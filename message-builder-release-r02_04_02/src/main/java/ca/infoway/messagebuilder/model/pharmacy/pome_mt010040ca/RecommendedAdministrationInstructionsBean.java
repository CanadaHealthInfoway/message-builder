/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt270010ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.merged.AssignedEntity4_1Bean;
import ca.infoway.messagebuilder.model.merged.BecauseOfBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Recommended Administration Instructions</p>
 * 
 * <p>This comprises the route of administration, 
 * maximum/minimum daily dose, and overall use instructions for 
 * the drug.</p>
 * 
 * <p>Gives guidance to prescribers on how the drug might 
 * be/should be used</p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.AdministrationGuideline"})
public class RecommendedAdministrationInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private List<AdministrationInstructionsBean> optionDosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private List<PatientCharacteristicsBean> preconditionObservationEventCriterion = new ArrayList<PatientCharacteristicsBean>();
    private PatientBean subjectPatient;
    private AssignedEntity4_1Bean authorAssignedEntity;

    @Hl7XmlMapping({"option/dosageInstruction"})
    public List<AdministrationInstructionsBean> getOptionDosageInstruction() {
        return this.optionDosageInstruction;
    }

    @Hl7XmlMapping({"reason"})
    public List<BecauseOfBean> getReason() {
        return this.reason;
    }

    @Hl7XmlMapping({"precondition/observationEventCriterion"})
    public List<PatientCharacteristicsBean> getPreconditionObservationEventCriterion() {
        return this.preconditionObservationEventCriterion;
    }

    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }

    @Hl7XmlMapping({"author/assignedEntity"})
    public AssignedEntity4_1Bean getAuthorAssignedEntity() {
        return this.authorAssignedEntity;
    }
    public void setAuthorAssignedEntity(AssignedEntity4_1Bean authorAssignedEntity) {
        this.authorAssignedEntity = authorAssignedEntity;
    }

}
