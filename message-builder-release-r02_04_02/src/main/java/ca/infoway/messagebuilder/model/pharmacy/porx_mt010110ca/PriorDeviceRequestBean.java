/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt010110ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT010110CA.PriorDeviceRequest"})
public class PriorDeviceRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private II previousPrescriptionOrderNumber = new IIImpl();


    /**
     * <p>B:Previous Prescription Order Number</p>
     * 
     * <p><p>A reference to a previous prescription which the 
     * current prescription replaces.</p></p>
     * 
     * <p><p>Allows a prescription renewal (this prescription) to 
     * note the previous prescription id that was 
     * renewed;</p><p>Allows tracking a therapy across multiple 
     * renewal prescriptions.</p></p>
     * 
     * <p><p>Allows a prescription renewal (this prescription) to 
     * note the previous prescription id that was 
     * renewed;</p><p>Allows tracking a therapy across multiple 
     * renewal prescriptions.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPreviousPrescriptionOrderNumber() {
        return this.previousPrescriptionOrderNumber.getValue();
    }
    public void setPreviousPrescriptionOrderNumber(Identifier previousPrescriptionOrderNumber) {
        this.previousPrescriptionOrderNumber.setValue(previousPrescriptionOrderNumber);
    }

}
