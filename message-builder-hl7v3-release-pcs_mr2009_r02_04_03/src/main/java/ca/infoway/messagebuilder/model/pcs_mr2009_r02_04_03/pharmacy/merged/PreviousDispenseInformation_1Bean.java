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
 * <p>Business Name: PreviousDispenseInformation</p>
 * 
 * <p>PORX_MT060190CA.SupplyEventPastSummary: Previous Dispense 
 * Information</p>
 * 
 * <p>At least one of quantity and repeatNumber must be 
 * specified.</p>
 * 
 * <p>Helps in understanding the status of the prescription and 
 * evaluating compliance.</p>
 * 
 * <p>Summarizes the dispenses that have happened against the 
 * prescription to date.</p>
 * 
 * <p>PORX_MT060340CA.SupplyEventPastSummary: Previous Dispense 
 * Information</p>
 * 
 * <p>At least one of quantity and repeatNumber must be 
 * specified.</p>
 * 
 * <p>Helps in understanding the status of the prescription and 
 * evaluating compliance.</p>
 * 
 * <p>Summarizes the dispenses that have happened against the 
 * prescription to date.</p>
 * 
 * <p>PORX_MT060160CA.SupplyEventPastSummary: Previous Dispense 
 * Information</p>
 * 
 * <p>At least one of quantity and repeatNumber must be 
 * specified.</p>
 * 
 * <p>Helps in understanding the status of the prescription and 
 * evaluating compliance.</p>
 * 
 * <p>Summarizes the dispenses that have happened against the 
 * prescription to date.</p>
 * 
 * <p>PORX_MT030040CA.SupplyEventPastSummary: Previous Dispense 
 * Information</p>
 * 
 * <p>At least one of quantity and repeatNumber must be 
 * specified.</p>
 * 
 * <p>Helps in understanding the status of the prescription and 
 * evaluating compliance.</p>
 * 
 * <p>Summarizes the dispenses that have happened against the 
 * prescription to date.</p>
 */
@Hl7PartTypeMapping({"PORX_MT030040CA.SupplyEventPastSummary","PORX_MT060160CA.SupplyEventPastSummary","PORX_MT060190CA.SupplyEventPastSummary","PORX_MT060340CA.SupplyEventPastSummary"})
public class PreviousDispenseInformation_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private INT repeatNumber = new INTImpl();
    private PQ quantity = new PQImpl();


    /**
     * <p>Un-merged Business Name: NumberOfFillsMadeAgainstRx</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190CA.SupplyEventPastSummary.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in tracking the progress of a prescription in 
     * prescription.</p>
     * 
     * <p>Indicates the number of dispense events performed against 
     * the prescription to date, including trial, partial and 
     * complete fills.</p>
     * 
     * <p>Un-merged Business Name: NumberOfFillsMadeAgainstRx</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SupplyEventPastSummary.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in tracking the progress of a prescription.</p>
     * 
     * <p>Indicates the number of dispense events performed against 
     * the prescription to date, including trial, partial and 
     * complete fills.</p>
     * 
     * <p>Un-merged Business Name: NumberOfFillMadeAgainstRx</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.SupplyEventPastSummary.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in tracking the progress of a prescription in 
     * prescription.</p>
     * 
     * <p>Indicates the number of dispense events performed against 
     * the prescription to date, including trial, partial and 
     * complete fills.</p>
     * 
     * <p>Un-merged Business Name: DispensedFillsToDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SupplyEventPastSummary.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in tracking the progress of a prescription in 
     * prescription.</p>
     * 
     * <p>Indicates the number of dispense events performed against 
     * the prescription to date, including trial, partial and 
     * complete fills.</p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getRepeatNumber() {
        return this.repeatNumber.getValue();
    }

    /**
     * <p>Un-merged Business Name: NumberOfFillsMadeAgainstRx</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190CA.SupplyEventPastSummary.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in tracking the progress of a prescription in 
     * prescription.</p>
     * 
     * <p>Indicates the number of dispense events performed against 
     * the prescription to date, including trial, partial and 
     * complete fills.</p>
     * 
     * <p>Un-merged Business Name: NumberOfFillsMadeAgainstRx</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SupplyEventPastSummary.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in tracking the progress of a prescription.</p>
     * 
     * <p>Indicates the number of dispense events performed against 
     * the prescription to date, including trial, partial and 
     * complete fills.</p>
     * 
     * <p>Un-merged Business Name: NumberOfFillMadeAgainstRx</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.SupplyEventPastSummary.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in tracking the progress of a prescription in 
     * prescription.</p>
     * 
     * <p>Indicates the number of dispense events performed against 
     * the prescription to date, including trial, partial and 
     * complete fills.</p>
     * 
     * <p>Un-merged Business Name: DispensedFillsToDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SupplyEventPastSummary.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in tracking the progress of a prescription in 
     * prescription.</p>
     * 
     * <p>Indicates the number of dispense events performed against 
     * the prescription to date, including trial, partial and 
     * complete fills.</p>
     */
    public void setRepeatNumber(Integer repeatNumber) {
        this.repeatNumber.setValue(repeatNumber);
    }


    /**
     * <p>Un-merged Business Name: TotalSuppliedAmount</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190CA.SupplyEventPastSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful for tracking the progress of a prescription.</p>
     * 
     * <p>Indicates the amount of medication that has been 
     * dispensed to date.</p>
     * 
     * <p>Un-merged Business Name: TotalSuppliedAmount</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SupplyEventPastSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful for tracking the progress of a prescription</p>
     * 
     * <p>Indicates the amount of the prescribed medication that 
     * has been dispensed to-date.</p>
     * 
     * <p>Un-merged Business Name: TotalSuppliedAmount</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.SupplyEventPastSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful for tracking the progress of a prescription</p>
     * 
     * <p>Indicates the amount of the prescribed medication that 
     * has been dispensed to-date.</p>
     * 
     * <p>Un-merged Business Name: DispensedQuantityToDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SupplyEventPastSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful for tracking the progress of a prescription</p>
     * 
     * <p>Depending on the Dispense Aggregate Information Type, 
     * this field would contain one of Remaining Total Quantity, 
     * First Quantity Dispensed, Last Quantity Dispensed, or Total 
     * Supplied Amount.</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Un-merged Business Name: TotalSuppliedAmount</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190CA.SupplyEventPastSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful for tracking the progress of a prescription.</p>
     * 
     * <p>Indicates the amount of medication that has been 
     * dispensed to date.</p>
     * 
     * <p>Un-merged Business Name: TotalSuppliedAmount</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SupplyEventPastSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful for tracking the progress of a prescription</p>
     * 
     * <p>Indicates the amount of the prescribed medication that 
     * has been dispensed to-date.</p>
     * 
     * <p>Un-merged Business Name: TotalSuppliedAmount</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.SupplyEventPastSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful for tracking the progress of a prescription</p>
     * 
     * <p>Indicates the amount of the prescribed medication that 
     * has been dispensed to-date.</p>
     * 
     * <p>Un-merged Business Name: DispensedQuantityToDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SupplyEventPastSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful for tracking the progress of a prescription</p>
     * 
     * <p>Depending on the Dispense Aggregate Information Type, 
     * this field would contain one of Remaining Total Quantity, 
     * First Quantity Dispensed, Last Quantity Dispensed, or Total 
     * Supplied Amount.</p>
     */
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }

}
