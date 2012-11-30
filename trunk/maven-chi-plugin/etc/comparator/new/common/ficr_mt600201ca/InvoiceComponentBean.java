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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.ficr_mt600201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Invoice Component 
 * 
 * <p>This allows for an Invoice Grouping to be composed of one 
 * or more invoice element groups and/or details. There must be 
 * one leaf detail.Sequence number used to sequence invoice 
 * elements in an Invoice Grouping and will not be included in 
 * Adjudication Results. 
 * 
 * <p>At most 5 levels of recursion, with children at each 
 * level. Root level counts as level 1. 
 * 
 * <p>The number of children for each group cannot and should 
 * not be limited. 
 * 
 * <p>At most 5 levels of recursion, with children at each 
 * level. Root level counts as level 1. 
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.InvoiceElementComponent"})
public class InvoiceComponentBean extends MessagePartBean {

    private INT sequenceNumber = new INTImpl();
    private InvoiceElementChoiceBean invoiceElementChoice;

    @Hl7XmlMapping({"sequenceNumber"})
    public java.lang.Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }
    public void setSequenceNumber(java.lang.Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }

    @Hl7XmlMapping({"invoiceElementChoice"})
    public InvoiceElementChoiceBean getInvoiceElementChoice() {
        return this.invoiceElementChoice;
    }
    public void setInvoiceElementChoice(InvoiceElementChoiceBean invoiceElementChoice) {
        this.invoiceElementChoice = invoiceElementChoice;
    }

}
