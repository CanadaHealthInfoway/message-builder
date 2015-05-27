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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.datatype.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class ANYImplTest {
	
	@Test
	public void twoNullFlavorsAreNeverEqual() throws Exception {
		ANYImpl<String> anyImpl1 = new BarDataType();
		anyImpl1.setNullFlavor(NullFlavor.ASKED_BUT_UNKNOWN);
		ANYImpl<String> anyImpl2 = new BarDataType();
		anyImpl2.setNullFlavor(NullFlavor.ASKED_BUT_UNKNOWN);
		assertFalse(anyImpl1.equals(anyImpl2));
	}

	@Test
	public void twoH7ValuesAreEqualWhenTheyAreNotNullFlavorsAndTheirValuesAreEqual() throws Exception {
		ANYImpl<String> anyImpl1 = new BarDataType();
		anyImpl1.setValue("same");
		ANYImpl<String> anyImpl2 = new BarDataType();
		anyImpl2.setValue("same");
		assertTrue(anyImpl1.equals(anyImpl2));
	}
	
	class BarDataType extends ANYImpl<String> {
	}
	
}
