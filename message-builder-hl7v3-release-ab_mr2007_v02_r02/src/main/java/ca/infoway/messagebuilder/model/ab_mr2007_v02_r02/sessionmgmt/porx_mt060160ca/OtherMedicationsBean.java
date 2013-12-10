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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.porx_mt060160ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.IssuesBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.PatientBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.coct_mt220110ca.DrugProductBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.merged.StatusChangesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Other Medications</p>
 * 
 * <p>routeCode must not be used when code is SNOMED and is 
 * mandatory otherwise</p><p>Status can only be ACTIVE or 
 * COMPLETED</p><p>Reported Issue is only permitted if Issue 
 * Indicator is not present and vice versa</p><p>Annotation is 
 * only permitted if Annotation Indicator is not present and 
 * vice versa</p>
 * 
 * <p>routeCode must not be used when code is SNOMED and is 
 * mandatory otherwise</p><p>Status can only be ACTIVE or 
 * COMPLETED</p><p>Reported Issue is only permitted if Issue 
 * Indicator is not present and vice versa</p><p>Annotation is 
 * only permitted if Annotation Indicator is not present and 
 * vice versa</p>
 * 
 * <p>routeCode must not be used when code is SNOMED and is 
 * mandatory otherwise</p><p>Status can only be ACTIVE or 
 * COMPLETED</p><p>Reported Issue is only permitted if Issue 
 * Indicator is not present and vice versa</p><p>Annotation is 
 * only permitted if Annotation Indicator is not present and 
 * vice versa</p>
 * 
 * <p>routeCode must not be used when code is SNOMED and is 
 * mandatory otherwise</p><p>Status can only be ACTIVE or 
 * COMPLETED</p><p>Reported Issue is only permitted if Issue 
 * Indicator is not present and vice versa</p><p>Annotation is 
 * only permitted if Annotation Indicator is not present and 
 * vice versa</p>
 * 
 * <p>A record of a medication the patient is believed to be 
 * taking, but for which an electronic order does not exist. 
 * 'Other medications' include any drug product deemed relevant 
 * to the patient's drug profile, but which was not 
 * specifically ordered by a prescriber in a DIS-enabled 
 * jurisdiction. Examples include over-the counter medications 
 * that were not specifically ordered, herbal remedies, and 
 * recreational drugs. Prescription drugs that the patient may 
 * be taking but was not prescribed on the EHR (e.g. 
 * institutionally administered or out-of-jurisdiction 
 * prescriptions) will also be recorded here.</p>
 * 
 * <p>Necessary component of a person's overall medication 
 * profile. Allows DUR checking against a more complete drug 
 * profile.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060160CA.OtherMedication"})
public class OtherMedicationsBean extends MessagePartBean implements ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.MedicationRecord {

    private static final long serialVersionUID = 20131210L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV confidentialityCode = new CVImpl();
    private CV routeCode = new CVImpl();
    private ProviderBean authorAssignedPerson;
    private List<AdministrationInstructionsBean> componentDosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private DrugProductBean consumableMedication;
    private CreatedAtBean location;
    private ProviderBean responsiblePartyAssignedPerson;
    private PatientBean subjectPatient;
    private List<StatusChangesBean> subjectOf1ControlActEvent = new ArrayList<StatusChangesBean>();
    private BL subjectOf2DetectedIssueIndicator = new BLImpl(false);
    private List<NotesBean> subjectOf3Annotation = new ArrayList<NotesBean>();
    private BL subjectOf4AnnotationIndicator = new BLImpl(false);
    private List<IssuesBean> subjectOf5DetectedIssueEvent = new ArrayList<IssuesBean>();


    /**
     * <p>Business Name: A:Administration Record Id</p>
     * 
     * <p>Relationship: PORX_MT060160CA.OtherMedication.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is an identifier assigned to a unique instance of an 
     * other medication record.</p>
     * 
     * <p>Allows for the unique referencing of a specific active 
     * medication record. Thus the mandatory requirement. .</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Administration Record Id</p>
     * 
     * <p>Relationship: PORX_MT060160CA.OtherMedication.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is an identifier assigned to a unique instance of an 
     * other medication record.</p>
     * 
     * <p>Allows for the unique referencing of a specific active 
     * medication record. Thus the mandatory requirement. .</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Other Medication Type</p>
     * 
     * <p>Relationship: PORX_MT060160CA.OtherMedication.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Must be 'DRUG' unless using SNOMED</p>
     * 
     * <p>Indicates that the record is a drug administration rather 
     * than an immunization or other type of administration. For 
     * SNOMED, may also include route, drug and other 
     * information.</p>
     * 
     * <p>Needed to convey the meaning of this class and is 
     * therefore mandatory.</p><p>The element allows 'CD' to 
     * provide support for SNOMED.</p>
     * 
     * <p>Needed to convey the meaning of this class and is 
     * therefore mandatory.</p><p>The element allows 'CD' to 
     * provide support for SNOMED.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Other Medication Type</p>
     * 
     * <p>Relationship: PORX_MT060160CA.OtherMedication.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Must be 'DRUG' unless using SNOMED</p>
     * 
     * <p>Indicates that the record is a drug administration rather 
     * than an immunization or other type of administration. For 
     * SNOMED, may also include route, drug and other 
     * information.</p>
     * 
     * <p>Needed to convey the meaning of this class and is 
     * therefore mandatory.</p><p>The element allows 'CD' to 
     * provide support for SNOMED.</p>
     * 
     * <p>Needed to convey the meaning of this class and is 
     * therefore mandatory.</p><p>The element allows 'CD' to 
     * provide support for SNOMED.</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: B:Other Medication Status</p>
     * 
     * <p>Relationship: PORX_MT060160CA.OtherMedication.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the status of the other medication record 
     * created on the EHR/DIS. Valid statuses for other medication 
     * records are: ACTIVE, COMPLETE.</p>
     * 
     * <p>Used to determine whether the medication should be 
     * considered in performing DUR checking.</p><p>Attribute is 
     * mandatory to ensure that a medication recorded in EHR/DIS is 
     * in some state.</p><p>Note ------ The provider might know 
     * that the patient is not taking the medication but not 
     * necessarily when the patient stopped it. Thus the status of 
     * the medication could be set to 'COMPLETED' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p>
     * 
     * <p>Used to determine whether the medication should be 
     * considered in performing DUR checking.</p><p>Attribute is 
     * mandatory to ensure that a medication recorded in EHR/DIS is 
     * in some state.</p><p>Note ------ The provider might know 
     * that the patient is not taking the medication but not 
     * necessarily when the patient stopped it. Thus the status of 
     * the medication could be set to 'COMPLETED' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p>
     * 
     * <p>Used to determine whether the medication should be 
     * considered in performing DUR checking.</p><p>Attribute is 
     * mandatory to ensure that a medication recorded in EHR/DIS is 
     * in some state.</p><p>Note ------ The provider might know 
     * that the patient is not taking the medication but not 
     * necessarily when the patient stopped it. Thus the status of 
     * the medication could be set to 'COMPLETED' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: B:Other Medication Status</p>
     * 
     * <p>Relationship: PORX_MT060160CA.OtherMedication.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the status of the other medication record 
     * created on the EHR/DIS. Valid statuses for other medication 
     * records are: ACTIVE, COMPLETE.</p>
     * 
     * <p>Used to determine whether the medication should be 
     * considered in performing DUR checking.</p><p>Attribute is 
     * mandatory to ensure that a medication recorded in EHR/DIS is 
     * in some state.</p><p>Note ------ The provider might know 
     * that the patient is not taking the medication but not 
     * necessarily when the patient stopped it. Thus the status of 
     * the medication could be set to 'COMPLETED' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p>
     * 
     * <p>Used to determine whether the medication should be 
     * considered in performing DUR checking.</p><p>Attribute is 
     * mandatory to ensure that a medication recorded in EHR/DIS is 
     * in some state.</p><p>Note ------ The provider might know 
     * that the patient is not taking the medication but not 
     * necessarily when the patient stopped it. Thus the status of 
     * the medication could be set to 'COMPLETED' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p>
     * 
     * <p>Used to determine whether the medication should be 
     * considered in performing DUR checking.</p><p>Attribute is 
     * mandatory to ensure that a medication recorded in EHR/DIS is 
     * in some state.</p><p>Note ------ The provider might know 
     * that the patient is not taking the medication but not 
     * necessarily when the patient stopped it. Thus the status of 
     * the medication could be set to 'COMPLETED' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: C:Drug Active Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.OtherMedication.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Indicates the time-period in which the patient has been 
     * taking or is expected to be taking the other medication.</p>
     * 
     * <p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p>
     * 
     * <p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p>
     * 
     * <p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p>
     * 
     * <p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p>
     * 
     * <p>Used to indicate help determine whether the medication is 
     * currently active. Because this information won't always be 
     * available, the attribute is marked as 'populated'.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: C:Drug Active Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.OtherMedication.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Indicates the time-period in which the patient has been 
     * taking or is expected to be taking the other medication.</p>
     * 
     * <p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p>
     * 
     * <p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p>
     * 
     * <p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p>
     * 
     * <p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p>
     * 
     * <p>Used to indicate help determine whether the medication is 
     * currently active. Because this information won't always be 
     * available, the attribute is marked as 'populated'.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: D:Other Medication Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.OtherMedication.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Denotes access restriction place on the other active 
     * medication record. Methods for accessing masked active 
     * medications will be governed by each jurisdiction (e.g. 
     * court orders, shared secret/consent, etc.).</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Business Name: D:Other Medication Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.OtherMedication.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Denotes access restriction place on the other active 
     * medication record. Methods for accessing masked active 
     * medications will be governed by each jurisdiction (e.g. 
     * court orders, shared secret/consent, etc.).</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Business Name: E:Route of Administration</p>
     * 
     * <p>Relationship: PORX_MT060160CA.OtherMedication.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>This is the means by which the patient is taking the 
     * medication.</p>
     * 
     * <p>RXR.1</p><p>Route of administration</p>
     * 
     * <p>RXR.1</p><p>Route of administration</p>
     * 
     * <p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and route. Because 
     * this information is pre-coordinated into 'code' for SNOMED, 
     * it is marked as optional.</p>
     */
    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getRouteCode() {
        return (RouteOfAdministration) this.routeCode.getValue();
    }

    /**
     * <p>Business Name: E:Route of Administration</p>
     * 
     * <p>Relationship: PORX_MT060160CA.OtherMedication.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>This is the means by which the patient is taking the 
     * medication.</p>
     * 
     * <p>RXR.1</p><p>Route of administration</p>
     * 
     * <p>RXR.1</p><p>Route of administration</p>
     * 
     * <p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and route. Because 
     * this information is pre-coordinated into 'code' for SNOMED, 
     * it is marked as optional.</p>
     */
    public void setRouteCode(RouteOfAdministration routeCode) {
        this.routeCode.setValue(routeCode);
    }


    /**
     * <p>Relationship: PORX_MT060160CA.Author.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author/assignedPerson"})
    public ProviderBean getAuthorAssignedPerson() {
        return this.authorAssignedPerson;
    }

    /**
     * <p>Relationship: PORX_MT060160CA.Author.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthorAssignedPerson(ProviderBean authorAssignedPerson) {
        this.authorAssignedPerson = authorAssignedPerson;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060160CA.Component5.dosageInstruction</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"component/dosageInstruction"})
    public List<AdministrationInstructionsBean> getComponentDosageInstruction() {
        return this.componentDosageInstruction;
    }


    /**
     * <p>Relationship: PORX_MT060160CA.Consumable2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"consumable/medication"})
    public DrugProductBean getConsumableMedication() {
        return this.consumableMedication;
    }

    /**
     * <p>Relationship: PORX_MT060160CA.Consumable2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setConsumableMedication(DrugProductBean consumableMedication) {
        this.consumableMedication = consumableMedication;
    }


    /**
     * <p>Relationship: PORX_MT060160CA.OtherMedication.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: PORX_MT060160CA.OtherMedication.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060160CA.ResponsibleParty4.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060160CA.ResponsibleParty4.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    /**
     * <p>Relationship: PORX_MT060160CA.Subject10.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Relationship: PORX_MT060160CA.Subject10.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Relationship: PORX_MT060160CA.Subject11.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public List<StatusChangesBean> getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060160CA.Subject9.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/detectedIssueIndicator"})
    public Boolean getSubjectOf2DetectedIssueIndicator() {
        return this.subjectOf2DetectedIssueIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT060160CA.Subject9.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf2DetectedIssueIndicator(Boolean subjectOf2DetectedIssueIndicator) {
        this.subjectOf2DetectedIssueIndicator.setValue(subjectOf2DetectedIssueIndicator);
    }


    /**
     * <p>Relationship: PORX_MT060160CA.Subject14.annotation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf3/annotation"})
    public List<NotesBean> getSubjectOf3Annotation() {
        return this.subjectOf3Annotation;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060160CA.Subject15.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf4/annotationIndicator"})
    public Boolean getSubjectOf4AnnotationIndicator() {
        return this.subjectOf4AnnotationIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT060160CA.Subject15.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf4AnnotationIndicator(Boolean subjectOf4AnnotationIndicator) {
        this.subjectOf4AnnotationIndicator.setValue(subjectOf4AnnotationIndicator);
    }


    /**
     * <p>Relationship: 
     * PORX_MT060160CA.Subject17.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf5/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf5DetectedIssueEvent() {
        return this.subjectOf5DetectedIssueEvent;
    }

}
