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

package ca.infoway.messagebuilder.model.newfoundland.cerx.othermedication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifiable;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.DetectedIssueBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.NoteBean;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DosageInstructionBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.MedicineBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.MedicationProfileSummaryBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.MedicationRecordBean;

@Hl7PartTypeMapping({ "PORX_MT060210CA.OtherMedication", "PORX_MT040010CA.OtherMedication", "PORX_MT040020CA.OtherMedication", "PORX_MT060160CA.OtherMedication", "PORX_MT060190CA.OtherMedication" })
public class OtherMedicationBean extends MedicationRecordBean implements Serializable, Identifiable, MedicationProfileSummaryBean {

    private static final long serialVersionUID = -3261460557583360592L;

    private II id = new IIImpl();

    private CD code = new CDImpl();

    private CD statusCode = new CDImpl();

    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();

    private CD confidentialityCode = new CDImpl();

    private CD routeCode = new CDImpl();

    private MedicineBean medicine = new MedicineBean();

    private IdentifiedPersonBean patient = new IdentifiedPersonBean();

    private ServiceDeliveryLocationBean location;

    private AssignedPersonBean author;

    private AssignedPersonBean responsibleParty;

    private final List<NoteBean> annotations = Collections.synchronizedList(new ArrayList<NoteBean>());

    private final List<DetectedIssueBean> detectedIssues = Collections.synchronizedList(new ArrayList<DetectedIssueBean>());

    private BL annotationIndicator = new BLImpl(false);

    private BL detectedIssuesIndicator = new BLImpl(false);

    private List<DosageInstructionBean> dosageInstructions = Collections.synchronizedList(new ArrayList<DosageInstructionBean>());

    @Hl7XmlMapping("consumable/medication/player")
    public MedicineBean getMedicine() {
        return this.medicine;
    }

    public void setMedicine(MedicineBean medicine) {
        this.medicine = medicine;
    }

    @Hl7XmlMapping("id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping("code")
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    public void setCode(ActCode code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("statusCode")
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

    @Hl7XmlMapping("effectiveTime")
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

    @Hl7XmlMapping("confidentialityCode")
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }

    @Hl7XmlMapping("routeCode")
    public RouteOfAdministration getRouteCode() {
        return (RouteOfAdministration) this.routeCode.getValue();
    }

    public void setRouteCode(RouteOfAdministration routeCode) {
        this.routeCode.setValue(routeCode);
    }

    @Hl7XmlMapping("subject/patient")
    public IdentifiedPersonBean getPatient() {
        return this.patient;
    }

    public void setPatient(IdentifiedPersonBean patient) {
        this.patient = patient;
    }

    @Hl7XmlMapping("location/serviceDeliveryLocation")
    public ServiceDeliveryLocationBean getLocation() {
        return this.location;
    }

    public void setLocation(ServiceDeliveryLocationBean location) {
        this.location = location;
    }

    @Hl7XmlMapping("author/assignedPerson")
    public AssignedPersonBean getAuthor() {
        return this.author;
    }

    public void setAuthor(AssignedPersonBean author) {
        this.author = author;
    }

    @Hl7XmlMapping({ "subjectOf3/annotation", "subjectOf/annotation" })
    public List<NoteBean> getAnnotations() {
        return this.annotations;
    }

    @Hl7XmlMapping({ "subjectOf5/detectedIssueEvent" })
    public List<DetectedIssueBean> getDetectedIssues() {
        return this.detectedIssues;
    }

    @Hl7XmlMapping({ "subjectOf4/annotationIndicator", "subjectOf2/annotationIndicator" })
    public Boolean getAnnotationIndicator() {
        return this.annotationIndicator.getValue();
    }

    public void setAnnotationIndicator(Boolean annotationIndicator) {
        this.annotationIndicator.setValue(annotationIndicator);
    }

    @Hl7XmlMapping({ "subjectOf1/detectedIssueIndicator" })
    public Boolean getDetectedIssuesIndicator() {
        return detectedIssuesIndicator.getValue();
    }

    public void setDetectedIssuesIndicator(Boolean detectedIssuesIndicator) {
        this.detectedIssuesIndicator.setValue(detectedIssuesIndicator);
    }

    @Hl7XmlMapping("component/dosageInstruction")
    public List<DosageInstructionBean> getDosageInstructions() {
        return this.dosageInstructions;
    }

    public void setDosageInstructions(List<DosageInstructionBean> dosageInstructions) {
        this.dosageInstructions = dosageInstructions;
    }

    @Hl7XmlMapping("responsibleParty/assignedPerson")
    public AssignedPersonBean getResponsibleParty() {
        return this.responsibleParty;
    }

    public void setResponsibleParty(AssignedPersonBean responsibleParty) {
        this.responsibleParty = responsibleParty;
    }
}
