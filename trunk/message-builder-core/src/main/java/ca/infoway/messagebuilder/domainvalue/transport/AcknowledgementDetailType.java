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

package ca.infoway.messagebuilder.domainvalue.transport;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum AcknowledgementDetailType. A code distinguishing between errors, 
 * warnings and information messages related to the transmission of the message
 */
public class AcknowledgementDetailType extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.AcknowledgementDetailType {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
    
    private static final long serialVersionUID = -5837485473668582469L;
    
	public static final AcknowledgementDetailType ERROR = new AcknowledgementDetailType("ERROR", "E");
    public static final AcknowledgementDetailType INFORMATION = new AcknowledgementDetailType("INFORMATION", "I"); 
    public static final AcknowledgementDetailType WARNING = new AcknowledgementDetailType("WARNING", "W");

    private final String codeValue;

    private AcknowledgementDetailType(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_ACKNOWLEDGEMENT_DETAIL_TYPE.getRoot();
    }

    /**
     * {@inheritDoc}
     */
    public String getCodeValue() {
        return this.codeValue;
    }
}
