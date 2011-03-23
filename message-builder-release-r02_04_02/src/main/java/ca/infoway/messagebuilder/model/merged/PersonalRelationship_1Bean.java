/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT400001CA.PersonalRelationship","FICR_MT400003CA.PersonalRelationship","FICR_MT400004CA.PersonalRelationship","FICR_MT490101CA.PersonalRelationship","FICR_MT490102CA.PersonalRelationship","FICR_MT500201CA.PersonalRelationship","FICR_MT510201CA.PersonalRelationship","FICR_MT600201CA.PersonalRelationship","FICR_MT610201CA.PersonalRelationship"})
public class PersonalRelationship_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private CV personalRelationshipType = new CVImpl();

    @Hl7XmlMapping({"code"})
    public Code getPersonalRelationshipType() {
        return (Code) this.personalRelationshipType.getValue();
    }
    public void setPersonalRelationshipType(Code personalRelationshipType) {
        this.personalRelationshipType.setValue(personalRelationshipType);
    }

}
