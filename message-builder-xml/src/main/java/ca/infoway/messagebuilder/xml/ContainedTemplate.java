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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-11-06 15:40:43 -0500 (Thu, 06 Nov 2014) $
 * Revision:      $LastChangedRevision: 9058 $
 */

package ca.infoway.messagebuilder.xml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * <p>A message part relationship (either an attribute or an association).
 * 
 * <p>Fundamentally, we think of there being four types of relationships:
 * 
 * <ol>
 * <li>Attributes
 * <li>Simple associations
 * <li>Choice associations
 * <li>Template associations
 * </ol>
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
public class ContainedTemplate {

	@Attribute
	private String templateOid;
	@Attribute(required=false)
	private String cardinality;

	/**
	 * <p>Default constructor.
	 */
	public ContainedTemplate() {
	}
	
	/**
	 * <p>Standard constructor.
	 * @param templateOid - the OID of the template
	 * @param cardinality - the cardinality.
	 */
	public ContainedTemplate(String templateOid, Cardinality cardinality) {
		this.templateOid = templateOid;
		this.cardinality = cardinality.toString();
	}
	

	public String getTemplateOid() {
		return templateOid;
	}

	public void setTemplateOid(String templateOid) {
		this.templateOid = templateOid;
	}

	/**
	 * <p>Get the cardinality.
	 * @return the cardinality
	 */
	public Cardinality getCardinality() {
		Cardinality temp = Cardinality.create(this.cardinality);
		if (temp != null) {
			return temp;
		} else {
			return Cardinality.create("0-1");
		}
	}

	/**
	 * <p>Set the cardinality.
	 * @param cardinality - the new value
	 */
	public void setCardinality(Cardinality cardinality) {
		this.cardinality = cardinality == null ? null : cardinality.toString();
	}

	public String getRawCardinality() {
		return this.cardinality;
	}
	
}
