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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged;

import ca.infoway.messagebuilder.Code;
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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt280001ca.A_BillableActChoice;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>FICR_MT500201CA.InvoiceElementDetail: (no business name)</p>
 * 
 * <p><p>RTO used to specify 15 pills (each) out of a bottle of 
 * 100 pills (each) to reflect billing for a portion of a 
 * package (e.g. 0.15 of a bottle)</p></p>
 * 
 * <p>FICR_MT600201CA.InvoiceElementDetail: (no business name)</p>
 * 
 * <p><p>RTO used to specify 15 pills (each) out of a bottle of 
 * 100 pills (each) to reflect billing for a portion of a 
 * package (e.g. 0.15 of a bottle)</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT500201CA.InvoiceElementDetail","FICR_MT510201CA.InvoiceElementDetail","FICR_MT600201CA.InvoiceElementDetail","FICR_MT610201CA.InvoiceElementDetail"})
public class InvoiceElementDetailBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.InvoiceElementChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt600201ca.InvoiceElementChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt500201ca.InvoiceElementChoice {

    private static final long serialVersionUID = 20120106L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private MO netAmt = new MOImpl();
    private List<A_BillableActChoice> reasonOfBillableActChoice = new ArrayList<A_BillableActChoice>();
    private PQ unitQuantity = new PQImpl();
    private RTO<Money, PhysicalQuantity> unitPriceAmt = new RTOImpl<Money, PhysicalQuantity>();
    private REAL factorNumber = new REALImpl();


    /**
     * <p>SubmittedInvoiceLineIdentifier</p>
     * 
     * <p>Submitted Invoice Line Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>SubmittedProductServiceCode</p>
     * 
     * <p>Submitted Product/Service Code</p>
     * 
     * <p>Submitted product/Service code</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>SubmittedInvoiceLineAmount</p>
     * 
     * <p>Submitted Invoice Line Amount</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    @Hl7XmlMapping({"reasonOf/billableActChoice"})
    public List<A_BillableActChoice> getReasonOfBillableActChoice() {
        return this.reasonOfBillableActChoice;
    }


    /**
     * <p>SubmittedUnitQuantity</p>
     * 
     * <p>Submitted Unit Quantity</p>
     */
    @Hl7XmlMapping({"unitQuantity"})
    public PhysicalQuantity getUnitQuantity() {
        return this.unitQuantity.getValue();
    }
    public void setUnitQuantity(PhysicalQuantity unitQuantity) {
        this.unitQuantity.setValue(unitQuantity);
    }


    /**
     * <p>SubmittedUnitAmountPrice</p>
     * 
     * <p>Submitted Unit Amount Price</p>
     */
    @Hl7XmlMapping({"unitPriceAmt"})
    public Ratio<Money, PhysicalQuantity> getUnitPriceAmt() {
        return this.unitPriceAmt.getValue();
    }
    public void setUnitPriceAmt(Ratio<Money, PhysicalQuantity> unitPriceAmt) {
        this.unitPriceAmt.setValue(unitPriceAmt);
    }


    /**
     * <p>Multiplier, e.g. 0.07</p>
     * 
     * <p>Tax % applied to unitPriceAmt.</p>
     */
    @Hl7XmlMapping({"factorNumber"})
    public BigDecimal getFactorNumber() {
        return this.factorNumber.getValue();
    }
    public void setFactorNumber(BigDecimal factorNumber) {
        this.factorNumber.setValue(factorNumber);
    }

}
