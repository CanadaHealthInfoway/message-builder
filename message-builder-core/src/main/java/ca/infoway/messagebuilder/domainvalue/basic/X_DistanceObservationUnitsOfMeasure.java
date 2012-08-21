package ca.infoway.messagebuilder.domainvalue.basic;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.x_DistanceObservationUnitsOfMeasure;
import ca.infoway.messagebuilder.lang.EnumPattern;

public class X_DistanceObservationUnitsOfMeasure extends EnumPattern implements x_DistanceObservationUnitsOfMeasure {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
	private static final long serialVersionUID = 3134130558551921271L;
	
	public static final X_DistanceObservationUnitsOfMeasure MILE = new X_DistanceObservationUnitsOfMeasure("MILE", "[mi_us]"); 
	public static final X_DistanceObservationUnitsOfMeasure YARD = new X_DistanceObservationUnitsOfMeasure("YARD", "[yd_i]"); 
	public static final X_DistanceObservationUnitsOfMeasure DEGREE = new X_DistanceObservationUnitsOfMeasure("DEGREE", "deg"); 
	public static final X_DistanceObservationUnitsOfMeasure KILOMETER = new X_DistanceObservationUnitsOfMeasure("KILOMETER", "km"); 
	public static final X_DistanceObservationUnitsOfMeasure METER = new X_DistanceObservationUnitsOfMeasure("METER", "m"); 
	
    private final String codeValue;

	private X_DistanceObservationUnitsOfMeasure(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;
    }

	public String getCodeValue() {
		return this.codeValue;
	}

	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_UNIFORM_UNIT_OF_MEASURE.getRoot();
	}

}
