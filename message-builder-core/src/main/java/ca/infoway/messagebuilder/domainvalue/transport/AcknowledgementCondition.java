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

package ca.infoway.messagebuilder.domainvalue.transport;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The codes identify the conditions under which accept acknowledgements are 
 * required to be returned in response to this message. Note that accept acknowledgement 
 * address two different issues at the same time: reliable transport as well as syntactical correct
 * 
 * @author administrator
 */
public class AcknowledgementCondition extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.AcknowledgementCondition, Describable {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
	private static final long serialVersionUID = 7605543876867112424L;

	/**
	 *  Always send an acknowledgement.
	 */
    public static final AcknowledgementCondition ALWAYS = new AcknowledgementCondition("ALWAYS", "AL"); 
    
    /**
     * Send an acknowledgement for error/reject conditions only.
     */
    public static final AcknowledgementCondition ERRORS_ONLY = new AcknowledgementCondition("ERRORS_ONLY", "ER"); 
    /**
     * Never send an acknowledgement.
     */
    public static final AcknowledgementCondition NEVER = new AcknowledgementCondition("NEVER", "NE");

    private final String codeValue;

    private AcknowledgementCondition(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_ACKNOWLEDGEMENT_CONDITION.getRoot();
    }

    /**
     * {@inheritDoc}
     */
    public String getCodeValue() {
        return this.codeValue;
    }

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}

}
