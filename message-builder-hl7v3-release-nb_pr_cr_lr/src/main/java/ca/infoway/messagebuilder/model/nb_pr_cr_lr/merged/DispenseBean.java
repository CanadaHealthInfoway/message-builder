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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActPharmacySupplyType;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt260020ca.InFulfillmentOfBean;
import java.util.Date;
import java.util.Set;



/**
 * <p>Business Name: Dispense</p>
 * 
 * <p>COCT_MT260010CA.SupplyEvent: Dispense</p>
 * 
 * <p>Used when the issue pertains to the supply of the drug 
 * rather than the drug itself. E.g. Duplicate pharmacy, refill 
 * too soon, etc.</p>
 * 
 * <p>Indicates a particular dispense event that resulted in 
 * the issue.</p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.SupplyEvent","COCT_MT260020CA.SupplyEvent","PORX_MT020070CA.SupplyEvent"})
public class DispenseBean extends MessagePartBean implements ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt260020ca.CausalActs, ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt260010ca.CausalActs {

    private static final long serialVersionUID = 20151013L;
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private INT repeatNumber = new INTImpl();
    private PQ quantity = new PQImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();
    private DispensedBean product;
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;
    private II id = new IIImpl();
    private CS statusCode = new CSImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private TargetedToPharmacyBean location;
    private InFulfillmentOfBean inFulfillmentOf;


    /**
     * <p>Business Name: DispenseType</p>
     * 
     * <p>Un-merged Business Name: DispenseType</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates reason for the size of dispense. Because it 
     * defines what type of dispense is occurring, the attribute is 
     * mandatory.</p>
     * 
     * <p>Indicates the type of dispensing event that is performed. 
     * Examples include: Trial Fill, Completion of Trial, Partial 
     * Fill, Emergency Fill, Samples, etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActPharmacySupplyType getCode() {
        return (ActPharmacySupplyType) this.code.getValue();
    }

    /**
     * <p>Business Name: DispenseType</p>
     * 
     * <p>Un-merged Business Name: DispenseType</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates reason for the size of dispense. Because it 
     * defines what type of dispense is occurring, the attribute is 
     * mandatory.</p>
     * 
     * <p>Indicates the type of dispensing event that is performed. 
     * Examples include: Trial Fill, Completion of Trial, Partial 
     * Fill, Emergency Fill, Samples, etc.</p>
     */
    public void setCode(ActPharmacySupplyType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: DispenseProcessingAndPickupDate</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking. This attribute is 
     * mandatory because an existing dispense record must at least 
     * indicate the date it was processed.</p>
     * 
     * <p>Must be able to post-date a dispense (enter 
     * retroactively) e.g. system failure.</p>
     * 
     * <p>Represents the date the dispense product was prepared and 
     * when the product was picked up by or delivered to the 
     * patient. The dispense processing date and pickup date can be 
     * back dated to reflect when the actual processing and pickup 
     * occurred. The lower-bound of the period signifies the 
     * dispense-processing date whereas the upper-bound signifies 
     * the dispense-pickup date.</p>
     * 
     * <p>Un-merged Business Name: DispensedDate</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>ZDU.4.5</p>
     * 
     * <p>Allows evaluation of 'refill too soon' and similar 
     * issues.</p><p>Attribute is marked as 'populated' as a 
     * dispense record may not exist without processing date.</p>
     * 
     * <p>Applications should specify a null flavor of &quot;Not 
     * Applicable&quot; for dispenses that have not yet been picked 
     * up.</p>
     * 
     * <p>The date and time on which the product was issued to the 
     * patient.</p>
     * 
     * <p>Un-merged Business Name: DispensedDate</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Un-merged Business Name: DispenseProcessingAndPickupDate</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking. This attribute is 
     * mandatory because an existing dispense record must at least 
     * indicate the date it was processed.</p>
     * 
     * <p>Must be able to post-date a dispense (enter 
     * retroactively) e.g. system failure.</p>
     * 
     * <p>Represents the date the dispense product was prepared and 
     * when the product was picked up by or delivered to the 
     * patient. The dispense processing date and pickup date can be 
     * back dated to reflect when the actual processing and pickup 
     * occurred. The lower-bound of the period signifies the 
     * dispense-processing date whereas the upper-bound signifies 
     * the dispense-pickup date.</p>
     * 
     * <p>Un-merged Business Name: DispensedDate</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>ZDU.4.5</p>
     * 
     * <p>Allows evaluation of 'refill too soon' and similar 
     * issues.</p><p>Attribute is marked as 'populated' as a 
     * dispense record may not exist without processing date.</p>
     * 
     * <p>Applications should specify a null flavor of &quot;Not 
     * Applicable&quot; for dispenses that have not yet been picked 
     * up.</p>
     * 
     * <p>The date and time on which the product was issued to the 
     * patient.</p>
     * 
     * <p>Un-merged Business Name: DispensedDate</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: NumberOfRemainingFills</p>
     * 
     * <p>Un-merged Business Name: NumberOfRemainingFills</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The number of remaining fills is used to evaluate the 
     * &quot;completed&quot; status of the prescription.</p>
     * 
     * <p>Indicates the number or remaining fills, if any, for this 
     * prescription.</p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getRepeatNumber() {
        return this.repeatNumber.getValue();
    }

    /**
     * <p>Business Name: NumberOfRemainingFills</p>
     * 
     * <p>Un-merged Business Name: NumberOfRemainingFills</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The number of remaining fills is used to evaluate the 
     * &quot;completed&quot; status of the prescription.</p>
     * 
     * <p>Indicates the number or remaining fills, if any, for this 
     * prescription.</p>
     */
    public void setRepeatNumber(Integer repeatNumber) {
        this.repeatNumber.setValue(repeatNumber);
    }


    /**
     * <p>Business Name: DispensedQuantity</p>
     * 
     * <p>Un-merged Business Name: DispensedQuantity</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Critical in understanding the patient's medication 
     * profile, both past and current, This is also mandatory to 
     * allow determination of the amount that remains to be 
     * dispensed against the prescription.</p>
     * 
     * <p>The amount of medication that has been dispensed. 
     * Includes unit of measure.</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Business Name: DispensedQuantity</p>
     * 
     * <p>Un-merged Business Name: DispensedQuantity</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Critical in understanding the patient's medication 
     * profile, both past and current, This is also mandatory to 
     * allow determination of the amount that remains to be 
     * dispensed against the prescription.</p>
     * 
     * <p>The amount of medication that has been dispensed. 
     * Includes unit of measure.</p>
     */
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>Business Name: DispensedDaysSupply</p>
     * 
     * <p>Un-merged Business Name: DispensedDaysSupply</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p>
     * 
     * <p>The number of days that the dispensed quantity is 
     * expected to last.</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }

    /**
     * <p>Business Name: DispensedDaysSupply</p>
     * 
     * <p>Un-merged Business Name: DispensedDaysSupply</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p>
     * 
     * <p>The number of days that the dispensed quantity is 
     * expected to last.</p>
     */
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.product</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.product</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.product</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"product"})
    public DispensedBean getProduct() {
        return this.product;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.product</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.product</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.product</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setProduct(DispensedBean product) {
        this.product = product;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.Destination2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.Destination2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDestinationServiceDeliveryLocation(DispenseShipToLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }


    /**
     * <p>Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows provider to drill down and retrieve additional 
     * information about the dispense event for consideration in 
     * their issue management decision.</p>
     * 
     * <p>Unique identifier of the dispensed event that triggered 
     * the issue.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows provider to drill down and retrieve additional 
     * information about the dispense event for consideration in 
     * their issue management decision.</p>
     * 
     * <p>Unique identifier of the dispensed event that triggered 
     * the issue.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: DispenseStatus</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: DispenseStatus</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Un-merged Business Name: DispenseMaskingIndicator</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010CA.SupplyEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     * 
     * <p>Conveys the patient's wishes relating to the sensitivity 
     * of the drug information.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p>An indication of sensitivity surrounding the related 
     * drug, and thus defines the required sensitivity for the 
     * detected issue.</p>
     * 
     * <p>Un-merged Business Name: DispenseMaskedIndicator</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020CA.SupplyEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public TargetedToPharmacyBean getLocation() {
        return this.location;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setLocation(TargetedToPharmacyBean location) {
        this.location = location;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.inFulfillmentOf</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf"})
    public InFulfillmentOfBean getInFulfillmentOf() {
        return this.inFulfillmentOf;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.inFulfillmentOf</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setInFulfillmentOf(InFulfillmentOfBean inFulfillmentOf) {
        this.inFulfillmentOf = inFulfillmentOf;
    }

}
