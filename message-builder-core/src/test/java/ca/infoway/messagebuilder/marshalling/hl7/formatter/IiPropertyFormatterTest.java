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

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;

public class IiPropertyFormatterTest extends MarshallingTestCase {

	@Test
    public void testGetAttributeNameValuePairsForValidII() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString");
        
        II iiHl7 = new IIImpl();
        iiHl7.setDataType(StandardDataType.II_BUS);
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II", null, false, SpecificationVersion.R02_04_02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 4, result.size());
        assertTrue("no errors", modelToXmlResult.getHl7Errors().isEmpty());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
        assertKeyValuePairInMap(result, "use", "BUS");
        assertKeyValuePairInMap(result, "specializationType", "II.BUS");
    }

	@Test
    public void testGetAttributeNameValuePairsForII_InvalidSpecializationType() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString");
        
        II iiHl7 = new IIImpl();
        iiHl7.setDataType(StandardDataType.II_BUS_AND_VER);
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II", null, false, SpecificationVersion.R02_04_02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 2, result.size());
        assertFalse("errors", modelToXmlResult.getHl7Errors().isEmpty());
        assertEquals(1, modelToXmlResult.getHl7Errors().size());
        assertEquals("Invalid specializationType (II.BUS_AND_VER). Field being left as II without a specializationType.", modelToXmlResult.getHl7Errors().get(0).getMessage());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
	}

	@Test
    public void testGetAttributeNameValuePairsForValidIICeRx() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString");
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II", null, false, SpecificationVersion.V01R04_3, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 2, result.size());
        assertTrue("no errors", modelToXmlResult.getHl7Errors().isEmpty());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
	}

	@Test
    public void testGetAttributeNameValuePairsForValidII_TOKEN() throws Exception {
		UUID randomUUID = UUID.randomUUID();
        Identifier ii = new Identifier(randomUUID.toString());
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II.TOKEN", null, false, SpecificationVersion.R02_04_02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 1, result.size());
        assertTrue("no errors", modelToXmlResult.getHl7Errors().isEmpty());
        
        assertKeyValuePairInMap(result, "root", randomUUID.toString());
	}

	@Test
    public void testGetAttributeNameValuePairsForInvalidII_TOKEN() throws Exception {
        Identifier ii = new Identifier("1.2.3.4");
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II.TOKEN", null, false, SpecificationVersion.R02_04_02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 1, result.size());
        assertFalse(modelToXmlResult.getHl7Errors().isEmpty());
        assertEquals(1, modelToXmlResult.getHl7Errors().size());
        assertEquals("root '1.2.3.4' should be a UUID.", modelToXmlResult.getHl7Errors().get(0).getMessage());
        
        assertKeyValuePairInMap(result, "root", "1.2.3.4");
	}

	@Test
    public void testGetAttributeNameValuePairsForValidII_OID() throws Exception {
        Identifier ii = new Identifier("11.22.33.44");
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II.OID", null, false, SpecificationVersion.R02_04_02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 2, result.size());
        assertTrue("no errors", modelToXmlResult.getHl7Errors().isEmpty());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "use", "BUS");
	}

	@Test
    public void testGetAttributeNameValuePairsForInvalidII_OID_shouldNotHaveExtension() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "shouldNotBeHere");
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II.OID", null, false, SpecificationVersion.R02_04_02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 3, result.size());
        assertFalse(modelToXmlResult.getHl7Errors().isEmpty());
        assertEquals(1, modelToXmlResult.getHl7Errors().size());
        assertEquals("Attribute \"extension\" is not allowed for II.OID", modelToXmlResult.getHl7Errors().get(0).getMessage());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "shouldNotBeHere");
        assertKeyValuePairInMap(result, "use", "BUS");
	}

	@Test
    public void testGetAttributeNameValuePairsForInvalidII_OID_rootTooLong() throws Exception {
        String tooLongRoot = "12345678900.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789";
		Identifier ii = new Identifier(tooLongRoot);
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II.OID", null, false, SpecificationVersion.R02_04_02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 2, result.size());
        assertFalse(modelToXmlResult.getHl7Errors().isEmpty());
        assertEquals(1, modelToXmlResult.getHl7Errors().size());
        assertEquals("root '" + tooLongRoot + "' exceeds maximum allowed length of 200.", modelToXmlResult.getHl7Errors().get(0).getMessage());
        
        assertKeyValuePairInMap(result, "root", tooLongRoot);
        assertKeyValuePairInMap(result, "use", "BUS");
	}

	@Test
    public void testGetAttributeNameValuePairsForInvalidII_OID() throws Exception {
		UUID randomUUID = UUID.randomUUID();
        Identifier ii = new Identifier(randomUUID.toString());
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II.OID", null, false, SpecificationVersion.R02_04_02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 2, result.size());
        assertFalse(modelToXmlResult.getHl7Errors().isEmpty());
        assertEquals(1, modelToXmlResult.getHl7Errors().size());
        assertEquals("The oid, \"" + randomUUID.toString() + "\" does not appear to be a valid oid", modelToXmlResult.getHl7Errors().get(0).getMessage());
        
        assertKeyValuePairInMap(result, "root", randomUUID.toString());
        assertKeyValuePairInMap(result, "use", "BUS");
	}

	@Test
    public void testGetAttributeNameValuePairsForValidII_OID_MR2007() throws Exception {
        Identifier ii = new Identifier("11.22.33.44");
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II.OID", null, false, SpecificationVersion.V02R02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 1, result.size());
        assertTrue("no errors", modelToXmlResult.getHl7Errors().isEmpty());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
	}

	@Test
    public void testGetAttributeNameValuePairsForValidII_BUS() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString");
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II.BUS", null, false, SpecificationVersion.R02_04_02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 3, result.size());
        assertTrue("no errors", modelToXmlResult.getHl7Errors().isEmpty());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
        assertKeyValuePairInMap(result, "use", "BUS");
	}

	@Test
    public void testGetAttributeNameValuePairsForValidII_BUS_asUuid() throws Exception {
		UUID randomUUID = UUID.randomUUID();
        Identifier ii = new Identifier(randomUUID.toString());
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II.BUS", null, false, SpecificationVersion.R02_04_02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 2, result.size());
        assertTrue("no errors", modelToXmlResult.getHl7Errors().isEmpty());
        
        assertKeyValuePairInMap(result, "root", randomUUID.toString());
        assertKeyValuePairInMap(result, "use", "BUS");
	}

	@Test
    public void testGetAttributeNameValuePairsForValidII_VER() throws Exception {
		UUID randomUUID = UUID.randomUUID();
        Identifier ii = new Identifier(randomUUID.toString());
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II.VER", null, false, SpecificationVersion.R02_04_02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 2, result.size());
        assertTrue("no errors", modelToXmlResult.getHl7Errors().isEmpty());
        
        assertKeyValuePairInMap(result, "root", randomUUID.toString());
        assertKeyValuePairInMap(result, "use", "VER");
	}

	@Test
    public void testGetAttributeNameValuePairsForValidII_BUS_AND_VER() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString");
        
        II iiHl7 = new IIImpl();
        iiHl7.setDataType(StandardDataType.II_BUS);
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II.BUS_AND_VER", null, false, SpecificationVersion.R02_04_02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 4, result.size());
        assertTrue("no errors", modelToXmlResult.getHl7Errors().isEmpty());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
        assertKeyValuePairInMap(result, "use", "BUS");
        assertKeyValuePairInMap(result, "specializationType", "II.BUS");
	}

	@Test
    public void testGetAttributeNameValuePairsForII_BUS_AND_VER_InvalidSpecializationType() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString");
        
        II iiHl7 = new IIImpl();
        iiHl7.setDataType(StandardDataType.II_OID);
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II.BUS_AND_VER", null, false, SpecificationVersion.R02_04_02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 4, result.size());
        assertFalse("errors", modelToXmlResult.getHl7Errors().isEmpty());
        assertEquals(1, modelToXmlResult.getHl7Errors().size());
        assertEquals("Specialization type must be II.BUS or II.VER; II.BUS will be assumed. Invalid specialization type II.OID", modelToXmlResult.getHl7Errors().get(0).getMessage());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
        assertKeyValuePairInMap(result, "use", "BUS");
        assertKeyValuePairInMap(result, "specializationType", "II.BUS");
	}

	@Test
    public void testGetAttributeNameValuePairsForII_BUS_UnnecessarySpecializationType() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString");
        
        II iiHl7 = new IIImpl();
        iiHl7.setDataType(StandardDataType.II_OID);
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II.BUS", null, false, SpecificationVersion.R02_04_02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 3, result.size());
        assertFalse("errors", modelToXmlResult.getHl7Errors().isEmpty());
        assertEquals(1, modelToXmlResult.getHl7Errors().size());
        assertEquals("A specializationType should not be specified for non-abstract type: II.BUS" , modelToXmlResult.getHl7Errors().get(0).getMessage());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
        assertKeyValuePairInMap(result, "use", "BUS");
	}

	@Test
    public void testGetAttributeNameValuePairsForValidII_PUBLIC() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString");
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II.PUBLIC", null, false, SpecificationVersion.R02_04_02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 4, result.size());
        assertTrue("no errors", modelToXmlResult.getHl7Errors().isEmpty());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
        assertKeyValuePairInMap(result, "use", "BUS");
        assertKeyValuePairInMap(result, "displayable", "true");
	}

	@Test
    public void testGetAttributeNameValuePairsForInvalidII_PUBLIC() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionStrngTooLong");
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II.PUBLIC", null, false, SpecificationVersion.R02_04_02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 4, result.size());
        assertFalse("errors", modelToXmlResult.getHl7Errors().isEmpty());
        assertEquals(1, modelToXmlResult.getHl7Errors().size());
        assertEquals("extension 'extensionStrngTooLong' exceeds maximum allowed length of 20." , modelToXmlResult.getHl7Errors().get(0).getMessage());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionStrngTooLong");
        assertKeyValuePairInMap(result, "use", "BUS");
        assertKeyValuePairInMap(result, "displayable", "true");
	}

	@Test
    public void testGetAttributeNameValuePairsForValidII_PUBLIC_MR2007() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString");
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II.PUBLIC", null, false, SpecificationVersion.V02R02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 3, result.size());
        assertTrue("no errors", modelToXmlResult.getHl7Errors().isEmpty());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
        assertKeyValuePairInMap(result, "displayable", "true");
	}

	@Test
    public void testGetAttributeNameValuePairsForValidII_PUBLICVER() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString", "a_version_string");
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II.PUBLICVER", null, false, SpecificationVersion.R02_04_02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 4, result.size());
        assertTrue("no errors", modelToXmlResult.getHl7Errors().isEmpty());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
        assertKeyValuePairInMap(result, "version", "a_version_string");
        assertKeyValuePairInMap(result, "displayable", "true");
	}

	@Test
    public void testGetAttributeNameValuePairsForValidII_BUSVER() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString", "a_version_string");
        
        II iiHl7 = new IIImpl();
        
        ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
		FormatContextImpl context = new FormatContextImpl(modelToXmlResult, null, "name", "II.BUSVER", null, false, SpecificationVersion.R02_04_02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 4, result.size());
        assertTrue("no errors", modelToXmlResult.getHl7Errors().isEmpty());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
        assertKeyValuePairInMap(result, "version", "a_version_string");
        assertKeyValuePairInMap(result, "use", "BUS");
	}

	@Test
    public void testGetAttributeNameValuePairsAllFilledIn() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString");
        Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null), ii, new IIImpl(ii));
        assertEquals("map size", 2, result.size());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
    }

	@Test
    public void testGetAttributeNameValuePairsAllFilledInIncludingSpecializationType() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString");
        
        II iiHl7 = new IIImpl();
        iiHl7.setDataType(StandardDataType.II_BUS);
        
        FormatContextImpl context = new FormatContextImpl(new ModelToXmlResult(), null, "name", "II.BUS_AND_VER", null, true, SpecificationVersion.R02_04_02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 4, result.size());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
        assertKeyValuePairInMap(result, "specializationType", "II.BUS");
        assertKeyValuePairInMap(result, "use", "BUS");
    }

	@Test
    public void testGetAttributeNameValuePairsAllFilledInForIiPublicInMr2007() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString");
        
        II iiHl7 = new IIImpl();
        iiHl7.setDataType(StandardDataType.II_PUBLIC);
        
        FormatContextImpl context = new FormatContextImpl(new ModelToXmlResult(), null, "name", "II.PUBLIC", null, true, SpecificationVersion.V02R02, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 3, result.size());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
        assertKeyValuePairInMap(result, "displayable", "true");
    }

	@Test
    public void testGetAttributeNameValuePairsAllFilledInForIiPublicInMr2009() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString");
        
        II iiHl7 = new IIImpl();
        iiHl7.setDataType(StandardDataType.II_PUBLIC);
        
        FormatContextImpl context = new FormatContextImpl(new ModelToXmlResult(), null, "name", "II.PUBLIC", null, true, SpecificationVersion.R02_04_03, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 4, result.size());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
        assertKeyValuePairInMap(result, "displayable", "true");
        assertKeyValuePairInMap(result, "use", "BUS");
    }

	@Test
    public void testGetAttributeNameValuePairsAllFilledInExcludingSpecializationTypeForCeRx() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString");
        
        II iiHl7 = new IIImpl();
        iiHl7.setDataType(StandardDataType.II);
        
        FormatContextImpl context = new FormatContextImpl(new ModelToXmlResult(), null, "name", "II", null, true, SpecificationVersion.V01R04_3, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 2, result.size());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
    }

	@Test
    public void testGetAttributeNameValuePairsAllFilledInExcludingSpecializationTypeForAB() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", "extensionString");
        
        II iiHl7 = new IIImpl();
        iiHl7.setDataType(StandardDataType.II);
        
        FormatContextImpl context = new FormatContextImpl(new ModelToXmlResult(), null, "name", "II", null, true, SpecificationVersion.V02R02_AB, null, null, null);
        
		Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(context, ii, iiHl7);
        assertEquals("map size", 2, result.size());
        
        assertKeyValuePairInMap(result, "root", "11.22.33.44");
        assertKeyValuePairInMap(result, "extension", "extensionString");
    }

	@Test
    public void testGetAttributeNameValuePairsAllFilledInWithTypeId() throws Exception {
    	Identifier ii = new Identifier("11.22.33.44", "extensionString");
    	Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null), ii, new IIImpl(ii));
    	assertEquals("map size", 2, result.size());
    	
    	assertKeyValuePairInMap(result, "root", "11.22.33.44");
    	assertKeyValuePairInMap(result, "extension", "extensionString");
    }
    
	@Test
    public void testGetAttributeNameValuePairsRootNotFilled() throws Exception {
        Identifier ii = new Identifier((String) null, "extension");
        ModelToXmlResult xmlResult = new ModelToXmlResult();
		IIImpl dataType = new IIImpl(ii);
		dataType.setDataType(StandardDataType.II_BUS);
		new IiPropertyFormatter().format(new FormatContextImpl(xmlResult, null, "name", "II.BUS", null), dataType);
        assertFalse(xmlResult.isValid());
        assertEquals(1, xmlResult.getHl7Errors().size());
        assertEquals("Attribute \"root\" must be specified for II.BUS", xmlResult.getHl7Errors().get(0).getMessage());
    }

	@Test
    public void testGetAttributeNameValuePairsExtensionNotFilled() throws Exception {
        Identifier ii = new Identifier("11.22.33.44", null);
        Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null), ii, new IIImpl(ii));
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
