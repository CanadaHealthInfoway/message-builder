package ca.infoway.messagebuilder.marshalling.hl7;

import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_BASIC;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_DISTANCE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_DRUG;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_HEIGHTWEIGHT;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_LAB;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_TIME;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

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
			errors.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
					MessageFormat.format("Type \"{0}\" is not a valid PQ type{1}",
							typeAsString, element == null ? "" : " ("+XmlDescriber.describeSingleElement(element)+")", typeAsString), element)); 
			return UnitsOfMeasureCaseSensitive.class;
		}
	}

}
