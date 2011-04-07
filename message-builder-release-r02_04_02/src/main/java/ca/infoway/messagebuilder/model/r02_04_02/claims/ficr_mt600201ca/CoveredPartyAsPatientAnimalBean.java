/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.claims.ficr_mt600201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT600201CA.CoveredPartyAsPatientAnimal"})
public class CoveredPartyAsPatientAnimalBean extends MessagePartBean implements ca.infoway.messagebuilder.model.r02_04_02.claims.merged.CoveredPartyAsPatientChoice {

    private static final long serialVersionUID = 20110407L;
    private ST nameOfTheAnimal = new STImpl();


    /**
     * <p>Name of the animal</p>
     */
    @Hl7XmlMapping({"name"})
    public String getNameOfTheAnimal() {
        return this.nameOfTheAnimal.getValue();
    }
    public void setNameOfTheAnimal(String nameOfTheAnimal) {
        this.nameOfTheAnimal.setValue(nameOfTheAnimal);
    }

}
