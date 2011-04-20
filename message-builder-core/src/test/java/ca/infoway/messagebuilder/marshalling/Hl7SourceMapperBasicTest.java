package ca.infoway.messagebuilder.marshalling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.controlact.ActStatus;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.mock.QuantityObservationEventBean;
import ca.infoway.messagebuilder.model.mock.Sender;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MockTestCaseMessageDefinitionService;

public class Hl7SourceMapperBasicTest {
	
	private static final String XML = "<sender typeCode=\"SND\" xmlns=\"urn:hl7-org:v3\" >" +
			"		<telecom value=\"http://987.654.321.0\" />" +
			"		<device classCode=\"DEV\" determinerCode=\"INSTANCE\">" +
			"			<id extension=\"123\" root=\"2.16.840.1.113883.4.262.12\" use=\"BUS\" />" +
			"			<manufacturerModelName>1.0</manufacturerModelName>" +
			"			<softwareName>Panacea Pharmacy</softwareName>" +
			"		</device>" +
			"	</sender>";
	
	private static final String XML2 = "<observation classCode=\"OBS\" moodCode=\"EVN\" xmlns=\"urn:hl7-org:v3\" >" +
	"		<code code=\"3137-7\" codeSystem=\"1.2.3.4\" />" +
	"		<statusCode code=\"completedINCORRECT\" />" +
	"		<value unit=\"mm\" value=\"5\" />" +
	"	</observation>";

	private Document document;
	private MessageDefinitionService service;
	private Element element;
	private Hl7PartSource partSource;
	
	@Before
	public void setUp() throws Exception {
		MockMessageBeanRegistry.initialize();
		CodeResolverRegistry.register(new EnumBasedCodeResolver(ActStatus.class));
		CodeResolverRegistry.register(new TrivialCodeResolver());
		this.service = new MockTestCaseMessageDefinitionService();
		this.document = getSourceDocument(XML);
		this.element = this.document.getDocumentElement();
		Hl7MessageSource rootSource = new Hl7MessageSource(MockVersionNumber.MOCK_NEWFOUNDLAND.getVersionLiteral(), this.document, this.service);
		this.partSource = rootSource.createPartSource(createRelationship("MCCI_MT002100CA.Sender"), element);
	}

	private Relationship createRelationship(String type) {
		Relationship relationship = new Relationship();
		relationship.setType(type);
		return relationship;
	}

	@Test
	public void shouldMapSenderAttributes() throws Exception {
		Sender teal = (Sender) new Hl7SourceMapper().mapPartSourceToTeal(this.partSource, null);
		assertNotNull("teal", teal);
		
		assertNotNull("telecom", teal.getTelecommunicationAddress());
		assertEquals("telecom number", "http://987.654.321.0", teal.getTelecommunicationAddress().toString());
	}

	@Test
	public void shouldMapSenderCollapsedAssociation() throws Exception {
		Sender teal = (Sender) new Hl7SourceMapper().mapPartSourceToTeal(partSource, null);
		assertNotNull("teal", teal);
		
		assertNotNull("device id", teal.getDeviceId());
		assertEquals("id", new Identifier("2.16.840.1.113883.4.262.12", "123"), teal.getDeviceId());
		assertEquals("model", "1.0", teal.getManufacturerModelNumber());
		assertEquals("model", "Panacea Pharmacy", teal.getSoftwareName());
	}

	@Test
	public void shouldMapObservationAttributes() throws Exception {
		Document document2 = getSourceDocument(XML2);
		Element element2 = document2.getDocumentElement();
		Hl7MessageSource rootSource2 = new Hl7MessageSource(MockVersionNumber.MOCK_NEWFOUNDLAND.getVersionLiteral(), document2, this.service);
		Hl7PartSource partSource2 = rootSource2.createPartSource(createRelationship("PORX_MT010120CA.QuantityObservationEvent"), element2);
		QuantityObservationEventBean teal = (QuantityObservationEventBean) new Hl7SourceMapper().mapPartSourceToTeal(partSource2, null);
		
		assertNotNull("teal", teal);
		assertNotNull("code1", teal.getPatientMeasurementType());
		assertNotNull("code2", teal.getPatientMeasuredValue());

		XmlToModelResult result = partSource2.getResult();
		assertNotNull("result", result);
		assertEquals(2, result.getHl7Errors().size());
		assertEquals(Hl7ErrorCode.UNSUPPORTED_INTERACTION, result.getHl7Errors().get(0).getHl7ErrorCode());
		assertEquals(Hl7ErrorCode.MANDATORY_FIELD_NOT_PROVIDED, result.getHl7Errors().get(1).getHl7ErrorCode());
	}
	
	
	private Document getSourceDocument(String xml) throws Exception {
		return new DocumentFactory().createFromString(xml);
	}

}
