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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.coct_mt280001ca.A_BillableActChoice;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.coct_mt680000ca.AdjudicatedInvoiceElementGroupBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt600201ca.AttachmentsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt600201ca.BusinessArrangementBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt600201ca.CrossReferenceIdentifierBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt600201ca.InvoiceComponentBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt600201ca.InvoiceOverrideDetailsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.domainvalue.ActInvoiceGroupCode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>FICR_MT600201CA.InvoiceElementGroup: Invoice Grouping 
 * Information</p>
 * 
 * <p>There are some situations where all items for a patient 
 * need to be included in 1 Invoice Grouping, as the final 
 * determination (adjudication results) will not be made until 
 * all invoice elements are considered for that patient.</p>
 * 
 * <p>The statement and justification of the Total Billed 
 * Amount. For an invoice it is the statement and justification 
 * of the Total Billed amount requesting the determination of 
 * the amount owed by the payor for the service(s) that either 
 * have occurred or are on-going. For an authorization it 
 * represents the statement and justification of an invoice for 
 * a future service requesting the determination of the amount 
 * owed that is guaranteed by the payor. For a 
 * pre-determination, it represents the statement and possible 
 * justification for an invoice for a future service to 
 * determine the possible amount owed by the payor.</p>
 * 
 * <p>FICR_MT610201CA.InvoiceElementGroup: Submitted Invoice 
 * Group</p>
 * 
 * <p>Unique number generated by the pharmacy software for the 
 * specific invoice element group</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.InvoiceElementGroup","FICR_MT610201CA.InvoiceElementGroup","QUCR_MT830201CA.InvoiceElementGroup"})
public class SubmittedInvoiceGroupBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt610201ca.InvoiceElementChoice, ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt600201ca.InvoiceElementChoice {

    private static final long serialVersionUID = 20150326L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private MO netAmt = new MOImpl();
    private BusinessArrangementBean inFulfillmentOfFinancialContract;
    private List<CrossReferenceIdentifierBean> predecessorInvoiceElementCrossReference = new ArrayList<CrossReferenceIdentifierBean>();
    private List<AdjudicatedInvoiceElementGroupBean> referenceAdjudicatedInvoiceElementGroup = new ArrayList<AdjudicatedInvoiceElementGroupBean>();
    private List<PolicyIdentifierBean> coveragePolicyOrAccount = new ArrayList<PolicyIdentifierBean>();
    private List<AttachmentsBean> pertinentInformation = new ArrayList<AttachmentsBean>();
    private List<InvoiceComponentBean> component = new ArrayList<InvoiceComponentBean>();
    private List<A_BillableActChoice> reasonOfBillableActChoice = new ArrayList<A_BillableActChoice>();
    private List<InvoiceOverrideDetailsBean> triggerForInvoiceElementOverride = new ArrayList<InvoiceOverrideDetailsBean>();


    /**
     * <p>Un-merged Business Name: InvoiceGroupID</p>
     * 
     * <p>Relationship: QUCR_MT830201CA.InvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For example:</p><p>1. unique invoice group identifier, 
     * independent of adjudicator recipient.</p><p>2. sequential 
     * invoice grouping identifier by adjudicator.</p><p>Obligation 
     * on adjudicator is to return and communicate about this item 
     * with all identifiers (i.e. identifier 1. and 2.).</p>
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
     * <p>For example:</p><p>1. unique invoice group identifier, 
     * independent of adjudicator recipient.</p><p>2. sequential 
     * invoice grouping identifier by adjudicator.</p><p>Obligation 
     * on adjudicator is to return and communicate about this item 
     * with all identifiers (i.e. identifier 1. and 2.).</p>
     * 
     * <p>OID (object identifier) + unique number generated by the 
     * pharmacy software for the specific invoice element 
     * group.</p><p>For child Invoice Element Groups, the 
     * identifier will be the same as its parent Invoice Element 
     * Group, appended with a &quot;.x&quot;, where &quot;x&quot; 
     * is a number siginifying the occurence of this item under its 
     * parent. For example, the parent id is &quot;12942&quot; and 
     * this is the 2nd item under the parent. Therefore, the id for 
     * this item would be &quot;12942.2&quot;.</p><p>Must not be 
     * the same identifier as the PaymentRequest.id or the 
     * InvoiceElementDetail.id.</p>
     * 
     * <p>Set of identifiers that uniquely identify the Invoice 
     * Grouping.</p>
     * 
     * <p>Un-merged Business Name: InvoiceGroupingIdentifier</p>
     * 
     * <p>Relationship: FICR_MT610201CA.InvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For example:</p><p>1. unique invoice group identifier, 
     * independent of adjudicator recipient.</p><p>2. sequential 
     * invoice grouping identifier by adjudicator.</p><p>Obligation 
     * on adjudicator is to return and communicate about this item 
     * with all identifiers (i.e. identifier 1. and 2.).</p>
     * 
     * <p>OID (object identifier) + unique number generated by the 
     * pharmacy software for the specific invoice element 
     * group.</p><p>For child Invoice Element Groups, the 
     * identifier will be the same as its parent Invoice Element 
     * Group, appended with a &quot;.x&quot;, where &quot;x&quot; 
     * is a number siginifying the occurence of this item under its 
     * parent. For example, the parent id is &quot;12942&quot; and 
     * this is the 2nd item under the parent. Therefore, the id for 
     * this item would be &quot;12942.2&quot;.</p><p>Must not be 
     * the same identifier as the PaymentRequest.id or the 
     * InvoiceElementDetail.id.</p>
     * 
     * <p>Set of identifiers that uniquely identify the Invoice 
     * Grouping.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Un-merged Business Name: InvoiceGroupID</p>
     * 
     * <p>Relationship: QUCR_MT830201CA.InvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For example:</p><p>1. unique invoice group identifier, 
     * independent of adjudicator recipient.</p><p>2. sequential 
     * invoice grouping identifier by adjudicator.</p><p>Obligation 
     * on adjudicator is to return and communicate about this item 
     * with all identifiers (i.e. identifier 1. and 2.).</p>
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
     * <p>For example:</p><p>1. unique invoice group identifier, 
     * independent of adjudicator recipient.</p><p>2. sequential 
     * invoice grouping identifier by adjudicator.</p><p>Obligation 
     * on adjudicator is to return and communicate about this item 
     * with all identifiers (i.e. identifier 1. and 2.).</p>
     * 
     * <p>OID (object identifier) + unique number generated by the 
     * pharmacy software for the specific invoice element 
     * group.</p><p>For child Invoice Element Groups, the 
     * identifier will be the same as its parent Invoice Element 
     * Group, appended with a &quot;.x&quot;, where &quot;x&quot; 
     * is a number siginifying the occurence of this item under its 
     * parent. For example, the parent id is &quot;12942&quot; and 
     * this is the 2nd item under the parent. Therefore, the id for 
     * this item would be &quot;12942.2&quot;.</p><p>Must not be 
     * the same identifier as the PaymentRequest.id or the 
     * InvoiceElementDetail.id.</p>
     * 
     * <p>Set of identifiers that uniquely identify the Invoice 
     * Grouping.</p>
     * 
     * <p>Un-merged Business Name: InvoiceGroupingIdentifier</p>
     * 
     * <p>Relationship: FICR_MT610201CA.InvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For example:</p><p>1. unique invoice group identifier, 
     * independent of adjudicator recipient.</p><p>2. sequential 
     * invoice grouping identifier by adjudicator.</p><p>Obligation 
     * on adjudicator is to return and communicate about this item 
     * with all identifiers (i.e. identifier 1. and 2.).</p>
     * 
     * <p>OID (object identifier) + unique number generated by the 
     * pharmacy software for the specific invoice element 
     * group.</p><p>For child Invoice Element Groups, the 
     * identifier will be the same as its parent Invoice Element 
     * Group, appended with a &quot;.x&quot;, where &quot;x&quot; 
     * is a number siginifying the occurence of this item under its 
     * parent. For example, the parent id is &quot;12942&quot; and 
     * this is the 2nd item under the parent. Therefore, the id for 
     * this item would be &quot;12942.2&quot;.</p><p>Must not be 
     * the same identifier as the PaymentRequest.id or the 
     * InvoiceElementDetail.id.</p>
     * 
     * <p>Set of identifiers that uniquely identify the Invoice 
     * Grouping.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: InvoiceType</p>
     * 
     * <p>Un-merged Business Name: InvoiceType</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>RXDINV, RXCINV, CSINV, CPINV, CSPINV only for root 
     * invoice element group. RXDINV only for root invoice element 
     * group. DRGING for specify drug group.</p>
     * 
     * <p>Invoice Type is the indication to the payor as to the 
     * content rules to apply when processing and adjudicating the 
     * invoice. Basically, the structure of the invoice grouping. 
     * Ie. Clinical Product, Clinical Service, Preferred Accom, Rx 
     * Dispense, Rx Compound</p>
     * 
     * <p>This is used to indicate the type of Invoice 
     * Grouping.</p><p>Each Invoice Type is used to specify 1. 
     * vocabulary, 2. structure of the Invoice Element Choice and 
     * 3. which Billable Act(s) can be included for the specified 
     * Invoice Type.</p><p>Information on constraints for the 
     * Invoice Type will be found in the NeCST Message 
     * Specifications. Each Benefit Group will indicate which 
     * Invoice Types will be supported by that Benefit 
     * Group.</p><p>Invoice Types will not generate unique and 
     * distinct XML schemas that can tested independent of each 
     * other. They must be tested together within an Message 
     * Type.</p>
     * 
     * <p>Invoice Type e.g. Healthcare Services, Rx Dispense, Rx 
     * Compound, Healthcare Goods, Preferred Accomodation</p>
     * 
     * <p>Un-merged Business Name: InvoiceType</p>
     * 
     * <p>Relationship: FICR_MT610201CA.InvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>of Invoice Grouping.</p><p>Each Invoice Type is used to 
     * specify 1. vocabulary, 2. structure of the Invoice Element 
     * Choice and 3. which Billable Act(s) can be included for the 
     * specified Invoice Type.</p><p>Information on constraints for 
     * the Invoice Type will be found in the NeCST Message 
     * Specifications. Each Benefit Group will indicate which 
     * Invoice Types will be supported by that Benefit 
     * Group.</p><p>Invoice Types will not generate unique and 
     * distinct XML schemas that can tested independent of each 
     * other. They must be tested together within an Message 
     * Type.</p>
     * 
     * <p>RXDINV, RXCINV, CSINV, CPINV, CSPINV only for root 
     * invoice element group.</p><p>RxS1: RXDINV only for root 
     * invoice element group. DRGING for specify drug group.</p>
     * 
     * <p>Invoice Type is the indication to the payor as to the 
     * content rules to apply when processing and adjudicating the 
     * invoice. Basically, the structure of the invoice grouping. 
     * Ie. Clinical Product, Clinical Service, Preferred Accom, Rx 
     * Dispense, Rx Compound</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceGroupCode getCode() {
        return (ActInvoiceGroupCode) this.code.getValue();
    }

    /**
     * <p>Business Name: InvoiceType</p>
     * 
     * <p>Un-merged Business Name: InvoiceType</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>RXDINV, RXCINV, CSINV, CPINV, CSPINV only for root 
     * invoice element group. RXDINV only for root invoice element 
     * group. DRGING for specify drug group.</p>
     * 
     * <p>Invoice Type is the indication to the payor as to the 
     * content rules to apply when processing and adjudicating the 
     * invoice. Basically, the structure of the invoice grouping. 
     * Ie. Clinical Product, Clinical Service, Preferred Accom, Rx 
     * Dispense, Rx Compound</p>
     * 
     * <p>This is used to indicate the type of Invoice 
     * Grouping.</p><p>Each Invoice Type is used to specify 1. 
     * vocabulary, 2. structure of the Invoice Element Choice and 
     * 3. which Billable Act(s) can be included for the specified 
     * Invoice Type.</p><p>Information on constraints for the 
     * Invoice Type will be found in the NeCST Message 
     * Specifications. Each Benefit Group will indicate which 
     * Invoice Types will be supported by that Benefit 
     * Group.</p><p>Invoice Types will not generate unique and 
     * distinct XML schemas that can tested independent of each 
     * other. They must be tested together within an Message 
     * Type.</p>
     * 
     * <p>Invoice Type e.g. Healthcare Services, Rx Dispense, Rx 
     * Compound, Healthcare Goods, Preferred Accomodation</p>
     * 
     * <p>Un-merged Business Name: InvoiceType</p>
     * 
     * <p>Relationship: FICR_MT610201CA.InvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>of Invoice Grouping.</p><p>Each Invoice Type is used to 
     * specify 1. vocabulary, 2. structure of the Invoice Element 
     * Choice and 3. which Billable Act(s) can be included for the 
     * specified Invoice Type.</p><p>Information on constraints for 
     * the Invoice Type will be found in the NeCST Message 
     * Specifications. Each Benefit Group will indicate which 
     * Invoice Types will be supported by that Benefit 
     * Group.</p><p>Invoice Types will not generate unique and 
     * distinct XML schemas that can tested independent of each 
     * other. They must be tested together within an Message 
     * Type.</p>
     * 
     * <p>RXDINV, RXCINV, CSINV, CPINV, CSPINV only for root 
     * invoice element group.</p><p>RxS1: RXDINV only for root 
     * invoice element group. DRGING for specify drug group.</p>
     * 
     * <p>Invoice Type is the indication to the payor as to the 
     * content rules to apply when processing and adjudicating the 
     * invoice. Basically, the structure of the invoice grouping. 
     * Ie. Clinical Product, Clinical Service, Preferred Accom, Rx 
     * Dispense, Rx Compound</p>
     */
    public void setCode(ActInvoiceGroupCode code) {
        this.code.setValue(code);
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
     * 
     * <p>Transmission of this information suggests a transfer of 
     * liability for how this information/invoice is 
     * used/communicated.</p><p>Legislation and service level 
     * agreements typically cover the requirement to send this code 
     * with every invoice.</p><p>This will be required for Alberta 
     * physician invoices only.</p>
     * 
     * <p>This may be useful for nursing homes. For example, they 
     * get paid so much $ per patient per month and would need to 
     * specify the time period for the invoice.</p>
     * 
     * <p>The period of time that the invoice pertains to. This may 
     * be a specific date or a date range (as in the month of 
     * January) for the invoice.</p>
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
     * 
     * <p>Transmission of this information suggests a transfer of 
     * liability for how this information/invoice is 
     * used/communicated.</p><p>Legislation and service level 
     * agreements typically cover the requirement to send this code 
     * with every invoice.</p><p>This will be required for Alberta 
     * physician invoices only.</p>
     * 
     * <p>This may be useful for nursing homes. For example, they 
     * get paid so much $ per patient per month and would need to 
     * specify the time period for the invoice.</p>
     * 
     * <p>The period of time that the invoice pertains to. This may 
     * be a specific date or a date range (as in the month of 
     * January) for the invoice.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: InvoiceSubTotal</p>
     * 
     * <p>Un-merged Business Name: InvoiceSubTotal</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Cancel Request: This would serve as a cross-check for 
     * the Adjudicator for the Invoice Grouping that is being 
     * cancelled.</p><p>Attribute cannot be mandatory as it may not 
     * be present for a Coverage Extension Request.</p>
     * 
     * <p>For Coverage Extension Results: Some adjudicators will 
     * indicate a dollar amount allowed for the coverage 
     * extension.</p><p>RxS1: Sum of InvoiceElementDetail.netAmt 
     * for all immediate child invoice elements. The root invoice 
     * element group will be the transaction total (invoice 
     * total).</p>
     * 
     * <p>Identifies the total monetary amount billed for the 
     * invoice element. This is the sum of the Submitted Invoice 
     * Line amounts.</p>
     * 
     * <p>Un-merged Business Name: InvoiceSubTotal</p>
     * 
     * <p>Relationship: FICR_MT610201CA.InvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Cancel Request: This would serve as a cross-check for 
     * the Adjudicator for the Invoice Grouping that is being 
     * cancelled.</p><p>Attribute cannot be mandatory as it may not 
     * be present for a Coverage Extension Request.</p>
     * 
     * <p>For Coverage Extension Results: Some adjudicators will 
     * indicate a dollar amount allowed for the coverage 
     * extension.</p><p>RxS1: Sum of InvoiceElementDetail.netAmt 
     * for all immediate child invoice elements. The root invoice 
     * element group will be the transaction total (invoice 
     * total).</p>
     * 
     * <p>Identifies the total monetary amount billed for the 
     * invoice element. This is the sum of the Submitted Invoice 
     * Line amounts.</p>
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
     * <p>Relationship: FICR_MT600201CA.InvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Cancel Request: This would serve as a cross-check for 
     * the Adjudicator for the Invoice Grouping that is being 
     * cancelled.</p><p>Attribute cannot be mandatory as it may not 
     * be present for a Coverage Extension Request.</p>
     * 
     * <p>For Coverage Extension Results: Some adjudicators will 
     * indicate a dollar amount allowed for the coverage 
     * extension.</p><p>RxS1: Sum of InvoiceElementDetail.netAmt 
     * for all immediate child invoice elements. The root invoice 
     * element group will be the transaction total (invoice 
     * total).</p>
     * 
     * <p>Identifies the total monetary amount billed for the 
     * invoice element. This is the sum of the Submitted Invoice 
     * Line amounts.</p>
     * 
     * <p>Un-merged Business Name: InvoiceSubTotal</p>
     * 
     * <p>Relationship: FICR_MT610201CA.InvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Cancel Request: This would serve as a cross-check for 
     * the Adjudicator for the Invoice Grouping that is being 
     * cancelled.</p><p>Attribute cannot be mandatory as it may not 
     * be present for a Coverage Extension Request.</p>
     * 
     * <p>For Coverage Extension Results: Some adjudicators will 
     * indicate a dollar amount allowed for the coverage 
     * extension.</p><p>RxS1: Sum of InvoiceElementDetail.netAmt 
     * for all immediate child invoice elements. The root invoice 
     * element group will be the transaction total (invoice 
     * total).</p>
     * 
     * <p>Identifies the total monetary amount billed for the 
     * invoice element. This is the sum of the Submitted Invoice 
     * Line amounts.</p>
     */
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementGroupInFulfillmentOf.financialContract</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/financialContract"})
    public BusinessArrangementBean getInFulfillmentOfFinancialContract() {
        return this.inFulfillmentOfFinancialContract;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementGroupInFulfillmentOf.financialContract</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInFulfillmentOfFinancialContract(BusinessArrangementBean inFulfillmentOfFinancialContract) {
        this.inFulfillmentOfFinancialContract = inFulfillmentOfFinancialContract;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.Predecessor.invoiceElementCrossReference</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"predecessor/invoiceElementCrossReference"})
    public List<CrossReferenceIdentifierBean> getPredecessorInvoiceElementCrossReference() {
        return this.predecessorInvoiceElementCrossReference;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.Reference.adjudicatedInvoiceElementGroup</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
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
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"coverage/policyOrAccount"})
    public List<PolicyIdentifierBean> getCoveragePolicyOrAccount() {
        return this.coveragePolicyOrAccount;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementGroup.pertinentInformation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     */
    @Hl7XmlMapping({"pertinentInformation"})
    public List<AttachmentsBean> getPertinentInformation() {
        return this.pertinentInformation;
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
    public List<InvoiceComponentBean> getComponent() {
        return this.component;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementReason.billableActChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"reasonOf/billableActChoice"})
    public List<A_BillableActChoice> getReasonOfBillableActChoice() {
        return this.reasonOfBillableActChoice;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.Suggests.invoiceElementOverride</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"triggerFor/invoiceElementOverride"})
    public List<InvoiceOverrideDetailsBean> getTriggerForInvoiceElementOverride() {
        return this.triggerForInvoiceElementOverride;
    }

}
