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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.iehr.repc_mt500003ca;

import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.coct_mt050202ca.PatientBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.coct_mt910108ca.RelatedPersonBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.coct_mt911108ca.ActingPerson;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.EHRRepositoryBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.Patient_2Bean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.ServiceLocationBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.iehr.merged.ControlActEventBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.iehr.merged.DischargeDiagnosisBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.iehr.merged.Request_1Bean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.merged.BecauseOfBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.merged.CareCompositionsBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.merged.ChangedByBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.merged.OccurredAtBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.merged.SpecimenRoleBean;
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
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCareEventType;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
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
@Hl7PartTypeMapping({"REPC_MT500003CA.PatientCareProvisionEvent"})
@Hl7RootType
public class CareCompositionBean extends MessagePartBean implements Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.iehr.comt_mt111111ca.SHR {

    private static final long serialVersionUID = 20130614L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private BL negationInd = new BLImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private SpecimenRoleBean subject1Specimen;
    private List<PatientBean> subject2Patient = new ArrayList<PatientBean>();
    private INT subject3PatientPatientEntityQuantifiedKindQuantity = new INTImpl();
    private ActingPerson responsiblePartyActingPerson;
    private List<ActingPerson> performerActingPerson = new ArrayList<ActingPerson>();
    private ChangedByBean author;
    private Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.ActingPerson informantActingPerson;
    private ActingPerson dischargerActingPerson;
    private EHRRepositoryBean custodian1AssignedDevice;
    private ServiceLocationBean custodian2ServiceDeliveryLocation;
    private List<OccurredAtBean> location = new ArrayList<OccurredAtBean>();
    private List<DischargeDiagnosisBean> outcomeDiagnosisEvent = new ArrayList<DischargeDiagnosisBean>();
    private Request_1Bean inFulfillmentOfActRequest;
    private List<II> predecessorOldPatientCareProvisionEventId = new ArrayList<II>();
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private II successorNewPatientCareProvisionEventId = new IIImpl();
    private BL subjectOf1AnnotationIndicator = new BLImpl(false);
    private ControlActEventBean subjectOf2ControlActEvent;
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>Business Name: A: Care Composition Id</p>
     * 
     * <p>Relationship: 
     * REPC_MT500003CA.PatientCareProvisionEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Allows for unique identification of the Care 
     * Composition and is therefore mandatory. Supports drill-down 
     * queries, linking of this record to other records, matching 
     * of EHR records to locally-stored PoS records and is 
     * necessary when identifying records for amending 
     * (revising)/directional linking (superseding).</i> </p>
     * 
     * <p> <i>A globally unique identifier assigned by the EHR to 
     * the Care Composition record.</i> </p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A: Care Composition Id</p>
     * 
     * <p>Relationship: 
     * REPC_MT500003CA.PatientCareProvisionEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Allows for unique identification of the Care 
     * Composition and is therefore mandatory. Supports drill-down 
     * queries, linking of this record to other records, matching 
     * of EHR records to locally-stored PoS records and is 
     * necessary when identifying records for amending 
     * (revising)/directional linking (superseding).</i> </p>
     * 
     * <p> <i>A globally unique identifier assigned by the EHR to 
     * the Care Composition record.</i> </p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: B: Care Composition Type</p>
     * 
     * <p>Relationship: 
     * REPC_MT500003CA.PatientCareProvisionEvent.code</p>
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
     * REPC_MT500003CA.PatientCareProvisionEvent.code</p>
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
     * REPC_MT500003CA.PatientCareProvisionEvent.negationInd</p>
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
     * REPC_MT500003CA.PatientCareProvisionEvent.negationInd</p>
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
     * REPC_MT500003CA.PatientCareProvisionEvent.statusCode</p>
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
     * REPC_MT500003CA.PatientCareProvisionEvent.statusCode</p>
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
     * REPC_MT500003CA.PatientCareProvisionEvent.effectiveTime</p>
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
     * REPC_MT500003CA.PatientCareProvisionEvent.effectiveTime</p>
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
     * REPC_MT500003CA.PatientCareProvisionEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
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
     * <p>Relationship: REPC_MT500003CA.Subject6.specimen</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subject1/specimen"})
    public SpecimenRoleBean getSubject1Specimen() {
        return this.subject1Specimen;
    }

    /**
     * <p>Relationship: REPC_MT500003CA.Subject6.specimen</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubject1Specimen(SpecimenRoleBean subject1Specimen) {
        this.subject1Specimen = subject1Specimen;
    }


    /**
     * <p>Relationship: REPC_MT500003CA.Subject7.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject2/patient"})
    public List<PatientBean> getSubject2Patient() {
        return this.subject2Patient;
    }


    /**
     * <p>Business Name: J:Number of Patients</p>
     * 
     * <p>Relationship: 
     * REPC_MT500003CA.EntityQuantifiedKind.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a provider to ascertain the size of a group 
     * encounter without necessarily revealing the identity of the 
     * patients involved.</p><p>The patients associated with an 
     * encounter must be specified at the time the record is 
     * created, thus the number of patients will always be known, 
     * making this element mandatory.</p>
     * 
     * <p>Indicates the number of patients involved in a group 
     * encounter. For non-group encounters, this attribute will 
     * always be &quot;1&quot;.</p>
     */
    @Hl7XmlMapping({"subject3/patient/patientEntityQuantifiedKind/quantity"})
    public Integer getSubject3PatientPatientEntityQuantifiedKindQuantity() {
        return this.subject3PatientPatientEntityQuantifiedKindQuantity.getValue();
    }

    /**
     * <p>Business Name: J:Number of Patients</p>
     * 
     * <p>Relationship: 
     * REPC_MT500003CA.EntityQuantifiedKind.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a provider to ascertain the size of a group 
     * encounter without necessarily revealing the identity of the 
     * patients involved.</p><p>The patients associated with an 
     * encounter must be specified at the time the record is 
     * created, thus the number of patients will always be known, 
     * making this element mandatory.</p>
     * 
     * <p>Indicates the number of patients involved in a group 
     * encounter. For non-group encounters, this attribute will 
     * always be &quot;1&quot;.</p>
     */
    public void setSubject3PatientPatientEntityQuantifiedKindQuantity(Integer subject3PatientPatientEntityQuantifiedKindQuantity) {
        this.subject3PatientPatientEntityQuantifiedKindQuantity.setValue(subject3PatientPatientEntityQuantifiedKindQuantity);
    }


    /**
     * <p>Relationship: 
     * REPC_MT500003CA.ResponsibleParty.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/actingPerson"})
    public ActingPerson getResponsiblePartyActingPerson() {
        return this.responsiblePartyActingPerson;
    }

    /**
     * <p>Relationship: 
     * REPC_MT500003CA.ResponsibleParty.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
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
     * <p>Relationship: REPC_MT500003CA.Performer3.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"performer/actingPerson"})
    public List<ActingPerson> getPerformerActingPerson() {
        return this.performerActingPerson;
    }


    /**
     * <p>Relationship: 
     * REPC_MT500003CA.PatientCareProvisionEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public ChangedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: 
     * REPC_MT500003CA.PatientCareProvisionEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(ChangedByBean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: REPC_MT500003CA.Informant.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"informant/actingPerson"})
    public Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.ActingPerson getInformantActingPerson() {
        return this.informantActingPerson;
    }

    /**
     * <p>Relationship: REPC_MT500003CA.Informant.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInformantActingPerson(Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.ActingPerson informantActingPerson) {
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
     * <p>Relationship: REPC_MT500003CA.Discharger.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"discharger/actingPerson"})
    public ActingPerson getDischargerActingPerson() {
        return this.dischargerActingPerson;
    }

    /**
     * <p>Relationship: REPC_MT500003CA.Discharger.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
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


    /**
     * <p>Relationship: REPC_MT500003CA.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"custodian1/assignedDevice"})
    public EHRRepositoryBean getCustodian1AssignedDevice() {
        return this.custodian1AssignedDevice;
    }

    /**
     * <p>Relationship: REPC_MT500003CA.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCustodian1AssignedDevice(EHRRepositoryBean custodian1AssignedDevice) {
        this.custodian1AssignedDevice = custodian1AssignedDevice;
    }


    /**
     * <p>Relationship: 
     * REPC_MT500003CA.Custodian2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"custodian2/serviceDeliveryLocation"})
    public ServiceLocationBean getCustodian2ServiceDeliveryLocation() {
        return this.custodian2ServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * REPC_MT500003CA.Custodian2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCustodian2ServiceDeliveryLocation(ServiceLocationBean custodian2ServiceDeliveryLocation) {
        this.custodian2ServiceDeliveryLocation = custodian2ServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: 
     * REPC_MT500003CA.PatientCareProvisionEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"location"})
    public List<OccurredAtBean> getLocation() {
        return this.location;
    }


    /**
     * <p>Relationship: REPC_MT500003CA.Outcome.diagnosisEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"outcome/diagnosisEvent"})
    public List<DischargeDiagnosisBean> getOutcomeDiagnosisEvent() {
        return this.outcomeDiagnosisEvent;
    }


    /**
     * <p>Relationship: REPC_MT500003CA.InFulfillmentOf.actRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/actRequest"})
    public Request_1Bean getInFulfillmentOfActRequest() {
        return this.inFulfillmentOfActRequest;
    }

    /**
     * <p>Relationship: REPC_MT500003CA.InFulfillmentOf.actRequest</p>
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
     * REPC_MT500003CA.OldPatientCareProvisionEvent.id</p>
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
     * REPC_MT500003CA.PatientCareProvisionEvent.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     */
    @Hl7XmlMapping({"reason"})
    public List<BecauseOfBean> getReason() {
        return this.reason;
    }


    /**
     * <p>Business Name: G:Replaced by Record Id</p>
     * 
     * <p>Relationship: 
     * REPC_MT500003CA.NewPatientCareProvisionEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Used in circumstances where a newer or corrected 
     * version of the record of this event exists.</i> </p>
     * 
     * <p> <i>Used to identify the record that supersedes the 
     * current record. This attribute is set when a new record 
     * identifies the current record as being replaced.</i> </p>
     */
    @Hl7XmlMapping({"successor/newPatientCareProvisionEvent/id"})
    public Identifier getSuccessorNewPatientCareProvisionEventId() {
        return this.successorNewPatientCareProvisionEventId.getValue();
    }

    /**
     * <p>Business Name: G:Replaced by Record Id</p>
     * 
     * <p>Relationship: 
     * REPC_MT500003CA.NewPatientCareProvisionEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Used in circumstances where a newer or corrected 
     * version of the record of this event exists.</i> </p>
     * 
     * <p> <i>Used to identify the record that supersedes the 
     * current record. This attribute is set when a new record 
     * identifies the current record as being replaced.</i> </p>
     */
    public void setSuccessorNewPatientCareProvisionEventId(Identifier successorNewPatientCareProvisionEventId) {
        this.successorNewPatientCareProvisionEventId.setValue(successorNewPatientCareProvisionEventId);
    }


    /**
     * <p>Relationship: REPC_MT500003CA.Subject.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/annotationIndicator"})
    public Boolean getSubjectOf1AnnotationIndicator() {
        return this.subjectOf1AnnotationIndicator.getValue();
    }

    /**
     * <p>Relationship: REPC_MT500003CA.Subject.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf1AnnotationIndicator(Boolean subjectOf1AnnotationIndicator) {
        this.subjectOf1AnnotationIndicator.setValue(subjectOf1AnnotationIndicator);
    }


    /**
     * <p>Relationship: REPC_MT500003CA.Subject4.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/controlActEvent"})
    public ControlActEventBean getSubjectOf2ControlActEvent() {
        return this.subjectOf2ControlActEvent;
    }

    /**
     * <p>Relationship: REPC_MT500003CA.Subject4.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf2ControlActEvent(ControlActEventBean subjectOf2ControlActEvent) {
        this.subjectOf2ControlActEvent = subjectOf2ControlActEvent;
    }


    /**
     * <p>Relationship: 
     * REPC_MT500003CA.Component.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
