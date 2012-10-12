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

import java.util.Date;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.ParticipationSignature;

public class AuthorBeanBuilder extends BaseBeanBuilder<AuthorBean> {
	
	public AuthorBeanBuilder() {
		super(new AuthorBean());
	}

	public AuthorBeanBuilder populate() {
		this.bean.setId(new Identifier("1.1.1", "1"));
		this.bean.setLicenseNumber(new Identifier("2.2.2", "1"));
		this.bean.setTime(new Date(0));
		this.bean.setName(createPersonName("John", "Doe"));
		this.bean.setSignatureCode(lookup(ParticipationSignature.class, "S", CodeSystem.VOCABULARY_PARTICIPATION_SIGNATURE.getRoot()));
		return this;
	}
	
	public AuthorBeanBuilder populateIncludingHealthcareProviderRoleType() {
		this.populate();
		this.bean.setCode(lookup(HealthcareProviderRoleType.class, "AUD", CodeSystem.VOCABULARY_ROLE_CODE.getRoot()));
		return this;
	}
	
	private PersonName createPersonName(String firstName, String lastName) {
		return PersonName.createFirstNameLastName(firstName, lastName);
	}
	
}
