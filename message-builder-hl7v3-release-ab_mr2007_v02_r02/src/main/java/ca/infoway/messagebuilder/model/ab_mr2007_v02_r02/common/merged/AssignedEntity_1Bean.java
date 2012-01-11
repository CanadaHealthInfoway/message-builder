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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.EntityClass;
import ca.infoway.messagebuilder.domainvalue.EntityDeterminer;
import ca.infoway.messagebuilder.domainvalue.HealthcareOrganizationRoleType;
import ca.infoway.messagebuilder.domainvalue.RoleClass;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
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
 * 
 * <p>COCT_MT090508CA.AssignedEntity: Healthcare Organization</p>
 * 
 * <p><p>The organization under whose authority the associated 
 * (linked by a participation) action is performed</p></p>
 * 
 * <p><p>Critical to tracking responsibility and performing 
 * follow-up.</p></p>
 * 
 * <p><p>All attributes other than the various identifiers are 
 * expected to be retrieved from the provider registry.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT090102CA.AssignedEntity","COCT_MT090508CA.AssignedEntity","COCT_MT260010CA.AssignedEntity","COCT_MT260020CA.AssignedEntity","COCT_MT260030CA.AssignedEntity"})
@Hl7RootType
public class AssignedEntity_1Bean extends MessagePartBean implements EntererChoice, ActingPerson, ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt911108ca.ActingPerson, ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.Recipient, AuthorPerson {

    private static final long serialVersionUID = 20111208L;
    private ST representedOrganizationName = new STImpl();
    private II id = new IIImpl();
    private CS assignedPersonClassCode = new CSImpl();
    private CS assignedPersonDeterminerCode = new CSImpl();
    private PN assignedPersonName = new PNImpl();
    private CS assignedPersonAsHealthCareProviderClassCode = new CSImpl();
    private II assignedPersonAsHealthCareProviderId = new IIImpl();
    private CS representedOrganizationClassCode = new CSImpl();
    private CS representedOrganizationDeterminerCode = new CSImpl();
    private II representedOrganizationId = new IIImpl();
    private CV representedOrganizationAssignedOrganizationCode = new CVImpl();
    private SET<TEL, TelecommunicationAddress> representedOrganizationAssignedOrganizationTelecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);


    /**
     * <p>E: Organization Name</p>
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
     * 
     * <p>G: Organization Name</p>
     * 
     * <p><p>Identifies the name of the organization</p></p>
     * 
     * <p><p>Allows for human recognition of the organization as 
     * well as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"assignedOrganization/name","representedOrganization/name"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="assignedOrganization", type="COCT_MT260010CA.Organization"),
        @Hl7MapByPartType(name="assignedOrganization", type="COCT_MT260020CA.Organization"),
        @Hl7MapByPartType(name="assignedOrganization", type="COCT_MT260030CA.Organization"),
        @Hl7MapByPartType(name="representedOrganization", type="COCT_MT090102CA.Organization"),
        @Hl7MapByPartType(name="representedOrganization", type="COCT_MT090508CA.Organization")})
    public String getRepresentedOrganizationName() {
        return this.representedOrganizationName.getValue();
    }
    public void setRepresentedOrganizationName(String representedOrganizationName) {
        this.representedOrganizationName.setValue(representedOrganizationName);
    }


    /**
     * <p>HealthcareWorkerIdentifier</p>
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
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    @Hl7XmlMapping({"assignedPerson/classCode"})
    public EntityClass getAssignedPersonClassCode() {
        return (EntityClass) this.assignedPersonClassCode.getValue();
    }
    public void setAssignedPersonClassCode(EntityClass assignedPersonClassCode) {
        this.assignedPersonClassCode.setValue(assignedPersonClassCode);
    }


    @Hl7XmlMapping({"assignedPerson/determinerCode"})
    public EntityDeterminer getAssignedPersonDeterminerCode() {
        return (EntityDeterminer) this.assignedPersonDeterminerCode.getValue();
    }
    public void setAssignedPersonDeterminerCode(EntityDeterminer assignedPersonDeterminerCode) {
        this.assignedPersonDeterminerCode.setValue(assignedPersonDeterminerCode);
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
     */
    @Hl7XmlMapping({"assignedPerson/name"})
    public PersonName getAssignedPersonName() {
        return this.assignedPersonName.getValue();
    }
    public void setAssignedPersonName(PersonName assignedPersonName) {
        this.assignedPersonName.setValue(assignedPersonName);
    }


    @Hl7XmlMapping({"assignedPerson/asHealthCareProvider/classCode"})
    public RoleClass getAssignedPersonAsHealthCareProviderClassCode() {
        return (RoleClass) this.assignedPersonAsHealthCareProviderClassCode.getValue();
    }
    public void setAssignedPersonAsHealthCareProviderClassCode(RoleClass assignedPersonAsHealthCareProviderClassCode) {
        this.assignedPersonAsHealthCareProviderClassCode.setValue(assignedPersonAsHealthCareProviderClassCode);
    }


    /**
     * <p>LicenseNumber</p>
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
    public Identifier getAssignedPersonAsHealthCareProviderId() {
        return this.assignedPersonAsHealthCareProviderId.getValue();
    }
    public void setAssignedPersonAsHealthCareProviderId(Identifier assignedPersonAsHealthCareProviderId) {
        this.assignedPersonAsHealthCareProviderId.setValue(assignedPersonAsHealthCareProviderId);
    }


    @Hl7XmlMapping({"representedOrganization/classCode"})
    public EntityClass getRepresentedOrganizationClassCode() {
        return (EntityClass) this.representedOrganizationClassCode.getValue();
    }
    public void setRepresentedOrganizationClassCode(EntityClass representedOrganizationClassCode) {
        this.representedOrganizationClassCode.setValue(representedOrganizationClassCode);
    }


    @Hl7XmlMapping({"representedOrganization/determinerCode"})
    public EntityDeterminer getRepresentedOrganizationDeterminerCode() {
        return (EntityDeterminer) this.representedOrganizationDeterminerCode.getValue();
    }
    public void setRepresentedOrganizationDeterminerCode(EntityDeterminer representedOrganizationDeterminerCode) {
        this.representedOrganizationDeterminerCode.setValue(representedOrganizationDeterminerCode);
    }


    /**
     * <p>OrganizationIdentifier</p>
     * 
     * <p>E: Organization identifier</p>
     * 
     * <p><p>A unique identifier for the organization</p></p>
     * 
     * <p><p>Allows the organization to be referenced when 
     * determining privileges and for drill-downs to retrieve 
     * additional information. Because of its importance, the 
     * attribute is mandatory.</p></p>
     * 
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
    public Identifier getRepresentedOrganizationId() {
        return this.representedOrganizationId.getValue();
    }
    public void setRepresentedOrganizationId(Identifier representedOrganizationId) {
        this.representedOrganizationId.setValue(representedOrganizationId);
    }


    /**
     * <p>OrganizationType</p>
     * 
     * <p>F: Organization Type</p>
     * 
     * <p><p>Identifies the type of organization on whose behalf 
     * the action was taken. E.g. Pharmacy, Clinic, Hospital, 
     * etc.</p></p>
     * 
     * <p><p>Provides context to the action and is therefore 
     * mandatory.</p></p>
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
     * <p>H: Organization Phone and Emails</p>
     * 
     * <p><p>Identifies contact information for the responsible 
     * organization.</p></p>
     * 
     * <p><p>This is the most commonly used contact information and 
     * is returned to avoid unnecessary queries against the client 
     * registry.</p></p>
     */
    @Hl7XmlMapping({"representedOrganization/assignedOrganization/telecom"})
    public Set<TelecommunicationAddress> getRepresentedOrganizationAssignedOrganizationTelecom() {
        return this.representedOrganizationAssignedOrganizationTelecom.rawSet();
    }

}
