package ca.infoway.messagebuilder.domainvalue.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DescribableUtilTest {

	@Test
	public void testShouldConvertEnumLikeStrings() throws Exception {
		assertEquals("value", "My interesting value", DescribableUtil.getDefaultDescription("MY_INTERESTING_VALUE"));
	}
	@Test
	public void testShouldHandleEmptyString() throws Exception {
		assertEquals("value", "", DescribableUtil.getDefaultDescription(""));
	}
	@Test
	public void testShouldHandleNull() throws Exception {
		assertEquals("value", "", DescribableUtil.getDefaultDescription(null));
	}
}
