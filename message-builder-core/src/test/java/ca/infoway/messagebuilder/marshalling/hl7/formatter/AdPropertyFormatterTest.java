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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType;
import ca.infoway.messagebuilder.domainvalue.basic.X_BasicPostalAddressUse;
import ca.infoway.messagebuilder.platform.CodeUtil;

public class AdPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new AdPropertyFormatter().format(getContext("addr", "AD.FULL"), new ADImpl());
		assertTrue(this.result.isValid());
        assertEquals("named null format", "<addr nullFlavor=\"NI\"/>", result.trim());
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		AdPropertyFormatter formatter = new AdPropertyFormatter();
		PostalAddress postalAddress = new PostalAddress();
		postalAddress.addPostalAddressPart(new PostalAddressPart("something"));
		String result = formatter.format(getContext("addr", "AD.FULL"), new ADImpl(postalAddress));
		assertFalse(this.result.isValid());
		assertEquals(5, this.result.getHl7Errors().size()); // city/state/postalcode/country are mandatory; part without types not allowed 
		assertEquals("empty address node node", "<addr></addr>", result.trim());
	}

	@Test
	public void testFormatValueReservedXmlChars() throws Exception{
		AdPropertyFormatter formatter = new AdPropertyFormatter();
		PostalAddress address = new PostalAddress();
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "<cats think they're > humans & dogs 99% of the time/>"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "ON"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.POSTAL_CODE, "H0H0H0"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, "Canada"));
        
		String result = formatter.format(getContext("addr", "AD.FULL"), new ADImpl(address));
		assertTrue(this.result.isValid());
		assertEquals("something in text node", "<addr><city>&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</city><state>ON</state><postalCode>H0H0H0</postalCode><country>Canada</country></addr>".trim(), result.trim());
	}
	
	@Test
    public void testFormatValueNonNullMultipleAddressParts() throws Exception {
		AdPropertyFormatter formatter = new AdPropertyFormatter();
        
		PostalAddress postalAddress = new PostalAddress();
		postalAddress.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "cityname"));
		postalAddress.addPostalAddressPart(new PostalAddressPart("freeform"));
		postalAddress.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.DELIMITER, ","));
		postalAddress.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "ON"));
		String result = formatter.format(getContext("addr", "AD.FULL"), new ADImpl(postalAddress));
		assertFalse(this.result.isValid());
		assertEquals(4, this.result.getHl7Errors().size()); // no parts without part type; delimiter not allowed; postal code and country mandatory
        assertEquals("something in text node with goofy sub nodes suppressed", "<addr><city>cityname</city><state>ON</state></addr>", result.trim());
    }

	@Test
    public void testFormatPostalAddressUses() throws Exception {
    	AdPropertyFormatter formatter = new AdPropertyFormatter();
        
        PostalAddress address = new PostalAddress();
        address.addUse(X_BasicPostalAddressUse.HOME);
        address.addUse(X_BasicPostalAddressUse.PHYSICAL);
        
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "Toronto"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "ON"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.POSTAL_CODE, "H0H0H0"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, "Canada"));

        // since the uses as a set, order is not guaranteed
        String result = formatter.format(getContext("addr", "AD.FULL"), new ADImpl(address));
		assertTrue(this.result.isValid());
        assertTrue("open tag", result.startsWith("<addr use=\""));
        assertTrue("H PHYS", result.contains("\"H PHYS\"") || result.contains("\"H PHYS\""));
    }
	
	@Test
    public void testFormatTooManyPostalAddressUses() throws Exception {
    	AdPropertyFormatter formatter = new AdPropertyFormatter();
        
        PostalAddress address = new PostalAddress();
        address.addUse(X_BasicPostalAddressUse.HOME);
        address.addUse(X_BasicPostalAddressUse.PHYSICAL);
        address.addUse(X_BasicPostalAddressUse.DIRECT);
        address.addUse(X_BasicPostalAddressUse.CONFIDENTIAL);
        
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "Toronto"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "ON"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.POSTAL_CODE, "H0H0H0"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, "Canada"));

        String result = formatter.format(getContext("addr", "AD.FULL"), new ADImpl(address));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
        assertTrue("open tag", result.startsWith("<addr use=\""));
        assertTrue(result.contains("\"H PHYS DIR CONF\""));
    }
	
	@Test
    public void testFormatNoDuplicatePartTypes() throws Exception {
    	AdPropertyFormatter formatter = new AdPropertyFormatter();
        
        PostalAddress address = new PostalAddress();
        address.addUse(X_BasicPostalAddressUse.HOME);
        
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "Toronto"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "ON"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.POSTAL_CODE, "H0H0H0"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, "Canada"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, "US"));

        formatter.format(getContext("addr", "AD.FULL"), new ADImpl(address));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
    }
	
	@Test
    public void testFormatInvalidUseOfCodeAndCodeSystem() throws Exception {
    	AdPropertyFormatter formatter = new AdPropertyFormatter();
        
        PostalAddress address = new PostalAddress();
        address.addUse(X_BasicPostalAddressUse.HOME);
        
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, CodeUtil.convertToCode("Toronto", "1.2.3.4.5")));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "ON"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.POSTAL_CODE, "H0H0H0"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, "Canada"));

        formatter.format(getContext("addr", "AD.FULL"), new ADImpl(address));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
    }
	
	@Test
    public void testFormatValueTooLong() throws Exception {
    	AdPropertyFormatter formatter = new AdPropertyFormatter();
        
        PostalAddress address = new PostalAddress();
        address.addUse(X_BasicPostalAddressUse.HOME);
        
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY,  "12345678901234567890123456789012345678901234567890123456789012345678901234567890"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "123456789012345678901234567890123456789012345678901234567890123456789012345678901"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.POSTAL_CODE, "H0H0H0"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, "Canada"));

        formatter.format(getContext("addr", "AD.FULL"), new ADImpl(address));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
    }
	
	@Test
    public void testFormatInvalidPartTypeForFull() throws Exception {
    	AdPropertyFormatter formatter = new AdPropertyFormatter();
        
        PostalAddress address = new PostalAddress();
        address.addUse(X_BasicPostalAddressUse.HOME);
        
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.DELIVERY_INSTALLATION_TYPE, "this isn't allowed"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "Toronto"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "ON"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.POSTAL_CODE, "H0H0H0"));
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, "Canada"));

        formatter.format(getContext("addr", "AD.FULL"), new ADImpl(address));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
    }
	
	@Test
    public void testFormatValidSearch() throws Exception {
    	AdPropertyFormatter formatter = new AdPropertyFormatter();
        
        PostalAddress address = new PostalAddress();
        
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "Toronto"));
        
        String formattedAddress = formatter.format(getContext("addr", "AD.SEARCH"), new ADImpl(address));
		assertTrue(this.result.isValid());
		assertEquals("<addr><city>Toronto</city></addr>", formattedAddress.trim());
    }
	
	@Test
    public void testFormatSearchMustHaveAtLeastOnePartType() throws Exception {
    	AdPropertyFormatter formatter = new AdPropertyFormatter();
        
        PostalAddress address = new PostalAddress();
        
        formatter.format(getContext("addr", "AD.SEARCH"), new ADImpl(address));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
    }
	
	@Test
    public void testFormatSearchCannotHaveUses() throws Exception {
    	AdPropertyFormatter formatter = new AdPropertyFormatter();
        
        PostalAddress address = new PostalAddress();
        address.addUse(X_BasicPostalAddressUse.HOME);
                
        address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "Toronto"));
        
        String formattedAddress = formatter.format(getContext("addr", "AD.SEARCH"), new ADImpl(address));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals("<addr><city>Toronto</city></addr>", formattedAddress.trim());
    }
	
}
