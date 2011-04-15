package ca.infoway.messagebuilder.marshalling.cr.v02r02;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.util.NameFormatter;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.BaseTransformerTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.AssignedDeviceBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.IndeterminatePersonBean;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationControlActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationRequestBean;
import ca.infoway.messagebuilder.model.newfoundland.cr.PersonNullifiedMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class PersonNullifiedTransformationTest extends BaseTransformerTestCase {
	
	private static final SpecificationVersion VERSION = SpecificationVersion.NEWFOUNDLAND;

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createRequest());
		assertNotNull("result", xml);
	}

	@Test
	public void shouldMatchKnownRequest() throws Exception {
		PersonNullifiedMessageBean model = createRequest();
		String xml = this.transformer.transformToHl7(VERSION, model);
		Document actual = this.factory.createFromString(xml);
		
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(
				"ca/infoway/messagebuilder/sample/cr/v02r02/personNullified.xml")), actual);
	}

	@Test
	public void shouldParseRequest() throws Exception {
		Document document = this.factory.createFromResource(new ClasspathResource(
				"ca/infoway/messagebuilder/sample/cr/v02r02/personNullified.xml"));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, document);
		PersonNullifiedMessageBean message = (PersonNullifiedMessageBean) result.getMessageObject();
		assertNotNull("object", message);
		
		assertEquals("control act", RegistrationControlActEventBean.class, message.getControlActEventBean().getClass());
		assertNotNull("registration", message.getControlActEventBean().getRegistrationBean());
		assertEquals("name", "Mabel Hauptman", 
				NameFormatter.getSimpleNameFormatter().format(
						message.getControlActEventBean().getRegistrationBean().getRecord().getIndeterminatePerson().getNames().get(0)));
	}

	@Test
	public void shouldParseRequestRxDesktopRequest() throws Exception {
		Document document = this.factory.createFromResource(new ClasspathResource(
				"ca/infoway/messagebuilder/sample/cr/v02r02/personNullifiedPharmacyExample.xml"));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, document);
		PersonNullifiedMessageBean message = (PersonNullifiedMessageBean) result.getMessageObject();
		assertNotNull("object", message);
		
		assertEquals("control act", RegistrationControlActEventBean.class, message.getControlActEventBean().getClass());
		assertNotNull("registration", message.getControlActEventBean().getRegistrationBean());
	}
	
	private PersonNullifiedMessageBean createRequest() {
		PersonNullifiedMessageBean model = new PersonNullifiedMessageBean();
		model.getControlActEventBean().setCode(HL7TriggerEventCode.PERSON_NULLIFIED);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		model.setAcknowledgementCondition(AcknowledgementCondition.NEVER);
		model.getControlActEventBean().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bae22"));
		model.getControlActEventBean().setEffectiveTime(MessageBeanBuilderSupport.EFFECTIVE_TIME);
		
		RegistrationRequestBean<IdentifiedPersonBean> registration = 
				new RegistrationRequestBean<IdentifiedPersonBean>();
		registration.setRecord(new IdentifiedPersonBean());
		registration.getRecord().setId(new Identifier("2.16.840.1.113883.1.133", "9283488"));
		
		IndeterminatePersonBean indeterminatePerson = new IndeterminatePersonBean(); 
		indeterminatePerson.setAdministrativeGenderCode(AdministrativeGender.FEMALE);
		indeterminatePerson.getNames().add(PersonName.createFirstNameLastName("Mabel", "Hauptman"));
		indeterminatePerson.setBirthTime(DateUtil.getDate(1932, Calendar.DECEMBER, 28));
		
		registration.getRecord().setIndeterminatePerson(indeterminatePerson);
		
		registration.setAssignedDevice(new AssignedDeviceBean());
		registration.getAssignedDevice().setId(new Identifier("1.2.3", "112233"));
		registration.getAssignedDevice().setAssignedRepository("Newfoundland/Panacea");
		registration.getAssignedDevice().setRepresentedRepositoryJurisdiction("Newfoundland");
		
		model.getControlActEventBean().setRegistrationBean(registration);
		return model;
	}
	
}
