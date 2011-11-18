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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt220110ca.DrugProductBean;
import java.util.Date;



/**
 * <p>PORX_MT060160CA.SupplyRequestItem: Dispense Instruction 
 * Details</p>
 * 
 * <p><p>Specification of how the prescribed medication is to 
 * be dispensed to the patient. Dispensed instruction 
 * information includes the quantity to be dispensed, how often 
 * the quantity is to be dispensed, etc.</p></p>
 * 
 * <p><p>Sets the parameters within which the dispenser must 
 * operate in dispensing the medication to the 
 * patient.</p><p>Allows dispensing instructions to be given at 
 * specific dispensable drug level for an overall prescribed 
 * drug.</p></p>
 * 
 * <p><p>Sets the parameters within which the dispenser must 
 * operate in dispensing the medication to the 
 * patient.</p><p>Allows dispensing instructions to be given at 
 * specific dispensable drug level for an overall prescribed 
 * drug.</p></p>
 * 
 * <p>PORX_MT060340CA.SupplyRequestItem: Extended Dispense 
 * Instructions</p>
 * 
 * <p><p>Specification of the overall use duration of the 
 * prescrbed medication and/or overall quantity to be 
 * dispensed.</p></p>
 * 
 * <p><p>Sets the parameters within which the dispenser must 
 * operate in dispensing the medication to the patient.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060160CA.SupplyRequestItem","PORX_MT060340CA.SupplyRequestItem"})
public class ExtendedDispenseInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private PQ quantity = new PQImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();
    private DrugProductBean productMedication;
    private FirstFillBean component2InitialSupplyRequest;
    private SubsequentSupplyRequestBean component1SubsequentSupplyRequest;


    /**
     * <p>TotalPrescribedQuantity</p>
     * 
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
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>TotalDaysSupply</p>
     * 
     * <p>A:Total Days Supply</p>
     * 
     * <p><p>The number of days that the overall prescribed item is 
     * expected to last, if the patient is compliant with the 
     * dispensing and administration of the prescription.</p></p>
     * 
     * <p><p>Used to specify a total authorization as a duration 
     * rather than a quantity with refills. E.g. dispense 30 at a 
     * time, refill for 1 year. May also be sent as an estimate of 
     * the expected overall duration of the prescription based on 
     * the quantity prescribed. This attribute is mandatory because 
     * the prescriber (in discussion with the patient) has a better 
     * understanding of the days supply needed by the patient.</p></p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }


    @Hl7XmlMapping({"product/medication"})
    public DrugProductBean getProductMedication() {
        return this.productMedication;
    }
    public void setProductMedication(DrugProductBean productMedication) {
        this.productMedication = productMedication;
    }


    @Hl7XmlMapping({"component1/initialSupplyRequest","component2/initialSupplyRequest"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="component1", type="PORX_MT060160CA.Component7"),
        @Hl7MapByPartType(name="component1/initialSupplyRequest", type="PORX_MT060160CA.InitialSupplyRequest"),
        @Hl7MapByPartType(name="component2", type="PORX_MT060340CA.Component7"),
        @Hl7MapByPartType(name="component2/initialSupplyRequest", type="PORX_MT060340CA.InitialSupplyRequest")})
    public FirstFillBean getComponent2InitialSupplyRequest() {
        return this.component2InitialSupplyRequest;
    }
    public void setComponent2InitialSupplyRequest(FirstFillBean component2InitialSupplyRequest) {
        this.component2InitialSupplyRequest = component2InitialSupplyRequest;
    }


    @Hl7XmlMapping({"component1/subsequentSupplyRequest","component2/subsequentSupplyRequest"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="component1", type="PORX_MT060340CA.Component8"),
        @Hl7MapByPartType(name="component1/subsequentSupplyRequest", type="PORX_MT060340CA.SubsequentSupplyRequest"),
        @Hl7MapByPartType(name="component2", type="PORX_MT060160CA.Component8"),
        @Hl7MapByPartType(name="component2/subsequentSupplyRequest", type="PORX_MT060160CA.SubsequentSupplyRequest")})
    public SubsequentSupplyRequestBean getComponent1SubsequentSupplyRequest() {
        return this.component1SubsequentSupplyRequest;
    }
    public void setComponent1SubsequentSupplyRequest(SubsequentSupplyRequestBean component1SubsequentSupplyRequest) {
        this.component1SubsequentSupplyRequest = component1SubsequentSupplyRequest;
    }

}
