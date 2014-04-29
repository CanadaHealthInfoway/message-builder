/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.marshalling;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TNImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.junit.XmlAssert;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.Relationship;

public class XmlRenderingVisitorTest {

	@Hl7PartTypeMapping("ABCD_MT987654CA.Baby")
	public class Part {

	}

	private XmlRenderingVisitor visitor;
	private Interaction interation;
	private MockPartBridge partBridge;
	private MockAttributeBridge attributeBridge;
	
	@Before
	public void setUp() throws Exception {
		CodeResolverRegistry.registerResolver(ActStatus.class, new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.controlact.ActStatus.class));
		this.visitor = new XmlRenderingVisitor();
		this.partBridge = new MockPartBridge();
		this.attributeBridge = new MockAttributeBridge();
		
		this.interation = new Interaction();
		this.interation.setName("ABCD_IN123456CA");
		Argument argument = new Argument();
		argument.setName("ABCD_MT987654CA.Baby");
		argument.setTemplateParameterName("act");
		argument.setTraversalName("bambino");
		this.interation.getArguments().add(argument);
	}
	
	@After
	public void tearDown() {
		CodeResolverRegistry.unregisterAll();
	}
	
	@Test
	public void shouldRenderRootElement() throws Exception {
		
		this.visitor.visitRootStart(this.partBridge, this.interation);
		this.visitor.visitRootEnd(this.partBridge, this.interation);
		
		String xml = this.visitor.toXml().getXmlMessage();
		assertXmlEquals("xml", "<ABCD_IN123456CA xmlns=\"urn:hl7-org:v3\" " +
				"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ITSVersion=\"XML_1.0\"/>", xml);
	}

	@Test
	public void shouldRenderNonStructuralAttributeWithNullFlavor() throws Exception {
		this.attributeBridge.setHl7Value(new IIImpl(NullFlavor.MASKED));

		this.visitor.visitRootStart(this.partBridge, this.interation);
		this.visitor.visitAttribute(this.attributeBridge, createNonStructuralRelationship(), null, null, null);
		this.visitor.visitRootEnd(this.partBridge, this.interation);
		
		String xml = this.visitor.toXml().getXmlMessage();
		assertXmlEquals("xml", "<ABCD_IN123456CA xmlns=\"urn:hl7-org:v3\" " +
				"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ITSVersion=\"XML_1.0\">" +
				"<id nullFlavor=\"MSK\"/>" +
				"</ABCD_IN123456CA>", xml);
	}

	@Test
	public void shouldRenderNonStructuralAttribute() throws Exception {
		IIImpl iiImpl = new IIImpl(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		iiImpl.setDataType(StandardDataType.II_TOKEN);
		this.attributeBridge.setHl7Value(iiImpl);

		this.visitor.visitRootStart(this.partBridge, this.interation);
		this.visitor.visitAttribute(this.attributeBridge, createNonStructuralRelationship(), null, null, null);
		this.visitor.visitRootEnd(this.partBridge, this.interation);
		
		String xml = this.visitor.toXml().getXmlMessage();
		assertXmlEquals("xml", "<ABCD_IN123456CA xmlns=\"urn:hl7-org:v3\" " +
				"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ITSVersion=\"XML_1.0\">" +
				"<id root=\"1ee83ff1-08ab-4fe7-b573-ea777e9bad51\"/>" +
				"</ABCD_IN123456CA>", xml);
	}
	
	@Test
	public void shouldRenderNonStructuralAttributeString() throws Exception {
		this.attributeBridge.setHl7Value(new STImpl("some string"));
		
		this.visitor.visitRootStart(this.partBridge, this.interation);
		
		Relationship relationship = new Relationship();
		relationship.setName("value");
		relationship.setType(StandardDataType.ANY_LAB.getType());
		this.visitor.visitAttribute(this.attributeBridge, relationship, null, null, null);
		
		this.visitor.visitRootEnd(this.partBridge, this.interation);
		
		String xml = this.visitor.toXml().getXmlMessage();
		assertXmlEquals("xml", "<ABCD_IN123456CA xmlns=\"urn:hl7-org:v3\" " +
				"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ITSVersion=\"XML_1.0\">" +
				"<value specializationType=\"ST\" xsi:type=\"ST\">some string</value>" +
				"</ABCD_IN123456CA>", xml);
	}
	
	@Test
	public void shouldRenderNotNonStructuralAttributeFullDate() throws Exception {
		this.attributeBridge.setHl7Value(new TNImpl(new TrivialName("Trivial Name")));
		this.visitor.visitRootStart(this.partBridge, this.interation);
		
		Relationship relationship = new Relationship();
		relationship.setName("value");
		relationship.setType(StandardDataType.ANY_LAB.getType());

		this.visitor.visitAttribute(attributeBridge, relationship, null, null, null);
		
		this.visitor.visitRootEnd(this.partBridge, this.interation);
		
		ModelToXmlResult result = this.visitor.toXml();
		result.getXmlMessage();

		List<Hl7Error> hl7Errors = result.getHl7Errors();
		Assert.assertFalse("should have incompatable ANY.LAB value", hl7Errors.isEmpty());
		Assert.assertEquals("should have incompatable ANY.LAB value", 1, hl7Errors.size());
		Assert.assertEquals("should have incompatable ANY.LAB value", 
							"Cannot support properties of type TN for ANY.LAB. Please specify a specializationType applicable for ANY.LAB in the appropriate message bean.", 
							hl7Errors.get(0).getMessage());
	}

	@Test
	public void shouldRenderFixedValueNonStructuralAttribute() throws Exception {
		this.visitor.visitRootStart(this.partBridge, this.interation);
		this.visitor.visitAttribute(this.attributeBridge, createFixedValueNonStructuralRelationship(), SpecificationVersion.V01R04_3, null, null);
		this.visitor.visitRootEnd(this.partBridge, this.interation);
		
		String xml = this.visitor.toXml().getXmlMessage();
		assertXmlEquals("xml", "<ABCD_IN123456CA xmlns=\"urn:hl7-org:v3\" " +
				"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ITSVersion=\"XML_1.0\">" +
				"<code code=\"completed\" codeSystem=\"2.16.840.1.113883.5.14\"/>" +
				"</ABCD_IN123456CA>", xml);
	}

	private Relationship createNonStructuralRelationship() {
		Relationship relationship = new Relationship();
		relationship.setName("id");
		relationship.setType(StandardDataType.II_TOKEN.getType());
		return relationship;
	}

	private Relationship createFixedValueNonStructuralRelationship() {
		Relationship relationship = new Relationship();
		relationship.setName("code");
		relationship.setType(StandardDataType.CV.getType());
		relationship.setDomainType("ActStatus");
		relationship.setFixedValue("completed");
		return relationship;
	}

	@Test
	public void shouldRenderStructuralAttribute() throws Exception {
		this.attributeBridge.setValue(Boolean.FALSE);

		this.visitor.visitRootStart(this.partBridge, this.interation);
		this.visitor.visitAttribute(this.attributeBridge, createStructuralRelationship(), null, null, null);
		this.visitor.visitRootEnd(this.partBridge, this.interation);
		
		String xml = this.visitor.toXml().getXmlMessage();
		assertXmlEquals("xml", "<ABCD_IN123456CA xmlns=\"urn:hl7-org:v3\" " +
				"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ITSVersion=\"XML_1.0\" negationInd=\"false\"/>", xml);
	}

	@Test
	public void shouldRenderFixedValueStructuralAttribute() throws Exception {
		this.attributeBridge.setValue(Boolean.FALSE);

		this.visitor.visitRootStart(this.partBridge, this.interation);
		this.visitor.visitAttribute(this.attributeBridge, createFixedValueStructuralRelationship(), null, null, null);
		this.visitor.visitRootEnd(this.partBridge, this.interation);
		
		String xml = this.visitor.toXml().getXmlMessage();
		assertXmlEquals("xml", "<ABCD_IN123456CA xmlns=\"urn:hl7-org:v3\" " +
				"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ITSVersion=\"XML_1.0\" negationInd=\"true\"/>", xml);
	}

	private Relationship createStructuralRelationship() {
		Relationship relationship = new Relationship();
		relationship.setName("negationInd");
		relationship.setType(StandardDataType.BL.getType());
		relationship.setStructural(true);
		return relationship;
	}

	private Relationship createFixedValueStructuralRelationship() {
		Relationship relationship = new Relationship();
		relationship.setName("negationInd");
		relationship.setFixedValue("true");
		relationship.setType(StandardDataType.BL.getType());
		relationship.setStructural(true);
		return relationship;
	}

	@Test
	public void shouldRenderSimpleAssociation() throws Exception {
		Relationship relationship = createSimpleAssociationRelationship();

		this.visitor.visitRootStart(this.partBridge, this.interation);
		this.visitor.visitAssociationStart(this.partBridge, relationship);
		this.visitor.visitAssociationEnd(this.partBridge, relationship);
		this.visitor.visitRootEnd(this.partBridge, this.interation);
		
		String xml = this.visitor.toXml().getXmlMessage();
		assertXmlEquals("xml", "<ABCD_IN123456CA xmlns=\"urn:hl7-org:v3\" " +
				"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ITSVersion=\"XML_1.0\">" 
				+"<receiver/></ABCD_IN123456CA>", xml);
		
	}

	@Test
	public void shouldRenderSimpleAssociationWithNullFlavor() throws Exception {
		Relationship relationship = createSimpleAssociationRelationship();
		
		this.partBridge.setNullFlavor(NullFlavor.MASKED);
		this.partBridge.setEmpty(true);
		
		this.visitor.visitRootStart(this.partBridge, this.interation);
		this.visitor.visitAssociationStart(this.partBridge, relationship);
		this.visitor.visitAssociationEnd(this.partBridge, relationship);
		this.visitor.visitRootEnd(this.partBridge, this.interation);
		
		String xml = this.visitor.toXml().getXmlMessage();
		assertXmlEquals("xml", "<ABCD_IN123456CA xmlns=\"urn:hl7-org:v3\" " +
				"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ITSVersion=\"XML_1.0\">" 
				+"<receiver nullFlavor=\"MSK\" xsi:nil=\"true\"/></ABCD_IN123456CA>", xml);
		
	}

	@Test
	public void shouldRenderTemplateAssociation() throws Exception {
		Relationship relationship = createTemplateAssociationRelationship();

		this.visitor.visitRootStart(this.partBridge, this.interation);
		this.visitor.visitAssociationStart(this.partBridge, relationship);
		this.visitor.visitAssociationEnd(this.partBridge, relationship);
		this.visitor.visitRootEnd(this.partBridge, this.interation);
		
		String xml = this.visitor.toXml().getXmlMessage();
		assertXmlEquals("xml", "<ABCD_IN123456CA xmlns=\"urn:hl7-org:v3\" " +
				"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ITSVersion=\"XML_1.0\">" 
				+"<bambino/></ABCD_IN123456CA>", xml);
		
	}

	@Test
	public void shouldRenderNullAssociation() throws Exception {
		this.partBridge.setEmpty(true);
		Relationship relationship = createSimpleAssociationRelationship();

		this.visitor.visitRootStart(this.partBridge, this.interation);
		this.visitor.visitAssociationStart(this.partBridge, relationship);
		this.visitor.visitAssociationEnd(this.partBridge, relationship);
		this.visitor.visitRootEnd(this.partBridge, this.interation);
		
		String xml = this.visitor.toXml().getXmlMessage();
		assertXmlEquals("xml", "<ABCD_IN123456CA xmlns=\"urn:hl7-org:v3\" " +
				"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ITSVersion=\"XML_1.0\">" 
				+"<receiver nullFlavor=\"NI\" xsi:nil=\"true\"/></ABCD_IN123456CA>", xml);
		
	}

	@Test
	public void shouldRenderChoiceAssociation() throws Exception {
		this.partBridge.setTypeName("ABCD_MT987654CA.Baby");
		Relationship relationship = createChoiceAssociationRelationship();

		this.visitor.visitRootStart(this.partBridge, this.interation);
		this.visitor.visitAssociationStart(this.partBridge, relationship);
		this.visitor.visitAssociationEnd(this.partBridge, relationship);
		this.visitor.visitRootEnd(this.partBridge, this.interation);
		
		String xml = this.visitor.toXml().getXmlMessage();
		assertXmlEquals("xml", "<ABCD_IN123456CA xmlns=\"urn:hl7-org:v3\" " +
				"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ITSVersion=\"XML_1.0\">" 
				+"<!-- INFO: Selected option baby/ABCD_MT987654CA.Baby from choice PRPA_IN101103CA.Receiver -->" +
				 "<baby/></ABCD_IN123456CA>", xml);
	}

	@Test
	public void shouldRenderCombinationOfAttributesAndAssociations() throws Exception {
		this.attributeBridge.setEmpty(Boolean.FALSE);
		IIImpl iiImpl = new IIImpl(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		iiImpl.setDataType(StandardDataType.II_TOKEN);
		this.attributeBridge.setHl7Value(iiImpl);
		this.attributeBridge.setValue(Boolean.FALSE);
		
		Relationship relationship = createSimpleAssociationRelationship();

		this.visitor.visitRootStart(this.partBridge, this.interation);
		this.visitor.visitAssociationStart(this.partBridge, relationship);
		this.visitor.visitAttribute(this.attributeBridge, createNonStructuralRelationship(), null, null, null);
		this.visitor.visitAttribute(this.attributeBridge, createStructuralRelationship(), null, null, null);
		this.visitor.visitAssociationEnd(this.partBridge, relationship);
		this.visitor.visitRootEnd(this.partBridge, this.interation);
		
		String xml = this.visitor.toXml().getXmlMessage();
		assertXmlEquals(
				"xml",
				"<ABCD_IN123456CA xmlns=\"urn:hl7-org:v3\" "
						+ "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ITSVersion=\"XML_1.0\">"
						+ "<receiver negationInd=\"false\"><id root=\"1ee83ff1-08ab-4fe7-b573-ea777e9bad51\"/></receiver>"
						+ "</ABCD_IN123456CA>", xml);
		
	}

	private Relationship createSimpleAssociationRelationship() {
		Relationship relationship = new Relationship();
		relationship.setConformance(ConformanceLevel.POPULATED);
		relationship.setName("receiver");
		relationship.setType("PRPA_IN101103CA.Receiver");
		return relationship;
	}

	private Relationship createTemplateAssociationRelationship() {
		Relationship relationship = new Relationship();
		relationship.setName("receiver");
		relationship.setTemplateParameterName("act");
		return relationship;
	}

	private Relationship createChoiceAssociationRelationship() {
		Relationship relationship = new Relationship();
		relationship.setName("receiver");
		relationship.setType("PRPA_IN101103CA.Receiver");
		
		Relationship choice = new Relationship();
		choice.setName("baby");
		choice.setType("ABCD_MT987654CA.Baby");
		relationship.getChoices().add(choice);
		return relationship;
	}

	private void assertXmlEquals(String string, String expected, String actual) {
		assertEquals(string, WhitespaceUtil.normalizeWhitespace(expected), WhitespaceUtil.normalizeWhitespace(actual));
	}
}
