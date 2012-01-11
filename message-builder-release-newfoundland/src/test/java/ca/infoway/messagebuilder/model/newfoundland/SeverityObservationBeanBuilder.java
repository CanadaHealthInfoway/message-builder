/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.model.newfoundland;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.SeverityObservation;
import ca.infoway.messagebuilder.model.newfoundland.SeverityObservationBean;

public class SeverityObservationBeanBuilder extends BaseBeanBuilder<SeverityObservationBean> {

	public SeverityObservationBeanBuilder() {
		super(new SeverityObservationBean());
	}

	// TM - this bean is pretty much useless. We only ever need the underlying SeverityObservation; the rest are fixed values.

	public SeverityObservationBeanBuilder populate() {
		bean.setCode(lookup(ActCode.class, "N", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		bean.setSeverityObservation(lookup(SeverityObservation.class, "H", CodeSystem.VOCABULARY_SEVERITY_OBSERVATION.getRoot()));
		bean.setStatusCode(lookup(ActStatus.class, "active", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		return this;
	}
	
}
