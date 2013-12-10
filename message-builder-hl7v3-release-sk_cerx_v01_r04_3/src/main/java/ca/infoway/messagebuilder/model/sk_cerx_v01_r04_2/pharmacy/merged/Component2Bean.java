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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Includes</p>
 * 
 * <p>PORX_MT020070CA.Component2: (no business name)</p>
 * 
 * <p>Component must be specified if the id is null and can not 
 * be specified if the id is not null.</p>
 * 
 * <p>PORX_MT030040CA.Component6: f:includes</p>
 * 
 * <p>Identifies the instructions for how the prescribed 
 * medication should be dispensed to the patient.</p>
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
 * <p>PORX_MT060190CA.Component6: f:includes</p>
 * 
 * <p>Identifies the instructions for how the prescribed 
 * medication should be dispensed to the patient.</p>
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
 */
@Hl7PartTypeMapping({"PORX_MT020070CA.Component2","PORX_MT030040CA.Component6","PORX_MT060190CA.Component6"})
public class Component2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20131210L;
    private BL contextConductionInd = new BLImpl();
    private DispenseInstructions_2Bean supplyRequest;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.Component2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.Component2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020070CA.Component2.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p><div>Specification of how the prescribed medication 
     * is</div> <p>to be dispensed to the patient.&nbsp;</p></p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"supplyRequest"})
    public DispenseInstructions_2Bean getSupplyRequest() {
        return this.supplyRequest;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020070CA.Component2.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p><div>Specification of how the prescribed medication 
     * is</div> <p>to be dispensed to the patient.&nbsp;</p></p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSupplyRequest(DispenseInstructions_2Bean supplyRequest) {
        this.supplyRequest = supplyRequest;
    }

}
