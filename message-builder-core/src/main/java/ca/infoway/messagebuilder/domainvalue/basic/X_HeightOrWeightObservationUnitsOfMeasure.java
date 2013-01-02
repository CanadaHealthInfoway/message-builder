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
import ca.infoway.messagebuilder.domainvalue.x_HeightOrWeightObservationUnitsOfMeasure;
import ca.infoway.messagebuilder.lang.EnumPattern;

public class X_HeightOrWeightObservationUnitsOfMeasure extends EnumPattern implements x_HeightOrWeightObservationUnitsOfMeasure {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
	private static final long serialVersionUID = 3134130558551921271L;
	
	public static final X_HeightOrWeightObservationUnitsOfMeasure FOOT = new X_HeightOrWeightObservationUnitsOfMeasure("FOOT", "[ft_i]"); 
	public static final X_HeightOrWeightObservationUnitsOfMeasure INCH = new X_HeightOrWeightObservationUnitsOfMeasure("INCH", "[in_i]"); 
	public static final X_HeightOrWeightObservationUnitsOfMeasure POUND = new X_HeightOrWeightObservationUnitsOfMeasure("POUND", "[lb_av]"); 
	public static final X_HeightOrWeightObservationUnitsOfMeasure OUNCE = new X_HeightOrWeightObservationUnitsOfMeasure("OUNCE", "[oz_av]"); 
	public static final X_HeightOrWeightObservationUnitsOfMeasure YARD = new X_HeightOrWeightObservationUnitsOfMeasure("YARD", "[yd_i]"); 
	public static final X_HeightOrWeightObservationUnitsOfMeasure CENTIMETER = new X_HeightOrWeightObservationUnitsOfMeasure("CENTIMETER", "cm"); 
	public static final X_HeightOrWeightObservationUnitsOfMeasure GRAM = new X_HeightOrWeightObservationUnitsOfMeasure("GRAM", "g"); 
	public static final X_HeightOrWeightObservationUnitsOfMeasure KILOGRAM = new X_HeightOrWeightObservationUnitsOfMeasure("KILOGRAM", "kg"); 
	public static final X_HeightOrWeightObservationUnitsOfMeasure METER = new X_HeightOrWeightObservationUnitsOfMeasure("METER", "m"); 
	public static final X_HeightOrWeightObservationUnitsOfMeasure MILLIMETER = new X_HeightOrWeightObservationUnitsOfMeasure("MILLIMETER", "mm"); 
	
	private final String codeValue;

	private X_HeightOrWeightObservationUnitsOfMeasure(String name, String codeValue) {
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
