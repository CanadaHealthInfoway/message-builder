/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.claims.ficr_mt610201ca.AdjudicatedInvoiceElementGroupBean;
import ca.infoway.messagebuilder.model.claims.ficr_mt610201ca.AdjudicatorBillingTaxAccountBean;
import ca.infoway.messagebuilder.model.common.coct_mt110101ca.AccountBean;
import ca.infoway.messagebuilder.model.common.coct_mt110200ca.PayeeAccountBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT610201CA.PaymentIntent","FICR_MT630000CA.PaymentIntent"})
@Hl7RootType
public class PaymentIntentBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private TS paymentIntentDateTime = new TSImpl();
    private MO totalIntentPaymentAmount = new MOImpl();
    private List<AdjudicatorBillingTaxAccountBean> pertinentInformationAdjudicatorBillingTaxAccount = new ArrayList<AdjudicatorBillingTaxAccountBean>();
    private List<AdjudicatedInvoiceElementGroupBean> reasonOfAdjudicatedInvoiceElementGroup = new ArrayList<AdjudicatedInvoiceElementGroupBean>();
    private AccountBean debitAccount;
    private PayeeAccountBean creditAccount;

    @Hl7XmlMapping({"effectiveTime"})
    public Date getPaymentIntentDateTime() {
        return this.paymentIntentDateTime.getValue();
    }
    public void setPaymentIntentDateTime(Date paymentIntentDateTime) {
        this.paymentIntentDateTime.setValue(paymentIntentDateTime);
    }

    @Hl7XmlMapping({"amt"})
    public Money getTotalIntentPaymentAmount() {
        return this.totalIntentPaymentAmount.getValue();
    }
    public void setTotalIntentPaymentAmount(Money totalIntentPaymentAmount) {
        this.totalIntentPaymentAmount.setValue(totalIntentPaymentAmount);
    }

    @Hl7XmlMapping({"pertinentInformation/adjudicatorBillingTaxAccount"})
    public List<AdjudicatorBillingTaxAccountBean> getPertinentInformationAdjudicatorBillingTaxAccount() {
        return this.pertinentInformationAdjudicatorBillingTaxAccount;
    }

    @Hl7XmlMapping({"reasonOf/adjudicatedInvoiceElementGroup"})
    public List<AdjudicatedInvoiceElementGroupBean> getReasonOfAdjudicatedInvoiceElementGroup() {
        return this.reasonOfAdjudicatedInvoiceElementGroup;
    }

    @Hl7XmlMapping({"debit/account"})
    public AccountBean getDebitAccount() {
        return this.debitAccount;
    }
    public void setDebitAccount(AccountBean debitAccount) {
        this.debitAccount = debitAccount;
    }

    @Hl7XmlMapping({"credit/account"})
    public PayeeAccountBean getCreditAccount() {
        return this.creditAccount;
    }
    public void setCreditAccount(PayeeAccountBean creditAccount) {
        this.creditAccount = creditAccount;
    }

}
