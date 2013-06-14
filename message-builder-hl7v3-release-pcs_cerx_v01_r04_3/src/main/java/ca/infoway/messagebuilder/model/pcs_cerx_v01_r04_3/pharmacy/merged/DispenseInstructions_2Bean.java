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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_SubstitutionConditionNoneOrUnconditional;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt240003ca.ServiceLocationBean;
import java.util.Date;



/**
 * <p>Business Name: DispenseInstructions</p>
 * 
 * <p>PORX_MT030040CA.SupplyRequest: Dispense Instructions</p>
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
@Hl7PartTypeMapping({"PORX_MT020070CA.SupplyRequest","PORX_MT030040CA.SupplyRequest","PORX_MT060190CA.SupplyRequest"})
public class DispenseInstructions_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private CS statusCode = new CSImpl();
    private PQ quantity = new PQImpl();
    private CV locationSubstitutionConditionCode = new CVImpl();
    private ServiceLocationBean locationServiceDeliveryLocation;
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>Un-merged Business Name: PrescriptionDispensableIndicator</p>
     * 
     * <p>Relationship: PORX_MT060190CA.SupplyRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the dispensing authorization of the prescription 
     * to be controlled/manipulates as needed.</p><p>Attribute is 
     * marked as &quot;mandatory&quot; as the dispensing authority 
     * of the prescription will always be known.</p>
     * 
     * <p>This generally mirrors the status for the prescription, 
     * but in some circumstances may be changed to 'aborted' while 
     * the prescription is still active. When this occurs, it means 
     * the prescription may no longer be dispensed, though it may 
     * still be administered.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseIndicator</p>
     * 
     * <p>Relationship: PORX_MT030040CA.SupplyRequest.statusCode</p>
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
     * <p>Un-merged Business Name: PrescriptionDispensableIndicator</p>
     * 
     * <p>Relationship: PORX_MT060190CA.SupplyRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the dispensing authorization of the prescription 
     * to be controlled/manipulates as needed.</p><p>Attribute is 
     * marked as &quot;mandatory&quot; as the dispensing authority 
     * of the prescription will always be known.</p>
     * 
     * <p>This generally mirrors the status for the prescription, 
     * but in some circumstances may be changed to 'aborted' while 
     * the prescription is still active. When this occurs, it means 
     * the prescription may no longer be dispensed, though it may 
     * still be administered.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseIndicator</p>
     * 
     * <p>Relationship: PORX_MT030040CA.SupplyRequest.statusCode</p>
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
     * <p>Business Name: TotalPrescribedQuantity</p>
     * 
     * <p>Un-merged Business Name: TotalPrescribedQuantity</p>
     * 
     * <p>Relationship: PORX_MT060190CA.SupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Sets upper limit for medication to be dispensed. Can be 
     * used to verify the intention of the prescriber with respect 
     * to the overall medication. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p>
     * 
     * <p>The overall amount of amount medication to be dispensed 
     * under this prescription. Includes any first fills (trials, 
     * aligning quantities), the initial standard fill plus all 
     * refills.</p>
     * 
     * <p>Un-merged Business Name: TotalPrescribedQuantity</p>
     * 
     * <p>Relationship: PORX_MT030040CA.SupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Sets upper limit for medication to be dispensed. Can be 
     * used to verify the intention of the prescriber with respect 
     * to the overall medication. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p><p>Narcotics 
     * must always be specified as a total quantity.</p>
     * 
     * <p>The overall amount of amount medication to be dispensed 
     * under this prescription. Includes any first fills (trials, 
     * aligning quantities), the initial standard fill plus all 
     * refills.</p>
     * 
     * <p>Un-merged Business Name: TotalPrescribedQuantity</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Critical in understanding the patient's medication 
     * profile, both past and current. This also allows 
     * determination of the amount that remains to be dispensed 
     * against the prescription.</p>
     * 
     * <p>The overall amount of amount medication to be dispensed 
     * under this prescription. Includes any first fills (trials, 
     * aligning quantities), the initial standard fill plus all 
     * refills.</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Business Name: TotalPrescribedQuantity</p>
     * 
     * <p>Un-merged Business Name: TotalPrescribedQuantity</p>
     * 
     * <p>Relationship: PORX_MT060190CA.SupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Sets upper limit for medication to be dispensed. Can be 
     * used to verify the intention of the prescriber with respect 
     * to the overall medication. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p>
     * 
     * <p>The overall amount of amount medication to be dispensed 
     * under this prescription. Includes any first fills (trials, 
     * aligning quantities), the initial standard fill plus all 
     * refills.</p>
     * 
     * <p>Un-merged Business Name: TotalPrescribedQuantity</p>
     * 
     * <p>Relationship: PORX_MT030040CA.SupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Sets upper limit for medication to be dispensed. Can be 
     * used to verify the intention of the prescriber with respect 
     * to the overall medication. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p><p>Narcotics 
     * must always be specified as a total quantity.</p>
     * 
     * <p>The overall amount of amount medication to be dispensed 
     * under this prescription. Includes any first fills (trials, 
     * aligning quantities), the initial standard fill plus all 
     * refills.</p>
     * 
     * <p>Un-merged Business Name: TotalPrescribedQuantity</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Critical in understanding the patient's medication 
     * profile, both past and current. This also allows 
     * determination of the amount that remains to be dispensed 
     * against the prescription.</p>
     * 
     * <p>The overall amount of amount medication to be dispensed 
     * under this prescription. Includes any first fills (trials, 
     * aligning quantities), the initial standard fill plus all 
     * refills.</p>
     */
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>Business Name: DispenseFacilityNotAssignableIndicator</p>
     * 
     * <p>Un-merged Business Name: 
     * DispenseFacilityNotAssignableIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190CA.Location3.substitutionConditionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Influences whether the prescription may be transferred to 
     * a service delivery location other than the targeted 
     * dispenser.</p>
     * 
     * <p>Indicates a 'hard' or 'soft' assignment of dispensing 
     * priviledged to the targeted facility.</p><p>'Hard' 
     * assignment (mandated facility) indicates that the 
     * prescription can be dispensed only at that 
     * facility.</p><p>'Soft' assignment (usually as a patient 
     * directive) indicates that the prescription may be dispensed 
     * at facilities other than the targeted facility.</p>
     * 
     * <p>Un-merged Business Name: 
     * DispenseFacilityNotAssignableIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.Location2.substitutionConditionCode</p>
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
     * <p>Business Name: DispenseFacilityNotAssignableIndicator</p>
     * 
     * <p>Un-merged Business Name: 
     * DispenseFacilityNotAssignableIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190CA.Location3.substitutionConditionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Influences whether the prescription may be transferred to 
     * a service delivery location other than the targeted 
     * dispenser.</p>
     * 
     * <p>Indicates a 'hard' or 'soft' assignment of dispensing 
     * priviledged to the targeted facility.</p><p>'Hard' 
     * assignment (mandated facility) indicates that the 
     * prescription can be dispensed only at that 
     * facility.</p><p>'Soft' assignment (usually as a patient 
     * directive) indicates that the prescription may be dispensed 
     * at facilities other than the targeted facility.</p>
     * 
     * <p>Un-merged Business Name: 
     * DispenseFacilityNotAssignableIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.Location2.substitutionConditionCode</p>
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
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190CA.Location3.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.Location2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190CA.Location3.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.Location2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    /**
     * <p>Business Name: TotalDaysSupply</p>
     * 
     * <p>Un-merged Business Name: TotalDaysSupply</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.SupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy').</p>
     * 
     * <p>The number of days that the overall prescribed item is 
     * expected to last, if the patient is compliant with the 
     * dispensing and administration of the prescription.</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }

    /**
     * <p>Business Name: TotalDaysSupply</p>
     * 
     * <p>Un-merged Business Name: TotalDaysSupply</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.SupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy').</p>
     * 
     * <p>The number of days that the overall prescribed item is 
     * expected to last, if the patient is compliant with the 
     * dispensing and administration of the prescription.</p>
     */
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }

}
