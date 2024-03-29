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

package ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer;

import org.junit.Assert;
import org.junit.Test;

import ca.infoway.messagebuilder.xml.DifferenceType;

public class DifferenceAnalyzerRegistryTest {

	@Test
	public void shoudHaveAllDifferencesRegistered() {
		
		DifferenceType[] values = DifferenceType.values();
		
		for (DifferenceType differenceType : values) {
			Assert.assertNotNull(differenceType.toString(), DifferenceAnalyzerRegistry.getInstance().get(differenceType));
		}
		
	}
	
	
}
