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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt060160ca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220110ca.DrugProductBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.RefusedByBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.IssuesBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.StatusChangesBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt980040ca.AdministrationInstructionsBean;



@Hl7PartTypeMapping({"PORX_MT060160CA.OtherMedication"})
public class OtherMedicationsBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.MedicationRecord {

    private static final long serialVersionUID = 20110831L;
    private II administrationRecordId = new IIImpl();
    private CD otherMedicationType = new CDImpl();
    private CS otherMedicationStatus = new CSImpl();
    private IVL<TS, Interval<Date>> drugActivePeriod = new IVLImpl<TS, Interval<Date>>();
    private CV otherMedicationMaskingIndicator = new CVImpl();
    private CV routeOfAdministration = new CVImpl();
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
     * <p>A:Administration Record Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getAdministrationRecordId() {
        return this.administrationRecordId.getValue();
    }
    public void setAdministrationRecordId(Identifier administrationRecordId) {
        this.administrationRecordId.setValue(administrationRecordId);
    }


    /**
     * <p>Other Medication Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getOtherMedicationType() {
        return (ActCode) this.otherMedicationType.getValue();
    }
    public void setOtherMedicationType(ActCode otherMedicationType) {
        this.otherMedicationType.setValue(otherMedicationType);
    }


    /**
     * <p>B:Other Medication Status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getOtherMedicationStatus() {
        return (ActStatus) this.otherMedicationStatus.getValue();
    }
    public void setOtherMedicationStatus(ActStatus otherMedicationStatus) {
        this.otherMedicationStatus.setValue(otherMedicationStatus);
    }


    /**
     * <p>C:Drug Active Period</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDrugActivePeriod() {
        return this.drugActivePeriod.getValue();
    }
    public void setDrugActivePeriod(Interval<Date> drugActivePeriod) {
        this.drugActivePeriod.setValue(drugActivePeriod);
    }


    /**
     * <p>D:Other Medication Masking Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getOtherMedicationMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.otherMedicationMaskingIndicator.getValue();
    }
    public void setOtherMedicationMaskingIndicator(x_VeryBasicConfidentialityKind otherMedicationMaskingIndicator) {
        this.otherMedicationMaskingIndicator.setValue(otherMedicationMaskingIndicator);
    }


    /**
     * <p>E:Route of Administration</p>
     */
    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getRouteOfAdministration() {
        return (RouteOfAdministration) this.routeOfAdministration.getValue();
    }
    public void setRouteOfAdministration(RouteOfAdministration routeOfAdministration) {
        this.routeOfAdministration.setValue(routeOfAdministration);
    }


    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"consumable/medication"})
    public DrugProductBean getConsumableMedication() {
        return this.consumableMedication;
    }
    public void setConsumableMedication(DrugProductBean consumableMedication) {
        this.consumableMedication = consumableMedication;
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
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
    public List<CommentBean> getSubjectOf3Annotation() {
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

}
