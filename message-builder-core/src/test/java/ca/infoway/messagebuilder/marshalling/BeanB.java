package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

@Hl7PartTypeMapping("ABCD_IN123456CA.BeanB")
public class BeanB {
	private String text;
	@Hl7XmlMapping("text")
	public String getText() {
		return this.text;
	}
	public void setText(String text) {
		this.text = text;
	}
}