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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.pharmacy.porx_mt060210ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt011001ca.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt220110ca.DrugProductBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt270010ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.IssuesBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.RefusedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.pharmacy.merged.StatusChangesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Other Medication</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present and vice versa</p><p>routeCode must not be used 
 * when code is SNOMED and is mandatory otherwise</p><p>Status 
 * can only be ACTIVE or COMPLETE</p><p>Reported Issue is only 
 * permitted if Issue Indicator is not present and vice 
 * versa</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present and vice versa</p><p>routeCode must not be used 
 * when code is SNOMED and is mandatory otherwise</p><p>Status 
 * can only be ACTIVE or COMPLETE</p><p>Reported Issue is only 
 * permitted if Issue Indicator is not present and vice 
 * versa</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present and vice versa</p><p>routeCode must not be used 
 * when code is SNOMED and is mandatory otherwise</p><p>Status 
 * can only be ACTIVE or COMPLETE</p><p>Reported Issue is only 
 * permitted if Issue Indicator is not present and vice 
 * versa</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present and vice versa</p><p>routeCode must not be used 
 * when code is SNOMED and is mandatory otherwise</p><p>Status 
 * can only be ACTIVE or COMPLETE</p><p>Reported Issue is only 
 * permitted if Issue Indicator is not present and vice 
 * versa</p>
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
 * 
 * <p>Necessary component of a person's overall medication 
 * profile. Allows DUR checking against a more complete drug 
 * profile.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060210CA.OtherMedication"})
@Hl7RootType
public class OtherMedicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private CV routeCode = new CVImpl();
    private DrugProductBean consumableMedication;
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private RefusedByBean author;
    private CreatedAtBean location;
    private List<AdministrationInstructionsBean> componentDosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private List<StatusChangesBean> subjectOf1ControlActEvent = new ArrayList<StatusChangesBean>();
    private BL subjectOf2DetectedIssueIndicator = new BLImpl(false);
    private List<NotesBean> subjectOf3Annotation = new ArrayList<NotesBean>();
    private BL subjectOf4AnnotationIndicator = new BLImpl(false);
    private List<IssuesBean> subjectOf5DetectedIssueEvent = new ArrayList<IssuesBean>();
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>A:Administration Record Id</p>
     * 
     * <p>This is an identifier assigned to a unique instance of an 
     * active medication record.</p>
     * 
     * <p>Allows for the unique referencing of a specific active 
     * medication record. Thus the mandatory requirement. .</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>A:Administration Record Id</p>
     * 
     * <p>This is an identifier assigned to a unique instance of an 
     * active medication record.</p>
     * 
     * <p>Allows for the unique referencing of a specific active 
     * medication record. Thus the mandatory requirement. .</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Other Medication Type</p>
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
     * <p>Other Medication Type</p>
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
     * <p>B:Other Medication Status</p>
     * 
     * <p>Indicates the status of the other medication record 
     * created on the EHR/DIS. Valid statuses for other medication 
     * records are: 'active' and 'completed' only.</p>
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
     * <p>Used to determine whether the medication should be 
     * considered in performing DUR checking.</p><p>Attribute is 
     * mandatory to ensure that a medication recorded in EHR/DIS is 
     * in some state.</p><p>Note ------ The provider might know 
     * that the patient is not taking the medication but not 
     * necessarily when the patient stopped it. Thus the status of 
     * the medication could be set to 'completed' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>B:Other Medication Status</p>
     * 
     * <p>Indicates the status of the other medication record 
     * created on the EHR/DIS. Valid statuses for other medication 
     * records are: 'active' and 'completed' only.</p>
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
     * <p>Used to determine whether the medication should be 
     * considered in performing DUR checking.</p><p>Attribute is 
     * mandatory to ensure that a medication recorded in EHR/DIS is 
     * in some state.</p><p>Note ------ The provider might know 
     * that the patient is not taking the medication but not 
     * necessarily when the patient stopped it. Thus the status of 
     * the medication could be set to 'completed' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>C:Drug Active Period</p>
     * 
     * <p>Indicates the time-period in which the patient has been 
     * taking or is expected to be taking the medication.</p>
     * 
     * <p>Used to help determine whether the medication is 
     * currently active. Because this information won't always be 
     * available, the attribute is marked as 'populated'.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>C:Drug Active Period</p>
     * 
     * <p>Indicates the time-period in which the patient has been 
     * taking or is expected to be taking the medication.</p>
     * 
     * <p>Used to help determine whether the medication is 
     * currently active. Because this information won't always be 
     * available, the attribute is marked as 'populated'.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>D:Other Medication Masking Indicators</p>
     * 
     * <p>Denotes access restriction place on the other medication 
     * record.</p><p>Methods for accessing masked other medications 
     * will be governed by each jurisdiction (e.g. court orders, 
     * shared secret/consent, etc.).</p><p>Valid values are: 'N' 
     * (normal - denotes 'Not Masked'); 'R' (restricted - denotes 
     * 'Masked') and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p>
     * 
     * <p>Denotes access restriction place on the other medication 
     * record.</p><p>Methods for accessing masked other medications 
     * will be governed by each jurisdiction (e.g. court orders, 
     * shared secret/consent, etc.).</p><p>Valid values are: 'N' 
     * (normal - denotes 'Not Masked'); 'R' (restricted - denotes 
     * 'Masked') and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p>
     * 
     * <p>Denotes access restriction place on the other medication 
     * record.</p><p>Methods for accessing masked other medications 
     * will be governed by each jurisdiction (e.g. court orders, 
     * shared secret/consent, etc.).</p><p>Valid values are: 'N' 
     * (normal - denotes 'Not Masked'); 'R' (restricted - denotes 
     * 'Masked') and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p>
     * 
     * <p>Denotes access restriction place on the other medication 
     * record.</p><p>Methods for accessing masked other medications 
     * will be governed by each jurisdiction (e.g. court orders, 
     * shared secret/consent, etc.).</p><p>Valid values are: 'N' 
     * (normal - denotes 'Not Masked'); 'R' (restricted - denotes 
     * 'Masked') and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>Taboo 
     * allows the provider to request restricted access to patient 
     * or their care giver.</p><p>Constraint: Cant have both normal 
     * and one of the other codes simultaneously.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>Taboo 
     * allows the provider to request restricted access to patient 
     * or their care giver.</p><p>Constraint: Cant have both normal 
     * and one of the other codes simultaneously.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>Taboo 
     * allows the provider to request restricted access to patient 
     * or their care giver.</p><p>Constraint: Cant have both normal 
     * and one of the other codes simultaneously.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>Taboo 
     * allows the provider to request restricted access to patient 
     * or their care giver.</p><p>Constraint: Cant have both normal 
     * and one of the other codes simultaneously.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    /**
     * <p>E:Route of Administration</p>
     * 
     * <p>This is the means by which the patient is taking the 
     * medication.</p>
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
     * <p>E:Route of Administration</p>
     * 
     * <p>This is the means by which the patient is taking the 
     * medication.</p>
     * 
     * <p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and route. Because 
     * this information is pre-coordinated into 'code' for SNOMED, 
     * it is marked as optional.</p>
     */
    public void setRouteCode(RouteOfAdministration routeCode) {
        this.routeCode.setValue(routeCode);
    }


    @Hl7XmlMapping({"consumable/medication"})
    public DrugProductBean getConsumableMedication() {
        return this.consumableMedication;
    }

    public void setConsumableMedication(DrugProductBean consumableMedication) {
        this.consumableMedication = consumableMedication;
    }


    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }

    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }

    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"component/dosageInstruction"})
    public List<AdministrationInstructionsBean> getComponentDosageInstruction() {
        return this.componentDosageInstruction;
    }


    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public List<StatusChangesBean> getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }


    @Hl7XmlMapping({"subjectOf2/detectedIssueIndicator"})
    public Boolean getSubjectOf2DetectedIssueIndicator() {
        return this.subjectOf2DetectedIssueIndicator.getValue();
    }

    public void setSubjectOf2DetectedIssueIndicator(Boolean subjectOf2DetectedIssueIndicator) {
        this.subjectOf2DetectedIssueIndicator.setValue(subjectOf2DetectedIssueIndicator);
    }


    @Hl7XmlMapping({"subjectOf3/annotation"})
    public List<NotesBean> getSubjectOf3Annotation() {
        return this.subjectOf3Annotation;
    }


    @Hl7XmlMapping({"subjectOf4/annotationIndicator"})
    public Boolean getSubjectOf4AnnotationIndicator() {
        return this.subjectOf4AnnotationIndicator.getValue();
    }

    public void setSubjectOf4AnnotationIndicator(Boolean subjectOf4AnnotationIndicator) {
        this.subjectOf4AnnotationIndicator.setValue(subjectOf4AnnotationIndicator);
    }


    @Hl7XmlMapping({"subjectOf5/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf5DetectedIssueEvent() {
        return this.subjectOf5DetectedIssueEvent;
    }


    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
