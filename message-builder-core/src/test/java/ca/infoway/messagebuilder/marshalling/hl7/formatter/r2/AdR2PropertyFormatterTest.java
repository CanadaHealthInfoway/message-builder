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

import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern;
import ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.basic.X_BasicPostalAddressUse;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;

public class AdR2PropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new AdR2PropertyFormatter().format(getContext("addr", "AD"), new ADImpl());
		assertTrue(this.result.isValid());
        assertEquals("named null format", "<addr nullFlavor=\"NI\"/>", result.trim());
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		AdR2PropertyFormatter formatter = new AdR2PropertyFormatter();
		PostalAddress postalAddress = new PostalAddress();
		postalAddress.addPostalAddressPart(new PostalAddressPart("something"));
		String result = formatter.format(getContext("addr", "AD"), new ADImpl(postalAddress));
		assertTrue(this.result.isValid());
		assertXml("empty address node", "<addr>something</addr>", result, true);
	}

	@Test
	public void testFormatValueReservedXmlChars() throws Exception{
		AdR2PropertyFormatter formatter = new AdR2PropertyFormatter();
		PostalAddress address = new PostalAddress();
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "<cats think they're > humans & dogs 99% of the time/>"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "ON"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.POSTAL_CODE, "H0H0H0"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, "Canada"));
        
		String result = formatter.format(getContext("addr", "AD"), new ADImpl(address));
		assertTrue(this.result.isValid());
		assertXml("something in text node", "<addr><city>&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</city><state>ON</state><postalCode>H0H0H0</postalCode><country>Canada</country></addr>", result, true);
	}
	
	@Test
    public void testFormatValueNonNullMultipleAddressParts() throws Exception {
		AdR2PropertyFormatter formatter = new AdR2PropertyFormatter();
        
		PostalAddress postalAddress = new PostalAddress();
		postalAddress.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "cityname"));
		postalAddress.addPostalAddressPart(new PostalAddressPart("freeform"));
		postalAddress.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.DELIMITER, ","));
		postalAddress.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "ON"));
		String result = formatter.format(getContext("addr", "AD"), new ADImpl(postalAddress));
		assertTrue(this.result.isValid());
        assertXml("something in text node with goofy sub nodes allowed", "<addr><city>cityname</city>freeform<delimiter>,</delimiter><state>ON</state></addr>", result, true);
    }

	@Test
    public void testFormatValueNonNullMultipleAddressPartsWithUseablePeriods() throws Exception {
		AdR2PropertyFormatter formatter = new AdR2PropertyFormatter();
        
		PostalAddress postalAddress = new PostalAddress();
		postalAddress.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "cityname"));
		postalAddress.addPostalAddressPart(new PostalAddressPart("freeform"));
		postalAddress.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.DELIMITER, ","));
		postalAddress.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "ON"));
		postalAddress.setIsNotOrdered(true);
		postalAddress.addUseablePeriod(new DateWithPattern(DateUtil.getDate(2007, 2, 23), "yyyyMMdd"), SetOperator.PERIODIC_HULL);
		postalAddress.addUseablePeriod(new DateWithPattern(DateUtil.getDate(2009, 9, 17), "yyyyMMdd"), null);
		postalAddress.addUseablePeriod(new DateWithPattern(DateUtil.getDate(2014, 6, 8), "yyyyMMdd"), SetOperator.INCLUDE);
		
		String result = formatter.format(getContext("addr", "AD"), new ADImpl(postalAddress));
		assertTrue(this.result.isValid());
        assertXml("addr with useable periods", "<addr isNotOrdered=\"true\"><city>cityname</city>freeform<delimiter>,</delimiter><state>ON</state><useablePeriod operator=\"P\" value=\"20070323\"/><useablePeriod operator=\"I\" value=\"20091017\"/><useablePeriod operator=\"I\" value=\"20140708\"/></addr>", result, true);
    }

	@Test
    public void testFormatPostalAddressUses() throws Exception {
    	AdR2PropertyFormatter formatter = new AdR2PropertyFormatter();
        
        PostalAddress address = new PostalAddress();
        address.addUse(X_BasicPostalAddressUse.HOME);
        address.addUse(X_BasicPostalAddressUse.PHYSICAL);
        
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "Toronto"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "ON"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.POSTAL_CODE, "H0H0H0"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, "Canada"));

        // since the uses as a set, order is not guaranteed
        String result = formatter.format(getContext("addr", "AD"), new ADImpl(address));
		assertTrue(this.result.isValid());
        assertTrue("open tag", result.startsWith("<addr use=\""));
        assertTrue("H PHYS", result.contains("\"H PHYS\"") || result.contains("\"H PHYS\""));
    }
	
	@Test
    public void testFormatManyPostalAddressUses() throws Exception {
    	AdR2PropertyFormatter formatter = new AdR2PropertyFormatter();
        
        PostalAddress address = new PostalAddress();
        address.addUse(X_BasicPostalAddressUse.HOME);
        address.addUse(X_BasicPostalAddressUse.PHYSICAL);
        address.addUse(X_BasicPostalAddressUse.DIRECT);
        address.addUse(X_BasicPostalAddressUse.CONFIDENTIAL);
        
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "Toronto"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "ON"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.POSTAL_CODE, "H0H0H0"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, "Canada"));

        String result = formatter.format(getContext("addr", "AD"), new ADImpl(address));
		assertTrue(this.result.isValid());
        assertTrue("open tag", result.startsWith("<addr use=\""));
        assertTrue(result.contains("\"H PHYS DIR CONF\""));
        assertXml("xml as expected", "<addr use=\"H PHYS DIR CONF\"><city>Toronto</city><state>ON</state><postalCode>H0H0H0</postalCode><country>Canada</country></addr>", result, true);
    }
	
	@Test
    public void testFormatDuplicatePartTypesAllowed() throws Exception {
		
		// confirmed via Sam that all part types can occur multiple times
		
    	AdR2PropertyFormatter formatter = new AdR2PropertyFormatter();
        
        PostalAddress address = new PostalAddress();
        address.addUse(X_BasicPostalAddressUse.HOME);
        
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "Toronto"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "ON"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.POSTAL_CODE, "H0H0H0"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, "Canada"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, "US"));

        formatter.format(getContext("addr", "AD"), new ADImpl(address));
		assertTrue(this.result.isValid());
    }
	
	@Test
    public void testFormatWeirdUseOfCodeAndCodeSystem() throws Exception {
    	AdR2PropertyFormatter formatter = new AdR2PropertyFormatter();
        
        PostalAddress address = new PostalAddress();
        address.addUse(X_BasicPostalAddressUse.HOME);
        
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "Toronto"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "ON"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.POSTAL_CODE, "H0H0H0"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, "Canada"));

        String result = formatter.format(getContext("addr", "AD"), new ADImpl(address));
		assertTrue(this.result.isValid());
        assertXml("xml as expected", "<addr use=\"H\"><city>Toronto</city><state>ON</state><postalCode>H0H0H0</postalCode><country>Canada</country></addr>", result, true);
    }
	
	@Test
    public void testFormatLongValue() throws Exception {
    	AdR2PropertyFormatter formatter = new AdR2PropertyFormatter();
        
        PostalAddress address = new PostalAddress();
        address.addUse(X_BasicPostalAddressUse.HOME);
        
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY,  "12345678901234567890123456789012345678901234567890123456789012345678901234567890"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "123456789012345678901234567890123456789012345678901234567890123456789012345678901"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.POSTAL_CODE, "H0H0H0"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, "Canada"));

        String result = formatter.format(getContext("addr", "AD"), new ADImpl(address));
		assertTrue(this.result.isValid());
        assertXml("xml as expected", "<addr use=\"H\"><city>12345678901234567890123456789012345678901234567890123456789012345678901234567890</city><state>123456789012345678901234567890123456789012345678901234567890123456789012345678901</state><postalCode>H0H0H0</postalCode><country>Canada</country></addr>", result, true);
    }
	
	@Test
    public void testFormatAddressUnusualPartType() throws Exception {
    	AdR2PropertyFormatter formatter = new AdR2PropertyFormatter();
        
        PostalAddress address = new PostalAddress();
        address.addUse(X_BasicPostalAddressUse.HOME);
        
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.DELIVERY_INSTALLATION_TYPE, "this is unusual"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "Toronto"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "ON"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.POSTAL_CODE, "H0H0H0"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, "Canada"));

        String result = formatter.format(getContext("addr", "AD"), new ADImpl(address));
		assertTrue(this.result.isValid());
        assertXml("xml as expected", "<addr use=\"H\"><deliveryInstallationType>this is unusual</deliveryInstallationType><city>Toronto</city><state>ON</state><postalCode>H0H0H0</postalCode><country>Canada</country></addr>", result, true);
    }
	
}
