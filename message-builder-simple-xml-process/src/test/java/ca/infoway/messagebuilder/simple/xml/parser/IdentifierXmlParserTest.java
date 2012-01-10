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

package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class IdentifierXmlParserTest extends AbstractXmlParserTest<II> {
	
	public IdentifierXmlParserTest() {
		super(new IdentifierXmlParser(), "id", new IIImpl());
	}	
	@Test
	public void shouldParseValue() throws Exception {
		assertEquals(
				"<id extension=\"2\" root=\"1\"/>",
				this.parser.parse(createContext(), new IIImpl(new Identifier("1", "2"))));
	}

	@Override
	protected II createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new IIImpl(nullFlavor);
	}

}
