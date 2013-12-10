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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.porx_mt030040ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt011001ca.CareCompositionsBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.ClassifiesBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.ConsentOverriddenByBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.FirstDispenseInformationBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.LastDispenseInformationBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.PrescribedBecauseOfBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.PreviousDispenseInformationBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.RemainingDispenseInformationBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.IncludesBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.RefusalToFillsBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.coct_mt220110ca.DrugProductBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Prescription</p>
 * 
 * <p>Where the prescription is for a combination of drugs 
 * (e.g. 10mg tablets + 40mg tablets) repeatNumber cannot be 
 * populated and quantity must be expressed in mg.</p>
 * 
 * <p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * intended to be receiving.</p>
 */
@Hl7PartTypeMapping({"PORX_MT030040CA.CombinedMedicationRequest"})
@Hl7RootType
public class PrescriptionBean extends MessagePartBean implements ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.Prescription_1 {

    private static final long serialVersionUID = 20131210L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private ConsentOverriddenByBean author;
    private ST component1AdministrationInstructionsText = new STImpl();
    private IncludesBean component2;
    private List<CareCompositionsBean> componentOf1PatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();
    private ClassifiesBean componentOf2;
    private BL derivedFromSourceDispense = new BLImpl(false);
    private DrugProductBean directTargetMedication;
    private RemainingDispenseInformationBean fulfillment1SupplyEventFutureSummary;
    private FirstDispenseInformationBean fulfillment2SupplyEventFirstSummary;
    private LastDispenseInformationBean fulfillment3SupplyEventLastSummary;
    private PreviousDispenseInformationBean fulfillment4SupplyEventPastSummary;
    private BL preconditionVerificationEventCriterion = new BLImpl(false);
    private List<PrescribedBecauseOfBean> reason = new ArrayList<PrescribedBecauseOfBean>();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private BL subjectOf1AnnotationIndicator = new BLImpl(false);
    private BL subjectOf2DetectedIssueIndicator = new BLImpl(false);
    private List<RefusalToFillsBean> subjectOf3RefusalToFill = new ArrayList<RefusalToFillsBean>();


    /**
     * <p>Business Name: A:Prescription Order Number</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.CombinedMedicationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p>It is created by the EHR/DIS 
     * once the prescription has passed all edits and 
     * validation.</p>
     * 
     * <p>The Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p>It is created by the EHR/DIS 
     * once the prescription has passed all edits and 
     * validation.</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * number is mandatory to allow every prescription record to be 
     * uniquely identified.</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * number is mandatory to allow every prescription record to be 
     * uniquely identified.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Prescription Order Number</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.CombinedMedicationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p>It is created by the EHR/DIS 
     * once the prescription has passed all edits and 
     * validation.</p>
     * 
     * <p>The Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p>It is created by the EHR/DIS 
     * once the prescription has passed all edits and 
     * validation.</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * number is mandatory to allow every prescription record to be 
     * uniquely identified.</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * number is mandatory to allow every prescription record to be 
     * uniquely identified.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Prescription Type</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.CombinedMedicationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that this is a prescription for a drug as 
     * opposed to an immunization. For SNOMED, may also contain 
     * information regarding drug and route.</p>
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
     * <p>Business Name: Prescription Type</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.CombinedMedicationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that this is a prescription for a drug as 
     * opposed to an immunization. For SNOMED, may also contain 
     * information regarding drug and route.</p>
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
     * <p>Business Name: C:Prescription Status</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.CombinedMedicationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This denotes the state of the prescription in the 
     * lifecycle of the prescription. Valid statuses are: NEW, 
     * ACTIVE, SUSPENDED, ABORTED, COMPLETED, OBSOLETE and 
     * NULLIFIED.</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against a prescription.</p><p>This is a mandatory field 
     * because every prescription needs to be in some state.</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against a prescription.</p><p>This is a mandatory field 
     * because every prescription needs to be in some state.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: C:Prescription Status</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.CombinedMedicationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This denotes the state of the prescription in the 
     * lifecycle of the prescription. Valid statuses are: NEW, 
     * ACTIVE, SUSPENDED, ABORTED, COMPLETED, OBSOLETE and 
     * NULLIFIED.</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against a prescription.</p><p>This is a mandatory field 
     * because every prescription needs to be in some state.</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against a prescription.</p><p>This is a mandatory field 
     * because every prescription needs to be in some state.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: F:Prescription Masking Indicators</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.CombinedMedicationRequest.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'N' (normal - denotes 'Not Masked'); 'R' (restricted - 
     * denotes 'Masked') and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'N' (normal - denotes 'Not Masked'); 'R' (restricted - 
     * denotes 'Masked') and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'N' (normal - denotes 'Not Masked'); 'R' (restricted - 
     * denotes 'Masked') and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'N' (normal - denotes 'Not Masked'); 'R' (restricted - 
     * denotes 'Masked') and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their medication data.</p><p>Taboo allows the provider to 
     * request restricted access to patient or their care 
     * giver.</p><p>Constraint: Can&#226;&#128;&#153;t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is required because even if a jurisdiction doesn't 
     * support masking on the way in, it will need to need to 
     * communicate masked data returned from other 
     * jurisdictions.</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their medication data.</p><p>Taboo allows the provider to 
     * request restricted access to patient or their care 
     * giver.</p><p>Constraint: Can&#226;&#128;&#153;t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is required because even if a jurisdiction doesn't 
     * support masking on the way in, it will need to need to 
     * communicate masked data returned from other 
     * jurisdictions.</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their medication data.</p><p>Taboo allows the provider to 
     * request restricted access to patient or their care 
     * giver.</p><p>Constraint: Can&#226;&#128;&#153;t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is required because even if a jurisdiction doesn't 
     * support masking on the way in, it will need to need to 
     * communicate masked data returned from other 
     * jurisdictions.</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their medication data.</p><p>Taboo allows the provider to 
     * request restricted access to patient or their care 
     * giver.</p><p>Constraint: Can&#226;&#128;&#153;t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is required because even if a jurisdiction doesn't 
     * support masking on the way in, it will need to need to 
     * communicate masked data returned from other 
     * jurisdictions.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    /**
     * <p>Relationship: 
     * PORX_MT030040CA.CombinedMedicationRequest.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public ConsentOverriddenByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: 
     * PORX_MT030040CA.CombinedMedicationRequest.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(ConsentOverriddenByBean author) {
        this.author = author;
    }


    /**
     * <p>Business Name: Rendered Dosage Instruction</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.AdministrationInstructions.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A free form textual specification generated from the 
     * input specifications as created by the provider.</p><p>This 
     * is made up of either an 'Ad-hoc dosage instruction' or 
     * 'Textual rendition of the structured dosage lines', plus 
     * route, dosage unit, and other pertinent administration 
     * information specified by the provider.</p>
     * 
     * <p>A free form textual specification generated from the 
     * input specifications as created by the provider.</p><p>This 
     * is made up of either an 'Ad-hoc dosage instruction' or 
     * 'Textual rendition of the structured dosage lines', plus 
     * route, dosage unit, and other pertinent administration 
     * information specified by the provider.</p>
     * 
     * <p>Allows the provider to verify the codified structured 
     * dosage information entered and ensure that the exploded 
     * instruction is consistent with the intended 
     * instructions.</p><p>Also useful in bringing back 
     * administration instructions on query responses. Because all 
     * prescriptions and dispenses have dosage, this attribute is 
     * mandatory.</p>
     * 
     * <p>Allows the provider to verify the codified structured 
     * dosage information entered and ensure that the exploded 
     * instruction is consistent with the intended 
     * instructions.</p><p>Also useful in bringing back 
     * administration instructions on query responses. Because all 
     * prescriptions and dispenses have dosage, this attribute is 
     * mandatory.</p>
     */
    @Hl7XmlMapping({"component1/administrationInstructions/text"})
    public String getComponent1AdministrationInstructionsText() {
        return this.component1AdministrationInstructionsText.getValue();
    }

    /**
     * <p>Business Name: Rendered Dosage Instruction</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040CA.AdministrationInstructions.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A free form textual specification generated from the 
     * input specifications as created by the provider.</p><p>This 
     * is made up of either an 'Ad-hoc dosage instruction' or 
     * 'Textual rendition of the structured dosage lines', plus 
     * route, dosage unit, and other pertinent administration 
     * information specified by the provider.</p>
     * 
     * <p>A free form textual specification generated from the 
     * input specifications as created by the provider.</p><p>This 
     * is made up of either an 'Ad-hoc dosage instruction' or 
     * 'Textual rendition of the structured dosage lines', plus 
     * route, dosage unit, and other pertinent administration 
     * information specified by the provider.</p>
     * 
     * <p>Allows the provider to verify the codified structured 
     * dosage information entered and ensure that the exploded 
     * instruction is consistent with the intended 
     * instructions.</p><p>Also useful in bringing back 
     * administration instructions on query responses. Because all 
     * prescriptions and dispenses have dosage, this attribute is 
     * mandatory.</p>
     * 
     * <p>Allows the provider to verify the codified structured 
     * dosage information entered and ensure that the exploded 
     * instruction is consistent with the intended 
     * instructions.</p><p>Also useful in bringing back 
     * administration instructions on query responses. Because all 
     * prescriptions and dispenses have dosage, this attribute is 
     * mandatory.</p>
     */
    public void setComponent1AdministrationInstructionsText(String component1AdministrationInstructionsText) {
        this.component1AdministrationInstructionsText.setValue(component1AdministrationInstructionsText);
    }


    /**
     * <p>Relationship: 
     * PORX_MT030040CA.CombinedMedicationRequest.component2</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"component2"})
    public IncludesBean getComponent2() {
        return this.component2;
    }

    /**
     * <p>Relationship: 
     * PORX_MT030040CA.CombinedMedicationRequest.component2</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setComponent2(IncludesBean component2) {
        this.component2 = component2;
    }


    /**
     * <p>Relationship: 
     * PORX_MT030040CA.Component.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"componentOf1/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOf1PatientCareProvisionEvent() {
        return this.componentOf1PatientCareProvisionEvent;
    }


    /**
     * <p>Relationship: 
     * PORX_MT030040CA.CombinedMedicationRequest.componentOf2</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"componentOf2"})
    public ClassifiesBean getComponentOf2() {
        return this.componentOf2;
    }

    /**
     * <p>Relationship: 
     * PORX_MT030040CA.CombinedMedicationRequest.componentOf2</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setComponentOf2(ClassifiesBean componentOf2) {
        this.componentOf2 = componentOf2;
    }


    /**
     * <p>Relationship: PORX_MT030040CA.DerivedFrom.sourceDispense</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"derivedFrom/sourceDispense"})
    public Boolean getDerivedFromSourceDispense() {
        return this.derivedFromSourceDispense.getValue();
    }

    /**
     * <p>Relationship: PORX_MT030040CA.DerivedFrom.sourceDispense</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setDerivedFromSourceDispense(Boolean derivedFromSourceDispense) {
        this.derivedFromSourceDispense.setValue(derivedFromSourceDispense);
    }


    /**
     * <p>Relationship: PORX_MT030040CA.DirectTarget.medication</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"directTarget/medication"})
    public DrugProductBean getDirectTargetMedication() {
        return this.directTargetMedication;
    }

    /**
     * <p>Relationship: PORX_MT030040CA.DirectTarget.medication</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setDirectTargetMedication(DrugProductBean directTargetMedication) {
        this.directTargetMedication = directTargetMedication;
    }


    /**
     * <p>Relationship: 
     * PORX_MT030040CA.InFulfillmentOf4.supplyEventFutureSummary</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment1/supplyEventFutureSummary"})
    public RemainingDispenseInformationBean getFulfillment1SupplyEventFutureSummary() {
        return this.fulfillment1SupplyEventFutureSummary;
    }

    /**
     * <p>Relationship: 
     * PORX_MT030040CA.InFulfillmentOf4.supplyEventFutureSummary</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setFulfillment1SupplyEventFutureSummary(RemainingDispenseInformationBean fulfillment1SupplyEventFutureSummary) {
        this.fulfillment1SupplyEventFutureSummary = fulfillment1SupplyEventFutureSummary;
    }


    /**
     * <p>Relationship: 
     * PORX_MT030040CA.InFulfillmentOf5.supplyEventFirstSummary</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment2/supplyEventFirstSummary"})
    public FirstDispenseInformationBean getFulfillment2SupplyEventFirstSummary() {
        return this.fulfillment2SupplyEventFirstSummary;
    }

    /**
     * <p>Relationship: 
     * PORX_MT030040CA.InFulfillmentOf5.supplyEventFirstSummary</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setFulfillment2SupplyEventFirstSummary(FirstDispenseInformationBean fulfillment2SupplyEventFirstSummary) {
        this.fulfillment2SupplyEventFirstSummary = fulfillment2SupplyEventFirstSummary;
    }


    /**
     * <p>Relationship: 
     * PORX_MT030040CA.InFulfillmentOf6.supplyEventLastSummary</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment3/supplyEventLastSummary"})
    public LastDispenseInformationBean getFulfillment3SupplyEventLastSummary() {
        return this.fulfillment3SupplyEventLastSummary;
    }

    /**
     * <p>Relationship: 
     * PORX_MT030040CA.InFulfillmentOf6.supplyEventLastSummary</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setFulfillment3SupplyEventLastSummary(LastDispenseInformationBean fulfillment3SupplyEventLastSummary) {
        this.fulfillment3SupplyEventLastSummary = fulfillment3SupplyEventLastSummary;
    }


    /**
     * <p>Relationship: 
     * PORX_MT030040CA.InFulfillmentOf2.supplyEventPastSummary</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment4/supplyEventPastSummary"})
    public PreviousDispenseInformationBean getFulfillment4SupplyEventPastSummary() {
        return this.fulfillment4SupplyEventPastSummary;
    }

    /**
     * <p>Relationship: 
     * PORX_MT030040CA.InFulfillmentOf2.supplyEventPastSummary</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setFulfillment4SupplyEventPastSummary(PreviousDispenseInformationBean fulfillment4SupplyEventPastSummary) {
        this.fulfillment4SupplyEventPastSummary = fulfillment4SupplyEventPastSummary;
    }


    /**
     * <p>Relationship: 
     * PORX_MT030040CA.Precondition.verificationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT030040CA.Precondition.verificationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
    }


    /**
     * <p>Relationship: 
     * PORX_MT030040CA.CombinedMedicationRequest.reason</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1-5)</p>
     */
    @Hl7XmlMapping({"reason"})
    public List<PrescribedBecauseOfBean> getReason() {
        return this.reason;
    }


    /**
     * <p>Relationship: 
     * PORX_MT030040CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    /**
     * <p>Relationship: 
     * PORX_MT030040CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    /**
     * <p>Relationship: PORX_MT030040CA.Subject.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/annotationIndicator"})
    public Boolean getSubjectOf1AnnotationIndicator() {
        return this.subjectOf1AnnotationIndicator.getValue();
    }

    /**
     * <p>Relationship: PORX_MT030040CA.Subject.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf1AnnotationIndicator(Boolean subjectOf1AnnotationIndicator) {
        this.subjectOf1AnnotationIndicator.setValue(subjectOf1AnnotationIndicator);
    }


    /**
     * <p>Relationship: 
     * PORX_MT030040CA.Subject2.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/detectedIssueIndicator"})
    public Boolean getSubjectOf2DetectedIssueIndicator() {
        return this.subjectOf2DetectedIssueIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT030040CA.Subject2.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf2DetectedIssueIndicator(Boolean subjectOf2DetectedIssueIndicator) {
        this.subjectOf2DetectedIssueIndicator.setValue(subjectOf2DetectedIssueIndicator);
    }


    /**
     * <p>Relationship: PORX_MT030040CA.Subject3.refusalToFill</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf3/refusalToFill"})
    public List<RefusalToFillsBean> getSubjectOf3RefusalToFill() {
        return this.subjectOf3RefusalToFill;
    }

}
