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
 * Author:        $LastChangedBy: gng $
 * Last modified: $LastChangedDate: 2013-04-08 11:07:24 -0400 (Mon, 08 Apr 2013) $
 * Revision:      $LastChangedRevision: 6766 $
 */

package ca.infoway.messagebuilder.marshalling.polymorphism;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.marshalling.polymorphism.PolymorphismHandler;

public class PolymorphismHandlerTest {

	private PolymorphismHandler handler = new PolymorphismHandler(); 
	
	@Test
	public void testValidTypeSwitching() {
		assertTrue(this.handler.isValidTypeChange(StandardDataType.TS, StandardDataType.SXCM_TS));
		assertTrue(this.handler.isValidTypeChange(StandardDataType.TS, StandardDataType.PIVL_TS));
		assertTrue(this.handler.isValidTypeChange(StandardDataType.TS, StandardDataType.IVL_TS));
		assertTrue(this.handler.isValidTypeChange(StandardDataType.TS, StandardDataType.EIVL_TS));
		assertTrue(this.handler.isValidTypeChange(StandardDataType.TS, StandardDataType.SXCM_TS));
		
		assertTrue(this.handler.isValidTypeChange(StandardDataType.SXCM_TS, StandardDataType.PIVL_TS));
		assertTrue(this.handler.isValidTypeChange(StandardDataType.SXCM_TS, StandardDataType.IVL_TS));
		assertTrue(this.handler.isValidTypeChange(StandardDataType.SXCM_TS, StandardDataType.EIVL_TS));

		assertTrue(this.handler.isValidTypeChange(StandardDataType.CD, StandardDataType.CE));
		assertTrue(this.handler.isValidTypeChange(StandardDataType.CD, StandardDataType.BXIT_CD));
		assertTrue(this.handler.isValidTypeChange(StandardDataType.CD, StandardDataType.SXCM_CD));
		assertTrue(this.handler.isValidTypeChange(StandardDataType.CD, StandardDataType.CV));
		assertTrue(this.handler.isValidTypeChange(StandardDataType.CD, StandardDataType.HXIT_CE));
		assertTrue(this.handler.isValidTypeChange(StandardDataType.CD, StandardDataType.CS));
		assertTrue(this.handler.isValidTypeChange(StandardDataType.CD, StandardDataType.CO));
		
		assertTrue(this.handler.isValidTypeChange(StandardDataType.CE, StandardDataType.CV));
		assertTrue(this.handler.isValidTypeChange(StandardDataType.CE, StandardDataType.HXIT_CE));
		assertTrue(this.handler.isValidTypeChange(StandardDataType.CE, StandardDataType.CS));
		assertTrue(this.handler.isValidTypeChange(StandardDataType.CE, StandardDataType.CO));
		
		assertTrue(this.handler.isValidTypeChange(StandardDataType.CV, StandardDataType.CS));
		assertTrue(this.handler.isValidTypeChange(StandardDataType.CV, StandardDataType.CO));
		
		assertTrue(this.handler.isValidTypeChange(StandardDataType.EN, StandardDataType.PN));
		assertTrue(this.handler.isValidTypeChange(StandardDataType.EN, StandardDataType.ON));
		assertTrue(this.handler.isValidTypeChange(StandardDataType.EN, StandardDataType.TN));
		
		assertTrue(this.handler.isValidTypeChange(StandardDataType.TS, StandardDataType.TS));
		assertTrue(this.handler.isValidTypeChange(StandardDataType.AD, StandardDataType.AD));
	}
	
	@Test
	public void testValidTypeNameSwitching() {
		assertTrue(this.handler.isValidTypeChange("TS", "IVL<TS>"));
		assertTrue(this.handler.isValidTypeChange("SXCM<TS>", "EIVL<TS>"));
		assertTrue(this.handler.isValidTypeChange("CD", "CS"));
		assertTrue(this.handler.isValidTypeChange("CE", "CV"));
		assertTrue(this.handler.isValidTypeChange("CV", "CO"));
		assertTrue(this.handler.isValidTypeChange("EN", "PN"));
	}
	
	@Test
	public void testInvalidTypeSwitching() {
		assertFalse(this.handler.isValidTypeChange(StandardDataType.SXCM_TS, StandardDataType.TS));
		assertFalse(this.handler.isValidTypeChange(StandardDataType.IVL_TS, StandardDataType.SXCM_TS));
		assertFalse(this.handler.isValidTypeChange(StandardDataType.CE, StandardDataType.CD));
		assertFalse(this.handler.isValidTypeChange(StandardDataType.CS, StandardDataType.CV));
		assertFalse(this.handler.isValidTypeChange(StandardDataType.ON, StandardDataType.PN));
		assertFalse(this.handler.isValidTypeChange(StandardDataType.PN, StandardDataType.EN));
	}
	
	@Test
	public void testInvalidTypeNameSwitching() {
		assertFalse(this.handler.isValidTypeChange("TS", "IVL_TS"));
		
		assertFalse(this.handler.isValidTypeChange("SXCM_TS", "EIVL_TS"));

		assertFalse(this.handler.isValidTypeChange("CS", "CD"));
		
		assertFalse(this.handler.isValidTypeChange("PN", "EN"));
	}
}
