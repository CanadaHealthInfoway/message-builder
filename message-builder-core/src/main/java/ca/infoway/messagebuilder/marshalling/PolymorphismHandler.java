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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-07-10 12:26:14 -0400 (Thu, 10 Jul 2014) $
 * Revision:      $LastChangedRevision: 8803 $
 */

package ca.infoway.messagebuilder.marshalling;

import static ca.infoway.messagebuilder.datatype.StandardDataType.BXIT_CD;
import static ca.infoway.messagebuilder.datatype.StandardDataType.CD;
import static ca.infoway.messagebuilder.datatype.StandardDataType.CE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.CO;
import static ca.infoway.messagebuilder.datatype.StandardDataType.CS;
import static ca.infoway.messagebuilder.datatype.StandardDataType.CV;
import static ca.infoway.messagebuilder.datatype.StandardDataType.EIVL_TS;
import static ca.infoway.messagebuilder.datatype.StandardDataType.EN;
import static ca.infoway.messagebuilder.datatype.StandardDataType.HXIT_CE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.IVL_TS;
import static ca.infoway.messagebuilder.datatype.StandardDataType.ON;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PIVL_TS;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PN;
import static ca.infoway.messagebuilder.datatype.StandardDataType.SXCM_CD;
import static ca.infoway.messagebuilder.datatype.StandardDataType.SXCM_TS;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TN;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.StandardDataType;

public class PolymorphismHandler {

	private static Map<StandardDataType, List<StandardDataType>> allowedMappings = new HashMap<StandardDataType, List<StandardDataType>>();
	static {
		allowedMappings.put(TS, Arrays.asList(SXCM_TS, PIVL_TS, IVL_TS, EIVL_TS));
		allowedMappings.put(SXCM_TS, Arrays.asList(PIVL_TS, IVL_TS, EIVL_TS));
		allowedMappings.put(CD, Arrays.asList(CE, BXIT_CD, SXCM_CD, CV, HXIT_CE, CS, CO));
		allowedMappings.put(CE, Arrays.asList(CV, HXIT_CE, CS, CO));
		allowedMappings.put(CV, Arrays.asList(CS, CO));
		allowedMappings.put(EN, Arrays.asList(PN, ON, TN));
	}
	
	public boolean isValidTypeChange(String currentType, String newType) {
		// assumes types come in as IVL<TS> and *not* IVL_TS (which is what xsi:type would have for a value)
		StandardDataType inType = StandardDataType.getByTypeName(currentType);
		StandardDataType outType = StandardDataType.getByTypeName(newType);
		return isValidTypeChange(inType, outType);
	}
	
	public boolean isValidTypeChange(StandardDataType currentType, StandardDataType newType) {
		if (currentType != null && currentType.equals(newType)) {
			return true;
		}
		List<StandardDataType> allowedTypes = allowedMappings.get(currentType);
		return allowedTypes != null && allowedTypes.contains(newType);
	}
	
}
