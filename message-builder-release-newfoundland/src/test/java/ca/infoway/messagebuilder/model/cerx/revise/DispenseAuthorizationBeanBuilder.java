package ca.infoway.messagebuilder.model.cerx.revise;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.SupplyRequestBeanBuilder;

public class DispenseAuthorizationBeanBuilder extends BaseBeanBuilder<DispenseAuthorizationBean> {
	
	public DispenseAuthorizationBeanBuilder() {
		super(new DispenseAuthorizationBean());
	}

	public DispenseAuthorizationBeanBuilder populate() {
		this.bean.setLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		this.bean.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
		this.bean.setPrescriptionIdentifier(new Identifier("prescriptionRoot", "prescriptionExtension"));
		this.bean.getSupplyEvents().add(new SupplyRequestBeanBuilder().populate().create());
		return this;
	}

}
