/**
 * Copyright 2012 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt600201ca;

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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt110200ca.AccountBean;
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

    private static final long serialVersionUID = 20121122L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private MO amt = new MOImpl();
    private AdministrativeContactsSBean primaryPerformerContactParty;
    private List<TaxAccountOfProviderBean> pertinentInformationProviderBillingTaxAccount = new ArrayList<TaxAccountOfProviderBean>();
    private AccountBean creditAccount;
    private ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt110101ca.AccountBean debitAccount;
    private List<InvoiceElementChoice> reasonOfInvoiceElementChoice = new ArrayList<InvoiceElementChoice>();


    /**
     * <p>Invoice Identifier</p>
     * 
     * <p>Set of Identifiers that uniquely identify the Invoice. 
     * Could reference an Invoice Number with associated 
     * indentifers</p>
     * 
     * <p>Invoice Identifier: Used for management of payment 
     * request objects by adjudicators to help with traceability of 
     * messages to their applications. This does not need to be 
     * surfaced to the provider. Can also be used to detect 
     * duplicate invoices.</p><p>There are some situations where 
     * more than 1 identifier for this object can be included in a 
     * message.</p><p>For example:</p>
     * 
     * <p>Invoice Identifier: Used for management of payment 
     * request objects by adjudicators to help with traceability of 
     * messages to their applications. This does not need to be 
     * surfaced to the provider. Can also be used to detect 
     * duplicate invoices.</p><p>There are some situations where 
     * more than 1 identifier for this object can be included in a 
     * message.</p><p>For example:</p>
     * 
     * <p>Invoice Identifier: Used for management of payment 
     * request objects by adjudicators to help with traceability of 
     * messages to their applications. This does not need to be 
     * surfaced to the provider. Can also be used to detect 
     * duplicate invoices.</p><p>There are some situations where 
     * more than 1 identifier for this object can be included in a 
     * message.</p><p>For example:</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Total Billed Amount</p>
     * 
     * <p>OID (object identifier) + unique number generated by the 
     * pharmacy software for the complete invoice.</p><p>Must not 
     * be the same identifier as the InvoiceElementGroup.id.</p>
     * 
     * <p>OID (object identifier) + unique number generated by the 
     * pharmacy software for the complete invoice.</p><p>Must not 
     * be the same identifier as the InvoiceElementGroup.id.</p>
     */
    @Hl7XmlMapping({"amt"})
    public Money getAmt() {
        return this.amt.getValue();
    }

    /**
     * <p>Total Billed Amount</p>
     * 
     * <p>OID (object identifier) + unique number generated by the 
     * pharmacy software for the complete invoice.</p><p>Must not 
     * be the same identifier as the InvoiceElementGroup.id.</p>
     * 
     * <p>OID (object identifier) + unique number generated by the 
     * pharmacy software for the complete invoice.</p><p>Must not 
     * be the same identifier as the InvoiceElementGroup.id.</p>
     */
    public void setAmt(Money amt) {
        this.amt.setValue(amt);
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
    public AccountBean getCreditAccount() {
        return this.creditAccount;
    }

    public void setCreditAccount(AccountBean creditAccount) {
        this.creditAccount = creditAccount;
    }


    @Hl7XmlMapping({"debit/account"})
    public ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt110101ca.AccountBean getDebitAccount() {
        return this.debitAccount;
    }

    public void setDebitAccount(ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt110101ca.AccountBean debitAccount) {
        this.debitAccount = debitAccount;
    }


    @Hl7XmlMapping({"reasonOf/invoiceElementChoice"})
    public List<InvoiceElementChoice> getReasonOfInvoiceElementChoice() {
        return this.reasonOfInvoiceElementChoice;
    }

}
