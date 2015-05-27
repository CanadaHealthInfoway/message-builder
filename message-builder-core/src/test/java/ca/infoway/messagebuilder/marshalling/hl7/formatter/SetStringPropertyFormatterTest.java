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

import org.junit.Assert;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class SetStringPropertyFormatterTest extends FormatterTestCase {

	private FormatterRegistry formatterRegistry = FormatterRegistry.getInstance();

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new SetPropertyFormatter(this.formatterRegistry).format(
				new FormatContextImpl(new ModelToXmlResult(), null, "blah", "SET<ST>", ConformanceLevel.MANDATORY, null, false), 
				new SETImpl<ST, String>(STImpl.class, NullFlavor.NO_INFORMATION));
        assertXml("null", "<blah nullFlavor=\"NI\"/>", result);
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		String result = new SetPropertyFormatter(this.formatterRegistry).format(
				new FormatContextImpl(new ModelToXmlResult(), null, "blah", "SET<ST>", ConformanceLevel.MANDATORY, Cardinality.create("1-4"), false), 
				SETImpl.<ST, String>create(STImpl.class, makeSet( "Fred", "Wilma" )));
		assertXml("non null", "<blah>Fred</blah><blah>Wilma</blah>", result);
	}

	@Test
	public void testFormatValueTooMany() throws Exception {
		String result = new SetPropertyFormatter(this.formatterRegistry).format(
				new FormatContextImpl(this.result, null, "blah", "SET<ST>", ConformanceLevel.MANDATORY, Cardinality.create("1-2"), false), 
				SETImpl.<ST, String>create(STImpl.class, makeSet( "Fred", "Wilma", "Barney" )));
		Assert.assertFalse(this.result.isValid());
		Assert.assertEquals(1, this.result.getHl7Errors().size());
		Assert.assertEquals("Number of elements (3) is more than the specified maximum (2)", this.result.getHl7Errors().get(0).getMessage());
		Assert.assertTrue(result.contains("<blah>Fred</blah>"));
		Assert.assertTrue(result.contains("<blah>Wilma</blah>"));
		Assert.assertTrue(result.contains("<blah>Barney</blah>"));
	}

	@Test
	public void testFormatValueTooFew() throws Exception {
		String result = new SetPropertyFormatter(this.formatterRegistry).format(
				new FormatContextImpl(this.result, null, "blah", "SET<ST>", ConformanceLevel.MANDATORY, Cardinality.create("4-6"), false), 
				SETImpl.<ST, String>create(STImpl.class, makeSet( "Fred", "Wilma", "Barney" )));
		Assert.assertFalse(this.result.isValid());
		Assert.assertEquals(1, this.result.getHl7Errors().size());
		Assert.assertEquals("Number of elements (3) is less than the specified minimum (4)", this.result.getHl7Errors().get(0).getMessage());
		Assert.assertTrue(result.contains("<blah>Fred</blah>"));
		Assert.assertTrue(result.contains("<blah>Wilma</blah>"));
		Assert.assertTrue(result.contains("<blah>Barney</blah>"));
	}

}
