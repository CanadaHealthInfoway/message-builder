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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt510201ca;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged.AllowableBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT510201CA.AdjudicatedInvoiceElementGroup"})
public class AdjudicatedInvoiceElementGroupBean extends MessagePartBean implements AdjudicatedInvoiceElementChoice {

    private static final long serialVersionUID = 20120106L;
    private AllowableBean reference1Allowable;
    private AdjudicationResultBean outcomeOfAdjudicationResult;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private CS statusCode = new CSImpl();
    private MO netAmt = new MOImpl();
    private Author1Bean author;
    private ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.AdjudicatedInvoiceElementGroupBean referenceAdjudicatedInvoiceElementGroup;
    private CoverageBean coverage;
    private List<ComponentBean> component = new ArrayList<ComponentBean>();


    @Hl7XmlMapping({"reference1/allowable"})
    public AllowableBean getReference1Allowable() {
        return this.reference1Allowable;
    }
    public void setReference1Allowable(AllowableBean reference1Allowable) {
        this.reference1Allowable = reference1Allowable;
    }


    @Hl7XmlMapping({"outcomeOf/adjudicationResult"})
    public AdjudicationResultBean getOutcomeOfAdjudicationResult() {
        return this.outcomeOfAdjudicationResult;
    }
    public void setOutcomeOfAdjudicationResult(AdjudicationResultBean outcomeOfAdjudicationResult) {
        this.outcomeOfAdjudicationResult = outcomeOfAdjudicationResult;
    }


    /**
     * <p>Adjudication Result Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Invoice Type</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>Invoice status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Paid Amount</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    @Hl7XmlMapping({"author"})
    public Author1Bean getAuthor() {
        return this.author;
    }
    public void setAuthor(Author1Bean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"reference/adjudicatedInvoiceElementGroup"})
    public ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.AdjudicatedInvoiceElementGroupBean getReferenceAdjudicatedInvoiceElementGroup() {
        return this.referenceAdjudicatedInvoiceElementGroup;
    }
    public void setReferenceAdjudicatedInvoiceElementGroup(ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.AdjudicatedInvoiceElementGroupBean referenceAdjudicatedInvoiceElementGroup) {
        this.referenceAdjudicatedInvoiceElementGroup = referenceAdjudicatedInvoiceElementGroup;
    }


    @Hl7XmlMapping({"coverage"})
    public CoverageBean getCoverage() {
        return this.coverage;
    }
    public void setCoverage(CoverageBean coverage) {
        this.coverage = coverage;
    }


    @Hl7XmlMapping({"component"})
    public List<ComponentBean> getComponent() {
        return this.component;
    }

}
