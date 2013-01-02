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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged;

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
 * <p>Business Name: LastDispenseInformation</p>
 * 
 * <p>PORX_MT060160CA.SupplyEventLastSummary: Last Dispense 
 * Information</p>
 * 
 * <p>Provides summary information about the most recent 
 * dispense event performed against the prescription</p>
 * 
 * <p>Useful in understanding the status of a prescription and 
 * in planning for renewals.</p>
 * 
 * <p>PORX_MT060190CA.SupplyEventLastSummary: Last Dispense 
 * Information</p>
 * 
 * <p>Provides summary information about the most recent 
 * dispense event performed against the prescription</p>
 * 
 * <p>Useful in understanding the status of a prescription and 
 * in planning for renewals.</p>
 * 
 * <p>PORX_MT060340CA.SupplyEventLastSummary: Last Dispense 
 * Information</p>
 * 
 * <p>Provides summary information about the most recent 
 * dispense event performed against the prescription</p>
 * 
 * <p>Useful in understanding the status of a prescription and 
 * in planning for renewals.</p>
 * 
 * <p>PORX_MT030040CA.SupplyEventLastSummary: Last Dispense 
 * Information</p>
 * 
 * <p>Provides summary information about the most recent 
 * dispense event performed against the prescription</p>
 * 
 * <p>Useful in understanding the status of a prescription and 
 * in planning for renewals.</p>
 */
@Hl7PartTypeMapping({"PORX_MT030040CA.SupplyEventLastSummary","PORX_MT060160CA.SupplyEventLastSummary","PORX_MT060190CA.SupplyEventLastSummary","PORX_MT060340CA.SupplyEventLastSummary"})
public class LastDispenseInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private PQ quantity = new PQImpl();


    /**
     * <p>Business Name: LastDispensePickupDate</p>
     * 
     * <p>Un-merged Business Name: LastDispensePickupDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SupplyEventLastSummary.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the most recent date on which a dispense on the 
     * prescription was picked up.</p>
     * 
     * <p>Useful in determining when a prescription will next need 
     * to be dispensed. Also provides an indication of 
     * compliance.</p>
     * 
     * <p>Un-merged Business Name: LastDispensePickupDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190CA.SupplyEventLastSummary.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the most recent date on which a dispense on the 
     * prescription was picked up.</p>
     * 
     * <p>Useful in determining when a prescription will next need 
     * to be dispensed. Also provides an indication of 
     * compliance.</p>
     * 
     * <p>Un-merged Business Name: LastDispensePickupDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.SupplyEventLastSummary.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the most recent date on which a dispense on the 
     * prescription was picked up.</p>
     * 
     * <p>Useful in determining when a prescription will next need 
     * to be dispensed. Also provides an indication of 
     * compliance.</p>
     * 
     * <p>Un-merged Business Name: LastDispensePickupDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SupplyEventLastSummary.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the most recent date on which a dispense on the 
     * prescription was picked up.</p>
     * 
     * <p>Useful in determining when a prescription will next need 
     * to be dispensed. Also provides an indication of 
     * compliance.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: LastDispensePickupDate</p>
     * 
     * <p>Un-merged Business Name: LastDispensePickupDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SupplyEventLastSummary.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the most recent date on which a dispense on the 
     * prescription was picked up.</p>
     * 
     * <p>Useful in determining when a prescription will next need 
     * to be dispensed. Also provides an indication of 
     * compliance.</p>
     * 
     * <p>Un-merged Business Name: LastDispensePickupDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190CA.SupplyEventLastSummary.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the most recent date on which a dispense on the 
     * prescription was picked up.</p>
     * 
     * <p>Useful in determining when a prescription will next need 
     * to be dispensed. Also provides an indication of 
     * compliance.</p>
     * 
     * <p>Un-merged Business Name: LastDispensePickupDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.SupplyEventLastSummary.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the most recent date on which a dispense on the 
     * prescription was picked up.</p>
     * 
     * <p>Useful in determining when a prescription will next need 
     * to be dispensed. Also provides an indication of 
     * compliance.</p>
     * 
     * <p>Un-merged Business Name: LastDispensePickupDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SupplyEventLastSummary.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the most recent date on which a dispense on the 
     * prescription was picked up.</p>
     * 
     * <p>Useful in determining when a prescription will next need 
     * to be dispensed. Also provides an indication of 
     * compliance.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Un-merged Business Name: LastQuantityDispensed</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SupplyEventLastSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the most recent quantity of the drug that was 
     * picked up for the prescription.</p>
     * 
     * <p>Useful in determining the amount of medication that a 
     * patient should have on-hand. Also provides an indication of 
     * compliance.</p><p>Because the quantity should always be 
     * known if the last dispense is known, this attribute is 
     * mandatory.</p>
     * 
     * <p>Useful in determining the amount of medication that a 
     * patient should have on-hand. Also provides an indication of 
     * compliance.</p><p>Because the quantity should always be 
     * known if the last dispense is known, this attribute is 
     * mandatory.</p>
     * 
     * <p>Un-merged Business Name: LastDispenseQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190CA.SupplyEventLastSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the most recent quantity of the drug that was 
     * picked up for the prescription.</p>
     * 
     * <p>Useful in determining amount of medication that a patient 
     * should have on-hand. Also provides an indication of 
     * compliance.</p><p>Because the quantity should always be 
     * known if the last dispense is known, this attribute is 
     * mandatory.</p>
     * 
     * <p>Useful in determining amount of medication that a patient 
     * should have on-hand. Also provides an indication of 
     * compliance.</p><p>Because the quantity should always be 
     * known if the last dispense is known, this attribute is 
     * mandatory.</p>
     * 
     * <p>Un-merged Business Name: LastQuantityDispensed</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.SupplyEventLastSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the most recent quantity of the drug that was 
     * picked up for the prescription.</p>
     * 
     * <p>Useful in determining amount of medication that a patient 
     * should have on-hand. Also provides an indication of 
     * compliance.</p><p>If the most recent dispense information is 
     * known, the quantity must be known and therefore is 
     * mandatory</p>
     * 
     * <p>Useful in determining amount of medication that a patient 
     * should have on-hand. Also provides an indication of 
     * compliance.</p><p>If the most recent dispense information is 
     * known, the quantity must be known and therefore is 
     * mandatory</p>
     * 
     * <p>Un-merged Business Name: LastQuantityDispensed</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SupplyEventLastSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the most recent quantity of the drug that was 
     * picked up for the prescription.</p>
     * 
     * <p>Useful in determining amount of medication that a patient 
     * should have on-hand. Also provides an indication of 
     * compliance.</p><p>Because the quantity should always be 
     * known if the last dispense is known, this attribute is 
     * mandatory.</p>
     * 
     * <p>Useful in determining amount of medication that a patient 
     * should have on-hand. Also provides an indication of 
     * compliance.</p><p>Because the quantity should always be 
     * known if the last dispense is known, this attribute is 
     * mandatory.</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Un-merged Business Name: LastQuantityDispensed</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SupplyEventLastSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the most recent quantity of the drug that was 
     * picked up for the prescription.</p>
     * 
     * <p>Useful in determining the amount of medication that a 
     * patient should have on-hand. Also provides an indication of 
     * compliance.</p><p>Because the quantity should always be 
     * known if the last dispense is known, this attribute is 
     * mandatory.</p>
     * 
     * <p>Useful in determining the amount of medication that a 
     * patient should have on-hand. Also provides an indication of 
     * compliance.</p><p>Because the quantity should always be 
     * known if the last dispense is known, this attribute is 
     * mandatory.</p>
     * 
     * <p>Un-merged Business Name: LastDispenseQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190CA.SupplyEventLastSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the most recent quantity of the drug that was 
     * picked up for the prescription.</p>
     * 
     * <p>Useful in determining amount of medication that a patient 
     * should have on-hand. Also provides an indication of 
     * compliance.</p><p>Because the quantity should always be 
     * known if the last dispense is known, this attribute is 
     * mandatory.</p>
     * 
     * <p>Useful in determining amount of medication that a patient 
     * should have on-hand. Also provides an indication of 
     * compliance.</p><p>Because the quantity should always be 
     * known if the last dispense is known, this attribute is 
     * mandatory.</p>
     * 
     * <p>Un-merged Business Name: LastQuantityDispensed</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.SupplyEventLastSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the most recent quantity of the drug that was 
     * picked up for the prescription.</p>
     * 
     * <p>Useful in determining amount of medication that a patient 
     * should have on-hand. Also provides an indication of 
     * compliance.</p><p>If the most recent dispense information is 
     * known, the quantity must be known and therefore is 
     * mandatory</p>
     * 
     * <p>Useful in determining amount of medication that a patient 
     * should have on-hand. Also provides an indication of 
     * compliance.</p><p>If the most recent dispense information is 
     * known, the quantity must be known and therefore is 
     * mandatory</p>
     * 
     * <p>Un-merged Business Name: LastQuantityDispensed</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SupplyEventLastSummary.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the most recent quantity of the drug that was 
     * picked up for the prescription.</p>
     * 
     * <p>Useful in determining amount of medication that a patient 
     * should have on-hand. Also provides an indication of 
     * compliance.</p><p>Because the quantity should always be 
     * known if the last dispense is known, this attribute is 
     * mandatory.</p>
     * 
     * <p>Useful in determining amount of medication that a patient 
     * should have on-hand. Also provides an indication of 
     * compliance.</p><p>Because the quantity should always be 
     * known if the last dispense is known, this attribute is 
     * mandatory.</p>
     */
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }

}
