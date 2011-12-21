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

package ca.infoway.messagebuilder.domainvalue.transport;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum HL7StandardVersionCode. Indicates the version of the HL7 messaging standard being referenced. 
 * This is the domain of HL7 version codes for the Version 3 standards. Values are to be determined by HL7 
 * and added with each new version of the HL7 Standard. 
 */
public class HL7StandardVersionCode extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.HL7StandardVersionCode, Describable {
    private static final long serialVersionUID = -2697379971765691638L;
	public static final HL7StandardVersionCode V3_2005_05 = new HL7StandardVersionCode("V3_2005_05", "V3-2005-05");
    public static final HL7StandardVersionCode V3_2006_05 = new HL7StandardVersionCode("V3_2006_05", "V3-2006-05");
    public static final HL7StandardVersionCode V3_2007_05 = new HL7StandardVersionCode("V3_2007_05", "V3-2007-05");
    public static final HL7StandardVersionCode V3_2007N = new HL7StandardVersionCode("V3_2007N", "V3-2007N");
    public static final HL7StandardVersionCode V3_2008N = new HL7StandardVersionCode("V3_2008N", "V3-2008N");

    private final String codeValue;

    private HL7StandardVersionCode(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_HL7_STANDARD_VERSION_CODE.getRoot();
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
		return this.codeValue;
	}
}
