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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.qucr_mt830201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActInvoiceGroupType;
import java.util.Date;



/**
 * <p>Business Name: Adjudication Result Identifier</p>
 * 
 * <p>May include data centre and sequence numbers</p>
 * 
 * <p>Adjudication Result Identifier</p>
 */
@Hl7PartTypeMapping({"QUCR_MT830201CA.AdjudicatedInvoiceElementGroup"})
public class AdjudicationResultIdentifierBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private MO netAmt = new MOImpl();
    private CS authorContextControlCode = new CSImpl();
    private TS authorTime = new TSImpl();
    private CV authorModeCode = new CVImpl();
    private II authorAdjudicatorRoleId = new IIImpl();
    private ResultOfAdjudicationBean outcomeOfAdjudicationResult;


    /**
     * <p>Business Name: Adjudication Result Identifier</p>
     * 
     * <p>Relationship: 
     * QUCR_MT830201CA.AdjudicatedInvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Technique to identify that the EOB was not electronic 
     * (manual) is through the participation mode code for the 
     * adjudicator.</p>
     * 
     * <p>May include data centre and sequence numbers</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Adjudication Result Identifier</p>
     * 
     * <p>Relationship: 
     * QUCR_MT830201CA.AdjudicatedInvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Technique to identify that the EOB was not electronic 
     * (manual) is through the participation mode code for the 
     * adjudicator.</p>
     * 
     * <p>May include data centre and sequence numbers</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: (Invoice Type</p>
     * 
     * <p>Relationship: 
     * QUCR_MT830201CA.AdjudicatedInvoiceElementGroup.code</p>
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
     * Compound, Healthcare Goods, Preferred Accomodation</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceGroupType getCode() {
        return (ActInvoiceGroupType) this.code.getValue();
    }

    /**
     * <p>Business Name: (Invoice Type</p>
     * 
     * <p>Relationship: 
     * QUCR_MT830201CA.AdjudicatedInvoiceElementGroup.code</p>
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
     * Compound, Healthcare Goods, Preferred Accomodation</p>
     */
    public void setCode(ActInvoiceGroupType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Paid Amount</p>
     * 
     * <p>Relationship: 
     * QUCR_MT830201CA.AdjudicatedInvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Coverage Extension Results, this is typically not 
     * specified, as dollar limits are noted as information 
     * codes.</p>
     * 
     * <p>Grand total of all SOFA observations contained in this 
     * summary</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }

    /**
     * <p>Business Name: Paid Amount</p>
     * 
     * <p>Relationship: 
     * QUCR_MT830201CA.AdjudicatedInvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Coverage Extension Results, this is typically not 
     * specified, as dollar limits are noted as information 
     * codes.</p>
     * 
     * <p>Grand total of all SOFA observations contained in this 
     * summary</p>
     */
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    /**
     * <p>Business Name: Context Control code</p>
     * 
     * <p>Relationship: 
     * QUCR_MT830201CA.AdjudicatedInvoiceAuthor.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"author/contextControlCode"})
    public ContextControl getAuthorContextControlCode() {
        return (ContextControl) this.authorContextControlCode.getValue();
    }

    /**
     * <p>Business Name: Context Control code</p>
     * 
     * <p>Relationship: 
     * QUCR_MT830201CA.AdjudicatedInvoiceAuthor.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setAuthorContextControlCode(ContextControl authorContextControlCode) {
        this.authorContextControlCode.setValue(authorContextControlCode);
    }


    /**
     * <p>Business Name: (Adjudication date/time</p>
     * 
     * <p>Relationship: 
     * QUCR_MT830201CA.AdjudicatedInvoiceAuthor.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used in Pharmacy for daily totals. For Invoice COB: Will 
     * only be value for electronic EOBs</p>
     * 
     * <p>Date and time of Adjudication</p>
     */
    @Hl7XmlMapping({"author/time"})
    public Date getAuthorTime() {
        return this.authorTime.getValue();
    }

    /**
     * <p>Business Name: (Adjudication date/time</p>
     * 
     * <p>Relationship: 
     * QUCR_MT830201CA.AdjudicatedInvoiceAuthor.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used in Pharmacy for daily totals. For Invoice COB: Will 
     * only be value for electronic EOBs</p>
     * 
     * <p>Date and time of Adjudication</p>
     */
    public void setAuthorTime(Date authorTime) {
        this.authorTime.setValue(authorTime);
    }


    /**
     * <p>Business Name: EOB Communication Method</p>
     * 
     * <p>Relationship: 
     * QUCR_MT830201CA.AdjudicatedInvoiceAuthor.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>For Invoice (COB): If Invoice submitted WRITTEN, then EOB 
     * must be adjudicated WRITTEN.</p><p>If Invoice submitted 
     * ELECTRONIC, then EOB can be ELECTRONIC (preferred) or 
     * WRITTEN.</p><p>For Adjudication Results: Must be ELECTRONIC 
     * only</p>
     * 
     * <p>EOB Communication Method</p>
     */
    @Hl7XmlMapping({"author/modeCode"})
    public ParticipationMode getAuthorModeCode() {
        return (ParticipationMode) this.authorModeCode.getValue();
    }

    /**
     * <p>Business Name: EOB Communication Method</p>
     * 
     * <p>Relationship: 
     * QUCR_MT830201CA.AdjudicatedInvoiceAuthor.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>For Invoice (COB): If Invoice submitted WRITTEN, then EOB 
     * must be adjudicated WRITTEN.</p><p>If Invoice submitted 
     * ELECTRONIC, then EOB can be ELECTRONIC (preferred) or 
     * WRITTEN.</p><p>For Adjudication Results: Must be ELECTRONIC 
     * only</p>
     * 
     * <p>EOB Communication Method</p>
     */
    public void setAuthorModeCode(ParticipationMode authorModeCode) {
        this.authorModeCode.setValue(authorModeCode);
    }


    /**
     * <p>Business Name: Adjudicator ID</p>
     * 
     * <p>Relationship: QUCR_MT830201CA.AdjudicatorRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Set of identifiers that uniquely identify the adjudicator 
     * of the invoice.</p>
     */
    @Hl7XmlMapping({"author/adjudicatorRole/id"})
    public Identifier getAuthorAdjudicatorRoleId() {
        return this.authorAdjudicatorRoleId.getValue();
    }

    /**
     * <p>Business Name: Adjudicator ID</p>
     * 
     * <p>Relationship: QUCR_MT830201CA.AdjudicatorRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Set of identifiers that uniquely identify the adjudicator 
     * of the invoice.</p>
     */
    public void setAuthorAdjudicatorRoleId(Identifier authorAdjudicatorRoleId) {
        this.authorAdjudicatorRoleId.setValue(authorAdjudicatorRoleId);
    }


    /**
     * <p>Relationship: 
     * QUCR_MT830201CA.AdjudicatedResultOutcome.adjudicationResult</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"outcomeOf/adjudicationResult"})
    public ResultOfAdjudicationBean getOutcomeOfAdjudicationResult() {
        return this.outcomeOfAdjudicationResult;
    }

    /**
     * <p>Relationship: 
     * QUCR_MT830201CA.AdjudicatedResultOutcome.adjudicationResult</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setOutcomeOfAdjudicationResult(ResultOfAdjudicationBean outcomeOfAdjudicationResult) {
        this.outcomeOfAdjudicationResult = outcomeOfAdjudicationResult;
    }

}
