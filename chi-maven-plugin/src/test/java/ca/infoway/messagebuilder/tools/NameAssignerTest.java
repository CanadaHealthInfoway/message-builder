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
package ca.infoway.messagebuilder.tools;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NameAssignerTest {

	@Test
	public void shouldDeriveUniqueNames() {
		NameAssigner assigner = new NameAssigner();
		assertEquals("name 1", "patient", assigner.determineName("ABCD_MT123456CA.Patient"));
		assertEquals("name 2", "patient2", assigner.determineName("ABCD_MT555555CA.Patient"));
		assertEquals("name 3", "patient3", assigner.determineName("ABCD_MT999999CA.Patient"));
	}

	@Test
	public void shouldRollOverToTen() {
		NameAssigner assigner = new NameAssigner();
		assertEquals("name 1", "patient", assigner.determineName("ABCD_MT123456CA.Patient"));
		assertEquals("name 2", "patient2", assigner.determineName("ABCD_MT555555CA.Patient"));
		assertEquals("name 3", "patient3", assigner.determineName("ABCD_MT999993CA.Patient"));
		assertEquals("name 4", "patient4", assigner.determineName("ABCD_MT999994CA.Patient"));
		assertEquals("name 5", "patient5", assigner.determineName("ABCD_MT999995CA.Patient"));
		assertEquals("name 6", "patient6", assigner.determineName("ABCD_MT999996CA.Patient"));
		assertEquals("name 7", "patient7", assigner.determineName("ABCD_MT999997CA.Patient"));
		assertEquals("name 8", "patient8", assigner.determineName("ABCD_MT999998CA.Patient"));
		assertEquals("name 9", "patient9", assigner.determineName("ABCD_MT999999CA.Patient"));
		assertEquals("name 10", "patient10", assigner.determineName("ABCD_MT999990CA.Patient"));
	}
	
	@Test
	public void shouldHandleLeadingZeroes() {
		NameAssigner assigner = new NameAssigner();
		assertEquals("name 1", "patient00", assigner.determineName("ABCD_MT123456CA.Patient00"));
		assertEquals("name 2", "patient01", assigner.determineName("ABCD_MT555555CA.Patient00"));
		assertEquals("name 3", "patient02", assigner.determineName("ABCD_MT999999CA.Patient00"));
	}
	
}
