package eki.ekilex.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import eki.common.constant.AuthorityItem;
import eki.common.constant.AuthorityOperation;
import eki.ekilex.constant.WebConstant;
import eki.ekilex.data.Classifier;
import eki.ekilex.data.Dataset;
import eki.ekilex.data.DatasetPermission;
import eki.ekilex.data.EkiUser;
import eki.ekilex.data.editor.ClassifierEditor;
import eki.ekilex.service.CommonDataService;
import eki.ekilex.service.DatasetService;
import eki.ekilex.service.PermissionService;
import eki.ekilex.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ConditionalOnWebApplication
@Controller
@SessionAttributes(WebConstant.SESSION_BEAN)
public class DatasetController implements WebConstant {

	private static final Logger logger = LoggerFactory.getLogger(DatasetController.class);

	@Autowired
	private DatasetService datasetService;

	@Autowired
	private UserService userService;

	@Autowired
	private PermissionService permissionService;

	@Autowired
	private CommonDataService commonDataService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Classifier.class, new ClassifierEditor());
	}

	@GetMapping(DICTIONARIES_URI)
	public String list(Model model) {

		logger.debug("Fetching all datasets");
		List<Dataset> datasets = datasetService.getDatasets();

		EkiUser currentUser = userService.getAuthenticatedUser();
		List<DatasetPermission> datasetPermissions = permissionService.getUserDatasetPermissions(currentUser.getId());

		List<String> ownedDataSetCodes = datasetPermissions
				.stream()
				.filter(permission -> AuthorityOperation.OWN.equals(permission.getAuthOperation()))
				.map(DatasetPermission::getDatasetCode)
				.collect(Collectors.toList());

		model.addAttribute("ownedDatasetCodes", ownedDataSetCodes);
		model.addAttribute("datasets", datasets);
		model.addAttribute("datasetData", new Dataset());


		return DATASETS_PAGE;
	}

	@PreAuthorize("authentication.principal.datasetPermissionsExist")
	@PostMapping(CREATE_DICTIONARY_URI)
	public String createDataset(@Valid @ModelAttribute("datasetData") Dataset datasetFormData) {
		logger.debug("Creating dataset, name : {}", datasetFormData.getName());
		datasetService.createDataset(datasetFormData);

		EkiUser currentUser = userService.getAuthenticatedUser();
		permissionService
				.createDatasetPermission(currentUser.getId(), datasetFormData.getCode(), AuthorityItem.DATASET, AuthorityOperation.OWN, null);

		userService.updateUserSecurityContext();

		return REDIRECT_PREF + DICTIONARIES_URI;
	}

	@PreAuthorize("authentication.principal.datasetPermissionsExist")
	@PostMapping(UPDATE_DICTIONARY_URI)
	public String updateDataSet(@Valid @ModelAttribute("datasetData") Dataset datasetFormData) {
		logger.debug("Updating dataset, name : {}", datasetFormData.getName());
		datasetService.updateDataset(datasetFormData);
		userService.updateAuthenticatedUserDatasetPermissions();

		return REDIRECT_PREF + DICTIONARIES_URI;
	}

	@PreAuthorize("authentication.principal.datasetPermissionsExist")
	@GetMapping(DELETE_DICTIONARY_URI + "/{datasetCode}")
	@ResponseBody
	public String deleteDataset(@PathVariable("datasetCode") String datasetCode) throws JsonProcessingException {

		logger.debug("Deleting dataset, code: {}", datasetCode);

		datasetService.deleteDataset(datasetCode);
		userService.updateUserSecurityContext();

		return "OK";
	}

	@GetMapping(REST_SERVICES_URI + VALIDATE_CREATE_DICTIONARY_URI + "/{datasetCode}")
	@ResponseBody
	public String validateCreateDataset(@PathVariable("datasetCode") String datasetCode) {
		if (datasetService.datasetCodeExists(datasetCode)) {
			logger.debug("Trying to create dataset with existing code '{}'.", datasetCode);
			return "CODE_EXISTS";
		}
		return "OK";
	}

	@ModelAttribute("languages")
	public List<Classifier> getLanguages() {
		return commonDataService.getLanguages();
	}

	@ModelAttribute("processStates")
	public List<Classifier> getProcessStates() {
		return commonDataService.getProcessStates();
	}


	@PostMapping(REST_SERVICES_URI + SEARCH_DOMAINS_URI)
	@ResponseBody
	public String searchDomain(@RequestParam String searchText) throws Exception {

		List<Classifier> result = commonDataService.findDomainsByValue(searchText);

		ObjectMapper jsonMapper = new ObjectMapper();
		return jsonMapper.writeValueAsString(result);

	}
}
