package eki.ekilex.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.postgresql.jdbc.PgArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import eki.common.constant.GlobalConstant;
import eki.common.data.PgVarcharArray;
import eki.common.service.db.BasicDbService;
import eki.ekilex.data.imp.Form;
import eki.ekilex.data.imp.Paradigm;
import eki.ekilex.data.imp.ParadigmWrapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestPropertySource(locations = "classpath:test-ekilex-app.properties")
@Transactional
public class ArbitraryTest implements GlobalConstant {

	private static final String DUMMY_TABLE = "dummy_table";

	@Autowired
	private BasicDbService basicDbService;

	@Before
	public void beforeTest() throws Exception {

		String createDummyTableSql = "create table " + DUMMY_TABLE + " ("
				+ "id bigserial primary key, "
				+ "value_array text array null"
				+ ");";
		basicDbService.executeScript(createDummyTableSql);
	}

	//tests customised data masking at PgVarcharArray
	@Test
	public void testTextArrayWriteRead() throws Exception {

		File txtFile = new File("./fileresources/txt/file.txt");
		FileInputStream txtFileStream = new FileInputStream(txtFile);
		List<String> originalValueLines = IOUtils.readLines(txtFileStream, UTF_8);
		txtFileStream.close();
		int originalLineCount = originalValueLines.size();

		String[] valueLinesArr = originalValueLines.toArray(new String[0]);
		Map<String, Object> tableRowParamMap;
		tableRowParamMap = new HashMap<>();
		tableRowParamMap.put("value_array", new PgVarcharArray(valueLinesArr));
		Long id = basicDbService.create(DUMMY_TABLE, tableRowParamMap);

		tableRowParamMap = new HashMap<>();
		tableRowParamMap.put("id", id);
		Map<String, Object> result = basicDbService.select(DUMMY_TABLE, tableRowParamMap);
		PgArray valueArrayField = (PgArray) result.get("value_array");
		String[] valueArray = (String[]) valueArrayField.getArray();
		List<String> resultValueLines = new ArrayList<>(Arrays.asList(valueArray));
		int resultLineCount = resultValueLines.size();

		assertEquals("Unmatching array counts", originalLineCount, resultLineCount);
		assertEquals("Unmatching array values", originalValueLines, resultValueLines);
	}

	@Test
	public void testMorphImport() throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();
		File jsonFile = new File("./fileresources/txt/paradigm.json");
		FileInputStream jsonFileStream = new FileInputStream(jsonFile);
		ParadigmWrapper paradigmWrapper = objectMapper.readValue(jsonFileStream, ParadigmWrapper.class);
		jsonFileStream.close();

		List<Paradigm> paradigms = paradigmWrapper.getParadigms();
		Paradigm firstParadigm = paradigms.get(0);
		List<Form> forms = firstParadigm.getForms();

		assertEquals("Incorrect data count", 36, forms.size());

	}
}
