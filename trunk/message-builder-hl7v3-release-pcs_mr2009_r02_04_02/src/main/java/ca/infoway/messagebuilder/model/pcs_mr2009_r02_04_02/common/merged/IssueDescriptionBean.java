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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.PrescribedByBean;



/**
 * <p>IssueDescription</p>
 * 
 * <p>COCT_MT260030CA.DetectedIssueDefinition: Issue 
 * Description</p>
 * 
 * <p>This is the decision support rule that triggered the 
 * issue.</p>
 * 
 * <p>Provides detailed background for providers in evaluating 
 * the issue.</p>
 * 
 * <p>COCT_MT260010CA.DetectedIssueDefinition: Issue 
 * Description</p>
 * 
 * <p>This is the decision support rule that triggered the 
 * issue.</p>
 * 
 * <p>Provides detailed background for providers in evaluating 
 * the issue.</p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.DetectedIssueDefinition","COCT_MT260020CA.DetectedIssueDefinition","COCT_MT260030CA.DetectedIssueDefinition"})
public class IssueDescriptionBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();
    private PrescribedByBean author;
    private RecommendedDosageBean componentSubstanceAdministrationEventCriterion;


    /**
     * <p>IssueMonographId</p>
     * 
     * <p>A:Issue Monograph Id</p>
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
     */
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }


    @Hl7XmlMapping({"author"})
    public PrescribedByBean getAuthor() {
        return this.author;
    }

    public void setAuthor(PrescribedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"component/substanceAdministrationEventCriterion"})
    public RecommendedDosageBean getComponentSubstanceAdministrationEventCriterion() {
        return this.componentSubstanceAdministrationEventCriterion;
    }

    public void setComponentSubstanceAdministrationEventCriterion(RecommendedDosageBean componentSubstanceAdministrationEventCriterion) {
        this.componentSubstanceAdministrationEventCriterion = componentSubstanceAdministrationEventCriterion;
    }

}
