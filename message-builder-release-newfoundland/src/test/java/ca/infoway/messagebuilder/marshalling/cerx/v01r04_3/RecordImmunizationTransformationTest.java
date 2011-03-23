package ca.infoway.messagebuilder.marshalling.cerx.v01r04_3;


import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.ActEventBean;
import ca.infoway.messagebuilder.model.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.cerx.immunization.ImmunizationBean;
import ca.infoway.messagebuilder.model.cerx.immunization.RecordImmunizationAcceptedMessageBean;
import ca.infoway.messagebuilder.model.cerx.immunization.RecordImmunizationMessageBean;
import ca.infoway.messagebuilder.model.cerx.immunization.RecordImmunizationRefusedMessageBean;

public class RecordImmunizationTransformationTest extends BaseImmunizationTransformationTest {
	
	private static final String REQUEST_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordImmunizationRequest.xml";
	private static final String ACCEPTED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordImmunizationRequestAccepted.xml";
	private static final String REFUSED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordImmunizationRequestRefused.xml";
	
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
		return new RecordImmunizationAcceptedMessageBean();
	}
	@Override
	protected NewBaseMessageBean createRefusedBean() {
		return new RecordImmunizationRefusedMessageBean();
	}
	@Override
	protected RecordRequestMessageBean<ImmunizationBean> createRequestBean() {
		return new RecordImmunizationMessageBean();
	}
	@Override
	protected HL7TriggerEventCode getAcceptedHL7TriggerEventCode() {
		return HL7TriggerEventCode.RECORD_IMMUNIZATION_REQUEST_ACCEPTED;
	}
	@Override
	protected HL7TriggerEventCode getRefusedHL7TriggerEventCode() {
		return HL7TriggerEventCode.RECORD_IMMUNIZATION_REQUEST_REFUSED;	
	}
	@Override
	protected HL7TriggerEventCode getRequestHL7TriggerEventCode() {
		return HL7TriggerEventCode.RECORD_IMMUNIZATION_REQUEST;
	}
}
