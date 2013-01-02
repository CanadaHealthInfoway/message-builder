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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged;

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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.coct_mt280001ca.A_BillableActChoice;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.domainvalue.ActInvoiceDetailCode;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: InvoiceElementDetails</p>
 * 
 * <p>FICR_MT600201CA.InvoiceElementDetail: Invoice Element 
 * Details</p>
 * 
 * <p>Domain for InvoiceElementDetail.code is 
 * GenericBillableItemModifier</p>
 * 
 * <p>RTO used to specify 15 pills (each) out of a bottle of 
 * 100 pills (each) to reflect billing for a portion of a 
 * package (e.g. 0.15 of a bottle)</p>
 * 
 * <p>The details of the Invoice item billed for, as in the 
 * product or service.</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.InvoiceElementDetail","FICR_MT610201CA.InvoiceElementDetail"})
public class SubmittedInvoiceElementDetailsBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt600201ca.InvoiceElementChoice, InvoiceElementChoice {

    private static final long serialVersionUID = 20121204L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private MO netAmt = new MOImpl();
    private List<A_BillableActChoice> reasonOfBillableActChoice = new ArrayList<A_BillableActChoice>();
    private PQ unitQuantity = new PQImpl();
    private RTO<Money, PhysicalQuantity> unitPriceAmt = new RTOImpl<Money, PhysicalQuantity>();
    private INT factorNumber = new INTImpl();


    /**
     * <p>Business Name: SubmittedInvoiceLineIdentifier</p>
     * 
     * <p>Un-merged Business Name: SubmittedInvoiceLineIdentifier</p>
     * 
     * <p>Relationship: FICR_MT610201CA.InvoiceElementDetail.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Only one identifier for an Invoice Detail is allowed.</p>
     * 
     * <p>OID (object identifier) + unique number generated by the 
     * pharmacy software for the specific invoice element 
     * detail.</p><p>The identifier will be the same as its parent 
     * Invoice Element Group, appended with a &quot;.x&quot;, where 
     * &quot;x&quot; is a number siginifying the occurence of this 
     * item under its parent. For example, the parent id is 
     * &quot;12942&quot; and this is the 2nd item under the parent. 
     * Therefore, the id for this item would be 
     * &quot;12942.2&quot;.</p><p>Must not be the same identifier 
     * as the PaymentRequest.id or the InvoiceElementGroup.id.</p>
     * 
     * <p>Submitted Invoice Line Identifier. OID (object 
     * identifier) + unique number generated by the pharmacy 
     * software for the specific invoice element detail</p>
     * 
     * <p>Un-merged Business Name: SubmittedInvoiceLineIdentifier</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementDetail.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Only one identifier for an Invoice Detail is allowed.</p>
     * 
     * <p>OID (object identifier) + unique number generated by the 
     * pharmacy software for the specific invoice element 
     * detail.</p><p>The identifier will be the same as its parent 
     * Invoice Element Group, appended with a &quot;.x&quot;, where 
     * &quot;x&quot; is a number siginifying the occurence of this 
     * item under its parent. For example, the parent id is 
     * &quot;12942&quot; and this is the 2nd item under the parent. 
     * Therefore, the id for this item would be 
     * &quot;12942.2&quot;.</p><p>Must not be the same identifier 
     * as the PaymentRequest.id or the InvoiceElementGroup.id.</p>
     * 
     * <p>Set of identifiers that uniquely identify the Invoice 
     * Line item.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: SubmittedInvoiceLineIdentifier</p>
     * 
     * <p>Un-merged Business Name: SubmittedInvoiceLineIdentifier</p>
     * 
     * <p>Relationship: FICR_MT610201CA.InvoiceElementDetail.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Only one identifier for an Invoice Detail is allowed.</p>
     * 
     * <p>OID (object identifier) + unique number generated by the 
     * pharmacy software for the specific invoice element 
     * detail.</p><p>The identifier will be the same as its parent 
     * Invoice Element Group, appended with a &quot;.x&quot;, where 
     * &quot;x&quot; is a number siginifying the occurence of this 
     * item under its parent. For example, the parent id is 
     * &quot;12942&quot; and this is the 2nd item under the parent. 
     * Therefore, the id for this item would be 
     * &quot;12942.2&quot;.</p><p>Must not be the same identifier 
     * as the PaymentRequest.id or the InvoiceElementGroup.id.</p>
     * 
     * <p>Submitted Invoice Line Identifier. OID (object 
     * identifier) + unique number generated by the pharmacy 
     * software for the specific invoice element detail</p>
     * 
     * <p>Un-merged Business Name: SubmittedInvoiceLineIdentifier</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementDetail.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Only one identifier for an Invoice Detail is allowed.</p>
     * 
     * <p>OID (object identifier) + unique number generated by the 
     * pharmacy software for the specific invoice element 
     * detail.</p><p>The identifier will be the same as its parent 
     * Invoice Element Group, appended with a &quot;.x&quot;, where 
     * &quot;x&quot; is a number siginifying the occurence of this 
     * item under its parent. For example, the parent id is 
     * &quot;12942&quot; and this is the 2nd item under the parent. 
     * Therefore, the id for this item would be 
     * &quot;12942.2&quot;.</p><p>Must not be the same identifier 
     * as the PaymentRequest.id or the InvoiceElementGroup.id.</p>
     * 
     * <p>Set of identifiers that uniquely identify the Invoice 
     * Line item.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: SubmittedProductServiceCode</p>
     * 
     * <p>Un-merged Business Name: SubmittedProductServiceCode</p>
     * 
     * <p>Relationship: FICR_MT610201CA.InvoiceElementDetail.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Adjudication Results: each Invoice Element Group or 
     * Detail that has been submitted must have a corresponding 
     * response with the same Invoice Element code. There may be 
     * additional Invoice Elements in the adjudication results for 
     * situations like code substitution.</p><p>Modifiers for the 
     * codes are taken from the same domain (i.e 
     * ActPoductServiceBillableItemCode).</p><p>Codes for this 
     * domain include intervention/procedure codes (e.g. CCI), 
     * product codes (e.g. HCPCS), pharmacy product codes (e.g. 
     * DIN). The code set also includes generic codes, applicable 
     * to all benefit groups, for specification of taxes, 
     * surcharges and discounts.</p><p>There are specific rules, by 
     * code set, for specification of these codes (e.g. CCI codes 
     * are stripped of punctuation).</p>
     * 
     * <p>RxS1: Select one of MARKUP (markup), PROFFEE 
     * (professional fee), or &lt;DIN&gt;/&lt;GTIN&gt;/&lt;UPC&gt; 
     * (drug), depending on what invoice element detail is being 
     * described.).</p>
     * 
     * <p>Product/Service Code, e.g. Office Visit ,Taxes, Markup, 
     * Dispense. Modifier e.g. northern isolation,off hours 
     * specialty, on call.</p>
     * 
     * <p>Un-merged Business Name: SubmittedProductServiceCode</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementDetail.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>RxS1: Select one of MARKUP (markup), PROFFEE 
     * (professional fee), or &lt;DIN&gt;/&lt;GTIN&gt;/&lt;UPC&gt; 
     * (drug), depending on what invoice element detail is being 
     * described.</p>
     * 
     * <p>There are specific rules, by code set, for specification 
     * of these codes (e.g. CCI codes are stripped of 
     * punctuation).</p>
     * 
     * <p>For Adjudication Results: each Invoice Element Group or 
     * Detail that has been submitted must have a corresponding 
     * response with the same Invoice Element code. There may be 
     * additional Invoice Elements in the adjudication results for 
     * situations like code substitution.</p><p>Modifiers for the 
     * codes are taken from the same domain (i.e 
     * ActPoductServiceBillableItemCode).</p><p>Codes for this 
     * domain include intervention/procedure codes (e.g. CCI), 
     * product codes (e.g. HCPCS), pharmacy product codes (e.g. 
     * DIN). The code set also includes generic codes, applicable 
     * to all benefit groups, for specification of taxes, 
     * surcharges and discounts.</p><p>There are specific rules, by 
     * code set, for specification of these codes (e.g. CCI codes 
     * are stripped of punctuation).</p>
     * 
     * <p>Product/Service Code e.g. Office Visit ,Taxes, Markup, 
     * Dispense + Product/Service Code Modifier e.g. northern 
     * isolation, off hours, specialty, on call. Also allows for 
     * specification of equivalents for each code for each 
     * Payor</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceDetailCode getCode() {
        return (ActInvoiceDetailCode) this.code.getValue();
    }

    /**
     * <p>Business Name: SubmittedProductServiceCode</p>
     * 
     * <p>Un-merged Business Name: SubmittedProductServiceCode</p>
     * 
     * <p>Relationship: FICR_MT610201CA.InvoiceElementDetail.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Adjudication Results: each Invoice Element Group or 
     * Detail that has been submitted must have a corresponding 
     * response with the same Invoice Element code. There may be 
     * additional Invoice Elements in the adjudication results for 
     * situations like code substitution.</p><p>Modifiers for the 
     * codes are taken from the same domain (i.e 
     * ActPoductServiceBillableItemCode).</p><p>Codes for this 
     * domain include intervention/procedure codes (e.g. CCI), 
     * product codes (e.g. HCPCS), pharmacy product codes (e.g. 
     * DIN). The code set also includes generic codes, applicable 
     * to all benefit groups, for specification of taxes, 
     * surcharges and discounts.</p><p>There are specific rules, by 
     * code set, for specification of these codes (e.g. CCI codes 
     * are stripped of punctuation).</p>
     * 
     * <p>RxS1: Select one of MARKUP (markup), PROFFEE 
     * (professional fee), or &lt;DIN&gt;/&lt;GTIN&gt;/&lt;UPC&gt; 
     * (drug), depending on what invoice element detail is being 
     * described.).</p>
     * 
     * <p>Product/Service Code, e.g. Office Visit ,Taxes, Markup, 
     * Dispense. Modifier e.g. northern isolation,off hours 
     * specialty, on call.</p>
     * 
     * <p>Un-merged Business Name: SubmittedProductServiceCode</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementDetail.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>RxS1: Select one of MARKUP (markup), PROFFEE 
     * (professional fee), or &lt;DIN&gt;/&lt;GTIN&gt;/&lt;UPC&gt; 
     * (drug), depending on what invoice element detail is being 
     * described.</p>
     * 
     * <p>There are specific rules, by code set, for specification 
     * of these codes (e.g. CCI codes are stripped of 
     * punctuation).</p>
     * 
     * <p>For Adjudication Results: each Invoice Element Group or 
     * Detail that has been submitted must have a corresponding 
     * response with the same Invoice Element code. There may be 
     * additional Invoice Elements in the adjudication results for 
     * situations like code substitution.</p><p>Modifiers for the 
     * codes are taken from the same domain (i.e 
     * ActPoductServiceBillableItemCode).</p><p>Codes for this 
     * domain include intervention/procedure codes (e.g. CCI), 
     * product codes (e.g. HCPCS), pharmacy product codes (e.g. 
     * DIN). The code set also includes generic codes, applicable 
     * to all benefit groups, for specification of taxes, 
     * surcharges and discounts.</p><p>There are specific rules, by 
     * code set, for specification of these codes (e.g. CCI codes 
     * are stripped of punctuation).</p>
     * 
     * <p>Product/Service Code e.g. Office Visit ,Taxes, Markup, 
     * Dispense + Product/Service Code Modifier e.g. northern 
     * isolation, off hours, specialty, on call. Also allows for 
     * specification of equivalents for each code for each 
     * Payor</p>
     */
    public void setCode(ActInvoiceDetailCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: SubmittedInvoiceLineAmount</p>
     * 
     * <p>Un-merged Business Name: SubmittedInvoiceLineAmount</p>
     * 
     * <p>Relationship: FICR_MT610201CA.InvoiceElementDetail.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute cannot be mandatory as it may not be present 
     * for a Coverage Extension Request.</p><p>Field length for 
     * value (amount) includes a decimal point. Decimal point MUST 
     * be specified with 2 and only 2 digits of precision. Example: 
     * &quot;150.12&quot;.</p>
     * 
     * <p>RxS1: For the &lt;DIN&gt;/&lt;GTIN&gt;/&lt;UPC&gt; 
     * invoice element detail, specifiy as &quot;x&quot; dollars. 
     * E.g. &quot;50.00&quot; &quot;CAD&quot;.</p><p>RxS1: For the 
     * MARKUP, PROFFEE invoice element details, specify as 
     * &quot;x&quot; dollars. E.g. &quot;12.00&quot; 
     * &quot;CAD&quot;</p>
     * 
     * <p>The amount billed for the Invoice Line product or 
     * service. This is the result of Submitted Unit Quantity * 
     * Submitted Unit Amount Price.</p>
     * 
     * <p>Un-merged Business Name: SubmittedInvoiceLineAmount</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementDetail.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Derived as numerator of UnitQuantity * 
     * UnitPriceAmt.</p><p>Attribute cannot be mandatory as it may 
     * not be present for a Coverage Extension Request.</p><p>Field 
     * length for value (amount) includes a decimal point. Decimal 
     * point MUST be specified with 2 and only 2 digits of 
     * precision. Example: &quot;150.12&quot;.</p><p>Example: 
     * &lt;netAmt value=&quot;5000.00&quot; 
     * currency=&quot;CAD&quot;/&gt;</p>
     * 
     * <p>RxS1: For the &lt;DIN&gt;/&lt;GTIN&gt;/&lt;UPC&gt; 
     * invoice element detail, specifiy as &quot;x&quot; dollars. 
     * E.g. &quot;50.00&quot; &quot;CAD&quot;.</p><p>RxS1: For the 
     * MARKUP, PROFFEE invoice element details, specify as 
     * &quot;x&quot; dollars. E.g. &quot;12.00&quot; 
     * &quot;CAD&quot;</p>
     * 
     * <p>The amount billed for the Invoice Line product or 
     * service. This is the result of Submitted Unit Quantity * 
     * Submitted Unit Amount Price.</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }

    /**
     * <p>Business Name: SubmittedInvoiceLineAmount</p>
     * 
     * <p>Un-merged Business Name: SubmittedInvoiceLineAmount</p>
     * 
     * <p>Relationship: FICR_MT610201CA.InvoiceElementDetail.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute cannot be mandatory as it may not be present 
     * for a Coverage Extension Request.</p><p>Field length for 
     * value (amount) includes a decimal point. Decimal point MUST 
     * be specified with 2 and only 2 digits of precision. Example: 
     * &quot;150.12&quot;.</p>
     * 
     * <p>RxS1: For the &lt;DIN&gt;/&lt;GTIN&gt;/&lt;UPC&gt; 
     * invoice element detail, specifiy as &quot;x&quot; dollars. 
     * E.g. &quot;50.00&quot; &quot;CAD&quot;.</p><p>RxS1: For the 
     * MARKUP, PROFFEE invoice element details, specify as 
     * &quot;x&quot; dollars. E.g. &quot;12.00&quot; 
     * &quot;CAD&quot;</p>
     * 
     * <p>The amount billed for the Invoice Line product or 
     * service. This is the result of Submitted Unit Quantity * 
     * Submitted Unit Amount Price.</p>
     * 
     * <p>Un-merged Business Name: SubmittedInvoiceLineAmount</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementDetail.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Derived as numerator of UnitQuantity * 
     * UnitPriceAmt.</p><p>Attribute cannot be mandatory as it may 
     * not be present for a Coverage Extension Request.</p><p>Field 
     * length for value (amount) includes a decimal point. Decimal 
     * point MUST be specified with 2 and only 2 digits of 
     * precision. Example: &quot;150.12&quot;.</p><p>Example: 
     * &lt;netAmt value=&quot;5000.00&quot; 
     * currency=&quot;CAD&quot;/&gt;</p>
     * 
     * <p>RxS1: For the &lt;DIN&gt;/&lt;GTIN&gt;/&lt;UPC&gt; 
     * invoice element detail, specifiy as &quot;x&quot; dollars. 
     * E.g. &quot;50.00&quot; &quot;CAD&quot;.</p><p>RxS1: For the 
     * MARKUP, PROFFEE invoice element details, specify as 
     * &quot;x&quot; dollars. E.g. &quot;12.00&quot; 
     * &quot;CAD&quot;</p>
     * 
     * <p>The amount billed for the Invoice Line product or 
     * service. This is the result of Submitted Unit Quantity * 
     * Submitted Unit Amount Price.</p>
     */
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
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
     * <p>Business Name: SubmittedUnitQuantity</p>
     * 
     * <p>Un-merged Business Name: SubmittedUnitQuantity</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementDetail.unitQuantity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Field length for value (value) may include a decimal 
     * point (e.g. 3.5 hours) with no restriction on the number of 
     * digits past the decimal point.</p><p>Attribute cannot be 
     * mandatory as it may not be present for a Coverage Extension 
     * Request.</p><p>Unit of measure for &quot;each&quot; is left 
     * null.</p><p>Example: &lt;numerator value=&quot;10&quot; 
     * unit=&quot;MG&quot;/&gt; &lt;denominator 
     * value=&quot;100&quot; unit=&quot;MG&quot;/&gt;</p>
     * 
     * <p>RxS1: For the &lt;DIN&gt;/&lt;GTIN&gt;/&lt;UPC&gt; 
     * invoice element detail, specifiy as &quot;x&quot; over 
     * &quot;y&quot; with no units of measure, where &quot;x&quot; 
     * is the number of pills and &quot;y&quot; is the package 
     * size. E.g. &quot;10&quot; over &quot;100&quot;.</p><p>RxS1: 
     * For the MARKUP, PROFFEE invoice element details, specify as 
     * 1 over 1. E.g. &quot;1&quot; over &quot;1&quot;.</p>
     * 
     * <p>A description of the number of instances of a product or 
     * service. I.e.. 4 hours, 4 mg, 4 boxes, 15 each of a 
     * container of 1000 each</p>
     */
    @Hl7XmlMapping({"unitQuantity"})
    public PhysicalQuantity getUnitQuantity() {
        return this.unitQuantity.getValue();
    }

    /**
     * <p>Business Name: SubmittedUnitQuantity</p>
     * 
     * <p>Un-merged Business Name: SubmittedUnitQuantity</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementDetail.unitQuantity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Field length for value (value) may include a decimal 
     * point (e.g. 3.5 hours) with no restriction on the number of 
     * digits past the decimal point.</p><p>Attribute cannot be 
     * mandatory as it may not be present for a Coverage Extension 
     * Request.</p><p>Unit of measure for &quot;each&quot; is left 
     * null.</p><p>Example: &lt;numerator value=&quot;10&quot; 
     * unit=&quot;MG&quot;/&gt; &lt;denominator 
     * value=&quot;100&quot; unit=&quot;MG&quot;/&gt;</p>
     * 
     * <p>RxS1: For the &lt;DIN&gt;/&lt;GTIN&gt;/&lt;UPC&gt; 
     * invoice element detail, specifiy as &quot;x&quot; over 
     * &quot;y&quot; with no units of measure, where &quot;x&quot; 
     * is the number of pills and &quot;y&quot; is the package 
     * size. E.g. &quot;10&quot; over &quot;100&quot;.</p><p>RxS1: 
     * For the MARKUP, PROFFEE invoice element details, specify as 
     * 1 over 1. E.g. &quot;1&quot; over &quot;1&quot;.</p>
     * 
     * <p>A description of the number of instances of a product or 
     * service. I.e.. 4 hours, 4 mg, 4 boxes, 15 each of a 
     * container of 1000 each</p>
     */
    public void setUnitQuantity(PhysicalQuantity unitQuantity) {
        this.unitQuantity.setValue(unitQuantity);
    }


    /**
     * <p>Business Name: SubmittedUnitAmountPrice</p>
     * 
     * <p>Un-merged Business Name: SubmittedUnitAmountPrice</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementDetail.unitPriceAmt</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Field length for value (amount) includes a decimal point. 
     * Decimal point MUST be specified with 2 and only 2 digits of 
     * precision. Example: &quot;150.12&quot;.</p><p>Attribute 
     * cannot be mandatory as it may not be present for a Coverage 
     * Extension Request.</p><p>Units for denominator must be the 
     * same as the units for the denominator of UnitPriceAmt. Value 
     * for denominator must be 1.</p><p>Example: &lt;numerator 
     * value=&quot;500.00&quot; currency=&quot;CAD&quot;/&gt; 
     * &lt;denominator value=&quot;1&quot; 
     * unit=&quot;MG&quot;/&gt;</p>
     * 
     * <p>RxS1: For the &lt;DIN&gt;/&lt;GTIN&gt;/&lt;UPC&gt; 
     * invoice element detail, specifiy as &quot;x&quot; dollars 
     * over (per) &quot;1&quot; pill, with no units of measure. 
     * E.g. &quot;5.00&quot; &quot;CAD&quot; over (per) 
     * &quot;1&quot;.</p><p>RxS1: For the MARKUP, PROFFEE invoice 
     * element details, specify as &quot;x&quot; dollars over (per) 
     * &quot;1&quot; unit, with no units of measure. E.g. 
     * &quot;12.00&quot; &quot;CAD&quot; over (per) 
     * &quot;1&quot;</p>
     * 
     * <p>The monetary cost per unit of the product or service. 
     * I.e.. $0.20/mg, $250/day, $50</p>
     */
    @Hl7XmlMapping({"unitPriceAmt"})
    public Ratio<Money, PhysicalQuantity> getUnitPriceAmt() {
        return this.unitPriceAmt.getValue();
    }

    /**
     * <p>Business Name: SubmittedUnitAmountPrice</p>
     * 
     * <p>Un-merged Business Name: SubmittedUnitAmountPrice</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementDetail.unitPriceAmt</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Field length for value (amount) includes a decimal point. 
     * Decimal point MUST be specified with 2 and only 2 digits of 
     * precision. Example: &quot;150.12&quot;.</p><p>Attribute 
     * cannot be mandatory as it may not be present for a Coverage 
     * Extension Request.</p><p>Units for denominator must be the 
     * same as the units for the denominator of UnitPriceAmt. Value 
     * for denominator must be 1.</p><p>Example: &lt;numerator 
     * value=&quot;500.00&quot; currency=&quot;CAD&quot;/&gt; 
     * &lt;denominator value=&quot;1&quot; 
     * unit=&quot;MG&quot;/&gt;</p>
     * 
     * <p>RxS1: For the &lt;DIN&gt;/&lt;GTIN&gt;/&lt;UPC&gt; 
     * invoice element detail, specifiy as &quot;x&quot; dollars 
     * over (per) &quot;1&quot; pill, with no units of measure. 
     * E.g. &quot;5.00&quot; &quot;CAD&quot; over (per) 
     * &quot;1&quot;.</p><p>RxS1: For the MARKUP, PROFFEE invoice 
     * element details, specify as &quot;x&quot; dollars over (per) 
     * &quot;1&quot; unit, with no units of measure. E.g. 
     * &quot;12.00&quot; &quot;CAD&quot; over (per) 
     * &quot;1&quot;</p>
     * 
     * <p>The monetary cost per unit of the product or service. 
     * I.e.. $0.20/mg, $250/day, $50</p>
     */
    public void setUnitPriceAmt(Ratio<Money, PhysicalQuantity> unitPriceAmt) {
        this.unitPriceAmt.setValue(unitPriceAmt);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementDetail.factorNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Factor numbers are used for taxes. They represent the 
     * percentage of tax applied to unitPriceAmt.</p>
     * 
     * <p>RxS1: Not permitted, as taxes are not included in this 
     * scenario.</p>
     * 
     * <p>Tax percentage applied to unitPriceAmt</p>
     */
    @Hl7XmlMapping({"factorNumber"})
    public Integer getFactorNumber() {
        return this.factorNumber.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementDetail.factorNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Factor numbers are used for taxes. They represent the 
     * percentage of tax applied to unitPriceAmt.</p>
     * 
     * <p>RxS1: Not permitted, as taxes are not included in this 
     * scenario.</p>
     * 
     * <p>Tax percentage applied to unitPriceAmt</p>
     */
    public void setFactorNumber(Integer factorNumber) {
        this.factorNumber.setValue(factorNumber);
    }

}
