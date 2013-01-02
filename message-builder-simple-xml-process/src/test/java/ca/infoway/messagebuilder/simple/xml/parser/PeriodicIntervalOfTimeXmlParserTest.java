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
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.datatype.PIVL;
import ca.infoway.messagebuilder.datatype.impl.PIVLImpl;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.basic.DefaultTimeUnit;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

@RunWith(Theories.class)
public class PeriodicIntervalOfTimeXmlParserTest extends AbstractXmlParserTest<PIVL> {
	
	public PeriodicIntervalOfTimeXmlParserTest() {
		super(new PeriodicIntervalOfTimeXmlParser(), "pivl", new PIVLImpl());
	}
	
	@Test
	public void shouldParseValue() throws Exception {
		PIVLImpl pivl = new PIVLImpl(PeriodicIntervalTime.createFrequency(
				4, 
				new PhysicalQuantity(new BigDecimal("7"), DefaultTimeUnit.DAY)));
		
		assertEquals(
				 "<pivl numberOfOccurrences=\"4\"><every unit=\"d\" value=\"7\"/></pivl>",
				 this.parser.parse(createContext(), pivl));
	}

	@Test
	public void shouldParseValueWithNoOccurences() throws Exception {
		PIVLImpl pivl = new PIVLImpl(PeriodicIntervalTime.createFrequency(
				null, 
				new PhysicalQuantity(new BigDecimal("7"), DefaultTimeUnit.DAY)));
		
		assertEquals(
				 "<pivl><every unit=\"d\" value=\"7\"/></pivl>",
				 this.parser.parse(createContext(), pivl));
	}
	
	@Override
	protected PIVL createAnyWithNullFlavor(NullFlavor nullFlavor) {
		PIVLImpl pivl = new PIVLImpl();
		pivl.setNullFlavor(nullFlavor);
		return pivl;
	}

}
