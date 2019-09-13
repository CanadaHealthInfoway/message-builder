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
 * Last modified: $LastChangedDate: 2012-01-10 21:44:14 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3332 $
 */
package ca.infoway.messagebuilder.generator.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import ca.infoway.messagebuilder.domainvalue.ActClassProcedure;
import ca.infoway.messagebuilder.domainvalue.ActServiceDeliveryLocationService;
import ca.infoway.messagebuilder.domainvalue.CareSummaryDocumentType;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.domainvalue.NonLabDICodedObservationSubType;

public class DomainTypeUtilTest {

	@Test
	public void shouldFindCommonAncestor() {
		DomainType ancestor = DomainTypeUtil.findCommonAncestor(new ClassBasedDomainType(HL7TriggerEventCode.class), 
				new ClassBasedDomainType(ActServiceDeliveryLocationService.class));
		assertNotNull("ancestor", ancestor);
		assertEquals("ancestor", "ActCode", ancestor.getName());
	}

	@Test
	public void shouldFindCommonAncestorMultipleLevelsDeep() {
		DomainType ancestor = DomainTypeUtil.findCommonAncestor(new ClassBasedDomainType(NonLabDICodedObservationSubType.class), 
				new ClassBasedDomainType(CareSummaryDocumentType.class));
		assertNotNull("ancestor", ancestor);
		assertEquals("ancestor", "ActCode", ancestor.getName());
	}
	
	@Test
	public void shouldDetectNoCommonAncestor() {
		DomainType ancestor = DomainTypeUtil.findCommonAncestor(new ClassBasedDomainType(HL7TriggerEventCode.class), 
				new ClassBasedDomainType(ActClassProcedure.class));
		assertNull("ancestor", ancestor);
	}
}
