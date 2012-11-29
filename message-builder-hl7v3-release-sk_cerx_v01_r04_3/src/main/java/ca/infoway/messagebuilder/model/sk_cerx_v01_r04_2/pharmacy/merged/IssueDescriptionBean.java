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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged;

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
 * <p>IssueDescription</p>
 * 
 * <p>PORX_MT980010CA.DetectedIssueDefinition: Issue 
 * Description</p>
 * 
 * <p>This is the decision support rule that triggered the 
 * issue.</p>
 * 
 * <p>Provides detailed background for providers in evaluating 
 * the issue.</p>
 * 
 * <p>PORX_MT980020CA.DetectedIssueDefinition: Issue 
 * Description</p>
 * 
 * <p>This is the decision support rule that triggered the 
 * issue.</p>
 * 
 * <p>Provides detailed background for providers in evaluating 
 * the issue.</p>
 * 
 * <p>PORX_MT980030CA.DetectedIssueDefinition: Issue 
 * Description</p>
 * 
 * <p>This is the decision support rule that triggered the 
 * issue.</p>
 * 
 * <p>Provides detailed background for providers in evaluating 
 * the issue.</p>
 */
@Hl7PartTypeMapping({"PORX_MT980010CA.DetectedIssueDefinition","PORX_MT980020CA.DetectedIssueDefinition","PORX_MT980030CA.DetectedIssueDefinition"})
public class IssueDescriptionBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();
    private TS authorTime = new TSImpl();
    private ST authorAssignedEntityAssignedOrganizationName = new STImpl();
    private RecommendedDosageBean componentSubstanceAdministrationEventCriterion;


    /**
     * <p>IssueMonographId</p>
     * 
     * <p>A:Issue Monograph Id</p>
     * 
     * <p>Knowledgebase organization specific identifier for the 
     * issue definition.</p>
     * 
     * <p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p>
     * 
     * <p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p>
     * 
     * <p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p>
     * 
     * <p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p>
     * 
     * <p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p>
     * 
     * <p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p>
     * 
     * <p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p>
     * 
     * <p>Allows applications to match with local Knowledge-bases 
     * and avoid displaying duplicate issues to providers.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>IssueMonographId</p>
     * 
     * <p>A:Issue Monograph Id</p>
     * 
     * <p>Knowledgebase organization specific identifier for the 
     * issue definition.</p>
     * 
     * <p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p>
     * 
     * <p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p>
     * 
     * <p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p>
     * 
     * <p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p>
     * 
     * <p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p>
     * 
     * <p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p>
     * 
     * <p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p>
     * 
     * <p>Allows applications to match with local Knowledge-bases 
     * and avoid displaying duplicate issues to providers.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>IssueDescription</p>
     * 
     * <p>C:Issue Description</p>
     * 
     * <p>A free form textual description of the issue. This is 
     * usually in the form of a monograph.</p>
     * 
     * <p>Monograph URI (Reference)</p><p>Monograph description</p>
     * 
     * <p>Monograph URI (Reference)</p><p>Monograph description</p>
     * 
     * <p>Provides detailed clinical background on reasons for 
     * issue.</p>
     * 
     * <p>C:Issue Description</p>
     * 
     * <p>A free form textual description of the issue. This is 
     * usually in the form of a monograph.</p>
     * 
     * <p>Monograph URI (Reference)</p><p>Monograph description</p>
     * 
     * <p>Monograph URI (Reference)</p><p>Monograph description</p>
     * 
     * <p>Provides detailed clinical background on reasons for 
     * issue.</p>
     * 
     * <p><div>PIN will only store the reference if the</div> 
     * <p>monograph ID is not recognized by PIN.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getText() {
        return this.text.getValue();
    }

    /**
     * <p>IssueDescription</p>
     * 
     * <p>C:Issue Description</p>
     * 
     * <p>A free form textual description of the issue. This is 
     * usually in the form of a monograph.</p>
     * 
     * <p>Monograph URI (Reference)</p><p>Monograph description</p>
     * 
     * <p>Monograph URI (Reference)</p><p>Monograph description</p>
     * 
     * <p>Provides detailed clinical background on reasons for 
     * issue.</p>
     * 
     * <p>C:Issue Description</p>
     * 
     * <p>A free form textual description of the issue. This is 
     * usually in the form of a monograph.</p>
     * 
     * <p>Monograph URI (Reference)</p><p>Monograph description</p>
     * 
     * <p>Monograph URI (Reference)</p><p>Monograph description</p>
     * 
     * <p>Provides detailed clinical background on reasons for 
     * issue.</p>
     * 
     * <p><div>PIN will only store the reference if the</div> 
     * <p>monograph ID is not recognized by PIN.&nbsp;</p></p>
     */
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }


    /**
     * <p>IssueMonographEffectiveDate</p>
     * 
     * <p>B:Issue Monograph Effective Date</p>
     * 
     * <p>The date and time on which the monograph becomes valid 
     * and applicable.</p>
     * 
     * <p>DDIMonograph.EffectiveDate</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>DDIMonograph.EffectiveDate</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>Allows detailed matching of local knowledgebase record 
     * with that of the central. (The monograph id may remain the 
     * same, but the effective date will always change).</p>
     */
    @Hl7XmlMapping({"author/time"})
    public Date getAuthorTime() {
        return this.authorTime.getValue();
    }

    /**
     * <p>IssueMonographEffectiveDate</p>
     * 
     * <p>B:Issue Monograph Effective Date</p>
     * 
     * <p>The date and time on which the monograph becomes valid 
     * and applicable.</p>
     * 
     * <p>DDIMonograph.EffectiveDate</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>DDIMonograph.EffectiveDate</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>Allows detailed matching of local knowledgebase record 
     * with that of the central. (The monograph id may remain the 
     * same, but the effective date will always change).</p>
     */
    public void setAuthorTime(Date authorTime) {
        this.authorTime.setValue(authorTime);
    }


    /**
     * <p>KnowledgebaseVendorName</p>
     * 
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
     */
    @Hl7XmlMapping({"author/assignedEntity/assignedOrganization/name"})
    public String getAuthorAssignedEntityAssignedOrganizationName() {
        return this.authorAssignedEntityAssignedOrganizationName.getValue();
    }

    /**
     * <p>KnowledgebaseVendorName</p>
     * 
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
     */
    public void setAuthorAssignedEntityAssignedOrganizationName(String authorAssignedEntityAssignedOrganizationName) {
        this.authorAssignedEntityAssignedOrganizationName.setValue(authorAssignedEntityAssignedOrganizationName);
    }


    /**
     * <p>Reccomended Dosage</p>
     * 
     * <p><div>Identifies the outer dosage boundaries that</div> 
     * <div>were exceeded and triggered the issue.</div> 
     * <div>Included in this information are the drugspecific</div> 
     * <div>recommended dosage ranges for</div> <p>various age 
     * groups, weight classes, etc.&nbsp;</p></p>
     * 
     * <p>Recommended Dosage</p>
     * 
     * <p>&nbsp;Identifies the outer dosage boundaries that</p> 
     * <div>were exceeded and triggered the issue.</div> 
     * <div>Included in this information are the drugspecific</div> 
     * <div>recommended dosage ranges for</div> <div>various age 
     * groups, weight classes, etc.</div>
     */
    @Hl7XmlMapping({"component/substanceAdministrationEventCriterion"})
    public RecommendedDosageBean getComponentSubstanceAdministrationEventCriterion() {
        return this.componentSubstanceAdministrationEventCriterion;
    }

    /**
     * <p>Reccomended Dosage</p>
     * 
     * <p><div>Identifies the outer dosage boundaries that</div> 
     * <div>were exceeded and triggered the issue.</div> 
     * <div>Included in this information are the drugspecific</div> 
     * <div>recommended dosage ranges for</div> <p>various age 
     * groups, weight classes, etc.&nbsp;</p></p>
     * 
     * <p>Recommended Dosage</p>
     * 
     * <p>&nbsp;Identifies the outer dosage boundaries that</p> 
     * <div>were exceeded and triggered the issue.</div> 
     * <div>Included in this information are the drugspecific</div> 
     * <div>recommended dosage ranges for</div> <div>various age 
     * groups, weight classes, etc.</div>
     */
    public void setComponentSubstanceAdministrationEventCriterion(RecommendedDosageBean componentSubstanceAdministrationEventCriterion) {
        this.componentSubstanceAdministrationEventCriterion = componentSubstanceAdministrationEventCriterion;
    }

}