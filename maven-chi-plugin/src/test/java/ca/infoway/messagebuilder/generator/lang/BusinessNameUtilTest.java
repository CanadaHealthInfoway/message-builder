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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.lang;

import static org.junit.Assert.assertEquals;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;


@RunWith(Theories.class)
public class BusinessNameUtilTest {

	@DataPoint public static final String[] CASE1 = {"Service %Location", "ServiceLocation"};
	@DataPoint public static final String[] CASE2 = {"*b1:recorded at", "RecordedAt"};
	@DataPoint public static final String[] CASE3 = {"b1:recorded at?", "RecordedAt"};
	@DataPoint public static final String[] CASE4 = {"policy/account code", "PolicyAccountCode"};
	@DataPoint public static final String[] CASE5 = {"*annotated by", "AnnotatedBy"};
	@DataPoint public static final String[] CASE6 = {"*g:occurred at ", "OccurredAt"};
	@DataPoint public static final String[] CASE7 = {"*g:occurred at\u00A0", "OccurredAt"};
	@DataPoint public static final String[] CASE8 = {"*g:occurred at\u2007", "OccurredAt"};
	@DataPoint public static final String[] CASE9 = {"*g:occurred at\u202F", "OccurredAt"};
	@DataPoint public static final String[] CASE10 ={"\u00A0*g:occurred at", "OccurredAt"};
	@DataPoint public static final String[] CASE11 ={"*g:occurred\u00A0at", "OccurredAt"};
	
	@Theory
	public void shouldCleanUpBusinessName(String[] testCase) throws Exception {
		assertEquals(testCase[1], BusinessNameUtil.cleanUpBusinessName(testCase[0]));
	}	
}
