/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.repc_mt000002ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.AllergyIntoleranceSeverityLevelBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.ReactionAssessmentsBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.ReportedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Reported Reaction</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is a 
 * record of an adverse reaction considered relevant to the 
 * patient's clincal record.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful in 
 * tracking reactions when it is not known precisely what 
 * product they are associated with and whether the reaction is 
 * due to an allergy or intolerance, a drug interaction or some 
 * other cause. Effectively gives a 'heads up' to clinicians 
 * using the drug or combination of drugs.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000002CA.ReactionObservationEvent"})
@Hl7RootType
public class ReportedReactionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private CD diagnosisType = new CDImpl();
    private ST description = new STImpl();
    private IVL<TS, Interval<Date>> reactionOnsetDate = new IVLImpl<TS, Interval<Date>>();
    private CV adverseReactionMaskingIndicator = new CVImpl();
    private CV reaction = new CVImpl();
    private ReportedByBean informant;
    private Patient_1Bean subjectPatient;
    private CommentBean subjectOf1Annotation;
    private AllergyIntoleranceSeverityLevelBean subjectOf2SeverityObservation;
    private List<ReactionAssessmentsBean> subjectOf3CausalityAssessment = new ArrayList<ReactionAssessmentsBean>();


    /**
     * <p>Diagnosis Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the type of diagnosis being captured.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * that the observation is actually a diagnosis and is 
     * therefore mandatory. The datatype is CD to support SNOMED 
     * post-coordination.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">If using 
     * SNOMED, this will contain the diagnosis. Otherwise it will 
     * be a fixed value of 'DX'.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getDiagnosisType() {
        return (ActCode) this.diagnosisType.getValue();
    }
    public void setDiagnosisType(ActCode diagnosisType) {
        this.diagnosisType.setValue(diagnosisType);
    }


    /**
     * <p>G:Description</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A free form 
     * description of the reaction.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">This is a specific 
     * description of the reaction, as opposed to annotations on 
     * the reaction.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Annotations and 
     * text are quite different. Think of it from a user interface. 
     * Notes might be things like &quot;patient didn't have the 
     * problem when the took the medication two weeks earlier&quot; 
     * or &quot;patient thinks it might have been related to the 
     * two bottles of scotch they drank the night prior&quot;, 
     * which aren't describing the reaction but are relevant to the 
     * reaction record</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A free form 
     * description of the reaction.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">This is a specific 
     * description of the reaction, as opposed to annotations on 
     * the reaction.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Annotations and 
     * text are quite different. Think of it from a user interface. 
     * Notes might be things like &quot;patient didn't have the 
     * problem when the took the medication two weeks earlier&quot; 
     * or &quot;patient thinks it might have been related to the 
     * two bottles of scotch they drank the night prior&quot;, 
     * which aren't describing the reaction but are relevant to the 
     * reaction record</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A free form 
     * description of the reaction.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">This is a specific 
     * description of the reaction, as opposed to annotations on 
     * the reaction.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Annotations and 
     * text are quite different. Think of it from a user interface. 
     * Notes might be things like &quot;patient didn't have the 
     * problem when the took the medication two weeks earlier&quot; 
     * or &quot;patient thinks it might have been related to the 
     * two bottles of scotch they drank the night prior&quot;, 
     * which aren't describing the reaction but are relevant to the 
     * reaction record</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">B.4</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows for 
     * flexibility in the recording and reporting of the 
     * reaction.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getDescription() {
        return this.description.getValue();
    }
    public void setDescription(String description) {
        this.description.setValue(description);
    }


    /**
     * <p>F:Reaction Onset Date</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The date on 
     * which the reaction occurrence began.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * when evidence of the condition first appeared. May also 
     * provide information on the duration of the reaction.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getReactionOnsetDate() {
        return this.reactionOnsetDate.getValue();
    }
    public void setReactionOnsetDate(Interval<Date> reactionOnsetDate) {
        this.reactionOnsetDate.setValue(reactionOnsetDate);
    }


    /**
     * <p>G:Adverse Reaction Masking Indicator</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Communicates 
     * the intent of the patient to restrict access to their 
     * adverse reactions. Provides support for additional 
     * confidentiality constraint, giving patients a level of 
     * control over their information. Valid values are: 'NORMAL' 
     * (denotes 'Not Masked'); and 'RESTRICTED' (denotes 'Masked'). 
     * The default is 'NORMAL' signifying 'Not Masked'.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows the 
     * patient to have discrete control over access to their 
     * adverse reaction data.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows the 
     * patient to have discrete control over access to their 
     * adverse reaction data.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * optional because not all systems will support masking.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getAdverseReactionMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.adverseReactionMaskingIndicator.getValue();
    }
    public void setAdverseReactionMaskingIndicator(x_VeryBasicConfidentialityKind adverseReactionMaskingIndicator) {
        this.adverseReactionMaskingIndicator.setValue(adverseReactionMaskingIndicator);
    }


    /**
     * <p>B:Reaction</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Specifies 
     * the kind of reaction, as experienced by the patient.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">B.1</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Ensures 
     * consistency in tracking and categorizing the reaction type. 
     * Helps ensure that only proper allergies are categorized as 
     * allergy. The attribute is optional because it will not be 
     * used for SNOMED. The attribute is CWE because not all 
     * possible types of reactions are expressible by coded 
     * values.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public SubjectReaction getReaction() {
        return (SubjectReaction) this.reaction.getValue();
    }
    public void setReaction(SubjectReaction reaction) {
        this.reaction.setValue(reaction);
    }


    @Hl7XmlMapping({"informant"})
    public ReportedByBean getInformant() {
        return this.informant;
    }
    public void setInformant(ReportedByBean informant) {
        this.informant = informant;
    }


    @Hl7XmlMapping({"subject/patient"})
    public Patient_1Bean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(Patient_1Bean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"subjectOf1/annotation"})
    public CommentBean getSubjectOf1Annotation() {
        return this.subjectOf1Annotation;
    }
    public void setSubjectOf1Annotation(CommentBean subjectOf1Annotation) {
        this.subjectOf1Annotation = subjectOf1Annotation;
    }


    @Hl7XmlMapping({"subjectOf2/severityObservation"})
    public AllergyIntoleranceSeverityLevelBean getSubjectOf2SeverityObservation() {
        return this.subjectOf2SeverityObservation;
    }
    public void setSubjectOf2SeverityObservation(AllergyIntoleranceSeverityLevelBean subjectOf2SeverityObservation) {
        this.subjectOf2SeverityObservation = subjectOf2SeverityObservation;
    }


    @Hl7XmlMapping({"subjectOf3/causalityAssessment"})
    public List<ReactionAssessmentsBean> getSubjectOf3CausalityAssessment() {
        return this.subjectOf3CausalityAssessment;
    }

}
