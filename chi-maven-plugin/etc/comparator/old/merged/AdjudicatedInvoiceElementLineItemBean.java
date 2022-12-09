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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.ficr_mt610201ca.AdjudicatedInvoiceElementChoiceBean;



@Hl7PartTypeMapping({"COCT_MT680000CA.AdjudicatedInvoiceElementDetail","FICR_MT610201CA.AdjudicatedInvoiceElementDetail"})
public class AdjudicatedInvoiceElementLineItemBean extends MessagePartBean implements ca.infoway.messagebuilder.model.common.coct_mt680000ca.AdjudicatedInvoiceElementChoiceBean, AdjudicatedInvoiceElementChoiceBean {

    private CV<Code> code = new CVImpl<Code>();
    private PQ unitQuantity = new PQImpl();
    private RTO<Money, PhysicalQuantity> unitPriceAmt = new RTOImpl<Money, PhysicalQuantity>();
    private MO netAmt = new MOImpl();
    private INT factorNumber = new INTImpl();
    private II adjudicatedInvoiceElementIdentifier = new IIImpl();

    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping({"unitQuantity"})
    public PhysicalQuantity getUnitQuantity() {
        return this.unitQuantity.getValue();
    }
    public void setUnitQuantity(PhysicalQuantity unitQuantity) {
        this.unitQuantity.setValue(unitQuantity);
    }

    @Hl7XmlMapping({"unitPriceAmt"})
    public Ratio<Money, PhysicalQuantity> getUnitPriceAmt() {
        return this.unitPriceAmt.getValue();
    }
    public void setUnitPriceAmt(Ratio<Money, PhysicalQuantity> unitPriceAmt) {
        this.unitPriceAmt.setValue(unitPriceAmt);
    }

    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }

    @Hl7XmlMapping({"factorNumber"})
    public java.lang.Integer getFactorNumber() {
        return this.factorNumber.getValue();
    }
    public void setFactorNumber(java.lang.Integer factorNumber) {
        this.factorNumber.setValue(factorNumber);
    }

    @Hl7XmlMapping({"id"})
    public Identifier getAdjudicatedInvoiceElementIdentifier() {
        return this.adjudicatedInvoiceElementIdentifier.getValue();
    }
    public void setAdjudicatedInvoiceElementIdentifier(Identifier adjudicatedInvoiceElementIdentifier) {
        this.adjudicatedInvoiceElementIdentifier.setValue(adjudicatedInvoiceElementIdentifier);
    }

}