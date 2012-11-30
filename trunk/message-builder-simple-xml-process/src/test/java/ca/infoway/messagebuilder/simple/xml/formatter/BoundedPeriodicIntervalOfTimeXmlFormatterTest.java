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

package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class BoundedPeriodicIntervalOfTimeXmlFormatterTest {

	private String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Before
	public void initialize() {
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@Test
	public void shouldTransformXmlToPhysicalQuantity() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<gts"+ns+"><overallTimePeriod><from value=\"19990330\" /><to value=\"20001015\" /></overallTimePeriod><frequency numberOfOccurrences=\"4\"><every value=\"7\" unit=\"day\"/></frequency></gts>");
	
		BoundedPeriodicIntervalOfTimeXmlFormatter formatter = new BoundedPeriodicIntervalOfTimeXmlFormatter(new FormatterConfiguration());
		
		Calendar fromCalendar = Calendar.getInstance();
		fromCalendar.clear();
		fromCalendar.set(1999, 2, 30);
		
		Calendar toCalendar = Calendar.getInstance();
		toCalendar.clear();
		toCalendar.set(2000, 9, 15);
		
		GTS gts = formatter.format(new FormatterContextImpl(StandardDataType.GTS, null), document.getDocumentElement());
		
		assertNotNull("gts", gts);
		
		Assert.assertEquals(fromCalendar.getTime(), gts.getValue().getDuration().getLow());
		Assert.assertEquals(toCalendar.getTime(), gts.getValue().getDuration().getHigh());
		
		Assert.assertEquals(4, gts.getValue().getFrequency().getRepetitions().intValue());
		Assert.assertEquals(new BigDecimal("7"), gts.getValue().getFrequency().getQuantity().getQuantity());
		Assert.assertEquals("day", gts.getValue().getFrequency().getQuantity().getUnit().getCodeValue());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfOverallTimePeriodIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<gts"+ns+"><frequency numberOfOccurrences=\"4\"><every value=\"7\" unit=\"day\"/></frequency></gts>");
		BoundedPeriodicIntervalOfTimeXmlFormatter formatter = new BoundedPeriodicIntervalOfTimeXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.GTS, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfFrequencyIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<gts"+ns+"><overallTimePeriod><from value=\"19990330\" /><to value=\"20001015\" /></overallTimePeriod></gts>");
		BoundedPeriodicIntervalOfTimeXmlFormatter formatter = new BoundedPeriodicIntervalOfTimeXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.GTS, null), document.getDocumentElement());
	}
	
	
	@Test
	public void shouldAllowInvalidPeriodicIntervalIfConfigurationIsPermissive() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<gts"+ns+"><overallTimePeriod><from value=\"19990330\" /><to value=\"20001015\" /></overallTimePeriod></gts>");
		
		BoundedPeriodicIntervalOfTimeXmlFormatter formatter = new BoundedPeriodicIntervalOfTimeXmlFormatter(new FormatterConfiguration(true));
		
		FormatterContextImpl formatContext = new FormatterContextImpl(StandardDataType.GTS, null);
		GTS gts = formatter.format(formatContext, document.getDocumentElement());

		assertNull("gts", gts);
		assertEquals(1, formatContext.getErrors().size());
		assertEquals("Invalid bounded periodic interval format. Both overallTimePeriod and frequency must be specified", formatContext.getErrors().get(0).getMessage());
	}
	
}
