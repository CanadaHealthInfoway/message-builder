/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.lab.polb_mt001999ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.merged.LabInitiatedOrderIndicatorBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.merged.OrderSortKeyBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.merged.ParentTestBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.merged.PriorTestRequestBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.merged.RecipientChoice;
import ca.infoway.messagebuilder.model.r02_04_02.lab.merged.ReferralRedirectIndicatorBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.polb_mt004000ca.BatteryEventBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.polb_mt004000ca.ObservationReportBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.polb_mt004000ca.ResultChoice;
import ca.infoway.messagebuilder.model.r02_04_02.lab.polb_mt004000ca.ResultObservationBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.polb_mt004100ca.ReportHeaderBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.polb_mt004200ca.DiagnosisOrInterpretationObservationBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.polb_mt004200ca.ObservationChoice;
import ca.infoway.messagebuilder.model.r02_04_02.merged.IncludesBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.SpecimenRoleBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"POLB_MT001999CA.RequestChoice"})
@Hl7RootType
public interface RequestChoice extends ca.infoway.messagebuilder.model.r02_04_02.iehr.comt_mt111111ca.Lab {

    public List<RecipientChoice> getInformationRecipientRecipientChoice();

    public List<HealthcareWorkerBean> getCallBackContactAssignedEntity();

    public PriorTestRequestBean getComponentOfPriorActRequest();
    public void setComponentOfPriorActRequest(PriorTestRequestBean componentOfPriorActRequest);

    public OutbreakBean getPertinentInformation1OutbreakEvent();
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent);

    public List<RequestChoice> getComponent4RequestChoice();

    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent();

    public ReferralRedirectIndicatorBean getComponent1ReferralRedirectIndicator();
    public void setComponent1ReferralRedirectIndicator(ReferralRedirectIndicatorBean component1ReferralRedirectIndicator);

    public LabInitiatedOrderIndicatorBean getComponent3LabInitiatedOrderIndicator();
    public void setComponent3LabInitiatedOrderIndicator(LabInitiatedOrderIndicatorBean component3LabInitiatedOrderIndicator);

    public List<IncludesBean> getSubjectOf1();

    public Patient_1Bean getRecordTargetPatient();
    public void setRecordTargetPatient(Patient_1Bean recordTargetPatient);

    public OrderSortKeyBean getComponent2RequestSortKey();
    public void setComponent2RequestSortKey(OrderSortKeyBean component2RequestSortKey);

    public List<ca.infoway.messagebuilder.model.r02_04_02.lab.polb_mt001999ca.ResultChoice> getFulfillmentResultChoice1();

    public HealthcareOrganizationBean getPerformerAssignedEntity();
    public void setPerformerAssignedEntity(HealthcareOrganizationBean performerAssignedEntity);

    public VersionInformationBean getSubjectOf2ControlActEvent();
    public void setSubjectOf2ControlActEvent(VersionInformationBean subjectOf2ControlActEvent);

    public ParentTestBean getOccurrenceOfActParentPointer();
    public void setOccurrenceOfActParentPointer(ParentTestBean occurrenceOfActParentPointer);

    public List<SpecimenRoleBean> getSpecimenSpecimen();

    public List<HealthcareWorkerBean> getVerifierAssignedEntity();

}
