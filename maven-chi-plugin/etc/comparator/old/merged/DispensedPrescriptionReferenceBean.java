/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT020050CA.InFulfillmentOf","PORX_MT060020CA.InFulfillmentOf"})
public class DispensedPrescriptionReferenceBean extends MessagePartBean {

    private II prescriptionIdentifier = new IIImpl();
    private HealthcareWorkerBean supplyRequestResponsiblePartyAssignedEntity;
    private PrescribedByBean supplyRequestAuthor = new PrescribedByBean();

    @Hl7XmlMapping({"supplyRequest/id"})
    public Identifier getPrescriptionIdentifier() {
        return this.prescriptionIdentifier.getValue();
    }
    public void setPrescriptionIdentifier(Identifier prescriptionIdentifier) {
        this.prescriptionIdentifier.setValue(prescriptionIdentifier);
    }

    @Hl7XmlMapping({"supplyRequest/responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getSupplyRequestResponsiblePartyAssignedEntity() {
        return this.supplyRequestResponsiblePartyAssignedEntity;
    }
    public void setSupplyRequestResponsiblePartyAssignedEntity(HealthcareWorkerBean supplyRequestResponsiblePartyAssignedEntity) {
        this.supplyRequestResponsiblePartyAssignedEntity = supplyRequestResponsiblePartyAssignedEntity;
    }

    @Hl7XmlMapping({"supplyRequest/author"})
    public PrescribedByBean getSupplyRequestAuthor() {
        return this.supplyRequestAuthor;
    }
    public void setSupplyRequestAuthor(PrescribedByBean supplyRequestAuthor) {
        this.supplyRequestAuthor = supplyRequestAuthor;
    }

}
