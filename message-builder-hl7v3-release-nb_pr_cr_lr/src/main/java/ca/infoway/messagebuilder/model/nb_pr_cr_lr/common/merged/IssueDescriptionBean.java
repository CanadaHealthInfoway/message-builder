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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Business Name: IssueDescription</p>
 * 
 * <p>COCT_MT260030NB.DetectedIssueDefinition: Issue 
 * Description</p>
 * 
 * <p>Provides detailed background for providers in evaluating 
 * the issue.</p>
 * 
 * <p>This is the decision support rule that triggered the 
 * issue.</p>
 * 
 * <p>COCT_MT260010NB.DetectedIssueDefinition: Issue 
 * Description</p>
 * 
 * <p>Provides detailed background for providers in evaluating 
 * the issue.</p>
 * 
 * <p>This is the decision support rule that triggered the 
 * issue.</p>
 */
@Hl7PartTypeMapping({"COCT_MT260010NB.DetectedIssueDefinition","COCT_MT260020NB.DetectedIssueDefinition","COCT_MT260030NB.DetectedIssueDefinition"})
public class IssueDescriptionBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private II id = new IIImpl();
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();
    private TS authorTime = new TSImpl();
    private ST authorAssignedEntityAssignedOrganizationName = new STImpl();
    private RecommendedDosageBean componentSubstanceAdministrationEventCriterion;


    /**
     * <p>Business Name: IssueMonographId</p>
     * 
     * <p>Un-merged Business Name: IssueMonographId</p>
     * 
     * <p>Relationship: COCT_MT260030NB.DetectedIssueDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DDIMonograph.DDIMonographId</p>
     * 
     * <p>ZPE.2</p>
     * 
     * <p>MB.05.03C</p>
     * 
     * <p>ZPS.14</p>
     * 
     * <p>ZDU.5.2</p>
     * 
     * <p>A_DetectedMedicationIssue</p>
     * 
     * <p>Monograph Code</p>
     * 
     * <p>Allows applications to match with local Knowledge-bases 
     * and avoid displaying duplicate issues to providers.</p>
     * 
     * <p>Knowledgebase organization specific identifier for the 
     * issue definition.</p>
     * 
     * <p>Un-merged Business Name: IssueMonographId</p>
     * 
     * <p>Relationship: COCT_MT260010NB.DetectedIssueDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DDIMonograph.DDIMonographId</p>
     * 
     * <p>ZPE.2</p>
     * 
     * <p>MB.05.03C</p>
     * 
     * <p>ZPS.14</p>
     * 
     * <p>ZDU.5.2</p>
     * 
     * <p>A_DetectedMedicationIssue</p>
     * 
     * <p>Monograph Code</p>
     * 
     * <p>Allows applications to match with local Knowledge-bases 
     * and avoid displaying duplicate issues to providers.</p>
     * 
     * <p>Knowledgebase organization specific identifier for the 
     * issue definition.</p>
     * 
     * <p>Un-merged Business Name: IssueMonographId</p>
     * 
     * <p>Relationship: COCT_MT260020NB.DetectedIssueDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: IssueMonographId</p>
     * 
     * <p>Un-merged Business Name: IssueMonographId</p>
     * 
     * <p>Relationship: COCT_MT260030NB.DetectedIssueDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DDIMonograph.DDIMonographId</p>
     * 
     * <p>ZPE.2</p>
     * 
     * <p>MB.05.03C</p>
     * 
     * <p>ZPS.14</p>
     * 
     * <p>ZDU.5.2</p>
     * 
     * <p>A_DetectedMedicationIssue</p>
     * 
     * <p>Monograph Code</p>
     * 
     * <p>Allows applications to match with local Knowledge-bases 
     * and avoid displaying duplicate issues to providers.</p>
     * 
     * <p>Knowledgebase organization specific identifier for the 
     * issue definition.</p>
     * 
     * <p>Un-merged Business Name: IssueMonographId</p>
     * 
     * <p>Relationship: COCT_MT260010NB.DetectedIssueDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DDIMonograph.DDIMonographId</p>
     * 
     * <p>ZPE.2</p>
     * 
     * <p>MB.05.03C</p>
     * 
     * <p>ZPS.14</p>
     * 
     * <p>ZDU.5.2</p>
     * 
     * <p>A_DetectedMedicationIssue</p>
     * 
     * <p>Monograph Code</p>
     * 
     * <p>Allows applications to match with local Knowledge-bases 
     * and avoid displaying duplicate issues to providers.</p>
     * 
     * <p>Knowledgebase organization specific identifier for the 
     * issue definition.</p>
     * 
     * <p>Un-merged Business Name: IssueMonographId</p>
     * 
     * <p>Relationship: COCT_MT260020NB.DetectedIssueDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: IssueDescription</p>
     * 
     * <p>Un-merged Business Name: IssueDescription</p>
     * 
     * <p>Relationship: 
     * COCT_MT260030NB.DetectedIssueDefinition.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Monograph URI (Reference)</p>
     * 
     * <p>Monograph description</p>
     * 
     * <p>Provides detailed clinical background on reasons for 
     * issue.</p>
     * 
     * <p>A free form textual description of the issue. This is 
     * usually in the form of a monograph.</p>
     * 
     * <p>Un-merged Business Name: IssueDescription</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010NB.DetectedIssueDefinition.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Monograph URI (Reference)</p>
     * 
     * <p>Monograph description</p>
     * 
     * <p>Provides detailed clinical background on reasons for 
     * issue.</p>
     * 
     * <p>A free form textual description of the issue. This is 
     * usually in the form of a monograph.</p>
     * 
     * <p>Un-merged Business Name: IssueDescription</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020NB.DetectedIssueDefinition.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: IssueDescription</p>
     * 
     * <p>Un-merged Business Name: IssueDescription</p>
     * 
     * <p>Relationship: 
     * COCT_MT260030NB.DetectedIssueDefinition.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Monograph URI (Reference)</p>
     * 
     * <p>Monograph description</p>
     * 
     * <p>Provides detailed clinical background on reasons for 
     * issue.</p>
     * 
     * <p>A free form textual description of the issue. This is 
     * usually in the form of a monograph.</p>
     * 
     * <p>Un-merged Business Name: IssueDescription</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010NB.DetectedIssueDefinition.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Monograph URI (Reference)</p>
     * 
     * <p>Monograph description</p>
     * 
     * <p>Provides detailed clinical background on reasons for 
     * issue.</p>
     * 
     * <p>A free form textual description of the issue. This is 
     * usually in the form of a monograph.</p>
     * 
     * <p>Un-merged Business Name: IssueDescription</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020NB.DetectedIssueDefinition.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: IssueMonographEffectiveDate</p>
     * 
     * <p>Un-merged Business Name: IssueMonographEffectiveDate</p>
     * 
     * <p>Relationship: COCT_MT260030NB.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DDIMonograph.EffectiveDate</p>
     * 
     * <p>A_DetectedMedicationIssue</p>
     * 
     * <p>Allows detailed matching of local knowledgebase record 
     * with that of the central. (The monograph id may remain the 
     * same, but the effective date will always change).</p>
     * 
     * <p>The date and time on which the monograph becomes valid 
     * and applicable.</p>
     * 
     * <p>Un-merged Business Name: IssueMonographEffectiveDate</p>
     * 
     * <p>Relationship: COCT_MT260010NB.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DDIMonograph.EffectiveDate</p>
     * 
     * <p>A_DetectedMedicationIssue</p>
     * 
     * <p>Allows detailed matching of local knowledgebase record 
     * with that of the central. (The monograph id may remain the 
     * same, but the effective date will always change).</p>
     * 
     * <p>The date and time on which the monograph becomes valid 
     * and applicable.</p>
     * 
     * <p>Un-merged Business Name: IssueMonographEffectiveDate</p>
     * 
     * <p>Relationship: COCT_MT260020NB.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"author/time"})
    public Date getAuthorTime() {
        return this.authorTime.getValue();
    }

    /**
     * <p>Business Name: IssueMonographEffectiveDate</p>
     * 
     * <p>Un-merged Business Name: IssueMonographEffectiveDate</p>
     * 
     * <p>Relationship: COCT_MT260030NB.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DDIMonograph.EffectiveDate</p>
     * 
     * <p>A_DetectedMedicationIssue</p>
     * 
     * <p>Allows detailed matching of local knowledgebase record 
     * with that of the central. (The monograph id may remain the 
     * same, but the effective date will always change).</p>
     * 
     * <p>The date and time on which the monograph becomes valid 
     * and applicable.</p>
     * 
     * <p>Un-merged Business Name: IssueMonographEffectiveDate</p>
     * 
     * <p>Relationship: COCT_MT260010NB.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DDIMonograph.EffectiveDate</p>
     * 
     * <p>A_DetectedMedicationIssue</p>
     * 
     * <p>Allows detailed matching of local knowledgebase record 
     * with that of the central. (The monograph id may remain the 
     * same, but the effective date will always change).</p>
     * 
     * <p>The date and time on which the monograph becomes valid 
     * and applicable.</p>
     * 
     * <p>Un-merged Business Name: IssueMonographEffectiveDate</p>
     * 
     * <p>Relationship: COCT_MT260020NB.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAuthorTime(Date authorTime) {
        this.authorTime.setValue(authorTime);
    }


    /**
     * <p>Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: COCT_MT260030NB.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a knowledgebase vendor to be referenced by 
     * name.</p><p>The attribute is mandatory because it is the 
     * only information collected about a knowledgebase vendor.</p>
     * 
     * <p>The name of a clinical knowledgebase vendor 
     * organization.</p>
     * 
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: COCT_MT260010NB.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a knowledgebase vendor to be referenced by 
     * name.</p><p>The attribute is mandatory because it is the 
     * only information collected about a knowledgebase vendor.</p>
     * 
     * <p>The name of a clinical knowledgebase vendor 
     * organization.</p>
     * 
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: COCT_MT260020NB.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author/assignedEntity/assignedOrganization/name"})
    public String getAuthorAssignedEntityAssignedOrganizationName() {
        return this.authorAssignedEntityAssignedOrganizationName.getValue();
    }

    /**
     * <p>Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: COCT_MT260030NB.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a knowledgebase vendor to be referenced by 
     * name.</p><p>The attribute is mandatory because it is the 
     * only information collected about a knowledgebase vendor.</p>
     * 
     * <p>The name of a clinical knowledgebase vendor 
     * organization.</p>
     * 
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: COCT_MT260010NB.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a knowledgebase vendor to be referenced by 
     * name.</p><p>The attribute is mandatory because it is the 
     * only information collected about a knowledgebase vendor.</p>
     * 
     * <p>The name of a clinical knowledgebase vendor 
     * organization.</p>
     * 
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: COCT_MT260020NB.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthorAssignedEntityAssignedOrganizationName(String authorAssignedEntityAssignedOrganizationName) {
        this.authorAssignedEntityAssignedOrganizationName.setValue(authorAssignedEntityAssignedOrganizationName);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT260030NB.Component.substanceAdministrationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010NB.Component.substanceAdministrationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020NB.Component.substanceAdministrationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component/substanceAdministrationEventCriterion"})
    public RecommendedDosageBean getComponentSubstanceAdministrationEventCriterion() {
        return this.componentSubstanceAdministrationEventCriterion;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT260030NB.Component.substanceAdministrationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010NB.Component.substanceAdministrationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020NB.Component.substanceAdministrationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponentSubstanceAdministrationEventCriterion(RecommendedDosageBean componentSubstanceAdministrationEventCriterion) {
        this.componentSubstanceAdministrationEventCriterion = componentSubstanceAdministrationEventCriterion;
    }

}
