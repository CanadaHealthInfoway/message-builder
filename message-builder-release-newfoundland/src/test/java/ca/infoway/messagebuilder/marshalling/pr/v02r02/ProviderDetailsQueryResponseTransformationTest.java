package ca.infoway.messagebuilder.marshalling.pr.v02r02;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.controlact.ActStatus;
import ca.infoway.messagebuilder.domainvalue.payload.QueryResponse;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementType;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.RegistrationEventRecordBean;
import ca.infoway.messagebuilder.model.pr.HealthcareProvider;
import ca.infoway.messagebuilder.model.pr.ProviderDetailsCriteria;
import ca.infoway.messagebuilder.model.pr.ProviderDetailsResponseMessageBean;
import ca.infoway.messagebuilder.model.pr.RoleChoice;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class ProviderDetailsQueryResponseTransformationTest extends BaseTransformerTestCase {
	
	private static final SpecificationVersion VERSION = SpecificationVersion.NEWFOUNDLAND;

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createProviderDetails());
		assertNotNull("result", xml);
		assertValidHl7Message(xml, VERSION);
	}

	@Test
	public void shouldMatchKnownResponse() throws Exception {
		ProviderDetailsResponseMessageBean model = createProviderDetails();
		String xml = this.transformer.transformToHl7(VERSION, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(
				getClass(), "/ca/infoway/messagebuilder/sample/pr/v02r02/providerDetailsQueryResponse.xml")), actual);
	}

	private ProviderDetailsResponseMessageBean createProviderDetails() {
		ProviderDetailsCriteria criteria = new ProviderDetailsCriteria();
		criteria.setName(PersonName.createFirstNameLastName("J", "Smith"));
		
		ProviderDetailsResponseMessageBean model = new ProviderDetailsResponseMessageBean(criteria);
		model.getControlActEvent().setCode(HL7TriggerEventCode.PROVIDER_DETAILS_QUERY);
		model.getControlActEvent().setStatusCode(ActStatus.COMPLETED);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		model.getAcknowledgement().setTargetMessage(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad41"));
		model.getAcknowledgement().setAcknowledgementType(AcknowledgementType.APPLICATION_ACKNOWLEDGEMENT_ACCEPT);
		model.getControlActEvent().setEventId(new Identifier("2.16.840.1.113883.1.6", "8141234"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		
		RegistrationEventRecordBean<RoleChoice> record = new RegistrationEventRecordBean<RoleChoice>(createProviderRecord(), ActStatus.ACTIVE);
		record.getCustodian().setId(new Identifier("1.2.3.4.5.6.7", "deviceId"));
		record.getCustodian().setRepositoryName("Panacea");
		record.getCustodian().setJurisdictionName("Ontario");
		model.getControlActEventBean().getQueryRecords().add(record);
		
		model.getQuerySummary().setQueryResponseCode(QueryResponse.DATA_FOUND);
		model.getQuerySummary().setResultTotalQuantity(1);
		model.getQuerySummary().setResultCurrentQuantity(1);
		model.getQuerySummary().setResultRemainingQuantity(0);
		model.getQuerySummary().setQueryId(model.getQueryId());
		
		return model;
	}

	private HealthcareProvider createProviderRecord() {
		HealthcareProvider provider = new HealthcareProvider();
		provider.setCode(CodeResolverRegistry.lookup(HealthcareProviderRoleType.class, "MD", CodeSystem.VOCABULARY_ROLE_CODE.getRoot()));
		provider.getId().add(new Identifier(CodeSystem.REFERRALS_OHIP_BILLING_NUMBER.getRoot(), "111-111-111"));
		PersonName personName = new PersonName();
		personName.addNamePart(new EntityNamePart("Robert", PersonNamePartType.GIVEN));
		personName.addNamePart(new EntityNamePart("Sales", PersonNamePartType.FAMILY));
		provider.getName().add(personName);
		return provider;
	}
	
}
