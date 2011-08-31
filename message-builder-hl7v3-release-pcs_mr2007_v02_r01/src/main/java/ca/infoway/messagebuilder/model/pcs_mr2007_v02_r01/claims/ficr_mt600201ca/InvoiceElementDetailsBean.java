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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt600201ca;

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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt280001ca.A_BillableActChoice;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt280001ca.CrossReferenceBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt290000ca.BillableClinicalServiceBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt300000ca.PharmacyDispenseBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt490000ca.BillableClinicalProductBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT600201CA.InvoiceElementDetail"})
public class InvoiceElementDetailsBean extends MessagePartBean implements InvoiceElementChoice {

    private static final long serialVersionUID = 20110831L;
    private List<A_BillableActChoice> reasonOfBillableActChoice = new ArrayList<A_BillableActChoice>();
    private II submittedInvoiceLineIdentifier = new IIImpl();
    private CV submittedProductServiceCode = new CVImpl();
    private PQ submittedUnitQuantity = new PQImpl();
    private RTO<Money, PhysicalQuantity> submittedUnitAmountPrice = new RTOImpl<Money, PhysicalQuantity>();
    private MO submittedInvoiceLineAmount = new MOImpl();
    private INT factorNumber = new INTImpl();


    @Hl7XmlMapping({"reasonOf/billableActChoice"})
    public List<A_BillableActChoice> getReasonOfBillableActChoice() {
        return this.reasonOfBillableActChoice;
    }


    /**
     * <p>Submitted Invoice Line Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getSubmittedInvoiceLineIdentifier() {
        return this.submittedInvoiceLineIdentifier.getValue();
    }
    public void setSubmittedInvoiceLineIdentifier(Identifier submittedInvoiceLineIdentifier) {
        this.submittedInvoiceLineIdentifier.setValue(submittedInvoiceLineIdentifier);
    }


    /**
     * <p>Submitted Product/Service Code</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getSubmittedProductServiceCode() {
        return (Code) this.submittedProductServiceCode.getValue();
    }
    public void setSubmittedProductServiceCode(Code submittedProductServiceCode) {
        this.submittedProductServiceCode.setValue(submittedProductServiceCode);
    }


    /**
     * <p>Submitted Unit Quantity</p>
     */
    @Hl7XmlMapping({"unitQuantity"})
    public PhysicalQuantity getSubmittedUnitQuantity() {
        return this.submittedUnitQuantity.getValue();
    }
    public void setSubmittedUnitQuantity(PhysicalQuantity submittedUnitQuantity) {
        this.submittedUnitQuantity.setValue(submittedUnitQuantity);
    }


    /**
     * <p>Submitted Unit Amount Price</p>
     */
    @Hl7XmlMapping({"unitPriceAmt"})
    public Ratio<Money, PhysicalQuantity> getSubmittedUnitAmountPrice() {
        return this.submittedUnitAmountPrice.getValue();
    }
    public void setSubmittedUnitAmountPrice(Ratio<Money, PhysicalQuantity> submittedUnitAmountPrice) {
        this.submittedUnitAmountPrice.setValue(submittedUnitAmountPrice);
    }


    /**
     * <p>Submitted Invoice Line Amount</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getSubmittedInvoiceLineAmount() {
        return this.submittedInvoiceLineAmount.getValue();
    }
    public void setSubmittedInvoiceLineAmount(Money submittedInvoiceLineAmount) {
        this.submittedInvoiceLineAmount.setValue(submittedInvoiceLineAmount);
    }


    @Hl7XmlMapping({"factorNumber"})
    public Integer getFactorNumber() {
        return this.factorNumber.getValue();
    }
    public void setFactorNumber(Integer factorNumber) {
        this.factorNumber.setValue(factorNumber);
    }

}
