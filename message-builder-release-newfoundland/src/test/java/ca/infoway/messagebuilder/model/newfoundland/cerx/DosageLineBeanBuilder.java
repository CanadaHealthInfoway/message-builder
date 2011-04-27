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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;

import java.math.BigDecimal;
import java.util.Date;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.DefaultTimeUnit;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodDefEvnRqo;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_TimeUnitsOfMeasure;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DosageLineBean;

public class DosageLineBeanBuilder extends BaseBeanBuilder<DosageLineBean> {

	public DosageLineBeanBuilder() {
		super(new DosageLineBean());
	}

	public DosageLineBeanBuilder populate() {
		this.bean.setAdHocDosageInstruction("ad hoc dosage instruction");
		this.bean.setDosageCondition("dosage condition");
		
		this.bean.setDoseQuantity(UncertainRange.createLow(
				new PhysicalQuantity(
						new BigDecimal(1), 
						lookup(x_DrugUnitsOfMeasure.class, "g", CodeSystem.VOCABULARY_UNIFORM_UNIT_OF_MEASURE.getRoot()))));
		this.bean.setEffectiveTime(
				new GeneralTimingSpecification(
						IntervalFactory.createLowWidth(new Date(0), new DateDiff(new PhysicalQuantity(new BigDecimal(3), DefaultTimeUnit.WEEK))),
						PeriodicIntervalTime.createFrequency(3, new PhysicalQuantity(new BigDecimal(1), DefaultTimeUnit.DAY))));
		this.bean.setMoodCode(lookup(x_ActMoodDefEvnRqo.class, "EVN", CodeSystem.VOCABULARY_ACT_MOOD.getRoot()));
		this.bean.setRateQuantity(UncertainRange.createLow(
				new PhysicalQuantity(
						new BigDecimal(1), 
						lookup(x_TimeUnitsOfMeasure.class, "s", CodeSystem.VOCABULARY_UNIFORM_UNIT_OF_MEASURE.getRoot()))));
		this.bean.setSupplementalInstruction(new SupplementalInstructionBeanBuilder().populate().create());
		return this;
	}
	
}
