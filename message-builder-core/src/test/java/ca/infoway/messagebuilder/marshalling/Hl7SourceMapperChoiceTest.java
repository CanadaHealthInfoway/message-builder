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

import static ca.infoway.messagebuilder.marshalling.MockVersionNumber.MOCK_NEWFOUNDLAND;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.model.mock.AssignedPersonBean;
import ca.infoway.messagebuilder.model.mock.AuthorBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MockTestCaseMessageDefinitionService;

public class Hl7SourceMapperChoiceTest {
	
	private static final String XML = "<author typeCode=\"AUT\" contextControlCode=\"AP\" xmlns=\"urn:hl7-org:v3\" >" +
			"  <time value=\"20080918181800\"/>" +
			"  <assignedEntity1 classCode=\"ASSIGNED\">" +
			"    <id extension=\"EHR ID EXT\" root=\"2.16.840.1.113883.4.267\" displayable=\"true\"/>" +
			"    <assignedPerson classCode=\"PSN\" determinerCode=\"INSTANCE\">" +
			"      <name use=\"L\"><given>Jane</given><family>Doe</family></name>" +
			"      <asHealthCareProvider classCode=\"PROV\">" +
			"        <id extension=\"55555\" root=\"2.16.840.1.113883.4.268\" displayable=\"true\" />" +
			"      </asHealthCareProvider>" +
			"    </assignedPerson>" +
			"  </assignedEntity1>" +
			"</author>";
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
		Hl7MessageSource rootSource = new Hl7MessageSource(MOCK_NEWFOUNDLAND, document, null, this.service);
		this.element = document.getDocumentElement();
		this.partSource = rootSource.createPartSource(createRelationship("MFMI_MT700711CA.Author"), element);
	}
	private Relationship createRelationship(String type) {
		Relationship relationship = new Relationship();
		relationship.setType(type);
		return relationship;
	}

	@Test
	public void shouldMapPatientChoice() throws Exception {
		AuthorBean  teal = (AuthorBean) new Hl7SourceMapper().mapPartSourceToTeal(this.partSource, null);
		assertNotNull("teal", teal);
		assertNotNull("patient", teal.getAuthorPerson());
		assertTrue("patient type", teal.getAuthorPerson() instanceof AssignedPersonBean);
	}

	private Document getSourceDocument() throws Exception {
		return new DocumentFactory().createFromString(XML);
	}
}
