package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

/**
 * @sharpen.ignore
 */
@Hl7PartTypeMapping("MOCK_MT898989CA")
public class MockMultiplyCompoundMappedMessagePartBean {

	private static final long serialVersionUID = -8148180862570811368L;
	
	private MockSubType type = new MockSubType();
	private MockSubType2 type2 = new MockSubType2();

	@Hl7XmlMapping("theType/theSubType/theSubSubType")
	@Hl7MapByPartTypes({@Hl7MapByPartType(name="theType",type="MOCK_MT123458CA.SubTypeA"),
						@Hl7MapByPartType(name="theType/theSubType",type="MOCK_MT123457CA.SubTypeB"),
						@Hl7MapByPartType(name="theType/theSubType/theSubSubType",type="MOCK_MT123456CA.SubType")})
	public MockSubType getType() {
		return type;
	}

	public void setType(MockSubType type) {
		this.type = type;
	}

	@Hl7XmlMapping("theType/theSubType/theSubSubType")
	@Hl7MapByPartTypes({@Hl7MapByPartType(name="theType",type="MOCK_MT123458CA.SubTypeA"),
						@Hl7MapByPartType(name="theType/theSubType",type="MOCK_MT123457CA.SubTypeB"),
						@Hl7MapByPartType(name="theType/theSubType/theSubSubType",type="MOCK_MT898989CA.SubType")})
	public MockSubType2 getType2() {
		return this.type2;
	}

	public void setType2(MockSubType2 type2) {
		this.type2 = type2;
	}
}
