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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.repc_mt500001ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCareEventType;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt050202ca.PatientBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt910108ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt911108ca.ActingPerson;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.Patient_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged.DischargeDiagnosisBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged.ParticipantGroupingsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged.Request_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.ActEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.BecauseOfBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.OccurredAtBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.SpecimenRoleBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Care Composition</p>
 * 
 * <p>Care compositions allow grouping together numerous 
 * related records which aids searching and navigation. Also, 
 * the mere knowledge that a type of care has occurred or is 
 * occurring (e.g. an in-patient hospital encounter) can be 
 * useful information when delivering subsequent care.</p>
 * 
 * <p>A care composition is a record with two purposes. It 
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
 * care&quot;.</p>
 */
@Hl7PartTypeMapping({"REPC_MT500001CA.PatientCareProvisionEvent"})
@Hl7RootType
public class CareCompositionBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private CV code = new CVImpl();
    private BL negationInd = new BLImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private SpecimenRoleBean subject1Specimen;
    private List<PatientBean> subject2Patient = new ArrayList<PatientBean>();
    private List<ActingPerson> performerActingPerson = new ArrayList<ActingPerson>();
    private ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.ActingPerson informantActingPerson;
    private ActingPerson dischargerActingPerson;
    private List<OccurredAtBean> location = new ArrayList<OccurredAtBean>();
    private List<DischargeDiagnosisBean> outcomeDiagnosisEvent = new ArrayList<DischargeDiagnosisBean>();
    private Request_1Bean inFulfillmentOfActRequest;
    private List<II> predecessorOldPatientCareProvisionEventId = new ArrayList<II>();
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private List<ActEventBean> component1ActEvent = new ArrayList<ActEventBean>();
    private List<ParticipantGroupingsBean> component2PatientCareProvisionEventPortion = new ArrayList<ParticipantGroupingsBean>();
    private IncludesBean subjectOf;
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>Business Name: B: Care Composition Type</p>
     * 
     * <p>Relationship: 
     * REPC_MT500001CA.PatientCareProvisionEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Care Composition Type is used for searching and for 
     * organizing Care Composition records as well as sorting them 
     * for presentation.</i> </p><p> <i>This is a key attribute for 
     * understanding the type of record and is therefore 
     * mandatory.</i> </p>
     * 
     * <p> <i>Identifies the type of Care Composition represented 
     * by this record.</i> </p><p>Care Composition is the generic 
     * name given to event 'containers' such as Encounters, 
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
     * Cardiology Care, etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCareEventType getCode() {
        return (ActCareEventType) this.code.getValue();
    }

    /**
     * <p>Business Name: B: Care Composition Type</p>
     * 
     * <p>Relationship: 
     * REPC_MT500001CA.PatientCareProvisionEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Care Composition Type is used for searching and for 
     * organizing Care Composition records as well as sorting them 
     * for presentation.</i> </p><p> <i>This is a key attribute for 
     * understanding the type of record and is therefore 
     * mandatory.</i> </p>
     * 
     * <p> <i>Identifies the type of Care Composition represented 
     * by this record.</i> </p><p>Care Composition is the generic 
     * name given to event 'containers' such as Encounters, 
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
     * Cardiology Care, etc.</p>
     */
    public void setCode(ActCareEventType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: D:Refuted Indicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT500001CA.PatientCareProvisionEvent.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Refuted Indicator cannot be specified unless Care 
     * Composition Type is Encounter or a specialization 
     * there-of.</p>
     * 
     * <p> <i>This is primarily used to supersede records where an 
     * assertion was made that is subsequently determined to be 
     * false. It is important to be able to make explicit 
     * statements that something is known to not be true.</i> 
     * </p><p> <i>This element is mandatory because it should 
     * always be known whether the record is being refuted or 
     * not.</i> </p>
     * 
     * <p> <i>When set to true, specifically flags the Care 
     * Composition record as &quot;did not occur&quot;. The default 
     * is false. Additional details about the reasons for refuting 
     * the record may be conveyed in notes.</i> </p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Business Name: D:Refuted Indicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT500001CA.PatientCareProvisionEvent.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Refuted Indicator cannot be specified unless Care 
     * Composition Type is Encounter or a specialization 
     * there-of.</p>
     * 
     * <p> <i>This is primarily used to supersede records where an 
     * assertion was made that is subsequently determined to be 
     * false. It is important to be able to make explicit 
     * statements that something is known to not be true.</i> 
     * </p><p> <i>This element is mandatory because it should 
     * always be known whether the record is being refuted or 
     * not.</i> </p>
     * 
     * <p> <i>When set to true, specifically flags the Care 
     * Composition record as &quot;did not occur&quot;. The default 
     * is false. Additional details about the reasons for refuting 
     * the record may be conveyed in notes.</i> </p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Business Name: C: Care Composition Status</p>
     * 
     * <p>Relationship: 
     * REPC_MT500001CA.PatientCareProvisionEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p> <i>Status is frequently used to filter query responses 
     * as well as to sort records for presentation. It also affects 
     * how the Care Composition record is interpreted.</i> </p><p> 
     * <i>Because the status won't always be known, the attribute 
     * is marked as 'populated' to allow the use of null 
     * flavors.</i> </p>
     * 
     * <p> <i>This identifies the current state of the Care 
     * Composition record. Allowed status values are 'active' (the 
     * encounter, episode or general delivery of care ongoing) and 
     * 'completed' (the encounter, episode or general care has 
     * ended).</i> </p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: C: Care Composition Status</p>
     * 
     * <p>Relationship: 
     * REPC_MT500001CA.PatientCareProvisionEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p> <i>Status is frequently used to filter query responses 
     * as well as to sort records for presentation. It also affects 
     * how the Care Composition record is interpreted.</i> </p><p> 
     * <i>Because the status won't always be known, the attribute 
     * is marked as 'populated' to allow the use of null 
     * flavors.</i> </p>
     * 
     * <p> <i>This identifies the current state of the Care 
     * Composition record. Allowed status values are 'active' (the 
     * encounter, episode or general delivery of care ongoing) and 
     * 'completed' (the encounter, episode or general care has 
     * ended).</i> </p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: F: Care Composition Period</p>
     * 
     * <p>Relationship: 
     * REPC_MT500001CA.PatientCareProvisionEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p>
     * 
     * <p>Represents the start and end of the date/time interval 
     * during which the care described by the composition was/is 
     * being provided.</p><p>E.g. The admission and discharge 
     * date/time; the date on which the episode began and ended; 
     * etc.</p><p>Please note that it is possible for many episodes 
     * and care events to not have an end date; in these 
     * situations, only the start date will be specified. Even 
     * encounters will not have an end date until the encounter is 
     * completed/patient is discharged.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: F: Care Composition Period</p>
     * 
     * <p>Relationship: 
     * REPC_MT500001CA.PatientCareProvisionEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p>
     * 
     * <p>Represents the start and end of the date/time interval 
     * during which the care described by the composition was/is 
     * being provided.</p><p>E.g. The admission and discharge 
     * date/time; the date on which the episode began and ended; 
     * etc.</p><p>Please note that it is possible for many episodes 
     * and care events to not have an end date; in these 
     * situations, only the start date will be specified. Even 
     * encounters will not have an end date until the encounter is 
     * completed/patient is discharged.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: E: Care Composition Masking Indicators</p>
     * 
     * <p>Relationship: 
     * REPC_MT500001CA.PatientCareProvisionEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     * 
     * <p></p>
     * 
     * <p> <i>The value specified for a particular record may be 
     * overridden by a higher level masking applied to an 
     * indication, a care composition, a type of record or even all 
     * patient records.</i> </p>
     * 
     * <p> <i>Communicates the desire of the patient to restrict 
     * access to this Care Composition record. Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information. Methods for 
     * accessing masked event records will be governed by each 
     * jurisdiction (e.g. court orders, shared secret/consent, 
     * etc.).</i> </p><p> <i>Can also be used to communicate that 
     * the information is deemed to be sensitive and should not be 
     * communicated or exposed to the patient (at least without the 
     * guidance of the authoring or other responsible healthcare 
     * provider).</i> </p><p> <i>Valid values are: 'normal' 
     * (denotes 'Not Masked'); 'restricted' (denotes 'Masked') and 
     * 'taboo' (denotes 'patient restricted'). The default is 
     * 'normal' signifying 'Not Masked'. Either or both of the 
     * other codes can be asserted to indicate masking by the 
     * patient from providers or masking by a provider from the 
     * patient, respectively. 'normal' should never be asserted 
     * with one of the other codes.</i> </p><p>Masking a care 
     * composition record masks it for all associated patients 
     * (i.e. all patients involved in the care composition as a 
     * group).</p><p>Also, masking a care composition implicitly 
     * masks all records associated with that care composition.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Relationship: REPC_MT500001CA.Subject6.specimen</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subject1/specimen"})
    public SpecimenRoleBean getSubject1Specimen() {
        return this.subject1Specimen;
    }

    /**
     * <p>Relationship: REPC_MT500001CA.Subject6.specimen</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubject1Specimen(SpecimenRoleBean subject1Specimen) {
        this.subject1Specimen = subject1Specimen;
    }


    /**
     * <p>Relationship: REPC_MT500001CA.Subject7.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject2/patient"})
    public List<PatientBean> getSubject2Patient() {
        return this.subject2Patient;
    }


    /**
     * <p>Relationship: REPC_MT500001CA.Performer3.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"performer/actingPerson"})
    public List<ActingPerson> getPerformerActingPerson() {
        return this.performerActingPerson;
    }


    /**
     * <p>Relationship: REPC_MT500001CA.Informant.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"informant/actingPerson"})
    public ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.ActingPerson getInformantActingPerson() {
        return this.informantActingPerson;
    }

    /**
     * <p>Relationship: REPC_MT500001CA.Informant.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInformantActingPerson(ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.ActingPerson informantActingPerson) {
        this.informantActingPerson = informantActingPerson;
    }

    public HealthcareOrganizationBean getInformantActingPersonAsAssignedEntity1() {
        return this.informantActingPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.informantActingPerson : null;
    }
    public boolean hasInformantActingPersonAsAssignedEntity1() {
        return (this.informantActingPerson instanceof HealthcareOrganizationBean);
    }

    public ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean getInformantActingPersonAsAssignedEntity2() {
        return this.informantActingPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean ? (ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean) this.informantActingPerson : null;
    }
    public boolean hasInformantActingPersonAsAssignedEntity2() {
        return (this.informantActingPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean);
    }

    public Patient_2Bean getInformantActingPersonAsPatient() {
        return this.informantActingPerson instanceof Patient_2Bean ? (Patient_2Bean) this.informantActingPerson : null;
    }
    public boolean hasInformantActingPersonAsPatient() {
        return (this.informantActingPerson instanceof Patient_2Bean);
    }


    /**
     * <p>Relationship: REPC_MT500001CA.Discharger.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"discharger/actingPerson"})
    public ActingPerson getDischargerActingPerson() {
        return this.dischargerActingPerson;
    }

    /**
     * <p>Relationship: REPC_MT500001CA.Discharger.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDischargerActingPerson(ActingPerson dischargerActingPerson) {
        this.dischargerActingPerson = dischargerActingPerson;
    }

    public HealthcareOrganizationBean getDischargerActingPersonAsAssignedEntity1() {
        return this.dischargerActingPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.dischargerActingPerson : null;
    }
    public boolean hasDischargerActingPersonAsAssignedEntity1() {
        return (this.dischargerActingPerson instanceof HealthcareOrganizationBean);
    }

    public ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean getDischargerActingPersonAsAssignedEntity2() {
        return this.dischargerActingPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean ? (ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean) this.dischargerActingPerson : null;
    }
    public boolean hasDischargerActingPersonAsAssignedEntity2() {
        return (this.dischargerActingPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean);
    }

    public RelatedPersonBean getDischargerActingPersonAsPersonalRelationship() {
        return this.dischargerActingPerson instanceof RelatedPersonBean ? (RelatedPersonBean) this.dischargerActingPerson : null;
    }
    public boolean hasDischargerActingPersonAsPersonalRelationship() {
        return (this.dischargerActingPerson instanceof RelatedPersonBean);
    }


    /**
     * <p>Relationship: 
     * REPC_MT500001CA.PatientCareProvisionEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"location"})
    public List<OccurredAtBean> getLocation() {
        return this.location;
    }


    /**
     * <p>Relationship: REPC_MT500001CA.Outcome.diagnosisEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"outcome/diagnosisEvent"})
    public List<DischargeDiagnosisBean> getOutcomeDiagnosisEvent() {
        return this.outcomeDiagnosisEvent;
    }


    /**
     * <p>Relationship: REPC_MT500001CA.InFulfillmentOf.actRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/actRequest"})
    public Request_1Bean getInFulfillmentOfActRequest() {
        return this.inFulfillmentOfActRequest;
    }

    /**
     * <p>Relationship: REPC_MT500001CA.InFulfillmentOf.actRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInFulfillmentOfActRequest(Request_1Bean inFulfillmentOfActRequest) {
        this.inFulfillmentOfActRequest = inFulfillmentOfActRequest;
    }


    /**
     * <p>Business Name: F:Replaces Record Ids</p>
     * 
     * <p>Relationship: 
     * REPC_MT500001CA.OldPatientCareProvisionEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Used in circumstances where information initially 
     * captured about an event is erroneous, incomplete or not 
     * captured at the desired level of detail and the change 
     * cannot be made by retracting the original record. (E.g. Too 
     * much time has elapsed, change is being made by a provider 
     * other than the original author of the vent record, etc.) May 
     * also be used to reference multiple records in the case where 
     * the same event has been accidentally captured more than 
     * once.</i> </p>
     * 
     * <p> <i>Used to identify any records that are 
     * &quot;superseded&quot; by the current record. This will 
     * cause the referenced records to be marked as 
     * &quot;obsolete&quot; with a reference pointing to this 
     * record.</i> </p>
     */
    @Hl7XmlMapping({"predecessor/oldPatientCareProvisionEvent/id"})
    public List<Identifier> getPredecessorOldPatientCareProvisionEventId() {
        return new RawListWrapper<II, Identifier>(predecessorOldPatientCareProvisionEventId, IIImpl.class);
    }


    /**
     * <p>Relationship: 
     * REPC_MT500001CA.PatientCareProvisionEvent.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     */
    @Hl7XmlMapping({"reason"})
    public List<BecauseOfBean> getReason() {
        return this.reason;
    }


    /**
     * <p>Relationship: REPC_MT500001CA.Component3.actEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component1/actEvent"})
    public List<ActEventBean> getComponent1ActEvent() {
        return this.component1ActEvent;
    }


    /**
     * <p>Relationship: 
     * REPC_MT500001CA.Component2.patientCareProvisionEventPortion</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"component2/patientCareProvisionEventPortion"})
    public List<ParticipantGroupingsBean> getComponent2PatientCareProvisionEventPortion() {
        return this.component2PatientCareProvisionEventPortion;
    }


    /**
     * <p>Relationship: 
     * REPC_MT500001CA.PatientCareProvisionEvent.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"subjectOf"})
    public IncludesBean getSubjectOf() {
        return this.subjectOf;
    }

    /**
     * <p>Relationship: 
     * REPC_MT500001CA.PatientCareProvisionEvent.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setSubjectOf(IncludesBean subjectOf) {
        this.subjectOf = subjectOf;
    }


    /**
     * <p>Relationship: 
     * REPC_MT500001CA.Component.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
