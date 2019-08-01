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
package ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.pharmacy.porx_mt020050ca;

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
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.common.coct_mt220200ca.DrugProductBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.pharmacy.merged.SupplyOrderBean;
import java.util.Date;



/**
 * <p>Business Name: Office Supply</p>
 * 
 * <p>Allows for tracking of medications supplied to an 
 * office.</p>
 * 
 * <p>This is the detailed information about a medication being 
 * supplied for office use.</p>
 */
@Hl7PartTypeMapping({"PORX_MT020050CA.SupplyEvent"})
@Hl7RootType
public class OfficeSupplyBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private TS effectiveTime = new TSImpl();
    private PQ quantity = new PQImpl();
    private DrugProductBean productMedication;
    private II destinationServiceDeliveryLocationId = new IIImpl();
    private SupplyOrderBean fulfillmentSupplyRequest;
    private NotesBean subjectOfAnnotation;


    /**
     * <p>Business Name: A:Local Dispense ID</p>
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
     * <p>Business Name: A:Local Dispense ID</p>
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
     * <p>Business Name: Dispense Type</p>
     * 
     * <p>Relationship: PORX_MT020050CA.SupplyEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>DispensedItem.activityType</p>
     * 
     * <p>D52</p>
     * 
     * <p>ZDP.2</p>
     * 
     * <p>Claim.403-D3</p>
     * 
     * <p>Claim.343-HD</p>
     * 
     * <p>A_BillablePharmacyDispense</p>
     * 
     * <p>Indicates reason for the size of dispense. Because it 
     * defines what type of dispense is occurring, the attribute is 
     * mandatory.</p>
     * 
     * <p>Indicates the type of dispensing event that is being 
     * performed.</p><p>This is a fixed dispense type of 'Office 
     * Supply' unless using SNOMED.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Dispense Type</p>
     * 
     * <p>Relationship: PORX_MT020050CA.SupplyEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>DispensedItem.activityType</p>
     * 
     * <p>D52</p>
     * 
     * <p>ZDP.2</p>
     * 
     * <p>Claim.403-D3</p>
     * 
     * <p>Claim.343-HD</p>
     * 
     * <p>A_BillablePharmacyDispense</p>
     * 
     * <p>Indicates reason for the size of dispense. Because it 
     * defines what type of dispense is occurring, the attribute is 
     * mandatory.</p>
     * 
     * <p>Indicates the type of dispensing event that is being 
     * performed.</p><p>This is a fixed dispense type of 'Office 
     * Supply' unless using SNOMED.</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: A:Supply Date</p>
     * 
     * <p>Relationship: PORX_MT020050CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ZPB3.9</p>
     * 
     * <p>ZDP.17 (high)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=07, format=102)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=36, format=102)</p>
     * 
     * <p>A_BillablePharmacyDispense</p>
     * 
     * <p>Dispense Date</p>
     * 
     * <p>Dispense Date</p>
     * 
     * <p>DispensedItem.dispenseDate</p>
     * 
     * <p>A_BillablePharmacyDispense</p>
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
     * <p>Business Name: A:Supply Date</p>
     * 
     * <p>Relationship: PORX_MT020050CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ZPB3.9</p>
     * 
     * <p>ZDP.17 (high)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=07, format=102)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=36, format=102)</p>
     * 
     * <p>A_BillablePharmacyDispense</p>
     * 
     * <p>Dispense Date</p>
     * 
     * <p>Dispense Date</p>
     * 
     * <p>DispensedItem.dispenseDate</p>
     * 
     * <p>A_BillablePharmacyDispense</p>
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
     * <p>Business Name: B:Supplied Quantity</p>
     * 
     * <p>Relationship: PORX_MT020050CA.SupplyEvent.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>D58</p>
     * 
     * <p>ZPB3.4</p>
     * 
     * <p>ZDP.10.1</p>
     * 
     * <p>ZDP.10.2.1 (the fact that it is package is determined by 
     * a playing entity)</p>
     * 
     * <p>ZDP.9.1</p>
     * 
     * <p>ZDP.9.2.1 (the fact that it is package is determined by a 
     * playing entity)</p>
     * 
     * <p>DRU.020-01 (Unit, qualifier=38 0r 87)</p>
     * 
     * <p>DRU.020-02 (Quantity, qualifier=38 0r 87)</p>
     * 
     * <p>DRU.020-03 (qualifier=38 0r 87)</p>
     * 
     * <p>Claim.442-E7</p>
     * 
     * <p>Claim.460-ET</p>
     * 
     * <p>Claim.600-28</p>
     * 
     * <p>A_BillablePharmacyDispense</p>
     * 
     * <p>Quantity</p>
     * 
     * <p>DispensedItem.dispensedAmount</p>
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
     * <p>Business Name: B:Supplied Quantity</p>
     * 
     * <p>Relationship: PORX_MT020050CA.SupplyEvent.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>D58</p>
     * 
     * <p>ZPB3.4</p>
     * 
     * <p>ZDP.10.1</p>
     * 
     * <p>ZDP.10.2.1 (the fact that it is package is determined by 
     * a playing entity)</p>
     * 
     * <p>ZDP.9.1</p>
     * 
     * <p>ZDP.9.2.1 (the fact that it is package is determined by a 
     * playing entity)</p>
     * 
     * <p>DRU.020-01 (Unit, qualifier=38 0r 87)</p>
     * 
     * <p>DRU.020-02 (Quantity, qualifier=38 0r 87)</p>
     * 
     * <p>DRU.020-03 (qualifier=38 0r 87)</p>
     * 
     * <p>Claim.442-E7</p>
     * 
     * <p>Claim.460-ET</p>
     * 
     * <p>Claim.600-28</p>
     * 
     * <p>A_BillablePharmacyDispense</p>
     * 
     * <p>Quantity</p>
     * 
     * <p>DispensedItem.dispensedAmount</p>
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
     * <p>Relationship: PORX_MT020050CA.Product2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"product/medication"})
    public DrugProductBean getProductMedication() {
        return this.productMedication;
    }

    /**
     * <p>Relationship: PORX_MT020050CA.Product2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setProductMedication(DrugProductBean productMedication) {
        this.productMedication = productMedication;
    }


    /**
     * <p>Business Name: C:Ship-to Facility Id</p>
     * 
     * <p>Relationship: PORX_MT020050CA.ServiceDeliveryLocation.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows tracking what drugs are dispensed to a facility. 
     * The attribute is mandatory because identification of the 
     * facility must be known.</p>
     * 
     * <p>Identifier of the facility where the dispensed medication 
     * was shipped.</p>
     */
    @Hl7XmlMapping({"destination/serviceDeliveryLocation/id"})
    public Identifier getDestinationServiceDeliveryLocationId() {
        return this.destinationServiceDeliveryLocationId.getValue();
    }

    /**
     * <p>Business Name: C:Ship-to Facility Id</p>
     * 
     * <p>Relationship: PORX_MT020050CA.ServiceDeliveryLocation.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows tracking what drugs are dispensed to a facility. 
     * The attribute is mandatory because identification of the 
     * facility must be known.</p>
     * 
     * <p>Identifier of the facility where the dispensed medication 
     * was shipped.</p>
     */
    public void setDestinationServiceDeliveryLocationId(Identifier destinationServiceDeliveryLocationId) {
        this.destinationServiceDeliveryLocationId.setValue(destinationServiceDeliveryLocationId);
    }


    /**
     * <p>Relationship: 
     * PORX_MT020050CA.InFulfillmentOf.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"fulfillment/supplyRequest"})
    public SupplyOrderBean getFulfillmentSupplyRequest() {
        return this.fulfillmentSupplyRequest;
    }

    /**
     * <p>Relationship: 
     * PORX_MT020050CA.InFulfillmentOf.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setFulfillmentSupplyRequest(SupplyOrderBean fulfillmentSupplyRequest) {
        this.fulfillmentSupplyRequest = fulfillmentSupplyRequest;
    }


    /**
     * <p>Relationship: PORX_MT020050CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/annotation"})
    public NotesBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }

    /**
     * <p>Relationship: PORX_MT020050CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOfAnnotation(NotesBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }

}
