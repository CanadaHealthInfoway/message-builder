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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged.PolicyIdentifierBean;



/**
 * <p>Coverage must be specified for Root Adjudicated Invoice 
 * Element Group and may not be specified for any other 
 * Adjudicated Invoice Element Group.</p>
 * 
 * <p>For Adjudication Results: On net new policies (i.e. 
 * adjudicated policies for which the provider did not request 
 * adjudication on the Invoice), any policy holder information 
 * will be communicated to the provider with adjudication 
 * information codes. A required action could be used to 
 * instruct the provider s/w to communicate this information to 
 * the patient.</p>
 * 
 * <p>Allows Payor to adj &amp; pay on different policy</p>
 */
@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatedInvoiceCoverage"})
public class AdjudicatedInvoiceCoverageBean extends MessagePartBean {

    private static final long serialVersionUID = 20190730L;
    private INT sequenceNumber = new INTImpl();
    private PolicyIdentifierBean policyOrAccount;


    /**
     * <p>Business Name: COB Sequence as Adjudicated</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceCoverage.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The Coordination of Benefits order of the insurance 
     * policy as determined by the adjudicator.</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Business Name: COB Sequence as Adjudicated</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceCoverage.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The Coordination of Benefits order of the insurance 
     * policy as determined by the adjudicator.</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceCoverage.policyOrAccount</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"policyOrAccount"})
    public PolicyIdentifierBean getPolicyOrAccount() {
        return this.policyOrAccount;
    }

    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceCoverage.policyOrAccount</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPolicyOrAccount(PolicyIdentifierBean policyOrAccount) {
        this.policyOrAccount = policyOrAccount;
    }

}
