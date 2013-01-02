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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.EN;
import ca.infoway.messagebuilder.datatype.impl.ENImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class ListEnPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new ListPropertyFormatter().format(
				new FormatContextImpl(new ModelToXmlResult(), null, "name", "LIST<EN>", ConformanceLevel.OPTIONAL), 
				new LISTImpl<EN<EntityName>, EntityName>(ENImpl.class));
		assertXml("null", "", result);
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		String result = new ListPropertyFormatter().format(
				new FormatContextImpl(new ModelToXmlResult(), null, "name", "LIST<EN>", ConformanceLevel.OPTIONAL, false, SpecificationVersion.R02_04_02, null, null, null), 
				(BareANY) LISTImpl.<EN<EntityName>, EntityName>create(ENImpl.class, createEntityNameList()));
		assertEquals("non null", "<name><family>Flinstone</family><given>Fred</given></name>" + LINE_SEPARATOR + 
								 "<name><family>Flinstone</family><given>Wilma</given></name>" + LINE_SEPARATOR, result);
	}

	private List<EntityName> createEntityNameList() {
		ArrayList<EntityName> result = new ArrayList<EntityName>();
		EntityName fred = createEntityName("Flinstone", "Fred");
		EntityName wilma = createEntityName("Flinstone", "Wilma");
		result.add(fred);
		result.add(wilma);
		return result;
	}

	private EntityName createEntityName(String familiyName, String givenName) {
		EntityName personName = new PersonName();
		List<EntityNamePart> parts = personName.getParts();
		parts.add(new EntityNamePart(familiyName, PersonNamePartType.FAMILY));
		parts.add(new EntityNamePart(givenName, PersonNamePartType.GIVEN));
		return personName;
	}
}
