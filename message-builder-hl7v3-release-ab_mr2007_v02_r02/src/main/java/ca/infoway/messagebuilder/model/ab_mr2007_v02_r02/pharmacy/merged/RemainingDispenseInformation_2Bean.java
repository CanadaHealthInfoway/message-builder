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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>RemainingDispenseInformation</p>
 * 
 * <p>PORX_MT060040CA.SupplyEventFutureSummary: Remaining 
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
 * <p>PORX_MT060060CA.SupplyEventFutureSummary: Remaining 
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
@Hl7PartTypeMapping({"PORX_MT060040CA.SupplyEventFutureSummary","PORX_MT060060CA.SupplyEventFutureSummary"})
public class RemainingDispenseInformation_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20111208L;
    private INT repeatNumber = new INTImpl();
    private INT quantity = new INTImpl();


    /**
     * <p>FillsRemaining</p>
     * 
     * <p>A:Fills Remaining</p>
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
     * <p>RemainingTotalQuantity</p>
     * 
     * <p>B:Remaining Total Quantity</p>
     * 
     * <p><p>Indicates the total remaining undispensed quantity 
     * authorized against the prescription.</p></p>
     * 
     * <p><p>Indicates how much can still be dispensed.</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getQuantity() {
        return this.quantity.getValue();
    }
    public void setQuantity(Integer quantity) {
        this.quantity.setValue(quantity);
    }

}
