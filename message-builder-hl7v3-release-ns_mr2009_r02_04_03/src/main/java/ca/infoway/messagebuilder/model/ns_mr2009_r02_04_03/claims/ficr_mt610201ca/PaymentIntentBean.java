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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.claims.merged.AdjudicatorBillingTaxAccountBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt110101ca.AccountBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt110200ca.PayeeAccountBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT610201CA.PaymentIntent"})
@Hl7RootType
public class PaymentIntentBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private TS effectiveTime = new TSImpl();
    private MO amt = new MOImpl();
    private List<AdjudicatorBillingTaxAccountBean> pertinentInformationAdjudicatorBillingTaxAccount = new ArrayList<AdjudicatorBillingTaxAccountBean>();
    private PayeeAccountBean creditAccount;
    private AccountBean debitAccount;
    private List<PaymentIntentReasonBean> reasonOf = new ArrayList<PaymentIntentReasonBean>();


    /**
     * <p>Business Name: Payment Intent Date/Time</p>
     * 
     * <p>Relationship: FICR_MT610201CA.PaymentIntent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Payment Intent Date/Time</p>
     * 
     * <p>Relationship: FICR_MT610201CA.PaymentIntent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Total intent payment amount</p>
     * 
     * <p>Relationship: FICR_MT610201CA.PaymentIntent.amt</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"amt"})
    public Money getAmt() {
        return this.amt.getValue();
    }

    /**
     * <p>Business Name: Total intent payment amount</p>
     * 
     * <p>Relationship: FICR_MT610201CA.PaymentIntent.amt</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAmt(Money amt) {
        this.amt.setValue(amt);
    }


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.PertinentInformation.adjudicatorBillingTaxAccount</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation/adjudicatorBillingTaxAccount"})
    public List<AdjudicatorBillingTaxAccountBean> getPertinentInformationAdjudicatorBillingTaxAccount() {
        return this.pertinentInformationAdjudicatorBillingTaxAccount;
    }


    /**
     * <p>Relationship: FICR_MT610201CA.PaymentIntentPayee.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"credit/account"})
    public PayeeAccountBean getCreditAccount() {
        return this.creditAccount;
    }

    /**
     * <p>Relationship: FICR_MT610201CA.PaymentIntentPayee.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCreditAccount(PayeeAccountBean creditAccount) {
        this.creditAccount = creditAccount;
    }


    /**
     * <p>Relationship: FICR_MT610201CA.PaymentIntentPayor.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"debit/account"})
    public AccountBean getDebitAccount() {
        return this.debitAccount;
    }

    /**
     * <p>Relationship: FICR_MT610201CA.PaymentIntentPayor.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDebitAccount(AccountBean debitAccount) {
        this.debitAccount = debitAccount;
    }


    /**
     * <p>Relationship: FICR_MT610201CA.PaymentIntent.reasonOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-10)</p>
     */
    @Hl7XmlMapping({"reasonOf"})
    public List<PaymentIntentReasonBean> getReasonOf() {
        return this.reasonOf;
    }

}
