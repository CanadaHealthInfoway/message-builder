package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.model.cerx.dispense.RecordDispenseProcessingRequestMessageBean;
import ca.infoway.messagebuilder.model.common.GenericResponseMessageBean;
import ca.infoway.messagebuilder.model.cr.FindCandidatesCriteria;
import ca.infoway.messagebuilder.model.cr.FindCandidatesQueryMessageBean;
import ca.infoway.messagebuilder.model.mock.AcknowledgementBean;
import ca.infoway.messagebuilder.model.mock.AcknowledgementDetailBean;
import ca.infoway.messagebuilder.model.mock.AssignedDeviceBean;
import ca.infoway.messagebuilder.model.mock.AssignedPersonBean;
import ca.infoway.messagebuilder.model.mock.AuthorBean;
import ca.infoway.messagebuilder.model.mock.InFulfillmentOfBean;
import ca.infoway.messagebuilder.model.mock.QuantityObservationEventBean;
import ca.infoway.messagebuilder.model.mock.QueryByParameterBean;
import ca.infoway.messagebuilder.model.mock.QueryControlActEventBean;
import ca.infoway.messagebuilder.model.mock.Receiver;
import ca.infoway.messagebuilder.model.mock.RegistrationControlActEventBean;
import ca.infoway.messagebuilder.model.mock.RegistrationRequestBean;
import ca.infoway.messagebuilder.model.mock.Sender;
import ca.infoway.messagebuilder.model.mock.ServiceDeliveryLocationBean;
import ca.infoway.messagebuilder.model.pr.PasswordChangeBean;
import ca.infoway.messagebuilder.model.pr.UpdatePasswordRequestMessageBean;

/**
 * <p>This class registers beans for test purposes.
 * 
 *  @sharpen.ignore enhance sharpen to translate this class correctly. 
 *  
 *  MessageBeanRegistry.getInstance().registerClass(RegistrationRequestBean.class, MockVersionNumber.MOCK);
 *  
 *  should look like this:
 *  
 *  MessageBeanRegistry.GetInstance().RegisterClass(typeof(RegistrationRequestBean<>), MockVersionNumber.MOCK);
 *   
 */
public class MockMessageBeanRegistry {
	
	private static boolean initialized = false;
	
	public static void initialize() {
		if (!initialized) {
			MessageBeanRegistry.getInstance().registerClass(MockMessageBean.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(MockSubType.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(FindCandidatesQueryMessageBean.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(FindCandidatesCriteria.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(GenericResponseMessageBean.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(UpdatePasswordRequestMessageBean.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(PasswordChangeBean.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(AcknowledgementBean.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(AcknowledgementDetailBean.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(AssignedDeviceBean.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(AssignedPersonBean.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(AuthorBean.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(RegistrationRequestBean.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(RegistrationControlActEventBean.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(QueryControlActEventBean.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(RecordDispenseProcessingRequestMessageBean.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(Sender.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(ServiceDeliveryLocationBean.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(Receiver.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(QueryByParameterBean.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			
			MessageBeanRegistry.getInstance().registerClass(BeanA.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(BeanB.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			MessageBeanRegistry.getInstance().registerClass(SimpleInteraction.class, MockVersionNumber.MOCK_NEWFOUNDLAND);
			
			MessageBeanRegistry.getInstance().registerClass(QuantityObservationEventBean.class, MockVersionNumber.MOCK_NEWFOUNDLAND);

			MessageBeanRegistry.getInstance().registerClass(InFulfillmentOfBean.class, MockVersionNumber.MOCK_MR2009);
			
			initialized = true;
		} 
	}
}
