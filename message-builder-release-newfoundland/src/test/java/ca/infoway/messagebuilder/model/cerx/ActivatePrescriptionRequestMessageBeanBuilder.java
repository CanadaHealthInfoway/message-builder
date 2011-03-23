package ca.infoway.messagebuilder.model.cerx;

import static ca.infoway.messagebuilder.model.cerx.medicalprofile.CombinedMedicationBeanBuilder.CombinedMedicationBeanType.PORX_MT010120CA;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.RecordBean;
import ca.infoway.messagebuilder.model.cerx.medicalprofile.CombinedMedicationBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.medicationprofile.CombinedMedication1Bean;
import ca.infoway.messagebuilder.model.cerx.prescription.ActivatePrescriptionRequestMessageBean;

public class ActivatePrescriptionRequestMessageBeanBuilder extends BaseBeanBuilder<ActivatePrescriptionRequestMessageBean> {

	public ActivatePrescriptionRequestMessageBeanBuilder() {
		super(new ActivatePrescriptionRequestMessageBean());
	}

	public ActivatePrescriptionRequestMessageBeanBuilder populate() {
		this.bean.getControlActEvent().setCode(HL7TriggerEventCode.ACTIVATE_PRESCRIPTION_REQUEST);
		MessageBeanBuilderSupport.populateStandardValuesV02(this.bean.getMessageAttributes());
		this.bean.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(this.bean.getControlActEvent());
		
		RecordBean<CombinedMedication1Bean> recordBean = new RecordBean<CombinedMedication1Bean>();
		recordBean.setRecord((CombinedMedication1Bean) new CombinedMedicationBeanBuilder(PORX_MT010120CA).populate().create());
		this.bean.getControlActEvent().setRecordBean(recordBean);
		
		return this;
	}
}
