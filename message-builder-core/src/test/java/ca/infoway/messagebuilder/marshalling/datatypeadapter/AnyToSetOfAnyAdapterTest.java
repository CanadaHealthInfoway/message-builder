package ca.infoway.messagebuilder.marshalling.datatypeadapter;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;

/**
 * @sharpen.ignore data type adapter
 */
public class AnyToSetOfAnyAdapterTest {

	private AnyToSetOfAnyAdapter adapter;
	
	@Before
	public void setUp() {
		this.adapter = new AnyToSetOfAnyAdapter();
	}
	
	@Test
	public void shouldMatch() throws Exception {
		assertTrue("typeName, type", this.adapter.canAdapt("II", SET.class));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldAdaptCorrectly() throws Exception {
		IIImpl ii = new IIImpl(new Identifier("1", "2"));
		BareANY adapted = this.adapter.adapt(ii);
		assertTrue(adapted instanceof SET);
		assertTrue(((SET<II, ?>) adapted).getValue().contains(ii));
	}
	
}
