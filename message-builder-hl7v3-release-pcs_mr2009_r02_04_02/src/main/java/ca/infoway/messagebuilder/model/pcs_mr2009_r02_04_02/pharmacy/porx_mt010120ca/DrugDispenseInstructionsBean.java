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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.pharmacy.porx_mt010120ca;

import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.coct_mt220100ca.DrugProductBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.pharmacy.merged.FirstFillBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.pharmacy.merged.SubsequentSupplyRequestBean;
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
import java.util.Date;



/**
 * <p>Business Name: Drug Dispense Instructions</p>
 * 
 * <p>Sets the parameters within which the dispenser must 
 * operate in dispensing the medication to the patient.</p>
 * 
 * <p>Specification of the overall use duration of the 
 * prescrbed medication and/or overall quantity to be 
 * dispensed.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.SupplyRequestItem"})
public class DrugDispenseInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private PQ quantity = new PQImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();
    private DrugProductBean productMedication;
    private SubsequentSupplyRequestBean component1SubsequentSupplyRequest;
    private FirstFillBean component2InitialSupplyRequest;


    /**
     * <p>Business Name: B:Total Prescribed Quantity</p>
     * 
     * <p>Relationship: PORX_MT010120CA.SupplyRequestItem.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Sets upper limit for medication to be dispensed. Can be 
     * used to verify the intention of the prescriber with respect 
     * to the overall medication. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p><p>Narcotics 
     * must always be specified as a total.</p>
     * 
     * <p>The overall amount of amount medication to be dispensed 
     * under this prescription. Includes any first fills (trials, 
     * aligning quantities), the initial standard fill plus all 
     * refills.</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Business Name: B:Total Prescribed Quantity</p>
     * 
     * <p>Relationship: PORX_MT010120CA.SupplyRequestItem.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Sets upper limit for medication to be dispensed. Can be 
     * used to verify the intention of the prescriber with respect 
     * to the overall medication. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p><p>Narcotics 
     * must always be specified as a total.</p>
     * 
     * <p>The overall amount of amount medication to be dispensed 
     * under this prescription. Includes any first fills (trials, 
     * aligning quantities), the initial standard fill plus all 
     * refills.</p>
     */
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>Business Name: A:Total Days Supply</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.SupplyRequestItem.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to specify a total authorization as a duration 
     * rather than a quantity with refills. E.g. dispense 30 at a 
     * time, refill for 1 year. May also be sent as an estimate of 
     * the expected overall duration of the prescription based on 
     * the quantity prescribed.</p><p>This attribute is mandatory 
     * because the prescriber (in discussion with the patient) has 
     * a better understanding of the days supply needed by the 
     * patient.</p>
     * 
     * <p>The number of days that the overall prescribed item is 
     * expected to last, if the patient is compliant with the 
     * dispensing and administration of the prescription.</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }

    /**
     * <p>Business Name: A:Total Days Supply</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.SupplyRequestItem.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to specify a total authorization as a duration 
     * rather than a quantity with refills. E.g. dispense 30 at a 
     * time, refill for 1 year. May also be sent as an estimate of 
     * the expected overall duration of the prescription based on 
     * the quantity prescribed.</p><p>This attribute is mandatory 
     * because the prescriber (in discussion with the patient) has 
     * a better understanding of the days supply needed by the 
     * patient.</p>
     * 
     * <p>The number of days that the overall prescribed item is 
     * expected to last, if the patient is compliant with the 
     * dispensing and administration of the prescription.</p>
     */
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }


    /**
     * <p>Relationship: PORX_MT010120CA.Product1.medication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"product/medication"})
    public DrugProductBean getProductMedication() {
        return this.productMedication;
    }

    /**
     * <p>Relationship: PORX_MT010120CA.Product1.medication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setProductMedication(DrugProductBean productMedication) {
        this.productMedication = productMedication;
    }


    /**
     * <p>Relationship: 
     * PORX_MT010120CA.Component8.subsequentSupplyRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component1/subsequentSupplyRequest"})
    public SubsequentSupplyRequestBean getComponent1SubsequentSupplyRequest() {
        return this.component1SubsequentSupplyRequest;
    }

    /**
     * <p>Relationship: 
     * PORX_MT010120CA.Component8.subsequentSupplyRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponent1SubsequentSupplyRequest(SubsequentSupplyRequestBean component1SubsequentSupplyRequest) {
        this.component1SubsequentSupplyRequest = component1SubsequentSupplyRequest;
    }


    /**
     * <p>Relationship: 
     * PORX_MT010120CA.Component7.initialSupplyRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component2/initialSupplyRequest"})
    public FirstFillBean getComponent2InitialSupplyRequest() {
        return this.component2InitialSupplyRequest;
    }

    /**
     * <p>Relationship: 
     * PORX_MT010120CA.Component7.initialSupplyRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent2InitialSupplyRequest(FirstFillBean component2InitialSupplyRequest) {
        this.component2InitialSupplyRequest = component2InitialSupplyRequest;
    }

}
