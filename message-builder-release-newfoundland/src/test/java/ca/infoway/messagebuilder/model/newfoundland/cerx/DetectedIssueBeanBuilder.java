/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueCode;
import ca.infoway.messagebuilder.domainvalue.ActIssuePriority;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.DetectedIssueBean;
import ca.infoway.messagebuilder.model.newfoundland.SeverityObservationBeanBuilder;

public class DetectedIssueBeanBuilder extends BaseBeanBuilder<DetectedIssueBean> {

	public DetectedIssueBeanBuilder() {
		super(new DetectedIssueBean());
	}

	public DetectedIssueBeanBuilder populate() {
		this.bean.setCode(lookup(ActDetectedIssueCode.class, "VALIDAT", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		this.bean.setPriorityCode(lookup(ActIssuePriority.class, "W", CodeSystem.VOCABULARY_ACKNOWLEDGEMENT_DETAIL_TYPE.getRoot()));
		this.bean.setText("some detected issue text");
		this.bean.setSeverityObservation(new SeverityObservationBeanBuilder().populate().create());
		
		this.bean.getCausalActs().add(new SupplyEventBeanBuilder().populateMedication().create());
		this.bean.getCausalActs().add(new SubstanceAdministrationBeanBuilder().populatePrescription().create()); // prescription
		this.bean.getCausalActs().add(new SubstanceAdministrationBeanBuilder().populate().create()); // otherSupply
//		this.bean.getIssueCausedBy();
//		this.bean.getIssueDescription();
		this.bean.getIssueManagements().add(new DetectedIssueManagementBeanBuilder().populate().create());
		this.bean.setStatusCode(lookup(ActStatus.class, "active", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		return this;
	}

}
