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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Business Name: PartOf</p>
 * 
 * <p>POIZ_MT060150ON.InFulfillmentOf3: part of</p>
 * 
 * <p>Allows tracking against a therapy plan.</p>
 * 
 * <p>Indicates the order of a specific immunization event with 
 * a planned/expected number of immunizations.</p>
 * 
 * <p>POIZ_MT030060ON.InFulfillmentOf3: part of</p>
 * 
 * <p>Allows changing what dose was administered after the 
 * fact.</p>
 * 
 * <p>Indicates the order of a specific immunization event with 
 * a planned/expected number of immunizations.</p>
 * 
 * <p>POIZ_MT030050ON.InFulfillmentOf3: part of</p>
 * 
 * <p>Allows tracking against a therapy plan.</p>
 * 
 * <p>Indicates the order of a specific immunization event with 
 * a planned/expected number of immunizations.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050ON.InFulfillmentOf3","POIZ_MT030060ON.InFulfillmentOf3","POIZ_MT060150ON.InFulfillmentOf3"})
public class PartOfBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private INT sequenceNumber = new INTImpl();
    private IVL<TS, Interval<Date>> immunizationPlanFulfillmentNextPlannedImmunizationEffectiveTime = new IVLImpl<TS, Interval<Date>>();
    private TS immunizationPlanSuccessorNextImmunizationPlanEffectiveTime = new TSImpl();


    /**
     * <p>Business Name: VaccineDoseNumber</p>
     * 
     * <p>Un-merged Business Name: VaccineDoseNumber</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150ON.InFulfillmentOf3.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>RXA.2</p>
     * 
     * <p>Used in compliance checking regarding completion of a 
     * planned immunization therapy.</p>
     * 
     * <p>Indicates whether this is the initial immunization (Dose 
     * Number = 1) or a specific booster (Dose Number = 2 means 
     * first booster, 3 means 2nd booster, etc.).</p>
     * 
     * <p>Un-merged Business Name: VaccineDoseNumber</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060ON.InFulfillmentOf3.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>RXA.2</p>
     * 
     * <p>Used in compliance checking regarding completion of a 
     * planned immunization therapy and is therefore marked as 
     * &quot;populated&quot;.</p>
     * 
     * <p>Indicates whether this is the initial immunization (Dose 
     * Number = 1) or a specific booster (Dose Number = 2 means 
     * first booster, 3 means 2nd booster, etc.).</p>
     * 
     * <p>Un-merged Business Name: VaccineDoseNumber</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050ON.InFulfillmentOf3.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>RXA.2</p>
     * 
     * <p>Used in compliance checking regarding completion of a 
     * planned immunization therapy.</p>
     * 
     * <p>Indicates whether this is the initial immunization (Dose 
     * Number = 1) or a specific booster (Dose Number = 2 means 
     * first booster, 3 means 2nd booster, etc.).</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Business Name: VaccineDoseNumber</p>
     * 
     * <p>Un-merged Business Name: VaccineDoseNumber</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150ON.InFulfillmentOf3.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>RXA.2</p>
     * 
     * <p>Used in compliance checking regarding completion of a 
     * planned immunization therapy.</p>
     * 
     * <p>Indicates whether this is the initial immunization (Dose 
     * Number = 1) or a specific booster (Dose Number = 2 means 
     * first booster, 3 means 2nd booster, etc.).</p>
     * 
     * <p>Un-merged Business Name: VaccineDoseNumber</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060ON.InFulfillmentOf3.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>RXA.2</p>
     * 
     * <p>Used in compliance checking regarding completion of a 
     * planned immunization therapy and is therefore marked as 
     * &quot;populated&quot;.</p>
     * 
     * <p>Indicates whether this is the initial immunization (Dose 
     * Number = 1) or a specific booster (Dose Number = 2 means 
     * first booster, 3 means 2nd booster, etc.).</p>
     * 
     * <p>Un-merged Business Name: VaccineDoseNumber</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050ON.InFulfillmentOf3.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>RXA.2</p>
     * 
     * <p>Used in compliance checking regarding completion of a 
     * planned immunization therapy.</p>
     * 
     * <p>Indicates whether this is the initial immunization (Dose 
     * Number = 1) or a specific booster (Dose Number = 2 means 
     * first booster, 3 means 2nd booster, etc.).</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Un-merged Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150ON.NextPlannedImmunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the scheduling of a multi-dose immunization 
     * course.</p>
     * 
     * <p>Indicates the date on which the next dose is to be 
     * administered. .</p>
     * 
     * <p>Un-merged Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060ON.NextPlannedImmunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the scheduling of a multi-dose immunization 
     * course.</p>
     * 
     * <p>Indicates the date on which the next dose is to be 
     * administered.</p>
     * 
     * <p>Un-merged Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050ON.NextPlannedImmunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Necessary reminder to a patient and his/or provider for a 
     * follow-up therapy.</p>
     * 
     * <p>Indicates the date on which the next course of 
     * immunization is to be undertaken.</p>
     */
    @Hl7XmlMapping({"immunizationPlan/fulfillment/nextPlannedImmunization/effectiveTime"})
    public Interval<Date> getImmunizationPlanFulfillmentNextPlannedImmunizationEffectiveTime() {
        return this.immunizationPlanFulfillmentNextPlannedImmunizationEffectiveTime.getValue();
    }

    /**
     * <p>Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Un-merged Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150ON.NextPlannedImmunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the scheduling of a multi-dose immunization 
     * course.</p>
     * 
     * <p>Indicates the date on which the next dose is to be 
     * administered. .</p>
     * 
     * <p>Un-merged Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060ON.NextPlannedImmunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the scheduling of a multi-dose immunization 
     * course.</p>
     * 
     * <p>Indicates the date on which the next dose is to be 
     * administered.</p>
     * 
     * <p>Un-merged Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050ON.NextPlannedImmunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Necessary reminder to a patient and his/or provider for a 
     * follow-up therapy.</p>
     * 
     * <p>Indicates the date on which the next course of 
     * immunization is to be undertaken.</p>
     */
    public void setImmunizationPlanFulfillmentNextPlannedImmunizationEffectiveTime(Interval<Date> immunizationPlanFulfillmentNextPlannedImmunizationEffectiveTime) {
        this.immunizationPlanFulfillmentNextPlannedImmunizationEffectiveTime.setValue(immunizationPlanFulfillmentNextPlannedImmunizationEffectiveTime);
    }


    /**
     * <p>Un-merged Business Name: RenewalDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150ON.NextImmunizationPlan.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Necessary reminder to a patient and his/or provider for a 
     * follow-up therapy.</p>
     * 
     * <p>Indicates the date on which the next course of 
     * immunization is to be undertaken.</p>
     * 
     * <p>Un-merged Business Name: NextPlannedSeriesRepeatDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060ON.NextImmunizationPlan.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for immunization therapy planning for a 
     * patient.</p>
     * 
     * <p>The date on which the overall immunization therapy is to 
     * be repeated.</p>
     * 
     * <p>Un-merged Business Name: NextPlannedSeriesRepeatDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050ON.NextImmunizationPlan.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the scheduling of a multi-dose immunization 
     * course.</p>
     * 
     * <p>Indicates the date on which the next series is scheduled 
     * to be administered.</p>
     */
    @Hl7XmlMapping({"immunizationPlan/successor/nextImmunizationPlan/effectiveTime"})
    public Date getImmunizationPlanSuccessorNextImmunizationPlanEffectiveTime() {
        return this.immunizationPlanSuccessorNextImmunizationPlanEffectiveTime.getValue();
    }

    /**
     * <p>Un-merged Business Name: RenewalDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150ON.NextImmunizationPlan.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Necessary reminder to a patient and his/or provider for a 
     * follow-up therapy.</p>
     * 
     * <p>Indicates the date on which the next course of 
     * immunization is to be undertaken.</p>
     * 
     * <p>Un-merged Business Name: NextPlannedSeriesRepeatDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060ON.NextImmunizationPlan.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for immunization therapy planning for a 
     * patient.</p>
     * 
     * <p>The date on which the overall immunization therapy is to 
     * be repeated.</p>
     * 
     * <p>Un-merged Business Name: NextPlannedSeriesRepeatDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050ON.NextImmunizationPlan.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the scheduling of a multi-dose immunization 
     * course.</p>
     * 
     * <p>Indicates the date on which the next series is scheduled 
     * to be administered.</p>
     */
    public void setImmunizationPlanSuccessorNextImmunizationPlanEffectiveTime(Date immunizationPlanSuccessorNextImmunizationPlanEffectiveTime) {
        this.immunizationPlanSuccessorNextImmunizationPlanEffectiveTime.setValue(immunizationPlanSuccessorNextImmunizationPlanEffectiveTime);
    }

}
