/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt500201ca;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged.ContactPartyBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged.ProviderBillingTaxAccountBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt110101ca.AccountBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt110200ca.PayeeAccountBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Mood Code: PRP - auth, pre-det, cov.etc. RQO - 
 * invoice</p>
 */
@Hl7PartTypeMapping({"FICR_MT500201CA.PaymentRequest"})
@Hl7RootType
public class PaymentRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20131209L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private MO amt = new MOImpl();
    private ContactPartyBean primaryPerformerContactParty;
    private PayeeAccountBean creditAccount;
    private AccountBean debitAccount;
    private List<ProviderBillingTaxAccountBean> pertinentInformationProviderBillingTaxAccount = new ArrayList<ProviderBillingTaxAccountBean>();
    private List<InvoiceElementChoice> reasonOfInvoiceElementChoice = new ArrayList<InvoiceElementChoice>();


    /**
     * <p>Business Name: Invoice Identifier</p>
     * 
     * <p>Relationship: FICR_MT500201CA.PaymentRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-9)</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: Total Billed Amount</p>
     * 
     * <p>Relationship: FICR_MT500201CA.PaymentRequest.amt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"amt"})
    public Money getAmt() {
        return this.amt.getValue();
    }

    /**
     * <p>Business Name: Total Billed Amount</p>
     * 
     * <p>Relationship: FICR_MT500201CA.PaymentRequest.amt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAmt(Money amt) {
        this.amt.setValue(amt);
    }


    /**
     * <p>Relationship: 
     * FICR_MT500201CA.PaymentRequestAttention.contactParty</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"primaryPerformer/contactParty"})
    public ContactPartyBean getPrimaryPerformerContactParty() {
        return this.primaryPerformerContactParty;
    }

    /**
     * <p>Relationship: 
     * FICR_MT500201CA.PaymentRequestAttention.contactParty</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPrimaryPerformerContactParty(ContactPartyBean primaryPerformerContactParty) {
        this.primaryPerformerContactParty = primaryPerformerContactParty;
    }


    /**
     * <p>Relationship: FICR_MT500201CA.PaymentRequestPayee.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"credit/account"})
    public PayeeAccountBean getCreditAccount() {
        return this.creditAccount;
    }

    /**
     * <p>Relationship: FICR_MT500201CA.PaymentRequestPayee.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCreditAccount(PayeeAccountBean creditAccount) {
        this.creditAccount = creditAccount;
    }


    /**
     * <p>Relationship: FICR_MT500201CA.PaymentRequestPayor.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"debit/account"})
    public AccountBean getDebitAccount() {
        return this.debitAccount;
    }

    /**
     * <p>Relationship: FICR_MT500201CA.PaymentRequestPayor.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDebitAccount(AccountBean debitAccount) {
        this.debitAccount = debitAccount;
    }


    /**
     * <p>Relationship: 
     * FICR_MT500201CA.PertinentInformation.providerBillingTaxAccount</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation/providerBillingTaxAccount"})
    public List<ProviderBillingTaxAccountBean> getPertinentInformationProviderBillingTaxAccount() {
        return this.pertinentInformationProviderBillingTaxAccount;
    }


    /**
     * <p>Relationship: 
     * FICR_MT500201CA.PaymentRequestReason.invoiceElementChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"reasonOf/invoiceElementChoice"})
    public List<InvoiceElementChoice> getReasonOfInvoiceElementChoice() {
        return this.reasonOfInvoiceElementChoice;
    }

}
