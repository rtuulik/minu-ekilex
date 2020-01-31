package eki.wordweb.data;

import java.util.List;

import eki.common.constant.Complexity;
import eki.common.constant.DatasetType;
import eki.common.data.AbstractDataObject;

public class DataFilter extends AbstractDataObject {

	private static final long serialVersionUID = 1L;

	private DatasetType datasetType;

	private List<String> destinLangs;

	private Complexity lexComplexity;

	private Integer maxDisplayLevel;

	public DataFilter(DatasetType datasetType, List<String> destinLangs, Complexity lexComplexity, Integer maxDisplayLevel) {
		this.datasetType = datasetType;
		this.destinLangs = destinLangs;
		this.lexComplexity = lexComplexity;
		this.maxDisplayLevel = maxDisplayLevel;
	}

	public DatasetType getDatasetType() {
		return datasetType;
	}

	public List<String> getDestinLangs() {
		return destinLangs;
	}

	public Complexity getLexComplexity() {
		return lexComplexity;
	}

	public Integer getMaxDisplayLevel() {
		return maxDisplayLevel;
	}

}
