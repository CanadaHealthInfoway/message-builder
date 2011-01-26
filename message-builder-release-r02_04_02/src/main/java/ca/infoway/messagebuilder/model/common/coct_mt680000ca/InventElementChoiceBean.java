/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt680000ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT680000CA.InvoiceElementIntent"})
public class InventElementChoiceBean extends MessagePartBean implements ca.infoway.messagebuilder.model.merged.InvoiceElementChoice {

    private static final long serialVersionUID = 20110126L;
    private List<InvoiceElementComponentBean> component = new ArrayList<InvoiceElementComponentBean>();
    private MO totalAmountBilledForInvoiceElement = new MOImpl();
    private CV invoiceElementIntentCode = new CVImpl();


    @Hl7XmlMapping({"component"})
    public List<InvoiceElementComponentBean> getComponent() {
        return this.component;
    }


    /**
     * <p>Total amount billed for invoice element</p>
     * 
     * <p><p>Identifies the total monetary amount billed for the 
     * invoice element.</p></p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getTotalAmountBilledForInvoiceElement() {
        return this.totalAmountBilledForInvoiceElement.getValue();
    }
    public void setTotalAmountBilledForInvoiceElement(Money totalAmountBilledForInvoiceElement) {
        this.totalAmountBilledForInvoiceElement.setValue(totalAmountBilledForInvoiceElement);
    }


    /**
     * <p>Invoice Element Intent Code</p>
     * 
     * <p><p>(Invoice Type e.g. Healthcare Services, Rx Dispense, 
     * Rx Compound, Healthcare Goods, Preferred Accomodation</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getInvoiceElementIntentCode() {
        return (Code) this.invoiceElementIntentCode.getValue();
    }
    public void setInvoiceElementIntentCode(Code invoiceElementIntentCode) {
        this.invoiceElementIntentCode.setValue(invoiceElementIntentCode);
    }

}
