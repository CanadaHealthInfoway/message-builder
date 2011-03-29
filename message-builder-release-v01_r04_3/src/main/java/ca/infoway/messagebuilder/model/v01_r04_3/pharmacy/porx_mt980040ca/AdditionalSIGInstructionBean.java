/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.porx_mt980040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodDefEvnRqo;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT980040CA.SupplementalInstruction"})
public class AdditionalSIGInstructionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CS dosageUsageContext = new CSImpl();
    private ST additionalDosageInstruction = new STImpl();


    /**
     * <p>Dosage Usage Context</p>
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
     */
    @Hl7XmlMapping({"text"})
    public String getAdditionalDosageInstruction() {
        return this.additionalDosageInstruction.getValue();
    }
    public void setAdditionalDosageInstruction(String additionalDosageInstruction) {
        this.additionalDosageInstruction.setValue(additionalDosageInstruction);
    }

}