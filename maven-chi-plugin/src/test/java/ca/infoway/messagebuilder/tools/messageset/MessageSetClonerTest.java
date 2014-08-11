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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.tools.messageset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.junit.XmlAssert;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.CodeSystem;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.ValueSet;
import ca.infoway.messagebuilder.xml.delta.RealmCode;



public class MessageSetClonerTest {

	@Test
	public void shouldGetTheRightNumberOfItems() throws Exception {
		MessageSet messageSet = readMessageSet("/messageSet_r02_04_02.xml");
		MessageSet clone = new MessageSetCloner().clone(messageSet, RealmCode.from("CA"));

		assertEquals("number of packages", messageSet.getPackageLocations().size(), clone.getPackageLocations().size());
		assertEquals("number of interactions", messageSet.getInteractions().size(), clone.getInteractions().size());
	}

	@Test
	public void shouldHaveStatusInValueSetsAndConcepts() throws Exception {
		MessageSet messageSet = readMessageSet("/messageSet_r02_04_02.xml");
		MessageSet clone = new MessageSetCloner().clone(messageSet, RealmCode.from("CA"));

		// for this test, status only placed on AdministrativeGender (for valuesets) and AcknolwedgmentCondition (for code system concepts)
		
		assertFalse(clone.getVocabulary().getValueSets().isEmpty());
		ValueSet valueSet = clone.getVocabulary().getValueSets().get(0);
		assertEquals("AdministrativeGender", valueSet.getName());
		assertEquals("active", valueSet.getCodes().get(0).getStatus());
		
		assertFalse(clone.getVocabulary().getCodeSystems().isEmpty());
		CodeSystem codeSystem = clone.getVocabulary().getCodeSystems().get(0);
		assertEquals("AcknowledgementCondition", codeSystem.getName());
		assertEquals("active", codeSystem.getConcepts().get(0).getStatus());
	}

	@Test
	public void shouldCloneAllNodes() throws Exception {
		MessageSet original = readMessageSet("/messageSet_v01_r04_3_hotfix3.xml");
		MessageSet clone = new MessageSetCloner().clone(original, RealmCode.from("CA"));
		Document document = toDocument(original);

		Document document2 = toDocument(clone);
		XmlAssert.assertTreeEquals(document, document2);
	}

	@Test
	public void shouldUpdateRealmCodeInInteractions() throws Exception {
		MessageSet original = readMessageSet("/messageSet_r02_04_02.xml");
		MessageSet clone = new MessageSetCloner().clone(original, RealmCode.from("ON"));

		assertNull("CA", clone.getInteractions().get("PRPA_IN101103CA"));
		Interaction findCandidates = clone.getInteractions().get("PRPA_IN101103ON");
		assertNotNull("ON", findCandidates);
		assertEquals("base type", "MCCI_MT002100ON.Message", findCandidates.getSuperTypeName());
		assertEquals("control act", "MFMI_MT700751ON.ControlActEvent", findCandidates.getArguments().get(0).getName());
		assertEquals("paylod", "PRPA_MT101103ON.ParameterList", 
				findCandidates.getArguments().get(0).getArguments().get(0).getName());
		assertEquals("trigger event", "PRPA_TE101103CA", findCandidates.getTriggerEvent());	// trigger events don't get updated -- JR 20130501
	}
	
	@Test
	public void shouldUpdateRealmCodeInMessageParts() throws Exception {
		MessageSet original = readMessageSet("/messageSet_r02_04_02.xml");
		MessageSet clone = new MessageSetCloner().clone(original, RealmCode.from("ON"));
		
		assertNull("CA", clone.getPackageLocations().get("PRPA_MT101103CA"));
		PackageLocation findCandidates = clone.getPackageLocations().get("PRPA_MT101103ON");
		assertNotNull("ON", findCandidates);
		assertEquals("root type", "PRPA_MT101103ON.ParameterList", findCandidates.getRootType());
		MessagePart messagePart = clone.getMessagePart(findCandidates.getRootType());
		assertNotNull("message part", messagePart);
		assertEquals("message part", "PRPA_MT101103ON.ParameterList", messagePart.getName());
	}
	
	@Test
	public void shouldUpdateRealmCodeInSpecializationChilds() throws Exception {
		MessageSet original = readMessageSet("/messageSet_r02_04_02.xml");
		MessageSet clone = new MessageSetCloner().clone(original, RealmCode.from("ON"));
		
		MessagePart messagePart = clone.getMessagePart("COCT_MT011001ON.Assignees");
		assertNotNull("ON", messagePart);
		
		assertEquals("childs", 2, messagePart.getSpecializationChilds().size());
		assertEquals("child 1 type", "COCT_MT090102ON.AssignedEntity", messagePart.getSpecializationChilds().get(0).getName());
		assertEquals("child 2 type", "COCT_MT090502ON.AssignedEntity", messagePart.getSpecializationChilds().get(1).getName());
	}
	
	private Document toDocument(MessageSet clone) throws Exception, SAXException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		new MessageSetMarshaller().marshall(clone, output);

		Document document2 = new DocumentFactory().createFromByteArray(output.toByteArray());
		return document2;
	}

	private MessageSet readMessageSet(String string) throws Exception {
		InputStream input = getClass().getResourceAsStream(string);
		try {
			return new MessageSetMarshaller().unmarshall(input);
		} finally {
			IOUtils.closeQuietly(input);
		}
	}
}
