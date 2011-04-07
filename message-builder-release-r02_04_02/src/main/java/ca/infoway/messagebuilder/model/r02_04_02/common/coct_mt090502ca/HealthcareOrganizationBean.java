/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt090502ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Healthcare Organization</p>
 * 
 * <p><p>The organization under whose authority the associated 
 * action (linked by a participation) was performed.</p></p>
 * 
 * <p><p>Critical to tracking responsibility and performing 
 * follow-up.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT090502CA.AssignedEntity"})
@Hl7RootType
public class HealthcareOrganizationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt080100ca.PerformerChoice, ca.infoway.messagebuilder.model.r02_04_02.lab.merged.RecipientChoice, ca.infoway.messagebuilder.model.r02_04_02.common.merged.ActingPerson, ca.infoway.messagebuilder.model.r02_04_02.common.merged.AuthorPerson, ca.infoway.messagebuilder.model.r02_04_02.merged.RoleChoice, ca.infoway.messagebuilder.model.r02_04_02.common.merged.EntererChoice, ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt011001ca.Assignees {

    private static final long serialVersionUID = 20110407L;
    private II organizationIdentifier = new IIImpl();
    private ST organizationName = new STImpl();


    /**
     * <p>D: Organization identifier</p>
     * 
     * <p><p>A unique identifier for the organization</p></p>
     * 
     * <p><p>Allows the organization to be referenced when 
     * determining privileges and for drill-downs to retrieve 
     * additional information. Because of its importance, the 
     * attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"representedOrganization/id"})
    public Identifier getOrganizationIdentifier() {
        return this.organizationIdentifier.getValue();
    }
    public void setOrganizationIdentifier(Identifier organizationIdentifier) {
        this.organizationIdentifier.setValue(organizationIdentifier);
    }


    /**
     * <p>E: Organization Name</p>
     * 
     * <p><p>Identifies the name of the organization</p></p>
     * 
     * <p><p>Allows for human recognition of the organization as 
     * well as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"representedOrganization/name"})
    public String getOrganizationName() {
        return this.organizationName.getValue();
    }
    public void setOrganizationName(String organizationName) {
        this.organizationName.setValue(organizationName);
    }

}
