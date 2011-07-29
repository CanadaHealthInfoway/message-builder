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
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.merged.PolicyIdentifierBean;



@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatedInvoiceCoverage"})
public class AdjudicatedInvoiceCoverageBean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private INT cOBSequenceAsAdjudicated = new INTImpl();
    private PolicyIdentifierBean policyOrAccount;


    /**
     * <p>COB Sequence as Adjudicated</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getCOBSequenceAsAdjudicated() {
        return this.cOBSequenceAsAdjudicated.getValue();
    }
    public void setCOBSequenceAsAdjudicated(Integer cOBSequenceAsAdjudicated) {
        this.cOBSequenceAsAdjudicated.setValue(cOBSequenceAsAdjudicated);
    }


    @Hl7XmlMapping({"policyOrAccount"})
    public PolicyIdentifierBean getPolicyOrAccount() {
        return this.policyOrAccount;
    }
    public void setPolicyOrAccount(PolicyIdentifierBean policyOrAccount) {
        this.policyOrAccount = policyOrAccount;
    }

}
