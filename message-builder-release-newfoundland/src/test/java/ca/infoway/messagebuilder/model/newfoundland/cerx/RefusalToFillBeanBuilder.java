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

import java.util.Date;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.ActSupplyFulfillmentRefusalReason;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class RefusalToFillBeanBuilder extends BaseBeanBuilder<RefusalToFillBean> {

	public RefusalToFillBeanBuilder() {
		super(new RefusalToFillBean());
	}
	
	public RefusalToFillBeanBuilder populate() {
		this.bean.setAuthor(new AuthorBeanBuilder().populate().create());
		this.bean.getDetectedIssues().add(new DetectedIssueBeanBuilder().populate().create());
		this.bean.setEffectiveTime(new Date(0));
		this.bean.setReasonCode(CodeResolverRegistry.lookup(ActSupplyFulfillmentRefusalReason.class, "FRR01", CodeSystem.VOCABULARY_ACT_REASON.getRoot()));
		this.bean.setLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		return this;
	}

}
