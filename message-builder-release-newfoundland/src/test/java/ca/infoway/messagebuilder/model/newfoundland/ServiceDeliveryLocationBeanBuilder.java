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

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPartType;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressUse;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.domainvalue.URLScheme;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class ServiceDeliveryLocationBeanBuilder extends BaseBeanBuilder<ServiceDeliveryLocationBean> {

	public ServiceDeliveryLocationBeanBuilder() {
		super(new ServiceDeliveryLocationBean());
	}

	public ServiceDeliveryLocationBeanBuilder populate() {
		bean.setIdentifier(new Identifier("2.2.2", "3"));
		bean.setName("Intelliware's Pharmacy");
		bean.setCode(CodeResolverRegistry.lookup(ServiceDeliveryLocationRoleType.class, "ALL", CodeSystem.VOCABULARY_ROLE_CODE.getRoot()));
		
		PostalAddress address = new PostalAddress();
		address.addUse(PostalAddressUse.HOME);
		address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STREET_NAME, "Bloor"));
		bean.setAddr(address);
		bean.getTelecom().add(new TelecommunicationAddress(CodeResolverRegistry.lookup(URLScheme.class, "http"), "123.456.789.10"));

		return this;
	}

}
