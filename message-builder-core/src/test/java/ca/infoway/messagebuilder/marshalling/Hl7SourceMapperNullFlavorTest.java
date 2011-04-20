package ca.infoway.messagebuilder.marshalling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.xml.xpath.XPathExpressionException;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.model.cr.FindCandidatesCriteria;
import ca.infoway.messagebuilder.model.mock.AssignedPersonBean;
import ca.infoway.messagebuilder.model.mock.AuthorBean;
import ca.infoway.messagebuilder.model.mock.QueryByParameterBean;
import ca.infoway.messagebuilder.model.mock.Sender;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MockTestCaseMessageDefinitionService;

// FIXME - TM - 3 tests are commented out below and should be re-implemented

public class Hl7SourceMapperNullFlavorTest {
	
	private MessageDefinitionService service;
	
	private static final String XML_WITH_NULL_FLAVOR = "<sender typeCode=\"SND\" xmlns=\"urn:hl7-org:v3\">" +
			"  <telecom nullFlavor=\"OTH\" />" +
			"  <device classCode=\"DEV\" determinerCode=\"INSTANCE\">" +
			"    <id extension=\"123\" root=\"2.16.840.1.113883.4.262.12\" use=\"BUS\" />" +
			"    <manufacturerModelName>1.0</manufacturerModelName>" +
			"    <softwareName>Panacea Pharmacy</softwareName>" +
			"  </device>" +
			"</sender>";
	private static final String XML_CHOICE_WITH_NULL_FLAVOR = "<author xmlns=\"urn:hl7-org:v3\">" +
			"  <time value=\"20080918181800\"/>" +
			"  <assignedEntity1 nullFlavor=\"OTH\" />" +
			"</author>";
	private static final String XML_CODE_WITH_NULL_FLAVOR = "<queryByParameter xmlns=\"urn:hl7-org:v3\">" +
			"  <queryId root=\"1ee83ff1-08ab-4fe7-b573-ea777e9bad31\" />" +
			"  <initialQuantityCode nullFlavor=\"OTH\" codeSystem=\"2.16.840.1.113883.5.1\" />" +
			"  <parameterList>" +
			"    <personName>" +
			"      <value><given>J</given><family>Smith</family></value>" +
			"    </personName>" +
			"  </parameterList>" +
			"</queryByParameter>";
	
	@Before
	public void setUp() throws Exception {
		MockMessageBeanRegistry.initialize();
		CodeResolverRegistry.register(new TrivialCodeResolver());
		this.service = new MockTestCaseMessageDefinitionService();
	}

	private Relationship createRelationship(String type) {
		Relationship relationship = new Relationship();
		relationship.setType(type);
		return relationship;
	}

	@Test
	public void shouldMapAttributeWithNullFlavor() throws Exception {
		Sender bean = (Sender) mapPartSourceToTeal(
				MockVersionNumber.MOCK_NEWFOUNDLAND,
				XML_WITH_NULL_FLAVOR,
				"MCCI_MT002100CA.Sender");

		assertNotNull("teal", bean);
		
		assertNull("telecom", bean.getTelecommunicationAddress());
		assertEquals("null flavor", 
				NullFlavor.OTHER,
				new DataTypeFieldHelper(bean, "telecommunicationAddress").getNullFlavor());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldMapCDAttributeWithNullFlavor() throws Exception {
		QueryByParameterBean<FindCandidatesCriteria> bean = (QueryByParameterBean<FindCandidatesCriteria>) mapPartSourceToTeal(
				MockVersionNumber.MOCK_NEWFOUNDLAND,
				XML_CODE_WITH_NULL_FLAVOR,
				"MFMI_MT700751CA.QueryByParameter");
		
		assertNotNull("CD", bean.getQueryLimitType());
		
		assertEquals("null flavor", 
				NullFlavor.OTHER,
				new DataTypeFieldHelper(bean, "queryLimitType").getNullFlavor());

		assertEquals("code system", 
				"2.16.840.1.113883.5.1", 
				bean.getQueryLimitType().getCodeSystem());
		assertNull("code", 
				bean.getQueryLimitType().getCodeValue());
		
	}

//	@Test
//	public void shouldMapAssociationWithNullFlavor() throws Exception {
//		DispenseInstructionsBean bean = (DispenseInstructionsBean) mapPartSourceToTeal(
//				SpecificationVersion.NEWFOUNDLAND, 
//				"activatePrescriptionRequestWithNullFlavor.xml", 
//				"./x:controlActEvent/x:subject/x:combinedMedicationRequest/x:component3/x:supplyRequest", 
//				"PORX_MT010120CA.SupplyRequest");
//		
//		assertNotNull("teal bean", bean);
////		assertTrue("has null flavor", bean.getLocation().hasNullFlavor());
////		assertEquals("null flavor", NullFlavor.OTHER, bean.getLocation().getNullFlavor());
//	}
//
//	@Test
//	public void shouldMapCollapsedAssociationWithNullFlavor() throws Exception {
//		CombinedMedication2Bean bean = (CombinedMedication2Bean) mapPartSourceToTeal(
//				SpecificationVersion.NEWFOUNDLAND, 
//				"activatePrescriptionRequestWithNullFlavor.xml", 
//				"./x:controlActEvent/x:subject/x:combinedMedicationRequest", 
//				"PORX_MT060160CA.CombinedMedicationRequest");
//		
//		assertNotNull("teal bean", bean);
//		assertTrue("has null flavor", bean.getLocation().hasNullFlavor());
//		assertEquals("null flavor", NullFlavor.OTHER, bean.getLocation().getNullFlavor());
//	}

	@Test
	public void shouldMapChoiceWithNullFlavor() throws Exception {
		AuthorBean bean = (AuthorBean) mapPartSourceToTeal(
				MockVersionNumber.MOCK_NEWFOUNDLAND,
				XML_CHOICE_WITH_NULL_FLAVOR,
				"MFMI_MT700751CA.Author_V02R02");
		
		assertNotNull("teal bean", bean);
		assertTrue("choice has null flavor", ((AssignedPersonBean) bean.getAuthorPerson()).hasNullFlavor());
		assertEquals("choice null flavor", NullFlavor.OTHER.getCodeValue(), 
				((AssignedPersonBean) bean.getAuthorPerson()).getNullFlavor().getCodeValue());
	}
	
//	@Test
//	public void shouldMapMultipleCardinalityAssociationWithNullFlavor() throws Exception {
//		Document document1 = new DocumentFactory().createFromResource(
//				new ClasspathResource(this.getClass(), "findCandidatesQuery_withNullFlavor.xml"));
//		
//		Hl7MessageSource rootPartSource1 = new Hl7MessageSource(SpecificationVersion.NEWFOUNDLAND.getVersionLiteral(), 
//				document1, 
//				this.service);
//		
//		FindCandidatesQueryMessageBean bean = (FindCandidatesQueryMessageBean)new Hl7SourceMapper().mapToTeal(rootPartSource1).getMessageObject();
//
//		assertNotNull("teal bean", bean);
//		assertFalse("first reason has no null flavor", bean.getReasons().get(0).hasNullFlavor());
//		assertTrue("second reason has null flavor", bean.getReasons().get(1).hasNullFlavor());		
//		assertEquals("second reason null flavor", NullFlavor.OTHER, bean.getReasons().get(1).getNullFlavor());
//	}
	
	private Object mapPartSourceToTeal(VersionNumber version, String xml,
			String relationshipType) throws IOException, SAXException,
			XPathExpressionException {
		Document document1 = new DocumentFactory()
				.createFromString(xml);

		Hl7MessageSource rootPartSource1 = new Hl7MessageSource(version
				.getVersionLiteral(), new DocumentFactory()
				.createFromString("<PRPA_IN101103CA xmlns=\"urn:hl7-org:v3\" />"), this.service);

		Hl7PartSource partSource1 = rootPartSource1.createPartSource(
				createRelationship(relationshipType), document1.getDocumentElement());

		return new Hl7SourceMapper().mapPartSourceToTeal(partSource1, null);
	}
	
}
