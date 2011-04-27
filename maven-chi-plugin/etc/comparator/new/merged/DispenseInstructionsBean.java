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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.porx_mt010140ca.HasBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"PORX_MT010110CA.SupplyRequest","PORX_MT010140CA.SupplyRequest","PORX_MT060040CA.SupplyRequest","PORX_MT060060CA.SupplyRequest"})
@Hl7RootType
public class DispenseInstructionsBean extends MessagePartBean {

    private INT totalPrescribedQuantity = new INTImpl();
    private IVL<TS, Interval<Date>> totalDaysSupply = new IVLImpl<TS, Interval<Date>>();
    private CreatedAtBean location;
    private ToBeShippedToBean destination;
    private IsPartOfBean component;
    private List<HasBean> fulfillment = new ArrayList<HasBean>();
    private PrescriptionBean componentOfActRequest = new PrescriptionBean();

    @Hl7XmlMapping({"quantity"})
    public java.lang.Integer getTotalPrescribedQuantity() {
        return this.totalPrescribedQuantity.getValue();
    }
    public void setTotalPrescribedQuantity(java.lang.Integer totalPrescribedQuantity) {
        this.totalPrescribedQuantity.setValue(totalPrescribedQuantity);
    }

    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getTotalDaysSupply() {
        return this.totalDaysSupply.getValue();
    }
    public void setTotalDaysSupply(Interval<Date> totalDaysSupply) {
        this.totalDaysSupply.setValue(totalDaysSupply);
    }

    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({"destination"})
    public ToBeShippedToBean getDestination() {
        return this.destination;
    }
    public void setDestination(ToBeShippedToBean destination) {
        this.destination = destination;
    }

    @Hl7XmlMapping({"component"})
    public IsPartOfBean getComponent() {
        return this.component;
    }
    public void setComponent(IsPartOfBean component) {
        this.component = component;
    }

    @Hl7XmlMapping({"fulfillment"})
    public List<HasBean> getFulfillment() {
        return this.fulfillment;
    }

    @Hl7XmlMapping({"componentOf/actRequest"})
    public PrescriptionBean getComponentOfActRequest() {
        return this.componentOfActRequest;
    }
    public void setComponentOfActRequest(PrescriptionBean componentOfActRequest) {
        this.componentOfActRequest = componentOfActRequest;
    }

}
