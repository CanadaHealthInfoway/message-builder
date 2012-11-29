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

package ca.infoway.messagebuilder.marshalling.newfoundland.cr.v02r02;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.cr.FindCandidatesQueryMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cr.FindCandidatesQueryResponseMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class FindCandidatesTransformationTest extends BaseTransformerTestCase {
	
	private static final VersionNumber VERSION = BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK;

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
