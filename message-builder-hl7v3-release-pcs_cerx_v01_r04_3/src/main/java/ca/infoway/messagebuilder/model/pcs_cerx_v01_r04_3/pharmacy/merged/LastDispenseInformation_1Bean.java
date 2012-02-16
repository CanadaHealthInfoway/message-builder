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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>LastDispenseInformation</p>
 * 
 * <p>PORX_MT060160CA.SupplyEventLastSummary: Last Dispense 
 * Information</p>
 * 
 * <p><p>Provides summary information about the most recent 
 * dispense event performed against the prescription</p></p>
 * 
 * <p><p>Useful in understanding the status of a prescription 
 * and in planning for renewals.</p></p>
 * 
 * <p>PORX_MT060190CA.SupplyEventLastSummary: Last Dispense 
 * Information</p>
 * 
 * <p><p>Provides summary information about the most recent 
 * dispense event performed against the prescription</p></p>
 * 
 * <p><p>Useful in understanding the status of a prescription 
 * and in planning for renewals.</p></p>
 * 
 * <p>PORX_MT060340CA.SupplyEventLastSummary: Last Dispense 
 * Information</p>
 * 
 * <p><p>Provides summary information about the most recent 
 * dispense event performed against the prescription</p></p>
 * 
 * <p><p>Useful in understanding the status of a prescription 
 * and in planning for renewals.</p></p>
 * 
 * <p>PORX_MT030040CA.SupplyEventLastSummary: Last Dispense 
 * Information</p>
 * 
 * <p><p>Provides summary information about the most recent 
 * dispense event performed against the prescription</p></p>
 * 
 * <p><p>Useful in understanding the status of a prescription 
 * and in planning for renewals.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT030040CA.SupplyEventLastSummary","PORX_MT060160CA.SupplyEventLastSummary","PORX_MT060190CA.SupplyEventLastSummary","PORX_MT060340CA.SupplyEventLastSummary"})
public class LastDispenseInformation_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private PQ quantity = new PQImpl();


    /**
     * <p>LastDispensePickupDate</p>
     * 
     * <p>Last Dispense Pickup Date</p>
     * 
     * <p><p>Indicates the most recent date on which a dispense on 
     * the prescription was picked up.</p></p>
     * 
     * <p><p>Useful in determining when a prescription will next 
     * need to be dispensed. Also provides an indication of 
     * compliance.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Last Quantity Dispensed.</p>
     * 
     * <p><p>Indicates the most recent quantity of the drug that 
     * was picked up for the prescription.</p></p>
     * 
     * <p><p>Useful in determining amount of medication that a 
     * patient should have on-hand. Also provides an indication of 
     * compliance.</p><p>If the most recent dispense information is 
     * known, the quantity must be known and therefore is 
     * mandatory</p></p>
     * 
     * <p><p>Useful in determining amount of medication that a 
     * patient should have on-hand. Also provides an indication of 
     * compliance.</p><p>If the most recent dispense information is 
     * known, the quantity must be known and therefore is 
     * mandatory</p></p>
     * 
     * <p>Last Dispense Quantity</p>
     * 
     * <p><p>Indicates the most recent quantity of the drug that 
     * was picked up for the prescription.</p></p>
     * 
     * <p><p>Useful in determining amount of medication that a 
     * patient should have on-hand. Also provides an indication of 
     * compliance.</p><p>Because the quantity should always be 
     * known if the last dispense is known, this attribute is 
     * mandatory.</p></p>
     * 
     * <p><p>Useful in determining amount of medication that a 
     * patient should have on-hand. Also provides an indication of 
     * compliance.</p><p>Because the quantity should always be 
     * known if the last dispense is known, this attribute is 
     * mandatory.</p></p>
     * 
     * <p>Last Quantity Dispensed</p>
     * 
     * <p><p>Indicates the most recent quantity of the drug that 
     * was picked up for the prescription.</p></p>
     * 
     * <p><p>Useful in determining the amount of medication that a 
     * patient should have on-hand. Also provides an indication of 
     * compliance.</p><p>Because the quantity should always be 
     * known if the last dispense is known, this attribute is 
     * mandatory.</p></p>
     * 
     * <p><p>Useful in determining the amount of medication that a 
     * patient should have on-hand. Also provides an indication of 
     * compliance.</p><p>Because the quantity should always be 
     * known if the last dispense is known, this attribute is 
     * mandatory.</p></p>
     * 
     * <p>Last Quantity Dispensed</p>
     * 
     * <p><p>Indicates the most recent quantity of the drug that 
     * was picked up for the prescription.</p></p>
     * 
     * <p><p>Useful in determining amount of medication that a 
     * patient should have on-hand. Also provides an indication of 
     * compliance.</p><p>Because the quantity should always be 
     * known if the last dispense is known, this attribute is 
     * mandatory.</p></p>
     * 
     * <p><p>Useful in determining amount of medication that a 
     * patient should have on-hand. Also provides an indication of 
     * compliance.</p><p>Because the quantity should always be 
     * known if the last dispense is known, this attribute is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }

}
