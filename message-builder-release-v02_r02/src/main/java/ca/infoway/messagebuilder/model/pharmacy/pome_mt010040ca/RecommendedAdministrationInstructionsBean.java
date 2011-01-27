/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt120402ca.DiagnosisIndicationsBean;
import ca.infoway.messagebuilder.model.common.coct_mt120402ca.Indications;
import ca.infoway.messagebuilder.model.common.coct_mt120402ca.OtherIndicationsBean;
import ca.infoway.messagebuilder.model.common.coct_mt270010ca.AdministrationInstructionsBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Recommended Administration Instructions</p>
 * 
 * <p><p>This comprises the route of administration, 
 * maximum/minimum daily dose, and overall use instructions for 
 * the drug.</p></p>
 * 
 * <p><p>Gives guidance to prescribers on how the drug might 
 * be/should be used</p></p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.AdministrationGuideline"})
public class RecommendedAdministrationInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private PatientBean subjectPatient;
    private List<PatientCharacteristicsBean> preconditionObservationEventCriterion = new ArrayList<PatientCharacteristicsBean>();
    private List<AdministrationInstructionsBean> optionDosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private ST recommendingAuthorityName = new STImpl();
    private List<Indications> reasonIndications = new ArrayList<Indications>();


    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"precondition/observationEventCriterion"})
    public List<PatientCharacteristicsBean> getPreconditionObservationEventCriterion() {
        return this.preconditionObservationEventCriterion;
    }


    @Hl7XmlMapping({"option/dosageInstruction"})
    public List<AdministrationInstructionsBean> getOptionDosageInstruction() {
        return this.optionDosageInstruction;
    }


    /**
     * <p>Recommending Authority Name</p>
     * 
     * <p><p>Indicates the name of the organization or agency that 
     * created the dosage recommendation</p></p>
     * 
     * <p><p>The source of a recommendation may influence 
     * prescriber's willingness to use the recommended dose and is 
     * therefore mandatory</p></p>
     */
    @Hl7XmlMapping({"author/assignedEntity/assignedOrganization/name"})
    public String getRecommendingAuthorityName() {
        return this.recommendingAuthorityName.getValue();
    }
    public void setRecommendingAuthorityName(String recommendingAuthorityName) {
        this.recommendingAuthorityName.setValue(recommendingAuthorityName);
    }


    @Hl7XmlMapping({"reason/indications"})
    public List<Indications> getReasonIndications() {
        return this.reasonIndications;
    }

}
