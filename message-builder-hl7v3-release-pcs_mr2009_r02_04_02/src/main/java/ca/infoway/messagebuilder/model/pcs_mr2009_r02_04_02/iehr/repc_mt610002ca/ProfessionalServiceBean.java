/**
 * Copyright 2011 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.repc_mt610002ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActProfessionalServiceCode;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt910108ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt911108ca.ActingPerson;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.EHRRepositoryBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.Patient_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.ActDefinitionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.ClinicalDocumentEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.Component2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.OldProcedureEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.Request_3Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.BecauseOfBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.ChangedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.OccurredAtBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Professional Service</p>
 * 
 * <p><p>Annotation is only permitted if Annotation Indicator 
 * is not present and vice versa</p></p>
 * 
 * <p><p>This is the information that is recorded and 
 * maintained on a consultative, surgical or physical service 
 * (procedure) provided to the patient.</p><p>Counseling, 
 * education, surgeries and physical therapy are examples of 
 * the types of services that can be captured.</p></p>
 * 
 * <p><p>This is the information that is recorded and 
 * maintained on a consultative, surgical or physical service 
 * (procedure) provided to the patient.</p><p>Counseling, 
 * education, surgeries and physical therapy are examples of 
 * the types of services that can be captured.</p></p>
 * 
 * <p><p>A_BillableClinicalService</p></p>
 * 
 * <p><p>Information about surgeries, councilling and other 
 * professional services is a key element of the EHR. It 
 * provides context around services provided and may inform 
 * choices about how best to manage the patient's 
 * healthcare.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT610002CA.ProcedureEvent"})
@Hl7RootType
public class ProfessionalServiceBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.comt_mt111111ca.SHR {

    private static final long serialVersionUID = 20110831L;
    private II serviceRecordId = new IIImpl();
    private CD serviceType = new CDImpl();
    private BL refutedIndicator = new BLImpl();
    private IVL<TS, Interval<Date>> serviceTimeAndLength = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> serviceMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private ActingPerson responsiblePartyActingPerson;
    private List<ActingPerson> performerActingPerson = new ArrayList<ActingPerson>();
    private ChangedByBean author;
    private ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ActingPerson informantActingPerson;
    private EHRRepositoryBean custodian1AssignedDevice;
    private ServiceLocationBean custodian2ServiceDeliveryLocation;
    private OccurredAtBean location;
    private Request_3Bean inFulfillmentOfActRequest;
    private List<ActDefinitionBean> definitionActDefinition = new ArrayList<ActDefinitionBean>();
    private List<OldProcedureEventBean> predecessorOldProcedureEvent = new ArrayList<OldProcedureEventBean>();
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private NewProcedureEventBean successorNewProcedureEvent;
    private List<IncludesBean> subjectOf1 = new ArrayList<IncludesBean>();
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);
    private ClinicalDocumentEventBean subjectOf3ClinicalDocumentEvent;
    private List<Component2Bean> componentOf1 = new ArrayList<Component2Bean>();
    private List<CareCompositionsBean> componentOf2PatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>A:Service Record Id</p>
     * 
     * <p></p></p>
     * 
     * <p><p>PatientConsultation.patientConsultationkey</p><p>PatientConsultation.externalId</p><p>ZRV.5</p><p>ZPS.2</p><p>ZPS.3</p><p>Claim.455-EM 
     * (root)</p><p>Claim.402-D2 
     * (extension)</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.patientConsultationkey</p><p>PatientConsultation.externalId</p><p>ZRV.5</p><p>ZPS.2</p><p>ZPS.3</p><p>Claim.455-EM 
     * (root)</p><p>Claim.402-D2 
     * (extension)</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.patientConsultationkey</p><p>PatientConsultation.externalId</p><p>ZRV.5</p><p>ZPS.2</p><p>ZPS.3</p><p>Claim.455-EM 
     * (root)</p><p>Claim.402-D2 
     * (extension)</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.patientConsultationkey</p><p>PatientConsultation.externalId</p><p>ZRV.5</p><p>ZPS.2</p><p>ZPS.3</p><p>Claim.455-EM 
     * (root)</p><p>Claim.402-D2 
     * (extension)</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.patientConsultationkey</p><p>PatientConsultation.externalId</p><p>ZRV.5</p><p>ZPS.2</p><p>ZPS.3</p><p>Claim.455-EM 
     * (root)</p><p>Claim.402-D2 
     * (extension)</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.patientConsultationkey</p><p>PatientConsultation.externalId</p><p>ZRV.5</p><p>ZPS.2</p><p>ZPS.3</p><p>Claim.455-EM 
     * (root)</p><p>Claim.402-D2 
     * (extension)</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.patientConsultationkey</p><p>PatientConsultation.externalId</p><p>ZRV.5</p><p>ZPS.2</p><p>ZPS.3</p><p>Claim.455-EM 
     * (root)</p><p>Claim.402-D2 
     * (extension)</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.patientConsultationkey</p><p>PatientConsultation.externalId</p><p>ZRV.5</p><p>ZPS.2</p><p>ZPS.3</p><p>Claim.455-EM 
     * (root)</p><p>Claim.402-D2 
     * (extension)</p><p>A_BillableClinicalService</p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getServiceRecordId() {
        return this.serviceRecordId.getValue();
    }
    public void setServiceRecordId(Identifier serviceRecordId) {
        this.serviceRecordId.setValue(serviceRecordId);
    }


    /**
     * <p>B:Service Type</p>
     * 
     * <p></p><p>e.g. appendectomy, smoking cessation counseling, 
     * physiotherapy</p></p>
     * 
     * <p></p><p>e.g. appendectomy, smoking cessation counseling, 
     * physiotherapy</p></p>
     * 
     * <p><p>PatientConsultation.category</p><p>D57</p><p>ZPS.5.1</p><p>ZPS.5.2 
     * (experience handled as qualifier)</p><p>Claim.436-E1 (code 
     * system)</p><p>Claim.407-D7 (mnemonic)</p><p>Claim.459-ER 
     * (modifier)</p><p>Claim.418-DI 
     * (modifier)</p><p>DUR/PPS.474-8E 
     * (modifier)</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.category</p><p>D57</p><p>ZPS.5.1</p><p>ZPS.5.2 
     * (experience handled as qualifier)</p><p>Claim.436-E1 (code 
     * system)</p><p>Claim.407-D7 (mnemonic)</p><p>Claim.459-ER 
     * (modifier)</p><p>Claim.418-DI 
     * (modifier)</p><p>DUR/PPS.474-8E 
     * (modifier)</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.category</p><p>D57</p><p>ZPS.5.1</p><p>ZPS.5.2 
     * (experience handled as qualifier)</p><p>Claim.436-E1 (code 
     * system)</p><p>Claim.407-D7 (mnemonic)</p><p>Claim.459-ER 
     * (modifier)</p><p>Claim.418-DI 
     * (modifier)</p><p>DUR/PPS.474-8E 
     * (modifier)</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.category</p><p>D57</p><p>ZPS.5.1</p><p>ZPS.5.2 
     * (experience handled as qualifier)</p><p>Claim.436-E1 (code 
     * system)</p><p>Claim.407-D7 (mnemonic)</p><p>Claim.459-ER 
     * (modifier)</p><p>Claim.418-DI 
     * (modifier)</p><p>DUR/PPS.474-8E 
     * (modifier)</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.category</p><p>D57</p><p>ZPS.5.1</p><p>ZPS.5.2 
     * (experience handled as qualifier)</p><p>Claim.436-E1 (code 
     * system)</p><p>Claim.407-D7 (mnemonic)</p><p>Claim.459-ER 
     * (modifier)</p><p>Claim.418-DI 
     * (modifier)</p><p>DUR/PPS.474-8E 
     * (modifier)</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.category</p><p>D57</p><p>ZPS.5.1</p><p>ZPS.5.2 
     * (experience handled as qualifier)</p><p>Claim.436-E1 (code 
     * system)</p><p>Claim.407-D7 (mnemonic)</p><p>Claim.459-ER 
     * (modifier)</p><p>Claim.418-DI 
     * (modifier)</p><p>DUR/PPS.474-8E 
     * (modifier)</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.category</p><p>D57</p><p>ZPS.5.1</p><p>ZPS.5.2 
     * (experience handled as qualifier)</p><p>Claim.436-E1 (code 
     * system)</p><p>Claim.407-D7 (mnemonic)</p><p>Claim.459-ER 
     * (modifier)</p><p>Claim.418-DI 
     * (modifier)</p><p>DUR/PPS.474-8E 
     * (modifier)</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.category</p><p>D57</p><p>ZPS.5.1</p><p>ZPS.5.2 
     * (experience handled as qualifier)</p><p>Claim.436-E1 (code 
     * system)</p><p>Claim.407-D7 (mnemonic)</p><p>Claim.459-ER 
     * (modifier)</p><p>Claim.418-DI 
     * (modifier)</p><p>DUR/PPS.474-8E 
     * (modifier)</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.category</p><p>D57</p><p>ZPS.5.1</p><p>ZPS.5.2 
     * (experience handled as qualifier)</p><p>Claim.436-E1 (code 
     * system)</p><p>Claim.407-D7 (mnemonic)</p><p>Claim.459-ER 
     * (modifier)</p><p>Claim.418-DI 
     * (modifier)</p><p>DUR/PPS.474-8E 
     * (modifier)</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.category</p><p>D57</p><p>ZPS.5.1</p><p>ZPS.5.2 
     * (experience handled as qualifier)</p><p>Claim.436-E1 (code 
     * system)</p><p>Claim.407-D7 (mnemonic)</p><p>Claim.459-ER 
     * (modifier)</p><p>Claim.418-DI 
     * (modifier)</p><p>DUR/PPS.474-8E 
     * (modifier)</p><p>A_BillableClinicalService</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActProfessionalServiceCode getServiceType() {
        return (ActProfessionalServiceCode) this.serviceType.getValue();
    }
    public void setServiceType(ActProfessionalServiceCode serviceType) {
        this.serviceType.setValue(serviceType);
    }


    /**
     * <p>C:Refuted Indicator</p>
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
     * <p>E:Service Time and Length</p>
     * 
     * <p><p>Center date cannot be null but duration can be left 
     * unspecified if not known.</p></p>
     * 
     * <p><p>The date and time during which the professional 
     * service was performed, as well as the duration of the 
     * service. May be specified as any one or two of start time, 
     * end time and duration.</p></p>
     * 
     * <p><p>PatientConsultation.eventTime(Low)</p><p>patientConsultation.eventDuration(Width)</p><p>ZPS.4 
     * (center)</p><p>ZPS.5.2(timing portion of code 
     * set)</p><p>Claim.457-EP</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.eventTime(Low)</p><p>patientConsultation.eventDuration(Width)</p><p>ZPS.4 
     * (center)</p><p>ZPS.5.2(timing portion of code 
     * set)</p><p>Claim.457-EP</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.eventTime(Low)</p><p>patientConsultation.eventDuration(Width)</p><p>ZPS.4 
     * (center)</p><p>ZPS.5.2(timing portion of code 
     * set)</p><p>Claim.457-EP</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.eventTime(Low)</p><p>patientConsultation.eventDuration(Width)</p><p>ZPS.4 
     * (center)</p><p>ZPS.5.2(timing portion of code 
     * set)</p><p>Claim.457-EP</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.eventTime(Low)</p><p>patientConsultation.eventDuration(Width)</p><p>ZPS.4 
     * (center)</p><p>ZPS.5.2(timing portion of code 
     * set)</p><p>Claim.457-EP</p><p>A_BillableClinicalService</p></p>
     * 
     * <p><p>PatientConsultation.eventTime(Low)</p><p>patientConsultation.eventDuration(Width)</p><p>ZPS.4 
     * (center)</p><p>ZPS.5.2(timing portion of code 
     * set)</p><p>Claim.457-EP</p><p>A_BillableClinicalService</p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getServiceTimeAndLength() {
        return this.serviceTimeAndLength.getValue();
    }
    public void setServiceTimeAndLength(Interval<Date> serviceTimeAndLength) {
        this.serviceTimeAndLength.setValue(serviceTimeAndLength);
    }


    /**
     * <p>D:Service Masking Indicators</p>
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
    public Set<x_BasicConfidentialityKind> getServiceMaskingIndicators() {
        return this.serviceMaskingIndicators.rawSet(x_BasicConfidentialityKind.class);
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


    @Hl7XmlMapping({"performer/actingPerson"})
    public List<ActingPerson> getPerformerActingPerson() {
        return this.performerActingPerson;
    }


    @Hl7XmlMapping({"author"})
    public ChangedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(ChangedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"informant/actingPerson"})
    public ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ActingPerson getInformantActingPerson() {
        return this.informantActingPerson;
    }
    public void setInformantActingPerson(ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ActingPerson informantActingPerson) {
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


    @Hl7XmlMapping({"custodian1/assignedDevice"})
    public EHRRepositoryBean getCustodian1AssignedDevice() {
        return this.custodian1AssignedDevice;
    }
    public void setCustodian1AssignedDevice(EHRRepositoryBean custodian1AssignedDevice) {
        this.custodian1AssignedDevice = custodian1AssignedDevice;
    }


    @Hl7XmlMapping({"custodian2/serviceDeliveryLocation"})
    public ServiceLocationBean getCustodian2ServiceDeliveryLocation() {
        return this.custodian2ServiceDeliveryLocation;
    }
    public void setCustodian2ServiceDeliveryLocation(ServiceLocationBean custodian2ServiceDeliveryLocation) {
        this.custodian2ServiceDeliveryLocation = custodian2ServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"inFulfillmentOf/actRequest"})
    public Request_3Bean getInFulfillmentOfActRequest() {
        return this.inFulfillmentOfActRequest;
    }
    public void setInFulfillmentOfActRequest(Request_3Bean inFulfillmentOfActRequest) {
        this.inFulfillmentOfActRequest = inFulfillmentOfActRequest;
    }


    @Hl7XmlMapping({"definition/actDefinition"})
    public List<ActDefinitionBean> getDefinitionActDefinition() {
        return this.definitionActDefinition;
    }


    @Hl7XmlMapping({"predecessor/oldProcedureEvent"})
    public List<OldProcedureEventBean> getPredecessorOldProcedureEvent() {
        return this.predecessorOldProcedureEvent;
    }


    @Hl7XmlMapping({"reason"})
    public List<BecauseOfBean> getReason() {
        return this.reason;
    }


    @Hl7XmlMapping({"successor/newProcedureEvent"})
    public NewProcedureEventBean getSuccessorNewProcedureEvent() {
        return this.successorNewProcedureEvent;
    }
    public void setSuccessorNewProcedureEvent(NewProcedureEventBean successorNewProcedureEvent) {
        this.successorNewProcedureEvent = successorNewProcedureEvent;
    }


    @Hl7XmlMapping({"subjectOf1"})
    public List<IncludesBean> getSubjectOf1() {
        return this.subjectOf1;
    }


    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    @Hl7XmlMapping({"subjectOf3/clinicalDocumentEvent"})
    public ClinicalDocumentEventBean getSubjectOf3ClinicalDocumentEvent() {
        return this.subjectOf3ClinicalDocumentEvent;
    }
    public void setSubjectOf3ClinicalDocumentEvent(ClinicalDocumentEventBean subjectOf3ClinicalDocumentEvent) {
        this.subjectOf3ClinicalDocumentEvent = subjectOf3ClinicalDocumentEvent;
    }


    @Hl7XmlMapping({"componentOf1"})
    public List<Component2Bean> getComponentOf1() {
        return this.componentOf1;
    }


    @Hl7XmlMapping({"componentOf2/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOf2PatientCareProvisionEvent() {
        return this.componentOf2PatientCareProvisionEvent;
    }

}
