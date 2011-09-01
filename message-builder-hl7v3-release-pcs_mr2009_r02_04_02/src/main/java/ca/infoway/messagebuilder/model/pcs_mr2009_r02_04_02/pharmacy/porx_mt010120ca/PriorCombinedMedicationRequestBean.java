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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.porx_mt010120ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p><p>Links the current order to a previous order</p></p>
 * 
 * <p><p>Links prescriptions into a 'chain', allowing easier 
 * monitoring.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.PriorCombinedMedicationRequest"})
public class PriorCombinedMedicationRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20110901L;
    private II previousPrescriptionOrderNumber = new IIImpl();
    private CV prescriptionType = new CVImpl();


    /**
     * <p>B:Previous Prescription Order Number</p>
     * 
     * <p><p>A reference to a previous prescription which the 
     * current prescription replaces.</p></p>
     * 
     * <p><p>Allows a prescription renewal (this prescription) to 
     * note the previous prescription id that was 
     * renewed;</p><p>Allows tracking a therapy across multiple 
     * renewal prescriptions.</p><p>As this is the direct link to 
     * the previous prescription, it is Mandatory.</p></p>
     * 
     * <p><p>Allows a prescription renewal (this prescription) to 
     * note the previous prescription id that was 
     * renewed;</p><p>Allows tracking a therapy across multiple 
     * renewal prescriptions.</p><p>As this is the direct link to 
     * the previous prescription, it is Mandatory.</p></p>
     * 
     * <p><p>Allows a prescription renewal (this prescription) to 
     * note the previous prescription id that was 
     * renewed;</p><p>Allows tracking a therapy across multiple 
     * renewal prescriptions.</p><p>As this is the direct link to 
     * the previous prescription, it is Mandatory.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPreviousPrescriptionOrderNumber() {
        return this.previousPrescriptionOrderNumber.getValue();
    }
    public void setPreviousPrescriptionOrderNumber(Identifier previousPrescriptionOrderNumber) {
        this.previousPrescriptionOrderNumber.setValue(previousPrescriptionOrderNumber);
    }


    /**
     * <p>Prescription type</p>
     * 
     * <p><p>It signifies the type of prescription (same as it is 
     * on the prescription pointed to by the Previous Prescription 
     * Order Number )</p></p>
     * 
     * <p><p>This allows for instant identification of the type of 
     * prescription being replaced/renewed, etc; and is therefore 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getPrescriptionType() {
        return (Code) this.prescriptionType.getValue();
    }
    public void setPrescriptionType(Code prescriptionType) {
        this.prescriptionType.setValue(prescriptionType);
    }

}
