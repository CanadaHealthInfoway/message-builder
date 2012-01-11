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

package ca.infoway.messagebuilder.datatype;

import static ca.infoway.messagebuilder.datatype.Hl7TypeName.parse;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @sharpen.ignore - datatype - translated manually
 */
public class Hl7TypeNameTest {
	
	@Test
	public void shouldCorrectlyIndicateEquality() throws Exception {
		assertTrue("name", parse("RTO < PQ.DRUG, PQ.TIME >").equals(parse("RTO<PQ.DRUG,PQ.TIME>")));
		assertFalse("different specialization", parse("RTO < PQ.DRUG, PQ >").equals(parse("RTO<PQ.DRUG,PQ.TIME>")));
	}
}
