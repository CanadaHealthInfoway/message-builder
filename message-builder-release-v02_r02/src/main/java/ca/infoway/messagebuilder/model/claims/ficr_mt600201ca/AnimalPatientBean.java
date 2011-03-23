/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt600201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Animal Patient</p>
 * 
 * <p>Animal Patient</p>
 * 
 * <p>Used when invoice is for animal patient.</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.CoveredPartyAsPatientAnimal"})
public class AnimalPatientBean extends MessagePartBean implements CoveredPartyAsPatientChoiceBean {

    private static final long serialVersionUID = 20100614L;
    private ST nameOfTheAnimal = new STImpl();

    @Hl7XmlMapping({"name"})
    public String getNameOfTheAnimal() {
        return this.nameOfTheAnimal.getValue();
    }
    public void setNameOfTheAnimal(String nameOfTheAnimal) {
        this.nameOfTheAnimal.setValue(nameOfTheAnimal);
    }

}
