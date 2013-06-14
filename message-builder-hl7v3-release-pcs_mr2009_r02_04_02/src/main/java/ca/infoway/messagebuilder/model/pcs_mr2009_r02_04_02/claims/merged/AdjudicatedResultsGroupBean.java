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
package Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.claims.merged;

import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.coct_mt110101ca.AccountBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.coct_mt110200ca.PayeeAccountBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.ServiceLocationBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.domainvalue.ActInvoiceAdjudicationPaymentSummaryType;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: AdjudicatedResultsGroup</p>
 * 
 * <p>QUCR_MT810201CA.AdjudResultsGroup: Adjudicated Results 
 * Group</p>
 * 
 * <p>Associations to the right are used for breaking 
 * down</p><p>a Payment Advice (e.g. provider, sending appl) 
 * or</p><p>a Statement of Financial Activity (e.g. payee, 
 * payor).</p><p>Only 1 association can be specified per 
 * instance of this act.</p>
 * 
 * <p>Group of Results adjudicated and identified and included 
 * in these results.</p>
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
@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudResultsGroup","FICR_MT630000CA.AdjudResultsGroup","QUCR_MT810201CA.AdjudResultsGroup"})
@Hl7RootType
public class AdjudicatedResultsGroupBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private MO netAmt = new MOImpl();
    private II deviceAdjudResultsSendingAppRolePlayingAdjudResultsSendingAppDeviceId = new IIImpl();
    private II performerAdjudResultsProviderRoleId = new IIImpl();
    private II authorAdjudResultsCarrierRoleId = new IIImpl();
    private ServiceLocationBean locationServiceDeliveryLocation;
    private II referenceAdjudResultsFinancialContractId = new IIImpl();
    private List<SummaryDetailsBean> summaryAdjudResultsGroupSummaryData = new ArrayList<SummaryDetailsBean>();
    private PayeeAccountBean creditAccount;
    private AccountBean debitAccount;
    private List<AdjudicatedResultsGroupBean> componentAdjudResultsGroup = new ArrayList<AdjudicatedResultsGroupBean>();


    /**
     * <p>Business Name: AdjudicatedResultsGroupID</p>
     * 
     * <p>Un-merged Business Name: AdjudicatedResultsGroupID</p>
     * 
     * <p>Relationship: QUCR_MT810201CA.AdjudResultsGroup.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>If specified on a Payment Advice Summary, can be used to 
     * request additional detail with a Payment Advice Query 
     * message</p>
     * 
     * <p>(If specified on a Payment Advice Summary, can be used to 
     * request additional detail with a Payment Advice Query 
     * message</p>
     * 
     * <p>ID of Results Group</p>
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
     * <p>Relationship: QUCR_MT810201CA.AdjudResultsGroup.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>If specified on a Payment Advice Summary, can be used to 
     * request additional detail with a Payment Advice Query 
     * message</p>
     * 
     * <p>(If specified on a Payment Advice Summary, can be used to 
     * request additional detail with a Payment Advice Query 
     * message</p>
     * 
     * <p>ID of Results Group</p>
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


    /**
     * <p>Un-merged Business Name: TypeOfSummary</p>
     * 
     * <p>Relationship: QUCR_MT810201CA.AdjudResultsGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This code describes the breakdown of the financial 
     * activity.</p>
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
     * <p>Type of summary</p>
     * 
     * <p>Un-merged Business Name: TypeOfSummary</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudResultsGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
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
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceAdjudicationPaymentSummaryType getCode() {
        return (ActInvoiceAdjudicationPaymentSummaryType) this.code.getValue();
    }

    /**
     * <p>Un-merged Business Name: TypeOfSummary</p>
     * 
     * <p>Relationship: QUCR_MT810201CA.AdjudResultsGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This code describes the breakdown of the financial 
     * activity.</p>
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
     * <p>Type of summary</p>
     * 
     * <p>Un-merged Business Name: TypeOfSummary</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudResultsGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
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
     */
    public void setCode(ActInvoiceAdjudicationPaymentSummaryType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: TimePeriodForThePayment</p>
     * 
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroup.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Time period for the payment or summary period.</p>
     * 
     * <p>For Payment Advice: Can also indicate time period over 
     * which the clawback and/or retro adjustment applies.</p>
     * 
     * <p>Un-merged Business Name: SummaryPeriodDateRange</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudResultsGroup.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
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
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Un-merged Business Name: TimePeriodForThePayment</p>
     * 
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroup.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Time period for the payment or summary period.</p>
     * 
     * <p>For Payment Advice: Can also indicate time period over 
     * which the clawback and/or retro adjustment applies.</p>
     * 
     * <p>Un-merged Business Name: SummaryPeriodDateRange</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudResultsGroup.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
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
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Un-merged Business Name: SummaryPeriodAmt</p>
     * 
     * <p>Relationship: QUCR_MT810201CA.AdjudResultsGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The AdjudResultsGroup.netAmt must equal the sum of all 
     * immediate children AdjudResultsGroup.netAmt</p>
     * 
     * <p>Can also indicate time period over which the clawback 
     * and/or retro adjustment applies</p>
     * 
     * <p>On SOFA Summary, this could be used to specify the amount 
     * that will be included in the Payment Advice. In this 
     * situation, it should equal the net effect of all 
     * AdjudResultsGroupSummaryData elements that would appear in 
     * the Payment Advice.</p>
     * 
     * <p>Summary Period Amt</p>
     * 
     * <p>Un-merged Business Name: SummaryPeriodAmount</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudResultsGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
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
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }

    /**
     * <p>Un-merged Business Name: SummaryPeriodAmt</p>
     * 
     * <p>Relationship: QUCR_MT810201CA.AdjudResultsGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The AdjudResultsGroup.netAmt must equal the sum of all 
     * immediate children AdjudResultsGroup.netAmt</p>
     * 
     * <p>Can also indicate time period over which the clawback 
     * and/or retro adjustment applies</p>
     * 
     * <p>On SOFA Summary, this could be used to specify the amount 
     * that will be included in the Payment Advice. In this 
     * situation, it should equal the net effect of all 
     * AdjudResultsGroupSummaryData elements that would appear in 
     * the Payment Advice.</p>
     * 
     * <p>Summary Period Amt</p>
     * 
     * <p>Un-merged Business Name: SummaryPeriodAmount</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudResultsGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
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
     */
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    /**
     * <p>Business Name: SendingApplicationIdentifier</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationIdentifier</p>
     * 
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsSendingAppDevice.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Sending application identifier</p>
     */
    @Hl7XmlMapping({"device/adjudResultsSendingAppRole/playingAdjudResultsSendingAppDevice/id"})
    public Identifier getDeviceAdjudResultsSendingAppRolePlayingAdjudResultsSendingAppDeviceId() {
        return this.deviceAdjudResultsSendingAppRolePlayingAdjudResultsSendingAppDeviceId.getValue();
    }

    /**
     * <p>Business Name: SendingApplicationIdentifier</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationIdentifier</p>
     * 
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsSendingAppDevice.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Sending application identifier</p>
     */
    public void setDeviceAdjudResultsSendingAppRolePlayingAdjudResultsSendingAppDeviceId(Identifier deviceAdjudResultsSendingAppRolePlayingAdjudResultsSendingAppDeviceId) {
        this.deviceAdjudResultsSendingAppRolePlayingAdjudResultsSendingAppDeviceId.setValue(deviceAdjudResultsSendingAppRolePlayingAdjudResultsSendingAppDeviceId);
    }


    /**
     * <p>Business Name: SummaryBreakdownProviderID</p>
     * 
     * <p>Un-merged Business Name: SummaryBreakdownProviderID</p>
     * 
     * <p>Relationship: QUCR_MT810201CA.AdjudResultsProviderRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identity of provider for summary breakdowns.</p>
     */
    @Hl7XmlMapping({"performer/adjudResultsProviderRole/id"})
    public Identifier getPerformerAdjudResultsProviderRoleId() {
        return this.performerAdjudResultsProviderRoleId.getValue();
    }

    /**
     * <p>Business Name: SummaryBreakdownProviderID</p>
     * 
     * <p>Un-merged Business Name: SummaryBreakdownProviderID</p>
     * 
     * <p>Relationship: QUCR_MT810201CA.AdjudResultsProviderRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identity of provider for summary breakdowns.</p>
     */
    public void setPerformerAdjudResultsProviderRoleId(Identifier performerAdjudResultsProviderRoleId) {
        this.performerAdjudResultsProviderRoleId.setValue(performerAdjudResultsProviderRoleId);
    }


    /**
     * <p>Business Name: CarrierId</p>
     * 
     * <p>Un-merged Business Name: CarrierId</p>
     * 
     * <p>Relationship: QUCR_MT810201CA.AdjudResultsCarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author/adjudResultsCarrierRole/id"})
    public Identifier getAuthorAdjudResultsCarrierRoleId() {
        return this.authorAdjudResultsCarrierRoleId.getValue();
    }

    /**
     * <p>Business Name: CarrierId</p>
     * 
     * <p>Un-merged Business Name: CarrierId</p>
     * 
     * <p>Relationship: QUCR_MT810201CA.AdjudResultsCarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthorAdjudResultsCarrierRoleId(Identifier authorAdjudResultsCarrierRoleId) {
        this.authorAdjudResultsCarrierRoleId.setValue(authorAdjudResultsCarrierRoleId);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroupLocation.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroupLocation.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    /**
     * <p>Business Name: BusinessArrangementID</p>
     * 
     * <p>Un-merged Business Name: BusinessArrangementID</p>
     * 
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsFinancialContract.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Business arrangement identifier</p>
     */
    @Hl7XmlMapping({"reference/adjudResultsFinancialContract/id"})
    public Identifier getReferenceAdjudResultsFinancialContractId() {
        return this.referenceAdjudResultsFinancialContractId.getValue();
    }

    /**
     * <p>Business Name: BusinessArrangementID</p>
     * 
     * <p>Un-merged Business Name: BusinessArrangementID</p>
     * 
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsFinancialContract.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Business arrangement identifier</p>
     */
    public void setReferenceAdjudResultsFinancialContractId(Identifier referenceAdjudResultsFinancialContractId) {
        this.referenceAdjudResultsFinancialContractId.setValue(referenceAdjudResultsFinancialContractId);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroupSummary.adjudResultsGroupSummaryData</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudResultsGroupSummary.adjudResultsGroupSummaryData</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.AdjudResultsGroupSummary.adjudResultsGroupSummaryData</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"summary/adjudResultsGroupSummaryData"})
    public List<SummaryDetailsBean> getSummaryAdjudResultsGroupSummaryData() {
        return this.summaryAdjudResultsGroupSummaryData;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroupPayee.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"credit/account"})
    public PayeeAccountBean getCreditAccount() {
        return this.creditAccount;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroupPayee.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCreditAccount(PayeeAccountBean creditAccount) {
        this.creditAccount = creditAccount;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroupPayor.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"debit/account"})
    public AccountBean getDebitAccount() {
        return this.debitAccount;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroupPayor.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDebitAccount(AccountBean debitAccount) {
        this.debitAccount = debitAccount;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroupComponent.adjudResultsGroup</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component/adjudResultsGroup"})
    public List<AdjudicatedResultsGroupBean> getComponentAdjudResultsGroup() {
        return this.componentAdjudResultsGroup;
    }

}
