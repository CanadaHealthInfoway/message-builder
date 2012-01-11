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
    private List<PertinentInformationBean> pertinentInformation = new ArrayList<PertinentInformationBean>();
    private ca.infoway.messagebuilder.model.common.coct_mt110200ca.AccountBean creditAccount;
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

    @Hl7XmlMapping({"primaryPerformer"})
    public AttentionToContactsBean getPrimaryPerformer() {
        return this.primaryPerformer;
    }
    public void setPrimaryPerformer(AttentionToContactsBean primaryPerformer) {
        this.primaryPerformer = primaryPerformer;
    }

    @Hl7XmlMapping({"pertinentInformation"})
    public List<PertinentInformationBean> getPertinentInformation() {
        return this.pertinentInformation;
    }

    @Hl7XmlMapping({"credit/account"})
    public ca.infoway.messagebuilder.model.common.coct_mt110200ca.AccountBean getCreditAccount() {
        return this.creditAccount;
    }
    public void setCreditAccount(ca.infoway.messagebuilder.model.common.coct_mt110200ca.AccountBean creditAccount) {
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
