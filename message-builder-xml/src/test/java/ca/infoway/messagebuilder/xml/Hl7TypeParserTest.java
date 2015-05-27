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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.xml;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;


/**
 * @sharpen.ignore - datatype - translated manually
 */
public class Hl7TypeParserTest {

	@Test
	public void shouldParseSimpleCase() throws Exception {
		Hl7TypeName name = new Hl7TypeParser().parse("ST");
		assertEquals("name", "ST", name.toString());
	}
	
	@Test
	public void shouldParseParameterizedTypes() throws Exception {
		Hl7TypeName name = new Hl7TypeParser().parse("SET<ST>");
		assertEquals("name", "SET<ST>", name.toString());
		assertEquals("base", "SET", name.getUnparameterizedName());
	}
	
	@Test
	public void shouldParseComplexParameterizedTypes() throws Exception {
		Hl7TypeName name = new Hl7TypeParser().parse("SET<RTO<PQ,PQ>>");
		assertEquals("name", "SET<RTO<PQ,PQ>>", name.toString());
		assertEquals("base", "SET", name.getUnparameterizedName());
		assertEquals("parameter count", 1, name.getParameters().size());
		
		Hl7TypeName parameter = name.getParameters().get(0);
		assertEquals("parameter name", "RTO", parameter.getUnparameterizedName());
		assertEquals("parameters of parameter count", 2, parameter.getParameters().size());
	}
	
	@Test
	public void shouldStripWhitespace() throws Exception {
		Hl7TypeName name = new Hl7TypeParser().parse("SET<RTO<PQ, PQ>>");
		assertEquals("name", "SET<RTO<PQ,PQ>>", name.toString());
		assertEquals("base", "SET", name.getUnparameterizedName());
		assertEquals("parameter count", 1, name.getParameters().size());
		
		Hl7TypeName parameter = name.getParameters().get(0);
		assertEquals("parameter name", "RTO", parameter.getUnparameterizedName());
		assertEquals("parameters of parameter count", 2, parameter.getParameters().size());
	}
	
	@Test
	public void shouldSplitOnCommas() throws Exception {
		List<String> parts = new Hl7TypeParser().split("PQ.DRUG,PQ.QUANTITY");
		assertEquals("count", 2, parts.size());
		assertEquals("first part", "PQ.DRUG", parts.get(0));
	}
	
	@Test
	public void shouldNotSplitOnNestedCommas() throws Exception {
		List<String> parts = new Hl7TypeParser().split("RTO<PQ.DRUG,PQ.QUANTITY>");
		assertEquals("count", 1, parts.size());
		assertEquals("first part", "RTO<PQ.DRUG,PQ.QUANTITY>", parts.get(0));
	}
}
