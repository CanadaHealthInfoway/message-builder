/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.lab.polb_mt001000ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActPriority;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ObservationOrderableLabType;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
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
import ca.infoway.messagebuilder.model.merged.SupportingClinicalInformationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"POLB_MT001000CA.ObservationRequest"})
public class ObservationRequestBean extends MessagePartBean implements RequestChoiceBean {

    private static final long serialVersionUID = 20100603L;
    private List<ReportSectionSpecimenBean> specimen = new ArrayList<ReportSectionSpecimenBean>();
    private PatientBean recordTargetPatient;
    private II testIdentifier = new IIImpl();
    private HealthcareOrganizationBean performerAssignedEntity;
    private CD testCode = new CDImpl();
    private List<HealthcareWorkerBean> callBackContactAssignedEntity = new ArrayList<HealthcareWorkerBean>();
    private CS testStatus = new CSImpl();
    private List<RecipientChoiceBean> informationRecipientRecipientChoice = new ArrayList<RecipientChoiceBean>();
    private LIST<GTS, GeneralTimingSpecification> testRequestTimeSpecification = new LISTImpl<GTS, GeneralTimingSpecification>(GTSImpl.class);
    private List<AssignedEntity_1Bean> verifierAssignedEntity = new ArrayList<AssignedEntity_1Bean>();
    private TS testRequestAvailabilityTime = new TSImpl();
    private ParentTestBean occurrenceOfActParentPointer;
    private CV testPriorityCode = new CVImpl();
    private OutbreakBean pertinentInformation1OutbreakEvent;
    private SET<CV, Code> testMaskingIndicator = new SETImpl<CV, Code>(CVImpl.class);
    private List<SupportingClinicalInformationBean> pertinentInformation2SupportingClinicalObservationEvent = new ArrayList<SupportingClinicalInformationBean>();
    private ReferralRedirectIndicatorBean component1ReferralRedirectIndicator;
    private OrderSortKeyBean component2RequestSortKey;
    private LabInitiatedOrderIndicatorBean component3LabInitiatedOrderIndicator;
    private List<RequestChoiceBean> component4RequestChoice = new ArrayList<RequestChoiceBean>();
    private List<HasNotesBean> subjectOf = new ArrayList<HasNotesBean>();
    private PriorTestRequestBean componentOfPriorActRequest;

    @Hl7XmlMapping({"specimen"})
    public List<ReportSectionSpecimenBean> getSpecimen() {
        return this.specimen;
    }

    @Hl7XmlMapping({"recordTarget/patient"})
    public PatientBean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }
    public void setRecordTargetPatient(PatientBean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }

    @Hl7XmlMapping({"id"})
    public Identifier getTestIdentifier() {
        return this.testIdentifier.getValue();
    }
    public void setTestIdentifier(Identifier testIdentifier) {
        this.testIdentifier.setValue(testIdentifier);
    }

    @Hl7XmlMapping({"performer/assignedEntity"})
    public HealthcareOrganizationBean getPerformerAssignedEntity() {
        return this.performerAssignedEntity;
    }
    public void setPerformerAssignedEntity(HealthcareOrganizationBean performerAssignedEntity) {
        this.performerAssignedEntity = performerAssignedEntity;
    }

    @Hl7XmlMapping({"code"})
    public ObservationOrderableLabType getTestCode() {
        return (ObservationOrderableLabType) this.testCode.getValue();
    }
    public void setTestCode(ObservationOrderableLabType testCode) {
        this.testCode.setValue(testCode);
    }

    @Hl7XmlMapping({"callBackContact/assignedEntity"})
    public List<HealthcareWorkerBean> getCallBackContactAssignedEntity() {
        return this.callBackContactAssignedEntity;
    }

    @Hl7XmlMapping({"statusCode"})
    public ActStatus getTestStatus() {
        return (ActStatus) this.testStatus.getValue();
    }
    public void setTestStatus(ActStatus testStatus) {
        this.testStatus.setValue(testStatus);
    }

    @Hl7XmlMapping({"informationRecipient/recipientChoice"})
    public List<RecipientChoiceBean> getInformationRecipientRecipientChoice() {
        return this.informationRecipientRecipientChoice;
    }

    @Hl7XmlMapping({"effectiveTime"})
    public List<GeneralTimingSpecification> getTestRequestTimeSpecification() {
        return this.testRequestTimeSpecification.rawList();
    }

    @Hl7XmlMapping({"verifier/assignedEntity"})
    public List<AssignedEntity_1Bean> getVerifierAssignedEntity() {
        return this.verifierAssignedEntity;
    }

    @Hl7XmlMapping({"availabilityTime"})
    public Date getTestRequestAvailabilityTime() {
        return this.testRequestAvailabilityTime.getValue();
    }
    public void setTestRequestAvailabilityTime(Date testRequestAvailabilityTime) {
        this.testRequestAvailabilityTime.setValue(testRequestAvailabilityTime);
    }

    @Hl7XmlMapping({"occurrenceOf/actParentPointer"})
    public ParentTestBean getOccurrenceOfActParentPointer() {
        return this.occurrenceOfActParentPointer;
    }
    public void setOccurrenceOfActParentPointer(ParentTestBean occurrenceOfActParentPointer) {
        this.occurrenceOfActParentPointer = occurrenceOfActParentPointer;
    }

    @Hl7XmlMapping({"priorityCode"})
    public ActPriority getTestPriorityCode() {
        return (ActPriority) this.testPriorityCode.getValue();
    }
    public void setTestPriorityCode(ActPriority testPriorityCode) {
        this.testPriorityCode.setValue(testPriorityCode);
    }

    @Hl7XmlMapping({"pertinentInformation1/outbreakEvent"})
    public OutbreakBean getPertinentInformation1OutbreakEvent() {
        return this.pertinentInformation1OutbreakEvent;
    }
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent) {
        this.pertinentInformation1OutbreakEvent = pertinentInformation1OutbreakEvent;
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getTestMaskingIndicator() {
        return this.testMaskingIndicator.rawSet(x_BasicConfidentialityKind.class);
    }

    @Hl7XmlMapping({"pertinentInformation2/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent() {
        return this.pertinentInformation2SupportingClinicalObservationEvent;
    }

    @Hl7XmlMapping({"component1/referralRedirectIndicator"})
    public ReferralRedirectIndicatorBean getComponent1ReferralRedirectIndicator() {
        return this.component1ReferralRedirectIndicator;
    }
    public void setComponent1ReferralRedirectIndicator(ReferralRedirectIndicatorBean component1ReferralRedirectIndicator) {
        this.component1ReferralRedirectIndicator = component1ReferralRedirectIndicator;
    }

    @Hl7XmlMapping({"component2/requestSortKey"})
    public OrderSortKeyBean getComponent2RequestSortKey() {
        return this.component2RequestSortKey;
    }
    public void setComponent2RequestSortKey(OrderSortKeyBean component2RequestSortKey) {
        this.component2RequestSortKey = component2RequestSortKey;
    }

    @Hl7XmlMapping({"component3/labInitiatedOrderIndicator"})
    public LabInitiatedOrderIndicatorBean getComponent3LabInitiatedOrderIndicator() {
        return this.component3LabInitiatedOrderIndicator;
    }
    public void setComponent3LabInitiatedOrderIndicator(LabInitiatedOrderIndicatorBean component3LabInitiatedOrderIndicator) {
        this.component3LabInitiatedOrderIndicator = component3LabInitiatedOrderIndicator;
    }

    @Hl7XmlMapping({"component4/requestChoice"})
    public List<RequestChoiceBean> getComponent4RequestChoice() {
        return this.component4RequestChoice;
    }

    @Hl7XmlMapping({"subjectOf"})
    public List<HasNotesBean> getSubjectOf() {
        return this.subjectOf;
    }

    @Hl7XmlMapping({"componentOf/priorActRequest"})
    public PriorTestRequestBean getComponentOfPriorActRequest() {
        return this.componentOfPriorActRequest;
    }
    public void setComponentOfPriorActRequest(PriorTestRequestBean componentOfPriorActRequest) {
        this.componentOfPriorActRequest = componentOfPriorActRequest;
    }

}
