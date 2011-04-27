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
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ControlActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.PatientIdentifierBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordTargetBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBeanBuilder;

public class ControlActEventBeanBuilder extends BaseBeanBuilder<ControlActEventBean> {

	public ControlActEventBeanBuilder() {
		super(new ControlActEventBean());
	}

	public ControlActEventBeanBuilder populate() {
		this.bean.setAuthor(new AuthorBeanBuilder().populate().create());
		this.bean.setCode(lookup(HL7TriggerEventCode.class, "PORX_TE020170UV", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		this.bean.setEffectiveTime(DateUtil.getDate(2005, 1, 3));
		this.bean.setEventId(new Identifier("11.22.33", "332211"));
		this.bean.setLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		this.bean.setReasonCode(lookup(ControlActReason.class, "HOSPADM", CodeSystem.VOCABULARY_ACT_REASON.getRoot()));
		this.bean.setResponsibleParty(new AssignedPersonBeanBuilder().populate().create());
		this.bean.setStatusCode(lookup(ActStatus.class, "active", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		
		PatientIdentifierBean patient = new PatientIdentifierBean();
		patient.setId(new Identifier("2.234.2.23", "293833"));
		this.bean.setRecordTarget(new RecordTargetBeanBuilder().withPatientIdentifierBean(patient).create());
		
		return this;
	}

}
