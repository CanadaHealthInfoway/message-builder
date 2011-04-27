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
package ca.infoway.messagebuilder.model.common.porx_mt010120ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.merged.RelatedPersonBean;
import ca.infoway.messagebuilder.model.merged.ToBeShippedToBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



/**
 * <p>f:includes 
 * 
 * <p>Identifies the instructions for how the prescribed 
 * medication should be dispensed to the patient. 
 * 
 * <p>An essential part of most prescriptions is the 
 * authorization to dispense. Multiple repetitions are included 
 * to accommodate circumstances where multiple drug products 
 * may need to be dispensed to complete a therapy. E.g. 100 x 
 * 20mg tablets and 50 x 10mg tablets. The association is 
 * marked as Populated because the authorization to dispense is 
 * a critical portion of a prescription. However the 
 * association is allowed to be 'null' when the order is for a 
 * medication which requires no dispense authorization (e.g. 
 * over-the-counter medications), or when the patient already 
 * has sufficient supply of the medication on hand to complete 
 * the therapy. 
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.Component6"})
public class Component6Bean extends MessagePartBean {

    private IVL<TS, Interval<Date>> dispensingAllowedPeriod = new IVLImpl<TS, Interval<Date>>();
    private List<RelatedPersonBean> supplyRequestReceiverPersonalRelationship = new ArrayList<RelatedPersonBean>();
    private CreatedAtBean supplyRequestLocation;
    private ToBeShippedToBean supplyRequestDestination;
    private List<ComponentBean> supplyRequestComponent = new ArrayList<ComponentBean>();

    @Hl7XmlMapping({"supplyRequest/effectiveTime"})
    public Interval<Date> getDispensingAllowedPeriod() {
        return this.dispensingAllowedPeriod.getValue();
    }
    public void setDispensingAllowedPeriod(Interval<Date> dispensingAllowedPeriod) {
        this.dispensingAllowedPeriod.setValue(dispensingAllowedPeriod);
    }

    @Hl7XmlMapping({"supplyRequest/receiver/personalRelationship"})
    public List<RelatedPersonBean> getSupplyRequestReceiverPersonalRelationship() {
        return this.supplyRequestReceiverPersonalRelationship;
    }

    @Hl7XmlMapping({"supplyRequest/location"})
    public CreatedAtBean getSupplyRequestLocation() {
        return this.supplyRequestLocation;
    }
    public void setSupplyRequestLocation(CreatedAtBean supplyRequestLocation) {
        this.supplyRequestLocation = supplyRequestLocation;
    }

    @Hl7XmlMapping({"supplyRequest/destination"})
    public ToBeShippedToBean getSupplyRequestDestination() {
        return this.supplyRequestDestination;
    }
    public void setSupplyRequestDestination(ToBeShippedToBean supplyRequestDestination) {
        this.supplyRequestDestination = supplyRequestDestination;
    }

    @Hl7XmlMapping({"supplyRequest/component"})
    public List<ComponentBean> getSupplyRequestComponent() {
        return this.supplyRequestComponent;
    }

}
