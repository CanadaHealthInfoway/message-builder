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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>REPC_MT210003CA.AssignedEntity: Provider</p>
 * 
 * <p><p>Player association must be present if and only if id 
 * is present</p></p>
 * 
 * <p><p>Identifies the service provider or type of service 
 * provider who is being requested to deliver services to the 
 * patient.</p></p>
 * 
 * <p><p>Represents a key piece of information about the 
 * referral. Included because the referral may be routed to a 
 * different person than that intended to actually deliver the 
 * service.</p></p>
 * 
 * <p>POIZ_MT030060CA.AssignedEntity: Healthcare Worker</p>
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
 * <p>POIZ_MT030050CA.AssignedEntity: Healthcare Worker</p>
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
 * <p>REPC_MT210002CA.AssignedEntity: Provider</p>
 * 
 * <p><p>Player association must be present if and only if id 
 * is present</p></p>
 * 
 * <p><p>Identifies the service provider or type of service 
 * provider who is being requested to deliver services to the 
 * patient.</p></p>
 * 
 * <p><p>Represents a key piece of information about the 
 * referral. Included because the referral may be routed to a 
 * different person than that intended to actually deliver the 
 * service.</p></p>
 * 
 * <p>POIZ_MT060150CA.AssignedEntity: Healthcare Worker</p>
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
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.AssignedEntity","POIZ_MT030060CA.AssignedEntity","POIZ_MT060150CA.AssignedEntity","REPC_MT210001CA.AssignedEntity","REPC_MT210002CA.AssignedEntity","REPC_MT210003CA.AssignedEntity"})
public class HealthcareWorkerBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private PN providerName = new PNImpl();
    private SET<TEL, TelecommunicationAddress> healthcareWorkerPhoneAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private ActingPersonBean assignedPerson;
    private II organizationIdentifier = new IIImpl();
    private ST organizationName = new STImpl();
    private CV organizationType = new CVImpl();
    private SET<TEL, TelecommunicationAddress> organizationPhoneAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);


    /**
     * <p>A:Healthcare Worker Identifier</p>
     * 
     * <p><p>Unique identifier the person involved in the 
     * action.</p></p>
     * 
     * <p><p>Allows unique identification of the person which can 
     * be critical for authentication, permissions, drill-down and 
     * traceability. However the ID may not always be known and is 
     * therefore is populated.</p></p>
     * 
     * <p>F: Provider Id</p>
     * 
     * <p><p>A unique provider identifier such as the MINC #; (a 
     * unique lifetime identifier for physicians in Canada). Other 
     * health care professions such as nursing and dietitians have 
     * similar identifiers. For those providers (such as family 
     * members, friends, neighbors and others who are part of the 
     * patient's informal support network will not have 
     * identifiers) the system will assign identifiers for the 
     * purpose of linking information within the message.</p></p>
     * 
     * <p><p>For non-professional providers and others who do not 
     * have unique provider numbers, applications must create 
     * 'internal' identifiers to allow referencing of the provider 
     * within the message.</p></p>
     * 
     * <p><p>An identifier is the best way of kinking a provider to 
     * information in a provider registry, and therefore will be 
     * required in the absence of a provider name.</p></p>
     * 
     * <p>F: Provider Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>G: Provider Type</p>
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
     * 
     * <p>G: Provider Type</p>
     * 
     * <p><p>Indicates the medical discipline of the provider.</p></p>
     * 
     * <p><p>Provides important context to understanding 
     * information recorded by a provider and work intended to be 
     * performed by the provider.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public HealthcareProviderRoleType getCode() {
        return (HealthcareProviderRoleType) this.code.getValue();
    }
    public void setCode(HealthcareProviderRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>ProviderName</p>
     * 
     * <p>C: Provider Name</p>
     * 
     * <p><p>The label by which a provider is known and 
     * communicated with.</p></p>
     * 
     * <p><p>Common way to identify and communicate with a service 
     * provider in a &quot;human readable&quot; and understood 
     * format.</p></p>
     * 
     * <p>C: Provider Name</p>
     */
    @Hl7XmlMapping({"assignedProvider/name"})
    public PersonName getProviderName() {
        return this.providerName.getValue();
    }
    public void setProviderName(PersonName providerName) {
        this.providerName.setValue(providerName);
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


    @Hl7XmlMapping({"assignedPerson"})
    public ActingPersonBean getAssignedPerson() {
        return this.assignedPerson;
    }
    public void setAssignedPerson(ActingPersonBean assignedPerson) {
        this.assignedPerson = assignedPerson;
    }


    /**
     * <p>OrganizationIdentifier</p>
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
     * <p>OrganizationName</p>
     * 
     * <p>H: Organization Name</p>
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

}
