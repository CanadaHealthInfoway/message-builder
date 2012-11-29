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
import java.util.Date;

import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalFactory;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;

public class SupplyRequestBeanBuilder extends BaseBeanBuilder<SupplyRequestBean> {
	
	public SupplyRequestBeanBuilder() {
		super(new SupplyRequestBean());
	}

	public SupplyRequestBeanBuilder populate() {
		this.bean.setExpectedUseTime(IntervalFactory.createLowHigh(new Date(600000000), new Date(700000000)));
		this.bean.setQuantity(new PhysicalQuantity(new BigDecimal(12), lookup(x_DrugUnitsOfMeasure.class, "g")));
		this.bean.setProduct(new MedicineBeanBuilder().populate().create());
		this.bean.setSubsequentSupplyRequest(new FillInstructionsBeanBuilder().populate().create());
		this.bean.setIntitialSupplyRequest(new FillInstructionsBeanBuilder().populate().create());
		return this;
	}

}
