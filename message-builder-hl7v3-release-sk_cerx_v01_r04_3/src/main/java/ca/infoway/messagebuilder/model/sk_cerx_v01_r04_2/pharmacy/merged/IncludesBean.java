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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Includes</p>
 * 
 * <p>PORX_MT060060CA.Component6: f:includes</p>
 * 
 * <p>Identifies the instructions for how the prescribed device 
 * should be dispensed to the patient.</p>
 * 
 * <p>Identifies the instructions for how the prescribed device 
 * should be dispensed to the patient.</p><p>An essential part 
 * of most prescriptions is the authorization to 
 * dispense.</p><p>The association is marked as Populated 
 * because the authorization to dispense is a critical portion 
 * of a prescription. However the association is allowed to be 
 * 'null' when the order is for a device which requires no 
 * dispense authorization, or when the patient already has 
 * sufficient supply of the device on hand to complete the 
 * therapy.</p>
 * 
 * <p>Identifies the instructions for how the prescribed device 
 * should be dispensed to the patient.</p><p>An essential part 
 * of most prescriptions is the authorization to 
 * dispense.</p><p>The association is marked as Populated 
 * because the authorization to dispense is a critical portion 
 * of a prescription. However the association is allowed to be 
 * 'null' when the order is for a device which requires no 
 * dispense authorization, or when the patient already has 
 * sufficient supply of the device on hand to complete the 
 * therapy.</p>
 * 
 * <p>Identifies the instructions for how the prescribed device 
 * should be dispensed to the patient.</p><p>An essential part 
 * of most prescriptions is the authorization to 
 * dispense.</p><p>The association is marked as Populated 
 * because the authorization to dispense is a critical portion 
 * of a prescription. However the association is allowed to be 
 * 'null' when the order is for a device which requires no 
 * dispense authorization, or when the patient already has 
 * sufficient supply of the device on hand to complete the 
 * therapy.</p>
 * 
 * <p>PORX_MT060040CA.Component6: f:includes</p>
 * 
 * <p>Identifies the instructions for how the prescribed device 
 * should be dispensed to the patient.</p>
 * 
 * <p>An essential part of most prescriptions is the 
 * authorization to dispense.</p>
 * 
 * <p>PORX_MT010110CA.Component6: f:includes</p>
 * 
 * <p>Identifies the instructions for how the prescribed device 
 * should be dispensed to the patient.</p>
 * 
 * <p>An essential part of most prescriptions is the 
 * authorization to dispense.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010110CA.Component6","PORX_MT060040CA.Component6","PORX_MT060060CA.Component6"})
public class IncludesBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private DispenseInstructions_1Bean supplyRequest;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p><div>Specification of how the prescribed device is to 
     * be</div> <div>component2.supplyRequest dispensed to the 
     * patient.&nbsp;</div></p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010110CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>&nbsp;Specification of how the prescribed device is to 
     * be</p> <div>dispensed to the patient.</div>
     */
    @Hl7XmlMapping({"supplyRequest"})
    public DispenseInstructions_1Bean getSupplyRequest() {
        return this.supplyRequest;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p><div>Specification of how the prescribed device is to 
     * be</div> <div>component2.supplyRequest dispensed to the 
     * patient.&nbsp;</div></p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010110CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>&nbsp;Specification of how the prescribed device is to 
     * be</p> <div>dispensed to the patient.</div>
     */
    public void setSupplyRequest(DispenseInstructions_1Bean supplyRequest) {
        this.supplyRequest = supplyRequest;
    }

}
