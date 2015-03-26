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
package ca.infoway.messagebuilder.model.ab_r02_04_03_imm.common.coct_mt270010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodDefEvnRqo;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Structured Dosage Lines</p>
 * 
 * <p>Either an Ad-hoc Dosage Line or (Dosage Timing/Frequency 
 * + Dosage Range + possibly Dosage Rate) may be specified t 
 * one time }</p>
 * 
 * <p>Enables SIG instructions to be discretely specified. 
 * Also, supports scaling doses and parallel dose 
 * specification.</p>
 * 
 * <p>This information, along with the order/sequence of the 
 * dosage lines, constitutes the details of a structured dosage 
 * instruction.</p>
 */
@Hl7PartTypeMapping({"COCT_MT270010CA.DosageLine"})
public class StructuredDosageLinesBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private CS moodCode = new CSImpl();
    private ST text = new STImpl();
    private GTS effectiveTime = new GTSImpl();
    private URG<PQ, PhysicalQuantity> doseQuantity = new URGImpl<PQ, PhysicalQuantity>();
    private URG<PQ, PhysicalQuantity> rateQuantity = new URGImpl<PQ, PhysicalQuantity>();
    private AdministrationPreconditionBean triggerActEventCriterion;
    private AdditionalSIGInstructionBean componentSupplementalInstruction;


    /**
     * <p>Business Name: Dosage Usage Context</p>
     * 
     * <p>Relationship: COCT_MT270010CA.DosageLine.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>- moodCode must be DEFN for drug definitions (such as 
     * monographs) - moodCode must be RQO for orders; - moodCode 
     * must be EVN for dispenses and recording of other 
     * medications</p>
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
    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodDefEvnRqo getMoodCode() {
        return (x_ActMoodDefEvnRqo) this.moodCode.getValue();
    }

    /**
     * <p>Business Name: Dosage Usage Context</p>
     * 
     * <p>Relationship: COCT_MT270010CA.DosageLine.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>- moodCode must be DEFN for drug definitions (such as 
     * monographs) - moodCode must be RQO for orders; - moodCode 
     * must be EVN for dispenses and recording of other 
     * medications</p>
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
    public void setMoodCode(x_ActMoodDefEvnRqo moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>Business Name: C:Ad-hoc Dosage Instruction</p>
     * 
     * <p>Relationship: COCT_MT270010CA.DosageLine.text</p>
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
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: C:Ad-hoc Dosage Instruction</p>
     * 
     * <p>Relationship: COCT_MT270010CA.DosageLine.text</p>
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
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: C:Dosage Timing/Frequency</p>
     * 
     * <p>Relationship: COCT_MT270010CA.DosageLine.effectiveTime</p>
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
    @Hl7XmlMapping({"effectiveTime"})
    public GeneralTimingSpecification getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: C:Dosage Timing/Frequency</p>
     * 
     * <p>Relationship: COCT_MT270010CA.DosageLine.effectiveTime</p>
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
    public void setEffectiveTime(GeneralTimingSpecification effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: D:Dosage Range</p>
     * 
     * <p>Relationship: COCT_MT270010CA.DosageLine.doseQuantity</p>
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
     * <p>Where no range is needed, a single value should be 
     * specified as the center, with a width of 0.</p>
     * 
     * <p>This specifies the minimum and maximum amount of the 
     * medication to be taken during a single administration.</p>
     */
    @Hl7XmlMapping({"doseQuantity"})
    public UncertainRange<PhysicalQuantity> getDoseQuantity() {
        return this.doseQuantity.getValue();
    }

    /**
     * <p>Business Name: D:Dosage Range</p>
     * 
     * <p>Relationship: COCT_MT270010CA.DosageLine.doseQuantity</p>
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
     * <p>Where no range is needed, a single value should be 
     * specified as the center, with a width of 0.</p>
     * 
     * <p>This specifies the minimum and maximum amount of the 
     * medication to be taken during a single administration.</p>
     */
    public void setDoseQuantity(UncertainRange<PhysicalQuantity> doseQuantity) {
        this.doseQuantity.setValue(doseQuantity);
    }


    /**
     * <p>Business Name: E:Dosage Rate</p>
     * 
     * <p>Relationship: COCT_MT270010CA.DosageLine.rateQuantity</p>
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
    @Hl7XmlMapping({"rateQuantity"})
    public UncertainRange<PhysicalQuantity> getRateQuantity() {
        return this.rateQuantity.getValue();
    }

    /**
     * <p>Business Name: E:Dosage Rate</p>
     * 
     * <p>Relationship: COCT_MT270010CA.DosageLine.rateQuantity</p>
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
    public void setRateQuantity(UncertainRange<PhysicalQuantity> rateQuantity) {
        this.rateQuantity.setValue(rateQuantity);
    }


    /**
     * <p>Relationship: COCT_MT270010CA.Trigger.actEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"trigger/actEventCriterion"})
    public AdministrationPreconditionBean getTriggerActEventCriterion() {
        return this.triggerActEventCriterion;
    }

    /**
     * <p>Relationship: COCT_MT270010CA.Trigger.actEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setTriggerActEventCriterion(AdministrationPreconditionBean triggerActEventCriterion) {
        this.triggerActEventCriterion = triggerActEventCriterion;
    }


    /**
     * <p>Relationship: 
     * COCT_MT270010CA.Component18.supplementalInstruction</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component/supplementalInstruction"})
    public AdditionalSIGInstructionBean getComponentSupplementalInstruction() {
        return this.componentSupplementalInstruction;
    }

    /**
     * <p>Relationship: 
     * COCT_MT270010CA.Component18.supplementalInstruction</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponentSupplementalInstruction(AdditionalSIGInstructionBean componentSupplementalInstruction) {
        this.componentSupplementalInstruction = componentSupplementalInstruction;
    }

}
