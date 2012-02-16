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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt610201ca.AdjudicatedInvoiceCoverageBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt610201ca.AllowableBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt610201ca.ComponentInvoiceElementBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.qucr_mt830201ca.AdjudicatedResultOutcomeBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>FICR_MT610201CA.AdjudicatedInvoiceElementGroup: 
 * Adjudicated Invoice</p>
 * 
 * <p><p>For the root AdjududicatedInvoiceElementGroup, the 
 * Coverage, Author and OutcomeOf relationships are 
 * Mandatory.</p><p>All Relationships to the 
 * AdjudicatedInvoiceElementGroup can only be associated with 
 * the root level instance</p></p>
 * 
 * <p><p>For the root AdjududicatedInvoiceElementGroup, the 
 * Coverage, Author and OutcomeOf relationships are 
 * Mandatory.</p><p>All Relationships to the 
 * AdjudicatedInvoiceElementGroup can only be associated with 
 * the root level instance</p></p>
 * 
 * <p><p>A.K.A. the result.</p></p>
 * 
 * <p>QUCR_MT830201CA.AdjudicatedInvoiceElementGroup: 
 * Adjudication Result Identifier</p>
 * 
 * <p><p>Adjudication Result Identifier</p></p>
 * 
 * <p><p>May include data centre and sequence numbers</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatedInvoiceElementGroup","QUCR_MT830201CA.AdjudicatedInvoiceElementGroup"})
public class AdjudicationResultIdentifierBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt610201ca.AdjudicatedInvoiceElementChoice {

    private static final long serialVersionUID = 20120215L;
    private AllowableBean reference1Allowable;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private CS statusCode = new CSImpl();
    private MO netAmt = new MOImpl();
    private AdjudicatorBean author;
    private AdjudicationResultIdentifierBean predecessorAdjudicatedInvoiceElementGroup;
    private List<AdjudicatedInvoiceElementGroupBean> referenceAdjudicatedInvoiceElementGroup = new ArrayList<AdjudicatedInvoiceElementGroupBean>();
    private List<AdjudicatedInvoiceCoverageBean> coverage = new ArrayList<AdjudicatedInvoiceCoverageBean>();
    private List<ComponentInvoiceElementBean> component = new ArrayList<ComponentInvoiceElementBean>();
    private AdjudicatedResultsGroupBean referencedByAdjudResultsGroup;
    private AdjudicatedResultOutcomeBean outcomeOf;


    @Hl7XmlMapping({"reference1/allowable"})
    public AllowableBean getReference1Allowable() {
        return this.reference1Allowable;
    }
    public void setReference1Allowable(AllowableBean reference1Allowable) {
        this.reference1Allowable = reference1Allowable;
    }


    /**
     * <p>AdjudicatedResultsIdentifier</p>
     * 
     * <p>(no business name)</p>
     * 
     * <p><p>May include data centre and sequence numbers</p></p>
     * 
     * <p><p>Technique to identify that the EOB was not electronic 
     * (manual) is through the participation mode code for the 
     * adjudicator.</p></p>
     * 
     * <p>Adjudicated Results Identifier</p>
     * 
     * <p><p>Technique to identify that the EOB was not electronic 
     * (manual) is through the participation mode code for the 
     * adjudicator.</p></p>
     * 
     * <p><p>Technique to identify that the EOB was not electronic 
     * (manual) is through the participation mode code for the 
     * adjudicator.</p></p>
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
     * <p>(Invoice Type</p>
     * 
     * <p><p>Invoice Type e.g. Healthcare Services, Rx Dispense, Rx 
     * Compound, Healthcare Goods, Preferred Accomodation</p></p>
     * 
     * <p><p>For Invoice (COB) : Invoice type (for root) cannot be 
     * different from submitted invoice. This would be a cause for 
     * rejecting the invoice.</p><p>For Adjudication Results: code 
     * must match to the corresponding invoice element that was 
     * submitted.</p><p>For Invoice Nullify Results: this is the 
     * identifier of the EOB that was previously messaged to the 
     * Provider.</p><p>Modifiers for the codes are taken from the 
     * same domain (i.e ActInvoiceGroupCode).</p></p>
     * 
     * <p><p>For Invoice (COB) : Invoice type (for root) cannot be 
     * different from submitted invoice. This would be a cause for 
     * rejecting the invoice.</p><p>For Adjudication Results: code 
     * must match to the corresponding invoice element that was 
     * submitted.</p><p>For Invoice Nullify Results: this is the 
     * identifier of the EOB that was previously messaged to the 
     * Provider.</p><p>Modifiers for the codes are taken from the 
     * same domain (i.e ActInvoiceGroupCode).</p></p>
     * 
     * <p><p>For Invoice (COB) : Invoice type (for root) cannot be 
     * different from submitted invoice. This would be a cause for 
     * rejecting the invoice.</p><p>For Adjudication Results: code 
     * must match to the corresponding invoice element that was 
     * submitted.</p><p>For Invoice Nullify Results: this is the 
     * identifier of the EOB that was previously messaged to the 
     * Provider.</p><p>Modifiers for the codes are taken from the 
     * same domain (i.e ActInvoiceGroupCode).</p></p>
     * 
     * <p><p>For Invoice (COB) : Invoice type (for root) cannot be 
     * different from submitted invoice. This would be a cause for 
     * rejecting the invoice.</p><p>For Adjudication Results: code 
     * must match to the corresponding invoice element that was 
     * submitted.</p><p>For Invoice Nullify Results: this is the 
     * identifier of the EOB that was previously messaged to the 
     * Provider.</p><p>Modifiers for the codes are taken from the 
     * same domain (i.e ActInvoiceGroupCode).</p></p>
     * 
     * <p>Invoice Type</p>
     * 
     * <p><p>Invoice Type e.g. Healthcare Services, Rx Dispense, Rx 
     * Compound, Healthcare Goods, Preferred Accomodation</p></p>
     * 
     * <p><p>RXDINV, RXCINV, CSINV, CPINV only.</p></p>
     * 
     * <p><p>For Invoice (COB) : Invoice type (for root) cannot be 
     * different from submitted invoice. This would be a cause for 
     * rejecting the invoice.</p><p>For Adjudication Results: code 
     * must match to the corresponding invoice element that was 
     * submitted.</p><p>For Invoice Nullify Results: this is the 
     * identifier of the EOB that was previously messaged to the 
     * Provider.</p><p>Modifiers for the codes are taken from the 
     * same domain (i.e ActInvoiceGroupCode).</p></p>
     * 
     * <p><p>For Invoice (COB) : Invoice type (for root) cannot be 
     * different from submitted invoice. This would be a cause for 
     * rejecting the invoice.</p><p>For Adjudication Results: code 
     * must match to the corresponding invoice element that was 
     * submitted.</p><p>For Invoice Nullify Results: this is the 
     * identifier of the EOB that was previously messaged to the 
     * Provider.</p><p>Modifiers for the codes are taken from the 
     * same domain (i.e ActInvoiceGroupCode).</p></p>
     * 
     * <p><p>For Invoice (COB) : Invoice type (for root) cannot be 
     * different from submitted invoice. This would be a cause for 
     * rejecting the invoice.</p><p>For Adjudication Results: code 
     * must match to the corresponding invoice element that was 
     * submitted.</p><p>For Invoice Nullify Results: this is the 
     * identifier of the EOB that was previously messaged to the 
     * Provider.</p><p>Modifiers for the codes are taken from the 
     * same domain (i.e ActInvoiceGroupCode).</p></p>
     * 
     * <p><p>For Invoice (COB) : Invoice type (for root) cannot be 
     * different from submitted invoice. This would be a cause for 
     * rejecting the invoice.</p><p>For Adjudication Results: code 
     * must match to the corresponding invoice element that was 
     * submitted.</p><p>For Invoice Nullify Results: this is the 
     * identifier of the EOB that was previously messaged to the 
     * Provider.</p><p>Modifiers for the codes are taken from the 
     * same domain (i.e ActInvoiceGroupCode).</p></p>
     * 
     * <p><p>For Invoice (COB) : Invoice type (for root) cannot be 
     * different from submitted invoice. This would be a cause for 
     * rejecting the invoice.</p><p>For Adjudication Results: code 
     * must match to the corresponding invoice element that was 
     * submitted.</p><p>For Invoice Nullify Results: this is the 
     * identifier of the EOB that was previously messaged to the 
     * Provider.</p><p>Modifiers for the codes are taken from the 
     * same domain (i.e ActInvoiceGroupCode).</p></p>
     * 
     * <p><p>For Invoice (COB) : Invoice type (for root) cannot be 
     * different from submitted invoice. This would be a cause for 
     * rejecting the invoice.</p><p>For Adjudication Results: code 
     * must match to the corresponding invoice element that was 
     * submitted.</p><p>For Invoice Nullify Results: this is the 
     * identifier of the EOB that was previously messaged to the 
     * Provider.</p><p>Modifiers for the codes are taken from the 
     * same domain (i.e ActInvoiceGroupCode).</p></p>
     * 
     * <p><p>For Invoice (COB) : Invoice type (for root) cannot be 
     * different from submitted invoice. This would be a cause for 
     * rejecting the invoice.</p><p>For Adjudication Results: code 
     * must match to the corresponding invoice element that was 
     * submitted.</p><p>For Invoice Nullify Results: this is the 
     * identifier of the EOB that was previously messaged to the 
     * Provider.</p><p>Modifiers for the codes are taken from the 
     * same domain (i.e ActInvoiceGroupCode).</p></p>
     * 
     * <p><p>For Invoice (COB) : Invoice type (for root) cannot be 
     * different from submitted invoice. This would be a cause for 
     * rejecting the invoice.</p><p>For Adjudication Results: code 
     * must match to the corresponding invoice element that was 
     * submitted.</p><p>For Invoice Nullify Results: this is the 
     * identifier of the EOB that was previously messaged to the 
     * Provider.</p><p>Modifiers for the codes are taken from the 
     * same domain (i.e ActInvoiceGroupCode).</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>StatusOfTheAdjudicatedInvoice</p>
     * 
     * <p>Status of the Adjudicated Invoice</p>
     * 
     * <p><p>Status of the Adjudicated Invoice</p></p>
     * 
     * <p><p>Active EOBs are used to convey interim or preliminary 
     * adjudication results. They can also be used, with 
     * information codes, to indicate that the invoice grouping is 
     * held for manual review by the adjudicator, waiting for other 
     * third party information (e.g. from another provider, 
     * employer, etc.).</p><p>Suspended EOBs are used to convey 
     * adjudication results that are awaiting additional 
     * information from the submitting Provider.</p><p>Complete 
     * EOBs are used to convey final adjudication results, with an 
     * associated intent to pay.</p></p>
     * 
     * <p><p>Active EOBs are used to convey interim or preliminary 
     * adjudication results. They can also be used, with 
     * information codes, to indicate that the invoice grouping is 
     * held for manual review by the adjudicator, waiting for other 
     * third party information (e.g. from another provider, 
     * employer, etc.).</p><p>Suspended EOBs are used to convey 
     * adjudication results that are awaiting additional 
     * information from the submitting Provider.</p><p>Complete 
     * EOBs are used to convey final adjudication results, with an 
     * associated intent to pay.</p></p>
     * 
     * <p><p>Active EOBs are used to convey interim or preliminary 
     * adjudication results. They can also be used, with 
     * information codes, to indicate that the invoice grouping is 
     * held for manual review by the adjudicator, waiting for other 
     * third party information (e.g. from another provider, 
     * employer, etc.).</p><p>Suspended EOBs are used to convey 
     * adjudication results that are awaiting additional 
     * information from the submitting Provider.</p><p>Complete 
     * EOBs are used to convey final adjudication results, with an 
     * associated intent to pay.</p></p>
     * 
     * <p><p>For Pharmacy dispense Invoices &amp; 
     * Pre-Determinations (RXDINV, RXCINV), only completed EOBs are 
     * permitted to facilitate real-time processing.</p><p>For 
     * Pharmacy clinical product (CPINV) and clinical service 
     * (CSINV) Invoices &amp; Pre-Determinations, status may be 
     * active, suspended or complete.</p><p>For all Coverage 
     * Extension Requests, status may be active, suspended or 
     * complete. For Invoice (COB): Status code must be complete in 
     * order for EOB to be sent to downstream Adjudicators. If a 
     * Provider receives a non-complete EOB, this cannot be 
     * forwarded to a downstream Adjudicator.</p><p>Field cannot be 
     * made mandatory, as it is not included in Payment Advice 
     * Detail messages (only completed EOBs can be included in a 
     * Payment Advice).</p></p>
     * 
     * <p><p>For Pharmacy dispense Invoices &amp; 
     * Pre-Determinations (RXDINV, RXCINV), only completed EOBs are 
     * permitted to facilitate real-time processing.</p><p>For 
     * Pharmacy clinical product (CPINV) and clinical service 
     * (CSINV) Invoices &amp; Pre-Determinations, status may be 
     * active, suspended or complete.</p><p>For all Coverage 
     * Extension Requests, status may be active, suspended or 
     * complete. For Invoice (COB): Status code must be complete in 
     * order for EOB to be sent to downstream Adjudicators. If a 
     * Provider receives a non-complete EOB, this cannot be 
     * forwarded to a downstream Adjudicator.</p><p>Field cannot be 
     * made mandatory, as it is not included in Payment Advice 
     * Detail messages (only completed EOBs can be included in a 
     * Payment Advice).</p></p>
     * 
     * <p><p>For Pharmacy dispense Invoices &amp; 
     * Pre-Determinations (RXDINV, RXCINV), only completed EOBs are 
     * permitted to facilitate real-time processing.</p><p>For 
     * Pharmacy clinical product (CPINV) and clinical service 
     * (CSINV) Invoices &amp; Pre-Determinations, status may be 
     * active, suspended or complete.</p><p>For all Coverage 
     * Extension Requests, status may be active, suspended or 
     * complete. For Invoice (COB): Status code must be complete in 
     * order for EOB to be sent to downstream Adjudicators. If a 
     * Provider receives a non-complete EOB, this cannot be 
     * forwarded to a downstream Adjudicator.</p><p>Field cannot be 
     * made mandatory, as it is not included in Payment Advice 
     * Detail messages (only completed EOBs can be included in a 
     * Payment Advice).</p></p>
     * 
     * <p><p>For Pharmacy dispense Invoices &amp; 
     * Pre-Determinations (RXDINV, RXCINV), only completed EOBs are 
     * permitted to facilitate real-time processing.</p><p>For 
     * Pharmacy clinical product (CPINV) and clinical service 
     * (CSINV) Invoices &amp; Pre-Determinations, status may be 
     * active, suspended or complete.</p><p>For all Coverage 
     * Extension Requests, status may be active, suspended or 
     * complete. For Invoice (COB): Status code must be complete in 
     * order for EOB to be sent to downstream Adjudicators. If a 
     * Provider receives a non-complete EOB, this cannot be 
     * forwarded to a downstream Adjudicator.</p><p>Field cannot be 
     * made mandatory, as it is not included in Payment Advice 
     * Detail messages (only completed EOBs can be included in a 
     * Payment Advice).</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>PaidAmount</p>
     * 
     * <p>Paid Amount</p>
     * 
     * <p><p>Paid Amount</p></p>
     * 
     * <p><p>For Coverage Extension Results, this is typically not 
     * specified, as dollar limits are noted as information 
     * codes.</p></p>
     * 
     * <p>Paid Amount</p>
     * 
     * <p><p>Grand total of all SOFA observations contained in this 
     * summary</p></p>
     * 
     * <p><p>For Coverage Extension Results, this is typically not 
     * specified, as dollar limits are noted as information 
     * codes.</p></p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    @Hl7XmlMapping({"author"})
    public AdjudicatorBean getAuthor() {
        return this.author;
    }
    public void setAuthor(AdjudicatorBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"predecessor/adjudicatedInvoiceElementGroup"})
    public AdjudicationResultIdentifierBean getPredecessorAdjudicatedInvoiceElementGroup() {
        return this.predecessorAdjudicatedInvoiceElementGroup;
    }
    public void setPredecessorAdjudicatedInvoiceElementGroup(AdjudicationResultIdentifierBean predecessorAdjudicatedInvoiceElementGroup) {
        this.predecessorAdjudicatedInvoiceElementGroup = predecessorAdjudicatedInvoiceElementGroup;
    }


    @Hl7XmlMapping({"reference/adjudicatedInvoiceElementGroup"})
    public List<AdjudicatedInvoiceElementGroupBean> getReferenceAdjudicatedInvoiceElementGroup() {
        return this.referenceAdjudicatedInvoiceElementGroup;
    }


    @Hl7XmlMapping({"coverage"})
    public List<AdjudicatedInvoiceCoverageBean> getCoverage() {
        return this.coverage;
    }


    @Hl7XmlMapping({"component"})
    public List<ComponentInvoiceElementBean> getComponent() {
        return this.component;
    }


    @Hl7XmlMapping({"referencedBy/adjudResultsGroup"})
    public AdjudicatedResultsGroupBean getReferencedByAdjudResultsGroup() {
        return this.referencedByAdjudResultsGroup;
    }
    public void setReferencedByAdjudResultsGroup(AdjudicatedResultsGroupBean referencedByAdjudResultsGroup) {
        this.referencedByAdjudResultsGroup = referencedByAdjudResultsGroup;
    }


    @Hl7XmlMapping({"outcomeOf"})
    public AdjudicatedResultOutcomeBean getOutcomeOf() {
        return this.outcomeOf;
    }
    public void setOutcomeOf(AdjudicatedResultOutcomeBean outcomeOf) {
        this.outcomeOf = outcomeOf;
    }

}
