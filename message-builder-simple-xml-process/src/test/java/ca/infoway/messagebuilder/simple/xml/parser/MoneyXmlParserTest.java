package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Currency;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class MoneyXmlParserTest extends AbstractXmlParserTest<MO> {
	
	public MoneyXmlParserTest() {
		super(new MoneyXmlParser(), "price", new MOImpl());
	}
	
	@Test
	public void shouldParseNonNullValue() throws Exception {
		assertEquals(
				"<price currency=\"CAD\" value=\"1.12\"/>",
				this.parser.parse(createContext(), new MOImpl(new Money(new BigDecimal("1.12"), Currency.CANADIAN_DOLLAR))));
	}

	@Override
	protected MO createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new MOImpl(nullFlavor);
	}

}
