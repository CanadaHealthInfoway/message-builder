/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
import ca.infoway.messagebuilder.model.common.coct_mt110101ca.AccountBean;
import ca.infoway.messagebuilder.model.common.coct_mt110200ca.PayeeAccountBean;
import ca.infoway.messagebuilder.model.common.ficr_mt610201ca.PertinentInformationBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT610201CA.PaymentIntent","FICR_MT630000CA.PaymentIntent"})
@Hl7RootType
public class PaymentIntentBean extends MessagePartBean {

    private TS paymentIntentDateTime = new TSImpl();
    private MO totalIntentPaymentAmount = new MOImpl();
    private List<PertinentInformationBean> pertinentInformation = new ArrayList<PertinentInformationBean>();
    private List<AdjudicatedInvoiceElementGroupBean> reasonOfAdjudicatedInvoiceElementGroup = new ArrayList<AdjudicatedInvoiceElementGroupBean>();
    private PayeeAccountBean creditAccount;
    private AccountBean debitAccount;

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

    @Hl7XmlMapping({"pertinentInformation"})
    public List<PertinentInformationBean> getPertinentInformation() {
        return this.pertinentInformation;
    }

    @Hl7XmlMapping({"reasonOf/adjudicatedInvoiceElementGroup"})
    public List<AdjudicatedInvoiceElementGroupBean> getReasonOfAdjudicatedInvoiceElementGroup() {
        return this.reasonOfAdjudicatedInvoiceElementGroup;
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

}
