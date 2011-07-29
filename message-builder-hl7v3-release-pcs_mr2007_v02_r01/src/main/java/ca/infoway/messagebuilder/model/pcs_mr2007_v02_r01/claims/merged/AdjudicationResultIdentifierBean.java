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



@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatedInvoiceElementGroup","QUCR_MT830201CA.AdjudicatedInvoiceElementGroup"})
public class AdjudicationResultIdentifierBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt610201ca.AdjudicatedInvoiceElementChoice {

    private static final long serialVersionUID = 20110729L;
    private AllowableBean reference1Allowable;
    private II adjudicatedResultsIdentifier = new IIImpl();
    private CV invoiceType = new CVImpl();
    private CS statusOfTheAdjudicatedInvoice = new CSImpl();
    private MO paidAmount = new MOImpl();
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
     * <p>Adjudicated Results Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getAdjudicatedResultsIdentifier() {
        return this.adjudicatedResultsIdentifier.getValue();
    }
    public void setAdjudicatedResultsIdentifier(Identifier adjudicatedResultsIdentifier) {
        this.adjudicatedResultsIdentifier.setValue(adjudicatedResultsIdentifier);
    }


    /**
     * <p>InvoiceType</p>
     * 
     * <p>(Invoice Type</p>
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


    /**
     * <p>StatusOfTheAdjudicatedInvoice</p>
     * 
     * <p>Status of the Adjudicated Invoice</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusOfTheAdjudicatedInvoice() {
        return (ActStatus) this.statusOfTheAdjudicatedInvoice.getValue();
    }
    public void setStatusOfTheAdjudicatedInvoice(ActStatus statusOfTheAdjudicatedInvoice) {
        this.statusOfTheAdjudicatedInvoice.setValue(statusOfTheAdjudicatedInvoice);
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
