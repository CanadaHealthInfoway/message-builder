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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_SubstitutionConditionNoneOrUnconditional;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.ResponsiblePartyBean;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBean;

@Hl7PartTypeMapping({ "PORX_MT010120CA.SupplyRequest", "PORX_MT060340CA.SupplyRequest" })
public class DispenseInstructionsBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 4102500032236219518L;

    private final CD statusCode = new CDImpl();

    private final IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();

    private final List<ResponsiblePartyBean> responsibleParties = Collections.synchronizedList(new ArrayList<ResponsiblePartyBean>());

    private final IVL<TS, Interval<Date>> toBePickedUpOn = new IVLImpl<TS, Interval<Date>>();

    private final CD substitutionConditionCode = new CDImpl();

    private ServiceDeliveryLocationBean serviceDeliveryLocation;

    private final AD destination = new ADImpl();

    private final List<SupplyRequestBean> supplyRequestItems = Collections.synchronizedList(new ArrayList<SupplyRequestBean>());

    @Hl7XmlMapping("statusCode")
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

    @Hl7XmlMapping("effectiveTime")
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

    @Hl7XmlMapping("receiver/responsibleParty")
    public List<ResponsiblePartyBean> getResponsibleParties() {
        return responsibleParties;
    }

    @Hl7XmlMapping("location/time")
    public Interval<Date> getToBePickedUpOn() {
        return this.toBePickedUpOn.getValue();
    }

    public void setToBePickedUpOn(Interval<Date> toBePickedUpOn) {
        this.toBePickedUpOn.setValue(toBePickedUpOn);
    }

    @Hl7XmlMapping("location/substitutionConditionCode")
    public x_SubstitutionConditionNoneOrUnconditional getSubstitutionConditionCode() {
        return (x_SubstitutionConditionNoneOrUnconditional) this.substitutionConditionCode.getValue();
    }

    public void setSubstitutionConditionCode(x_SubstitutionConditionNoneOrUnconditional substitutionConditionCode) {
        this.substitutionConditionCode.setValue(substitutionConditionCode);
    }

    @Hl7XmlMapping("location/serviceDeliveryLocation")
    public ServiceDeliveryLocationBean getServiceDeliveryLocation() {
        return serviceDeliveryLocation;
    }

    public void setServiceDeliveryLocation(ServiceDeliveryLocationBean serviceDeliveryLocation) {
        this.serviceDeliveryLocation = serviceDeliveryLocation;
    }

    @Hl7XmlMapping("destination/serviceDeliveryLocation/addr")
    public PostalAddress getDestination() {
        return this.destination.getValue();
    }

    public void setDestination(PostalAddress destination) {
        this.destination.setValue(destination);
    }

    @Hl7XmlMapping("component/supplyRequestItem")
    public List<SupplyRequestBean> getSupplyRequestItems() {
        return supplyRequestItems;
    }
}
