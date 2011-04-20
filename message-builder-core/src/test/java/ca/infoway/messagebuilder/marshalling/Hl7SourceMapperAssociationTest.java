package ca.infoway.messagebuilder.marshalling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.URLScheme;
import ca.infoway.messagebuilder.model.mock.Sender;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MockTestCaseMessageDefinitionService;

public class Hl7SourceMapperAssociationTest {
	
	private static final String XML = "<sender typeCode=\"SND\" xmlns=\"urn:hl7-org:v3\" >" +
	"		<telecom value=\"http://987.654.321.0\" />" +
	"		<device classCode=\"DEV\" determinerCode=\"INSTANCE\">" +
	"			<id extension=\"123\" root=\"2.16.840.1.113883.4.262.12\" use=\"BUS\" />" +
	"			<manufacturerModelName>1.0</manufacturerModelName>" +
	"			<softwareName>Panacea Pharmacy</softwareName>" +
	"		</device>" +
	"	</sender>";

	private Document document;
	private MessageDefinitionService service;
	private Element element;
	private Hl7PartSource partSource;
	
	@Before
	public void setUp() throws Exception {
		MockMessageBeanRegistry.initialize();
		CodeResolverRegistry.register(new TrivialCodeResolver());
		this.service = new MockTestCaseMessageDefinitionService();
		this.document = getSourceDocument();
		Hl7MessageSource rootSource = new Hl7MessageSource(MockVersionNumber.MOCK_NEWFOUNDLAND.getVersionLiteral(), document, this.service);
		this.element = this.document.getDocumentElement();
		this.partSource = rootSource.createPartSource(createRelationship("MCCI_MT002100CA.Sender"), element);
	}
	
	private Relationship createRelationship(String type) {
		Relationship relationship = new Relationship();
		relationship.setType(type);
		return relationship;
	}

	@Test
	public void shouldMapSender() throws Exception {
		Sender teal = (Sender) new Hl7SourceMapper().mapPartSourceToTeal(this.partSource, null);
		
		assertNotNull("teal", teal);
		assertEquals("device id", new Identifier("2.16.840.1.113883.4.262.12", "123"), teal.getDeviceId());
		assertNull("device name", teal.getDeviceName());
		assertEquals("model number", "1.0", teal.getManufacturerModelNumber());
		assertNull("sending org id", teal.getSendingOrganizationIdentifier());
		assertEquals("software name", "Panacea Pharmacy", teal.getSoftwareName());
		assertEquals("address", "987.654.321.0", teal.getTelecommunicationAddress().getAddress());
		assertEquals("address scheme", URLScheme.HTTP.getCodeValue(), teal.getTelecommunicationAddress().getUrlScheme().getCodeValue());
	}

	private Document getSourceDocument() throws Exception {
		return new DocumentFactory().createFromString(XML);
	}
}
