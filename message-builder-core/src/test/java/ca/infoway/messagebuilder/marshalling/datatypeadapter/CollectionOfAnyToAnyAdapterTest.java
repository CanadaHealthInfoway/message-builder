package ca.infoway.messagebuilder.marshalling.datatypeadapter;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;

/**
 * @sharpen.ignore data type adapter
 */
public class CollectionOfAnyToAnyAdapterTest {

	private CollectionOfAnyToAnyAdapter adapter;
	
	@Before
	public void setUp() {
		this.adapter = new CollectionOfAnyToAnyAdapter();
	}
	
	@Test
	public void shouldMatch() throws Exception {
		assertTrue("typeName, type (SET)", this.adapter.canAdapt(SET.class, "II"));
		assertTrue("typeName, type (LIST)", this.adapter.canAdapt(LIST.class, "II"));
	}

	@Test
	public void shouldAdaptListCorrectly() throws Exception {
		IIImpl ii = new IIImpl(new Identifier("1", "2"));
		LIST<II, Identifier> list = new LISTImpl<II, Identifier>(IIImpl.class); 
		list.getValue().add(ii);
		
		BareANY adapted = this.adapter.adapt(list);
		assertTrue(adapted instanceof II);
		assertSame(adapted, ii);
	}

	@Test
	public void shouldAdaptSetCorrectly() throws Exception {
		IIImpl ii = new IIImpl(new Identifier("1", "2"));
		SET<II, Identifier> set = new SETImpl<II, Identifier>(IIImpl.class); 
		set.getValue().add(ii);
		
		BareANY adapted = this.adapter.adapt(set);
		assertTrue(adapted instanceof II);
		assertSame(adapted, ii);
	}
	
}
