package ca.infoway.messagebuilder.marshalling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

@Hl7PartTypeMapping("ABCD_IN123456CA.BeanBPrime")
public class BeanBPrime {
	private List<String> text = Collections.synchronizedList(new ArrayList<String>());

	@Hl7XmlMapping("text")
	public List<String> getText() {
		return this.text;
	}
}