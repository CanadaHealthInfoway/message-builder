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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>PreviousDispenseInformation</p>
 * 
 * <p>PORX_MT060060CA.SupplyEventPastSummary: Previous Dispense 
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
 * <p>PORX_MT060040CA.SupplyEventPastSummary: Previous Dispense 
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
@Hl7PartTypeMapping({"PORX_MT060040CA.SupplyEventPastSummary","PORX_MT060060CA.SupplyEventPastSummary"})
public class PreviousDispenseInformation_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private INT numberOfFillsMadeAgainstRx = new INTImpl();
    private INT totalSuppliedAmount = new INTImpl();


    /**
     * <p>NumberOfFillsMadeAgainstRx</p>
     * 
     * <p>A:Number of Fills Made Against Rx</p>
     * 
     * <p><p>Indicates the number of dispense events performed 
     * against the prescription to date, including trial, partial 
     * and complete fills.</p></p>
     * 
     * <p><p>Useful in tracking the progress of a prescription in 
     * prescription.</p></p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getNumberOfFillsMadeAgainstRx() {
        return this.numberOfFillsMadeAgainstRx.getValue();
    }
    public void setNumberOfFillsMadeAgainstRx(Integer numberOfFillsMadeAgainstRx) {
        this.numberOfFillsMadeAgainstRx.setValue(numberOfFillsMadeAgainstRx);
    }


    /**
     * <p>TotalSuppliedAmount</p>
     * 
     * <p>B:Total Supplied Amount</p>
     * 
     * <p><p>Indicates the amount of the prescribed medication that 
     * has been dispensed to-date.</p></p>
     * 
     * <p><p>Useful for tracking the progress of a 
     * prescription.</p></p>
     * 
     * <p>B:Total Supplied Amount</p>
     * 
     * <p><p>Indicates the number of the prescribed devices that 
     * has been dispensed to-date.</p></p>
     * 
     * <p><p>Useful for tracking the progress of a prescription</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getTotalSuppliedAmount() {
        return this.totalSuppliedAmount.getValue();
    }
    public void setTotalSuppliedAmount(Integer totalSuppliedAmount) {
        this.totalSuppliedAmount.setValue(totalSuppliedAmount);
    }

}
