package ca.infoway.messagebuilder.marshalling.datatypeadapter;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;

/**
 * @sharpen.ignore data type adapter
 */
@SuppressWarnings("unchecked")
public class AnyToListOfAnyAdapterTest {

	private AnyToListOfAnyAdapter adapter;
	
	@Before
	public void setUp() {
		this.adapter = new AnyToListOfAnyAdapter();
	}
	
	@Test
	public void shouldMatch() throws Exception {
		assertTrue("typeName, type", this.adapter.canAdapt("II", LIST.class));
	}

	@Test
	public void shouldAdaptCorrectly() throws Exception {
		IIImpl ii = new IIImpl(new Identifier("1", "2"));
		BareANY adapted = this.adapter.adapt(ii);
		assertTrue(adapted instanceof LIST);
		assertTrue(((LIST<II, ?>) adapted).getValue().contains(ii));
	}
	
}
