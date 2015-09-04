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
package ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.pharmacy.porx_mt060090ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.pharmacy.merged.PrescriptionReferenceBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.pharmacy.merged.StatusChangesBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.pharmacy.merged.SubstitutionBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.pharmacy.merged.SupplyEventBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.pharmacy.porx_mt980030ca.IssuesBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.pharmacy.porx_mt980040ca.AdministrationInstructionsBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Dispense</p>
 * 
 * <p>Reported Issue is only permitted if Issue Indicator is 
 * not present</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present</p>
 * 
 * <p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * actually receiving.</p>
 * 
 * <p>Describes the issuing of a drug in response to an 
 * authorizing prescription.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060090CA.MedicationDispense"})
@Hl7RootType
public class DispenseBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private II id = new IIImpl();
    private CS statusCode = new CSImpl();
    private CV confidentialityCode = new CVImpl();
    private ProviderBean responsiblePartyAssignedPerson;
    private ProviderBean performerAssignedPerson;
    private RecordedAtBean location;
    private PrescriptionReferenceBean inFulfillmentOfSubstanceAdministrationRequest;
    private List<AdministrationInstructionsBean> component1DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private SubstitutionBean component2SubstitutionMade;
    private SupplyEventBean component3SupplyEvent;
    private List<StatusChangesBean> subjectOf1ControlActEvent = new ArrayList<StatusChangesBean>();
    private List<IssuesBean> subjectOf2DetectedIssueEvent = new ArrayList<IssuesBean>();
    private List<NotesBean> subjectOf3Annotation = new ArrayList<NotesBean>();
    private BL subjectOf4DetectedIssueIndicator = new BLImpl(false);
    private BL subjectOf5AnnotationIndicator = new BLImpl(false);


    /**
     * <p>Business Name: A:Prescription Dispense Number</p>
     * 
     * <p>Relationship: PORX_MT060090CA.MedicationDispense.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
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
     * <p>Relationship: PORX_MT060090CA.MedicationDispense.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
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
     * PORX_MT060090CA.MedicationDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: C:Dispense Status</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.MedicationDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: E:Prescription Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.MedicationDispense.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Business Name: E:Prescription Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.MedicationDispense.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Relationship: 
     * PORX_MT060090CA.ResponsibleParty2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060090CA.ResponsibleParty2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    /**
     * <p>Relationship: PORX_MT060090CA.Performer3.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"performer/assignedPerson"})
    public ProviderBean getPerformerAssignedPerson() {
        return this.performerAssignedPerson;
    }

    /**
     * <p>Relationship: PORX_MT060090CA.Performer3.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPerformerAssignedPerson(ProviderBean performerAssignedPerson) {
        this.performerAssignedPerson = performerAssignedPerson;
    }


    /**
     * <p>Relationship: PORX_MT060090CA.MedicationDispense.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: PORX_MT060090CA.MedicationDispense.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060090CA.InFulfillmentOf.substanceAdministrationRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/substanceAdministrationRequest"})
    public PrescriptionReferenceBean getInFulfillmentOfSubstanceAdministrationRequest() {
        return this.inFulfillmentOfSubstanceAdministrationRequest;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060090CA.InFulfillmentOf.substanceAdministrationRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInFulfillmentOfSubstanceAdministrationRequest(PrescriptionReferenceBean inFulfillmentOfSubstanceAdministrationRequest) {
        this.inFulfillmentOfSubstanceAdministrationRequest = inFulfillmentOfSubstanceAdministrationRequest;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060090CA.Component11.dosageInstruction</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component1/dosageInstruction"})
    public List<AdministrationInstructionsBean> getComponent1DosageInstruction() {
        return this.component1DosageInstruction;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060090CA.Component13.substitutionMade</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component2/substitutionMade"})
    public SubstitutionBean getComponent2SubstitutionMade() {
        return this.component2SubstitutionMade;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060090CA.Component13.substitutionMade</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent2SubstitutionMade(SubstitutionBean component2SubstitutionMade) {
        this.component2SubstitutionMade = component2SubstitutionMade;
    }


    /**
     * <p>Relationship: PORX_MT060090CA.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component3/supplyEvent"})
    public SupplyEventBean getComponent3SupplyEvent() {
        return this.component3SupplyEvent;
    }

    /**
     * <p>Relationship: PORX_MT060090CA.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponent3SupplyEvent(SupplyEventBean component3SupplyEvent) {
        this.component3SupplyEvent = component3SupplyEvent;
    }


    /**
     * <p>Relationship: PORX_MT060090CA.Subject.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public List<StatusChangesBean> getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }


    /**
     * <p>Relationship: PORX_MT060090CA.Subject6.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf2DetectedIssueEvent() {
        return this.subjectOf2DetectedIssueEvent;
    }


    /**
     * <p>Relationship: PORX_MT060090CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf3/annotation"})
    public List<NotesBean> getSubjectOf3Annotation() {
        return this.subjectOf3Annotation;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060090CA.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf4/detectedIssueIndicator"})
    public Boolean getSubjectOf4DetectedIssueIndicator() {
        return this.subjectOf4DetectedIssueIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT060090CA.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf4DetectedIssueIndicator(Boolean subjectOf4DetectedIssueIndicator) {
        this.subjectOf4DetectedIssueIndicator.setValue(subjectOf4DetectedIssueIndicator);
    }


    /**
     * <p>Relationship: 
     * PORX_MT060090CA.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf5/annotationIndicator"})
    public Boolean getSubjectOf5AnnotationIndicator() {
        return this.subjectOf5AnnotationIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT060090CA.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf5AnnotationIndicator(Boolean subjectOf5AnnotationIndicator) {
        this.subjectOf5AnnotationIndicator.setValue(subjectOf5AnnotationIndicator);
    }

}