/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p><p>Who did the substitution</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT300000CA.SubstitutionRole"})
public class SubstitutionRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private II personWhoDidTheSubstitution = new IIImpl();


    /**
     * <p>Person who did the substitution</p>
     * 
     * <p><p>ID must be that of the patient, ordering provider or 
     * dispensing provider</p></p>
     * 
     * <p><p>Id must be that of the patient, ordering provider or 
     * dispensing provider.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPersonWhoDidTheSubstitution() {
        return this.personWhoDidTheSubstitution.getValue();
    }
    public void setPersonWhoDidTheSubstitution(Identifier personWhoDidTheSubstitution) {
        this.personWhoDidTheSubstitution.setValue(personWhoDidTheSubstitution);
    }

}