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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt510201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT510201CA.Component"})
public class ComponentBean extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private AdjudicatedInvoiceElementChoice adjudicatedInvoiceElementChoice;


    /**
     * <p>Relationship: 
     * FICR_MT510201CA.Component.adjudicatedInvoiceElementChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"adjudicatedInvoiceElementChoice"})
    public AdjudicatedInvoiceElementChoice getAdjudicatedInvoiceElementChoice() {
        return this.adjudicatedInvoiceElementChoice;
    }

    /**
     * <p>Relationship: 
     * FICR_MT510201CA.Component.adjudicatedInvoiceElementChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setAdjudicatedInvoiceElementChoice(AdjudicatedInvoiceElementChoice adjudicatedInvoiceElementChoice) {
        this.adjudicatedInvoiceElementChoice = adjudicatedInvoiceElementChoice;
    }

    public FinancialTransactionIntentBean getAdjudicatedInvoiceElementChoiceAsAdjudicatedInvoiceElementGroup() {
        return this.adjudicatedInvoiceElementChoice instanceof FinancialTransactionIntentBean ? (FinancialTransactionIntentBean) this.adjudicatedInvoiceElementChoice : null;
    }
    public boolean hasAdjudicatedInvoiceElementChoiceAsAdjudicatedInvoiceElementGroup() {
        return (this.adjudicatedInvoiceElementChoice instanceof FinancialTransactionIntentBean);
    }

    public AdjudicatedInvoiceElementDetailBean getAdjudicatedInvoiceElementChoiceAsAdjudicatedInvoiceElementDetail() {
        return this.adjudicatedInvoiceElementChoice instanceof AdjudicatedInvoiceElementDetailBean ? (AdjudicatedInvoiceElementDetailBean) this.adjudicatedInvoiceElementChoice : null;
    }
    public boolean hasAdjudicatedInvoiceElementChoiceAsAdjudicatedInvoiceElementDetail() {
        return (this.adjudicatedInvoiceElementChoice instanceof AdjudicatedInvoiceElementDetailBean);
    }

}
