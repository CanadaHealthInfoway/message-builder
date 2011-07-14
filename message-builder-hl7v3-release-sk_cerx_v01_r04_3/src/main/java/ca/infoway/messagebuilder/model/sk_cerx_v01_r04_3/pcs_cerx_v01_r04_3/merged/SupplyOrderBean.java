/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.coct_mt090107ca.ProviderBean;



/**
 * <p>PORX_MT060020CA.SupplyRequest: Prescription Reference</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A reference 
 * to the prescription order being dispensed</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Links a 
 * dispense with its parent prescription.</p></p>
 * 
 * <p>PORX_MT020050CA.SupplyRequest: Supply Order</p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">Identification of 
 * the supply information. This prescription will have a supply 
 * order portion but no administration part.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Ensures that 
 * dispenses to offices (non-patient identifiable dispenses) 
 * follow the normal dispensing rules.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT020050CA.SupplyRequest","PORX_MT060020CA.SupplyRequest"})
public class SupplyOrderBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private II prescriptionIdentifier = new IIImpl();
    private OverriddenByBean author;
    private ProviderBean responsiblePartyAssignedPerson;


    /**
     * <p>PrescriptionIdentifier</p>
     * 
     * <p>A:Prescription Identifier</p>
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
     * mandatory because the DIS would always assign a Prescription 
     * Number.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * prescriptions to be uniquely referenced and associated with 
     * the dispense.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The ID is 
     * mandatory because the DIS would always assign a Prescription 
     * Number.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPrescriptionIdentifier() {
        return this.prescriptionIdentifier.getValue();
    }
    public void setPrescriptionIdentifier(Identifier prescriptionIdentifier) {
        this.prescriptionIdentifier.setValue(prescriptionIdentifier);
    }


    @Hl7XmlMapping({"author"})
    public OverriddenByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(OverriddenByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }

}
