/**
 * Copyright 2013 Canada Health, Inc.
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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged.AdjudicatedInvoiceElementGroupBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged.AdjudicatedResultsGroupBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged.AdjudicationCodeChoice;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.domainvalue.ActInvoiceGroupCode;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Adjudicated Invoice</p>
 * 
 * <p>For the root AdjududicatedInvoiceElementGroup, the 
 * Coverage, Author and OutcomeOf relationships are 
 * Mandatory.</p>
 * 
 * <p>All Relationships to the AdjudicatedInvoiceElementGroup 
 * can only be associated with the root level instance</p>
 * 
 * <p>Grouping of invoice elements or line items.</p>
 */
@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatedInvoiceElementGroup"})
public class AdjudicatedInvoiceBean extends MessagePartBean implements AdjudicatedInvoiceElementChoice {

    private static final long serialVersionUID = 20130613L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private CS statusCode = new CSImpl();
    private MO netAmt = new MOImpl();
    private AdjudicatorBean author;
    private AdjudicatedInvoiceBean predecessorAdjudicatedInvoiceElementGroup;
    private List<AdjudicatedInvoiceElementGroupBean> referenceAdjudicatedInvoiceElementGroup = new ArrayList<AdjudicatedInvoiceElementGroupBean>();
    private MO reference1AllowableNetAmt = new MOImpl();
    private List<AdjudicatedInvoiceCoverageBean> coverage = new ArrayList<AdjudicatedInvoiceCoverageBean>();
    private List<AdjudicatedInvoiceElementChoice> componentAdjudicatedInvoiceElementChoice = new ArrayList<AdjudicatedInvoiceElementChoice>();
    private AdjudicationCodeChoice outcomeOfAdjudicationCodeChoice;
    private AdjudicatedResultsGroupBean referencedByAdjudResultsGroup;


    /**
     * <p>Business Name: Adjudicated Results Identifier</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Technique to identify that the EOB was not electronic 
     * (manual) is through the participation mode code for the 
     * adjudicator.</p>
     * 
     * <p>Technique to identify that the EOB was not electronic 
     * (manual) is through the participation mode code for the 
     * adjudicator.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Adjudicated Results Identifier</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Technique to identify that the EOB was not electronic 
     * (manual) is through the participation mode code for the 
     * adjudicator.</p>
     * 
     * <p>Technique to identify that the EOB was not electronic 
     * (manual) is through the participation mode code for the 
     * adjudicator.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Invoice Type</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>RXDINV, RXCINV, CSINV, CPINV only.</p>
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
     * Compound, Healthcare Goods, Preferred Accomodation</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceGroupCode getCode() {
        return (ActInvoiceGroupCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Invoice Type</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>RXDINV, RXCINV, CSINV, CPINV only.</p>
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
     * Compound, Healthcare Goods, Preferred Accomodation</p>
     */
    public void setCode(ActInvoiceGroupCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Status of the Adjudicated Invoice</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementGroup.statusCode</p>
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
     * associated intent to pay.</p>
     * 
     * <p>For Pharmacy dispense Invoices &amp; Pre-Determinations 
     * (RXDINV, RXCINV), only completed EOBs are permitted to 
     * facilitate real-time processing.</p><p>For Pharmacy clinical 
     * product (CPINV) and clinical service (CSINV) Invoices &amp; 
     * Pre-Determinations, status may be active, suspended or 
     * complete.</p><p>For all Coverage Extension Requests, status 
     * may be active, suspended or complete. For Invoice (COB): 
     * Status code must be complete in order for EOB to be sent to 
     * downstream Adjudicators. If a Provider receives a 
     * non-complete EOB, this cannot be forwarded to a downstream 
     * Adjudicator.</p><p>Field cannot be made mandatory, as it is 
     * not included in Payment Advice Detail messages (only 
     * completed EOBs can be included in a Payment Advice).</p>
     * 
     * <p>Status of the Adjudicated Invoice</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Status of the Adjudicated Invoice</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementGroup.statusCode</p>
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
     * associated intent to pay.</p>
     * 
     * <p>For Pharmacy dispense Invoices &amp; Pre-Determinations 
     * (RXDINV, RXCINV), only completed EOBs are permitted to 
     * facilitate real-time processing.</p><p>For Pharmacy clinical 
     * product (CPINV) and clinical service (CSINV) Invoices &amp; 
     * Pre-Determinations, status may be active, suspended or 
     * complete.</p><p>For all Coverage Extension Requests, status 
     * may be active, suspended or complete. For Invoice (COB): 
     * Status code must be complete in order for EOB to be sent to 
     * downstream Adjudicators. If a Provider receives a 
     * non-complete EOB, this cannot be forwarded to a downstream 
     * Adjudicator.</p><p>Field cannot be made mandatory, as it is 
     * not included in Payment Advice Detail messages (only 
     * completed EOBs can be included in a Payment Advice).</p>
     * 
     * <p>Status of the Adjudicated Invoice</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: Paid Amount</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Coverage Extension Results, this is typically not 
     * specified, as dollar limits are noted as information 
     * codes.</p>
     * 
     * <p>Paid Amount</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }

    /**
     * <p>Business Name: Paid Amount</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Coverage Extension Results, this is typically not 
     * specified, as dollar limits are noted as information 
     * codes.</p>
     * 
     * <p>Paid Amount</p>
     */
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementGroup.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"author"})
    public AdjudicatorBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementGroup.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAuthor(AdjudicatorBean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoicePredecessor.adjudicatedInvoiceElementGroup</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"predecessor/adjudicatedInvoiceElementGroup"})
    public AdjudicatedInvoiceBean getPredecessorAdjudicatedInvoiceElementGroup() {
        return this.predecessorAdjudicatedInvoiceElementGroup;
    }

    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoicePredecessor.adjudicatedInvoiceElementGroup</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPredecessorAdjudicatedInvoiceElementGroup(AdjudicatedInvoiceBean predecessorAdjudicatedInvoiceElementGroup) {
        this.predecessorAdjudicatedInvoiceElementGroup = predecessorAdjudicatedInvoiceElementGroup;
    }


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.Reference2.adjudicatedInvoiceElementGroup</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"reference/adjudicatedInvoiceElementGroup"})
    public List<AdjudicatedInvoiceElementGroupBean> getReferenceAdjudicatedInvoiceElementGroup() {
        return this.referenceAdjudicatedInvoiceElementGroup;
    }


    /**
     * <p>Relationship: FICR_MT610201CA.Allowable.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allowable or eligibile amount, as per fee schedule</p>
     */
    @Hl7XmlMapping({"reference1/allowable/netAmt"})
    public Money getReference1AllowableNetAmt() {
        return this.reference1AllowableNetAmt.getValue();
    }

    /**
     * <p>Relationship: FICR_MT610201CA.Allowable.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allowable or eligibile amount, as per fee schedule</p>
     */
    public void setReference1AllowableNetAmt(Money reference1AllowableNetAmt) {
        this.reference1AllowableNetAmt.setValue(reference1AllowableNetAmt);
    }


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementGroup.coverage</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     */
    @Hl7XmlMapping({"coverage"})
    public List<AdjudicatedInvoiceCoverageBean> getCoverage() {
        return this.coverage;
    }


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementComponent.adjudicatedInvoiceElementChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component/adjudicatedInvoiceElementChoice"})
    public List<AdjudicatedInvoiceElementChoice> getComponentAdjudicatedInvoiceElementChoice() {
        return this.componentAdjudicatedInvoiceElementChoice;
    }


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedResultOutcome.adjudicationCodeChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"outcomeOf/adjudicationCodeChoice"})
    public AdjudicationCodeChoice getOutcomeOfAdjudicationCodeChoice() {
        return this.outcomeOfAdjudicationCodeChoice;
    }

    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedResultOutcome.adjudicationCodeChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setOutcomeOfAdjudicationCodeChoice(AdjudicationCodeChoice outcomeOfAdjudicationCodeChoice) {
        this.outcomeOfAdjudicationCodeChoice = outcomeOfAdjudicationCodeChoice;
    }

    public AdjudicationResultReasonBean getOutcomeOfAdjudicationCodeChoiceAsAdjudicationResultReason() {
        return this.outcomeOfAdjudicationCodeChoice instanceof AdjudicationResultReasonBean ? (AdjudicationResultReasonBean) this.outcomeOfAdjudicationCodeChoice : null;
    }
    public boolean hasOutcomeOfAdjudicationCodeChoiceAsAdjudicationResultReason() {
        return (this.outcomeOfAdjudicationCodeChoice instanceof AdjudicationResultReasonBean);
    }

    public AdjudicationResultsInformationBean getOutcomeOfAdjudicationCodeChoiceAsAdjudicationResultInformation() {
        return this.outcomeOfAdjudicationCodeChoice instanceof AdjudicationResultsInformationBean ? (AdjudicationResultsInformationBean) this.outcomeOfAdjudicationCodeChoice : null;
    }
    public boolean hasOutcomeOfAdjudicationCodeChoiceAsAdjudicationResultInformation() {
        return (this.outcomeOfAdjudicationCodeChoice instanceof AdjudicationResultsInformationBean);
    }


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudResultsRef.adjudResultsGroup</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"referencedBy/adjudResultsGroup"})
    public AdjudicatedResultsGroupBean getReferencedByAdjudResultsGroup() {
        return this.referencedByAdjudResultsGroup;
    }

    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudResultsRef.adjudResultsGroup</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setReferencedByAdjudResultsGroup(AdjudicatedResultsGroupBean referencedByAdjudResultsGroup) {
        this.referencedByAdjudResultsGroup = referencedByAdjudResultsGroup;
    }

}
