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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT260010CA.Definition","COCT_MT260020CA.Definition","COCT_MT260030CA.Definition"})
public class IsDefinedByBean extends MessagePartBean {

    private II issueMonographId = new IIImpl();
    private ED<EncapsulatedData> issueDescription = new EDImpl<EncapsulatedData>();
    private Component_1Bean detectedIssueDefinitionComponent;
    private TS issueMonographEffectiveDate = new TSImpl();
    private ResponsibleOrganizationBean detectedIssueDefinitionAuthorAssignedEntityAssignedOrganization = new ResponsibleOrganizationBean();

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

    @Hl7XmlMapping({"detectedIssueDefinition/author/assignedEntity/assignedOrganization"})
    public ResponsibleOrganizationBean getDetectedIssueDefinitionAuthorAssignedEntityAssignedOrganization() {
        return this.detectedIssueDefinitionAuthorAssignedEntityAssignedOrganization;
    }
    public void setDetectedIssueDefinitionAuthorAssignedEntityAssignedOrganization(ResponsibleOrganizationBean detectedIssueDefinitionAuthorAssignedEntityAssignedOrganization) {
        this.detectedIssueDefinitionAuthorAssignedEntityAssignedOrganization = detectedIssueDefinitionAuthorAssignedEntityAssignedOrganization;
    }

}
