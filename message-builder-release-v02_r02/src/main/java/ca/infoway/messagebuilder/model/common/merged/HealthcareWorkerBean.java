/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.HealthcareOrganizationRoleType;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
 * <p>HealthcareWorker</p>
 * 
 * <p>COCT_MT090108CA.AssignedEntity: Healthcare Worker</p>
 * 
 * <p><p>The person organization assigned to carry out the 
 * associated (linked by a participation) action and/or the 
 * organization under whose authority they are acting.</p></p>
 * 
 * <p><p>Critical to tracking responsibility and performing 
 * follow-up. The CMET supports both licensed providers as well 
 * as non-licensed providers such as technicians, 
 * receptionists, etc.</p></p>
 * 
 * <p><p>All attributes other than the various identifiers are 
 * expected to be retrieved from the provider registry.</p></p>
 * 
 * <p>COCT_MT090102CA.AssignedEntity: Healthcare Worker</p>
 * 
 * <p><p>The person assigned to carry out the associated action 
 * (linked by a participation) and/or the organization/group 
 * under whose authority they are acting.</p></p>
 * 
 * <p><p>Critical to tracking responsibility and performing 
 * follow-up. The CMET supports both licensed providers as well 
 * as non-licensed providers such as technicians, 
 * receptionists, etc.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT090102CA.AssignedEntity","COCT_MT090108CA.AssignedEntity","COCT_MT260010CA.AssignedEntity","COCT_MT260020CA.AssignedEntity","COCT_MT260030CA.AssignedEntity"})
@Hl7RootType
public class HealthcareWorkerBean extends MessagePartBean implements EntererChoice, AuthorPerson, ca.infoway.messagebuilder.model.merged.Recipient, ca.infoway.messagebuilder.model.merged.Choice, ca.infoway.messagebuilder.model.pharmacy.merged.ChangedBy, ca.infoway.messagebuilder.model.common.coct_mt911108ca.ActingPerson, ca.infoway.messagebuilder.model.iehr.merged.Party, ActingPerson {

    private static final long serialVersionUID = 20110127L;
    private ST assignedOrganizationName = new STImpl();
    private II healthcareWorkerIdentifier = new IIImpl();
    private CV healthcareWorkerType = new CVImpl();
    private CV organizationType = new CVImpl();
    private SET<TEL, TelecommunicationAddress> organizationPhoneAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private II organizationIdentifier = new IIImpl();
    private PN healthcareWorkerName = new PNImpl();
    private II licenseNumber = new IIImpl();
    private SET<TEL, TelecommunicationAddress> healthcareWorkerPhoneAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);


    /**
     * <p>E: Organization Name</p>
     * 
     * <p><p>Identifies the name of the organization</p></p>
     * 
     * <p><p>Allows for human recognition of the organization as 
     * well as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p></p>
     * 
     * <p>H: Organization Name</p>
     * 
     * <p><p>Identifies the name of the organization</p></p>
     * 
     * <p><p>Allows for human recognition of the organization as 
     * well as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p></p>
     * 
     * <p>C:Knowledgebase Vendor Name</p>
     * 
     * <p><p>The name of a clinical knowledgebase vendor 
     * organization.</p></p>
     * 
     * <p><p>Allows a knowledgebase vendor to be referenced by 
     * name.</p><p>The attribute is mandatory because it is the 
     * only information collected about a knowledgebase vendor.</p></p>
     * 
     * <p><p>Allows a knowledgebase vendor to be referenced by 
     * name.</p><p>The attribute is mandatory because it is the 
     * only information collected about a knowledgebase vendor.</p></p>
     */
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


    /**
     * <p>HealthcareWorkerIdentifier</p>
     * 
     * <p>A:Healthcare Worker Identifier</p>
     * 
     * <p><p>Unique identifier the person involved in the 
     * action.</p></p>
     * 
     * <p><p>Allows unique identification of the person which can 
     * be critical for authentication, permissions, drill-down and 
     * traceability and is therefore mandatory.</p></p>
     * 
     * <p>A: Healthcare Worker Identifier</p>
     * 
     * <p><p>Unique identifier the person involved in the 
     * action.</p></p>
     * 
     * <p><p>Allows unique identification of the person which can 
     * be critical for authentication, permissions, drill-down and 
     * traceability and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getHealthcareWorkerIdentifier() {
        return this.healthcareWorkerIdentifier.getValue();
    }
    public void setHealthcareWorkerIdentifier(Identifier healthcareWorkerIdentifier) {
        this.healthcareWorkerIdentifier.setValue(healthcareWorkerIdentifier);
    }


    /**
     * <p>HealthcareWorkerType</p>
     * 
     * <p>B: Healthcare Worker Type</p>
     * 
     * <p><p>Indicates the &quot;kind&quot; of healthcare 
     * participant, such as &quot;physician&quot;, 
     * &quot;dentist&quot;, &quot;lab technician&quot;, 
     * &quot;receptionist&quot;, etc.</p></p>
     * 
     * <p><p>Provides context around the actions of the participant 
     * and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public HealthcareProviderRoleType getHealthcareWorkerType() {
        return (HealthcareProviderRoleType) this.healthcareWorkerType.getValue();
    }
    public void setHealthcareWorkerType(HealthcareProviderRoleType healthcareWorkerType) {
        this.healthcareWorkerType.setValue(healthcareWorkerType);
    }


    /**
     * <p>OrganizationType</p>
     * 
     * <p>G: Organization Type</p>
     * 
     * <p><p>Identifies the type of organization on whose behalf 
     * the action was taken. E.g. Pharmacy, Clinic, Hospital, 
     * etc.</p></p>
     * 
     * <p><p>Provides context to the action and is therefore 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"representedOrganization/assignedOrganization/code"})
    public HealthcareOrganizationRoleType getOrganizationType() {
        return (HealthcareOrganizationRoleType) this.organizationType.getValue();
    }
    public void setOrganizationType(HealthcareOrganizationRoleType organizationType) {
        this.organizationType.setValue(organizationType);
    }


    /**
     * <p>OrganizationPhoneAndEmails</p>
     * 
     * <p>I: Organization Phone and Emails</p>
     * 
     * <p><p>Identifies contact information for the responsible 
     * organization.</p></p>
     * 
     * <p><p>This is the most commonly used contact information and 
     * is returned to avoid unnecessary queries against the client 
     * registry.</p></p>
     */
    @Hl7XmlMapping({"representedOrganization/assignedOrganization/telecom"})
    public Set<TelecommunicationAddress> getOrganizationPhoneAndEmails() {
        return this.organizationPhoneAndEmails.rawSet();
    }


    /**
     * <p>OrganizationIdentifier</p>
     * 
     * <p>D: Organization identifier</p>
     * 
     * <p><p>A unique identifier for the organization</p></p>
     * 
     * <p><p>Allows the organization to be referenced when 
     * determining privileges and for drill-downs to retrieve 
     * additional information. Because of its importance, the 
     * attribute is mandatory.</p></p>
     * 
     * <p>F: Organization identifier</p>
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
     * <p>HealthcareWorkerName</p>
     * 
     * <p>B: Healthcare Worker Name</p>
     * 
     * <p><p>The name of the involved person.</p></p>
     * 
     * <p><p>This is a human-readable name and is essential for 
     * validation of the person. As a result, the attribute is 
     * mandatory</p></p>
     * 
     * <p>C: Healthcare Worker Name</p>
     * 
     * <p><p>The name of the participating person.</p></p>
     * 
     * <p><p>This is a human-readable name and is thus essential 
     * for both display and validation of the person. As a result, 
     * the attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"assignedPerson/name"})
    public PersonName getHealthcareWorkerName() {
        return this.healthcareWorkerName.getValue();
    }
    public void setHealthcareWorkerName(PersonName healthcareWorkerName) {
        this.healthcareWorkerName.setValue(healthcareWorkerName);
    }


    /**
     * <p>LicenseNumber</p>
     * 
     * <p>D: License Number</p>
     * 
     * <p><p>The license number issued to the provider and relevant 
     * to the current action.</p></p>
     * 
     * <p><p>Allows lookup on college website, confirmation of 
     * identity, etc. Regulations occasionally require license 
     * numbers to be specified as part of clinical records.</p></p>
     * 
     * <p><p>If the identifier used in the root of the CMET is the 
     * same as the license number, the license number should be 
     * sent in both places.</p><p>Detailed information about the 
     * status and effective period of licenses must be retrieved 
     * from the provider registry.</p></p>
     * 
     * <p><p>If the identifier used in the root of the CMET is the 
     * same as the license number, the license number should be 
     * sent in both places.</p><p>Detailed information about the 
     * status and effective period of licenses must be retrieved 
     * from the provider registry.</p></p>
     * 
     * <p>C: License Number</p>
     * 
     * <p><p>The license number issued to the provider and relevant 
     * to the current action.</p></p>
     * 
     * <p><p>Allows lookup on college website, confirmation of 
     * identity, etc. Regulations occasionally require license 
     * numbers to be specified as part of clinical records.</p></p>
     * 
     * <p><p>If the identifier used in the root of the CMET is the 
     * same as the license number, the license number should be 
     * sent in both places.</p></p>
     */
    @Hl7XmlMapping({"assignedPerson/asHealthCareProvider/id"})
    public Identifier getLicenseNumber() {
        return this.licenseNumber.getValue();
    }
    public void setLicenseNumber(Identifier licenseNumber) {
        this.licenseNumber.setValue(licenseNumber);
    }


    /**
     * <p>HealthcareWorkerPhoneAndEmails</p>
     * 
     * <p>E: Healthcare Worker Phone and Emails</p>
     * 
     * <p><p>Indicates phone and/or e-mail addresses at which the 
     * healthcare worker can be reached.</p></p>
     * 
     * <p><p>This is the most commonly used piece of contact 
     * information and is returned here to avoid unnecessary 
     * queries of the provider registry.</p></p>
     */
    @Hl7XmlMapping({"telecom"})
    public Set<TelecommunicationAddress> getHealthcareWorkerPhoneAndEmails() {
        return this.healthcareWorkerPhoneAndEmails.rawSet();
    }

}
