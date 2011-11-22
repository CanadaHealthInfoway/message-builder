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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt220110ca.DrugProductBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT060160CA.SupplyRequestItem","PORX_MT060340CA.SupplyRequestItem"})
public class ExtendedDispenseInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20111121L;
    private PQ quantity = new PQImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();
    private DrugProductBean productMedication;
    private FirstFillBean component2InitialSupplyRequest;
    private SubsequentSupplyRequestBean component1SubsequentSupplyRequest;


    /**
     * <p>TotalPrescribedQuantity</p>
     * 
     * <p>B:Total Prescribed Quantity</p>
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
