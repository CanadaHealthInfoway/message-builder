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
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Coverage must be specified for Root Adjudicated Invoice 
 * Element Group and may not be specified for any other 
 * Adjudicated Invoice Element Group.</p>
 * 
 * <p>Allows Payor to adj &amp; pay on different policy</p>
 */
@Hl7PartTypeMapping({"FICR_MT510201CA.Coverage"})
public class CoverageBean extends MessagePartBean {

    private static final long serialVersionUID = 20190730L;
    private INT sequenceNumber = new INTImpl();
    private PolicyOrAccountBean policyOrAccount;


    /**
     * <p>Business Name: COB sequence as adjudicated.</p>
     * 
     * <p>Relationship: FICR_MT510201CA.Coverage.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Business Name: COB sequence as adjudicated.</p>
     * 
     * <p>Relationship: FICR_MT510201CA.Coverage.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Relationship: FICR_MT510201CA.Coverage.policyOrAccount</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"policyOrAccount"})
    public PolicyOrAccountBean getPolicyOrAccount() {
        return this.policyOrAccount;
    }

    /**
     * <p>Relationship: FICR_MT510201CA.Coverage.policyOrAccount</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPolicyOrAccount(PolicyOrAccountBean policyOrAccount) {
        this.policyOrAccount = policyOrAccount;
    }

}
