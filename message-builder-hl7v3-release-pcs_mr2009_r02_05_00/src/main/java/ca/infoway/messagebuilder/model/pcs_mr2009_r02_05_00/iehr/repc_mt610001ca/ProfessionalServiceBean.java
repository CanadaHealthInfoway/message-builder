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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.repc_mt610001ca;

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
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActProfessionalServiceCode;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.merged.Patient_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.merged.ActDefinitionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.merged.ClinicalDocumentEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.merged.OldProcedureEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.merged.Request_3Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.ActingPerson;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.BecauseOfBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.OccurredAtBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.pr.merged.HealthcareWorkerBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Professional Service</p>
 * 
 * <p>A_BillableClinicalService</p>
 * 
 * <p>Information about surgeries, councilling and other 
 * professional services is a key element of the EHR. It 
 * provides context around services provided and may inform 
 * choices about how best to manage the patient's 
 * healthcare.</p>
 * 
 * <p>This is the information that is recorded and maintained 
 * on a consultative, surgical or physical service (procedure) 
 * provided to the patient.</p><p>Counseling, education, 
 * surgeries and physical therapy are examples of the types of 
 * services that can be captured.</p>
 */
@Hl7PartTypeMapping({"REPC_MT610001CA.ProcedureEvent"})
@Hl7RootType
public class ProfessionalServiceBean extends MessagePartBean {

    private static final long serialVersionUID = 20140507L;
    private CD code = new CDImpl();
    private BL negationInd = new BLImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private List<ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt911108ca.ActingPerson> performerActingPerson = new ArrayList<ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt911108ca.ActingPerson>();
    private ActingPerson informantActingPerson;
    private OccurredAtBean location;
    private Request_3Bean inFulfillmentOfActRequest;
    private List<ActDefinitionBean> definitionActDefinition = new ArrayList<ActDefinitionBean>();
    private List<OldProcedureEventBean> predecessorOldProcedureEvent = new ArrayList<OldProcedureEventBean>();
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private IncludesBean subjectOf1;
    private ClinicalDocumentEventBean subjectOf2ClinicalDocumentEvent;
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>Business Name: B:Service Type</p>
     * 
     * <p>Relationship: REPC_MT610001CA.ProcedureEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PatientConsultation.category</p>
     * 
     * <p>D57</p>
     * 
     * <p>ZPS.5.1</p>
     * 
     * <p>ZPS.5.2 (experience handled as qualifier)</p>
     * 
     * <p>Claim.436-E1 (code system)</p>
     * 
     * <p>Claim.407-D7 (mnemonic)</p>
     * 
     * <p>Claim.459-ER (modifier)</p>
     * 
     * <p>Claim.418-DI (modifier)</p>
     * 
     * <p>DUR/PPS.474-8E (modifier)</p>
     * 
     * <p>A_BillableClinicalService</p>
     * 
     * <p> <i>Service Type is used for searching and for organizing 
     * Professional Service records as well as sorting them for 
     * presentation.</i> </p><p> <i>This is a key attribute for 
     * understanding the type of record and is therefore 
     * mandatory.</i> </p><p> <i>This element makes use of the CD 
     * datatype to allow for use of the SNOMED code system that in 
     * some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p><p> <i>The element uses CWE to allow for the capture of 
     * Service Type concepts not presently supported by the 
     * approved code system(s). In this case, the human-to-human 
     * benefit of capturing additional non-coded values outweighs 
     * the penalties of capturing some information that will not be 
     * amenable to searching or categorizing.</i> </p>
     * 
     * <p> <i>Identifies the type of Professional Service 
     * represented by this record.</i> </p><p>e.g. appendectomy, 
     * smoking cessation counseling, physiotherapy</p>
     */
    @Hl7XmlMapping({"code"})
    public ActProfessionalServiceCode getCode() {
        return (ActProfessionalServiceCode) this.code.getValue();
    }

    /**
     * <p>Business Name: B:Service Type</p>
     * 
     * <p>Relationship: REPC_MT610001CA.ProcedureEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PatientConsultation.category</p>
     * 
     * <p>D57</p>
     * 
     * <p>ZPS.5.1</p>
     * 
     * <p>ZPS.5.2 (experience handled as qualifier)</p>
     * 
     * <p>Claim.436-E1 (code system)</p>
     * 
     * <p>Claim.407-D7 (mnemonic)</p>
     * 
     * <p>Claim.459-ER (modifier)</p>
     * 
     * <p>Claim.418-DI (modifier)</p>
     * 
     * <p>DUR/PPS.474-8E (modifier)</p>
     * 
     * <p>A_BillableClinicalService</p>
     * 
     * <p> <i>Service Type is used for searching and for organizing 
     * Professional Service records as well as sorting them for 
     * presentation.</i> </p><p> <i>This is a key attribute for 
     * understanding the type of record and is therefore 
     * mandatory.</i> </p><p> <i>This element makes use of the CD 
     * datatype to allow for use of the SNOMED code system that in 
     * some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p><p> <i>The element uses CWE to allow for the capture of 
     * Service Type concepts not presently supported by the 
     * approved code system(s). In this case, the human-to-human 
     * benefit of capturing additional non-coded values outweighs 
     * the penalties of capturing some information that will not be 
     * amenable to searching or categorizing.</i> </p>
     * 
     * <p> <i>Identifies the type of Professional Service 
     * represented by this record.</i> </p><p>e.g. appendectomy, 
     * smoking cessation counseling, physiotherapy</p>
     */
    public void setCode(ActProfessionalServiceCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: C:Refuted Indicator</p>
     * 
     * <p>Relationship: REPC_MT610001CA.ProcedureEvent.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>This is primarily used to supersede records where an 
     * assertion was made that is subsequently determined to be 
     * false. It is important to be able to make explicit 
     * statements that something is known to not be true.</i> 
     * </p><p> <i>This element is mandatory because it should 
     * always be known whether the record is being refuted or 
     * not.</i> </p>
     * 
     * <p> <i>When set to true, specifically flags the Professional 
     * Service record as &quot;did not occur&quot;. The default is 
     * false. Additional details about the reasons for refuting the 
     * record may be conveyed in notes.</i> </p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Business Name: C:Refuted Indicator</p>
     * 
     * <p>Relationship: REPC_MT610001CA.ProcedureEvent.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>This is primarily used to supersede records where an 
     * assertion was made that is subsequently determined to be 
     * false. It is important to be able to make explicit 
     * statements that something is known to not be true.</i> 
     * </p><p> <i>This element is mandatory because it should 
     * always be known whether the record is being refuted or 
     * not.</i> </p>
     * 
     * <p> <i>When set to true, specifically flags the Professional 
     * Service record as &quot;did not occur&quot;. The default is 
     * false. Additional details about the reasons for refuting the 
     * record may be conveyed in notes.</i> </p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Business Name: E:Service Time and Length</p>
     * 
     * <p>Relationship: 
     * REPC_MT610001CA.ProcedureEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Center date cannot be null but duration can be left 
     * unspecified if not known.</p>
     * 
     * <p>PatientConsultation.eventTime(Low)</p>
     * 
     * <p>patientConsultation.eventDuration(Width)</p>
     * 
     * <p>ZPS.4 (center)</p>
     * 
     * <p>ZPS.5.2(timing portion of code set)</p>
     * 
     * <p>Claim.457-EP</p>
     * 
     * <p>A_BillableClinicalService</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p>
     * 
     * <p>The date and time during which the professional service 
     * was performed, as well as the duration of the service. May 
     * be specified as any one or two of start time, end time and 
     * duration.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: E:Service Time and Length</p>
     * 
     * <p>Relationship: 
     * REPC_MT610001CA.ProcedureEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Center date cannot be null but duration can be left 
     * unspecified if not known.</p>
     * 
     * <p>PatientConsultation.eventTime(Low)</p>
     * 
     * <p>patientConsultation.eventDuration(Width)</p>
     * 
     * <p>ZPS.4 (center)</p>
     * 
     * <p>ZPS.5.2(timing portion of code set)</p>
     * 
     * <p>Claim.457-EP</p>
     * 
     * <p>A_BillableClinicalService</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p>
     * 
     * <p>The date and time during which the professional service 
     * was performed, as well as the duration of the service. May 
     * be specified as any one or two of start time, end time and 
     * duration.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: D:Service Masking Indicators</p>
     * 
     * <p>Relationship: 
     * REPC_MT610001CA.ProcedureEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     * 
     * <p>The value specified for a particular record may be 
     * overridden by a higher level masking applied to an 
     * indication, a care composition, a type of record or even all 
     * patient records.</p>
     * 
     * <p>Communicates the desire of the patient to restrict access 
     * to this Care Composition record. Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information. Methods for 
     * accessing masked event records will be governed by each 
     * jurisdiction (e.g. court orders, shared secret/consent, 
     * etc.).</p><p>Can also be used to communicate that the 
     * information is deemed to be sensitive and should not be 
     * communicated or exposed to the patient (at least without the 
     * guidance of the authoring or other responsible healthcare 
     * provider).</p><p>Valid values are: 'normal' (denotes 'Not 
     * Masked'); 'restricted' (denotes 'Masked') and 'taboo' 
     * (denotes 'patient restricted'). The default is 'normal' 
     * signifying 'Not Masked'. Either or both of the other codes 
     * can be asserted to indicate masking by the patient from 
     * providers or masking by a provider from the patient, 
     * respectively. 'normal' should never be asserted with one of 
     * the other codes.</p><p>Masking a care composition record 
     * masks it for all associated patients (i.e. all patients 
     * involved in the care composition as a group).</p><p>Also, 
     * masking a care composition implicitly masks all records 
     * associated with that care composition.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Relationship: REPC_MT610001CA.Performer.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"performer/actingPerson"})
    public List<ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt911108ca.ActingPerson> getPerformerActingPerson() {
        return this.performerActingPerson;
    }


    /**
     * <p>Relationship: REPC_MT610001CA.Informant.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"informant/actingPerson"})
    public ActingPerson getInformantActingPerson() {
        return this.informantActingPerson;
    }

    /**
     * <p>Relationship: REPC_MT610001CA.Informant.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
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
     * <p>Relationship: REPC_MT610001CA.ProcedureEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: REPC_MT610001CA.ProcedureEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: REPC_MT610001CA.InFulfillmentOf.actRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/actRequest"})
    public Request_3Bean getInFulfillmentOfActRequest() {
        return this.inFulfillmentOfActRequest;
    }

    /**
     * <p>Relationship: REPC_MT610001CA.InFulfillmentOf.actRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInFulfillmentOfActRequest(Request_3Bean inFulfillmentOfActRequest) {
        this.inFulfillmentOfActRequest = inFulfillmentOfActRequest;
    }


    /**
     * <p>Relationship: REPC_MT610001CA.Definition.actDefinition</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"definition/actDefinition"})
    public List<ActDefinitionBean> getDefinitionActDefinition() {
        return this.definitionActDefinition;
    }


    /**
     * <p>Relationship: 
     * REPC_MT610001CA.Predecessor.oldProcedureEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"predecessor/oldProcedureEvent"})
    public List<OldProcedureEventBean> getPredecessorOldProcedureEvent() {
        return this.predecessorOldProcedureEvent;
    }


    /**
     * <p>Relationship: REPC_MT610001CA.ProcedureEvent.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     */
    @Hl7XmlMapping({"reason"})
    public List<BecauseOfBean> getReason() {
        return this.reason;
    }


    /**
     * <p>Relationship: REPC_MT610001CA.ProcedureEvent.subjectOf1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"subjectOf1"})
    public IncludesBean getSubjectOf1() {
        return this.subjectOf1;
    }

    /**
     * <p>Relationship: REPC_MT610001CA.ProcedureEvent.subjectOf1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setSubjectOf1(IncludesBean subjectOf1) {
        this.subjectOf1 = subjectOf1;
    }


    /**
     * <p>Relationship: 
     * REPC_MT610001CA.Subject4.clinicalDocumentEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/clinicalDocumentEvent"})
    public ClinicalDocumentEventBean getSubjectOf2ClinicalDocumentEvent() {
        return this.subjectOf2ClinicalDocumentEvent;
    }

    /**
     * <p>Relationship: 
     * REPC_MT610001CA.Subject4.clinicalDocumentEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf2ClinicalDocumentEvent(ClinicalDocumentEventBean subjectOf2ClinicalDocumentEvent) {
        this.subjectOf2ClinicalDocumentEvent = subjectOf2ClinicalDocumentEvent;
    }


    /**
     * <p>Relationship: 
     * REPC_MT610001CA.Component2.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
