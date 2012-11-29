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
 * Last modified: $LastChangedDate: 2012-01-10 21:44:14 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3332 $
 */
package ca.infoway.messagebuilder.generator.util;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;

public class ClassBasedDomainTypeTest {

	@Test
	public void shouldFindParentTypes() throws Exception {
		ClassBasedDomainType domainType = new ClassBasedDomainType(HL7TriggerEventCode.class);
		List<DomainType> list = domainType.getParentDomainTypes();
		assertEquals("size", 1, list.size());
		assertEquals("ActCode", "ActCode", list.get(0).getName());
	}

}
