/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt500201ca;

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
import ca.infoway.messagebuilder.model.common.coct_mt110101ca.AccountBean;
import ca.infoway.messagebuilder.model.common.coct_mt110200ca.PayeeAccountBean;
import ca.infoway.messagebuilder.model.merged.ContactPartyBean;
import ca.infoway.messagebuilder.model.merged.ProviderBillingTaxAccountBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Mood Code: PRP - auth, pre-det, cov.etc. RQO - invoice</p>
 */
@Hl7PartTypeMapping({"FICR_MT500201CA.PaymentRequest"})
@Hl7RootType
public class PaymentRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private SET<II, Identifier> invoiceIdentifier = new SETImpl<II, Identifier>(IIImpl.class);
    private MO totalBilledAmount = new MOImpl();
    private ContactPartyBean primaryPerformerContactParty;
    private PayeeAccountBean creditAccount;
    private AccountBean debitAccount;
    private List<ProviderBillingTaxAccountBean> pertinentInformationProviderBillingTaxAccount = new ArrayList<ProviderBillingTaxAccountBean>();
    private List<InvoiceElementChoiceBean> reasonOfInvoiceElementChoice = new ArrayList<InvoiceElementChoiceBean>();

    @Hl7XmlMapping({"id"})
    public Set<Identifier> getInvoiceIdentifier() {
        return this.invoiceIdentifier.rawSet();
    }

    @Hl7XmlMapping({"amt"})
    public Money getTotalBilledAmount() {
        return this.totalBilledAmount.getValue();
    }
    public void setTotalBilledAmount(Money totalBilledAmount) {
        this.totalBilledAmount.setValue(totalBilledAmount);
    }

    @Hl7XmlMapping({"primaryPerformer/contactParty"})
    public ContactPartyBean getPrimaryPerformerContactParty() {
        return this.primaryPerformerContactParty;
    }
    public void setPrimaryPerformerContactParty(ContactPartyBean primaryPerformerContactParty) {
        this.primaryPerformerContactParty = primaryPerformerContactParty;
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

    @Hl7XmlMapping({"reasonOf/invoiceElementChoice"})
    public List<InvoiceElementChoiceBean> getReasonOfInvoiceElementChoice() {
        return this.reasonOfInvoiceElementChoice;
    }

}
