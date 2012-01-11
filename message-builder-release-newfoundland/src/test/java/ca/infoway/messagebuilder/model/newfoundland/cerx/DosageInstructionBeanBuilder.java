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
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalUtil;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActSite;
import ca.infoway.messagebuilder.domainvalue.AdministrableDrugForm;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodDefEvnRqo;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DosageInstructionBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.Medication3Bean;

public class DosageInstructionBeanBuilder extends BaseBeanBuilder<DosageInstructionBean> {

	public DosageInstructionBeanBuilder() {
		super(new DosageInstructionBean());
	}

	public DosageInstructionBeanBuilder populate() {
		this.bean.setAdministrationUnitCode(lookup(AdministrableDrugForm.class, "DROP", CodeSystem.VOCABULARY_ADMINISTRABLE_DRUG_FORM.getRoot()));
		this.bean.setCode(lookup(ActCode.class, "INFA", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		this.bean.setEffectiveTime(IntervalUtil.createInterval(DateUtil.getDate(2007, 8, 20), DateUtil.getDate(2008, 3, 12)));
		this.bean.setMoodCode(lookup(x_ActMoodDefEvnRqo.class, "DEF", CodeSystem.VOCABULARY_ACT_MOOD.getRoot()));
		this.bean.setRouteCode(lookup(RouteOfAdministration.class, "CHEW", CodeSystem.VOCABULARY_ROUTE_OF_ADMINISTRATION.getRoot()));
		this.bean.setText("some dosage instructions");
		this.bean.getApproachSiteCode().add(lookup(ActSite.class, "BE", CodeSystem.VOCABULARY_ACT_SITE.getRoot()));
//		this.bean.getMaxDoseQuantity().add(new Ratio<PhysicalQuantity, PhysicalQuantity>());
		this.bean.setSupplementalInstructionBean(new SupplementalInstructionBeanBuilder().populate().create());
		this.bean.getDosageLineWrappers().add(new DosageLineWrapperBeanBuilder().populate().create());
		Medication3Bean medication3 = new Medication3Bean();
		medication3.setMedicineBean(new MedicineBeanBuilder().populate().create());
		this.bean.setMedication(medication3);
		return this;
	}
	
	public DosageInstructionBeanBuilder withText(String dosageText){
		this.bean.setText(dosageText);
		return this;
	}

}
