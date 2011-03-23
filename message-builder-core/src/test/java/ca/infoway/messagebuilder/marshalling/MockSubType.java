package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

@Hl7PartTypeMapping("MOCK_MT123456CA.SubType")
public class MockSubType {

	private String name;

	@Hl7XmlMapping("component/subject3/name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
