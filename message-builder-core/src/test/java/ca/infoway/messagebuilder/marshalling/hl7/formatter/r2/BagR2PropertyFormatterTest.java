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
 * Last modified: $LastChangedDate: 2013-05-16 20:53:38 -0400 (Thu, 16 May 2013) $
 * Revision:      $LastChangedRevision: 6878 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static ca.infoway.messagebuilder.xml.ConformanceLevel.OPTIONAL;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;
import ca.infoway.messagebuilder.xml.Cardinality;

public class BagR2PropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new BagR2PropertyFormatter().format(
				new FormatContextImpl(new ModelToXmlResult(), null, "telecom", "BAG<TEL>", OPTIONAL, null, false, SpecificationVersion.R02_04_03, null, null, null), 
				(BareANY) new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class));
		assertXml("null", "", result);
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		String result = new BagR2PropertyFormatter().format(
				new FormatContextImpl(new ModelToXmlResult(), null, "telecom", "BAG<TEL>", OPTIONAL, Cardinality.create("1-4"), false, SpecificationVersion.R02_04_03, null, null, null), 
				(BareANY) LISTImpl.<TEL, TelecommunicationAddress>create(
						TELImpl.class, 
						createTelecommunicationAddressList()));
		assertXml("non null", "<telecom value=\"+1-519-555-2345;ext=12345\"/>" + 
							  "<telecom value=\"+1-416-555-2345;ext=12345\"/>", result);
	}

	private List<TelecommunicationAddress> createTelecommunicationAddressList() {
		ArrayList<TelecommunicationAddress> result = new ArrayList<TelecommunicationAddress>();
		TelecommunicationAddress phone1 = createTelecommunicationAddress("+1-519-555-2345;ext=12345");
		TelecommunicationAddress phone2 = createTelecommunicationAddress("+1-416-555-2345;ext=12345");
		result.add(phone1);
		result.add(phone2);
		return result;
	}

	private static TelecommunicationAddress createTelecommunicationAddress(String formattedPhoneNumber) {
		TelecommunicationAddress telecom = new TelecommunicationAddress();
		telecom.setAddress(formattedPhoneNumber);
		return telecom;
	}
}
