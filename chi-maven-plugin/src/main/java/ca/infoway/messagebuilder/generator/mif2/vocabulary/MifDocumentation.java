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

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(strict = false)
@Namespace(prefix = "mif", reference = "urn:hl7-org:v3/mif2")
public class MifDocumentation {

	@Element(required = false)
	private MifBasicAnnotation definition;
	
	@Element(required=false)
	private MifBasicAnnotation description;
	
	@ElementList(entry = "usageNotes", required = false, inline = true)
	private List<MifBasicAnnotation> usageNotes = new ArrayList<MifBasicAnnotation>();

	@Element(required = false)
	private MifBasicAnnotation rationale;
	
	@ElementList(entry = "otherAnnotation", required = false, inline = true)
	private List<MifOtherAnnotation> otherAnnotations = new ArrayList<MifOtherAnnotation>();

	public MifDocumentation() {
	}

	public MifBasicAnnotation getDefinition() {
		return definition;
	}

	public MifBasicAnnotation getDescription() {
		return description;
	}

	public List<MifBasicAnnotation> getUsageNotes() {
		return usageNotes;
	}

	public MifBasicAnnotation getRationale() {
		return rationale;
	}

	public List<MifOtherAnnotation> getOtherAnnotations() {
		return otherAnnotations;
	}
	
	public String getOtherAnnotation(String type) {
		for (MifOtherAnnotation otherAnnotation : this.otherAnnotations) {
			if (otherAnnotation.getType().equals(type)) {
				return otherAnnotation.getData();
			}
		}
		return null;
	}

}
