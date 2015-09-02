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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.repc_mt000014nb;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
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
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt011001nb.CareCompositionsBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt050207nb.PatientBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt090108nb.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt090508nb.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt911107nb.ActingPerson;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.domainvalue.ActDiagnosisCode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Health Condition</p>
 * 
 * <p>Necessary component of a person's overall profile. Helps 
 * with contraindication checking.</p>
 * 
 * <p>A record of a patient's health condition, as tracked over 
 * time. Examples include diseases, disabilities, pregnancy, 
 * lactation and other clinical conditions of 
 * interest.</p><p>Also known as &quot;Problem&quot; (from a 
 * 'problem list').</p>
 */
@Hl7PartTypeMapping({"REPC_MT000014NB.ConditionEvent"})
@Hl7RootType
public class HealthConditionBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private CD value = new CDImpl();
    private ActingPerson informantActingPerson;
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>Business Name: A:Condition Identifier</p>
     * 
     * <p>Relationship: REPC_MT000014NB.ConditionEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (2)</p>
     * 
     * <p> <i>Allows for unique identification of the Health 
     * Condition and is therefore mandatory. Supports drill-down 
     * queries, linking of this record to other records, matching 
     * of EHR records to locally-stored PoS records and is 
     * necessary when identifying records for amending 
     * (revising)/directional linking (superseding).</i> </p>
     * 
     * <p> <i>A globally unique identifier assigned by the EHR to 
     * the Health Condition record.</i> </p><p>The identifier 
     * applies to this &quot;instance&quot; of the condition. For 
     * example, multiple pregnancies would each be treated as 
     * distinct conditions, each with a unique id.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: B: Condition Type</p>
     * 
     * <p>Relationship: REPC_MT000014NB.ConditionEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Code is fixed DX if not using SNOMED;</p>
     * 
     * <p> <i>Condition Type is used for searching and for 
     * organizing Health Condition records as well as sorting them 
     * for presentation.</i> </p><p> <i>This is a key attribute for 
     * understanding the type of record and is therefore 
     * mandatory.</i> </p><p>Since all diagnosis concepts can be 
     * represented in a single field, this domain is a fixed 
     * value</p>
     * 
     * <p>Designates the concept in DiagnosisValue as a 
     * Diagnosis</p>
     */
    @Hl7XmlMapping({"code"})
    public ActDiagnosisCode getCode() {
        return (ActDiagnosisCode) this.code.getValue();
    }

    /**
     * <p>Business Name: B: Condition Type</p>
     * 
     * <p>Relationship: REPC_MT000014NB.ConditionEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Code is fixed DX if not using SNOMED;</p>
     * 
     * <p> <i>Condition Type is used for searching and for 
     * organizing Health Condition records as well as sorting them 
     * for presentation.</i> </p><p> <i>This is a key attribute for 
     * understanding the type of record and is therefore 
     * mandatory.</i> </p><p>Since all diagnosis concepts can be 
     * represented in a single field, this domain is a fixed 
     * value</p>
     * 
     * <p>Designates the concept in DiagnosisValue as a 
     * Diagnosis</p>
     */
    public void setCode(ActDiagnosisCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: C:Condition Status</p>
     * 
     * <p>Relationship: REPC_MT000014NB.ConditionEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p> <i>Status is frequently used to filter query responses 
     * as well as to sort records for presentation. It also affects 
     * how the Health Condition record is interpreted.</i> </p><p> 
     * <i>Because the status won't always be known, the attribute 
     * is marked as 'populated' to allow the use of null 
     * flavors.</i> </p>
     * 
     * <p> <i>This identifies the current state of the Health 
     * Condition record.</i> </p><p>Indicates whether the condition 
     * is still being monitored as relevant to the patient's health 
     * ('active') or whether the condition is no longer considered 
     * a relevant 'problem' ('completed'). It may also be 
     * 'obsolete' in circumstances where the record has been 
     * replaced.</p><p>Note that a problem may be considered 
     * 'active' even if the underlying condition is no longer 
     * affecting the patient. For example, for a patient who was 
     * recently pregnant, the pregnancy has ended, but the 
     * pregnancy would still be an 'active' condition record 
     * because of it's ongoing impact on the patient's healthcare 
     * situation.</p><p>To convey the actual clinical status of the 
     * condition, use SNOMED post-coordination in the Condition 
     * attribute.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: C:Condition Status</p>
     * 
     * <p>Relationship: REPC_MT000014NB.ConditionEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p> <i>Status is frequently used to filter query responses 
     * as well as to sort records for presentation. It also affects 
     * how the Health Condition record is interpreted.</i> </p><p> 
     * <i>Because the status won't always be known, the attribute 
     * is marked as 'populated' to allow the use of null 
     * flavors.</i> </p>
     * 
     * <p> <i>This identifies the current state of the Health 
     * Condition record.</i> </p><p>Indicates whether the condition 
     * is still being monitored as relevant to the patient's health 
     * ('active') or whether the condition is no longer considered 
     * a relevant 'problem' ('completed'). It may also be 
     * 'obsolete' in circumstances where the record has been 
     * replaced.</p><p>Note that a problem may be considered 
     * 'active' even if the underlying condition is no longer 
     * affecting the patient. For example, for a patient who was 
     * recently pregnant, the pregnancy has ended, but the 
     * pregnancy would still be an 'active' condition record 
     * because of it's ongoing impact on the patient's healthcare 
     * situation.</p><p>To convey the actual clinical status of the 
     * condition, use SNOMED post-coordination in the Condition 
     * attribute.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: G: Condition Time Period</p>
     * 
     * <p>Relationship: 
     * REPC_MT000014NB.ConditionEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p>
     * 
     * <p>The date on which the condition first began and when it 
     * ended.</p><p>For ongoing conditions such as chronic 
     * diseases, the upper boundary may be unknown.</p><p>For 
     * transient conditions such as pregnancy, lactation, etc; the 
     * upper boundary of the period would usually be specified to 
     * signify the end of the condition.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: G: Condition Time Period</p>
     * 
     * <p>Relationship: 
     * REPC_MT000014NB.ConditionEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p>
     * 
     * <p>The date on which the condition first began and when it 
     * ended.</p><p>For ongoing conditions such as chronic 
     * diseases, the upper boundary may be unknown.</p><p>For 
     * transient conditions such as pregnancy, lactation, etc; the 
     * upper boundary of the period would usually be specified to 
     * signify the end of the condition.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: F: Condition Masking Indicators</p>
     * 
     * <p>Relationship: 
     * REPC_MT000014NB.ConditionEvent.confidentialityCode</p>
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
     * access to this Health Condition record. Provides support for 
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
     * with one of the other codes.</i> </p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Business Name: K:Condition</p>
     * 
     * <p>Relationship: REPC_MT000014NB.ConditionEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is the central piece of information in recording a 
     * condition, therefore the attribute is mandatory.</p><p> 
     * <i>This element makes use of the CD datatype because some 
     * terminologies used for the domain require use of 
     * modifiers.</i> </p><p> <i>The element uses CWE to allow for 
     * the capture of Condition concepts not presently supported by 
     * the approved code system(s). In this case, the 
     * human-to-human benefit of capturing additional non-coded 
     * values outweighs the penalties of capturing some information 
     * that will not be amenable to searching or categorizing.</i> 
     * </p>
     * 
     * <p>A code indicating the specific condition. E.g. 
     * Hypertension, Pregnancy.</p>
     */
    @Hl7XmlMapping({"value"})
    public DiagnosisValue getValue() {
        return (DiagnosisValue) this.value.getValue();
    }

    /**
     * <p>Business Name: K:Condition</p>
     * 
     * <p>Relationship: REPC_MT000014NB.ConditionEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is the central piece of information in recording a 
     * condition, therefore the attribute is mandatory.</p><p> 
     * <i>This element makes use of the CD datatype because some 
     * terminologies used for the domain require use of 
     * modifiers.</i> </p><p> <i>The element uses CWE to allow for 
     * the capture of Condition concepts not presently supported by 
     * the approved code system(s). In this case, the 
     * human-to-human benefit of capturing additional non-coded 
     * values outweighs the penalties of capturing some information 
     * that will not be amenable to searching or categorizing.</i> 
     * </p>
     * 
     * <p>A code indicating the specific condition. E.g. 
     * Hypertension, Pregnancy.</p>
     */
    public void setValue(DiagnosisValue value) {
        this.value.setValue(value);
    }


    /**
     * <p>Relationship: REPC_MT000014NB.Informant.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"informant/actingPerson"})
    public ActingPerson getInformantActingPerson() {
        return this.informantActingPerson;
    }

    /**
     * <p>Relationship: REPC_MT000014NB.Informant.actingPerson</p>
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

    public PatientBean getInformantActingPersonAsPatient() {
        return this.informantActingPerson instanceof PatientBean ? (PatientBean) this.informantActingPerson : null;
    }
    public boolean hasInformantActingPersonAsPatient() {
        return (this.informantActingPerson instanceof PatientBean);
    }


    /**
     * <p>Relationship: 
     * REPC_MT000014NB.Component.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
