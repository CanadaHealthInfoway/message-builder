/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt270010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodDefEvnRqo;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Additional SIG Instruction</p>
 * 
 * <p><p>This is a modifier for a specific dosage line or for 
 * the entire SIG. Examples are: On empty stomach, At 
 * breakfast, before bedtime, etc.</p></p>
 * 
 * <p><p>Adds further constraint or flexibility to the primary 
 * administration instruction.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT270010CA.SupplementalInstruction"})
public class AdditionalSIGInstructionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CS dosageUsageContext = new CSImpl();
    private ST additionalDosageInstruction = new STImpl();


    /**
     * <p>Dosage Usage Context</p>
     * 
     * <p><p>- moodCode must be DEFN for drug definitions (such as 
     * as monographs) - moodCode must be RQO for orders; - moodCode 
     * must be EVN for dispenses and recording of other medications 
     * { x.; }</p></p>
     * 
     * <p><p>Indicates the context of the 
     * administration.</p><p>moodCode = RQO, for administration 
     * instruction on orders</p><p>moodCode = EVN, for 
     * administration instruction on dispenses</p><p>moodCode = 
     * DEF, for administration instruction on medication definition 
     * documents/references (typically, monographs).</p></p>
     * 
     * <p><p>Indicates the context of the 
     * administration.</p><p>moodCode = RQO, for administration 
     * instruction on orders</p><p>moodCode = EVN, for 
     * administration instruction on dispenses</p><p>moodCode = 
     * DEF, for administration instruction on medication definition 
     * documents/references (typically, monographs).</p></p>
     * 
     * <p><p>Indicates the context of the 
     * administration.</p><p>moodCode = RQO, for administration 
     * instruction on orders</p><p>moodCode = EVN, for 
     * administration instruction on dispenses</p><p>moodCode = 
     * DEF, for administration instruction on medication definition 
     * documents/references (typically, monographs).</p></p>
     * 
     * <p><p>Indicates the context of the 
     * administration.</p><p>moodCode = RQO, for administration 
     * instruction on orders</p><p>moodCode = EVN, for 
     * administration instruction on dispenses</p><p>moodCode = 
     * DEF, for administration instruction on medication definition 
     * documents/references (typically, monographs).</p></p>
     * 
     * <p><p>Puts the class in context, and is therefore 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodDefEvnRqo getDosageUsageContext() {
        return (x_ActMoodDefEvnRqo) this.dosageUsageContext.getValue();
    }
    public void setDosageUsageContext(x_ActMoodDefEvnRqo dosageUsageContext) {
        this.dosageUsageContext.setValue(dosageUsageContext);
    }


    /**
     * <p>F:Additional Dosage Instruction</p>
     * 
     * <p><p>A free form textual description of extended 
     * instruction regarding the administration of the drug.</p></p>
     * 
     * <p><p>ZDP.13.8</p></p>
     * 
     * <p><p>Allows for expression of non-codable qualifiers such 
     * as: 'on an empty stomach', 'add water' etc; which do not 
     * affect calculations of frequencies or quantity.</p><p>This 
     * attribute is marked as 'mandatory' as it is the only 
     * information that can be specified here.</p></p>
     * 
     * <p><p>Allows for expression of non-codable qualifiers such 
     * as: 'on an empty stomach', 'add water' etc; which do not 
     * affect calculations of frequencies or quantity.</p><p>This 
     * attribute is marked as 'mandatory' as it is the only 
     * information that can be specified here.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getAdditionalDosageInstruction() {
        return this.additionalDosageInstruction.getValue();
    }
    public void setAdditionalDosageInstruction(String additionalDosageInstruction) {
        this.additionalDosageInstruction.setValue(additionalDosageInstruction);
    }

}
