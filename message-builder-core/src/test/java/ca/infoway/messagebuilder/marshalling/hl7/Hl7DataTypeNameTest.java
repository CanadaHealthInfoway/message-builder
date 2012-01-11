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

package ca.infoway.messagebuilder.marshalling.hl7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Hl7DataTypeNameTest {
	
	@Test
	public void testShouldDetermineUnqualifiedName() throws Exception {
		Hl7DataTypeName name = Hl7DataTypeName.create("TS.FULLDATE");
		assertEquals("TS", name.getUnqualifiedVersion().toString());
	}
	@Test
	public void testShouldRecognizeQualifiedTypes() throws Exception {
		Hl7DataTypeName name = Hl7DataTypeName.create("TS.FULLDATE");
		assertTrue("TS.FULLDATE", name.isQualified());
	}
	@Test
	public void testShouldDetermineUnqualifiedCollectionName() throws Exception {
		Hl7DataTypeName name = Hl7DataTypeName.create("SET<TS.FULLDATE>");
		assertEquals("SET<TS>", name.getUnqualifiedVersion().toString());
	}
	@Test
	public void testShouldDetermineUnqualifiedComplicatedName() throws Exception {
		Hl7DataTypeName name = Hl7DataTypeName.create("RTO<MO.CAD,PQ.BASIC>");
		assertEquals("RTO<MO,PQ>", name.getUnqualifiedVersion().toString());
	}
}
