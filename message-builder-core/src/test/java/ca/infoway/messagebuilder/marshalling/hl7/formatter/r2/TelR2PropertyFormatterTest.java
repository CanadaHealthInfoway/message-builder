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
 * Last modified: $LastChangedDate: 2013-09-06 10:36:09 -0400 (Fri, 06 Sep 2013) $
 * Revision:      $LastChangedRevision: 7861 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;

public class TelR2PropertyFormatterTest extends FormatterTestCase {

	@After
	public void teardown() {
		this.result.clearErrors();
	}
	
	private FormatContextImpl createContext(String type) {
		return new FormatContextImpl(this.result, null, "name", type, null, null, false, SpecificationVersion.R02_04_03, null, null, null);
	}

	// tests for valid/invalid schemes?? valid/invalid address uses? 
	
	@Test
	public void testImpliedNullValue() throws Exception {
		String result = new TelR2PropertyFormatter().format(createContext("TEL"), new TELImpl());

		assertTrue(this.result.isValid());
		assertXml("xml output", "<name nullFlavor=\"NI\"/>", result);
	}

	@Test
	public void testNullValue() throws Exception {
		String result = new TelR2PropertyFormatter().format(createContext("TEL"), new TELImpl(NullFlavor.NOT_APPLICABLE));

		assertTrue(this.result.isValid());
		assertXml("xml output", "<name nullFlavor=\"NA\"/>", result);
	}

	@Test
	public void testTelPhoneValid() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.TELEPHONE);
		address.setAddress("aValue");
		String result = new TelR2PropertyFormatter().format(createContext("TEL"), new TELImpl(address));
		
		assertTrue(this.result.isValid());
		assertXml("xml output", "<name value=\"tel:aValue\"/>", result);
	}

	@Test
	public void testIncludeUses() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.TELEPHONE);
		address.setAddress("aValue");
		address.addAddressUse(CeRxDomainTestValues.HOME_ADDRESS);
		
		String result = new TelR2PropertyFormatter().format(createContext("TEL"), new TELImpl(address));
		
		assertTrue(this.result.isValid());
		assertXml("xml output", "<name use=\"H\" value=\"tel:aValue\"/>", result);

		address.addAddressUse(CeRxDomainTestValues.MOBILE_CONTACT);
		result = new TelR2PropertyFormatter().format(createContext("TEL"), new TELImpl(address));
		assertTrue(this.result.isValid());
		assertXml("xml output", "<name use=\"H MC\" value=\"tel:aValue\"/>", result);
	}
	
	@Test
	public void testTelEmail() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.MAILTO);
		address.setAddress("1234567890123456789012345678901234567890123");
		
		String result = new TelR2PropertyFormatter().format(createContext("TEL"), new TELImpl(address));
		
		assertTrue(this.result.isValid());
		assertXml("xml output", "<name value=\"mailto:1234567890123456789012345678901234567890123\"/>", result);
	}

	@Test
	public void testIncludeUsesAndUseablePeriods() throws Exception {
		Date date1 = DateUtil.getDate(2004, 5, 10, 9, 42, 43, 123);
		Date date2 = DateUtil.getDate(2006, 6, 11, 11, 31, 32, 444);
		
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.TELEPHONE);
		address.setAddress("aValue");
		address.addAddressUse(CeRxDomainTestValues.HOME_ADDRESS);
		address.addAddressUse(CeRxDomainTestValues.MOBILE_CONTACT);
		address.addUseablePeriod(new DateWithPattern(date1, "yyyyMMddHHmmss.SSS0"), SetOperator.EXCLUDE);
		address.addUseablePeriod(new DateWithPattern(date2, "yyyyMMddHHmmss.SSS0"), null);
		
		String result = new TelR2PropertyFormatter().format(createContext("TEL"), new TELImpl(address));
		
		assertTrue(this.result.isValid());
		assertXml("xml output", "<name use=\"H MC\" value=\"tel:aValue\"><useablePeriod operator=\"E\" value=\"20040610094243.1230\"/><useablePeriod operator=\"I\" value=\"20060711113132.4440\"/></name>", result);
	}
	
}
