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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt600201ca;

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
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt280001ca.A_BillableActChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.ActInvoiceDetailCode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>RTO used to specify 15 pills (each) out of a bottle of 
 * 100 pills (each) to reflect billing for a portion of a 
 * package (e.g. 0.15 of a bottle)</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.InvoiceElementDetail"})
public class InvoiceElementDetailBean extends MessagePartBean implements InvoiceElementChoice {

    private static final long serialVersionUID = 20121204L;
    private List<A_BillableActChoice> reasonOfBillableActChoice = new ArrayList<A_BillableActChoice>();
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private PQ unitQuantity = new PQImpl();
    private RTO<Money, PhysicalQuantity> unitPriceAmt = new RTOImpl<Money, PhysicalQuantity>();
    private MO netAmt = new MOImpl();
    private List<REAL> factorNumber = new ArrayList<REAL>();


    /**
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementReason.billableActChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"reasonOf/billableActChoice"})
    public List<A_BillableActChoice> getReasonOfBillableActChoice() {
        return this.reasonOfBillableActChoice;
    }


    /**
     * <p>Business Name: Submitted Invoice Line Identifier</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementDetail.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Submitted Invoice Line Identifier</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementDetail.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Submitted Product/Service Code</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementDetail.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceDetailCode getCode() {
        return (ActInvoiceDetailCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Submitted Product/Service Code</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementDetail.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ActInvoiceDetailCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Submitted Unit Quantity</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementDetail.unitQuantity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"unitQuantity"})
    public PhysicalQuantity getUnitQuantity() {
        return this.unitQuantity.getValue();
    }

    /**
     * <p>Business Name: Submitted Unit Quantity</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementDetail.unitQuantity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setUnitQuantity(PhysicalQuantity unitQuantity) {
        this.unitQuantity.setValue(unitQuantity);
    }


    /**
     * <p>Business Name: Submitted Unit Amount Price</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementDetail.unitPriceAmt</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"unitPriceAmt"})
    public Ratio<Money, PhysicalQuantity> getUnitPriceAmt() {
        return this.unitPriceAmt.getValue();
    }

    /**
     * <p>Business Name: Submitted Unit Amount Price</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementDetail.unitPriceAmt</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setUnitPriceAmt(Ratio<Money, PhysicalQuantity> unitPriceAmt) {
        this.unitPriceAmt.setValue(unitPriceAmt);
    }


    /**
     * <p>Business Name: Submitted Invoice Line Amount</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementDetail.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }

    /**
     * <p>Business Name: Submitted Invoice Line Amount</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementDetail.netAmt</p>
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
     * FICR_MT600201CA.InvoiceElementDetail.factorNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-*)</p>
     */
    @Hl7XmlMapping({"factorNumber"})
    public List<BigDecimal> getFactorNumber() {
        return new RawListWrapper<REAL, BigDecimal>(factorNumber, REALImpl.class);
    }

}
