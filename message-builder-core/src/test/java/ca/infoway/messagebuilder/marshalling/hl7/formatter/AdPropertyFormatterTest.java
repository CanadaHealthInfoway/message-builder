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
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPartType;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressUse;

public class AdPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new AdPropertyFormatter().format(getContext("addr"), new ADImpl());
        assertEquals("named null format", "<addr nullFlavor=\"NI\"/>", result.trim());
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		AdPropertyFormatter formatter = new AdPropertyFormatter();
		PostalAddress postalAddress = new PostalAddress();
		postalAddress.addPostalAddressPart(new PostalAddressPart("something"));
		String result = formatter.format(getContext("addr"), new ADImpl(postalAddress));
		assertEquals("something in text node", "<addr>something</addr>", result.trim());
	}

	@Test
	public void testFormatValueReservedXmlChars() throws Exception{
		AdPropertyFormatter formatter = new AdPropertyFormatter();
		PostalAddress postalAddress = new PostalAddress();
		postalAddress.addPostalAddressPart(new PostalAddressPart("<cats think they're > humans & dogs 99% of the time/>"));
		String result = formatter.format(getContext("addr"), new ADImpl(postalAddress));
		assertEquals("something in text node", "<addr>&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</addr>".trim(), result.trim());
	}
	
	@Test
    public void testFormatValueNonNullMultipleAddressParts() throws Exception {
		AdPropertyFormatter formatter = new AdPropertyFormatter();
        
		PostalAddress postalAddress = new PostalAddress();
		postalAddress.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "cityname"));
		postalAddress.addPostalAddressPart(new PostalAddressPart("freeform"));
		postalAddress.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.DELIMITER, ","));
		postalAddress.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "ON"));
		String result = formatter.format(getContext("addr"), new ADImpl(postalAddress));
        assertEquals("something in text node with goofy sub nodes", "<addr><city>cityname</city>freeform<delimiter>,</delimiter><state>ON</state></addr>", result.trim());
    }

	@Test
    public void testFormatPostalAddressUses() throws Exception {
    	AdPropertyFormatter formatter = new AdPropertyFormatter();
        
        PostalAddress address = new PostalAddress();
        address.addUse(PostalAddressUse.HOME);
        address.addUse(PostalAddressUse.PUBLIC);

        // since the uses as a set, order is not guaranteed
        String result = formatter.format(getContext("addr"), new ADImpl(address));
        assertTrue("open tag", result.startsWith("<addr use=\""));
        assertTrue("H PUB", result.contains("H PUB") || result.contains("PUB H"));
        assertTrue("close tag", result.trim().endsWith("\"></addr>"));
    }
	
}
