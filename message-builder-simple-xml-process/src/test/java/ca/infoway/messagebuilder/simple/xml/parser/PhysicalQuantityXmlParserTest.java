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

import static ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;


public class PhysicalQuantityXmlParserTest extends AbstractXmlParserTest<PQ> {

	public PhysicalQuantityXmlParserTest() {
		super(new PhysicalQuantityXmlParser(), "dose", new PQImpl());
	}

	@Test
	public void shouldParseValue() throws Exception {
        PhysicalQuantity physicalQuantity = new PhysicalQuantity(
        		new BigDecimal("33.45"), 
        		ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE);
		
		assertEquals(
				"<dose unit=\"U/L\" value=\"33.45\"/>",
				this.parser.parse(createContext(), new PQImpl(physicalQuantity)));
        
	}
	
	@Override
	protected PQ createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new PQImpl(nullFlavor);
	}
	
}
