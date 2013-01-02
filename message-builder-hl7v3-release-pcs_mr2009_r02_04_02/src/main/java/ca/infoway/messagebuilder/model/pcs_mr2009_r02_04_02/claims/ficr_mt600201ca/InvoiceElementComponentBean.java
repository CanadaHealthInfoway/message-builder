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
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.InvoiceTypeBean;



/**
 * <p>At most 5 levels of recursion, with n children at each 
 * level. Root level counts as level 1.</p>
 * 
 * <p>This allows for an Invoice Grouping to be composed of one 
 * or more invoice element groups and/or details. There must be 
 * one leaf detail.</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.InvoiceElementComponent"})
public class InvoiceElementComponentBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private INT sequenceNumber = new INTImpl();
    private InvoiceElementChoice invoiceElementChoice;


    /**
     * <p>Business Name: Invoice Element Sequence Number</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementComponent.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Business Name: Invoice Element Sequence Number</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementComponent.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementComponent.invoiceElementChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"invoiceElementChoice"})
    public InvoiceElementChoice getInvoiceElementChoice() {
        return this.invoiceElementChoice;
    }

    /**
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementComponent.invoiceElementChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
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
