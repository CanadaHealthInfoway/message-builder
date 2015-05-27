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
 * Last modified: $LastChangedDate: 2014-03-13 09:26:14 -0400 (Thu, 13 Mar 2014) $
 * Revision:      $LastChangedRevision: 8457 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.TestableAbstractValueNullFlavorPropertyFormatter;

public class IiR2PropertyFormatterTest extends MarshallingTestCase {
	
	private static class TestableIiR2PropertyFormatter extends IiR2PropertyFormatter implements TestableAbstractValueNullFlavorPropertyFormatter<Identifier> {
		public Map<String, String> getAttributeNameValuePairsForTest(FormatContext context, Identifier t, BareANY bareAny) {
			return super.getAttributeNameValuePairs(context, t, bareAny);
		}
	}

	@Test
    public void testGetAttributeNameValuePairsForValidII() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString");
        ii.setAssigningAuthorityName("aaName");
        ii.setDisplayable("d_true");
        
        II iiHl7 = new IIImpl();
        iiHl7.setDataType(StandardDataType.II);
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false);
        
		Map<String, String> result = new TestableIiR2PropertyFormatter().getAttributeNameValuePairsForTest(context, ii, iiHl7);
        assertEquals("map size", 4, result.size());
        assertTrue("no errors", modelToXmlResult.getHl7Errors().isEmpty());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
        assertKeyValuePairInMap(result, "assigningAuthorityName", "aaName");
        assertKeyValuePairInMap(result, "displayable", "d_true");
    }

	@Test
    public void testGetAttributeNameValuePairsForValidIICeRx() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString");
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II", null, null, false, SpecificationVersion.V01R04_3, null, null, null, false);
        
		Map<String, String> result = new TestableIiR2PropertyFormatter().getAttributeNameValuePairsForTest(context, ii, iiHl7);
        assertEquals("map size", 2, result.size());
        assertTrue("no errors", modelToXmlResult.getHl7Errors().isEmpty());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
	}

	@Test
    public void testGetAttributeNameValuePairsForValidIIAsUuid() throws Exception {
		UUID randomUUID = UUID.randomUUID();
        Identifier ii = new Identifier(randomUUID.toString());
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false);
        
		Map<String, String> result = new TestableIiR2PropertyFormatter().getAttributeNameValuePairsForTest(context, ii, iiHl7);
        assertEquals("map size", 1, result.size());
        assertTrue("no errors", modelToXmlResult.getHl7Errors().isEmpty());
        
        assertKeyValuePairInMap(result, "root", randomUUID.toString());
	}

	@Test
    public void testGetAttributeNameValuePairsForInvalidIIAsUuid() throws Exception {
		UUID randomUUID = UUID.randomUUID();
        String root = randomUUID.toString() + "_zyx";
		Identifier ii = new Identifier(root);
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false);
        
		Map<String, String> result = new TestableIiR2PropertyFormatter().getAttributeNameValuePairsForTest(context, ii, iiHl7);
        assertEquals("map size", 1, result.size());
        assertFalse(modelToXmlResult.getHl7Errors().isEmpty());
        assertEquals(1, modelToXmlResult.getHl7Errors().size());
        assertEquals("root '" + root + "' must conform to be either a UUID, RUID, or OID.", modelToXmlResult.getHl7Errors().get(0).getMessage());
        
        assertKeyValuePairInMap(result, "root", root);
	}

	@Test
    public void testGetAttributeNameValuePairsForValidIIAsOid() throws Exception {
        Identifier ii = new Identifier("11.22.33.44");
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false);
        
		Map<String, String> result = new TestableIiR2PropertyFormatter().getAttributeNameValuePairsForTest(context, ii, iiHl7);
        assertEquals("map size", 1, result.size());
        assertTrue("no errors", modelToXmlResult.getHl7Errors().isEmpty());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
	}

	@Test
    public void testGetAttributeNameValuePairsForInvalidIIAsOid() throws Exception {
        Identifier ii = new Identifier("311.22.33.44");
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false);
        
		Map<String, String> result = new TestableIiR2PropertyFormatter().getAttributeNameValuePairsForTest(context, ii, iiHl7);
        assertEquals("map size", 1, result.size());
        assertFalse("one error", modelToXmlResult.isValid());
        assertEquals("one error", 1, modelToXmlResult.getHl7Errors().size());
        
        assertKeyValuePairInMap(result, "root", "311.22.33.44");
	}

	@Test
    public void testGetAttributeNameValuePairsAllFilledIn() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString");
        Map<String, String> result = new TestableIiR2PropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null, false), ii, new IIImpl(ii));
        assertEquals("map size", 2, result.size());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
    }

	@Test
    public void testGetAttributeNameValuePairsRootNotFilled() throws Exception {
        Identifier ii = new Identifier((String) null, "extension");
        ModelToXmlResult xmlResult = new ModelToXmlResult();
		IIImpl dataType = new IIImpl(ii);
		dataType.setDataType(StandardDataType.II);
		new TestableIiR2PropertyFormatter().format(new FormatContextImpl(xmlResult, null, "name", "II", null, null, false), dataType);
        assertFalse(xmlResult.isValid());
        assertEquals(1, xmlResult.getHl7Errors().size());
        assertEquals("Attribute \"root\" must be specified for II", xmlResult.getHl7Errors().get(0).getMessage());
    }

	@Test
    public void testGetAttributeNameValuePairsExtensionNotFilled() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", null);
        Map<String, String> result = new TestableIiR2PropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null, false), ii, new IIImpl(ii));
        assertEquals("map size", 1, result.size());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyNotInMap(result, "extension");
    }
	
    private void assertKeyValuePairInMap(Map<String, String> map, String key, String value) {
        assertTrue("key " + key + " as expected", map.containsKey(key));
        assertEquals("value for key " + key + " as expected", value, map.get(key));
    }

    private void assertKeyNotInMap(Map<String, String> map, String key) {
        assertTrue("key " + key + " as expected", !map.containsKey(key));
    }
}
