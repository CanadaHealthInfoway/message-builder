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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Provider</p>
 * 
 * <p>REPC_MT210002NB.AssignedEntity: Provider</p>
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
 * <p>REPC_MT210003NB.AssignedEntity: Provider</p>
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
 * <p>REPC_MT210001NB.AssignedEntity: Provider</p>
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
 */
@Hl7PartTypeMapping({"REPC_MT210001NB.AssignedEntity","REPC_MT210002NB.AssignedEntity","REPC_MT210003NB.AssignedEntity"})
public class ProviderBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private PN assignedProviderName = new PNImpl();


    /**
     * <p>Business Name: ProviderId</p>
     * 
     * <p>Un-merged Business Name: ProviderId</p>
     * 
     * <p>Relationship: REPC_MT210002NB.AssignedEntity.id</p>
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
     * <p>Relationship: REPC_MT210003NB.AssignedEntity.id</p>
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
     * <p>Relationship: REPC_MT210001NB.AssignedEntity.id</p>
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
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: ProviderId</p>
     * 
     * <p>Un-merged Business Name: ProviderId</p>
     * 
     * <p>Relationship: REPC_MT210002NB.AssignedEntity.id</p>
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
     * <p>Relationship: REPC_MT210003NB.AssignedEntity.id</p>
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
     * <p>Relationship: REPC_MT210001NB.AssignedEntity.id</p>
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
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: ProviderType</p>
     * 
     * <p>Un-merged Business Name: ProviderType</p>
     * 
     * <p>Relationship: REPC_MT210002NB.AssignedEntity.code</p>
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
     * <p>Relationship: REPC_MT210003NB.AssignedEntity.code</p>
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
     * <p>Relationship: REPC_MT210001NB.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides important context to understanding information 
     * recorded by a provider and work intended to be performed by 
     * the provider.</p>
     * 
     * <p>Indicates the medical discipline of the provider.</p>
     */
    @Hl7XmlMapping({"code"})
    public HealthcareProviderRoleType getCode() {
        return (HealthcareProviderRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: ProviderType</p>
     * 
     * <p>Un-merged Business Name: ProviderType</p>
     * 
     * <p>Relationship: REPC_MT210002NB.AssignedEntity.code</p>
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
     * <p>Relationship: REPC_MT210003NB.AssignedEntity.code</p>
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
     * <p>Relationship: REPC_MT210001NB.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides important context to understanding information 
     * recorded by a provider and work intended to be performed by 
     * the provider.</p>
     * 
     * <p>Indicates the medical discipline of the provider.</p>
     */
    public void setCode(HealthcareProviderRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: ProviderName</p>
     * 
     * <p>Un-merged Business Name: ProviderName</p>
     * 
     * <p>Relationship: REPC_MT210002NB.Provider.name</p>
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
     * <p>Relationship: REPC_MT210003NB.Provider.name</p>
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
     * <p>Relationship: REPC_MT210001NB.Provider.name</p>
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
     * <p>Relationship: REPC_MT210002NB.Provider.name</p>
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
     * <p>Relationship: REPC_MT210003NB.Provider.name</p>
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
     * <p>Relationship: REPC_MT210001NB.Provider.name</p>
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

}
