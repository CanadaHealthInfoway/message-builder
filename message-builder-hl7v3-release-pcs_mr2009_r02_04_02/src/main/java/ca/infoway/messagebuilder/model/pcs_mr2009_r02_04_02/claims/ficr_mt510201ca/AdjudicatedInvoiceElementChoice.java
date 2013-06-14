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
package Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.claims.ficr_mt510201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;



/**
 * <p>Want sum of all adjudication details (info &amp; 
 * non-info) to equal what was submitted. For example, the 
 * reasons why you refused to pay part of the invoice</p>
 */
@Hl7PartTypeMapping({"FICR_MT510201CA.AdjudicatedInvoiceElementChoice"})
public interface AdjudicatedInvoiceElementChoice {


    /**
     * <p>Business Name: Fee Scheduled Eligibile Amt.</p>
     * 
     * <p>Relationship: FICR_MT510201CA.Allowable.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public Money getReference1AllowableNetAmt();

    /**
     * <p>Business Name: Fee Scheduled Eligibile Amt.</p>
     * 
     * <p>Relationship: FICR_MT510201CA.Allowable.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setReference1AllowableNetAmt(Money reference1AllowableNetAmt);


    /**
     * <p>Relationship: FICR_MT510201CA.Outcome.adjudicationResult</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public AdjudicationResultBean getOutcomeOfAdjudicationResult();

    /**
     * <p>Relationship: FICR_MT510201CA.Outcome.adjudicationResult</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setOutcomeOfAdjudicationResult(AdjudicationResultBean outcomeOfAdjudicationResult);

}
