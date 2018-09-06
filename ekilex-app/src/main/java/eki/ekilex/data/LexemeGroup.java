package eki.ekilex.data;

import eki.common.data.AbstractDataObject;

import java.util.List;

public class LexemeGroup extends AbstractDataObject {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String groupTypeLabel;

	private List<Relation> members;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupTypeLabel() {
		return groupTypeLabel;
	}

	public void setGroupTypeLabel(String groupTypeLabel) {
		this.groupTypeLabel = groupTypeLabel;
	}

	public List<Relation> getMembers() {
		return members;
	}

	public void setMembers(List<Relation> members) {
		this.members = members;
	}

}
