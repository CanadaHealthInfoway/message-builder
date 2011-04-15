package ca.infoway.messagebuilder.model.cerx.deviceprescription;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.cerx.DeviceRequestBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DeviceRequestBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.ActivateDevicePrescriptionRequestMessageBean;

public class ActivateDevicePrescriptionRequestMessageBeanBuilder extends BaseBeanBuilder<ActivateDevicePrescriptionRequestMessageBean> {

	public ActivateDevicePrescriptionRequestMessageBeanBuilder() {
		super(new ActivateDevicePrescriptionRequestMessageBean());
	}

	public ActivateDevicePrescriptionRequestMessageBeanBuilder populate() {
		this.bean.getControlActEvent().setCode(HL7TriggerEventCode.ACTIVATE_DEVICE_PRESCRIPTION_REQUEST);
		MessageBeanBuilderSupport.populateStandardValuesV02(this.bean.getMessageAttributes());
		this.bean.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(this.bean.getControlActEvent());
		
		RecordBean<DeviceRequestBean> recordBean = new RecordBean<DeviceRequestBean>();
		recordBean.setRecord(new DeviceRequestBeanBuilder().populate().create());
		this.bean.getControlActEvent().setRecordBean(recordBean);
		
		return this;
	}
}
