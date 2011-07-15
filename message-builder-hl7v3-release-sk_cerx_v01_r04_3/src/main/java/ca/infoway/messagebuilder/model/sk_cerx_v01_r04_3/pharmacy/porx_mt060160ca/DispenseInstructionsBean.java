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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.porx_mt060160ca;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt040205ca.ResponsiblePersonBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.Component3Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.DispenseShipToLocationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"PORX_MT060160CA.SupplyRequest"})
public class DispenseInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110715L;
    private CS prescriptionDispensableIndicator = new CSImpl();
    private IVL<TS, Interval<Date>> dispensingAllowedPeriod = new IVLImpl<TS, Interval<Date>>();
    private List<ResponsiblePersonBean> receiverResponsibleParty = new ArrayList<ResponsiblePersonBean>();
    private RecordedAtBean location;
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;
    private List<Component3Bean> component = new ArrayList<Component3Bean>();


    /**
     * <p>Prescription Dispensable Indicator</p>
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
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDispensingAllowedPeriod() {
        return this.dispensingAllowedPeriod.getValue();
    }
    public void setDispensingAllowedPeriod(Interval<Date> dispensingAllowedPeriod) {
        this.dispensingAllowedPeriod.setValue(dispensingAllowedPeriod);
    }


    @Hl7XmlMapping({"receiver/responsibleParty"})
    public List<ResponsiblePersonBean> getReceiverResponsibleParty() {
        return this.receiverResponsibleParty;
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


    @Hl7XmlMapping({"component"})
    public List<Component3Bean> getComponent() {
        return this.component;
    }

}
