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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.claims.ficr_mt610201nb;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt110101nb.AccountBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt110200nb.PayeeAccountBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Payment Intent</p>
 * 
 * <p>If an Adjudicator adjudicates for multiple insurance 
 * policies (EOBs) for multiple Payors and/or Payees, there 
 * would be more than 1 Payment Intent payload in the Results 
 * message</p>
 */
@Hl7PartTypeMapping({"FICR_MT610201NB.PaymentIntent"})
@Hl7RootType
public class PaymentIntentBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private TS effectiveTime = new TSImpl();
    private MO amt = new MOImpl();
    private PayeeAccountBean creditAccount;
    private AccountBean debitAccount;
    private List<AdjudicatorBillingTaxAccountBean> pertinentInformationAdjudicatorBillingTaxAccount = new ArrayList<AdjudicatorBillingTaxAccountBean>();
    private List<PaymentReasonBean> reasonOf = new ArrayList<PaymentReasonBean>();


    /**
     * <p>Business Name: Payment Intent Date/Time</p>
     * 
     * <p>Relationship: FICR_MT610201NB.PaymentIntent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>For Invoice Nullify Results: Effective time of the cancel 
     * is noted in the control act wrapper.</p>
     * 
     * <p>Time payor intends to make payment (e.g. date of 
     * cheque/EFT run). For nullify, this would also be the date 
     * the payor intends to make the payment.</p><p>For Invoice 
     * Nullify Results: Effective time of the cancel is noted in 
     * the control act wrapper.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Payment Intent Date/Time</p>
     * 
     * <p>Relationship: FICR_MT610201NB.PaymentIntent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>For Invoice Nullify Results: Effective time of the cancel 
     * is noted in the control act wrapper.</p>
     * 
     * <p>Time payor intends to make payment (e.g. date of 
     * cheque/EFT run). For nullify, this would also be the date 
     * the payor intends to make the payment.</p><p>For Invoice 
     * Nullify Results: Effective time of the cancel is noted in 
     * the control act wrapper.</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Total intent payment amount</p>
     * 
     * <p>Relationship: FICR_MT610201NB.PaymentIntent.amt</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Amt must be positive or 0 for</p><p>completed 
     * Adjudication Results</p><p>messages</p><p>Amt must be 
     * negative or 0 for Invoice Cancel Results messages</p>
     * 
     * <p>Adjudication Results: The payment intent amount cannot be 
     * mandatory for active adjudication results.</p><p>For Invoice 
     * Nullify Results: the payment intent is completed only, and 
     * therefore the amount must be specified.</p><p>For completed 
     * Payment Intents, this field is mandatory.</p><p>Amt must be 
     * positive or 0 for</p><p>completed Adjudication 
     * Results</p><p>messages</p><p>Amt must be negative or 0 for 
     * Invoice Cancel Results messages</p>
     * 
     * <p>Adjudication Results: The payment intent amount cannot be 
     * mandatory for active adjudication results.</p><p>For Invoice 
     * Nullify Results: the payment intent is completed only, and 
     * therefore the amount must be specified.</p><p>For completed 
     * Payment Intents, this field is mandatory.</p>
     */
    @Hl7XmlMapping({"amt"})
    public Money getAmt() {
        return this.amt.getValue();
    }

    /**
     * <p>Business Name: Total intent payment amount</p>
     * 
     * <p>Relationship: FICR_MT610201NB.PaymentIntent.amt</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Amt must be positive or 0 for</p><p>completed 
     * Adjudication Results</p><p>messages</p><p>Amt must be 
     * negative or 0 for Invoice Cancel Results messages</p>
     * 
     * <p>Adjudication Results: The payment intent amount cannot be 
     * mandatory for active adjudication results.</p><p>For Invoice 
     * Nullify Results: the payment intent is completed only, and 
     * therefore the amount must be specified.</p><p>For completed 
     * Payment Intents, this field is mandatory.</p><p>Amt must be 
     * positive or 0 for</p><p>completed Adjudication 
     * Results</p><p>messages</p><p>Amt must be negative or 0 for 
     * Invoice Cancel Results messages</p>
     * 
     * <p>Adjudication Results: The payment intent amount cannot be 
     * mandatory for active adjudication results.</p><p>For Invoice 
     * Nullify Results: the payment intent is completed only, and 
     * therefore the amount must be specified.</p><p>For completed 
     * Payment Intents, this field is mandatory.</p>
     */
    public void setAmt(Money amt) {
        this.amt.setValue(amt);
    }


    /**
     * <p>Relationship: FICR_MT610201NB.PaymentIntentPayee.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"credit/account"})
    public PayeeAccountBean getCreditAccount() {
        return this.creditAccount;
    }

    /**
     * <p>Relationship: FICR_MT610201NB.PaymentIntentPayee.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCreditAccount(PayeeAccountBean creditAccount) {
        this.creditAccount = creditAccount;
    }


    /**
     * <p>Relationship: FICR_MT610201NB.PaymentIntentPayor.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"debit/account"})
    public AccountBean getDebitAccount() {
        return this.debitAccount;
    }

    /**
     * <p>Relationship: FICR_MT610201NB.PaymentIntentPayor.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDebitAccount(AccountBean debitAccount) {
        this.debitAccount = debitAccount;
    }


    /**
     * <p>Relationship: 
     * FICR_MT610201NB.PertinentInformation.adjudicatorBillingTaxAccount</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation/adjudicatorBillingTaxAccount"})
    public List<AdjudicatorBillingTaxAccountBean> getPertinentInformationAdjudicatorBillingTaxAccount() {
        return this.pertinentInformationAdjudicatorBillingTaxAccount;
    }


    /**
     * <p>Relationship: FICR_MT610201NB.PaymentIntent.reasonOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-10)</p>
     */
    @Hl7XmlMapping({"reasonOf"})
    public List<PaymentReasonBean> getReasonOf() {
        return this.reasonOf;
    }

}