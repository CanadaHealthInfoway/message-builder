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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.iehr.repc_mt000006ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.iehr.merged.ReactionAssessmentsBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.iehr.merged.ReportedByBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.AllergyIntoleranceSeverityLevelBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.RefusedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Reported Reaction</p>
 * 
 * <p><p>Value is mandatory if not using SNOMED</p><p>Code is 
 * fixed to DX if not using SNOMED</p></p>
 * 
 * <p><p>Value is mandatory if not using SNOMED</p><p>Code is 
 * fixed to DX if not using SNOMED</p></p>
 * 
 * <p><p>This is a record of an adverse reaction considered 
 * relevant to the patient's clinical record.</p></p>
 * 
 * <p><p>Useful in tracking reactions when it is not known 
 * precisely what product they are associated with and whether 
 * the reaction is due to an allergy or intolerance, a drug 
 * interaction or some other cause. Effectively gives a 'heads 
 * up' to clinicians using the drug or combination of 
 * drugs.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000006CA.ReactionObservationEvent"})
@Hl7RootType
public class ReportedReactionBean extends MessagePartBean {

    private static final long serialVersionUID = 20120322L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private ST text = new STImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV confidentialityCode = new CVImpl();
    private CV value = new CVImpl();
    private PatientBean subjectPatient;
    private ProviderBean responsiblePartyAssignedPerson;
    private RefusedByBean author;
    private ReportedByBean informant;
    private RecordedAtBean location;
    private List<CommentBean> subjectOf1Annotation = new ArrayList<CommentBean>();
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);
    private List<ReactionAssessmentsBean> subjectOf3CausalityAssessment = new ArrayList<ReactionAssessmentsBean>();
    private AllergyIntoleranceSeverityLevelBean subjectOf4SeverityObservation;


    /**
     * <p>C:Reaction Record Id</p>
     * 
     * <p><p>An identifier assigned to the record of the adverse 
     * reaction.</p></p>
     * 
     * <p><p>Uniquely identifies the specific reaction record and 
     * is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Diagnosis Type</p>
     * 
     * <p><p>Indicates the type of diagnosis being captured.</p></p>
     * 
     * <p><p>Indicates that the observation is actually a diagnosis 
     * and is therefore mandatory. The datatype is CD to support 
     * SNOMED post-coordination.</p></p>
     * 
     * <p><p>If using SNOMED, this will contain the diagnosis. 
     * Otherwise it will be a fixed value of 'DX'.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>G:Description</p>
     * 
     * <p><p>A free form description of the reaction.</p></p>
     * 
     * <p><p>B.4</p></p>
     * 
     * <p><p>Allows for flexibility in the recording and reporting 
     * of the reaction.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>F:Reaction Onset Date</p>
     * 
     * <p><p>The date on which the reaction occurrence began.</p></p>
     * 
     * <p><p>Indicates when evidence of the condition first 
     * appeared. May also provide information on the duration of 
     * the reaction.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>G:Adverse Reaction Masking Indicator</p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their adverse reactions. Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information. Valid values are: 
     * 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' (denotes 
     * 'Masked'). The default is 'NORMAL' signifying 'Not 
     * Masked'.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their adverse reaction data.</p><p>The attribute 
     * is optional because not all systems will support 
     * masking.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their adverse reaction data.</p><p>The attribute 
     * is optional because not all systems will support 
     * masking.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>B:Reaction</p>
     * 
     * <p><p>Specifies the kind of reaction, as experienced by the 
     * patient.</p></p>
     * 
     * <p><p>B.1</p></p>
     * 
     * <p><p>Ensures consistency in tracking and categorizing the 
     * reaction type. Helps ensure that only proper allergies are 
     * categorized as allergy. The attribute is optional because it 
     * will not be used for SNOMED. The attribute is CWE because 
     * not all possible types of reactions are expressible by coded 
     * values.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public SubjectReaction getValue() {
        return (SubjectReaction) this.value.getValue();
    }
    public void setValue(SubjectReaction value) {
        this.value.setValue(value);
    }


    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
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
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"subjectOf1/annotation"})
    public List<CommentBean> getSubjectOf1Annotation() {
        return this.subjectOf1Annotation;
    }


    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    @Hl7XmlMapping({"subjectOf3/causalityAssessment"})
    public List<ReactionAssessmentsBean> getSubjectOf3CausalityAssessment() {
        return this.subjectOf3CausalityAssessment;
    }


    @Hl7XmlMapping({"subjectOf4/severityObservation"})
    public AllergyIntoleranceSeverityLevelBean getSubjectOf4SeverityObservation() {
        return this.subjectOf4SeverityObservation;
    }
    public void setSubjectOf4SeverityObservation(AllergyIntoleranceSeverityLevelBean subjectOf4SeverityObservation) {
        this.subjectOf4SeverityObservation = subjectOf4SeverityObservation;
    }

}
