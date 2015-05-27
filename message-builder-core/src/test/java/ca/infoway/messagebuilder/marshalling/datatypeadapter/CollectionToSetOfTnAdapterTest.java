/**
 * Copyright 2013 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.marshalling.datatypeadapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TN;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;

/**
 * @sharpen.ignore - due to generics issues
 */
@SuppressWarnings("unchecked")
public class CollectionToSetOfTnAdapterTest {

	private CollectionToSetOfTnAdapter adapter;
	
	@Before
	public void setUp() {
		this.adapter = new CollectionToSetOfTnAdapter();
	}
	
	@Test
	public void shouldMatch() throws Exception {
		assertTrue("typeName, type (SET)", this.adapter.canAdapt(SET.class, "SET<TN>"));
		assertTrue("typeName, type (LIST)", this.adapter.canAdapt(LIST.class, "SET<TN>"));
	}

	@Test
	public void shouldAdaptListCorrectly() throws Exception {
		LIST<ST, String> list = new LISTImpl<ST, String>(STImpl.class); 
		list.rawList().add("text1");
		list.rawList().add("text2");
		
		BareANY adapted = this.adapter.adapt("SET<TN>", list);
		assertTrue("type", adapted instanceof SET);
		
		Set<Object> set = (Set) adapted.getBareValue();
		assertEquals("size", 2, set.size());
		assertTrue("all TNs", everyItemTN(set));
		assertTrue(hasItemWithValue(set, "text1"));
		assertTrue(hasItemWithValue(set, "text2"));
	}
	
	private boolean hasItemWithValue(Set<Object> set, String value) {
		for (Object item : set) {
			TN tnItem = (TN) item;
			if (tnItem.getValue().getName().equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean everyItemTN(Set<Object> set) {
		for (Object item : set) {
			if (!(item instanceof TN)) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void shouldAdaptSetCorrectly() throws Exception {
		SET<ST, String> list = new SETImpl<ST, String>(STImpl.class); 
		list.rawSet().add("text1");
		list.rawSet().add("text2");
		
		BareANY adapted = this.adapter.adapt("SET<TN>", list);
		assertTrue("type", adapted instanceof SET);
		
		Set<Object> set = (Set) adapted.getBareValue();
		assertEquals("size", 2, set.size());
		assertTrue("all TNs", everyItemTN(set));
		assertTrue(hasItemWithValue(set, "text1"));
		assertTrue(hasItemWithValue(set, "text2"));
	}

}
