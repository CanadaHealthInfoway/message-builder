package ca.infoway.messagebuilder.model.newfoundland;

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
 * <p>Healthcare Organization 
 * 
 * <p>The organization under whose authority the associated 
 * action (linked by a participation) was performed. 
 * 
 * <p>Critical to tracking responsibility and performing 
 * follow-up. 
 */
@Hl7PartTypeMapping("COCT_MT090502CA.AssignedEntity")
@Hl7RootType
public class HealthcareOrganizationBean extends MessagePartBean implements AuthorPerson {

    private static final long serialVersionUID = 6960026369111472289L;
    
	private II organizationIdentifier = new IIImpl();
    private ST organizationName = new STImpl();


    /**
     * <p>D: Organization identifier 
     * 
     * <p>A unique identifier for the organization 
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory. 
     */
    @Hl7XmlMapping("representedOrganization/id")
    public Identifier getOrganizationIdentifier() {
        return this.organizationIdentifier.getValue();
    }
    public void setOrganizationIdentifier(Identifier organizationIdentifier) {
        this.organizationIdentifier.setValue(organizationIdentifier);
    }


    /**
     * <p>E: Organization Name 
     * 
     * <p>Identifies the name of the organization 
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory. 
     */
    @Hl7XmlMapping("representedOrganization/name")
    public String getOrganizationName() {
        return this.organizationName.getValue();
    }
    public void setOrganizationName(String organizationName) {
        this.organizationName.setValue(organizationName);
    }
}
