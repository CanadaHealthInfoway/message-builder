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

package ca.infoway.messagebuilder.model.newfoundland.pr;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({"PRPM_MT306011CA.HealthCareProvider"})
public class HealthcareProvider extends MessagePartBean implements RoleChoice, Serializable {

	private static final long serialVersionUID = 1701242657724075950L;
	
	private final SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
	private final LIST<PN, PersonName> name = new LISTImpl<PN, PersonName>(PNImpl.class);
	private final CD code = new CDImpl();

	@Hl7XmlMapping("name")
	public List<PersonName> getName() {
		return this.name.rawList();
	}

	@Hl7XmlMapping("id")
	public Set<Identifier> getId() {
		return this.id.rawSet();
	}

	@Hl7XmlMapping("code")
	public HealthcareProviderRoleType getCode() {
		return (HealthcareProviderRoleType) this.code.getValue();
	}

	public void setCode(HealthcareProviderRoleType code) {
		this.code.setValue(code);
	}
}
