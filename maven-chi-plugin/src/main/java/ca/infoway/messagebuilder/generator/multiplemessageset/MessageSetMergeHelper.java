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

package ca.infoway.messagebuilder.generator.multiplemessageset;

import static ca.infoway.messagebuilder.generator.lang.DifferenceHelper.EXISTS;
import static ca.infoway.messagebuilder.generator.lang.DifferenceHelper.MISSING;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.DifferenceValue;
import ca.infoway.messagebuilder.xml.HasDifferences;

public class MessageSetMergeHelper {

	String standardMerge(String primary, String secondary) {
		String result = primary;
		if (StringUtils.isBlank(primary) && StringUtils.isNotBlank(secondary)) {
			result = secondary;
		}
		return result;
	}
	
	Object standardMerge(Object primary, Object secondary) {
		return ObjectUtils.defaultIfNull(primary, secondary);
	}
	
	Difference addMissingDifference(MergeContext context, HasDifferences hasDifferences, boolean primaryOnly) {
		Difference result = addDifference(context, hasDifferences, DifferenceType.COMPONENT_ONLY_IN_ONE_VERSION, primaryOnly ? EXISTS : null, primaryOnly ? null : EXISTS);
		result.setOk(true);
		return result;
	}
	
	Difference addDifference(MergeContext context, HasDifferences hasDifferences, DifferenceType type, String value, String value2) {
		
		DifferenceValue differenceValue1 = new DifferenceValue();
		differenceValue1.setValue(StringUtils.isBlank(value) ? MISSING : value);
		differenceValue1.setVersion(context.getPrimaryVersion());
		
		DifferenceValue differenceValue2 = new DifferenceValue();
		differenceValue2.setValue(StringUtils.isBlank(value2) ? MISSING : value2);
		differenceValue2.setVersion(context.getSecondaryVersion());
		
		Difference difference = new Difference();
		difference.setType(type);
		difference.getDifferences().add(differenceValue1);
		difference.getDifferences().add(differenceValue2);
		
		hasDifferences.addDifference(difference);
		
		String differenceInfo = 
			  StringUtils.trimToEmpty(context.getCurrentInteraction()) + " " 
			+ StringUtils.trimToEmpty(context.getCurrentPackageLocation()) + " " 
			+ StringUtils.trimToEmpty(context.getCurrentMessagePart())
			+ " - " + "difference for " + type + ": " + value + ", " + value2;
		context.logInfo(differenceInfo.trim());
		
		return difference;
	}

}
