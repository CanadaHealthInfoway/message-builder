/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.v01_r04_3.merged.PrescribedByBean;



@Hl7PartTypeMapping({"PORX_MT020050CA.SupplyRequest","PORX_MT060020CA.SupplyRequest"})
public class SupplyOrderBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private ProviderBean responsiblePartyAssignedPerson;
    private II prescriptionIdentifier = new IIImpl();
    private PrescribedByBean author;


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    /**
     * <p>PrescriptionIdentifier</p>
     * 
     * <p>A:Prescription Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPrescriptionIdentifier() {
        return this.prescriptionIdentifier.getValue();
    }
    public void setPrescriptionIdentifier(Identifier prescriptionIdentifier) {
        this.prescriptionIdentifier.setValue(prescriptionIdentifier);
    }


    @Hl7XmlMapping({"author"})
    public PrescribedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(PrescribedByBean author) {
        this.author = author;
    }

}