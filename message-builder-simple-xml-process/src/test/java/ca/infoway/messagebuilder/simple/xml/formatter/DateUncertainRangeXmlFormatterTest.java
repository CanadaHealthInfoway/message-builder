/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

@RunWith(Theories.class)
public class DateUncertainRangeXmlFormatterTest {

	private static String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@DataPoint
	public static final String XML_LOW_HIGH = "<range" + ns  + ">" + "<from value=\"20100218\" />"
			+ "<to value=\"20100222\" />" + "</range>";
	@DataPoint
	public static final String XML_LOW = "<range" + ns  + ">" + "<from value=\"20100218\" />"
			+ "</range>";
	@DataPoint
	public static final String XML_LOW_DURATION = "<range" + ns  + ">" + "<from value=\"20100218\" />"
		+ "<duration value=\"5\" unit=\"d\" />" + "</range>";
	@DataPoint
	public static final String XML_HIGH_DURATION = "<range" + ns  + ">" 
		+ "<duration value=\"5\" unit=\"d\" />" 
		+ "<to value=\"20100218\" />"
		+ "</range>";
	@DataPoint
	public static final String XML_CENTER_HIGH = "<range" + ns  + ">" 
		+ "<center value=\"20100220\" />"		
		+ "<to value=\"20100222\" />"
		+ "</range>";
	@DataPoint
	public static final String XML_CENTER = "<range" + ns  + ">" 
		+ "<center value=\"20100220\" />"		
		+ "</range>";
	@DataPoint
	public static final String XML_DURATION = "<range" + ns  + ">" + "<duration value=\"5\" unit=\"d\" />"
		+ "</range>";
	DateUncertainRangeXmlFormatter formatter = new DateUncertainRangeXmlFormatter(new FormatterConfiguration());
	
	@Before
	public void setUp() throws Exception {
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@Theory
	public void shouldParseXml(String xml) throws Exception {
		Document document = new DocumentFactory().createFromString(xml);
		URG<TS, Date> interval = this.formatter.format(
				new FormatterContextImpl(StandardDataType.URG_TS_DATE, null), document.getDocumentElement());
		
		assertNotNull("interval", interval);
	}
	@Test
	public void shouldProduceResult() throws Exception {
		Document document = new DocumentFactory().createFromString(XML_CENTER_HIGH);
		URG<TS, Date> interval = this.formatter.format(
				new FormatterContextImpl(StandardDataType.URG_TS_DATE, null), document.getDocumentElement());
		
		assertNotNull("interval", interval);
		assertNotNull("interval high", interval.getValue().getHigh());
		assertNotNull("interval low", interval.getValue().getLow());
		assertNotNull("interval center", interval.getValue().getCentre());
		assertEquals("interval center", DateUtil.getDate(2010, Calendar.FEBRUARY, 20), interval.getValue().getCentre());
		assertEquals("interval low", DateUtil.getDate(2010, Calendar.FEBRUARY, 18), interval.getValue().getLow());
		assertEquals("interval high", DateUtil.getDate(2010, Calendar.FEBRUARY, 22), interval.getValue().getHigh());
	}
}
