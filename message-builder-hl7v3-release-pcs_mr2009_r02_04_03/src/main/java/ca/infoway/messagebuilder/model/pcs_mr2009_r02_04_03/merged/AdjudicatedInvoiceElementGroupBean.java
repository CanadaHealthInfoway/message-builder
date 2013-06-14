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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged.AdjudicatedResultsGroupBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged.PaymentIntentBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt680000ca.AdjudicatedInvoiceAuthorBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt680000ca.AdjudicatedInvoiceCoverageBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt680000ca.AdjudicatedInvoiceElementChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActInvoiceGroupType;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: AdjudicatedInvoiceElementGroup</p>
 * 
 * <p>FICR_MT630000CA.AdjudicatedInvoiceElementGroup: 
 * Adjudicated Invoice Element Group</p>
 * 
 * <p>Group of Invoice Elements being referenced; ie. group of 
 * billable items.</p>
 */
@Hl7PartTypeMapping({"COCT_MT680000CA.AdjudicatedInvoiceElementGroup","FICR_MT630000CA.AdjudicatedInvoiceElementGroup"})
@Hl7RootType
public class AdjudicatedInvoiceElementGroupBean extends MessagePartBean implements AdjudicatedInvoiceElementChoice {

    private static final long serialVersionUID = 20130614L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private CS statusCode = new CSImpl();
    private MO netAmt = new MOImpl();
    private PaymentIntentBean reasonPaymentIntent;
    private AdjudicatedInvoiceElementGroupBean referenceAdjudicatedInvoiceElementGroup;
    private AdjudicatedResultsGroupBean referencedByAdjudResultsGroup;
    private AdjudicatedInvoiceAuthorBean author;
    private List<AdjudicatedInvoiceCoverageBean> coverage = new ArrayList<AdjudicatedInvoiceCoverageBean>();
    private List<AdjudicatedInvoiceElementChoice> componentAdjudicatedInvoiceElementChoice = new ArrayList<AdjudicatedInvoiceElementChoice>();
    private AdjudicationResultBean outcomeOfAdjudicationResult;


    /**
     * <p>Business Name: AdjudicationResultId</p>
     * 
     * <p>Un-merged Business Name: AdjudicationResultId</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.AdjudicatedInvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>May include data centre and sequence numbers</p>
     * 
     * <p>Adjudication Result Id - Technique to identify that the 
     * EOB was not electronic (manual) is through the participation 
     * mode code for the adjudicator.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: AdjudicationResultId</p>
     * 
     * <p>Un-merged Business Name: AdjudicationResultId</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.AdjudicatedInvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>May include data centre and sequence numbers</p>
     * 
     * <p>Adjudication Result Id - Technique to identify that the 
     * EOB was not electronic (manual) is through the participation 
     * mode code for the adjudicator.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Un-merged Business Name: InvoiceType</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.AdjudicatedInvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Invoice (COB) : Invoice type (for root) cannot be 
     * different from submitted invoice. This would be a cause for 
     * rejecting the invoice.</p><p>For Adjudication Results: code 
     * must match to the corresponding invoice element that was 
     * submitted.</p><p>For Invoice Nullify Results: this is the 
     * identifier of the EOB that was previously messaged to the 
     * Provider.</p><p>Modifiers for the codes are taken from the 
     * same domain (i.e ActInvoiceGroupCode).</p>
     * 
     * <p>Invoice Type e.g. Healthcare Services, Rx Dispense, Rx 
     * Compound</p>
     * 
     * <p>Un-merged Business Name: InvoiceElementGroupCode</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicatedInvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>(Invoice Type e.g. Healthcare Services, Rx Dispense, Rx 
     * Compound, Healthcare Goods, Preferred Accomodation</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceGroupType getCode() {
        return (ActInvoiceGroupType) this.code.getValue();
    }

    /**
     * <p>Un-merged Business Name: InvoiceType</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.AdjudicatedInvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Invoice (COB) : Invoice type (for root) cannot be 
     * different from submitted invoice. This would be a cause for 
     * rejecting the invoice.</p><p>For Adjudication Results: code 
     * must match to the corresponding invoice element that was 
     * submitted.</p><p>For Invoice Nullify Results: this is the 
     * identifier of the EOB that was previously messaged to the 
     * Provider.</p><p>Modifiers for the codes are taken from the 
     * same domain (i.e ActInvoiceGroupCode).</p>
     * 
     * <p>Invoice Type e.g. Healthcare Services, Rx Dispense, Rx 
     * Compound</p>
     * 
     * <p>Un-merged Business Name: InvoiceElementGroupCode</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicatedInvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>(Invoice Type e.g. Healthcare Services, Rx Dispense, Rx 
     * Compound, Healthcare Goods, Preferred Accomodation</p>
     */
    public void setCode(ActInvoiceGroupType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: InvoiceStatus</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.AdjudicatedInvoiceElementGroup.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Active EOBs are used to convey interim or preliminary 
     * adjudication results. They can also be used, with 
     * information codes, to indicate that the invoice grouping is 
     * held for manual review by the adjudicator, waiting for other 
     * third party information (e.g. from another provider, 
     * employer, etc.).</p><p>Suspended EOBs are used to convey 
     * adjudication results that are awaiting additional 
     * information from the submitting Provider.</p><p>Complete 
     * EOBs are used to convey final adjudication results, with an 
     * associated intent to pay.</p><p>For Invoice (COB): Status 
     * code must be complete in order for EOB to be sent to 
     * downstream Adjudicators. If a Provider receives a 
     * non-complete EOB, this cannot be forwarded to a downstream 
     * Adjudicator.</p><p>Field cannot be made mandatory, as it is 
     * not included in Payment Advice Detail messages (only 
     * completed EOBs can be included in a Payment Advice).</p>
     * 
     * <p>Codes representing the defined states of an Act as 
     * defined by the Act class state machine.</p>
     * 
     * <p>Un-merged Business Name: InvoiceStatusCode</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicatedInvoiceElementGroup.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>(Completed when done, Suspended if waiting for external 
     * )(information, Active if delayed by Adjudicator or the EOB 
     * is an estimate</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: InvoiceStatus</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.AdjudicatedInvoiceElementGroup.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Active EOBs are used to convey interim or preliminary 
     * adjudication results. They can also be used, with 
     * information codes, to indicate that the invoice grouping is 
     * held for manual review by the adjudicator, waiting for other 
     * third party information (e.g. from another provider, 
     * employer, etc.).</p><p>Suspended EOBs are used to convey 
     * adjudication results that are awaiting additional 
     * information from the submitting Provider.</p><p>Complete 
     * EOBs are used to convey final adjudication results, with an 
     * associated intent to pay.</p><p>For Invoice (COB): Status 
     * code must be complete in order for EOB to be sent to 
     * downstream Adjudicators. If a Provider receives a 
     * non-complete EOB, this cannot be forwarded to a downstream 
     * Adjudicator.</p><p>Field cannot be made mandatory, as it is 
     * not included in Payment Advice Detail messages (only 
     * completed EOBs can be included in a Payment Advice).</p>
     * 
     * <p>Codes representing the defined states of an Act as 
     * defined by the Act class state machine.</p>
     * 
     * <p>Un-merged Business Name: InvoiceStatusCode</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicatedInvoiceElementGroup.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>(Completed when done, Suspended if waiting for external 
     * )(information, Active if delayed by Adjudicator or the EOB 
     * is an estimate</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Un-merged Business Name: PaidAmount</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.AdjudicatedInvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Coverage Extension Results, this is typically not 
     * specified, as dollar limits are noted as information 
     * codes</p>
     * 
     * <p>Paid Amount</p>
     * 
     * <p>Un-merged Business Name: InvoiceElementAmountBilled</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicatedInvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the total monetary amount billed for the 
     * invoice element. = unit_qty * unit_price_amt * factor_nbr * 
     * points_nbr. E.g. $150 CAD</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }

    /**
     * <p>Un-merged Business Name: PaidAmount</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.AdjudicatedInvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Coverage Extension Results, this is typically not 
     * specified, as dollar limits are noted as information 
     * codes</p>
     * 
     * <p>Paid Amount</p>
     * 
     * <p>Un-merged Business Name: InvoiceElementAmountBilled</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicatedInvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the total monetary amount billed for the 
     * invoice element. = unit_qty * unit_price_amt * factor_nbr * 
     * points_nbr. E.g. $150 CAD</p>
     */
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.PaymentIntentReason.paymentIntent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"reason/paymentIntent"})
    public PaymentIntentBean getReasonPaymentIntent() {
        return this.reasonPaymentIntent;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.PaymentIntentReason.paymentIntent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setReasonPaymentIntent(PaymentIntentBean reasonPaymentIntent) {
        this.reasonPaymentIntent = reasonPaymentIntent;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.Reference.adjudicatedInvoiceElementGroup</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"reference/adjudicatedInvoiceElementGroup"})
    public AdjudicatedInvoiceElementGroupBean getReferenceAdjudicatedInvoiceElementGroup() {
        return this.referenceAdjudicatedInvoiceElementGroup;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.Reference.adjudicatedInvoiceElementGroup</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setReferenceAdjudicatedInvoiceElementGroup(AdjudicatedInvoiceElementGroupBean referenceAdjudicatedInvoiceElementGroup) {
        this.referenceAdjudicatedInvoiceElementGroup = referenceAdjudicatedInvoiceElementGroup;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.AdjudResultsRef.adjudResultsGroup</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"referencedBy/adjudResultsGroup"})
    public AdjudicatedResultsGroupBean getReferencedByAdjudResultsGroup() {
        return this.referencedByAdjudResultsGroup;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.AdjudResultsRef.adjudResultsGroup</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setReferencedByAdjudResultsGroup(AdjudicatedResultsGroupBean referencedByAdjudResultsGroup) {
        this.referencedByAdjudResultsGroup = referencedByAdjudResultsGroup;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicatedInvoiceElementGroup.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public AdjudicatedInvoiceAuthorBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicatedInvoiceElementGroup.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(AdjudicatedInvoiceAuthorBean author) {
        this.author = author;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicatedInvoiceElementGroup.coverage</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-10)</p>
     */
    @Hl7XmlMapping({"coverage"})
    public List<AdjudicatedInvoiceCoverageBean> getCoverage() {
        return this.coverage;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicatedInvoiceElementComponent.adjudicatedInvoiceElementChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component/adjudicatedInvoiceElementChoice"})
    public List<AdjudicatedInvoiceElementChoice> getComponentAdjudicatedInvoiceElementChoice() {
        return this.componentAdjudicatedInvoiceElementChoice;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicatedResultOutcome.adjudicationResult</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"outcomeOf/adjudicationResult"})
    public AdjudicationResultBean getOutcomeOfAdjudicationResult() {
        return this.outcomeOfAdjudicationResult;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicatedResultOutcome.adjudicationResult</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setOutcomeOfAdjudicationResult(AdjudicationResultBean outcomeOfAdjudicationResult) {
        this.outcomeOfAdjudicationResult = outcomeOfAdjudicationResult;
    }

}
