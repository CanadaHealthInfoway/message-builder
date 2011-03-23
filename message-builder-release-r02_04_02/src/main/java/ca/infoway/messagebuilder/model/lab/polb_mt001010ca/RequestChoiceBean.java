/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.lab.polb_mt001010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.common.coct_mt050007ca.PatientBean;
import ca.infoway.messagebuilder.model.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.merged.AssignedEntity_1Bean;
import ca.infoway.messagebuilder.model.merged.HasNotesBean;
import ca.infoway.messagebuilder.model.merged.LabInitiatedOrderIndicatorBean;
import ca.infoway.messagebuilder.model.merged.OrderSortKeyBean;
import ca.infoway.messagebuilder.model.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.merged.ParentTestBean;
import ca.infoway.messagebuilder.model.merged.PriorTestRequestBean;
import ca.infoway.messagebuilder.model.merged.RecipientChoiceBean;
import ca.infoway.messagebuilder.model.merged.ReferralRedirectIndicatorBean;
import ca.infoway.messagebuilder.model.merged.ReportSectionSpecimenBean;
import ca.infoway.messagebuilder.model.merged.SubjectToTriggerEventBean;
import ca.infoway.messagebuilder.model.merged.SupportingClinicalInformationBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"POLB_MT001010CA.RequestChoice"})
@Hl7RootType
public interface RequestChoiceBean {

    public List<ReportSectionSpecimenBean> getSpecimen();

    public PatientBean getRecordTargetPatient();
    public void setRecordTargetPatient(PatientBean recordTargetPatient);

    public HealthcareOrganizationBean getPerformerAssignedEntity();
    public void setPerformerAssignedEntity(HealthcareOrganizationBean performerAssignedEntity);

    public List<HealthcareWorkerBean> getCallBackContactAssignedEntity();

    public List<RecipientChoiceBean> getInformationRecipientRecipientChoice();

    public List<AssignedEntity_1Bean> getVerifierAssignedEntity();

    public ParentTestBean getOccurrenceOfActParentPointer();
    public void setOccurrenceOfActParentPointer(ParentTestBean occurrenceOfActParentPointer);

    public OutbreakBean getPertinentInformation1OutbreakEvent();
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent);

    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent();

    public ReferralRedirectIndicatorBean getComponent1ReferralRedirectIndicator();
    public void setComponent1ReferralRedirectIndicator(ReferralRedirectIndicatorBean component1ReferralRedirectIndicator);

    public OrderSortKeyBean getComponent2RequestSortKey();
    public void setComponent2RequestSortKey(OrderSortKeyBean component2RequestSortKey);

    public LabInitiatedOrderIndicatorBean getComponent3LabInitiatedOrderIndicator();
    public void setComponent3LabInitiatedOrderIndicator(LabInitiatedOrderIndicatorBean component3LabInitiatedOrderIndicator);

    public List<RequestChoiceBean> getComponent4RequestChoice();

    public List<HasNotesBean> getSubjectOf1();

    public SubjectToTriggerEventBean getSubjectOf2();
    public void setSubjectOf2(SubjectToTriggerEventBean subjectOf2);

    public PriorTestRequestBean getComponentOfPriorActRequest();
    public void setComponentOfPriorActRequest(PriorTestRequestBean componentOfPriorActRequest);

}
