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
 * Last modified: $LastChangedDate: 2013-02-25 19:53:06 -0500 (Mon, 25 Feb 2013) $
 * Revision:      $LastChangedRevision: 6643 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.util.Currency;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;

public class MoR2PropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		FormatContext context = getContext("name");
		String result = new MoR2PropertyFormatter().format(context, new MOImpl((Money) null));
		assertEquals("named null format", "<name nullFlavor=\"NI\"/>", result.trim());
		assertTrue(context.getModelToXmlResult().isValid());
	}
	
	@Test
    public void testFormatValueNonNull() throws Exception {
        MoR2PropertyFormatter formatter = new MoR2PropertyFormatter();
        
        Money money = new Money(new BigDecimal("12.00"), Currency.CANADIAN_DOLLAR);
        FormatContext context = getContext("amount");
		String result = formatter.format(context, new MOImpl(money));
        assertEquals("something in text node", "<amount currency=\"CAD\" value=\"12.00\"/>", result.trim());
		assertTrue(context.getModelToXmlResult().isValid());

        context.getModelToXmlResult().clearErrors();
        
        money = new Money(new BigDecimal("12"), Currency.CANADIAN_DOLLAR);
        result = formatter.format(context, new MOImpl(money));
        assertEquals("something in text node", "<amount currency=\"CAD\" value=\"12\"/>", result.trim());
		assertTrue(context.getModelToXmlResult().isValid());
        
        context.getModelToXmlResult().clearErrors();

        money = new Money(new BigDecimal("12.0000"), Currency.EURO);
        result = formatter.format(context, new MOImpl(money));
        assertEquals("something in text node", "<amount currency=\"EUR\" value=\"12.0000\"/>", result.trim());
		assertTrue(context.getModelToXmlResult().isValid());
		
        context.getModelToXmlResult().clearErrors();

        money = new Money(null, Currency.EURO);
        result = formatter.format(context, new MOImpl(money));
        assertEquals("something in text node", "<amount currency=\"EUR\"/>", result.trim());
		assertTrue(context.getModelToXmlResult().isValid());

        context.getModelToXmlResult().clearErrors();

        money = new Money(new BigDecimal("12.0000"), null);
        result = formatter.format(context, new MOImpl(money));
		assertTrue(context.getModelToXmlResult().isValid());
		
        context.getModelToXmlResult().clearErrors();

        money = new Money(new BigDecimal("123456789012.00"), Currency.CANADIAN_DOLLAR);
        result = formatter.format(context, new MOImpl(money));
        assertEquals("something in text node", "<amount currency=\"CAD\" value=\"123456789012.00\"/>", result.trim());
		assertTrue(context.getModelToXmlResult().isValid());
		
        context.getModelToXmlResult().clearErrors();

        money = new Money(new BigDecimal("-89012.00"), Currency.CANADIAN_DOLLAR);
        result = formatter.format(context, new MOImpl(money));
        assertEquals("something in text node", "<amount currency=\"CAD\" value=\"-89012.00\"/>", result.trim());
		assertFalse(context.getModelToXmlResult().isValid());
		assertEquals(1, context.getModelToXmlResult().getHl7Errors().size()); // only digits allowed
    }

	@Test
    public void testFormatValueNonNullWithOperatorNotAllowed() throws Exception {
        MoR2PropertyFormatter formatter = new MoR2PropertyFormatter();
        
        Money money = new Money(new BigDecimal("12.00"), Currency.CANADIAN_DOLLAR);
        FormatContext context = getContext("amount");
		MOImpl dataType = new MOImpl(money);
		dataType.setOperator(SetOperator.CONVEX_HULL);
		
		String result = formatter.format(context, dataType);
        assertEquals("something in text node", "<amount currency=\"CAD\" value=\"12.00\"/>", result.trim());
		assertFalse(context.getModelToXmlResult().isValid());
		assertEquals(1, context.getModelToXmlResult().getHl7Errors().size());
		assertTrue(context.getModelToXmlResult().getHl7Errors().get(0).getMessage().toLowerCase().contains("operator"));
	}
	
	@Test
    public void testFormatSxcmValueNonNullWithOperatorAllowed() throws Exception {
        MoR2PropertyFormatter formatter = new MoR2PropertyFormatter();
        
        Money money = new Money(new BigDecimal("12.00"), Currency.CANADIAN_DOLLAR);
        FormatContext context = getContext("amount", "SXCM<TS>");
		MOImpl dataType = new MOImpl(money);
		dataType.setOperator(SetOperator.CONVEX_HULL);
		
		String result = formatter.format(context, dataType);
        assertEquals("something in text node", "<amount currency=\"CAD\" operator=\"H\" value=\"12.00\"/>", result.trim());
		assertTrue(context.getModelToXmlResult().isValid());
	}
	
	@Test
    public void testFormatSxcmValueNonNullWithNoOperator() throws Exception {
        MoR2PropertyFormatter formatter = new MoR2PropertyFormatter();
        
        Money money = new Money(new BigDecimal("12.00"), Currency.CANADIAN_DOLLAR);
        FormatContext context = getContext("amount", "SXCM<TS>");
		MOImpl dataType = new MOImpl(money);
		
		String result = formatter.format(context, dataType);
        assertEquals("something in text node", "<amount currency=\"CAD\" value=\"12.00\"/>", result.trim());
		assertTrue(context.getModelToXmlResult().isValid());
	}
}
