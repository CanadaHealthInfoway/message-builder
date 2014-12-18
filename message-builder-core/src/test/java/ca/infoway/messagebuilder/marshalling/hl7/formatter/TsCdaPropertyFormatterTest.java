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
 * Last modified: $LastChangedDate: 2013-05-15 18:39:56 -0400 (Wed, 15 May 2013) $
 * Revision:      $LastChangedRevision: 6874 $
 */
package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.SXCMTSCDAR1Impl;
import ca.infoway.messagebuilder.datatype.impl.TSCDAR1Impl;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class TsCdaPropertyFormatterTest {

	private TsCdaPropertyFormatter formatter = new TsCdaPropertyFormatter();
	
	@Test
	public void testTs() {
		ModelToXmlResult result = new ModelToXmlResult();
		Date date = DateUtil.getDate(2012, 4, 3);
		DateWithPattern dateWithPattern = new DateWithPattern(date, "yyyyMMdd");
		BareANY dataType = new TSCDAR1Impl(new MbDate(dateWithPattern));
		
		FormatContext formatContext = new FormatContextImpl(
				result, "", "date", "TSCDAR1", null, ConformanceLevel.MANDATORY, Cardinality.create("1"), false, SpecificationVersion.R02_04_03, null, null, null, null, true);
		
		String xml = this.formatter.format(formatContext, dataType);
		
		assertTrue(result.isValid());
		assertEquals("<date value=\"20120503\"/>", xml.trim());
	}
	
	@Test
	public void testSxcmTs() {
		ModelToXmlResult result = new ModelToXmlResult();
		Date date = DateUtil.getDate(2013, 5, 4);
		DateWithPattern dateWithPattern = new DateWithPattern(date, "yyyyMMdd");
		BareANY dataType = new SXCMTSCDAR1Impl(new MbDate(dateWithPattern));
		((ANYMetaData) dataType).setOperator(SetOperator.EXCLUDE);
		
		FormatContext formatContext = new FormatContextImpl(
				result, "", "date", "SXCMTSCDAR1", null, ConformanceLevel.MANDATORY, Cardinality.create("1"), false, SpecificationVersion.R02_04_03, null, null, null, null, true);
		
		String xml = this.formatter.format(formatContext, dataType);
		
		assertTrue(result.isValid());
		assertEquals("<date operator=\"E\" value=\"20130604\"/>", xml.trim());
	}
}
