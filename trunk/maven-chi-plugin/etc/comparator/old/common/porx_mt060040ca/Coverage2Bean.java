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
package ca.infoway.messagebuilder.model.common.porx_mt060040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.HealthcareOrganizationRoleType;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodOrderEvent;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;



/**
 * <p>h:includes 
 * 
 * <p>Indicates any extensions to the patient's insurance 
 * coverage that have been solicited by the prescriber, 
 * including indications of whether the requested extension was 
 * granted. 
 * 
 * <p>An authorization issued by a payor to cover a device not 
 * previously covered by a patient's drug plan. 
 * 
 * <p>Helps streamline communication from prescriber to 
 * pharmacy by informing the pharmacy of whether an extension 
 * has already been requested, and if so, what the status is. 
 */
@Hl7PartTypeMapping({"PORX_MT060040CA.Coverage2"})
public class Coverage2Bean extends MessagePartBean {

    private CS<x_ActMoodOrderEvent> extensionGrantedIndicator = new CSImpl<x_ActMoodOrderEvent>();
    private II coverageExtensionId = new IIImpl();
    private II payorIdentifier = new IIImpl();
    private II organizationIdentifier = new IIImpl();
    private ST organizationName = new STImpl();
    private CV<HealthcareOrganizationRoleType> organizationType = new CVImpl<HealthcareOrganizationRoleType>();
    private SET<TEL, TelecommunicationAddress> organizationPhoneAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);

    @Hl7XmlMapping({"coverage/moodCode"})
    public x_ActMoodOrderEvent getExtensionGrantedIndicator() {
        return this.extensionGrantedIndicator.getValue();
    }
    public void setExtensionGrantedIndicator(x_ActMoodOrderEvent extensionGrantedIndicator) {
        this.extensionGrantedIndicator.setValue(extensionGrantedIndicator);
    }

    @Hl7XmlMapping({"coverage/id"})
    public Identifier getCoverageExtensionId() {
        return this.coverageExtensionId.getValue();
    }
    public void setCoverageExtensionId(Identifier coverageExtensionId) {
        this.coverageExtensionId.setValue(coverageExtensionId);
    }

    @Hl7XmlMapping({"coverage/author/underwriter/id"})
    public Identifier getPayorIdentifier() {
        return this.payorIdentifier.getValue();
    }
    public void setPayorIdentifier(Identifier payorIdentifier) {
        this.payorIdentifier.setValue(payorIdentifier);
    }

    @Hl7XmlMapping({"coverage/author/underwriter/underwritingOrganization/id"})
    public Identifier getOrganizationIdentifier() {
        return this.organizationIdentifier.getValue();
    }
    public void setOrganizationIdentifier(Identifier organizationIdentifier) {
        this.organizationIdentifier.setValue(organizationIdentifier);
    }

    @Hl7XmlMapping({"coverage/author/underwriter/underwritingOrganization/name"})
    public java.lang.String getOrganizationName() {
        return this.organizationName.getValue();
    }
    public void setOrganizationName(java.lang.String organizationName) {
        this.organizationName.setValue(organizationName);
    }

    @Hl7XmlMapping({"coverage/author/underwriter/underwritingOrganization/assignedOrganization/code"})
    public HealthcareOrganizationRoleType getOrganizationType() {
        return this.organizationType.getValue();
    }
    public void setOrganizationType(HealthcareOrganizationRoleType organizationType) {
        this.organizationType.setValue(organizationType);
    }

    @Hl7XmlMapping({"coverage/author/underwriter/underwritingOrganization/assignedOrganization/telecom"})
    public Set<TelecommunicationAddress> getOrganizationPhoneAndEmails() {
        return this.organizationPhoneAndEmails.rawSet();
    }

}
