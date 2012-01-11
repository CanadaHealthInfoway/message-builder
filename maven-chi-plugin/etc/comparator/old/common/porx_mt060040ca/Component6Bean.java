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
package ca.infoway.messagebuilder.model.common.porx_mt060040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.merged.DispenseShipToLocationBean;
import ca.infoway.messagebuilder.model.merged.IsPartOfBean;
import java.util.Date;



/**
 * <p>f:includes 
 * 
 * <p>Identifies the instructions for how the prescribed device 
 * should be dispensed to the patient. 
 * 
 * <p>An essential part of most prescriptions is the 
 * authorization to dispense. 
 */
@Hl7PartTypeMapping({"PORX_MT060040CA.Component6"})
public class Component6Bean extends MessagePartBean {

    private INT totalPrescribedQuantity = new INTImpl();
    private IVL<TS, Interval<Date>> totalDaysSupply = new IVLImpl<TS, Interval<Date>>();
    private CreatedAtBean supplyRequestLocation;
    private DispenseShipToLocationBean supplyRequestDestinationServiceDeliveryLocation;
    private IsPartOfBean supplyRequestSourceOf;

    @Hl7XmlMapping({"supplyRequest/quantity"})
    public java.lang.Integer getTotalPrescribedQuantity() {
        return this.totalPrescribedQuantity.getValue();
    }
    public void setTotalPrescribedQuantity(java.lang.Integer totalPrescribedQuantity) {
        this.totalPrescribedQuantity.setValue(totalPrescribedQuantity);
    }

    @Hl7XmlMapping({"supplyRequest/expectedUseTime"})
    public Interval<Date> getTotalDaysSupply() {
        return this.totalDaysSupply.getValue();
    }
    public void setTotalDaysSupply(Interval<Date> totalDaysSupply) {
        this.totalDaysSupply.setValue(totalDaysSupply);
    }

    @Hl7XmlMapping({"supplyRequest/location"})
    public CreatedAtBean getSupplyRequestLocation() {
        return this.supplyRequestLocation;
    }
    public void setSupplyRequestLocation(CreatedAtBean supplyRequestLocation) {
        this.supplyRequestLocation = supplyRequestLocation;
    }

    @Hl7XmlMapping({"supplyRequest/destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getSupplyRequestDestinationServiceDeliveryLocation() {
        return this.supplyRequestDestinationServiceDeliveryLocation;
    }
    public void setSupplyRequestDestinationServiceDeliveryLocation(DispenseShipToLocationBean supplyRequestDestinationServiceDeliveryLocation) {
        this.supplyRequestDestinationServiceDeliveryLocation = supplyRequestDestinationServiceDeliveryLocation;
    }

    @Hl7XmlMapping({"supplyRequest/sourceOf"})
    public IsPartOfBean getSupplyRequestSourceOf() {
        return this.supplyRequestSourceOf;
    }
    public void setSupplyRequestSourceOf(IsPartOfBean supplyRequestSourceOf) {
        this.supplyRequestSourceOf = supplyRequestSourceOf;
    }

}
