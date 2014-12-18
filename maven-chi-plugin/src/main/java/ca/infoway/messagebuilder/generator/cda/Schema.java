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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.cda;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@Root(name="schema",strict=false)
@Namespace(prefix="xs",reference="http://www.w3.org/2001/XMLSchema")
@NamespaceList({
	@Namespace(prefix="mif",reference="urn:hl7-org:v3/mif"),
	@Namespace(reference="urn:hl7-org:v3"),
	@Namespace(prefix="xs",reference="http://www.w3.org/2001/XMLSchema"),
	@Namespace(prefix="sdtc",reference="urn:hl7-org:sdtc")
})
public class Schema {
	
	@Attribute
	private String targetNamespace;
	
	@Attribute
	private String elementFormDefault;
	
	@Element
	private Annotation annotation;
	
	@ElementList(required=false,inline=true,entry="include")
	private List<Include> includes = new ArrayList<Include>();

	@ElementList(entry="complexType",required=false,inline=true)
	private List<ComplexType> complexTypes = new ArrayList<ComplexType>();
	
	@ElementList(required=false,inline=true,entry="element")
	private List<XsElement> elements = new ArrayList<XsElement>();

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

	public Annotation getAnnotation() {
		return annotation;
	}

	public void setAnnotation(Annotation annotation) {
		this.annotation = annotation;
	}

	public List<Include> getIncludes() {
		return includes;
	}

	public List<ComplexType> getComplexTypes() {
		return complexTypes;
	}
	
	public XsElement getElement(String name) {
		XsElement result = null;
		for (XsElement element : elements) {
			if (StringUtils.equals(element.getName(), name)) {
				result = element;
			}
		}
		return result;
	}
	
	public void addElement(XsElement element) {
		this.elements.add(element);
	}
}
