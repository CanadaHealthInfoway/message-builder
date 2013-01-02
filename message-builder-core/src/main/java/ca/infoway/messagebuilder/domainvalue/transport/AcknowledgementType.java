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
 * <p>The Enum AcknowledgementType. This attribute contains an acknowledgement code as described in the HL7 message processing rules.
 */
public class AcknowledgementType extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.AcknowledgementType, Describable {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
    
    private static final long serialVersionUID = -1689382159743562443L;
    
	public static final AcknowledgementType ACCEPT_ACKNOWLEDGEMENT_COMMIT_ACCEPT = new AcknowledgementType("ACCEPT_ACKNOWLEDGEMENT_COMMIT_ACCEPT", "CA", true); 
    public static final AcknowledgementType ACCEPT_ACKNOWLEDGEMENT_COMMIT_ERROR = new AcknowledgementType("ACCEPT_ACKNOWLEDGEMENT_COMMIT_ERROR", "CE", false);
    public static final AcknowledgementType ACCEPT_ACKNOWLEDGEMENT_COMMIT_REJECT = new AcknowledgementType("ACCEPT_ACKNOWLEDGEMENT_COMMIT_REJECT", "CR", false);
    public static final AcknowledgementType APPLICATION_ACKNOWLEDGEMENT_ACCEPT = new AcknowledgementType("APPLICATION_ACKNOWLEDGEMENT_ACCEPT", "AA", true);
    public static final AcknowledgementType APPLICATION_ACKNOWLEDGEMENT_ERROR = new AcknowledgementType("APPLICATION_ACKNOWLEDGEMENT_ERROR", "AE", false);
    public static final AcknowledgementType APPLICATION_ACKNOWLEDGEMENT_REJECT = new AcknowledgementType("APPLICATION_ACKNOWLEDGEMENT_REJECT", "AR", false);

    private final String codeValue;
    private final boolean accepted;

    private AcknowledgementType(String name, String codeValue, boolean accepted) {
    	super(name);
        this.codeValue = codeValue;
        this.accepted = accepted;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_ACKNOWLEDGEMENT_TYPE.getRoot();
    }

    /**
     * {@inheritDoc}
     */
    public String getCodeValue() {
        return this.codeValue;
    }
    
    /**
     * <p>Checks if is accepted.
     *
     * @return true, if is accepted
     */
    public boolean isAccepted() {
        return this.accepted;
    }

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}
}
