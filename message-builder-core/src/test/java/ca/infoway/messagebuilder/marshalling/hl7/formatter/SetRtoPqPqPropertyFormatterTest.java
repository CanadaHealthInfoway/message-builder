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

import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;
import ca.infoway.messagebuilder.xml.Cardinality;

/**
 * @sharpen.ignore - translate manually due to generics
 */
public class SetRtoPqPqPropertyFormatterTest extends FormatterTestCase {

	private FormatterRegistry formatterRegistry = FormatterRegistry.getInstance();

	@Before
	public void setup() {
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}
	
	@SuppressWarnings("unchecked")
	@Test
    public void testFormatValueNonNull() throws Exception {

		PhysicalQuantity numerator1 = new PhysicalQuantity(BigDecimal.ONE, UnitsOfMeasureCaseSensitive.CENTIMETRE);
		PhysicalQuantity denominator1 = new PhysicalQuantity(new BigDecimal(2), UnitsOfMeasureCaseSensitive.CUBIC_CENTIMETER);

		PhysicalQuantity numerator2 = new PhysicalQuantity(BigDecimal.TEN, UnitsOfMeasureCaseSensitive.MILLIMETER);
		PhysicalQuantity denominator2 = new PhysicalQuantity(new BigDecimal(11), UnitsOfMeasureCaseSensitive.CUBIC_MILIMETER);

		Ratio<PhysicalQuantity,PhysicalQuantity> ratio1 = new Ratio<PhysicalQuantity,PhysicalQuantity>(numerator1, denominator1);
		Ratio<PhysicalQuantity,PhysicalQuantity> ratio2 = new Ratio<PhysicalQuantity,PhysicalQuantity>(numerator2, denominator2);

        SETImpl<RTO<PhysicalQuantity,PhysicalQuantity>,Ratio<PhysicalQuantity,PhysicalQuantity>> set = new SETImpl<RTO<PhysicalQuantity,PhysicalQuantity>,Ratio<PhysicalQuantity,PhysicalQuantity>>(RTOImpl.class);
        set.rawSet().addAll(makeSet(ratio1, ratio2));

		String result = new SetPropertyFormatter(this.formatterRegistry).format(
				new FormatContextImpl(new ModelToXmlResult(), null, "blah", "SET<RTO<PQ.DRUG,PQ.TIME>>", MANDATORY, Cardinality.create("1-4"), false, SpecificationVersion.R02_04_02, null, null, null, false),
				set);

        assertXml("non null", "<blah><numerator unit=\"cm\" value=\"1\"/><denominator unit=\"cm3\" value=\"2\"/></blah><blah><numerator unit=\"mm\" value=\"10\"/><denominator unit=\"mm3\" value=\"11\"/></blah>", result);
    }

    private Set<Ratio<PhysicalQuantity,PhysicalQuantity>> makeSet(Ratio<PhysicalQuantity,PhysicalQuantity>... ratios) {
        return new LinkedHashSet<Ratio<PhysicalQuantity,PhysicalQuantity>>(Arrays.asList( ratios ));
    }
}
