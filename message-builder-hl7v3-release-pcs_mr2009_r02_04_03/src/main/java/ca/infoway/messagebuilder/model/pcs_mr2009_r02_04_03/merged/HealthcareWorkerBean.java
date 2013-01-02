/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged;

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
import java.util.Set;



/**
 * <p>REPC_MT210003CA.AssignedEntity: Provider</p>
 * 
 * <p>Player association must be present if and only if id is 
 * present</p>
 * 
 * <p>Represents a key piece of information about the referral. 
 * Included because the referral may be routed to a different 
 * person than that intended to actually deliver the 
 * service.</p>
 * 
 * <p>Identifies the service provider or type of service 
 * provider who is being requested to deliver services to the 
 * patient.</p>
 * 
 * <p>POIZ_MT030060CA.AssignedEntity: Healthcare Worker</p>
 * 
 * <p>Critical to tracking responsibility and performing 
 * follow-up. The CMET supports both licensed providers as well 
 * as non-licensed providers such as technicians, 
 * receptionists, etc.</p>
 * 
 * <p>All attributes other than the various identifiers are 
 * expected to be retrieved from the provider registry.</p>
 * 
 * <p>The person organization assigned to carry out the 
 * associated (linked by a participation) action and/or the 
 * organization under whose authority they are acting.</p>
 * 
 * <p>POIZ_MT030050CA.AssignedEntity: Healthcare Worker</p>
 * 
 * <p>Critical to tracking responsibility and performing 
 * follow-up. The CMET supports both licensed providers as well 
 * as non-licensed providers such as technicians, 
 * receptionists, etc.</p>
 * 
 * <p>All attributes other than the various identifiers are 
 * expected to be retrieved from the provider registry.</p>
 * 
 * <p>The person organization assigned to carry out the 
 * associated (linked by a participation) action and/or the 
 * organization under whose authority they are acting.</p>
 * 
 * <p>REPC_MT210002CA.AssignedEntity: Provider</p>
 * 
 * <p>Player association must be present if and only if id is 
 * present</p>
 * 
 * <p>Represents a key piece of information about the referral. 
 * Included because the referral may be routed to a different 
 * person than that intended to actually deliver the 
 * service.</p>
 * 
 * <p>Identifies the service provider or type of service 
 * provider who is being requested to deliver services to the 
 * patient.</p>
 * 
 * <p>POIZ_MT060150CA.AssignedEntity: Healthcare Worker</p>
 * 
 * <p>Critical to tracking responsibility and performing 
 * follow-up. The CMET supports both licensed providers as well 
 * as non-licensed providers such as technicians, 
 * receptionists, etc.</p>
 * 
 * <p>All attributes other than the various identifiers are 
 * expected to be retrieved from the provider registry.</p>
 * 
 * <p>The person organization assigned to carry out the 
 * associated (linked by a participation) action and/or the 
 * organization under whose authority they are acting.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.AssignedEntity","POIZ_MT030060CA.AssignedEntity","POIZ_MT060150CA.AssignedEntity","REPC_MT210001CA.AssignedEntity","REPC_MT210002CA.AssignedEntity","REPC_MT210003CA.AssignedEntity"})
public class HealthcareWorkerBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private PN assignedProviderName = new PNImpl();
    private SET<TEL, TelecommunicationAddress> telecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private ActingPersonBean assignedPerson;
    private II representedOrganizationId = new IIImpl();
    private ST representedOrganizationName = new STImpl();
    private CV representedOrganizationAssignedOrganizationCode = new CVImpl();
    private SET<TEL, TelecommunicationAddress> representedOrganizationAssignedOrganizationTelecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);


    /**
     * <p>Un-merged Business Name: HealthcareWorkerIdentifier</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Allows unique identification of the person which can be 
     * critical for authentication, permissions, drill-down and 
     * traceability. However the ID may not always be known and is 
     * therefore is populated.</p>
     * 
     * <p>Unique identifier the person involved in the action.</p>
     * 
     * <p>Un-merged Business Name: HealthcareWorkerIdentifier</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Allows unique identification of the person which can be 
     * critical for authentication, permissions, drill-down and 
     * traceability. However the ID may not always be known and is 
     * therefore is populated.</p>
     * 
     * <p>Unique identifier the person involved in the action.</p>
     * 
     * <p>Un-merged Business Name: ProviderId</p>
     * 
     * <p>Relationship: REPC_MT210001CA.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: ProviderId</p>
     * 
     * <p>Relationship: REPC_MT210003CA.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>For non-professional providers and others who do not have 
     * unique provider numbers, applications must create 'internal' 
     * identifiers to allow referencing of the provider within the 
     * message.</p>
     * 
     * <p>An identifier is the best way of kinking a provider to 
     * information in a provider registry, and therefore will be 
     * required in the absence of a provider name.</p>
     * 
     * <p>A unique provider identifier such as the MINC #; (a 
     * unique lifetime identifier for physicians in Canada). Other 
     * health care professions such as nursing and dietitians have 
     * similar identifiers. For those providers (such as family 
     * members, friends, neighbors and others who are part of the 
     * patient's informal support network will not have 
     * identifiers) the system will assign identifiers for the 
     * purpose of linking information within the message.</p>
     * 
     * <p>Un-merged Business Name: ProviderId</p>
     * 
     * <p>Relationship: REPC_MT210002CA.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>For non-professional providers and others who do not have 
     * unique provider numbers, applications must create 'internal' 
     * identifiers to allow referencing of the provider within the 
     * message.</p>
     * 
     * <p>An identifier is the best way of kinking a provider to 
     * information in a provider registry, and therefore will be 
     * required in the absence of a provider name.</p>
     * 
     * <p>A unique provider identifier such as the MINC #; (a 
     * unique lifetime identifier for physicians in Canada). Other 
     * health care professions such as nursing and dietitians have 
     * similar identifiers. For those providers (such as family 
     * members, friends, neighbors and others who are part of the 
     * patient's informal support network will not have 
     * identifiers) the system will assign identifiers for the 
     * purpose of linking information within the message.</p>
     * 
     * <p>Un-merged Business Name: HealthcareWorkerIdentifier</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Allows unique identification of the person which can be 
     * critical for authentication, permissions, drill-down and 
     * traceability. However the ID may not always be known and is 
     * therefore is populated.</p>
     * 
     * <p>Unique identifier the person involved in the action.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Un-merged Business Name: HealthcareWorkerIdentifier</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Allows unique identification of the person which can be 
     * critical for authentication, permissions, drill-down and 
     * traceability. However the ID may not always be known and is 
     * therefore is populated.</p>
     * 
     * <p>Unique identifier the person involved in the action.</p>
     * 
     * <p>Un-merged Business Name: HealthcareWorkerIdentifier</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Allows unique identification of the person which can be 
     * critical for authentication, permissions, drill-down and 
     * traceability. However the ID may not always be known and is 
     * therefore is populated.</p>
     * 
     * <p>Unique identifier the person involved in the action.</p>
     * 
     * <p>Un-merged Business Name: ProviderId</p>
     * 
     * <p>Relationship: REPC_MT210001CA.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: ProviderId</p>
     * 
     * <p>Relationship: REPC_MT210003CA.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>For non-professional providers and others who do not have 
     * unique provider numbers, applications must create 'internal' 
     * identifiers to allow referencing of the provider within the 
     * message.</p>
     * 
     * <p>An identifier is the best way of kinking a provider to 
     * information in a provider registry, and therefore will be 
     * required in the absence of a provider name.</p>
     * 
     * <p>A unique provider identifier such as the MINC #; (a 
     * unique lifetime identifier for physicians in Canada). Other 
     * health care professions such as nursing and dietitians have 
     * similar identifiers. For those providers (such as family 
     * members, friends, neighbors and others who are part of the 
     * patient's informal support network will not have 
     * identifiers) the system will assign identifiers for the 
     * purpose of linking information within the message.</p>
     * 
     * <p>Un-merged Business Name: ProviderId</p>
     * 
     * <p>Relationship: REPC_MT210002CA.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>For non-professional providers and others who do not have 
     * unique provider numbers, applications must create 'internal' 
     * identifiers to allow referencing of the provider within the 
     * message.</p>
     * 
     * <p>An identifier is the best way of kinking a provider to 
     * information in a provider registry, and therefore will be 
     * required in the absence of a provider name.</p>
     * 
     * <p>A unique provider identifier such as the MINC #; (a 
     * unique lifetime identifier for physicians in Canada). Other 
     * health care professions such as nursing and dietitians have 
     * similar identifiers. For those providers (such as family 
     * members, friends, neighbors and others who are part of the 
     * patient's informal support network will not have 
     * identifiers) the system will assign identifiers for the 
     * purpose of linking information within the message.</p>
     * 
     * <p>Un-merged Business Name: HealthcareWorkerIdentifier</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Allows unique identification of the person which can be 
     * critical for authentication, permissions, drill-down and 
     * traceability. However the ID may not always be known and is 
     * therefore is populated.</p>
     * 
     * <p>Unique identifier the person involved in the action.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Un-merged Business Name: HealthcareWorkerType</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context around the actions of the participant 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the &quot;kind&quot; of healthcare participant, 
     * such as &quot;physician&quot;, &quot;dentist&quot;, 
     * &quot;lab technician&quot;, &quot;receptionist&quot;, 
     * etc.</p>
     * 
     * <p>Un-merged Business Name: HealthcareWorkerType</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context around the actions of the participant 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the &quot;kind&quot; of healthcare participant, 
     * such as &quot;physician&quot;, &quot;dentist&quot;, 
     * &quot;lab technician&quot;, &quot;receptionist&quot;, 
     * etc.</p>
     * 
     * <p>Un-merged Business Name: ProviderType</p>
     * 
     * <p>Relationship: REPC_MT210001CA.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: ProviderType</p>
     * 
     * <p>Relationship: REPC_MT210003CA.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides important context to understanding information 
     * recorded by a provider and work intended to be performed by 
     * the provider.</p>
     * 
     * <p>Indicates the medical discipline of the provider.</p>
     * 
     * <p>Un-merged Business Name: ProviderType</p>
     * 
     * <p>Relationship: REPC_MT210002CA.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides important context to understanding information 
     * recorded by a provider and work intended to be performed by 
     * the provider.</p>
     * 
     * <p>Indicates the medical discipline of the provider.</p>
     * 
     * <p>Un-merged Business Name: HealthcareWorkerType</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context around the actions of the participant 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the &quot;kind&quot; of healthcare participant, 
     * such as &quot;physician&quot;, &quot;dentist&quot;, 
     * &quot;lab technician&quot;, &quot;receptionist&quot;, 
     * etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public HealthcareProviderRoleType getCode() {
        return (HealthcareProviderRoleType) this.code.getValue();
    }

    /**
     * <p>Un-merged Business Name: HealthcareWorkerType</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context around the actions of the participant 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the &quot;kind&quot; of healthcare participant, 
     * such as &quot;physician&quot;, &quot;dentist&quot;, 
     * &quot;lab technician&quot;, &quot;receptionist&quot;, 
     * etc.</p>
     * 
     * <p>Un-merged Business Name: HealthcareWorkerType</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context around the actions of the participant 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the &quot;kind&quot; of healthcare participant, 
     * such as &quot;physician&quot;, &quot;dentist&quot;, 
     * &quot;lab technician&quot;, &quot;receptionist&quot;, 
     * etc.</p>
     * 
     * <p>Un-merged Business Name: ProviderType</p>
     * 
     * <p>Relationship: REPC_MT210001CA.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: ProviderType</p>
     * 
     * <p>Relationship: REPC_MT210003CA.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides important context to understanding information 
     * recorded by a provider and work intended to be performed by 
     * the provider.</p>
     * 
     * <p>Indicates the medical discipline of the provider.</p>
     * 
     * <p>Un-merged Business Name: ProviderType</p>
     * 
     * <p>Relationship: REPC_MT210002CA.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides important context to understanding information 
     * recorded by a provider and work intended to be performed by 
     * the provider.</p>
     * 
     * <p>Indicates the medical discipline of the provider.</p>
     * 
     * <p>Un-merged Business Name: HealthcareWorkerType</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context around the actions of the participant 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the &quot;kind&quot; of healthcare participant, 
     * such as &quot;physician&quot;, &quot;dentist&quot;, 
     * &quot;lab technician&quot;, &quot;receptionist&quot;, 
     * etc.</p>
     */
    public void setCode(HealthcareProviderRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: ProviderName</p>
     * 
     * <p>Un-merged Business Name: ProviderName</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Provider.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ProviderName</p>
     * 
     * <p>Relationship: REPC_MT210003CA.Provider.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Common way to identify and communicate with a service 
     * provider in a &quot;human readable&quot; and understood 
     * format.</p>
     * 
     * <p>The label by which a provider is known and communicated 
     * with.</p>
     * 
     * <p>Un-merged Business Name: ProviderName</p>
     * 
     * <p>Relationship: REPC_MT210002CA.Provider.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Common way to identify and communicate with a service 
     * provider in a &quot;human readable&quot; and understood 
     * format.</p>
     * 
     * <p>The label by which a provider is known and communicated 
     * with.</p>
     */
    @Hl7XmlMapping({"assignedProvider/name"})
    public PersonName getAssignedProviderName() {
        return this.assignedProviderName.getValue();
    }

    /**
     * <p>Business Name: ProviderName</p>
     * 
     * <p>Un-merged Business Name: ProviderName</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Provider.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ProviderName</p>
     * 
     * <p>Relationship: REPC_MT210003CA.Provider.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Common way to identify and communicate with a service 
     * provider in a &quot;human readable&quot; and understood 
     * format.</p>
     * 
     * <p>The label by which a provider is known and communicated 
     * with.</p>
     * 
     * <p>Un-merged Business Name: ProviderName</p>
     * 
     * <p>Relationship: REPC_MT210002CA.Provider.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Common way to identify and communicate with a service 
     * provider in a &quot;human readable&quot; and understood 
     * format.</p>
     * 
     * <p>The label by which a provider is known and communicated 
     * with.</p>
     */
    public void setAssignedProviderName(PersonName assignedProviderName) {
        this.assignedProviderName.setValue(assignedProviderName);
    }


    /**
     * <p>Business Name: HealthcareWorkerPhoneAndEmails</p>
     * 
     * <p>Un-merged Business Name: HealthcareWorkerPhoneAndEmails</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.AssignedEntity.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>This is the most commonly used piece of contact 
     * information and is returned here to avoid unnecessary 
     * queries of the provider registry.</p>
     * 
     * <p>Indicates phone and/or e-mail addresses at which the 
     * healthcare worker can be reached.</p>
     * 
     * <p>Un-merged Business Name: HealthcareWorkerPhoneAndEmails</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.AssignedEntity.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>This is the most commonly used piece of contact 
     * information and is returned here to avoid unnecessary 
     * queries of the provider registry.</p>
     * 
     * <p>Indicates phone and/or e-mail addresses at which the 
     * healthcare worker can be reached.</p>
     * 
     * <p>Un-merged Business Name: HealthcareWorkerPhoneAndEmails</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.AssignedEntity.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>This is the most commonly used piece of contact 
     * information and is returned here to avoid unnecessary 
     * queries of the provider registry.</p>
     * 
     * <p>Indicates phone and/or e-mail addresses at which the 
     * healthcare worker can be reached.</p>
     */
    @Hl7XmlMapping({"telecom"})
    public Set<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawSet();
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.AssignedEntity.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.AssignedEntity.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.AssignedEntity.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"assignedPerson"})
    public ActingPersonBean getAssignedPerson() {
        return this.assignedPerson;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.AssignedEntity.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.AssignedEntity.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.AssignedEntity.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAssignedPerson(ActingPersonBean assignedPerson) {
        this.assignedPerson = assignedPerson;
    }


    /**
     * <p>Business Name: OrganizationIdentifier</p>
     * 
     * <p>Un-merged Business Name: OrganizationIdentifier</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>A unique identifier for the organization</p>
     * 
     * <p>Un-merged Business Name: OrganizationIdentifier</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>A unique identifier for the organization</p>
     * 
     * <p>Un-merged Business Name: OrganizationIdentifier</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>A unique identifier for the organization</p>
     */
    @Hl7XmlMapping({"representedOrganization/id"})
    public Identifier getRepresentedOrganizationId() {
        return this.representedOrganizationId.getValue();
    }

    /**
     * <p>Business Name: OrganizationIdentifier</p>
     * 
     * <p>Un-merged Business Name: OrganizationIdentifier</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>A unique identifier for the organization</p>
     * 
     * <p>Un-merged Business Name: OrganizationIdentifier</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>A unique identifier for the organization</p>
     * 
     * <p>Un-merged Business Name: OrganizationIdentifier</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>A unique identifier for the organization</p>
     */
    public void setRepresentedOrganizationId(Identifier representedOrganizationId) {
        this.representedOrganizationId.setValue(representedOrganizationId);
    }


    /**
     * <p>Business Name: OrganizationName</p>
     * 
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     * 
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     * 
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     */
    @Hl7XmlMapping({"representedOrganization/name"})
    public String getRepresentedOrganizationName() {
        return this.representedOrganizationName.getValue();
    }

    /**
     * <p>Business Name: OrganizationName</p>
     * 
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     * 
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     * 
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     */
    public void setRepresentedOrganizationName(String representedOrganizationName) {
        this.representedOrganizationName.setValue(representedOrganizationName);
    }


    /**
     * <p>Business Name: OrganizationType</p>
     * 
     * <p>Un-merged Business Name: OrganizationType</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.AssignedOrganization.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context to the action and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the type of organization on whose behalf the 
     * action was taken. E.g. Pharmacy, Clinic, Hospital, etc.</p>
     * 
     * <p>Un-merged Business Name: OrganizationType</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.AssignedOrganization.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context to the action and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the type of organization on whose behalf the 
     * action was taken. E.g. Pharmacy, Clinic, Hospital, etc.</p>
     * 
     * <p>Un-merged Business Name: OrganizationType</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.AssignedOrganization.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context to the action and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the type of organization on whose behalf the 
     * action was taken. E.g. Pharmacy, Clinic, Hospital, etc.</p>
     */
    @Hl7XmlMapping({"representedOrganization/assignedOrganization/code"})
    public HealthcareOrganizationRoleType getRepresentedOrganizationAssignedOrganizationCode() {
        return (HealthcareOrganizationRoleType) this.representedOrganizationAssignedOrganizationCode.getValue();
    }

    /**
     * <p>Business Name: OrganizationType</p>
     * 
     * <p>Un-merged Business Name: OrganizationType</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.AssignedOrganization.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context to the action and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the type of organization on whose behalf the 
     * action was taken. E.g. Pharmacy, Clinic, Hospital, etc.</p>
     * 
     * <p>Un-merged Business Name: OrganizationType</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.AssignedOrganization.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context to the action and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the type of organization on whose behalf the 
     * action was taken. E.g. Pharmacy, Clinic, Hospital, etc.</p>
     * 
     * <p>Un-merged Business Name: OrganizationType</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.AssignedOrganization.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context to the action and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the type of organization on whose behalf the 
     * action was taken. E.g. Pharmacy, Clinic, Hospital, etc.</p>
     */
    public void setRepresentedOrganizationAssignedOrganizationCode(HealthcareOrganizationRoleType representedOrganizationAssignedOrganizationCode) {
        this.representedOrganizationAssignedOrganizationCode.setValue(representedOrganizationAssignedOrganizationCode);
    }


    /**
     * <p>Business Name: OrganizationPhoneAndEmails</p>
     * 
     * <p>Un-merged Business Name: OrganizationPhoneAndEmails</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.AssignedOrganization.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>This is the most commonly used contact information and is 
     * returned to avoid unnecessary queries against the client 
     * registry.</p>
     * 
     * <p>Identifies contact information for the responsible 
     * organization.</p>
     * 
     * <p>Un-merged Business Name: OrganizationPhoneAndEmails</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.AssignedOrganization.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>This is the most commonly used contact information and is 
     * returned to avoid unnecessary queries against the client 
     * registry.</p>
     * 
     * <p>Identifies contact information for the responsible 
     * organization.</p>
     * 
     * <p>Un-merged Business Name: OrganizationPhoneAndEmails</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.AssignedOrganization.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>This is the most commonly used contact information and is 
     * returned to avoid unnecessary queries against the client 
     * registry.</p>
     * 
     * <p>Identifies contact information for the responsible 
     * organization.</p>
     */
    @Hl7XmlMapping({"representedOrganization/assignedOrganization/telecom"})
    public Set<TelecommunicationAddress> getRepresentedOrganizationAssignedOrganizationTelecom() {
        return this.representedOrganizationAssignedOrganizationTelecom.rawSet();
    }

}
