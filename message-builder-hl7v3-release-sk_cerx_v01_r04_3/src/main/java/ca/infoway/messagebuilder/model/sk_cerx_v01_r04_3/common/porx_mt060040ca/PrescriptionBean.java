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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.porx_mt060040ca;

import java.util.ArrayList;
import java.util.List;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt141007ca.DeviceProductBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.Author4Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.CommentBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.CoverageExtensions_1Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.DeviceDispense_1Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.FirstDispenseInformation_2Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.IssuesBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.LastDispenseInformation_2Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.ParentPrescriptionBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.PrescribedBecauseOfBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.PreviousDispenseInformation_2Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.ProcedureRequestBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.RefusalToFillsBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.RemainingDispenseInformation_2Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.StatusChangesBean;



/**
 * <p>Prescription</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Information 
 * pertaining to a Prescriber's authorization for a device to 
 * be dispensed to a patient, as well as the instruction on 
 * when and how the device is to be used by the patient.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is a 
 * 'core' class of the medication model and is important for 
 * understanding what devices the patient is intended to be 
 * receiving.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060040CA.DeviceRequest"})
@Hl7RootType
public class PrescriptionBean extends MessagePartBean implements ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.Prescription {

    private static final long serialVersionUID = 20110714L;
    private II prescriptionOrderNumber = new IIImpl();
    private CS prescriptionStatus = new CSImpl();
    private CV prescriptionMaskingIndicator = new CVImpl();
    private Author4Bean author;
    private ProcedureRequestBean component1ProcedureRequest;
    private DispenseInstructionsBean component2SupplyRequest;
    private List<CoverageExtensions_1Bean> coverageCoverage = new ArrayList<CoverageExtensions_1Bean>();
    private BL derivedFromSourceDispense = new BLImpl(false);
    private DeviceProductBean directTargetManufacturedProduct;
    private LastDispenseInformation_2Bean fulfillment1SupplyEventLastSummary;
    private FirstDispenseInformation_2Bean fulfillment2SupplyEventFirstSummary;
    private RemainingDispenseInformation_2Bean fulfillment3SupplyEventFutureSummary;
    private PreviousDispenseInformation_2Bean fulfillment4SupplyEventPastSummary;
    private List<DeviceDispense_1Bean> fulfillment5DeviceDispense = new ArrayList<DeviceDispense_1Bean>();
    private RecordedAtBean location;
    private BL preconditionVerificationEventCriterion = new BLImpl(false);
    private ParentPrescriptionBean predecessorPriorSupplyRequest;
    private List<PrescribedBecauseOfBean> reason = new ArrayList<PrescribedBecauseOfBean>();
    private ProviderBean responsiblePartyAssignedPerson;
    private Patient_1Bean subjectPatient;
    private List<IssuesBean> subjectOf1DetectedIssueEvent = new ArrayList<IssuesBean>();
    private List<StatusChangesBean> subjectOf2ControlActEvent = new ArrayList<StatusChangesBean>();
    private List<CommentBean> subjectOf3Annotation = new ArrayList<CommentBean>();
    private List<RefusalToFillsBean> subjectOf4RefusalToFill = new ArrayList<RefusalToFillsBean>();
    private BL subjectOf5DetectedIssueIndicator = new BLImpl(false);
    private BL subjectOf6AnnotationIndicator = new BLImpl(false);


    /**
     * <p>A:Prescription Order Number</p>
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
     * xmlns:ht
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPrescriptionOrderNumber() {
        return this.prescriptionOrderNumber.getValue();
    }
    public void setPrescriptionOrderNumber(Identifier prescriptionOrderNumber) {
        this.prescriptionOrderNumber.setValue(prescriptionOrderNumber);
    }


    /**
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
     * prescription data.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows the 
     * patient to have discrete control over access to their 
     * prescription data.</p><p 
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
    public Author4Bean getAuthor() {
        return this.author;
    }
    public void setAuthor(Author4Bean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"component1/procedureRequest"})
    public ProcedureRequestBean getComponent1ProcedureRequest() {
        return this.component1ProcedureRequest;
    }
    public void setComponent1ProcedureRequest(ProcedureRequestBean component1ProcedureRequest) {
        this.component1ProcedureRequest = component1ProcedureRequest;
    }


    @Hl7XmlMapping({"component2/supplyRequest"})
    public DispenseInstructionsBean getComponent2SupplyRequest() {
        return this.component2SupplyRequest;
    }
    public void setComponent2SupplyRequest(DispenseInstructionsBean component2SupplyRequest) {
        this.component2SupplyRequest = component2SupplyRequest;
    }


    @Hl7XmlMapping({"coverage/coverage"})
    public List<CoverageExtensions_1Bean> getCoverageCoverage() {
        return this.coverageCoverage;
    }


    @Hl7XmlMapping({"derivedFrom/sourceDispense"})
    public Boolean getDerivedFromSourceDispense() {
        return this.derivedFromSourceDispense.getValue();
    }
    public void setDerivedFromSourceDispense(Boolean derivedFromSourceDispense) {
        this.derivedFromSourceDispense.setValue(derivedFromSourceDispense);
    }


    @Hl7XmlMapping({"directTarget/manufacturedProduct"})
    public DeviceProductBean getDirectTargetManufacturedProduct() {
        return this.directTargetManufacturedProduct;
    }
    public void setDirectTargetManufacturedProduct(DeviceProductBean directTargetManufacturedProduct) {
        this.directTargetManufacturedProduct = directTargetManufacturedProduct;
    }


    @Hl7XmlMapping({"fulfillment1/supplyEventLastSummary"})
    public LastDispenseInformation_2Bean getFulfillment1SupplyEventLastSummary() {
        return this.fulfillment1SupplyEventLastSummary;
    }
    public void setFulfillment1SupplyEventLastSummary(LastDispenseInformation_2Bean fulfillment1SupplyEventLastSummary) {
        this.fulfillment1SupplyEventLastSummary = fulfillment1SupplyEventLastSummary;
    }


    @Hl7XmlMapping({"fulfillment2/supplyEventFirstSummary"})
    public FirstDispenseInformation_2Bean getFulfillment2SupplyEventFirstSummary() {
        return this.fulfillment2SupplyEventFirstSummary;
    }
    public void setFulfillment2SupplyEventFirstSummary(FirstDispenseInformation_2Bean fulfillment2SupplyEventFirstSummary) {
        this.fulfillment2SupplyEventFirstSummary = fulfillment2SupplyEventFirstSummary;
    }


    @Hl7XmlMapping({"fulfillment3/supplyEventFutureSummary"})
    public RemainingDispenseInformation_2Bean getFulfillment3SupplyEventFutureSummary() {
        return this.fulfillment3SupplyEventFutureSummary;
    }
    public void setFulfillment3SupplyEventFutureSummary(RemainingDispenseInformation_2Bean fulfillment3SupplyEventFutureSummary) {
        this.fulfillment3SupplyEventFutureSummary = fulfillment3SupplyEventFutureSummary;
    }


    @Hl7XmlMapping({"fulfillment4/supplyEventPastSummary"})
    public PreviousDispenseInformation_2Bean getFulfillment4SupplyEventPastSummary() {
        return this.fulfillment4SupplyEventPastSummary;
    }
    public void setFulfillment4SupplyEventPastSummary(PreviousDispenseInformation_2Bean fulfillment4SupplyEventPastSummary) {
        this.fulfillment4SupplyEventPastSummary = fulfillment4SupplyEventPastSummary;
    }


    @Hl7XmlMapping({"fulfillment5/deviceDispense"})
    public List<DeviceDispense_1Bean> getFulfillment5DeviceDispense() {
        return this.fulfillment5DeviceDispense;
    }


    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }
    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
    }


    @Hl7XmlMapping({"predecessor/priorSupplyRequest"})
    public ParentPrescriptionBean getPredecessorPriorSupplyRequest() {
        return this.predecessorPriorSupplyRequest;
    }
    public void setPredecessorPriorSupplyRequest(ParentPrescriptionBean predecessorPriorSupplyRequest) {
        this.predecessorPriorSupplyRequest = predecessorPriorSupplyRequest;
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


    @Hl7XmlMapping({"subjectOf1/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf1DetectedIssueEvent() {
        return this.subjectOf1DetectedIssueEvent;
    }


    @Hl7XmlMapping({"subjectOf2/controlActEvent"})
    public List<StatusChangesBean> getSubjectOf2ControlActEvent() {
        return this.subjectOf2ControlActEvent;
    }


    @Hl7XmlMapping({"subjectOf3/annotation"})
    public List<CommentBean> getSubjectOf3Annotation() {
        return this.subjectOf3Annotation;
    }


    @Hl7XmlMapping({"subjectOf4/refusalToFill"})
    public List<RefusalToFillsBean> getSubjectOf4RefusalToFill() {
        return this.subjectOf4RefusalToFill;
    }


    @Hl7XmlMapping({"subjectOf5/detectedIssueIndicator"})
    public Boolean getSubjectOf5DetectedIssueIndicator() {
        return this.subjectOf5DetectedIssueIndicator.getValue();
    }
    public void setSubjectOf5DetectedIssueIndicator(Boolean subjectOf5DetectedIssueIndicator) {
        this.subjectOf5DetectedIssueIndicator.setValue(subjectOf5DetectedIssueIndicator);
    }


    @Hl7XmlMapping({"subjectOf6/annotationIndicator"})
    public Boolean getSubjectOf6AnnotationIndicator() {
        return this.subjectOf6AnnotationIndicator.getValue();
    }
    public void setSubjectOf6AnnotationIndicator(Boolean subjectOf6AnnotationIndicator) {
        this.subjectOf6AnnotationIndicator.setValue(subjectOf6AnnotationIndicator);
    }

}
