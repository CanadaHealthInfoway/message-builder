package ca.infoway.messagebuilder.marshalling.cerx.v01r04_3;

import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.UPDATE_ALLERGY_INTOLERANCE_REQUEST;
import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.UPDATE_ALLERGY_INTOLERANCE_REQUEST_ACCEPTED;
import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.UPDATE_ALLERGY_INTOLERANCE_REQUEST_REFUSED;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.ActEventBean;
import ca.infoway.messagebuilder.model.ActEventBeanBuilder;
import ca.infoway.messagebuilder.model.RecordBean;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.cerx.allergy.AllergyIntoleranceBean;
import ca.infoway.messagebuilder.model.cerx.allergy.UpdateAllergyIntoleranceAcceptedMessageBean;
import ca.infoway.messagebuilder.model.cerx.allergy.UpdateAllergyIntoleranceMessageBean;
import ca.infoway.messagebuilder.model.cerx.allergy.UpdateAllergyIntoleranceRefusedMessageBean;

public class UpdateAllergyIntoleranceTransformationTest extends BaseAllergyIntoleranceTransformationTest {
	
	private static final String REQUEST_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/updateAllergyIntoleranceRequest.xml";
	private static final String ACCEPTED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/updateAllergyIntoleranceRequestAccepted.xml";
	private static final String REFUSED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/updateAllergyIntoleranceRequestRefused.xml";
	
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
		return new UpdateAllergyIntoleranceAcceptedMessageBean();
	}
	@Override
	protected RecordResponseMessageBean<ActEventBean> createRefusedBean() {
		UpdateAllergyIntoleranceRefusedMessageBean refusedBean = new UpdateAllergyIntoleranceRefusedMessageBean();
		refusedBean.getControlActEvent().setRecordBean(new RecordBean<ActEventBean>());
		refusedBean.getControlActEvent().getRecordBean().setRecord(new ActEventBeanBuilder().populate().create());
		return refusedBean;
	}
	@Override
	protected RecordRequestMessageBean<AllergyIntoleranceBean> createRequestBean() {
		return new UpdateAllergyIntoleranceMessageBean();
	}
	@Override
	protected HL7TriggerEventCode getAcceptedHL7TriggerEventCode() {
		return UPDATE_ALLERGY_INTOLERANCE_REQUEST_ACCEPTED;
	}
	@Override
	protected HL7TriggerEventCode getRefusedHL7TriggerEventCode() {
		return UPDATE_ALLERGY_INTOLERANCE_REQUEST_REFUSED;	
	}
	@Override
	protected HL7TriggerEventCode getRequestHL7TriggerEventCode() {
		return UPDATE_ALLERGY_INTOLERANCE_REQUEST;
	}
}
