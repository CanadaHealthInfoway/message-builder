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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Payment Reason</p>
 * 
 * <p>For spontaneous EOBs, there may be more than 1 EOB for 
 * the same Payment Intent.</p>
 * 
 * <p>For deferred adjudication, this may be of value. 
 * Spontaneous EOBs for policies that were not asked for on an 
 * invoice will likely require separate Payment Intents and/or 
 * EOBs.</p>
 */
@Hl7PartTypeMapping({"FICR_MT610201CA.PaymentIntentReason"})
public class PaymentReasonBean extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private AdjudicatedInvoiceBean adjudicatedInvoiceElementGroup;


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.PaymentIntentReason.adjudicatedInvoiceElementGroup</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"adjudicatedInvoiceElementGroup"})
    public AdjudicatedInvoiceBean getAdjudicatedInvoiceElementGroup() {
        return this.adjudicatedInvoiceElementGroup;
    }

    /**
     * <p>Relationship: 
     * FICR_MT610201CA.PaymentIntentReason.adjudicatedInvoiceElementGroup</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setAdjudicatedInvoiceElementGroup(AdjudicatedInvoiceBean adjudicatedInvoiceElementGroup) {
        this.adjudicatedInvoiceElementGroup = adjudicatedInvoiceElementGroup;
    }

}
