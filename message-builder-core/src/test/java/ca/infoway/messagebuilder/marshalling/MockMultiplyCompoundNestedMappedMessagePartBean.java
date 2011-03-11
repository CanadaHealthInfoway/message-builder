package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;

/**
 *	@sharpen.ignore 
 */
@Hl7PartTypeMapping("MOCK_MT898989CA")
public class MockMultiplyCompoundNestedMappedMessagePartBean {

	private static final long serialVersionUID = -8148180862570811368L;
	
    private ST assignedOrganizationName = new STImpl();
    private II organizationIdentifier = new IIImpl();
    private II otherOrganizationIdentifier = new IIImpl();

    @Hl7XmlMapping({"assignedOrganization/name","representedOrganization/name"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="assignedOrganization", type="COCT_MT260010CA.Organization"),
        @Hl7MapByPartType(name="assignedOrganization", type="COCT_MT260020CA.Organization"),
        @Hl7MapByPartType(name="assignedOrganization", type="COCT_MT260030CA.Organization"),
        @Hl7MapByPartType(name="representedOrganization", type="COCT_MT090102CA.Organization"),
        @Hl7MapByPartType(name="representedOrganization", type="COCT_MT090108CA.Organization")})
    public String getAssignedOrganizationName() {
        return this.assignedOrganizationName.getValue();
    }
    public void setAssignedOrganizationName(String assignedOrganizationName) {
        this.assignedOrganizationName.setValue(assignedOrganizationName);
    }

    @Hl7XmlMapping({"representedOrganization/id"})
    public Identifier getOrganizationIdentifier() {
        return this.organizationIdentifier.getValue();
    }
    public void setOrganizationIdentifier(Identifier organizationIdentifier) {
        this.organizationIdentifier.setValue(organizationIdentifier);
    }
    
    @Hl7XmlMapping({"assignedOrganization/otherId"})
    public Identifier getOtherOrganizationIdentifier() {
        return this.otherOrganizationIdentifier.getValue();
    }
    public void setOtherOrganizationIdentifier(Identifier otherOrganizationIdentifier) {
        this.otherOrganizationIdentifier.setValue(otherOrganizationIdentifier);
    }
}
