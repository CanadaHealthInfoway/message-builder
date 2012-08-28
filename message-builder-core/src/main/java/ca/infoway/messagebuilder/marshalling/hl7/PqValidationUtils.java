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
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.x_BasicUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_DistanceObservationUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_HeightOrWeightObservationUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_LabUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_TimeUnitsOfMeasure;
import ca.infoway.messagebuilder.lang.NumberUtil;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

public class PqValidationUtils {

	public static final int MAXIMUM_INTEGER_DIGITS = 11;
	public static final int MAXIMUM_FRACTION_DIGITS = 2;
	
	public static final Map<String, Integer> maximum_fraction_digits_exceptions = new HashMap<String, Integer>();
	static {
		maximum_fraction_digits_exceptions.put(Hl7BaseVersion.MR2009.name() + "_PQ.DRUG", 4);
		maximum_fraction_digits_exceptions.put(Hl7BaseVersion.MR2009.name() + "_PQ.LAB", 4);
	}

	public static final Map<String, Integer> maximum_integer_digits_exceptions = new HashMap<String, Integer>();
	static {
		maximum_integer_digits_exceptions.put(Hl7BaseVersion.CERX.name() + "_PQ.BASIC", 8);
		maximum_integer_digits_exceptions.put(Hl7BaseVersion.CERX.name() + "_PQ.DRUG", 8);
		maximum_integer_digits_exceptions.put(Hl7BaseVersion.CERX.name() + "_PQ.TIME", 8);
		maximum_integer_digits_exceptions.put(Hl7BaseVersion.CERX.name() + "_PQ.HEIGHTWEIGHT", 8); // CeRx does not specify PQ.LAB or PQ.DISTANCE 
	}
	
	public int getMaxFractionDigits(VersionNumber version, String type) {
		Integer exceptionValue = maximum_fraction_digits_exceptions.get(version.getBaseVersion().name() + "_" + type);
		return exceptionValue == null ? MAXIMUM_FRACTION_DIGITS : exceptionValue;
	}

	public int getMaxIntDigits(VersionNumber version, String type) {
		Integer exceptionValue = maximum_integer_digits_exceptions.get(version.getBaseVersion().name() + "_" + type);
		return exceptionValue == null ? MAXIMUM_INTEGER_DIGITS : exceptionValue;
	}

	public Class<? extends UnitsOfMeasureCaseSensitive> getUnitTypeByHl7Type(StandardDataType dataType, Hl7Errors errors) {
		return getUnitTypeByHl7Type(dataType == null ? null : dataType.getType(), null, errors);
	}
	
	public Class<? extends UnitsOfMeasureCaseSensitive> getUnitTypeByHl7Type(String typeAsString, Element element, Hl7Errors errors) {
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
			String elementString = element == null ? "" : (" (" + XmlDescriber.describeSingleElement(element) + ")");
			errors.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
					MessageFormat.format("Type \"{0}\" is not a valid PQ type{1}",
							typeAsString, elementString, typeAsString), element)); 
			return UnitsOfMeasureCaseSensitive.class;
		}
	}

    public BigDecimal validateValue(String value, VersionNumber version, String type, Element element, Hl7Errors errors) {
    	int maxIntDigits = this.getMaxIntDigits(version, type);
    	int maxFractionDigits = this.getMaxFractionDigits(version, type);
    	boolean alreadyWarnedAboutValue = false;
    	
    	String elementString = element == null ? "" : (" (" + XmlDescriber.describeSingleElement(element) + ")");
    	
		BigDecimal result = null;
		
		if (StringUtils.isBlank(value)) {
			errors.addHl7Error(new Hl7Error(
					Hl7ErrorCode.DATA_TYPE_ERROR, 
					MessageFormat.format("No value provided for physical quantity{0}",elementString), 
					element));
		} else {
			if (NumberUtil.isNumber(value)) {
				String integerPart = value.contains(".") ? StringUtils.substringBefore(value, ".") : value;
				String decimalPart = value.contains(".") ? StringUtils.substringAfter(value, ".") : "";
				
				String errorMessage = "PhysicalQuantity{0} for {1}/{2} can contain a maximum of {3} {4} places";
				
				if (StringUtils.length(decimalPart) > maxFractionDigits) {
					errors.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
							MessageFormat.format(errorMessage,
									elementString, version.getBaseVersion(), type, maxFractionDigits, "decimal"), element));
		        }
				
				if (StringUtils.length(integerPart) > maxIntDigits) {
					errors.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
							MessageFormat.format(errorMessage,
									elementString, version.getBaseVersion(), type, maxIntDigits, "integer"), element));
		        }
	
				if (!StringUtils.isNumeric(integerPart) || !StringUtils.isNumeric(decimalPart)) {
					alreadyWarnedAboutValue = true;
					errors.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
							MessageFormat.format("value \"{0}\" must contain digits only{1}",
									value, elementString), element));
				}
			}
			
			try {
				result = new BigDecimal(value);
			} catch (NumberFormatException e) {
				if (!alreadyWarnedAboutValue) {
					errors.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
							MessageFormat.format("value \"{0}\" is not a valid decimal value ({1})",
									value, XmlDescriber.describeSingleElement(element)), element));
				}
			}
		}
			
		return result;
    }

	public UnitsOfMeasureCaseSensitive validateUnits(String type, String unitsAsString, Element element, Hl7Errors errors) {
		UnitsOfMeasureCaseSensitive units = null;
		if (StringUtils.isNotBlank(unitsAsString)) {
			units = (UnitsOfMeasureCaseSensitive) CodeResolverRegistry.lookup(this.getUnitTypeByHl7Type(type, element, errors), unitsAsString);
			if (units == null) {
				String elementString = element == null ? "" : (" (" + XmlDescriber.describeSingleElement(element) + ")");
				errors.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
						MessageFormat.format("Unit \"{0}\" is not valid for type {2}{1}",
								unitsAsString, elementString, type), element));
			}
		}
		return units;
	}

}
