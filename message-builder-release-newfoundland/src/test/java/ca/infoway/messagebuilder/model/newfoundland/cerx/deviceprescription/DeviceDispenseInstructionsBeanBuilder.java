/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.x_SubstitutionConditionNoneOrUnconditional;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DeviceDispenseInstructionsBean;

public class DeviceDispenseInstructionsBeanBuilder extends BaseBeanBuilder<DeviceDispenseInstructionsBean> {

	public DeviceDispenseInstructionsBeanBuilder() {
		super(new DeviceDispenseInstructionsBean());
	}

	public DeviceDispenseInstructionsBeanBuilder populate() {
		this.bean.setQuantity(new Integer(1)); 
		this.bean.setDispenseFacilityNotAssignableIndicator(
				lookup(x_SubstitutionConditionNoneOrUnconditional.class, "NOSUB", CodeSystem.VOCABULARY_SUBSTITUTION_CONDITION.getRoot()));
		this.bean.setServiceDeliveryLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		return this;
	}

}
