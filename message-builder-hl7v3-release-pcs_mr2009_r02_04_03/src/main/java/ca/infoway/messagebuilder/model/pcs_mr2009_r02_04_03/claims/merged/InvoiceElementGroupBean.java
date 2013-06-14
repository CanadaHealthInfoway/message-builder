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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt500201ca.InvoiceElementComponentBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt280001ca.A_BillableActChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActInvoiceGroupType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.AdjudicatedInvoiceElementGroupBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"FICR_MT500201CA.InvoiceElementGroup","FICR_MT510201CA.InvoiceElementGroup"})
public class InvoiceElementGroupBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.InvoiceElementChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt500201ca.InvoiceElementChoice {

    private static final long serialVersionUID = 20130613L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private MO netAmt = new MOImpl();
    private CoveredPartyAsPatientBean coveredPartyCoveredPartyAsPatient;
    private FinancialContractBean inFulfillmentOfFinancialContract;
    private List<II> predecessorInvoiceElementCrossReferenceId = new ArrayList<II>();
    private List<AdjudicatedInvoiceElementGroupBean> referenceAdjudicatedInvoiceElementGroup = new ArrayList<AdjudicatedInvoiceElementGroupBean>();
    private List<PolicyOrAccount_2Bean> coveragePolicyOrAccount = new ArrayList<PolicyOrAccount_2Bean>();
    private List<HealthDocumentAttachment_2Bean> pertinentInformationHealthDocumentAttachment = new ArrayList<HealthDocumentAttachment_2Bean>();
    private List<InvoiceElementComponentBean> component = new ArrayList<InvoiceElementComponentBean>();
    private List<A_BillableActChoice> reasonOfBillableActChoice = new ArrayList<A_BillableActChoice>();
    private List<InvoiceElementOverrideBean> triggerForInvoiceElementOverride = new ArrayList<InvoiceElementOverrideBean>();


    /**
     * <p>Business Name: InvoiceGroupingIdentifierS</p>
     * 
     * <p>Un-merged Business Name: InvoiceGroupingIdentifierS</p>
     * 
     * <p>Relationship: FICR_MT500201CA.InvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-99)</p>
     * 
     * <p>Un-merged Business Name: InvoiceGroupingIdentifierS</p>
     * 
     * <p>Relationship: FICR_MT510201CA.InvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-10)</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: InvoiceType</p>
     * 
     * <p>Un-merged Business Name: InvoiceType</p>
     * 
     * <p>Relationship: FICR_MT500201CA.InvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: InvoiceType</p>
     * 
     * <p>Relationship: FICR_MT510201CA.InvoiceElementGroup.code</p>
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
     * <p>Relationship: FICR_MT500201CA.InvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: InvoiceType</p>
     * 
     * <p>Relationship: FICR_MT510201CA.InvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ActInvoiceGroupType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: TimePeriodForInvoice</p>
     * 
     * <p>Un-merged Business Name: TimePeriodForInvoice</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.InvoiceElementGroup.effectiveTime</p>
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
     * FICR_MT500201CA.InvoiceElementGroup.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: InvoiceSubTotal</p>
     * 
     * <p>Un-merged Business Name: InvoiceSubTotal</p>
     * 
     * <p>Relationship: FICR_MT500201CA.InvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: InvoiceSubTotal</p>
     * 
     * <p>Relationship: FICR_MT510201CA.InvoiceElementGroup.netAmt</p>
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
     * <p>Relationship: FICR_MT500201CA.InvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: InvoiceSubTotal</p>
     * 
     * <p>Relationship: FICR_MT510201CA.InvoiceElementGroup.netAmt</p>
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
     * FICR_MT500201CA.CoveredParty.coveredPartyAsPatient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.CoveredParty.coveredPartyAsPatient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"coveredParty/coveredPartyAsPatient"})
    public CoveredPartyAsPatientBean getCoveredPartyCoveredPartyAsPatient() {
        return this.coveredPartyCoveredPartyAsPatient;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.CoveredParty.coveredPartyAsPatient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.CoveredParty.coveredPartyAsPatient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCoveredPartyCoveredPartyAsPatient(CoveredPartyAsPatientBean coveredPartyCoveredPartyAsPatient) {
        this.coveredPartyCoveredPartyAsPatient = coveredPartyCoveredPartyAsPatient;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.InvoiceElementGroupInFulfillmentOf.financialContract</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/financialContract"})
    public FinancialContractBean getInFulfillmentOfFinancialContract() {
        return this.inFulfillmentOfFinancialContract;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.InvoiceElementGroupInFulfillmentOf.financialContract</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInFulfillmentOfFinancialContract(FinancialContractBean inFulfillmentOfFinancialContract) {
        this.inFulfillmentOfFinancialContract = inFulfillmentOfFinancialContract;
    }


    /**
     * <p>Business Name: CrossReferenceIdentifier</p>
     * 
     * <p>Un-merged Business Name: CrossReferenceIdentifier</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.InvoiceElementCrossReference.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"predecessor/invoiceElementCrossReference/id"})
    public List<Identifier> getPredecessorInvoiceElementCrossReferenceId() {
        return new RawListWrapper<II, Identifier>(predecessorInvoiceElementCrossReferenceId, IIImpl.class);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.Reference.adjudicatedInvoiceElementGroup</p>
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
     * FICR_MT500201CA.InvoiceElementCoverage.policyOrAccount</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"coverage/policyOrAccount"})
    public List<PolicyOrAccount_2Bean> getCoveragePolicyOrAccount() {
        return this.coveragePolicyOrAccount;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.InvoiceElementGroupAttachment.healthDocumentAttachment</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation/healthDocumentAttachment"})
    public List<HealthDocumentAttachment_2Bean> getPertinentInformationHealthDocumentAttachment() {
        return this.pertinentInformationHealthDocumentAttachment;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.InvoiceElementGroup.component</p>
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
     * FICR_MT500201CA.InvoiceElementReason.billableActChoice</p>
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
     * FICR_MT500201CA.Suggests.invoiceElementOverride</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"triggerFor/invoiceElementOverride"})
    public List<InvoiceElementOverrideBean> getTriggerForInvoiceElementOverride() {
        return this.triggerForInvoiceElementOverride;
    }

}
