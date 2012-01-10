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

import java.math.BigDecimal;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Currency;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class MoneyXmlParserTest extends AbstractXmlParserTest<MO> {
	
	public MoneyXmlParserTest() {
		super(new MoneyXmlParser(), "price", new MOImpl());
	}
	
	@Test
	public void shouldParseNonNullValue() throws Exception {
		assertEquals(
				"<price currency=\"CAD\" value=\"1.12\"/>",
				this.parser.parse(createContext(), new MOImpl(new Money(new BigDecimal("1.12"), Currency.CANADIAN_DOLLAR))));
	}

	@Override
	protected MO createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new MOImpl(nullFlavor);
	}

}
