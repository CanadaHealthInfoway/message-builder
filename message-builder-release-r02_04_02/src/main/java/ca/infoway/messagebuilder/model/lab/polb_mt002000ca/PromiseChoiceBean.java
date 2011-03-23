/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.lab.polb_mt002000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.common.coct_mt050007ca.PatientBean;
import ca.infoway.messagebuilder.model.common.coct_mt090502ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.merged.HasNotesBean;
import ca.infoway.messagebuilder.model.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.merged.ReportSectionSpecimenBean;
import ca.infoway.messagebuilder.model.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.merged.SubjectToTriggerEventBean;
import ca.infoway.messagebuilder.model.merged.SupportingClinicalInformationBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"POLB_MT002000CA.PromiseChoice"})
@Hl7RootType
public interface PromiseChoiceBean {

    public ReportSectionSpecimenBean getSpecimen();
    public void setSpecimen(ReportSectionSpecimenBean specimen);

    public PatientBean getRecordTargetPatient();
    public void setRecordTargetPatient(PatientBean recordTargetPatient);

    public List<RoleChoiceBean> getReceiverRoleChoice();

    public List<RoleChoiceBean> getPerformerRoleChoice();

    public HealthcareOrganizationBean getPrimaryInformationRecipientAssignedEntity();
    public void setPrimaryInformationRecipientAssignedEntity(HealthcareOrganizationBean primaryInformationRecipientAssignedEntity);

    public List<FulfillmentChoiceBean> getInFulfillmentOfFulfillmentChoice();

    public OutbreakBean getPertinentInformation1OutbreakEvent();
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent);

    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent();

    public List<PromiseChoiceBean> getComponentPromiseChoice();

    public SubjectToTriggerEventBean getSubjectOf1();
    public void setSubjectOf1(SubjectToTriggerEventBean subjectOf1);

    public List<HasNotesBean> getSubjectOf2();

    public ResultStatusProcessStepBean getSubjectOf3ResultStatusProcessStep();
    public void setSubjectOf3ResultStatusProcessStep(ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep);

}
