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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Business Name: FirstDispenseInformation</p>
 * 
 * <p>PORX_MT060060CA.SupplyEventFirstSummary: First Dispense 
 * Information</p>
 * 
 * <p>Provides summary information about the first dispense 
 * event on the prescription</p>
 * 
 * <p>Useful in understanding the status of a prescription and 
 * in planning for renewals.</p>
 * 
 * <p>PORX_MT060040CA.SupplyEventFirstSummary: First Dispense 
 * Information</p>
 * 
 * <p>Provides summary information about the first dispense 
 * event on the prescription</p>
 * 
 * <p>Useful in understanding the status of a prescription and 
 * in planning for renewals.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060040CA.SupplyEventFirstSummary","PORX_MT060060CA.SupplyEventFirstSummary"})
public class FirstDispenseInformation_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private INT quantity = new INTImpl();


    /**
     * <p>Business Name: FirstDispensePickupDate</p>
     * 
     * <p>Un-merged Business Name: FirstDispensePickupDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060060CA.SupplyEventFirstSummary.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates when the first dispense against the 
     * prescription was picked up.</p>
     * 
     * <p>Useful in establishing start of therapy.</p><p>Important 
     * information for compliance.</p>
     * 
     * <p>Useful in establishing start of therapy.</p><p>Important 
     * information for compliance.</p>
     * 
     * <p>Un-merged Business Name: FirstDispensePickupDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.SupplyEventFirstSummary.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates when the first dispense against the 
     * prescription was picked up.</p>
     * 
     * <p>Useful in establishing start of therapy.</p><p>Important 
     * information for compliance.</p>
     * 
     * <p>Useful in establishing start of therapy.</p><p>Important 
     * information for compliance.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: FirstDispensePickupDate</p>
     * 
     * <p>Un-merged Business Name: FirstDispensePickupDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060060CA.SupplyEventFirstSummary.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates when the first dispense against the 
     * prescription was picked up.</p>
     * 
     * <p>Useful in establishing start of therapy.</p><p>Important 
     * information for compliance.</p>
     * 
     * <p>Useful in establishing start of therapy.</p><p>Important 
     * information for compliance.</p>
     * 
     * <p>Un-merged Business Name: FirstDispensePickupDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.SupplyEventFirstSummary.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates when the first dispense against the 
     * prescription was picked up.</p>
     * 
     * <p>Useful in establishing start of therapy.</p><p>Important 
     * information for compliance.</p>
     * 
     * <p>Useful in establishing start of therapy.</p><p>Important 
     * information for compliance.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: FirstQuantityDispensed</p>
     * 
     * <p>Un-merged Business Name: FirstQuantityDispensed</p>
     * 
     * <p>Relationship: 
     * PORX_MT060060CA.SupplyEventFirstSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the number of devices first dispensed on the 
     * prescription.</p>
     * 
     * <p>Usually establishes trial quantities for a 
     * prescription.</p><p>Because the quantity should always be 
     * known if the first dispense is known, this attribute is 
     * mandatory.</p>
     * 
     * <p>Usually establishes trial quantities for a 
     * prescription.</p><p>Because the quantity should always be 
     * known if the first dispense is known, this attribute is 
     * mandatory.</p>
     * 
     * <p>Un-merged Business Name: FirstQuantityDispensed</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.SupplyEventFirstSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the amount of device first dispensed on the 
     * prescription.</p>
     * 
     * <p>Usually establishes trial quantities for a prescription. 
     * If the first dispense is known, then the quantity must be 
     * known, thus the element is mandatory.</p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Business Name: FirstQuantityDispensed</p>
     * 
     * <p>Un-merged Business Name: FirstQuantityDispensed</p>
     * 
     * <p>Relationship: 
     * PORX_MT060060CA.SupplyEventFirstSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the number of devices first dispensed on the 
     * prescription.</p>
     * 
     * <p>Usually establishes trial quantities for a 
     * prescription.</p><p>Because the quantity should always be 
     * known if the first dispense is known, this attribute is 
     * mandatory.</p>
     * 
     * <p>Usually establishes trial quantities for a 
     * prescription.</p><p>Because the quantity should always be 
     * known if the first dispense is known, this attribute is 
     * mandatory.</p>
     * 
     * <p>Un-merged Business Name: FirstQuantityDispensed</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.SupplyEventFirstSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the amount of device first dispensed on the 
     * prescription.</p>
     * 
     * <p>Usually establishes trial quantities for a prescription. 
     * If the first dispense is known, then the quantity must be 
     * known, thus the element is mandatory.</p>
     */
    public void setQuantity(Integer quantity) {
        this.quantity.setValue(quantity);
    }

}
