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

import java.math.BigDecimal;
import java.util.Date;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.x_ActObservationHeightOrWeight;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;

public class QuantityObservationEventBeanBuilder extends BaseBeanBuilder<QuantityObservationEventBean> {

	public QuantityObservationEventBeanBuilder() {
		super(new QuantityObservationEventBean());
	}
	
	public QuantityObservationEventBeanBuilder populate() {
		this.bean.setPatientMeasurementType(lookup(x_ActObservationHeightOrWeight.class, "3137-7", CodeSystem.LOINC.getRoot()));
		this.bean.setPatientMeasurementTime(new Date(20));
		this.bean.setPatientMeasuredValue(new PhysicalQuantity(new BigDecimal(79.0), lookup(UnitsOfMeasureCaseSensitive.class, "kg")));
		return this;
	}

}
