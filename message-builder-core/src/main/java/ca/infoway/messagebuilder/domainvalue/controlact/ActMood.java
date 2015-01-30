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

package ca.infoway.messagebuilder.domainvalue.controlact;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum ActMood. 
 */
public class ActMood extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.ActMood, Describable {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
	private static final long serialVersionUID = 584607967819653758L;
	
	public static final ActMood DEF = new ActMood("DEF"); 
	public static final ActMood EVN = new ActMood("EVN"); 
	public static final ActMood EVN_CRT = new ActMood("EVN.CRT"); 
	public static final ActMood EVNINT_CRT = new ActMood("EVNINT.CRT"); 
	public static final ActMood INT = new ActMood("INT"); 
	public static final ActMood PERM = new ActMood("PERM"); 
	public static final ActMood RQO = new ActMood("RQO"); 

	private ActMood(String name) {
		super(name);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_ACT_MOOD.getRoot();
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
		return name();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}
}
