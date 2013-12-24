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
 * Last modified: $LastChangedDate: 2013-01-02 18:05:34 -0400 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

public class AbstractElementParserTest {

	@Test
	public void shouldConvertSpecializationType() {
		
		AbstractElementParser parser = new AbstractElementParser() {
			@Override
			public BareANY parse(ParseContext context, List<Node> node,	XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
				return null;
			}
		};
		
		assertEquals("ST", parser.convertSpecializationType("ST"));
		assertEquals("ST", parser.convertSpecializationType("ST.CA"));
		assertEquals("ST.LANG", parser.convertSpecializationType("ST.LANG"));
		assertEquals("LIST<ST>", parser.convertSpecializationType("LIST_ST.CA"));
		assertEquals("CV", parser.convertSpecializationType("CV"));
		assertEquals("CV", parser.convertSpecializationType("CV.CA"));
		assertEquals("RTO<PQ,PQ>", parser.convertSpecializationType("RTO_PQ_PQ"));
		assertEquals("RTO<PQ,PQ>", parser.convertSpecializationType("RTO_PQ.CA_PQ.CA"));
		assertEquals("SET<RTO<PQ,PQ>>", parser.convertSpecializationType("SET_RTO_PQ_PQ"));
		assertEquals("LIST<RTO<PQ,PQ>>", parser.convertSpecializationType("LIST_RTO_PQ_PQ"));
		assertEquals("RTO<MO,PQ>", parser.convertSpecializationType("RTO_MO_PQ"));
		assertEquals("II.PUBLIC", parser.convertSpecializationType("II.PUBLIC"));
		assertEquals("CV", parser.convertSpecializationType("cv.ca"));
		assertEquals("RTO<PQ,PQ>", parser.convertSpecializationType("rto_pq_pq"));
	}
	
}
