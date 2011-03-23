/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.ficr_mt600201ca;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



/**
 * <p>Invoice Identifier 
 * 
 * <p>Set of Identifiers that uniquely identify the Invoice. 
 * Could reference an Invoice Number with associated 
 * indentifers 
 * 
 * <p>Details of the claim for which payment is being 
 * requested. 
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.PaymentRequest"})
@Hl7RootType
public class InvoiceIdentifierBean extends MessagePartBean {

    private SET<II, Identifier> invoiceIdentifier = new SETImpl<II, Identifier>(IIImpl.class);
    private MO totalBilledAmount = new MOImpl();
    private AttentionToContactsBean primaryPerformer;
    private PayeeAccountBean creditAccount;
    private AccountBean debitAccount;
    private List<PertinentInformationBean> pertinentInformation = new ArrayList<PertinentInformationBean>();
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

    @Hl7XmlMapping({"primaryPerformer"})
    public AttentionToContactsBean getPrimaryPerformer() {
        return this.primaryPerformer;
    }
    public void setPrimaryPerformer(AttentionToContactsBean primaryPerformer) {
        this.primaryPerformer = primaryPerformer;
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

    @Hl7XmlMapping({"pertinentInformation"})
    public List<PertinentInformationBean> getPertinentInformation() {
        return this.pertinentInformation;
    }

    @Hl7XmlMapping({"reasonOf/invoiceElementChoice"})
    public List<InvoiceElementChoiceBean> getReasonOfInvoiceElementChoice() {
        return this.reasonOfInvoiceElementChoice;
    }

}
