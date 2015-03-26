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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: RemainingDispenseInformation</p>
 * 
 * <p>PORX_MT030040ON.SupplyEventFutureSummary: Remaining 
 * Dispense Information</p>
 * 
 * <p>At least one of quantity and repeatNumber must be 
 * specified.</p>
 * 
 * <p>Useful in understanding the status of a prescription and 
 * in planning for renewals.</p>
 * 
 * <p>Provides summary information about what dispenses remain 
 * to be performed against the prescription</p>
 * 
 * <p>PORX_MT060190ON.SupplyEventFutureSummary: Remaining 
 * Dispense Information</p>
 * 
 * <p>At least one of quantity and repeatNumber must be 
 * specified.</p>
 * 
 * <p>Useful in understanding the status of a prescription and 
 * in planning for renewals.</p>
 * 
 * <p>Provides summary information about what dispenses remain 
 * to be performed against the prescription</p>
 * 
 * <p>PORX_MT060340ON.SupplyEventFutureSummary: Remaining 
 * Dispense Information</p>
 * 
 * <p>At least one of quantity and repeatNumber must be 
 * specified.</p>
 * 
 * <p>Useful in understanding the status of a prescription and 
 * in planning for renewals.</p>
 * 
 * <p>Provides summary information about what dispenses remain 
 * to be performed against the prescription</p>
 * 
 * <p>PORX_MT060160ON.SupplyEventFutureSummary: Remaining 
 * Dispense Information</p>
 * 
 * <p>At least one of quantity and repeatNumber must be 
 * specified.</p>
 * 
 * <p>Useful in understanding the status of a prescription and 
 * in planning for renewals.</p>
 * 
 * <p>Provides summary information about what dispenses remain 
 * to be performed against the prescription</p>
 */
@Hl7PartTypeMapping({"PORX_MT030040ON.SupplyEventFutureSummary","PORX_MT060160ON.SupplyEventFutureSummary","PORX_MT060190ON.SupplyEventFutureSummary","PORX_MT060340ON.SupplyEventFutureSummary"})
public class RemainingDispenseInformation_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private INT repeatNumber = new INTImpl();
    private PQ quantity = new PQImpl();


    /**
     * <p>Un-merged Business Name: FillsRemaining</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040ON.SupplyEventFutureSummary.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the number of dispenses that may still 
     * occur.</p>
     * 
     * <p>Indicates the number of remaining dispenses estimated, 
     * assuming that each fill is equal to the quantity prescribed 
     * for a single fill, rounding up.</p>
     * 
     * <p>Un-merged Business Name: FillsRemaining</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190ON.SupplyEventFutureSummary.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the number of dispenses that may still 
     * occur.</p>
     * 
     * <p>Indicates the number of remaining dispenses estimated, 
     * assuming that each fill is equal to the quantity prescribed 
     * for a single fill, rounding up.</p>
     * 
     * <p>Un-merged Business Name: FillsRemaining</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.SupplyEventFutureSummary.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the number of dispenses that may still 
     * occur.</p>
     * 
     * <p>Indicates the number of remaining dispenses estimated, 
     * assuming that each fill is equal to the quantity prescribed 
     * for a single fill, rounding up.</p>
     * 
     * <p>Un-merged Business Name: TotalFillsRemaining</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160ON.SupplyEventFutureSummary.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the number of dispenses that may still 
     * occur.</p>
     * 
     * <p>Indicates the number of remaining dispenses estimated, 
     * assuming that each fill is equal to the quantity prescribed 
     * for a single fill, rounding up.</p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getRepeatNumber() {
        return this.repeatNumber.getValue();
    }

    /**
     * <p>Un-merged Business Name: FillsRemaining</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040ON.SupplyEventFutureSummary.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the number of dispenses that may still 
     * occur.</p>
     * 
     * <p>Indicates the number of remaining dispenses estimated, 
     * assuming that each fill is equal to the quantity prescribed 
     * for a single fill, rounding up.</p>
     * 
     * <p>Un-merged Business Name: FillsRemaining</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190ON.SupplyEventFutureSummary.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the number of dispenses that may still 
     * occur.</p>
     * 
     * <p>Indicates the number of remaining dispenses estimated, 
     * assuming that each fill is equal to the quantity prescribed 
     * for a single fill, rounding up.</p>
     * 
     * <p>Un-merged Business Name: FillsRemaining</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.SupplyEventFutureSummary.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the number of dispenses that may still 
     * occur.</p>
     * 
     * <p>Indicates the number of remaining dispenses estimated, 
     * assuming that each fill is equal to the quantity prescribed 
     * for a single fill, rounding up.</p>
     * 
     * <p>Un-merged Business Name: TotalFillsRemaining</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160ON.SupplyEventFutureSummary.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the number of dispenses that may still 
     * occur.</p>
     * 
     * <p>Indicates the number of remaining dispenses estimated, 
     * assuming that each fill is equal to the quantity prescribed 
     * for a single fill, rounding up.</p>
     */
    public void setRepeatNumber(Integer repeatNumber) {
        this.repeatNumber.setValue(repeatNumber);
    }


    /**
     * <p>Un-merged Business Name: RemainingTotalQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040ON.SupplyEventFutureSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates how much can still be dispensed.</p>
     * 
     * <p>Indicates the total remaining undispensed quantity 
     * authorized against the prescription.</p>
     * 
     * <p>Un-merged Business Name: RemainingTotalQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190ON.SupplyEventFutureSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates how much can still be dispensed.</p>
     * 
     * <p>Indicates the total remaining undispensed quantity 
     * authorized against the prescription.</p>
     * 
     * <p>Un-merged Business Name: RemainingTotalQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.SupplyEventFutureSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates how much can still be dispensed.</p>
     * 
     * <p>Indicates the total remaining undispensed quantity 
     * authorized against the prescription.</p>
     * 
     * <p>Un-merged Business Name: TotalQuantityRemaining</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160ON.SupplyEventFutureSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates how much can still be dispensed.</p>
     * 
     * <p>Indicates the total remaining undispensed quantity 
     * authorized against the prescription.</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Un-merged Business Name: RemainingTotalQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040ON.SupplyEventFutureSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates how much can still be dispensed.</p>
     * 
     * <p>Indicates the total remaining undispensed quantity 
     * authorized against the prescription.</p>
     * 
     * <p>Un-merged Business Name: RemainingTotalQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190ON.SupplyEventFutureSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates how much can still be dispensed.</p>
     * 
     * <p>Indicates the total remaining undispensed quantity 
     * authorized against the prescription.</p>
     * 
     * <p>Un-merged Business Name: RemainingTotalQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.SupplyEventFutureSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates how much can still be dispensed.</p>
     * 
     * <p>Indicates the total remaining undispensed quantity 
     * authorized against the prescription.</p>
     * 
     * <p>Un-merged Business Name: TotalQuantityRemaining</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160ON.SupplyEventFutureSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates how much can still be dispensed.</p>
     * 
     * <p>Indicates the total remaining undispensed quantity 
     * authorized against the prescription.</p>
     */
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }

}
