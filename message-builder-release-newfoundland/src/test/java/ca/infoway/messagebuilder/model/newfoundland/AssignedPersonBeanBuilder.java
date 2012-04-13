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
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;

public class AssignedPersonBeanBuilder extends BaseBeanBuilder<AssignedPersonBean> {

	public AssignedPersonBeanBuilder() {
		super(new AssignedPersonBean());
	}

	public AssignedPersonBeanBuilder populate() {
		this.bean.setCode(lookup(HealthcareProviderRoleType.class, "ACP", CodeSystem.VOCABULARY_ROLE_CODE.getRoot()));
		this.bean.setId(new Identifier("12.34.56", "1"));
		this.bean.setName(PersonName.createFirstNameLastName("John", "Doe"));
		this.bean.setLicenseNumber(new Identifier("77.33.22.11", "1"));
		return this;
	}

}
