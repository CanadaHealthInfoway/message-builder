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

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;

public class IvlToTsAdapterTest {

	private IvlToTsAdapter adapter;
	
	@Before
	public void setUp() {
		this.adapter = new IvlToTsAdapter();
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@After
	public void tearDown() {
		CodeResolverRegistry.unregisterAll();
	}
	
	@Test
	public void shouldMatch() throws Exception {
		assertTrue("FULL_DATE_IVL", this.adapter.canAdapt(StandardDataType.IVL_FULL_DATE.getType(), TS.class));
		assertTrue("IVL_FULL_DATE_WITH_TIME", this.adapter.canAdapt(StandardDataType.IVL_FULL_DATE_WITH_TIME.getType(), TS.class));
	}

	@Test
	public void shouldAdaptCorrectly() throws Exception {
		IVLImpl<TS, Interval<Date>> ivl = new IVLImpl<TS, Interval<Date>>(IntervalFactory.<Date>createLow(new Date()));
		BareANY adapted = this.adapter.adapt(TS.class, ivl);
		assertTrue(adapted instanceof TS);
		assertEquals("low", ((TS) adapted).getValue(), ivl.getValue().getLow());
	}
	
}
