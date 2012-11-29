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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.porx_mt020050ca;

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
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.SupplyOrderBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.coct_mt220200ca.DrugProductBean;
import java.util.Date;



/**
 * <p>Office Supply</p>
 * 
 * <p>This is the detailed information about a medication being 
 * supplied for office use.</p>
 * 
 * <p>Allows for tracking of medications supplied to an 
 * office.</p>
 */
@Hl7PartTypeMapping({"PORX_MT020050CA.SupplyEvent"})
@Hl7RootType
public class OfficeSupplyBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();
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
     * <p>Identifier assigned by the dispensing facility.</p>
     * 
     * <p>Allows formal tracking of centrally recorded dispenses to 
     * local records for audit and related purposes.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>A:Local Dispense ID</p>
     * 
     * <p>Identifier assigned by the dispensing facility.</p>
     * 
     * <p>Allows formal tracking of centrally recorded dispenses to 
     * local records for audit and related purposes.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Dispense Type</p>
     * 
     * <p>Indicates the type of dispensing event that is being 
     * performed.</p><p>This is a fixed dispense type of 'Office 
     * Supply' unless using SNOMED.</p>
     * 
     * <p>Indicates the type of dispensing event that is being 
     * performed.</p><p>This is a fixed dispense type of 'Office 
     * Supply' unless using SNOMED.</p>
     * 
     * <p>Indicates reason for the size of dispense. Because it 
     * defines what type of dispense is occurring, the attribute is 
     * mandatory.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Dispense Type</p>
     * 
     * <p>Indicates the type of dispensing event that is being 
     * performed.</p><p>This is a fixed dispense type of 'Office 
     * Supply' unless using SNOMED.</p>
     * 
     * <p>Indicates the type of dispensing event that is being 
     * performed.</p><p>This is a fixed dispense type of 'Office 
     * Supply' unless using SNOMED.</p>
     * 
     * <p>Indicates reason for the size of dispense. Because it 
     * defines what type of dispense is occurring, the attribute is 
     * mandatory.</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>A:Supply Date</p>
     * 
     * <p>Represents the date medication was supplied.</p>
     * 
     * <p>Needed for audit purposes.</p><p>Because the supply date 
     * is always known, the attribute is mandatory.</p>
     * 
     * <p>Needed for audit purposes.</p><p>Because the supply date 
     * is always known, the attribute is mandatory.</p>
     * 
     * <p>Must be able to post date a dispense (enter 
     * retroactively) e.g. system failure</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>A:Supply Date</p>
     * 
     * <p>Represents the date medication was supplied.</p>
     * 
     * <p>Needed for audit purposes.</p><p>Because the supply date 
     * is always known, the attribute is mandatory.</p>
     * 
     * <p>Needed for audit purposes.</p><p>Because the supply date 
     * is always known, the attribute is mandatory.</p>
     * 
     * <p>Must be able to post date a dispense (enter 
     * retroactively) e.g. system failure</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>B:Supplied Quantity</p>
     * 
     * <p>The amount of medication that has been dispensed. 
     * Includes unit of measure.</p>
     * 
     * <p>Allows for auditing of medication dispensed to an office. 
     * This is mandatory to allow reconciliation with the amount 
     * used from the office.</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>B:Supplied Quantity</p>
     * 
     * <p>The amount of medication that has been dispensed. 
     * Includes unit of measure.</p>
     * 
     * <p>Allows for auditing of medication dispensed to an office. 
     * This is mandatory to allow reconciliation with the amount 
     * used from the office.</p>
     */
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
     * <p>C:Ship-to Facility Id</p>
     * 
     * <p>Identifier of the facility where the dispensed medication 
     * was shipped.</p>
     * 
     * <p>Allows tracking what drugs are dispensed to a facility. 
     * The attribute is mandatory because identification of the 
     * facility must be known.</p>
     */
    @Hl7XmlMapping({"destination/serviceDeliveryLocation/id"})
    public Identifier getDestinationServiceDeliveryLocationId() {
        return this.destinationServiceDeliveryLocationId.getValue();
    }

    /**
     * <p>C:Ship-to Facility Id</p>
     * 
     * <p>Identifier of the facility where the dispensed medication 
     * was shipped.</p>
     * 
     * <p>Allows tracking what drugs are dispensed to a facility. 
     * The attribute is mandatory because identification of the 
     * facility must be known.</p>
     */
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
