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

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;
import ca.infoway.messagebuilder.simple.xml.formatter.AbstractSimpleXmlFormatter;

public abstract class AbstractXmlParserTest<T extends ANY<?>> {

	protected final SimpleXmlParser<T> parser;
	protected final String elementName;
	
	private final T defaultAny;
	
	protected static final String NS = "xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	protected AbstractXmlParserTest(SimpleXmlParser<T> parser, String elementName, T defaultAny) {
		this.parser = parser;
		this.elementName = elementName;
		this.defaultAny = defaultAny;
		
	}
	
	protected abstract T createAnyWithNullFlavor(NullFlavor nullFlavor);
	
	@Test
	public void shouldParseNullValueWithNoNullFlavor() throws Exception {
		assertEquals(
				"",
				this.parser.parse(createContext(), this.defaultAny));
	}

//	@Test
//	public void shouldParseValueWithNullFlavor() throws Exception {
//		NullFlavor nullFlavor = NullFlavor.OTHER;
//		assertEquals(
//				format("<%sNullFlavor>OTH</%1$sNullFlavor><name>John Doe</name>", this.elementName, nullFlavor.getCodeValue()),
//				this.parser.parse(createContext(), createAnyWithValueAndNullFlavor(nullFlavor)));
//	}
	
	@Test
	public void shouldParseNullFlavor() throws Exception {
		NullFlavor nullFlavor = NullFlavor.MASKED;
		assertEquals(
				format("<%sNullFlavor %s>%s</%1$sNullFlavor>", this.elementName, NS, nullFlavor.getCodeValue()),
				this.parser.parse(createContext(), createAnyWithNullFlavor(nullFlavor)));
	}
	
	protected final SimpleXmlParseContext createContext() {
		return new SimpleXmlParseContextImpl(this.elementName);
	}

}
