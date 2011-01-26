/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.iehr.repc_mt000007ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
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
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.common.coct_mt910108ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.common.merged.ActingPerson;
import ca.infoway.messagebuilder.model.common.merged.EHRRepositoryBean;
import ca.infoway.messagebuilder.model.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.common.merged.Patient_2Bean;
import ca.infoway.messagebuilder.model.common.merged.ServiceLocationBean;
import ca.infoway.messagebuilder.model.iehr.merged.AllergyIntoleranceStatusChangesBean;
import ca.infoway.messagebuilder.model.iehr.merged.NewConditionBean;
import ca.infoway.messagebuilder.model.iehr.merged.OldConditionBean;
import ca.infoway.messagebuilder.model.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.merged.ChangedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Health Condition</p>
 * 
 * <p><p>A record of a patient's health condition, as tracked 
 * over time. Examples include diseases, disabilities, 
 * pregnancy, lactation and other clinical conditions of 
 * interest.</p><p>Also known as &quot;Problem&quot; (from a 
 * 'problem list').</p></p>
 * 
 * <p><p>A record of a patient's health condition, as tracked 
 * over time. Examples include diseases, disabilities, 
 * pregnancy, lactation and other clinical conditions of 
 * interest.</p><p>Also known as &quot;Problem&quot; (from a 
 * 'problem list').</p></p>
 * 
 * <p><p>Necessary component of a person's overall profile. 
 * Helps with contraindication checking.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000007CA.ConditionEvent"})
@Hl7RootType
public class HealthConditionBean extends MessagePartBean implements ca.infoway.messagebuilder.model.iehr.comt_mt111111ca.SHR {

    private static final long serialVersionUID = 20110126L;
    private ChangedByBean author;
    private ActingPerson informantActingPerson;
    private II conditionIdentifier = new IIImpl();
    private CV conditionType = new CVImpl();
    private ca.infoway.messagebuilder.model.common.coct_mt911108ca.ActingPerson responsiblePartyActingPerson;
    private EHRRepositoryBean custodian2AssignedDevice;
    private BL refutedIndicator = new BLImpl();
    private SET<CV, Code> conditionMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private CD condition = new CDImpl();
    private ServiceLocationBean custodian1ServiceDeliveryLocation;
    private CS conditionStatus = new CSImpl();
    private BL subjectOf2AnnotationIndicator = new BLImpl();
    private IVL<TS, Interval<Date>> conditionTimePeriod = new IVLImpl<TS, Interval<Date>>();
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();
    private AllergyIntoleranceStatusChangesBean subjectOf1ControlActEvent;
    private List<OldConditionBean> predecessorOldCondition = new ArrayList<OldConditionBean>();
    private NewConditionBean successorNewCondition;


    @Hl7XmlMapping({"author"})
    public ChangedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(ChangedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"informant/actingPerson"})
    public ActingPerson getInformantActingPerson() {
        return this.informantActingPerson;
    }
    public void setInformantActingPerson(ActingPerson informantActingPerson) {
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


    /**
     * <p>A:Condition Identifier</p>
     * 
     * <p></p><p>The identifier applies to this 
     * &quot;instance&quot; of the condition. For example, multiple 
     * pregnancies would each be treated as distinct conditions, 
     * each with a unique id.</p></p>
     * 
     * <p></p><p>The identifier applies to this 
     * &quot;instance&quot; of the condition. For example, multiple 
     * pregnancies would each be treated as distinct conditions, 
     * each with a unique id.</p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getConditionIdentifier() {
        return this.conditionIdentifier.getValue();
    }
    public void setConditionIdentifier(Identifier conditionIdentifier) {
        this.conditionIdentifier.setValue(conditionIdentifier);
    }


    /**
     * <p>B: Condition Type</p>
     * 
     * <p><p>Code is fixed DX if not using SNOMED;</p></p>
     * 
     * <p><p>Designates the concept in DiagnosisValue as a 
     * Diagnosis</p></p>
     * 
     * <p></p><p>Since all diagnosis concepts can be represented in 
     * a single field, this domain is a fixed value</p></p>
     * 
     * <p></p><p>Since all diagnosis concepts can be represented in 
     * a single field, this domain is a fixed value</p></p>
     * 
     * <p></p><p>Since all diagnosis concepts can be represented in 
     * a single field, this domain is a fixed value</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getConditionType() {
        return (Code) this.conditionType.getValue();
    }
    public void setConditionType(Code conditionType) {
        this.conditionType.setValue(conditionType);
    }


    @Hl7XmlMapping({"responsibleParty/actingPerson"})
    public ca.infoway.messagebuilder.model.common.coct_mt911108ca.ActingPerson getResponsiblePartyActingPerson() {
        return this.responsiblePartyActingPerson;
    }
    public void setResponsiblePartyActingPerson(ca.infoway.messagebuilder.model.common.coct_mt911108ca.ActingPerson responsiblePartyActingPerson) {
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


    @Hl7XmlMapping({"custodian2/assignedDevice"})
    public EHRRepositoryBean getCustodian2AssignedDevice() {
        return this.custodian2AssignedDevice;
    }
    public void setCustodian2AssignedDevice(EHRRepositoryBean custodian2AssignedDevice) {
        this.custodian2AssignedDevice = custodian2AssignedDevice;
    }


    /**
     * <p>E: Refuted Indicator</p>
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


    /**
     * <p>F: Condition Masking Indicators</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConditionMaskingIndicators() {
        return this.conditionMaskingIndicators.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>K:Condition</p>
     * 
     * <p><p>A code indicating the specific condition. E.g. 
     * Hypertension, Pregnancy.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"value"})
    public DiagnosisValue getCondition() {
        return (DiagnosisValue) this.condition.getValue();
    }
    public void setCondition(DiagnosisValue condition) {
        this.condition.setValue(condition);
    }


    @Hl7XmlMapping({"custodian1/serviceDeliveryLocation"})
    public ServiceLocationBean getCustodian1ServiceDeliveryLocation() {
        return this.custodian1ServiceDeliveryLocation;
    }
    public void setCustodian1ServiceDeliveryLocation(ServiceLocationBean custodian1ServiceDeliveryLocation) {
        this.custodian1ServiceDeliveryLocation = custodian1ServiceDeliveryLocation;
    }


    /**
     * <p>C:Condition Status</p>
     * 
     * <p></p><p>Indicates whether the condition is still being 
     * monitored as relevant to the patient's health ('active') or 
     * whether the condition is no longer considered a relevant 
     * 'problem' ('completed'). It may also be 'obsolete' in 
     * circumstances where the record has been replaced.</p><p>Note 
     * that a problem may be considered 'active' even if the 
     * underlying condition is no longer affecting the patient. For 
     * example, for a patient who was recently pregnant, the 
     * pregnancy has ended, but the pregnancy would still be an 
     * 'active' condition record because of it's ongoing impact on 
     * the patient's healthcare situation.</p><p>To convey the 
     * actual clinical status of the condition, use SNOMED 
     * post-coordination in the Condition attribute.</p></p>
     * 
     * <p></p><p>Indicates whether the condition is still being 
     * monitored as relevant to the patient's health ('active') or 
     * whether the condition is no longer considered a relevant 
     * 'problem' ('completed'). It may also be 'obsolete' in 
     * circumstances where the record has been replaced.</p><p>Note 
     * that a problem may be considered 'active' even if the 
     * underlying condition is no longer affecting the patient. For 
     * example, for a patient who was recently pregnant, the 
     * pregnancy has ended, but the pregnancy would still be an 
     * 'active' condition record because of it's ongoing impact on 
     * the patient's healthcare situation.</p><p>To convey the 
     * actual clinical status of the condition, use SNOMED 
     * post-coordination in the Condition attribute.</p></p>
     * 
     * <p></p><p>Indicates whether the condition is still being 
     * monitored as relevant to the patient's health ('active') or 
     * whether the condition is no longer considered a relevant 
     * 'problem' ('completed'). It may also be 'obsolete' in 
     * circumstances where the record has been replaced.</p><p>Note 
     * that a problem may be considered 'active' even if the 
     * underlying condition is no longer affecting the patient. For 
     * example, for a patient who was recently pregnant, the 
     * pregnancy has ended, but the pregnancy would still be an 
     * 'active' condition record because of it's ongoing impact on 
     * the patient's healthcare situation.</p><p>To convey the 
     * actual clinical status of the condition, use SNOMED 
     * post-coordination in the Condition attribute.</p></p>
     * 
     * <p></p><p>Indicates whether the condition is still being 
     * monitored as relevant to the patient's health ('active') or 
     * whether the condition is no longer considered a relevant 
     * 'problem' ('completed'). It may also be 'obsolete' in 
     * circumstances where the record has been replaced.</p><p>Note 
     * that a problem may be considered 'active' even if the 
     * underlying condition is no longer affecting the patient. For 
     * example, for a patient who was recently pregnant, the 
     * pregnancy has ended, but the pregnancy would still be an 
     * 'active' condition record because of it's ongoing impact on 
     * the patient's healthcare situation.</p><p>To convey the 
     * actual clinical status of the condition, use SNOMED 
     * post-coordination in the Condition attribute.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getConditionStatus() {
        return (ActStatus) this.conditionStatus.getValue();
    }
    public void setConditionStatus(ActStatus conditionStatus) {
        this.conditionStatus.setValue(conditionStatus);
    }


    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    /**
     * <p>G: Condition Time Period</p>
     * 
     * <p><p>The date on which the condition first began and when 
     * it ended.</p><p>For ongoing conditions such as chronic 
     * diseases, the upper boundary may be unknown.</p><p>For 
     * transient conditions such as pregnancy, lactation, etc; the 
     * upper boundary of the period would usually be specified to 
     * signify the end of the condition.</p></p>
     * 
     * <p><p>The date on which the condition first began and when 
     * it ended.</p><p>For ongoing conditions such as chronic 
     * diseases, the upper boundary may be unknown.</p><p>For 
     * transient conditions such as pregnancy, lactation, etc; the 
     * upper boundary of the period would usually be specified to 
     * signify the end of the condition.</p></p>
     * 
     * <p><p>The date on which the condition first began and when 
     * it ended.</p><p>For ongoing conditions such as chronic 
     * diseases, the upper boundary may be unknown.</p><p>For 
     * transient conditions such as pregnancy, lactation, etc; the 
     * upper boundary of the period would usually be specified to 
     * signify the end of the condition.</p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getConditionTimePeriod() {
        return this.conditionTimePeriod.getValue();
    }
    public void setConditionTimePeriod(Interval<Date> conditionTimePeriod) {
        this.conditionTimePeriod.setValue(conditionTimePeriod);
    }


    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }


    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public AllergyIntoleranceStatusChangesBean getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }
    public void setSubjectOf1ControlActEvent(AllergyIntoleranceStatusChangesBean subjectOf1ControlActEvent) {
        this.subjectOf1ControlActEvent = subjectOf1ControlActEvent;
    }


    @Hl7XmlMapping({"predecessor/oldCondition"})
    public List<OldConditionBean> getPredecessorOldCondition() {
        return this.predecessorOldCondition;
    }


    @Hl7XmlMapping({"successor/newCondition"})
    public NewConditionBean getSuccessorNewCondition() {
        return this.successorNewCondition;
    }
    public void setSuccessorNewCondition(NewConditionBean successorNewCondition) {
        this.successorNewCondition = successorNewCondition;
    }

}
