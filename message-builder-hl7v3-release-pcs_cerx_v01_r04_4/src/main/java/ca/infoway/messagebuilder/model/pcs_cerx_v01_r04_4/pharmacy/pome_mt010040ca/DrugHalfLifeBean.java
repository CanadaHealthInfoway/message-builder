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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Drug Half-Life</p>
 * 
 * <p>Impacts contraindication checking for drugs no longer 
 * being taken by patients.</p>
 * 
 * <p>Specification of the length of time a particular drug 
 * remains in the body (as active)</p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.HalfLife"})
public class DrugHalfLifeBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private PQ value = new PQImpl();


    /**
     * <p>Business Name: Half-Life Period</p>
     * 
     * <p>Relationship: POME_MT010040CA.HalfLife.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>DrugProduct.HalfLifePeriod</p>
     * 
     * <p>Depending on the half-life, a drug may remain present and 
     * active in a patient's system long after they cease taking 
     * it. Understanding this time period is essential to 
     * appropriate dosing, and also to identifying when to include 
     * medications in drug-drug interaction checking.</p>
     * 
     * <p>Different drugs are absorbed and degraded by the body at 
     * different rates. The half-life indicates the length of time 
     * necessary for a human body to degrade the drug to half its 
     * original potency. The actual time-period will vary from 
     * person to person based on mass, renal function, liver 
     * function, route of administration and other factors</p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: Half-Life Period</p>
     * 
     * <p>Relationship: POME_MT010040CA.HalfLife.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>DrugProduct.HalfLifePeriod</p>
     * 
     * <p>Depending on the half-life, a drug may remain present and 
     * active in a patient's system long after they cease taking 
     * it. Understanding this time period is essential to 
     * appropriate dosing, and also to identifying when to include 
     * medications in drug-drug interaction checking.</p>
     * 
     * <p>Different drugs are absorbed and degraded by the body at 
     * different rates. The half-life indicates the length of time 
     * necessary for a human body to degrade the drug to half its 
     * original potency. The actual time-period will vary from 
     * person to person based on mass, renal function, liver 
     * function, route of administration and other factors</p>
     */
    public void setValue(PhysicalQuantity value) {
        this.value.setValue(value);
    }

}
