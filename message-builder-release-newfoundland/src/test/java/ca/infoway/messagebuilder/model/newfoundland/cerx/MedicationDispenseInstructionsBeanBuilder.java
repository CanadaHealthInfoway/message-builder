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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.math.BigDecimal;

import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.MedicationDispenseInstructionsBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class MedicationDispenseInstructionsBeanBuilder extends
		BaseBeanBuilder<MedicationDispenseInstructionsBean> {
	
	public MedicationDispenseInstructionsBeanBuilder() {
		super(new MedicationDispenseInstructionsBean());
	}

	public MedicationDispenseInstructionsBeanBuilder populate() {
		this.bean.setActStatus(CodeResolverRegistry.lookup(ActStatus.class, "active"));
		this.bean.setQuantity(new PhysicalQuantity(BigDecimal.ONE, CodeResolverRegistry.lookup(UnitsOfMeasureCaseSensitive.class, "mg")));
		this.bean.setServiceDeliveryLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		return this;
	}
	

}
