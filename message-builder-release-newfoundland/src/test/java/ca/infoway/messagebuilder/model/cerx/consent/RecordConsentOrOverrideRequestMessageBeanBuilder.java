package ca.infoway.messagebuilder.model.cerx.consent;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;

import java.util.Date;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.domainvalue.ActConsentType;
import ca.infoway.messagebuilder.domainvalue.x_PhysicalVerbalParticipationMode;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.RecordBean;
import ca.infoway.messagebuilder.model.ResponsiblePartyBeanBuilder;

public class RecordConsentOrOverrideRequestMessageBeanBuilder extends BaseBeanBuilder<RecordConsentOrOverrideRequestMessageBean> {
	
	public RecordConsentOrOverrideRequestMessageBeanBuilder() {
		super(new RecordConsentOrOverrideRequestMessageBean());
	}

	public RecordConsentOrOverrideRequestMessageBeanBuilder populate() {
		this.bean.getControlActEvent().setCode(HL7TriggerEventCode.RECORD_CONSENT_OR_OVERRIDE_REQUEST);
		MessageBeanBuilderSupport.populateStandardValuesV02(this.bean.getMessageAttributes());
		MessageBeanBuilderSupport.populateStandardValues(this.bean.getControlActEvent());
		
		RecordBean<ConsentBean> recordBean = new RecordBean<ConsentBean>();
		ConsentBean record = new ConsentBean();
		record.setId(new Identifier("consentRoot", "consentExtension"));
		record.setCode(lookup(ActConsentType.class, "INFA", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		record.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
		record.setConsenter(new ResponsiblePartyBeanBuilder().populate().create());
		record.setModeCode(lookup(x_PhysicalVerbalParticipationMode.class, "PHYSICAL", CodeSystem.VOCABULARY_PROCESSING_MODE.getRoot()));
		record.setEffectiveTime(IntervalFactory.createLowHigh(new Date(600000000), new Date(700000000)));
		record.setNegationInd(Boolean.TRUE);
//		record.setProvider(new AssignedPersonBeanBuilder().populate().create());
//		record.setReasonCode(lookup(ActConsentInformationAccessReason.class, "EMERG", CodeSystem.VOCABULARY_ACT_REASON.getRoot()));
		record.setInformationAccess(new InformationAccessBeanBuilder().populate().create());
		recordBean.setRecord(record);
		this.bean.getControlActEvent().setRecordBean(recordBean);
		
		return this;
	}

}
