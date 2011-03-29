/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r01.common.coct_mt120402ca.DiagnosisIndicationsBean;
import ca.infoway.messagebuilder.model.v02_r01.common.coct_mt120402ca.Indications;
import ca.infoway.messagebuilder.model.v02_r01.common.coct_mt120402ca.OtherIndicationsBean;
import ca.infoway.messagebuilder.model.v02_r01.common.coct_mt270010ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.HealthcareWorkerBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"POME_MT010040CA.AdministrationGuideline"})
public class RecommendedAdministrationInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private PatientBean subjectPatient;
    private List<Indications> reasonIndications = new ArrayList<Indications>();
    private List<AdministrationInstructionsBean> optionDosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private HealthcareWorkerBean authorAssignedEntity;
    private List<PatientCharacteristicsBean> preconditionObservationEventCriterion = new ArrayList<PatientCharacteristicsBean>();


    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"reason/indications"})
    public List<Indications> getReasonIndications() {
        return this.reasonIndications;
    }


    @Hl7XmlMapping({"option/dosageInstruction"})
    public List<AdministrationInstructionsBean> getOptionDosageInstruction() {
        return this.optionDosageInstruction;
    }


    @Hl7XmlMapping({"author/assignedEntity"})
    public HealthcareWorkerBean getAuthorAssignedEntity() {
        return this.authorAssignedEntity;
    }
    public void setAuthorAssignedEntity(HealthcareWorkerBean authorAssignedEntity) {
        this.authorAssignedEntity = authorAssignedEntity;
    }


    @Hl7XmlMapping({"precondition/observationEventCriterion"})
    public List<PatientCharacteristicsBean> getPreconditionObservationEventCriterion() {
        return this.preconditionObservationEventCriterion;
    }

}