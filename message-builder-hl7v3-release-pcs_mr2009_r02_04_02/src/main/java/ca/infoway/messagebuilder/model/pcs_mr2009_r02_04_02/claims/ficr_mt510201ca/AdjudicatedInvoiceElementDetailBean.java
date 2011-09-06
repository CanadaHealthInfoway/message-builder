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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt510201ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.AllowableBean;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"FICR_MT510201CA.AdjudicatedInvoiceElementDetail"})
public class AdjudicatedInvoiceElementDetailBean extends MessagePartBean implements AdjudicatedInvoiceElementChoice {

    private static final long serialVersionUID = 20110906L;
    private AllowableBean reference1Allowable;
    private AdjudicationResultBean outcomeOfAdjudicationResult;
    private SET<II, Identifier> adjudicatedInvoiceElementIdentifier = new SETImpl<II, Identifier>(IIImpl.class);
    private CV adjudicatedProductServiceCode = new CVImpl();
    private PQ adjudicatedUnitQuantity = new PQImpl();
    private RTO<Money, PhysicalQuantity> adjudicatedUnitPrice = new RTOImpl<Money, PhysicalQuantity>();
    private MO adjudicatedLineAmount = new MOImpl();
    private List<REAL> multiplierEG007 = new ArrayList<REAL>();


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
     * <p>Adjudicated Invoice Element Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getAdjudicatedInvoiceElementIdentifier() {
        return this.adjudicatedInvoiceElementIdentifier.rawSet();
    }


    /**
     * <p>Adjudicated Product/Service Code</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getAdjudicatedProductServiceCode() {
        return (Code) this.adjudicatedProductServiceCode.getValue();
    }
    public void setAdjudicatedProductServiceCode(Code adjudicatedProductServiceCode) {
        this.adjudicatedProductServiceCode.setValue(adjudicatedProductServiceCode);
    }


    /**
     * <p>Adjudicated Unit Quantity</p>
     */
    @Hl7XmlMapping({"unitQuantity"})
    public PhysicalQuantity getAdjudicatedUnitQuantity() {
        return this.adjudicatedUnitQuantity.getValue();
    }
    public void setAdjudicatedUnitQuantity(PhysicalQuantity adjudicatedUnitQuantity) {
        this.adjudicatedUnitQuantity.setValue(adjudicatedUnitQuantity);
    }


    /**
     * <p>Adjudicated Unit Price</p>
     */
    @Hl7XmlMapping({"unitPriceAmt"})
    public Ratio<Money, PhysicalQuantity> getAdjudicatedUnitPrice() {
        return this.adjudicatedUnitPrice.getValue();
    }
    public void setAdjudicatedUnitPrice(Ratio<Money, PhysicalQuantity> adjudicatedUnitPrice) {
        this.adjudicatedUnitPrice.setValue(adjudicatedUnitPrice);
    }


    /**
     * <p>Adjudicated Line Amount</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getAdjudicatedLineAmount() {
        return this.adjudicatedLineAmount.getValue();
    }
    public void setAdjudicatedLineAmount(Money adjudicatedLineAmount) {
        this.adjudicatedLineAmount.setValue(adjudicatedLineAmount);
    }


    /**
     * <p>Multiplier,e.g. 0.07</p>
     */
    @Hl7XmlMapping({"factorNumber"})
    public List<BigDecimal> getMultiplierEG007() {
        return new RawListWrapper<REAL, BigDecimal>(multiplierEG007, REALImpl.class);
    }

}
