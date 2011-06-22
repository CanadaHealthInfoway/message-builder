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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.coct_mt220110ca.DrugProductBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Prescription</p>
 * 
 * <p>PORX_MT030040CA.CombinedMedicationRequest: Prescription</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Information 
 * pertaining to a Prescriber's authorization for a drug to be 
 * dispensed to a patient, as well as the instruction on when 
 * and how the drug is to be administered to the patient.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is a 
 * 'core' class of the medication model and is important for 
 * understanding what drugs the patient is intended to be 
 * receiving.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Where the 
 * prescription is for a combination of drugs (e.g. 10mg 
 * tablets + 40mg tablets) repeatNumber cannot be populated and 
 * quantity must be expressed in mg.</p></p>
 * 
 * <p>PORX_MT060100CA.SubstanceAdministrationRequest: 
 * Prescription</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
 * the order being dispensed</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides a 
 * drill-down link from the prescription to its corresponding 
 * order.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT030040CA.CombinedMedicationRequest","PORX_MT060100CA.SubstanceAdministrationRequest"})
@Hl7RootType
public class SubstanceAdministrationRequestBean extends MessagePartBean implements Prescription {

    private static final long serialVersionUID = 20110621L;
    private II id = new IIImpl();
    private CS prescriptionStatus = new CSImpl();
    private CV prescriptionMaskingIndicator = new CVImpl();
    private OverriddenByBean author;
    private ST renderedDosageInstruction = new STImpl();
    private DispenseInstructions_2Bean component2SupplyRequest;
    private ClassifiesBean componentOf;
    private BL derivedFromSourceDispense = new BLImpl(false);
    private DrugProductBean directTargetMedication;
    private RemainingDispenseInformation_1Bean fulfillment1SupplyEventFutureSummary;
    private FirstDispenseInformation_1Bean fulfillment2SupplyEventFirstSummary;
    private LastDispenseInformation_1Bean fulfillment3SupplyEventLastSummary;
    private PreviousDispenseInformation_1Bean fulfillment4SupplyEventPastSummary;
    private BL preconditionVerificationEventCriterion = new BLImpl(false);
    private List<PrescribedBecauseOfBean> reason = new ArrayList<PrescribedBecauseOfBean>();
    private ProviderBean responsiblePartyAssignedPerson;
    private Patient_1Bean subjectPatient;
    private BL subjectOf1AnnotationIndicator = new BLImpl(false);
    private BL subjectOf2DetectedIssueIndicator = new BLImpl(false);
    private List<RefusalToFillsBean> subjectOf3RefusalToFill = new ArrayList<RefusalToFillsBean>();


    /**
     * <p>A:Prescription Identifier</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The 
     * Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">It is created by 
     * the EHR/DIS once the prescription has passed all edits and 
     * validation.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The 
     * Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">It is created by 
     * the EHR/DIS once the prescription has passed all edits and 
     * validation.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionExternalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0101(id for 
     * prescription)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.456-EN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.454-EK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionExternalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0101(id for 
     * prescription)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.456-EN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.454-EK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionExternalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0101(id for 
     * prescription)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.456-EN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.454-EK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionExternalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0101(id for 
     * prescription)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.456-EN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.454-EK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionExternalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0101(id for 
     * prescription)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.456-EN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.454-EK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionExternalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0101(id for 
     * prescription)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.456-EN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.454-EK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionExternalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0101(id for 
     * prescription)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>PrescriptionStatus</p>
     * 
     * <p>C:Prescription Status</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This denotes 
     * the state of the prescription in the lifecycle of the 
     * prescription. Valid statuses are: NEW, ACTIVE, SUSPENDED, 
     * ABORTED, COMPLETED, OBSOLETE and NULLIFIED.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.state 
     * (cannot distinguish between 'Filled' and 'Unfilled', must 
     * look at amounts dispensed to distniguish between those; and 
     * also cannot distinguish modified, need to look at event 
     * history).</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription 
     * Status</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.state 
     * (cannot distinguish between 'Filled' and 'Unfilled', must 
     * look at amounts dispensed to distniguish between those; and 
     * also cannot distinguish modified, need to look at event 
     * history).</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription 
     * Status</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * what actions are allowed to be performed against a 
     * prescription.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">This is a 
     * mandatory field because every prescription needs to be in 
     * some state.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * what actions are allowed to be performed against a 
     * prescription.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">This is a 
     * mandatory field because every prescription needs to be in 
     * some state.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getPrescriptionStatus() {
        return (ActStatus) this.prescriptionStatus.getValue();
    }
    public void setPrescriptionStatus(ActStatus prescriptionStatus) {
        this.prescriptionStatus.setValue(prescriptionStatus);
    }


    /**
     * <p>PrescriptionMaskingIndicator</p>
     * 
     * <p>F:Prescription Masking Indicator</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Communicates 
     * the intent of the patient to restrict access to their 
     * prescriptions.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Provides support 
     * for additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Valid values are: 
     * 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' (denotes 
     * 'Masked').</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The default is 
     * 'NORMAL' signifying 'Not Masked'.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Communicates 
     * the intent of the patient to restrict access to their 
     * prescriptions.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Provides support 
     * for additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Valid values are: 
     * 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' (denotes 
     * 'Masked').</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The default is 
     * 'NORMAL' signifying 'Not Masked'.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Communicates 
     * the intent of the patient to restrict access to their 
     * prescriptions.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Provides support 
     * for additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Valid values are: 
     * 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' (denotes 
     * 'Masked').</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The default is 
     * 'NORMAL' signifying 'Not Masked'.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Communicates 
     * the intent of the patient to restrict access to their 
     * prescriptions.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Provides support 
     * for additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Valid values are: 
     * 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' (denotes 
     * 'Masked').</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The default is 
     * 'NORMAL' signifying 'Not Masked'.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.masked</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows the 
     * patient to have discrete control over access to their 
     * medication data.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows the 
     * patient to have discrete control over access to their 
     * medication data.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * optional because not all systems will support masking.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getPrescriptionMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.prescriptionMaskingIndicator.getValue();
    }
    public void setPrescriptionMaskingIndicator(x_VeryBasicConfidentialityKind prescriptionMaskingIndicator) {
        this.prescriptionMaskingIndicator.setValue(prescriptionMaskingIndicator);
    }


    @Hl7XmlMapping({"author"})
    public OverriddenByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(OverriddenByBean author) {
        this.author = author;
    }


    /**
     * <p>RenderedDosageInstruction</p>
     * 
     * <p>Rendered Dosage Instruction</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A free form 
     * textual specification generated from the input 
     * specifications as created by the provider.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">This is made up of 
     * either an 'Ad-hoc dosage instruction' or 'Textual rendition 
     * of the structured dosage lines', plus route, dosage unit, 
     * and other pertinent administration information specified by 
     * the provider.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A free form 
     * textual specification generated from the input 
     * specifications as created by the provider.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">This is made up of 
     * either an 'Ad-hoc dosage instruction' or 'Textual rendition 
     * of the structured dosage lines', plus route, dosage unit, 
     * and other pertinent administration information specified by 
     * the provider.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows the 
     * provider to verify the codified structured dosage 
     * information entered and ensure that the exploded instruction 
     * is consistent with the intended instructions.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Also useful in 
     * bringing back administration instructions on query 
     * responses. Because all prescriptions and dispenses have 
     * dosage, this attribute is mandatory.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows the 
     * provider to verify the codified structured dosage 
     * information entered and ensure that the exploded instruction 
     * is consistent with the intended instructions.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Also useful in 
     * bringing back administration instructions on query 
     * responses. Because all prescriptions and dispenses have 
     * dosage, this attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"component1/administrationInstructions/text"})
    public String getRenderedDosageInstruction() {
        return this.renderedDosageInstruction.getValue();
    }
    public void setRenderedDosageInstruction(String renderedDosageInstruction) {
        this.renderedDosageInstruction.setValue(renderedDosageInstruction);
    }


    @Hl7XmlMapping({"component2/supplyRequest"})
    public DispenseInstructions_2Bean getComponent2SupplyRequest() {
        return this.component2SupplyRequest;
    }
    public void setComponent2SupplyRequest(DispenseInstructions_2Bean component2SupplyRequest) {
        this.component2SupplyRequest = component2SupplyRequest;
    }


    @Hl7XmlMapping({"componentOf"})
    public ClassifiesBean getComponentOf() {
        return this.componentOf;
    }
    public void setComponentOf(ClassifiesBean componentOf) {
        this.componentOf = componentOf;
    }


    @Hl7XmlMapping({"derivedFrom/sourceDispense"})
    public Boolean getDerivedFromSourceDispense() {
        return this.derivedFromSourceDispense.getValue();
    }
    public void setDerivedFromSourceDispense(Boolean derivedFromSourceDispense) {
        this.derivedFromSourceDispense.setValue(derivedFromSourceDispense);
    }


    @Hl7XmlMapping({"directTarget/medication"})
    public DrugProductBean getDirectTargetMedication() {
        return this.directTargetMedication;
    }
    public void setDirectTargetMedication(DrugProductBean directTargetMedication) {
        this.directTargetMedication = directTargetMedication;
    }


    @Hl7XmlMapping({"fulfillment1/supplyEventFutureSummary"})
    public RemainingDispenseInformation_1Bean getFulfillment1SupplyEventFutureSummary() {
        return this.fulfillment1SupplyEventFutureSummary;
    }
    public void setFulfillment1SupplyEventFutureSummary(RemainingDispenseInformation_1Bean fulfillment1SupplyEventFutureSummary) {
        this.fulfillment1SupplyEventFutureSummary = fulfillment1SupplyEventFutureSummary;
    }


    @Hl7XmlMapping({"fulfillment2/supplyEventFirstSummary"})
    public FirstDispenseInformation_1Bean getFulfillment2SupplyEventFirstSummary() {
        return this.fulfillment2SupplyEventFirstSummary;
    }
    public void setFulfillment2SupplyEventFirstSummary(FirstDispenseInformation_1Bean fulfillment2SupplyEventFirstSummary) {
        this.fulfillment2SupplyEventFirstSummary = fulfillment2SupplyEventFirstSummary;
    }


    @Hl7XmlMapping({"fulfillment3/supplyEventLastSummary"})
    public LastDispenseInformation_1Bean getFulfillment3SupplyEventLastSummary() {
        return this.fulfillment3SupplyEventLastSummary;
    }
    public void setFulfillment3SupplyEventLastSummary(LastDispenseInformation_1Bean fulfillment3SupplyEventLastSummary) {
        this.fulfillment3SupplyEventLastSummary = fulfillment3SupplyEventLastSummary;
    }


    @Hl7XmlMapping({"fulfillment4/supplyEventPastSummary"})
    public PreviousDispenseInformation_1Bean getFulfillment4SupplyEventPastSummary() {
        return this.fulfillment4SupplyEventPastSummary;
    }
    public void setFulfillment4SupplyEventPastSummary(PreviousDispenseInformation_1Bean fulfillment4SupplyEventPastSummary) {
        this.fulfillment4SupplyEventPastSummary = fulfillment4SupplyEventPastSummary;
    }


    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }
    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
    }


    @Hl7XmlMapping({"reason"})
    public List<PrescribedBecauseOfBean> getReason() {
        return this.reason;
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    @Hl7XmlMapping({"subject/patient"})
    public Patient_1Bean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(Patient_1Bean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"subjectOf1/annotationIndicator"})
    public Boolean getSubjectOf1AnnotationIndicator() {
        return this.subjectOf1AnnotationIndicator.getValue();
    }
    public void setSubjectOf1AnnotationIndicator(Boolean subjectOf1AnnotationIndicator) {
        this.subjectOf1AnnotationIndicator.setValue(subjectOf1AnnotationIndicator);
    }


    @Hl7XmlMapping({"subjectOf2/detectedIssueIndicator"})
    public Boolean getSubjectOf2DetectedIssueIndicator() {
        return this.subjectOf2DetectedIssueIndicator.getValue();
    }
    public void setSubjectOf2DetectedIssueIndicator(Boolean subjectOf2DetectedIssueIndicator) {
        this.subjectOf2DetectedIssueIndicator.setValue(subjectOf2DetectedIssueIndicator);
    }


    @Hl7XmlMapping({"subjectOf3/refusalToFill"})
    public List<RefusalToFillsBean> getSubjectOf3RefusalToFill() {
        return this.subjectOf3RefusalToFill;
    }

}
