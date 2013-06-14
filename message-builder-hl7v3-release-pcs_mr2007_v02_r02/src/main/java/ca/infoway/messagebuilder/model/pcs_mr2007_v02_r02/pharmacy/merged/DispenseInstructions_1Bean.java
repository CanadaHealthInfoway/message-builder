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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActClass;
import ca.infoway.messagebuilder.domainvalue.ActMood;
import ca.infoway.messagebuilder.domainvalue.ActRelationshipType;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.domainvalue.x_SubstitutionConditionNoneOrUnconditional;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.DispenseShipToLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.porx_mt010140ca.RemainingDispensesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: DispenseInstructions</p>
 * 
 * <p>PORX_MT060040CA.SupplyRequest: Dispense Instructions</p>
 * 
 * <p>At least one of &quot;Days Supply&quot; and &quot;Fill 
 * Quantity&quot; must be identified.</p>
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
 * <p>Sets the parameters within which the dispenser must 
 * operate in dispensing the device to the patient.</p>
 * 
 * <p>Specification of how the prescribed device is to be 
 * dispensed to the patient. Dispensed instruction information 
 * includes the quantity to be dispensed, how often the 
 * quantity is to be dispensed, etc.</p>
 * 
 * <p>PORX_MT010140CA.SupplyRequest: Dispense Instructions</p>
 * 
 * <p>Sets the parameters within which the dispenser must 
 * operate.</p>
 * 
 * <p>This is the information that describes the authorization 
 * for a dispenser to dispense the prescription.</p>
 * 
 * <p>PORX_MT010110CA.SupplyRequest: Dispense Instructions</p>
 * 
 * <p>One of 'quantity' and 'expectedUseTime' must be 
 * specified</p>
 * 
 * <p>Sets the parameters within which the dispenser must 
 * operate in dispensing the device to the patient.</p>
 * 
 * <p>Specification of how the prescribed device is to be 
 * dispensed to the patient. Dispensed instruction information 
 * includes the quantity to be dispensed, how often the 
 * quantity is to be dispensed, etc.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010110CA.SupplyRequest","PORX_MT010140CA.SupplyRequest","PORX_MT060040CA.SupplyRequest","PORX_MT060060CA.SupplyRequest"})
@Hl7RootType
public class DispenseInstructions_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private INT quantity = new INTImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;
    private IVL<TS, Interval<Date>> locationTime = new IVLImpl<TS, Interval<Date>>();
    private ServiceLocationBean locationServiceDeliveryLocation;
    private CS componentTypeCode = new CSImpl();
    private CS componentContextControlCode = new CSImpl();
    private BL componentContextConductionInd = new BLImpl();
    private CS componentSupplementalFillInformationClassCode = new CSImpl();
    private CS componentSupplementalFillInformationMoodCode = new CSImpl();
    private INT componentSupplementalFillInformationRepeatNumber = new INTImpl();
    private INT componentSupplementalFillInformationQuantity = new INTImpl();
    private CV locationSubstitutionConditionCode = new CVImpl();
    private List<RemainingDispensesBean> fulfillmentSupplyEvent = new ArrayList<RemainingDispensesBean>();
    private ActRequestBean componentOfActRequest;


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
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.Destination1.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.Destination1.serviceDeliveryLocation</p>
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
     * PORX_MT060040CA.Destination1.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.Destination1.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDestinationServiceDeliveryLocation(DispenseShipToLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
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
     * PORX_MT010140CA.Location.serviceDeliveryLocation</p>
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
     * PORX_MT010140CA.Location.serviceDeliveryLocation</p>
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
     * <p>Relationship: PORX_MT060040CA.Component3.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010110CA.Component.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component/typeCode"})
    public ActRelationshipType getComponentTypeCode() {
        return (ActRelationshipType) this.componentTypeCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Component3.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010110CA.Component.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponentTypeCode(ActRelationshipType componentTypeCode) {
        this.componentTypeCode.setValue(componentTypeCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.Component3.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.Component.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component/contextControlCode"})
    public ContextControl getComponentContextControlCode() {
        return (ContextControl) this.componentContextControlCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.Component3.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.Component.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponentContextControlCode(ContextControl componentContextControlCode) {
        this.componentContextControlCode.setValue(componentContextControlCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.Component3.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.Component.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component/contextConductionInd"})
    public Boolean getComponentContextConductionInd() {
        return this.componentContextConductionInd.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.Component3.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.Component.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponentContextConductionInd(Boolean componentContextConductionInd) {
        this.componentContextConductionInd.setValue(componentContextConductionInd);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.SupplementalFillInformation.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.SupplementalFillInformation.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component/supplementalFillInformation/classCode"})
    public ActClass getComponentSupplementalFillInformationClassCode() {
        return (ActClass) this.componentSupplementalFillInformationClassCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.SupplementalFillInformation.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.SupplementalFillInformation.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponentSupplementalFillInformationClassCode(ActClass componentSupplementalFillInformationClassCode) {
        this.componentSupplementalFillInformationClassCode.setValue(componentSupplementalFillInformationClassCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.SupplementalFillInformation.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.SupplementalFillInformation.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component/supplementalFillInformation/moodCode"})
    public ActMood getComponentSupplementalFillInformationMoodCode() {
        return (ActMood) this.componentSupplementalFillInformationMoodCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.SupplementalFillInformation.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.SupplementalFillInformation.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponentSupplementalFillInformationMoodCode(ActMood componentSupplementalFillInformationMoodCode) {
        this.componentSupplementalFillInformationMoodCode.setValue(componentSupplementalFillInformationMoodCode);
    }


    /**
     * <p>Business Name: NumberOfFills</p>
     * 
     * <p>Un-merged Business Name: NumberOfFills</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.SupplementalFillInformation.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A prescription can authorize multiple fills.</p>
     * 
     * <p>Allows the prescriber to specify the number of fills 
     * authorized by this prescription.</p>
     * 
     * <p>Un-merged Business Name: NumberOfFills</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.SupplementalFillInformation.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A prescription can authorize multiple fills.</p>
     * 
     * <p>Allows the prescriber to specify the number of fills 
     * authorized by this prescription.</p>
     */
    @Hl7XmlMapping({"component/supplementalFillInformation/repeatNumber"})
    public Integer getComponentSupplementalFillInformationRepeatNumber() {
        return this.componentSupplementalFillInformationRepeatNumber.getValue();
    }

    /**
     * <p>Business Name: NumberOfFills</p>
     * 
     * <p>Un-merged Business Name: NumberOfFills</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.SupplementalFillInformation.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A prescription can authorize multiple fills.</p>
     * 
     * <p>Allows the prescriber to specify the number of fills 
     * authorized by this prescription.</p>
     * 
     * <p>Un-merged Business Name: NumberOfFills</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.SupplementalFillInformation.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A prescription can authorize multiple fills.</p>
     * 
     * <p>Allows the prescriber to specify the number of fills 
     * authorized by this prescription.</p>
     */
    public void setComponentSupplementalFillInformationRepeatNumber(Integer componentSupplementalFillInformationRepeatNumber) {
        this.componentSupplementalFillInformationRepeatNumber.setValue(componentSupplementalFillInformationRepeatNumber);
    }


    /**
     * <p>Business Name: FillQuantity</p>
     * 
     * <p>Un-merged Business Name: FillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.SupplementalFillInformation.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The prescription is usually authorized for a specific 
     * quantity for each fill.</p>
     * 
     * <p>Specifies the quantity for each fill.</p>
     * 
     * <p>Un-merged Business Name: FillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.SupplementalFillInformation.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The prescription is usually authorized for a specific 
     * quantity for each fill.</p>
     * 
     * <p>Specifies the quantity for each fill.</p>
     */
    @Hl7XmlMapping({"component/supplementalFillInformation/quantity"})
    public Integer getComponentSupplementalFillInformationQuantity() {
        return this.componentSupplementalFillInformationQuantity.getValue();
    }

    /**
     * <p>Business Name: FillQuantity</p>
     * 
     * <p>Un-merged Business Name: FillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.SupplementalFillInformation.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The prescription is usually authorized for a specific 
     * quantity for each fill.</p>
     * 
     * <p>Specifies the quantity for each fill.</p>
     * 
     * <p>Un-merged Business Name: FillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.SupplementalFillInformation.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The prescription is usually authorized for a specific 
     * quantity for each fill.</p>
     * 
     * <p>Specifies the quantity for each fill.</p>
     */
    public void setComponentSupplementalFillInformationQuantity(Integer componentSupplementalFillInformationQuantity) {
        this.componentSupplementalFillInformationQuantity.setValue(componentSupplementalFillInformationQuantity);
    }


    /**
     * <p>Business Name: DispenseFacilityNotAssignableIndicator</p>
     * 
     * <p>Un-merged Business Name: 
     * DispenseFacilityNotAssignableIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060060CA.Location2.substitutionConditionCode</p>
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
     * <p>Business Name: DispenseFacilityNotAssignableIndicator</p>
     * 
     * <p>Un-merged Business Name: 
     * DispenseFacilityNotAssignableIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060060CA.Location2.substitutionConditionCode</p>
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
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010140CA.InFulfillmentOf.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment/supplyEvent"})
    public List<RemainingDispensesBean> getFulfillmentSupplyEvent() {
        return this.fulfillmentSupplyEvent;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010140CA.Component6.actRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"componentOf/actRequest"})
    public ActRequestBean getComponentOfActRequest() {
        return this.componentOfActRequest;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010140CA.Component6.actRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponentOfActRequest(ActRequestBean componentOfActRequest) {
        this.componentOfActRequest = componentOfActRequest;
    }

}
