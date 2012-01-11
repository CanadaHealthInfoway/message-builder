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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>PreviousDispenseInformation</p>
 * 
 * <p>PORX_MT060190CA.SupplyEventPastSummary: Previous Dispense 
 * Information</p>
 * 
 * <p><p>At least one of quantity and repeatNumber must be 
 * specified.</p></p>
 * 
 * <p><p>Summarizes the dispenses that have happened against 
 * the prescription to date.</p></p>
 * 
 * <p><p>Helps in understanding the status of the prescription 
 * and evaluating compliance.</p></p>
 * 
 * <p>PORX_MT060340CA.SupplyEventPastSummary: Previous Dispense 
 * Information</p>
 * 
 * <p><p>At least one of quantity and repeatNumber must be 
 * specified.</p></p>
 * 
 * <p><p>Summarizes the dispenses that have happened against 
 * the prescription to date.</p></p>
 * 
 * <p><p>Helps in understanding the status of the prescription 
 * and evaluating compliance.</p></p>
 * 
 * <p>PORX_MT060160CA.SupplyEventPastSummary: Previous Dispense 
 * Information</p>
 * 
 * <p><p>At least one of quantity and repeatNumber must be 
 * specified.</p></p>
 * 
 * <p><p>Summarizes the dispenses that have happened against 
 * the prescription to date.</p></p>
 * 
 * <p><p>Helps in understanding the status of the prescription 
 * and evaluating compliance.</p></p>
 * 
 * <p>PORX_MT030040CA.SupplyEventPastSummary: Previous Dispense 
 * Information</p>
 * 
 * <p><p>At least one of quantity and repeatNumber must be 
 * specified.</p></p>
 * 
 * <p><p>Summarizes the dispenses that have happened against 
 * the prescription to date.</p></p>
 * 
 * <p><p>Helps in understanding the status of the prescription 
 * and evaluating compliance.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT030040CA.SupplyEventPastSummary","PORX_MT060160CA.SupplyEventPastSummary","PORX_MT060190CA.SupplyEventPastSummary","PORX_MT060340CA.SupplyEventPastSummary"})
public class PreviousDispenseInformation_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private INT repeatNumber = new INTImpl();
    private PQ quantity = new PQImpl();


    /**
     * <p>Number of Fills Made Against Rx</p>
     * 
     * <p><p>Indicates the number of dispense events performed 
     * against the prescription to date, including trial, partial 
     * and complete fills.</p></p>
     * 
     * <p><p>Useful in tracking the progress of a prescription in 
     * prescription.</p></p>
     * 
     * <p>A:Dispensed Fills To-date</p>
     * 
     * <p><p>Indicates the number of dispense events performed 
     * against the prescription to date, including trial, partial 
     * and complete fills.</p></p>
     * 
     * <p><p>Useful in tracking the progress of a prescription in 
     * prescription.</p></p>
     * 
     * <p>A:Number of Fills Made Against Rx</p>
     * 
     * <p><p>Indicates the number of dispense events performed 
     * against the prescription to date, including trial, partial 
     * and complete fills.</p></p>
     * 
     * <p><p>Useful in tracking the progress of a prescription.</p></p>
     * 
     * <p>A:Number of Fill Made Against Rx</p>
     * 
     * <p><p>Indicates the number of dispense events performed 
     * against the prescription to date, including trial, partial 
     * and complete fills.</p></p>
     * 
     * <p><p>Useful in tracking the progress of a prescription in 
     * prescription.</p></p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getRepeatNumber() {
        return this.repeatNumber.getValue();
    }
    public void setRepeatNumber(Integer repeatNumber) {
        this.repeatNumber.setValue(repeatNumber);
    }


    /**
     * <p>B:Total Supplied Amount</p>
     * 
     * <p><p>Indicates the amount of the prescribed medication that 
     * has been dispensed to-date.</p></p>
     * 
     * <p><p>Useful for tracking the progress of a prescription</p></p>
     * 
     * <p>B:Dispensed Quantity To-date</p>
     * 
     * <p><p>Depending on the Dispense Aggregate Information Type, 
     * this field would contain one of Remaining Total Quantity, 
     * First Quantity Dispensed, Last Quantity Dispensed, or Total 
     * Supplied Amount.</p></p>
     * 
     * <p><p>Useful for tracking the progress of a prescription</p></p>
     * 
     * <p>Total Supplied Amount</p>
     * 
     * <p><p>Indicates the amount of medication that has been 
     * dispensed to date.</p></p>
     * 
     * <p><p>Useful for tracking the progress of a 
     * prescription.</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }

}
