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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.porx_mt060340ca;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt040205ca.ResponsiblePersonBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged.Component3Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged.DispenseShipToLocationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Dispense Instructions</p>
 * 
 * <p>Specification of how the prescribed medication is to be 
 * dispensed to the patient. Dispensed instruction information 
 * includes the quantity to be dispensed, how often the 
 * quantity is to be dispensed, etc.</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Sets the parameters within which the dispenser must 
 * operate in dispensing the medication to the patient.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060340CA.SupplyRequest"})
public class DispenseInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private List<ResponsiblePersonBean> receiverResponsibleParty = new ArrayList<ResponsiblePersonBean>();
    private RecordedAtBean location;
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;
    private List<Component3Bean> component = new ArrayList<Component3Bean>();


    /**
     * <p>Business Name: Prescription Dispensable Indicator</p>
     * 
     * <p>Relationship: PORX_MT060340CA.SupplyRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This generally mirrors the status for the prescription, 
     * but in some circumstances may be changed to 'aborted' while 
     * the prescription is still active. When this occurs, it means 
     * the prescription may no longer be dispensed, though it may 
     * still be administered.</p>
     * 
     * <p>Allows a prescriber to say &quot;Finish what you have on 
     * hand, but don't get any more.&quot;</p><p>Because the status 
     * should always be known, this element is mandatory.</p>
     * 
     * <p>Allows a prescriber to say &quot;Finish what you have on 
     * hand, but don't get any more.&quot;</p><p>Because the status 
     * should always be known, this element is mandatory.</p>
     * 
     * <p><div>When a Revoke Dispensing transaction has</div> 
     * <div>been received against this prescription or the</div> 
     * <div>prescription has been renewed, then this will</div> 
     * <div>be ABORTED otherwise it will be the same as</div> 
     * <p>the prescription status.&nbsp;</p></p>
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
     * <p>This generally mirrors the status for the prescription, 
     * but in some circumstances may be changed to 'aborted' while 
     * the prescription is still active. When this occurs, it means 
     * the prescription may no longer be dispensed, though it may 
     * still be administered.</p>
     * 
     * <p>Allows a prescriber to say &quot;Finish what you have on 
     * hand, but don't get any more.&quot;</p><p>Because the status 
     * should always be known, this element is mandatory.</p>
     * 
     * <p>Allows a prescriber to say &quot;Finish what you have on 
     * hand, but don't get any more.&quot;</p><p>Because the status 
     * should always be known, this element is mandatory.</p>
     * 
     * <p><div>When a Revoke Dispensing transaction has</div> 
     * <div>been received against this prescription or the</div> 
     * <div>prescription has been renewed, then this will</div> 
     * <div>be ABORTED otherwise it will be the same as</div> 
     * <p>the prescription status.&nbsp;</p></p>
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
     * <p>This indicates the validity period of a prescription 
     * (stale dating the Prescription). It reflects the prescriber 
     * perspective for the validity of the prescription. Dispenses 
     * must not be made against the prescription outside of this 
     * period. The lower-bound of the Prescription Effective Period 
     * signifies the earliest date that the prescription can be 
     * filled for the first time. If an upper-bound is not 
     * specified then the Prescription is open-ended or will 
     * default to a stale-date based on regulations.</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>Indicates when the Order becomes valid, and when it 
     * ceases to be an actionable Order. Some jurisdictions place a 
     * 'stale date' on prescriptions that cause them to become 
     * invalid a certain amount of time after they are written. 
     * This time may vary by medication.</p>
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
     * <p>This indicates the validity period of a prescription 
     * (stale dating the Prescription). It reflects the prescriber 
     * perspective for the validity of the prescription. Dispenses 
     * must not be made against the prescription outside of this 
     * period. The lower-bound of the Prescription Effective Period 
     * signifies the earliest date that the prescription can be 
     * filled for the first time. If an upper-bound is not 
     * specified then the Prescription is open-ended or will 
     * default to a stale-date based on regulations.</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>ZPB3.9</p><p>DRU.040-02 (low, qualifier=07, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=36, 
     * format=102)</p><p>Number of days (width)</p><p>When will 
     * drug be administered?(low)</p><p>ZDP.17 (high)</p><p>Last 
     * date dispensed(when summary type is 'most 
     * recent')</p><p>Prescription.dispensingInterval(period)</p><p>Prescription.effectiveDate 
     * (low)</p><p>Prescription.expiryDate (high)</p>
     * 
     * <p>Indicates when the Order becomes valid, and when it 
     * ceases to be an actionable Order. Some jurisdictions place a 
     * 'stale date' on prescriptions that cause them to become 
     * invalid a certain amount of time after they are written. 
     * This time may vary by medication.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Relationship: PORX_MT060340CA.Receiver.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"receiver/responsibleParty"})
    public List<ResponsiblePersonBean> getReceiverResponsibleParty() {
        return this.receiverResponsibleParty;
    }


    /**
     * <p>Relationship: PORX_MT060340CA.SupplyRequest.location</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;Indicates the pharmacy to which the 
     * prescription</p> <div>has been directed or which has 
     * currently assumed</div> <div>responsibility for dispensing 
     * the prescription.</div>
     */
    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: PORX_MT060340CA.SupplyRequest.location</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;Indicates the pharmacy to which the 
     * prescription</p> <div>has been directed or which has 
     * currently assumed</div> <div>responsibility for dispensing 
     * the prescription.</div>
     */
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.Destination1.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060340CA.Destination1.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setDestinationServiceDeliveryLocation(DispenseShipToLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: PORX_MT060340CA.SupplyRequest.component</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1-5)</p>
     * 
     * <p><div>Identifies the instructions for how the 
     * prescribed</div> <div>medication should be dispensed to the 
     * patient.</div> <div>Multiple repetitions are included to 
     * accommodate</div> <div>circumstances where multiple drug 
     * products may</div> <div>need to be dispensed to complete a 
     * therapy. E.g.</div> <p>100 x 20mg tablets and 50 x 10mg 
     * tablets.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"component"})
    public List<Component3Bean> getComponent() {
        return this.component;
    }

}
