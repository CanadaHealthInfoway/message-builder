package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.math.BigDecimal;

import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.MedicationDispenseInstructionsBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class MedicationDispenseInstructionsBeanBuilder extends
		BaseBeanBuilder<MedicationDispenseInstructionsBean> {
	
	public MedicationDispenseInstructionsBeanBuilder() {
		super(new MedicationDispenseInstructionsBean());
	}

	public MedicationDispenseInstructionsBeanBuilder populate() {
		this.bean.setActStatus(CodeResolverRegistry.lookup(ActStatus.class, "active"));
		this.bean.setQuantity(new PhysicalQuantity(BigDecimal.ONE, CodeResolverRegistry.lookup(UnitsOfMeasureCaseSensitive.class, "mg")));
		this.bean.setServiceDeliveryLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		return this;
	}
	

}
