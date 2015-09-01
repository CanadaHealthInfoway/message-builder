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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.porx_mt060340ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt910107ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged.DispenseShipToLocationBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged.TargetedToPharmacyBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.merged.Component3Bean;
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
@Hl7PartTypeMapping({"PORX_MT060340CA.SupplyRequest"})
public class DispenseInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20150901L;
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private List<RelatedPersonBean> receiverPersonalRelationship = new ArrayList<RelatedPersonBean>();
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;
    private TargetedToPharmacyBean location;
    private List<Component3Bean> component = new ArrayList<Component3Bean>();


    /**
     * <p>Business Name: Prescription Dispensable Indicator</p>
     * 
     * <p>Relationship: PORX_MT060340CA.SupplyRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a prescriber to say &quot;Finish what you have on 
     * hand, but don't get any more.&quot;</p><p>Because the status 
     * should always be known, this element is mandatory.</p>
     * 
     * <p>This generally mirrors the status for the prescription, 
     * but in some circumstances may be changed to 'aborted' while 
     * the prescription is still active. When this occurs, it means 
     * the prescription may no longer be dispensed, though it may 
     * still be administered.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Prescription Dispensable Indicator</p>
     * 
     * <p>Relationship: PORX_MT060340CA.SupplyRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a prescriber to say &quot;Finish what you have on 
     * hand, but don't get any more.&quot;</p><p>Because the status 
     * should always be known, this element is mandatory.</p>
     * 
     * <p>This generally mirrors the status for the prescription, 
     * but in some circumstances may be changed to 'aborted' while 
     * the prescription is still active. When this occurs, it means 
     * the prescription may no longer be dispensed, though it may 
     * still be administered.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: A:Dispensing Allowed Period</p>
     * 
     * <p>Relationship: PORX_MT060340CA.SupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates when the Order becomes valid, and when it 
     * ceases to be an actionable Order. Some jurisdictions place a 
     * 'stale date' on prescriptions that cause them to become 
     * invalid a certain amount of time after they are written. 
     * This time may vary by medication.</p>
     * 
     * <p>This indicates the validity period of a prescription 
     * (stale dating the Prescription). It reflects the prescriber 
     * perspective for the validity of the prescription. Dispenses 
     * must not be made against the prescription outside of this 
     * period. The lower-bound of the Prescription Effective Period 
     * signifies the earliest date that the prescription can be 
     * filled for the first time. If an upper-bound is not 
     * specified then the Prescription is open-ended or will 
     * default to a stale-date based on regulations.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: A:Dispensing Allowed Period</p>
     * 
     * <p>Relationship: PORX_MT060340CA.SupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates when the Order becomes valid, and when it 
     * ceases to be an actionable Order. Some jurisdictions place a 
     * 'stale date' on prescriptions that cause them to become 
     * invalid a certain amount of time after they are written. 
     * This time may vary by medication.</p>
     * 
     * <p>This indicates the validity period of a prescription 
     * (stale dating the Prescription). It reflects the prescriber 
     * perspective for the validity of the prescription. Dispenses 
     * must not be made against the prescription outside of this 
     * period. The lower-bound of the Prescription Effective Period 
     * signifies the earliest date that the prescription can be 
     * filled for the first time. If an upper-bound is not 
     * specified then the Prescription is open-ended or will 
     * default to a stale-date based on regulations.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.Receiver.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"receiver/personalRelationship"})
    public List<RelatedPersonBean> getReceiverPersonalRelationship() {
        return this.receiverPersonalRelationship;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.Destination1.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060340CA.Destination1.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDestinationServiceDeliveryLocation(DispenseShipToLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: PORX_MT060340CA.SupplyRequest.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public TargetedToPharmacyBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: PORX_MT060340CA.SupplyRequest.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setLocation(TargetedToPharmacyBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: PORX_MT060340CA.SupplyRequest.component</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-5)</p>
     */
    @Hl7XmlMapping({"component"})
    public List<Component3Bean> getComponent() {
        return this.component;
    }

}
