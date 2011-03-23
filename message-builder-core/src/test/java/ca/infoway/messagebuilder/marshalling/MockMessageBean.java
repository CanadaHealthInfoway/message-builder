package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.InteractionBean;

@Hl7PartTypeMapping("MOCK_IN123456CA")
public class MockMessageBean implements InteractionBean {

	private static final long serialVersionUID = -8148180862570811368L;
	
	private MockSubType type = new MockSubType();

	@Hl7XmlMapping("theType")
	public MockSubType getType() {
		return type;
	}

	public void setType(MockSubType type) {
		this.type = type;
	}
	
	

}
