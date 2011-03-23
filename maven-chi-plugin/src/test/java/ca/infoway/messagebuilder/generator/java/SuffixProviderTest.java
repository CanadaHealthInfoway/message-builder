package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class SuffixProviderTest {

	private SuffixProvider suffixProvider = new SuffixProvider();
	
	@Test
	public void shouldFindASuffix() throws Exception {
		assertEquals("suffix", "_1", this.suffixProvider.getSuffix("fred"));
	}
	
	@Test
	public void shouldIncrementEachNameUniquely() throws Exception {
		assertEquals("suffix", "_1", this.suffixProvider.getSuffix("fred"));
		assertEquals("suffix", "_1", this.suffixProvider.getSuffix("wilma"));
		assertEquals("suffix", "_2", this.suffixProvider.getSuffix("fred"));
		assertEquals("suffix", "_3", this.suffixProvider.getSuffix("fred"));
		assertEquals("suffix", "_2", this.suffixProvider.getSuffix("wilma"));
	}
}
