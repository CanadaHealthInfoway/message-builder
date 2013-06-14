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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt220200ca.DrugProductBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.RelatedPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.ServiceDeliveryLocationBean;
import java.util.Date;
import java.util.Set;



/**
 * <p>PORX_MT020030CA.SupplyEvent: Prescription Dispense 
 * Response</p>
 * 
 * <p>Allows communication of the identifiers assigned to the 
 * dispense and the prescription by the DIS.</p>
 * 
 * <p>Represents the information returned when a dispense has 
 * been accepted</p>
 * 
 * <p>PORX_MT020020CA.SupplyEvent: Dispense Pickup</p>
 * 
 * <p>The root class for the message. The time of pickup is 
 * specified on the ControlAct wrapper.</p>
 * 
 * <p>Captures information about what prescription was picked 
 * up and who received it.</p>
 * 
 * <p>PORX_MT020050CA.SupplyEvent: Office Supply</p>
 * 
 * <p>Allows for tracking of medications supplied to an 
 * office.</p>
 * 
 * <p>This is the detailed information about a medication being 
 * supplied for office use.</p>
 */
@Hl7PartTypeMapping({"PORX_MT020020CA.SupplyEvent","PORX_MT020030CA.SupplyEvent","PORX_MT020050CA.SupplyEvent"})
@Hl7RootType
public class PrescriptionDispenseResponseBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private II id = new IIImpl();
    private SET<II, Identifier> inFulfillmentOfActRequestId = new SETImpl<II, Identifier>(IIImpl.class);
    private RelatedPersonBean receiverPersonalRelationship;
    private TS effectiveTime = new TSImpl();
    private PQ quantity = new PQImpl();
    private DrugProductBean productMedication;
    private ServiceDeliveryLocationBean destinationServiceDeliveryLocation;
    private SupplyOrderBean fulfillmentSupplyRequest;
    private IncludesBean subjectOf;


    /**
     * <p>Un-merged Business Name: DispenseIdentifier</p>
     * 
     * <p>Relationship: PORX_MT020030CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Establishes a record of impending dispense on the 
     * prescription. Attribute is mandatory to ensure that 
     * successful request to dispense has been acknowledged by the 
     * DIS.</p>
     * 
     * <p>Identifier of a dispense event to be used by the 
     * requesting dispenser.</p>
     * 
     * <p>Un-merged Business Name: DispenseId</p>
     * 
     * <p>Relationship: PORX_MT020020CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows dispenses to be uniquely identified. This 
     * attribute is mandatory because the identity of the dispense 
     * record must be known.</p>
     * 
     * <p>Identity of prescription dispense that has been picked 
     * up.</p>
     * 
     * <p>Un-merged Business Name: LocalDispenseID</p>
     * 
     * <p>Relationship: PORX_MT020050CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows formal tracking of centrally recorded dispenses to 
     * local records for audit and related purposes.</p>
     * 
     * <p>Identifier assigned by the dispensing facility.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Un-merged Business Name: DispenseIdentifier</p>
     * 
     * <p>Relationship: PORX_MT020030CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Establishes a record of impending dispense on the 
     * prescription. Attribute is mandatory to ensure that 
     * successful request to dispense has been acknowledged by the 
     * DIS.</p>
     * 
     * <p>Identifier of a dispense event to be used by the 
     * requesting dispenser.</p>
     * 
     * <p>Un-merged Business Name: DispenseId</p>
     * 
     * <p>Relationship: PORX_MT020020CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows dispenses to be uniquely identified. This 
     * attribute is mandatory because the identity of the dispense 
     * record must be known.</p>
     * 
     * <p>Identity of prescription dispense that has been picked 
     * up.</p>
     * 
     * <p>Un-merged Business Name: LocalDispenseID</p>
     * 
     * <p>Relationship: PORX_MT020050CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows formal tracking of centrally recorded dispenses to 
     * local records for audit and related purposes.</p>
     * 
     * <p>Identifier assigned by the dispensing facility.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Relationship: PORX_MT020030CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-2)</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced. Multiple 
     * identifiers are allowed to support assigning of prescription 
     * ids by the prescriber, EHR, and potentially by 
     * pharmacies.</p><p>The ID is mandatory to allow every 
     * prescription record to be uniquely identified.</p>
     * 
     * <p>This is an identifier assigned to a specific medication 
     * order. The number remains constant across the lifetime of 
     * the order, regardless of the number of providers or 
     * pharmacies involved in fulfilling the order.</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/actRequest/id"})
    public Set<Identifier> getInFulfillmentOfActRequestId() {
        return this.inFulfillmentOfActRequestId.rawSet();
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020020CA.Receiver.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"receiver/personalRelationship"})
    public RelatedPersonBean getReceiverPersonalRelationship() {
        return this.receiverPersonalRelationship;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020020CA.Receiver.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setReceiverPersonalRelationship(RelatedPersonBean receiverPersonalRelationship) {
        this.receiverPersonalRelationship = receiverPersonalRelationship;
    }


    /**
     * <p>Business Name: SupplyDate</p>
     * 
     * <p>Un-merged Business Name: SupplyDate</p>
     * 
     * <p>Relationship: PORX_MT020050CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed for audit purposes.</p><p>Because the supply date 
     * is always known, the attribute is mandatory.</p>
     * 
     * <p>Must be able to post date a dispense (enter 
     * retroactively) e.g. system failure</p>
     * 
     * <p>Represents the date medication was supplied.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: SupplyDate</p>
     * 
     * <p>Un-merged Business Name: SupplyDate</p>
     * 
     * <p>Relationship: PORX_MT020050CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed for audit purposes.</p><p>Because the supply date 
     * is always known, the attribute is mandatory.</p>
     * 
     * <p>Must be able to post date a dispense (enter 
     * retroactively) e.g. system failure</p>
     * 
     * <p>Represents the date medication was supplied.</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: SuppliedQuantity</p>
     * 
     * <p>Un-merged Business Name: SuppliedQuantity</p>
     * 
     * <p>Relationship: PORX_MT020050CA.SupplyEvent.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for auditing of medication dispensed to an office. 
     * This is mandatory to allow reconciliation with the amount 
     * used from the office.</p>
     * 
     * <p>The amount of medication that has been dispensed. 
     * Includes unit of measure.</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Business Name: SuppliedQuantity</p>
     * 
     * <p>Un-merged Business Name: SuppliedQuantity</p>
     * 
     * <p>Relationship: PORX_MT020050CA.SupplyEvent.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for auditing of medication dispensed to an office. 
     * This is mandatory to allow reconciliation with the amount 
     * used from the office.</p>
     * 
     * <p>The amount of medication that has been dispensed. 
     * Includes unit of measure.</p>
     */
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020050CA.Product2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"product/medication"})
    public DrugProductBean getProductMedication() {
        return this.productMedication;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020050CA.Product2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setProductMedication(DrugProductBean productMedication) {
        this.productMedication = productMedication;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020050CA.Destination2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public ServiceDeliveryLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020050CA.Destination2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setDestinationServiceDeliveryLocation(ServiceDeliveryLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020050CA.InFulfillmentOf.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment/supplyRequest"})
    public SupplyOrderBean getFulfillmentSupplyRequest() {
        return this.fulfillmentSupplyRequest;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020050CA.InFulfillmentOf.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setFulfillmentSupplyRequest(SupplyOrderBean fulfillmentSupplyRequest) {
        this.fulfillmentSupplyRequest = fulfillmentSupplyRequest;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020050CA.SupplyEvent.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"subjectOf"})
    public IncludesBean getSubjectOf() {
        return this.subjectOf;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020050CA.SupplyEvent.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setSubjectOf(IncludesBean subjectOf) {
        this.subjectOf = subjectOf;
    }

}
