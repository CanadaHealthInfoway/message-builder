/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt600201ca;

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
import ca.infoway.messagebuilder.model.claims.coct_mt110101ca.AccountBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Invoice Identifier</p>
 * 
 * <p>Set of Identifiers that uniquely identify the Invoice. 
 * Could reference an Invoice Number with associated 
 * indentifers</p>
 * 
 * <p>Details of the claim for which payment is being 
 * requested.</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.PaymentRequest"})
@Hl7RootType
public class InvoiceIdentifierBean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private SET<II, Identifier> invoiceIdentifier = new SETImpl<II, Identifier>(IIImpl.class);
    private MO totalBilledAmount = new MOImpl();
    private AdministrativeContactsSBean primaryPerformerContactParty;
    private List<TaxAccountOfProviderBean> pertinentInformationProviderBillingTaxAccount = new ArrayList<TaxAccountOfProviderBean>();
    private ca.infoway.messagebuilder.model.claims.coct_mt110200ca.AccountBean creditAccount;
    private AccountBean debitAccount;
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
    public AdministrativeContactsSBean getPrimaryPerformerContactParty() {
        return this.primaryPerformerContactParty;
    }
    public void setPrimaryPerformerContactParty(AdministrativeContactsSBean primaryPerformerContactParty) {
        this.primaryPerformerContactParty = primaryPerformerContactParty;
    }

    @Hl7XmlMapping({"pertinentInformation/providerBillingTaxAccount"})
    public List<TaxAccountOfProviderBean> getPertinentInformationProviderBillingTaxAccount() {
        return this.pertinentInformationProviderBillingTaxAccount;
    }

    @Hl7XmlMapping({"credit/account"})
    public ca.infoway.messagebuilder.model.claims.coct_mt110200ca.AccountBean getCreditAccount() {
        return this.creditAccount;
    }
    public void setCreditAccount(ca.infoway.messagebuilder.model.claims.coct_mt110200ca.AccountBean creditAccount) {
        this.creditAccount = creditAccount;
    }

    @Hl7XmlMapping({"debit/account"})
    public AccountBean getDebitAccount() {
        return this.debitAccount;
    }
    public void setDebitAccount(AccountBean debitAccount) {
        this.debitAccount = debitAccount;
    }

    @Hl7XmlMapping({"reasonOf/invoiceElementChoice"})
    public List<InvoiceElementChoiceBean> getReasonOfInvoiceElementChoice() {
        return this.reasonOfInvoiceElementChoice;
    }

}
