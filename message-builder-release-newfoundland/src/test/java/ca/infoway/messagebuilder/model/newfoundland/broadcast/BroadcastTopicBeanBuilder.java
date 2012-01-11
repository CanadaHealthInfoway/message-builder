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

package ca.infoway.messagebuilder.model.newfoundland.broadcast;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.SubscriptionStatus;
import ca.infoway.messagebuilder.domainvalue.payload.TopicPriority;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.broadcast.BroadcastTopicBean;


public class BroadcastTopicBeanBuilder extends BaseBeanBuilder<BroadcastTopicBean> {
	
	public BroadcastTopicBeanBuilder() {
		super(new BroadcastTopicBean());
	}

	public BroadcastTopicBeanBuilder populateAsNlMandatory() {
		this.bean.setId(new Identifier("2.16.124.113620.1.1.17", "77777"));
		this.bean.setTitle("TL7 NL MANDATORY Topic");
		this.bean.setTopicPriority(TopicPriority.NL_MANDATORY);
		return this;
	}

	public BroadcastTopicBeanBuilder populateAsOptional() {
		this.bean.setId(new Identifier("2.16.124.113620.1.1.17", "99999"));
		this.bean.setTitle("TL7 NL OPTIONAL Topic");
		this.bean.setTopicPriority(TopicPriority.OPTIONAL);
		return this;
	}
	
	public BroadcastTopicBeanBuilder withSubscriptionStatusSubscribed(){
		this.bean.setSubscriptionStatus(lookup(SubscriptionStatus.class, "1", CodeSystem.SUBSCRIPTION_STATUS.getRoot()));
		return this;
	}

	public BroadcastTopicBeanBuilder withSubscriptionStatusUnSubscribed(){
		this.bean.setSubscriptionStatus(lookup(SubscriptionStatus.class, "2", CodeSystem.SUBSCRIPTION_STATUS.getRoot()));
		return this;
	}
	
	public BroadcastTopicBeanBuilder withId(String extension){
		this.bean.getId().setExtension(extension);
		this.bean.getId().setRoot("2.16.124.113620.1.1.17");
		return this;
	}

}
