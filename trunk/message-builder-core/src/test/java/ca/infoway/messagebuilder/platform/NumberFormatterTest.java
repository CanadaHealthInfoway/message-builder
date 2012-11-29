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

package ca.infoway.messagebuilder.platform;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;


public class NumberFormatterTest {

	@Test
	public void shouldFormatBigDecimal() throws Exception {
		assertEquals("result", "1.00", new NumberFormatter().format(new BigDecimal("1.0"), 10, 1, 2, true));
		assertEquals("result", "1", new NumberFormatter().format(new BigDecimal("1.0"), 10, 1, 2, false));
		assertEquals("result", "11.00", new NumberFormatter().format(new BigDecimal("11111.0"), 5, 2, 2, true));
		
		// BCH: This result is questionable.  Confirm at a later date.
		assertEquals("result", "11", new NumberFormatter().format(new BigDecimal("11111.0"), 5, 2, 2, false));
	}
	
	@Test
	public void shouldRound() throws Exception {
		assertEquals("result", "1.01", new NumberFormatter().format(new BigDecimal("1.008"), 10, 1, 2, true));
	}
}
