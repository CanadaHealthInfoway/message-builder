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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2012-08-20 19:26:20 -0400 (Mon, 20 Aug 2012) $
 * Revision:      $LastChangedRevision: 6033 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.datatype.lang.util.UncertainRangeFactory;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;

public class UrgTsPropertyFormatterTest extends FormatterTestCase {

	@Before
	public void setup() {
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}
	
	@Test
	public void testBasic() throws Exception {
		UncertainRange<Date> urg = UncertainRangeFactory.createLowHigh(DateUtil.getDate(2010, 0, 20), DateUtil.getDate(2011, 1, 21));
		
		String result = new UrgTsPropertyFormatter().format(getContext("name", "URG<TS.DATE>"), new URGImpl<TS, Date>(urg));
		
		assertTrue(this.result.isValid());
		assertXml("result", "<name><low value=\"20100120\"/><high value=\"20110221\"/></name>", result);
	}

	@Test
	public void testBasicWithInvalidInclusiveUsage() throws Exception {
		UncertainRange<Date> urg = UncertainRangeFactory.createLowHigh(DateUtil.getDate(2010, 0, 20), DateUtil.getDate(2011, 1, 21));
		urg.setHighInclusive(true);
		
		String result = new UrgTsPropertyFormatter().format(getContext("name", "URG<TS.DATE>"), new URGImpl<TS, Date>(urg));
		
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size()); // should not use inclusive fields with this datatype
		assertXml("result", "<name><low value=\"20100120\"/><high value=\"20110221\"/></name>", result);
	}

	@Test
	public void testNullCase() throws Exception {
		String result = new UrgTsPropertyFormatter().format(getContext("name", "URG<TS.DATE>"), new URGImpl<TS, Date>());
		assertTrue(this.result.isValid());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
	
}
