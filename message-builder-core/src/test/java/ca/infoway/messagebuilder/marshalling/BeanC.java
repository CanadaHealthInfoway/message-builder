package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

@Hl7PartTypeMapping("ABCD_IN123456CA.BeanC")
public class BeanC {

	private BeanB beanB;

	@Hl7XmlMapping("textHolder")
	public BeanB getBeanB() {
		return this.beanB;
	}

	public void setBeanB(BeanB beanB) {
		this.beanB = beanB;
	}
}
