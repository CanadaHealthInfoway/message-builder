/**
 * Copyright 2012 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

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
