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

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class SetStringPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new SetPropertyFormatter().format(
				new FormatContextImpl("blah", "SET<ST>", ConformanceLevel.MANDATORY), 
				new SETImpl<ST, String>(STImpl.class, NullFlavor.NO_INFORMATION));
        assertXml("null", "<blah nullFlavor=\"NI\"/>", result);
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		String result = new SetPropertyFormatter().format(
				new FormatContextImpl("blah", "SET<ST>", ConformanceLevel.MANDATORY), 
				SETImpl.<ST, String>create(STImpl.class, makeSet( "Fred", "Wilma" )));
		assertXml("non null", "<blah>Fred</blah><blah>Wilma</blah>", result);
	}

}
