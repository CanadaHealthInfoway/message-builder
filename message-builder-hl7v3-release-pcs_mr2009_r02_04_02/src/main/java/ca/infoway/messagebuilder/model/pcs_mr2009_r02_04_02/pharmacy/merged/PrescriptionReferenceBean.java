/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged;

import java.util.Set;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.RefusedByBean;



/**
 * <p>PrescriptionReference</p>
 * 
 * <p>PORX_MT020070CA.SubstanceAdministrationRequest: 
 * Prescription Reference</p>
 * 
 * <p><p>The Prescriber Name must be specified only when the 
 * Prescription Order Number is Null.</p><p>Component MUST be 
 * specified if the id is null and CAN NOT be specified if the 
 * id is not null</p></p>
 * 
 * <p><p>The Prescriber Name must be specified only when the 
 * Prescription Order Number is Null.</p><p>Component MUST be 
 * specified if the id is null and CAN NOT be specified if the 
 * id is not null</p></p>
 * 
 * <p><p>Information pertaining to the prescription for which a 
 * dispense is being created</p></p>
 * 
 * <p><p>Dispenses for electronically created prescriptions 
 * must reference the prescription.</p></p>
 * 
 * <p>PORX_MT060010CA.SupplyRequest: Prescription Reference</p>
 * 
 * <p><p>A reference to the prescription order being 
 * dispensed</p></p>
 * 
 * <p><p>Links a dispense with its parent prescription.</p></p>
 * 
 * <p>PORX_MT060090CA.SubstanceAdministrationRequest: 
 * Prescription Reference</p>
 * 
 * <p><p>A reference to the prescription order being 
 * dispensed</p></p>
 * 
 * <p><p>Links a dispense with its parent prescription.</p></p>
 * 
 * <p>PORX_MT020060CA.DeviceRequest: Prescription Reference</p>
 * 
 * <p><p>The Prescriber Name must be specified only when the 
 * Prescription ID is Null</p></p>
 * 
 * <p><p>Information pertaining to the prescription for which a 
 * dispense is being created</p></p>
 * 
 * <p><p>Dispenses for electronically created prescriptions 
 * must reference the prescription.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT020060CA.DeviceRequest","PORX_MT020070CA.SubstanceAdministrationRequest","PORX_MT060010CA.SupplyRequest","PORX_MT060090CA.SubstanceAdministrationRequest"})
public class PrescriptionReferenceBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private SET<II, Identifier> prescriptionOrderNumber = new SETImpl<II, Identifier>(IIImpl.class);
    private CV prescriptionType = new CVImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private RefusedByBean author;
    private ClassifiesBean component1;
    private Component2Bean component;
    private CS prescriptionStatus = new CSImpl();


    /**
     * <p>PrescriptionOrderNumber</p>
     * 
     * <p>Prescription Order Number</p>
     * 
     * <p><p>This is an identifier assigned to a specific 
     * medication order. The number remains constant across the 
     * lifetime of the order, regardless of the number of providers 
     * or pharmacies involved in fulfilling the order.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely referenced and 
     * associated with the dispense.</p><p>The ID is mandatory 
     * because the DIS will always assign a Prescription Order 
     * Number.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely referenced and 
     * associated with the dispense.</p><p>The ID is mandatory 
     * because the DIS will always assign a Prescription Order 
     * Number.</p></p>
     * 
     * <p>D:Prescription Order Number</p>
     * 
     * <p><p>The identifier of the prescription for which a 
     * dispense is being created.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>The ID is only 'populated' because in some 
     * cases the prescription will not yet exist 
     * electronically.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>The ID is only 'populated' because in some 
     * cases the prescription will not yet exist 
     * electronically.</p></p>
     * 
     * <p>D:Prescription Order Number</p>
     * 
     * <p><p>The identifier of the prescription for which a 
     * dispense is beiing created.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>The ID is only 'populated' because in some 
     * cases the prescription will not yet exist 
     * electronically.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>The ID is only 'populated' because in some 
     * cases the prescription will not yet exist 
     * electronically.</p></p>
     * 
     * <p>Prescription Order Number</p>
     * 
     * <p><p>This is an identifier assigned to a specific device 
     * order. The number remains constant across the lifetime of 
     * the order, regardless of the number of providers or 
     * pharmacies involved in fulfilling the order.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely referenced and 
     * associated with the dispense.</p><p>The ID is mandatory 
     * because the DIS will always assign a Prescription Order 
     * Number.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely referenced and 
     * associated with the dispense.</p><p>The ID is mandatory 
     * because the DIS will always assign a Prescription Order 
     * Number.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getPrescriptionOrderNumber() {
        return this.prescriptionOrderNumber.rawSet();
    }


    /**
     * <p>PrescriptionType</p>
     * 
     * <p>Prescription Type</p>
     * 
     * <p><p>Differentiates the type of medication e.g. drug, 
     * vaccine</p></p>
     * 
     * <p><p>Important in understanding the context of the 
     * prescription being fulfilled. Therefoe is Mandatory.</p></p>
     * 
     * <p>Prescription type</p>
     * 
     * <p><p>Indicates that this is a drug rather than a 
     * vaccine.</p></p>
     * 
     * <p><p>Relevant to a full understanding of the prescription. 
     * For this reason is Mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getPrescriptionType() {
        return (Code) this.prescriptionType.getValue();
    }
    public void setPrescriptionType(Code prescriptionType) {
        this.prescriptionType.setValue(prescriptionType);
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


    @Hl7XmlMapping({"component1"})
    public ClassifiesBean getComponent1() {
        return this.component1;
    }
    public void setComponent1(ClassifiesBean component1) {
        this.component1 = component1;
    }


    @Hl7XmlMapping({"component","component2"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="component", type="PORX_MT020060CA.Component2"),
        @Hl7MapByPartType(name="component2", type="PORX_MT020070CA.Component2")})
    public Component2Bean getComponent() {
        return this.component;
    }
    public void setComponent(Component2Bean component) {
        this.component = component;
    }


    /**
     * <p>PrescriptionStatus</p>
     * 
     * <p>Prescription Status</p>
     * 
     * <p><p>Provides the status of the prescription without 
     * requiring additional queries</p></p>
     * 
     * <p><p>Needed in some jurisdictions</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getPrescriptionStatus() {
        return (ActStatus) this.prescriptionStatus.getValue();
    }
    public void setPrescriptionStatus(ActStatus prescriptionStatus) {
        this.prescriptionStatus.setValue(prescriptionStatus);
    }

}
