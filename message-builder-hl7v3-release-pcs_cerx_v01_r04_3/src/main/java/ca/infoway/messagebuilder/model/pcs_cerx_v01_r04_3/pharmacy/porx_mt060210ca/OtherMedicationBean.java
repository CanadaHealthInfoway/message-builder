/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt060210ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
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
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220110ca.DrugProductBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.RefusedByBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.IssuesBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.StatusChangesBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt980040ca.AdministrationInstructionsBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Other Medication</p>
 * 
 * <p>routeCode must not be used when code is SNOMED and is 
 * mandatory otherwise</p>
 * 
 * <p>Status can only be ACTIVE or COMPLETE</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present and vice versa</p>
 * 
 * <p>Reported Issue is only permitted if Issue Indicator is 
 * not present and vice versa</p>
 * 
 * <p>Necessary component of a person's overall medication 
 * profile. Allows DUR checking against a more complete drug 
 * profile.</p>
 * 
 * <p>A record of a medication the patient is believed to be 
 * taking, but for which an electronic order does not exist. 
 * &quot;Other active medications&quot; include any drug 
 * product deemed relevant to the patient's drug profile, but 
 * which was not specifically ordered by a prescriber in a 
 * DIS-enabled jurisdiction. Examples include over-the counter 
 * medications that were not specifically ordered, herbal 
 * remedies, and recreational drugs. Prescription drugs that 
 * the patient may be taking but was not prescribed on the EHR 
 * (e.g. institutionally administered or out-of-jurisdiction 
 * prescriptions) will also be recorded here.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060210CA.OtherMedication"})
@Hl7RootType
public class OtherMedicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV confidentialityCode = new CVImpl();
    private CV routeCode = new CVImpl();
    private PatientBean subjectPatient;
    private DrugProductBean consumableMedication;
    private ProviderBean responsiblePartyAssignedPerson;
    private RefusedByBean author;
    private RecordedAtBean location;
    private List<AdministrationInstructionsBean> componentDosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private List<StatusChangesBean> subjectOf1ControlActEvent = new ArrayList<StatusChangesBean>();
    private BL subjectOf2DetectedIssueIndicator = new BLImpl(false);
    private List<CommentBean> subjectOf3Annotation = new ArrayList<CommentBean>();
    private BL subjectOf4AnnotationIndicator = new BLImpl(false);
    private List<IssuesBean> subjectOf5DetectedIssueEvent = new ArrayList<IssuesBean>();


    /**
     * <p>Business Name: A:Administration Record Id</p>
     * 
     * <p>Relationship: PORX_MT060210CA.OtherMedication.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the unique referencing of a specific active 
     * medication record. Thus the mandatory requirement. .</p>
     * 
     * <p>This is an identifier assigned to a unique instance of an 
     * active medication record.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Administration Record Id</p>
     * 
     * <p>Relationship: PORX_MT060210CA.OtherMedication.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the unique referencing of a specific active 
     * medication record. Thus the mandatory requirement. .</p>
     * 
     * <p>This is an identifier assigned to a unique instance of an 
     * active medication record.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Other Medication Type</p>
     * 
     * <p>Relationship: PORX_MT060210CA.OtherMedication.code</p>
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
     * <p>Relationship: PORX_MT060210CA.OtherMedication.code</p>
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
     * <p>Business Name: B:Other Medication Status</p>
     * 
     * <p>Relationship: PORX_MT060210CA.OtherMedication.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to determine whether the medication should be 
     * considered in performing DUR checking.</p><p>Attribute is 
     * mandatory to ensure that a medication recorded in EHR/DIS is 
     * in some state.</p><p>Note ------ The provider might know 
     * that the patient is not taking the medication but not 
     * necessarily when the patient stopped it. Thus the status of 
     * the medication could be set to 'completed' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p>
     * 
     * <p>Indicates the status of the other medication record 
     * created on the EHR/DIS. Valid statuses for other medication 
     * records are: 'active' and 'completed' only.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: B:Other Medication Status</p>
     * 
     * <p>Relationship: PORX_MT060210CA.OtherMedication.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to determine whether the medication should be 
     * considered in performing DUR checking.</p><p>Attribute is 
     * mandatory to ensure that a medication recorded in EHR/DIS is 
     * in some state.</p><p>Note ------ The provider might know 
     * that the patient is not taking the medication but not 
     * necessarily when the patient stopped it. Thus the status of 
     * the medication could be set to 'completed' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p>
     * 
     * <p>Indicates the status of the other medication record 
     * created on the EHR/DIS. Valid statuses for other medication 
     * records are: 'active' and 'completed' only.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: C:Drug Active Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT060210CA.OtherMedication.effectiveTime</p>
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
     * <p>Indicates the time-period in which the patient has been 
     * taking or is expected to be taking the medication.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: C:Drug Active Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT060210CA.OtherMedication.effectiveTime</p>
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
     * <p>Indicates the time-period in which the patient has been 
     * taking or is expected to be taking the medication.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: D:Other Medication Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060210CA.OtherMedication.confidentialityCode</p>
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
     * <p>Business Name: D:Other Medication Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060210CA.OtherMedication.confidentialityCode</p>
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
     * <p>Business Name: E:Route of Administration</p>
     * 
     * <p>Relationship: PORX_MT060210CA.OtherMedication.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>RXR.1</p>
     * 
     * <p>Route of administration</p>
     * 
     * <p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and route. Because 
     * this information is pre-coordinated into 'code' for SNOMED, 
     * it is marked as optional.</p>
     * 
     * <p>This is the means by which the patient is taking the 
     * medication.</p>
     */
    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getRouteCode() {
        return (RouteOfAdministration) this.routeCode.getValue();
    }

    /**
     * <p>Business Name: E:Route of Administration</p>
     * 
     * <p>Relationship: PORX_MT060210CA.OtherMedication.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>RXR.1</p>
     * 
     * <p>Route of administration</p>
     * 
     * <p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and route. Because 
     * this information is pre-coordinated into 'code' for SNOMED, 
     * it is marked as optional.</p>
     * 
     * <p>This is the means by which the patient is taking the 
     * medication.</p>
     */
    public void setRouteCode(RouteOfAdministration routeCode) {
        this.routeCode.setValue(routeCode);
    }


    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Relationship: PORX_MT060210CA.Consumable2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"consumable/medication"})
    public DrugProductBean getConsumableMedication() {
        return this.consumableMedication;
    }

    /**
     * <p>Relationship: PORX_MT060210CA.Consumable2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setConsumableMedication(DrugProductBean consumableMedication) {
        this.consumableMedication = consumableMedication;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060210CA.ResponsibleParty.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060210CA.ResponsibleParty.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }

    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }

    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: PORX_MT060210CA.Component.dosageInstruction</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"component/dosageInstruction"})
    public List<AdministrationInstructionsBean> getComponentDosageInstruction() {
        return this.componentDosageInstruction;
    }


    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public List<StatusChangesBean> getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060210CA.Subject9.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/detectedIssueIndicator"})
    public Boolean getSubjectOf2DetectedIssueIndicator() {
        return this.subjectOf2DetectedIssueIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT060210CA.Subject9.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf2DetectedIssueIndicator(Boolean subjectOf2DetectedIssueIndicator) {
        this.subjectOf2DetectedIssueIndicator.setValue(subjectOf2DetectedIssueIndicator);
    }


    @Hl7XmlMapping({"subjectOf3/annotation"})
    public List<CommentBean> getSubjectOf3Annotation() {
        return this.subjectOf3Annotation;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060210CA.Subject15.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf4/annotationIndicator"})
    public Boolean getSubjectOf4AnnotationIndicator() {
        return this.subjectOf4AnnotationIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT060210CA.Subject15.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf4AnnotationIndicator(Boolean subjectOf4AnnotationIndicator) {
        this.subjectOf4AnnotationIndicator.setValue(subjectOf4AnnotationIndicator);
    }


    @Hl7XmlMapping({"subjectOf5/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf5DetectedIssueEvent() {
        return this.subjectOf5DetectedIssueEvent;
    }

}
