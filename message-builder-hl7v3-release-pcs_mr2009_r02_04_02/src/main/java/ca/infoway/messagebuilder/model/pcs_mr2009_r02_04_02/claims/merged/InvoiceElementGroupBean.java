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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt500201ca.InvoiceElementComponentBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt280001ca.A_BillableActChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.AdjudicatedInvoiceElementGroupBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"FICR_MT500201CA.InvoiceElementGroup","FICR_MT510201CA.InvoiceElementGroup"})
public class InvoiceElementGroupBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.InvoiceElementChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt500201ca.InvoiceElementChoice {

    private static final long serialVersionUID = 20110901L;
    private List<A_BillableActChoice> reasonOfBillableActChoice = new ArrayList<A_BillableActChoice>();
    private SET<II, Identifier> invoiceGroupingIdentifierS = new SETImpl<II, Identifier>(IIImpl.class);
    private CV invoiceType = new CVImpl();
    private IVL<TS, Interval<Date>> timePeriodForInvoice = new IVLImpl<TS, Interval<Date>>();
    private MO invoiceSubTotal = new MOImpl();
    private CoveredPartyAsPatientBean coveredPartyCoveredPartyAsPatient;
    private FinancialContractBean inFulfillmentOfFinancialContract;
    private List<InvoiceElementCrossReferenceBean> predecessorInvoiceElementCrossReference = new ArrayList<InvoiceElementCrossReferenceBean>();
    private List<AdjudicatedInvoiceElementGroupBean> referenceAdjudicatedInvoiceElementGroup = new ArrayList<AdjudicatedInvoiceElementGroupBean>();
    private List<PolicyOrAccount_2Bean> coveragePolicyOrAccount = new ArrayList<PolicyOrAccount_2Bean>();
    private List<HealthDocumentAttachment_2Bean> pertinentInformationHealthDocumentAttachment = new ArrayList<HealthDocumentAttachment_2Bean>();
    private List<InvoiceElementComponentBean> component = new ArrayList<InvoiceElementComponentBean>();
    private List<InvoiceElementOverrideBean> triggerForInvoiceElementOverride = new ArrayList<InvoiceElementOverrideBean>();


    @Hl7XmlMapping({"reasonOf/billableActChoice"})
    public List<A_BillableActChoice> getReasonOfBillableActChoice() {
        return this.reasonOfBillableActChoice;
    }


    /**
     * <p>InvoiceGroupingIdentifierS</p>
     * 
     * <p>Invoice Grouping Identifier(s</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getInvoiceGroupingIdentifierS() {
        return this.invoiceGroupingIdentifierS.rawSet();
    }


    /**
     * <p>InvoiceType</p>
     * 
     * <p>Invoice type</p>
     * 
     * <p>Invoice Type</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getInvoiceType() {
        return (Code) this.invoiceType.getValue();
    }
    public void setInvoiceType(Code invoiceType) {
        this.invoiceType.setValue(invoiceType);
    }


    /**
     * <p>TimePeriodForInvoice</p>
     * 
     * <p>Time period for invoice</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getTimePeriodForInvoice() {
        return this.timePeriodForInvoice.getValue();
    }
    public void setTimePeriodForInvoice(Interval<Date> timePeriodForInvoice) {
        this.timePeriodForInvoice.setValue(timePeriodForInvoice);
    }


    /**
     * <p>InvoiceSubTotal</p>
     * 
     * <p>Invoice Sub-total</p>
     * 
     * <p>Invoice sub-total</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getInvoiceSubTotal() {
        return this.invoiceSubTotal.getValue();
    }
    public void setInvoiceSubTotal(Money invoiceSubTotal) {
        this.invoiceSubTotal.setValue(invoiceSubTotal);
    }


    @Hl7XmlMapping({"coveredParty/coveredPartyAsPatient"})
    public CoveredPartyAsPatientBean getCoveredPartyCoveredPartyAsPatient() {
        return this.coveredPartyCoveredPartyAsPatient;
    }
    public void setCoveredPartyCoveredPartyAsPatient(CoveredPartyAsPatientBean coveredPartyCoveredPartyAsPatient) {
        this.coveredPartyCoveredPartyAsPatient = coveredPartyCoveredPartyAsPatient;
    }


    @Hl7XmlMapping({"inFulfillmentOf/financialContract"})
    public FinancialContractBean getInFulfillmentOfFinancialContract() {
        return this.inFulfillmentOfFinancialContract;
    }
    public void setInFulfillmentOfFinancialContract(FinancialContractBean inFulfillmentOfFinancialContract) {
        this.inFulfillmentOfFinancialContract = inFulfillmentOfFinancialContract;
    }


    @Hl7XmlMapping({"predecessor/invoiceElementCrossReference"})
    public List<InvoiceElementCrossReferenceBean> getPredecessorInvoiceElementCrossReference() {
        return this.predecessorInvoiceElementCrossReference;
    }


    @Hl7XmlMapping({"reference/adjudicatedInvoiceElementGroup"})
    public List<AdjudicatedInvoiceElementGroupBean> getReferenceAdjudicatedInvoiceElementGroup() {
        return this.referenceAdjudicatedInvoiceElementGroup;
    }


    @Hl7XmlMapping({"coverage/policyOrAccount"})
    public List<PolicyOrAccount_2Bean> getCoveragePolicyOrAccount() {
        return this.coveragePolicyOrAccount;
    }


    @Hl7XmlMapping({"pertinentInformation/healthDocumentAttachment"})
    public List<HealthDocumentAttachment_2Bean> getPertinentInformationHealthDocumentAttachment() {
        return this.pertinentInformationHealthDocumentAttachment;
    }


    @Hl7XmlMapping({"component"})
    public List<InvoiceElementComponentBean> getComponent() {
        return this.component;
    }


    @Hl7XmlMapping({"triggerFor/invoiceElementOverride"})
    public List<InvoiceElementOverrideBean> getTriggerForInvoiceElementOverride() {
        return this.triggerForInvoiceElementOverride;
    }

}
