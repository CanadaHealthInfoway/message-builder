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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2014-04-10 17:43:48 -0400 (Thu, 10 Apr 2014) $
 * Revision:      $LastChangedRevision: 8508 $
 */

package ca.infoway.messagebuilder.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * <p>Specification of cardinality and fixed value constraints on fields inside a standard datatype.
 * 
 * <p>Only used in the context of CDA documents
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
public class SchematronRule {
	
	@Element
	private SchematronTest test;
	@Element(required=false)
	private SchematronDescription description;

	/**
	 * <p>Default constructor.
	 */
	public SchematronRule() {
	}
	
	public SchematronRule(String test, String description) {
		this.test = new SchematronTest(test);
		if (description != null) {
			this.description = new SchematronDescription(description);
		}
	}

	public SchematronTest getTest() {
		return test;
	}

	public void setTest(SchematronTest test) {
		this.test = test;
	}

	public SchematronDescription getDescription() {
		return description;
	}

	public void setDescription(SchematronDescription description) {
		this.description = description;
	}

	
}
