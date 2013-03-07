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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt680000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.ActInsurancePolicyType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.PolicyUnderwriterBean;



/**
 * <p>Business Name: Financial contract Policy/Account</p>
 * 
 * <p>Account or policy used for determining elibility in 
 * adjudication process.</p>
 */
@Hl7PartTypeMapping({"COCT_MT680000CA.PolicyOrAccount"})
public class FinancialContractPolicyAccountBean extends MessagePartBean {

    private static final long serialVersionUID = 20130307L;
    private CV code = new CVImpl();
    private PolicyUnderwriterBean author;


    /**
     * <p>Business Name: policy/account code</p>
     * 
     * <p>Relationship: COCT_MT680000CA.PolicyOrAccount.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Code Set denoting policy type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInsurancePolicyType getCode() {
        return (ActInsurancePolicyType) this.code.getValue();
    }

    /**
     * <p>Business Name: policy/account code</p>
     * 
     * <p>Relationship: COCT_MT680000CA.PolicyOrAccount.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Code Set denoting policy type</p>
     */
    public void setCode(ActInsurancePolicyType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: COCT_MT680000CA.PolicyOrAccount.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public PolicyUnderwriterBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: COCT_MT680000CA.PolicyOrAccount.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(PolicyUnderwriterBean author) {
        this.author = author;
    }

}
