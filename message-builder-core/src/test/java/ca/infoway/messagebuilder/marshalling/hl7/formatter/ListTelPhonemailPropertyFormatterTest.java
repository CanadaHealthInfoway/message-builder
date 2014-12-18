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

import static ca.infoway.messagebuilder.xml.ConformanceLevel.OPTIONAL;

import java.util.ArrayList;

import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.xml.Cardinality;

public class ListTelPhonemailPropertyFormatterTest extends FormatterTestCase {

	private FormatterRegistry formatterRegistry = FormatterRegistry.getInstance();

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new ListPropertyFormatter(this.formatterRegistry).format(
				new FormatContextImpl(new ModelToXmlResult(), null, "blah", "LIST<TEL.PHONEMAIL>", OPTIONAL, null, false, SpecificationVersion.R02_04_03, null, null, null, false), 
				(BareANY) new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class));
		assertXml("null", "", result);
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		ModelToXmlResult results = new ModelToXmlResult();
		String result = new ListPropertyFormatter(this.formatterRegistry).format(
				new FormatContextImpl(results, null, "blah", "LIST<TEL.PHONEMAIL>", OPTIONAL, Cardinality.create("0-4"), false, SpecificationVersion.R02_04_03, null, null, null, false), 
				(BareANY) LISTImpl.<TEL, TelecommunicationAddress>create(
						TELImpl.class, 
						new ArrayList<TelecommunicationAddress>(makeTelecommunicationAddressList("Fred"))));
		assertXml("non null", "<blah specializationType=\"TEL.PHONE\" value=\"mailto:Fred\" xsi:type=\"TEL\"/>", result);
	}

	@Test
	public void testFormatValueNonNullMultiple() throws Exception {
		String result = new ListPropertyFormatter(this.formatterRegistry).format(
				new FormatContextImpl(new ModelToXmlResult(), null, "blah", "LIST<TEL.PHONEMAIL>", OPTIONAL, Cardinality.create("0-4"), false, SpecificationVersion.R02_04_03, null, null, null, false), 
				(BareANY) LISTImpl.<TEL, TelecommunicationAddress>create(
						TELImpl.class, 
						new ArrayList<TelecommunicationAddress>(makeTelecommunicationAddressList("Fred", "Jack"))));
		assertXml("non null", "<blah specializationType=\"TEL.PHONE\" value=\"mailto:Fred\" xsi:type=\"TEL\"/>"+
				              "<blah specializationType=\"TEL.PHONE\" value=\"mailto:Jack\" xsi:type=\"TEL\"/>", result);
	}

}
