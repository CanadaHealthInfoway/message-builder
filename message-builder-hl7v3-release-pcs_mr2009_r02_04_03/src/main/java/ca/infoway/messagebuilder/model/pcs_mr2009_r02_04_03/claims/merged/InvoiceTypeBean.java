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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt600201ca.InvoiceElementComponentBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt280001ca.A_BillableActChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActInvoiceGroupType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.AdjudicatedInvoiceElementGroupBean;



/**
 * <p>Business Name: InvoiceType</p>
 * 
 * <p>FICR_MT620000CA.InvoiceElementGroup: Invoice Type</p>
 * 
 * <p>Cancel reasons are noted in the control wrapper</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.InvoiceElementGroup","FICR_MT610201CA.InvoiceElementGroup","FICR_MT620000CA.InvoiceElementGroup","QUCR_MT830201CA.InvoiceElementGroup"})
@Hl7RootType
public class InvoiceTypeBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.InvoiceElementChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt600201ca.InvoiceElementChoice {

    private static final long serialVersionUID = 20130307L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private MO netAmt = new MOImpl();
    private List<A_BillableActChoice> reasonOfBillableActChoice = new ArrayList<A_BillableActChoice>();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private FinancialContractBean inFulfillmentOfFinancialContract;
    private List<InvoiceElementCrossReferenceBean> predecessorInvoiceElementCrossReference = new ArrayList<InvoiceElementCrossReferenceBean>();
    private List<AdjudicatedInvoiceElementGroupBean> referenceAdjudicatedInvoiceElementGroup = new ArrayList<AdjudicatedInvoiceElementGroupBean>();
    private List<PolicyOrAccount_2Bean> coveragePolicyOrAccount = new ArrayList<PolicyOrAccount_2Bean>();
    private List<HealthDocumentAttachment_2Bean> pertinentInformationHealthDocumentAttachment = new ArrayList<HealthDocumentAttachment_2Bean>();
    private List<InvoiceElementComponentBean> component = new ArrayList<InvoiceElementComponentBean>();
    private List<InvoiceElementOverrideBean> triggerForInvoiceElementOverride = new ArrayList<InvoiceElementOverrideBean>();


    /**
     * <p>Un-merged Business Name: InvoiceGroupingIdentifiers</p>
     * 
     * <p>Relationship: FICR_MT620000CA.InvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>There are some situations where more than 1 identifier 
     * for this object can be included in a message.</p>
     * 
     * <p>For example:</p><p>1. unique invoice group identifier, 
     * independent of adjudicator recipient.</p><p>2. sequential 
     * invoice grouping identifier by adjudicator.</p><p>Obligation 
     * on adjudicator is to return and communicate about this item 
     * with all identifiers (i.e. identifier 1. and 2.).</p>
     * 
     * <p></p>
     * 
     * <p>Un-merged Business Name: InvoiceGroupID</p>
     * 
     * <p>Relationship: QUCR_MT830201CA.InvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p></p><p>For example:</p><p>1. unique invoice group 
     * identifier, independent of adjudicator recipient.</p><p>2. 
     * sequential invoice grouping identifier by 
     * adjudicator.</p><p>Obligation on adjudicator is to return 
     * and communicate about this item with all identifiers (i.e. 
     * identifier 1. and 2.).</p>
     * 
     * <p>Set of identifiers that uniquely identify the Invoice 
     * Grouping.</p>
     * 
     * <p>Un-merged Business Name: InvoiceGroupingIdentifierS</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: InvoiceGroupingIdentifier</p>
     * 
     * <p>Relationship: FICR_MT610201CA.InvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Un-merged Business Name: InvoiceGroupingIdentifiers</p>
     * 
     * <p>Relationship: FICR_MT620000CA.InvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>There are some situations where more than 1 identifier 
     * for this object can be included in a message.</p>
     * 
     * <p>For example:</p><p>1. unique invoice group identifier, 
     * independent of adjudicator recipient.</p><p>2. sequential 
     * invoice grouping identifier by adjudicator.</p><p>Obligation 
     * on adjudicator is to return and communicate about this item 
     * with all identifiers (i.e. identifier 1. and 2.).</p>
     * 
     * <p></p>
     * 
     * <p>Un-merged Business Name: InvoiceGroupID</p>
     * 
     * <p>Relationship: QUCR_MT830201CA.InvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p></p><p>For example:</p><p>1. unique invoice group 
     * identifier, independent of adjudicator recipient.</p><p>2. 
     * sequential invoice grouping identifier by 
     * adjudicator.</p><p>Obligation on adjudicator is to return 
     * and communicate about this item with all identifiers (i.e. 
     * identifier 1. and 2.).</p>
     * 
     * <p>Set of identifiers that uniquely identify the Invoice 
     * Grouping.</p>
     * 
     * <p>Un-merged Business Name: InvoiceGroupingIdentifierS</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: InvoiceGroupingIdentifier</p>
     * 
     * <p>Relationship: FICR_MT610201CA.InvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: InvoiceType</p>
     * 
     * <p>Un-merged Business Name: InvoiceType</p>
     * 
     * <p>Relationship: FICR_MT620000CA.InvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Each Invoice Type is used to specify 1. vocabulary, 2. 
     * structure of the Invoice Element Choice and 3. which 
     * Billable Act(s) can be included for the specified Invoice 
     * Type.</p><p>Information on constraints for the Invoice Type 
     * will be found in the NeCST Message Specifications. Each 
     * Benefit Group will indicate which Invoice Types will be 
     * supported by that Benefit Group.</p><p>Invoice Types will 
     * not generate unique and distinct XML schemas that can tested 
     * independent of each other. They must be tested together 
     * within an Message Type.</p>
     * 
     * <p>Invoice Type e.g. Healthcare Services, Rx Dispense, Rx 
     * Compound, Healthcare Goods, Preferred Accomodation</p>
     * 
     * <p>Un-merged Business Name: InvoiceType</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: InvoiceType</p>
     * 
     * <p>Relationship: FICR_MT610201CA.InvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceGroupType getCode() {
        return (ActInvoiceGroupType) this.code.getValue();
    }

    /**
     * <p>Business Name: InvoiceType</p>
     * 
     * <p>Un-merged Business Name: InvoiceType</p>
     * 
     * <p>Relationship: FICR_MT620000CA.InvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Each Invoice Type is used to specify 1. vocabulary, 2. 
     * structure of the Invoice Element Choice and 3. which 
     * Billable Act(s) can be included for the specified Invoice 
     * Type.</p><p>Information on constraints for the Invoice Type 
     * will be found in the NeCST Message Specifications. Each 
     * Benefit Group will indicate which Invoice Types will be 
     * supported by that Benefit Group.</p><p>Invoice Types will 
     * not generate unique and distinct XML schemas that can tested 
     * independent of each other. They must be tested together 
     * within an Message Type.</p>
     * 
     * <p>Invoice Type e.g. Healthcare Services, Rx Dispense, Rx 
     * Compound, Healthcare Goods, Preferred Accomodation</p>
     * 
     * <p>Un-merged Business Name: InvoiceType</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: InvoiceType</p>
     * 
     * <p>Relationship: FICR_MT610201CA.InvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ActInvoiceGroupType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: InvoiceSubTotal</p>
     * 
     * <p>Un-merged Business Name: InvoiceSubTotal</p>
     * 
     * <p>Relationship: FICR_MT620000CA.InvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Cancel Request: This would serve as a cross-check for 
     * the Adjudicator for the Invoice Grouping that is being 
     * cancelled.</p><p>Attribute cannot be mandatory as it may not 
     * be present for a Coverage Extension Request.</p>
     * 
     * <p>Invoice sub-total - This is the sum of the Submitted 
     * Invoice Line amounts; Identifies the total monetary amount 
     * billed for the invoice element.</p>
     * 
     * <p>Un-merged Business Name: InvoiceSubTotal</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: InvoiceSubTotal</p>
     * 
     * <p>Relationship: FICR_MT610201CA.InvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }

    /**
     * <p>Business Name: InvoiceSubTotal</p>
     * 
     * <p>Un-merged Business Name: InvoiceSubTotal</p>
     * 
     * <p>Relationship: FICR_MT620000CA.InvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Cancel Request: This would serve as a cross-check for 
     * the Adjudicator for the Invoice Grouping that is being 
     * cancelled.</p><p>Attribute cannot be mandatory as it may not 
     * be present for a Coverage Extension Request.</p>
     * 
     * <p>Invoice sub-total - This is the sum of the Submitted 
     * Invoice Line amounts; Identifies the total monetary amount 
     * billed for the invoice element.</p>
     * 
     * <p>Un-merged Business Name: InvoiceSubTotal</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: InvoiceSubTotal</p>
     * 
     * <p>Relationship: FICR_MT610201CA.InvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementReason.billableActChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"reasonOf/billableActChoice"})
    public List<A_BillableActChoice> getReasonOfBillableActChoice() {
        return this.reasonOfBillableActChoice;
    }


    /**
     * <p>Business Name: TimePeriodForInvoice</p>
     * 
     * <p>Un-merged Business Name: TimePeriodForInvoice</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementGroup.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: TimePeriodForInvoice</p>
     * 
     * <p>Un-merged Business Name: TimePeriodForInvoice</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementGroup.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementGroupInFulfillmentOf.financialContract</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/financialContract"})
    public FinancialContractBean getInFulfillmentOfFinancialContract() {
        return this.inFulfillmentOfFinancialContract;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementGroupInFulfillmentOf.financialContract</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setInFulfillmentOfFinancialContract(FinancialContractBean inFulfillmentOfFinancialContract) {
        this.inFulfillmentOfFinancialContract = inFulfillmentOfFinancialContract;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.Predecessor.invoiceElementCrossReference</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"predecessor/invoiceElementCrossReference"})
    public List<InvoiceElementCrossReferenceBean> getPredecessorInvoiceElementCrossReference() {
        return this.predecessorInvoiceElementCrossReference;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.Reference.adjudicatedInvoiceElementGroup</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"reference/adjudicatedInvoiceElementGroup"})
    public List<AdjudicatedInvoiceElementGroupBean> getReferenceAdjudicatedInvoiceElementGroup() {
        return this.referenceAdjudicatedInvoiceElementGroup;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementCoverage.policyOrAccount</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"coverage/policyOrAccount"})
    public List<PolicyOrAccount_2Bean> getCoveragePolicyOrAccount() {
        return this.coveragePolicyOrAccount;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementGroupAttachment.healthDocumentAttachment</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation/healthDocumentAttachment"})
    public List<HealthDocumentAttachment_2Bean> getPertinentInformationHealthDocumentAttachment() {
        return this.pertinentInformationHealthDocumentAttachment;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementGroup.component</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-10)</p>
     */
    @Hl7XmlMapping({"component"})
    public List<InvoiceElementComponentBean> getComponent() {
        return this.component;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.Suggests.invoiceElementOverride</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"triggerFor/invoiceElementOverride"})
    public List<InvoiceElementOverrideBean> getTriggerForInvoiceElementOverride() {
        return this.triggerForInvoiceElementOverride;
    }

}
