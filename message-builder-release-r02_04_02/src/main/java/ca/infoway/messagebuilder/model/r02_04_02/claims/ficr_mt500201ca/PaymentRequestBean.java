/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.claims.ficr_mt500201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.claims.merged.ContactPartyBean;
import ca.infoway.messagebuilder.model.r02_04_02.claims.merged.InvoiceElementDetailBean;
import ca.infoway.messagebuilder.model.r02_04_02.claims.merged.InvoiceElementGroupBean;
import ca.infoway.messagebuilder.model.r02_04_02.claims.merged.ProviderBillingTaxAccountBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt110101ca.AccountBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt110200ca.PayeeAccountBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p><p>Mood Code: PRP - auth, pre-det, cov.etc. RQO - 
 * invoice</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT500201CA.PaymentRequest"})
@Hl7RootType
public class PaymentRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private List<InvoiceElementChoice> reasonOfInvoiceElementChoice = new ArrayList<InvoiceElementChoice>();
    private MO totalBilledAmount = new MOImpl();
    private PayeeAccountBean creditAccount;
    private AccountBean debitAccount;
    private List<ProviderBillingTaxAccountBean> pertinentInformationProviderBillingTaxAccount = new ArrayList<ProviderBillingTaxAccountBean>();
    private SET<II, Identifier> invoiceIdentifier = new SETImpl<II, Identifier>(IIImpl.class);
    private ContactPartyBean primaryPerformerContactParty;


    @Hl7XmlMapping({"reasonOf/invoiceElementChoice"})
    public List<InvoiceElementChoice> getReasonOfInvoiceElementChoice() {
        return this.reasonOfInvoiceElementChoice;
    }


    /**
     * <p>Total Billed Amount</p>
     */
    @Hl7XmlMapping({"amt"})
    public Money getTotalBilledAmount() {
        return this.totalBilledAmount.getValue();
    }
    public void setTotalBilledAmount(Money totalBilledAmount) {
        this.totalBilledAmount.setValue(totalBilledAmount);
    }


    @Hl7XmlMapping({"credit/account"})
    public PayeeAccountBean getCreditAccount() {
        return this.creditAccount;
    }
    public void setCreditAccount(PayeeAccountBean creditAccount) {
        this.creditAccount = creditAccount;
    }


    @Hl7XmlMapping({"debit/account"})
    public AccountBean getDebitAccount() {
        return this.debitAccount;
    }
    public void setDebitAccount(AccountBean debitAccount) {
        this.debitAccount = debitAccount;
    }


    @Hl7XmlMapping({"pertinentInformation/providerBillingTaxAccount"})
    public List<ProviderBillingTaxAccountBean> getPertinentInformationProviderBillingTaxAccount() {
        return this.pertinentInformationProviderBillingTaxAccount;
    }


    /**
     * <p>Invoice Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getInvoiceIdentifier() {
        return this.invoiceIdentifier.rawSet();
    }


    @Hl7XmlMapping({"primaryPerformer/contactParty"})
    public ContactPartyBean getPrimaryPerformerContactParty() {
        return this.primaryPerformerContactParty;
    }
    public void setPrimaryPerformerContactParty(ContactPartyBean primaryPerformerContactParty) {
        this.primaryPerformerContactParty = primaryPerformerContactParty;
    }

}
