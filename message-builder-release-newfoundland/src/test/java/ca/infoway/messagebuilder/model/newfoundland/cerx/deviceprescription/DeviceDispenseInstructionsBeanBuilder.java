package ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.x_SubstitutionConditionNoneOrUnconditional;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DeviceDispenseInstructionsBean;

public class DeviceDispenseInstructionsBeanBuilder extends BaseBeanBuilder<DeviceDispenseInstructionsBean> {

	public DeviceDispenseInstructionsBeanBuilder() {
		super(new DeviceDispenseInstructionsBean());
	}

	public DeviceDispenseInstructionsBeanBuilder populate() {
		this.bean.setQuantity(new Integer(1)); 
		this.bean.setDispenseFacilityNotAssignableIndicator(
				lookup(x_SubstitutionConditionNoneOrUnconditional.class, "NOSUB", CodeSystem.VOCABULARY_SUBSTITUTION_CONDITION.getRoot()));
		this.bean.setServiceDeliveryLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		return this;
	}

}
