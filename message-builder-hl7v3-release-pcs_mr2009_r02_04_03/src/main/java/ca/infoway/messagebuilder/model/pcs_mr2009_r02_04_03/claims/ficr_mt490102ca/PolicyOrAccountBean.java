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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt490102ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged.CoveredPartyBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged.PolicyHolderBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActInsurancePolicyType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.UnderwriterBean;



@Hl7PartTypeMapping({"FICR_MT490102CA.PolicyOrAccount"})
public class PolicyOrAccountBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private CoveredPartyBean beneficiaryCoveredParty;
    private PolicyHolderBean holderPolicyHolder;
    private UnderwriterBean authorUnderwriter;


    /**
     * <p>Business Name: Policy Identifier</p>
     * 
     * <p>Relationship: FICR_MT490102CA.PolicyOrAccount.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Policy Identifier</p>
     * 
     * <p>Relationship: FICR_MT490102CA.PolicyOrAccount.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Policy Type</p>
     * 
     * <p>Relationship: FICR_MT490102CA.PolicyOrAccount.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInsurancePolicyType getCode() {
        return (ActInsurancePolicyType) this.code.getValue();
    }

    /**
     * <p>Business Name: Policy Type</p>
     * 
     * <p>Relationship: FICR_MT490102CA.PolicyOrAccount.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ActInsurancePolicyType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: FICR_MT490102CA.Beneficiary.coveredParty</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"beneficiary/coveredParty"})
    public CoveredPartyBean getBeneficiaryCoveredParty() {
        return this.beneficiaryCoveredParty;
    }

    /**
     * <p>Relationship: FICR_MT490102CA.Beneficiary.coveredParty</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setBeneficiaryCoveredParty(CoveredPartyBean beneficiaryCoveredParty) {
        this.beneficiaryCoveredParty = beneficiaryCoveredParty;
    }


    /**
     * <p>Relationship: FICR_MT490102CA.Holder.policyHolder</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"holder/policyHolder"})
    public PolicyHolderBean getHolderPolicyHolder() {
        return this.holderPolicyHolder;
    }

    /**
     * <p>Relationship: FICR_MT490102CA.Holder.policyHolder</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setHolderPolicyHolder(PolicyHolderBean holderPolicyHolder) {
        this.holderPolicyHolder = holderPolicyHolder;
    }


    /**
     * <p>Relationship: FICR_MT490102CA.Author.underwriter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author/underwriter"})
    public UnderwriterBean getAuthorUnderwriter() {
        return this.authorUnderwriter;
    }

    /**
     * <p>Relationship: FICR_MT490102CA.Author.underwriter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthorUnderwriter(UnderwriterBean authorUnderwriter) {
        this.authorUnderwriter = authorUnderwriter;
    }

}
