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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.InvoiceElementDetailBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.InvoiceTypeBean;



/**
 * <p>COCT_MT680000CA.AdjudicationResultReference: (no business 
 * name)</p>
 * 
 * <p><p>Each submitted invoice element must have 1 
 * AdjudicationResults instance unless its parent is 
 * adjudicated as submitted</p></p>
 * 
 * <p><p>Multiple references to submitted invoice elements 
 * provides support for code substitution where the number of 
 * submitted fee items is consolidated on the adjudication 
 * results (e.g. 3 items to 1)</p></p>
 * 
 * <p>FICR_MT610201CA.AdjudicationResultReference: (no business 
 * name)</p>
 * 
 * <p><p>Each submitted invoice element must have 1 
 * AdjudicationResults instance unless its parent is 
 * adjudicated as submitted</p><p>Association mandatory for 
 * Root AdjudicatedInvoiceElementGroup and all associations 
 * that point to submitted invoice elements.</p></p>
 * 
 * <p><p>Each submitted invoice element must have 1 
 * AdjudicationResults instance unless its parent is 
 * adjudicated as submitted</p><p>Association mandatory for 
 * Root AdjudicatedInvoiceElementGroup and all associations 
 * that point to submitted invoice elements.</p></p>
 * 
 * <p><p>Multiple references to submitted invoice elements 
 * provides support for code substitution where the number of 
 * submitted fee items is consolidated on the adjudication 
 * results (e.g. 3 items to 1)</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT680000CA.AdjudicationResultReference","FICR_MT610201CA.AdjudicationResultReference"})
public class AdjudicationResultReferenceBean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private InvoiceElementChoice invoiceElementChoice;


    @Hl7XmlMapping({"invoiceElementChoice"})
    public InvoiceElementChoice getInvoiceElementChoice() {
        return this.invoiceElementChoice;
    }
    public void setInvoiceElementChoice(InvoiceElementChoice invoiceElementChoice) {
        this.invoiceElementChoice = invoiceElementChoice;
    }

    public InvoiceTypeBean getInvoiceElementChoiceAsInvoiceElementGroup() {
        return this.invoiceElementChoice instanceof InvoiceTypeBean ? (InvoiceTypeBean) this.invoiceElementChoice : null;
    }
    public boolean hasInvoiceElementChoiceAsInvoiceElementGroup() {
        return (this.invoiceElementChoice instanceof InvoiceTypeBean);
    }

    public InvoiceElementDetailBean getInvoiceElementChoiceAsInvoiceElementDetail() {
        return this.invoiceElementChoice instanceof InvoiceElementDetailBean ? (InvoiceElementDetailBean) this.invoiceElementChoice : null;
    }
    public boolean hasInvoiceElementChoiceAsInvoiceElementDetail() {
        return (this.invoiceElementChoice instanceof InvoiceElementDetailBean);
    }

}
