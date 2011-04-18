package ca.infoway.messagebuilder.model.newfoundland.cerx;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;

import java.util.Date;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPartType;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressUse;
import ca.infoway.messagebuilder.domainvalue.x_SubstitutionConditionNoneOrUnconditional;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ResponsiblePartyBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DispenseInstructionsBean;

public class DispenseInstructionsBeanBuilder extends
		BaseBeanBuilder<DispenseInstructionsBean> {
	
	public DispenseInstructionsBeanBuilder() {
		super(new DispenseInstructionsBean());
	}

	public BaseBeanBuilder<DispenseInstructionsBean> populate() {
		PostalAddress address = new PostalAddress();
		address.addUse(PostalAddressUse.HOME);
		address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STREET_NAME, "Bloor"));
		this.bean.setDestination(address);
		this.bean.setEffectiveTime(IntervalFactory.createLow(new Date(0)));
		this.bean.getResponsibleParties().add(new ResponsiblePartyBeanBuilder().populate().create());
		this.bean.setServiceDeliveryLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		this.bean.setSubstitutionConditionCode(lookup(x_SubstitutionConditionNoneOrUnconditional.class, "NOSUB", CodeSystem.VOCABULARY_SUBSTITUTION_CONDITION.getRoot()));
		this.bean.getSupplyRequestItems().add(new SupplyRequestBeanBuilder().populate().create());
		this.bean.setToBePickedUpOn(IntervalFactory.createLow(new Date(0)));
		return this;
	}
	

}
