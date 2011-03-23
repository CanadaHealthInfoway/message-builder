/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.lab.polb_mt002000ca;

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
import ca.infoway.messagebuilder.domainvalue.ObservationOrderableLabType;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt050007ca.PatientBean;
import ca.infoway.messagebuilder.model.common.coct_mt090502ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.merged.HasNotesBean;
import ca.infoway.messagebuilder.model.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.merged.ReportSectionSpecimenBean;
import ca.infoway.messagebuilder.model.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.merged.SubjectToTriggerEventBean;
import ca.infoway.messagebuilder.model.merged.SupportingClinicalInformationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"POLB_MT002000CA.BatteryPromise"})
public class BatteryPromiseBean extends MessagePartBean implements PromiseChoiceBean {

    private static final long serialVersionUID = 20100603L;
    private ReportSectionSpecimenBean specimen;
    private PatientBean recordTargetPatient;
    private II batteryPromiseIdentifier = new IIImpl();
    private List<RoleChoiceBean> receiverRoleChoice = new ArrayList<RoleChoiceBean>();
    private CD typeOfBatteryPromise = new CDImpl();
    private List<RoleChoiceBean> performerRoleChoice = new ArrayList<RoleChoiceBean>();
    private CS batteryPromiseStatus = new CSImpl();
    private HealthcareOrganizationBean primaryInformationRecipientAssignedEntity;
    private IVL<TS, Interval<Date>> batteryPromiseEffectiveTime = new IVLImpl<TS, Interval<Date>>();
    private List<FulfillmentChoiceBean> inFulfillmentOfFulfillmentChoice = new ArrayList<FulfillmentChoiceBean>();
    private SET<CV, Code> batteryPromiseConfidentiality = new SETImpl<CV, Code>(CVImpl.class);
    private OutbreakBean pertinentInformation1OutbreakEvent;
    private List<SupportingClinicalInformationBean> pertinentInformation2SupportingClinicalObservationEvent = new ArrayList<SupportingClinicalInformationBean>();
    private List<PromiseChoiceBean> componentPromiseChoice = new ArrayList<PromiseChoiceBean>();
    private SubjectToTriggerEventBean subjectOf1;
    private List<HasNotesBean> subjectOf2 = new ArrayList<HasNotesBean>();
    private ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep;

    @Hl7XmlMapping({"specimen"})
    public ReportSectionSpecimenBean getSpecimen() {
        return this.specimen;
    }
    public void setSpecimen(ReportSectionSpecimenBean specimen) {
        this.specimen = specimen;
    }

    @Hl7XmlMapping({"recordTarget/patient"})
    public PatientBean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }
    public void setRecordTargetPatient(PatientBean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }

    @Hl7XmlMapping({"id"})
    public Identifier getBatteryPromiseIdentifier() {
        return this.batteryPromiseIdentifier.getValue();
    }
    public void setBatteryPromiseIdentifier(Identifier batteryPromiseIdentifier) {
        this.batteryPromiseIdentifier.setValue(batteryPromiseIdentifier);
    }

    @Hl7XmlMapping({"receiver/roleChoice"})
    public List<RoleChoiceBean> getReceiverRoleChoice() {
        return this.receiverRoleChoice;
    }

    @Hl7XmlMapping({"code"})
    public ObservationOrderableLabType getTypeOfBatteryPromise() {
        return (ObservationOrderableLabType) this.typeOfBatteryPromise.getValue();
    }
    public void setTypeOfBatteryPromise(ObservationOrderableLabType typeOfBatteryPromise) {
        this.typeOfBatteryPromise.setValue(typeOfBatteryPromise);
    }

    @Hl7XmlMapping({"performer/roleChoice"})
    public List<RoleChoiceBean> getPerformerRoleChoice() {
        return this.performerRoleChoice;
    }

    @Hl7XmlMapping({"statusCode"})
    public ActStatus getBatteryPromiseStatus() {
        return (ActStatus) this.batteryPromiseStatus.getValue();
    }
    public void setBatteryPromiseStatus(ActStatus batteryPromiseStatus) {
        this.batteryPromiseStatus.setValue(batteryPromiseStatus);
    }

    @Hl7XmlMapping({"primaryInformationRecipient/assignedEntity"})
    public HealthcareOrganizationBean getPrimaryInformationRecipientAssignedEntity() {
        return this.primaryInformationRecipientAssignedEntity;
    }
    public void setPrimaryInformationRecipientAssignedEntity(HealthcareOrganizationBean primaryInformationRecipientAssignedEntity) {
        this.primaryInformationRecipientAssignedEntity = primaryInformationRecipientAssignedEntity;
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getBatteryPromiseEffectiveTime() {
        return this.batteryPromiseEffectiveTime.getValue();
    }
    public void setBatteryPromiseEffectiveTime(Interval<Date> batteryPromiseEffectiveTime) {
        this.batteryPromiseEffectiveTime.setValue(batteryPromiseEffectiveTime);
    }

    @Hl7XmlMapping({"inFulfillmentOf/fulfillmentChoice"})
    public List<FulfillmentChoiceBean> getInFulfillmentOfFulfillmentChoice() {
        return this.inFulfillmentOfFulfillmentChoice;
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getBatteryPromiseConfidentiality() {
        return this.batteryPromiseConfidentiality.rawSet(x_BasicConfidentialityKind.class);
    }

    @Hl7XmlMapping({"pertinentInformation1/outbreakEvent"})
    public OutbreakBean getPertinentInformation1OutbreakEvent() {
        return this.pertinentInformation1OutbreakEvent;
    }
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent) {
        this.pertinentInformation1OutbreakEvent = pertinentInformation1OutbreakEvent;
    }

    @Hl7XmlMapping({"pertinentInformation2/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent() {
        return this.pertinentInformation2SupportingClinicalObservationEvent;
    }

    @Hl7XmlMapping({"component/promiseChoice"})
    public List<PromiseChoiceBean> getComponentPromiseChoice() {
        return this.componentPromiseChoice;
    }

    @Hl7XmlMapping({"subjectOf1"})
    public SubjectToTriggerEventBean getSubjectOf1() {
        return this.subjectOf1;
    }
    public void setSubjectOf1(SubjectToTriggerEventBean subjectOf1) {
        this.subjectOf1 = subjectOf1;
    }

    @Hl7XmlMapping({"subjectOf2"})
    public List<HasNotesBean> getSubjectOf2() {
        return this.subjectOf2;
    }

    @Hl7XmlMapping({"subjectOf3/resultStatusProcessStep"})
    public ResultStatusProcessStepBean getSubjectOf3ResultStatusProcessStep() {
        return this.subjectOf3ResultStatusProcessStep;
    }
    public void setSubjectOf3ResultStatusProcessStep(ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep) {
        this.subjectOf3ResultStatusProcessStep = subjectOf3ResultStatusProcessStep;
    }

}
