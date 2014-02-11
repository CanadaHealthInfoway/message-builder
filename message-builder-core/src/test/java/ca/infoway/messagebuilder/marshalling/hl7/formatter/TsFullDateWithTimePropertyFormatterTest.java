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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class TsFullDateWithTimePropertyFormatterTest {

	private TsFullDateWithTimePropertyFormatter formatter = new TsFullDateWithTimePropertyFormatter();
	
	@Test
	public void shouldProduceResultWithFullDateSpecializationType() {
		ModelToXmlResult result = new ModelToXmlResult();
		Date date = DateUtil.getDate(1999, 3, 23);
		TS ts = new TSImpl(date);
		ts.setDataType(StandardDataType.TS_FULLDATE);
		FormatContext context = new FormatContextImpl(result, null, "tsValue", "TS.FULLDATEWITHTIME", null, null, false, SpecificationVersion.R02_04_02, null, null, null);
		String xmlOutput = this.formatter.format(context, ts);
		assertTrue("no errors", result.getHl7Errors().isEmpty());
		assertEquals("output as expected", "<tsValue specializationType=\"TS.FULLDATE\" value=\"19990423\" xsi:type=\"TS\"/>", xmlOutput.trim());
	}
	
	@Test
	public void shouldProduceResultWithFullDateTimeSpecializationType() {
		ModelToXmlResult result = new ModelToXmlResult();
		Date date = DateUtil.getDate(1999, 3, 23, 1, 2, 3, 0);
		TS ts = new TSImpl(date);
		ts.setDataType(StandardDataType.TS_FULLDATETIME);
		FormatContext context = new FormatContextImpl(result, null, "tsValue", "TS.FULLDATEWITHTIME", null, null, false, SpecificationVersion.R02_04_02, null, null, null);
		String xmlOutput = this.formatter.format(context, ts);
		// avoid having to assess the timezone
		assertTrue("no errors", result.getHl7Errors().isEmpty());
		assertTrue(xmlOutput.trim().startsWith("<tsValue specializationType=\"TS.FULLDATETIME\" value=\"19990423010203.0000"));
		assertTrue(xmlOutput.trim().endsWith("\" xsi:type=\"TS\"/>"));
	}
	
	@Test
	public void shouldProduceResultWithMissingSpecializationTypeError() {
		ModelToXmlResult result = new ModelToXmlResult();
		Date date = DateUtil.getDate(1999, 3, 23, 1, 2, 3, 0);
		TS ts = new TSImpl(date);
		FormatContext context = new FormatContextImpl(result, null, "tsValue", "TS.FULLDATEWITHTIME", null, null, false, SpecificationVersion.R02_04_02, null, null, null);
		String xmlOutput = this.formatter.format(context, ts);
		assertEquals("1 error", 1, result.getHl7Errors().size());
		assertEquals("No specializationType provided. Value should be one of TS.FULLDATE / TS.FULLDATETIME / TS.FULLDATEPARTTIME. TS.FULLDATETIME will be assumed.", result.getHl7Errors().get(0).getMessage());
		// avoid having to assess the timezone
		assertTrue(xmlOutput.trim().startsWith("<tsValue specializationType=\"TS.FULLDATETIME\" value=\"19990423010203.0000"));
		assertTrue(xmlOutput.trim().endsWith("\" xsi:type=\"TS\"/>"));
	}
	
	@Test
	public void shouldProduceResultWithInvalidSpecializationTypeError() {
		ModelToXmlResult result = new ModelToXmlResult();
		Date date = DateUtil.getDate(1999, 3, 23, 1, 2, 3, 0);
		TS ts = new TSImpl(date);
		ts.setDataType(StandardDataType.TS_DATETIME);
		FormatContext context = new FormatContextImpl(result, null, "tsValue", "TS.FULLDATEWITHTIME", null, null, false, SpecificationVersion.R02_04_02, null, null, null);
		String xmlOutput = this.formatter.format(context, ts);
		assertEquals("1 error", 1, result.getHl7Errors().size());
		assertEquals("Invalid specializationType: TS.DATETIME. Value should be one of TS.FULLDATE / TS.FULLDATETIME / TS.FULLDATEPARTTIME. TS.FULLDATETIME will be assumed.", result.getHl7Errors().get(0).getMessage());
		// avoid having to assess the timezone
		assertTrue(xmlOutput.trim().startsWith("<tsValue specializationType=\"TS.FULLDATETIME\" value=\"19990423010203.0000"));
		assertTrue(xmlOutput.trim().endsWith("\" xsi:type=\"TS\"/>"));
	}
	
	@Test
	public void shouldProduceResultWithNoErrorsWhenNullFlavorSupplied() {
		// writing test based on RM16399
		ModelToXmlResult result = new ModelToXmlResult();
		TS ts = new TSImpl(NullFlavor.ASKED_BUT_UNKNOWN);
		FormatContext context = new FormatContextImpl(result, null, "tsValue", "TS.FULLDATEWITHTIME", ConformanceLevel.OPTIONAL, null, false, SpecificationVersion.R02_04_02, null, null, null);
		String xmlOutput = this.formatter.format(context, ts);
		assertTrue(result.isValid());
		assertEquals("<tsValue nullFlavor=\"ASKU\"/>", xmlOutput.trim());
	}
	
}
