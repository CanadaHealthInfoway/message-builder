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

package ca.infoway.messagebuilder.datatype.lang;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>An enum for telecom address uses. Used mainly within tests. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class TelecommunicationAddressUse extends EnumPattern implements Describable, 
		ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse {
    private static final long serialVersionUID = -3649151061999838824L;
	public static final TelecommunicationAddressUse HOME = new TelecommunicationAddressUse("HOME", "H");
    public static final TelecommunicationAddressUse PRIMARY_HOME = new TelecommunicationAddressUse("PRIMARY_HOME", "HP"); 
    public static final TelecommunicationAddressUse VACATION_HOME = new TelecommunicationAddressUse("VACATION_HOME", "HV"); 
    public static final TelecommunicationAddressUse WORKPLACE = new TelecommunicationAddressUse("WORKPLACE", "WP"); 
    public static final TelecommunicationAddressUse DIRECT = new TelecommunicationAddressUse("DIRECT", "DIR"); 
    public static final TelecommunicationAddressUse PUBLISHED = new TelecommunicationAddressUse("PUBLISHED", "PUB"); 
    public static final TelecommunicationAddressUse BAD = new TelecommunicationAddressUse("BAD", "BAD"); 
    public static final TelecommunicationAddressUse TEMPORARY = new TelecommunicationAddressUse("TEMPORARY", "TMP"); 
    public static final TelecommunicationAddressUse ANSWERING_MACHINE = new TelecommunicationAddressUse("ANSWERING_MACHINE", "AS");
    public static final TelecommunicationAddressUse EMERGENCY_CONTACT = new TelecommunicationAddressUse("EMERGENCY_CONTACT", "EC"); 
    public static final TelecommunicationAddressUse MOBILE = new TelecommunicationAddressUse("MOBILE", "MC"); 
    public static final TelecommunicationAddressUse PAGER = new TelecommunicationAddressUse("PAGER", "PG");

    private final String codeValue;

    private TelecommunicationAddressUse(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }

    /**
     * <p>Returns the code system for this telecom address use.
     * 
     * @return the code system for this telecom address use
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_TELECOMMUNICATION_ADDRESS_USE.getRoot();
    }

    /**
     * <p>Returns the code for this telecome address use.
     * 
     * @return the code for this telecome address use.
     */
    public String getCodeValue() {
        return this.codeValue;
    }

    /**
     * <p>Returns a description of this telecom address use.
     *  
     * @return a description of this telecom address use. 
     */
    public String getDescription() {
        return DescribableUtil.getDefaultDescription(name());
    }
}
