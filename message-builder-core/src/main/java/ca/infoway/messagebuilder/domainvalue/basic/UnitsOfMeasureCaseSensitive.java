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

package ca.infoway.messagebuilder.domainvalue.basic;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.x_BasicUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>An enum for units of measurement. Currently only used in tests.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class UnitsOfMeasureCaseSensitive extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive, x_BasicUnitsOfMeasure, Describable {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
	private static final long serialVersionUID = -8960154320681947245L;
	
	// some implementations want to be able to specify unit="1"; this is a bit of a hack to allow this case 
	public static final UnitsOfMeasureCaseSensitive ONE= new UnitsOfMeasureCaseSensitive("ONE", "1");

	public static final UnitsOfMeasureCaseSensitive PERCENT= new UnitsOfMeasureCaseSensitive("PERCENT", "%");
	public static final UnitsOfMeasureCaseSensitive PER_DAY= new UnitsOfMeasureCaseSensitive("PER_DAY", "1/d");
	public static final UnitsOfMeasureCaseSensitive PER_MINUTE= new UnitsOfMeasureCaseSensitive("PER_MINUTE", "1/min");
	public static final UnitsOfMeasureCaseSensitive DEGREE_CELSIUS= new UnitsOfMeasureCaseSensitive("DEGREE_CELSIUS", "Cel");
	public static final UnitsOfMeasureCaseSensitive UNIT= new UnitsOfMeasureCaseSensitive("UNIT", "U");
	public static final UnitsOfMeasureCaseSensitive ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE= new UnitsOfMeasureCaseSensitive("ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE", "U/L");
	public static final UnitsOfMeasureCaseSensitive ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE_LOWER= new UnitsOfMeasureCaseSensitive("ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE_LOWER", "U/l");
	public static final UnitsOfMeasureCaseSensitive CUP= new UnitsOfMeasureCaseSensitive("CUP", "[cup_us]");
	public static final UnitsOfMeasureCaseSensitive DEGREE_FAHRENHEIT= new UnitsOfMeasureCaseSensitive("DEGREE_FAHRENHEIT", "[deg]");
	public static final UnitsOfMeasureCaseSensitive FLUID_OUNCE= new UnitsOfMeasureCaseSensitive("FLUID_OUNCE", "[foz_br]");
	public static final UnitsOfMeasureCaseSensitive FOOT= new UnitsOfMeasureCaseSensitive("FOOT", "[ft_i]");
	public static final UnitsOfMeasureCaseSensitive GALLON= new UnitsOfMeasureCaseSensitive("GALLON", "[gal_br]");
	public static final UnitsOfMeasureCaseSensitive INCH= new UnitsOfMeasureCaseSensitive("INCH", "[in_i]");
	public static final UnitsOfMeasureCaseSensitive POUND= new UnitsOfMeasureCaseSensitive("POUND", "[lb_av]");
	public static final UnitsOfMeasureCaseSensitive OUNCE= new UnitsOfMeasureCaseSensitive("OUNCE", "[oz_av]");
	public static final UnitsOfMeasureCaseSensitive PINT= new UnitsOfMeasureCaseSensitive("PINT", "[pt_br]");
	public static final UnitsOfMeasureCaseSensitive QUART= new UnitsOfMeasureCaseSensitive("QUART", "[qt_br]");
	public static final UnitsOfMeasureCaseSensitive SQUARE_FOOT= new UnitsOfMeasureCaseSensitive("SQUARE_FOOT", "[sft_i]");
	public static final UnitsOfMeasureCaseSensitive SQUARE_INCH= new UnitsOfMeasureCaseSensitive("SQUARE_INCH", "[sin_i]");
	public static final UnitsOfMeasureCaseSensitive SQUARE_YARD= new UnitsOfMeasureCaseSensitive("SQUARE_YARD", "[syd_i]");
	public static final UnitsOfMeasureCaseSensitive TABLESPOON= new UnitsOfMeasureCaseSensitive("TABLESPOON", "[tbs_us]");
	public static final UnitsOfMeasureCaseSensitive TEASPOON= new UnitsOfMeasureCaseSensitive("TEASPOON", "[tsp_us]");
	public static final UnitsOfMeasureCaseSensitive YARD= new UnitsOfMeasureCaseSensitive("YARD", "[yd_i]");
	public static final UnitsOfMeasureCaseSensitive YEAR= new UnitsOfMeasureCaseSensitive("YEAR", "a");
	public static final UnitsOfMeasureCaseSensitive CENTIMETRE= new UnitsOfMeasureCaseSensitive("CENTIMETRE", "cm");
	public static final UnitsOfMeasureCaseSensitive SQUARE_CENTIMETRE= new UnitsOfMeasureCaseSensitive("SQUARE_CENTIMETRE", "cm2");
	public static final UnitsOfMeasureCaseSensitive CUBIC_CENTIMETER= new UnitsOfMeasureCaseSensitive("CUBIC_CENTIMETER", "cm3");
	public static final UnitsOfMeasureCaseSensitive DAY= new UnitsOfMeasureCaseSensitive("DAY", "d");
	public static final UnitsOfMeasureCaseSensitive DECAGRAM= new UnitsOfMeasureCaseSensitive("DECAGRAM", "dg");
	public static final UnitsOfMeasureCaseSensitive DECALITRE= new UnitsOfMeasureCaseSensitive("DECALITRE", "dL");
	public static final UnitsOfMeasureCaseSensitive DECALITRE_LOWER= new UnitsOfMeasureCaseSensitive("DECALITRE_LOWER", "dl");
	public static final UnitsOfMeasureCaseSensitive GRAM= new UnitsOfMeasureCaseSensitive("GRAM", "g");
	public static final UnitsOfMeasureCaseSensitive GRAM_PER_DAY= new UnitsOfMeasureCaseSensitive("GRAM_PER_DAY", "g/d");
	public static final UnitsOfMeasureCaseSensitive GRAMS_PER_LITRE= new UnitsOfMeasureCaseSensitive("GRAMS_PER_LITRE", "g/L");
	public static final UnitsOfMeasureCaseSensitive GRAMS_PER_LITRE_LOWER= new UnitsOfMeasureCaseSensitive("GRAMS_PER_LITRE_LOWER", "g/l");
	public static final UnitsOfMeasureCaseSensitive GRAMS_PER_DECILITRE= new UnitsOfMeasureCaseSensitive("GRAMS_PER_DECILITRE", "g/dL");
	public static final UnitsOfMeasureCaseSensitive GRAMS_PER_DECILITRE_LOWER= new UnitsOfMeasureCaseSensitive("GRAMS_PER_DECILITRE_LOWER", "g/dl");
	public static final UnitsOfMeasureCaseSensitive HOUR= new UnitsOfMeasureCaseSensitive("HOUR", "h");
	public static final UnitsOfMeasureCaseSensitive INTERNATIONAL_UNIT= new UnitsOfMeasureCaseSensitive("INTERNATIONAL_UNIT", "iU");
	public static final UnitsOfMeasureCaseSensitive KILOGRAM= new UnitsOfMeasureCaseSensitive("KILOGRAM", "kg");
	public static final UnitsOfMeasureCaseSensitive LITRE= new UnitsOfMeasureCaseSensitive("LITRE", "L");
	public static final UnitsOfMeasureCaseSensitive LITRE_LOWER= new UnitsOfMeasureCaseSensitive("LITRE_LOWER", "l");
	public static final UnitsOfMeasureCaseSensitive METRE= new UnitsOfMeasureCaseSensitive("METRE", "m");
	public static final UnitsOfMeasureCaseSensitive SQUARE_METRE= new UnitsOfMeasureCaseSensitive("SQUARE_METRE", "m2");
	public static final UnitsOfMeasureCaseSensitive MILLIUNIT= new UnitsOfMeasureCaseSensitive("MILLIUNIT", "mU");
	public static final UnitsOfMeasureCaseSensitive MILLIEQUIVALENT= new UnitsOfMeasureCaseSensitive("MILLIEQUIVALENT", "meq");
	public static final UnitsOfMeasureCaseSensitive MILLIGRAM= new UnitsOfMeasureCaseSensitive("MILLIGRAM", "mg");
	public static final UnitsOfMeasureCaseSensitive MILLIGRAM_PER_DAY= new UnitsOfMeasureCaseSensitive("MILLIGRAM_PER_DAY", "mg/d");
	public static final UnitsOfMeasureCaseSensitive MINUTE= new UnitsOfMeasureCaseSensitive("MINUTE", "min");
	public static final UnitsOfMeasureCaseSensitive MILLILITRE= new UnitsOfMeasureCaseSensitive("MILLILITRE", "mL");
	public static final UnitsOfMeasureCaseSensitive MILLILITRE_LOWER= new UnitsOfMeasureCaseSensitive("MILLILITRE_LOWER", "ml");
	public static final UnitsOfMeasureCaseSensitive MILLILITRE_PER_SECOND= new UnitsOfMeasureCaseSensitive("MILLILITRE_PER_SECOND", "mL/s");
	public static final UnitsOfMeasureCaseSensitive MILLILITRE_PER_SECOND_LOWER= new UnitsOfMeasureCaseSensitive("MILLILITRE_PER_SECOND_LOWER", "ml/s");
	public static final UnitsOfMeasureCaseSensitive MILLILITRE_PER_MINUTE= new UnitsOfMeasureCaseSensitive("MILLILITRE_PER_MINUTE", "mL/min");
	public static final UnitsOfMeasureCaseSensitive MILLILITRE_PER_MINUTE_LOWER= new UnitsOfMeasureCaseSensitive("MILLILITRE_PER_MINUTE_LOWER", "ml/min");
	public static final UnitsOfMeasureCaseSensitive MILLIMETER= new UnitsOfMeasureCaseSensitive("MILLIMETER", "mm");
	public static final UnitsOfMeasureCaseSensitive SQUARE_MILLIMETRE= new UnitsOfMeasureCaseSensitive("SQUARE_MILLIMETRE", "mm2");
	public static final UnitsOfMeasureCaseSensitive CUBIC_MILIMETER= new UnitsOfMeasureCaseSensitive("CUBIC_MILIMETER", "mm3");
	public static final UnitsOfMeasureCaseSensitive MILLIMETERS_OF_MERCURY_PRESSURE= new UnitsOfMeasureCaseSensitive("MILLIMETERS_OF_MERCURY_PRESSURE", "mm[Hg]");
	public static final UnitsOfMeasureCaseSensitive MILLIMOLE= new UnitsOfMeasureCaseSensitive("MILLIMOLE", "mmol");
	public static final UnitsOfMeasureCaseSensitive MILLIMOLES_PER_LITRE= new UnitsOfMeasureCaseSensitive("MILLIMOLES_PER_LITRE", "mmol/L");
	public static final UnitsOfMeasureCaseSensitive MILLIMOLES_PER_LITRE_LOWER= new UnitsOfMeasureCaseSensitive("MILLIMOLES_PER_LITRE_LOWER", "mmol/l");
	public static final UnitsOfMeasureCaseSensitive MONTH= new UnitsOfMeasureCaseSensitive("MONTH", "mo");
	public static final UnitsOfMeasureCaseSensitive MOLE= new UnitsOfMeasureCaseSensitive("MOLE", "mol");
	public static final UnitsOfMeasureCaseSensitive MILLISECOND= new UnitsOfMeasureCaseSensitive("MILLISECOND", "ms");
	public static final UnitsOfMeasureCaseSensitive NANOGRAM= new UnitsOfMeasureCaseSensitive("NANOGRAM", "ng");
	public static final UnitsOfMeasureCaseSensitive NANOLITRE= new UnitsOfMeasureCaseSensitive("NANOLITRE", "nL");
	public static final UnitsOfMeasureCaseSensitive NANOLITRE_LOWER= new UnitsOfMeasureCaseSensitive("NANOLITRE_LOWER", "nl");
	public static final UnitsOfMeasureCaseSensitive PICOGRAMS_PER_MILLILITRE= new UnitsOfMeasureCaseSensitive("PICOGRAMS_PER_MILLILITRE", "pg/mL");
	public static final UnitsOfMeasureCaseSensitive PICOGRAMS_PER_MILLILITRE_LOWER= new UnitsOfMeasureCaseSensitive("PICOGRAMS_PER_MILLILITRE_LOWER", "pg/ml");
	public static final UnitsOfMeasureCaseSensitive SECOND= new UnitsOfMeasureCaseSensitive("SECOND", "s");
	public static final UnitsOfMeasureCaseSensitive MICROGRAM= new UnitsOfMeasureCaseSensitive("MICROGRAM", "ug");
	public static final UnitsOfMeasureCaseSensitive MICROGRAM_PER_MINUTE= new UnitsOfMeasureCaseSensitive("MICROGRAM_PER_MINUTE", "ug/min");
	public static final UnitsOfMeasureCaseSensitive MICROLITRE= new UnitsOfMeasureCaseSensitive("MICROLITRE", "uL");
	public static final UnitsOfMeasureCaseSensitive MICROLITRE_LOWER= new UnitsOfMeasureCaseSensitive("MICROLITRE_LOWER", "ul");
	public static final UnitsOfMeasureCaseSensitive MICROMOLE= new UnitsOfMeasureCaseSensitive("MICROMOLE", "umol");
	public static final UnitsOfMeasureCaseSensitive MICROMOLES_PER_LITRE= new UnitsOfMeasureCaseSensitive("MICROMOLES_PER_LITRE", "umol/L");
	public static final UnitsOfMeasureCaseSensitive MICROMOLES_PER_LITRE_LOWER= new UnitsOfMeasureCaseSensitive("MICROMOLES_PER_LITRE_LOWER", "umol/l");
	public static final UnitsOfMeasureCaseSensitive WEEK= new UnitsOfMeasureCaseSensitive("WEEK", "wk");
	
	public static final UnitsOfMeasureCaseSensitive MILLIGRAMS_PER_ACTUATION= new UnitsOfMeasureCaseSensitive("MILLIGRAMS_PER_ACTUATION", "mg/actuat");
	
	public static final UnitsOfMeasureCaseSensitive MILE = new UnitsOfMeasureCaseSensitive("MILE", "[mi_us]"); 
	public static final UnitsOfMeasureCaseSensitive DEGREE = new UnitsOfMeasureCaseSensitive("DEGREE", "deg"); 
	public static final UnitsOfMeasureCaseSensitive KILOMETER = new UnitsOfMeasureCaseSensitive("KILOMETER", "km"); 
	public static final UnitsOfMeasureCaseSensitive METER = new UnitsOfMeasureCaseSensitive("METER", "m"); 

    private final String codeValue;
	private final String description;

    private UnitsOfMeasureCaseSensitive(String name, String codeValue) {
    	this(name, codeValue, DescribableUtil.getDefaultDescription(name));
    }
    
    private UnitsOfMeasureCaseSensitive(String name, String codeValue, String description) {
    	super(name);
    	this.codeValue = codeValue;
		this.description = description;
    }
    
    /**
     * <p>Returns the code system for this unit of measurement.
     * 
     * @return the code system for this unit of measurement.
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_UNIFORM_UNIT_OF_MEASURE.getRoot();
    }

    /**
     * <p>Returns the value of the unit of measurement.
     * 
     * @return the value of the unit of measurement.
     */
    public String getCodeValue() {
        return this.codeValue;
    }

    /**
     * <p>Returns the description of this unit of measurement.
     * 
     * @return the description of this unit of measurement.
     */
	public String getDescription() {
		return this.description;
	}
}
