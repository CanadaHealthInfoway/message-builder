/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt680000ca.AdjudicatedInvoiceAuthorBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt680000ca.AdjudicatedInvoiceCoverageBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt680000ca.AdjudicatedInvoiceElementChoice;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt680000ca.AdjudicatedResultOutcomeBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT680000CA.AdjudicatedInvoiceElementGroup","FICR_MT630000CA.AdjudicatedInvoiceElementGroup"})
@Hl7RootType
public class AdjudicatedInvoiceElementGroupBean extends MessagePartBean implements AdjudicatedInvoiceElementChoice {

    private static final long serialVersionUID = 20110831L;
    private II adjudicationResultId = new IIImpl();
    private CV invoiceType = new CVImpl();
    private CS statusCode = new CSImpl();
    private MO paidAmount = new MOImpl();
    private PaymentIntentBean reasonPaymentIntent;
    private AdjudicatedInvoiceElementGroupBean referenceAdjudicatedInvoiceElementGroup;
    private AdjudicatedResultsGroupBean referencedByAdjudResultsGroup;
    private AdjudicatedResultOutcomeBean outcomeOf;
    private AdjudicatedInvoiceAuthorBean author;
    private List<AdjudicatedInvoiceCoverageBean> coverage = new ArrayList<AdjudicatedInvoiceCoverageBean>();
    private List<AdjudicatedInvoiceElementChoice> componentAdjudicatedInvoiceElementChoice = new ArrayList<AdjudicatedInvoiceElementChoice>();


    /**
     * <p>AdjudicationResultId</p>
     * 
     * <p>Adjudication Result Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getAdjudicationResultId() {
        return this.adjudicationResultId.getValue();
    }
    public void setAdjudicationResultId(Identifier adjudicationResultId) {
        this.adjudicationResultId.setValue(adjudicationResultId);
    }


    /**
     * <p>InvoiceType</p>
     * 
     * <p>Invoice Type</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getInvoiceType() {
        return (Code) this.invoiceType.getValue();
    }
    public void setInvoiceType(Code invoiceType) {
        this.invoiceType.setValue(invoiceType);
    }


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
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getPaidAmount() {
        return this.paidAmount.getValue();
    }
    public void setPaidAmount(Money paidAmount) {
        this.paidAmount.setValue(paidAmount);
    }


    @Hl7XmlMapping({"reason/paymentIntent"})
    public PaymentIntentBean getReasonPaymentIntent() {
        return this.reasonPaymentIntent;
    }
    public void setReasonPaymentIntent(PaymentIntentBean reasonPaymentIntent) {
        this.reasonPaymentIntent = reasonPaymentIntent;
    }


    @Hl7XmlMapping({"reference/adjudicatedInvoiceElementGroup"})
    public AdjudicatedInvoiceElementGroupBean getReferenceAdjudicatedInvoiceElementGroup() {
        return this.referenceAdjudicatedInvoiceElementGroup;
    }
    public void setReferenceAdjudicatedInvoiceElementGroup(AdjudicatedInvoiceElementGroupBean referenceAdjudicatedInvoiceElementGroup) {
        this.referenceAdjudicatedInvoiceElementGroup = referenceAdjudicatedInvoiceElementGroup;
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


    @Hl7XmlMapping({"author"})
    public AdjudicatedInvoiceAuthorBean getAuthor() {
        return this.author;
    }
    public void setAuthor(AdjudicatedInvoiceAuthorBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"coverage"})
    public List<AdjudicatedInvoiceCoverageBean> getCoverage() {
        return this.coverage;
    }


    @Hl7XmlMapping({"component/adjudicatedInvoiceElementChoice"})
    public List<AdjudicatedInvoiceElementChoice> getComponentAdjudicatedInvoiceElementChoice() {
        return this.componentAdjudicatedInvoiceElementChoice;
    }

}