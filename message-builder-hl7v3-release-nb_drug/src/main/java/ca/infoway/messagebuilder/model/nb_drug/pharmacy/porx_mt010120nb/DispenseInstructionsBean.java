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
package ca.infoway.messagebuilder.model.nb_drug.pharmacy.porx_mt010120nb;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_drug.common.coct_mt040205nb.ResponsiblePersonBean;
import ca.infoway.messagebuilder.model.nb_drug.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.nb_drug.pharmacy.merged.DispenseShipToLocationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Dispense Instructions</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Sets the parameters within which the dispenser must 
 * operate in dispensing the medication to the patient.</p>
 * 
 * <p>Specification of how the prescribed medication is to be 
 * dispensed to the patient. Dispensed instruction information 
 * includes the quantity to be dispensed, how often the 
 * quantity is to be dispensed, etc.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010120NB.SupplyRequest"})
public class DispenseInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20150901L;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private List<ResponsiblePersonBean> receiverResponsibleParty = new ArrayList<ResponsiblePersonBean>();
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;
    private RecordedAtBean location;
    private List<DrugDispenseInstructionsBean> componentSupplyRequestItem = new ArrayList<DrugDispenseInstructionsBean>();


    /**
     * <p>Business Name: A:Dispensing Allowed Period</p>
     * 
     * <p>Relationship: PORX_MT010120NB.SupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ZPB3.9</p>
     * 
     * <p>DRU.040-02 (low, qualifier=07, format=102) 
     * eScript:DRU.040-02 (low, qualifier=36, format=102) 
     * HC-SA:Number of days (width) HC-SA:When will drug be 
     * administered?(low) PECS:ZDP.17 (high) PEI:Last date 
     * dispensed(when summary type is 'most recent')</p>
     * 
     * <p>Prescription.dispensingInterval(period)</p>
     * 
     * <p>Prescription.effectiveDate (low) 
     * PIN:Prescription.expiryDate (high)</p>
     * 
     * <p>Indicates when the Prescription becomes valid, and when 
     * it ceases to be a dispensable Prescription.</p><p>Some 
     * jurisdictions place a 'stale date' on prescriptions that 
     * cause them to become invalid a certain amount of time after 
     * they are written. This time may vary by medication.</p>
     * 
     * <p>This indicates the validity period of a prescription 
     * (stale dating the Prescription).</p><p>It reflects the 
     * prescriber perspective for the validity of the prescription. 
     * Dispenses must not be made against the prescription outside 
     * of this period. The lower-bound of the Prescription 
     * Effective Period signifies the earliest date that the 
     * prescription can be filled for the first time. If an 
     * upper-bound is not specified then the Prescription is 
     * open-ended or will default to a stale-date based on 
     * regulations.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: A:Dispensing Allowed Period</p>
     * 
     * <p>Relationship: PORX_MT010120NB.SupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ZPB3.9</p>
     * 
     * <p>DRU.040-02 (low, qualifier=07, format=102) 
     * eScript:DRU.040-02 (low, qualifier=36, format=102) 
     * HC-SA:Number of days (width) HC-SA:When will drug be 
     * administered?(low) PECS:ZDP.17 (high) PEI:Last date 
     * dispensed(when summary type is 'most recent')</p>
     * 
     * <p>Prescription.dispensingInterval(period)</p>
     * 
     * <p>Prescription.effectiveDate (low) 
     * PIN:Prescription.expiryDate (high)</p>
     * 
     * <p>Indicates when the Prescription becomes valid, and when 
     * it ceases to be a dispensable Prescription.</p><p>Some 
     * jurisdictions place a 'stale date' on prescriptions that 
     * cause them to become invalid a certain amount of time after 
     * they are written. This time may vary by medication.</p>
     * 
     * <p>This indicates the validity period of a prescription 
     * (stale dating the Prescription).</p><p>It reflects the 
     * prescriber perspective for the validity of the prescription. 
     * Dispenses must not be made against the prescription outside 
     * of this period. The lower-bound of the Prescription 
     * Effective Period signifies the earliest date that the 
     * prescription can be filled for the first time. If an 
     * upper-bound is not specified then the Prescription is 
     * open-ended or will default to a stale-date based on 
     * regulations.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Relationship: PORX_MT010120NB.Receiver.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"receiver/responsibleParty"})
    public List<ResponsiblePersonBean> getReceiverResponsibleParty() {
        return this.receiverResponsibleParty;
    }


    /**
     * <p>Relationship: 
     * PORX_MT010120NB.Destination1.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * PORX_MT010120NB.Destination1.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDestinationServiceDeliveryLocation(DispenseShipToLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: PORX_MT010120NB.SupplyRequest.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: PORX_MT010120NB.SupplyRequest.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: PORX_MT010120NB.Component.supplyRequestItem</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component/supplyRequestItem"})
    public List<DrugDispenseInstructionsBean> getComponentSupplyRequestItem() {
        return this.componentSupplyRequestItem;
    }

}
