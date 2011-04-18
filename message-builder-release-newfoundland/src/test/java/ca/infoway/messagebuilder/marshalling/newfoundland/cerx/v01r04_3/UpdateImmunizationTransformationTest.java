package ca.infoway.messagebuilder.marshalling.newfoundland.cerx.v01r04_3;

import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.UPDATE_IMMUNIZATION_REQUEST;
import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.UPDATE_IMMUNIZATION_REQUEST_ACCEPTED;
import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.UPDATE_IMMUNIZATION_REQUEST_REFUSED;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.immunization.ImmunizationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.immunization.UpdateImmunizationAcceptedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.immunization.UpdateImmunizationMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.immunization.UpdateImmunizationRefusedMessageBean;

public class UpdateImmunizationTransformationTest extends BaseImmunizationTransformationTest {
	
	private static final String REQUEST_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/updateImmunizationRequest.xml";
	private static final String ACCEPTED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/updateImmunizationRequestAccepted.xml";
	private static final String REFUSED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/updateImmunizationRequestRefused.xml";
	
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
		return new UpdateImmunizationAcceptedMessageBean();
	}
	@Override
	protected RecordResponseMessageBean<ActEventBean> createRefusedBean() {
		return new UpdateImmunizationRefusedMessageBean();		
	}
	@Override
	protected RecordRequestMessageBean<ImmunizationBean> createRequestBean() {
		return new UpdateImmunizationMessageBean();
	}
	@Override
	protected HL7TriggerEventCode getAcceptedHL7TriggerEventCode() {
		return UPDATE_IMMUNIZATION_REQUEST_ACCEPTED;
	}
	@Override
	protected HL7TriggerEventCode getRefusedHL7TriggerEventCode() {
		return UPDATE_IMMUNIZATION_REQUEST_REFUSED;	
	}
	@Override
	protected HL7TriggerEventCode getRequestHL7TriggerEventCode() {
		return UPDATE_IMMUNIZATION_REQUEST;
	}
}
