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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt610201ca;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged.AdjudicatedResultsGroupBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActInvoiceGroupType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.AdjudicationResultBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatedInvoiceElementGroup"})
public class AdjudicatedInvoiceElementGroupBean extends MessagePartBean implements AdjudicatedInvoiceElementChoice {

    private static final long serialVersionUID = 20130613L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private CS statusCode = new CSImpl();
    private MO netAmt = new MOImpl();
    private AdjudicatedInvoiceAuthorBean author;
    private AdjudicatedInvoiceElementGroupBean predecessorAdjudicatedInvoiceElementGroup;
    private List<ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.AdjudicatedInvoiceElementGroupBean> referenceAdjudicatedInvoiceElementGroup = new ArrayList<ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.AdjudicatedInvoiceElementGroupBean>();
    private MO reference1AllowableNetAmt = new MOImpl();
    private List<AdjudicatedInvoiceCoverageBean> coverage = new ArrayList<AdjudicatedInvoiceCoverageBean>();
    private List<AdjudicatedInvoiceElementChoice> componentAdjudicatedInvoiceElementChoice = new ArrayList<AdjudicatedInvoiceElementChoice>();
    private AdjudicationResultBean outcomeOfAdjudicationResult;
    private AdjudicatedResultsGroupBean referencedByAdjudResultsGroup;


    /**
     * <p>Business Name: Adjudicated Results Identifier</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceGroupType getCode() {
        return (ActInvoiceGroupType) this.code.getValue();
    }

    /**
     * <p>Business Name: Invoice Type</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ActInvoiceGroupType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Status of the Adjudicated Invoice</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementGroup.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
    public AdjudicatedInvoiceAuthorBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementGroup.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAuthor(AdjudicatedInvoiceAuthorBean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoicePredecessor.adjudicatedInvoiceElementGroup</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"predecessor/adjudicatedInvoiceElementGroup"})
    public AdjudicatedInvoiceElementGroupBean getPredecessorAdjudicatedInvoiceElementGroup() {
        return this.predecessorAdjudicatedInvoiceElementGroup;
    }

    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoicePredecessor.adjudicatedInvoiceElementGroup</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPredecessorAdjudicatedInvoiceElementGroup(AdjudicatedInvoiceElementGroupBean predecessorAdjudicatedInvoiceElementGroup) {
        this.predecessorAdjudicatedInvoiceElementGroup = predecessorAdjudicatedInvoiceElementGroup;
    }


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.Reference.adjudicatedInvoiceElementGroup</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"reference/adjudicatedInvoiceElementGroup"})
    public List<ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.AdjudicatedInvoiceElementGroupBean> getReferenceAdjudicatedInvoiceElementGroup() {
        return this.referenceAdjudicatedInvoiceElementGroup;
    }


    /**
     * <p>Business Name: Paid Amount</p>
     * 
     * <p>Relationship: FICR_MT610201CA.Allowable.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"reference1/allowable/netAmt"})
    public Money getReference1AllowableNetAmt() {
        return this.reference1AllowableNetAmt.getValue();
    }

    /**
     * <p>Business Name: Paid Amount</p>
     * 
     * <p>Relationship: FICR_MT610201CA.Allowable.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     * FICR_MT610201CA.AdjudicatedResultOutcome.adjudicationResult</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"outcomeOf/adjudicationResult"})
    public AdjudicationResultBean getOutcomeOfAdjudicationResult() {
        return this.outcomeOfAdjudicationResult;
    }

    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedResultOutcome.adjudicationResult</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setOutcomeOfAdjudicationResult(AdjudicationResultBean outcomeOfAdjudicationResult) {
        this.outcomeOfAdjudicationResult = outcomeOfAdjudicationResult;
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
