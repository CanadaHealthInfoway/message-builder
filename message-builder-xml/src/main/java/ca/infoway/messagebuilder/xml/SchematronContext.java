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

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 * <p>Specification of cardinality and fixed value constraints on fields inside a standard datatype.
 * 
 * <p>Only used in the context of CDA documents
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
public class SchematronContext {
	
	@Attribute
	private String context;

	@ElementList(required=false,inline=true,entry="schematronRule")
	private List<SchematronRule> rules = new ArrayList<SchematronRule>();

	/**
	 * <p>Default constructor.
	 */
	public SchematronContext() {
	}
	
	/**
	 * <p>Standard constructor.
	 * @param context - the context.
	 */
	public SchematronContext(String context) {
		this.context = context;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public List<SchematronRule> getRules() {
		return rules;
	}
	
	public void addRule(SchematronRule rule) {
		this.rules.add(rule);
	}
	
}
