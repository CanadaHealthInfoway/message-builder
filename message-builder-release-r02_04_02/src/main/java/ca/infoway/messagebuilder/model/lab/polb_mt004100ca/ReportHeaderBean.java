/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.lab.polb_mt004100ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt090502ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.common.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.lab.merged.FulfillmentChoice;
import ca.infoway.messagebuilder.model.lab.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.lab.merged.ReportableHealthIndicatorBean;
import ca.infoway.messagebuilder.model.lab.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.lab.merged.WasPerformedByBean;
import ca.infoway.messagebuilder.model.lab.polb_mt001001ca.BatteryOrPanelBean;
import ca.infoway.messagebuilder.model.lab.polb_mt001001ca.ObservationRequestBean;
import ca.infoway.messagebuilder.model.lab.polb_mt001001ca.PlacerGroupBean;
import ca.infoway.messagebuilder.model.lab.polb_mt001001ca.RequestChoice;
import ca.infoway.messagebuilder.model.merged.IncludesBean;
import ca.infoway.messagebuilder.model.merged.RoleChoice;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Report Header</p>
 * 
 * <p><p>Report or result header information. Contains 
 * associations to the appropriate patient, the order and/or 
 * promise which this result fulfills, and any report-level 
 * annotations.</p></p>
 * 
 * <p><p>The header allows for report-level observations, the 
 * association to the patient (in this model, all results in 
 * one message pertain to one patient), and the public health 
 * reportable test indicator and one or more culture 
 * observation object complexes.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT004100CA.ObservationReport"})
@Hl7RootType
public class ReportHeaderBean extends MessagePartBean implements ca.infoway.messagebuilder.model.lab.polb_mt004999ca.ResultInstancePayloadChoice, ca.infoway.messagebuilder.model.lab.polb_mt001999ca.ResultChoice {

    private static final long serialVersionUID = 20110127L;
    private CS observationReportStatus = new CSImpl();
    private CD labObservationReportType = new CDImpl();
    private Patient_1Bean recordTargetPatient;
    private ca.infoway.messagebuilder.model.common.coct_mt090508ca.HealthcareOrganizationBean primaryInformationRecipientAssignedEntity;
    private List<IncludesBean> subjectOf2 = new ArrayList<IncludesBean>();
    private List<RoleChoice> receiverRoleChoice = new ArrayList<RoleChoice>();
    private ED<EncapsulatedData> renderedReport = new EDImpl<EncapsulatedData>();
    private SET<CV, Code> resultMaskingIndicator = new SETImpl<CV, Code>(CVImpl.class);
    private ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep;
    private List<WasPerformedByBean> performer = new ArrayList<WasPerformedByBean>();
    private ST observationReportTitle = new STImpl();
    private List<FulfillmentChoice> inFulfillmentOfFulfillmentChoice = new ArrayList<FulfillmentChoice>();
    private List<ReportableHealthIndicatorBean> component1ReportableTestIndicator = new ArrayList<ReportableHealthIndicatorBean>();
    private List<CultureGrouperObservationBean> component2Culture = new ArrayList<CultureGrouperObservationBean>();
    private OutbreakBean pertinentInformation1OutbreakEvent;
    private II observationReportIdentifier = new IIImpl();
    private VersionInformationBean subjectOf1ControlActEvent;
    private List<SupportingClinicalInformationBean> pertinentInformation2SupportingClinicalObservationEvent = new ArrayList<SupportingClinicalInformationBean>();
    private TS observationReportDateTime = new TSImpl();


    /**
     * <p>Observation Report Status</p>
     * 
     * <p><p>The status or state of the report. The statusCode is 
     * not as fine-grained as lab reporting statuses such as 
     * preliminary. A &quot;preliminary&quot; result is a result 
     * whose statusCode=active and ProcessStep (procedure event) 
     * valued &quot;preliminary&quot;.</p></p>
     * 
     * <p><p>The statusCode represents the &quot;state&quot; of the 
     * act e.g. active=in progress or not yet started, 
     * complete=final.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getObservationReportStatus() {
        return (ActStatus) this.observationReportStatus.getValue();
    }
    public void setObservationReportStatus(ActStatus observationReportStatus) {
        this.observationReportStatus.setValue(observationReportStatus);
    }


    /**
     * <p>Lab Observation Report Type</p>
     * 
     * <p><p>The type of this report. This is fixed to Microbiology 
     * Sensitivity Report.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getLabObservationReportType() {
        return (Code) this.labObservationReportType.getValue();
    }
    public void setLabObservationReportType(Code labObservationReportType) {
        this.labObservationReportType.setValue(labObservationReportType);
    }


    @Hl7XmlMapping({"recordTarget/patient"})
    public Patient_1Bean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }
    public void setRecordTargetPatient(Patient_1Bean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }


    @Hl7XmlMapping({"primaryInformationRecipient/assignedEntity"})
    public ca.infoway.messagebuilder.model.common.coct_mt090508ca.HealthcareOrganizationBean getPrimaryInformationRecipientAssignedEntity() {
        return this.primaryInformationRecipientAssignedEntity;
    }
    public void setPrimaryInformationRecipientAssignedEntity(ca.infoway.messagebuilder.model.common.coct_mt090508ca.HealthcareOrganizationBean primaryInformationRecipientAssignedEntity) {
        this.primaryInformationRecipientAssignedEntity = primaryInformationRecipientAssignedEntity;
    }


    @Hl7XmlMapping({"subjectOf2"})
    public List<IncludesBean> getSubjectOf2() {
        return this.subjectOf2;
    }


    @Hl7XmlMapping({"receiver/roleChoice"})
    public List<RoleChoice> getReceiverRoleChoice() {
        return this.receiverRoleChoice;
    }


    /**
     * <p>Rendered Report</p>
     * 
     * <p><p>This attribute is used to send a Rendered Report (or 
     * reference to) which includes only those elements in the 
     * message in a displayable format.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getRenderedReport() {
        return this.renderedReport.getValue();
    }
    public void setRenderedReport(EncapsulatedData renderedReport) {
        this.renderedReport.setValue(renderedReport);
    }


    /**
     * <p>Result Masking Indicator</p>
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
    public Set<x_BasicConfidentialityKind> getResultMaskingIndicator() {
        return this.resultMaskingIndicator.rawSet(x_BasicConfidentialityKind.class);
    }


    @Hl7XmlMapping({"subjectOf3/resultStatusProcessStep"})
    public ResultStatusProcessStepBean getSubjectOf3ResultStatusProcessStep() {
        return this.subjectOf3ResultStatusProcessStep;
    }
    public void setSubjectOf3ResultStatusProcessStep(ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep) {
        this.subjectOf3ResultStatusProcessStep = subjectOf3ResultStatusProcessStep;
    }


    @Hl7XmlMapping({"performer"})
    public List<WasPerformedByBean> getPerformer() {
        return this.performer;
    }


    /**
     * <p>Observation Report Title</p>
     * 
     * <p><p>This allows the reporting lab to add a title to this 
     * result.</p></p>
     * 
     * <p><p>A report title describes or labels the general content 
     * and/or context of the result.</p></p>
     */
    @Hl7XmlMapping({"title"})
    public String getObservationReportTitle() {
        return this.observationReportTitle.getValue();
    }
    public void setObservationReportTitle(String observationReportTitle) {
        this.observationReportTitle.setValue(observationReportTitle);
    }


    @Hl7XmlMapping({"inFulfillmentOf/fulfillmentChoice"})
    public List<FulfillmentChoice> getInFulfillmentOfFulfillmentChoice() {
        return this.inFulfillmentOfFulfillmentChoice;
    }


    @Hl7XmlMapping({"component1/reportableTestIndicator"})
    public List<ReportableHealthIndicatorBean> getComponent1ReportableTestIndicator() {
        return this.component1ReportableTestIndicator;
    }


    @Hl7XmlMapping({"component2/culture"})
    public List<CultureGrouperObservationBean> getComponent2Culture() {
        return this.component2Culture;
    }


    @Hl7XmlMapping({"pertinentInformation1/outbreakEvent"})
    public OutbreakBean getPertinentInformation1OutbreakEvent() {
        return this.pertinentInformation1OutbreakEvent;
    }
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent) {
        this.pertinentInformation1OutbreakEvent = pertinentInformation1OutbreakEvent;
    }


    /**
     * <p>A:Observation Report Identifier</p>
     * 
     * <p><p>Unique identifier for this microbiology result.</p></p>
     * 
     * <p><p>Unique identifiers are required for revisions, 
     * corrections, and cancel transactions.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getObservationReportIdentifier() {
        return this.observationReportIdentifier.getValue();
    }
    public void setObservationReportIdentifier(Identifier observationReportIdentifier) {
        this.observationReportIdentifier.setValue(observationReportIdentifier);
    }


    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public VersionInformationBean getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }
    public void setSubjectOf1ControlActEvent(VersionInformationBean subjectOf1ControlActEvent) {
        this.subjectOf1ControlActEvent = subjectOf1ControlActEvent;
    }


    @Hl7XmlMapping({"pertinentInformation2/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent() {
        return this.pertinentInformation2SupportingClinicalObservationEvent;
    }


    /**
     * <p>Observation Report Date/Time</p>
     * 
     * <p><p>The date/time this report was 
     * &quot;released&quot;.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getObservationReportDateTime() {
        return this.observationReportDateTime.getValue();
    }
    public void setObservationReportDateTime(Date observationReportDateTime) {
        this.observationReportDateTime.setValue(observationReportDateTime);
    }

}
