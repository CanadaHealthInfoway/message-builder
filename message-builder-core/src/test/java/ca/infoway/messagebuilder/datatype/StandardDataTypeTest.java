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

package ca.infoway.messagebuilder.datatype;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static ca.infoway.messagebuilder.datatype.StandardDataType.convertSimpleXmlToDataType;

import org.junit.Test;

import ca.infoway.messagebuilder.xml.Hl7TypeName;

public class StandardDataTypeTest {
	
	@Test
	public void shouldGetHl7TypeName() throws Exception {
		Hl7TypeName typeName = StandardDataType.AD_BASIC.getTypeName();
		assertEquals("name", "AD.BASIC", typeName.toString());
		assertEquals("unqualified name", "AD", typeName.getUnspecializedName());
	}

	@Test
	public void shouldGetRootName() throws Exception {
		assertEquals("AD", "AD", StandardDataType.AD_BASIC.getTypeName().getRootName());
		assertEquals("IVL", "IVL", StandardDataType.IVL_FULL_DATE.getTypeName().getRootName());
	}

	@Test
	public void shouldCalculateIsCoded() throws Exception {
		assertTrue("CD", StandardDataType.CD.isCoded());
		assertTrue("CD.LAB", StandardDataType.CD_LAB.isCoded());
		assertTrue("CV", StandardDataType.CV.isCoded());
		assertFalse("ST", StandardDataType.ST.isCoded());
	}
	
	@Test
	public void shouldResolveSimpleXmlType() throws Exception {
		assertEquals("II", StandardDataType.II, convertSimpleXmlToDataType("InstanceIdentifier"));
		assertEquals("TS.DATE", StandardDataType.TS_DATE, convertSimpleXmlToDataType("PartialDate"));
	}
	
}
