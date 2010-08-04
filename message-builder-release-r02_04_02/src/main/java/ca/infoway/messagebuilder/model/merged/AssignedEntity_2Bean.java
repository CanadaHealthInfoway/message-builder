/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import java.util.Set;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
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



@Hl7PartTypeMapping({"POIZ_MT030050CA.AssignedEntity","POIZ_MT030060CA.AssignedEntity","POIZ_MT060150CA.AssignedEntity"})
public class AssignedEntity_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private II healthcareWorkerIdentifier = new IIImpl();
    private CV healthcareWorkerType = new CVImpl();
    private SET<TEL, TelecommunicationAddress> healthcareWorkerPhoneAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private II organizationIdentifier = new IIImpl();
    private ST organizationName = new STImpl();
    private CV organizationType = new CVImpl();
    private SET<TEL, TelecommunicationAddress> organizationPhoneAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private PN healthcareWorkerName = new PNImpl();
    private II licenseNumber = new IIImpl();

    @Hl7XmlMapping({"id"})
    public Identifier getHealthcareWorkerIdentifier() {
        return this.healthcareWorkerIdentifier.getValue();
    }
    public void setHealthcareWorkerIdentifier(Identifier healthcareWorkerIdentifier) {
        this.healthcareWorkerIdentifier.setValue(healthcareWorkerIdentifier);
    }

    @Hl7XmlMapping({"code"})
    public HealthcareProviderRoleType getHealthcareWorkerType() {
        return (HealthcareProviderRoleType) this.healthcareWorkerType.getValue();
    }
    public void setHealthcareWorkerType(HealthcareProviderRoleType healthcareWorkerType) {
        this.healthcareWorkerType.setValue(healthcareWorkerType);
    }

    @Hl7XmlMapping({"telecom"})
    public Set<TelecommunicationAddress> getHealthcareWorkerPhoneAndEmails() {
        return this.healthcareWorkerPhoneAndEmails.rawSet();
    }

    @Hl7XmlMapping({"representedOrganization/id"})
    public Identifier getOrganizationIdentifier() {
        return this.organizationIdentifier.getValue();
    }
    public void setOrganizationIdentifier(Identifier organizationIdentifier) {
        this.organizationIdentifier.setValue(organizationIdentifier);
    }

    @Hl7XmlMapping({"representedOrganization/name"})
    public String getOrganizationName() {
        return this.organizationName.getValue();
    }
    public void setOrganizationName(String organizationName) {
        this.organizationName.setValue(organizationName);
    }

    @Hl7XmlMapping({"representedOrganization/assignedOrganization/code"})
    public HealthcareOrganizationRoleType getOrganizationType() {
        return (HealthcareOrganizationRoleType) this.organizationType.getValue();
    }
    public void setOrganizationType(HealthcareOrganizationRoleType organizationType) {
        this.organizationType.setValue(organizationType);
    }

    @Hl7XmlMapping({"representedOrganization/assignedOrganization/telecom"})
    public Set<TelecommunicationAddress> getOrganizationPhoneAndEmails() {
        return this.organizationPhoneAndEmails.rawSet();
    }

    @Hl7XmlMapping({"assignedPerson/name"})
    public PersonName getHealthcareWorkerName() {
        return this.healthcareWorkerName.getValue();
    }
    public void setHealthcareWorkerName(PersonName healthcareWorkerName) {
        this.healthcareWorkerName.setValue(healthcareWorkerName);
    }

    @Hl7XmlMapping({"assignedPerson/asHealthCareProvider/id"})
    public Identifier getLicenseNumber() {
        return this.licenseNumber.getValue();
    }
    public void setLicenseNumber(Identifier licenseNumber) {
        this.licenseNumber.setValue(licenseNumber);
    }

}