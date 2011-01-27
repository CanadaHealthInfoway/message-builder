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
import java.util.Date;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"POLB_MT001000CA.ObservationRequest"})
public class ObservationRequestBean extends MessagePartBean implements RequestChoice {

    private static final long serialVersionUID = 20110127L;
    private CS testStatus = new CSImpl();
    private Patient_1Bean recordTargetPatient;
    private CD testCode = new CDImpl();
    private List<IncludesBean> subjectOf = new ArrayList<IncludesBean>();
    private ca.infoway.messagebuilder.model.common.coct_mt090508ca.HealthcareOrganizationBean performerAssignedEntity;
    private SET<CV, Code> testMaskingIndicator = new SETImpl<CV, Code>(CVImpl.class);
    private List<SpecimenRoleBean> specimenSpecimen = new ArrayList<SpecimenRoleBean>();
    private ParentTestBean occurrenceOfActParentPointer;
    private List<HealthcareWorkerBean> verifierAssignedEntity = new ArrayList<HealthcareWorkerBean>();
    private List<RequestChoice> component4RequestChoice = new ArrayList<RequestChoice>();
    private OutbreakBean pertinentInformation1OutbreakEvent;
    private List<RecipientChoice> informationRecipientRecipientChoice = new ArrayList<RecipientChoice>();
    private II testIdentifier = new IIImpl();
    private OrderSortKeyBean component2RequestSortKey;
    private CV testPriorityCode = new CVImpl();
    private LabInitiatedOrderIndicatorBean component3LabInitiatedOrderIndicator;
    private ReferralRedirectIndicatorBean component1ReferralRedirectIndicator;
    private List<SupportingClinicalInformationBean> pertinentInformation2SupportingClinicalObservationEvent = new ArrayList<SupportingClinicalInformationBean>();
    private PriorTestRequestBean componentOfPriorActRequest;
    private LIST<GTS, GeneralTimingSpecification> testRequestTimeSpecification = new LISTImpl<GTS, GeneralTimingSpecification>(GTSImpl.class);
    private TS testRequestAvailabilityTime = new TSImpl();
    private List<HealthcareWorkerBean> callBackContactAssignedEntity = new ArrayList<HealthcareWorkerBean>();


    /**
     * <p>I:Test Status</p>
     * 
     * <p><p>The statusCode represents the &quot;state&quot; of the 
     * act e.g. active=in progress or not yet started, 
     * complete=resulted and/or result reported. It is up to the 
     * order placer to determine when, upon receipt of one or more 
     * results which fulfill this order, the order is complete.</p></p>
     * 
     * <p><p>The statusCode represents the &quot;state&quot; of the 
     * test e.g. active=in progress or not yet started, 
     * complete=resulted and/or reported.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getTestStatus() {
        return (ActStatus) this.testStatus.getValue();
    }
    public void setTestStatus(ActStatus testStatus) {
        this.testStatus.setValue(testStatus);
    }


    @Hl7XmlMapping({"recordTarget/patient"})
    public Patient_1Bean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }
    public void setRecordTargetPatient(Patient_1Bean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }


    /**
     * <p>G:Test Code</p>
     * 
     * <p><p>LOINC code for the ordered test The value set bound to 
     * this attribute is a list of LOINC codes pulled from the 
     * pan-Canadian Laboratory Observation Code Database (pCLOCD). 
     * Only those records flagged as orderable or &quot;both&quot; 
     * in the pCLOCD can be used.</p></p>
     * 
     * <p><p>Specifies the requested test to be performed.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationOrderableLabType getTestCode() {
        return (ObservationOrderableLabType) this.testCode.getValue();
    }
    public void setTestCode(ObservationOrderableLabType testCode) {
        this.testCode.setValue(testCode);
    }


    @Hl7XmlMapping({"subjectOf"})
    public List<IncludesBean> getSubjectOf() {
        return this.subjectOf;
    }


    @Hl7XmlMapping({"performer/assignedEntity"})
    public ca.infoway.messagebuilder.model.common.coct_mt090508ca.HealthcareOrganizationBean getPerformerAssignedEntity() {
        return this.performerAssignedEntity;
    }
    public void setPerformerAssignedEntity(ca.infoway.messagebuilder.model.common.coct_mt090508ca.HealthcareOrganizationBean performerAssignedEntity) {
        this.performerAssignedEntity = performerAssignedEntity;
    }


    /**
     * <p>K:Test Masking Indicator</p>
     * 
     * <p><p>Any piece of information is potentially subject to 
     * 'masking', restricting it's availability from providers who 
     * have not been specifically authorized. Additionally, some 
     * clinical data requires the ability to mark as &quot;not for 
     * direct disclosure to patient&quot;. The values in this 
     * attribute enable the above masking to be represented and 
     * messaged.</p></p>
     * 
     * <p><p>This code allows for privacy control by patients as 
     * well as flagged for 'not for disclosure to patient' by care 
     * providers.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getTestMaskingIndicator() {
        return this.testMaskingIndicator.rawSet(x_BasicConfidentialityKind.class);
    }


    @Hl7XmlMapping({"specimen/specimen"})
    public List<SpecimenRoleBean> getSpecimenSpecimen() {
        return this.specimenSpecimen;
    }


    @Hl7XmlMapping({"occurrenceOf/actParentPointer"})
    public ParentTestBean getOccurrenceOfActParentPointer() {
        return this.occurrenceOfActParentPointer;
    }
    public void setOccurrenceOfActParentPointer(ParentTestBean occurrenceOfActParentPointer) {
        this.occurrenceOfActParentPointer = occurrenceOfActParentPointer;
    }


    @Hl7XmlMapping({"verifier/assignedEntity"})
    public List<HealthcareWorkerBean> getVerifierAssignedEntity() {
        return this.verifierAssignedEntity;
    }


    @Hl7XmlMapping({"component4/requestChoice"})
    public List<RequestChoice> getComponent4RequestChoice() {
        return this.component4RequestChoice;
    }


    @Hl7XmlMapping({"pertinentInformation1/outbreakEvent"})
    public OutbreakBean getPertinentInformation1OutbreakEvent() {
        return this.pertinentInformation1OutbreakEvent;
    }
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent) {
        this.pertinentInformation1OutbreakEvent = pertinentInformation1OutbreakEvent;
    }


    @Hl7XmlMapping({"informationRecipient/recipientChoice"})
    public List<RecipientChoice> getInformationRecipientRecipientChoice() {
        return this.informationRecipientRecipientChoice;
    }


    /**
     * <p>F:Test Identifier</p>
     * 
     * <p><p>Must contain a value assigned by the order-placing 
     * organization that uniquely identifies this test request 
     * among all test requests in the receiving application.</p></p>
     * 
     * <p><p>Used to uniquely identify this test. Necessary for 
     * order revisions and cancellations.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getTestIdentifier() {
        return this.testIdentifier.getValue();
    }
    public void setTestIdentifier(Identifier testIdentifier) {
        this.testIdentifier.setValue(testIdentifier);
    }


    @Hl7XmlMapping({"component2/requestSortKey"})
    public OrderSortKeyBean getComponent2RequestSortKey() {
        return this.component2RequestSortKey;
    }
    public void setComponent2RequestSortKey(OrderSortKeyBean component2RequestSortKey) {
        this.component2RequestSortKey = component2RequestSortKey;
    }


    /**
     * <p>J:Test Priority Code</p>
     * 
     * <p><p>Priority code associated with a specific test.</p></p>
     * 
     * <p><p>Communicates requested test priority (e.g. routine, 
     * stat, etc.)</p></p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public ActPriority getTestPriorityCode() {
        return (ActPriority) this.testPriorityCode.getValue();
    }
    public void setTestPriorityCode(ActPriority testPriorityCode) {
        this.testPriorityCode.setValue(testPriorityCode);
    }


    @Hl7XmlMapping({"component3/labInitiatedOrderIndicator"})
    public LabInitiatedOrderIndicatorBean getComponent3LabInitiatedOrderIndicator() {
        return this.component3LabInitiatedOrderIndicator;
    }
    public void setComponent3LabInitiatedOrderIndicator(LabInitiatedOrderIndicatorBean component3LabInitiatedOrderIndicator) {
        this.component3LabInitiatedOrderIndicator = component3LabInitiatedOrderIndicator;
    }


    @Hl7XmlMapping({"component1/referralRedirectIndicator"})
    public ReferralRedirectIndicatorBean getComponent1ReferralRedirectIndicator() {
        return this.component1ReferralRedirectIndicator;
    }
    public void setComponent1ReferralRedirectIndicator(ReferralRedirectIndicatorBean component1ReferralRedirectIndicator) {
        this.component1ReferralRedirectIndicator = component1ReferralRedirectIndicator;
    }


    @Hl7XmlMapping({"pertinentInformation2/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent() {
        return this.pertinentInformation2SupportingClinicalObservationEvent;
    }


    @Hl7XmlMapping({"componentOf/priorActRequest"})
    public PriorTestRequestBean getComponentOfPriorActRequest() {
        return this.componentOfPriorActRequest;
    }
    public void setComponentOfPriorActRequest(PriorTestRequestBean componentOfPriorActRequest) {
        this.componentOfPriorActRequest = componentOfPriorActRequest;
    }


    /**
     * <p>H:Test Request Time Specification</p>
     * 
     * <p><p>The time specification for when this test is requested 
     * to be performed or occur or when the changes to the request 
     * took effect or are supposed to take effect. This time 
     * specification includes support for complex, repeating 
     * orders.</p></p>
     * 
     * <p><p>Would be used to communicate that an Order is for a 
     * future date.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public List<GeneralTimingSpecification> getTestRequestTimeSpecification() {
        return this.testRequestTimeSpecification.rawList();
    }


    /**
     * <p>L:Test Request Availability Time</p>
     * 
     * <p><p>The date/time when this order is available.</p></p>
     * 
     * <p><p>OLIS needs to be able to communicate the timestamp 
     * that it assigns to an ObservationRequest (test request) when 
     * the test request is created, revised, and whenever result 
     * information is added or revised. 
     * ObservationRequest.availabilityTime has been determined to 
     * be the most appropriate field.</p></p>
     */
    @Hl7XmlMapping({"availabilityTime"})
    public Date getTestRequestAvailabilityTime() {
        return this.testRequestAvailabilityTime.getValue();
    }
    public void setTestRequestAvailabilityTime(Date testRequestAvailabilityTime) {
        this.testRequestAvailabilityTime.setValue(testRequestAvailabilityTime);
    }


    @Hl7XmlMapping({"callBackContact/assignedEntity"})
    public List<HealthcareWorkerBean> getCallBackContactAssignedEntity() {
        return this.callBackContactAssignedEntity;
    }

}
