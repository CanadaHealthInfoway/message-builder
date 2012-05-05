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

import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.DateUtil;

public class SetTsPropertyFormatterTest extends FormatterTestCase {

	@Test
    public void testFormatValueNull() throws Exception {
        String result = new SetPropertyFormatter().format(new FormatContextImpl("blah", "SET<TS>", MANDATORY), 
        		new SETImpl<TS, Date>(TSImpl.class, NullFlavor.NO_INFORMATION));
        assertXml("null", "<blah nullFlavor=\"NI\"/>", result);
    }
    
	@Test
    public void testFormatValueNonNull() throws Exception {			
        Date calendar1 = DateUtil.getDate(1999, 0, 1, 12, 29, 59, 0);
        Date calendar2 = DateUtil.getDate(2001, 1, 3, 13, 30, 00, 0);
        
        SETImpl<TS, Date> set = new SETImpl<TS, Date>(TSImpl.class);
        set.rawSet().addAll(makeSet(calendar1, calendar2));
        
		String result = new SetPropertyFormatter().format(
				new FormatContextImpl("blah", "SET<TS>", MANDATORY), 
				set);
		
	    System.setProperty("user.timezone", Calendar.getInstance().getTimeZone().getDisplayName());
		SimpleDateFormat tzformat = new SimpleDateFormat("Z");
		String currentTimeZone = tzformat.format(new Date());		
		String expectedValue1 = "19990101122959.0000" + currentTimeZone;
		String expectedValue2 = "20010203133000.0000" + currentTimeZone;
		
        assertXml("non null", "<blah value=\"" + expectedValue1 + "\"/><blah value=\"" + expectedValue2 + "\"/>", result);
    }

    private Set<Date> makeSet(Date... dates) {
        return new LinkedHashSet<Date>(Arrays.asList( dates ));
    }
}
