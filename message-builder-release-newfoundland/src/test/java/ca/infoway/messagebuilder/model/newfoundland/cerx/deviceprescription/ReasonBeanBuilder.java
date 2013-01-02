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

package ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ObservationDiagnosisBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ReasonBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class ReasonBeanBuilder extends BaseBeanBuilder<ReasonBean> {

	public ReasonBeanBuilder() {
		super(new ReasonBean());
	}

	public ReasonBeanBuilder populate() {
		ObservationDiagnosisBean indication = new ObservationDiagnosisBean();
		indication.setCode(CodeResolverRegistry.lookup(ActCode.class, "402261004", CodeSystem.SNOMED.getRoot()));
		indication.setText("indication text");
		this.bean.setIndication(indication);
		this.bean.setPriorityNumber(1);
		return this;
	}

}
