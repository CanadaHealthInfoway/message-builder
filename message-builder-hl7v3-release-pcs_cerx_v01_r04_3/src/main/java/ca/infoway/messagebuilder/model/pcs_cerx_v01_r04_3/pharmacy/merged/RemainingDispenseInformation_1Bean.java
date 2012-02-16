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
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>RemainingDispenseInformation</p>
 * 
 * <p>PORX_MT030040CA.SupplyEventFutureSummary: Remaining 
 * Dispense Information</p>
 * 
 * <p><p>At least one of quantity and repeatNumber must be 
 * specified.</p></p>
 * 
 * <p><p>Provides summary information about what dispenses 
 * remain to be performed against the prescription</p></p>
 * 
 * <p><p>Useful in understanding the status of a prescription 
 * and in planning for renewals.</p></p>
 * 
 * <p>PORX_MT060340CA.SupplyEventFutureSummary: Remaining 
 * Dispense Information</p>
 * 
 * <p><p>At least one of quantity and repeatNumber must be 
 * specified.</p></p>
 * 
 * <p><p>Provides summary information about what dispenses 
 * remain to be performed against the prescription</p></p>
 * 
 * <p><p>Useful in understanding the status of a prescription 
 * and in planning for renewals.</p></p>
 * 
 * <p>PORX_MT060160CA.SupplyEventFutureSummary: Remaining 
 * Dispense Information</p>
 * 
 * <p><p>At least one of quantity and repeatNumber must be 
 * specified.</p></p>
 * 
 * <p><p>Provides summary information about what dispenses 
 * remain to be performed against the prescription</p></p>
 * 
 * <p><p>Useful in understanding the status of a prescription 
 * and in planning for renewals.</p></p>
 * 
 * <p>PORX_MT060190CA.SupplyEventFutureSummary: Remaining 
 * Dispense Information</p>
 * 
 * <p><p>At least one of quantity and repeatNumber must be 
 * specified.</p></p>
 * 
 * <p><p>Provides summary information about what dispenses 
 * remain to be performed against the prescription</p></p>
 * 
 * <p><p>Useful in understanding the status of a prescription 
 * and in planning for renewals.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT030040CA.SupplyEventFutureSummary","PORX_MT060160CA.SupplyEventFutureSummary","PORX_MT060190CA.SupplyEventFutureSummary","PORX_MT060340CA.SupplyEventFutureSummary"})
public class RemainingDispenseInformation_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private INT repeatNumber = new INTImpl();
    private PQ quantity = new PQImpl();


    /**
     * <p>A:Fills Remaining</p>
     * 
     * <p><p>Indicates the number of remaining dispenses estimated, 
     * assuming that each fill is equal to the quantity prescribed 
     * for a single fill, rounding up.</p></p>
     * 
     * <p><p>Indicates the number of dispenses that may still 
     * occur.</p></p>
     * 
     * <p>A:Total Fills Remaining</p>
     * 
     * <p><p>Indicates the number of remaining dispenses estimated, 
     * assuming that each fill is equal to the quantity prescribed 
     * for a single fill, rounding up.</p></p>
     * 
     * <p><p>Indicates the number of dispenses that may still 
     * occur.</p></p>
     * 
     * <p>Fills Remaining</p>
     * 
     * <p><p>Indicates the number of remaining dispenses estimated, 
     * assuming that each fill is equal to the quantity prescribed 
     * for a single fill, rounding up.</p></p>
     * 
     * <p><p>Indicates the number of dispenses that may still 
     * occur.</p></p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getRepeatNumber() {
        return this.repeatNumber.getValue();
    }
    public void setRepeatNumber(Integer repeatNumber) {
        this.repeatNumber.setValue(repeatNumber);
    }


    /**
     * <p>Remaining Total Quantity</p>
     * 
     * <p><p>Indicates the total remaining undispensed quantity 
     * authorized against the prescription.</p></p>
     * 
     * <p><p>Indicates how much can still be dispensed.</p></p>
     * 
     * <p>B:Total Quantity Remaining</p>
     * 
     * <p><p>Indicates the total remaining undispensed quantity 
     * authorized against the prescription.</p></p>
     * 
     * <p><p>Indicates how much can still be dispensed.</p></p>
     * 
     * <p>B:Remaining Total Quantity</p>
     * 
     * <p><p>Indicates the total remaining undispensed quantity 
     * authorized against the prescription.</p></p>
     * 
     * <p><p>Indicates how much can still be dispensed.</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }

}
