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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.Date;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.lang.EnumPattern;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;

public class IvlTsFullDateTimePropertyFormatterTest extends FormatterTestCase {
	
	public static class CustomUnit extends EnumPattern implements UnitsOfMeasureCaseSensitive {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
		private static final long serialVersionUID = -8455773998578575019L;
		public static final CustomUnit SANDWICH = new CustomUnit("SANDWICH"); 
		public static final CustomUnit COFFEE = new CustomUnit("COFFEE");
		public static final CustomUnit NEWSPAPER = new CustomUnit("NEWSPAPER");
		private CustomUnit(String name) {
			super(name);
		}
		public String getCodeSystem() {
			return null;
		}
		public String getCodeValue() {
			return name();
		}
	}
    
	@SuppressWarnings("deprecation")
	@Test
	public void testCustomUnit() throws Exception {
        Interval<Date> interval = IntervalFactory.<Date>createWidth(new DateDiff(1, CustomUnit.SANDWICH));
        String result = new IvlTsPropertyFormatter().format(getContext("name"), 
        		new IVLImpl<QTY<Date>, Interval<Date>>(interval));
        assertXml("result", "<name><width unit=\"SANDWICH\" value=\"1\"/></name>", result);
    }
    
	@Test
	public void testNullable() throws Exception {
        Interval<Date> interval = IntervalFactory.<Date>createWidth(new DateDiff(NullFlavor.OTHER));
        String result = new IvlTsPropertyFormatter().format(getContext("name"), 
        		new IVLImpl<QTY<Date>, Interval<Date>>(interval));
        assertXml("result", "<name><width nullFlavor=\"OTH\"/></name>", result);
    }
    
    @Override
    protected FormatContext getContext(String name) {
    	return new FormatContextImpl(new ModelToXmlResult(), null, name, "IVL<TS.FULLDATETIME>", null);
    }
}
