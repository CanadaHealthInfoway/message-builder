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

import java.math.BigDecimal;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActPharmacySupplyType;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ResponsiblePartyBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.SupplyEventBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.ClinicalDeviceBeanBuilder;

public class SupplyEventBeanBuilder extends BaseBeanBuilder<SupplyEventBean> {

	public SupplyEventBeanBuilder() {
		super(new SupplyEventBean());
	}

	public SupplyEventBeanBuilder populateMedication() {
		populate();
		this.bean.setQuantity(new PhysicalQuantity(BigDecimal.ONE, lookup(UnitsOfMeasureCaseSensitive.class, "mg")));
		this.bean.setMedication(new MedicineBeanBuilder().populate().create());
		
		return this;
	}

	public SupplyEventBeanBuilder populateDevice() {
		populate();
		this.bean.setQuantity(new PhysicalQuantity(BigDecimal.ONE, lookup(UnitsOfMeasureCaseSensitive.class, "Unit")));
		this.bean.setClinicalDevice(new ClinicalDeviceBeanBuilder().populate().create());
		
		return this;
	}

	private void populate() {
		this.bean.setDispenseId(new Identifier("dispenseIdRoot", "1"));
		this.bean.setCode(lookup(ActPharmacySupplyType.class, "DF", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		this.bean.setStatusCode(lookup(ActStatus.class, "active", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		this.bean.setEffectiveTime(IntervalFactory.createLowHigh(DateUtil.getDate(2009, 1, 1), DateUtil.getDate(2009, 12, 12)));
		this.bean.setExpectedUseTime(IntervalFactory.createHigh(DateUtil.getDate(2009, 12, 20)));
		this.bean.setDestination(new ServiceDeliveryLocationBeanBuilder().populate().create());
		this.bean.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
		this.bean.setResponsibleParty(new ResponsiblePartyBeanBuilder().populate().create());
		this.bean.setLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
	}
	

}
