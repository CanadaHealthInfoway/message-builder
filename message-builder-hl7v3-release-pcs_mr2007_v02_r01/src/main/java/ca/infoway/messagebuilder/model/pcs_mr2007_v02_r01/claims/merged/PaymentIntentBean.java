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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt110200ca.AccountBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt610201ca.AdjudicatorBillingTaxAccountBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt610201ca.PaymentReasonBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT610201CA.PaymentIntent","FICR_MT630000CA.PaymentIntent"})
@Hl7RootType
public class PaymentIntentBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private TS paymentIntentDateTime = new TSImpl();
    private MO amt = new MOImpl();
    private List<AdjudicatorBillingTaxAccountBean> pertinentInformationAdjudicatorBillingTaxAccount = new ArrayList<AdjudicatorBillingTaxAccountBean>();
    private AccountBean creditAccount;
    private ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt110101ca.AccountBean debitAccount;
    private List<PaymentReasonBean> reasonOf = new ArrayList<PaymentReasonBean>();


    /**
     * <p>PaymentIntentDateTime</p>
     * 
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
     * <p>payment amount</p>
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


    @Hl7XmlMapping({"pertinentInformation/adjudicatorBillingTaxAccount"})
    public List<AdjudicatorBillingTaxAccountBean> getPertinentInformationAdjudicatorBillingTaxAccount() {
        return this.pertinentInformationAdjudicatorBillingTaxAccount;
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


    @Hl7XmlMapping({"reasonOf"})
    public List<PaymentReasonBean> getReasonOf() {
        return this.reasonOf;
    }

}
