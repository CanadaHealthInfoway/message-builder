/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"POIZ_MT030050CA.NextImmunizationPlan","POIZ_MT030060CA.NextImmunizationPlan","POIZ_MT060150CA.NextImmunizationPlan"})
public class NextImmunizationPlanBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private TS effectiveTime = new TSImpl();


    /**
     * <p>Repeat Date</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The date on 
     * which the overall immunization therapy is to be 
     * repeated.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows for 
     * immunization therapy planning for a patient.</p></p>
     * 
     * <p>Renewal Date</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the date on which the next course of immunization is to be 
     * undertaken.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Necessary 
     * reminder to a patient and his/or provider for a follow-up 
     * therapy.</p></p>
     * 
     * <p>Next Planned Dose Date</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the date on which the next dose is to be administered.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows for 
     * the scheduling of a multi-dose immunization course.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

}
