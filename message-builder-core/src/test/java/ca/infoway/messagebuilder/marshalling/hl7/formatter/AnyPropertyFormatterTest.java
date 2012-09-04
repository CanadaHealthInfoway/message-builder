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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.datatype.lang.util.UncertainRangeFactory;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;

public class AnyPropertyFormatterTest extends FormatterTestCase {

	@Before
	public void setup() {
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}
	
	@Test
	public void testBasic() throws Exception {
		UncertainRange<PhysicalQuantity> urg = UncertainRangeFactory.createLowHigh(createQuantity("55", ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.MILLIMETER), createQuantity("60", ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.MILLIMETER));
		URGImpl<PQ, PhysicalQuantity> urgImpl = new URGImpl<PQ, PhysicalQuantity>(urg);
		urgImpl.setDataType(StandardDataType.URG_PQ_BASIC);
		String result = new AnyPropertyFormatter().format(new FormatContextImpl(new ModelToXmlResult(), null, "name", "ANY.LAB", null, false, SpecificationVersion.R02_04_02, null, null), urgImpl, 0);
		assertXml("result", "<name specializationType=\"URG_PQ.BASIC\" xsi:type=\"URG_PQ\"><low specializationType=\"PQ.BASIC\" unit=\"mm\" value=\"55\" xsi:type=\"PQ\"/><high specializationType=\"PQ.BASIC\" unit=\"mm\" value=\"60\" xsi:type=\"PQ\"/></name>", result);
		
	}

	@Test
	public void testNullCase() throws Exception {
		URGImpl<PQ, PhysicalQuantity> urgImpl = new URGImpl<PQ, PhysicalQuantity>();
		urgImpl.setDataType(StandardDataType.URG_PQ_BASIC);		
		String result = new AnyPropertyFormatter().format(new FormatContextImpl(new ModelToXmlResult(), null, "name", "ANY.LAB", null), 
				urgImpl, 0);
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
	
	private PhysicalQuantity createQuantity(String quantity, UnitsOfMeasureCaseSensitive unit) {
		return new PhysicalQuantity(new BigDecimal(quantity), unit);
	}
}
