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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged.PolicyOrAccount_2Bean;



/**
 * <p><p>Coverage must be specified for Root Adjudicated 
 * Invoice Element Group and may not be specified for any other 
 * Adjudicated Invoice Element Group.</p></p>
 * 
 * <p><p>Allows Payor to adj &amp; pay on different policy</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatedInvoiceCoverage"})
public class AdjudicatedInvoiceCoverageBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private INT sequenceNumber = new INTImpl();
    private PolicyOrAccount_2Bean policyOrAccount;


    /**
     * <p>COB Sequence as Adjudicated</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    @Hl7XmlMapping({"policyOrAccount"})
    public PolicyOrAccount_2Bean getPolicyOrAccount() {
        return this.policyOrAccount;
    }
    public void setPolicyOrAccount(PolicyOrAccount_2Bean policyOrAccount) {
        this.policyOrAccount = policyOrAccount;
    }

}