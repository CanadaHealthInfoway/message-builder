/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.lab.polb_mt004100ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.merged.FulfillmentChoice;
import ca.infoway.messagebuilder.model.r02_04_02.lab.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.merged.ReportSectionSpecimenBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.merged.ReportableHealthIndicatorBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.merged.ResultSortKeyBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.merged.WasPerformedByBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.polb_mt001001ca.BatteryOrPanelBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.polb_mt001001ca.ObservationRequestBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.polb_mt001001ca.PlacerGroupBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.polb_mt001001ca.RequestChoice;
import ca.infoway.messagebuilder.model.r02_04_02.merged.IncludesBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.RoleChoice;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Culture Grouper Observation</p>
 * 
 * <p><p>This culture observation is the grouping observation 
 * for all information related to the culturing of the 
 * collected specimen to identify micro-organisms and the 
 * further, optional testing for antibiotic sensitivities.</p></p>
 * 
 * <p><p>This mandatory culture observation is the grouping 
 * observation for all information related to the culturing of 
 * the collected specimen to identify micro-organisms and the 
 * further, optional testing for antibiotic sensitivities.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT004100CA.Culture"})
public class CultureGrouperObservationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private List<ReportableHealthIndicatorBean> component4ReportableTestIndicator = new ArrayList<ReportableHealthIndicatorBean>();
    private List<WasPerformedByBean> performer = new ArrayList<WasPerformedByBean>();
    private List<RoleChoice> receiverRoleChoice = new ArrayList<RoleChoice>();
    private ResultSortKeyBean component2ResultSortKey;
    private OutbreakBean pertinentInformation2OutbreakEvent;
    private List<CultureObservationsBean> component1CultureObservationEvent = new ArrayList<CultureObservationsBean>();
    private List<HasAComponentBean> component3 = new ArrayList<HasAComponentBean>();
    private List<SupportingClinicalInformationBean> pertinentInformation1SupportingClinicalObservationEvent = new ArrayList<SupportingClinicalInformationBean>();
    private HealthcareOrganizationBean primaryInformationRecipientAssignedEntity;
    private SET<II, Identifier> cultureIdentifier = new SETImpl<II, Identifier>(IIImpl.class);
    private CD cultureType = new CDImpl();
    private ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep;
    private List<IncludesBean> subjectOf2 = new ArrayList<IncludesBean>();
    private VersionInformationBean subjectOf1ControlActEvent;
    private SET<CV, Code> resultMaskingIndicator = new SETImpl<CV, Code>(CVImpl.class);
    private List<FulfillmentChoice> inFulfillmentOfFulfillmentChoice = new ArrayList<FulfillmentChoice>();
    private CS cultureStatus = new CSImpl();
    private IVL<TS, Interval<Date>> cultureEffectiveTime = new IVLImpl<TS, Interval<Date>>();
    private ReportSectionSpecimenBean specimen;


    @Hl7XmlMapping({"component4/reportableTestIndicator"})
    public List<ReportableHealthIndicatorBean> getComponent4ReportableTestIndicator() {
        return this.component4ReportableTestIndicator;
    }


    @Hl7XmlMapping({"performer"})
    public List<WasPerformedByBean> getPerformer() {
        return this.performer;
    }


    @Hl7XmlMapping({"receiver/roleChoice"})
    public List<RoleChoice> getReceiverRoleChoice() {
        return this.receiverRoleChoice;
    }


    @Hl7XmlMapping({"component2/resultSortKey"})
    public ResultSortKeyBean getComponent2ResultSortKey() {
        return this.component2ResultSortKey;
    }
    public void setComponent2ResultSortKey(ResultSortKeyBean component2ResultSortKey) {
        this.component2ResultSortKey = component2ResultSortKey;
    }


    @Hl7XmlMapping({"pertinentInformation2/outbreakEvent"})
    public OutbreakBean getPertinentInformation2OutbreakEvent() {
        return this.pertinentInformation2OutbreakEvent;
    }
    public void setPertinentInformation2OutbreakEvent(OutbreakBean pertinentInformation2OutbreakEvent) {
        this.pertinentInformation2OutbreakEvent = pertinentInformation2OutbreakEvent;
    }


    @Hl7XmlMapping({"component1/cultureObservationEvent"})
    public List<CultureObservationsBean> getComponent1CultureObservationEvent() {
        return this.component1CultureObservationEvent;
    }


    @Hl7XmlMapping({"component3"})
    public List<HasAComponentBean> getComponent3() {
        return this.component3;
    }


    @Hl7XmlMapping({"pertinentInformation1/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformation1SupportingClinicalObservationEvent() {
        return this.pertinentInformation1SupportingClinicalObservationEvent;
    }


    @Hl7XmlMapping({"primaryInformationRecipient/assignedEntity"})
    public HealthcareOrganizationBean getPrimaryInformationRecipientAssignedEntity() {
        return this.primaryInformationRecipientAssignedEntity;
    }
    public void setPrimaryInformationRecipientAssignedEntity(HealthcareOrganizationBean primaryInformationRecipientAssignedEntity) {
        this.primaryInformationRecipientAssignedEntity = primaryInformationRecipientAssignedEntity;
    }


    /**
     * <p>Culture Identifier</p>
     * 
     * <p><p>Unique to identify this culture test.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getCultureIdentifier() {
        return this.cultureIdentifier.rawSet();
    }


    /**
     * <p>Culture Type</p>
     * 
     * <p><p>Describes the type of culture. LOINC codes are used 
     * for this attribute which also &quot;carry&quot; the specimen 
     * source e.g. ear, blood, etc.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCultureType() {
        return (Code) this.cultureType.getValue();
    }
    public void setCultureType(Code cultureType) {
        this.cultureType.setValue(cultureType);
    }


    @Hl7XmlMapping({"subjectOf3/resultStatusProcessStep"})
    public ResultStatusProcessStepBean getSubjectOf3ResultStatusProcessStep() {
        return this.subjectOf3ResultStatusProcessStep;
    }
    public void setSubjectOf3ResultStatusProcessStep(ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep) {
        this.subjectOf3ResultStatusProcessStep = subjectOf3ResultStatusProcessStep;
    }


    @Hl7XmlMapping({"subjectOf2"})
    public List<IncludesBean> getSubjectOf2() {
        return this.subjectOf2;
    }


    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public VersionInformationBean getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }
    public void setSubjectOf1ControlActEvent(VersionInformationBean subjectOf1ControlActEvent) {
        this.subjectOf1ControlActEvent = subjectOf1ControlActEvent;
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


    @Hl7XmlMapping({"inFulfillmentOf/fulfillmentChoice"})
    public List<FulfillmentChoice> getInFulfillmentOfFulfillmentChoice() {
        return this.inFulfillmentOfFulfillmentChoice;
    }


    /**
     * <p>Culture Status</p>
     * 
     * <p><p>Status of the Culture.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getCultureStatus() {
        return (ActStatus) this.cultureStatus.getValue();
    }
    public void setCultureStatus(ActStatus cultureStatus) {
        this.cultureStatus.setValue(cultureStatus);
    }


    /**
     * <p>Culture Effective Time</p>
     * 
     * <p><p>Effective time associated with the Culture.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getCultureEffectiveTime() {
        return this.cultureEffectiveTime.getValue();
    }
    public void setCultureEffectiveTime(Interval<Date> cultureEffectiveTime) {
        this.cultureEffectiveTime.setValue(cultureEffectiveTime);
    }


    @Hl7XmlMapping({"specimen"})
    public ReportSectionSpecimenBean getSpecimen() {
        return this.specimen;
    }
    public void setSpecimen(ReportSectionSpecimenBean specimen) {
        this.specimen = specimen;
    }

}