/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.porx_mt010120ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Enables the 
 * indication of whether the prescription is ineligible for 
 * trial dispensing.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Serves as 
 * reminder for dispenser that the prescription is not to be 
 * trial-filled. In some jurisdictions, the prescription must 
 * be so designated by the prescriber for the dispenser to do 
 * trial dispensing.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.Component2"})
public class Component2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private BL notEligibleForTrial = new BLImpl();


    /**
     * <p>G:Not Eligible for Trial?</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">An 
     * indication that a prescription is or is not eligible for 
     * trial dispensing from a clinical (not financial) 
     * perspective. False = Eligible, True = Not Eligible.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">May affect 
     * dispensers' discretion to dispense anything other than 
     * prescribed fill quantity.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Expressed as 
     * 'Non-Eligibility' rather than 'Eligibility' due to 
     * restrictions in HL7 modeling.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The element is 
     * mandatory because it must always be known whether the 
     * element is true or false.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">May affect 
     * dispensers' discretion to dispense anything other than 
     * prescribed fill quantity.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Expressed as 
     * 'Non-Eligibility' rather than 'Eligibility' due to 
     * restrictions in HL7 modeling.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The element is 
     * mandatory because it must always be known whether the 
     * element is true or false.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">May affect 
     * dispensers' discretion to dispense anything other than 
     * prescribed fill quantity.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Expressed as 
     * 'Non-Eligibility' rather than 'Eligibility' due to 
     * restrictions in HL7 modeling.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The element is 
     * mandatory because it must always be known whether the 
     * element is true or false.</p></p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNotEligibleForTrial() {
        return this.notEligibleForTrial.getValue();
    }
    public void setNotEligibleForTrial(Boolean notEligibleForTrial) {
        this.notEligibleForTrial.setValue(notEligibleForTrial);
    }

}
