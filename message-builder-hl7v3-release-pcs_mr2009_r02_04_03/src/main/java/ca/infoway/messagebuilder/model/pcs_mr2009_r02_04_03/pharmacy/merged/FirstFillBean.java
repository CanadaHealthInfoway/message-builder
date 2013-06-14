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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pharmacy.merged;

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
 * <p>Business Name: FirstFill</p>
 * 
 * <p>PORX_MT060160CA.InitialSupplyRequest: First Fill</p>
 * 
 * <p>Allows a different amount to be dispensed on an initial 
 * fill, either as a trial or to synchronize refill dates 
 * across multiple patient prescriptions</p>
 * 
 * <p>Special instructions regarding the very first supply of 
 * medication to a patient.</p>
 * 
 * <p>PORX_MT010120CA.InitialSupplyRequest: First Fill</p>
 * 
 * <p>Allows a different amount to be dispensed on an initial 
 * fill, either as a trial or to synchronize refill dates 
 * across multiple patient prescriptions.</p>
 * 
 * <p>Special instructions regarding the very first supply of 
 * medication to a patient.</p>
 * 
 * <p>PORX_MT060340CA.InitialSupplyRequest: First Fill</p>
 * 
 * <p>Allows a different amount to be dispensed on an initial 
 * fill, either as a trial or to synchronize refill dates 
 * across multiple patient prescriptions</p>
 * 
 * <p>Special instructions regarding the very first supply of 
 * medication to a patient.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.InitialSupplyRequest","PORX_MT060160CA.InitialSupplyRequest","PORX_MT060340CA.InitialSupplyRequest"})
public class FirstFillBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private PQ quantity = new PQImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>Business Name: FirstFillExpiryDate</p>
     * 
     * <p>Un-merged Business Name: FirstFillExpiryDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.InitialSupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Some jurisdictions have distinct stale-date periods for 
     * the initial fill of a prescription from the overall 
     * dispensing of the prescription. E.g. &quot;The first fill 
     * must be made within 1 year, all fills must be complete 
     * within 1.5 years&quot;. (This attribute would be used for 
     * the &quot;1 year&quot;.)</p>
     * 
     * <p>The date before which an initial dispense can be made 
     * against the prescription. If an initial fill has not been 
     * made against the prescription in this time-period, it may 
     * not be dispensed.</p>
     * 
     * <p>Un-merged Business Name: FirstFillExpiryDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.InitialSupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Some jurisdictions have distinct stale-date periods for 
     * the initial fill of a prescription from the overall 
     * dispensing of the prescription. E.g. &quot;The first fill 
     * must be made within 1 year, all fills must be complete 
     * within 1.5 years&quot;. (This attribute would be used for 
     * the &quot;1 year&quot;).</p>
     * 
     * <p>The last date before which an initial dispense can be 
     * made against the prescription. If an initial fill has not 
     * been made against the prescription in this time-period, then 
     * the prescription is no longer deemed valid and it may not be 
     * dispensed.</p>
     * 
     * <p>Un-merged Business Name: FirstFillExpiryDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.InitialSupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Some jurisdictions have distinct stale-date periods for 
     * the initial fill of a prescription from the overall 
     * dispensing of the prescription. E.g. 'The first fill must be 
     * made within 1 year, all fills must be complete within 1.5 
     * years'. (This attribute would be used for the '1 year'.)</p>
     * 
     * <p>The date before which an initial dispense can be made 
     * against the prescription. If an initial fill has not been 
     * made against the prescription in this time-period, it may 
     * not be dispensed.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: FirstFillExpiryDate</p>
     * 
     * <p>Un-merged Business Name: FirstFillExpiryDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.InitialSupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Some jurisdictions have distinct stale-date periods for 
     * the initial fill of a prescription from the overall 
     * dispensing of the prescription. E.g. &quot;The first fill 
     * must be made within 1 year, all fills must be complete 
     * within 1.5 years&quot;. (This attribute would be used for 
     * the &quot;1 year&quot;.)</p>
     * 
     * <p>The date before which an initial dispense can be made 
     * against the prescription. If an initial fill has not been 
     * made against the prescription in this time-period, it may 
     * not be dispensed.</p>
     * 
     * <p>Un-merged Business Name: FirstFillExpiryDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.InitialSupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Some jurisdictions have distinct stale-date periods for 
     * the initial fill of a prescription from the overall 
     * dispensing of the prescription. E.g. &quot;The first fill 
     * must be made within 1 year, all fills must be complete 
     * within 1.5 years&quot;. (This attribute would be used for 
     * the &quot;1 year&quot;).</p>
     * 
     * <p>The last date before which an initial dispense can be 
     * made against the prescription. If an initial fill has not 
     * been made against the prescription in this time-period, then 
     * the prescription is no longer deemed valid and it may not be 
     * dispensed.</p>
     * 
     * <p>Un-merged Business Name: FirstFillExpiryDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.InitialSupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Some jurisdictions have distinct stale-date periods for 
     * the initial fill of a prescription from the overall 
     * dispensing of the prescription. E.g. 'The first fill must be 
     * made within 1 year, all fills must be complete within 1.5 
     * years'. (This attribute would be used for the '1 year'.)</p>
     * 
     * <p>The date before which an initial dispense can be made 
     * against the prescription. If an initial fill has not been 
     * made against the prescription in this time-period, it may 
     * not be dispensed.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: FirstFillQuantity</p>
     * 
     * <p>Un-merged Business Name: FirstFillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.InitialSupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Prescription.coordinatingAmount</p>
     * 
     * <p>Allows a limited quantity to be dispensed for a trial or 
     * for a synchronizing dose.</p>
     * 
     * <p>The quantity of medication to be dispensed the first time 
     * the prescription is dispensed against.</p>
     * 
     * <p>Un-merged Business Name: FirstFillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.InitialSupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows a limited quantity to be dispensed for a trial or 
     * for a synchronizing dose.</p>
     * 
     * <p>The quantity of medication to be dispensed the first time 
     * the prescription is dispensed against.</p>
     * 
     * <p>Un-merged Business Name: FirstFillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.InitialSupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Prescription.coordinatingAmount</p>
     * 
     * <p>Allows a limited quantity to be dispensed for a trial or 
     * for a synchronizing dose.</p>
     * 
     * <p>The quantity of medication to be dispensed the first time 
     * the prescription is dispensed against.</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Business Name: FirstFillQuantity</p>
     * 
     * <p>Un-merged Business Name: FirstFillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.InitialSupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Prescription.coordinatingAmount</p>
     * 
     * <p>Allows a limited quantity to be dispensed for a trial or 
     * for a synchronizing dose.</p>
     * 
     * <p>The quantity of medication to be dispensed the first time 
     * the prescription is dispensed against.</p>
     * 
     * <p>Un-merged Business Name: FirstFillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.InitialSupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows a limited quantity to be dispensed for a trial or 
     * for a synchronizing dose.</p>
     * 
     * <p>The quantity of medication to be dispensed the first time 
     * the prescription is dispensed against.</p>
     * 
     * <p>Un-merged Business Name: FirstFillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.InitialSupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Prescription.coordinatingAmount</p>
     * 
     * <p>Allows a limited quantity to be dispensed for a trial or 
     * for a synchronizing dose.</p>
     * 
     * <p>The quantity of medication to be dispensed the first time 
     * the prescription is dispensed against.</p>
     */
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>Business Name: FirstFillDaysSupply</p>
     * 
     * <p>Un-merged Business Name: FirstFillDaysSupply</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.InitialSupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used when the prescriber cannot or does not wish to 
     * calculate the quantity necessary to last for the trial or 
     * synchronization time.</p>
     * 
     * <p>The number of days that the first fill is expected to 
     * last, if the patient is compliant with the dispensing of the 
     * first fill and with administration of the prescription.</p>
     * 
     * <p>Un-merged Business Name: FirstFillDaysSupply</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.InitialSupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used when the prescriber cannot or does not wish to 
     * calculate the quantity necessary to last for the trial or 
     * synchronization time.</p>
     * 
     * <p>The number of days that the first fill is expected to 
     * last, if the patient is compliant with the dispensing of the 
     * first fill and with administration of the prescription.</p>
     * 
     * <p>Un-merged Business Name: FirstFillDaysSupply</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.InitialSupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used when the prescriber cannot or does not wish to 
     * calculate the quantity necessary to last for the trial or 
     * synchronization time.</p>
     * 
     * <p>The number of days that the first fill is expected to 
     * last, if the patient is compliant with the dispensing of the 
     * first fill and with administration of the prescription.</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }

    /**
     * <p>Business Name: FirstFillDaysSupply</p>
     * 
     * <p>Un-merged Business Name: FirstFillDaysSupply</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.InitialSupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used when the prescriber cannot or does not wish to 
     * calculate the quantity necessary to last for the trial or 
     * synchronization time.</p>
     * 
     * <p>The number of days that the first fill is expected to 
     * last, if the patient is compliant with the dispensing of the 
     * first fill and with administration of the prescription.</p>
     * 
     * <p>Un-merged Business Name: FirstFillDaysSupply</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.InitialSupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used when the prescriber cannot or does not wish to 
     * calculate the quantity necessary to last for the trial or 
     * synchronization time.</p>
     * 
     * <p>The number of days that the first fill is expected to 
     * last, if the patient is compliant with the dispensing of the 
     * first fill and with administration of the prescription.</p>
     * 
     * <p>Un-merged Business Name: FirstFillDaysSupply</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.InitialSupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used when the prescriber cannot or does not wish to 
     * calculate the quantity necessary to last for the trial or 
     * synchronization time.</p>
     * 
     * <p>The number of days that the first fill is expected to 
     * last, if the patient is compliant with the dispensing of the 
     * first fill and with administration of the prescription.</p>
     */
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }

}
