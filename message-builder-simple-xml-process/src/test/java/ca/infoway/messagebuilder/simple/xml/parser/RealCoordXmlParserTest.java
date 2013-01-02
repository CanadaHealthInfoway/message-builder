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

import java.math.BigDecimal;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class RealCoordXmlParserTest  extends AbstractXmlParserTest<REAL> {
	
	public RealCoordXmlParserTest() {
		super(new RealXmlParser(), "amount", new REALImpl());
	}
	
	@Test
	public void shouldParseZeroValue() throws Exception {
		assertEquals(
				"<amount>0.0000</amount>",
				this.parser.parse(createContext(), createRealCoord("0")));
	}

	@Test
	public void shouldParseZeroOne() throws Exception {
		assertEquals(
				"<amount>1.0000</amount>",
				this.parser.parse(createContext(), createRealCoord("1")));
	}
	
	@Test
	public void shouldParseValue() throws Exception {
		assertEquals(
				"<amount>1234.2564</amount>",
				this.parser.parse(createContext(), createRealCoord("1234.2564")));
		
	}

	@Test
	public void shouldParseValueAndRownDown() throws Exception{
		assertEquals(
				"<amount>1234.2564</amount>",
				this.parser.parse(createContext(), createRealCoord("1234.256444444")));
	}
	
	@Test
	public void shouldParseValueAndRownUp() throws Exception{
		assertEquals(
				"<amount>1234.2565</amount>",
				this.parser.parse(createContext(), createRealCoord("1234.256455555")));
	}
	
	private REALImpl createRealCoord(String realValue) {
		REALImpl real = new REALImpl(new BigDecimal(realValue));
		real.setDataType(StandardDataType.REAL_COORD);
		return real;
	}


	@Override
	protected REAL createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new REALImpl(nullFlavor);
	}

}
