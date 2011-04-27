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

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

@RunWith(Theories.class)
public class DateIntervalXmlFormatterTest {

	private static String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@DataPoint
	public static final String XML_LOW_HIGH = "<interval" + ns  + ">" + "<from value=\"20100218\" />"
			+ "<to value=\"20100222\" />" + "</interval>";
	@DataPoint
	public static final String XML_LOW = "<interval" + ns  + ">" + "<from value=\"20100218\" />"
			+ "</interval>";
	@DataPoint
	public static final String XML_LOW_DURATION = "<interval" + ns  + ">" + "<from value=\"20100218\" />"
		+ "<duration value=\"5\" unit=\"d\" />" + "</interval>";
	@DataPoint
	public static final String XML_HIGH_DURATION = "<interval" + ns  + ">" 
		+ "<duration value=\"5\" unit=\"d\" />" 
		+ "<to value=\"20100218\" />"
		+ "</interval>";
	@DataPoint
	public static final String XML_DURATION = "<interval" + ns  + ">" + "<duration value=\"5\" unit=\"d\" />"
		+ "</interval>";
	DateIntervalXmlFormatter formatter = new DateIntervalXmlFormatter(new FormatterConfiguration());
	
	@Before
	public void setUp() throws Exception {
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@Theory
	public void shouldParseXml(String xml) throws Exception {
		Document document = new DocumentFactory().createFromString(xml);
		IVL<TS, Interval<Date>> interval = this.formatter.format(
				new FormatterContextImpl(StandardDataType.IVL_TS, null), document.getDocumentElement());
		
		assertNotNull("interval", interval);
	}
}
