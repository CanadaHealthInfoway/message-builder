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
package ca.infoway.messagebuilder.datatype.lang;

import java.util.Date;

import org.junit.Test;

import ca.infoway.messagebuilder.domainvalue.NullFlavor;

public class IntervalFactoryTest {

	@Test
	public void testNullParameters() {
		IntervalFactory.createCentre((Date) null);
		IntervalFactory.createCentre((Date) null, (NullFlavor) null);
		IntervalFactory.createCentreHigh((Date) null, (Date) null);
		IntervalFactory.createCentreHigh((Date) null, (Date) null, (NullFlavor) null, (NullFlavor) null);
		IntervalFactory.createCentreWidth((Date) null, (Diff<Date>) null);
		IntervalFactory.createCentreWidth((Date) null, (Diff<Date>) null, (NullFlavor) null);
		IntervalFactory.createHigh((Date) null);
		IntervalFactory.createHigh((Date) null, (NullFlavor) null);
		IntervalFactory.createLow((Date) null);
		IntervalFactory.createLow((Date) null, (NullFlavor) null);
		IntervalFactory.createLowCentre((Date) null, (Date) null);
		IntervalFactory.createLowCentre((Date) null, (Date) null, (NullFlavor) null, (NullFlavor) null);
		IntervalFactory.createLowHigh((Date) null, (Date) null);
		IntervalFactory.createLowHigh((Date) null, (Date) null, (NullFlavor) null, (NullFlavor) null);
		IntervalFactory.createLowWidth((Date) null, (Diff<Date>) null);
		IntervalFactory.createLowWidth((Date) null, (Diff<Date>) null, (NullFlavor) null);
		IntervalFactory.createSimple((Date) null);
		IntervalFactory.createWidth((Diff<Date>) null);
		IntervalFactory.createWidthHigh((Diff<Date>) null, (Date) null);
		IntervalFactory.createWidthHigh((Diff<Date>) null, (Date) null, (NullFlavor) null);
	}
	
}
