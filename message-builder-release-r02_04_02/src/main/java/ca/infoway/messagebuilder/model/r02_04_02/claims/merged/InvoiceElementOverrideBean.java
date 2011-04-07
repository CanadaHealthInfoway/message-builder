/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.claims.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT500201CA.InvoiceElementOverride","FICR_MT600201CA.InvoiceElementOverride"})
public class InvoiceElementOverrideBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CV invoiceOverrideCode = new CVImpl();
    private ST invoiceOverrideNote = new STImpl();


    /**
     * <p>InvoiceOverrideCode</p>
     * 
     * <p>Invoice override code</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getInvoiceOverrideCode() {
        return (Code) this.invoiceOverrideCode.getValue();
    }
    public void setInvoiceOverrideCode(Code invoiceOverrideCode) {
        this.invoiceOverrideCode.setValue(invoiceOverrideCode);
    }


    /**
     * <p>InvoiceOverrideNote</p>
     * 
     * <p>Invoice Override Note</p>
     */
    @Hl7XmlMapping({"text"})
    public String getInvoiceOverrideNote() {
        return this.invoiceOverrideNote.getValue();
    }
    public void setInvoiceOverrideNote(String invoiceOverrideNote) {
        this.invoiceOverrideNote.setValue(invoiceOverrideNote);
    }

}
