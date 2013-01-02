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

package ca.infoway.messagebuilder.model.newfoundland;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;

import java.util.TimeZone;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalUtil;
import ca.infoway.messagebuilder.domainvalue.RoleStatus;
import ca.infoway.messagebuilder.domainvalue.URLScheme;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.domainvalue.x_SimplePersonalRelationship;
import ca.infoway.messagebuilder.domainvalue.basic.X_BasicPostalAddressUse;
import ca.infoway.messagebuilder.j5goodies.DateUtil;

public class ResponsiblePartyBeanBuilder extends BaseBeanBuilder<ResponsiblePartyBean> {

	public ResponsiblePartyBeanBuilder() {
		super(new ResponsiblePartyBean());
	}

	public ResponsiblePartyBeanBuilder populate() {
		this.bean.setCode(lookup(x_SimplePersonalRelationship.class, "SIB", CodeSystem.VOCABULARY_ROLE_CODE.getRoot()));
		bean.setId(new Identifier("3.14", "159"));
		PostalAddress address = new PostalAddress();
		address.addUse(X_BasicPostalAddressUse.HOME);
		address.addPostalAddressPart(new PostalAddressPart("Bloor"));
		bean.setAddress(address);
		bean.getTelecom().add(new TelecommunicationAddress(
				lookup(URLScheme.class, "tel"), "4167620032"));
		bean.setIndeterminatePerson(new IndeterminatePersonBeanBuilder().populate().create());
		bean.setStatusCode(lookup(RoleStatus.class, "active", CodeSystem.VOCABULARY_ROLE_STATUS.getRoot()));
		bean.setConfidentialityCode(
				lookup(x_NormalRestrictedTabooConfidentialityKind.class, "N", CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot()));
		bean.setEffectiveTime(IntervalUtil.createInterval(
				DateUtil.getDate(2000, 2, 3, 0, 0, 0, 0, TimeZone.getTimeZone("America/Toronto")),
				DateUtil.getDate(2010, 3, 4, 0, 0, 0, 0, TimeZone.getTimeZone("America/Toronto"))
				));
		return this;
	}

}
