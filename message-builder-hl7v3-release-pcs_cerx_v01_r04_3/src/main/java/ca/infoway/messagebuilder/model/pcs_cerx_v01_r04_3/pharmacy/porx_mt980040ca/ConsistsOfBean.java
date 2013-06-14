/**
 * Copyright 2013 Canada Health, Inc.
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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt980040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodDefEvnRqo;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: b:consists of</p>
 * 
 * <p>Structured dosage lines facilitate the checking of dosage 
 * appropriateness. It also allows for the formal calculation 
 * of days supply based on administration instructions and 
 * supplied quantity.</p>
 * 
 * <p>Dosage instructions may be given as textual information 
 * (as in Ad-hoc Dosage Instructions specified above) or as a 
 * structured set of dosage lines. This association allows for 
 * the specification of structured dosage lines.</p>
 */
@Hl7PartTypeMapping({"PORX_MT980040CA.Component17"})
public class ConsistsOfBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private INT sequenceNumber = new INTImpl();
    private CS dosageLineMoodCode = new CSImpl();
    private ST dosageLineText = new STImpl();
    private GTS dosageLineEffectiveTime = new GTSImpl();
    private URG<PQ, PhysicalQuantity> dosageLineDoseQuantity = new URGImpl<PQ, PhysicalQuantity>();
    private URG<PQ, PhysicalQuantity> dosageLineRateQuantity = new URGImpl<PQ, PhysicalQuantity>();
    private ST dosageLineTriggerActEventCriterionText = new STImpl();
    private AdditionalSIGInstructionBean dosageLineComponentSupplementalInstruction;


    /**
     * <p>Business Name: A:Dosage Line Order</p>
     * 
     * <p>Relationship: PORX_MT980040CA.Component17.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ZDP.13.10</p>
     * 
     * <p>Clearly expresses the order of each dosage line to ensure 
     * the correct dosage is given. Element is mandatory to ensure 
     * that dosage lines are specified and followed in the order 
     * intended.</p>
     * 
     * <p>Need examples to illustrate use of sequence lines with 
     * 'ANDs' and 'THENs'.</p>
     * 
     * <p>Indicates the order in which dosage lines should be 
     * performed. Ensures that each step of multiple and complex 
     * SIGs (e.g ramp up/down) is in the desired order. Dosage 
     * lines with the same sequence number should be performed in 
     * parallel. E.g. 2 tabs tid for 3 days (sequence 1) and then 1 
     * tab tid for 4 days (sequence 2) E.g. 1 tab in the morning 
     * (sequence 1) and 2 tabs at bedtime (sequence 1)</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Business Name: A:Dosage Line Order</p>
     * 
     * <p>Relationship: PORX_MT980040CA.Component17.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ZDP.13.10</p>
     * 
     * <p>Clearly expresses the order of each dosage line to ensure 
     * the correct dosage is given. Element is mandatory to ensure 
     * that dosage lines are specified and followed in the order 
     * intended.</p>
     * 
     * <p>Need examples to illustrate use of sequence lines with 
     * 'ANDs' and 'THENs'.</p>
     * 
     * <p>Indicates the order in which dosage lines should be 
     * performed. Ensures that each step of multiple and complex 
     * SIGs (e.g ramp up/down) is in the desired order. Dosage 
     * lines with the same sequence number should be performed in 
     * parallel. E.g. 2 tabs tid for 3 days (sequence 1) and then 1 
     * tab tid for 4 days (sequence 2) E.g. 1 tab in the morning 
     * (sequence 1) and 2 tabs at bedtime (sequence 1)</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Business Name: Dosage Usage Context</p>
     * 
     * <p>Relationship: PORX_MT980040CA.DosageLine.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Puts the class in context, and is therefore 
     * mandatory.</p>
     * 
     * <p>Indicates the context of the 
     * administration.</p><p>moodCode = RQO, for administration 
     * instruction on orders</p><p>moodCode = EVN, for 
     * administration instruction on dispenses</p><p>moodCode = 
     * DEF, for administration instruction on medication definition 
     * documents/references (typically, monographs).</p>
     */
    @Hl7XmlMapping({"dosageLine/moodCode"})
    public x_ActMoodDefEvnRqo getDosageLineMoodCode() {
        return (x_ActMoodDefEvnRqo) this.dosageLineMoodCode.getValue();
    }

    /**
     * <p>Business Name: Dosage Usage Context</p>
     * 
     * <p>Relationship: PORX_MT980040CA.DosageLine.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Puts the class in context, and is therefore 
     * mandatory.</p>
     * 
     * <p>Indicates the context of the 
     * administration.</p><p>moodCode = RQO, for administration 
     * instruction on orders</p><p>moodCode = EVN, for 
     * administration instruction on dispenses</p><p>moodCode = 
     * DEF, for administration instruction on medication definition 
     * documents/references (typically, monographs).</p>
     */
    public void setDosageLineMoodCode(x_ActMoodDefEvnRqo dosageLineMoodCode) {
        this.dosageLineMoodCode.setValue(dosageLineMoodCode);
    }


    /**
     * <p>Business Name: C:Ad-hoc Dosage Instruction</p>
     * 
     * <p>Relationship: PORX_MT980040CA.DosageLine.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DispensedItem.instruction</p>
     * 
     * <p>Prescription.instruction</p>
     * 
     * <p>D99.02</p>
     * 
     * <p>X0201</p>
     * 
     * <p>ZPB3.16</p>
     * 
     * <p>DRU.030-02</p>
     * 
     * <p>Not all dosage instructions can easily be expressed in 
     * formal terms</p><p>Allows dosage instructions to be sent 
     * across as one string of information without breaking it 
     * up.</p>
     * 
     * <p>This field must not be used for components of the 
     * prescription that are coded elsewhere.(e.g. Coded Dosage 
     * Timing).</p>
     * 
     * <p>A free form description of how the dispensed medication 
     * is to be administered to the patient.</p>
     */
    @Hl7XmlMapping({"dosageLine/text"})
    public String getDosageLineText() {
        return this.dosageLineText.getValue();
    }

    /**
     * <p>Business Name: C:Ad-hoc Dosage Instruction</p>
     * 
     * <p>Relationship: PORX_MT980040CA.DosageLine.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DispensedItem.instruction</p>
     * 
     * <p>Prescription.instruction</p>
     * 
     * <p>D99.02</p>
     * 
     * <p>X0201</p>
     * 
     * <p>ZPB3.16</p>
     * 
     * <p>DRU.030-02</p>
     * 
     * <p>Not all dosage instructions can easily be expressed in 
     * formal terms</p><p>Allows dosage instructions to be sent 
     * across as one string of information without breaking it 
     * up.</p>
     * 
     * <p>This field must not be used for components of the 
     * prescription that are coded elsewhere.(e.g. Coded Dosage 
     * Timing).</p>
     * 
     * <p>A free form description of how the dispensed medication 
     * is to be administered to the patient.</p>
     */
    public void setDosageLineText(String dosageLineText) {
        this.dosageLineText.setValue(dosageLineText);
    }


    /**
     * <p>Business Name: C:Dosage Timing/Frequency</p>
     * 
     * <p>Relationship: PORX_MT980040CA.DosageLine.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DosageItem.Duration(OuterInterval.Width)</p>
     * 
     * <p>DosageItem.StartDate(OuterInterval.Low)</p>
     * 
     * <p>RepeatPattern.PatternCode(PIVL - codes will need to be 
     * mapped to and from formal GTS expressions)</p>
     * 
     * <p>RepeatPattern.uncodedPattern (PIVL.originalText)</p>
     * 
     * <p>ZDP.13.2.1 (PIVL.period)</p>
     * 
     * <p>DP.13.2.2 (single time or list of times)</p>
     * 
     * <p>PID.13.3 (outer IVL&lt;TS&gt;.width)</p>
     * 
     * <p>PID.13.4 (outer IVL&lt;TS&gt;.low)</p>
     * 
     * <p>PID.13.5 (outer IVL&lt;TS&gt;.high)</p>
     * 
     * <p>Frequency</p>
     * 
     * <p>Together with the dose quantity, indicates the overall 
     * quantity of drug.</p>
     * 
     * <p>A structure describing the frequency (how often the drug 
     * is to be administered), offset (elapse time between 
     * administrations) represented by one line of dosage 
     * administration instruction. Includes the overall time-period 
     * the dosage instruction applies.</p>
     */
    @Hl7XmlMapping({"dosageLine/effectiveTime"})
    public GeneralTimingSpecification getDosageLineEffectiveTime() {
        return this.dosageLineEffectiveTime.getValue();
    }

    /**
     * <p>Business Name: C:Dosage Timing/Frequency</p>
     * 
     * <p>Relationship: PORX_MT980040CA.DosageLine.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DosageItem.Duration(OuterInterval.Width)</p>
     * 
     * <p>DosageItem.StartDate(OuterInterval.Low)</p>
     * 
     * <p>RepeatPattern.PatternCode(PIVL - codes will need to be 
     * mapped to and from formal GTS expressions)</p>
     * 
     * <p>RepeatPattern.uncodedPattern (PIVL.originalText)</p>
     * 
     * <p>ZDP.13.2.1 (PIVL.period)</p>
     * 
     * <p>DP.13.2.2 (single time or list of times)</p>
     * 
     * <p>PID.13.3 (outer IVL&lt;TS&gt;.width)</p>
     * 
     * <p>PID.13.4 (outer IVL&lt;TS&gt;.low)</p>
     * 
     * <p>PID.13.5 (outer IVL&lt;TS&gt;.high)</p>
     * 
     * <p>Frequency</p>
     * 
     * <p>Together with the dose quantity, indicates the overall 
     * quantity of drug.</p>
     * 
     * <p>A structure describing the frequency (how often the drug 
     * is to be administered), offset (elapse time between 
     * administrations) represented by one line of dosage 
     * administration instruction. Includes the overall time-period 
     * the dosage instruction applies.</p>
     */
    public void setDosageLineEffectiveTime(GeneralTimingSpecification dosageLineEffectiveTime) {
        this.dosageLineEffectiveTime.setValue(dosageLineEffectiveTime);
    }


    /**
     * <p>Business Name: D:Dosage Range</p>
     * 
     * <p>Relationship: PORX_MT980040CA.DosageLine.doseQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DosageItem.DosageRange</p>
     * 
     * <p>ZDP.13.1</p>
     * 
     * <p>Dosage</p>
     * 
     * <p>Enables the checking of administration compliance that 
     * could results in fill-too-soon/fill-too-late 
     * contraindications. Supports circumstances where the dose can 
     * vary. (e.g. 1-2 tablets)</p>
     * 
     * <p>Where no range is needed, sending the same value in both 
     * the low and the high is the preferred solution.</p>
     * 
     * <p>This specifies the minimum and maximum amount of the 
     * medication to be taken during a single administration.</p>
     */
    @Hl7XmlMapping({"dosageLine/doseQuantity"})
    public UncertainRange<PhysicalQuantity> getDosageLineDoseQuantity() {
        return this.dosageLineDoseQuantity.getValue();
    }

    /**
     * <p>Business Name: D:Dosage Range</p>
     * 
     * <p>Relationship: PORX_MT980040CA.DosageLine.doseQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DosageItem.DosageRange</p>
     * 
     * <p>ZDP.13.1</p>
     * 
     * <p>Dosage</p>
     * 
     * <p>Enables the checking of administration compliance that 
     * could results in fill-too-soon/fill-too-late 
     * contraindications. Supports circumstances where the dose can 
     * vary. (e.g. 1-2 tablets)</p>
     * 
     * <p>Where no range is needed, sending the same value in both 
     * the low and the high is the preferred solution.</p>
     * 
     * <p>This specifies the minimum and maximum amount of the 
     * medication to be taken during a single administration.</p>
     */
    public void setDosageLineDoseQuantity(UncertainRange<PhysicalQuantity> dosageLineDoseQuantity) {
        this.dosageLineDoseQuantity.setValue(dosageLineDoseQuantity);
    }


    /**
     * <p>Business Name: E:Dosage Rate</p>
     * 
     * <p>Relationship: PORX_MT980040CA.DosageLine.rateQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required for intravenous administration</p>
     * 
     * <p>For intravenous and other such routes, this is the time 
     * period over which one dose is to be administered. The flow 
     * rate is determined by dividing the dose quantity by the 
     * Dosage rate.</p>
     */
    @Hl7XmlMapping({"dosageLine/rateQuantity"})
    public UncertainRange<PhysicalQuantity> getDosageLineRateQuantity() {
        return this.dosageLineRateQuantity.getValue();
    }

    /**
     * <p>Business Name: E:Dosage Rate</p>
     * 
     * <p>Relationship: PORX_MT980040CA.DosageLine.rateQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required for intravenous administration</p>
     * 
     * <p>For intravenous and other such routes, this is the time 
     * period over which one dose is to be administered. The flow 
     * rate is determined by dividing the dose quantity by the 
     * Dosage rate.</p>
     */
    public void setDosageLineRateQuantity(UncertainRange<PhysicalQuantity> dosageLineRateQuantity) {
        this.dosageLineRateQuantity.setValue(dosageLineRateQuantity);
    }


    /**
     * <p>Business Name: A:Dosage Condition</p>
     * 
     * <p>Relationship: PORX_MT980040CA.ActEventCriterion.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>RepeatPattern.prn (true when present)</p>
     * 
     * <p>ZDP.13.6 (true when present)</p>
     * 
     * <p>ZDP.13.7</p>
     * 
     * <p>Allows un-coded specifications of conditions in which the 
     * medication should be taken.</p>
     * 
     * <p>A free-form textual description of condition that must be 
     * met before the product may be administered to/by the 
     * patient.</p><p>Example: When pressure exceeds 150/90 - Take 
     * 2 tabs</p>
     */
    @Hl7XmlMapping({"dosageLine/trigger/actEventCriterion/text"})
    public String getDosageLineTriggerActEventCriterionText() {
        return this.dosageLineTriggerActEventCriterionText.getValue();
    }

    /**
     * <p>Business Name: A:Dosage Condition</p>
     * 
     * <p>Relationship: PORX_MT980040CA.ActEventCriterion.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>RepeatPattern.prn (true when present)</p>
     * 
     * <p>ZDP.13.6 (true when present)</p>
     * 
     * <p>ZDP.13.7</p>
     * 
     * <p>Allows un-coded specifications of conditions in which the 
     * medication should be taken.</p>
     * 
     * <p>A free-form textual description of condition that must be 
     * met before the product may be administered to/by the 
     * patient.</p><p>Example: When pressure exceeds 150/90 - Take 
     * 2 tabs</p>
     */
    public void setDosageLineTriggerActEventCriterionText(String dosageLineTriggerActEventCriterionText) {
        this.dosageLineTriggerActEventCriterionText.setValue(dosageLineTriggerActEventCriterionText);
    }


    /**
     * <p>Relationship: 
     * PORX_MT980040CA.Component18.supplementalInstruction</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"dosageLine/component/supplementalInstruction"})
    public AdditionalSIGInstructionBean getDosageLineComponentSupplementalInstruction() {
        return this.dosageLineComponentSupplementalInstruction;
    }

    /**
     * <p>Relationship: 
     * PORX_MT980040CA.Component18.supplementalInstruction</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDosageLineComponentSupplementalInstruction(AdditionalSIGInstructionBean dosageLineComponentSupplementalInstruction) {
        this.dosageLineComponentSupplementalInstruction = dosageLineComponentSupplementalInstruction;
    }

}
