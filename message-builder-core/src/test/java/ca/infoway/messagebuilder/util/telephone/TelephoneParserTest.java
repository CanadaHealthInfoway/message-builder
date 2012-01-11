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

package ca.infoway.messagebuilder.util.telephone;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @sharpen.ignore - test - translated manually.
 */
public class TelephoneParserTest {

	private TelephoneParser parser;

	@Before
	public void setUp() throws Exception {
		this.parser = new TelephoneParser();
	}
	
	@Test
	public void shouldParse() throws Exception {
		assertParsable("7620032");
		assertParsable("4167896541");
		assertNotParsable("41696325874");
		assertNotParsable("1-416");
		assertParsable("1-762-0032");  // really?
		assertParsable("+1-416-762-0032 ext: 242");
		assertParsable("+1-416-762-0032;ext=242");
		assertParsable("+1-416-762-0032 x 242");
		assertParsable("+1-416-762-0032");
		assertParsable("1-416-762-0032");
		assertParsable("1-416-7620032");
		assertNotParsable("(762) 0032");
		assertParsable("762-0032");
		assertNotParsable("1-800-MYPIZZA");
		assertParsable("416-762-0032");
		assertParsable("(416)985-2364");
		assertParsable("(416) 985-2364");
		assertParsable("416 985-2364");
		assertParsable("7620032x242");
	}

	private void assertNotParsable(String number) {
		Telephone telephone = this.parser.createTelephone(number);
		assertNull(number, telephone);
	}

	private void assertParsable(String number) {
		Telephone telephone = this.parser.createTelephone(number);
		assertNotNull(number, telephone);
		assertFalse(number, StringUtils.isBlank(telephone.getHl7FormattedPhoneNumber()));
	}
}
