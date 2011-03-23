package ca.infoway.messagebuilder.platform;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;


public class ClassUtilTest {

	@Test
	public void shouldRecognizeGenerics() throws Exception {
		assertTrue("list", ClassUtil.isGeneric(List.class));
		assertFalse("string", ClassUtil.isGeneric(String.class));
	}
}
