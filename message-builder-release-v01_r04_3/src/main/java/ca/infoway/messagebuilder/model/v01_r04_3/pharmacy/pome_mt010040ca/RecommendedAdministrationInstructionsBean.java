/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.porx_mt980040ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.porx_mt980050ca.DiagnosisIndicationsBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.porx_mt980050ca.Indications;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.porx_mt980050ca.OtherIndicationsBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.porx_mt980050ca.SymptomIndicationsBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"POME_MT010040CA.AdministrationGuideline"})
public class RecommendedAdministrationInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private ST recommendingAuthorityName = new STImpl();
    private List<Indications> reasonIndications = new ArrayList<Indications>();
    private List<AdministrationInstructionsBean> optionDosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private List<PatientCharacteristicsBean> preconditionObservationEventCriterion = new ArrayList<PatientCharacteristicsBean>();
    private PatientBean subjectPatient;


    /**
     * <p>Recommending Authority Name</p>
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


    @Hl7XmlMapping({"option/dosageInstruction"})
    public List<AdministrationInstructionsBean> getOptionDosageInstruction() {
        return this.optionDosageInstruction;
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

}