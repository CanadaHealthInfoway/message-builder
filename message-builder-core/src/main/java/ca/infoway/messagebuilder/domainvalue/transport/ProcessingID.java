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
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>Codes used to specify whether a message is part of a production, training, 
 * or debugging system.
 */
public class ProcessingID extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.ProcessingID, Describable {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
    private static final long serialVersionUID = -4810533940602682646L;
    
	public static final ProcessingID DEBUGGING  = new ProcessingID("DEBUGGING", "D"); 
    public static final ProcessingID PRODUCTION = new ProcessingID("PRODUCTION", "P"); 
    public static final ProcessingID TRAINING = new ProcessingID("TRAINING", "T");

    private final String codeValue;

    private ProcessingID(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }

    /**
     * {@inheritDoc}
     */
    public String getCodeSystem() {
        return "";
    }

    /**
     * {@inheritDoc}
     */
    public String getCodeSystemName() {
    	return null;
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
