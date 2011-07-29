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
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt600201ca.InvoiceElementComponentBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt280001ca.A_BillableActChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt280001ca.PreviousBillableActCrossReferenceBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt290000ca.BillableClinicalServiceBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt300000ca.SupplyEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt490000ca.BillableClinicalProductBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.AdjudicatedInvoiceElementGroupBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>InvoiceType</p>
 * 
 * <p>FICR_MT620000CA.InvoiceElementGroup: Invoice Type</p>
 * 
 * <p><p>Cancel reasons are noted in the control wrapper</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.InvoiceElementGroup","FICR_MT610201CA.InvoiceElementGroup","FICR_MT620000CA.InvoiceElementGroup","QUCR_MT830201CA.InvoiceElementGroup"})
@Hl7RootType
public class InvoiceTypeBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt600201ca.InvoiceElementChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.InvoiceElementChoice {

    private static final long serialVersionUID = 20110729L;
    private II id = new IIImpl();
    private CV invoiceType = new CVImpl();
    private MO invoiceSubTotal = new MOImpl();
    private List<A_BillableActChoice> reasonOfBillableActChoice = new ArrayList<A_BillableActChoice>();
    private IVL<TS, Interval<Date>> timePeriodForInvoice = new IVLImpl<TS, Interval<Date>>();
    private FinancialContractBean inFulfillmentOfFinancialContract;
    private List<InvoiceElementCrossReferenceBean> predecessorInvoiceElementCrossReference = new ArrayList<InvoiceElementCrossReferenceBean>();
    private List<AdjudicatedInvoiceElementGroupBean> referenceAdjudicatedInvoiceElementGroup = new ArrayList<AdjudicatedInvoiceElementGroupBean>();
    private List<PolicyOrAccount_2Bean> coveragePolicyOrAccount = new ArrayList<PolicyOrAccount_2Bean>();
    private List<HealthDocumentAttachment_2Bean> pertinentInformationHealthDocumentAttachment = new ArrayList<HealthDocumentAttachment_2Bean>();
    private List<InvoiceElementComponentBean> component = new ArrayList<InvoiceElementComponentBean>();
    private List<InvoiceElementOverrideBean> triggerForInvoiceElementOverride = new ArrayList<InvoiceElementOverrideBean>();


    /**
     * <p>Invoice Grouping Identifier(s</p>
     * 
     * <p>Invoice Group ID</p>
     * 
     * <p><p>Set of identifiers that uniquely identify the Invoice 
     * Grouping.</p></p>
     * 
     * <p><p>For example:</p><p>1. unique invoice group identifier, 
     * independent of adjudicator recipient.</p><p>2. sequential 
     * invoice grouping identifier by adjudicator.</p><p>Obligation 
     * on adjudicator is to return and communicate about this item 
     * with all identifiers (i.e. identifier 1. and 2.).</p></p>
     * 
     * <p><p>For example:</p><p>1. unique invoice group identifier, 
     * independent of adjudicator recipient.</p><p>2. sequential 
     * invoice grouping identifier by adjudicator.</p><p>Obligation 
     * on adjudicator is to return and communicate about this item 
     * with all identifiers (i.e. identifier 1. and 2.).</p></p>
     * 
     * <p><p>For example:</p><p>1. unique invoice group identifier, 
     * independent of adjudicator recipient.</p><p>2. sequential 
     * invoice grouping identifier by adjudicator.</p><p>Obligation 
     * on adjudicator is to return and communicate about this item 
     * with all identifiers (i.e. identifier 1. and 2.).</p></p>
     * 
     * <p><p>For example:</p><p>1. unique invoice group identifier, 
     * independent of adjudicator recipient.</p><p>2. sequential 
     * invoice grouping identifier by adjudicator.</p><p>Obligation 
     * on adjudicator is to return and communicate about this item 
     * with all identifiers (i.e. identifier 1. and 2.).</p></p>
     * 
     * <p>Invoice Grouping Identifier</p>
     * 
     * <p>Invoice Grouping Identifiers</p>
     * 
     * <p><p>There are some situations where more than 1 identifier 
     * for this object can be included in a message.</p></p>
     * 
     * <p><p>For example:</p><p>1. unique invoice group identifier, 
     * independent of adjudicator recipient.</p><p>2. sequential 
     * invoice grouping identifier by adjudicator.</p><p>Obligation 
     * on adjudicator is to return and communicate about this item 
     * with all identifiers (i.e. identifier 1. and 2.).</p></p>
     * 
     * <p><p>For example:</p><p>1. unique invoice group identifier, 
     * independent of adjudicator recipient.</p><p>2. sequential 
     * invoice grouping identifier by adjudicator.</p><p>Obligation 
     * on adjudicator is to return and communicate about this item 
     * with all identifiers (i.e. identifier 1. and 2.).</p></p>
     * 
     * <p><p>For example:</p><p>1. unique invoice group identifier, 
     * independent of adjudicator recipient.</p><p>2. sequential 
     * invoice grouping identifier by adjudicator.</p><p>Obligation 
     * on adjudicator is to return and communicate about this item 
     * with all identifiers (i.e. identifier 1. and 2.).</p></p>
     * 
     * <p><p>For example:</p><p>1. unique invoice group identifier, 
     * independent of adjudicator recipient.</p><p>2. sequential 
     * invoice grouping identifier by adjudicator.</p><p>Obligation 
     * on adjudicator is to return and communicate about this item 
     * with all identifiers (i.e. identifier 1. and 2.).</p></p>
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
     * 
     * <p><p>Invoice Type e.g. Healthcare Services, Rx Dispense, Rx 
     * Compound, Healthcare Goods, Preferred Accomodation</p></p>
     * 
     * <p><p>Each Invoice Type is used to specify 1. vocabulary, 2. 
     * structure of the Invoice Element Choice and 3. which 
     * Billable Act(s) can be included for the specified Invoice 
     * Type.</p><p>Information on constraints for the Invoice Type 
     * will be found in the NeCST Message Specifications. Each 
     * Benefit Group will indicate which Invoice Types will be 
     * supported by that Benefit Group.</p><p>Invoice Types will 
     * not generate unique and distinct XML schemas that can tested 
     * independent of each other. They must be tested together 
     * within an Message Type.</p></p>
     * 
     * <p><p>Each Invoice Type is used to specify 1. vocabulary, 2. 
     * structure of the Invoice Element Choice and 3. which 
     * Billable Act(s) can be included for the specified Invoice 
     * Type.</p><p>Information on constraints for the Invoice Type 
     * will be found in the NeCST Message Specifications. Each 
     * Benefit Group will indicate which Invoice Types will be 
     * supported by that Benefit Group.</p><p>Invoice Types will 
     * not generate unique and distinct XML schemas that can tested 
     * independent of each other. They must be tested together 
     * within an Message Type.</p></p>
     * 
     * <p><p>Each Invoice Type is used to specify 1. vocabulary, 2. 
     * structure of the Invoice Element Choice and 3. which 
     * Billable Act(s) can be included for the specified Invoice 
     * Type.</p><p>Information on constraints for the Invoice Type 
     * will be found in the NeCST Message Specifications. Each 
     * Benefit Group will indicate which Invoice Types will be 
     * supported by that Benefit Group.</p><p>Invoice Types will 
     * not generate unique and distinct XML schemas that can tested 
     * independent of each other. They must be tested together 
     * within an Message Type.</p></p>
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
     * <p>InvoiceSubTotal</p>
     * 
     * <p>Invoice Sub-total</p>
     * 
     * <p>Invoice SubTotal</p>
     * 
     * <p>Invoice sub-total</p>
     * 
     * <p><p>Invoice sub-total - This is the sum of the Submitted 
     * Invoice Line amounts; Identifies the total monetary amount 
     * billed for the invoice element.</p></p>
     * 
     * <p><p>For Cancel Request: This would serve as a cross-check 
     * for the Adjudicator for the Invoice Grouping that is being 
     * cancelled.</p><p>Attribute cannot be mandatory as it may not 
     * be present for a Coverage Extension Request.</p></p>
     * 
     * <p><p>For Cancel Request: This would serve as a cross-check 
     * for the Adjudicator for the Invoice Grouping that is being 
     * cancelled.</p><p>Attribute cannot be mandatory as it may not 
     * be present for a Coverage Extension Request.</p></p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getInvoiceSubTotal() {
        return this.invoiceSubTotal.getValue();
    }
    public void setInvoiceSubTotal(Money invoiceSubTotal) {
        this.invoiceSubTotal.setValue(invoiceSubTotal);
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
    public Interval<Date> getTimePeriodForInvoice() {
        return this.timePeriodForInvoice.getValue();
    }
    public void setTimePeriodForInvoice(Interval<Date> timePeriodForInvoice) {
        this.timePeriodForInvoice.setValue(timePeriodForInvoice);
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
