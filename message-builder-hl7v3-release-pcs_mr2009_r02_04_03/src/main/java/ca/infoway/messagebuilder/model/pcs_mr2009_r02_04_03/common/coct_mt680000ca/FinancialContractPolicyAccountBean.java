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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt680000ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.PolicyUnderwriterBean;



/**
 * <p>Financial contract Policy/Account</p>
 * 
 * <p><p>Account or policy used for determining elibility in 
 * adjudication process.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT680000CA.PolicyOrAccount"})
public class FinancialContractPolicyAccountBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private CV code = new CVImpl();
    private PolicyUnderwriterBean author;


    /**
     * <p>policy/account code</p>
     * 
     * <p><p>Code Set denoting policy type</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    @Hl7XmlMapping({"author"})
    public PolicyUnderwriterBean getAuthor() {
        return this.author;
    }
    public void setAuthor(PolicyUnderwriterBean author) {
        this.author = author;
    }

}
