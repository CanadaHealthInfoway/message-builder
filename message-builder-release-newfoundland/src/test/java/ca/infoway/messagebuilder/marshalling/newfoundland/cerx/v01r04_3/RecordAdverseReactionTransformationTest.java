package ca.infoway.messagebuilder.marshalling.newfoundland.cerx.v01r04_3;


import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.adversereaction.AdverseReactionBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.adversereaction.RecordAdverseReactionAcceptedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.adversereaction.RecordAdverseReactionMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.adversereaction.RecordAdverseReactionRefusedMessageBean;

public class RecordAdverseReactionTransformationTest extends BaseAdverseReactionTransformationTest {
	
	private static final String REQUEST_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordAdverseReactionRequest.xml";
	private static final String ACCEPTED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordAdverseReactionRequestAccepted.xml";
	private static final String REFUSED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordAdverseReactionRequestRefused.xml";
	
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
		return new RecordAdverseReactionAcceptedMessageBean();
	}
	@Override
	protected RecordResponseMessageBean<ActEventBean> createRefusedBean() {
		return new RecordAdverseReactionRefusedMessageBean();
	}
	@Override
	protected RecordRequestMessageBean<AdverseReactionBean> createRequestBean() {
		return new RecordAdverseReactionMessageBean();
	}
	@Override
	protected HL7TriggerEventCode getAcceptedHL7TriggerEventCode() {
		return HL7TriggerEventCode.RECORD_ADVERSE_REACTION_REQUEST_ACCEPTED;
	}
	@Override
	protected HL7TriggerEventCode getRefusedHL7TriggerEventCode() {
		return HL7TriggerEventCode.RECORD_ADVERSE_REACTION_REQUEST_REFUSED;	
	}
	@Override
	protected HL7TriggerEventCode getRequestHL7TriggerEventCode() {
		return HL7TriggerEventCode.RECORD_ADVERSE_REACTION_REQUEST;
	}
}