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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionNotAllowedReason;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.SubstitutionPermissionBean;

public class SubstitutionPermissionBeanBuilder extends BaseBeanBuilder<SubstitutionPermissionBean> {
	
	public SubstitutionPermissionBeanBuilder() {
		super(new SubstitutionPermissionBean());
	}

	public SubstitutionPermissionBeanBuilder populate() {
		// SPD: fixed
		// this.bean.setCode(lookup(ActCode.class, "G", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		this.bean.setNegationInd(false);
		this.bean.setReasonCode(
				lookup(SubstanceAdminSubstitutionNotAllowedReason.class, "ALGALT", CodeSystem.VOCABULARY_ACT_REASON.getRoot()));
		return this;
	}

}
