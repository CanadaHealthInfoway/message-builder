package ca.infoway.messagebuilder.model.cerx;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;

import java.math.BigDecimal;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActPharmacySupplyType;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.ResponsiblePartyBeanBuilder;
import ca.infoway.messagebuilder.model.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.deviceprescription.ClinicalDeviceBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.SupplyEventBean;

public class SupplyEventBeanBuilder extends BaseBeanBuilder<SupplyEventBean> {

	public SupplyEventBeanBuilder() {
		super(new SupplyEventBean());
	}

	public SupplyEventBeanBuilder populateMedication() {
		populate();
		this.bean.setQuantity(new PhysicalQuantity(BigDecimal.ONE, lookup(UnitsOfMeasureCaseSensitive.class, "mg")));
		this.bean.setMedication(new MedicineBeanBuilder().populate().create());
		
		return this;
	}

	public SupplyEventBeanBuilder populateDevice() {
		populate();
		this.bean.setQuantity(new PhysicalQuantity(BigDecimal.ONE, lookup(UnitsOfMeasureCaseSensitive.class, "Unit")));
		this.bean.setClinicalDevice(new ClinicalDeviceBeanBuilder().populate().create());
		
		return this;
	}

	private void populate() {
		this.bean.setDispenseId(new Identifier("dispenseIdRoot", "1"));
		this.bean.setCode(lookup(ActPharmacySupplyType.class, "DF", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		this.bean.setStatusCode(lookup(ActStatus.class, "active", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		this.bean.setEffectiveTime(IntervalFactory.createLowHigh(DateUtil.getDate(2009, 1, 1), DateUtil.getDate(2009, 12, 12)));
		this.bean.setExpectedUseTime(IntervalFactory.createHigh(DateUtil.getDate(2009, 12, 20)));
		this.bean.setDestination(new ServiceDeliveryLocationBeanBuilder().populate().create());
		this.bean.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
		this.bean.setResponsibleParty(new ResponsiblePartyBeanBuilder().populate().create());
		this.bean.setLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
	}
	

}
