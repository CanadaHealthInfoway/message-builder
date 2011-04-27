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

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ReasonBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.RefusalToFillBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.CumulativeSupplySummaryBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.SupplySummaryBean;
import ca.infoway.messagebuilder.model.newfoundland.confidentiality.VeryBasicConfidentiality;

public abstract class BasePrescriptionBean extends MessagePartBean implements VeryBasicConfidentiality, Serializable {

    private static final long serialVersionUID = -2470828955019658352L;

    private II id = new IIImpl();

    private CD statusCode = new CDImpl();

    private CD confidentialityCode = new CDImpl();

    private IdentifiedPersonBean patient;

    private AssignedPersonBean responsibleParty;

    private AuthorBean author;

    private final List<ReasonBean> reasons = Collections.synchronizedList(new ArrayList<ReasonBean>());

    private ST usageInstructions = new STImpl();

    private final List<RefusalToFillBean> refusalToFill = Collections.synchronizedList(new ArrayList<RefusalToFillBean>());

    private SupplySummaryBean supplyEventLastSummary;

    private SupplySummaryBean supplyEventFirstSummary;

    private CumulativeSupplySummaryBean supplyEventFutureSummary;

    private CumulativeSupplySummaryBean supplyEventPastSummary;

    private BL annotationIndicator = new BLImpl(false);

    private BL detectedIssueIndicator = new BLImpl(false);

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

    @Hl7XmlMapping("reason")
    public List<ReasonBean> getReasons() {
        return reasons;
    }

    @Hl7XmlMapping({ "component1/procedureRequest/text", "component1/administrationInstructions/text" })
    public String getUsageInstructions() {
        return this.usageInstructions.getValue();
    }

    public void setUsageInstructions(String usageInstructions) {
        this.usageInstructions.setValue(usageInstructions);
    }

    @Hl7XmlMapping("subjectOf3/refusalToFill")
    public List<RefusalToFillBean> getRefusalToFill() {
        return refusalToFill;
    }

    @Hl7XmlMapping("fulfillment1/supplyEventFutureSummary")
    public CumulativeSupplySummaryBean getSupplyEventFutureSummary() {
        return supplyEventFutureSummary;
    }

    public void setSupplyEventFutureSummary(CumulativeSupplySummaryBean supplyEventFutureSummary) {
        this.supplyEventFutureSummary = supplyEventFutureSummary;
    }

    @Hl7XmlMapping("fulfillment2/supplyEventFirstSummary")
    public SupplySummaryBean getSupplyEventFirstSummary() {
        return supplyEventFirstSummary;
    }

    public void setSupplyEventFirstSummary(SupplySummaryBean supplyEventFirstSummary) {
        this.supplyEventFirstSummary = supplyEventFirstSummary;
    }

    @Hl7XmlMapping("fulfillment3/supplyEventLastSummary")
    public SupplySummaryBean getSupplyEventLastSummary() {
        return supplyEventLastSummary;
    }

    public void setSupplyEventLastSummary(SupplySummaryBean supplyEventLastSummary) {
        this.supplyEventLastSummary = supplyEventLastSummary;
    }

    @Hl7XmlMapping("fulfillment4/supplyEventPastSummary")
    public CumulativeSupplySummaryBean getSupplyEventPastSummary() {
        return supplyEventPastSummary;
    }

    public void setSupplyEventPastSummary(CumulativeSupplySummaryBean supplyEventPastSummary) {
        this.supplyEventPastSummary = supplyEventPastSummary;
    }

    @Hl7XmlMapping("subjectOf1/annotationIndicator")
    public Boolean getAnnotationIndicator() {
        return annotationIndicator.getValue();
    }

    public void setAnnotationIndicator(Boolean annotationIndicator) {
        this.annotationIndicator.setValue(annotationIndicator);
    }

    @Hl7XmlMapping("subjectOf2/detectedIssueIndicator")
    public Boolean getDetectedIssueIndicator() {
        return detectedIssueIndicator.getValue();
    }

    public void setDetectedIssueIndicator(Boolean detectedIssueIndicator) {
        this.detectedIssueIndicator.setValue(detectedIssueIndicator);
    }
}
