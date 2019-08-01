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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.ActInvoiceAdjudicationPaymentSummaryType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: AdjudicatedResultsGroup</p>
 * 
 * <p>FICR_MT630000CA.AdjudResultsGroup: Adjudicated Results 
 * Group</p>
 * 
 * <p>Payor must be specified for the root Act ONLY. Payee is 
 * optional, but may only be specified for the root Act.</p>
 * 
 * <p>Group of results for line items/invoice elements 
 * previously adjudicated.</p>
 */
@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudResultsGroup","FICR_MT630000CA.AdjudResultsGroup"})
public class AdjudicatedResultsGroupBean extends MessagePartBean {

    private static final long serialVersionUID = 20190730L;
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private MO netAmt = new MOImpl();
    private List<SummaryDetailsBean> summaryAdjudResultsGroupSummaryData = new ArrayList<SummaryDetailsBean>();
    private II id = new IIImpl();


    /**
     * <p>Un-merged Business Name: BreakdownOfFinancialActivity</p>
     * 
     * <p>Relationship: FICR_MT630000CA.AdjudResultsGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Payment Advice: For Vision Care payment advices, 
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
     * <p>This code describes the breakdown of the financial 
     * activity and defines the 'categorization; Only really 
     * relevant for summaries.</p>
     * 
     * <p>Un-merged Business Name: TypeOfSummary</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudResultsGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceAdjudicationPaymentSummaryType getCode() {
        return (ActInvoiceAdjudicationPaymentSummaryType) this.code.getValue();
    }

    /**
     * <p>Un-merged Business Name: BreakdownOfFinancialActivity</p>
     * 
     * <p>Relationship: FICR_MT630000CA.AdjudResultsGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Payment Advice: For Vision Care payment advices, 
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
     * <p>This code describes the breakdown of the financial 
     * activity and defines the 'categorization; Only really 
     * relevant for summaries.</p>
     * 
     * <p>Un-merged Business Name: TypeOfSummary</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudResultsGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ActInvoiceAdjudicationPaymentSummaryType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: TimePeriodForThePayment</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.AdjudResultsGroup.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>For Payment Advice: Can also indicate time period over 
     * which the clawback and/or retro adjustment applies.</p>
     * 
     * <p>Time period for the payment or summary period.</p>
     * 
     * <p>Un-merged Business Name: SummaryPeriodDateRange</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudResultsGroup.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Un-merged Business Name: TimePeriodForThePayment</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.AdjudResultsGroup.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>For Payment Advice: Can also indicate time period over 
     * which the clawback and/or retro adjustment applies.</p>
     * 
     * <p>Time period for the payment or summary period.</p>
     * 
     * <p>Un-merged Business Name: SummaryPeriodDateRange</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudResultsGroup.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Un-merged Business Name: SummaryPeriodAmt</p>
     * 
     * <p>Relationship: FICR_MT630000CA.AdjudResultsGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>On SOFA Summary, this could be used to specify the amount 
     * that will be included in the Payment Advice. In this 
     * situation, it should equal the net effect of all 
     * AdjudResultsGroupSummaryData elements that would appear in 
     * the Payment Advice.</p>
     * 
     * <p>Summary Period Amt - Grand total of all SOFA observations 
     * contained in this summary</p>
     * 
     * <p>Un-merged Business Name: SummaryPeriodAmount</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudResultsGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }

    /**
     * <p>Un-merged Business Name: SummaryPeriodAmt</p>
     * 
     * <p>Relationship: FICR_MT630000CA.AdjudResultsGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>On SOFA Summary, this could be used to specify the amount 
     * that will be included in the Payment Advice. In this 
     * situation, it should equal the net effect of all 
     * AdjudResultsGroupSummaryData elements that would appear in 
     * the Payment Advice.</p>
     * 
     * <p>Summary Period Amt - Grand total of all SOFA observations 
     * contained in this summary</p>
     * 
     * <p>Un-merged Business Name: SummaryPeriodAmount</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudResultsGroup.netAmt</p>
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
     * FICR_MT630000CA.AdjudResultsGroupSummary.adjudResultsGroupSummaryData</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudResultsGroupSummary.adjudResultsGroupSummaryData</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"summary/adjudResultsGroupSummaryData"})
    public List<SummaryDetailsBean> getSummaryAdjudResultsGroupSummaryData() {
        return this.summaryAdjudResultsGroupSummaryData;
    }


    /**
     * <p>Business Name: AdjudicatedResultsGroupID</p>
     * 
     * <p>Un-merged Business Name: AdjudicatedResultsGroupID</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudResultsGroup.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: AdjudicatedResultsGroupID</p>
     * 
     * <p>Un-merged Business Name: AdjudicatedResultsGroupID</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudResultsGroup.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
