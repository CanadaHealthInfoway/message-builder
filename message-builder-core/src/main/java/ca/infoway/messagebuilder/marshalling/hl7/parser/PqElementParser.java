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
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_DRUG;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_HEIGHTWEIGHT;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_TIME;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.x_BasicUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_HeightOrWeightObservationUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_TimeUnitsOfMeasure;
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
 * trailing zeros. This class ignores that restriction.
 * 
 * Note: this may have to be modified once the PQ.DRUG and PQ.HEIGHTWEIGHT subclasses are described.
 */
@DataTypeHandler("PQ")
class PqElementParser extends AbstractSingleElementParser<PhysicalQuantity> {
	
	private static final int MAXIMUM_INTEGER_DIGITS = 11;
	private static final int MAXIMUM_FRACTION_DIGITS = 2;

	@Override
	protected PhysicalQuantity parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		return parseNonNullElement(context, (Element) node, xmlToModelResult);
	}

	private PhysicalQuantity parseNonNullElement(ParseContext context, Element element, XmlToModelResult xmlToModelResult) {
		BigDecimal value = parseValue(context, element.getAttribute("value"), element, xmlToModelResult);
		UnitsOfMeasureCaseSensitive unit = parseUnit(context, element.getAttribute("unit"), element, xmlToModelResult);
		
		return (value != null) ? new PhysicalQuantity(value, unit) : null;
	}
	
	private BigDecimal parseValue(ParseContext context, String valueAsString, Element element,
			XmlToModelResult xmlToModelResult) {
		BigDecimal result = null;
		if (StringUtils.isBlank(valueAsString)) {
			xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
					MessageFormat.format("No value provided for physical quantity ({0})",
							XmlDescriber.describeSingleElement(element)), element));
		} else {
			try {
				result = new BigDecimal(valueAsString);
				checkResultIsValidValue(result, element, xmlToModelResult);
			} catch (NumberFormatException e) {
				xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
						MessageFormat.format("value \"{0}\" is not a valid decimal value ({1})",
								valueAsString, XmlDescriber.describeSingleElement(element)), element));
			}
		}
		return result;
	}


    protected void checkResultIsValidValue(BigDecimal value, Element element, XmlToModelResult xmlToModelResult) {
        if (value.scale() > MAXIMUM_FRACTION_DIGITS) {
			xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
					MessageFormat.format("PhysicalQuantity ({0}) can contain a maximum of {1} decimal places",
							XmlDescriber.describeSingleElement(element), MAXIMUM_FRACTION_DIGITS), element));
            
        } else if ((value.precision() - value.scale()) > MAXIMUM_INTEGER_DIGITS) {
			xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
					MessageFormat.format("PhysicalQuantity ({0}) can contain a maximum of {1} integer places",
							XmlDescriber.describeSingleElement(element), MAXIMUM_INTEGER_DIGITS), element));
        }
    }

	private UnitsOfMeasureCaseSensitive parseUnit(ParseContext context, String unitAsString, Element element,
			XmlToModelResult xmlToModelResult) {
		if (StringUtils.isNotBlank(unitAsString)) {
			UnitsOfMeasureCaseSensitive unit = (UnitsOfMeasureCaseSensitive) CodeResolverRegistry.lookup(getUnitTypeByHl7Type(context), unitAsString);
			if (unit == null) {
				xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
						MessageFormat.format("Unit \"{0}\" is not valid ({1})",
								unitAsString, XmlDescriber.describeSingleElement(element)), element));
			}
			return unit;
		} else {
			return null;
		}
	}

	private Class<? extends UnitsOfMeasureCaseSensitive> getUnitTypeByHl7Type(ParseContext context) {
		StandardDataType type = StandardDataType.getByTypeName(context.getType());
		if (type == null) {
			// TODO: BCH: should we consider this an error case?
			return UnitsOfMeasureCaseSensitive.class;
		} else {
			
			if (PQ_DRUG.equals(type)) {
				return x_DrugUnitsOfMeasure.class;
			} else if (PQ_HEIGHTWEIGHT.equals(type)) {
				return x_HeightOrWeightObservationUnitsOfMeasure.class;
			} else if (PQ_TIME.equals(type)) {
				return x_TimeUnitsOfMeasure.class;
			} else if (PQ_BASIC.equals(type)) {
				return x_BasicUnitsOfMeasure.class;
			} else {
				return UnitsOfMeasureCaseSensitive.class;
			}
			
		}
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new PQImpl();
	}
}