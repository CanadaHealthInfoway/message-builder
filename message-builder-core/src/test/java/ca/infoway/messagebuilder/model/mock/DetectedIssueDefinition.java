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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.model.mock;

import java.io.Serializable;
import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.domainvalue.ObservationDosageDefinitionPreconditionType;

@Hl7PartTypeMapping({"PORX_MT980030CA.DetectedIssueDefinition"})
public class DetectedIssueDefinition implements Serializable {

	private static final long serialVersionUID = 1829563352068802464L;
	
	private Identifier issueMonographId;
	private String issueDescription;
	private AuthorBean author;
	private Interval<Date> doseDuration;
	private UncertainRange<PhysicalQuantity> dosageRange;
	private ObservationDosageDefinitionPreconditionType dosagePreconditionType;
	private UncertainRange<PhysicalQuantity> dosagePreconditionValue;
	
	@Hl7XmlMapping({"id"})
	public Identifier getIssueMonographId() {
		return issueMonographId;
	}
	public void setIssueMonographId(Identifier issueMonographId) {
		this.issueMonographId = issueMonographId;
	}

	@Hl7XmlMapping({"text"})
	public String getIssueDescription() {
		return issueDescription;
	}
	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	@Hl7XmlMapping({"author"})
	public AuthorBean getAuthor() {
		return author;
	}
	public void setAuthor(AuthorBean author) {
		this.author = author;
	}

	@Hl7XmlMapping({"component/substanceAdministrationEventCriterion/effectiveTime"})
	public Interval<Date> getDoseDuration() {
		return doseDuration;
	}
	public void setDoseDuration(Interval<Date> doseDuration) {
		this.doseDuration = doseDuration;
	}

	@Hl7XmlMapping({"component/substanceAdministrationEventCriterion/doseQuantity"})
	public UncertainRange<PhysicalQuantity> getDosageRange() {
		return dosageRange;
	}
	public void setDosageRange(UncertainRange<PhysicalQuantity> dosageRange) {
		this.dosageRange = dosageRange;
	}

	@Hl7XmlMapping({"component/substanceAdministrationEventCriterion/component/observationEventCriterion/code"})
	public ObservationDosageDefinitionPreconditionType getDosagePreconditionType() {
		return dosagePreconditionType;
	}
	public void setDosagePreconditionType(
			ObservationDosageDefinitionPreconditionType dosagePreconditionType) {
		this.dosagePreconditionType = dosagePreconditionType;
	}

	@Hl7XmlMapping({"component/substanceAdministrationEventCriterion/component/observationEventCriterion/value"})
	public UncertainRange<PhysicalQuantity> getDosagePreconditionValue() {
		return dosagePreconditionValue;
	}
	public void setDosagePreconditionValue(
			UncertainRange<PhysicalQuantity> dosagePreconditionValue) {
		this.dosagePreconditionValue = dosagePreconditionValue;
	}

}
