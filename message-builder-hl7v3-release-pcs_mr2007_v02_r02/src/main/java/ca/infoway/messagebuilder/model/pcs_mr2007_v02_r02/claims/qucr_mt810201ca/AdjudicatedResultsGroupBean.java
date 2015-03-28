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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.qucr_mt810201ca;

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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.coct_mt110101ca.AccountBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.coct_mt110200ca.PayeeAccountBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged.SummaryDetailsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt240003ca.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.domainvalue.ActInvoiceAdjudicationPaymentCode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Adjudicated Results Group</p>
 * 
 * <p>The AdjudResultsGroup.netAmt must equal the sum of all 
 * immediate children AdjudResultsGroup.netAmt</p>
 * 
 * <p>Associations to the right are used for breaking 
 * down</p><p>a Payment Advice (e.g. provider, sending appl) 
 * or</p><p>a Statement of Financial Activity (e.g. payee, 
 * payor).</p><p>Only 1 association can be specified per 
 * instance of this act.</p>
 */
@Hl7PartTypeMapping({"QUCR_MT810201CA.AdjudResultsGroup"})
@Hl7RootType
public class AdjudicatedResultsGroupBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private MO netAmt = new MOImpl();
    private DevicePlayingTheSendingApplicationRoleBean deviceAdjudResultsSendingAppRole;
    private ProviderIDBean performerAdjudResultsProviderRole;
    private CarrierOrThirdPartyAdministratorBean authorAdjudResultsCarrierRole;
    private ServiceLocationBean locationServiceDeliveryLocation;
    private BusinessArrangementBean referenceAdjudResultsFinancialContract;
    private List<SummaryDetailsBean> summaryAdjudResultsGroupSummaryData = new ArrayList<SummaryDetailsBean>();
    private PayeeAccountBean creditAccount;
    private AccountBean debitAccount;
    private List<AdjudicatedResultsGroupBean> componentAdjudResultsGroup = new ArrayList<AdjudicatedResultsGroupBean>();


    /**
     * <p>Business Name: Adjudicated Results Group ID</p>
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
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Adjudicated Results Group ID</p>
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
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Type of summary</p>
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
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceAdjudicationPaymentCode getCode() {
        return (ActInvoiceAdjudicationPaymentCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Type of summary</p>
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
     */
    public void setCode(ActInvoiceAdjudicationPaymentCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Time period for the payment</p>
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
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Time period for the payment</p>
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
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Summary Period Amt</p>
     * 
     * <p>Relationship: QUCR_MT810201CA.AdjudResultsGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }

    /**
     * <p>Business Name: Summary Period Amt</p>
     * 
     * <p>Relationship: QUCR_MT810201CA.AdjudResultsGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     */
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    /**
     * <p>Relationship: 
     * QUCR_MT810201CA.Device.adjudResultsSendingAppRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"device/adjudResultsSendingAppRole"})
    public DevicePlayingTheSendingApplicationRoleBean getDeviceAdjudResultsSendingAppRole() {
        return this.deviceAdjudResultsSendingAppRole;
    }

    /**
     * <p>Relationship: 
     * QUCR_MT810201CA.Device.adjudResultsSendingAppRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDeviceAdjudResultsSendingAppRole(DevicePlayingTheSendingApplicationRoleBean deviceAdjudResultsSendingAppRole) {
        this.deviceAdjudResultsSendingAppRole = deviceAdjudResultsSendingAppRole;
    }


    /**
     * <p>Relationship: 
     * QUCR_MT810201CA.Performer.adjudResultsProviderRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"performer/adjudResultsProviderRole"})
    public ProviderIDBean getPerformerAdjudResultsProviderRole() {
        return this.performerAdjudResultsProviderRole;
    }

    /**
     * <p>Relationship: 
     * QUCR_MT810201CA.Performer.adjudResultsProviderRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPerformerAdjudResultsProviderRole(ProviderIDBean performerAdjudResultsProviderRole) {
        this.performerAdjudResultsProviderRole = performerAdjudResultsProviderRole;
    }


    /**
     * <p>Relationship: 
     * QUCR_MT810201CA.Author.adjudResultsCarrierRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"author/adjudResultsCarrierRole"})
    public CarrierOrThirdPartyAdministratorBean getAuthorAdjudResultsCarrierRole() {
        return this.authorAdjudResultsCarrierRole;
    }

    /**
     * <p>Relationship: 
     * QUCR_MT810201CA.Author.adjudResultsCarrierRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setAuthorAdjudResultsCarrierRole(CarrierOrThirdPartyAdministratorBean authorAdjudResultsCarrierRole) {
        this.authorAdjudResultsCarrierRole = authorAdjudResultsCarrierRole;
    }


    /**
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
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroupLocation.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroupRef.adjudResultsFinancialContract</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"reference/adjudResultsFinancialContract"})
    public BusinessArrangementBean getReferenceAdjudResultsFinancialContract() {
        return this.referenceAdjudResultsFinancialContract;
    }

    /**
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroupRef.adjudResultsFinancialContract</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setReferenceAdjudResultsFinancialContract(BusinessArrangementBean referenceAdjudResultsFinancialContract) {
        this.referenceAdjudResultsFinancialContract = referenceAdjudResultsFinancialContract;
    }


    /**
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroupSummary.adjudResultsGroupSummaryData</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"summary/adjudResultsGroupSummaryData"})
    public List<SummaryDetailsBean> getSummaryAdjudResultsGroupSummaryData() {
        return this.summaryAdjudResultsGroupSummaryData;
    }


    /**
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
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroupPayee.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCreditAccount(PayeeAccountBean creditAccount) {
        this.creditAccount = creditAccount;
    }


    /**
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
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroupPayor.account</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDebitAccount(AccountBean debitAccount) {
        this.debitAccount = debitAccount;
    }


    /**
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
