/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.repc_mt220001ca;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCareEventType;
import ca.infoway.messagebuilder.domainvalue.EncounterDischargeDisposition;
import ca.infoway.messagebuilder.domainvalue.x_ActStatusActiveComplete;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.merged.DischargeDiagnosesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.merged.Request_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.merged.TransportedToBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.BecauseOfBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.OccurredAtBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.SupervisedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.pr.merged.HealthcareWorkerBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: B: Discharge/Care Summary Report</p>
 * 
 * <p>Provides contextual overview information for searching 
 * and filtering</p>
 * 
 * <p>Discrete information about the encounter, episode or 
 * other event for which the discharge or care report is being 
 * written.</p>
 */
@Hl7PartTypeMapping({"REPC_MT220001CA.PatientCareProvisionEvent"})
public class DischargeCareSummaryReportBean extends MessagePartBean implements DocumentContent {

    private static final long serialVersionUID = 20140507L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV dischargeDispositionCode = new CVImpl();
    private SupervisedByBean responsibleParty;
    private HealthcareWorkerBean admitterAssignedEntity;
    private HealthcareWorkerBean attenderAssignedEntity;
    private HealthcareWorkerBean dischargerAssignedEntity;
    private OccurredAtBean location;
    private List<DischargeDiagnosesBean> outcomeConditionEvent = new ArrayList<DischargeDiagnosesBean>();
    private Request_1Bean inFulfillmentOfActRequest;
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private TransportedToBean departedByTransportationEvent;


    /**
     * <p>Business Name: M:Reported on Care Composition Link</p>
     * 
     * <p>Relationship: 
     * REPC_MT220001CA.PatientCareProvisionEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for drill-down and for direct association between 
     * the report and the discrete record.</p>
     * 
     * <p>Provides the identifier of the discrete encounter, 
     * episode or care event being reported on.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: M:Reported on Care Composition Link</p>
     * 
     * <p>Relationship: 
     * REPC_MT220001CA.PatientCareProvisionEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for drill-down and for direct association between 
     * the report and the discrete record.</p>
     * 
     * <p>Provides the identifier of the discrete encounter, 
     * episode or care event being reported on.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: C: Discharge/Care Summary Report Type</p>
     * 
     * <p>Relationship: 
     * REPC_MT220001CA.PatientCareProvisionEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Discharge/Care Summary</p><p>Report Type is used for 
     * searching and for organizing Discharge-Care</p><p>Summary 
     * records as well as sorting them for 
     * presentation.&lt;/html:i&gt;</p><p>&lt;/html:p&gt;</p><p>&lt;html:p 
     * xmlns:html=&quot;http://www.w3.org/1999/xhtml&quot;&gt;</p><p>&lt;html:i 
     * xmlns:html=&quot;http://www.w3.org/1999/xhtml&quot;&gt;This 
     * is a key attribute</p><p>for understanding the type of 
     * record and is therefore mandatory.</p><p>This element makes 
     * use of the CD datatype to allow for use of the SNOMED code 
     * system that in some circumstances requires the use of 
     * post-coordination. Post-coordination is only supported by 
     * the CD datatype.</p>
     * 
     * <p>Identifies the type orcategory Summary Report represented 
     * by this record.</p><p>The discharge / care report summarizes 
     * the events and activities that happened during care 
     * including who is responsible for the care provided. The 
     * report is sent at the termination of care. In this case, the 
     * performer is the sending provider.</p><p>Examples: Inpatient 
     * stay,cardiology, etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCareEventType getCode() {
        return (ActCareEventType) this.code.getValue();
    }

    /**
     * <p>Business Name: C: Discharge/Care Summary Report Type</p>
     * 
     * <p>Relationship: 
     * REPC_MT220001CA.PatientCareProvisionEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Discharge/Care Summary</p><p>Report Type is used for 
     * searching and for organizing Discharge-Care</p><p>Summary 
     * records as well as sorting them for 
     * presentation.&lt;/html:i&gt;</p><p>&lt;/html:p&gt;</p><p>&lt;html:p 
     * xmlns:html=&quot;http://www.w3.org/1999/xhtml&quot;&gt;</p><p>&lt;html:i 
     * xmlns:html=&quot;http://www.w3.org/1999/xhtml&quot;&gt;This 
     * is a key attribute</p><p>for understanding the type of 
     * record and is therefore mandatory.</p><p>This element makes 
     * use of the CD datatype to allow for use of the SNOMED code 
     * system that in some circumstances requires the use of 
     * post-coordination. Post-coordination is only supported by 
     * the CD datatype.</p>
     * 
     * <p>Identifies the type orcategory Summary Report represented 
     * by this record.</p><p>The discharge / care report summarizes 
     * the events and activities that happened during care 
     * including who is responsible for the care provided. The 
     * report is sent at the termination of care. In this case, the 
     * performer is the sending provider.</p><p>Examples: Inpatient 
     * stay,cardiology, etc.</p>
     */
    public void setCode(ActCareEventType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: D: Preliminary/Final Indicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT220001CA.PatientCareProvisionEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Status is frequentlyused to filter query responses as 
     * well as to sort records for presentation. It also affects 
     * how the Discharge-Care Summary record is 
     * interpreted.</p><p>Because the status won't always be known, 
     * the attribute is marked as 'populated' to allow the use of 
     * null flavors.</p>
     * 
     * <p>This identifies the current state of the Discharge-Care 
     * Summary record.</p><p>If the status is 'active'it means that 
     * the assessment is ongoing and the report is preliminary. 
     * Ifthe status is 'completed' it means that the assessment is 
     * finished and the report is considered complete.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public x_ActStatusActiveComplete getStatusCode() {
        return (x_ActStatusActiveComplete) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: D: Preliminary/Final Indicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT220001CA.PatientCareProvisionEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Status is frequentlyused to filter query responses as 
     * well as to sort records for presentation. It also affects 
     * how the Discharge-Care Summary record is 
     * interpreted.</p><p>Because the status won't always be known, 
     * the attribute is marked as 'populated' to allow the use of 
     * null flavors.</p>
     * 
     * <p>This identifies the current state of the Discharge-Care 
     * Summary record.</p><p>If the status is 'active'it means that 
     * the assessment is ongoing and the report is preliminary. 
     * Ifthe status is 'completed' it means that the assessment is 
     * finished and the report is considered complete.</p>
     */
    public void setStatusCode(x_ActStatusActiveComplete statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: F: Discharge/Care Summary Report Period</p>
     * 
     * <p>Relationship: 
     * REPC_MT220001CA.PatientCareProvisionEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the time-period of relevance to the record 
     * which is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * period covered by a discharge or care summary should always 
     * be known, this attribute is mandatory.</p>
     * 
     * <p>Indicates the period of care to which the discharge or 
     * care report applies. For an encounter discharge assessment, 
     * this would be the admission and discharge date.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: F: Discharge/Care Summary Report Period</p>
     * 
     * <p>Relationship: 
     * REPC_MT220001CA.PatientCareProvisionEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the time-period of relevance to the record 
     * which is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * period covered by a discharge or care summary should always 
     * be known, this attribute is mandatory.</p>
     * 
     * <p>Indicates the period of care to which the discharge or 
     * care report applies. For an encounter discharge assessment, 
     * this would be the admission and discharge date.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: N:Discharge Disposition</p>
     * 
     * <p>Relationship: 
     * REPC_MT220001CA.PatientCareProvisionEvent.dischargeDispositionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>May be important in planning subsequent care for the 
     * patient. Something must be said about discharge condition 
     * but in some circumstances the value may not be known. Thus 
     * the attribute is treated as 'populated'.</p>
     * 
     * <p>Indicates the manner in which the patient left the 
     * encounter or other care event. E.g. 'Deceased', 'Discharged 
     * to home', 'Discharged to isolation'</p>
     */
    @Hl7XmlMapping({"dischargeDispositionCode"})
    public EncounterDischargeDisposition getDischargeDispositionCode() {
        return (EncounterDischargeDisposition) this.dischargeDispositionCode.getValue();
    }

    /**
     * <p>Business Name: N:Discharge Disposition</p>
     * 
     * <p>Relationship: 
     * REPC_MT220001CA.PatientCareProvisionEvent.dischargeDispositionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>May be important in planning subsequent care for the 
     * patient. Something must be said about discharge condition 
     * but in some circumstances the value may not be known. Thus 
     * the attribute is treated as 'populated'.</p>
     * 
     * <p>Indicates the manner in which the patient left the 
     * encounter or other care event. E.g. 'Deceased', 'Discharged 
     * to home', 'Discharged to isolation'</p>
     */
    public void setDischargeDispositionCode(EncounterDischargeDisposition dischargeDispositionCode) {
        this.dischargeDispositionCode.setValue(dischargeDispositionCode);
    }


    /**
     * <p>Relationship: 
     * REPC_MT220001CA.PatientCareProvisionEvent.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"consultant","responsibleParty"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="consultant", type="REPC_MT220001CA.Consultant"),
        @Hl7MapByPartType(name="responsibleParty", type="REPC_MT220001CA.ResponsibleParty")})
    public SupervisedByBean getResponsibleParty() {
        return this.responsibleParty;
    }

    /**
     * <p>Relationship: 
     * REPC_MT220001CA.PatientCareProvisionEvent.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsibleParty(SupervisedByBean responsibleParty) {
        this.responsibleParty = responsibleParty;
    }


    /**
     * <p>Relationship: REPC_MT220001CA.Admitter.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"admitter/assignedEntity"})
    public HealthcareWorkerBean getAdmitterAssignedEntity() {
        return this.admitterAssignedEntity;
    }

    /**
     * <p>Relationship: REPC_MT220001CA.Admitter.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setAdmitterAssignedEntity(HealthcareWorkerBean admitterAssignedEntity) {
        this.admitterAssignedEntity = admitterAssignedEntity;
    }


    /**
     * <p>Relationship: REPC_MT220001CA.Attender.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"attender/assignedEntity"})
    public HealthcareWorkerBean getAttenderAssignedEntity() {
        return this.attenderAssignedEntity;
    }

    /**
     * <p>Relationship: REPC_MT220001CA.Attender.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setAttenderAssignedEntity(HealthcareWorkerBean attenderAssignedEntity) {
        this.attenderAssignedEntity = attenderAssignedEntity;
    }


    /**
     * <p>Relationship: REPC_MT220001CA.Discharger.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"discharger/assignedEntity"})
    public HealthcareWorkerBean getDischargerAssignedEntity() {
        return this.dischargerAssignedEntity;
    }

    /**
     * <p>Relationship: REPC_MT220001CA.Discharger.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDischargerAssignedEntity(HealthcareWorkerBean dischargerAssignedEntity) {
        this.dischargerAssignedEntity = dischargerAssignedEntity;
    }


    /**
     * <p>Relationship: 
     * REPC_MT220001CA.PatientCareProvisionEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: 
     * REPC_MT220001CA.PatientCareProvisionEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: REPC_MT220001CA.Outcome.conditionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"outcome/conditionEvent"})
    public List<DischargeDiagnosesBean> getOutcomeConditionEvent() {
        return this.outcomeConditionEvent;
    }


    /**
     * <p>Relationship: REPC_MT220001CA.InFulfillmentOf.actRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/actRequest"})
    public Request_1Bean getInFulfillmentOfActRequest() {
        return this.inFulfillmentOfActRequest;
    }

    /**
     * <p>Relationship: REPC_MT220001CA.InFulfillmentOf.actRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInFulfillmentOfActRequest(Request_1Bean inFulfillmentOfActRequest) {
        this.inFulfillmentOfActRequest = inFulfillmentOfActRequest;
    }


    /**
     * <p>Relationship: REPC_MT220001CA.DocumentContent.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     */
    @Hl7XmlMapping({"reason"})
    public List<BecauseOfBean> getReason() {
        return this.reason;
    }


    /**
     * <p>Relationship: 
     * REPC_MT220001CA.DepartedBy.transportationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"departedBy/transportationEvent"})
    public TransportedToBean getDepartedByTransportationEvent() {
        return this.departedByTransportationEvent;
    }

    /**
     * <p>Relationship: 
     * REPC_MT220001CA.DepartedBy.transportationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDepartedByTransportationEvent(TransportedToBean departedByTransportationEvent) {
        this.departedByTransportationEvent = departedByTransportationEvent;
    }

}
