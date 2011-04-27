/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.generator.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import ca.infoway.messagebuilder.domainvalue.ActClass;
import ca.infoway.messagebuilder.domainvalue.ActStatus;


public class DomainRegistryTest {

	@Test
	public void shouldNotThrowExceptionOnNullParameter() throws Exception {
		assertNull("null parameter", DomainRegistry.getInstance().getDomainType(null));
	}
	
	@Test
	public void shouldResolveValue() throws Exception {
		assertEquals("value", ActClass.class, DomainRegistry.getInstance().getDomainType("ActClass"));
	}
	@Test
	public void shouldResolveValueWithWrongCase() throws Exception {
		assertEquals("value", ActClass.class, DomainRegistry.getInstance().getDomainType("actclass"));
	}
	
	@Test
	public void shouldResolveInterfaceTypesOnly() throws Exception {
		assertEquals("value", ActStatus.class, DomainRegistry.getInstance().getDomainType("ActStatus"));
	}
	
}
