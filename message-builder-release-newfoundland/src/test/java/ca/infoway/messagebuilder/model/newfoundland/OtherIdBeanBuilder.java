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
import ca.infoway.messagebuilder.domainvalue.OtherIdentifierRoleType;
import ca.infoway.messagebuilder.model.newfoundland.OtherIdentifiersBean;

public class OtherIdBeanBuilder extends BaseBeanBuilder<OtherIdentifiersBean> {
	
	public OtherIdBeanBuilder() {
		super(new OtherIdentifiersBean());
	}

	public OtherIdBeanBuilder populate() {
		bean.setCode(lookup(OtherIdentifierRoleType.class, "PASS", CodeSystem.VOCABULARY_OTHER_IDENTIFIER_ROLE_TYPE.getRoot()));
		bean.setOrganizationName("Organization Inc.");
		bean.setOrganizationId(new Identifier("11.22.33", "987"));
		bean.getIds().add(new Identifier("1.2.3", "123"));
		return this;
	}

}
