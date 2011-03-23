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
import java.util.Collections;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT680000CA.InvoiceElementIntent"})
public class InventElementChoiceBean extends MessagePartBean implements InvoiceElementChoiceBean {

    private CV<Code> invoiceElementIntentCode = new CVImpl<Code>();
    private MO totalAmountBilledForInvoiceElement = new MOImpl();
    private List<InvoiceElementChoiceBean> componentInvoiceElementChoice = new ArrayList<InvoiceElementChoiceBean>();

    @Hl7XmlMapping({"code"})
    public Code getInvoiceElementIntentCode() {
        return this.invoiceElementIntentCode.getValue();
    }
    public void setInvoiceElementIntentCode(Code invoiceElementIntentCode) {
        this.invoiceElementIntentCode.setValue(invoiceElementIntentCode);
    }

    @Hl7XmlMapping({"netAmt"})
    public Money getTotalAmountBilledForInvoiceElement() {
        return this.totalAmountBilledForInvoiceElement.getValue();
    }
    public void setTotalAmountBilledForInvoiceElement(Money totalAmountBilledForInvoiceElement) {
        this.totalAmountBilledForInvoiceElement.setValue(totalAmountBilledForInvoiceElement);
    }

    @Hl7XmlMapping({"component/invoiceElementChoice"})
    public List<InvoiceElementChoiceBean> getComponentInvoiceElementChoice() {
        return this.componentInvoiceElementChoice;
    }

}
