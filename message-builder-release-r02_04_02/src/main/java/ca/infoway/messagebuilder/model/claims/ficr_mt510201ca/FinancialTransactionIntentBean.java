/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt510201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.claims.merged.AdjudicatorBillingTaxAccountBean;
import ca.infoway.messagebuilder.model.common.coct_mt110101ca.AccountBean;
import ca.infoway.messagebuilder.model.common.coct_mt110200ca.PayeeAccountBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p><p>Amt must be positive or 0 for</p><p>completed 
 * Adjudication Results</p><p>messages</p><p>Amt must be 
 * negative or 0 for Invoice Cancel Results messages</p></p>
 * 
 * <p><p>Amt must be positive or 0 for</p><p>completed 
 * Adjudication Results</p><p>messages</p><p>Amt must be 
 * negative or 0 for Invoice Cancel Results messages</p></p>
 * 
 * <p><p>Amt must be positive or 0 for</p><p>completed 
 * Adjudication Results</p><p>messages</p><p>Amt must be 
 * negative or 0 for Invoice Cancel Results messages</p></p>
 * 
 * <p><p>Amt must be positive or 0 for</p><p>completed 
 * Adjudication Results</p><p>messages</p><p>Amt must be 
 * negative or 0 for Invoice Cancel Results messages</p></p>
 * 
 * <p><p>If an Adjudicator adjudicates for multiple insurance 
 * policies (EOBs) for multiple Payors and/or Payees, there 
 * would be more than 1 Payment Intent payload in the Results 
 * message</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT510201CA.FinancialTransactionIntent"})
@Hl7RootType
public class FinancialTransactionIntentBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private List<AdjudicatorBillingTaxAccountBean> pertinentInformationAdjudicatorBillingTaxAccount = new ArrayList<AdjudicatorBillingTaxAccountBean>();
    private CS paymentIntentStatus = new CSImpl();
    private II paymentIntentIdentifier = new IIImpl();
    private List<Reason2Bean> reasonOf = new ArrayList<Reason2Bean>();
    private TS paymentIntentDateTime = new TSImpl();
    private MO totalAmountOfPaymentIntent = new MOImpl();
    private AccountBean debitAccount;
    private PayeeAccountBean creditAccount;


    @Hl7XmlMapping({"pertinentInformation/adjudicatorBillingTaxAccount"})
    public List<AdjudicatorBillingTaxAccountBean> getPertinentInformationAdjudicatorBillingTaxAccount() {
        return this.pertinentInformationAdjudicatorBillingTaxAccount;
    }


    /**
     * <p>Payment Intent Status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getPaymentIntentStatus() {
        return (ActStatus) this.paymentIntentStatus.getValue();
    }
    public void setPaymentIntentStatus(ActStatus paymentIntentStatus) {
        this.paymentIntentStatus.setValue(paymentIntentStatus);
    }


    /**
     * <p>Payment Intent Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPaymentIntentIdentifier() {
        return this.paymentIntentIdentifier.getValue();
    }
    public void setPaymentIntentIdentifier(Identifier paymentIntentIdentifier) {
        this.paymentIntentIdentifier.setValue(paymentIntentIdentifier);
    }


    @Hl7XmlMapping({"reasonOf"})
    public List<Reason2Bean> getReasonOf() {
        return this.reasonOf;
    }


    /**
     * <p>Payment Intent Date/Time</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getPaymentIntentDateTime() {
        return this.paymentIntentDateTime.getValue();
    }
    public void setPaymentIntentDateTime(Date paymentIntentDateTime) {
        this.paymentIntentDateTime.setValue(paymentIntentDateTime);
    }


    /**
     * <p>Total Amount of Payment Intent</p>
     */
    @Hl7XmlMapping({"amt"})
    public Money getTotalAmountOfPaymentIntent() {
        return this.totalAmountOfPaymentIntent.getValue();
    }
    public void setTotalAmountOfPaymentIntent(Money totalAmountOfPaymentIntent) {
        this.totalAmountOfPaymentIntent.setValue(totalAmountOfPaymentIntent);
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
