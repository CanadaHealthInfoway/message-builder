/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT020070CA.Agent","PORX_MT060090CA.Agent","PORX_MT060160CA.Agent","PORX_MT060340CA.Agent"})
public class AgentBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private II substitutingPersonIdentifier = new IIImpl();


    /**
     * <p>SubstitutingPersonIdentifier</p>
     * 
     * <p>Substituting Person Identifier</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The identity 
     * of the person who was ultimately responsible for the drug 
     * substitution.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">This is either the 
     * patient, the prescriber of the dispenser.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The identity 
     * of the person who was ultimately responsible for the drug 
     * substitution.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">This is either the 
     * patient, the prescriber of the dispenser.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides a 
     * trace of responsibility for the dispensed drug.</p></p>
     * 
     * <p>Substituting Person Identifier</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identity of 
     * the person who ultimately made the substitution 
     * decision.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides a 
     * trace of responsibility for the substitution.</p></p>
     * 
     * <p><p>Identity of the person who ultimately made the 
     * substitution decision. This must be either the patient's 
     * identifier, the prescriber identifier, or the dispenser 
     * identifier <strong>or a BUS error will be 
     * returned.</strong></p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getSubstitutingPersonIdentifier() {
        return this.substitutingPersonIdentifier.getValue();
    }
    public void setSubstitutingPersonIdentifier(Identifier substitutingPersonIdentifier) {
        this.substitutingPersonIdentifier.setValue(substitutingPersonIdentifier);
    }

}
