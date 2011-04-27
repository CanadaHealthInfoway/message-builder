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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt020050ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220200ca.DrugProductBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.SupplyOrderBean;

import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT020050CA.SupplyEvent"})
@Hl7RootType
public class OfficeSupplyBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private II localDispenseID = new IIImpl();
    private CV dispenseType = new CVImpl();
    private TS supplyDate = new TSImpl();
    private PQ suppliedQuantity = new PQImpl();
    private DrugProductBean productMedication;
    private II shipToFacilityId = new IIImpl();
    private SupplyOrderBean fulfillmentSupplyRequest;
    private CommentBean subjectOfAnnotation;


    /**
     * <p>A:Local Dispense ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getLocalDispenseID() {
        return this.localDispenseID.getValue();
    }
    public void setLocalDispenseID(Identifier localDispenseID) {
        this.localDispenseID.setValue(localDispenseID);
    }


    /**
     * <p>Dispense Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getDispenseType() {
        return (ActCode) this.dispenseType.getValue();
    }
    public void setDispenseType(ActCode dispenseType) {
        this.dispenseType.setValue(dispenseType);
    }


    /**
     * <p>A:Supply Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getSupplyDate() {
        return this.supplyDate.getValue();
    }
    public void setSupplyDate(Date supplyDate) {
        this.supplyDate.setValue(supplyDate);
    }


    /**
     * <p>B:Supplied Quantity</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getSuppliedQuantity() {
        return this.suppliedQuantity.getValue();
    }
    public void setSuppliedQuantity(PhysicalQuantity suppliedQuantity) {
        this.suppliedQuantity.setValue(suppliedQuantity);
    }


    @Hl7XmlMapping({"product/medication"})
    public DrugProductBean getProductMedication() {
        return this.productMedication;
    }
    public void setProductMedication(DrugProductBean productMedication) {
        this.productMedication = productMedication;
    }


    /**
     * <p>C:Ship-to Facility Id</p>
     */
    @Hl7XmlMapping({"destination/serviceDeliveryLocation/id"})
    public Identifier getShipToFacilityId() {
        return this.shipToFacilityId.getValue();
    }
    public void setShipToFacilityId(Identifier shipToFacilityId) {
        this.shipToFacilityId.setValue(shipToFacilityId);
    }


    @Hl7XmlMapping({"fulfillment/supplyRequest"})
    public SupplyOrderBean getFulfillmentSupplyRequest() {
        return this.fulfillmentSupplyRequest;
    }
    public void setFulfillmentSupplyRequest(SupplyOrderBean fulfillmentSupplyRequest) {
        this.fulfillmentSupplyRequest = fulfillmentSupplyRequest;
    }


    @Hl7XmlMapping({"subjectOf/annotation"})
    public CommentBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }
    public void setSubjectOfAnnotation(CommentBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }

}
