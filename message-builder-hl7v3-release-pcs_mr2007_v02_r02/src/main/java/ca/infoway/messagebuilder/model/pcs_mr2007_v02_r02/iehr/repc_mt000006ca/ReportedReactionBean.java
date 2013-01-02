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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.iehr.repc_mt000006ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt011001ca.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.iehr.merged.ReportedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.iehr.merged.ReportedReactionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.AllergyIntoleranceSeverityLevelBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.RefusedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Reported Reaction</p>
 * 
 * <p>Value is mandatory if not using SNOMED</p>
 * 
 * <p>Code is fixed to DX if not using SNOMED</p>
 * 
 * <p>Useful in tracking reactions when it is not known 
 * precisely what product they are associated with and whether 
 * the reaction is due to an allergy or intolerance, a drug 
 * interaction or some other cause. Effectively gives a 'heads 
 * up' to clinicians using the drug or combination of 
 * drugs.</p>
 * 
 * <p>This is a record of an adverse reaction considered 
 * relevant to the patient's clinical record.</p>
 */
@Hl7PartTypeMapping({"REPC_MT000006CA.ReactionObservationEvent"})
@Hl7RootType
public class ReportedReactionBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private ST text = new STImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private CV value = new CVImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private RefusedByBean author;
    private ReportedByBean informant;
    private CreatedAtBean location;
    private List<NotesBean> subjectOf1Annotation = new ArrayList<NotesBean>();
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);
    private List<ReportedReactionsBean> subjectOf3CausalityAssessment = new ArrayList<ReportedReactionsBean>();
    private AllergyIntoleranceSeverityLevelBean subjectOf4SeverityObservation;
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>Business Name: C:Reaction Record Id</p>
     * 
     * <p>Relationship: REPC_MT000006CA.ReactionObservationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Uniquely identifies the specific reaction record and is 
     * therefore mandatory.</p>
     * 
     * <p>An identifier assigned to the record of the adverse 
     * reaction.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: C:Reaction Record Id</p>
     * 
     * <p>Relationship: REPC_MT000006CA.ReactionObservationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Uniquely identifies the specific reaction record and is 
     * therefore mandatory.</p>
     * 
     * <p>An identifier assigned to the record of the adverse 
     * reaction.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Diagnosis Type</p>
     * 
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that the observation is actually a diagnosis 
     * and is therefore mandatory. The datatype is CD to support 
     * SNOMED post-coordination.</p>
     * 
     * <p>If using SNOMED, this will contain the diagnosis. 
     * Otherwise it will be a fixed value of 'DX'.</p>
     * 
     * <p>Indicates the type of diagnosis being captured.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Diagnosis Type</p>
     * 
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that the observation is actually a diagnosis 
     * and is therefore mandatory. The datatype is CD to support 
     * SNOMED post-coordination.</p>
     * 
     * <p>If using SNOMED, this will contain the diagnosis. 
     * Otherwise it will be a fixed value of 'DX'.</p>
     * 
     * <p>Indicates the type of diagnosis being captured.</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: G:Description</p>
     * 
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for flexibility in the recording and reporting of 
     * the reaction.</p>
     * 
     * <p>A free form description of the reaction.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: G:Description</p>
     * 
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for flexibility in the recording and reporting of 
     * the reaction.</p>
     * 
     * <p>A free form description of the reaction.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: F:Reaction Onset Date</p>
     * 
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates when evidence of the condition first appeared. 
     * May also provide information on the duration of the 
     * reaction.</p>
     * 
     * <p>The date on which the reaction occurrence began.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: F:Reaction Onset Date</p>
     * 
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates when evidence of the condition first appeared. 
     * May also provide information on the duration of the 
     * reaction.</p>
     * 
     * <p>The date on which the reaction occurrence began.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: G:Adverse Reaction Masking Indicators</p>
     * 
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their adverse reaction data.</p><p>Taboo allows the 
     * provider to request restricted access to patient or their 
     * care giver.</p><p>Constraint: Cant have both normal and one 
     * of the other codes simultaneously.</p><p>The attribute is 
     * required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their adverse reactions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    /**
     * <p>Business Name: B:Reaction</p>
     * 
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>B.1</p>
     * 
     * <p>Ensures consistency in tracking and categorizing the 
     * reaction type. Helps ensure that only proper allergies are 
     * categorized as allergy. The attribute is optional because it 
     * will not be used for SNOMED. The attribute is CWE because 
     * not all possible types of reactions are expressible by coded 
     * values.</p>
     * 
     * <p>Specifies the kind of reaction, as experienced by the 
     * patient.</p>
     */
    @Hl7XmlMapping({"value"})
    public SubjectReaction getValue() {
        return (SubjectReaction) this.value.getValue();
    }

    /**
     * <p>Business Name: B:Reaction</p>
     * 
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>B.1</p>
     * 
     * <p>Ensures consistency in tracking and categorizing the 
     * reaction type. Helps ensure that only proper allergies are 
     * categorized as allergy. The attribute is optional because it 
     * will not be used for SNOMED. The attribute is CWE because 
     * not all possible types of reactions are expressible by coded 
     * values.</p>
     * 
     * <p>Specifies the kind of reaction, as experienced by the 
     * patient.</p>
     */
    public void setValue(SubjectReaction value) {
        this.value.setValue(value);
    }


    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }

    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"informant"})
    public ReportedByBean getInformant() {
        return this.informant;
    }

    public void setInformant(ReportedByBean informant) {
        this.informant = informant;
    }


    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }

    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: REPC_MT000006CA.Subject3.annotation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/annotation"})
    public List<NotesBean> getSubjectOf1Annotation() {
        return this.subjectOf1Annotation;
    }


    /**
     * <p>Relationship: 
     * REPC_MT000006CA.Subject4.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * REPC_MT000006CA.Subject4.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    @Hl7XmlMapping({"subjectOf3/causalityAssessment"})
    public List<ReportedReactionsBean> getSubjectOf3CausalityAssessment() {
        return this.subjectOf3CausalityAssessment;
    }


    @Hl7XmlMapping({"subjectOf4/severityObservation"})
    public AllergyIntoleranceSeverityLevelBean getSubjectOf4SeverityObservation() {
        return this.subjectOf4SeverityObservation;
    }

    public void setSubjectOf4SeverityObservation(AllergyIntoleranceSeverityLevelBean subjectOf4SeverityObservation) {
        this.subjectOf4SeverityObservation = subjectOf4SeverityObservation;
    }


    /**
     * <p>Relationship: 
     * REPC_MT000006CA.Component.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
