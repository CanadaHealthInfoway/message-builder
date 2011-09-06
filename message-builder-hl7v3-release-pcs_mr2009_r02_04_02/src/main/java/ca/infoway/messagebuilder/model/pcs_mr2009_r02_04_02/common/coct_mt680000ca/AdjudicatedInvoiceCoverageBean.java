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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt680000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p><p>Association is required, 1..1 and not mandatory, as 
 * EOB may have been generated from a non-HL7 EOB and the 
 * Provider s/w will not know the Policy Type to put in the 
 * target act.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT680000CA.AdjudicatedInvoiceCoverage"})
public class AdjudicatedInvoiceCoverageBean extends MessagePartBean {

    private static final long serialVersionUID = 20110906L;
    private INT cOBPriority = new INTImpl();
    private FinancialContractPolicyAccountBean policyOrAccount;


    /**
     * <p>COB Priority</p>
     * 
     * <p><p>COB priority as adjudicated primary, secondary, 
     * etc.</p></p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getCOBPriority() {
        return this.cOBPriority.getValue();
    }
    public void setCOBPriority(Integer cOBPriority) {
        this.cOBPriority.setValue(cOBPriority);
    }


    @Hl7XmlMapping({"policyOrAccount"})
    public FinancialContractPolicyAccountBean getPolicyOrAccount() {
        return this.policyOrAccount;
    }
    public void setPolicyOrAccount(FinancialContractPolicyAccountBean policyOrAccount) {
        this.policyOrAccount = policyOrAccount;
    }

}
