package ca.infoway.messagebuilder.model.cerx;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.NoteBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.deviceprescription.ClinicalDeviceBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.deviceprescription.DeviceDispenseInstructionsBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.deviceprescription.ReasonBeanBuilder;

public class DeviceRequestBeanBuilder extends BaseBeanBuilder<DeviceRequestBean> {
	
	public DeviceRequestBeanBuilder() {
		super(new DeviceRequestBean());
	}

	public DeviceRequestBeanBuilder populate() {
		this.bean.getConfidentialityCode().add(lookup(x_VeryBasicConfidentialityKind.class, "N", CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot()));
		this.bean.setDirectTarget(new ClinicalDeviceBeanBuilder().populate().create());
		this.bean.setId(new Identifier("1.2.3", "extension-1"));
		this.bean.setNote(new NoteBeanBuilder().populate().create());
		this.bean.setPatient(new IdentifiedPersonBeanBuilder().populate().create());		
		this.bean.setPredecessorId(new Identifier("predecessor-root", "ext"));
		this.bean.setSupplyRequest(new DeviceDispenseInstructionsBeanBuilder().populate().create());
		this.bean.setStatusCode(lookup(ActStatus.class, "normal", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		this.bean.getReasons().add(new ReasonBeanBuilder().populate().create());
		this.bean.setUsageInstructions("usage instructions");
		return this;
	}

}
