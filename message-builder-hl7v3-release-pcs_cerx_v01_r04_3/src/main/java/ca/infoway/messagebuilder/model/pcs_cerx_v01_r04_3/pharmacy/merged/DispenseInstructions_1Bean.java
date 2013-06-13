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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt240003ca.ServiceLocationBean;
import java.util.Date;



/**
 * <p>Business Name: DispenseInstructions</p>
 * 
 * <p>PORX_MT060040CA.SupplyRequest: Dispense Instructions</p>
 * 
 * <p>At least one of &quot;Days Supply&quot; and &quot;Fill 
 * Quantity&quot; must be identified.</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Sets the parameters within which the dispenser must 
 * operate in dispensing the device to the patient.</p>
 * 
 * <p>Specification of how the prescribed device is to be 
 * dispensed to the patient. Dispensed instruction information 
 * includes the quantity to be dispensed, how often the 
 * quantity is to be dispensed, etc.</p>
 * 
 * <p>PORX_MT060060CA.SupplyRequest: Dispense Instructions</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Sets the parameters within which the dispenser must 
 * operate in dispensing the device to the patient.</p>
 * 
 * <p>Specification of how the prescribed device is to be 
 * dispensed to the patient. Dispensed instruction information 
 * includes the quantity to be dispensed, how often the 
 * quantity is to be dispensed, etc.</p>
 * 
 * <p>PORX_MT020060CA.SupplyRequest: (no business name)</p>
 * 
 * <p>AT least one of Total Prescribed Quantity or Total Days 
 * Supply must be specified</p>
 * 
 * <p>PORX_MT010110CA.SupplyRequest: Dispense Instructions</p>
 * 
 * <p>One of 'quantity' and 'expectedUseTime' must be 
 * specified</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Sets the parameters within which the dispenser must 
 * operate in dispensing the device to the patient.</p>
 * 
 * <p>Specification of how the prescribed device is to be 
 * dispensed to the patient. Dispensed instruction information 
 * includes the quantity to be dispensed, how often the 
 * quantity is to be dispensed, etc.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010110CA.SupplyRequest","PORX_MT020060CA.SupplyRequest","PORX_MT060040CA.SupplyRequest","PORX_MT060060CA.SupplyRequest"})
public class DispenseInstructions_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private INT quantity = new INTImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();
    private AD destinationServiceDeliveryLocationAddr = new ADImpl();
    private IVL<TS, Interval<Date>> locationTime = new IVLImpl<TS, Interval<Date>>();
    private ServiceLocationBean locationServiceDeliveryLocation;
    private SupplementalFillInformationBean componentSupplementalFillInformation;


    /**
     * <p>Business Name: TotalPrescribedQuantity</p>
     * 
     * <p>Un-merged Business Name: TotalPrescribedQuantity</p>
     * 
     * <p>Relationship: PORX_MT060040CA.SupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Sets upper limit for devices to be dispensed. Can be used 
     * to verify the intention of the prescriber with respect to 
     * the overall prescription. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p>
     * 
     * <p>The overall number of devices to be dispensed under this 
     * prescription. Includes any first fills (trials, aligning 
     * quantities), the initial standard fill plus all refills.</p>
     * 
     * <p>Un-merged Business Name: TotalPrescribedQuantity</p>
     * 
     * <p>Relationship: PORX_MT060060CA.SupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Sets upper limit for devices to be dispensed. Can be used 
     * to verify the intention of the prescriber with respect to 
     * the overall prescription. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p>
     * 
     * <p>The overall number of devices to be dispensed under this 
     * prescription. Includes any first fills (trials, aligning 
     * quantities), the initial standard fill plus all refills.</p>
     * 
     * <p>Un-merged Business Name: TotalPrescribedQuantity</p>
     * 
     * <p>Relationship: PORX_MT020060CA.SupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows determination of the amount that remains to be 
     * dispensed against the prescription.</p>
     * 
     * <p>The overall amount of device to be dispensed under this 
     * prescription.</p>
     * 
     * <p>Un-merged Business Name: TotalPrescribedQuantity</p>
     * 
     * <p>Relationship: PORX_MT010110CA.SupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Sets upper limit for device to be dispensed. Can be used 
     * to verify the intention of the prescriber with respect to 
     * the overall prescription. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p>
     * 
     * <p>The overall number of devices to be dispensed under this 
     * prescription. Includes any first fills (trials, aligning 
     * quantities), the initial standard fill plus all refills.</p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Business Name: TotalPrescribedQuantity</p>
     * 
     * <p>Un-merged Business Name: TotalPrescribedQuantity</p>
     * 
     * <p>Relationship: PORX_MT060040CA.SupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Sets upper limit for devices to be dispensed. Can be used 
     * to verify the intention of the prescriber with respect to 
     * the overall prescription. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p>
     * 
     * <p>The overall number of devices to be dispensed under this 
     * prescription. Includes any first fills (trials, aligning 
     * quantities), the initial standard fill plus all refills.</p>
     * 
     * <p>Un-merged Business Name: TotalPrescribedQuantity</p>
     * 
     * <p>Relationship: PORX_MT060060CA.SupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Sets upper limit for devices to be dispensed. Can be used 
     * to verify the intention of the prescriber with respect to 
     * the overall prescription. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p>
     * 
     * <p>The overall number of devices to be dispensed under this 
     * prescription. Includes any first fills (trials, aligning 
     * quantities), the initial standard fill plus all refills.</p>
     * 
     * <p>Un-merged Business Name: TotalPrescribedQuantity</p>
     * 
     * <p>Relationship: PORX_MT020060CA.SupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows determination of the amount that remains to be 
     * dispensed against the prescription.</p>
     * 
     * <p>The overall amount of device to be dispensed under this 
     * prescription.</p>
     * 
     * <p>Un-merged Business Name: TotalPrescribedQuantity</p>
     * 
     * <p>Relationship: PORX_MT010110CA.SupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Sets upper limit for device to be dispensed. Can be used 
     * to verify the intention of the prescriber with respect to 
     * the overall prescription. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p>
     * 
     * <p>The overall number of devices to be dispensed under this 
     * prescription. Includes any first fills (trials, aligning 
     * quantities), the initial standard fill plus all refills.</p>
     */
    public void setQuantity(Integer quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>Business Name: TotalDaysSupply</p>
     * 
     * <p>Un-merged Business Name: TotalDaysSupply</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.SupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used to specify a total authorization as a duration 
     * rather than a quantity with refills. E.g. dispense 30 at a 
     * time, refill for 1 year. May also be sent as an estimate of 
     * the expected overall duration of the prescription based on 
     * the quantity prescribed.</p>
     * 
     * <p>The number of days that the overall prescribed item is 
     * expected to last, if the patient is compliant with the 
     * dispensing and use of the prescription.</p>
     * 
     * <p>Un-merged Business Name: TotalDaysSupply</p>
     * 
     * <p>Relationship: 
     * PORX_MT020060CA.SupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late').</p>
     * 
     * <p>The number of days that the overall prescribed item is 
     * expected to last, if the patient is compliant with the 
     * dispensing and use of the prescription</p>
     * 
     * <p>Un-merged Business Name: TotalDaysSupply</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.SupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used to specify a total authorization as a duration 
     * rather than a quantity with refills. E.g. dispense 30 at a 
     * time, refill for 1 year. May also be sent as an estimate of 
     * the expected overall duration of the prescription based on 
     * the quantity prescribed.</p>
     * 
     * <p>The number of days that the overall prescribed item is 
     * expected to last, if the patient is compliant with the 
     * dispensing and use of the prescription.</p>
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
     * PORX_MT060040CA.SupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used to specify a total authorization as a duration 
     * rather than a quantity with refills. E.g. dispense 30 at a 
     * time, refill for 1 year. May also be sent as an estimate of 
     * the expected overall duration of the prescription based on 
     * the quantity prescribed.</p>
     * 
     * <p>The number of days that the overall prescribed item is 
     * expected to last, if the patient is compliant with the 
     * dispensing and use of the prescription.</p>
     * 
     * <p>Un-merged Business Name: TotalDaysSupply</p>
     * 
     * <p>Relationship: 
     * PORX_MT020060CA.SupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late').</p>
     * 
     * <p>The number of days that the overall prescribed item is 
     * expected to last, if the patient is compliant with the 
     * dispensing and use of the prescription</p>
     * 
     * <p>Un-merged Business Name: TotalDaysSupply</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.SupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used to specify a total authorization as a duration 
     * rather than a quantity with refills. E.g. dispense 30 at a 
     * time, refill for 1 year. May also be sent as an estimate of 
     * the expected overall duration of the prescription based on 
     * the quantity prescribed.</p>
     * 
     * <p>The number of days that the overall prescribed item is 
     * expected to last, if the patient is compliant with the 
     * dispensing and use of the prescription.</p>
     */
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }


    /**
     * <p>Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.ServiceDeliveryLocation2.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some cases devices need to be delivered to the patient 
     * instead of being picked up. In other cases, devices need to 
     * be shipped to the physician's office to replace stock used 
     * for the patient.</p>
     * 
     * <p>Indicates the location the dispensed device should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some cases devices need to be delivered to the patient 
     * instead of being picked up. In other cases, devices need to 
     * be shipped to the physician's office to replace stock used 
     * for the patient.</p>
     * 
     * <p>Indicates the location the dispensed device should be 
     * shipped to, at the request of the patient or provider.</p>
     */
    @Hl7XmlMapping({"destination/serviceDeliveryLocation/addr"})
    public PostalAddress getDestinationServiceDeliveryLocationAddr() {
        return this.destinationServiceDeliveryLocationAddr.getValue();
    }

    /**
     * <p>Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.ServiceDeliveryLocation2.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some cases devices need to be delivered to the patient 
     * instead of being picked up. In other cases, devices need to 
     * be shipped to the physician's office to replace stock used 
     * for the patient.</p>
     * 
     * <p>Indicates the location the dispensed device should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some cases devices need to be delivered to the patient 
     * instead of being picked up. In other cases, devices need to 
     * be shipped to the physician's office to replace stock used 
     * for the patient.</p>
     * 
     * <p>Indicates the location the dispensed device should be 
     * shipped to, at the request of the patient or provider.</p>
     */
    public void setDestinationServiceDeliveryLocationAddr(PostalAddress destinationServiceDeliveryLocationAddr) {
        this.destinationServiceDeliveryLocationAddr.setValue(destinationServiceDeliveryLocationAddr);
    }


    /**
     * <p>Business Name: ToBePickedUpWhen</p>
     * 
     * <p>Un-merged Business Name: ToBePickedUpWhen</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Location4.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows a prescriber to indicate to the targeted pharmacy, 
     * when patient will be expecting to pick up the dispensed 
     * device.</p>
     * 
     * <p>The date and time on which the dispense is expected to be 
     * picked up.</p>
     * 
     * <p>Un-merged Business Name: ToBePickedUpWhen</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Location2.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows a prescriber to indicate to the targeted pharmacy, 
     * when patient will be expecting to pick up the dispensed 
     * device.</p>
     * 
     * <p>The date and time on which the dispense is expected to be 
     * picked up.</p>
     * 
     * <p>Un-merged Business Name: ToBePickedUpWhen</p>
     * 
     * <p>Relationship: PORX_MT010110CA.Location2.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows a prescriber to indicate to the targeted pharmacy, 
     * when patient will be expecting to pick up the dispensed 
     * device.</p>
     * 
     * <p>The date and time on which the dispense is expected to be 
     * picked up.</p>
     */
    @Hl7XmlMapping({"location/time"})
    public Interval<Date> getLocationTime() {
        return this.locationTime.getValue();
    }

    /**
     * <p>Business Name: ToBePickedUpWhen</p>
     * 
     * <p>Un-merged Business Name: ToBePickedUpWhen</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Location4.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows a prescriber to indicate to the targeted pharmacy, 
     * when patient will be expecting to pick up the dispensed 
     * device.</p>
     * 
     * <p>The date and time on which the dispense is expected to be 
     * picked up.</p>
     * 
     * <p>Un-merged Business Name: ToBePickedUpWhen</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Location2.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows a prescriber to indicate to the targeted pharmacy, 
     * when patient will be expecting to pick up the dispensed 
     * device.</p>
     * 
     * <p>The date and time on which the dispense is expected to be 
     * picked up.</p>
     * 
     * <p>Un-merged Business Name: ToBePickedUpWhen</p>
     * 
     * <p>Relationship: PORX_MT010110CA.Location2.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows a prescriber to indicate to the targeted pharmacy, 
     * when patient will be expecting to pick up the dispensed 
     * device.</p>
     * 
     * <p>The date and time on which the dispense is expected to be 
     * picked up.</p>
     */
    public void setLocationTime(Interval<Date> locationTime) {
        this.locationTime.setValue(locationTime);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.Location4.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060060CA.Location2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.Location2.serviceDeliveryLocation</p>
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
     * PORX_MT060040CA.Location4.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060060CA.Location2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.Location2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.Component2.supplementalFillInformation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.Component.supplementalFillInformation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component/supplementalFillInformation"})
    public SupplementalFillInformationBean getComponentSupplementalFillInformation() {
        return this.componentSupplementalFillInformation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.Component2.supplementalFillInformation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.Component.supplementalFillInformation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponentSupplementalFillInformation(SupplementalFillInformationBean componentSupplementalFillInformation) {
        this.componentSupplementalFillInformation = componentSupplementalFillInformation;
    }

}
