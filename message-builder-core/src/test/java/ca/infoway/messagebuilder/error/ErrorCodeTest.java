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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.error;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

public class ErrorCodeTest {
	@Test
	public void testAllHl7ErrorCodesAreInErrorCode() {
		List<Hl7ErrorCode> oldErrorCode = Hl7ErrorCode.values(Hl7ErrorCode.class);
		for (int i = 0; i < oldErrorCode.size(); i++) {
			ErrorCode newErrorCode = TransformError.transformCode(oldErrorCode.get(i));
			if (newErrorCode == null) {
				fail("ErrorCode is missing Hl7ErrorCode: " + oldErrorCode.get(i).name());
			}
		}
	}
	
}
