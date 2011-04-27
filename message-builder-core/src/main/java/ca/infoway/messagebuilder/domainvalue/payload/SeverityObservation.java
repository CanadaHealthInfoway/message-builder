/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.domainvalue.payload;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum SeverityObservation. An indication of the seriousness of a patient's medical 
 * condition or issues. Conditions for which severity levels are assigned include: disease state, 
 * allergies, intolerance and contraindications involving combinations of drugs and other conditions.
 */
public class SeverityObservation extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.SeverityObservation {
	
	private static final long serialVersionUID = -5776943781743759764L;
	
	public static final SeverityObservation HIGH = new SeverityObservation("HIGH", "H"); 
	public static final SeverityObservation MODERATE = new SeverityObservation("MODERATE", "M"); 
	public static final SeverityObservation LOW = new SeverityObservation("LOW", "L");

    private final String codeValue;

    private SeverityObservation(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }

	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_SEVERITY_OBSERVATION.getRoot();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		return this.codeValue;
	}
}
