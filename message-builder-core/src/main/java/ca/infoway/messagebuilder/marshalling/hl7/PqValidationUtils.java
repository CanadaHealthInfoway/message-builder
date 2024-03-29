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
package ca.infoway.messagebuilder.marshalling.hl7;

import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_BASIC;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_DISTANCE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_DRUG;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_HEIGHTWEIGHT;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_LAB;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_TIME;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.x_BasicUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_DistanceObservationUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_HeightOrWeightObservationUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_LabUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_TimeUnitsOfMeasure;
import ca.infoway.messagebuilder.error.ErrorLevel;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.lang.NumberUtil;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

public class PqValidationUtils {

	public static final int MAXIMUM_INTEGER_DIGITS = 11;
	public static final int MAXIMUM_FRACTION_DIGITS = 2;
	public static final int MAXIMUM_FRACTION_DIGITS_DRUG_LAB = 4;
	private static final int MAX_ORIGINAL_TEXT_LENGTH = 150;
	
	public static final Map<String, Integer> maximum_fraction_digits_exceptions = new HashMap<String, Integer>();
	public static final Map<String, Integer> maximum_integer_digits_exceptions = new HashMap<String, Integer>();
	
	static {
		maximum_fraction_digits_exceptions.put(Hl7BaseVersion.MR2007 + "_PQ.DRUG", 2);
		maximum_fraction_digits_exceptions.put(Hl7BaseVersion.MR2007 + "_PQ.LAB", 2);
		
		maximum_fraction_digits_exceptions.put(Hl7BaseVersion.CERX + "_PQ.DRUG", 2);
		maximum_fraction_digits_exceptions.put(Hl7BaseVersion.CERX + "_PQ.LAB", 2);
		
		maximum_integer_digits_exceptions.put(Hl7BaseVersion.CERX + "_PQ.BASIC", 8);
		maximum_integer_digits_exceptions.put(Hl7BaseVersion.CERX + "_PQ.DRUG", 8);
		maximum_integer_digits_exceptions.put(Hl7BaseVersion.CERX + "_PQ.TIME", 8);
		maximum_integer_digits_exceptions.put(Hl7BaseVersion.CERX + "_PQ.HEIGHTWEIGHT", 8); // CeRx does not specify PQ.LAB or PQ.DISTANCE 
	}
	
	public int getMaxFractionDigits(VersionNumber version, String typeAsString) {
		int maxFractionDigits = MAXIMUM_FRACTION_DIGITS;
		StandardDataType type = StandardDataType.getByTypeName(typeAsString);
		if (PQ_DRUG.equals(type) || PQ_LAB.equals(type)) {
			maxFractionDigits = MAXIMUM_FRACTION_DIGITS_DRUG_LAB;
		}
		Integer exceptionValue = maximum_fraction_digits_exceptions.get(version.getBaseVersion() + "_" + type);
		return (int) (exceptionValue == null ? maxFractionDigits : exceptionValue);
	}

	public int getMaxIntDigits(VersionNumber version, String type) {
		Integer exceptionValue = maximum_integer_digits_exceptions.get(version.getBaseVersion() + "_" + type);
		return (int) (exceptionValue == null ? MAXIMUM_INTEGER_DIGITS : exceptionValue);
	}

	private Class<? extends UnitsOfMeasureCaseSensitive> getUnitTypeByHl7Type(String typeAsString, Element element, String propertyPath, Hl7Errors errors, boolean isR2) {
		StandardDataType type = StandardDataType.getByTypeName(typeAsString);
		if (PQ_BASIC.equals(type)) {
			return x_BasicUnitsOfMeasure.class;
		} else if (PQ_DRUG.equals(type)) {
			return x_DrugUnitsOfMeasure.class;
		} else if (PQ_TIME.equals(type)) {
			return x_TimeUnitsOfMeasure.class;
		} else if (PQ_LAB.equals(type)) {
			return x_LabUnitsOfMeasure.class;
		} else if (PQ_HEIGHTWEIGHT.equals(type)) {
			return x_HeightOrWeightObservationUnitsOfMeasure.class;
		} else if (PQ_DISTANCE.equals(type)) {
			return x_DistanceObservationUnitsOfMeasure.class;
		} else {
			if (!isR2) {
				createWarning(MessageFormat.format("Type \"{0}\" is not a valid PQ type",	typeAsString), element, propertyPath, errors);
			}
			return UnitsOfMeasureCaseSensitive.class;
		}
	}

    public BigDecimal validateValue(String value, VersionNumber version, String type, boolean hasNullFlavor, Element element, String propertyPath, Hl7Errors errors) {
    	int maxIntDigits = this.getMaxIntDigits(version, type);
    	int maxFractionDigits = this.getMaxFractionDigits(version, type);
    	boolean alreadyWarnedAboutValue = false;
    	
		BigDecimal result = null;
		
		if (StringUtils.isBlank(value)) {
			if (!hasNullFlavor) {
				createWarning("No value provided for physical quantity", element, propertyPath, errors);
			}
		} else {
			if (NumberUtil.isNumber(value)) {
				String integerPart = value.contains(".") ? StringUtils.substringBefore(value, ".") : value;
				String decimalPart = value.contains(".") ? StringUtils.substringAfter(value, ".") : "";
				
				String errorMessage = "PhysicalQuantity for {0}/{1} can contain a maximum of {2} {3} places";
				
				if (StringUtils.length(decimalPart) > maxFractionDigits) {
					createWarning(MessageFormat.format(errorMessage, version.getBaseVersion(), type, maxFractionDigits, "decimal"), element, propertyPath, errors);
		        }
				
				if (StringUtils.length(integerPart) > maxIntDigits) {
					createWarning(MessageFormat.format(errorMessage, version.getBaseVersion(), type, maxIntDigits, "integer"), element, propertyPath, errors);
		        }
	
				if (!StringUtils.isNumeric(integerPart) || !StringUtils.isNumeric(decimalPart)) {
					alreadyWarnedAboutValue = true;
					createWarning(MessageFormat.format("value \"{0}\" must contain digits only", value), element, propertyPath, errors);
				}
			}
			
			try {
				result = new BigDecimal(value);
			} catch (NumberFormatException e) {
				if (!alreadyWarnedAboutValue) {
					createWarning(MessageFormat.format("value \"{0}\" is not a valid decimal value", value), element, propertyPath, errors);
				}
			}
		}
			
		return result;
    }

    public BigDecimal validateValueR2(String value, VersionNumber version, String type, boolean hasNullFlavor, Element element, String propertyPath, Hl7Errors errors) {
		BigDecimal result = null;
		
		if (!StringUtils.isBlank(value)) {
			try {
				result = new BigDecimal(value);
			} catch (NumberFormatException e) {
				createWarning(MessageFormat.format("value \"{0}\" is not a valid decimal value", value), element, propertyPath, errors);
			}
		}
			
		return result;
    }

	public UnitsOfMeasureCaseSensitive validateUnits(String type, String unitsAsString, Element element, String propertyPath, Hl7Errors errors, boolean isR2) {
		UnitsOfMeasureCaseSensitive units = null;
		if (StringUtils.isNotBlank(unitsAsString)) {
			units = (UnitsOfMeasureCaseSensitive) CodeResolverRegistry.lookup(this.getUnitTypeByHl7Type(type, element, propertyPath, errors, isR2), unitsAsString);
			if (units == null) {
				createWarning(MessageFormat.format("Unit \"{0}\" is not valid for type {1}", unitsAsString, type), element, propertyPath, errors);
			}
		}
		return units;
	}

	public void validateOriginalText(String typeAsString, String originalText, boolean hasAnyValues, boolean hasNullFlavor, VersionNumber version, Element element, String propertyPath, Hl7Errors errors) {
		StandardDataType type = StandardDataType.getByTypeName(typeAsString);
		boolean hasOriginalText = StringUtils.isNotBlank(originalText);
		if (hasOriginalText) {
			// only PQ.LAB is allowed to have originalText
			if (!PQ_LAB.equals(type)) {
				createWarning(MessageFormat.format("Type {0} not allowed to have originalText. For physical quantity types, originalText is only allowed for PQ.LAB.", typeAsString), element, propertyPath, errors);
			} else {
				// no more than 150 characters
				int length = originalText.length();
				if (length > MAX_ORIGINAL_TEXT_LENGTH) {
					createWarning(MessageFormat.format("PQ.LAB originalText has {0} characters, but only {1} are allowed.", length, MAX_ORIGINAL_TEXT_LENGTH), element, propertyPath, errors);
				}
			}
		}
		// TM - HACK: these restrictions don't seem to apply to the R2 datatype version of PQ.LAB; currently only BC using this (refactor when implementing R2 datatypes)
		if (PQ_LAB.equals(type) && hasNullFlavor && !SpecificationVersion.isExactVersion(version, SpecificationVersion.V02R04_BC)) {
			if (!hasOriginalText) {
				createWarning("For PQ.LAB values, originalText is mandatory when set to a NullFlavor.", element, propertyPath, errors);
			}
			if (hasAnyValues) {
				createWarning("PQ.LAB can not have quantity or units specified when set to a NullFlavor.", element, propertyPath, errors);
			}
		}
	}
	
	private void createWarning(String errorMessage, Element element, String propertyPath, Hl7Errors errors) {
		Hl7Error error = null;
		if (element != null) {
			error = new Hl7Error(
					Hl7ErrorCode.DATA_TYPE_ERROR,
					ErrorLevel.ERROR,
					errorMessage + 	" (" + XmlDescriber.describeSingleElement(element) + ")", 
					element);		
		} else { // assuming this has a property path
			error = new Hl7Error(
					Hl7ErrorCode.DATA_TYPE_ERROR, 
					ErrorLevel.ERROR,
					errorMessage, 
					propertyPath);		
		}
		
		errors.addHl7Error(error);
	}

}
