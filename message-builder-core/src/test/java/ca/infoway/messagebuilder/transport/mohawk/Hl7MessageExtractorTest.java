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

package ca.infoway.messagebuilder.transport.mohawk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.util.xml.DocumentFactory;

/**
 * @sharpen.ignore - test - translated manually
 */
public class Hl7MessageExtractorTest {
	
	@Test
	public void shouldExtractResponseMessage() throws Exception {
		byte[] b = loadResponse();
		String document = new Hl7MessageExtractor().getHl7Message(new ByteArrayInputStream(b));
		assertTrue("string", document.contains("<hl7:PRPA_IN101104CA"));
		
		assertEquals("root", "PRPA_IN101104CA", 
				new DocumentFactory().createFromString(
						document).getDocumentElement().getLocalName());
	}

	private byte[] loadResponse() throws Exception {
		InputStream input = getClass().getResourceAsStream("soapResponse.xml");
		try {
			return IOUtils.toByteArray(input);
		} finally {
			IOUtils.closeQuietly(input);
		}
	}
}
