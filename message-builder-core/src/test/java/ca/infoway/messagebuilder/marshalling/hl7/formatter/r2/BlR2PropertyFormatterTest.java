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
 * Last modified: $LastChangedDate: 2013-05-16 20:18:23 -0400 (Thu, 16 May 2013) $
 * Revision:      $LastChangedRevision: 6877 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.TestableAbstractValueNullFlavorPropertyFormatter;

public class BlR2PropertyFormatterTest extends FormatterTestCase {
	
	private static class TestableBlR2PropertyFormatter extends BlR2PropertyFormatter implements TestableAbstractValueNullFlavorPropertyFormatter<Boolean> {
		public Map<String, String> getAttributeNameValuePairsForTest(FormatContext context, Boolean t, BareANY bareAny) {
			return super.getAttributeNameValuePairs(context, t, bareAny);
		}
	}

	@Test
	public void testGetAttributeNameValuePairsNullValueBL() throws Exception {
		Map<String,String>  result = new TestableBlR2PropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(this.result, null, "name", "BL", null, null, false), null, new BLImpl());

		// a null value for BL elements results in a nullFlavor attribute
		assertEquals("map size", 1, result.size());
		
		assertTrue(this.result.isValid());
		assertTrue("key as expected", result.containsKey("nullFlavor"));
		assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
	}

	@Test
	public void testGetAttributeNameValuePairsSpecifiedNullValueBL() throws Exception {
		Map<String,String>  result = new TestableBlR2PropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(this.result, null, "name", "BL", null, null, false), null, new BLImpl(NullFlavor.NOT_APPLICABLE));

		// a null value for BL elements results in a nullFlavor attribute
		assertEquals("map size", 1, result.size());
		
		assertTrue(this.result.isValid());
		assertTrue("key as expected", result.containsKey("nullFlavor"));
		assertEquals("value as expected", NullFlavor.NOT_APPLICABLE.getCodeValue(), result.get("nullFlavor"));
	}

	@Test
	public void testGetAttributeNameValuePairsBooleanTrueBL() throws Exception  {
		Map<String, String> result = new TestableBlR2PropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(this.result, null, "name", "BL", null, null, false), Boolean.TRUE, null);
		assertEquals("map size", 1, result.size());
		
		assertTrue(this.result.isValid());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "true", result.get("value"));
	}

	@Test
	public void testGetAttributeNameValuePairsBooleanFalseBL() throws Exception  {
		Map<String, String> result = new TestableBlR2PropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(this.result, null, "name", "BL", null, null, false), Boolean.FALSE, null);
		assertEquals("map size", 1, result.size());
		
		assertTrue(this.result.isValid());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "false", result.get("value"));
	}
	
	@Test
	public void testNullValueBN() throws Exception {
		// this test should go through the full formatter (as NFs can sometimes cause a short-circuit of the code path to follow)

		FormatContextImpl context = new FormatContextImpl(this.result, null, "name", "BN", null, null, false);
		String xml = new TestableBlR2PropertyFormatter().format(context, new BLImpl());

		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertXml("xml output", "<name nullFlavor=\"NI\"/>", xml);
	}

	@Test
	public void testSpecifiedNullValueBN() throws Exception {
		
		// this test should go through the full formatter (as NFs can sometimes cause a short-circuit of the code path to follow)
		
		FormatContextImpl context = new FormatContextImpl(this.result, null, "name", "BN", null, null, false);
		String xml = new TestableBlR2PropertyFormatter().format(context, new BLImpl(NullFlavor.NOT_APPLICABLE));
		
		// a null value for BL elements results in a nullFlavor attribute
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertXml("xml output", "<name nullFlavor=\"NA\"/>", xml);
	}

	@Test
	public void testGetAttributeNameValuePairsBooleanTrueBN() throws Exception  {
		Map<String, String> result = new TestableBlR2PropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(this.result, null, "name", "BN", null, null, false), Boolean.TRUE, null);
		assertEquals("map size", 1, result.size());
		
		assertTrue(this.result.isValid());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "true", result.get("value"));
	}

	@Test
	public void testGetAttributeNameValuePairsBooleanFalseBN() throws Exception  {
		Map<String, String> result = new TestableBlR2PropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(this.result, null, "name", "BN", null, null, false), Boolean.FALSE, null);
		assertEquals("map size", 1, result.size());
		
		assertTrue(this.result.isValid());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "false", result.get("value"));
	}
}
