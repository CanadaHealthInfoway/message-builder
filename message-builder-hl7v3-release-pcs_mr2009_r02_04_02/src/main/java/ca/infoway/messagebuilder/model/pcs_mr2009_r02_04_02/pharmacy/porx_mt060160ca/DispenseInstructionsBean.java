/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.porx_mt060160ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.OccurredAtBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.RelatedPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged.Component3Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged.DispenseShipToLocationBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Dispense Instructions</p>
 * 
 * <p><p>Specification of how the prescribed medication is to 
 * be dispensed to the patient. Dispensed instruction 
 * information includes the quantity to be dispensed, how often 
 * the quantity is to be dispensed, etc.</p></p>
 * 
 * <p><p>Sets the parameters within which the dispenser must 
 * operate in dispensing the medication to the patient.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060160CA.SupplyRequest"})
public class DispenseInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CS prescriptionDispensableIndicator = new CSImpl();
    private IVL<TS, Interval<Date>> dispensingAllowedPeriod = new IVLImpl<TS, Interval<Date>>();
    private List<RelatedPersonBean> receiverPersonalRelationship = new ArrayList<RelatedPersonBean>();
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;
    private OccurredAtBean location;
    private List<Component3Bean> component = new ArrayList<Component3Bean>();


    /**
     * <p>Prescription Dispensable Indicator</p>
     * 
     * <p><p>This generally mirrors the status for the 
     * prescription, but in some circumstances may be changed to 
     * 'aborted' while the prescription is still active. When this 
     * occurs, it means the prescription may no longer be 
     * dispensed, though it may still be administered.</p></p>
     * 
     * <p><p>Allows a prescriber to say &quot;Finish what you have 
     * on hand, but don't get any more.&quot;</p><p>Because the 
     * status should always be known, this element is 
     * mandatory.</p></p>
     * 
     * <p><p>Allows a prescriber to say &quot;Finish what you have 
     * on hand, but don't get any more.&quot;</p><p>Because the 
     * status should always be known, this element is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getPrescriptionDispensableIndicator() {
        return (ActStatus) this.prescriptionDispensableIndicator.getValue();
    }
    public void setPrescriptionDispensableIndicator(ActStatus prescriptionDispensableIndicator) {
        this.prescriptionDispensableIndicator.setValue(prescriptionDispensableIndicator);
    }


    /**
     * <p>A:Dispensing Allowed Period</p>
     * 
     * <p><p>This indicates the validity period of a prescription 
     * (stale dating the Prescription). It reflects the prescriber 
     * perspective for the validity of the prescription. Dispenses 
     * must not be made against the prescription outside of this 
     * period. The lower-bound of the Prescription Effective Period 
     * signifies the earliest date that the prescription can be 
     * filled for the first time. If an upper-bound is not 
     * specified then the Prescription is open-ended or will 
     * default to a stale-date based on regulations.</p></p>
     * 
     * <p><p>Indicates when the Order becomes valid, and when it 
     * ceases to be an actionable Order. Some jurisdictions place a 
     * 'stale date' on prescriptions that cause them to become 
     * invalid a certain amount of time after they are written. 
     * This time may vary by medication.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDispensingAllowedPeriod() {
        return this.dispensingAllowedPeriod.getValue();
    }
    public void setDispensingAllowedPeriod(Interval<Date> dispensingAllowedPeriod) {
        this.dispensingAllowedPeriod.setValue(dispensingAllowedPeriod);
    }


    @Hl7XmlMapping({"receiver/personalRelationship"})
    public List<RelatedPersonBean> getReceiverPersonalRelationship() {
        return this.receiverPersonalRelationship;
    }


    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }
    public void setDestinationServiceDeliveryLocation(DispenseShipToLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"component"})
    public List<Component3Bean> getComponent() {
        return this.component;
    }

}
