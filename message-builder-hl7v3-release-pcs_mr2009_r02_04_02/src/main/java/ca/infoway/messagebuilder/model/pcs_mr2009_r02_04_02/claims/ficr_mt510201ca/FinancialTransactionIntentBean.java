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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt510201ca;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.AdjudicatorBillingTaxAccountBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt110101ca.AccountBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt110200ca.PayeeAccountBean;

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

    private static final long serialVersionUID = 20110407L;
    private II paymentIntentIdentifier = new IIImpl();
    private CS paymentIntentStatus = new CSImpl();
    private TS paymentIntentDateTime = new TSImpl();
    private MO totalAmountOfPaymentIntent = new MOImpl();
    private PayeeAccountBean creditAccount;
    private AccountBean debitAccount;
    private List<AdjudicatorBillingTaxAccountBean> pertinentInformationAdjudicatorBillingTaxAccount = new ArrayList<AdjudicatorBillingTaxAccountBean>();
    private List<Reason2Bean> reasonOf = new ArrayList<Reason2Bean>();


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


    @Hl7XmlMapping({"pertinentInformation/adjudicatorBillingTaxAccount"})
    public List<AdjudicatorBillingTaxAccountBean> getPertinentInformationAdjudicatorBillingTaxAccount() {
        return this.pertinentInformationAdjudicatorBillingTaxAccount;
    }


    @Hl7XmlMapping({"reasonOf"})
    public List<Reason2Bean> getReasonOf() {
        return this.reasonOf;
    }

}
