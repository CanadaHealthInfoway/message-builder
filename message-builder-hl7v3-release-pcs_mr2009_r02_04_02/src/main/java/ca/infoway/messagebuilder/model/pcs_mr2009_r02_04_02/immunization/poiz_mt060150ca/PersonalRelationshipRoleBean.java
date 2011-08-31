/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.poiz_mt060150ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.PersonalRelationshipRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POIZ_MT060150CA.PersonalRelationshipRole"})
public class PersonalRelationshipRoleBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged.InformationSourceChoice {

    private static final long serialVersionUID = 20110831L;
    private CV personalRelationshipType = new CVImpl();


    /**
     * <p>Personal Relationship Type</p>
     */
    @Hl7XmlMapping({"code"})
    public PersonalRelationshipRoleType getPersonalRelationshipType() {
        return (PersonalRelationshipRoleType) this.personalRelationshipType.getValue();
    }
    public void setPersonalRelationshipType(PersonalRelationshipRoleType personalRelationshipType) {
        this.personalRelationshipType.setValue(personalRelationshipType);
    }

}
