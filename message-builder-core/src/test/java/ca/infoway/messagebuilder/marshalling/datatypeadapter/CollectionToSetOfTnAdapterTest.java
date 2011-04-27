/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TN;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;

/**
 * @sharpen.ignore - test - translated manually 
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
		
		BareANY adapted = this.adapter.adapt(list);
		assertTrue("type", adapted instanceof SET);
		
		Set<Object> set = (Set) adapted.getBareValue();
		assertEquals("size", 2, set.size());
		assertThat("all TNs", set, JUnitMatchers.everyItem(instanceOf(TN.class)));
		assertThat(set, hasItem(tn("text1")));
		assertThat(set, hasItem(tn("text2")));
	}

	@Test
	public void shouldAdaptSetCorrectly() throws Exception {
		SET<ST, String> list = new SETImpl<ST, String>(STImpl.class); 
		list.rawSet().add("text1");
		list.rawSet().add("text2");
		
		BareANY adapted = this.adapter.adapt(list);
		assertTrue("type", adapted instanceof SET);
		
		Set<Object> set = (Set) adapted.getBareValue();
		assertEquals("size", 2, set.size());
		assertThat("all TNs", set, JUnitMatchers.everyItem(instanceOf(TN.class)));
		assertThat(set, hasItem(tn("text1")));
		assertThat(set, hasItem(tn("text2")));
	}

	private Matcher<? extends Object> tn(final String text) {
		return new TypeSafeMatcher<TN>() {
			@Override
			public boolean matchesSafely(TN tn) {
				return text.equals(tn.getValue().getName());
			}
			public void describeTo(Description description) {
				description.appendText("TN(" + text + ")");
			}
		};
	}

}
