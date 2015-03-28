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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.porx_mt010120ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt910107ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.DispenseShipToLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.TargetedToPharmacyBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Dispense Instructions</p>
 * 
 * <p>Sets the parameters within which the dispenser must 
 * operate in dispensing the medication to the patient.</p>
 * 
 * <p>Specification of how the prescribed medication is to be 
 * dispensed to the patient. Dispensed instruction information 
 * includes the quantity to be dispensed, how often the 
 * quantity is to be dispensed, etc.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.SupplyRequest"})
public class DispenseInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private List<RelatedPersonBean> receiverPersonalRelationship = new ArrayList<RelatedPersonBean>();
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;
    private TargetedToPharmacyBean location;
    private List<DrugDispenseInstructionsBean> componentSupplyRequestItem = new ArrayList<DrugDispenseInstructionsBean>();


    /**
     * <p>Business Name: A:Dispensing Allowed Period</p>
     * 
     * <p>Relationship: PORX_MT010120CA.SupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
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
     * <p>Relationship: PORX_MT010120CA.SupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
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
     * <p>Relationship: 
     * PORX_MT010120CA.Receiver.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"receiver/personalRelationship"})
    public List<RelatedPersonBean> getReceiverPersonalRelationship() {
        return this.receiverPersonalRelationship;
    }


    /**
     * <p>Relationship: 
     * PORX_MT010120CA.Destination1.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * PORX_MT010120CA.Destination1.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDestinationServiceDeliveryLocation(DispenseShipToLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: PORX_MT010120CA.SupplyRequest.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public TargetedToPharmacyBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: PORX_MT010120CA.SupplyRequest.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setLocation(TargetedToPharmacyBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: PORX_MT010120CA.Component.supplyRequestItem</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component/supplyRequestItem"})
    public List<DrugDispenseInstructionsBean> getComponentSupplyRequestItem() {
        return this.componentSupplyRequestItem;
    }

}
