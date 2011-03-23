package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.Currency;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PersonNamePartType;

public class MoPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new MoPropertyFormatter().format(getContext("name"), new MOImpl((Money) null));
		assertEquals("named null format", "<name nullFlavor=\"NI\"/>", result.trim());
	}
	
	@Test
    public void testFormatValueNonNull() throws Exception {
        MoPropertyFormatter formatter = new MoPropertyFormatter();
        
        Money money = new Money(new BigDecimal("12.00"), Currency.CANADIAN_DOLLAR);
        String result = formatter.format(getContext("amount"), new MOImpl(money));
        assertEquals("something in text node", "<amount currency=\"CAD\" value=\"12.00\"/>", result.trim());
        
        money = new Money(new BigDecimal("12"), Currency.CANADIAN_DOLLAR);
        result = formatter.format(getContext("amount"), new MOImpl(money));
        assertEquals("something in text node", "<amount currency=\"CAD\" value=\"12\"/>", result.trim());
        
        money = new Money(new BigDecimal("12.0000"), Currency.EURO);
        result = formatter.format(getContext("amount"), new MOImpl(money));
        assertEquals("something in text node", "<amount currency=\"EUR\" value=\"12.0000\"/>", result.trim());
        
        money = new Money(null, Currency.EURO);
        result = formatter.format(getContext("amount"), new MOImpl(money));
        assertEquals("something in text node", "<amount currency=\"EUR\"/>", result.trim());

        money = new Money(new BigDecimal("12.0000"), null);
        result = formatter.format(getContext("amount"), new MOImpl(money));
        assertEquals("something in text node", "<amount value=\"12.0000\"/>", result.trim());
    }

	@Test
    public void testFormatValueNonNullMultipleNameParts() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addNamePart(new EntityNamePart("prefix", PersonNamePartType.PREFIX));
        personName.addNamePart(new EntityNamePart("given", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("family", PersonNamePartType.FAMILY));
        personName.addNamePart(new EntityNamePart("suffix", PersonNamePartType.SUFFIX));
        
        String result = formatter.format(getContext("name"), new PNImpl(personName));
        assertEquals("well formed name", "<name><prefix>prefix</prefix><given>given</given><family>family</family><suffix>suffix</suffix></name>", result.trim());
    }

    @Test
	public void testFormatValueReservedXmlChars() throws Exception{
        PnPropertyFormatter formatter = new PnPropertyFormatter();
		
        PersonName personName = new PersonName();
        personName.addNamePart(new EntityNamePart("<cats think they're > humans & dogs 99% of the time/>"));

        String result = formatter.format(getContext("name"), new PNImpl(personName));
		assertEquals("something in text node", "<name>&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</name>".trim(), result.trim());
	}
}
