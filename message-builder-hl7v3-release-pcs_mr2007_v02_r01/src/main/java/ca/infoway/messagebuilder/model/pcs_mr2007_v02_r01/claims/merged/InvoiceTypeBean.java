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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt280001ca.A_BillableActChoice;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt600201ca.AttachmentsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt600201ca.CrossReferenceIdentifierBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt600201ca.InvoiceComponentBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt600201ca.InvoiceOverrideDetailsBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT600201CA.InvoiceElementGroup","FICR_MT620000CA.InvoiceElementGroup","QUCR_MT830201CA.InvoiceElementGroup"})
@Hl7RootType
public class InvoiceTypeBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt600201ca.InvoiceElementChoice {

    private static final long serialVersionUID = 20111117L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private MO netAmt = new MOImpl();
    private List<A_BillableActChoice> reasonOfBillableActChoice = new ArrayList<A_BillableActChoice>();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private BusinessArrangementBean inFulfillmentOfFinancialContract;
    private List<AttachmentsBean> pertinentInformation = new ArrayList<AttachmentsBean>();
    private List<CrossReferenceIdentifierBean> predecessorInvoiceElementCrossReference = new ArrayList<CrossReferenceIdentifierBean>();
    private List<AdjudicatedInvoiceElementGroupBean> referenceAdjudicatedInvoiceElementGroup = new ArrayList<AdjudicatedInvoiceElementGroupBean>();
    private List<PolicyIdentifierBean> coveragePolicyOrAccount = new ArrayList<PolicyIdentifierBean>();
    private List<InvoiceComponentBean> component = new ArrayList<InvoiceComponentBean>();
    private List<InvoiceOverrideDetailsBean> triggerForInvoiceElementOverride = new ArrayList<InvoiceOverrideDetailsBean>();


    /**
     * <p>Invoice Grouping Identifiers</p>
     * 
     * <p>Invoice Grouping Identifier(s</p>
     * 
     * <p>Invoice Group ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>InvoiceType</p>
     * 
     * <p>Invoice Type</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>InvoiceSubTotal</p>
     * 
     * <p>Invoice Sub-total</p>
     * 
     * <p>Invoice sub-total</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    @Hl7XmlMapping({"reasonOf/billableActChoice"})
    public List<A_BillableActChoice> getReasonOfBillableActChoice() {
        return this.reasonOfBillableActChoice;
    }


    /**
     * <p>TimePeriodForInvoice</p>
     * 
     * <p>Time period for invoice</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    @Hl7XmlMapping({"inFulfillmentOf/financialContract"})
    public BusinessArrangementBean getInFulfillmentOfFinancialContract() {
        return this.inFulfillmentOfFinancialContract;
    }
    public void setInFulfillmentOfFinancialContract(BusinessArrangementBean inFulfillmentOfFinancialContract) {
        this.inFulfillmentOfFinancialContract = inFulfillmentOfFinancialContract;
    }


    @Hl7XmlMapping({"pertinentInformation"})
    public List<AttachmentsBean> getPertinentInformation() {
        return this.pertinentInformation;
    }


    @Hl7XmlMapping({"predecessor/invoiceElementCrossReference"})
    public List<CrossReferenceIdentifierBean> getPredecessorInvoiceElementCrossReference() {
        return this.predecessorInvoiceElementCrossReference;
    }


    @Hl7XmlMapping({"reference/adjudicatedInvoiceElementGroup"})
    public List<AdjudicatedInvoiceElementGroupBean> getReferenceAdjudicatedInvoiceElementGroup() {
        return this.referenceAdjudicatedInvoiceElementGroup;
    }


    @Hl7XmlMapping({"coverage/policyOrAccount"})
    public List<PolicyIdentifierBean> getCoveragePolicyOrAccount() {
        return this.coveragePolicyOrAccount;
    }


    @Hl7XmlMapping({"component"})
    public List<InvoiceComponentBean> getComponent() {
        return this.component;
    }


    @Hl7XmlMapping({"triggerFor/invoiceElementOverride"})
    public List<InvoiceOverrideDetailsBean> getTriggerForInvoiceElementOverride() {
        return this.triggerForInvoiceElementOverride;
    }

}
