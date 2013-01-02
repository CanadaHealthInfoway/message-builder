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

package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class SimpleCodedTypeXmlParserTest extends AbstractXmlParserTest<CS> {
	
	public SimpleCodedTypeXmlParserTest() {
		super(new SimpleCodedTypeXmlParser(), "code", new CSImpl());
	}
	
	@Test
	public void shouldParseCode() throws Exception {
		assertEquals(
				"<code code=\"A\"/>",
				this.parser.parse(createContext(), new CSImpl(createCode("A", "1.2.3.4.5"))));
	}

	private Code createCode(final String code, final String codeSystem) {
		return new Code() {
			public String getCodeValue() {
				return code;
			}
			public String getCodeSystem() {
				return codeSystem;
			}
		};
	}
	
	@Override
	protected CS createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new CSImpl(nullFlavor);
	}

}
