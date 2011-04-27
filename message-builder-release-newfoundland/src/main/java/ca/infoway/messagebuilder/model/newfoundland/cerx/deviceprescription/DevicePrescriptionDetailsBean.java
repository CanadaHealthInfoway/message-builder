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

package ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBean;
import ca.infoway.messagebuilder.model.newfoundland.DetectedIssueBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.NoteBean;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.CoverageExtentionBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DeviceDispenseInstructionsBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.HistoricalControlActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.Prescription;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ReasonBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.RefusalToFillBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.CumulativeSupplySummaryBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.SupplySummaryBean;
import ca.infoway.messagebuilder.model.newfoundland.confidentiality.VeryBasicConfidentiality;

@Hl7PartTypeMapping({ "PORX_MT060040CA.DeviceRequest" })
public class DevicePrescriptionDetailsBean extends MessagePartBean implements Serializable, VeryBasicConfidentiality, Prescription {

    private static final long serialVersionUID = -337725170698013235L;

    private final II id = new IIImpl();

    private final CD statusCode = new CDImpl();

    private final CD confidentialityCode = new CDImpl();

    private ClinicalDeviceBean clinicalDevice;

    private IdentifiedPersonBean patient;

    private AssignedPersonBean responsibleParty;

    private AuthorBean author;

    private ServiceDeliveryLocationBean location;

    private final II previousPrescriptionOrderNumber = new IIImpl();

    private final List<ReasonBean> reasons = Collections.synchronizedList(new ArrayList<ReasonBean>());

    private final List<CoverageExtentionBean> coverages = Collections.synchronizedList(new ArrayList<CoverageExtentionBean>());

    private final ST usageInstructions = new STImpl();

    private DeviceDispenseInstructionsBean dispenseInstructions;

    private SupplySummaryBean supplyEventLastSummary;

    private SupplySummaryBean supplyEventFirstSummary;

    private CumulativeSupplySummaryBean supplyEventFutureSummary;

    private CumulativeSupplySummaryBean supplyEventPastSummary;

    private final List<DeviceDispenseBean> prescriptionDispenses = Collections.synchronizedList(new ArrayList<DeviceDispenseBean>());

    private final List<DetectedIssueBean> detectedIssues = Collections.synchronizedList(new ArrayList<DetectedIssueBean>());

    private final List<HistoricalControlActEventBean> deviceDispenseHistoryRecords = Collections.synchronizedList(new ArrayList<HistoricalControlActEventBean>());

    private final List<NoteBean> notes = Collections.synchronizedList(new ArrayList<NoteBean>());

    private final List<RefusalToFillBean> refusalToFill = Collections.synchronizedList(new ArrayList<RefusalToFillBean>());

    @Hl7XmlMapping("id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping("statusCode")
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

    @Hl7XmlMapping("confidentialityCode")
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }

    @Hl7XmlMapping("directTarget/manufacturedProduct/manufacturedClinicalDevice")
    public ClinicalDeviceBean getDirectTarget() {
        return clinicalDevice;
    }

    public void setDirectTarget(ClinicalDeviceBean directTarget) {
        this.clinicalDevice = directTarget;
    }

    @Hl7XmlMapping("subject/patient")
    public IdentifiedPersonBean getPatient() {
        return patient;
    }

    public void setPatient(IdentifiedPersonBean patient) {
        this.patient = patient;
    }

    @Hl7XmlMapping("responsibleParty/assignedPerson")
    public AssignedPersonBean getResponsibleParty() {
        return responsibleParty;
    }

    public void setResponsibleParty(AssignedPersonBean responsibleParty) {
        this.responsibleParty = responsibleParty;
    }

    @Hl7XmlMapping("author")
    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    @Hl7XmlMapping("location/serviceDeliveryLocation")
    public ServiceDeliveryLocationBean getLocation() {
        return location;
    }

    public void setLocation(ServiceDeliveryLocationBean location) {
        this.location = location;
    }

    @Hl7XmlMapping("predecessor/priorSupplyRequest/id")
    public Identifier getPreviousPrescriptionOrderNumber() {
        return this.previousPrescriptionOrderNumber.getValue();
    }

    public void setPreviousPrescriptionOrderNumber(Identifier priorSupplyRequestId) {
        this.previousPrescriptionOrderNumber.setValue(priorSupplyRequestId);
    }

    @Hl7XmlMapping("reason")
    public List<ReasonBean> getReasons() {
        return reasons;
    }

    @Hl7XmlMapping("coverage/coverage")
    public List<CoverageExtentionBean> getCoverages() {
        return coverages;
    }

    @Hl7XmlMapping("component1/procedureRequest/text")
    public String getUsageInstructions() {
        return this.usageInstructions.getValue();
    }

    public void setUsageInstructions(String usageInstructions) {
        this.usageInstructions.setValue(usageInstructions);
    }

    @Hl7XmlMapping("component2/supplyRequest")
    public DeviceDispenseInstructionsBean getDispenseInstructions() {
        return dispenseInstructions;
    }

    public void setDispenseInstructions(DeviceDispenseInstructionsBean dispenseInstructions) {
        this.dispenseInstructions = dispenseInstructions;
    }

    @Hl7XmlMapping("fulfillment1/supplyEventLastSummary")
    public SupplySummaryBean getSupplyEventLastSummary() {
        return supplyEventLastSummary;
    }

    public void setSupplyEventLastSummary(SupplySummaryBean supplyEventLastSummary) {
        this.supplyEventLastSummary = supplyEventLastSummary;
    }

    @Hl7XmlMapping("fulfillment2/supplyEventFirstSummary")
    public SupplySummaryBean getSupplyEventFirstSummary() {
        return supplyEventFirstSummary;
    }

    public void setSupplyEventFirstSummary(SupplySummaryBean supplyEventFirstSummary) {
        this.supplyEventFirstSummary = supplyEventFirstSummary;
    }

    @Hl7XmlMapping("fulfillment3/supplyEventFutureSummary")
    public CumulativeSupplySummaryBean getSupplyEventFutureSummary() {
        return supplyEventFutureSummary;
    }

    public void setSupplyEventFutureSummary(CumulativeSupplySummaryBean supplyEventFutureSummary) {
        this.supplyEventFutureSummary = supplyEventFutureSummary;
    }

    @Hl7XmlMapping("fulfillment4/supplyEventPastSummary")
    public CumulativeSupplySummaryBean getSupplyEventPastSummary() {
        return supplyEventPastSummary;
    }

    public void setSupplyEventPastSummary(CumulativeSupplySummaryBean supplyEventPastSummary) {
        this.supplyEventPastSummary = supplyEventPastSummary;
    }

    @Hl7XmlMapping("fulfillment5/deviceDispense")
    public List<DeviceDispenseBean> getPrescriptionDispenses() {
        return prescriptionDispenses;
    }

    @Hl7XmlMapping("subjectOf1/detectedIssueEvent")
    public List<DetectedIssueBean> getDetectedIssues() {
        return detectedIssues;
    }

    @Hl7XmlMapping("subjectOf2/controlActEvent")
    public List<HistoricalControlActEventBean> getDeviceDispenseHistoryRecords() {
        return deviceDispenseHistoryRecords;
    }

    @Hl7XmlMapping("subjectOf3/annotation")
    public List<NoteBean> getNotes() {
        return notes;
    }

    @Hl7XmlMapping("subjectOf4/refusalToFill")
    public List<RefusalToFillBean> getRefusalToFill() {
        return refusalToFill;
    }
}
