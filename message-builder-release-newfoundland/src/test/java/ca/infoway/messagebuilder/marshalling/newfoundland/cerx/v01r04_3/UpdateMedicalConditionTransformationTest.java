package ca.infoway.messagebuilder.marshalling.newfoundland.cerx.v01r04_3;

import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.condition.MedicalConditionBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.condition.UpdateMedicalConditionAcceptedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.condition.UpdateMedicalConditionMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.condition.UpdateMedicalConditionRefusedMessageBean;

public class UpdateMedicalConditionTransformationTest extends BaseMedicalConditionTransformationTest {
	
	private static final String REQUEST_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/updateMedicalConditionRequest.xml";
	private static final String ACCEPTED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/updateMedicalConditionRequestAccepted.xml";
	private static final String REFUSED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/updateMedicalConditionRequestRefused.xml";
	
	@Override
	public String getAcceptedMessageFile() {
		return ACCEPTED_MESSAGE_FILE;
	}
	@Override
	public String getRefusedMessageFile() {
		return REFUSED_MESSAGE_FILE;
	}
	@Override
	public String getRequestMessageFile() {
		return REQUEST_MESSAGE_FILE;
	}
	@Override
	protected RecordResponseMessageBean<ActEventBean> createAcceptedBean() {
		return new UpdateMedicalConditionAcceptedMessageBean();
	}
	@Override
	protected RecordResponseMessageBean<ActEventBean> createRefusedBean() {
		UpdateMedicalConditionRefusedMessageBean refusedBean = new UpdateMedicalConditionRefusedMessageBean();
		refusedBean.getControlActEvent().setRecordBean(new RecordBean<ActEventBean>());
		refusedBean.getControlActEvent().getRecordBean().setRecord(new ActEventBeanBuilder().populate().create());
		return refusedBean;		
	}
	@Override
	protected RecordRequestMessageBean<MedicalConditionBean> createRequestBean() {
		return new UpdateMedicalConditionMessageBean();
	}
	@Override
	protected HL7TriggerEventCode getAcceptedHL7TriggerEventCode() {
		return HL7TriggerEventCode.UPDATE_MEDICAL_CONDITION_REQUEST_ACCEPTED;
	}
	@Override
	protected HL7TriggerEventCode getRefusedHL7TriggerEventCode() {
		return HL7TriggerEventCode.UPDATE_MEDICAL_CONDITION_REQUEST_REFUSED;	
	}
	@Override
	protected HL7TriggerEventCode getRequestHL7TriggerEventCode() {
		return HL7TriggerEventCode.UPDATE_MEDICAL_CONDITION_REQUEST;
	}
}