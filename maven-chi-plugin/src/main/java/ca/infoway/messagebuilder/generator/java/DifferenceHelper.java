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

package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.multiplemessageset.MessageSetMergeHelper;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.HasDifferences;

class DifferenceHelper {
	static boolean hasDifferenceOfType(HasDifferences hasDifferences, DifferenceType differenceType) {
		return getDifferenceByType(hasDifferences, differenceType) != null;
	}
	static Difference getDifferenceByType(HasDifferences hasDifferences, DifferenceType differenceType) {
		Difference result = null;
		for (Difference difference : hasDifferences.getDifferences()) {
			if (differenceType == difference.getType()) {
				result = difference;
				break;
			}
		}
		return result;
	}
	static <T extends HasDifferences> T choosePrimary(
			T relationship1, T relationship2) {
		
		Difference difference1 = getDifferenceByType(relationship1, DifferenceType.COMPONENT_ONLY_IN_ONE_VERSION);
		Difference difference2 = getDifferenceByType(relationship2, DifferenceType.COMPONENT_ONLY_IN_ONE_VERSION);
		
		if (difference1 == null || difference2 == null) {
			throw new GeneratorException("Cannot determine primary relationship");
		} else if (isPrimary(difference1)) {
			return relationship1;
		} else if (isPrimary(difference2)) {
			return relationship2;
		} else {
			throw new GeneratorException("Cannot determine primary relationship");
		}
	}
	private static boolean isPrimary(Difference difference1) {
		return MessageSetMergeHelper.EXISTS.equals(difference1.getDifferences().get(0).getValue());
	}
}	
