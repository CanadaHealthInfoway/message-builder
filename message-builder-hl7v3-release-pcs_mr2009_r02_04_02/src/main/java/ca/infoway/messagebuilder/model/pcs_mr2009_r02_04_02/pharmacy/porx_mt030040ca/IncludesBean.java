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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.porx_mt030040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: f:includes</p>
 * 
 * <p>An essential part of most prescriptions is the 
 * authorization to dispense. Multiple repetitions are included 
 * to accommodate circumstances where multiple drug products 
 * may need to be dispensed to complete a therapy. E.g. 100 x 
 * 20mg tablets and 50 x 10mg tablets. The association is 
 * marked as Populated because the authorization to dispense is 
 * a critical portion of a prescription. However the 
 * association is allowed to be 'null' when the order is for a 
 * medication which requires no dispense authorization (e.g. 
 * over-the-counter medications), or when the patient already 
 * has sufficient supply of the medication on hand to complete 
 * the therapy.</p>
 * 
 * <p>Identifies the instructions for how the prescribed 
 * medication should be dispensed to the patient.</p>
 */
@Hl7PartTypeMapping({"PORX_MT030040CA.Component6"})
public class IncludesBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private DispenseInstructionsBean supplyRequest;


    /**
     * <p>Relationship: PORX_MT030040CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"supplyRequest"})
    public DispenseInstructionsBean getSupplyRequest() {
        return this.supplyRequest;
    }

    /**
     * <p>Relationship: PORX_MT030040CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSupplyRequest(DispenseInstructionsBean supplyRequest) {
        this.supplyRequest = supplyRequest;
    }

}
