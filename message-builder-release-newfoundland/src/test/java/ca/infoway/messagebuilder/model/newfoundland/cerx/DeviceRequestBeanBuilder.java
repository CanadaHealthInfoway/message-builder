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

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.NoteBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.ClinicalDeviceBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.DeviceDispenseInstructionsBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.ReasonBeanBuilder;

public class DeviceRequestBeanBuilder extends BaseBeanBuilder<DeviceRequestBean> {
	
	public DeviceRequestBeanBuilder() {
		super(new DeviceRequestBean());
	}

	public DeviceRequestBeanBuilder populate() {
		this.bean.getConfidentialityCode().add(lookup(x_VeryBasicConfidentialityKind.class, "N", CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot()));
		this.bean.setDirectTarget(new ClinicalDeviceBeanBuilder().populate().create());
		this.bean.setId(new Identifier("1.2.3", "extension-1"));
		this.bean.setNote(new NoteBeanBuilder().populate().create());
		this.bean.setPatient(new IdentifiedPersonBeanBuilder().populate().create());		
		this.bean.setPredecessorId(new Identifier("predecessor-root", "ext"));
		this.bean.setSupplyRequest(new DeviceDispenseInstructionsBeanBuilder().populate().create());
		this.bean.setStatusCode(lookup(ActStatus.class, "normal", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		this.bean.getReasons().add(new ReasonBeanBuilder().populate().create());
		this.bean.setUsageInstructions("usage instructions");
		return this;
	}

}
