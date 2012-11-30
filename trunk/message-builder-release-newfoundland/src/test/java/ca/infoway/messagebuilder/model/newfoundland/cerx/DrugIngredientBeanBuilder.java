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
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActiveIngredientDrugEntityType;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;

public class DrugIngredientBeanBuilder extends BaseBeanBuilder<DrugIngredientBean> {

	public DrugIngredientBeanBuilder() {
		super(new DrugIngredientBean());
	}

	public DrugIngredientBeanBuilder populate() {
		this.bean.setName("ibuprofen");
		this.bean.setQuantity(new PhysicalQuantity(new BigDecimal(250), lookup(x_DrugUnitsOfMeasure.class, "g", CodeSystem.VOCABULARY_UNIFORM_UNIT_OF_MEASURE.getRoot())));
		this.bean.setNegationInd(false);
		this.bean.setCode(lookup(ActiveIngredientDrugEntityType.class, "00888982", CodeSystem.DRUG_IDENTIFICATION_NUMBER.getRoot()));
		return this;
	}

	public DrugIngredientBeanBuilder withDin(String din) {
		this.bean.setCode(lookup(ActiveIngredientDrugEntityType.class, din, CodeSystem.DRUG_IDENTIFICATION_NUMBER.getRoot()));
		this.bean.setName("drug with Din=" + din);
		return this;
	}

}
