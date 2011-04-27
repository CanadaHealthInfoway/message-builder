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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
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
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.ActRequestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.OccurredAtBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.porx_mt010140ca.RemainingDispensesBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>DispenseInstructions</p>
 * 
 * <p>PORX_MT060040CA.SupplyRequest: Dispense Instructions</p>
 * 
 * <p><p>At least one of Days Supply and Fill Quantity must be 
 * identified.</p></p>
 * 
 * <p><p>Specification of how the prescribed device is to be 
 * dispensed to the patient. Dispensed instruction information 
 * includes the quantity to be dispensed, how often the 
 * quantity is to be dispensed, etc.</p></p>
 * 
 * <p><p>Sets the parameters within which the dispenser must 
 * operate in dispensing the device to the patient.</p></p>
 * 
 * <p>PORX_MT060060CA.SupplyRequest: Dispense Instructions</p>
 * 
 * <p><p>Specification of how the prescribed device is to be 
 * dispensed to the patient. Dispensed instruction information 
 * includes the quantity to be dispensed, how often the 
 * quantity is to be dispensed, etc.</p></p>
 * 
 * <p><p>Sets the parameters within which the dispenser must 
 * operate in dispensing the device to the patient.</p></p>
 * 
 * <p>PORX_MT010140CA.SupplyRequest: Dispense Instructions</p>
 * 
 * <p><p>This is the information that describes the 
 * authorization for a dispenser to dispense the 
 * prescription.</p></p>
 * 
 * <p><p>Sets the parameters within which the dispenser must 
 * operate.</p></p>
 * 
 * <p>PORX_MT010110CA.SupplyRequest: Dispense Instructions</p>
 * 
 * <p><p>One of quantity and expectedUseTime must be 
 * specified</p></p>
 * 
 * <p><p>Specification of how the prescribed device is to be 
 * dispensed to the patient. Dispensed instruction information 
 * includes the quantity to be dispensed, how often the 
 * quantity is to be dispensed, etc.</p></p>
 * 
 * <p><p>Sets the parameters within which the dispenser must 
 * operate in dispensing the device to the patient.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT010110CA.SupplyRequest","PORX_MT010140CA.SupplyRequest","PORX_MT060040CA.SupplyRequest","PORX_MT060060CA.SupplyRequest"})
@Hl7RootType
public class DispenseInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private INT totalPrescribedQuantity = new INTImpl();
    private IVL<TS, Interval<Date>> totalDaysSupply = new IVLImpl<TS, Interval<Date>>();
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;
    private OccurredAtBean location;
    private CS componentContextControlCode = new CSImpl();
    private BL componentContextConductionInd = new BLImpl();
    private SupplementalFillInformationBean componentSupplementalFillInformation;
    private List<RemainingDispensesBean> fulfillmentSupplyEvent = new ArrayList<RemainingDispensesBean>();
    private ActRequestBean componentOfActRequest;


    /**
     * <p>TotalPrescribedQuantity</p>
     * 
     * <p>B:Total Prescribed Quantity</p>
     * 
     * <p><p>The overall number of devices to be dispensed under 
     * this prescription. Includes any first fills (trials, 
     * aligning quantities), the initial standard fill plus all 
     * refills.</p></p>
     * 
     * <p><p>Sets upper limit for device to be dispensed. Can be 
     * used to verify the intention of the prescriber with respect 
     * to the overall prescription. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p></p>
     * 
     * <p>B:Total Prescribed Quantity</p>
     * 
     * <p><p>The overall number of devices to be dispensed under 
     * this prescription. Includes any first fills (trials, 
     * aligning quantities), the initial standard fill plus all 
     * refills.</p></p>
     * 
     * <p><p>Sets upper limit for devices to be dispensed. Can be 
     * used to verify the intention of the prescriber with respect 
     * to the overall prescription. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getTotalPrescribedQuantity() {
        return this.totalPrescribedQuantity.getValue();
    }
    public void setTotalPrescribedQuantity(Integer totalPrescribedQuantity) {
        this.totalPrescribedQuantity.setValue(totalPrescribedQuantity);
    }


    /**
     * <p>TotalDaysSupply</p>
     * 
     * <p>C:Total Days Supply</p>
     * 
     * <p><p>The number of days that the overall prescribed item is 
     * expected to last, if the patient is compliant with the 
     * dispensing and use of the prescription.</p></p>
     * 
     * <p><p>Used to specify a total authorization as a duration 
     * rather than a quantity with refills. E.g. dispense 30 at a 
     * time, refill for 1 year. May also be sent as an estimate of 
     * the expected overall duration of the prescription based on 
     * the quantity prescribed.</p></p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getTotalDaysSupply() {
        return this.totalDaysSupply.getValue();
    }
    public void setTotalDaysSupply(Interval<Date> totalDaysSupply) {
        this.totalDaysSupply.setValue(totalDaysSupply);
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


    @Hl7XmlMapping({"component/contextControlCode"})
    public ContextControl getComponentContextControlCode() {
        return (ContextControl) this.componentContextControlCode.getValue();
    }
    public void setComponentContextControlCode(ContextControl componentContextControlCode) {
        this.componentContextControlCode.setValue(componentContextControlCode);
    }


    @Hl7XmlMapping({"component/contextConductionInd"})
    public Boolean getComponentContextConductionInd() {
        return this.componentContextConductionInd.getValue();
    }
    public void setComponentContextConductionInd(Boolean componentContextConductionInd) {
        this.componentContextConductionInd.setValue(componentContextConductionInd);
    }


    @Hl7XmlMapping({"component/supplementalFillInformation"})
    public SupplementalFillInformationBean getComponentSupplementalFillInformation() {
        return this.componentSupplementalFillInformation;
    }
    public void setComponentSupplementalFillInformation(SupplementalFillInformationBean componentSupplementalFillInformation) {
        this.componentSupplementalFillInformation = componentSupplementalFillInformation;
    }


    @Hl7XmlMapping({"fulfillment/supplyEvent"})
    public List<RemainingDispensesBean> getFulfillmentSupplyEvent() {
        return this.fulfillmentSupplyEvent;
    }


    @Hl7XmlMapping({"componentOf/actRequest"})
    public ActRequestBean getComponentOfActRequest() {
        return this.componentOfActRequest;
    }
    public void setComponentOfActRequest(ActRequestBean componentOfActRequest) {
        this.componentOfActRequest = componentOfActRequest;
    }

}
