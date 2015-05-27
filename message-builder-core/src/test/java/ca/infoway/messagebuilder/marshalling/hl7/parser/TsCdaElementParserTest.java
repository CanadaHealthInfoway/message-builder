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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-05-15 18:39:56 -0400 (Wed, 15 May 2013) $
 * Revision:      $LastChangedRevision: 6874 $
 */
package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.SXCMTSCDAR1;
import ca.infoway.messagebuilder.datatype.TSCDAR1;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class TsCdaElementParserTest extends MarshallingTestCase {

	private TsCdaElementParser parser = new TsCdaElementParser();
	
	@Test
	public void testTsCda() throws Exception {
		Date expectedDate = DateUtil.getDate(2012, 4, 3);
        Node node = createNode("<date value=\"20120503\"/>");

		ParseContext context = ParseContextImpl.create("TSCDAR1", null, SpecificationVersion.R02_04_03, null, null, ConformanceLevel.MANDATORY, Cardinality.create("1"), null, true);
		BareANY parseResult = this.parser.parse(context, Arrays.asList(node), this.xmlResult);
		
		assertTrue(this.xmlResult.isValid());
		assertTrue(parseResult instanceof TSCDAR1);
		assertTrue(parseResult.getBareValue() instanceof MbDate);
		assertEquals(expectedDate, ((MbDate) parseResult.getBareValue()).getValue());
	}
	
	@Test
	public void testSxcmTs() throws Exception {
		Date expectedDate = DateUtil.getDate(2012, 4, 3);
        Node node = createNode("<date operator=\"E\" value=\"20120503\"/>");

		ParseContext context = ParseContextImpl.create("SXCMTSCDAR1", null, SpecificationVersion.R02_04_03, null, null, ConformanceLevel.MANDATORY, Cardinality.create("1"), null, true);
		BareANY parseResult = this.parser.parse(context, Arrays.asList(node), this.xmlResult);
		
		assertTrue(this.xmlResult.isValid());
		assertTrue(parseResult instanceof SXCMTSCDAR1);
		assertTrue(parseResult.getBareValue() instanceof MbDate);
		assertEquals(expectedDate, ((MbDate) parseResult.getBareValue()).getValue());
	}
	
}
