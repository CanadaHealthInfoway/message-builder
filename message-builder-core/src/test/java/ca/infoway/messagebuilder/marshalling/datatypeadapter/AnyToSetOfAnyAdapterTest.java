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
