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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.coct_mt680000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.domainvalue.ActInvoiceDetailCode;



@Hl7PartTypeMapping({"COCT_MT680000CA.InvoiceElementIntent2"})
public class InvoiceElementIntent2Bean extends MessagePartBean implements InvoiceElementChoice {

    private static final long serialVersionUID = 20150328L;
    private CV code = new CVImpl();
    private PQ unitQuantity = new PQImpl();
    private RTO<Money, PhysicalQuantity> unitPriceAmt = new RTOImpl<Money, PhysicalQuantity>();
    private MO netAmt = new MOImpl();
    private INT factorNumber = new INTImpl();


    /**
     * <p>Business Name: Generic Service Codes</p>
     * 
     * <p>Relationship: COCT_MT680000CA.InvoiceElementIntent2.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Domain for InvoiceElementIntent2.code is 
     * GenericBillableItemModifier</p>
     * 
     * <p>(Product/Service Code e.g. Office Visit ,Taxes, Markup, 
     * Dispense, including Product/Service Code Modifier e.g. 
     * northern isolation, off hours specialty, on call</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceDetailCode getCode() {
        return (ActInvoiceDetailCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Generic Service Codes</p>
     * 
     * <p>Relationship: COCT_MT680000CA.InvoiceElementIntent2.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Domain for InvoiceElementIntent2.code is 
     * GenericBillableItemModifier</p>
     * 
     * <p>(Product/Service Code e.g. Office Visit ,Taxes, Markup, 
     * Dispense, including Product/Service Code Modifier e.g. 
     * northern isolation, off hours specialty, on call</p>
     */
    public void setCode(ActInvoiceDetailCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Unit Quantity</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.InvoiceElementIntent2.unitQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>e.g. 3 {boxes}</p>
     */
    @Hl7XmlMapping({"unitQuantity"})
    public PhysicalQuantity getUnitQuantity() {
        return this.unitQuantity.getValue();
    }

    /**
     * <p>Business Name: Unit Quantity</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.InvoiceElementIntent2.unitQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>e.g. 3 {boxes}</p>
     */
    public void setUnitQuantity(PhysicalQuantity unitQuantity) {
        this.unitQuantity.setValue(unitQuantity);
    }


    /**
     * <p>Business Name: Price per unit</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.InvoiceElementIntent2.unitPriceAmt</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>e.g. $50 CAD/ 1 {box}</p>
     */
    @Hl7XmlMapping({"unitPriceAmt"})
    public Ratio<Money, PhysicalQuantity> getUnitPriceAmt() {
        return this.unitPriceAmt.getValue();
    }

    /**
     * <p>Business Name: Price per unit</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.InvoiceElementIntent2.unitPriceAmt</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>e.g. $50 CAD/ 1 {box}</p>
     */
    public void setUnitPriceAmt(Ratio<Money, PhysicalQuantity> unitPriceAmt) {
        this.unitPriceAmt.setValue(unitPriceAmt);
    }


    /**
     * <p>Business Name: Total amount billed for line 
     * item/elements.</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.InvoiceElementIntent2.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>(= unit_qty * unit_price_amt * factor_nbr * points_nbr. 
     * E.g. $150 CAD</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }

    /**
     * <p>Business Name: Total amount billed for line 
     * item/elements.</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.InvoiceElementIntent2.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>(= unit_qty * unit_price_amt * factor_nbr * points_nbr. 
     * E.g. $150 CAD</p>
     */
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    /**
     * <p>Business Name: Factor Number</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.InvoiceElementIntent2.factorNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>multiplier, can be used for tax percentages such as 
     * 0.07</p>
     */
    @Hl7XmlMapping({"factorNumber"})
    public Integer getFactorNumber() {
        return this.factorNumber.getValue();
    }

    /**
     * <p>Business Name: Factor Number</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.InvoiceElementIntent2.factorNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>multiplier, can be used for tax percentages such as 
     * 0.07</p>
     */
    public void setFactorNumber(Integer factorNumber) {
        this.factorNumber.setValue(factorNumber);
    }

}
