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
 * <p>Tracks metadata necessary for generating an XSD schema.
 * 
 * <p>Only used in the context of CDA documents
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
public class SchemaMetadata {
	
	@Attribute
	private String targetNamespace;
	
	@Attribute
	private String elementFormDefault;
	
	@ElementList(inline=true,entry="documentation")
	private List<String> documentation = new ArrayList<String>();
	
	@ElementList(inline=true,entry="includeSchemaLocation")
	private List<String> schemaLocations = new ArrayList<String>();
	

	/**
	 * <p>Default constructor.
	 */
	public SchemaMetadata() {
	}

	public String getTargetNamespace() {
		return targetNamespace;
	}

	public void setTargetNamespace(String targetNamespace) {
		this.targetNamespace = targetNamespace;
	}

	public String getElementFormDefault() {
		return elementFormDefault;
	}

	public void setElementFormDefault(String elementFormDefault) {
		this.elementFormDefault = elementFormDefault;
	}

	public List<String> getDocumentation() {
		return documentation;
	}

	public void addDocumentation(String documentation) {
		this.documentation.add(documentation);
	}

	public List<String> getSchemaLocations() {
		return schemaLocations;
	}

	public void setSchemaLocations(List<String> schemaLocations) {
		this.schemaLocations = schemaLocations;
	}
	
}
