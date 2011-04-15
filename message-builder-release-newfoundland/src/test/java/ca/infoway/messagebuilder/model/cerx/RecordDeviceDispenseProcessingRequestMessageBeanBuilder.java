package ca.infoway.messagebuilder.model.cerx;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.payload.Confidentiality;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.NoteBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DispenseRequest2Bean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.dispense.RecordDeviceDispenseProcessingRequestMessageBean;

public class RecordDeviceDispenseProcessingRequestMessageBeanBuilder extends BaseBeanBuilder<RecordDeviceDispenseProcessingRequestMessageBean> {

	public RecordDeviceDispenseProcessingRequestMessageBeanBuilder() {
		super(new RecordDeviceDispenseProcessingRequestMessageBean());
	}

	public RecordDeviceDispenseProcessingRequestMessageBeanBuilder populate() {
		this.bean.getControlActEvent().setCode(HL7TriggerEventCode.RECORD_DEVICE_DISP_PROCESSING_REQUEST);
		MessageBeanBuilderSupport.populateStandardValuesV02(this.bean.getMessageAttributes());
		this.bean.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad55"));
		MessageBeanBuilderSupport.populateStandardValues(this.bean.getControlActEvent());
		
		DispenseRequest2Bean dispenseRequestBean = new DispenseRequest2Bean();
		RecordBean<DispenseRequest2Bean> recordBean = new RecordBean<DispenseRequest2Bean>();
		recordBean.setRecord(dispenseRequestBean);
		this.bean.getControlActEvent().setRecordBean(recordBean);
		
		dispenseRequestBean.setIdAssignedByPharmacy(new Identifier("2.16.124.113618.1.1227543788373.2148.1233933814438.2148", "16373838"));
		dispenseRequestBean.getConfidentialityCode().add(Confidentiality.NORMAL);
		IdentifiedPersonBean personBean = new IdentifiedPersonBeanBuilder().populate().create();
		personBean.setId(new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"));
		personBean.getIndeterminatePerson().setBirthTime(DateUtil.getDate(1987, 0, 1));
		dispenseRequestBean.setPatient(personBean);
		dispenseRequestBean.setUsageInstructions("use as directed");
		dispenseRequestBean.setSupplyEvent(new SupplyEventBeanBuilder().populateDevice().create());
		dispenseRequestBean.setNote(new NoteBeanBuilder().populate().create());
		dispenseRequestBean.setSimpleDeviceRequestBean(new SimpleDeviceRequestBeanBuilder().populate().create());
		
		return this;
	}
	
	public RecordDeviceDispenseProcessingRequestMessageBeanBuilder withTxNumber(Identifier txNumber) {
		this.bean.getRecord().setIdAssignedByPharmacy(txNumber);
		return this;
	}

}
