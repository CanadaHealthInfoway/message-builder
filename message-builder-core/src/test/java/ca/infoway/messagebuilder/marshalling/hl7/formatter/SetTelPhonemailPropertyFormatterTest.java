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

import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;

public class SetTelPhonemailPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new SetPropertyFormatter().format(new FormatContextImpl(new ModelToXmlResult(), null, "blah", "SET<TEL.PHONEMAIL>", MANDATORY, false, SpecificationVersion.R02_04_03, null, null, null), 
				new SETImpl<TEL, TelecommunicationAddress>(
						TELImpl.class, 
						NullFlavor.NO_INFORMATION));
        assertXml("null", "<blah nullFlavor=\"NI\"/>", result);
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		String result = new SetPropertyFormatter().format(new FormatContextImpl(new ModelToXmlResult(), null, "blah", "SET<TEL.PHONEMAIL>", MANDATORY, false, SpecificationVersion.R02_04_03, null, null, null),
				SETImpl.<TEL, TelecommunicationAddress>create(
						TELImpl.class, makeTelecommunicationAddressSet("Fred")));
		assertXml("non null", "<blah value=\"mailto:Fred\"/>", result);
	}

}
