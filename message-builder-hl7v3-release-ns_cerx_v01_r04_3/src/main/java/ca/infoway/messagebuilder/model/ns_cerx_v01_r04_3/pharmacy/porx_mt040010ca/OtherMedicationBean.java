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
package ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.pharmacy.porx_mt040010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.common.coct_mt050203ca.PatientBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.common.coct_mt220100ca.DrugProductBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.pharmacy.porx_mt980040ca.AdministrationInstructionsBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Other Medication</p>
 * 
 * <p>Status can only be 'ACTIVE' or 'COMPLETED'</p>
 * 
 * <p>routeCode must not be used when code is SNOMED and is 
 * mandatory otherwise</p>
 * 
 * <p>Necessary component of a person's overall medication 
 * profile. Allows DUR checking against a more complete drug 
 * profile.</p>
 * 
 * <p>A record of a medication the patient is believed to be 
 * taking, but for which an electronic order does not exist. 
 * 'Other medications' include any drug product deemed relevant 
 * to the patient's drug profile, but which was not 
 * specifically ordered by a prescriber in a DIS-enabled 
 * jurisdiction. Examples include over-the counter medications 
 * that were not specifically ordered, herbal remedies, and 
 * recreational drugs. Prescription drugs that the patient may 
 * be taking but were not prescribed on the EHR (e.g. 
 * institutionally administered or out-of-jurisdiction 
 * prescriptions) will also be recorded here.</p>
 */
@Hl7PartTypeMapping({"PORX_MT040010CA.OtherMedication"})
@Hl7RootType
public class OtherMedicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private CV code = new CVImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV confidentialityCode = new CVImpl();
    private CV routeCode = new CVImpl();
    private PatientBean subjectPatient;
    private DrugProductBean consumableMedication;
    private List<AdministrationInstructionsBean> componentDosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private NotesBean subjectOfAnnotation;


    /**
     * <p>Business Name: Other Medication Type</p>
     * 
     * <p>Relationship: PORX_MT040010CA.OtherMedication.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Must be 'DRUG' unless using SNOMED</p>
     * 
     * <p>Needed to convey the meaning of this class and is 
     * therefore mandatory.</p><p>The element allows 'CD' to 
     * provide support for SNOMED.</p>
     * 
     * <p>Indicates that the record is a drug administration rather 
     * than an immunization or other type of administration. For 
     * SNOMED, may also include route, drug and other 
     * information.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Other Medication Type</p>
     * 
     * <p>Relationship: PORX_MT040010CA.OtherMedication.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Must be 'DRUG' unless using SNOMED</p>
     * 
     * <p>Needed to convey the meaning of this class and is 
     * therefore mandatory.</p><p>The element allows 'CD' to 
     * provide support for SNOMED.</p>
     * 
     * <p>Indicates that the record is a drug administration rather 
     * than an immunization or other type of administration. For 
     * SNOMED, may also include route, drug and other 
     * information.</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: C:Other Medication Status</p>
     * 
     * <p>Relationship: PORX_MT040010CA.OtherMedication.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against an other medication record. This is a mandatory 
     * field because every recorded 'other medication' needs to be 
     * in some state.</p><p>Note ------ The provider might know 
     * that the patient is not taking the medication but not 
     * necessarily when the patient stopped it. Thus the status of 
     * the medication could be set to 'COMPLETED' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p>
     * 
     * <p>This denotes a state in the lifecycle of the other 
     * medication. Valid statuses are: 'ACTIVE' and 'COMPLETED' 
     * only.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: C:Other Medication Status</p>
     * 
     * <p>Relationship: PORX_MT040010CA.OtherMedication.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against an other medication record. This is a mandatory 
     * field because every recorded 'other medication' needs to be 
     * in some state.</p><p>Note ------ The provider might know 
     * that the patient is not taking the medication but not 
     * necessarily when the patient stopped it. Thus the status of 
     * the medication could be set to 'COMPLETED' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p>
     * 
     * <p>This denotes a state in the lifecycle of the other 
     * medication. Valid statuses are: 'ACTIVE' and 'COMPLETED' 
     * only.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: d:Drug Active Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT040010CA.OtherMedication.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>ZDP.13.2.2</p>
     * 
     * <p>ZDP.13.3</p>
     * 
     * <p>ZDP.13.4</p>
     * 
     * <p>ZDP.13.5</p>
     * 
     * <p>Used to help determine whether the medication is 
     * currently active. Because this information won't always be 
     * available, the attribute is marked as 'populated'.</p>
     * 
     * <p>Either the start or end or both can be null if they are 
     * not known.</p>
     * 
     * <p>Indicates the time-period in which the patient has been 
     * taking or is expected to be taking the medication.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: d:Drug Active Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT040010CA.OtherMedication.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>ZDP.13.2.2</p>
     * 
     * <p>ZDP.13.3</p>
     * 
     * <p>ZDP.13.4</p>
     * 
     * <p>ZDP.13.5</p>
     * 
     * <p>Used to help determine whether the medication is 
     * currently active. Because this information won't always be 
     * available, the attribute is marked as 'populated'.</p>
     * 
     * <p>Either the start or end or both can be null if they are 
     * not known.</p>
     * 
     * <p>Indicates the time-period in which the patient has been 
     * taking or is expected to be taking the medication.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: E:Other Medication Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT040010CA.OtherMedication.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Denotes access restriction place on the other medication 
     * record. Methods for accessing masked other medications will 
     * be governed by each jurisdiction (e.g. court orders, shared 
     * secret/consent, etc.).</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Business Name: E:Other Medication Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT040010CA.OtherMedication.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Denotes access restriction place on the other medication 
     * record. Methods for accessing masked other medications will 
     * be governed by each jurisdiction (e.g. court orders, shared 
     * secret/consent, etc.).</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Business Name: F:Route of Administration</p>
     * 
     * <p>Relationship: PORX_MT040010CA.OtherMedication.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Route of administration</p>
     * 
     * <p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and route. Because 
     * this information is pre-coordinated into 'code' for SNOMED, 
     * it is marked as optional.</p>
     * 
     * <p>This is the means by which the patient is taking the 
     * other medication.</p>
     */
    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getRouteCode() {
        return (RouteOfAdministration) this.routeCode.getValue();
    }

    /**
     * <p>Business Name: F:Route of Administration</p>
     * 
     * <p>Relationship: PORX_MT040010CA.OtherMedication.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Route of administration</p>
     * 
     * <p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and route. Because 
     * this information is pre-coordinated into 'code' for SNOMED, 
     * it is marked as optional.</p>
     * 
     * <p>This is the means by which the patient is taking the 
     * other medication.</p>
     */
    public void setRouteCode(RouteOfAdministration routeCode) {
        this.routeCode.setValue(routeCode);
    }


    /**
     * <p>Relationship: PORX_MT040010CA.Subject10.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Relationship: PORX_MT040010CA.Subject10.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Relationship: PORX_MT040010CA.Consumable2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"consumable/medication"})
    public DrugProductBean getConsumableMedication() {
        return this.consumableMedication;
    }

    /**
     * <p>Relationship: PORX_MT040010CA.Consumable2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setConsumableMedication(DrugProductBean consumableMedication) {
        this.consumableMedication = consumableMedication;
    }


    /**
     * <p>Relationship: PORX_MT040010CA.Component.dosageInstruction</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component/dosageInstruction"})
    public List<AdministrationInstructionsBean> getComponentDosageInstruction() {
        return this.componentDosageInstruction;
    }


    /**
     * <p>Relationship: PORX_MT040010CA.Subject9.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/annotation"})
    public NotesBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }

    /**
     * <p>Relationship: PORX_MT040010CA.Subject9.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOfAnnotation(NotesBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }

}
