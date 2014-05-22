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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Diff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalFactory;
import ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class IvlPqPropertyFormatterTest extends FormatterTestCase {

	private static final PhysicalQuantity PHYSICAL_QUANTITY_LOW = new PhysicalQuantity(new BigDecimal(1000),
			UnitsOfMeasureCaseSensitive.MILLILITRE);
	private static final PhysicalQuantity PHYSICAL_QUANTITY_HIGH = new PhysicalQuantity(new BigDecimal(2000),
			UnitsOfMeasureCaseSensitive.MILLILITRE);
	
	private IvlPqPropertyFormatter formatter;

	@Before
	public void setUp() throws Exception {
		this.formatter = new IvlPqPropertyFormatter();
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}

	@Override
	protected FormatContext getContext(String name) {
		return new FormatContextImpl(new ModelToXmlResult(), null, name, "IVL<PQ>", null, ConformanceLevel.POPULATED, null, false, SpecificationVersion.R02_04_03, null, null, null);
	}

	@Test
	public void testBasic() throws Exception {
		Interval<PhysicalQuantity> interval = IntervalFactory.<PhysicalQuantity>createLowHigh(PHYSICAL_QUANTITY_LOW, PHYSICAL_QUANTITY_HIGH);
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<PhysicalQuantity>, Interval<PhysicalQuantity>>(interval));
		assertXml("result", "<name><low unit=\"mL\" value=\"1000\"/><high unit=\"mL\" value=\"2000\"/></name>", result);
	}

	@Test
	public void testIntervalLow() throws Exception {
		Interval<PhysicalQuantity> low = IntervalFactory.<PhysicalQuantity>createLow(PHYSICAL_QUANTITY_LOW);
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<PhysicalQuantity>, Interval<PhysicalQuantity>>(low));
		assertXml("result", "<name><low unit=\"mL\" value=\"1000\"/></name>", result);
	}

	@Test
	public void testNullCase() throws Exception {
		String result = this.formatter.format(getContext("name"), new IVLImpl<QTY<PhysicalQuantity>, Interval<PhysicalQuantity>>());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}

	@Test
	public void testIntervalWidth() throws Exception {
		Interval<PhysicalQuantity> interval = IntervalFactory.<PhysicalQuantity>createWidth(new Diff<PhysicalQuantity>(PHYSICAL_QUANTITY_LOW));
		String result = this.formatter.format(getContext("name"), 
			new IVLImpl<QTY<PhysicalQuantity>, Interval<PhysicalQuantity>>(interval));
		assertXml("result", "<name><width unit=\"mL\" value=\"1000\"/></name>", result);
	}
}
