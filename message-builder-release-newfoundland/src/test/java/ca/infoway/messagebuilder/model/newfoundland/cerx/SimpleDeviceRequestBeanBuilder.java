package ca.infoway.messagebuilder.model.newfoundland.cerx;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.SimpleDeviceRequestBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.DeviceDispenseInstructionsBeanBuilder;

public class SimpleDeviceRequestBeanBuilder extends BaseBeanBuilder<SimpleDeviceRequestBean> {
	
	public SimpleDeviceRequestBeanBuilder() {
		super(new SimpleDeviceRequestBean());
	}

	public SimpleDeviceRequestBeanBuilder populate() {
		this.bean.setId(new Identifier("2.16.124.113620.1.1.8", "4814"));
		
		this.bean.setSupplyRequest(new DeviceDispenseInstructionsBeanBuilder().populate().create());
		this.bean.setAuthor(new AuthorBeanBuilder().populate().create());
		this.bean.setResponsibleParty(new AssignedPersonBeanBuilder().populate().create());
		return this;
	}

}
