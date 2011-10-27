/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.model.mock.InFulfillmentOfBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MockTestCaseMessageDefinitionService;

public class Hl7SourceMapperIndicatorTest {
	
	private static final String XML_TRUE = 
		"<inFulfillmentOf contextConductionInd=\"true\" contextControlCode=\"AN\" typeCode=\"FLFS\" xmlns=\"urn:hl7-org:v3\" >" +
			"<sequenceNumber value=\"2\"/>" +
			"<immunizationPlan classCode=\"SBADM\" moodCode=\"INT\">" +
				"<code code=\"IMMUNIZ\" codeSystem=\"2.16.840.1.113883.5.4\"/>" +
				"<statusCode code=\"active\"/>" +
			"</immunizationPlan>" +
		"</inFulfillmentOf>";
	
	private static final String XML_FALSE = 
		"<inFulfillmentOf contextConductionInd=\"true\" contextControlCode=\"AN\" typeCode=\"FLFS\" xmlns=\"urn:hl7-org:v3\" >" +
			"<sequenceNumber value=\"2\"/>" +
		"</inFulfillmentOf>";
	
	private static final String XML_NULL = 
		"<inFulfillmentOf contextConductionInd=\"true\" contextControlCode=\"AN\" typeCode=\"FLFS\" xmlns=\"urn:hl7-org:v3\" >" +
			"<sequenceNumber value=\"2\"/>" +
			"<immunizationPlan nullFlavor=\"UNK\" />" +
		"</inFulfillmentOf>";
	
	private Document document;
	private MessageDefinitionService service;
	private Element element;
	private Hl7PartSource partSource;
	
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
	public void shouldMapIndicatorAttributesWhenPresent() throws Exception {
		this.document = getSourceDocument(XML_TRUE);
		this.element = this.document.getDocumentElement();
		Hl7MessageSource rootSource = new Hl7MessageSource(MockVersionNumber.MOCK_MR2009, this.document, null, null, this.service);
		this.partSource = rootSource.createPartSource(createRelationship("POIZ_MT030050CA.InFulfillmentOf"), element);

		InFulfillmentOfBean teal = (InFulfillmentOfBean) new Hl7SourceMapper().mapPartSourceToTeal(this.partSource, null);
		assertNotNull("teal", teal);
		
		assertNotNull("indicator", teal.getImmunizationPlan());
		boolean indValue = teal.getImmunizationPlan().booleanValue();
		assertTrue("indicator", indValue);
		assertFalse("indicator", ((BL) teal.getField("immunizationPlan")).isNull());
		assertEquals("dose number", 2, teal.getDoseNumber().intValue());
	}

	@Test
	public void shouldHandleIndicatorAttributesWhenAbsent() throws Exception {
		
		this.document = getSourceDocument(XML_FALSE);
		this.element = this.document.getDocumentElement();
		Hl7MessageSource rootSource = new Hl7MessageSource(MockVersionNumber.MOCK_MR2009, this.document, null, null, this.service);
		this.partSource = rootSource.createPartSource(createRelationship("POIZ_MT030050CA.InFulfillmentOf"), element);

		InFulfillmentOfBean teal = (InFulfillmentOfBean) new Hl7SourceMapper().mapPartSourceToTeal(this.partSource, null);
		assertNotNull("teal", teal);
		
		assertFalse("null flavor", ((BL) teal.getField("immunizationPlan")).isNull());
		assertEquals("dose number", 2, teal.getDoseNumber().intValue());
		boolean indValue = teal.getImmunizationPlan().booleanValue();
		assertNotNull("indicator", indValue); 
		assertFalse("indicator", teal.getImmunizationPlan().booleanValue());
	}

	@Test
	public void shouldHandleIndicatorAttributesWhenNullFlavor() throws Exception {
		this.document = getSourceDocument(XML_NULL);
		this.element = this.document.getDocumentElement();
		Hl7MessageSource rootSource = new Hl7MessageSource(MockVersionNumber.MOCK_MR2009, this.document, null, null, this.service);
		this.partSource = rootSource.createPartSource(createRelationship("POIZ_MT030050CA.InFulfillmentOf"), element);

		InFulfillmentOfBean teal = (InFulfillmentOfBean) new Hl7SourceMapper().mapPartSourceToTeal(this.partSource, null);
		assertNotNull("teal", teal);
		
		assertTrue("null flavor", ((BL) teal.getField("immunizationPlan")).isNull());
		assertEquals("dose number", 2, teal.getDoseNumber().intValue());
		assertNull("indicator", teal.getImmunizationPlan());
		//assertFalse("indicator", teal.getImmunizationPlan()); // indicator boolean value is not present (null) when has null flavor
	}

	private Document getSourceDocument(String xml) throws Exception {
		return new DocumentFactory().createFromString(xml);
	}

}
