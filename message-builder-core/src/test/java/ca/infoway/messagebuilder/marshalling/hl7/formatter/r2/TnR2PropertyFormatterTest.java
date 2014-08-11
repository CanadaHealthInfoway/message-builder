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
 * Last modified: $LastChangedDate: 2014-02-14 11:22:06 -0500 (Fri, 14 Feb 2014) $
 * Revision:      $LastChangedRevision: 8399 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.ENImpl;
import ca.infoway.messagebuilder.datatype.impl.TNImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.basic.EntityNamePartQualifier;
import ca.infoway.messagebuilder.domainvalue.basic.EntityNameUse;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;

public class TnR2PropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new EnR2PropertyFormatter().format(getContext("name", "TN"), new TNImpl());

		assertTrue(this.result.isValid());
        assertEquals("named null format", "<name nullFlavor=\"NI\"/>", result.trim());
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
		
		String result = formatter.format(getContext("name", "TN"), new TNImpl(new TrivialName("something")));
		
		assertTrue(this.result.isValid());
		assertXml("something in text node", "<name>something</name>", result, true);
	}

	@Test
	public void testFormatValueNonNullInvalidPart() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
		
		TrivialName trivialName = new TrivialName();
		trivialName.addNamePart(new EntityNamePart("something", PersonNamePartType.FAMILY));
		String result = formatter.format(getContext("name", "TN"), new TNImpl(trivialName));
		
        assertFalse(this.result.isValid());
        assertEquals(1, this.result.getHl7Errors().size());
		assertXml("something in text node", "<name><family>something</family></name>", result, true);
	}

	@Test
	public void testFormatValueNonNullInvalidQualifer() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
		
		TrivialName trivialName = new TrivialName();
		trivialName.addNamePart(new EntityNamePart("something", null, EntityNamePartQualifier.INITIAL));
		String result = formatter.format(getContext("name", "TN"), new TNImpl(trivialName));
		
        assertFalse(this.result.isValid());
        assertEquals(1, this.result.getHl7Errors().size());
		assertXml("something in text node", "<name>something</name>", result, true);
	}

	@Test
	public void testFormatValueNonNullWithValidTime() throws Exception {
		Date lowDate = new DateWithPattern(DateUtil.getDate(2006, 11, 25), "yyyyMMdd");
		Date highDate = new DateWithPattern(DateUtil.getDate(2014, 3, 12), "yyyyMMdd");
		Interval<Date> validTime = IntervalFactory.createLowHigh(lowDate, highDate);
		
		EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
		
		TrivialName trivialName = new TrivialName("something");
		trivialName.setValidTime(validTime);
		
		String result = formatter.format(getContext("name", "TN"), new TNImpl(trivialName));
		
		assertTrue(this.result.isValid());
		assertXml("something in text node", "<name>something<validTime><low value=\"20061225\"/><high value=\"20140412\"/></validTime></name>", result, true);
	}

	@Test
	public void testFormatValueReservedXmlChars() throws Exception{
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
		
		TrivialName trivialName = new TrivialName("<cats think they're > humans & dogs 99% of the time/>");
		String result = formatter.format(getContext("name", "TN"), new TNImpl(trivialName));
		
		assertTrue(this.result.isValid());
		assertXml("something in text node", "<name>&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</name>", result, true);
	}
	
	@Test
    public void testFormatInvalidNameUses() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
        
        EntityName name = new TrivialName("something");
        name.addUse(EntityNameUse.ALPHABETIC);
        name.addUse(EntityNameUse.IDEOGRAPHIC);

        String result = formatter.format(getContext("name", "TN"), new ENImpl<EntityName>(name));

        assertFalse(this.result.isValid());
        assertEquals(1, this.result.getHl7Errors().size());
		assertXml("something in text node", "<name use=\"ABC IDE\">something</name>", result, true);
    }
}
