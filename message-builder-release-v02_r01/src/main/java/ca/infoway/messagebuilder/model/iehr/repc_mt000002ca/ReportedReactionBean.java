/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.iehr.repc_mt000002ca;

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
import ca.infoway.messagebuilder.model.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.merged.AllergyIntoleranceSeverityLevelBean;
import ca.infoway.messagebuilder.model.merged.CausalityAssessment_1Bean;
import ca.infoway.messagebuilder.model.merged.Informant_2Bean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Reported Reaction</p>
 * 
 * <p>This is a record of an adverse reaction considered 
 * relevant to the patient's clincal record.</p>
 * 
 * <p>Useful in tracking reactions when it is not known 
 * precisely what product they are associated with and whether 
 * the reaction is due to an allergy or intolerance, a drug 
 * interaction or some other cause. Effectively gives a 'heads 
 * up' to clinicians using the drug or combination of drugs.</p>
 * 
 * <p>Value is mandatory if not using SNOMED</p>
 * 
 * <p>Code is fixed to DX if not using SNOMED</p>
 */
@Hl7PartTypeMapping({"REPC_MT000002CA.ReactionObservationEvent"})
@Hl7RootType
public class ReportedReactionBean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private CD diagnosisType = new CDImpl();
    private ST description = new STImpl();
    private IVL<TS, Interval<Date>> reactionOnsetDate = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> adverseReactionMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private CV reaction = new CVImpl();
    private Informant_2Bean informant;
    private NotesBean subjectOf1Annotation;
    private AllergyIntoleranceSeverityLevelBean subjectOf2SeverityObservation;
    private List<CausalityAssessment_1Bean> subjectOf3CausalityAssessment = new ArrayList<CausalityAssessment_1Bean>();

    @Hl7XmlMapping({"code"})
    public ActCode getDiagnosisType() {
        return (ActCode) this.diagnosisType.getValue();
    }
    public void setDiagnosisType(ActCode diagnosisType) {
        this.diagnosisType.setValue(diagnosisType);
    }

    @Hl7XmlMapping({"text"})
    public String getDescription() {
        return this.description.getValue();
    }
    public void setDescription(String description) {
        this.description.setValue(description);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getReactionOnsetDate() {
        return this.reactionOnsetDate.getValue();
    }
    public void setReactionOnsetDate(Interval<Date> reactionOnsetDate) {
        this.reactionOnsetDate.setValue(reactionOnsetDate);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getAdverseReactionMaskingIndicators() {
        return this.adverseReactionMaskingIndicators.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }

    @Hl7XmlMapping({"value"})
    public SubjectReaction getReaction() {
        return (SubjectReaction) this.reaction.getValue();
    }
    public void setReaction(SubjectReaction reaction) {
        this.reaction.setValue(reaction);
    }

    @Hl7XmlMapping({"informant"})
    public Informant_2Bean getInformant() {
        return this.informant;
    }
    public void setInformant(Informant_2Bean informant) {
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
    public List<CausalityAssessment_1Bean> getSubjectOf3CausalityAssessment() {
        return this.subjectOf3CausalityAssessment;
    }

}
