/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

/**
 */
public class MessageSetMarshallerTest {

	private MessageSetMarshaller marshaller;

	@Before
	public void setUp() throws Exception {
		this.marshaller = new MessageSetMarshaller();
	}
	
	@Test
	public void testShouldReadSampleXmlWithBreadcrumbHistory() throws Exception {
		MessageSet testset = getMessageSet("sample_with_breadcrumbs.xml");
		assertTrue(testset.getRemixHistory().size() > 0);
		assertEquals(testset.getRemixHistory().get(0).getValue(), "R02_04_02");
	}
	
	@Test
	public void testShouldReadSampleXml() throws Exception {
		MessageSet set = getMessageSet("sample.xml");
		assertNotNull("set", set);
		assertEquals("number of parts", 2, set.getPackageLocations().get("COCT_MT470002CA").getMessageParts().size());
		assertEquals("cardinality", new Cardinality(1, 1), set.getMessagePart("COCT_MT470002CA.ActDefinition").getRelationships().get(0).getCardinality());
	}

	@Test
	public void testShouldReadSampleXmlWithArgumentChoices() throws Exception {
		MessageSet set = getMessageSet("sample_with_argument_choices.xml");
		assertNotNull("set", set);
	}
	
	@Test
	public void testWriteXml() throws Exception {
		MessageSet set = new MessageSet();
		Interaction interaction = new Interaction();
		interaction.setName("ABCD_IN000001CA");
		interaction.setSuperTypeName("MCCI_IN002100CA.Message");
		set.getInteractions().put("ABCD_IN000001CA", interaction);

		MessageSet newSet = marshallAndUnmarshall(set);
		
		assertEquals("interactions", set.getInteractions().size(), newSet.getInteractions().size());
	}

	@Test
	public void testWriteXmlWithNesting() throws Exception {
		MessageSet set = new MessageSet();
		Interaction interaction = new Interaction();
		interaction.setName("ABCD_IN000001CA");
		interaction.setSuperTypeName("MCCI_IN002100CA.Message");
		Argument triggerEvent = new Argument();
		triggerEvent.setName("REPC_MT123456CA.ControlActEvent");
		Argument payload = new Argument();
		payload.setName("REPC_MT123456CA.Payload");
		triggerEvent.getArguments().add(payload);
		interaction.getArguments().add(triggerEvent);
		set.getInteractions().put("ABCD_IN000001CA", interaction);
		
		MessageSet newSet = marshallAndUnmarshall(set);
		
		assertEquals("interactions", set.getInteractions().size(), newSet.getInteractions().size());
	}
	
	private MessageSet marshallAndUnmarshall(MessageSet set) throws Exception {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		this.marshaller.marshall(set, output);
		
		byte[] b = output.toByteArray();
		System.out.println(new String(b));
		
		return this.marshaller.unmarshall(new ByteArrayInputStream(b));
	}

	private MessageSet getMessageSet(String xml) throws Exception {
		InputStream input = getClass().getResourceAsStream(xml);
		try {
			return this.marshaller.unmarshall(input);
		} finally {
			IOUtils.closeQuietly(input);
		}
	}
}
