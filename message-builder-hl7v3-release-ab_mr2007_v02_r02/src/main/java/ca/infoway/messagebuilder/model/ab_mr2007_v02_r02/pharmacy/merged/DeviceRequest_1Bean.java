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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt141007ca.DeviceProductBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.PrescribedBecauseOfBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.RefusedByBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.porx_mt010110ca.PriorDeviceRequestBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.coct_mt120600ca.NotesBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>PORX_MT010110CA.DeviceRequest: Prescription</p>
 * 
 * <p>Information pertaining to a prescriber's authorization 
 * for a device to be dispensed to a patient, as well as the 
 * instruction on when and how the device is to be used by the 
 * patient</p>
 * 
 * <p>This is a 'core' class of the medication model and is 
 * important for understanding what devices the patient is 
 * intended to be receiving.</p>
 * 
 * <p>PORX_MT020070CA.SubstanceAdministrationRequest: 
 * Prescription Reference</p>
 * 
 * <p>The Prescriber Name must be specified only when the 
 * Prescription Order Number is Null.</p><p>Component MUST be 
 * specified if the id is null and CAN NOT be specified if the 
 * id is not null</p>
 * 
 * <p>The Prescriber Name must be specified only when the 
 * Prescription Order Number is Null.</p><p>Component MUST be 
 * specified if the id is null and CAN NOT be specified if the 
 * id is not null</p>
 * 
 * <p>Information pertaining to the prescription for which a 
 * dispense is being created</p>
 * 
 * <p>Dispenses for electronically created prescriptions must 
 * reference the prescription.</p>
 * 
 * <p>PORX_MT020060CA.DeviceRequest: Prescription Reference</p>
 * 
 * <p>The Prescriber Name must be specified only when the 
 * Prescription ID is Null</p>
 * 
 * <p>Information pertaining to the prescription for which a 
 * dispense is being created</p>
 * 
 * <p>Dispenses for electronically created prescriptions must 
 * reference the prescription.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010110CA.DeviceRequest","PORX_MT020060CA.DeviceRequest","PORX_MT020070CA.SubstanceAdministrationRequest"})
@Hl7RootType
public class DeviceRequest_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();
    private CS statusCode = new CSImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private DeviceProductBean directTargetManufacturedProduct;
    private PriorDeviceRequestBean predecessorPriorDeviceRequest;
    private List<PrescribedBecauseOfBean> reason = new ArrayList<PrescribedBecauseOfBean>();
    private BL preconditionVerificationEventCriterion = new BLImpl(false);
    private List<CoverageExtensionsBean> coverageCoverage = new ArrayList<CoverageExtensionsBean>();
    private ProcedureRequestBean component1ProcedureRequest;
    private DispenseInstructions_1Bean component2SupplyRequest;
    private NotesBean subjectOfAnnotation;
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private RefusedByBean author;
    private BL componentContextConductionInd = new BLImpl();
    private DispenseInstructions_2Bean componentSupplyRequest;


    /**
     * <p>A: Prescription Number</p>
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
     * <p>Allows for the situations where the order is originating 
     * from the DIS.</p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>Because this attribute is not used for 
     * prescriptions originating from a prescriber system, the 
     * element is optional.</p>
     * 
     * <p>Allows for the situations where the order is originating 
     * from the DIS.</p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>Because this attribute is not used for 
     * prescriptions originating from a prescriber system, the 
     * element is optional.</p>
     * 
     * <p>Allows for the situations where the order is originating 
     * from the DIS.</p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>Because this attribute is not used for 
     * prescriptions originating from a prescriber system, the 
     * element is optional.</p>
     * 
     * <p>D:Prescription Order Number</p>
     * 
     * <p>The identifier of the prescription for which a dispense 
     * is being created.</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * ID is only 'populated' because in some cases the 
     * prescription will not yet exist electronically.</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * ID is only 'populated' because in some cases the 
     * prescription will not yet exist electronically.</p>
     * 
     * <p>D:Prescription Order Number</p>
     * 
     * <p>The identifier of the prescription for which a dispense 
     * is beiing created.</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * ID is only 'populated' because in some cases the 
     * prescription will not yet exist electronically.</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * ID is only 'populated' because in some cases the 
     * prescription will not yet exist electronically.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>A: Prescription Number</p>
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
     * <p>Allows for the situations where the order is originating 
     * from the DIS.</p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>Because this attribute is not used for 
     * prescriptions originating from a prescriber system, the 
     * element is optional.</p>
     * 
     * <p>Allows for the situations where the order is originating 
     * from the DIS.</p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>Because this attribute is not used for 
     * prescriptions originating from a prescriber system, the 
     * element is optional.</p>
     * 
     * <p>Allows for the situations where the order is originating 
     * from the DIS.</p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>Because this attribute is not used for 
     * prescriptions originating from a prescriber system, the 
     * element is optional.</p>
     * 
     * <p>D:Prescription Order Number</p>
     * 
     * <p>The identifier of the prescription for which a dispense 
     * is being created.</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * ID is only 'populated' because in some cases the 
     * prescription will not yet exist electronically.</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * ID is only 'populated' because in some cases the 
     * prescription will not yet exist electronically.</p>
     * 
     * <p>D:Prescription Order Number</p>
     * 
     * <p>The identifier of the prescription for which a dispense 
     * is beiing created.</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * ID is only 'populated' because in some cases the 
     * prescription will not yet exist electronically.</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * ID is only 'populated' because in some cases the 
     * prescription will not yet exist electronically.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>PrescriptionStatus</p>
     * 
     * <p>C:Prescription Status</p>
     * 
     * <p>This denotes the state of the prescription in the 
     * lifecycle of the prescription. Valid statuses are: new, 
     * active, suspended, aborted, completed, obsolete and 
     * nullified. Use 'active' when registering a new prescription 
     * or converting a predetermination into a valid 
     * prescription.</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against a prescription. This is a mandatory field because 
     * every prescription needs to be in some state.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>PrescriptionStatus</p>
     * 
     * <p>C:Prescription Status</p>
     * 
     * <p>This denotes the state of the prescription in the 
     * lifecycle of the prescription. Valid statuses are: new, 
     * active, suspended, aborted, completed, obsolete and 
     * nullified. Use 'active' when registering a new prescription 
     * or converting a predetermination into a valid 
     * prescription.</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against a prescription. This is a mandatory field because 
     * every prescription needs to be in some state.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>PrescriptionMaskingIndicators</p>
     * 
     * <p>F:Prescription Masking Indicators</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions. Provides support for additional 
     * confidentiality constraint, giving patients a level of 
     * control over their information.</p><p>Valid values are: 'N' 
     * (normal - denotes 'Not Masked'); 'R' (restricted - denotes 
     * 'Masked') and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions. Provides support for additional 
     * confidentiality constraint, giving patients a level of 
     * control over their information.</p><p>Valid values are: 'N' 
     * (normal - denotes 'Not Masked'); 'R' (restricted - denotes 
     * 'Masked') and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions. Provides support for additional 
     * confidentiality constraint, giving patients a level of 
     * control over their information.</p><p>Valid values are: 'N' 
     * (normal - denotes 'Not Masked'); 'R' (restricted - denotes 
     * 'Masked') and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their prescription data.</p><p>Taboo allows the provider 
     * to request restricted access to patient or their care 
     * giver.</p><p>Constraint: Can&#226;&#128;&#153;t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their prescription data.</p><p>Taboo allows the provider 
     * to request restricted access to patient or their care 
     * giver.</p><p>Constraint: Can&#226;&#128;&#153;t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their prescription data.</p><p>Taboo allows the provider 
     * to request restricted access to patient or their care 
     * giver.</p><p>Constraint: Can&#226;&#128;&#153;t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their prescription data.</p><p>Taboo allows the provider 
     * to request restricted access to patient or their care 
     * giver.</p><p>Constraint: Can&#226;&#128;&#153;t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    @Hl7XmlMapping({"directTarget/manufacturedProduct"})
    public DeviceProductBean getDirectTargetManufacturedProduct() {
        return this.directTargetManufacturedProduct;
    }

    public void setDirectTargetManufacturedProduct(DeviceProductBean directTargetManufacturedProduct) {
        this.directTargetManufacturedProduct = directTargetManufacturedProduct;
    }


    @Hl7XmlMapping({"predecessor/priorDeviceRequest"})
    public PriorDeviceRequestBean getPredecessorPriorDeviceRequest() {
        return this.predecessorPriorDeviceRequest;
    }

    public void setPredecessorPriorDeviceRequest(PriorDeviceRequestBean predecessorPriorDeviceRequest) {
        this.predecessorPriorDeviceRequest = predecessorPriorDeviceRequest;
    }


    @Hl7XmlMapping({"reason"})
    public List<PrescribedBecauseOfBean> getReason() {
        return this.reason;
    }


    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }

    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
    }


    @Hl7XmlMapping({"coverage/coverage"})
    public List<CoverageExtensionsBean> getCoverageCoverage() {
        return this.coverageCoverage;
    }


    @Hl7XmlMapping({"component1/procedureRequest"})
    public ProcedureRequestBean getComponent1ProcedureRequest() {
        return this.component1ProcedureRequest;
    }

    public void setComponent1ProcedureRequest(ProcedureRequestBean component1ProcedureRequest) {
        this.component1ProcedureRequest = component1ProcedureRequest;
    }


    @Hl7XmlMapping({"component2/supplyRequest"})
    public DispenseInstructions_1Bean getComponent2SupplyRequest() {
        return this.component2SupplyRequest;
    }

    public void setComponent2SupplyRequest(DispenseInstructions_1Bean component2SupplyRequest) {
        this.component2SupplyRequest = component2SupplyRequest;
    }


    @Hl7XmlMapping({"subjectOf/annotation"})
    public NotesBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }

    public void setSubjectOfAnnotation(NotesBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }


    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }

    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"component/contextConductionInd"})
    public Boolean getComponentContextConductionInd() {
        return this.componentContextConductionInd.getValue();
    }

    public void setComponentContextConductionInd(Boolean componentContextConductionInd) {
        this.componentContextConductionInd.setValue(componentContextConductionInd);
    }


    @Hl7XmlMapping({"component/supplyRequest"})
    public DispenseInstructions_2Bean getComponentSupplyRequest() {
        return this.componentSupplyRequest;
    }

    public void setComponentSupplyRequest(DispenseInstructions_2Bean componentSupplyRequest) {
        this.componentSupplyRequest = componentSupplyRequest;
    }

}
