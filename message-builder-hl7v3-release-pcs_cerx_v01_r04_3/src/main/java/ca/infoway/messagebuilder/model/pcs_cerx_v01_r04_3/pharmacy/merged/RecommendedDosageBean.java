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
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: RecommendedDosage</p>
 * 
 * <p>PORX_MT980010CA.SubstanceAdministrationEventCriterion: 
 * Recommended Dosage</p>
 * 
 * <p>Provides a reference for calculating optimum dose of 
 * medication for patients.</p>
 * 
 * <p>Identifies the outer dosage boundaries that were exceeded 
 * and triggered the issue. Included in this information are 
 * the drug-specific recommended dosage ranges for various age 
 * groups and weight classes.</p>
 * 
 * <p>PORX_MT980020CA.SubstanceAdministrationEventCriterion: 
 * Recommended Dosage</p>
 * 
 * <p>Provides a reference for calculating optimum dose of 
 * medication for patients.</p>
 * 
 * <p>Identifies the outer dosage boundaries that were exceeded 
 * and triggered the issue. Included in this information are 
 * the drug-specific recommended dosage ranges for various age 
 * groups, weight classes, etc.</p>
 * 
 * <p>PORX_MT980030CA.SubstanceAdministrationEventCriterion: 
 * Recommended Dosage</p>
 * 
 * <p>Provides a reference for calculating optimum dose of 
 * medication for patients.</p>
 * 
 * <p>Identifies the outer dosage boundaries that were exceeded 
 * and triggered the issue. Included in this information are 
 * the drug-specific recommended dosage ranges for various age 
 * groups and weight classes.</p>
 */
@Hl7PartTypeMapping({"PORX_MT980010CA.SubstanceAdministrationEventCriterion","PORX_MT980020CA.SubstanceAdministrationEventCriterion","PORX_MT980030CA.SubstanceAdministrationEventCriterion"})
public class RecommendedDosageBean extends MessagePartBean {

    private static final long serialVersionUID = 20190730L;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private URG<PQ, PhysicalQuantity> doseQuantity = new URGImpl<PQ, PhysicalQuantity>();
    private List<DosagePreconditionsBean> componentObservationEventCriterion = new ArrayList<DosagePreconditionsBean>();


    /**
     * <p>Business Name: DoseDuration</p>
     * 
     * <p>Un-merged Business Name: DoseDuration</p>
     * 
     * <p>Relationship: 
     * PORX_MT980010CA.SubstanceAdministrationEventCriterion.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Recommended Duration (width)</p>
     * 
     * <p>Allows calculation of amount under or over.</p>
     * 
     * <p>Indicates the recommended duration for drug therapy that 
     * was exceeded or not met.</p>
     * 
     * <p>Un-merged Business Name: DoseDuration</p>
     * 
     * <p>Relationship: 
     * PORX_MT980020CA.SubstanceAdministrationEventCriterion.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Recommended Duration (width)</p>
     * 
     * <p>Allows calculation of amount under or over.</p>
     * 
     * <p>Indicates the recommended duration for drug therapy that 
     * was exceeded or not met.</p>
     * 
     * <p>Un-merged Business Name: DoseDuration</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.SubstanceAdministrationEventCriterion.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Recommended Duration (width)</p>
     * 
     * <p>Allows calculation of amount under or over.</p>
     * 
     * <p>Indicates the recommended duration for drug therapy that 
     * was exceeded or not met.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: DoseDuration</p>
     * 
     * <p>Un-merged Business Name: DoseDuration</p>
     * 
     * <p>Relationship: 
     * PORX_MT980010CA.SubstanceAdministrationEventCriterion.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Recommended Duration (width)</p>
     * 
     * <p>Allows calculation of amount under or over.</p>
     * 
     * <p>Indicates the recommended duration for drug therapy that 
     * was exceeded or not met.</p>
     * 
     * <p>Un-merged Business Name: DoseDuration</p>
     * 
     * <p>Relationship: 
     * PORX_MT980020CA.SubstanceAdministrationEventCriterion.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Recommended Duration (width)</p>
     * 
     * <p>Allows calculation of amount under or over.</p>
     * 
     * <p>Indicates the recommended duration for drug therapy that 
     * was exceeded or not met.</p>
     * 
     * <p>Un-merged Business Name: DoseDuration</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.SubstanceAdministrationEventCriterion.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Recommended Duration (width)</p>
     * 
     * <p>Allows calculation of amount under or over.</p>
     * 
     * <p>Indicates the recommended duration for drug therapy that 
     * was exceeded or not met.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: DosageRange</p>
     * 
     * <p>Un-merged Business Name: DosageRange</p>
     * 
     * <p>Relationship: 
     * PORX_MT980010CA.SubstanceAdministrationEventCriterion.doseQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ContraIndication.recommendedRange</p>
     * 
     * <p>Maximum Dosage Level (high)</p>
     * 
     * <p>Minimum Dosage Level (low)</p>
     * 
     * <p>Allows calculation of amount over/under.</p>
     * 
     * <p>This is a specification of the range of quantity of 
     * medication (Min/Max figures) that is recommended for the 
     * drug to avoid triggering of dosage issues.</p>
     * 
     * <p>Un-merged Business Name: DosageRange</p>
     * 
     * <p>Relationship: 
     * PORX_MT980020CA.SubstanceAdministrationEventCriterion.doseQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ContraIndication.recommendedRange</p>
     * 
     * <p>Maximum Dosage Level (high)</p>
     * 
     * <p>Minimum Dosage Level (low)</p>
     * 
     * <p>Allows calculation of amount over/under.</p>
     * 
     * <p>This is a specification of the range of quantity of 
     * medication (Min/Max figures) that is recommended for the 
     * drug to avoid triggering of dosage issues.</p>
     * 
     * <p>Un-merged Business Name: DosageRange</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.SubstanceAdministrationEventCriterion.doseQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ContraIndication.recommendedRange</p>
     * 
     * <p>Maximum Dosage Level (high)</p>
     * 
     * <p>Minimum Dosage Level (low)</p>
     * 
     * <p>Allows calculation of amount over/under.</p>
     * 
     * <p>This is a specification of the range of quantity of 
     * medication (Min/Max figures) that is recommended for the 
     * drug to avoid triggering of dosage issues.</p>
     */
    @Hl7XmlMapping({"doseQuantity"})
    public UncertainRange<PhysicalQuantity> getDoseQuantity() {
        return this.doseQuantity.getValue();
    }

    /**
     * <p>Business Name: DosageRange</p>
     * 
     * <p>Un-merged Business Name: DosageRange</p>
     * 
     * <p>Relationship: 
     * PORX_MT980010CA.SubstanceAdministrationEventCriterion.doseQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ContraIndication.recommendedRange</p>
     * 
     * <p>Maximum Dosage Level (high)</p>
     * 
     * <p>Minimum Dosage Level (low)</p>
     * 
     * <p>Allows calculation of amount over/under.</p>
     * 
     * <p>This is a specification of the range of quantity of 
     * medication (Min/Max figures) that is recommended for the 
     * drug to avoid triggering of dosage issues.</p>
     * 
     * <p>Un-merged Business Name: DosageRange</p>
     * 
     * <p>Relationship: 
     * PORX_MT980020CA.SubstanceAdministrationEventCriterion.doseQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ContraIndication.recommendedRange</p>
     * 
     * <p>Maximum Dosage Level (high)</p>
     * 
     * <p>Minimum Dosage Level (low)</p>
     * 
     * <p>Allows calculation of amount over/under.</p>
     * 
     * <p>This is a specification of the range of quantity of 
     * medication (Min/Max figures) that is recommended for the 
     * drug to avoid triggering of dosage issues.</p>
     * 
     * <p>Un-merged Business Name: DosageRange</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.SubstanceAdministrationEventCriterion.doseQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ContraIndication.recommendedRange</p>
     * 
     * <p>Maximum Dosage Level (high)</p>
     * 
     * <p>Minimum Dosage Level (low)</p>
     * 
     * <p>Allows calculation of amount over/under.</p>
     * 
     * <p>This is a specification of the range of quantity of 
     * medication (Min/Max figures) that is recommended for the 
     * drug to avoid triggering of dosage issues.</p>
     */
    public void setDoseQuantity(UncertainRange<PhysicalQuantity> doseQuantity) {
        this.doseQuantity.setValue(doseQuantity);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT980010CA.Component2.observationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT980020CA.Component2.observationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.Component2.observationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component/observationEventCriterion"})
    public List<DosagePreconditionsBean> getComponentObservationEventCriterion() {
        return this.componentObservationEventCriterion;
    }

}
