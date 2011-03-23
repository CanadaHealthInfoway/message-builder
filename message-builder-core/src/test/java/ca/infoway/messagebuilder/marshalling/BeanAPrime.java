package ca.infoway.messagebuilder.marshalling;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

@Hl7PartTypeMapping("ABCD_IN123456CA.BeanAPrime")
public class BeanAPrime {
	private List<BeanB> issues = new ArrayList<BeanB>();
	@Hl7XmlMapping("subjectOf/component/issue")
	public List<BeanB> getIssues() {
		return this.issues;
	}
}