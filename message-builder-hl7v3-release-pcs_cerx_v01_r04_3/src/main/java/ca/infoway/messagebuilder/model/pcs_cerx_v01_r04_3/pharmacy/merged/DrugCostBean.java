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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: DrugCost</p>
 * 
 * <p>POME_MT010100CA.PotentialCharge: I:Drug Cost</p>
 * 
 * <p>Allows providers to evaluate patient's affordability 
 * status before prescribing a drug.</p>
 * 
 * <p>Suggested cost of a drug (unit cost).</p>
 * 
 * <p>POME_MT010040CA.PotentialCharge: Drug Cost</p>
 * 
 * <p>Allows providers to evaluate patient's affordability 
 * status before prescribing a drug.</p>
 * 
 * <p>Suggested cost of a drug (unit cost).</p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.PotentialCharge","POME_MT010100CA.PotentialCharge"})
public class DrugCostBean extends MessagePartBean {

    private static final long serialVersionUID = 20150903L;
    private MO unitPriceAmt = new MOImpl();


    /**
     * <p>Business Name: DrugCost</p>
     * 
     * <p>Un-merged Business Name: DrugCost</p>
     * 
     * <p>Relationship: 
     * POME_MT010100CA.PotentialCharge.unitPriceAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ZPJ2.2</p>
     * 
     * <p>May influence prescriber and pharmacists decisions as 
     * cost can impact compliance.</p>
     * 
     * <p>The average unit dose cost of the drug.</p>
     * 
     * <p>Un-merged Business Name: DrugCost</p>
     * 
     * <p>Relationship: 
     * POME_MT010040CA.PotentialCharge.unitPriceAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ZPJ2.2</p>
     * 
     * <p>May influence prescriber and pharmacists decisions as 
     * cost can impact compliance.</p>
     * 
     * <p>The average unit dose cost of the drug.</p>
     */
    @Hl7XmlMapping({"unitPriceAmt"})
    public Money getUnitPriceAmt() {
        return this.unitPriceAmt.getValue();
    }

    /**
     * <p>Business Name: DrugCost</p>
     * 
     * <p>Un-merged Business Name: DrugCost</p>
     * 
     * <p>Relationship: 
     * POME_MT010100CA.PotentialCharge.unitPriceAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ZPJ2.2</p>
     * 
     * <p>May influence prescriber and pharmacists decisions as 
     * cost can impact compliance.</p>
     * 
     * <p>The average unit dose cost of the drug.</p>
     * 
     * <p>Un-merged Business Name: DrugCost</p>
     * 
     * <p>Relationship: 
     * POME_MT010040CA.PotentialCharge.unitPriceAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ZPJ2.2</p>
     * 
     * <p>May influence prescriber and pharmacists decisions as 
     * cost can impact compliance.</p>
     * 
     * <p>The average unit dose cost of the drug.</p>
     */
    public void setUnitPriceAmt(Money unitPriceAmt) {
        this.unitPriceAmt.setValue(unitPriceAmt);
    }

}
