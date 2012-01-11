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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged;

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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt220200ca.DrugProductBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.RelatedPersonBean;
import java.util.Date;



/**
 * <p>PORX_MT020030CA.SupplyEvent: Prescription Dispense 
 * Response</p>
 * 
 * <p><p>Represents the information returned when a dispense 
 * has been accepted</p></p>
 * 
 * <p><p>Allows communication of the identifiers assigned to 
 * the dispense and the prescription by the DIS.</p></p>
 * 
 * <p>PORX_MT020020CA.SupplyEvent: Dispense Pickup</p>
 * 
 * <p><p>Captures information about what prescription was 
 * picked up and who received it.</p></p>
 * 
 * <p><p>The root class for the message. The time of pickup is 
 * specified on the ControlAct wrapper.</p></p>
 * 
 * <p>PORX_MT020050CA.SupplyEvent: Office Supply</p>
 * 
 * <p><p>This is the detailed information about a medication 
 * being supplied for office use.</p></p>
 * 
 * <p><p>Allows for tracking of medications supplied to an 
 * office.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT020020CA.SupplyEvent","PORX_MT020030CA.SupplyEvent","PORX_MT020050CA.SupplyEvent"})
@Hl7RootType
public class PrescriptionDispenseResponseBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private II id = new IIImpl();
    private II inFulfillmentOfActRequestId = new IIImpl();
    private RelatedPersonBean receiverPersonalRelationship;
    private CV code = new CVImpl();
    private TS effectiveTime = new TSImpl();
    private PQ quantity = new PQImpl();
    private DrugProductBean productMedication;
    private II destinationServiceDeliveryLocationId = new IIImpl();
    private SupplyOrderBean fulfillmentSupplyRequest;
    private NotesBean subjectOfAnnotation;


    /**
     * <p>A:Local Dispense ID</p>
     * 
     * <p><p>Identifier assigned by the dispensing facility.</p></p>
     * 
     * <p><p>Allows formal tracking of centrally recorded dispenses 
     * to local records for audit and related purposes.</p></p>
     * 
     * <p>Dispense Identifier</p>
     * 
     * <p><p>Identifier of a dispense event to be used by the 
     * requesting dispenser.</p></p>
     * 
     * <p><p>Establishes a record of impending dispense on the 
     * prescription. Attribute is mandatory to ensure that 
     * successful request to dispense has been acknowledged by the 
     * DIS.</p></p>
     * 
     * <p>Dispense Id</p>
     * 
     * <p><p>Identity of prescription dispense that has been picked 
     * up.</p></p>
     * 
     * <p><p>Allows dispenses to be uniquely identified. This 
     * attribute is mandatory because the identity of the dispense 
     * record must be known.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>PrescriptionOrderNumber</p>
     * 
     * <p>A:Prescription Order Number</p>
     * 
     * <p><p>This is an identifier assigned to a specific 
     * medication order. The number remains constant across the 
     * lifetime of the order, regardless of the number of providers 
     * or pharmacies involved in fulfilling the order.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely referenced. 
     * Multiple identifiers are allowed to support assigning of 
     * prescription ids by the prescriber, EHR, and potentially by 
     * pharmacies.</p><p>The ID is mandatory to allow every 
     * prescription record to be uniquely identified.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely referenced. 
     * Multiple identifiers are allowed to support assigning of 
     * prescription ids by the prescriber, EHR, and potentially by 
     * pharmacies.</p><p>The ID is mandatory to allow every 
     * prescription record to be uniquely identified.</p></p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/actRequest/id"})
    public Identifier getInFulfillmentOfActRequestId() {
        return this.inFulfillmentOfActRequestId.getValue();
    }
    public void setInFulfillmentOfActRequestId(Identifier inFulfillmentOfActRequestId) {
        this.inFulfillmentOfActRequestId.setValue(inFulfillmentOfActRequestId);
    }


    @Hl7XmlMapping({"receiver/personalRelationship"})
    public RelatedPersonBean getReceiverPersonalRelationship() {
        return this.receiverPersonalRelationship;
    }
    public void setReceiverPersonalRelationship(RelatedPersonBean receiverPersonalRelationship) {
        this.receiverPersonalRelationship = receiverPersonalRelationship;
    }


    /**
     * <p>DispenseType</p>
     * 
     * <p>Dispense Type</p>
     * 
     * <p><p>Indicates the type of dispensing event that is being 
     * performed.</p><p>This is a fixed dispense type of 'Office 
     * Supply' unless using SNOMED.</p></p>
     * 
     * <p><p>Indicates the type of dispensing event that is being 
     * performed.</p><p>This is a fixed dispense type of 'Office 
     * Supply' unless using SNOMED.</p></p>
     * 
     * <p><p>Indicates reason for the size of dispense. Because it 
     * defines what type of dispense is occurring, the attribute is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>SupplyDate</p>
     * 
     * <p>A:Supply Date</p>
     * 
     * <p><p>Represents the date medication was supplied.</p></p>
     * 
     * <p><p>Needed for audit purposes.</p><p>Because the supply 
     * date is always known, the attribute is mandatory.</p></p>
     * 
     * <p><p>Needed for audit purposes.</p><p>Because the supply 
     * date is always known, the attribute is mandatory.</p></p>
     * 
     * <p><p>Must be able to post date a dispense (enter 
     * retroactively) e.g. system failure</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>SuppliedQuantity</p>
     * 
     * <p>B:Supplied Quantity</p>
     * 
     * <p><p>The amount of medication that has been dispensed. 
     * Includes unit of measure.</p></p>
     * 
     * <p><p>Allows for auditing of medication dispensed to an 
     * office. This is mandatory to allow reconciliation with the 
     * amount used from the office.</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    @Hl7XmlMapping({"product/medication"})
    public DrugProductBean getProductMedication() {
        return this.productMedication;
    }
    public void setProductMedication(DrugProductBean productMedication) {
        this.productMedication = productMedication;
    }


    /**
     * <p>ShipToFacilityId</p>
     * 
     * <p>C:Ship-to Facility Id</p>
     * 
     * <p><p>Identifier of the facility where the dispensed 
     * medication was shipped.</p></p>
     * 
     * <p><p>Allows tracking what drugs are dispensed to a 
     * facility. The attribute is mandatory because identification 
     * of the facility must be known.</p></p>
     */
    @Hl7XmlMapping({"destination/serviceDeliveryLocation/id"})
    public Identifier getDestinationServiceDeliveryLocationId() {
        return this.destinationServiceDeliveryLocationId.getValue();
    }
    public void setDestinationServiceDeliveryLocationId(Identifier destinationServiceDeliveryLocationId) {
        this.destinationServiceDeliveryLocationId.setValue(destinationServiceDeliveryLocationId);
    }


    @Hl7XmlMapping({"fulfillment/supplyRequest"})
    public SupplyOrderBean getFulfillmentSupplyRequest() {
        return this.fulfillmentSupplyRequest;
    }
    public void setFulfillmentSupplyRequest(SupplyOrderBean fulfillmentSupplyRequest) {
        this.fulfillmentSupplyRequest = fulfillmentSupplyRequest;
    }


    @Hl7XmlMapping({"subjectOf/annotation"})
    public NotesBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }
    public void setSubjectOfAnnotation(NotesBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }

}
