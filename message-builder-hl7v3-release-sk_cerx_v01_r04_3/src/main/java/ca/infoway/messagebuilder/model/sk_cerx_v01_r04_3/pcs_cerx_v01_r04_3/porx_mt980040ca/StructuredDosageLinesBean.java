/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.porx_mt980040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodDefEvnRqo;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Structured Dosage Lines</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This 
 * information, along with the order/sequence of the dosage 
 * lines, constitutes the details of a structured dosage 
 * instruction.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Enables SIG 
 * instructions to be discretely specified. Also, supports 
 * scaling doses and parallel dose specification.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT980040CA.DosageLine"})
public class StructuredDosageLinesBean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private CS dosageUsageContext = new CSImpl();
    private ST adHocDosageInstruction = new STImpl();
    private GTS dosageTimingFrequency = new GTSImpl();
    private URG<PQ, PhysicalQuantity> dosageRange = new URGImpl<PQ, PhysicalQuantity>();
    private URG<PQ, PhysicalQuantity> dosageRate = new URGImpl<PQ, PhysicalQuantity>();
    private AdditionalSIGInstructionBean componentSupplementalInstruction;
    private AdministrationPreconditionBean triggerActEventCriterion;


    /**
     * <p>Dosage Usage Context</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the context of the administration.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = RQO, 
     * for administration instruction on orders</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = EVN, 
     * for administration instruction on dispenses</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = DEF, 
     * for administration instruction on medication definition 
     * documents/references (typically, monographs).</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the context of the administration.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = RQO, 
     * for administration instruction on orders</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = EVN, 
     * for administration instruction on dispenses</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = DEF, 
     * for administration instruction on medication definition 
     * documents/references (typically, monographs).</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the context of the administration.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = RQO, 
     * for administration instruction on orders</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = EVN, 
     * for administration instruction on dispenses</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = DEF, 
     * for administration instruction on medication definition 
     * documents/references (typically, monographs).</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the context of the administration.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = RQO, 
     * for administration instruction on orders</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = EVN, 
     * for administration instruction on dispenses</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = DEF, 
     * for administration instruction on medication definition 
     * documents/references (typically, monographs).</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Puts the 
     * class in context, and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodDefEvnRqo getDosageUsageContext() {
        return (x_ActMoodDefEvnRqo) this.dosageUsageContext.getValue();
    }
    public void setDosageUsageContext(x_ActMoodDefEvnRqo dosageUsageContext) {
        this.dosageUsageContext.setValue(dosageUsageContext);
    }


    /**
     * <p>C:Ad-hoc Dosage Instruction</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A free form 
     * description of how the dispensed medication is to be 
     * administered to the patient.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.instruction</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.instruction</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.02</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0201</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.16</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.030-02</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.instruction</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.instruction</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.02</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0201</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.16</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.030-02</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.instruction</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.instruction</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.02</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0201</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.16</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.030-02</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.instruction</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.instruction</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.02</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0201</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.16</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.030-02</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.instruction</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.instruction</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.02</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0201</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.16</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.030-02</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.instruction</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.instruction</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.02</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0201</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.16</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.030-02</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Not all 
     * dosage instructions can easily be expressed in formal 
     * terms</p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * dosage instructions to be sent across as one string of 
     * information without breaking it up.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Not all 
     * dosage instructions can easily be expressed in formal 
     * terms</p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * dosage instructions to be sent across as one string of 
     * information without breaking it up.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This field 
     * must not be used for components of the prescription that are 
     * coded elsewhere.(e.g. Coded Dosage Timing).</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getAdHocDosageInstruction() {
        return this.adHocDosageInstruction.getValue();
    }
    public void setAdHocDosageInstruction(String adHocDosageInstruction) {
        this.adHocDosageInstruction.setValue(adHocDosageInstruction);
    }


    /**
     * <p>C:Dosage Timing/Frequency</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A structure 
     * describing the frequency (how often the drug is to be 
     * administered), offset (elapse time between administrations) 
     * represented by one line of dosage administration 
     * instruction. Includes the overall time-period the dosage 
     * instruction applies.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.Duration(OuterInterval.Width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.StartDate(OuterInterval.Low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">RepeatPattern.PatternCode(PIVL 
     * - codes will need to be mapped to and from formal GTS 
     * expressions)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">RepeatPattern.uncodedPattern 
     * (PIVL.originalText)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.2.1 
     * (PIVL.period)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DP.13.2.2 (single 
     * time or list of times)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.3 (outer 
     * IVL&lt;TS&gt;.width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.4 (outer 
     * IVL&lt;TS&gt;.low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.5 (outer 
     * IVL&lt;TS&gt;.high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Frequency</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.Duration(OuterInterval.Width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.StartDate(OuterInterval.Low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">RepeatPattern.PatternCode(PIVL 
     * - codes will need to be mapped to and from formal GTS 
     * expressions)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">RepeatPattern.uncodedPattern 
     * (PIVL.originalText)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.2.1 
     * (PIVL.period)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DP.13.2.2 (single 
     * time or list of times)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.3 (outer 
     * IVL&lt;TS&gt;.width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.4 (outer 
     * IVL&lt;TS&gt;.low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.5 (outer 
     * IVL&lt;TS&gt;.high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Frequency</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.Duration(OuterInterval.Width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.StartDate(OuterInterval.Low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">RepeatPattern.PatternCode(PIVL 
     * - codes will need to be mapped to and from formal GTS 
     * expressions)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">RepeatPattern.uncodedPattern 
     * (PIVL.originalText)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.2.1 
     * (PIVL.period)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DP.13.2.2 (single 
     * time or list of times)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.3 (outer 
     * IVL&lt;TS&gt;.width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.4 (outer 
     * IVL&lt;TS&gt;.low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.5 (outer 
     * IVL&lt;TS&gt;.high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Frequency</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.Duration(OuterInterval.Width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.StartDate(OuterInterval.Low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">RepeatPattern.PatternCode(PIVL 
     * - codes will need to be mapped to and from formal GTS 
     * expressions)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">RepeatPattern.uncodedPattern 
     * (PIVL.originalText)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.2.1 
     * (PIVL.period)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DP.13.2.2 (single 
     * time or list of times)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.3 (outer 
     * IVL&lt;TS&gt;.width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.4 (outer 
     * IVL&lt;TS&gt;.low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.5 (outer 
     * IVL&lt;TS&gt;.high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Frequency</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.Duration(OuterInterval.Width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.StartDate(OuterInterval.Low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">RepeatPattern.PatternCode(PIVL 
     * - codes will need to be mapped to and from formal GTS 
     * expressions)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">RepeatPattern.uncodedPattern 
     * (PIVL.originalText)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.2.1 
     * (PIVL.period)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DP.13.2.2 (single 
     * time or list of times)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.3 (outer 
     * IVL&lt;TS&gt;.width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.4 (outer 
     * IVL&lt;TS&gt;.low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.5 (outer 
     * IVL&lt;TS&gt;.high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Frequency</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.Duration(OuterInterval.Width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.StartDate(OuterInterval.Low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">RepeatPattern.PatternCode(PIVL 
     * - codes will need to be mapped to and from formal GTS 
     * expressions)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">RepeatPattern.uncodedPattern 
     * (PIVL.originalText)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.2.1 
     * (PIVL.period)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DP.13.2.2 (single 
     * time or list of times)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.3 (outer 
     * IVL&lt;TS&gt;.width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.4 (outer 
     * IVL&lt;TS&gt;.low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.5 (outer 
     * IVL&lt;TS&gt;.high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Frequency</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.Duration(OuterInterval.Width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.StartDate(OuterInterval.Low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">RepeatPattern.PatternCode(PIVL 
     * - codes will need to be mapped to and from formal GTS 
     * expressions)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">RepeatPattern.uncodedPattern 
     * (PIVL.originalText)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.2.1 
     * (PIVL.period)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DP.13.2.2 (single 
     * time or list of times)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.3 (outer 
     * IVL&lt;TS&gt;.width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.4 (outer 
     * IVL&lt;TS&gt;.low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.5 (outer 
     * IVL&lt;TS&gt;.high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Frequency</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.Duration(OuterInterval.Width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.StartDate(OuterInterval.Low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">RepeatPattern.PatternCode(PIVL 
     * - codes will need to be mapped to and from formal GTS 
     * expressions)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">RepeatPattern.uncodedPattern 
     * (PIVL.originalText)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.2.1 
     * (PIVL.period)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DP.13.2.2 (single 
     * time or list of times)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.3 (outer 
     * IVL&lt;TS&gt;.width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.4 (outer 
     * IVL&lt;TS&gt;.low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.5 (outer 
     * IVL&lt;TS&gt;.high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Frequency</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.Duration(OuterInterval.Width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.StartDate(OuterInterval.Low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">RepeatPattern.PatternCode(PIVL 
     * - codes will need to be mapped to and from formal GTS 
     * expressions)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">RepeatPattern.uncodedPattern 
     * (PIVL.originalText)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.2.1 
     * (PIVL.period)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DP.13.2.2 (single 
     * time or list of times)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.3 (outer 
     * IVL&lt;TS&gt;.width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.4 (outer 
     * IVL&lt;TS&gt;.low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.13.5 (outer 
     * IVL&lt;TS&gt;.high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Frequency</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.or
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"effectiveTime"})
    public GeneralTimingSpecification getDosageTimingFrequency() {
        return this.dosageTimingFrequency.getValue();
    }
    public void setDosageTimingFrequency(GeneralTimingSpecification dosageTimingFrequency) {
        this.dosageTimingFrequency.setValue(dosageTimingFrequency);
    }


    /**
     * <p>D:Dosage Range</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This 
     * specifies the minimum and maximum amount of the medication 
     * to be taken during a single administration.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.DosageRange</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dosage</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.DosageRange</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dosage</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DosageItem.DosageRange</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dosage</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Enables the 
     * checking of administration compliance that could results in 
     * fill-too-soon/fill-too-late contraindications. Supports 
     * circumstances where the dose can vary. (e.g. 1-2 
     * tablets)</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Where no 
     * range is needed, a single value should be specified as the 
     * center, with a width of 0.</p></p>
     */
    @Hl7XmlMapping({"doseQuantity"})
    public UncertainRange<PhysicalQuantity> getDosageRange() {
        return this.dosageRange.getValue();
    }
    public void setDosageRange(UncertainRange<PhysicalQuantity> dosageRange) {
        this.dosageRange.setValue(dosageRange);
    }


    /**
     * <p>E:Dosage Rate</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">For 
     * intravenous and other such routes, this is the time period 
     * over which one dose is to be administered. The flow rate is 
     * determined by dividing the dose quantity by the Dosage 
     * rate.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Required for 
     * intravenous administration</p></p>
     */
    @Hl7XmlMapping({"rateQuantity"})
    public UncertainRange<PhysicalQuantity> getDosageRate() {
        return this.dosageRate.getValue();
    }
    public void setDosageRate(UncertainRange<PhysicalQuantity> dosageRate) {
        this.dosageRate.setValue(dosageRate);
    }


    @Hl7XmlMapping({"component/supplementalInstruction"})
    public AdditionalSIGInstructionBean getComponentSupplementalInstruction() {
        return this.componentSupplementalInstruction;
    }
    public void setComponentSupplementalInstruction(AdditionalSIGInstructionBean componentSupplementalInstruction) {
        this.componentSupplementalInstruction = componentSupplementalInstruction;
    }


    @Hl7XmlMapping({"trigger/actEventCriterion"})
    public AdministrationPreconditionBean getTriggerActEventCriterion() {
        return this.triggerActEventCriterion;
    }
    public void setTriggerActEventCriterion(AdministrationPreconditionBean triggerActEventCriterion) {
        this.triggerActEventCriterion = triggerActEventCriterion;
    }

}
