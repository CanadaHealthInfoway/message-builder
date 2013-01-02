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
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;

/**
 * @sharpen.ignore data type adapter
 */
public class TsToIvlAdapterTest {

	private TsToIvlAdapter adapter;
	
	@Before
	public void setUp() {
		this.adapter = new TsToIvlAdapter();
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@After
	public void tearDown() {
		CodeResolverRegistry.unregisterAll();
	}
	
	@Test
	public void shouldMatch() throws Exception {
		assertTrue("FULL_DATE_IVL", this.adapter.canAdapt(TS.class, StandardDataType.IVL_FULL_DATE.getType()));
		assertTrue("IVL_FULL_DATE_WITH_TIME", this.adapter.canAdapt(TS.class, StandardDataType.IVL_FULL_DATE_WITH_TIME.getType()));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldAdaptCorrectly() throws Exception {
		TSImpl ts = new TSImpl(new Date());
		BareANY adapted = this.adapter.adapt(ts);
		assertTrue(adapted instanceof IVL);
		assertEquals("low", ((IVL<TS, Interval<Date>>) adapted).getValue().getLow(), ts.getValue());
	}
	
}
