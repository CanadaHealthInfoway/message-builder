/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import static ca.infoway.messagebuilder.datatype.lang.PostalAddressPartType.DELIMITER;
import static ca.infoway.messagebuilder.datatype.lang.PostalAddressPartType.HOUSE_NUMBER;
import static ca.infoway.messagebuilder.datatype.lang.PostalAddressPartType.UNIT_ID;
import static ca.infoway.messagebuilder.marshalling.WhitespaceUtil.normalizeWhitespace;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterAssert.assertContainsSame;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterAssert.toSet;
import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedString;
import ca.infoway.messagebuilder.datatype.lang.Country;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPartType;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressUse;
import ca.infoway.messagebuilder.domainvalue.basic.Iso3166Alpha2Country;
import ca.infoway.messagebuilder.domainvalue.basic.State;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class AdBasicPropertyFormatterTest extends FormatterTestCase {

	private PostalAddress address;
	private AdBasicPropertyFormatter formatter;

	@Before
	public void setUp() throws Exception {
		this.address = new PostalAddress();
		this.formatter = new AdBasicPropertyFormatter();
	}
	
	@Test
	public void testFormatValueNull() throws Exception {

		String result = this.formatter.format(getContext("name"), new ADImpl());
		
		String expectedResult = "<name nullFlavor=\"NI\"/>" + LINE_SEPARATOR;
		assertEquals("null name", expectedResult, result);
	}

	@Test
	public void testFormatEmptyAddress() throws Exception {
		AdBasicPropertyFormatter formatter = new AdBasicPropertyFormatter();
		String result = formatter.format(getContext("address"), new ADImpl(this.address));
		
		String expectedResult = "<address>" + LINE_SEPARATOR + "</address>" + LINE_SEPARATOR;
		assertXmlEquals("empty address", expectedResult, result);
		
		// a funny case: make sure adding a null address use is like not adding one at all
		// (i.e., just like above)
		this.address.addUse(null);
		assertXmlEquals("empty address - even with \"null\" address use", expectedResult, result);
		
		this.address.addUse(PostalAddressUse.WORK_PLACE);
		result = formatter.format(getContext("address"), new ADImpl(this.address) );
		expectedResult = "<address use=\"WP\">" + LINE_SEPARATOR + "</address>" + LINE_SEPARATOR;
		assertXmlEquals("empty workplace address", expectedResult, result);
		
		this.address.addUse(PostalAddressUse.HOME);
		result = formatter.format(getContext("address"), new ADImpl(this.address));
		Document document = new DocumentFactory().createFromString(result);
		String attribute = (document.getDocumentElement()).getAttribute("use");
		
		assertContainsSame("uses", toSet("H WP"), toSet(attribute));
	}

	@Test
	public void testFormatFreeformLines() throws Exception {
		AdBasicPropertyFormatter formatter = new AdBasicPropertyFormatter();
		this.address.addPostalAddressPart(new PostalAddressPart("address line one"));
		String result = formatter.format(getContext("address"), new ADImpl(this.address));
		
		String expectedResult = 
			  "<address>"
			+ "address line one"
			+ "</address>";
		
		assertXmlEquals("one freeform line", expectedResult, result);
		
		this.address.addPostalAddressPart(new PostalAddressPart("address line two"));
		result = formatter.format(getContext("address"), new ADImpl(this.address));
		
		expectedResult = 
			  "<address>"
			+ "address line one "
			+ "address line two"
			+ "</address>";
		
		assertXmlEquals("two freeform lines", expectedResult, result);
	}

	@Test
	public void testFormatCity() throws Exception {
		this.address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "Cityville"));
		String result = this.formatter.format(getContext("address"), new ADImpl(this.address));
		
		String expectedResult = 
			  "<address>" + LINE_SEPARATOR
			+ "  <city>Cityville</city>" + LINE_SEPARATOR 
			+ "</address>" + LINE_SEPARATOR;

		assertXmlEquals("city", expectedResult, result);
	}
	
	private void assertXmlEquals(String string, String expected, String actual) {
		assertEquals(string, normalizeWhitespace(expected), normalizeWhitespace(actual));
	}

	@Test
	public void testFormatProvince() throws Exception {
		this.address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "Ontario"));
		String result = this.formatter.format(getContext("address"), new ADImpl(this.address));
		
		String expectedResult = 
			  "<address>" + LINE_SEPARATOR
			+ "  <state>Ontario</state>" + LINE_SEPARATOR 
			+ "</address>" + LINE_SEPARATOR;

		assertXmlEquals("province", expectedResult, result);
	}

	@Test
	public void testFormatPostalCode() throws Exception {
		this.address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.POSTAL_CODE, "postalCodeValue"));
		String result = this.formatter.format(getContext("address"), new ADImpl(this.address));
		
		String expectedResult = 
			  "<address>" + LINE_SEPARATOR
			+ "  <postalCode>postalCodeValue</postalCode>" + LINE_SEPARATOR 
			+ "</address>" + LINE_SEPARATOR;

		assertXmlEquals("postal code", expectedResult, result);
	}
	
	@Test
	public void testNonTrivialDelimiter() throws Exception {
		addParts(new PostalAddressPartType[] {UNIT_ID, DELIMITER, 
				HOUSE_NUMBER, null},
				new String[] { "200", "-", "1709", "Bloor St. W." });
		
		String result = this.formatter.format(getContext("address"), new ADImpl(this.address));
		
		String expectedResult = 
			"<address>"
			+ "200 - 1709 Bloor St. W."
			+ "</address>";
		
		assertXmlEquals("postal code", expectedResult, result);
	}
	
	private void addParts(PostalAddressPartType[] type,
			String[] strings) {
		
		for (int i = 0; i < Math.max(type.length, strings.length); i++) {
			this.address.addPostalAddressPart(new PostalAddressPart(
					i < type.length ? type[i] : null,
					i < strings.length ? strings[i] : null));
		}
	}

	@Test
	public void testFormatCountryCode() throws Exception {
		this.address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, Country.CANADA));
		String result = this.formatter.format(getContext("address"), new ADImpl(this.address));
		
		String expectedResult = 
			  "<address>" + LINE_SEPARATOR
			+ "  <country code=\"Canada\">Canada</country>" + LINE_SEPARATOR 
			+ "</address>" + LINE_SEPARATOR;

		assertXmlEquals("country", expectedResult, result);
		
	}
	
	@Test
	public void testFormatCountryIsoCode() throws Exception {
		this.address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, Iso3166Alpha2Country.CANADA));
		String result = this.formatter.format(getContext("address"), new ADImpl(this.address));
		
		String expectedResult = 
			  "<address>" + LINE_SEPARATOR
				+ "  <country code=\"CA\">CA</country>" + LINE_SEPARATOR 
			+ "</address>" + LINE_SEPARATOR;

		assertXmlEquals("country", expectedResult, result);
	}
	
	@Test
	public void testFormatCountryAsCodedString() throws Exception {
		CodedString<Code> country = new CodedString<Code>("Canada", Iso3166Alpha2Country.CANADA);
		this.address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, country));
		String result = this.formatter.format(getContext("address"), new ADImpl(this.address));
		
		String expectedResult = 
			  "<address>" + LINE_SEPARATOR
				+ "  <country code=\"CA\">Canada</country>" + LINE_SEPARATOR 
			+ "</address>" + LINE_SEPARATOR;

		assertXmlEquals("country", expectedResult, result);
	}
	
	@Test
	public void testFormatAll() throws Exception {
		AdBasicPropertyFormatter formatter = new AdBasicPropertyFormatter();
		this.address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STREET_ADDRESS_LINE, "1 Yonge St."));
		this.address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STREET_ADDRESS_LINE, "1 Bloor St."));
		this.address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STREET_ADDRESS_LINE, "1 Spadina Ave."));
		this.address.addUse(PostalAddressUse.HOME);
		this.address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "Toronto"));
		this.address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, State.ONTARIO));
		this.address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.POSTAL_CODE, "postalCodeValue"));
		this.address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, Country.CANADA));
		this.address.addPostalAddressPart(new PostalAddressPart("freeformLine1"));
		this.address.addPostalAddressPart(new PostalAddressPart("freeformLine2"));
		String result = formatter.format(getContext("address"), new ADImpl(this.address));
		
		String expectedResult = "<address use=\"H\">" +
				"1 Yonge St.<delimiter></delimiter>" +
				"1 Bloor St.<delimiter></delimiter>" +
				"1 Spadina Ave." +
				"<city>Toronto</city>" +
				"<state code=\"ON\">ON</state>" +
				"<postalCode>postalCodeValue</postalCode>" +
				"<country code=\"Canada\">Canada</country>" +
				"freeformLine1 freeformLine2" +
				"</address>";
		
		assertXmlEquals("full address", expectedResult, result);
	}
	
	@Test
	public void testFormatAllInvalidAddressUses() throws Exception {
		assertInvalidAddressUse(PostalAddressUse.ALPHABETIC);
		assertInvalidAddressUse(PostalAddressUse.BAD);
		assertInvalidAddressUse(PostalAddressUse.DIRECT);
		assertInvalidAddressUse(PostalAddressUse.IDEOGRAPHIC);
		assertInvalidAddressUse(PostalAddressUse.PRIMARY_HOME);
		assertInvalidAddressUse(PostalAddressUse.PUBLIC);
		assertInvalidAddressUse(PostalAddressUse.SYLLABIC);
		assertInvalidAddressUse(PostalAddressUse.VACATION_HOME);
	}
	
	private void assertInvalidAddressUse(PostalAddressUse postalAddressUse) throws Exception {
		String xml = new AdBasicPropertyFormatter().format(getContext("address"), new ADImpl(this.address));
		assertFalse("use: " + postalAddressUse, xml.contains("use"));
	}
	
	@Test
	public void testFormatAllValidAddressUses() throws Exception {
		assertValidAddressUse(PostalAddressUse.HOME);
		assertValidAddressUse(PostalAddressUse.PHYSICAL);
		assertValidAddressUse(PostalAddressUse.POSTAL);
		assertValidAddressUse(PostalAddressUse.TEMPORARY);
		assertValidAddressUse(PostalAddressUse.WORK_PLACE);
	}
	
	private void assertValidAddressUse(PostalAddressUse use) throws Exception {
		PostalAddress postalAddress = new PostalAddress();
		postalAddress.addUse(use);
		
		String result = new AdBasicPropertyFormatter().format(getContext("address"), new ADImpl(postalAddress));
		String expected = "<address use=\"" + use.getCodeValue() + "\">" + LINE_SEPARATOR + "</address>" + LINE_SEPARATOR;
		assertXmlEquals("use formatted properly", expected, result);
	}
}
