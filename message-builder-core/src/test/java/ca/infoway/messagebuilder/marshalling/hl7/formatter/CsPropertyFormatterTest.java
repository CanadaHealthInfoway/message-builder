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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class CsPropertyFormatterTest extends FormatterTestCase {
    
    class FakeCode implements Code {
        public FakeCode() {
        }
        public String getCodeSystem() {
            return "1.1";
        }
        /**
         * {@inheritDoc}
         */
        public String getCodeSystemName() {
        	return null;
        }
        
        public String getCodeValue() {
            return "code";
        }
    }

    @Test
    public void testGetAttributeNameValuePairsNullValue() throws Exception {
        Map<String, String> result = new CsPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null, false), null, null);
        assertEquals("map size", 0, result.size());
    }

    @Test
    public void testGetAttributeNameValuePairsEnum() throws Exception {
        // used as expected: an enumerated object is passed in
        Map<String, String> result = new CsPropertyFormatter().getAttributeNameValuePairs(
        		new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null, false), 
        		CeRxDomainTestValues.CENTIMETRE, null);
        assertEquals("map size", 1, result.size());
        
        assertTrue("key as expected", result.containsKey("code"));
        assertEquals("value as expected", "cm", result.get("code"));
    }

    @Test
    public void testGetAttributeNameValuePairsWithoutCodeSystem() throws Exception {
        Map<String, String> result = new CsPropertyFormatter().getAttributeNameValuePairs(
        		new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null, false), 
        		new MockCodeImpl("fred", "The Flintstones"),
        		null);

        assertEquals("map size", 1, result.size());
        assertFalse("key as expected", result.containsKey("codeSystem"));
    }
    
    @Test
    public void testGetAttributeNameValuePairsWithOriginalText() throws Exception {
        CSImpl cs = new CSImpl(new FakeCode());
        cs.setOriginalText("The Flintstones");
        
		String result = new CsPropertyFormatter().format(
        		getContext("character"),
                cs);
        
		assertEquals(1, this.result.getHl7Errors().size());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().startsWith("Could not locate a registered domain type to match "));
        Document document = new DocumentFactory().createFromString(result);
        NodeList list = document.getElementsByTagName("originalText");
        assertEquals("originalText", 1, list.getLength());
    }
    
    @Test
    public void testFormatNull() throws Exception {
        String result = new CsPropertyFormatter().format(getContext("option"), new CSImpl(NullFlavor.OTHER));
        
		assertTrue(this.result.isValid());
        Document document = new DocumentFactory().createFromString(result);
        NodeList list = document.getElementsByTagName("option");
        assertEquals("option", 1, list.getLength());
        
        Element element = ((Element) list.item(0));
        assertEquals("nullFlavor", "OTH", element.getAttribute("nullFlavor"));
        assertFalse("code system", element.hasAttribute("codeSystem"));
        
    }
    
    @Test
    public void testFormatNullWithCodeSystem() throws Exception {
        String xml = new CsPropertyFormatter().format(
        		getContext("option"),
        		new CSImpl(NullFlavor.OTHER));
        
		assertTrue(this.result.isValid());
        Document document = new DocumentFactory().createFromString(xml);
        NodeList list = document.getElementsByTagName("option");
        assertEquals("option", 1, list.getLength());
        
        Element result = ((Element) list.item(0));
        assertEquals("nullFlavor", "OTH", result.getAttribute("nullFlavor"));
        assertFalse("should not have codeSystem", result.hasAttribute("codeSystem"));
    }
}
