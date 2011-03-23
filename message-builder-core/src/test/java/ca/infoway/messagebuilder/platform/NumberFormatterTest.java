package ca.infoway.messagebuilder.platform;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import ca.infoway.messagebuilder.platform.NumberFormatter;


public class NumberFormatterTest {

	@Test
	public void shouldFormatBigDecimal() throws Exception {
		assertEquals("result", "1.00", new NumberFormatter().format(new BigDecimal("1.0"), 10, 2, true));
		assertEquals("result", "1", new NumberFormatter().format(new BigDecimal("1.0"), 10, 2, false));
		assertEquals("result", "11.00", new NumberFormatter().format(new BigDecimal("11111.0"), 5, 2, true));
		
		// BCH: This result is questionable.  Confirm at a later date.
		assertEquals("result", "11", new NumberFormatter().format(new BigDecimal("11111.0"), 5, 2, false));
	}
	
	@Test
	public void shouldRound() throws Exception {
		assertEquals("result", "1.01", new NumberFormatter().format(new BigDecimal("1.008"), 10, 2, true));
	}
}
