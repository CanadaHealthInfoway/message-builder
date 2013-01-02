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

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class EncapsulatedDataSignatureXmlParserTest extends AbstractXmlParserTest<ED<String>> {
	
	public EncapsulatedDataSignatureXmlParserTest() {
		super(new EncapsulatedDataSignatureXmlParser(), "sig", new EDImpl<String>());
	}
	
	@Test
	public void shouldParseSt() throws Exception {
		assertEquals(
				"<sig>hola</sig>",
				this.parser.parse(createContext(), createEdSignature(StandardDataType.ED_SIGNATURE, "hola")));
	}

	private EDImpl<String> createEdSignature(StandardDataType dataType, String value) {
		EDImpl<String> ed = new EDImpl<String>(value);
		ed.setDataType(dataType);
		return ed;
	}
	
	@Override
	protected ED<String> createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new EDImpl<String>(nullFlavor);
	}

}
