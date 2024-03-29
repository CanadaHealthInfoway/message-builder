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

package ca.infoway.messagebuilder.datatype;

import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;

/**
 * <p>A class to represent CeRx's notion of a physical quantity. Backed by the java datatype PhysicalQuantity.
 *
 * <p>There are two attributes of note: value (amount) and unit.
 * 
 * <p>The HL7 version of this class relies on the HL7 REAL, which is a
 * re-implemented BigDecimal for all intents and purposes.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @see <a href="http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-PQ">The HL7 Definition</a>
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public interface PQ extends QTY<PhysicalQuantity>, SetOperatorType {

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
