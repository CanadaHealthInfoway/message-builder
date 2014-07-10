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

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class HistoricalControlActEventBeanBuilder extends
		BaseBeanBuilder<HistoricalControlActEventBean> {

	public HistoricalControlActEventBeanBuilder() {
		super(new HistoricalControlActEventBean());
	}

	public HistoricalControlActEventBeanBuilder withTriggerEventCode(String triggerEventCode) {
		this.bean.setCode(CodeResolverRegistry.lookup(HL7TriggerEventCode.class, triggerEventCode, CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		return this;
	}
	
	public HistoricalControlActEventBeanBuilder populate() {
		this.bean.setEffectiveTime(IntervalFactory.createLow(DateUtil.getDate(2009, 1, 1, 0, 0, 0, 0, TimeZone.getTimeZone("America/Toronto"))));
		this.bean.setReasonCode(CodeResolverRegistry.lookup(ControlActReason.class, "EIE", CodeSystem.VOCABULARY_ACT_REASON.getRoot()));
		this.bean.setResponsibleParty(new AssignedPersonBeanBuilder().populate().create());
		this.bean.setAuthor(new AuthorBeanBuilder().populate().create());
		return this;
	}

}
