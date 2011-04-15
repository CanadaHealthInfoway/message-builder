package ca.infoway.messagebuilder.marshalling.cr.v02r02;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.BaseTransformerTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.cr.FindCandidatesQueryMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cr.FindCandidatesQueryResponseMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class FindCandidatesTransformationTest extends BaseTransformerTestCase {
	
	private static final SpecificationVersion VERSION = SpecificationVersion.NEWFOUNDLAND;

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createFindCandidates());
		assertNotNull("result", xml);
		assertPassesMessageValidation(xml, VERSION);
	}

	@Test
	public void shouldMatchKnownMessage() throws Exception {
		FindCandidatesQueryMessageBean model = createFindCandidates();
		String xml = toHl7UsingNewRenderer(model, VERSION);
		Document actual = this.factory.createFromString(xml);

		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(
				getClass(), "/ca/infoway/messagebuilder/sample/cr/v02r02/findCandidatesQuery.xml")), actual);
	}

	@Test 
	public void shouldProcessResponse() throws Exception {
		Document xml = this.factory.createFromResource(new ClasspathResource(getClass(), "/ca/infoway/messagebuilder/sample/cr/v02r02/findCandidatesResponse.xml"));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, xml);
		assertTrue("type", result.getMessageObject() instanceof FindCandidatesQueryResponseMessageBean);
		
		FindCandidatesQueryResponseMessageBean response = (FindCandidatesQueryResponseMessageBean) result.getMessageObject();
		assertEquals("found", 1, response.getControlActEventBean().getQueryRecords().size());
	}

	private FindCandidatesQueryMessageBean createFindCandidates() {
		FindCandidatesQueryMessageBean model = new FindCandidatesQueryMessageBean();
		model.getControlActEventBean().setCode(HL7TriggerEventCode.FIND_CANDIDATES_QUERY);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEventBean());
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		model.getCriteria().setName(PersonName.createFirstNameLastName("J", "Smith"));
		return model;
	}
}
