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

import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class BooleanXmlParserTest  extends AbstractXmlParserTest<BL> {
	
	public BooleanXmlParserTest() {
		super(new BooleanXmlParser(), "groovy", new BLImpl());
	}
	
	@Test
	public void shouldParseTrueValue() throws Exception {
		assertEquals(
				"<groovy>true</groovy>",
				this.parser.parse(createContext(), new BLImpl(true)));
	}

	@Test
	public void shouldParseFalseValue() throws Exception {
		assertEquals(
				"<groovy>false</groovy>",
				this.parser.parse(createContext(), new BLImpl(false)));
	}
	
	@Override
	protected BL createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new BLImpl(nullFlavor);
	}

}
