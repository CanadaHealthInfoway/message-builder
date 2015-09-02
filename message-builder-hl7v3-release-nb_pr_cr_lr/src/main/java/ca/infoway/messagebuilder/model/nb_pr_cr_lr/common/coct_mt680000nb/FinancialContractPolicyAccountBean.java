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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt680000nb;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.domainvalue.ActInsurancePolicyCode;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.merged.CarrierRoleBean;



/**
 * <p>Business Name: Financial contract Policy/Account</p>
 * 
 * <p>Account or policy used for determining elibility in 
 * adjudication process.</p>
 */
@Hl7PartTypeMapping({"COCT_MT680000NB.PolicyOrAccount"})
public class FinancialContractPolicyAccountBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private CV code = new CVImpl();
    private CarrierRoleBean authorCarrierRole;


    /**
     * <p>Business Name: policy/account code</p>
     * 
     * <p>Relationship: COCT_MT680000NB.PolicyOrAccount.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Code Set denoting policy type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInsurancePolicyCode getCode() {
        return (ActInsurancePolicyCode) this.code.getValue();
    }

    /**
     * <p>Business Name: policy/account code</p>
     * 
     * <p>Relationship: COCT_MT680000NB.PolicyOrAccount.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Code Set denoting policy type</p>
     */
    public void setCode(ActInsurancePolicyCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: 
     * COCT_MT680000NB.PolicyUnderwriter.carrierRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author/carrierRole"})
    public CarrierRoleBean getAuthorCarrierRole() {
        return this.authorCarrierRole;
    }

    /**
     * <p>Relationship: 
     * COCT_MT680000NB.PolicyUnderwriter.carrierRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthorCarrierRole(CarrierRoleBean authorCarrierRole) {
        this.authorCarrierRole = authorCarrierRole;
    }

}
