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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.RecordedAtBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT010110CA.SupplyRequest","PORX_MT020060CA.SupplyRequest","PORX_MT060040CA.SupplyRequest","PORX_MT060060CA.SupplyRequest"})
public class DispenseInstructions_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private INT quantity = new INTImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();
    private RecordedAtBean location;
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;
    private SupplementalFillInformationBean componentSupplementalFillInformation;


    /**
     * <p>TotalPrescribedQuantity</p>
     * 
     * <p>B:Total Prescribed Quantity</p>
     * 
     * <p>Total Prescribed Quantity</p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getQuantity() {
        return this.quantity.getValue();
    }
    public void setQuantity(Integer quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>TotalDaysSupply</p>
     * 
     * <p>Total Days Supply</p>
     * 
     * <p>C:Total Days Supply</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }


    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }
    public void setDestinationServiceDeliveryLocation(DispenseShipToLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"component/supplementalFillInformation"})
    public SupplementalFillInformationBean getComponentSupplementalFillInformation() {
        return this.componentSupplementalFillInformation;
    }
    public void setComponentSupplementalFillInformation(SupplementalFillInformationBean componentSupplementalFillInformation) {
        this.componentSupplementalFillInformation = componentSupplementalFillInformation;
    }

}
