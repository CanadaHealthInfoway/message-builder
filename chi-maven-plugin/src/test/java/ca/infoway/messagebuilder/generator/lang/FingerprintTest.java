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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.lang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class FingerprintTest {

	@Test
	public void shouldConcat() throws Exception {
		
		Fingerprint fingerprint = new Fingerprint(RelationshipType.ATTRIBUTE, "name");
		Fingerprint fingerprint2 = new Fingerprint(RelationshipType.ASSOCIATION, "ABCD_MT123456CA.Person");
		assertEquals("string", "ABCD_MT123456CA.Person/name", fingerprint2.concat(fingerprint).toString());
	}
}
