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
package ca.infoway.messagebuilder.model.ab_r02_05_00_pa.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Includes</p>
 * 
 * <p>PORX_MT060060CA.Component6: f:includes</p>
 * 
 * <p>An essential part of most prescriptions is the 
 * authorization to dispense.</p>
 * 
 * <p>Identifies the instructions for how the prescribed device 
 * should be dispensed to the patient.</p>
 * 
 * <p>PORX_MT060040CA.Component6: f:includes</p>
 * 
 * <p>An essential part of most prescriptions is the 
 * authorization to dispense.</p>
 * 
 * <p>Identifies the instructions for how the prescribed device 
 * should be dispensed to the patient.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060040CA.Component6","PORX_MT060060CA.Component6"})
public class Component6Bean extends MessagePartBean {

    private static final long serialVersionUID = 20140501L;
    private DispenseInstructionsBean supplyRequest;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"supplyRequest"})
    public DispenseInstructionsBean getSupplyRequest() {
        return this.supplyRequest;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSupplyRequest(DispenseInstructionsBean supplyRequest) {
        this.supplyRequest = supplyRequest;
    }

}
