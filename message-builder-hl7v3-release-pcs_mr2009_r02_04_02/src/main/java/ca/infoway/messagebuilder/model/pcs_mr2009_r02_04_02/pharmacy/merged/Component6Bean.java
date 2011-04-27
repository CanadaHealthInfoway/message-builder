/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Includes</p>
 * 
 * <p>PORX_MT060060CA.Component6: f:includes</p>
 * 
 * <p><p>Identifies the instructions for how the prescribed 
 * device should be dispensed to the patient.</p></p>
 * 
 * <p><p>An essential part of most prescriptions is the 
 * authorization to dispense.</p></p>
 * 
 * <p>PORX_MT060040CA.Component6: f:includes</p>
 * 
 * <p><p>Identifies the instructions for how the prescribed 
 * device should be dispensed to the patient.</p></p>
 * 
 * <p><p>An essential part of most prescriptions is the 
 * authorization to dispense.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060040CA.Component6","PORX_MT060060CA.Component6"})
public class Component6Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private DispenseInstructionsBean supplyRequest;


    @Hl7XmlMapping({"supplyRequest"})
    public DispenseInstructionsBean getSupplyRequest() {
        return this.supplyRequest;
    }
    public void setSupplyRequest(DispenseInstructionsBean supplyRequest) {
        this.supplyRequest = supplyRequest;
    }

}
