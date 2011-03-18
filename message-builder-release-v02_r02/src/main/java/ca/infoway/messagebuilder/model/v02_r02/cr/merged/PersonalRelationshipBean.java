/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.cr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.PersonalRelationshipRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>PersonalRelationship</p>
 * 
 * <p>PRPA_MT101001CA.PersonalRelationship: Personal 
 * Relationship</p>
 * 
 * <p><p>Associations between persons in the Person Registry, 
 * such as spouse or parent, can be sent in a 
 * PersonalRelationship class. The exact nature of a 
 * association is described by the code attribute with a value 
 * drawn from the PersonalRelationshipRoleType domain. Most 
 * associations can be represented in either of two ways 
 * depending on who is the player and who is the scoper. For 
 * example, the association between a father and his daughter 
 * can be represented by a code of &quot;father&quot; where the 
 * parent is the player and the child is the scoper, or by a 
 * code of &quot;daughter&quot; where the child is the player 
 * and the parent is the scoper.</p></p>
 * 
 * <p><p>Supports the business requirement to capture 
 * additional information about the Identified Client's Next of 
 * Kin</p></p>
 * 
 * <p>PRPA_MT101104CA.PersonalRelationship: Personal 
 * Relationship</p>
 * 
 * <p><p>Associations between persons in the Person Registry, 
 * such as spouse or parent, can be sent in a 
 * PersonalRelationship class. The exact nature of a 
 * association is described by the code attribute with a value 
 * drawn from the PersonalRelationshipRoleType domain. Most 
 * associations can be represented in either of two ways 
 * depending on who is the player and who is the scoper. For 
 * example, the association between a father and his daughter 
 * can be represented by a code of &quot;father&quot; where the 
 * parent is the player and the child is the scoper, or by a 
 * code of &quot;daughter&quot; where the child is the player 
 * and the parent is the scoper.</p></p>
 * 
 * <p><p>Supports the business requirement to capture 
 * additional information about the Identified Client's Next of 
 * Kin</p></p>
 * 
 * <p>PRPA_MT101102CA.PersonalRelationship: Personal 
 * Relationship</p>
 * 
 * <p><p>Associations between persons in the Person Registry, 
 * such as spouse or parent, can be sent in a 
 * PersonalRelationship class. The exact nature of a 
 * association is described by the code attribute with a value 
 * drawn from the PersonalRelationshipRoleType domain. Most 
 * associations can be represented in either of two ways 
 * depending on who is the player and who is the scoper. For 
 * example, the association between a father and his daughter 
 * can be represented by a code of &quot;father&quot; where the 
 * parent is the player and the child is the scoper, or by a 
 * code of &quot;daughter&quot; where the child is the player 
 * and the parent is the scoper.</p></p>
 * 
 * <p><p>Supports the business requirement to capture 
 * additional information about the Identified Client's Next of 
 * Kin</p></p>
 * 
 * <p>PRPA_MT101002CA.PersonalRelationship: Personal 
 * Relationship</p>
 * 
 * <p><p>Associations between persons in the Person Registry, 
 * such as spouse or parent, can be sent in a 
 * PersonalRelationship class. The exact nature of a 
 * association is described by the code attribute with a value 
 * drawn from the PersonalRelationshipRoleType domain. Most 
 * associations can be represented in either of two ways 
 * depending on who is the player and who is the scoper. For 
 * example, the association between a father and his daughter 
 * can be represented by a code of &quot;father&quot; where the 
 * parent is the player and the child is the scoper, or by a 
 * code of &quot;daughter&quot; where the child is the player 
 * and the parent is the scoper.</p></p>
 * 
 * <p><p>Supports the business requirement to capture 
 * additional information about the Identified Client's Next of 
 * Kin</p></p>
 * 
 * <p><p>Links two people in a personal relationship. The 
 * character of the relationship must be defined by a 
 * PersonalRelationshipRoleType code. The player and scoper are 
 * determined by PersonalRelationshipRoleType code as well.</p></p>
 */
@Hl7PartTypeMapping({"PRPA_MT101001CA.PersonalRelationship","PRPA_MT101002CA.PersonalRelationship","PRPA_MT101102CA.PersonalRelationship","PRPA_MT101104CA.PersonalRelationship"})
public class PersonalRelationshipBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CV clientNextOfKin = new CVImpl();
    private II nextOfKinIdentifier = new IIImpl();
    private PN nextOfKinName = new PNImpl();


    /**
     * <p>ClientNextOfKin</p>
     * 
     * <p>Client Next of Kin</p>
     * 
     * <p><p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p></p>
     * 
     * <p><p>Mandatory attribute that supports understanding the 
     * relationship between the client and the Next of Kin</p></p>
     * 
     * <p>Client Next of Kin</p>
     * 
     * <p><p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p></p>
     * 
     * <p><p>Mandatory attribute that supports understanding the 
     * relationship between the client and the ParentClient</p></p>
     */
    @Hl7XmlMapping({"code"})
    public PersonalRelationshipRoleType getClientNextOfKin() {
        return (PersonalRelationshipRoleType) this.clientNextOfKin.getValue();
    }
    public void setClientNextOfKin(PersonalRelationshipRoleType clientNextOfKin) {
        this.clientNextOfKin.setValue(clientNextOfKin);
    }


    /**
     * <p>NextOfKinIdentifier</p>
     * 
     * <p>Next of Kin Identifier</p>
     * 
     * <p><p>A unique identifier for the next of kin</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * next of kin</p></p>
     */
    @Hl7XmlMapping({"relationshipHolder/id"})
    public Identifier getNextOfKinIdentifier() {
        return this.nextOfKinIdentifier.getValue();
    }
    public void setNextOfKinIdentifier(Identifier nextOfKinIdentifier) {
        this.nextOfKinIdentifier.setValue(nextOfKinIdentifier);
    }


    /**
     * <p>NextOfKinName</p>
     * 
     * <p>Next of Kin Name</p>
     * 
     * <p><p>A name for the next of kin</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * next of kin</p></p>
     */
    @Hl7XmlMapping({"relationshipHolder/name"})
    public PersonName getNextOfKinName() {
        return this.nextOfKinName.getValue();
    }
    public void setNextOfKinName(PersonName nextOfKinName) {
        this.nextOfKinName.setValue(nextOfKinName);
    }

}
