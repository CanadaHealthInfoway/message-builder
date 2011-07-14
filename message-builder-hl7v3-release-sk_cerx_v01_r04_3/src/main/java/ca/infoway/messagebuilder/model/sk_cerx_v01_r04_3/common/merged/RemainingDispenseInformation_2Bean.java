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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged;

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
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
 * summary information about what dispenses remain to be 
 * performed against the prescription</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful in 
 * understanding the status of a prescription and in planning 
 * for renewals.</p></p>
 * 
 * <p>PORX_MT060060CA.SupplyEventFutureSummary: Remaining 
 * Dispense Information</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
 * summary information about what dispenses remain to be 
 * performed against the prescription</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful in 
 * understanding the status of a prescription and in planning 
 * for renewals.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060040CA.SupplyEventFutureSummary","PORX_MT060060CA.SupplyEventFutureSummary"})
public class RemainingDispenseInformation_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private INT fillsRemaining = new INTImpl();
    private INT remainingTotalQuantity = new INTImpl();


    /**
     * <p>FillsRemaining</p>
     * 
     * <p>A:Fills Remaining</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the number of remaining dispenses estimated, assuming that 
     * each fill is equal to the quantity prescribed for a single 
     * fill, rounding up.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the number of dispenses that may still occur.</p></p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getFillsRemaining() {
        return this.fillsRemaining.getValue();
    }
    public void setFillsRemaining(Integer fillsRemaining) {
        this.fillsRemaining.setValue(fillsRemaining);
    }


    /**
     * <p>RemainingTotalQuantity</p>
     * 
     * <p>B:Remaining Total Quantity</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the total remaining undispensed quantity authorized against 
     * the prescription.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * how much can still be dispensed.</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getRemainingTotalQuantity() {
        return this.remainingTotalQuantity.getValue();
    }
    public void setRemainingTotalQuantity(Integer remainingTotalQuantity) {
        this.remainingTotalQuantity.setValue(remainingTotalQuantity);
    }

}
