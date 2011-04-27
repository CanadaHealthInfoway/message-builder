/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class RatioMoneyPerUnitXmlFormatterTest {

	private final String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Before
	public void initialize() {
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@Test
	public void shouldTransformXmlToPhysicalQuantity() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<moneyPerUnit"+this.ns+"><money currency=\"CAD\" value=\"5.3\" /><unit unit=\"days\" value=\"10\" /></moneyPerUnit>");
	
		RatioMoneyPerUnitXmlFormatter formatter = new RatioMoneyPerUnitXmlFormatter(new FormatterConfiguration());
		
		RTO<Money, PhysicalQuantity> rto = formatter.format(new FormatterContextImpl(StandardDataType.RTO_MO_CAD_PQ_BASIC, null), document.getDocumentElement());
		assertNotNull("rto", rto);
		Assert.assertEquals("5.3", rto.getValue().getNumerator().getAmount().toPlainString());
		Assert.assertEquals("CAD", rto.getValue().getNumerator().getCurrency().getCodeValue());
		Assert.assertEquals("10", rto.getValue().getDenominator().getQuantity().toPlainString());
		Assert.assertEquals("days", rto.getValue().getDenominator().getUnit().getCodeValue());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfDrugQuantityIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<moneyPerUnit"+this.ns+"><unit unit=\"days\" value=\"10\" /></moneyPerUnit>");
		RatioMoneyPerUnitXmlFormatter formatter = new RatioMoneyPerUnitXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.RTO_MO_CAD_PQ_BASIC, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfDrugQuantityIsEmpty() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<moneyPerUnit"+this.ns+"><money/><unit unit=\"days\" value=\"10\" /></moneyPerUnit>");
		RatioMoneyPerUnitXmlFormatter formatter = new RatioMoneyPerUnitXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.RTO_MO_CAD_PQ_BASIC, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfTimeIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<moneyPerUnit"+this.ns+"><money currency=\"CAD\" value=\"5.3\" /></moneyPerUnit>");
		RatioMoneyPerUnitXmlFormatter formatter = new RatioMoneyPerUnitXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.RTO_MO_CAD_PQ_BASIC, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfTimeIsEmpty() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<moneyPerUnit"+this.ns+"><money currency=\"CAD\" value=\"5.3\" /><unit/></moneyPerUnit>");
		RatioMoneyPerUnitXmlFormatter formatter = new RatioMoneyPerUnitXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.RTO_MO_CAD_PQ_BASIC, null), document.getDocumentElement());
	}
	
	@Test
	public void shouldAllowInvalidRatioIfConfigurationIsPermissive() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<moneyPerUnit"+this.ns+"><money currency=\"CAD\" value=\"5.3\" /></moneyPerUnit>");
		
		RatioMoneyPerUnitXmlFormatter formatter = new RatioMoneyPerUnitXmlFormatter(new FormatterConfiguration(true));
		
		FormatterContextImpl formatContext = new FormatterContextImpl(StandardDataType.RTO_MO_CAD_PQ_BASIC, null);
		RTO<Money, PhysicalQuantity> rto = formatter.format(formatContext, document.getDocumentElement());

		assertNull("rto", rto);
		assertEquals(1, formatContext.getErrors().size());
		assertEquals("Invalid ratio format. Both money and unit are required.", formatContext.getErrors().get(0).getMessage());
	}
	
}
