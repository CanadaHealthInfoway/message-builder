/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.common.coct_mt270010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Administration Precondition</p>
 * 
 * <p><p>This sets the conditions for which a specific 
 * administration of the drug may be undertaken. Example: if 
 * headache persists for 2hrs or more 'take 2 tabs.</p></p>
 * 
 * <p><p>Indicates that prescription is a 'PRN' (as needed) 
 * prescription and that doses to be consumed cannot be 
 * accurately calculated. This has important compliance 
 * implications.</p></p>
 * 
 * <p><p>To flag a prescription as '''PRN''' without specifying 
 * a condition, include the association but specify a null 
 * flavor for the Dosage Condition.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT270010CA.ActEventCriterion"})
public class AdministrationPreconditionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private ST dosageCondition = new STImpl();


    /**
     * <p>A:Dosage Condition</p>
     * 
     * <p><p>A free-form textual description of condition that must 
     * be met before the product may be administered to/by the 
     * patient.</p><p>Example: When pressure exceeds 150/90 - Take 
     * 2 tabs</p></p>
     * 
     * <p><p>A free-form textual description of condition that must 
     * be met before the product may be administered to/by the 
     * patient.</p><p>Example: When pressure exceeds 150/90 - Take 
     * 2 tabs</p></p>
     * 
     * <p><p>RepeatPattern.prn (true when present)</p><p>ZDP.13.6 
     * (true when present)</p><p>ZDP.13.7</p></p>
     * 
     * <p><p>RepeatPattern.prn (true when present)</p><p>ZDP.13.6 
     * (true when present)</p><p>ZDP.13.7</p></p>
     * 
     * <p><p>RepeatPattern.prn (true when present)</p><p>ZDP.13.6 
     * (true when present)</p><p>ZDP.13.7</p></p>
     * 
     * <p><p>Allows un-coded specifications of conditions in which 
     * the medication should be taken.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getDosageCondition() {
        return this.dosageCondition.getValue();
    }
    public void setDosageCondition(String dosageCondition) {
        this.dosageCondition.setValue(dosageCondition);
    }

}