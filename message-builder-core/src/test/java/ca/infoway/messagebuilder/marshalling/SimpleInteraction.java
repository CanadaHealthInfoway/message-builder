package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.InteractionBean;

@Hl7PartTypeMapping("ABCD_IN123456CA.SimpleInteraction")
public class SimpleInteraction implements InteractionBean {
	private BeanB bean;
	@Hl7XmlMapping("bean")
	public BeanB getBean() {
		return this.bean;
	}
	public void setBean(BeanB bean) {
		this.bean = bean;
	}
}