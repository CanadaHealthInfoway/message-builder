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
 * Last modified: $LastChangedDate: 2012-01-10 20:35:55 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3319 $
 */
package ca.infoway.messagebuilder.marshalling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.marshalling.DomainTypeHelper;

public class DomainTypeHelperTest {

	@Test
	public void shouldSanitizeDomainName() throws Exception {
		assertEquals("1", "NonPersonLivingSubject", DomainTypeHelper.sanitize("Non-personLivingSubject"));
		assertEquals("2", "HL7TriggerEventCode", DomainTypeHelper.sanitize("HL7TriggerEventCode"));
		assertEquals("3", "x_VeryBasicConfidentialityKind", DomainTypeHelper.sanitize("x_VeryBasicConfidentialityKind"));
	}

}
