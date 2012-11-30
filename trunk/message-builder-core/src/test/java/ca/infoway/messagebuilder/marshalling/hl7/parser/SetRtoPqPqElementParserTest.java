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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class SetRtoPqPqElementParserTest extends ParserTestCase {

	@Test
	public void testParse() throws Exception {
		Node node = createNode("<top>" +
									"<something>" +
										"<numerator unit=\"mg\" value=\"1000\" />" +
										"<denominator unit=\"d\" value=\"1\" />" +
									"</something>" +
									"<something>" +
										"<numerator unit=\"mg\" value=\"1001\"	/>" +
										"<denominator unit=\"d\" value=\"2\" />" +
									"</something>" +
								"</top>");

		BareANY result = new SetElementParser().parse(
				ParserContextImpl.create("SET<RTO<PQ.DRUG,PQ.TIME>>", null, SpecificationVersion.V01R04_2_SK, null, null, ConformanceLevel.MANDATORY),
				asList(node.getChildNodes()),
				null);
		@SuppressWarnings("unchecked")
		Set<Ratio<PhysicalQuantity,PhysicalQuantity>> set = ((SET<RTO<PhysicalQuantity,PhysicalQuantity>,Ratio<PhysicalQuantity,PhysicalQuantity>>) result).rawSet();

		assertNotNull("null", set);
		assertEquals("size", 2, set.size());

		boolean foundFirst = false;
		boolean foundSecond = false;

		for (Ratio<PhysicalQuantity, PhysicalQuantity> ratio : set) {
			if (ratio.getNumerator().getQuantity().intValue() == 1000 && ratio.getDenominator().getQuantity().intValue() == 1) {
				foundFirst = true;
			} else if (ratio.getNumerator().getQuantity().intValue() == 1001 && ratio.getDenominator().getQuantity().intValue() == 2) {
				foundSecond = true;
			}
		}

		assertTrue(foundFirst);
		assertTrue(foundSecond);

	}
}
