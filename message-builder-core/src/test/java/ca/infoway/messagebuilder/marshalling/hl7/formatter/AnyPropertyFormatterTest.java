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

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.datatype.lang.util.UncertainRangeFactory;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.MockEnum;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;

public class AnyPropertyFormatterTest extends FormatterTestCase {

	@Before
	public void setup() {
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}
	
	@After
	public void tearDown() {
		CodeResolverRegistry.unregisterAll();
	}
	
	@Test
	public void testBasic() throws Exception {
		UncertainRange<PhysicalQuantity> urg = UncertainRangeFactory.createLowHigh(createQuantity("55", ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.MILLIMETER), createQuantity("60", ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.MILLIMETER));
		URGImpl<PQ, PhysicalQuantity> urgImpl = new URGImpl<PQ, PhysicalQuantity>(urg);
		urgImpl.setDataType(StandardDataType.URG_PQ_BASIC);
		String result = new AnyPropertyFormatter().format(new FormatContextImpl(new ModelToXmlResult(), null, "name", "ANY.LAB", null, null, false, SpecificationVersion.R02_04_02, null, null, null), urgImpl, 0);
		assertXml("result", "<name specializationType=\"URG_PQ.BASIC\" xsi:type=\"URG_PQ\"><low unit=\"mm\" value=\"55\"/><high unit=\"mm\" value=\"60\"/></name>", result);
		
	}

	@Test
	public void testStLang() throws Exception {
		String myString = "some value";
		ANYImpl<Object> stImpl = new ANYImpl<Object>(myString, null, StandardDataType.ST_LANG);
		stImpl.setLanguage("en-CA");
		String result = new AnyPropertyFormatter().format(new FormatContextImpl(new ModelToXmlResult(), null, "name", "ANY", null, null, false, SpecificationVersion.R02_04_02, null, null, null), stImpl, 0);
		assertXml("result", "<name language=\"en-CA\" specializationType=\"ST.LANG\" xsi:type=\"ST\">some value</name>", result);
	}

	@Test
	public void testCdWithAllMetadata() throws Exception {
		ANYImpl<Object> cdImpl = new ANYImpl<Object>(MockEnum.BARNEY, null, StandardDataType.CD_LAB);
		cdImpl.setDisplayName("disp name");
		cdImpl.setOriginalText("orig text");
		cdImpl.getTranslations().add(new CDImpl(MockEnum.BETTY));
		cdImpl.getTranslations().add(new CDImpl(MockEnum.BAM_BAM));
		
		String result = new AnyPropertyFormatter().format(new FormatContextImpl(this.result, null, "name", "ANY", null, null, false, SpecificationVersion.R02_04_02, null, null, null), cdImpl, 0);
		assertXml("result", "<name code=\"BARNEY\" codeSystem=\"1.2.3.4.5\" displayName=\"disp name\" specializationType=\"CD.LAB\" xsi:type=\"CD\"><originalText>orig text</originalText><translation code=\"BETTY\" codeSystem=\"1.2.3.4.5\"/><translation code=\"BAM_BAM\" codeSystem=\"1.2.3.4.5\"/></name>", result);
		assertTrue(this.result.isValid());
	}

	@Test
	public void testCdWithNullFlavorAndMetadata() throws Exception {
		ANYImpl<Object> cdImpl = new ANYImpl<Object>(null, NullFlavor.UNKNOWN, StandardDataType.CD_LAB);
		cdImpl.setOriginalText("orig text");
		cdImpl.getTranslations().add(new CDImpl(MockEnum.BETTY));
		cdImpl.getTranslations().add(new CDImpl(MockEnum.BAM_BAM));
		
		String result = new AnyPropertyFormatter().format(new FormatContextImpl(new ModelToXmlResult(), null, "name", "ANY", null, null, false, SpecificationVersion.R02_04_02, null, null, null), cdImpl, 0);
		assertXml("result", "<name nullFlavor=\"UNK\" specializationType=\"CD.LAB\" xsi:type=\"CD\"><originalText>orig text</originalText><translation code=\"BETTY\" codeSystem=\"1.2.3.4.5\"/><translation code=\"BAM_BAM\" codeSystem=\"1.2.3.4.5\"/></name>", result);
		assertTrue(this.result.isValid());
	}

	@Test
	public void testNullCase() throws Exception {
		URGImpl<PQ, PhysicalQuantity> urgImpl = new URGImpl<PQ, PhysicalQuantity>();
		urgImpl.setDataType(StandardDataType.URG_PQ_BASIC);		
		String result = new AnyPropertyFormatter().format(new FormatContextImpl(new ModelToXmlResult(), null, "name", "ANY.LAB", null, null), 
				urgImpl, 0);
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
	
	private PhysicalQuantity createQuantity(String quantity, UnitsOfMeasureCaseSensitive unit) {
		return new PhysicalQuantity(new BigDecimal(quantity), unit);
	}
}
