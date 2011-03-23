package ca.infoway.messagebuilder.util.iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * @sharpen.ignore - util.iterator - translated manually
 */
public class EmptyIterableTest {
	
	@Test
	public void testNullSafeIterable() throws Exception {
		List<String> thing = null;
		assertIterable(EmptyIterable.nullSafeIterable(thing));
	}
	private void assertIterable(Iterable<?> i) {
		assertNotNull("iterable", i);
		assertNotNull("iterator", i.iterator());
		assertFalse("has next", i.iterator().hasNext());
		try {
			i.iterator().next();
			fail("next");
		} catch (NoSuchElementException e) {
		}
	}
	public void testNullSafeIterableArray() throws Exception {
		String[] list = null;
		assertIterable(EmptyIterable.nullSafeIterable(list));
	}
	@Test
	public void testArray() throws Exception {
		String[] list = new String[] { "Fred" };
		Iterable<String> i = EmptyIterable.nullSafeIterable(list);
		assertNotNull("iterable", i);
		Iterator<String> iterator = i.iterator();
		assertNotNull("iterator", iterator);
		assertNotNull("hasNext()", iterator.hasNext());
		assertEquals("next()", "Fred", iterator.next());
		assertFalse("no more", iterator.hasNext());
	}
	@Test
	public void testNullSafeIterableMap() throws Exception {
		Map<String,Date> map = null;
		assertIterable(EmptyIterable.nullSafeKeySetIterable(map));
	}
	@Test
	public void testNullSafeIterableMapValues() throws Exception {
		Map<String,Date> map = null;
		assertIterable(EmptyIterable.nullSafeValuesIterable(map));
	}
}
