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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.repc_mt610001ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActProfessionalServiceCode;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt910108ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt911108ca.ActingPerson;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.Patient_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.ActDefinitionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.ClinicalDocumentEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.OldProcedureEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.Request_3Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.BecauseOfBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.OccurredAtBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Professional Service</p>
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
@Hl7PartTypeMapping({"REPC_MT610001CA.ProcedureEvent"})
@Hl7RootType
public class ProfessionalServiceBean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private CD serviceType = new CDImpl();
    private BL refutedIndicator = new BLImpl();
    private IVL<TS, Interval<Date>> serviceTimeAndLength = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> serviceMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private List<ActingPerson> performerActingPerson = new ArrayList<ActingPerson>();
    private ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ActingPerson informantActingPerson;
    private OccurredAtBean location;
    private Request_3Bean inFulfillmentOfActRequest;
    private List<ActDefinitionBean> definitionActDefinition = new ArrayList<ActDefinitionBean>();
    private List<OldProcedureEventBean> predecessorOldProcedureEvent = new ArrayList<OldProcedureEventBean>();
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private IncludesBean subjectOf1;
    private ClinicalDocumentEventBean subjectOf2ClinicalDocumentEvent;
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


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


    @Hl7XmlMapping({"performer/actingPerson"})
    public List<ActingPerson> getPerformerActingPerson() {
        return this.performerActingPerson;
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


    @Hl7XmlMapping({"subjectOf1"})
    public IncludesBean getSubjectOf1() {
        return this.subjectOf1;
    }
    public void setSubjectOf1(IncludesBean subjectOf1) {
        this.subjectOf1 = subjectOf1;
    }


    @Hl7XmlMapping({"subjectOf2/clinicalDocumentEvent"})
    public ClinicalDocumentEventBean getSubjectOf2ClinicalDocumentEvent() {
        return this.subjectOf2ClinicalDocumentEvent;
    }
    public void setSubjectOf2ClinicalDocumentEvent(ClinicalDocumentEventBean subjectOf2ClinicalDocumentEvent) {
        this.subjectOf2ClinicalDocumentEvent = subjectOf2ClinicalDocumentEvent;
    }


    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
