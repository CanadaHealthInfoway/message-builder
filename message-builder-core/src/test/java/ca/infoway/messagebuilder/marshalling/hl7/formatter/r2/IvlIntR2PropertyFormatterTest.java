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
 * Last modified: $LastChangedDate: 2013-05-16 20:18:23 -0400 (Thu, 16 May 2013) $
 * Revision:      $LastChangedRevision: 6877 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Diff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class IvlIntR2PropertyFormatterTest extends FormatterTestCase {
	
	private IvlIntR2PropertyFormatter formatter;
	
	@Before
	public void setUp() throws Exception {
		this.formatter = new IvlIntR2PropertyFormatter();
	}

	@Override
	protected FormatContext getContext(String name) {
		return new FormatContextImpl(new ModelToXmlResult(), null, name, "IVL<INT>", ConformanceLevel.POPULATED, null, false);
	}
	
	@Test
	public void testSimpleWithOperator() throws Exception {
		Interval<Integer> ivl = IntervalFactory.<Integer>createSimple(new Integer(5), SetOperator.EXCLUDE);
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Integer>, Interval<Integer>>(ivl));
		assertXml("result", "<name operator=\"E\" value=\"5\"/>", result);
	}
	
	@Test
	public void testBasic() throws Exception {
		Interval<Integer> ivl = IntervalFactory.<Integer>createLowHigh(new Integer(1), new Integer(3));
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Integer>, Interval<Integer>>(ivl));
		assertXml("result", "<name><low value=\"1\"/><high value=\"3\"/></name>", result);
	}
	
	@Test
	public void testBasicWithInclusive() throws Exception {
		Interval<Integer> ivl = IntervalFactory.<Integer>createLowHigh(new Integer(1), new Integer(3));
		ivl.setLowInclusive(true);
		ivl.setHighInclusive(false);
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Integer>, Interval<Integer>>(ivl));
		assertXml("result", "<name><low inclusive=\"true\" value=\"1\"/><high inclusive=\"false\" value=\"3\"/></name>", result);
	}
	
	@Test
	public void testIntervalLow() throws Exception {
		Interval<Integer> ivl = IntervalFactory.<Integer>createLow(new Integer(1));
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Integer>, Interval<Integer>>(ivl));
		assertXml("result", "<name><low value=\"1\"/></name>", result);
	}

	@Test
	public void testNullCase() throws Exception {
		String result = this.formatter.format(getContext("name"), new IVLImpl<QTY<Integer>, Interval<Integer>>());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
	
	@Test
	public void testIntervalWidth() throws Exception {
		Interval<Integer> ivl = IntervalFactory.<Integer>createWidth(new Diff<Integer>(new Integer(2)));
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Integer>, Interval<Integer>>(ivl));
		assertXml("result", "<name><width value=\"2\"/></name>", result);
	}
}
