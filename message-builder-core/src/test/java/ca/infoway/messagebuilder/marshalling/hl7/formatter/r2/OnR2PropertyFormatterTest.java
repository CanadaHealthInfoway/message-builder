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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.ONImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.OrganizationName;
import ca.infoway.messagebuilder.datatype.lang.util.OrganizationNamePartType;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;

public class OnR2PropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new EnR2PropertyFormatter().format(getContext("name", "ON"), new ONImpl(null));
        assertEquals("named null format", "<name nullFlavor=\"NI\"/>", result.trim());
	}
	
	@Test
    public void testFormatValueNonNull() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
        
        OrganizationName organizationName = new OrganizationName();
        organizationName.addNamePart(new EntityNamePart("Organization"));
        
        String result = formatter.format(getContext("name", "ON"), new ONImpl(organizationName));
        assertTrue(this.result.isValid());
        assertXml("something in text node", "<name>Organization</name>", result, true);
    }

	@Test
    public void testFormatValueNonNullMultipleNameParts() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
        
        OrganizationName organizationName = new OrganizationName();
        organizationName.addNamePart(new EntityNamePart("prefix", OrganizationNamePartType.PREFIX));
        organizationName.addNamePart(new EntityNamePart("Organization"));
        organizationName.addNamePart(new EntityNamePart(",", OrganizationNamePartType.DELIMITER));
        organizationName.addNamePart(new EntityNamePart("Inc", OrganizationNamePartType.SUFFIX));
        
        String result = formatter.format(getContext("name", "ON"), new ONImpl(organizationName));
        assertTrue(this.result.isValid());
        assertXml("something in text node with goofy sub nodes", "<name><prefix>prefix</prefix>Organization<delimiter>,</delimiter><suffix>Inc</suffix></name>", result, true);
    }

	@Test
	public void testFormatValueReservedXmlChars() throws Exception{
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
		
        OrganizationName organizationName = new OrganizationName();
        organizationName.addNamePart(new EntityNamePart("<cats think they're > humans & dogs 99% of the time/>"));

        String result = formatter.format(getContext("name", "ON"), new ONImpl(organizationName));
        assertTrue(this.result.isValid());
		assertXml("something in text node", "<name>&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</name>", result, true);
	}
}
