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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.merged.AdjudicatedInvoiceElementLineItemBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.merged.AdjudicationResultIdentifierBean;



@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatedInvoiceElementComponent"})
public class ComponentInvoiceElementBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private AdjudicatedInvoiceElementChoice adjudicatedInvoiceElementChoice;


    @Hl7XmlMapping({"adjudicatedInvoiceElementChoice"})
    public AdjudicatedInvoiceElementChoice getAdjudicatedInvoiceElementChoice() {
        return this.adjudicatedInvoiceElementChoice;
    }
    public void setAdjudicatedInvoiceElementChoice(AdjudicatedInvoiceElementChoice adjudicatedInvoiceElementChoice) {
        this.adjudicatedInvoiceElementChoice = adjudicatedInvoiceElementChoice;
    }

    public AdjudicationResultIdentifierBean getAdjudicatedInvoiceElementChoiceAsAdjudicatedInvoiceElementGroup() {
        return this.adjudicatedInvoiceElementChoice instanceof AdjudicationResultIdentifierBean ? (AdjudicationResultIdentifierBean) this.adjudicatedInvoiceElementChoice : null;
    }
    public boolean hasAdjudicatedInvoiceElementChoiceAsAdjudicatedInvoiceElementGroup() {
        return (this.adjudicatedInvoiceElementChoice instanceof AdjudicationResultIdentifierBean);
    }

    public AdjudicatedInvoiceElementLineItemBean getAdjudicatedInvoiceElementChoiceAsAdjudicatedInvoiceElementDetail() {
        return this.adjudicatedInvoiceElementChoice instanceof AdjudicatedInvoiceElementLineItemBean ? (AdjudicatedInvoiceElementLineItemBean) this.adjudicatedInvoiceElementChoice : null;
    }
    public boolean hasAdjudicatedInvoiceElementChoiceAsAdjudicatedInvoiceElementDetail() {
        return (this.adjudicatedInvoiceElementChoice instanceof AdjudicatedInvoiceElementLineItemBean);
    }

}
