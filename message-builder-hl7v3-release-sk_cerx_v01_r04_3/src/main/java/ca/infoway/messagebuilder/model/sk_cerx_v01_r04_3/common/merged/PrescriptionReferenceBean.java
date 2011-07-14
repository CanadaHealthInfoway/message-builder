/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.porx_mt010110ca.PriorDeviceRequestBean;



/**
 * <p>PORX_MT010110CA.DeviceRequest: Prescription</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Information 
 * pertaining to a prescriber's authorization for a device to 
 * be dispensed to a patient, as well as the instruction on 
 * when and how the device is to be used by the patient</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is a 
 * 'core' class of the medication model and is important for 
 * understanding what devices the patient is intended to be 
 * receiving.</p></p>
 * 
 * <p>PORX_MT020070CA.SubstanceAdministrationRequest: 
 * Prescription Reference</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Information 
 * pertaining to the prescription for which a dispense is being 
 * created</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Dispenses 
 * for electronically created prescriptions must reference the 
 * prescription.</p></p>
 * 
 * <p>PORX_MT060010CA.SupplyRequest: Prescription Reference</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A reference 
 * to the prescription order being dispensed</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Links a 
 * dispense with its parent prescription.</p></p>
 * 
 * <p>PORX_MT060090CA.SubstanceAdministrationRequest: 
 * Prescription Reference</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A reference 
 * to the prescription order being dispensed</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Links a 
 * dispense with its parent prescription.</p></p>
 * 
 * <p>PORX_MT020060CA.DeviceRequest: Prescription Reference</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Information 
 * pertaining to the prescription for which a dispense is being 
 * created</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Dispenses 
 * for electronically created prescriptions must reference the 
 * prescription.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT010110CA.DeviceRequest","PORX_MT020060CA.DeviceRequest","PORX_MT020070CA.SubstanceAdministrationRequest","PORX_MT060010CA.SupplyRequest","PORX_MT060090CA.SubstanceAdministrationRequest"})
@Hl7RootType
public class PrescriptionReferenceBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private II id = new IIImpl();
    private CS prescriptionStatus = new CSImpl();
    private CV confidentialityCode = new CVImpl();
    private ProcedureRequestBean component1ProcedureRequest;
    private Component6Bean component2;
    private List<CoverageExtensions_1Bean> coverageCoverage = new ArrayList<CoverageExtensions_1Bean>();
    private DeviceProductBean directTargetManufacturedProduct;
    private BL preconditionVerificationEventCriterion = new BLImpl(false);
    private PriorDeviceRequestBean predecessorPriorDeviceRequest;
    private List<PrescribedBecauseOfBean> reason = new ArrayList<PrescribedBecauseOfBean>();
    private Patient_1Bean subjectPatient;
    private CommentBean subjectOfAnnotation;
    private RefusedByBean author;
    private BL componentContextConductionInd = new BLImpl();
    private DispenseInstructions_2Bean componentSupplyRequest;
    private ProviderBean responsiblePartyAssignedPerson;


    /**
     * <p>Prescription Order Number</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is an 
     * identifier assigned to a specific device order. The number 
     * remains constant across the lifetime of the order, 
     * regardless of the number of providers or pharmacies involved 
     * in fulfilling the order.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * prescriptions to be uniquely referenced and associated with 
     * the dispense.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The ID is 
     * mandatory because the DIS will always assign a Prescription 
     * Order Number.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * prescriptions to be uniquely referenced and associated with 
     * the dispense.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The ID is 
     * mandatory because the DIS will always assign a Prescription 
     * Order Number.</p></p>
     * 
     * <p>D:Prescription Order Number</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The 
     * identifier of the prescription for which a dispense is being 
     * created.</p></p>
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
     * xmlns:html="http://www.w3.org/19
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
     * prescription. Valid statuses are: new, active, suspended, 
     * aborted, completed, obsolete and nullified. Use 'active' 
     * when registering a new prescription or converting a 
     * predetermination into a valid prescription.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * what actions are allowed to be performed against a 
     * prescription. This is a mandatory field because every 
     * prescription needs to be in some state.</p></p>
     * 
     * <p><p>This will be "active" when submitting a new 
     * prescription. Any other code will cause a CODE_INVAL error 
     * issue to be returned.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getPrescriptionStatus() {
        return (ActStatus) this.prescriptionStatus.getValue();
    }
    public void setPrescriptionStatus(ActStatus prescriptionStatus) {
        this.prescriptionStatus.setValue(prescriptionStatus);
    }


    /**
     * <p>(no business name)</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Communicates 
     * the intent of the patient to restrict access to their 
     * prescriptions. Provides support for additional 
     * confidentiality constraint, giving patients a level of 
     * control over their information. Valid values are: 'NORMAL' 
     * (denotes 'Not Masked'); and 'RESTRICTED' (denotes 'Masked'). 
     * The default is 'NORMAL' signifying 'Not Masked'.</p></p>
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
     * 
     * <p><p><strong>As SK does not implement record-level masking, 
     * this must be "Normal" or a CODE_INVAL error issue will be 
     * returned.</strong></p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    @Hl7XmlMapping({"component1/procedureRequest"})
    public ProcedureRequestBean getComponent1ProcedureRequest() {
        return this.component1ProcedureRequest;
    }
    public void setComponent1ProcedureRequest(ProcedureRequestBean component1ProcedureRequest) {
        this.component1ProcedureRequest = component1ProcedureRequest;
    }


    @Hl7XmlMapping({"component2"})
    public Component6Bean getComponent2() {
        return this.component2;
    }
    public void setComponent2(Component6Bean component2) {
        this.component2 = component2;
    }


    @Hl7XmlMapping({"coverage/coverage"})
    public List<CoverageExtensions_1Bean> getCoverageCoverage() {
        return this.coverageCoverage;
    }


    @Hl7XmlMapping({"directTarget/manufacturedProduct"})
    public DeviceProductBean getDirectTargetManufacturedProduct() {
        return this.directTargetManufacturedProduct;
    }
    public void setDirectTargetManufacturedProduct(DeviceProductBean directTargetManufacturedProduct) {
        this.directTargetManufacturedProduct = directTargetManufacturedProduct;
    }


    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }
    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
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


    @Hl7XmlMapping({"subject/patient"})
    public Patient_1Bean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(Patient_1Bean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"subjectOf/annotation"})
    public CommentBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }
    public void setSubjectOfAnnotation(CommentBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
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


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }

}
