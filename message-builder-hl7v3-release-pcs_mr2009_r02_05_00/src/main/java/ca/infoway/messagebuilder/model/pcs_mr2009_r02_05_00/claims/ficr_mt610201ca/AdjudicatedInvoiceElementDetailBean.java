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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.claims.merged.AllowableBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.domainvalue.ActInvoiceDetailCode;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.AdjudicatedResultOutcomeBean;

import java.math.BigDecimal;



@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatedInvoiceElementDetail"})
public class AdjudicatedInvoiceElementDetailBean extends MessagePartBean implements AdjudicatedInvoiceElementChoice {

    private static final long serialVersionUID = 20140506L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private PQ unitQuantity = new PQImpl();
    private RTO<Money, PhysicalQuantity> unitPriceAmt = new RTOImpl<Money, PhysicalQuantity>();
    private MO netAmt = new MOImpl();
    private REAL factorNumber = new REALImpl();
    private AllowableBean reference1Allowable;
    private AdjudicatedResultOutcomeBean outcomeOf;


    /**
     * <p>Business Name: Adjudicated Invoice Element Identifier</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementDetail.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Adjudicated Invoice Element Identifier</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementDetail.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Adjudicated Product/Service Code</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementDetail.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceDetailCode getCode() {
        return (ActInvoiceDetailCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Adjudicated Product/Service Code</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementDetail.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ActInvoiceDetailCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Adjudicated Unit Quantity</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementDetail.unitQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"unitQuantity"})
    public PhysicalQuantity getUnitQuantity() {
        return this.unitQuantity.getValue();
    }

    /**
     * <p>Business Name: Adjudicated Unit Quantity</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementDetail.unitQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setUnitQuantity(PhysicalQuantity unitQuantity) {
        this.unitQuantity.setValue(unitQuantity);
    }


    /**
     * <p>Business Name: Adjudicated Unit Price</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementDetail.unitPriceAmt</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"unitPriceAmt"})
    public Ratio<Money, PhysicalQuantity> getUnitPriceAmt() {
        return this.unitPriceAmt.getValue();
    }

    /**
     * <p>Business Name: Adjudicated Unit Price</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementDetail.unitPriceAmt</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setUnitPriceAmt(Ratio<Money, PhysicalQuantity> unitPriceAmt) {
        this.unitPriceAmt.setValue(unitPriceAmt);
    }


    /**
     * <p>Business Name: Adjudicated Invoice Line Amount</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementDetail.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }

    /**
     * <p>Business Name: Adjudicated Invoice Line Amount</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementDetail.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    /**
     * <p>Business Name: Multiplier, e.g. 0.07</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementDetail.factorNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"factorNumber"})
    public BigDecimal getFactorNumber() {
        return this.factorNumber.getValue();
    }

    /**
     * <p>Business Name: Multiplier, e.g. 0.07</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementDetail.factorNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setFactorNumber(BigDecimal factorNumber) {
        this.factorNumber.setValue(factorNumber);
    }


    /**
     * <p>Relationship: FICR_MT610201CA.Reference2.allowable</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"reference1/allowable"})
    public AllowableBean getReference1Allowable() {
        return this.reference1Allowable;
    }

    /**
     * <p>Relationship: FICR_MT610201CA.Reference2.allowable</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setReference1Allowable(AllowableBean reference1Allowable) {
        this.reference1Allowable = reference1Allowable;
    }


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementChoice.outcomeOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"outcomeOf"})
    public AdjudicatedResultOutcomeBean getOutcomeOf() {
        return this.outcomeOf;
    }

    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceElementChoice.outcomeOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setOutcomeOf(AdjudicatedResultOutcomeBean outcomeOf) {
        this.outcomeOf = outcomeOf;
    }

}
