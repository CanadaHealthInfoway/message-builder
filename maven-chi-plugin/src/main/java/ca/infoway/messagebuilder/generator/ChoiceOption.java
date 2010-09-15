package ca.infoway.messagebuilder.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

class ChoiceOption {
	
	private String relationshipName;
	private String type;
	
	private List<ChoiceOption> options;
	
	@SuppressWarnings("unchecked")
	public ChoiceOption(String relationshipName, String type) {
		this(relationshipName, type, Collections.EMPTY_LIST);
	}
	public ChoiceOption(String relationshipName, String type, List<ChoiceOption> options) {
		this.relationshipName = relationshipName;
		this.type = type;
		this.options = Collections.unmodifiableList(new ArrayList<ChoiceOption>(options));
	}
	
	public String getRelationshipName() {
		return this.relationshipName;
	}
	public String getType() {
		return this.type;
	}
	public List<ChoiceOption> getOptions() {
		return this.options;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("relationshipName", this.relationshipName)
			.append("type", this.type)
			.toString();
	}
}
