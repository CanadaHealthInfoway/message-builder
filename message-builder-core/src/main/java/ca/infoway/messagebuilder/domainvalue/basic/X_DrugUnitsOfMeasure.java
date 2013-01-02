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
package ca.infoway.messagebuilder.domainvalue.basic;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.lang.EnumPattern;

public class X_DrugUnitsOfMeasure extends EnumPattern implements x_DrugUnitsOfMeasure {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
	private static final long serialVersionUID = 3134130558551921271L;
	
	public static final X_DrugUnitsOfMeasure PERCENT= new X_DrugUnitsOfMeasure("PERCENT", "%");
	public static final X_DrugUnitsOfMeasure CUP= new X_DrugUnitsOfMeasure("CUP", "[cup_us]");
	public static final X_DrugUnitsOfMeasure FLUID_OUNCE= new X_DrugUnitsOfMeasure("FLUID_OUNCE", "[foz_br]");
	public static final X_DrugUnitsOfMeasure GALLON= new X_DrugUnitsOfMeasure("GALLON", "[gal_br]");
	public static final X_DrugUnitsOfMeasure POUND= new X_DrugUnitsOfMeasure("POUND", "[lb_av]");
	public static final X_DrugUnitsOfMeasure OUNCE= new X_DrugUnitsOfMeasure("OUNCE", "[oz_av]");
	public static final X_DrugUnitsOfMeasure PINT= new X_DrugUnitsOfMeasure("PINT", "[pt_br]");
	public static final X_DrugUnitsOfMeasure QUART= new X_DrugUnitsOfMeasure("QUART", "[qt_br]");
	public static final X_DrugUnitsOfMeasure SQUARE_FOOT= new X_DrugUnitsOfMeasure("SQUARE_FOOT", "[sft_i]");
	public static final X_DrugUnitsOfMeasure SQUARE_INCH= new X_DrugUnitsOfMeasure("SQUARE_INCH", "[sin_i]");
	public static final X_DrugUnitsOfMeasure SQUARE_YARD= new X_DrugUnitsOfMeasure("SQUARE_YARD", "[syd_i]");
	public static final X_DrugUnitsOfMeasure TABLESPOON= new X_DrugUnitsOfMeasure("TABLESPOON", "[tbs_us]");
	public static final X_DrugUnitsOfMeasure TEASPOON= new X_DrugUnitsOfMeasure("TEASPOON", "[tsp_us]");
	public static final X_DrugUnitsOfMeasure SQUARE_CENTIMETRE= new X_DrugUnitsOfMeasure("SQUARE_CENTIMETRE", "cm2");
	public static final X_DrugUnitsOfMeasure CUBIC_CENTIMETER= new X_DrugUnitsOfMeasure("CUBIC_CENTIMETER", "cm3");
	public static final X_DrugUnitsOfMeasure GRAM= new X_DrugUnitsOfMeasure("GRAM", "g");
	public static final X_DrugUnitsOfMeasure INTERNATIONAL_UNIT= new X_DrugUnitsOfMeasure("INTERNATIONAL_UNIT", "iU");
	public static final X_DrugUnitsOfMeasure KILOGRAM= new X_DrugUnitsOfMeasure("KILOGRAM", "kg");
	public static final X_DrugUnitsOfMeasure LITRE= new X_DrugUnitsOfMeasure("LITRE", "l");
	public static final X_DrugUnitsOfMeasure SQUARE_METRE= new X_DrugUnitsOfMeasure("SQUARE_METRE", "m2");
	public static final X_DrugUnitsOfMeasure MILLIEQUIVALENT= new X_DrugUnitsOfMeasure("MILLIEQUIVALENT", "meq");
	public static final X_DrugUnitsOfMeasure MILLIGRAM= new X_DrugUnitsOfMeasure("MILLIGRAM", "mg");
	public static final X_DrugUnitsOfMeasure MILLILITRE= new X_DrugUnitsOfMeasure("MILLILITRE", "ml");
	public static final X_DrugUnitsOfMeasure SQUARE_MILLIMETRE= new X_DrugUnitsOfMeasure("SQUARE_MILLIMETRE", "mm2");
	public static final X_DrugUnitsOfMeasure CUBIC_MILIMETER= new X_DrugUnitsOfMeasure("CUBIC_MILIMETER", "mm3");
	public static final X_DrugUnitsOfMeasure MILLIMOLE= new X_DrugUnitsOfMeasure("MILLIMOLE", "mmol");
	public static final X_DrugUnitsOfMeasure MOLE= new X_DrugUnitsOfMeasure("MOLE", "mol");
	public static final X_DrugUnitsOfMeasure MILLIUNIT= new X_DrugUnitsOfMeasure("MILLIUNIT", "mU");
	public static final X_DrugUnitsOfMeasure NANOGRAM= new X_DrugUnitsOfMeasure("NANOGRAM", "ng");
	public static final X_DrugUnitsOfMeasure NANOLITRE= new X_DrugUnitsOfMeasure("NANOLITRE", "nl");
	public static final X_DrugUnitsOfMeasure UNIT= new X_DrugUnitsOfMeasure("UNIT", "U");
	public static final X_DrugUnitsOfMeasure MICROGRAM= new X_DrugUnitsOfMeasure("MICROGRAM", "ug");
	public static final X_DrugUnitsOfMeasure MICROLITRE= new X_DrugUnitsOfMeasure("MICROLITRE", "ul");
	public static final X_DrugUnitsOfMeasure MICROMOLE= new X_DrugUnitsOfMeasure("MICROMOLE", "umol");
	
	private final String codeValue;

	private X_DrugUnitsOfMeasure(String name, String codeValue) {
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
