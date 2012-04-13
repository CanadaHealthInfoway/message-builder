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

package ca.infoway.messagebuilder.model.newfoundland.cerx.consent;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.ActInformationAccessTypeCode;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.InformationAccessTypeBean;

public class InformationAccessBeanBuilder extends BaseBeanBuilder<InformationAccessBean> {
	
	public InformationAccessBeanBuilder() {
		super(new InformationAccessBean());
	}

	public InformationAccessBeanBuilder populate() {
		InformationAccessTypeBean informationAccessType = new InformationAccessTypeBean();
		informationAccessType.setCode(lookup(ActInformationAccessTypeCode.class, "ACADR", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		this.bean.getInformationAccessTypes().add(informationAccessType);
		this.bean.setRecipient(new AssignedPersonBeanBuilder().populate().create());
		return this;
	}

}
