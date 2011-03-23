package ca.infoway.messagebuilder.example;

import static ca.infoway.messagebuilder.datatype.lang.PersonName.createFirstNameLastName;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.devtools.DefaultValueHolder;
import ca.infoway.messagebuilder.devtools.MessageBeanFactory;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mfmi_mt700751ca.QueryByParameterBean;
import ca.infoway.messagebuilder.model.common.mfmi_mt700751ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.cr.prpa_mt101103ca.ParameterListBean;
import ca.infoway.messagebuilder.model.interaction.FindCandidatesQueryBean;
import ca.infoway.messagebuilder.model.merged.AssignedEntity_1Bean;
import ca.infoway.messagebuilder.model.merged.Author_2Bean;
import ca.infoway.messagebuilder.model.merged.ServiceDeliveryLocation_1Bean;

/**
 * <p>This class shows how to create a simple FindCandidates HL7 query bean.
 * 
 */
public class FindCandidatesExampleCreator {

	private MessageBeanFactory messageBeanFactory = new MessageBeanFactory(new DefaultValueHolder());
	
	protected FindCandidatesQueryBean createFindCandidatesQuery() {

		// construct message bean
		FindCandidatesQueryBean messageBean = new FindCandidatesQueryBean();

		// populate values standard for all messages
		populateMessageAttributesStandardValues(messageBean);
		
		// standard control act initialization for this specific message 
		initializeQueryControlAct(messageBean);
		
		// populate control act fields for this message instance
		// (this could be standardized across all instances of this message, or even across all messages)  
		populateQueryControlActStandardValues(messageBean.getControlActEvent());
		
		// set specific payload values for this message instance
		populatePayload(messageBean);
		
		return messageBean;
	}

	private void populateMessageAttributesStandardValues(InteractionBean messageBean) {
		this.messageBeanFactory.populate(messageBean);
	}

	private void initializeQueryControlAct(FindCandidatesQueryBean messageBean) {
		messageBean.setControlActEvent(new TriggerEventBean<ParameterListBean>());
		messageBean.getControlActEvent().setQueryByParameter(new QueryByParameterBean<ParameterListBean>());
		messageBean.getControlActEvent().getQueryByParameter().setParameterList(new ParameterListBean());
		messageBean.getControlActEvent().setEventType(HL7TriggerEventCode.FIND_CANDIDATES_QUERY);
	}
	
	private void populateQueryControlActStandardValues(TriggerEventBean<ParameterListBean> triggerEventBean) {
		triggerEventBean.setEventIdentifier(new Identifier("2.16.840.1.113883.1.6", "8141234"));
		triggerEventBean.setEventEffectivePeriod(IntervalFactory.<Date>createLow(new Date()));
		triggerEventBean.setAuthor(createAuthorBean());
		triggerEventBean.setLocationServiceDeliveryLocation(createServiceDeliveryLocationBean());
		triggerEventBean.getQueryByParameter().setQueryIdentifier(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
	}
	
	private ServiceDeliveryLocation_1Bean createServiceDeliveryLocationBean() {
		ServiceDeliveryLocation_1Bean result = new ServiceDeliveryLocation_1Bean();
		result.setLocationIdReference(new Identifier("2.16.124.113620.1.1.11111", "1"));
		result.setServiceLocationName("Intelliware's Pharmacy");
		return result;
	}

	private Author_2Bean createAuthorBean() {
		Author_2Bean authorBean = new Author_2Bean();
		AssignedEntity_1Bean person = new AssignedEntity_1Bean();
		authorBean.setAuthorPerson(person);
		person.getHealthcareWorkerIdentifier().add(new Identifier("1.1.1", "1"));
		authorBean.setTimeOfCreation(new Date());
		person.setHealthcareWorkerName(createFirstNameLastName("John", "Doe"));
		return authorBean;
	}
	
	private void populatePayload(FindCandidatesQueryBean messageBean) {
		
		ParameterListBean parameterList = messageBean.getControlActEvent().getQueryByParameter().getParameterList();
		
		parameterList.getClientName().add(createFirstNameLastName("Rober", "Smith"));
		parameterList.setPrincipalPersonGender(AdministrativeGender.MALE);
		parameterList.setClientDateOfBirth(DateUtil.getDate(1974, 7, 20));
		
	}

}