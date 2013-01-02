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

package ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.ClinicalDeviceEntity;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class ClinicalDeviceBeanBuilder extends BaseBeanBuilder<ClinicalDeviceBean> {

	public ClinicalDeviceBeanBuilder() {
		super(new ClinicalDeviceBean());
	}

	public ClinicalDeviceBeanBuilder populate() {
		this.bean.setCode(CodeResolverRegistry.lookup(ClinicalDeviceEntity.class, "97799979", CodeSystem.OPINIONS.getRoot()));
		this.bean.setName("Onetouch Surestep Testing Strips (100)");
		this.bean.setDesc("A concoction of this and that");
		this.bean.setQuantity(1);
		return this;
	}

}
