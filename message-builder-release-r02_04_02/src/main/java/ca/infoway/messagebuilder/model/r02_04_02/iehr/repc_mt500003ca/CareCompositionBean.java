/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.iehr.repc_mt500003ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCareEventType;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt050202ca.PatientBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt910108ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt911108ca.ActingPerson;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.EHRRepositoryBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.Patient_2Bean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.ServiceLocationBean;
import ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.ControlActEventBean;
import ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.DischargeDiagnosisBean;
import ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.NewPatientCareProvisionEventBean;
import ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.OldPatientCareProvisionEventBean;
import ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.Request_1Bean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.BecauseOfBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.ChangedByBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.OccurredAtBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.SpecimenRoleBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Care Composition</p>
 * 
 * <p><p>A care composition is a record with two purposes. It 
 * indicates that care of a given type has occurred or is 
 * occurring. It also acts as a collector for the events that 
 * happened during care, including who is responsible for the 
 * care provided.</p><p>Care composition messages may be sent 
 * during the course of care to describe the progress of care 
 * or may be sent at the termination of care to describe all 
 * the activities that occurred during the provision of care. 
 * Note that this record merely captures the existence of care 
 * and the locations and people involved. The actual discrete 
 * events and any care summary documentation that results are 
 * captured using other messages.</p><p>Examples include: 
 * encounters, condition-related care (episodes) and 
 * longer-term care collections such as &quot;gynecological 
 * care&quot;.</p></p>
 * 
 * <p><p>A care composition is a record with two purposes. It 
 * indicates that care of a given type has occurred or is 
 * occurring. It also acts as a collector for the events that 
 * happened during care, including who is responsible for the 
 * care provided.</p><p>Care composition messages may be sent 
 * during the course of care to describe the progress of care 
 * or may be sent at the termination of care to describe all 
 * the activities that occurred during the provision of care. 
 * Note that this record merely captures the existence of care 
 * and the locations and people involved. The actual discrete 
 * events and any care summary documentation that results are 
 * captured using other messages.</p><p>Examples include: 
 * encounters, condition-related care (episodes) and 
 * longer-term care collections such as &quot;gynecological 
 * care&quot;.</p></p>
 * 
 * <p><p>A care composition is a record with two purposes. It 
 * indicates that care of a given type has occurred or is 
 * occurring. It also acts as a collector for the events that 
 * happened during care, including who is responsible for the 
 * care provided.</p><p>Care composition messages may be sent 
 * during the course of care to describe the progress of care 
 * or may be sent at the termination of care to describe all 
 * the activities that occurred during the provision of care. 
 * Note that this record merely captures the existence of care 
 * and the locations and people involved. The actual discrete 
 * events and any care summary documentation that results are 
 * captured using other messages.</p><p>Examples include: 
 * encounters, condition-related care (episodes) and 
 * longer-term care collections such as &quot;gynecological 
 * care&quot;.</p></p>
 * 
 * <p><p>Care compositions allow grouping together numerous 
 * related records which aids searching and navigation. Also, 
 * the mere knowledge that a type of care has occurred or is 
 * occurring (e.g. an in-patient hospital encounter) can be 
 * useful information when delivering subsequent care.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT500003CA.PatientCareProvisionEvent"})
@Hl7RootType
public class CareCompositionBean extends MessagePartBean implements ca.infoway.messagebuilder.model.r02_04_02.iehr.comt_mt111111ca.SHR {

    private static final long serialVersionUID = 20110318L;
    private SpecimenRoleBean subject1Specimen;
    private II careCompositionId = new IIImpl();
    private ServiceLocationBean custodian2ServiceDeliveryLocation;
    private EHRRepositoryBean custodian1AssignedDevice;
    private List<OccurredAtBean> location = new ArrayList<OccurredAtBean>();
    private List<ActingPerson> performerActingPerson = new ArrayList<ActingPerson>();
    private BL refutedIndicator = new BLImpl();
    private List<DischargeDiagnosisBean> outcomeDiagnosisEvent = new ArrayList<DischargeDiagnosisBean>();
    private ControlActEventBean subjectOf2ControlActEvent;
    private SET<CV, Code> careCompositionMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private CS careCompositionStatus = new CSImpl();
    private ActingPerson dischargerActingPerson;
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private ChangedByBean author;
    private BL subjectOf1AnnotationIndicator = new BLImpl();
    private List<PatientBean> subject2Patient = new ArrayList<PatientBean>();
    private List<OldPatientCareProvisionEventBean> predecessorOldPatientCareProvisionEvent = new ArrayList<OldPatientCareProvisionEventBean>();
    private NewPatientCareProvisionEventBean successorNewPatientCareProvisionEvent;
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();
    private ca.infoway.messagebuilder.model.r02_04_02.common.merged.ActingPerson informantActingPerson;
    private ActingPerson responsiblePartyActingPerson;
    private CV careCompositionType = new CVImpl();
    private INT numberOfPatients = new INTImpl();
    private IVL<TS, Interval<Date>> careCompositionPeriod = new IVLImpl<TS, Interval<Date>>();
    private Request_1Bean inFulfillmentOfActRequest;


    @Hl7XmlMapping({"subject1/specimen"})
    public SpecimenRoleBean getSubject1Specimen() {
        return this.subject1Specimen;
    }
    public void setSubject1Specimen(SpecimenRoleBean subject1Specimen) {
        this.subject1Specimen = subject1Specimen;
    }


    /**
     * <p>A: Care Composition Id</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getCareCompositionId() {
        return this.careCompositionId.getValue();
    }
    public void setCareCompositionId(Identifier careCompositionId) {
        this.careCompositionId.setValue(careCompositionId);
    }


    @Hl7XmlMapping({"custodian2/serviceDeliveryLocation"})
    public ServiceLocationBean getCustodian2ServiceDeliveryLocation() {
        return this.custodian2ServiceDeliveryLocation;
    }
    public void setCustodian2ServiceDeliveryLocation(ServiceLocationBean custodian2ServiceDeliveryLocation) {
        this.custodian2ServiceDeliveryLocation = custodian2ServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"custodian1/assignedDevice"})
    public EHRRepositoryBean getCustodian1AssignedDevice() {
        return this.custodian1AssignedDevice;
    }
    public void setCustodian1AssignedDevice(EHRRepositoryBean custodian1AssignedDevice) {
        this.custodian1AssignedDevice = custodian1AssignedDevice;
    }


    @Hl7XmlMapping({"location"})
    public List<OccurredAtBean> getLocation() {
        return this.location;
    }


    @Hl7XmlMapping({"performer/actingPerson"})
    public List<ActingPerson> getPerformerActingPerson() {
        return this.performerActingPerson;
    }


    /**
     * <p>D:Refuted Indicator</p>
     * 
     * <p><p>Refuted Indicator cannot be specified unless Care 
     * Composition Type is Encounter or a specialization 
     * there-of.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getRefutedIndicator() {
        return this.refutedIndicator.getValue();
    }
    public void setRefutedIndicator(Boolean refutedIndicator) {
        this.refutedIndicator.setValue(refutedIndicator);
    }


    @Hl7XmlMapping({"outcome/diagnosisEvent"})
    public List<DischargeDiagnosisBean> getOutcomeDiagnosisEvent() {
        return this.outcomeDiagnosisEvent;
    }


    @Hl7XmlMapping({"subjectOf2/controlActEvent"})
    public ControlActEventBean getSubjectOf2ControlActEvent() {
        return this.subjectOf2ControlActEvent;
    }
    public void setSubjectOf2ControlActEvent(ControlActEventBean subjectOf2ControlActEvent) {
        this.subjectOf2ControlActEvent = subjectOf2ControlActEvent;
    }


    /**
     * <p>E: Care Composition Masking Indicators</p>
     * 
     * <p></p><p>Masking a care composition record masks it for all 
     * associated patients (i.e. all patients involved in the care 
     * composition as a group).</p><p>Also, masking a care 
     * composition implicitly masks all records associated with 
     * that care composition.</p></p>
     * 
     * <p></p><p>Masking a care composition record masks it for all 
     * associated patients (i.e. all patients involved in the care 
     * composition as a group).</p><p>Also, masking a care 
     * composition implicitly masks all records associated with 
     * that care composition.</p></p>
     * 
     * <p></p><p>Masking a care composition record masks it for all 
     * associated patients (i.e. all patients involved in the care 
     * composition as a group).</p><p>Also, masking a care 
     * composition implicitly masks all records associated with 
     * that care composition.</p></p>
     * 
     * <p></p><p>Masking a care composition record masks it for all 
     * associated patients (i.e. all patients involved in the care 
     * composition as a group).</p><p>Also, masking a care 
     * composition implicitly masks all records associated with 
     * that care composition.</p></p>
     * 
     * <p></p><p>Masking a care composition record masks it for all 
     * associated patients (i.e. all patients involved in the care 
     * composition as a group).</p><p>Also, masking a care 
     * composition implicitly masks all records associated with 
     * that care composition.</p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getCareCompositionMaskingIndicators() {
        return this.careCompositionMaskingIndicators.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>C: Care Composition Status</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getCareCompositionStatus() {
        return (ActStatus) this.careCompositionStatus.getValue();
    }
    public void setCareCompositionStatus(ActStatus careCompositionStatus) {
        this.careCompositionStatus.setValue(careCompositionStatus);
    }


    @Hl7XmlMapping({"discharger/actingPerson"})
    public ActingPerson getDischargerActingPerson() {
        return this.dischargerActingPerson;
    }
    public void setDischargerActingPerson(ActingPerson dischargerActingPerson) {
        this.dischargerActingPerson = dischargerActingPerson;
    }

    public HealthcareWorkerBean getDischargerActingPersonAsAssignedEntity1() {
        return this.dischargerActingPerson instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.dischargerActingPerson : null;
    }
    public boolean hasDischargerActingPersonAsAssignedEntity1() {
        return (this.dischargerActingPerson instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getDischargerActingPersonAsAssignedEntity2() {
        return this.dischargerActingPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.dischargerActingPerson : null;
    }
    public boolean hasDischargerActingPersonAsAssignedEntity2() {
        return (this.dischargerActingPerson instanceof HealthcareOrganizationBean);
    }

    public RelatedPersonBean getDischargerActingPersonAsPersonalRelationship() {
        return this.dischargerActingPerson instanceof RelatedPersonBean ? (RelatedPersonBean) this.dischargerActingPerson : null;
    }
    public boolean hasDischargerActingPersonAsPersonalRelationship() {
        return (this.dischargerActingPerson instanceof RelatedPersonBean);
    }


    @Hl7XmlMapping({"reason"})
    public List<BecauseOfBean> getReason() {
        return this.reason;
    }


    @Hl7XmlMapping({"author"})
    public ChangedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(ChangedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"subjectOf1/annotationIndicator"})
    public Boolean getSubjectOf1AnnotationIndicator() {
        return this.subjectOf1AnnotationIndicator.getValue();
    }
    public void setSubjectOf1AnnotationIndicator(Boolean subjectOf1AnnotationIndicator) {
        this.subjectOf1AnnotationIndicator.setValue(subjectOf1AnnotationIndicator);
    }


    @Hl7XmlMapping({"subject2/patient"})
    public List<PatientBean> getSubject2Patient() {
        return this.subject2Patient;
    }


    @Hl7XmlMapping({"predecessor/oldPatientCareProvisionEvent"})
    public List<OldPatientCareProvisionEventBean> getPredecessorOldPatientCareProvisionEvent() {
        return this.predecessorOldPatientCareProvisionEvent;
    }


    @Hl7XmlMapping({"successor/newPatientCareProvisionEvent"})
    public NewPatientCareProvisionEventBean getSuccessorNewPatientCareProvisionEvent() {
        return this.successorNewPatientCareProvisionEvent;
    }
    public void setSuccessorNewPatientCareProvisionEvent(NewPatientCareProvisionEventBean successorNewPatientCareProvisionEvent) {
        this.successorNewPatientCareProvisionEvent = successorNewPatientCareProvisionEvent;
    }


    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }


    @Hl7XmlMapping({"informant/actingPerson"})
    public ca.infoway.messagebuilder.model.r02_04_02.common.merged.ActingPerson getInformantActingPerson() {
        return this.informantActingPerson;
    }
    public void setInformantActingPerson(ca.infoway.messagebuilder.model.r02_04_02.common.merged.ActingPerson informantActingPerson) {
        this.informantActingPerson = informantActingPerson;
    }

    public HealthcareWorkerBean getInformantActingPersonAsAssignedEntity1() {
        return this.informantActingPerson instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.informantActingPerson : null;
    }
    public boolean hasInformantActingPersonAsAssignedEntity1() {
        return (this.informantActingPerson instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getInformantActingPersonAsAssignedEntity2() {
        return this.informantActingPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.informantActingPerson : null;
    }
    public boolean hasInformantActingPersonAsAssignedEntity2() {
        return (this.informantActingPerson instanceof HealthcareOrganizationBean);
    }

    public Patient_2Bean getInformantActingPersonAsPatient() {
        return this.informantActingPerson instanceof Patient_2Bean ? (Patient_2Bean) this.informantActingPerson : null;
    }
    public boolean hasInformantActingPersonAsPatient() {
        return (this.informantActingPerson instanceof Patient_2Bean);
    }


    @Hl7XmlMapping({"responsibleParty/actingPerson"})
    public ActingPerson getResponsiblePartyActingPerson() {
        return this.responsiblePartyActingPerson;
    }
    public void setResponsiblePartyActingPerson(ActingPerson responsiblePartyActingPerson) {
        this.responsiblePartyActingPerson = responsiblePartyActingPerson;
    }

    public HealthcareWorkerBean getResponsiblePartyActingPersonAsAssignedEntity1() {
        return this.responsiblePartyActingPerson instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.responsiblePartyActingPerson : null;
    }
    public boolean hasResponsiblePartyActingPersonAsAssignedEntity1() {
        return (this.responsiblePartyActingPerson instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getResponsiblePartyActingPersonAsAssignedEntity2() {
        return this.responsiblePartyActingPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.responsiblePartyActingPerson : null;
    }
    public boolean hasResponsiblePartyActingPersonAsAssignedEntity2() {
        return (this.responsiblePartyActingPerson instanceof HealthcareOrganizationBean);
    }

    public RelatedPersonBean getResponsiblePartyActingPersonAsPersonalRelationship() {
        return this.responsiblePartyActingPerson instanceof RelatedPersonBean ? (RelatedPersonBean) this.responsiblePartyActingPerson : null;
    }
    public boolean hasResponsiblePartyActingPersonAsPersonalRelationship() {
        return (this.responsiblePartyActingPerson instanceof RelatedPersonBean);
    }


    /**
     * <p>B: Care Composition Type</p>
     * 
     * <p></p><p>Care Composition is the generic name given to 
     * event 'containers' such as Encounters, 
     * Health-Condition-based Collections (Episodes) and Care-based 
     * Collections. The &quot;type&quot; of care composition places 
     * constraints on what elements are 
     * supported.</p><p>Encounter-based collection: a series of 
     * health care events that occur during an interaction between 
     * one or more health care providers and one or more patients 
     * where the providers and the patient remain in the same 
     * location over a contiguous period of time; the providers and 
     * patient may be at different locations (telehealth). e.g. 
     * Inpatient encounter, Community 
     * encounter.</p><p>Condition-based collection (Episode): a 
     * series of interactions between a patient and one or more 
     * health care providers over time in one or more locations and 
     * tied together by a common diagnosis or 
     * problem.</p><p>Care-based collection: a high level grouping 
     * of health events, encounters, and/or episodes related to a 
     * particular area of healthcare. e.g. Gynecology care, 
     * Cardiology Care, etc.</p></p>
     * 
     * <p></p><p>Care Composition is the generic name given to 
     * event 'containers' such as Encounters, 
     * Health-Condition-based Collections (Episodes) and Care-based 
     * Collections. The &quot;type&quot; of care composition places 
     * constraints on what elements are 
     * supported.</p><p>Encounter-based collection: a series of 
     * health care events that occur during an interaction between 
     * one or more health care providers and one or more patients 
     * where the providers and the patient remain in the same 
     * location over a contiguous period of time; the providers and 
     * patient may be at different locations (telehealth). e.g. 
     * Inpatient encounter, Community 
     * encounter.</p><p>Condition-based collection (Episode): a 
     * series of interactions between a patient and one or more 
     * health care providers over time in one or more locations and 
     * tied together by a common diagnosis or 
     * problem.</p><p>Care-based collection: a high level grouping 
     * of health events, encounters, and/or episodes related to a 
     * particular area of healthcare. e.g. Gynecology care, 
     * Cardiology Care, etc.</p></p>
     * 
     * <p></p><p>Care Composition is the generic name given to 
     * event 'containers' such as Encounters, 
     * Health-Condition-based Collections (Episodes) and Care-based 
     * Collections. The &quot;type&quot; of care composition places 
     * constraints on what elements are 
     * supported.</p><p>Encounter-based collection: a series of 
     * health care events that occur during an interaction between 
     * one or more health care providers and one or more patients 
     * where the providers and the patient remain in the same 
     * location over a contiguous period of time; the providers and 
     * patient may be at different locations (telehealth). e.g. 
     * Inpatient encounter, Community 
     * encounter.</p><p>Condition-based collection (Episode): a 
     * series of interactions between a patient and one or more 
     * health care providers over time in one or more locations and 
     * tied together by a common diagnosis or 
     * problem.</p><p>Care-based collection: a high level grouping 
     * of health events, encounters, and/or episodes related to a 
     * particular area of healthcare. e.g. Gynecology care, 
     * Cardiology Care, etc.</p></p>
     * 
     * <p></p><p>Care Composition is the generic name given to 
     * event 'containers' such as Encounters, 
     * Health-Condition-based Collections (Episodes) and Care-based 
     * Collections. The &quot;type&quot; of care composition places 
     * constraints on what elements are 
     * supported.</p><p>Encounter-based collection: a series of 
     * health care events that occur during an interaction between 
     * one or more health care providers and one or more patients 
     * where the providers and the patient remain in the same 
     * location over a contiguous period of time; the providers and 
     * patient may be at different locations (telehealth). e.g. 
     * Inpatient encounter, Community 
     * encounter.</p><p>Condition-based collection (Episode): a 
     * series of interactions between a patient and one or more 
     * health care providers over time in one or more locations and 
     * tied together by a common diagnosis or 
     * problem.</p><p>Care-based collection: a high level grouping 
     * of health events, encounters, and/or episodes related to a 
     * particular area of healthcare. e.g. Gynecology care, 
     * Cardiology Care, etc.</p></p>
     * 
     * <p></p><p>Care Composition is the generic name given to 
     * event 'containers' such as Encounters, 
     * Health-Condition-based Collections (Episodes) and Care-based 
     * Collections. The &quot;type&quot; of care composition places 
     * constraints on what elements are 
     * supported.</p><p>Encounter-based collection: a series of 
     * health care events that occur during an interaction between 
     * one or more health care providers and one or more patients 
     * where the providers and the patient remain in the same 
     * location over a contiguous period of time; the providers and 
     * patient may be at different locations (telehealth). e.g. 
     * Inpatient encounter, Community 
     * encounter.</p><p>Condition-based collection (Episode): a 
     * series of interactions between a patient and one or more 
     * health care providers over time in one or more locations and 
     * tied together by a common diagnosis or 
     * problem.</p><p>Care-based collection: a high level grouping 
     * of health events, encounters, and/or episodes related to a 
     * particular area of healthcare. e.g. Gynecology care, 
     * Cardiology Care, etc.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActCareEventType getCareCompositionType() {
        return (ActCareEventType) this.careCompositionType.getValue();
    }
    public void setCareCompositionType(ActCareEventType careCompositionType) {
        this.careCompositionType.setValue(careCompositionType);
    }


    /**
     * <p>J:Number of Patients</p>
     * 
     * <p><p>Indicates the number of patients involved in a group 
     * encounter. For non-group encounters, this attribute will 
     * always be &quot;1&quot;.</p></p>
     * 
     * <p><p>Allows a provider to ascertain the size of a group 
     * encounter without necessarily revealing the identity of the 
     * patients involved.</p><p>The patients associated with an 
     * encounter must be specified at the time the record is 
     * created, thus the number of patients will always be known, 
     * making this element mandatory.</p></p>
     * 
     * <p><p>Allows a provider to ascertain the size of a group 
     * encounter without necessarily revealing the identity of the 
     * patients involved.</p><p>The patients associated with an 
     * encounter must be specified at the time the record is 
     * created, thus the number of patients will always be known, 
     * making this element mandatory.</p></p>
     */
    @Hl7XmlMapping({"subject3/patient/patientEntityQuantifiedKind/quantity"})
    public Integer getNumberOfPatients() {
        return this.numberOfPatients.getValue();
    }
    public void setNumberOfPatients(Integer numberOfPatients) {
        this.numberOfPatients.setValue(numberOfPatients);
    }


    /**
     * <p>F: Care Composition Period</p>
     * 
     * <p><p>Represents the start and end of the date/time interval 
     * during which the care described by the composition was/is 
     * being provided.</p><p>E.g. The admission and discharge 
     * date/time; the date on which the episode began and ended; 
     * etc.</p><p>Please note that it is possible for many episodes 
     * and care events to not have an end date; in these 
     * situations, only the start date will be specified. Even 
     * encounters will not have an end date until the encounter is 
     * completed/patient is discharged.</p></p>
     * 
     * <p><p>Represents the start and end of the date/time interval 
     * during which the care described by the composition was/is 
     * being provided.</p><p>E.g. The admission and discharge 
     * date/time; the date on which the episode began and ended; 
     * etc.</p><p>Please note that it is possible for many episodes 
     * and care events to not have an end date; in these 
     * situations, only the start date will be specified. Even 
     * encounters will not have an end date until the encounter is 
     * completed/patient is discharged.</p></p>
     * 
     * <p><p>Represents the start and end of the date/time interval 
     * during which the care described by the composition was/is 
     * being provided.</p><p>E.g. The admission and discharge 
     * date/time; the date on which the episode began and ended; 
     * etc.</p><p>Please note that it is possible for many episodes 
     * and care events to not have an end date; in these 
     * situations, only the start date will be specified. Even 
     * encounters will not have an end date until the encounter is 
     * completed/patient is discharged.</p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getCareCompositionPeriod() {
        return this.careCompositionPeriod.getValue();
    }
    public void setCareCompositionPeriod(Interval<Date> careCompositionPeriod) {
        this.careCompositionPeriod.setValue(careCompositionPeriod);
    }


    @Hl7XmlMapping({"inFulfillmentOf/actRequest"})
    public Request_1Bean getInFulfillmentOfActRequest() {
        return this.inFulfillmentOfActRequest;
    }
    public void setInFulfillmentOfActRequest(Request_1Bean inFulfillmentOfActRequest) {
        this.inFulfillmentOfActRequest = inFulfillmentOfActRequest;
    }

}
