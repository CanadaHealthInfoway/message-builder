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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.repc_mt000006ca;

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
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt011001ca.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.domainvalue.ActDiagnosisCode;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.merged.ReactionAssessmentsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.merged.ReportedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.AllergyIntoleranceSeverityLevelBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.RefusedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.SupervisedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.TargetedToPharmacyBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Reported Reaction</p>
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
public class ReportedReactionBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.comt_mt111111ca.SHR {

    private static final long serialVersionUID = 20190731L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CD code = new CDImpl();
    private ST text = new STImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private CV value = new CVImpl();
    private SupervisedByBean responsibleParty;
    private RefusedByBean author;
    private ReportedByBean informant;
    private TargetedToPharmacyBean location;
    private List<IncludesBean> subjectOf1 = new ArrayList<IncludesBean>();
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);
    private List<ReactionAssessmentsBean> subjectOf3CausalityAssessment = new ArrayList<ReactionAssessmentsBean>();
    private AllergyIntoleranceSeverityLevelBean subjectOf4SeverityObservation;
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>Business Name: C:Reaction Record Id</p>
     * 
     * <p>Relationship: REPC_MT000006CA.ReactionObservationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (2)</p>
     * 
     * <p>Uniquely identifies the specific reaction record and is 
     * therefore mandatory.</p>
     * 
     * <p>An identifier assigned to the record of the adverse 
     * reaction.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: Reaction Type</p>
     * 
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that the observation is actually a diagnosis 
     * and is therefore mandatory.</p>
     * 
     * <p>Denotes assertion of reaction. The reaction is conveyed 
     * in the value attribute.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActDiagnosisCode getCode() {
        return (ActDiagnosisCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Reaction Type</p>
     * 
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that the observation is actually a diagnosis 
     * and is therefore mandatory.</p>
     * 
     * <p>Denotes assertion of reaction. The reaction is conveyed 
     * in the value attribute.</p>
     */
    public void setCode(ActDiagnosisCode code) {
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
     * care giver.</p><p>Constraint: Can't have both normal and one 
     * of the other codes simultaneously.</p><p>The attribute is 
     * required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p>
     * 
     * <p>Communicates the desire of the patient to restrict access 
     * to this Health Condition record. Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information. Methods for 
     * accessing masked event records will be governed by each 
     * jurisdiction (e.g. court orders, shared secret/consent, 
     * etc.). Can also be used to communicate that the information 
     * is deemed to be sensitive and should not be communicated or 
     * exposed to the patient (at least without the guidance of the 
     * authoring or other responsible healthcare provider). Valid 
     * values are: 'normal' (denotes 'Not Masked'); 'restricted' 
     * (denotes 'Masked'); 'very restricted' (denotes 'Masked by 
     * Regulation'); and 'taboo' (denotes 'patient restricted'). 
     * The default is 'normal' signifying 'Not Masked'. Either or 
     * both of the other codes can be asserted to indicate masking 
     * by the patient from providers or masking by a provider from 
     * the patient, respectively. 'normal' should never be asserted 
     * with one of the other codes.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
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
     * categorized as allergy. The attribute is CWE because not all 
     * possible types of reactions are expressible by coded 
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
     * categorized as allergy. The attribute is CWE because not all 
     * possible types of reactions are expressible by coded 
     * values.</p>
     * 
     * <p>Specifies the kind of reaction, as experienced by the 
     * patient.</p>
     */
    public void setValue(SubjectReaction value) {
        this.value.setValue(value);
    }


    /**
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"responsibleParty"})
    public SupervisedByBean getResponsibleParty() {
        return this.responsibleParty;
    }

    /**
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setResponsibleParty(SupervisedByBean responsibleParty) {
        this.responsibleParty = responsibleParty;
    }


    /**
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.informant</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"informant"})
    public ReportedByBean getInformant() {
        return this.informant;
    }

    /**
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.informant</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setInformant(ReportedByBean informant) {
        this.informant = informant;
    }


    /**
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public TargetedToPharmacyBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(TargetedToPharmacyBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: 
     * REPC_MT000006CA.ReactionObservationEvent.subjectOf1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-99)</p>
     */
    @Hl7XmlMapping({"subjectOf1"})
    public List<IncludesBean> getSubjectOf1() {
        return this.subjectOf1;
    }


    /**
     * <p>Relationship: 
     * REPC_MT000006CA.Subject4.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * REPC_MT000006CA.Subject4.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    /**
     * <p>Relationship: 
     * REPC_MT000006CA.Subject6.causalityAssessment</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf3/causalityAssessment"})
    public List<ReactionAssessmentsBean> getSubjectOf3CausalityAssessment() {
        return this.subjectOf3CausalityAssessment;
    }


    /**
     * <p>Relationship: 
     * REPC_MT000006CA.Subject1.severityObservation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf4/severityObservation"})
    public AllergyIntoleranceSeverityLevelBean getSubjectOf4SeverityObservation() {
        return this.subjectOf4SeverityObservation;
    }

    /**
     * <p>Relationship: 
     * REPC_MT000006CA.Subject1.severityObservation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf4SeverityObservation(AllergyIntoleranceSeverityLevelBean subjectOf4SeverityObservation) {
        this.subjectOf4SeverityObservation = subjectOf4SeverityObservation;
    }


    /**
     * <p>Relationship: 
     * REPC_MT000006CA.Component.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
