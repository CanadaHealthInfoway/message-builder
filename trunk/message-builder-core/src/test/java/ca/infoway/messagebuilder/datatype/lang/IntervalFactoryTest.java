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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.datatype.lang;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.lang.util.IntervalFactory;

public class IntervalFactoryTest {

	@Test
	public void testNullParameters() {
		IntervalFactory.createCentre(null);
		IntervalFactory.createCentre(null, null);
		IntervalFactory.createCentreHigh(null, null);
		IntervalFactory.createCentreHigh(null, null, null, null);
		IntervalFactory.createCentreWidth(null, null);
		IntervalFactory.createCentreWidth(null, null, null);
		IntervalFactory.createHigh(null);
		IntervalFactory.createHigh(null, null);
		IntervalFactory.createLow(null);
		IntervalFactory.createLow(null, null);
		IntervalFactory.createLowCentre(null, null);
		IntervalFactory.createLowCentre(null, null, null, null);
		IntervalFactory.createLowHigh(null, null);
		IntervalFactory.createLowHigh(null, null, null, null);
		IntervalFactory.createLowWidth(null, null);
		IntervalFactory.createLowWidth(null, null, null);
		IntervalFactory.createSimple(null);
		IntervalFactory.createWidth(null);
		IntervalFactory.createWidthHigh(null, null);
		IntervalFactory.createWidthHigh(null, null, null);
	}
	
}
