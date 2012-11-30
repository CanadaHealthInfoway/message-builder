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

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.lang.CompressedData;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.util.Compression;
import ca.infoway.messagebuilder.domainvalue.x_DocumentMediaType;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;

public class EncapsulatedDataDocumentXmlParserTest extends AbstractXmlParserTest<ED<EncapsulatedData>> {
	
//	<document mediaType="text/html" uri="http://www.i-proving.ca" compression="GZ" language="en">
//		<document>VG9tIGlzIGRyaXZpbmcgbWUgY3Jhenk=</document>
//	</document>

	private String doc = "VG9tIGlzIGRyaXZpbmcgbWUgY3Jhenk=";
	private byte[] bytes = Base64.decodeBase64(this.doc.getBytes());

	public EncapsulatedDataDocumentXmlParserTest() {
		super(new EncapsulatedDataDocumentXmlParser(), "docOrRef", new EDImpl<EncapsulatedData>());
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@Test
	public void shouldParseMinimalEdDoc() throws Exception {
		assertEquals(
				"<docOrRef><document>VG9tIGlzIGRyaXZpbmcgbWUgY3Jhenk=</document></docOrRef>",
				this.parser.parse(createContext(), createEdDoc(StandardDataType.ED_DOC, null, null, null, null, new String(this.bytes))));
	}

	@Test
	public void shouldParseFullEdDoc() throws Exception {
		assertEquals(
				"<docOrRef compression=\"GZ\" language=\"en\" mediaType=\"text/html\" uri=\"http://www.i-proving.ca\"><document>VG9tIGlzIGRyaXZpbmcgbWUgY3Jhenk=</document></docOrRef>",
				this.parser.parse(createContext(), createEdDoc(StandardDataType.ED_DOC, "text/html", "http://www.i-proving.ca", "GZ", "en-CA", new String(this.bytes))));
	}

	private EDImpl<EncapsulatedData> createEdDoc(StandardDataType dataType, String mediaType, String uri, String compression, String language, String content) {
		x_DocumentMediaType mt = StringUtils.isBlank(mediaType) ? null : CodeResolverRegistry.lookup(x_DocumentMediaType.class, mediaType);
		byte[] doc = (StringUtils.isBlank(content) ? null : content.getBytes());
		EncapsulatedData ed = null;
		if (StringUtils.isBlank(compression)) {
			ed = new EncapsulatedData(mt, uri, language, doc);
		} else {
			Compression compr = Compression.get(compression);
			ed = new CompressedData(mt, uri, doc, compr, language);
		}
		return new EDImpl<EncapsulatedData>(null, ed, null, dataType);
	}
	
	@Override
	protected ED<EncapsulatedData> createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new EDImpl<EncapsulatedData>(nullFlavor);
	}

}
