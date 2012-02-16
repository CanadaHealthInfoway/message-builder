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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged.InvoiceElementDetailBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged.PaymentIntentBean;



/**
 * <p>Component Invoice element</p>
 * 
 * <p><p>At most 5 levels of recursion, with n children at each 
 * level. Root level counts as level 1.</p></p>
 * 
 * <p><p>Note: Levels of nesting cannot be specified, as the 
 * maximum cardinality only applies to immediate children of 
 * this act, not the levels of nesting.</p></p>
 * 
 * <p><p>Levels of nesting cannot be specified, as the maximum 
 * cardinality only applies to immediate children of this act, 
 * not the levels of nesting.</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatedInvoiceElementComponent"})
public class ComponentInvoiceElementBean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private AdjudicatedInvoiceElementChoice adjudicatedInvoiceElementChoice;


    @Hl7XmlMapping({"adjudicatedInvoiceElementChoice"})
    public AdjudicatedInvoiceElementChoice getAdjudicatedInvoiceElementChoice() {
        return this.adjudicatedInvoiceElementChoice;
    }
    public void setAdjudicatedInvoiceElementChoice(AdjudicatedInvoiceElementChoice adjudicatedInvoiceElementChoice) {
        this.adjudicatedInvoiceElementChoice = adjudicatedInvoiceElementChoice;
    }

    public PaymentIntentBean getAdjudicatedInvoiceElementChoiceAsAdjudicatedInvoiceElementGroup() {
        return this.adjudicatedInvoiceElementChoice instanceof PaymentIntentBean ? (PaymentIntentBean) this.adjudicatedInvoiceElementChoice : null;
    }
    public boolean hasAdjudicatedInvoiceElementChoiceAsAdjudicatedInvoiceElementGroup() {
        return (this.adjudicatedInvoiceElementChoice instanceof PaymentIntentBean);
    }

    public InvoiceElementDetailBean getAdjudicatedInvoiceElementChoiceAsAdjudicatedInvoiceElementDetail() {
        return this.adjudicatedInvoiceElementChoice instanceof InvoiceElementDetailBean ? (InvoiceElementDetailBean) this.adjudicatedInvoiceElementChoice : null;
    }
    public boolean hasAdjudicatedInvoiceElementChoiceAsAdjudicatedInvoiceElementDetail() {
        return (this.adjudicatedInvoiceElementChoice instanceof InvoiceElementDetailBean);
    }

}
