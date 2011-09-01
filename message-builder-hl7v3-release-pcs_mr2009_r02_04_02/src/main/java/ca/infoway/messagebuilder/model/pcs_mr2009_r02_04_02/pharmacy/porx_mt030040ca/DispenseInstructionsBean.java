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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.porx_mt030040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.OccurredAtBean;



/**
 * <p>Dispense Instructions</p>
 * 
 * <p><p>Specification of how the prescribed medication is to 
 * be dispensed to the patient. Dispensed instruction 
 * information includes the quantity to be dispensed, how often 
 * the quantity is to be dispensed, etc.</p></p>
 * 
 * <p><p>Sets the parameters within which the dispenser must 
 * operate in dispensing the medication to the patient.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT030040CA.SupplyRequest"})
public class DispenseInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110901L;
    private CS prescriptionDispenseIndicator = new CSImpl();
    private PQ totalPrescribedQuantity = new PQImpl();
    private OccurredAtBean location;


    /**
     * <p>A:Prescription Dispense Indicator</p>
     * 
     * <p><p>This generally mirrors the status for the 
     * prescription, but in some circumstances may be changed to 
     * 'aborted' while the prescription is still active. When this 
     * occurs, it means the prescription may no longer be 
     * dispensed, though it may still be administered.</p></p>
     * 
     * <p><p>Allows a prescriber to say &quot;Finish what you have 
     * on hand, but don't get any more.&quot;</p><p>Because the 
     * status should always be known, this element is 
     * mandatory.</p></p>
     * 
     * <p><p>Allows a prescriber to say &quot;Finish what you have 
     * on hand, but don't get any more.&quot;</p><p>Because the 
     * status should always be known, this element is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getPrescriptionDispenseIndicator() {
        return (ActStatus) this.prescriptionDispenseIndicator.getValue();
    }
    public void setPrescriptionDispenseIndicator(ActStatus prescriptionDispenseIndicator) {
        this.prescriptionDispenseIndicator.setValue(prescriptionDispenseIndicator);
    }


    /**
     * <p>B:Total Prescribed Quantity</p>
     * 
     * <p><p>The overall amount of amount medication to be 
     * dispensed under this prescription. Includes any first fills 
     * (trials, aligning quantities), the initial standard fill 
     * plus all refills.</p></p>
     * 
     * <p><p>Sets upper limit for medication to be dispensed. Can 
     * be used to verify the intention of the prescriber with 
     * respect to the overall medication. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p><p>Narcotics 
     * must always be specified as a total quantity.</p></p>
     * 
     * <p><p>Sets upper limit for medication to be dispensed. Can 
     * be used to verify the intention of the prescriber with 
     * respect to the overall medication. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p><p>Narcotics 
     * must always be specified as a total quantity.</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getTotalPrescribedQuantity() {
        return this.totalPrescribedQuantity.getValue();
    }
    public void setTotalPrescribedQuantity(PhysicalQuantity totalPrescribedQuantity) {
        this.totalPrescribedQuantity.setValue(totalPrescribedQuantity);
    }


    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }

}
