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

package ca.infoway.messagebuilder.marshalling.polymorphism;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.error.ErrorLevel;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;

public class PolymorphismHandler {

	private static Map<StandardDataType, List<StandardDataType>> allowedMappings = new HashMap<StandardDataType, List<StandardDataType>>();
	private static Map<StandardDataType, StandardDataType> cdaR1MappingsToNew = new HashMap<StandardDataType, StandardDataType>();
	private static Map<StandardDataType, StandardDataType> cdaR1MappingsToOld = new HashMap<StandardDataType, StandardDataType>();
	
	//Only 1 static init block in .NET
	static {
		//Static imports here seem to confuse sharpen
		allowedMappings.put(StandardDataType.TS, Arrays.asList(StandardDataType.SXCM_TS, StandardDataType.PIVL_TS, StandardDataType.IVL_TS, StandardDataType.EIVL_TS));
		allowedMappings.put(StandardDataType.SXCM_TS, Arrays.asList(StandardDataType.PIVL_TS, StandardDataType.IVL_TS, StandardDataType.EIVL_TS));
		allowedMappings.put(StandardDataType.CD, Arrays.asList(StandardDataType.CE, StandardDataType.BXIT_CD, StandardDataType.SXCM_CD, StandardDataType.CV, StandardDataType.HXIT_CE, StandardDataType.CS, StandardDataType.CO));
		allowedMappings.put(StandardDataType.CE, Arrays.asList(StandardDataType.CV, StandardDataType.HXIT_CE, StandardDataType.CS, StandardDataType.CO));
		allowedMappings.put(StandardDataType.CV, Arrays.asList(StandardDataType.CS, StandardDataType.CO));
		allowedMappings.put(StandardDataType.EN, Arrays.asList(StandardDataType.PN, StandardDataType.ON, StandardDataType.TN));
		
		cdaR1MappingsToNew.put(StandardDataType.TS, StandardDataType.TSCDAR1);
		cdaR1MappingsToNew.put(StandardDataType.PIVL_TS, StandardDataType.PIVLTSCDAR1);
		cdaR1MappingsToNew.put(StandardDataType.SXCM_TS, StandardDataType.SXCMTSCDAR1);
		cdaR1MappingsToNew.put(StandardDataType.IVL_TS, StandardDataType.IVLTSCDAR1);
		
		cdaR1MappingsToOld.put(StandardDataType.TSCDAR1, StandardDataType.TS);
		cdaR1MappingsToOld.put(StandardDataType.PIVLTSCDAR1, StandardDataType.PIVL_TS);
		cdaR1MappingsToOld.put(StandardDataType.SXCMTSCDAR1, StandardDataType.SXCM_TS);
		cdaR1MappingsToOld.put(StandardDataType.IVLTSCDAR1, StandardDataType.IVL_TS);
	}
	
	public String determineActualDataTypeFromXsiType(String modelType, String newTypeFromXsiType, boolean isCda, boolean isR1, ErrorLogger errorLogger) {
		StandardDataType newTypeEnum = StandardDataType.valueOf(StandardDataType.class, newTypeFromXsiType);
		return determineActualDataType(modelType, newTypeEnum, isCda, isR1, errorLogger);
	}
	
	public String determineActualDataType(String modelType, StandardDataType newTypeEnum, boolean isCda, boolean isR1, ErrorLogger errorLogger) {
		StandardDataType modelTypeEnum = StandardDataType.getByTypeName(modelType);
		if (!isCda || modelTypeEnum == null || newTypeEnum == null || StandardDataType.isSetOrList(modelType) || newTypeIsRootOfCurrent(modelTypeEnum, newTypeEnum)) {
			return modelType;
		}
		return determineActualDataType(modelTypeEnum, newTypeEnum, isCda && isR1, errorLogger);
	}
	
	private String determineActualDataType(StandardDataType modelType, StandardDataType newType, boolean isCdaR1, ErrorLogger errorLogger) {
		StandardDataType convertedModelType = modelType;
		if (cdaR1MappingsToOld.containsKey(modelType)) {
			convertedModelType = cdaR1MappingsToOld.get(modelType);
		}
		
		String unspecializedModelType = convertedModelType.getTypeName().getUnspecializedName();
		String unspecializedNewType = newType.getTypeName().getUnspecializedName();
		
		// allow ANY handlers and collection handlers deal with type changes on their own
		if (StandardDataType.ANY.getType().equals(unspecializedModelType) || StandardDataType.isSetOrList(unspecializedModelType)) {
			return modelType.getType();
		}
		
		if (isValidTypeChange(unspecializedModelType, unspecializedNewType)) {
			return mapCdaR1Type(newType, isCdaR1);
		} else {
			String message = MessageFormat.format("Not able to handle type change from {0} to {1}. Type has been left unchanged.", convertedModelType.getType(), newType.getType());
			errorLogger.logError(Hl7ErrorCode.UNSUPPORTED_TYPE_CHANGE, ErrorLevel.WARNING, message);
			return modelType.getType();
		}
	}
	
	public String mapCdaR1Type(StandardDataType newType, boolean isCdaR1) {
		if (isCdaR1 && cdaR1MappingsToNew.containsKey(newType)) {
			return cdaR1MappingsToNew.get(newType).getType();
		}
		return newType.getType();
	}
	
	boolean isValidTypeChange(String currentType, String newType) {
		// assumes types come in as IVL<TS> and *not* IVL_TS (which is what xsi:type would have for a value)
		StandardDataType inType = StandardDataType.getByTypeName(currentType);
		StandardDataType outType = StandardDataType.getByTypeName(newType);
		return isValidTypeChange(inType, outType);
	}
	
	boolean isValidTypeChange(StandardDataType currentType, StandardDataType newType) {
		// bug fix: if the new type ends up being the root type of the current (model) type, that is valid
		if (currentType != null && currentType.equals(newType)) {
			return true;
		}
		List<StandardDataType> allowedTypes = allowedMappings.get(currentType);
		return allowedTypes != null && allowedTypes.contains(newType);
	}

	private boolean newTypeIsRootOfCurrent(StandardDataType currentType, StandardDataType newType) {
		return currentType.getRootDataType().equals(newType);
	}
	
}
