/**
 * Copyright 2012 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged;

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
 * <p>The person organization assigned to carry out the 
 * associated (linked by a participation) action and/or the 
 * organization under whose authority they are acting.</p>
 * 
 * <p>Critical to tracking responsibility and performing 
 * follow-up. The CMET supports both licensed providers as well 
 * as non-licensed providers such as technicians, 
 * receptionists, etc.</p>
 * 
 * <p>All attributes other than the various identifiers are 
 * expected to be retrieved from the provider registry.</p>
 * 
 * <p>COCT_MT090102CA.AssignedEntity: Healthcare Worker</p>
 * 
 * <p>The person assigned to carry out the associated action 
 * (linked by a participation) and/or the organization/group 
 * under whose authority they are acting.</p>
 * 
 * <p>Critical to tracking responsibility and performing 
 * follow-up. The CMET supports both licensed providers as well 
 * as non-licensed providers such as technicians, 
 * receptionists, etc.</p>
 */
@Hl7PartTypeMapping({"COCT_MT090102CA.AssignedEntity","COCT_MT090108CA.AssignedEntity","COCT_MT260010CA.AssignedEntity","COCT_MT260020CA.AssignedEntity","COCT_MT260030CA.AssignedEntity"})
@Hl7RootType
public class HealthcareWorkerBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.Choice, AuthorPerson, ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.iehr.merged.Party, ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.Recipient, ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt911108ca.ActingPerson, EntererChoice, ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.ChangedBy, ActingPerson {

    private static final long serialVersionUID = 20121122L;
    private ST assignedOrganizationName = new STImpl();
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private SET<TEL, TelecommunicationAddress> telecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private PN assignedPersonName = new PNImpl();
    private II assignedPersonAsHealthCareProviderId = new IIImpl();
    private II representedOrganizationId = new IIImpl();
    private CV representedOrganizationAssignedOrganizationCode = new CVImpl();
    private SET<TEL, TelecommunicationAddress> representedOrganizationAssignedOrganizationTelecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);


    /**
     * <p>C:Knowledgebase Vendor Name</p>
     * 
     * <p>The name of a clinical knowledgebase vendor 
     * organization.</p>
     * 
     * <p>Allows a knowledgebase vendor to be referenced by 
     * name.</p><p>The attribute is mandatory because it is the 
     * only information collected about a knowledgebase vendor.</p>
     * 
     * <p>Allows a knowledgebase vendor to be referenced by 
     * name.</p><p>The attribute is mandatory because it is the 
     * only information collected about a knowledgebase vendor.</p>
     * 
     * <p>H: Organization Name</p>
     * 
     * <p>Identifies the name of the organization</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>E: Organization Name</p>
     * 
     * <p>Identifies the name of the organization</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
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

    /**
     * <p>C:Knowledgebase Vendor Name</p>
     * 
     * <p>The name of a clinical knowledgebase vendor 
     * organization.</p>
     * 
     * <p>Allows a knowledgebase vendor to be referenced by 
     * name.</p><p>The attribute is mandatory because it is the 
     * only information collected about a knowledgebase vendor.</p>
     * 
     * <p>Allows a knowledgebase vendor to be referenced by 
     * name.</p><p>The attribute is mandatory because it is the 
     * only information collected about a knowledgebase vendor.</p>
     * 
     * <p>H: Organization Name</p>
     * 
     * <p>Identifies the name of the organization</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>E: Organization Name</p>
     * 
     * <p>Identifies the name of the organization</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     */
    public void setAssignedOrganizationName(String assignedOrganizationName) {
        this.assignedOrganizationName.setValue(assignedOrganizationName);
    }


    /**
     * <p>HealthcareWorkerIdentifier</p>
     * 
     * <p>A:Healthcare Worker Identifier</p>
     * 
     * <p>Unique identifier the person involved in the action.</p>
     * 
     * <p>Allows unique identification of the person which can be 
     * critical for authentication, permissions, drill-down and 
     * traceability and is therefore mandatory.</p>
     * 
     * <p>A: Healthcare Worker Identifier</p>
     * 
     * <p>Unique identifier the person involved in the action.</p>
     * 
     * <p>Allows unique identification of the person which can be 
     * critical for authentication, permissions, drill-down and 
     * traceability and is therefore mandatory.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>HealthcareWorkerIdentifier</p>
     * 
     * <p>A:Healthcare Worker Identifier</p>
     * 
     * <p>Unique identifier the person involved in the action.</p>
     * 
     * <p>Allows unique identification of the person which can be 
     * critical for authentication, permissions, drill-down and 
     * traceability and is therefore mandatory.</p>
     * 
     * <p>A: Healthcare Worker Identifier</p>
     * 
     * <p>Unique identifier the person involved in the action.</p>
     * 
     * <p>Allows unique identification of the person which can be 
     * critical for authentication, permissions, drill-down and 
     * traceability and is therefore mandatory.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>HealthcareWorkerType</p>
     * 
     * <p>B: Healthcare Worker Type</p>
     * 
     * <p>Indicates the &quot;kind&quot; of healthcare participant, 
     * such as &quot;physician&quot;, &quot;dentist&quot;, 
     * &quot;lab technician&quot;, &quot;receptionist&quot;, 
     * etc.</p>
     * 
     * <p>Provides context around the actions of the participant 
     * and is therefore mandatory.</p>
     */
    @Hl7XmlMapping({"code"})
    public HealthcareProviderRoleType getCode() {
        return (HealthcareProviderRoleType) this.code.getValue();
    }

    /**
     * <p>HealthcareWorkerType</p>
     * 
     * <p>B: Healthcare Worker Type</p>
     * 
     * <p>Indicates the &quot;kind&quot; of healthcare participant, 
     * such as &quot;physician&quot;, &quot;dentist&quot;, 
     * &quot;lab technician&quot;, &quot;receptionist&quot;, 
     * etc.</p>
     * 
     * <p>Provides context around the actions of the participant 
     * and is therefore mandatory.</p>
     */
    public void setCode(HealthcareProviderRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>HealthcareWorkerPhoneAndEmails</p>
     * 
     * <p>E: Healthcare Worker Phone and Emails</p>
     * 
     * <p>Indicates phone and/or e-mail addresses at which the 
     * healthcare worker can be reached.</p>
     * 
     * <p>This is the most commonly used piece of contact 
     * information and is returned here to avoid unnecessary 
     * queries of the provider registry.</p>
     */
    @Hl7XmlMapping({"telecom"})
    public Set<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawSet();
    }


    /**
     * <p>HealthcareWorkerName</p>
     * 
     * <p>B: Healthcare Worker Name</p>
     * 
     * <p>The name of the involved person.</p>
     * 
     * <p>This is a human-readable name and is essential for 
     * validation of the person. As a result, the attribute is 
     * mandatory</p>
     * 
     * <p>C: Healthcare Worker Name</p>
     * 
     * <p>The name of the participating person.</p>
     * 
     * <p>This is a human-readable name and is thus essential for 
     * both display and validation of the person. As a result, the 
     * attribute is mandatory.</p>
     */
    @Hl7XmlMapping({"assignedPerson/name"})
    public PersonName getAssignedPersonName() {
        return this.assignedPersonName.getValue();
    }

    /**
     * <p>HealthcareWorkerName</p>
     * 
     * <p>B: Healthcare Worker Name</p>
     * 
     * <p>The name of the involved person.</p>
     * 
     * <p>This is a human-readable name and is essential for 
     * validation of the person. As a result, the attribute is 
     * mandatory</p>
     * 
     * <p>C: Healthcare Worker Name</p>
     * 
     * <p>The name of the participating person.</p>
     * 
     * <p>This is a human-readable name and is thus essential for 
     * both display and validation of the person. As a result, the 
     * attribute is mandatory.</p>
     */
    public void setAssignedPersonName(PersonName assignedPersonName) {
        this.assignedPersonName.setValue(assignedPersonName);
    }


    /**
     * <p>LicenseNumber</p>
     * 
     * <p>C: License Number</p>
     * 
     * <p>The license number issued to the provider and relevant to 
     * the current action.</p>
     * 
     * <p>Allows lookup on college website, confirmation of 
     * identity, etc. Regulations occasionally require license 
     * numbers to be specified as part of clinical records.</p>
     * 
     * <p>If the identifier used in the root of the CMET is the 
     * same as the license number, the license number should be 
     * sent in both places.</p>
     * 
     * <p>D: License Number</p>
     * 
     * <p>The license number issued to the provider and relevant to 
     * the current action.</p>
     * 
     * <p>Allows lookup on college website, confirmation of 
     * identity, etc. Regulations occasionally require license 
     * numbers to be specified as part of clinical records.</p>
     * 
     * <p>If the identifier used in the root of the CMET is the 
     * same as the license number, the license number should be 
     * sent in both places.</p><p>Detailed information about the 
     * status and effective period of licenses must be retrieved 
     * from the provider registry.</p>
     * 
     * <p>If the identifier used in the root of the CMET is the 
     * same as the license number, the license number should be 
     * sent in both places.</p><p>Detailed information about the 
     * status and effective period of licenses must be retrieved 
     * from the provider registry.</p>
     */
    @Hl7XmlMapping({"assignedPerson/asHealthCareProvider/id"})
    public Identifier getAssignedPersonAsHealthCareProviderId() {
        return this.assignedPersonAsHealthCareProviderId.getValue();
    }

    /**
     * <p>LicenseNumber</p>
     * 
     * <p>C: License Number</p>
     * 
     * <p>The license number issued to the provider and relevant to 
     * the current action.</p>
     * 
     * <p>Allows lookup on college website, confirmation of 
     * identity, etc. Regulations occasionally require license 
     * numbers to be specified as part of clinical records.</p>
     * 
     * <p>If the identifier used in the root of the CMET is the 
     * same as the license number, the license number should be 
     * sent in both places.</p>
     * 
     * <p>D: License Number</p>
     * 
     * <p>The license number issued to the provider and relevant to 
     * the current action.</p>
     * 
     * <p>Allows lookup on college website, confirmation of 
     * identity, etc. Regulations occasionally require license 
     * numbers to be specified as part of clinical records.</p>
     * 
     * <p>If the identifier used in the root of the CMET is the 
     * same as the license number, the license number should be 
     * sent in both places.</p><p>Detailed information about the 
     * status and effective period of licenses must be retrieved 
     * from the provider registry.</p>
     * 
     * <p>If the identifier used in the root of the CMET is the 
     * same as the license number, the license number should be 
     * sent in both places.</p><p>Detailed information about the 
     * status and effective period of licenses must be retrieved 
     * from the provider registry.</p>
     */
    public void setAssignedPersonAsHealthCareProviderId(Identifier assignedPersonAsHealthCareProviderId) {
        this.assignedPersonAsHealthCareProviderId.setValue(assignedPersonAsHealthCareProviderId);
    }


    /**
     * <p>OrganizationIdentifier</p>
     * 
     * <p>D: Organization identifier</p>
     * 
     * <p>A unique identifier for the organization</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>F: Organization identifier</p>
     * 
     * <p>A unique identifier for the organization</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     */
    @Hl7XmlMapping({"representedOrganization/id"})
    public Identifier getRepresentedOrganizationId() {
        return this.representedOrganizationId.getValue();
    }

    /**
     * <p>OrganizationIdentifier</p>
     * 
     * <p>D: Organization identifier</p>
     * 
     * <p>A unique identifier for the organization</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>F: Organization identifier</p>
     * 
     * <p>A unique identifier for the organization</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     */
    public void setRepresentedOrganizationId(Identifier representedOrganizationId) {
        this.representedOrganizationId.setValue(representedOrganizationId);
    }


    /**
     * <p>OrganizationType</p>
     * 
     * <p>G: Organization Type</p>
     * 
     * <p>Identifies the type of organization on whose behalf the 
     * action was taken. E.g. Pharmacy, Clinic, Hospital, etc.</p>
     * 
     * <p>Provides context to the action and is therefore 
     * mandatory.</p>
     */
    @Hl7XmlMapping({"representedOrganization/assignedOrganization/code"})
    public HealthcareOrganizationRoleType getRepresentedOrganizationAssignedOrganizationCode() {
        return (HealthcareOrganizationRoleType) this.representedOrganizationAssignedOrganizationCode.getValue();
    }

    /**
     * <p>OrganizationType</p>
     * 
     * <p>G: Organization Type</p>
     * 
     * <p>Identifies the type of organization on whose behalf the 
     * action was taken. E.g. Pharmacy, Clinic, Hospital, etc.</p>
     * 
     * <p>Provides context to the action and is therefore 
     * mandatory.</p>
     */
    public void setRepresentedOrganizationAssignedOrganizationCode(HealthcareOrganizationRoleType representedOrganizationAssignedOrganizationCode) {
        this.representedOrganizationAssignedOrganizationCode.setValue(representedOrganizationAssignedOrganizationCode);
    }


    /**
     * <p>OrganizationPhoneAndEmails</p>
     * 
     * <p>I: Organization Phone and Emails</p>
     * 
     * <p>Identifies contact information for the responsible 
     * organization.</p>
     * 
     * <p>This is the most commonly used contact information and is 
     * returned to avoid unnecessary queries against the client 
     * registry.</p>
     */
    @Hl7XmlMapping({"representedOrganization/assignedOrganization/telecom"})
    public Set<TelecommunicationAddress> getRepresentedOrganizationAssignedOrganizationTelecom() {
        return this.representedOrganizationAssignedOrganizationTelecom.rawSet();
    }

}
