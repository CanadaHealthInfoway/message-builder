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
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum ProcessingMode.
 */
public class ProcessingMode extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.ProcessingMode, Describable {
	
    private static final long serialVersionUID = -4741683761461235584L;
    
	public static final ProcessingMode ARCHIVE = new ProcessingMode("ARCHIVE", "A"); 
    public static final ProcessingMode CURRENT_PROCESSING = new ProcessingMode("CURRENT_PROCESSING", "T"); 
    public static final ProcessingMode INITIAL_LOAD = new ProcessingMode("INITIAL_LOAD", "I");
    public static final ProcessingMode RESTORE_FROM_ARCHIVE = new ProcessingMode("RESTORE_FROM_ARCHIVE", "R");

    private final String codeValue;

    private ProcessingMode(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_PROCESSING_MODE.getRoot();
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
