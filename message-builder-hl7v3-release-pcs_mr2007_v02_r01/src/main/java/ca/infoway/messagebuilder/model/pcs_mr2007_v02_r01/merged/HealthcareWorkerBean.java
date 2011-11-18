/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged;

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



@Hl7PartTypeMapping({"COCT_MT090102CA.AssignedEntity","COCT_MT090108CA.AssignedEntity","COCT_MT260010CA.AssignedEntity","COCT_MT260020CA.AssignedEntity","COCT_MT260030CA.AssignedEntity","POME_MT010040CA.AssignedEntity1","POME_MT010040CA.AssignedEntity2","POME_MT010040CA.AssignedEntity3","POME_MT010040CA.AssignedEntity4","PORR_MT050016CA.AssignedEntity"})
@Hl7RootType
public class HealthcareWorkerBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.iehr.merged.Party, Recipient, ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.pharmacy.merged.ChangedBy, ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt911108ca.ActingPerson, ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged.ActingPerson {

    private static final long serialVersionUID = 20111117L;
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
     * <p>Recommending Authority Name</p>
     * 
     * <p>E: Organization Name</p>
     * 
     * <p>H: Organization Name</p>
     * 
     * <p>Monitoring Organization Name</p>
     * 
     * <p>Formulary Owner Name</p>
     * 
     * <p>D:Medication Document Author Name</p>
     * 
     * <p>C:Knowledgebase Vendor Name</p>
     * 
     * <p>Monograph Author Name</p>
     */
    @Hl7XmlMapping({"assignedOrganization/name","representedOrganization/name"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="assignedOrganization", type="COCT_MT260010CA.Organization"),
        @Hl7MapByPartType(name="assignedOrganization", type="COCT_MT260020CA.Organization"),
        @Hl7MapByPartType(name="assignedOrganization", type="COCT_MT260030CA.Organization"),
        @Hl7MapByPartType(name="assignedOrganization", type="POME_MT010040CA.Organization1"),
        @Hl7MapByPartType(name="assignedOrganization", type="POME_MT010040CA.Organization2"),
        @Hl7MapByPartType(name="assignedOrganization", type="POME_MT010040CA.Organization3"),
        @Hl7MapByPartType(name="assignedOrganization", type="POME_MT010040CA.Organization4"),
        @Hl7MapByPartType(name="representedOrganization", type="COCT_MT090102CA.Organization"),
        @Hl7MapByPartType(name="representedOrganization", type="COCT_MT090108CA.Organization"),
        @Hl7MapByPartType(name="representedOrganization", type="PORR_MT050016CA.Organization4")})
    public String getAssignedOrganizationName() {
        return this.assignedOrganizationName.getValue();
    }
    public void setAssignedOrganizationName(String assignedOrganizationName) {
        this.assignedOrganizationName.setValue(assignedOrganizationName);
    }


    /**
     * <p>HealthcareWorkerIdentifier</p>
     * 
     * <p>A: Healthcare Worker Identifier</p>
     * 
     * <p>A:Healthcare Worker Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>HealthcareWorkerType</p>
     * 
     * <p>B: Healthcare Worker Type</p>
     */
    @Hl7XmlMapping({"code"})
    public HealthcareProviderRoleType getCode() {
        return (HealthcareProviderRoleType) this.code.getValue();
    }
    public void setCode(HealthcareProviderRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>HealthcareWorkerPhoneAndEmails</p>
     * 
     * <p>E: Healthcare Worker Phone and Emails</p>
     */
    @Hl7XmlMapping({"telecom"})
    public Set<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawSet();
    }


    /**
     * <p>HealthcareWorkerName</p>
     * 
     * <p>C: Healthcare Worker Name</p>
     * 
     * <p>B: Healthcare Worker Name</p>
     */
    @Hl7XmlMapping({"assignedPerson/name"})
    public PersonName getAssignedPersonName() {
        return this.assignedPersonName.getValue();
    }
    public void setAssignedPersonName(PersonName assignedPersonName) {
        this.assignedPersonName.setValue(assignedPersonName);
    }


    /**
     * <p>LicenseNumber</p>
     * 
     * <p>C: License Number</p>
     * 
     * <p>D: License Number</p>
     */
    @Hl7XmlMapping({"assignedPerson/asHealthCareProvider/id"})
    public Identifier getAssignedPersonAsHealthCareProviderId() {
        return this.assignedPersonAsHealthCareProviderId.getValue();
    }
    public void setAssignedPersonAsHealthCareProviderId(Identifier assignedPersonAsHealthCareProviderId) {
        this.assignedPersonAsHealthCareProviderId.setValue(assignedPersonAsHealthCareProviderId);
    }


    /**
     * <p>OrganizationIdentifier</p>
     * 
     * <p>F: Organization identifier</p>
     * 
     * <p>D: Organization identifier</p>
     */
    @Hl7XmlMapping({"representedOrganization/id"})
    public Identifier getRepresentedOrganizationId() {
        return this.representedOrganizationId.getValue();
    }
    public void setRepresentedOrganizationId(Identifier representedOrganizationId) {
        this.representedOrganizationId.setValue(representedOrganizationId);
    }


    /**
     * <p>OrganizationType</p>
     * 
     * <p>G: Organization Type</p>
     */
    @Hl7XmlMapping({"representedOrganization/assignedOrganization/code"})
    public HealthcareOrganizationRoleType getRepresentedOrganizationAssignedOrganizationCode() {
        return (HealthcareOrganizationRoleType) this.representedOrganizationAssignedOrganizationCode.getValue();
    }
    public void setRepresentedOrganizationAssignedOrganizationCode(HealthcareOrganizationRoleType representedOrganizationAssignedOrganizationCode) {
        this.representedOrganizationAssignedOrganizationCode.setValue(representedOrganizationAssignedOrganizationCode);
    }


    /**
     * <p>OrganizationPhoneAndEmails</p>
     * 
     * <p>I: Organization Phone and Emails</p>
     */
    @Hl7XmlMapping({"representedOrganization/assignedOrganization/telecom"})
    public Set<TelecommunicationAddress> getRepresentedOrganizationAssignedOrganizationTelecom() {
        return this.representedOrganizationAssignedOrganizationTelecom.rawSet();
    }

}
