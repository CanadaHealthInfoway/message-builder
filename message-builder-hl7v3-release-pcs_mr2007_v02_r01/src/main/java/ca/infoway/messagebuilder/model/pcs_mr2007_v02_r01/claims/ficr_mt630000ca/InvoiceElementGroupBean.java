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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt630000ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.merged.AdjudicatedInvoiceElementGroupBean;

import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT630000CA.InvoiceElementGroup"})
@Hl7RootType
public class InvoiceElementGroupBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private II invoiceGroupID = new IIImpl();
    private CV invoiceType = new CVImpl();
    private MO invoiceSubTotal = new MOImpl();
    private List<AdjudicatedInvoiceElementGroupBean> referenceAdjudicatedInvoiceElementGroup = new ArrayList<AdjudicatedInvoiceElementGroupBean>();


    /**
     * <p>Invoice Group ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getInvoiceGroupID() {
        return this.invoiceGroupID.getValue();
    }
    public void setInvoiceGroupID(Identifier invoiceGroupID) {
        this.invoiceGroupID.setValue(invoiceGroupID);
    }


    /**
     * <p>Invoice Type</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getInvoiceType() {
        return (Code) this.invoiceType.getValue();
    }
    public void setInvoiceType(Code invoiceType) {
        this.invoiceType.setValue(invoiceType);
    }


    /**
     * <p>Invoice Sub-total</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getInvoiceSubTotal() {
        return this.invoiceSubTotal.getValue();
    }
    public void setInvoiceSubTotal(Money invoiceSubTotal) {
        this.invoiceSubTotal.setValue(invoiceSubTotal);
    }


    @Hl7XmlMapping({"reference/adjudicatedInvoiceElementGroup"})
    public List<AdjudicatedInvoiceElementGroupBean> getReferenceAdjudicatedInvoiceElementGroup() {
        return this.referenceAdjudicatedInvoiceElementGroup;
    }

}
