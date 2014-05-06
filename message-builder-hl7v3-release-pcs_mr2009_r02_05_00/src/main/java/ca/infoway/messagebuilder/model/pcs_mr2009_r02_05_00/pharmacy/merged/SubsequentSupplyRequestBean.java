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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>PORX_MT060160CA.SubsequentSupplyRequest: (no business 
 * name)</p>
 * 
 * <p>Dispensing instruction for all dispenses subsequent to 
 * the first fill.</p>
 * 
 * <p>PORX_MT060340CA.SubsequentSupplyRequest: (no business 
 * name)</p>
 * 
 * <p>Dispensing instruction for all dispenses subsequent to 
 * the first fill.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.SubsequentSupplyRequest","PORX_MT060160CA.SubsequentSupplyRequest","PORX_MT060340CA.SubsequentSupplyRequest"})
public class SubsequentSupplyRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20140506L;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private INT repeatNumber = new INTImpl();
    private PQ quantity = new PQImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>Business Name: DispenseInterval</p>
     * 
     * <p>Un-merged Business Name: DispenseInterval</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SubsequentSupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Helps the prescriber ensure that the patient does not 
     * ever receive more than the appropriate amount of medication 
     * in a particular timeframe.</p>
     * 
     * <p>Indicates a minimum amount of time that must occur 
     * between dispenses.</p>
     * 
     * <p>Un-merged Business Name: DispenseInterval</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.SubsequentSupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Helps the prescriber ensure that the patient does not 
     * ever receive more than the appropriate amount of medication 
     * in a particular timeframe.</p>
     * 
     * <p>Indicates a minimum amount of time that must occur 
     * between dispenses.</p>
     * 
     * <p>Un-merged Business Name: DispenseInterval</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SubsequentSupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Helps the prescriber ensure that the patient does not 
     * ever receive more than the appropriate amount of medication 
     * in a particular timeframe.</p>
     * 
     * <p>Indicates a minimum amount of time that must occur 
     * between dispenses.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: DispenseInterval</p>
     * 
     * <p>Un-merged Business Name: DispenseInterval</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SubsequentSupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Helps the prescriber ensure that the patient does not 
     * ever receive more than the appropriate amount of medication 
     * in a particular timeframe.</p>
     * 
     * <p>Indicates a minimum amount of time that must occur 
     * between dispenses.</p>
     * 
     * <p>Un-merged Business Name: DispenseInterval</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.SubsequentSupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Helps the prescriber ensure that the patient does not 
     * ever receive more than the appropriate amount of medication 
     * in a particular timeframe.</p>
     * 
     * <p>Indicates a minimum amount of time that must occur 
     * between dispenses.</p>
     * 
     * <p>Un-merged Business Name: DispenseInterval</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SubsequentSupplyRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Helps the prescriber ensure that the patient does not 
     * ever receive more than the appropriate amount of medication 
     * in a particular timeframe.</p>
     * 
     * <p>Indicates a minimum amount of time that must occur 
     * between dispenses.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: NumberOfFills</p>
     * 
     * <p>Un-merged Business Name: NumberOfFills</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SubsequentSupplyRequest.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>D54.03</p>
     * 
     * <p>DRU.060-02</p>
     * 
     * <p>Claim,415-DF</p>
     * 
     * <p>ZDP.15.1</p>
     * 
     * <p>Prescription.numberOfRefills</p>
     * 
     * <p>Used to calculate total prescribed quantity; and also 
     * used for compliance checking.</p><p>Expressed as Number of 
     * Fills rather than number of refills due to HL7 modeling 
     * constraints.</p>
     * 
     * <p>The number of times the prescribed quantity is to be 
     * dispensed, including the initial standard fill.</p>
     * 
     * <p>Un-merged Business Name: NumberOfFills</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.SubsequentSupplyRequest.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used to calculate total prescribed quantity; and also 
     * used for compliance checking.</p><p>Expressed as Number of 
     * Fills rather than number of refills due to HL7 modeling 
     * constraints.</p>
     * 
     * <p>The number of times the prescribed quantity is to be 
     * dispensed including the initial standard fill.</p>
     * 
     * <p>Un-merged Business Name: NumberOfFills</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SubsequentSupplyRequest.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>D54.03</p>
     * 
     * <p>DRU.060-02</p>
     * 
     * <p>Claim,415-DF</p>
     * 
     * <p>ZDP.15.1</p>
     * 
     * <p>Prescription.numberOfRefills</p>
     * 
     * <p>Used to calculate total prescribed quantity; and also 
     * used for compliance checking.</p><p>Expressed as Number of 
     * Fills rather than number of refills due to HL7 modeling 
     * constraints.</p>
     * 
     * <p>The number of times the prescribed quantity is to be 
     * dispensed including the initial standard fill.</p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getRepeatNumber() {
        return this.repeatNumber.getValue();
    }

    /**
     * <p>Business Name: NumberOfFills</p>
     * 
     * <p>Un-merged Business Name: NumberOfFills</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SubsequentSupplyRequest.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>D54.03</p>
     * 
     * <p>DRU.060-02</p>
     * 
     * <p>Claim,415-DF</p>
     * 
     * <p>ZDP.15.1</p>
     * 
     * <p>Prescription.numberOfRefills</p>
     * 
     * <p>Used to calculate total prescribed quantity; and also 
     * used for compliance checking.</p><p>Expressed as Number of 
     * Fills rather than number of refills due to HL7 modeling 
     * constraints.</p>
     * 
     * <p>The number of times the prescribed quantity is to be 
     * dispensed, including the initial standard fill.</p>
     * 
     * <p>Un-merged Business Name: NumberOfFills</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.SubsequentSupplyRequest.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used to calculate total prescribed quantity; and also 
     * used for compliance checking.</p><p>Expressed as Number of 
     * Fills rather than number of refills due to HL7 modeling 
     * constraints.</p>
     * 
     * <p>The number of times the prescribed quantity is to be 
     * dispensed including the initial standard fill.</p>
     * 
     * <p>Un-merged Business Name: NumberOfFills</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SubsequentSupplyRequest.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>D54.03</p>
     * 
     * <p>DRU.060-02</p>
     * 
     * <p>Claim,415-DF</p>
     * 
     * <p>ZDP.15.1</p>
     * 
     * <p>Prescription.numberOfRefills</p>
     * 
     * <p>Used to calculate total prescribed quantity; and also 
     * used for compliance checking.</p><p>Expressed as Number of 
     * Fills rather than number of refills due to HL7 modeling 
     * constraints.</p>
     * 
     * <p>The number of times the prescribed quantity is to be 
     * dispensed including the initial standard fill.</p>
     */
    public void setRepeatNumber(Integer repeatNumber) {
        this.repeatNumber.setValue(repeatNumber);
    }


    /**
     * <p>Business Name: FillQuantity</p>
     * 
     * <p>Un-merged Business Name: FillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SubsequentSupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Prescription.fillAmount</p>
     * 
     * <p>Prescription.maximumDispensedAmount (when 
     * SupplyRequest.effectiveTime id populated with an 
     * interval)</p>
     * 
     * <p>Quantity</p>
     * 
     * <p>Limits the quantity of medication in patient's possession 
     * at a time. Used in compliance checking</p>
     * 
     * <p>The amount of medication to be dispensed to the patient 
     * for each normal fill (excluding trial or other special first 
     * fills).</p>
     * 
     * <p>Un-merged Business Name: FillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.SubsequentSupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Limits the quantity of medication in patient's possession 
     * at a time. Used in compliance checking.</p>
     * 
     * <p>The amount of medication to be dispensed to the patient 
     * for each normal fill (excluding trial or other special first 
     * fills).</p>
     * 
     * <p>Un-merged Business Name: FillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SubsequentSupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Prescription.fillAmount</p>
     * 
     * <p>Prescription.maximumDispensedAmount (when 
     * SupplyRequest.effectiveTime id populated with an 
     * interval)</p>
     * 
     * <p>Quantity</p>
     * 
     * <p>Limits the quantity of medication in patient's possession 
     * at a time. Used in compliance checking</p>
     * 
     * <p>The amount of medication to be dispensed to the patient 
     * for each normal fill (excluding trial or other special first 
     * fills).</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Business Name: FillQuantity</p>
     * 
     * <p>Un-merged Business Name: FillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SubsequentSupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Prescription.fillAmount</p>
     * 
     * <p>Prescription.maximumDispensedAmount (when 
     * SupplyRequest.effectiveTime id populated with an 
     * interval)</p>
     * 
     * <p>Quantity</p>
     * 
     * <p>Limits the quantity of medication in patient's possession 
     * at a time. Used in compliance checking</p>
     * 
     * <p>The amount of medication to be dispensed to the patient 
     * for each normal fill (excluding trial or other special first 
     * fills).</p>
     * 
     * <p>Un-merged Business Name: FillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.SubsequentSupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Limits the quantity of medication in patient's possession 
     * at a time. Used in compliance checking.</p>
     * 
     * <p>The amount of medication to be dispensed to the patient 
     * for each normal fill (excluding trial or other special first 
     * fills).</p>
     * 
     * <p>Un-merged Business Name: FillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SubsequentSupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Prescription.fillAmount</p>
     * 
     * <p>Prescription.maximumDispensedAmount (when 
     * SupplyRequest.effectiveTime id populated with an 
     * interval)</p>
     * 
     * <p>Quantity</p>
     * 
     * <p>Limits the quantity of medication in patient's possession 
     * at a time. Used in compliance checking</p>
     * 
     * <p>The amount of medication to be dispensed to the patient 
     * for each normal fill (excluding trial or other special first 
     * fills).</p>
     */
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>Business Name: DaysSupply</p>
     * 
     * <p>Un-merged Business Name: DaysSupply</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SubsequentSupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in determining and managing certain 
     * contraindications ('Fill-Too-Soon', 'Fill-Too-Late', and 
     * 'Duration of Therapy'). Also provides guidance to the 
     * pharmacy on how much to dispense. Also useful in 
     * research.</p>
     * 
     * <p>The number of days that each standard fill is expected to 
     * last. The dispenser must use the administration instructions 
     * together with the Days Supply to calculate the total 
     * quantity to dispense per fill. May be specified in addition 
     * to quantity to indicate the length of time a quantity of 'as 
     * needed' medication is expected to last.</p>
     * 
     * <p>Un-merged Business Name: DaysSupply</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.SubsequentSupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in determining and managing certain 
     * contraindications ('Fill-Too-Soon', 'Fill-Too-Late', and 
     * 'Duration of Therapy'). Also provides guidance to the 
     * pharmacy on how much to dispense. Also useful in 
     * research</p>
     * 
     * <p>The number of days that each standard fill is expected to 
     * last. The dispenser must use the administration instructions 
     * together with the Days Supply to calculate the total 
     * quantity to dispense per fill. May be specified in addition 
     * to quantity to indicate the length of time a quantity of 
     * &quot;as needed&quot; medication is expected to last.</p>
     * 
     * <p>Un-merged Business Name: DaysSupply</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SubsequentSupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in determining and managing certain 
     * contraindications ('Fill-Too-Soon', 'Fill-Too-Late', and 
     * 'Duration of Therapy'). Also provides guidance to the 
     * pharmacy on how much to dispense. Also useful in 
     * research.</p>
     * 
     * <p>The number of days that each standard fill is expected to 
     * last. The dispenser must use the administration instructions 
     * together with the Days Supply to calculate the total 
     * quantity to dispense per fill. May be specified in addition 
     * to quantity to indicate the length of time a quantity of 'as 
     * needed' medication is expected to last.</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }

    /**
     * <p>Business Name: DaysSupply</p>
     * 
     * <p>Un-merged Business Name: DaysSupply</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SubsequentSupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in determining and managing certain 
     * contraindications ('Fill-Too-Soon', 'Fill-Too-Late', and 
     * 'Duration of Therapy'). Also provides guidance to the 
     * pharmacy on how much to dispense. Also useful in 
     * research.</p>
     * 
     * <p>The number of days that each standard fill is expected to 
     * last. The dispenser must use the administration instructions 
     * together with the Days Supply to calculate the total 
     * quantity to dispense per fill. May be specified in addition 
     * to quantity to indicate the length of time a quantity of 'as 
     * needed' medication is expected to last.</p>
     * 
     * <p>Un-merged Business Name: DaysSupply</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.SubsequentSupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in determining and managing certain 
     * contraindications ('Fill-Too-Soon', 'Fill-Too-Late', and 
     * 'Duration of Therapy'). Also provides guidance to the 
     * pharmacy on how much to dispense. Also useful in 
     * research</p>
     * 
     * <p>The number of days that each standard fill is expected to 
     * last. The dispenser must use the administration instructions 
     * together with the Days Supply to calculate the total 
     * quantity to dispense per fill. May be specified in addition 
     * to quantity to indicate the length of time a quantity of 
     * &quot;as needed&quot; medication is expected to last.</p>
     * 
     * <p>Un-merged Business Name: DaysSupply</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SubsequentSupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in determining and managing certain 
     * contraindications ('Fill-Too-Soon', 'Fill-Too-Late', and 
     * 'Duration of Therapy'). Also provides guidance to the 
     * pharmacy on how much to dispense. Also useful in 
     * research.</p>
     * 
     * <p>The number of days that each standard fill is expected to 
     * last. The dispenser must use the administration instructions 
     * together with the Days Supply to calculate the total 
     * quantity to dispense per fill. May be specified in addition 
     * to quantity to indicate the length of time a quantity of 'as 
     * needed' medication is expected to last.</p>
     */
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }

}