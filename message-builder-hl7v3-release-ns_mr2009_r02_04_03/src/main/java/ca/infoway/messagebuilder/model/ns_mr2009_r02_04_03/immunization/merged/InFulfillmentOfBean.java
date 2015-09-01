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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>POIZ_MT030060CA.InFulfillmentOf: (no business name)</p>
 * 
 * <p>Allows tracking against an immunization plan or 
 * schedule.</p>
 * 
 * <p>Indicates the order of a specific immunization event with 
 * a planned/expected number of immunizations.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.InFulfillmentOf","POIZ_MT030060CA.InFulfillmentOf","POIZ_MT060150CA.InFulfillmentOf"})
public class InFulfillmentOfBean extends MessagePartBean {

    private static final long serialVersionUID = 20150901L;
    private INT sequenceNumber = new INTImpl();
    private BL immunizationPlan = new BLImpl(false);


    /**
     * <p>Business Name: DoseNumber</p>
     * 
     * <p>Un-merged Business Name: DoseNumber</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.InFulfillmentOf.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: DoseNumber</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.InFulfillmentOf.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used in compliance checking regarding completion of an 
     * immunization plan or schedule.</p>
     * 
     * <p>Indicates whether this is the initial immunization (Dose 
     * Number = 1) or a specific booster (Dose Number = 2 means 
     * first booster, 3 means second booster, etc.).</p>
     * 
     * <p>Un-merged Business Name: DoseNumber</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.InFulfillmentOf.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Business Name: DoseNumber</p>
     * 
     * <p>Un-merged Business Name: DoseNumber</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.InFulfillmentOf.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: DoseNumber</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.InFulfillmentOf.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used in compliance checking regarding completion of an 
     * immunization plan or schedule.</p>
     * 
     * <p>Indicates whether this is the initial immunization (Dose 
     * Number = 1) or a specific booster (Dose Number = 2 means 
     * first booster, 3 means second booster, etc.).</p>
     * 
     * <p>Un-merged Business Name: DoseNumber</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.InFulfillmentOf.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.InFulfillmentOf.immunizationPlan</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.InFulfillmentOf.immunizationPlan</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.InFulfillmentOf.immunizationPlan</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"immunizationPlan"})
    public Boolean getImmunizationPlan() {
        return this.immunizationPlan.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.InFulfillmentOf.immunizationPlan</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.InFulfillmentOf.immunizationPlan</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.InFulfillmentOf.immunizationPlan</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setImmunizationPlan(Boolean immunizationPlan) {
        this.immunizationPlan.setValue(immunizationPlan);
    }

}
