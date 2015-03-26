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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt510201ca;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged.AdjudicatorBillingTaxAccountBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt110101ca.AccountBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt110200ca.PayeeAccountBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Amt must be positive or 0 for</p><p>completed 
 * Adjudication Results</p><p>messages</p><p>Amt must be 
 * negative or 0 for Invoice Cancel Results messages</p>
 * 
 * <p>If an Adjudicator adjudicates for multiple insurance 
 * policies (EOBs) for multiple Payors and/or Payees, there 
 * would be more than 1 Payment Intent payload in the Results 
 * message</p>
 */
@Hl7PartTypeMapping({"FICR_MT510201CA.FinancialTransactionIntent"})
@Hl7RootType
public class FinancialTransactionIntentBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private II id = new IIImpl();
    private CS statusCode = new CSImpl();
    private TS effectiveTime = new TSImpl();
    private MO amt = new MOImpl();
    private PayeeAccountBean creditAccount;
    private AccountBean debitAccount;
    private List<AdjudicatorBillingTaxAccountBean> pertinentInformationAdjudicatorBillingTaxAccount = new ArrayList<AdjudicatorBillingTaxAccountBean>();
    private List<Reason2Bean> reasonOf = new ArrayList<Reason2Bean>();


    /**
     * <p>Business Name: Payment Intent Identifier</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.FinancialTransactionIntent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Payment Intent Identifier</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.FinancialTransactionIntent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Payment Intent Status</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.FinancialTransactionIntent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Payment Intent Status</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.FinancialTransactionIntent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: Payment Intent Date/Time</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.FinancialTransactionIntent.effectiveTime</p>
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
     * <p>Relationship: 
     * FICR_MT510201CA.FinancialTransactionIntent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Total Amount of Payment Intent</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.FinancialTransactionIntent.amt</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"amt"})
    public Money getAmt() {
        return this.amt.getValue();
    }

    /**
     * <p>Business Name: Total Amount of Payment Intent</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.FinancialTransactionIntent.amt</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAmt(Money amt) {
        this.amt.setValue(amt);
    }


    /**
     * <p>Relationship: FICR_MT510201CA.Credit.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"credit/account"})
    public PayeeAccountBean getCreditAccount() {
        return this.creditAccount;
    }

    /**
     * <p>Relationship: FICR_MT510201CA.Credit.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCreditAccount(PayeeAccountBean creditAccount) {
        this.creditAccount = creditAccount;
    }


    /**
     * <p>Relationship: FICR_MT510201CA.Debit.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"debit/account"})
    public AccountBean getDebitAccount() {
        return this.debitAccount;
    }

    /**
     * <p>Relationship: FICR_MT510201CA.Debit.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDebitAccount(AccountBean debitAccount) {
        this.debitAccount = debitAccount;
    }


    /**
     * <p>Relationship: 
     * FICR_MT510201CA.PertinentInformation2.adjudicatorBillingTaxAccount</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation/adjudicatorBillingTaxAccount"})
    public List<AdjudicatorBillingTaxAccountBean> getPertinentInformationAdjudicatorBillingTaxAccount() {
        return this.pertinentInformationAdjudicatorBillingTaxAccount;
    }


    /**
     * <p>Relationship: 
     * FICR_MT510201CA.FinancialTransactionIntent.reasonOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-10)</p>
     */
    @Hl7XmlMapping({"reasonOf"})
    public List<Reason2Bean> getReasonOf() {
        return this.reasonOf;
    }

}
