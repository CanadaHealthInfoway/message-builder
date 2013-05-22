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
public class MifValueSetContent {

	@Attribute(required=false)
	private String codeSystem;
	@Element(required=false)
	private MifValueSetNonComputableContent nonComputableContent;
	@ElementList(required=false,inline=true,entry="propertyBasedContent")
	private List<MifValueSetPropertyBasedContent> propertyBasedContents;
	@ElementList(required=false,inline=true,entry="codeBasedContent")
	private List<MifValueSetCodeBasedContent> codeBasedContents;
	@ElementList(required=false,inline=true,entry="combinedContent")
	private List<MifValueSetCombinedContent> combinedContents;
	@ElementList(required=false,inline=true,entry="valueSetRef")
	private List<MifValueSetReference> valueSetReferences;

	public String getCodeSystem() {
		return codeSystem;
	}

	public void setCodeSystem(String codeSystem) {
		this.codeSystem = codeSystem;
	}

	public MifValueSetNonComputableContent getNonComputableContent() {
		return nonComputableContent;
	}

	public void setNonComputableContent(
			MifValueSetNonComputableContent nonComputableContent) {
		this.nonComputableContent = nonComputableContent;
	}

	public List<MifValueSetPropertyBasedContent> getPropertyBasedContents() {
		return propertyBasedContents;
	}

	public void setPropertyBasedContents(
			List<MifValueSetPropertyBasedContent> propertyBasedContents) {
		this.propertyBasedContents = propertyBasedContents;
	}

	public List<MifValueSetCodeBasedContent> getCodeBasedContents() {
		return codeBasedContents;
	}

	public void setCodeBasedContents(
			List<MifValueSetCodeBasedContent> codeBasedContents) {
		this.codeBasedContents = codeBasedContents;
	}

	public List<MifValueSetCombinedContent> getCombinedContents() {
		return combinedContents;
	}

	public void setCombinedContents(
			List<MifValueSetCombinedContent> combinedContents) {
		this.combinedContents = combinedContents;
	}

	public List<MifValueSetReference> getValueSetReferences() {
		return valueSetReferences;
	}

	public void setValueSetReferences(List<MifValueSetReference> valueSetReferences) {
		this.valueSetReferences = valueSetReferences;
	}
	
}
