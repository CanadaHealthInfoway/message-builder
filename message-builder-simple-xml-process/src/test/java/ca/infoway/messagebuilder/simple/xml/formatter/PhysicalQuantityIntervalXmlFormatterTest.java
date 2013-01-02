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

package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

@RunWith(Theories.class)
public class PhysicalQuantityIntervalXmlFormatterTest {

	private static String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@DataPoint
	public static final String XML_LOW_HIGH = "<interval" + ns  + ">" + "<from value=\"5\" unit=\"mg\" />"
			+ "<to value=\"10\" unit=\"mg\" />" + "</interval>";
	@DataPoint
	public static final String XML_LOW = "<interval" + ns  + ">" + "<from value=\"5\" unit=\"mg\" />"
			+ "</interval>";
	@DataPoint
	public static final String XML_HIGH = "<interval" + ns  + ">" + "<to value=\"10\" unit=\"mg\" />"
		+ "</interval>";
	private PhysicalQuantityIntervalXmlFormatter formatter = new PhysicalQuantityIntervalXmlFormatter(new FormatterConfiguration());
	
	@Before
	public void setUp() throws Exception {
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@Theory
	public void shouldParseXml(String xml) throws Exception {
		Document document = new DocumentFactory().createFromString(xml);
		IVL<PQ, Interval<PhysicalQuantity>> interval = this.formatter.format(
				new FormatterContextImpl(StandardDataType.IVL_PQ, null), document.getDocumentElement());
		
		assertNotNull("interval", interval);
	}
	
	@Test
	public void shouldProduceMeaningfulResult() throws Exception {
		Document document = new DocumentFactory().createFromString(XML_HIGH);
		IVL<PQ, Interval<PhysicalQuantity>> interval = this.formatter.format(
				new FormatterContextImpl(StandardDataType.IVL_PQ, null), document.getDocumentElement());
		
		assertNotNull("interval", interval);
		assertNull("from", interval.getValue().getLow());
		assertNotNull("to", interval.getValue().getHigh());
		assertEquals("to amount", new BigDecimal("10"), interval.getValue().getHigh().getQuantity());
		assertEquals("to unit", "mg", interval.getValue().getHigh().getUnit().getCodeValue());
	}
}
