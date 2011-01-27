/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.lab.polb_mt001000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.common.coct_mt090502ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.common.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.lab.merged.LabInitiatedOrderIndicatorBean;
import ca.infoway.messagebuilder.model.lab.merged.OrderSortKeyBean;
import ca.infoway.messagebuilder.model.lab.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.lab.merged.ParentTestBean;
import ca.infoway.messagebuilder.model.lab.merged.PriorTestRequestBean;
import ca.infoway.messagebuilder.model.lab.merged.RecipientChoice;
import ca.infoway.messagebuilder.model.lab.merged.ReferralRedirectIndicatorBean;
import ca.infoway.messagebuilder.model.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.merged.IncludesBean;
import ca.infoway.messagebuilder.model.merged.SpecimenRoleBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"POLB_MT001000CA.RequestChoice"})
@Hl7RootType
public interface RequestChoice {

    public Patient_1Bean getRecordTargetPatient();
    public void setRecordTargetPatient(Patient_1Bean recordTargetPatient);

    public List<IncludesBean> getSubjectOf();

    public ca.infoway.messagebuilder.model.common.coct_mt090508ca.HealthcareOrganizationBean getPerformerAssignedEntity();
    public void setPerformerAssignedEntity(ca.infoway.messagebuilder.model.common.coct_mt090508ca.HealthcareOrganizationBean performerAssignedEntity);

    public List<SpecimenRoleBean> getSpecimenSpecimen();

    public ParentTestBean getOccurrenceOfActParentPointer();
    public void setOccurrenceOfActParentPointer(ParentTestBean occurrenceOfActParentPointer);

    public List<HealthcareWorkerBean> getVerifierAssignedEntity();

    public List<RequestChoice> getComponent4RequestChoice();

    public OutbreakBean getPertinentInformation1OutbreakEvent();
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent);

    public List<RecipientChoice> getInformationRecipientRecipientChoice();

    public OrderSortKeyBean getComponent2RequestSortKey();
    public void setComponent2RequestSortKey(OrderSortKeyBean component2RequestSortKey);

    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent();

    public ReferralRedirectIndicatorBean getComponent1ReferralRedirectIndicator();
    public void setComponent1ReferralRedirectIndicator(ReferralRedirectIndicatorBean component1ReferralRedirectIndicator);

    public LabInitiatedOrderIndicatorBean getComponent3LabInitiatedOrderIndicator();
    public void setComponent3LabInitiatedOrderIndicator(LabInitiatedOrderIndicatorBean component3LabInitiatedOrderIndicator);

    public PriorTestRequestBean getComponentOfPriorActRequest();
    public void setComponentOfPriorActRequest(PriorTestRequestBean componentOfPriorActRequest);

    public List<HealthcareWorkerBean> getCallBackContactAssignedEntity();

}
