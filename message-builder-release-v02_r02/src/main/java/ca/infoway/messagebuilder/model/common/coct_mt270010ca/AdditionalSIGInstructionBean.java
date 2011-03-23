/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt270010ca;

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
 * <p>This is a modifier for a specific dosage line or for the 
 * entire SIG. Examples are: On empty stomach, At breakfast, 
 * before bedtime, etc.</p>
 * 
 * <p>Adds further constraint or flexibility to the primary 
 * administration instruction.</p>
 * 
 * <p>- moodCode must be DEFN for drug definitions (such as as 
 * monographs) - moodCode must be RQO for orders; - moodCode 
 * must be EVN for dispenses and recording of other medications 
 * { x.; }</p>
 */
@Hl7PartTypeMapping({"COCT_MT270010CA.SupplementalInstruction"})
public class AdditionalSIGInstructionBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private CS dosageUsageContext = new CSImpl();
    private ST additionalDosageInstruction = new STImpl();

    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodDefEvnRqo getDosageUsageContext() {
        return (x_ActMoodDefEvnRqo) this.dosageUsageContext.getValue();
    }
    public void setDosageUsageContext(x_ActMoodDefEvnRqo dosageUsageContext) {
        this.dosageUsageContext.setValue(dosageUsageContext);
    }

    @Hl7XmlMapping({"text"})
    public String getAdditionalDosageInstruction() {
        return this.additionalDosageInstruction.getValue();
    }
    public void setAdditionalDosageInstruction(String additionalDosageInstruction) {
        this.additionalDosageInstruction.setValue(additionalDosageInstruction);
    }

}
