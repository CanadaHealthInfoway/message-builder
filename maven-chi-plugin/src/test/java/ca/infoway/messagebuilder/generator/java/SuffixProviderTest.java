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

package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class SuffixProviderTest {

	private SuffixProvider suffixProvider = new SuffixProvider();
	
	@Test
	public void shouldFindASuffix() throws Exception {
		assertEquals("suffix", "_1", this.suffixProvider.getSuffix("fred"));
	}
	
	@Test
	public void shouldIncrementEachNameUniquely() throws Exception {
		assertEquals("suffix", "_1", this.suffixProvider.getSuffix("fred"));
		assertEquals("suffix", "_1", this.suffixProvider.getSuffix("wilma"));
		assertEquals("suffix", "_2", this.suffixProvider.getSuffix("fred"));
		assertEquals("suffix", "_3", this.suffixProvider.getSuffix("fred"));
		assertEquals("suffix", "_2", this.suffixProvider.getSuffix("wilma"));
	}
}
