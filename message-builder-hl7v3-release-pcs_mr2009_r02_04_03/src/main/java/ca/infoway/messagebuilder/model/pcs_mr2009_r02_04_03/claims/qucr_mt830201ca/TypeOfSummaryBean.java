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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.qucr_mt830201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActInvoiceAdjudicationPaymentSummaryType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Type of Summary</p>
 * 
 * <p>Detailed information required for financial 
 * reconciliation.</p>
 * 
 * <p>(Invoice Type e.g. Healthcare Services, Rx Dispense, Rx 
 * Compound, Healthcare Goods, Preferred Accomodation</p>
 */
@Hl7PartTypeMapping({"QUCR_MT830201CA.AdjudResultsGroup"})
@Hl7RootType
public class TypeOfSummaryBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private CD code = new CDImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private MO netAmt = new MOImpl();
    private List<AdjudicationResultIdentifierBean> referenceAdjudicatedInvoiceElementGroup = new ArrayList<AdjudicationResultIdentifierBean>();


    /**
     * <p>Business Name: Type of Summary</p>
     * 
     * <p>Relationship: QUCR_MT830201CA.AdjudResultsGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Payment Advice: Code also specifies the type of 
     * adjustment for a payment advice (e.g. CFWD - carry forward 
     * adjustment).</p>
     * 
     * <p>-For Payment Advice: For Vision Care payment advices, 
     * RETRO adjustments will always include references to the EOBs 
     * that made up the retroactive adjustment.</p><p>For Payment 
     * Advice: For Pharmacy payment advices, RETRO adjustments will 
     * not include references to the EOBs that made up the 
     * retroactive adjustment. Providers must submit a Payment 
     * Advice Query message to get the EOBs referenced by the RETRO 
     * amount. The Payment Advice Detail message, however, is not 
     * currently supported in Pharmacy.</p><p>For Payment Advice: 
     * Code also specifies the type of adjustment for a payment 
     * advice (e.g. CFWD - carry forward adjustment).</p>
     * 
     * <p>Codes representing a grouping of invoice elements 
     * (totals, sub-totals), reported through a Payment Advice or a 
     * Statement of Financial Activity (SOFA). The code can 
     * represent summaries by day, location, payee and other cost 
     * elements such as bonus, retroactive adjustment and 
     * transaction fees.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceAdjudicationPaymentSummaryType getCode() {
        return (ActInvoiceAdjudicationPaymentSummaryType) this.code.getValue();
    }

    /**
     * <p>Business Name: Type of Summary</p>
     * 
     * <p>Relationship: QUCR_MT830201CA.AdjudResultsGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Payment Advice: Code also specifies the type of 
     * adjustment for a payment advice (e.g. CFWD - carry forward 
     * adjustment).</p>
     * 
     * <p>-For Payment Advice: For Vision Care payment advices, 
     * RETRO adjustments will always include references to the EOBs 
     * that made up the retroactive adjustment.</p><p>For Payment 
     * Advice: For Pharmacy payment advices, RETRO adjustments will 
     * not include references to the EOBs that made up the 
     * retroactive adjustment. Providers must submit a Payment 
     * Advice Query message to get the EOBs referenced by the RETRO 
     * amount. The Payment Advice Detail message, however, is not 
     * currently supported in Pharmacy.</p><p>For Payment Advice: 
     * Code also specifies the type of adjustment for a payment 
     * advice (e.g. CFWD - carry forward adjustment).</p>
     * 
     * <p>Codes representing a grouping of invoice elements 
     * (totals, sub-totals), reported through a Payment Advice or a 
     * Statement of Financial Activity (SOFA). The code can 
     * represent summaries by day, location, payee and other cost 
     * elements such as bonus, retroactive adjustment and 
     * transaction fees.</p>
     */
    public void setCode(ActInvoiceAdjudicationPaymentSummaryType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Summary period date range</p>
     * 
     * <p>Relationship: 
     * QUCR_MT830201CA.AdjudResultsGroup.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Time period for the payment or summary period. Can also 
     * indicate time period over which the clawback and/or retro 
     * adjustment applies</p>
     * 
     * <p>For Payment Advice: Can also indicate time period over 
     * which the clawback and/or retro adjustment applies.</p>
     * 
     * <p>Summary period date range - Time period for the payment 
     * or summary period.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Summary period date range</p>
     * 
     * <p>Relationship: 
     * QUCR_MT830201CA.AdjudResultsGroup.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Time period for the payment or summary period. Can also 
     * indicate time period over which the clawback and/or retro 
     * adjustment applies</p>
     * 
     * <p>For Payment Advice: Can also indicate time period over 
     * which the clawback and/or retro adjustment applies.</p>
     * 
     * <p>Summary period date range - Time period for the payment 
     * or summary period.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Summary Period Amt</p>
     * 
     * <p>Relationship: QUCR_MT830201CA.AdjudResultsGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The AdjudResultsGroup.netAmt must equal the sum of all 
     * immediate children AdjudResultsGroup.netAmt</p>
     * 
     * <p>On SOFA Summary, this could be used to specify the amount 
     * that will be included in the Payment Advice. In this 
     * situation, it should equal the net effect of all 
     * AdjudResultsGroupSummaryData elements that would appear in 
     * the Payment Advice.</p>
     * 
     * <p>Summary Period Amt</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }

    /**
     * <p>Business Name: Summary Period Amt</p>
     * 
     * <p>Relationship: QUCR_MT830201CA.AdjudResultsGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The AdjudResultsGroup.netAmt must equal the sum of all 
     * immediate children AdjudResultsGroup.netAmt</p>
     * 
     * <p>On SOFA Summary, this could be used to specify the amount 
     * that will be included in the Payment Advice. In this 
     * situation, it should equal the net effect of all 
     * AdjudResultsGroupSummaryData elements that would appear in 
     * the Payment Advice.</p>
     * 
     * <p>Summary Period Amt</p>
     */
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    /**
     * <p>Relationship: 
     * QUCR_MT830201CA.AdjudResultsRef.adjudicatedInvoiceElementGroup</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"reference/adjudicatedInvoiceElementGroup"})
    public List<AdjudicationResultIdentifierBean> getReferenceAdjudicatedInvoiceElementGroup() {
        return this.referenceAdjudicatedInvoiceElementGroup;
    }

}
