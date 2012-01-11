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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;


public class GenericDataTypeFactoryTest {

	@Test
	public void shouldFindIntervalTypes() throws Exception {
		assertType("IVL<PQ.BASIC>");
		assertType("IVL<TS.FULLDATETIME>");
		assertType("IVL<TS.DATE>");
	}

	private void assertType(String type) {
		assertNotNull("type " + type, GenericDataTypeFactory.create(type));
	}
	
	@Test
	public void shouldFindListTypes() throws Exception {
		assertType("LIST<II.OID>");
		assertType("LIST<GTS.BOUNDEDPIVL>");
		assertType("LIST<PN.BASIC>");
		assertType("LIST<TEL.PHONEMAIL>");
	}
}
