/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.iehr.repc_mt000002ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r02.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.v02_r02.iehr.merged.ReportedByBean;
import ca.infoway.messagebuilder.model.v02_r02.iehr.merged.ReportedReactionsBean;
import ca.infoway.messagebuilder.model.v02_r02.merged.AllergyIntoleranceSeverityLevelBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



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
 * relevant to the patient's clincal record.</p></p>
 * 
 * <p><p>Useful in tracking reactions when it is not known 
 * precisely what product they are associated with and whether 
 * the reaction is due to an allergy or intolerance, a drug 
 * interaction or some other cause. Effectively gives a 'heads 
 * up' to clinicians using the drug or combination of 
 * drugs.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000002CA.ReactionObservationEvent"})
@Hl7RootType
public class ReportedReactionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CD diagnosisType = new CDImpl();
    private ST description = new STImpl();
    private IVL<TS, Interval<Date>> reactionOnsetDate = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> adverseReactionMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private CV reaction = new CVImpl();
    private ReportedByBean informant;
    private NotesBean subjectOf1Annotation;
    private AllergyIntoleranceSeverityLevelBean subjectOf2SeverityObservation;
    private List<ReportedReactionsBean> subjectOf3CausalityAssessment = new ArrayList<ReportedReactionsBean>();


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
    public ActCode getDiagnosisType() {
        return (ActCode) this.diagnosisType.getValue();
    }
    public void setDiagnosisType(ActCode diagnosisType) {
        this.diagnosisType.setValue(diagnosisType);
    }


    /**
     * <p>G:Description</p>
     * 
     * <p><p>A free form description of the reaction.</p><p>This is 
     * a specific description of the reaction, as opposed to 
     * annotations on the reaction.</p><p>Annotations and text are 
     * quite different. Think of it from a user interface. Notes 
     * might be things like &quot;patient didn't have the problem 
     * when the took the medication two weeks earlier&quot; or 
     * &quot;patient thinks it might have been related to the two 
     * bottles of scotch they drank the night prior&quot;, which 
     * aren't describing the reaction but are relevant to the 
     * reaction record</p></p>
     * 
     * <p><p>A free form description of the reaction.</p><p>This is 
     * a specific description of the reaction, as opposed to 
     * annotations on the reaction.</p><p>Annotations and text are 
     * quite different. Think of it from a user interface. Notes 
     * might be things like &quot;patient didn't have the problem 
     * when the took the medication two weeks earlier&quot; or 
     * &quot;patient thinks it might have been related to the two 
     * bottles of scotch they drank the night prior&quot;, which 
     * aren't describing the reaction but are relevant to the 
     * reaction record</p></p>
     * 
     * <p><p>A free form description of the reaction.</p><p>This is 
     * a specific description of the reaction, as opposed to 
     * annotations on the reaction.</p><p>Annotations and text are 
     * quite different. Think of it from a user interface. Notes 
     * might be things like &quot;patient didn't have the problem 
     * when the took the medication two weeks earlier&quot; or 
     * &quot;patient thinks it might have been related to the two 
     * bottles of scotch they drank the night prior&quot;, which 
     * aren't describing the reaction but are relevant to the 
     * reaction record</p></p>
     * 
     * <p><p>Allows for flexibility in the recording and reporting 
     * of the reaction.</p></p>
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
     * <p><p>The date on which the reaction occurrence began.</p></p>
     * 
     * <p><p>Indicates when evidence of the condition first 
     * appeared. May also provide information on the duration of 
     * the reaction.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getReactionOnsetDate() {
        return this.reactionOnsetDate.getValue();
    }
    public void setReactionOnsetDate(Interval<Date> reactionOnsetDate) {
        this.reactionOnsetDate.setValue(reactionOnsetDate);
    }


    /**
     * <p>G:Adverse Reaction Masking Indicators</p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their adverse reactions.</p><p>Provides support 
     * for additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their adverse reactions.</p><p>Provides support 
     * for additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their adverse reactions.</p><p>Provides support 
     * for additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their adverse reactions.</p><p>Provides support 
     * for additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their adverse reactions.</p><p>Provides support 
     * for additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their adverse reaction data.</p><p>Taboo allows 
     * the provider to request restricted access to patient or 
     * their care giver.</p><p>Constraint: Can'''t have both normal 
     * and one of the other codes simultaneously.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their adverse reaction data.</p><p>Taboo allows 
     * the provider to request restricted access to patient or 
     * their care giver.</p><p>Constraint: Can'''t have both normal 
     * and one of the other codes simultaneously.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their adverse reaction data.</p><p>Taboo allows 
     * the provider to request restricted access to patient or 
     * their care giver.</p><p>Constraint: Can'''t have both normal 
     * and one of the other codes simultaneously.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their adverse reaction data.</p><p>Taboo allows 
     * the provider to request restricted access to patient or 
     * their care giver.</p><p>Constraint: Can'''t have both normal 
     * and one of the other codes simultaneously.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getAdverseReactionMaskingIndicators() {
        return this.adverseReactionMaskingIndicators.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
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


    @Hl7XmlMapping({"subjectOf1/annotation"})
    public NotesBean getSubjectOf1Annotation() {
        return this.subjectOf1Annotation;
    }
    public void setSubjectOf1Annotation(NotesBean subjectOf1Annotation) {
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
    public List<ReportedReactionsBean> getSubjectOf3CausalityAssessment() {
        return this.subjectOf3CausalityAssessment;
    }

}
