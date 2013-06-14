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
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.x_SubstitutionConditionNoneOrUnconditional;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.DispenseShipToLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.RelatedPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.ServiceLocationBean;
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

    private static final long serialVersionUID = 20130613L;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private List<RelatedPersonBean> receiverPersonalRelationship = new ArrayList<RelatedPersonBean>();
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;
    private IVL<TS, Interval<Date>> locationTime = new IVLImpl<TS, Interval<Date>>();
    private CV locationSubstitutionConditionCode = new CVImpl();
    private ServiceLocationBean locationServiceDeliveryLocation;
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
     * <p>Business Name: to be picked up when</p>
     * 
     * <p>Relationship: PORX_MT010120CA.Location2.time</p>
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
     * <p>Business Name: to be picked up when</p>
     * 
     * <p>Relationship: PORX_MT010120CA.Location2.time</p>
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
     * <p>Business Name: Dispense Facility Not Reassignable</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.Location2.substitutionConditionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Influences whether the prescription may be transferred to 
     * a service delivery location other than the targeted 
     * dispenser.</p>
     * 
     * <p>Indicates a 'hard' or 'soft' assignment of dispensing 
     * priviledged to the targetted facility.</p><p>'Hard' 
     * assignment (mandated facility) indicates that the 
     * prescription can be dispensed only at that 
     * facility.</p><p>'Soft' assignment (usually as a patient 
     * directive) indicates that the prescription may be dispensed 
     * at facilities other than the targeted facility.</p>
     */
    @Hl7XmlMapping({"location/substitutionConditionCode"})
    public x_SubstitutionConditionNoneOrUnconditional getLocationSubstitutionConditionCode() {
        return (x_SubstitutionConditionNoneOrUnconditional) this.locationSubstitutionConditionCode.getValue();
    }

    /**
     * <p>Business Name: Dispense Facility Not Reassignable</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.Location2.substitutionConditionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Influences whether the prescription may be transferred to 
     * a service delivery location other than the targeted 
     * dispenser.</p>
     * 
     * <p>Indicates a 'hard' or 'soft' assignment of dispensing 
     * priviledged to the targetted facility.</p><p>'Hard' 
     * assignment (mandated facility) indicates that the 
     * prescription can be dispensed only at that 
     * facility.</p><p>'Soft' assignment (usually as a patient 
     * directive) indicates that the prescription may be dispensed 
     * at facilities other than the targeted facility.</p>
     */
    public void setLocationSubstitutionConditionCode(x_SubstitutionConditionNoneOrUnconditional locationSubstitutionConditionCode) {
        this.locationSubstitutionConditionCode.setValue(locationSubstitutionConditionCode);
    }


    /**
     * <p>Relationship: 
     * PORX_MT010120CA.Location2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * PORX_MT010120CA.Location2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
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
