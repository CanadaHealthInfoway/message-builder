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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged;

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
 * <p>RecommendedDosage</p>
 * 
 * <p>COCT_MT260030CA.SubstanceAdministrationEventCriterion: 
 * Recommended Dosage</p>
 * 
 * <p><p>Identifies the outer dosage boundaries that were 
 * exceeded and triggered the issue. Included in this 
 * information are the drug-specific recommended dosage ranges 
 * for various age groups and weight classes.</p></p>
 * 
 * <p><p>Provides a reference for calculating optimum dose of 
 * medication for patients.</p></p>
 * 
 * <p>COCT_MT260010CA.SubstanceAdministrationEventCriterion: 
 * Recommended Dosage</p>
 * 
 * <p><p>Identifies the outer dosage boundaries that were 
 * exceeded and triggered the issue. Included in this 
 * information are the drug-specific recommended dosage ranges 
 * for various age groups and weight classes.</p></p>
 * 
 * <p><p>Provides a reference for calculating optimum dose of 
 * medication for patients.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.SubstanceAdministrationEventCriterion","COCT_MT260020CA.SubstanceAdministrationEventCriterion","COCT_MT260030CA.SubstanceAdministrationEventCriterion"})
public class RecommendedDosageBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private URG<PQ, PhysicalQuantity> doseQuantity = new URGImpl<PQ, PhysicalQuantity>();
    private List<DosagePreconditionsBean> componentObservationEventCriterion = new ArrayList<DosagePreconditionsBean>();


    /**
     * <p>DoseDuration</p>
     * 
     * <p>A:Dose Duration</p>
     * 
     * <p>A:Dose Duration</p>
     * 
     * <p><p>Indicates the recommended duration for drug therapy 
     * that was exceeded or not met.</p></p>
     * 
     * <p><p>Recommended Duration (width)</p></p>
     * 
     * <p><p>Allows calculation of amount under or over.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>DosageRange</p>
     * 
     * <p>B:Dosage Range</p>
     * 
     * <p>B:Dosage Range</p>
     * 
     * <p><p>This is a specification of the range of quantity of 
     * medication (Min/Max figures) that is recommended for the 
     * drug to avoid triggering of dosage issues.</p></p>
     * 
     * <p><p>ContraIndication.recommendedRange</p><p>Maximum Dosage 
     * Level (high)</p><p>Minimum Dosage Level (low)</p></p>
     * 
     * <p><p>ContraIndication.recommendedRange</p><p>Maximum Dosage 
     * Level (high)</p><p>Minimum Dosage Level (low)</p></p>
     * 
     * <p><p>ContraIndication.recommendedRange</p><p>Maximum Dosage 
     * Level (high)</p><p>Minimum Dosage Level (low)</p></p>
     * 
     * <p><p>Allows calculation of amount over/under.</p></p>
     */
    @Hl7XmlMapping({"doseQuantity"})
    public UncertainRange<PhysicalQuantity> getDoseQuantity() {
        return this.doseQuantity.getValue();
    }
    public void setDoseQuantity(UncertainRange<PhysicalQuantity> doseQuantity) {
        this.doseQuantity.setValue(doseQuantity);
    }


    @Hl7XmlMapping({"component/observationEventCriterion"})
    public List<DosagePreconditionsBean> getComponentObservationEventCriterion() {
        return this.componentObservationEventCriterion;
    }

}