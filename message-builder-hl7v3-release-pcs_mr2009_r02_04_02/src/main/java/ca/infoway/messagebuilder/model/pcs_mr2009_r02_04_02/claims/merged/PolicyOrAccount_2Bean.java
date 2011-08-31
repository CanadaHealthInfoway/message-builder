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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt500201ca.PolicyHolderBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.PolicyUnderwriterBean;



/**
 * <p>FICR_MT600201CA.PolicyOrAccount: (no business name)</p>
 * 
 * <p><p>id: = Coverage Identifier, extension = 
 * Policy.Plan.Group.Contract. Division.Section.Version (or 
 * similar). Carrier noted in author participation, and may not 
 * be same namespace as OID of id</p></p>
 * 
 * <p>FICR_MT500201CA.PolicyOrAccount: (no business name)</p>
 * 
 * <p><p>id: = Coverage Identifier, extension = 
 * Policy.Plan.Group.Contract. Division.Section.Version (or 
 * similar). Carrier noted in author participation, and may not 
 * be same namespace as OID of id</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT500201CA.PolicyOrAccount","FICR_MT600201CA.PolicyOrAccount","FICR_MT610201CA.PolicyOrAccount"})
public class PolicyOrAccount_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private II id = new IIImpl();
    private CD policyType = new CDImpl();
    private CoveredPartyAsPatientBean beneficiaryCoveredPartyAsPatient;
    private PolicyUnderwriterBean author;
    private PolicyHolderBean holderPolicyHolder;


    /**
     * <p>Policy ID</p>
     * 
     * <p>Policy Identifier(s</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>PolicyType</p>
     * 
     * <p>Policy Type</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getPolicyType() {
        return (Code) this.policyType.getValue();
    }
    public void setPolicyType(Code policyType) {
        this.policyType.setValue(policyType);
    }


    @Hl7XmlMapping({"beneficiary/coveredPartyAsPatient"})
    public CoveredPartyAsPatientBean getBeneficiaryCoveredPartyAsPatient() {
        return this.beneficiaryCoveredPartyAsPatient;
    }
    public void setBeneficiaryCoveredPartyAsPatient(CoveredPartyAsPatientBean beneficiaryCoveredPartyAsPatient) {
        this.beneficiaryCoveredPartyAsPatient = beneficiaryCoveredPartyAsPatient;
    }


    @Hl7XmlMapping({"author"})
    public PolicyUnderwriterBean getAuthor() {
        return this.author;
    }
    public void setAuthor(PolicyUnderwriterBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"holder/policyHolder"})
    public PolicyHolderBean getHolderPolicyHolder() {
        return this.holderPolicyHolder;
    }
    public void setHolderPolicyHolder(PolicyHolderBean holderPolicyHolder) {
        this.holderPolicyHolder = holderPolicyHolder;
    }

}
