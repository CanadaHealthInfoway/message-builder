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
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: PartOf</p>
 * 
 * <p>POIZ_MT030050CA.InFulfillmentOf3: part of</p>
 * 
 * <p>Allows tracking against a therapy plan.</p>
 * 
 * <p>Indicates the order of a specific immunization event with 
 * a planned/expected number of immunizations.</p>
 * 
 * <p>POIZ_MT060150CA.InFulfillmentOf3: part of</p>
 * 
 * <p>Allows tracking against a therapy plan.</p>
 * 
 * <p>Indicates the order of a specific immunization event with 
 * a planned/expected number of immunizations.</p>
 * 
 * <p>POIZ_MT030060CA.InFulfillmentOf3: part of</p>
 * 
 * <p>Allows changing what dose was administered after the 
 * fact.</p>
 * 
 * <p>Indicates the order of a specific immunization event with 
 * a planned/expected number of immunizations.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.InFulfillmentOf3","POIZ_MT030060CA.InFulfillmentOf3","POIZ_MT060150CA.InFulfillmentOf3"})
public class PartOfBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private INT sequenceNumber = new INTImpl();
    private ImmunizationCourseBean immunizationPlan;


    /**
     * <p>Business Name: VaccineDoseNumber</p>
     * 
     * <p>Other Business Name: VaccineDoseNumber</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.InFulfillmentOf3.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
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
     * <p>Other Business Name: VaccineDoseNumber</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.InFulfillmentOf3.sequenceNumber</p>
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
     * <p>Other Business Name: VaccineDoseNumber</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.InFulfillmentOf3.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
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
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Business Name: VaccineDoseNumber</p>
     * 
     * <p>Other Business Name: VaccineDoseNumber</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.InFulfillmentOf3.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
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
     * <p>Other Business Name: VaccineDoseNumber</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.InFulfillmentOf3.sequenceNumber</p>
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
     * <p>Other Business Name: VaccineDoseNumber</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.InFulfillmentOf3.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
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
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.InFulfillmentOf3.immunizationPlan</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.InFulfillmentOf3.immunizationPlan</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.InFulfillmentOf3.immunizationPlan</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"immunizationPlan"})
    public ImmunizationCourseBean getImmunizationPlan() {
        return this.immunizationPlan;
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.InFulfillmentOf3.immunizationPlan</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.InFulfillmentOf3.immunizationPlan</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.InFulfillmentOf3.immunizationPlan</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setImmunizationPlan(ImmunizationCourseBean immunizationPlan) {
        this.immunizationPlan = immunizationPlan;
    }

}
