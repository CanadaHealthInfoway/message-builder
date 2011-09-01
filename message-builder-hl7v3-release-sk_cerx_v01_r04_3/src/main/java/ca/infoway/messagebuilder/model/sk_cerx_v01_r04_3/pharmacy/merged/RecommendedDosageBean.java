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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged;

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



@Hl7PartTypeMapping({"PORX_MT980010CA.SubstanceAdministrationEventCriterion","PORX_MT980020CA.SubstanceAdministrationEventCriterion","PORX_MT980030CA.SubstanceAdministrationEventCriterion"})
public class RecommendedDosageBean extends MessagePartBean {

    private static final long serialVersionUID = 20110901L;
    private IVL<TS, Interval<Date>> doseDuration = new IVLImpl<TS, Interval<Date>>();
    private URG<PQ, PhysicalQuantity> dosageRange = new URGImpl<PQ, PhysicalQuantity>();
    private List<DosagePreconditionsBean> componentObservationEventCriterion = new ArrayList<DosagePreconditionsBean>();


    /**
     * <p>DoseDuration</p>
     * 
     * <p>A:Dose Duration</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDoseDuration() {
        return this.doseDuration.getValue();
    }
    public void setDoseDuration(Interval<Date> doseDuration) {
        this.doseDuration.setValue(doseDuration);
    }


    /**
     * <p>DosageRange</p>
     * 
     * <p>B:Dosage Range</p>
     */
    @Hl7XmlMapping({"doseQuantity"})
    public UncertainRange<PhysicalQuantity> getDosageRange() {
        return this.dosageRange.getValue();
    }
    public void setDosageRange(UncertainRange<PhysicalQuantity> dosageRange) {
        this.dosageRange.setValue(dosageRange);
    }


    @Hl7XmlMapping({"component/observationEventCriterion"})
    public List<DosagePreconditionsBean> getComponentObservationEventCriterion() {
        return this.componentObservationEventCriterion;
    }

}
