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

import static ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor.NEGATIVE_INFINITY;
import static ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor.POSITIVE_INFINITY;
import static ca.infoway.messagebuilder.marshalling.hl7.TsDateFormats.ABSTRACT_TS_IGNORE_SPECIALIZATION_TYPE_ERROR_PROPERTY_NAME;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.basic.DefaultTimeUnit;

public class IvlValidationUtils {

	boolean isUncertainRangeValidation;
	
	public IvlValidationUtils() {
		this(false);
	}
	
	public IvlValidationUtils(boolean isUncertainRangeValidation) {
		this.isUncertainRangeValidation = isUncertainRangeValidation;
	}
	
	public String validateSpecializationType(String type, String specializationType, List<String> errors) {
		String resultType = type;
		if (StandardDataType.IVL_FULL_DATE_WITH_TIME.getType().equals(type)) {
			// assume type to default to FULLDATETIME
			resultType = StandardDataType.IVL_FULL_DATE_TIME.getType();
			if (StringUtils.isBlank(specializationType) || "IVL".equals(specializationType)) {
				if (Boolean.valueOf(System.getProperty(ABSTRACT_TS_IGNORE_SPECIALIZATION_TYPE_ERROR_PROPERTY_NAME))) {
					// do nothing - error message is to be suppressed
				} else { 
					errors.add("IVL<TS.FULLDATEWITHTIME> is an abstract type. A specialization type must be provided. IVL<TS.FULLDATETIME> will be assumed.");
				}
			} else {
				StandardDataType concreteType = StandardDataType.getByTypeName(specializationType);
				if (concreteType == StandardDataType.IVL_FULL_DATE || concreteType == StandardDataType.IVL_FULL_DATE_TIME) {
					resultType = specializationType; 
				} else {
					errors.add("Invalid specializationType provided for abstract type IVL<TS.FULLDATEWITHTIME>. IVL<TS.FULLDATETIME> will be assumed.");
				}
			}
		}
		return resultType;
	}
	
	public List<String> validateCorrectElementsProvided(String type, VersionNumber version, boolean lowProvided, boolean highProvided, boolean centerProvided, boolean widthProvided) {
		List<String> errors = new ArrayList<String>();
		boolean isCeRx = SpecificationVersion.isVersion(version, Hl7BaseVersion.CERX);
		
		String typeWithoutParameters = Hl7DataTypeName.getTypeWithoutParameters(type);
		String parameterizedType = Hl7DataTypeName.getParameterizedType(type);
		String unqualifiedParameterizedType = Hl7DataTypeName.unqualify(parameterizedType);
		
		StandardDataType ivlType = StandardDataType.getByTypeName(typeWithoutParameters);
		StandardDataType innerType = StandardDataType.getByTypeName(parameterizedType);
		StandardDataType baseInnerType = StandardDataType.getByTypeName(unqualifiedParameterizedType);
		
		int numberOfCorrectlyProvidedElements = this.countProvidedElements(lowProvided, highProvided, centerProvided, widthProvided);
		
		if (lowProvided && this.isLowProhibited(ivlType)) {
			numberOfCorrectlyProvidedElements--;
			errors.add(this.createIncorrectElementErrorMessage(type, "low"));
		}
		if (highProvided && this.isHighProhibited(ivlType)) {
			numberOfCorrectlyProvidedElements--;
			errors.add(this.createIncorrectElementErrorMessage(type, "high"));
		}
		if (widthProvided && this.isWidthProhibited(ivlType, innerType, baseInnerType)) {
			numberOfCorrectlyProvidedElements--;
			errors.add(this.createIncorrectElementErrorMessage(type, "width"));
		}
		if (centerProvided && this.isCenterProhibited(isCeRx, innerType)) {
			numberOfCorrectlyProvidedElements--;
			errors.add(this.createIncorrectElementErrorMessage(type, "center"));
		}
		if (this.incorrectNumberOfElementsProvided(numberOfCorrectlyProvidedElements, ivlType)) {
			errors.add(this.createWrongNumberOfElementsProvidedErrorMessage(isCeRx, type, ivlType, innerType, baseInnerType));
		}
		return errors;
	}

	public List<String> doOtherValidations(String type, NullFlavor lowNullFlavor, NullFlavor centerNullFlavor, NullFlavor highNullFlavor, NullFlavor widthNullFlavor, UnitsOfMeasureCaseSensitive widthTimeUnits) {
		List<String> errors = new ArrayList<String>();
		
		String parameterizedType = Hl7DataTypeName.getParameterizedType(type);
		String unqualifiedParameterizedType = Hl7DataTypeName.unqualify(parameterizedType);
		
		StandardDataType innerType = StandardDataType.getByTypeName(parameterizedType);
		StandardDataType baseInnerType = StandardDataType.getByTypeName(unqualifiedParameterizedType);

		if (!this.isUncertainRangeValidation) {
			if (baseInnerType == StandardDataType.PQ) {
				// TODO - VALIDATION - TM - this might apply to URG<PQ.x> (check with Lloyd)
				boolean lowNull = (lowNullFlavor != null);
				boolean highNull = (highNullFlavor != null);
				if (lowNull && highNull) {
					errors.add("For " + getIntervalOrRange() + "s of type PQ.x, one of (low, high) must be non-null.");
				}
			} else {
				ensureNotPinfOrNinf("low", lowNullFlavor, errors);
				ensureNotPinfOrNinf("high", highNullFlavor, errors);
				ensureNotPinfOrNinf("center", centerNullFlavor, errors);
				ensureNotPinfOrNinf("width", widthNullFlavor, errors);
			}
			
			// TS.DATE/TS.FULLDATE have width restrictions (does not seem to apply to URG; check with Lloyd)
			if (innerType == StandardDataType.TS_DATE || innerType == StandardDataType.TS_FULLDATE) {
				if (widthTimeUnits != null) {
					if (!DefaultTimeUnit.isDayBased(widthTimeUnits)) {
						errors.add("Width units must be days (d), weeks (wk), months (mo) or years (a).");
					}
				}
			}
		}
			
		
		return errors;
	}
	
	private void ensureNotPinfOrNinf(String intervalElement, NullFlavor nullFlavor, List<String> errors) {
		if (nullFlavor != null) {
			if (POSITIVE_INFINITY.getCodeValue().equals(nullFlavor.getCodeValue()) || NEGATIVE_INFINITY.getCodeValue().equals(nullFlavor.getCodeValue())) {
				errors.add("The " + intervalElement + " element can not have a null flavor of PINF or NINF.");
			}
		}
	}

	private boolean incorrectNumberOfElementsProvided(int numberOfCorrectlyProvidedElements, StandardDataType ivlType) {
		return ivlType == StandardDataType.IVL ? numberOfCorrectlyProvidedElements != 2 : numberOfCorrectlyProvidedElements != 1;
	}

	private int countProvidedElements(boolean lowProvided, boolean highProvided, boolean centerProvided, boolean widthProvided) {
		return (lowProvided ? 1 : 0) + (highProvided ? 1 : 0) + (widthProvided ? 1 : 0) + (centerProvided ? 1 : 0);
	}

	private boolean isCenterProhibited(boolean isCeRx, StandardDataType innerType) {
		// only allowed for *CeRx* types: IVL<TS.DATE> and IVL<TS.FULLDATE>
		// also allowed for types (of any version): URG<TS.DATE> 
		return !(isCeRx && !this.isUncertainRangeValidation && (innerType == StandardDataType.TS_DATE || innerType == StandardDataType.TS_FULLDATE))
			&& !(this.isUncertainRangeValidation && innerType == StandardDataType.TS_DATE);
	}

	private boolean isWidthProhibited(StandardDataType ivlType, StandardDataType innerType, StandardDataType baseInnerType) {
		return ivlType == StandardDataType.IVL_HIGH || ivlType == StandardDataType.IVL_LOW || innerType == StandardDataType.TS_FULLDATETIME || baseInnerType == StandardDataType.PQ;
	}

	private boolean isHighProhibited(StandardDataType ivlType) {
		return ivlType == StandardDataType.IVL_WIDTH || ivlType == StandardDataType.IVL_LOW;
	}

	private boolean isLowProhibited(StandardDataType ivlType) {
		return ivlType == StandardDataType.IVL_WIDTH || ivlType == StandardDataType.IVL_HIGH;
	}

	private String createWrongNumberOfElementsProvidedErrorMessage(boolean isCeRx, String type, StandardDataType ivlType, StandardDataType innerType, StandardDataType baseInnerType) {
		return getIntervalOrRange() + "s of type " + type + " must " + (ivlType == StandardDataType.IVL || ivlType == StandardDataType.URG ? "provide exactly 2 of" : "only provide") + ": "
				+ (isLowProhibited(ivlType) ? "" : "low ")
				+ (isHighProhibited(ivlType) ? "" : "high ")
				+ (isCenterProhibited(isCeRx, innerType) ? "" : "center ")
				+ (isWidthProhibited(ivlType, innerType, baseInnerType) ? "" : "width ");
	}

	private String createIncorrectElementErrorMessage(String type, String incorrectElement) {
		return "Element " + incorrectElement + " is not allowed for type " + type;
	}

	private String getIntervalOrRange() {
		return this.isUncertainRangeValidation ? "Range" : "Interval";
	}
	
}
