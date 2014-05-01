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
package ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.coct_mt680000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.merged.InvoiceElementChoice;



@Hl7PartTypeMapping({"COCT_MT680000CA.InvoiceElementComponent"})
public class InvoiceElementComponentBean extends MessagePartBean {

    private static final long serialVersionUID = 20140501L;
    private InvoiceElementChoice invoiceElementChoice;


    /**
     * <p>Relationship: 
     * COCT_MT680000CA.InvoiceElementComponent.invoiceElementChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"invoiceElementChoice"})
    public InvoiceElementChoice getInvoiceElementChoice() {
        return this.invoiceElementChoice;
    }

    /**
     * <p>Relationship: 
     * COCT_MT680000CA.InvoiceElementComponent.invoiceElementChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInvoiceElementChoice(InvoiceElementChoice invoiceElementChoice) {
        this.invoiceElementChoice = invoiceElementChoice;
    }

    public InventElementChoiceBean getInvoiceElementChoiceAsInvoiceElementIntent1() {
        return this.invoiceElementChoice instanceof InventElementChoiceBean ? (InventElementChoiceBean) this.invoiceElementChoice : null;
    }
    public boolean hasInvoiceElementChoiceAsInvoiceElementIntent1() {
        return (this.invoiceElementChoice instanceof InventElementChoiceBean);
    }

    public InvoiceElementIntent2Bean getInvoiceElementChoiceAsInvoiceElementIntent2() {
        return this.invoiceElementChoice instanceof InvoiceElementIntent2Bean ? (InvoiceElementIntent2Bean) this.invoiceElementChoice : null;
    }
    public boolean hasInvoiceElementChoiceAsInvoiceElementIntent2() {
        return (this.invoiceElementChoice instanceof InvoiceElementIntent2Bean);
    }

}
