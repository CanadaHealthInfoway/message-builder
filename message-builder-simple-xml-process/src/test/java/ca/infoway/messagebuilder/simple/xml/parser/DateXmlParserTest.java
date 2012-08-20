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

package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.GregorianCalendar;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.simple.xml.ParserException;

public class DateXmlParserTest extends AbstractXmlParserTest<TS> {
	
	public DateXmlParserTest() {
		super(new DateXmlParser(), "effectiveDate", new TSImpl());
	}
	
	@Test
	public void shouldParseTsDate() throws Exception {
		assertEquals(
				"<effectiveDate value=\"20101001\"/>",
				parseDate(StandardDataType.TS_DATE, "20101001", "yyyyMMdd"));
	}

	@Test
	public void shouldParseTsFullDate() throws Exception {
		assertEquals(
				"<effectiveDate value=\"20101001\"/>",
				parseDate(StandardDataType.TS_FULLDATE, "20101001", "yyyyMMdd"));
	}

	@Test
	public void shouldParseTs() throws Exception {
		assertEquals(
				"<effectiveDate value=\"20101001050607-0400\"/>",
				parseDate(StandardDataType.TS, "20101001050607-0400", "yyyyMMddHHmmssZ"));
	}

	@Test
	public void shouldParseTsDateTime() throws Exception {
		assertEquals(
				"<effectiveDate value=\"20101001050607-0400\"/>",
				parseDate(StandardDataType.TS_DATETIME, "20101001050607-0400", "yyyyMMddHHmmssZ"));
	}

	@Test
	public void shouldParseTsFullDateTime() throws Exception {
		assertEquals(
				"<effectiveDate value=\"20101001050607-0400\"/>",
				parseDate(StandardDataType.TS_FULLDATETIME, "20101001050607-0400", "yyyyMMddHHmmssZ"));
	}
	
	@Test
	public void shouldParseTsDateWithPrecisionRemembered() throws Exception {
		TSImpl ts = new TSImpl(new ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern(new GregorianCalendar(2010, 0, 1).getTime(), "yyyy"));
		ts.setDataType(StandardDataType.TS_DATE);
		
		assertEquals(
				"<effectiveDate value=\"2010\"/>",
				this.parser.parse(new SimpleXmlParseContextImpl(this.elementName), ts));
	}
	
	@Override
	protected TS createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new TSImpl(nullFlavor);
	}

	private String parseDate(StandardDataType dataType, String date, String format) throws ParserException, ParseException {
		return this.parser.parse(
				new SimpleXmlParseContextImpl(this.elementName), 
				createTs(dataType, date, format));
	}

	private TSImpl createTs(StandardDataType dataType, String date, String format) throws ParseException {
		TSImpl ts = new TSImpl(DateUtils.parseDate(date, new String[] {format}));
		ts.setDataType(dataType);
		return ts;
	}

}
