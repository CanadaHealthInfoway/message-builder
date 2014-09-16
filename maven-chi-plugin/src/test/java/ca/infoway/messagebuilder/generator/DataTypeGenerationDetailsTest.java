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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-08-11 11:35:13 -0400 (Mon, 11 Aug 2014) $
 * Revision:      $LastChangedRevision: 8844 $
 */

package ca.infoway.messagebuilder.generator;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DataTypeGenerationDetailsTest {

	@Test
	public void testCodedTypeChecking() {
		assertFalse(DataTypeGenerationDetails.AD.isCoded());
		assertFalse(DataTypeGenerationDetails.BL.isCoded());
		assertFalse(DataTypeGenerationDetails.ED.isCoded());
		assertFalse(DataTypeGenerationDetails.TS.isCoded());
		assertFalse(DataTypeGenerationDetails.SXCM_INT_R2.isCoded());
		assertFalse(DataTypeGenerationDetails.SXCM.isCoded());
		assertFalse(DataTypeGenerationDetails.SXCM_R2.isCoded());
		assertFalse(DataTypeGenerationDetails.CR_R2.isCoded());
		
		assertTrue(DataTypeGenerationDetails.CD.isCoded());
		assertTrue(DataTypeGenerationDetails.CD_LAB.isCoded());
		assertTrue(DataTypeGenerationDetails.CD_R2.isCoded());
		assertTrue(DataTypeGenerationDetails.CV.isCoded());
		assertTrue(DataTypeGenerationDetails.CV_R2.isCoded());
		assertTrue(DataTypeGenerationDetails.CE.isCoded());
		assertTrue(DataTypeGenerationDetails.CE_R2.isCoded());
		assertTrue(DataTypeGenerationDetails.CO_R2.isCoded());
		
		assertFalse(DataTypeGenerationDetails.SC.isCoded());  // this should eventually be a coded type, but is not for R1 generation purposes
		assertTrue(DataTypeGenerationDetails.SC_R2.isCoded());
		
		assertTrue(DataTypeGenerationDetails.CS.isCoded());
		assertTrue(DataTypeGenerationDetails.CS_R2.isCoded());
		assertTrue(DataTypeGenerationDetails.PQR_R2.isCoded());
		assertTrue(DataTypeGenerationDetails.SXCM_CD_R2.isCoded());
		assertTrue(DataTypeGenerationDetails.BXIT_CD_R2.isCoded());
		assertTrue(DataTypeGenerationDetails.HXIT_CE_R2.isCoded());
	}
	
}
