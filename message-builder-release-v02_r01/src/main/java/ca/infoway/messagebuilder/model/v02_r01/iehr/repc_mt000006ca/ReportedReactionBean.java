/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.iehr.repc_mt000006ca;

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
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r01.common.coct_mt011001ca.CareCompositionsBean;
import ca.infoway.messagebuilder.model.v02_r01.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.v02_r01.iehr.merged.ReportedByBean;
import ca.infoway.messagebuilder.model.v02_r01.iehr.merged.ReportedReactionsBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.AllergyIntoleranceSeverityLevelBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.RefusedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"REPC_MT000006CA.ReactionObservationEvent"})
@Hl7RootType
public class ReportedReactionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private IVL<TS, Interval<Date>> reactionOnsetDate = new IVLImpl<TS, Interval<Date>>();
    private List<NotesBean> subjectOf1Annotation = new ArrayList<NotesBean>();
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();
    private List<ReportedReactionsBean> subjectOf3CausalityAssessment = new ArrayList<ReportedReactionsBean>();
    private CV reaction = new CVImpl();
    private II reactionRecordId = new IIImpl();
    private RefusedByBean author;
    private CD diagnosisType = new CDImpl();
    private SET<CV, Code> adverseReactionMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private ST description = new STImpl();
    private BL subjectOf2AnnotationIndicator = new BLImpl();
    private CreatedAtBean location;
    private AllergyIntoleranceSeverityLevelBean subjectOf4SeverityObservation;
    private ReportedByBean informant;


    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
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


    @Hl7XmlMapping({"subjectOf1/annotation"})
    public List<NotesBean> getSubjectOf1Annotation() {
        return this.subjectOf1Annotation;
    }


    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }


    @Hl7XmlMapping({"subjectOf3/causalityAssessment"})
    public List<ReportedReactionsBean> getSubjectOf3CausalityAssessment() {
        return this.subjectOf3CausalityAssessment;
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


    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RefusedByBean author) {
        this.author = author;
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
     * <p>G:Adverse Reaction Masking Indicators</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getAdverseReactionMaskingIndicators() {
        return this.adverseReactionMaskingIndicators.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
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


    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"subjectOf4/severityObservation"})
    public AllergyIntoleranceSeverityLevelBean getSubjectOf4SeverityObservation() {
        return this.subjectOf4SeverityObservation;
    }
    public void setSubjectOf4SeverityObservation(AllergyIntoleranceSeverityLevelBean subjectOf4SeverityObservation) {
        this.subjectOf4SeverityObservation = subjectOf4SeverityObservation;
    }


    @Hl7XmlMapping({"informant"})
    public ReportedByBean getInformant() {
        return this.informant;
    }
    public void setInformant(ReportedByBean informant) {
        this.informant = informant;
    }

}
