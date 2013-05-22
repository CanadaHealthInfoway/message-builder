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
 * Last modified: $LastChangedDate: 2012-03-06 13:41:31 -0500 (Tue, 06 Mar 2012) $
 * Revision:      $LastChangedRevision: 5770 $
 */
package ca.infoway.messagebuilder.generator.mif2.vocabulary;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(strict=false)
@Namespace(prefix="mif",reference="urn:hl7-org:v3/mif2")
public class MifCodeSystemConcept {

	@Attribute(required=false,name="isSelectable")
	private boolean selectable = true;
	@Element(required=false)
	private MifAnnotations annotations;
	@ElementList(required=false,inline=true,entry="conceptRelationship")
	private List<MifConceptRelationship> relationships;
	@ElementList(required=false,inline=true,entry="printName")
	private List<MifConceptPrintName> printNames;
	@ElementList(required=false,inline=true,entry="code")
	private List<MifCode> codes;
	public boolean isSelectable() {
		return selectable;
	}
	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}
	public MifAnnotations getAnnotations() {
		return annotations;
	}
	public void setAnnotations(MifAnnotations annotations) {
		this.annotations = annotations;
	}
	public List<MifConceptRelationship> getRelationships() {
		return relationships;
	}
	public void setRelationships(List<MifConceptRelationship> relationships) {
		this.relationships = relationships;
	}
	public List<MifConceptPrintName> getPrintNames() {
		return printNames;
	}
	public void setPrintNames(List<MifConceptPrintName> printNames) {
		this.printNames = printNames;
	}
	public List<MifCode> getCodes() {
		return codes;
	}
	public void setCodes(List<MifCode> codes) {
		this.codes = codes;
	}
}
