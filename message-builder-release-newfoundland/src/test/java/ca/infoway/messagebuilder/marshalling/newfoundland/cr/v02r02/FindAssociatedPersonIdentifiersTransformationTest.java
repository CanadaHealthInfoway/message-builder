package ca.infoway.messagebuilder.marshalling.newfoundland.cr.v02r02;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.junit.XmlAssert;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.cr.FindAssociatedPersonIdentifiersQueryMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class FindAssociatedPersonIdentifiersTransformationTest extends BaseTransformerTestCase {
	
	private static final SpecificationVersion VERSION = SpecificationVersion.NEWFOUNDLAND;

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createRequest());
		assertNotNull("result", xml);
		assertValidHl7Message(xml);
	}

	@Test
	public void shouldMatchKnownResponse() throws Exception {
		FindAssociatedPersonIdentifiersQueryMessageBean model = createRequest();
		String xml = this.transformer.transformToHl7(VERSION, model);
		Document actual = this.factory.createFromString(xml);
		
		XmlAssert.assertTreeEquals(this.factory.createFromResource(new ClasspathResource(
				getClass(), "/ca/infoway/messagebuilder/sample/cr/v02r02/findAssociatedPersonIdentifiersQuery.xml")), actual);
	}

	private FindAssociatedPersonIdentifiersQueryMessageBean createRequest() {
		FindAssociatedPersonIdentifiersQueryMessageBean model = new FindAssociatedPersonIdentifiersQueryMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.FIND_ASSOCIATED_PERSON_IDENTIFIERS_QUERY);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		model.getCriteria().setClientBusinessId(new Identifier("2.16.840.1.113883.1.133", "9283488"));
		return model;
	}
}
