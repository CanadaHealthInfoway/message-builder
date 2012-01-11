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

import static ca.infoway.messagebuilder.xml.ConformanceLevel.OPTIONAL;

import java.util.ArrayList;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;

public class ListTelPhonemailPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new ListPropertyFormatter().format(
				new FormatContextImpl("blah", "LIST<TEL.PHONEMAIL>", OPTIONAL), 
				(BareANY) new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class));
		assertXml("null", "", result);
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		String result = new ListPropertyFormatter().format(
				new FormatContextImpl("blah", "LIST<TEL.PHONEMAIL>", OPTIONAL), 
				(BareANY) LISTImpl.<TEL, TelecommunicationAddress>create(
						TELImpl.class, 
						new ArrayList<TelecommunicationAddress>(makeTelecommunicationAddressSet( "Fred"))));
		assertXml("non null", "<blah value=\"mailto://Fred\"/>", result);
	}

}
