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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.porx_mt060100on;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.coct_mt090107on.ProviderBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.coct_mt240003on.ServiceLocationBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.merged.CombinedMedicationRequest_1Bean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.merged.SupplyEventBean;



/**
 * <p>Business Name: Dispense</p>
 * 
 * <p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * actually receiving.</p>
 * 
 * <p>Describes the issuing of a drug in response to an 
 * authorizing prescription.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060100ON.MedicationDispense"})
@Hl7RootType
public class DispenseBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private II id = new IIImpl();
    private CS statusCode = new CSImpl();
    private CV confidentialityCode = new CVImpl();
    private ProviderBean responsiblePartyAssignedPerson;
    private ProviderBean performerAssignedPerson;
    private ServiceLocationBean locationServiceDeliveryLocation;
    private SupplyEventBean component1SupplyEvent;
    private ST component2AdministrationInstructionsText = new STImpl();
    private CombinedMedicationRequest_1Bean fulfillmentSubstanceAdministrationRequest;
    private BL subjectOf1DetectedIssueIndicator = new BLImpl(false);
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);


    /**
     * <p>Business Name: A:Prescription Dispense Number</p>
     * 
     * <p>Relationship: PORX_MT060100ON.MedicationDispense.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows dispense events to be uniquely referenced and is 
     * therefore mandatory.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a prescription dispense by the EHR/DIS 
     * irrespective of the source of the supply event</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Prescription Dispense Number</p>
     * 
     * <p>Relationship: PORX_MT060100ON.MedicationDispense.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows dispense events to be uniquely referenced and is 
     * therefore mandatory.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a prescription dispense by the EHR/DIS 
     * irrespective of the source of the supply event</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: C:Dispense Status</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100ON.MedicationDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates how far along the process the dispense event 
     * is. It should always be known and is therefore 
     * mandatory.</p>
     * 
     * <p>Indicates whether the dispense has been picked up 
     * ('complete') or has just been processed ('active').</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: C:Dispense Status</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100ON.MedicationDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates how far along the process the dispense event 
     * is. It should always be known and is therefore 
     * mandatory.</p>
     * 
     * <p>Indicates whether the dispense has been picked up 
     * ('complete') or has just been processed ('active').</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: E:Prescription Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100ON.MedicationDispense.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their medication data.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' 
     * (denotes 'Masked').</p><p>The default is 'NORMAL' signifying 
     * 'Not Masked'.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Business Name: E:Prescription Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100ON.MedicationDispense.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their medication data.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' 
     * (denotes 'Masked').</p><p>The default is 'NORMAL' signifying 
     * 'Not Masked'.</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Relationship: 
     * PORX_MT060100ON.ResponsibleParty.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060100ON.ResponsibleParty.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    /**
     * <p>Relationship: PORX_MT060100ON.Performer.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"performer/assignedPerson"})
    public ProviderBean getPerformerAssignedPerson() {
        return this.performerAssignedPerson;
    }

    /**
     * <p>Relationship: PORX_MT060100ON.Performer.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPerformerAssignedPerson(ProviderBean performerAssignedPerson) {
        this.performerAssignedPerson = performerAssignedPerson;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060100ON.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060100ON.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: PORX_MT060100ON.Component2.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component1/supplyEvent"})
    public SupplyEventBean getComponent1SupplyEvent() {
        return this.component1SupplyEvent;
    }

    /**
     * <p>Relationship: PORX_MT060100ON.Component2.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponent1SupplyEvent(SupplyEventBean component1SupplyEvent) {
        this.component1SupplyEvent = component1SupplyEvent;
    }


    /**
     * <p>Business Name: Rendered Dosage Instruction</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100ON.AdministrationInstructions.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the provider to verify the codified structured 
     * dosage information entered and ensure that the exploded 
     * instruction is consistent with the intended 
     * instructions.</p><p>Also useful in bringing back 
     * administration instructions on query responses. Because all 
     * prescriptions and dispenses have dosage, this attribute is 
     * mandatory.</p>
     * 
     * <p>For dosage instructions which cannot be summarized in the 
     * space allocated, a string such as &quot;Complex dose&quot; 
     * or &quot;Scaling dose&quot; or something similar should be 
     * sent. Dosage instructions should never be truncated.</p>
     * 
     * <p>A free form textual specification generated from the 
     * input specifications as created by the provider.</p><p>This 
     * is made up of either an 'Ad-hoc dosage instruction' or 
     * 'Textual rendition of the structured dosage lines', plus 
     * route, dosage unit, and other pertinent administration 
     * information specified by the provider.</p>
     */
    @Hl7XmlMapping({"component2/administrationInstructions/text"})
    public String getComponent2AdministrationInstructionsText() {
        return this.component2AdministrationInstructionsText.getValue();
    }

    /**
     * <p>Business Name: Rendered Dosage Instruction</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100ON.AdministrationInstructions.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the provider to verify the codified structured 
     * dosage information entered and ensure that the exploded 
     * instruction is consistent with the intended 
     * instructions.</p><p>Also useful in bringing back 
     * administration instructions on query responses. Because all 
     * prescriptions and dispenses have dosage, this attribute is 
     * mandatory.</p>
     * 
     * <p>For dosage instructions which cannot be summarized in the 
     * space allocated, a string such as &quot;Complex dose&quot; 
     * or &quot;Scaling dose&quot; or something similar should be 
     * sent. Dosage instructions should never be truncated.</p>
     * 
     * <p>A free form textual specification generated from the 
     * input specifications as created by the provider.</p><p>This 
     * is made up of either an 'Ad-hoc dosage instruction' or 
     * 'Textual rendition of the structured dosage lines', plus 
     * route, dosage unit, and other pertinent administration 
     * information specified by the provider.</p>
     */
    public void setComponent2AdministrationInstructionsText(String component2AdministrationInstructionsText) {
        this.component2AdministrationInstructionsText.setValue(component2AdministrationInstructionsText);
    }


    /**
     * <p>Relationship: 
     * PORX_MT060100ON.InFulfillmentOf.substanceAdministrationRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment/substanceAdministrationRequest"})
    public CombinedMedicationRequest_1Bean getFulfillmentSubstanceAdministrationRequest() {
        return this.fulfillmentSubstanceAdministrationRequest;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060100ON.InFulfillmentOf.substanceAdministrationRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setFulfillmentSubstanceAdministrationRequest(CombinedMedicationRequest_1Bean fulfillmentSubstanceAdministrationRequest) {
        this.fulfillmentSubstanceAdministrationRequest = fulfillmentSubstanceAdministrationRequest;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060100ON.Subject4.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/detectedIssueIndicator"})
    public Boolean getSubjectOf1DetectedIssueIndicator() {
        return this.subjectOf1DetectedIssueIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT060100ON.Subject4.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf1DetectedIssueIndicator(Boolean subjectOf1DetectedIssueIndicator) {
        this.subjectOf1DetectedIssueIndicator.setValue(subjectOf1DetectedIssueIndicator);
    }


    /**
     * <p>Relationship: 
     * PORX_MT060100ON.Subject3.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT060100ON.Subject3.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }

}