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

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;

import java.util.Date;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType;
import ca.infoway.messagebuilder.domainvalue.x_SubstitutionConditionNoneOrUnconditional;
import ca.infoway.messagebuilder.domainvalue.basic.X_BasicPostalAddressUse;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ResponsiblePartyBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBeanBuilder;

public class DispenseInstructionsBeanBuilder extends
		BaseBeanBuilder<DispenseInstructionsBean> {
	
	public DispenseInstructionsBeanBuilder() {
		super(new DispenseInstructionsBean());
	}

	public BaseBeanBuilder<DispenseInstructionsBean> populate() {
		PostalAddress address = new PostalAddress();
		address.addUse(X_BasicPostalAddressUse.HOME);
		address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STREET_NAME, "Bloor"));
		this.bean.setDestination(address);
		this.bean.setEffectiveTime(IntervalFactory.createLow(new Date(0)));
		this.bean.getResponsibleParties().add(new ResponsiblePartyBeanBuilder().populate().create());
		this.bean.setServiceDeliveryLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		this.bean.setSubstitutionConditionCode(lookup(x_SubstitutionConditionNoneOrUnconditional.class, "NOSUB", CodeSystem.VOCABULARY_SUBSTITUTION_CONDITION.getRoot()));
		this.bean.getSupplyRequestItems().add(new SupplyRequestBeanBuilder().populate().create());
		this.bean.setToBePickedUpOn(IntervalFactory.createLow(new Date(0)));
		return this;
	}
	

}
