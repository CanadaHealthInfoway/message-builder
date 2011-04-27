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

package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class IntegerXmlParserTest extends AbstractXmlParserTest<INT> {
	
	public IntegerXmlParserTest() {
		super(new IntegerXmlParser(), "maxAge", new INTImpl());
	}
	
	@Test
	public void shouldParseNonNullValue() throws Exception {
		assertEquals(
				"<maxAge>1</maxAge>",
				this.parser.parse(createContext(), new INTImpl(1)));
	}

	@Override
	protected INT createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new INTImpl(nullFlavor);
	}

}
