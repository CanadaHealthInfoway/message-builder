package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class RealConfXmlParserTest  extends AbstractXmlParserTest<REAL> {
	
	public RealConfXmlParserTest() {
		super(new RealXmlParser(), "amount", new REALImpl());
	}
	
	@Test
	public void shouldParseZeroValue() throws Exception {
		assertEquals(
				"<amount>0.0000</amount>",
				this.parser.parse(createContext(), createRealConf("0")));
	}

	@Test
	public void shouldParseZeroOne() throws Exception {
		assertEquals(
				"<amount>1.0000</amount>",
				this.parser.parse(createContext(), createRealConf("1")));
	}
	
	@Test
	public void shouldParseValue() throws Exception {
		assertEquals(
				"<amount>0.2564</amount>",
				this.parser.parse(createContext(), createRealConf("0.2564")));
		
	}

	@Test
	public void shouldParseValueAndRownDown() throws Exception{
		assertEquals(
				"<amount>0.2564</amount>",
				this.parser.parse(createContext(), createRealConf("0.256444444")));
	}
	
	@Test
	public void shouldParseValueAndRownUp() throws Exception{
		assertEquals(
				"<amount>0.2565</amount>",
				this.parser.parse(createContext(), createRealConf("0.256455555")));
	}
	
	private REALImpl createRealConf(String realValue) {
		REALImpl real = new REALImpl(new BigDecimal(realValue));
		real.setDataType(StandardDataType.REAL_CONF);
		return real;
	}


	@Override
	protected REAL createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new REALImpl(nullFlavor);
	}

}
