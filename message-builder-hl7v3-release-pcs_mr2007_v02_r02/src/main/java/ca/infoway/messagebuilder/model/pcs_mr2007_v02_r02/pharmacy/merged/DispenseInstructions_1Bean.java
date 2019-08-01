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
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActRelationshipType;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.DispenseShipToLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.TargetedToPharmacyBean;
import java.util.Date;



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
 */
@Hl7PartTypeMapping({"PORX_MT010110CA.SupplyRequest","PORX_MT060040CA.SupplyRequest","PORX_MT060060CA.SupplyRequest"})
public class DispenseInstructions_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20190730L;
    private INT quantity = new INTImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();
    private TargetedToPharmacyBean location;
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;
    private CS componentTypeCode = new CSImpl();
    private CS componentContextControlCode = new CSImpl();
    private BL componentContextConductionInd = new BLImpl();
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
     * <p>Relationship: PORX_MT060040CA.SupplyRequest.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010110CA.SupplyRequest.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060CA.SupplyRequest.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public TargetedToPharmacyBean getLocation() {
        return this.location;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.SupplyRequest.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010110CA.SupplyRequest.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060CA.SupplyRequest.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setLocation(TargetedToPharmacyBean location) {
        this.location = location;
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
     * PORX_MT060040CA.Component3.supplementalFillInformation</p>
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
     * PORX_MT060040CA.Component3.supplementalFillInformation</p>
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
