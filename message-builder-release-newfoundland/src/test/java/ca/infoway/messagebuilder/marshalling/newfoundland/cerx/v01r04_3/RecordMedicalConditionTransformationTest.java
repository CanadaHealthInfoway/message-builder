package ca.infoway.messagebuilder.marshalling.cerx.v01r04_3;


import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.condition.MedicalConditionBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.condition.RecordMedicalConditionAcceptedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.condition.RecordMedicalConditionMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.condition.RecordMedicalConditionRefusedMessageBean;

public class RecordMedicalConditionTransformationTest extends BaseMedicalConditionTransformationTest {
	
	private static final String REQUEST_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordMedicalConditionRequest.xml";
	private static final String ACCEPTED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordMedicalConditionRequestAccepted.xml";
	private static final String REFUSED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordMedicalConditionRequestRefused.xml";
	
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
		return new RecordMedicalConditionAcceptedMessageBean();
	}
	@Override
	protected RecordResponseMessageBean<ActEventBean> createRefusedBean() {
		return new RecordMedicalConditionRefusedMessageBean();
	}
	@Override
	protected RecordRequestMessageBean<MedicalConditionBean> createRequestBean() {
		return new RecordMedicalConditionMessageBean();
	}
	@Override
	protected HL7TriggerEventCode getAcceptedHL7TriggerEventCode() {
		return HL7TriggerEventCode.RECORD_MEDICAL_CONDITION_REQUEST_ACCEPTED;
	}
	@Override
	protected HL7TriggerEventCode getRefusedHL7TriggerEventCode() {
		return HL7TriggerEventCode.RECORD_MEDICAL_CONDITION_REQUEST_REFUSED;	
	}
	@Override
	protected HL7TriggerEventCode getRequestHL7TriggerEventCode() {
		return HL7TriggerEventCode.RECORD_MEDICAL_CONDITION_REQUEST;
	}
}
