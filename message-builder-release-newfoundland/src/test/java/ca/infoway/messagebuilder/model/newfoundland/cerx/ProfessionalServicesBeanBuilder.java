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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.util.TimeZone;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalFactory;
import ca.infoway.messagebuilder.domainvalue.ActProfessionalServiceCode;
import ca.infoway.messagebuilder.domainvalue.controlact.ActStatus;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.NoteBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.professionalservice.ProfessionalServiceRecord;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class ProfessionalServicesBeanBuilder extends BaseBeanBuilder<ProfessionalServiceRecord> {
	
	public ProfessionalServicesBeanBuilder() {
		super(new ProfessionalServiceRecord());
	}

	public ProfessionalServicesBeanBuilder populate() {
		this.bean.setId(new Identifier("1.2.3.4.5", "1"));
		this.bean.setStatus(ActStatus.ACTIVE);
		this.bean.setCode(CodeResolverRegistry.lookup(ActProfessionalServiceCode.class, "SMC", "2.16.840.1.113883.6.95"));
		this.bean.setEffectiveTime(IntervalFactory.createSimple(DateUtil.getDate(2009, 0, 1, 0, 0, 0, 0, TimeZone.getTimeZone("America/Toronto"))));
		this.bean.setPatient(new IdentifiedPersonBeanBuilder().populateMabelHauptman().create());
		
		this.bean.setPerformer(new PerformerBean());
		this.bean.getPerformer().getAssignedPerson().setId(new Identifier("1.1.2.2.3.3.1", "2"));
		this.bean.getPerformer().getAssignedPerson().setLicenseNumber(new Identifier("77.33.22.11", "1"));
		this.bean.getPerformer().getAssignedPerson().setName(PersonName.createFirstNameLastName("John", "Doe"));
		this.bean.getNotes().add(new NoteBeanBuilder().populate().create());
		this.bean.setLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		this.bean.setAuthor(new AuthorBeanBuilder().populate().create());
		return this;
	}
}
