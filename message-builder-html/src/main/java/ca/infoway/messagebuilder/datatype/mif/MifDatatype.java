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
package ca.infoway.messagebuilder.datatype.mif;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class MifDatatype {

	@Attribute
	private String name;
	
	@Attribute
	private String title;
	
	@Attribute(required=false)
	private Boolean isAbstract;
	
	@Attribute
	private String datatypeKind;
	
	@Attribute
	private String visibility;
	
	@Element(required=false)
	private MifAnnotations annotations;
	
	@ElementList(entry="property",required=false,inline=true)
	private List<MifProperty> properties = new ArrayList<MifProperty>();

	@ElementList(entry="enumerationValue",required=false,inline=true)
	private List<MifSimpleText> enumerationValues = new ArrayList<MifSimpleText>();

	@ElementList(entry="derivedFrom",required=false,inline=true)
	private List<MifDerivedFrom> derivedFromList = new ArrayList<MifDerivedFrom>();
	
	public MifAnnotations getAnnotations() {
		return annotations;
	}
	public void setAnnotations(MifAnnotations annotations) {
		this.annotations = annotations;
	}

	public List<MifProperty> getProperties() {
		return properties;
	}
	public void setProperties(List<MifProperty> properties) {
		this.properties = properties;
	}
	public List<MifDerivedFrom> getDerivedFrom() {
		return derivedFromList;
	}
	public void setDerivedFrom(List<MifDerivedFrom> derivedFromList) {
		this.derivedFromList = derivedFromList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getIsAbstract() {
		return isAbstract;
	}
	public void setIsAbstract(Boolean isAbstract) {
		this.isAbstract = isAbstract;
	}
	public String getDatatypeKind() {
		return datatypeKind;
	}
	public void setDatatypeKind(String datatypeKind) {
		this.datatypeKind = datatypeKind;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	
	
}
