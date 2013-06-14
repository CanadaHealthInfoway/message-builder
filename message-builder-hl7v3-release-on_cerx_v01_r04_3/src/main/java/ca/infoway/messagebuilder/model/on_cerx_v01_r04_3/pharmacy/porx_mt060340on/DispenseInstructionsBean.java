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
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.porx_mt060340on;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_SubstitutionConditionNoneOrUnconditional;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.coct_mt040205on.ResponsiblePersonBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.coct_mt240003on.ServiceLocationBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.merged.ExtendedDispenseInstructionsBean;
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
@Hl7PartTypeMapping({"PORX_MT060340ON.SupplyRequest"})
public class DispenseInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private List<ResponsiblePersonBean> receiverResponsibleParty = new ArrayList<ResponsiblePersonBean>();
    private AD destinationServiceDeliveryLocationAddr = new ADImpl();
    private IVL<TS, Interval<Date>> locationTime = new IVLImpl<TS, Interval<Date>>();
    private CV locationSubstitutionConditionCode = new CVImpl();
    private ServiceLocationBean locationServiceDeliveryLocation;
    private List<ExtendedDispenseInstructionsBean> componentSupplyRequestItem = new ArrayList<ExtendedDispenseInstructionsBean>();


    /**
     * <p>Business Name: Prescription Dispensable Indicator</p>
     * 
     * <p>Relationship: PORX_MT060340ON.SupplyRequest.statusCode</p>
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
     * <p>Relationship: PORX_MT060340ON.SupplyRequest.statusCode</p>
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
     * <p>Relationship: PORX_MT060340ON.SupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ZPB3.9</p>
     * 
     * <p>DRU.040-02 (low, qualifier=07, format=102)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=36, format=102)</p>
     * 
     * <p>Number of days (width)</p>
     * 
     * <p>When will drug be administered?(low)</p>
     * 
     * <p>ZDP.17 (high)</p>
     * 
     * <p>Last date dispensed(when summary type is 'most 
     * recent')</p>
     * 
     * <p>Prescription.dispensingInterval(period)</p>
     * 
     * <p>Prescription.effectiveDate (low)</p>
     * 
     * <p>Prescription.expiryDate (high)</p>
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
     * <p>Relationship: PORX_MT060340ON.SupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ZPB3.9</p>
     * 
     * <p>DRU.040-02 (low, qualifier=07, format=102)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=36, format=102)</p>
     * 
     * <p>Number of days (width)</p>
     * 
     * <p>When will drug be administered?(low)</p>
     * 
     * <p>ZDP.17 (high)</p>
     * 
     * <p>Last date dispensed(when summary type is 'most 
     * recent')</p>
     * 
     * <p>Prescription.dispensingInterval(period)</p>
     * 
     * <p>Prescription.effectiveDate (low)</p>
     * 
     * <p>Prescription.expiryDate (high)</p>
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
     * <p>Relationship: PORX_MT060340ON.Receiver.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"receiver/responsibleParty"})
    public List<ResponsiblePersonBean> getReceiverResponsibleParty() {
        return this.receiverResponsibleParty;
    }


    /**
     * <p>Business Name: H:Prescription Ship to Address</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.ServiceDeliveryLocation2.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some cases drugs need to be delivered to the patient 
     * instead of being picked up. In other cases, drugs need to be 
     * shipped to the physician's office to replace stock used for 
     * the patient.</p>
     * 
     * <p>Indicates the location the dispensed medication should be 
     * shipped to, at the request of the patient or provider.</p>
     */
    @Hl7XmlMapping({"destination/serviceDeliveryLocation/addr"})
    public PostalAddress getDestinationServiceDeliveryLocationAddr() {
        return this.destinationServiceDeliveryLocationAddr.getValue();
    }

    /**
     * <p>Business Name: H:Prescription Ship to Address</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.ServiceDeliveryLocation2.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some cases drugs need to be delivered to the patient 
     * instead of being picked up. In other cases, drugs need to be 
     * shipped to the physician's office to replace stock used for 
     * the patient.</p>
     * 
     * <p>Indicates the location the dispensed medication should be 
     * shipped to, at the request of the patient or provider.</p>
     */
    public void setDestinationServiceDeliveryLocationAddr(PostalAddress destinationServiceDeliveryLocationAddr) {
        this.destinationServiceDeliveryLocationAddr.setValue(destinationServiceDeliveryLocationAddr);
    }


    /**
     * <p>Business Name: To be picked up when</p>
     * 
     * <p>Relationship: PORX_MT060340ON.Location4.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows a prescriber to indicate to the targeted pharmacy, 
     * when patient will be expecting to pick up the dispensed 
     * medication.</p>
     * 
     * <p>The date and time on which the dispense is expected to be 
     * picked up.</p>
     */
    @Hl7XmlMapping({"location/time"})
    public Interval<Date> getLocationTime() {
        return this.locationTime.getValue();
    }

    /**
     * <p>Business Name: To be picked up when</p>
     * 
     * <p>Relationship: PORX_MT060340ON.Location4.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows a prescriber to indicate to the targeted pharmacy, 
     * when patient will be expecting to pick up the dispensed 
     * medication.</p>
     * 
     * <p>The date and time on which the dispense is expected to be 
     * picked up.</p>
     */
    public void setLocationTime(Interval<Date> locationTime) {
        this.locationTime.setValue(locationTime);
    }


    /**
     * <p>Business Name: Assigned Facility Not Reassignable 
     * Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.Location4.substitutionConditionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Influences whether the prescription may be transferred to 
     * a service delivery location other than the targeted 
     * dispenser.</p>
     * 
     * <p>Indicates whether a dispenser to whom the prescription is 
     * targeted is a mandated or patient-preferred pharmacy.</p>
     */
    @Hl7XmlMapping({"location/substitutionConditionCode"})
    public x_SubstitutionConditionNoneOrUnconditional getLocationSubstitutionConditionCode() {
        return (x_SubstitutionConditionNoneOrUnconditional) this.locationSubstitutionConditionCode.getValue();
    }

    /**
     * <p>Business Name: Assigned Facility Not Reassignable 
     * Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.Location4.substitutionConditionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Influences whether the prescription may be transferred to 
     * a service delivery location other than the targeted 
     * dispenser.</p>
     * 
     * <p>Indicates whether a dispenser to whom the prescription is 
     * targeted is a mandated or patient-preferred pharmacy.</p>
     */
    public void setLocationSubstitutionConditionCode(x_SubstitutionConditionNoneOrUnconditional locationSubstitutionConditionCode) {
        this.locationSubstitutionConditionCode.setValue(locationSubstitutionConditionCode);
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340ON.Location4.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060340ON.Location4.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340ON.Component3.supplyRequestItem</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component/supplyRequestItem"})
    public List<ExtendedDispenseInstructionsBean> getComponentSupplyRequestItem() {
        return this.componentSupplyRequestItem;
    }

}
