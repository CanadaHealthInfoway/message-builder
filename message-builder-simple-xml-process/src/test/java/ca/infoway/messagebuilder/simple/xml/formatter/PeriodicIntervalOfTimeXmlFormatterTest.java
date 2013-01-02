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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.PIVL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class PeriodicIntervalOfTimeXmlFormatterTest {

	private final String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Before
	public void initialize() {
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@Test
	public void shouldTransformXmlToPhysicalQuantity() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<pivl"+this.ns+" numberOfOccurrences=\"4\"><every value=\"7\" unit=\"day\"/></pivl>");
	
		PeriodicIntervalOfTimeXmlFormatter formatter = new PeriodicIntervalOfTimeXmlFormatter(new FormatterConfiguration());
		
		PIVL pivl = formatter.format(new FormatterContextImpl(StandardDataType.PIVL_TS_DATETIME, null), document.getDocumentElement());
		assertNotNull("pivl", pivl);
		Assert.assertEquals(4, pivl.getValue().getRepetitions().intValue());
		Assert.assertEquals(new BigDecimal("7"), pivl.getValue().getQuantity().getQuantity());
		Assert.assertEquals("day", pivl.getValue().getQuantity().getUnit().getCodeValue());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfNumberOfOccurrencesIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<pivl"+this.ns+"><every value=\"7\" unit=\"day\"/></pivl>");
		PeriodicIntervalOfTimeXmlFormatter formatter = new PeriodicIntervalOfTimeXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.PIVL_TS_DATETIME, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfNumberOfOccurrencesIsInvalidInteger() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<pivl"+this.ns+" numberOfOccurrences=\"-23\"><every value=\"7\" unit=\"day\"/></pivl>");
		PeriodicIntervalOfTimeXmlFormatter formatter = new PeriodicIntervalOfTimeXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.PIVL_TS_DATETIME, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfNumberOfOccurrencesIsNotANumber() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<pivl"+this.ns+" numberOfOccurrences=\"abcg\"><every value=\"7\" unit=\"day\"/></pivl>");
		PeriodicIntervalOfTimeXmlFormatter formatter = new PeriodicIntervalOfTimeXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.PIVL_TS_DATETIME, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfFrequencyIsEmpty() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<pivl"+this.ns+" numberOfOccurrences=\"4\"></pivl>");
		PeriodicIntervalOfTimeXmlFormatter formatter = new PeriodicIntervalOfTimeXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.PIVL_TS_DATETIME, null), document.getDocumentElement());
	}
	
	@Test
	public void shouldAllowInvalidPeriodicIntervalIfConfigurationIsPermissive() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<pivl"+this.ns+" ><every value=\"7\" unit=\"day\"/></pivl>");
		
		PeriodicIntervalOfTimeXmlFormatter formatter = new PeriodicIntervalOfTimeXmlFormatter(new FormatterConfiguration(true));
		
		FormatterContextImpl formatContext = new FormatterContextImpl(StandardDataType.PIVL_TS_DATETIME, null);
		PIVL pivl = formatter.format(formatContext, document.getDocumentElement());

		assertNull("pivl", pivl);
		assertEquals(1, formatContext.getErrors().size());
		assertEquals("Invalid periodic interval format. Both \"every\" quantity and numberOfOccurrences are required.", formatContext.getErrors().get(0).getMessage());
	}
	
}
