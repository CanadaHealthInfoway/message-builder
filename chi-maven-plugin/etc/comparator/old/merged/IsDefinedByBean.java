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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.HealthcareOrganizationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;



@Hl7PartTypeMapping({"COCT_MT260010CA.Definition","COCT_MT260020CA.Definition","COCT_MT260030CA.Definition"})
public class IsDefinedByBean extends MessagePartBean {

    private II issueMonographId = new IIImpl();
    private ED<EncapsulatedData> issueDescription = new EDImpl<EncapsulatedData>();
    private Component_1Bean detectedIssueDefinitionComponent;
    private TS issueMonographEffectiveDate = new TSImpl();
    private II organizationIdentifier = new IIImpl();
    private ST organizationName = new STImpl();
    private CV<HealthcareOrganizationRoleType> organizationType = new CVImpl<HealthcareOrganizationRoleType>();
    private SET<TEL, TelecommunicationAddress> organizationPhoneAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);

    @Hl7XmlMapping({"detectedIssueDefinition/id"})
    public Identifier getIssueMonographId() {
        return this.issueMonographId.getValue();
    }
    public void setIssueMonographId(Identifier issueMonographId) {
        this.issueMonographId.setValue(issueMonographId);
    }

    @Hl7XmlMapping({"detectedIssueDefinition/text"})
    public EncapsulatedData getIssueDescription() {
        return this.issueDescription.getValue();
    }
    public void setIssueDescription(EncapsulatedData issueDescription) {
        this.issueDescription.setValue(issueDescription);
    }

    @Hl7XmlMapping({"detectedIssueDefinition/component"})
    public Component_1Bean getDetectedIssueDefinitionComponent() {
        return this.detectedIssueDefinitionComponent;
    }
    public void setDetectedIssueDefinitionComponent(Component_1Bean detectedIssueDefinitionComponent) {
        this.detectedIssueDefinitionComponent = detectedIssueDefinitionComponent;
    }

    @Hl7XmlMapping({"detectedIssueDefinition/author/time"})
    public Date getIssueMonographEffectiveDate() {
        return this.issueMonographEffectiveDate.getValue();
    }
    public void setIssueMonographEffectiveDate(Date issueMonographEffectiveDate) {
        this.issueMonographEffectiveDate.setValue(issueMonographEffectiveDate);
    }

    @Hl7XmlMapping({"detectedIssueDefinition/author/assignedEntity/assignedOrganization/id"})
    public Identifier getOrganizationIdentifier() {
        return this.organizationIdentifier.getValue();
    }
    public void setOrganizationIdentifier(Identifier organizationIdentifier) {
        this.organizationIdentifier.setValue(organizationIdentifier);
    }

    @Hl7XmlMapping({"detectedIssueDefinition/author/assignedEntity/assignedOrganization/name"})
    public java.lang.String getOrganizationName() {
        return this.organizationName.getValue();
    }
    public void setOrganizationName(java.lang.String organizationName) {
        this.organizationName.setValue(organizationName);
    }

    @Hl7XmlMapping({"detectedIssueDefinition/author/assignedEntity/assignedOrganization/assignedOrganization/code"})
    public HealthcareOrganizationRoleType getOrganizationType() {
        return this.organizationType.getValue();
    }
    public void setOrganizationType(HealthcareOrganizationRoleType organizationType) {
        this.organizationType.setValue(organizationType);
    }

    @Hl7XmlMapping({"detectedIssueDefinition/author/assignedEntity/assignedOrganization/assignedOrganization/telecom"})
    public Set<TelecommunicationAddress> getOrganizationPhoneAndEmails() {
        return this.organizationPhoneAndEmails.rawSet();
    }

}