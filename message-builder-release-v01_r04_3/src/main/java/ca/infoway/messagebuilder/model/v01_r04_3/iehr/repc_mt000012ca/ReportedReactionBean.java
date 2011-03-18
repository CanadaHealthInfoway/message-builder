/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.iehr.repc_mt000012ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.v01_r04_3.iehr.merged.ReportedByBean;
import ca.infoway.messagebuilder.model.v01_r04_3.iehr.merged.ReportedReactionsBean;
import ca.infoway.messagebuilder.model.v01_r04_3.merged.AllergyIntoleranceSeverityLevelBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"REPC_MT000012CA.ReactionObservationEvent"})
@Hl7RootType
public class ReportedReactionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private PatientBean subjectPatient;
    private CV adverseReactionMaskingIndicator = new CVImpl();
    private List<ReportedReactionsBean> subjectOf2CausalityAssessment = new ArrayList<ReportedReactionsBean>();
    private II reactionRecordId = new IIImpl();
    private CD diagnosisType = new CDImpl();
    private IVL<TS, Interval<Date>> reactionOnsetDate = new IVLImpl<TS, Interval<Date>>();
    private CV reaction = new CVImpl();
    private AllergyIntoleranceSeverityLevelBean subjectOf1SeverityObservation;
    private ST description = new STImpl();
    private ReportedByBean informant;


    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>G:Adverse Reaction Masking Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getAdverseReactionMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.adverseReactionMaskingIndicator.getValue();
    }
    public void setAdverseReactionMaskingIndicator(x_VeryBasicConfidentialityKind adverseReactionMaskingIndicator) {
        this.adverseReactionMaskingIndicator.setValue(adverseReactionMaskingIndicator);
    }


    @Hl7XmlMapping({"subjectOf2/causalityAssessment"})
    public List<ReportedReactionsBean> getSubjectOf2CausalityAssessment() {
        return this.subjectOf2CausalityAssessment;
    }


    /**
     * <p>C:Reaction Record Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getReactionRecordId() {
        return this.reactionRecordId.getValue();
    }
    public void setReactionRecordId(Identifier reactionRecordId) {
        this.reactionRecordId.setValue(reactionRecordId);
    }


    /**
     * <p>Diagnosis Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getDiagnosisType() {
        return (ActCode) this.diagnosisType.getValue();
    }
    public void setDiagnosisType(ActCode diagnosisType) {
        this.diagnosisType.setValue(diagnosisType);
    }


    /**
     * <p>F:Reaction Onset Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getReactionOnsetDate() {
        return this.reactionOnsetDate.getValue();
    }
    public void setReactionOnsetDate(Interval<Date> reactionOnsetDate) {
        this.reactionOnsetDate.setValue(reactionOnsetDate);
    }


    /**
     * <p>B:Reaction</p>
     */
    @Hl7XmlMapping({"value"})
    public SubjectReaction getReaction() {
        return (SubjectReaction) this.reaction.getValue();
    }
    public void setReaction(SubjectReaction reaction) {
        this.reaction.setValue(reaction);
    }


    @Hl7XmlMapping({"subjectOf1/severityObservation"})
    public AllergyIntoleranceSeverityLevelBean getSubjectOf1SeverityObservation() {
        return this.subjectOf1SeverityObservation;
    }
    public void setSubjectOf1SeverityObservation(AllergyIntoleranceSeverityLevelBean subjectOf1SeverityObservation) {
        this.subjectOf1SeverityObservation = subjectOf1SeverityObservation;
    }


    /**
     * <p>G:Description</p>
     */
    @Hl7XmlMapping({"text"})
    public String getDescription() {
        return this.description.getValue();
    }
    public void setDescription(String description) {
        this.description.setValue(description);
    }


    @Hl7XmlMapping({"informant"})
    public ReportedByBean getInformant() {
        return this.informant;
    }
    public void setInformant(ReportedByBean informant) {
        this.informant = informant;
    }

}
