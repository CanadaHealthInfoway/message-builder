/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>ParentPrescription</p>
 * 
 * <p>PORX_MT060040CA.PriorSupplyRequest: Parent Prescription</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is the 
 * original prescription that is being renewed. The current 
 * prescription uses the original prescription as the basis for 
 * its information.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Helps link 
 * prescriptions together, and subsequently indications for 
 * prescribing.</p></p>
 * 
 * <p>PORX_MT060340CA.PriorCombinedMedicationRequest: Parent 
 * Prescription</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is the 
 * original prescription that is being renewed. The current 
 * prescription uses the original prescription as the basis for 
 * its information.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Helps link 
 * prescriptions together, and subsequently indications for 
 * prescribing.</p></p>
 * 
 * <p>PORX_MT060160CA.PriorCombinedMedicationRequest: Parent 
 * Prescription</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is the 
 * original prescription that is being renewed. The current 
 * prescription uses the original prescription as the basis for 
 * its information.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Helps link 
 * prescriptions together, and subsequently indications for 
 * prescribing.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.PriorCombinedMedicationRequest","PORX_MT060040CA.PriorSupplyRequest","PORX_MT060160CA.PriorCombinedMedicationRequest","PORX_MT060340CA.PriorCombinedMedicationRequest"})
public class ParentPrescriptionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private II previousPrescriptionOrderNumber = new IIImpl();


    /**
     * <p>PreviousPrescriptionOrderNumber</p>
     * 
     * <p>B:Previous Prescription Order Number</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A reference 
     * to a previous prescription which the current prescription 
     * replaces.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">New or 
     * Repeat (if present, then Repeat)</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows a 
     * prescription renewal (this prescription) to note the 
     * previous prescription id that was renewed;</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Allows tracking a 
     * therapy across multiple renewal prescriptions.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows a 
     * prescription renewal (this prescription) to note the 
     * previous prescription id that was renewed;</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Allows tracking a 
     * therapy across multiple renewal prescriptions.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPreviousPrescriptionOrderNumber() {
        return this.previousPrescriptionOrderNumber.getValue();
    }
    public void setPreviousPrescriptionOrderNumber(Identifier previousPrescriptionOrderNumber) {
        this.previousPrescriptionOrderNumber.setValue(previousPrescriptionOrderNumber);
    }

}
