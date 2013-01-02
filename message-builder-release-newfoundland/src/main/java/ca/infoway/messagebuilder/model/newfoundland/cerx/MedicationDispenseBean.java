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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
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
import ca.infoway.messagebuilder.domainvalue.Confidentiality;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.DetectedIssueBean;
import ca.infoway.messagebuilder.model.newfoundland.NoteBean;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBean;

@Hl7PartTypeMapping({ "PORX_MT060100CA.MedicationDispense", "PORX_MT060090CA.MedicationDispense" })
public class MedicationDispenseBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 942287881917020376L;

    private II id = new IIImpl();

    private CD statusCode = new CDImpl();

    private CD confidentialityCode = new CDImpl();

    private AssignedPersonBean responsibleParty;

    private AssignedPersonBean performer;

    private ServiceDeliveryLocationBean location;

    private SubstanceAdministrationRequestBean substanceAdministrationRequest;

    private List<DosageInstructionBean> dosageInstructions = Collections.synchronizedList(new ArrayList<DosageInstructionBean>());

    private SubstitutionMadeBean substitutionMade;

    private SupplyEventBean supplyEvent;

    private ST administrationInstructions = new STImpl();

    private final List<HistoricalControlActEventBean> dispenseHistoryRecords = Collections.synchronizedList(new ArrayList<HistoricalControlActEventBean>());

    private final List<DetectedIssueBean> detectedIssues = Collections.synchronizedList(new ArrayList<DetectedIssueBean>());

    private List<NoteBean> notes = Collections.synchronizedList(new ArrayList<NoteBean>());

    private BL detectedIssueIndicator = new BLImpl(false);

    private BL annotationIndicator = new BLImpl(false);

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
    public Confidentiality getConfidentialityCode() {
        return (Confidentiality) this.confidentialityCode.getValue();
    }

    public void setConfidentialityCode(Confidentiality confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }

    @Hl7XmlMapping("performer/assignedPerson")
    public AssignedPersonBean getPerformer() {
        return performer;
    }

    public void setPerformer(AssignedPersonBean responsibleParty) {
        this.performer = responsibleParty;
    }

    @Hl7XmlMapping("location/serviceDeliveryLocation")
    public ServiceDeliveryLocationBean getLocation() {
        return location;
    }

    public void setLocation(ServiceDeliveryLocationBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({ "component1/supplyEvent", "component3/supplyEvent" })
    public SupplyEventBean getSupplyEvent() {
        return supplyEvent;
    }

    public void setSupplyEvent(SupplyEventBean supplyEvent) {
        this.supplyEvent = supplyEvent;
    }

    @Hl7XmlMapping("component2/administrationInstructions/text")
    public String getAdministrationInstructions() {
        return this.administrationInstructions.getValue();
    }

    public void setAdministrationInstructions(String administrationInstructions) {
        this.administrationInstructions.setValue(administrationInstructions);
    }

    @Hl7XmlMapping({ "fulfillment/substanceAdministrationRequest", "inFulfillmentOf/substanceAdministrationRequest" })
    public SubstanceAdministrationRequestBean getSubstanceAdministrationRequest() {
        return substanceAdministrationRequest;
    }

    public void setSubstanceAdministrationRequest(SubstanceAdministrationRequestBean substanceAdministrationRequest) {
        this.substanceAdministrationRequest = substanceAdministrationRequest;
    }

    @Hl7XmlMapping({ "subjectOf1/detectedIssueIndicator", "subjectOf4/detectedIssueIndicator" })
    public Boolean getDetectedIssueIndicator() {
        return detectedIssueIndicator.getValue();
    }

    public void setDetectedIssueIndicator(Boolean detectedIssueIndicator) {
        this.detectedIssueIndicator.setValue(detectedIssueIndicator);
    }

    @Hl7XmlMapping({ "subjectOf2/annotationIndicator", "subjectOf5/annotationIndicator" })
    public Boolean getAnnotationIndicator() {
        return annotationIndicator.getValue();
    }

    public void setAnnotationIndicator(Boolean annotationIndicator) {
        this.annotationIndicator.setValue(annotationIndicator);
    }

    @Hl7XmlMapping({ "responsibleParty/assignedPerson" })
    public AssignedPersonBean getResponsibleParty() {
        return responsibleParty;
    }

    public void setResponsibleParty(AssignedPersonBean responsibleParty) {
        this.responsibleParty = responsibleParty;
    }

    @Hl7XmlMapping({ "component1/dosageInstruction" })
    public List<DosageInstructionBean> getDosageInstructions() {
        return dosageInstructions;
    }

    public void setDosageInstructions(List<DosageInstructionBean> dosageInstructions) {
        this.dosageInstructions = dosageInstructions;
    }

    @Hl7XmlMapping("subjectOf3/annotation")
    public List<NoteBean> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteBean> notes) {
        this.notes = notes;
    }

    @Hl7XmlMapping("subjectOf2/detectedIssueEvent")
    public List<DetectedIssueBean> getDetectedIssues() {
        return this.detectedIssues;
    }

    @Hl7XmlMapping("component2/substitutionMade")
    public SubstitutionMadeBean getSubstitutionMade() {
        return substitutionMade;
    }

    public void setSubstitutionMade(SubstitutionMadeBean substitutionMade) {
        this.substitutionMade = substitutionMade;
    }

    @Hl7XmlMapping("subjectOf1/controlActEvent")
    public List<HistoricalControlActEventBean> getDispenseHistoryRecords() {
        return dispenseHistoryRecords;
    }
}
