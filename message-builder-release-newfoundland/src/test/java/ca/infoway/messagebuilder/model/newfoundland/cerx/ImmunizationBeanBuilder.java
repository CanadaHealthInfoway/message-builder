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
import java.util.TimeZone;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalUtil;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActNoImmunizationReason;
import ca.infoway.messagebuilder.domainvalue.HumanSubstanceAdministrationSite;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_InformationSource;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.NoteBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.immunization.ImmunizationBean;

public class ImmunizationBeanBuilder extends BaseBeanBuilder<ImmunizationBean> {

	public ImmunizationBeanBuilder() {
		super(new ImmunizationBean());
	}

	public ImmunizationBeanBuilder populate() {
		this.bean.setId(new Identifier("2.16.124.113620.1.1.15", "7"));
		this.bean.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
		this.bean.setConfidentialityCode(lookup(x_VeryBasicConfidentialityKind.class, "N", CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot()));
		this.bean.setCode(lookup(ActCode.class, "DX", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		this.bean.setCauseOfIndicator(true);
		this.bean.setDetectedIssueIndicator(true);
		this.bean.setAnnotationIndicator(true);
		this.bean.setAuthor(new AuthorBeanBuilder().populate().create());
		this.bean.setNegationInd(true);
		this.bean.setNextPlannedDoseDate(IntervalUtil.createInterval(DateUtil.getDate(2008, 4, 5, 0, 0, 0, 0, TimeZone.getTimeZone("America/Toronto")), null));
		this.bean.setRenewalDate(DateUtil.getDate(2008, 4, 5, 0, 0, 0, 0, TimeZone.getTimeZone("America/Toronto")));
		this.bean.setEffectiveTime(DateUtil.getDate(2008, 4, 5, 0, 0, 0, 0, TimeZone.getTimeZone("America/Toronto")));
		this.bean.setDoseSequenceNumber(3);
		this.bean.setLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		this.bean.setMedicine(new MedicineBeanBuilder().populate().create());
		this.bean.setResponsibleParty(new AssignedPersonBeanBuilder().populate().create());
		this.bean.setApproachSiteCode(lookup(HumanSubstanceAdministrationSite.class, "LLAQ", CodeSystem.VOCABULARY_BODY_SITE.getRoot()));
		this.bean.setInformantRole(lookup(x_InformationSource.class, "AGNT", CodeSystem.VOCABULARY_ROLE_CLASS.getRoot()));
		this.bean.setReasonCode(lookup(ActNoImmunizationReason.class, "IMMUNE", CodeSystem.VOCABULARY_ACT_REASON.getRoot()));
		this.bean.setRouteCode(lookup(RouteOfAdministration.class, "GARGLE", CodeSystem.VOCABULARY_ROUTE_OF_ADMINISTRATION.getRoot()));
		this.bean.setDoseQuantity(
			new PhysicalQuantity(
				BigDecimal.ONE, 
				lookup(x_DrugUnitsOfMeasure.class, "mg", CodeSystem.VOCABULARY_UNIFORM_UNIT_OF_MEASURE.getRoot())
			)
		);
		this.bean.getNotes().add(new NoteBeanBuilder().populate().create());
		this.bean.getNotes().add(new NoteBeanBuilder().populate().create());
		return this;
	}

}
