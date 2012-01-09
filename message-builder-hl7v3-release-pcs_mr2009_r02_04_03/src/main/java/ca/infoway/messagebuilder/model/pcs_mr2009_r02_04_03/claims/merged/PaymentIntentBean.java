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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt610201ca.PaymentIntentReasonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt110101ca.AccountBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt110200ca.PayeeAccountBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>PaymentIntent</p>
 * 
 * <p>FICR_MT630000CA.PaymentIntent: Payment Intent</p>
 * 
 * <p><p>Intention of Payor to pay invoice as previously 
 * adjudicated.</p></p>
 * 
 * <p><p>If an Adjudicator adjudicates for multiple insurance 
 * policies (EOBs) for multiple Payors and/or Payees, there 
 * would be more than 1 Payment Intent payload in the Results 
 * message</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT610201CA.PaymentIntent","FICR_MT630000CA.PaymentIntent"})
@Hl7RootType
public class PaymentIntentBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private TS effectiveTime = new TSImpl();
    private MO amt = new MOImpl();
    private PayeeAccountBean creditAccount;
    private AccountBean debitAccount;
    private List<AdjudicatorBillingTaxAccountBean> pertinentInformationAdjudicatorBillingTaxAccount = new ArrayList<AdjudicatorBillingTaxAccountBean>();
    private List<PaymentIntentReasonBean> reasonOf = new ArrayList<PaymentIntentReasonBean>();


    /**
     * <p>PaymentIntentDateTime</p>
     * 
     * <p>Payment Intent Date/Time</p>
     * 
     * <p>Payment Intent Date/Time</p>
     * 
     * <p><p>Parment Intent Date/Time - Time payor intends to make 
     * payment (e.g. date of cheque/EFT run).</p></p>
     * 
     * <p><p>For nullify, this would also be the date the payor 
     * intends to make the payment.</p><p>For Invoice Nullify 
     * Results: Effective time of the cancel is noted in the 
     * control act wrapper.</p></p>
     * 
     * <p><p>For nullify, this would also be the date the payor 
     * intends to make the payment.</p><p>For Invoice Nullify 
     * Results: Effective time of the cancel is noted in the 
     * control act wrapper.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>payment amount</p>
     * 
     * <p><p>Net_amt must be positive or 0 for</p><p>Adjudication 
     * Results messages</p><p>Net_amt must be negative or 0 for 
     * Invoice Cancel messages</p></p>
     * 
     * <p><p>Net_amt must be positive or 0 for</p><p>Adjudication 
     * Results messages</p><p>Net_amt must be negative or 0 for 
     * Invoice Cancel messages</p></p>
     * 
     * <p><p>Net_amt must be positive or 0 for</p><p>Adjudication 
     * Results messages</p><p>Net_amt must be negative or 0 for 
     * Invoice Cancel messages</p></p>
     * 
     * <p><p>payment amount</p></p>
     * 
     * <p><p>Adjudication Results: The payment intent amount cannot 
     * be mandatory for active adjudication results.</p><p>For 
     * Invoice Nullify Results: the payment intent is completed 
     * only, and therefore the amount must be specified.</p><p>For 
     * completed Payment Intents, this field is mandatory.</p></p>
     * 
     * <p><p>Adjudication Results: The payment intent amount cannot 
     * be mandatory for active adjudication results.</p><p>For 
     * Invoice Nullify Results: the payment intent is completed 
     * only, and therefore the amount must be specified.</p><p>For 
     * completed Payment Intents, this field is mandatory.</p></p>
     * 
     * <p><p>Adjudication Results: The payment intent amount cannot 
     * be mandatory for active adjudication results.</p><p>For 
     * Invoice Nullify Results: the payment intent is completed 
     * only, and therefore the amount must be specified.</p><p>For 
     * completed Payment Intents, this field is mandatory.</p></p>
     * 
     * <p>Total intent payment amount</p>
     */
    @Hl7XmlMapping({"amt"})
    public Money getAmt() {
        return this.amt.getValue();
    }
    public void setAmt(Money amt) {
        this.amt.setValue(amt);
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
    public List<PaymentIntentReasonBean> getReasonOf() {
        return this.reasonOf;
    }

}
