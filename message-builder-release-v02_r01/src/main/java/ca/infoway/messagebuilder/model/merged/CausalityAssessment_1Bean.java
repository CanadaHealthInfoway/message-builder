/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
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
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ExposureAgentEntityType;
import ca.infoway.messagebuilder.domainvalue.ObservationValue;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.iehr.repc_mt000005ca.RecordsBean;
import java.util.Date;



@Hl7PartTypeMapping({"REPC_MT000001CA.CausalityAssessment","REPC_MT000002CA.CausalityAssessment","REPC_MT000005CA.CausalityAssessment","REPC_MT000006CA.CausalityAssessment","REPC_MT000013CA.CausalityAssessment"})
public class CausalityAssessment_1Bean extends MessagePartBean implements ca.infoway.messagebuilder.model.merged.RecordsBean, RecordsBean {

    private static final long serialVersionUID = 20100615L;
    private CD assessmentType = new CDImpl();
    private CV relatednessAssessment = new CVImpl();
    private II incidenceIdentifier = new IIImpl();
    private CV exposureMethod = new CVImpl();
    private CV exposedMaterialType = new CVImpl();
    private ST exposedMaterialName = new STImpl();
    private II reactionRecordId = new IIImpl();
    private CD diagnosisType = new CDImpl();
    private BL noReactionOccurred = new BLImpl();
    private ST description = new STImpl();
    private IVL<TS, Interval<Date>> reactionOnsetDate = new IVLImpl<TS, Interval<Date>>();
    private CV reaction = new CVImpl();
    private AllergyIntoleranceSeverityLevelBean subjectObservationEventSubjectOfSeverityObservation;

    @Hl7XmlMapping({"code"})
    public ActCode getAssessmentType() {
        return (ActCode) this.assessmentType.getValue();
    }
    public void setAssessmentType(ActCode assessmentType) {
        this.assessmentType.setValue(assessmentType);
    }

    @Hl7XmlMapping({"value"})
    public ObservationValue getRelatednessAssessment() {
        return (ObservationValue) this.relatednessAssessment.getValue();
    }
    public void setRelatednessAssessment(ObservationValue relatednessAssessment) {
        this.relatednessAssessment.setValue(relatednessAssessment);
    }

    @Hl7XmlMapping({"startsAfterStartOf/exposureEvent/id"})
    public Identifier getIncidenceIdentifier() {
        return this.incidenceIdentifier.getValue();
    }
    public void setIncidenceIdentifier(Identifier incidenceIdentifier) {
        this.incidenceIdentifier.setValue(incidenceIdentifier);
    }

    @Hl7XmlMapping({"startsAfterStartOf/exposureEvent/routeCode"})
    public RouteOfAdministration getExposureMethod() {
        return (RouteOfAdministration) this.exposureMethod.getValue();
    }
    public void setExposureMethod(RouteOfAdministration exposureMethod) {
        this.exposureMethod.setValue(exposureMethod);
    }

    @Hl7XmlMapping({"startsAfterStartOf/exposureEvent/consumable/administrableMaterial/administerableMaterialKind/code"})
    public ExposureAgentEntityType getExposedMaterialType() {
        return (ExposureAgentEntityType) this.exposedMaterialType.getValue();
    }
    public void setExposedMaterialType(ExposureAgentEntityType exposedMaterialType) {
        this.exposedMaterialType.setValue(exposedMaterialType);
    }

    @Hl7XmlMapping({"startsAfterStartOf/exposureEvent/consumable/administrableMaterial/administerableMaterialKind/name"})
    public String getExposedMaterialName() {
        return this.exposedMaterialName.getValue();
    }
    public void setExposedMaterialName(String exposedMaterialName) {
        this.exposedMaterialName.setValue(exposedMaterialName);
    }

    @Hl7XmlMapping({"subject/observationEvent/id"})
    public Identifier getReactionRecordId() {
        return this.reactionRecordId.getValue();
    }
    public void setReactionRecordId(Identifier reactionRecordId) {
        this.reactionRecordId.setValue(reactionRecordId);
    }

    @Hl7XmlMapping({"subject/observationEvent/code"})
    public ActCode getDiagnosisType() {
        return (ActCode) this.diagnosisType.getValue();
    }
    public void setDiagnosisType(ActCode diagnosisType) {
        this.diagnosisType.setValue(diagnosisType);
    }

    @Hl7XmlMapping({"subject/observationEvent/negationInd"})
    public Boolean getNoReactionOccurred() {
        return this.noReactionOccurred.getValue();
    }
    public void setNoReactionOccurred(Boolean noReactionOccurred) {
        this.noReactionOccurred.setValue(noReactionOccurred);
    }

    @Hl7XmlMapping({"subject/observationEvent/text"})
    public String getDescription() {
        return this.description.getValue();
    }
    public void setDescription(String description) {
        this.description.setValue(description);
    }

    @Hl7XmlMapping({"subject/observationEvent/effectiveTime"})
    public Interval<Date> getReactionOnsetDate() {
        return this.reactionOnsetDate.getValue();
    }
    public void setReactionOnsetDate(Interval<Date> reactionOnsetDate) {
        this.reactionOnsetDate.setValue(reactionOnsetDate);
    }

    @Hl7XmlMapping({"subject/observationEvent/value"})
    public SubjectReaction getReaction() {
        return (SubjectReaction) this.reaction.getValue();
    }
    public void setReaction(SubjectReaction reaction) {
        this.reaction.setValue(reaction);
    }

    @Hl7XmlMapping({"subject/observationEvent/subjectOf/severityObservation"})
    public AllergyIntoleranceSeverityLevelBean getSubjectObservationEventSubjectOfSeverityObservation() {
        return this.subjectObservationEventSubjectOfSeverityObservation;
    }
    public void setSubjectObservationEventSubjectOfSeverityObservation(AllergyIntoleranceSeverityLevelBean subjectObservationEventSubjectOfSeverityObservation) {
        this.subjectObservationEventSubjectOfSeverityObservation = subjectObservationEventSubjectOfSeverityObservation;
    }

}
