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
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Business Name: IssueDescription</p>
 * 
 * <p>PORX_MT980010ON.DetectedIssueDefinition: Issue 
 * Description</p>
 * 
 * <p>Provides detailed background for providers in evaluating 
 * the issue.</p>
 * 
 * <p>This is the decision support rule that triggered the 
 * issue.</p>
 * 
 * <p>PORX_MT980020ON.DetectedIssueDefinition: Issue 
 * Description</p>
 * 
 * <p>Provides detailed background for providers in evaluating 
 * the issue.</p>
 * 
 * <p>This is the decision support rule that triggered the 
 * issue.</p>
 * 
 * <p>PORX_MT980030ON.DetectedIssueDefinition: Issue 
 * Description</p>
 * 
 * <p>Provides detailed background for providers in evaluating 
 * the issue.</p>
 * 
 * <p>This is the decision support rule that triggered the 
 * issue.</p>
 */
@Hl7PartTypeMapping({"PORX_MT980010ON.DetectedIssueDefinition","PORX_MT980020ON.DetectedIssueDefinition","PORX_MT980030ON.DetectedIssueDefinition"})
public class IssueDescriptionBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private II id = new IIImpl();
    private ANY<Object> text = new ANYImpl<Object>();
    private TS authorTime = new TSImpl();
    private AssignedEntityBean authorAssignedEntity;
    private RecommendedDosageBean componentSubstanceAdministrationEventCriterion;


    /**
     * <p>Business Name: IssueMonographId</p>
     * 
     * <p>Un-merged Business Name: IssueMonographId</p>
     * 
     * <p>Relationship: PORX_MT980010ON.DetectedIssueDefinition.id</p>
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
     * <p>Relationship: PORX_MT980020ON.DetectedIssueDefinition.id</p>
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
     * <p>Relationship: PORX_MT980030ON.DetectedIssueDefinition.id</p>
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
     * <p>Relationship: PORX_MT980010ON.DetectedIssueDefinition.id</p>
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
     * <p>Relationship: PORX_MT980020ON.DetectedIssueDefinition.id</p>
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
     * <p>Relationship: PORX_MT980030ON.DetectedIssueDefinition.id</p>
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
     * PORX_MT980010ON.DetectedIssueDefinition.text</p>
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
     * PORX_MT980020ON.DetectedIssueDefinition.text</p>
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
     * PORX_MT980030ON.DetectedIssueDefinition.text</p>
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
     */
    @Hl7XmlMapping({"text"})
    public Object getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: IssueDescription</p>
     * 
     * <p>Un-merged Business Name: IssueDescription</p>
     * 
     * <p>Relationship: 
     * PORX_MT980010ON.DetectedIssueDefinition.text</p>
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
     * PORX_MT980020ON.DetectedIssueDefinition.text</p>
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
     * PORX_MT980030ON.DetectedIssueDefinition.text</p>
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
     */
    public void setText(Object text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: IssueMonographEffectiveDate</p>
     * 
     * <p>Un-merged Business Name: IssueMonographEffectiveDate</p>
     * 
     * <p>Relationship: PORX_MT980010ON.Author2.time</p>
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
     * <p>Relationship: PORX_MT980020ON.Author2.time</p>
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
     * <p>Relationship: PORX_MT980030ON.Author2.time</p>
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
     * <p>Relationship: PORX_MT980010ON.Author2.time</p>
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
     * <p>Relationship: PORX_MT980020ON.Author2.time</p>
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
     * <p>Relationship: PORX_MT980030ON.Author2.time</p>
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
     */
    public void setAuthorTime(Date authorTime) {
        this.authorTime.setValue(authorTime);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT980010ON.Author2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT980020ON.Author2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT980030ON.Author2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author/assignedEntity"})
    public AssignedEntityBean getAuthorAssignedEntity() {
        return this.authorAssignedEntity;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT980010ON.Author2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT980020ON.Author2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT980030ON.Author2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthorAssignedEntity(AssignedEntityBean authorAssignedEntity) {
        this.authorAssignedEntity = authorAssignedEntity;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT980010ON.Component.substanceAdministrationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT980020ON.Component.substanceAdministrationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030ON.Component.substanceAdministrationEventCriterion</p>
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
     * PORX_MT980010ON.Component.substanceAdministrationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT980020ON.Component.substanceAdministrationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030ON.Component.substanceAdministrationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponentSubstanceAdministrationEventCriterion(RecommendedDosageBean componentSubstanceAdministrationEventCriterion) {
        this.componentSubstanceAdministrationEventCriterion = componentSubstanceAdministrationEventCriterion;
    }

}
