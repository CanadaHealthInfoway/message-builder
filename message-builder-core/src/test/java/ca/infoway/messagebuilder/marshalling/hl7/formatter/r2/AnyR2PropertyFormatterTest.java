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
 * Last modified: $LastChangedDate: 2014-07-10 12:26:14 -0400 (Thu, 10 Jul 2014) $
 * Revision:      $LastChangedRevision: 8803 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;

public class AnyR2PropertyFormatterTest extends FormatterTestCase {

	@Before
	public void setup() {
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}
	
	@After
	public void tearDown() {
		CodeResolverRegistry.unregisterAll();
	}
	
	@Test
	public void testPq() throws Exception {
		Object quantity = createQuantity("12", ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.GRAM);
		ANYImpl<Object> pqImpl = new ANYImpl<Object>(quantity, null, StandardDataType.PQ);
		String result = new AnyR2PropertyFormatter().format(new FormatContextImpl(this.result, null, "name", "ANY", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false), pqImpl, 0);
		assertXml("result", "<name unit=\"g\" value=\"12\" xsi:type=\"PQ\"/>", result);
		
	}

	@Test
	public void testTs() throws Exception {
		Date date = DateUtil.getDate(2003, 2, 27);
		DateWithPattern dateWithPattern = new DateWithPattern(date, "yyyyMMdd");
		ANYImpl<Object> tsImpl = new ANYImpl<Object>(new MbDate(dateWithPattern), null, StandardDataType.TS);
		String result = new AnyR2PropertyFormatter().format(new FormatContextImpl(this.result, null, "name", "ANY", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false), tsImpl, 0);
		assertXml("result", "<name value=\"20030327\" xsi:type=\"TS\"/>", result);
		
	}

	@Test
	public void testPn() throws Exception {
		PersonName name = PersonName.createFirstNameLastName("John", "Smith");
		ANYImpl<Object> pnImpl = new ANYImpl<Object>(name, null, StandardDataType.PN);
		String result = new AnyR2PropertyFormatter().format(new FormatContextImpl(this.result, null, "name", "ANY", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false), pnImpl, 0);
		assertXml("result", "<name use=\"L\" xsi:type=\"PN\"><given>John</given><family>Smith</family></name>", result);
		
	}

	@Test
	public void testSt() throws Exception {
		String myString = "some value";
		ANYImpl<Object> stImpl = new ANYImpl<Object>(myString, null, StandardDataType.ST);
		stImpl.setLanguage("en-CA");
		String result = new AnyR2PropertyFormatter().format(new FormatContextImpl(this.result, null, "name", "ANY", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false), stImpl, 0);
		assertXml("result", "<name language=\"en-CA\" xsi:type=\"ST\">some value</name>", result);
	}

	@Test
	public void testPqWithNullFlavor() throws Exception {
		ANYImpl<Object> pqImpl = new ANYImpl<Object>(null, NullFlavor.UNKNOWN, StandardDataType.PQ);
		pqImpl.setOriginalText("orig text");
		
		String result = new AnyR2PropertyFormatter().format(new FormatContextImpl(this.result, null, "name", "ANY", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false), pqImpl, 0);
		assertXml("result", "<name nullFlavor=\"UNK\"/>", result);
		assertTrue(this.result.isValid());
	}

	@Test
	public void testFormatStWithCdataValue() throws Exception {
		AnyR2PropertyFormatter formatter = new AnyR2PropertyFormatter();
		FormatContext context = getContext("name", "ANY");
		
		ANYImpl<Object> dataType = new ANYImpl<Object>("something", null, StandardDataType.ST);
		dataType.setCdata(true);
		
		String result = formatter.format(context, dataType);
		assertEquals("something in text node", addLineSeparator("<name xsi:type=\"ST\"><![CDATA[something]]></name>"), result);
		assertTrue(this.result.isValid());
	}

	@Test
	public void testNullCase() throws Exception {
		ANYImpl<Object> urgImpl = new ANYImpl<Object>(null, null, StandardDataType.AD);
		String result = new AnyR2PropertyFormatter().format(new FormatContextImpl(this.result, null, "name", "ANY", null, null, false), 
				urgImpl, 0);
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
	
	private PhysicalQuantity createQuantity(String quantity, UnitsOfMeasureCaseSensitive unit) {
		return new PhysicalQuantity(new BigDecimal(quantity), unit);
	}
	
//	@Test
//	public void testRto() throws Exception {
//		Ratio<PhysicalQuantity, PhysicalQuantity> ratio = new Ratio<PhysicalQuantity, PhysicalQuantity>();
//		ratio.setNumerator(new PhysicalQuantity(new BigDecimal(1), ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.CENTIMETRE));
//		ratio.setDenominator(new PhysicalQuantity(new BigDecimal(2), ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.METRE));
//		
//		ANYImpl<Object> rtoImpl = new ANYImpl<Object>(ratio, null, StandardDataType.RTO_PQ_DRUG_PQ_DRUG);
//		
//		String result = new AnyR2PropertyFormatter().format(new FormatContextImpl(this.result, null, "name", "ANY", null, null, false, SpecificationVersion.R02_04_02, null, null, null), rtoImpl, 0);
//		assertXml("result", "<name xsi:type=\"RTO_PQ_PQ\"><numerator unit=\"cm\" value=\"1\" xsi:type=\"PQ\"/><denominator unit=\"m\" value=\"2\" xsi:type=\"PQ\"/></name>", result);
//	}

//	@Test
//	public void testCdWithAllMetadata() throws Exception {
//		ANYImpl<Object> cdImpl = new ANYImpl<Object>(MockEnum.BARNEY, null, StandardDataType.CD_LAB);
//		cdImpl.setDisplayName("disp name");
//		cdImpl.setOriginalText("orig text");
//		cdImpl.getTranslations().add(new CDImpl(MockEnum.BETTY));
//		cdImpl.getTranslations().add(new CDImpl(MockEnum.BAM_BAM));
//		
//		String result = new AnyR2PropertyFormatter().format(new FormatContextImpl(this.result, null, "name", "ANY", null, null, false, SpecificationVersion.R02_04_02, null, null, null), cdImpl, 0);
//		assertXml("result", "<name code=\"BARNEY\" codeSystem=\"1.2.3.4.5\" displayName=\"disp name\" xsi:type=\"CD\"><originalText>orig text</originalText><translation code=\"BETTY\" codeSystem=\"1.2.3.4.5\"/><translation code=\"BAM_BAM\" codeSystem=\"1.2.3.4.5\"/></name>", result);
//		assertTrue(this.result.isValid());
//	}

//	@Test
//	public void testCdWithNullFlavorAndMetadata() throws Exception {
//		ANYImpl<Object> cdImpl = new ANYImpl<Object>(null, NullFlavor.UNKNOWN, StandardDataType.CD_LAB);
//		cdImpl.setOriginalText("orig text");
//		cdImpl.getTranslations().add(new CDImpl(MockEnum.BETTY));
//		cdImpl.getTranslations().add(new CDImpl(MockEnum.BAM_BAM));
//		
//		String result = new AnyR2PropertyFormatter().format(new FormatContextImpl(this.result, null, "name", "ANY", null, null, false, SpecificationVersion.R02_04_02, null, null, null), cdImpl, 0);
//		assertXml("result", "<name nullFlavor=\"UNK\" xsi:type=\"CD\"><originalText>orig text</originalText><translation code=\"BETTY\" codeSystem=\"1.2.3.4.5\"/><translation code=\"BAM_BAM\" codeSystem=\"1.2.3.4.5\"/></name>", result);
//		assertTrue(this.result.isValid());
//	}

//	@Test
//	public void testUrg() throws Exception {
//		UncertainRange<PhysicalQuantity> urg = UncertainRangeFactory.createLowHigh(createQuantity("55", ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.MILLIMETER), createQuantity("60", ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.MILLIMETER));
//		ANYImpl<Object> urgImpl = new ANYImpl<Object>(urg, null, StandardDataType.URG_PQ_BASIC);
//		String result = new AnyR2PropertyFormatter().format(new FormatContextImpl(this.result, null, "name", "ANY", null, null, false, SpecificationVersion.R02_04_02, null, null, null), urgImpl, 0);
//		assertXml("result", "<name xsi:type=\"URG_PQ\"><low unit=\"mm\" value=\"55\"/><high unit=\"mm\" value=\"60\"/></name>", result);
//		
//	}
	
}
