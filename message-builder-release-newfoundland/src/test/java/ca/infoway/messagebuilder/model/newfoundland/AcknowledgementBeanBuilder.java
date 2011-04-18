package ca.infoway.messagebuilder.model.newfoundland;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementType;
import ca.infoway.messagebuilder.model.newfoundland.AcknowledgementBean;


public class AcknowledgementBeanBuilder extends BaseBeanBuilder<AcknowledgementBean> {

	public AcknowledgementBeanBuilder() {
		super(new AcknowledgementBean());
	}

	public AcknowledgementBeanBuilder populate() {
		bean.setAcknowledgementType(AcknowledgementType.APPLICATION_ACKNOWLEDGEMENT_ACCEPT);
		bean.setTargetMessage(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad11"));		
		return this;
	}
	
}
