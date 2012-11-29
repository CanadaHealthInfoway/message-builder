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

package ca.infoway.messagebuilder.model.newfoundland.cerx.othermedication;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.controlact.ActStatus;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class OtherMedicationBeanBuilder extends BaseBeanBuilder<OtherMedicationBean> {

	public OtherMedicationBeanBuilder() {
		super(new OtherMedicationBean());
	}

	public OtherMedicationBeanBuilder populate() {
		this.bean.setCode(CodeResolverRegistry.lookup(ActCode.class, "DRUG", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		this.bean.setStatusCode(ActStatus.ACTIVE);
		this.bean.setId(new Identifier(CodeSystem.INTELLIWARE_APPLICATIONS_TEAL.getRoot() + ".1111", "1234"));
		this.bean.getMedicine().setCode(CodeResolverRegistry.lookup(ClinicalDrug.class, "01916475", CodeSystem.DRUG_IDENTIFICATION_NUMBER.getRoot()));
		this.bean.getMedicine().setName("Percocet");
		AssignedPersonBean author = new AssignedPersonBean();
		author.setId(new Identifier("13.23", "129387"));
		author.setName(PersonName.createFirstNameLastName("Frederick", "Strange"));
		this.bean.setAuthor(author);
		
		this.bean.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
		this.bean.setLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		return this;
	}

}
