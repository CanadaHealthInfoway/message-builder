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
 * Last modified: $LastChangedDate: 2014-01-09 11:56:23 -0500 (Thu, 09 Jan 2014) $
 * Revision:      $LastChangedRevision: 8280 $
 */
package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Type;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD_R2;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.domainvalue.ObservationValue;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserTestCase;
import ca.infoway.messagebuilder.xml.Cardinality;

public class ListCDR2ElementParserTest extends ParserTestCase {
	
	private ParserR2Registry parserR2Registry = ParserR2Registry.getInstance();
	
	@Test
	public void testParse() throws Exception {
		Node node = createNode("<top>" +
				"<targetSiteCode code=\"416949008\" codeSystem=\"2.16.840.1.113883.6.96\" codeSystemName=\"SNOMED CT\" displayName=\"Abdomen and pelvis\"/>" +
				"</top>");

		Type expectedReturnType = ObservationValue.class;
		ParseContext parseContext = ParseContextImpl.create("LIST<CD>", expectedReturnType, SpecificationVersion.CCDA_R1_1, null, 
				null, null, Cardinality.create("0-4"), null, true);
		BareANY result = new ListR2ElementParser(this.parserR2Registry).parse(parseContext, asList(node.getChildNodes()), this.xmlResult);
		
		assertTrue(this.xmlResult.isValid());
		@SuppressWarnings("unchecked")
		List<CodedTypeR2<ObservationValue>> list = ((LIST<CD_R2<ObservationValue>, CodedTypeR2<ObservationValue>>) result).rawList();
		assertNotNull("null", list);
		assertEquals("size", 1, list.size());
		CodedTypeR2<ObservationValue> firstValue = list.get(0);
		assertEquals("416949008", firstValue.getCodeValue());
		assertEquals("2.16.840.1.113883.6.96", firstValue.getCodeSystem());
		assertEquals("SNOMED CT", firstValue.getCodeSystemName());
		assertEquals("Abdomen and pelvis", firstValue.getDisplayName());
	}

}