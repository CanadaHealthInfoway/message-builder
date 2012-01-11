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

package ca.infoway.messagebuilder.datatype;

import java.util.List;

import ca.infoway.messagebuilder.Code;

/**
 * <p>HL7 datatype CD. Backed by a Code.
 * 
 * <p>A CD represents any kind of concept usually by giving a code defined in a
 * code system. A CD can contain the original text or phrase that served as the
 * basis of the coding and one or more translations into different coding
 * systems. A CD can also contain qualifiers to describe, e.g., the concept of a
 * "left foot" as a postcoordinated term built from the primary code "FOOT" and
 * the qualifier "LEFT". In cases of an exceptional value, the CD need not
 * contain a code but only the original text describing that concept.
 * 
 * <p>CD is mostly used in one of its restricted or "profiled" forms, CS, CE, CV.
 * Use of the full concept descriptor data type is not common. It requires a
 * conscious decision and documented rationale. In all other cases, one of the
 * CD restrictions shall be used.
 * 
 * <p>All CD restrictions constrain certain properties. Properties may be
 * constrained to the extent that only one value may be allowed for that
 * property, in which case mentioning the property becomes redundant.
 * Constraining a property to one value is referred to as suppressing that
 * property. Although, conceptually a suppressed property is still semantically
 * applicable, it is safe for an HL7 interface to assume the implicit default
 * value without testing.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <V> the underlying code type.
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public interface CD extends ANY<Code> {
	
	/**
	 * Returns the display name.
	 * 
	 * @return the display name
	 */
	public String getDisplayName(); // CD.LAB only
	
	/**
	 * Sets the display name.
	 * 
	 * @param displayName the display name
	 */
	public void setDisplayName(String displayName); // CD.LAB only
	
	/**
	 * Returns the translations for this CD.
	 * 
	 * @return the translations for this CD
	 */
	public List<CD> getTranslations();
	
	/**
	 * Returns the original text.
	 * 
	 * @return the original text
	 */
	public String getOriginalText();
	
	/**
	 * Sets the original text.
	 * 
	 * @param originalText the original text
	 */
	public void setOriginalText(String originalText);
	
}
