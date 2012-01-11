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
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActSubstanceAdminSubstitutionCode;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionReason;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.SubstitutionMadeBean;

public class SubstitutionMadeBeanBuilder extends BaseBeanBuilder<SubstitutionMadeBean> {

	public static final Identifier DEFAULT_RESPONSIBLE_PARTY = new Identifier("1.2.3.4", "11223344");

	public SubstitutionMadeBeanBuilder() {
		super(new SubstitutionMadeBean());
	}

	public SubstitutionMadeBeanBuilder populate() {
		this.bean.setCode(lookup(ActSubstanceAdminSubstitutionCode.class, "F", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		this.bean.setReasonCode(lookup(SubstanceAdminSubstitutionReason.class, "CT", CodeSystem.VOCABULARY_ACT_REASON.getRoot()));
		this.bean.setResponsibleParty(DEFAULT_RESPONSIBLE_PARTY);
		return this;
	}

	public SubstitutionMadeBeanBuilder withCodeNone() {
		this.bean.setCode(lookup(ActSubstanceAdminSubstitutionCode.class, "N", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		return this;
	}
}
