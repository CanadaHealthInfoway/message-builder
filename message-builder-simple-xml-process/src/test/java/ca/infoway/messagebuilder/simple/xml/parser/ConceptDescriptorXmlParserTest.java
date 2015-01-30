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

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class ConceptDescriptorXmlParserTest extends AbstractXmlParserTest<CD> {
	
	public ConceptDescriptorXmlParserTest() {
		super(new ConceptDescriptorXmlParser(), "code", new CDImpl());
	}
	
	@Test
	public void shouldParseCode() throws Exception {
		assertEquals(
				"<code code=\"A\" codeSystem=\"1.2.3.4.5\"/>",
				this.parser.parse(createContext(), new CDImpl(createCode("A", "1.2.3.4.5"))));
	}

	@Test
	public void shouldParseOriginalText() throws Exception {
		assertEquals(
				"<code code=\"A\" codeSystem=\"1.2.3.4.5\" originalText=\"ACTIVATION\"/>",
				this.parser.parse(createContext(), createCdWithOriginalText("A", "1.2.3.4.5", "ACTIVATION")));
	}

	@Test
	public void shouldParseDisplayName() throws Exception {
		CDImpl cd = new CDImpl(createCode("A", "1.2.3.4.5"));
		cd.setDisplayName("My display name");
		
		assertEquals(
				"<code code=\"A\" codeSystem=\"1.2.3.4.5\" displayName=\"My display name\"/>",
				this.parser.parse(createContext(), cd));
	}
	
	@Test
	public void shouldParseTranslations() throws Exception {
		CD cd = createCdWithOriginalText("A", "1.2.3.4.5", "ACTIVATION");
		cd.getTranslations().add(createCdWithOriginalText("M_translation1", "1.2.3.4_translation1", "Some original text_translation1"));
		cd.getTranslations().add(createCdWithOriginalText("M_translation2", "1.2.3.4_translation2", "Some original text_translation2"));
		
		assertEquals(
				"<code code=\"A\" codeSystem=\"1.2.3.4.5\" originalText=\"ACTIVATION\">" +
					"<translation code=\"M_translation1\" codeSystem=\"1.2.3.4_translation1\">" +
						"<originalText>Some original text_translation1</originalText>" +
					"</translation>" +
					"<translation code=\"M_translation2\" codeSystem=\"1.2.3.4_translation2\">" +
						"<originalText>Some original text_translation2</originalText>" +
					"</translation>" +
				"</code>",
				this.parser.parse(createContext(), cd));
	}
	
	private CD createCdWithOriginalText(final String codeValue, final String codeSystem, final String origianlText) {
		CDImpl cd = new CDImpl(new Code() {
			public String getCodeValue() {
				return codeValue;
			}
			public String getCodeSystem() {
				return codeSystem;
			}
		    public String getCodeSystemName() {
		    	return null;
		    }
		});
		cd.setOriginalText(origianlText);
		return cd;
	}

	private Code createCode(final String codeValue, final String codeSystem) {
		return new Code() {
			public String getCodeValue() {
				return codeValue;
			}
			public String getCodeSystem() {
				return codeSystem;
			}
		    public String getCodeSystemName() {
		    	return null;
		    }
		};
	}
	
	@Override
	protected CD createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new CDImpl(nullFlavor);
	}

}
