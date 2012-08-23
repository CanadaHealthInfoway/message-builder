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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_BASIC;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_DISTANCE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_DRUG;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_HEIGHTWEIGHT;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_LAB;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_TIME;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.x_BasicUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_DistanceObservationUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_HeightOrWeightObservationUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_LabUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_TimeUnitsOfMeasure;
import ca.infoway.messagebuilder.lang.NumberUtil;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * PQ - Physical Quantity
 * 
 * Parses a PQ element into a PhysicalQuantity. The element looks like this:
 * 
 * <element-name value="123.33" unit="unit"/>
 *
 * If a value is null, value is replaced by a null flavor. So the element would look
 * like this:
 * 
 * <element-name nullFlavor="something" />
 * 
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-PQ
 * 
 * CeRx specifies that the quantity is formatted as 99999999.99 with no leading or
 * trailing zeros. This class ignores that particular restriction.  (for MR2007 and MR2009, for most cases this becomes 11.2)
 * 
 */
@DataTypeHandler("PQ")
class PqElementParser extends AbstractSingleElementParser<PhysicalQuantity> {
	
	private static final int MAXIMUM_INTEGER_DIGITS = 11;
	private static final int MAXIMUM_FRACTION_DIGITS = 2;
	
	private static final Map<String, Integer> maximum_fraction_digits_exceptions = new HashMap<String, Integer>();
	static {
		maximum_fraction_digits_exceptions.put(Hl7BaseVersion.MR2009.name() + "_PQ.DRUG", 4);
		maximum_fraction_digits_exceptions.put(Hl7BaseVersion.MR2009.name() + "_PQ.LAB", 4);
	}

	private static final Map<String, Integer> maximum_integer_digits_exceptions = new HashMap<String, Integer>();
	static {
		maximum_integer_digits_exceptions.put(Hl7BaseVersion.CERX.name() + "_PQ.BASIC", 8);
		maximum_integer_digits_exceptions.put(Hl7BaseVersion.CERX.name() + "_PQ.DRUG", 8);
		maximum_integer_digits_exceptions.put(Hl7BaseVersion.CERX.name() + "_PQ.TIME", 8);
		maximum_integer_digits_exceptions.put(Hl7BaseVersion.CERX.name() + "_PQ.HEIGHTWEIGHT", 8); // CeRx does not specify PQ.LAB or PQ.DISTANCE 
	}
	
	@Override
	protected PhysicalQuantity parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		Element element = (Element) node;
		
		BigDecimal value = parseValue(context, element.getAttribute("value"), element, xmlToModelResult);
		UnitsOfMeasureCaseSensitive unit = parseUnit(context, element.getAttribute("unit"), element, xmlToModelResult);
		
		// TODO: TM - PQ.LAB in MR2009 allows for an originalText attribute. Since no current pan-Canadian standard uses PQ.LAB, this requirement has not been implemented.
		
		return (value != null) ? new PhysicalQuantity(value, unit) : null;
	}
	
	private BigDecimal parseValue(ParseContext context, String valueAsString, Element element, XmlToModelResult xmlToModelResult) {
		BigDecimal result = null;
		if (StringUtils.isBlank(valueAsString)) {
			xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
					MessageFormat.format("No value provided for physical quantity ({0})",
							XmlDescriber.describeSingleElement(element)), element));
		} else {
			result = validateValue(valueAsString, context.getVersion(), context.getType(), element, xmlToModelResult);
		}
		return result;
	}

    protected BigDecimal validateValue(String value, VersionNumber version, String type, Element element, XmlToModelResult xmlToModelResult) {
    	int maxIntDigits = getMaxIntDigits(version, type);
    	int maxFractionDigits = getMaxFractionDigits(version, type);
    	String errorMessage = "PhysicalQuantity ({0}) for {1}/{2} can contain a maximum of {3} {4} places";
    	boolean alreadyWarnedAboutValue = false;
    	
		if (NumberUtil.isNumber(value)) {
			String integerPart = value.contains(".") ? StringUtils.substringBefore(value, ".") : value;
			String decimalPart = value.contains(".") ? StringUtils.substringAfter(value, ".") : "";
			
			if (StringUtils.length(decimalPart) > maxFractionDigits) {
				xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
						MessageFormat.format(errorMessage,
								XmlDescriber.describeSingleElement(element), version.getBaseVersion(), type, maxFractionDigits, "decimal"), element));
	        }
			
			if (StringUtils.length(integerPart) > maxIntDigits) {
				xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
						MessageFormat.format(errorMessage,
								XmlDescriber.describeSingleElement(element), version.getBaseVersion(), type, maxIntDigits, "integer"), element));
	        }

			if (!StringUtils.isNumeric(integerPart) || !StringUtils.isNumeric(decimalPart)) {
				alreadyWarnedAboutValue = true;
				xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
						MessageFormat.format("value \"{0}\" must contain digits only ({1})",
								value, XmlDescriber.describeSingleElement(element)), element));
			}
		}
			
		BigDecimal result = null;
		try {
			result = new BigDecimal(value);
		} catch (NumberFormatException e) {
			if (!alreadyWarnedAboutValue) {
				xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
						MessageFormat.format("value \"{0}\" is not a valid decimal value ({1})",
								value, XmlDescriber.describeSingleElement(element)), element));
			}
		}
		return result;
    }

	private int getMaxFractionDigits(VersionNumber version, String type) {
		Integer exceptionValue = maximum_fraction_digits_exceptions.get(version.getBaseVersion().name() + "_" + type);
		return exceptionValue == null ? MAXIMUM_FRACTION_DIGITS : exceptionValue;
	}

	private int getMaxIntDigits(VersionNumber version, String type) {
		Integer exceptionValue = maximum_integer_digits_exceptions.get(version.getBaseVersion().name() + "_" + type);
		return exceptionValue == null ? MAXIMUM_INTEGER_DIGITS : exceptionValue;
	}

	private UnitsOfMeasureCaseSensitive parseUnit(ParseContext context, String unitAsString, Element element, XmlToModelResult xmlToModelResult) {
		if (StringUtils.isNotBlank(unitAsString)) {
			UnitsOfMeasureCaseSensitive unit = (UnitsOfMeasureCaseSensitive) CodeResolverRegistry.lookup(getUnitTypeByHl7Type(context, element, xmlToModelResult), unitAsString);
			if (unit == null) {
				xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
						MessageFormat.format("Unit \"{0}\" is not valid for type {2} ({1})",
								unitAsString, XmlDescriber.describeSingleElement(element), context.getType()), element));
			}
			return unit;
		} else {
			return null;
		}
	}

	private Class<? extends UnitsOfMeasureCaseSensitive> getUnitTypeByHl7Type(ParseContext context, Element element, XmlToModelResult xmlToModelResult) {
		StandardDataType type = StandardDataType.getByTypeName(context.getType());
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
			xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
					MessageFormat.format("Type \"{0}\" is not a valid PQ type ({1})",
							context.getType(), XmlDescriber.describeSingleElement(element), context.getType()), element));
			return UnitsOfMeasureCaseSensitive.class;
		}
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new PQImpl();
	}
}