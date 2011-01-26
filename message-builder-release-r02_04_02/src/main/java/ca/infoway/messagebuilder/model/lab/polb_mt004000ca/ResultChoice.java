/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.lab.polb_mt004000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.common.coct_mt090502ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.common.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.lab.merged.FulfillmentChoice;
import ca.infoway.messagebuilder.model.lab.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.lab.merged.RecipientChoice;
import ca.infoway.messagebuilder.model.lab.merged.ReportSectionSpecimenBean;
import ca.infoway.messagebuilder.model.lab.merged.ReportableHealthIndicatorBean;
import ca.infoway.messagebuilder.model.lab.merged.ResultSortKeyBean;
import ca.infoway.messagebuilder.model.lab.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.lab.polb_mt001001ca.BatteryOrPanelBean;
import ca.infoway.messagebuilder.model.lab.polb_mt001001ca.ObservationRequestBean;
import ca.infoway.messagebuilder.model.lab.polb_mt001001ca.PlacerGroupBean;
import ca.infoway.messagebuilder.model.lab.polb_mt001001ca.RequestChoice;
import ca.infoway.messagebuilder.model.merged.IncludesBean;
import ca.infoway.messagebuilder.model.merged.RoleChoice;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"POLB_MT004000CA.ResultChoice"})
@Hl7RootType
public interface ResultChoice extends ca.infoway.messagebuilder.model.lab.polb_mt004999ca.ResultInstancePayloadChoice, ca.infoway.messagebuilder.model.lab.polb_mt001999ca.ResultChoice {

    public List<RoleChoice> getReceiverRoleChoice();

    public RecipientChoice getPrimaryInformationRecipientRecipientChoice();
    public void setPrimaryInformationRecipientRecipientChoice(RecipientChoice primaryInformationRecipientRecipientChoice);

    public List<RoleChoice> getPerformerRoleChoice();

    public List<FulfillmentChoice> getInFulfillmentOfFulfillmentChoice();

    public OutbreakBean getPertinentInformation1OutbreakEvent();
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent);

    public List<ResultChoice> getComponent3ResultChoice();

    public List<ReportSectionSpecimenBean> getSpecimen();

    public VersionInformationBean getSubjectOf1ControlActEvent();
    public void setSubjectOf1ControlActEvent(VersionInformationBean subjectOf1ControlActEvent);

    public ResultStatusProcessStepBean getSubjectOf3ResultStatusProcessStep();
    public void setSubjectOf3ResultStatusProcessStep(ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep);

    public Patient_1Bean getRecordTargetPatient();
    public void setRecordTargetPatient(Patient_1Bean recordTargetPatient);

    public List<IncludesBean> getSubjectOf2();

    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent();

    public List<ReportableHealthIndicatorBean> getComponent2ReportableTestIndicator();

    public ResultSortKeyBean getComponent1ResultSortKey();
    public void setComponent1ResultSortKey(ResultSortKeyBean component1ResultSortKey);

}
