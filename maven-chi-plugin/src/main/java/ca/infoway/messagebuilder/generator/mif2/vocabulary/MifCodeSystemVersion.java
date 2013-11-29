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

import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(strict=false)
@Namespace(prefix="mif",reference="urn:hl7-org:v3/mif2")
public class MifCodeSystemVersion {

	@Attribute(required=false)
	private Date releaseDate;
	@Attribute(required=false)
	private String publisherVersionId;
	@Attribute(required=false)
	private boolean hl7MaintainedIndicator;
	@Attribute(required=false)
	private boolean completeCodesIndicator;
	@ElementList(required=false,inline=true,entry="concept")
	private List<MifCodeSystemConcept> concepts;
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getPublisherVersionId() {
		return publisherVersionId;
	}
	public void setPublisherVersionId(String publisherVersionId) {
		this.publisherVersionId = publisherVersionId;
	}
	public boolean isHl7MaintainedIndicator() {
		return hl7MaintainedIndicator;
	}
	public void setHl7MaintainedIndicator(boolean hl7MaintainedIndicator) {
		this.hl7MaintainedIndicator = hl7MaintainedIndicator;
	}
	public boolean isCompleteCodesIndicator() {
		return completeCodesIndicator;
	}
	public void setCompleteCodesIndicator(boolean completeCodesIndicator) {
		this.completeCodesIndicator = completeCodesIndicator;
	}
	public List<MifCodeSystemConcept> getConcepts() {
		return concepts;
	}
	public void setConcepts(List<MifCodeSystemConcept> concepts) {
		this.concepts = concepts;
	}
	
}
