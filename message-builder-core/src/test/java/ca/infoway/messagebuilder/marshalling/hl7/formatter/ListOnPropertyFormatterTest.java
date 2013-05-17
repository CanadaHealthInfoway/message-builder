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

import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;
import static ca.infoway.messagebuilder.xml.ConformanceLevel.OPTIONAL;
import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.ON;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.ONImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.OrganizationName;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class ListOnPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new ListPropertyFormatter().format(
				new FormatContextImpl(new ModelToXmlResult(), null, "name", "LIST<ON>", OPTIONAL, null), 
				new LISTImpl<ON, OrganizationName>(ONImpl.class));
		assertXml("null", "", result);
	}

	@Test
    public void testFormatValueNullMandatory() throws Exception {
        String result = new ListPropertyFormatter().format(
        		new FormatContextImpl(new ModelToXmlResult(), null, "blah", "LIST<ON>", ConformanceLevel.MANDATORY, null), 
				(BareANY) new LISTImpl<ON, OrganizationName>(ONImpl.class, NullFlavor.NO_INFORMATION));
        assertXml("null", "<blah nullFlavor=\"NI\"/>", result);
    }
    
	@Test
	public void testFormatValueNonNull() throws Exception {
		String result = new ListPropertyFormatter().format(
				new FormatContextImpl(new ModelToXmlResult(), null, "name", "LIST<ON>", MANDATORY, Cardinality.create("1-4")),
				LISTImpl.<ON, OrganizationName>create(ONImpl.class, createOrganizationNameList()));
		
		assertEquals("non null", 
				"<name>Organization 1</name>" + LINE_SEPARATOR + "<name>Organization 2</name>" + LINE_SEPARATOR, 
				result);
	}

	private List<OrganizationName> createOrganizationNameList() {
		ArrayList<OrganizationName> result = new ArrayList<OrganizationName>();
		result.add(createOrganizationName("Organization 1"));
		result.add(createOrganizationName("Organization 2"));
		return result;
	}

	private OrganizationName createOrganizationName(String name) {
		OrganizationName organizationName = new OrganizationName();
		List<EntityNamePart> parts = organizationName.getParts();
		parts.add(new EntityNamePart(name));
		return organizationName;
	}
}
