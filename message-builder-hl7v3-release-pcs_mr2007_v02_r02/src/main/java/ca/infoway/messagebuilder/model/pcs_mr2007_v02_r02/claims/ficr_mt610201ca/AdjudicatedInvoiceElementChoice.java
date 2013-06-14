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
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged.AdjudicationCodeChoice;



/**
 * <p>Want sum of all adjudication details (info &amp; 
 * non-info) to equal what was submitted. For example, the 
 * reasons why you refused to pay part of the invoice</p>
 */
@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatedInvoiceElementChoice"})
public interface AdjudicatedInvoiceElementChoice {


    /**
     * <p>Relationship: FICR_MT610201CA.Allowable.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allowable or eligibile amount, as per fee schedule</p>
     */
    public Money getReference1AllowableNetAmt();

    /**
     * <p>Relationship: FICR_MT610201CA.Allowable.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allowable or eligibile amount, as per fee schedule</p>
     */
    public void setReference1AllowableNetAmt(Money reference1AllowableNetAmt);


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedResultOutcome.adjudicationCodeChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public AdjudicationCodeChoice getOutcomeOfAdjudicationCodeChoice();

    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedResultOutcome.adjudicationCodeChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setOutcomeOfAdjudicationCodeChoice(AdjudicationCodeChoice outcomeOfAdjudicationCodeChoice);

}
