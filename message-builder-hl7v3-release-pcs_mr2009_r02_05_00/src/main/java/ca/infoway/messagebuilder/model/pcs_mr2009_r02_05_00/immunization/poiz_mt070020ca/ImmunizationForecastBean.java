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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.immunization.poiz_mt070020ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.domainvalue.ImmunizationForecastStatus;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.domainvalue.VaccineType;
import java.util.Date;



/**
 * <p>Business Name: Immunization Forecast</p>
 * 
 * <p>Represents the recommended vaccination schedule for a 
 * patient.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT070020CA.ImmunizationForecast"})
public class ImmunizationForecastBean extends MessagePartBean {

    private static final long serialVersionUID = 20150904L;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private INT consumableSequenceNumber = new INTImpl();
    private CV consumableMedicationAdministerableMedicineCode = new CVImpl();
    private CV subjectForecastStatusCode = new CVImpl();


    /**
     * <p>Business Name: Eligibility Period</p>
     * 
     * <p>Relationship: 
     * POIZ_MT070020CA.ImmunizationForecast.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed for informing service providers as to when a 
     * patient is eligible or due for an administration. As such, 
     * this attribute is mandatory.</p>
     * 
     * <p>Low date in range represents the earliest eligible 
     * administration date. The high date in the range represents 
     * the date that the patient is due for the vaccine 
     * administration.</p>
     * 
     * <p>Represents the dates that the patient is eligible and due 
     * for a vaccine administration.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Eligibility Period</p>
     * 
     * <p>Relationship: 
     * POIZ_MT070020CA.ImmunizationForecast.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed for informing service providers as to when a 
     * patient is eligible or due for an administration. As such, 
     * this attribute is mandatory.</p>
     * 
     * <p>Low date in range represents the earliest eligible 
     * administration date. The high date in the range represents 
     * the date that the patient is due for the vaccine 
     * administration.</p>
     * 
     * <p>Represents the dates that the patient is eligible and due 
     * for a vaccine administration.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Dose Number</p>
     * 
     * <p>Relationship: POIZ_MT070020CA.Consumable.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Used to provide additional context to the immunization 
     * forecast.</p>
     * 
     * <p>Indicates whether the forecasted event is the initial 
     * immunization (Dose Number = 1) or a specific booster (Dose 
     * Number = 2 means first booster, 3 means second booster, 
     * etc.).</p>
     */
    @Hl7XmlMapping({"consumable/sequenceNumber"})
    public Integer getConsumableSequenceNumber() {
        return this.consumableSequenceNumber.getValue();
    }

    /**
     * <p>Business Name: Dose Number</p>
     * 
     * <p>Relationship: POIZ_MT070020CA.Consumable.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Used to provide additional context to the immunization 
     * forecast.</p>
     * 
     * <p>Indicates whether the forecasted event is the initial 
     * immunization (Dose Number = 1) or a specific booster (Dose 
     * Number = 2 means first booster, 3 means second booster, 
     * etc.).</p>
     */
    public void setConsumableSequenceNumber(Integer consumableSequenceNumber) {
        this.consumableSequenceNumber.setValue(consumableSequenceNumber);
    }


    /**
     * <p>Business Name: Immunizing Agent Code</p>
     * 
     * <p>Relationship: POIZ_MT070020CA.Medicine.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to represent higher-level vaccine information. It is 
     * expected that either the immunizing agent name or code is 
     * provided. As a result, this attribute is populated.</p>
     * 
     * <p>A coded attribute which represents the immunizing agent 
     * that is to be administered.</p>
     */
    @Hl7XmlMapping({"consumable/medication/administerableMedicine/code"})
    public VaccineType getConsumableMedicationAdministerableMedicineCode() {
        return (VaccineType) this.consumableMedicationAdministerableMedicineCode.getValue();
    }

    /**
     * <p>Business Name: Immunizing Agent Code</p>
     * 
     * <p>Relationship: POIZ_MT070020CA.Medicine.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to represent higher-level vaccine information. It is 
     * expected that either the immunizing agent name or code is 
     * provided. As a result, this attribute is populated.</p>
     * 
     * <p>A coded attribute which represents the immunizing agent 
     * that is to be administered.</p>
     */
    public void setConsumableMedicationAdministerableMedicineCode(VaccineType consumableMedicationAdministerableMedicineCode) {
        this.consumableMedicationAdministerableMedicineCode.setValue(consumableMedicationAdministerableMedicineCode);
    }


    /**
     * <p>Business Name: Immunization Status</p>
     * 
     * <p>Relationship: POIZ_MT070020CA.ForecastStatus.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Needed to indicate to a provider if a patient is up to 
     * date with their immunizations according to the schedule and 
     * is therefore mandatory.</p>
     * 
     * <p>Used to represent the patient's status with respect to 
     * their immunization schedule.</p>
     */
    @Hl7XmlMapping({"subject/forecastStatus/code"})
    public ImmunizationForecastStatus getSubjectForecastStatusCode() {
        return (ImmunizationForecastStatus) this.subjectForecastStatusCode.getValue();
    }

    /**
     * <p>Business Name: Immunization Status</p>
     * 
     * <p>Relationship: POIZ_MT070020CA.ForecastStatus.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Needed to indicate to a provider if a patient is up to 
     * date with their immunizations according to the schedule and 
     * is therefore mandatory.</p>
     * 
     * <p>Used to represent the patient's status with respect to 
     * their immunization schedule.</p>
     */
    public void setSubjectForecastStatusCode(ImmunizationForecastStatus subjectForecastStatusCode) {
        this.subjectForecastStatusCode.setValue(subjectForecastStatusCode);
    }

}
