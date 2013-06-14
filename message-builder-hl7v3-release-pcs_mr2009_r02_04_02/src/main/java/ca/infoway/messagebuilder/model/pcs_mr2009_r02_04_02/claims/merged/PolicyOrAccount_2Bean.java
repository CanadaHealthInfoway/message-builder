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
package Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.claims.merged;

import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.claims.ficr_mt500201ca.PolicyHolderPersonBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.merged.CarrierRoleBean;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>FICR_MT600201CA.PolicyOrAccount: (no business name)</p>
 * 
 * <p>id: = Coverage Identifier, extension = 
 * Policy.Plan.Group.Contract. Division.Section.Version (or 
 * similar). Carrier noted in author participation, and may not 
 * be same namespace as OID of id</p>
 * 
 * <p>FICR_MT500201CA.PolicyOrAccount: (no business name)</p>
 * 
 * <p>id: = Coverage Identifier, extension = 
 * Policy.Plan.Group.Contract. Division.Section.Version (or 
 * similar). Carrier noted in author participation, and may not 
 * be same namespace as OID of id</p>
 */
@Hl7PartTypeMapping({"FICR_MT500201CA.PolicyOrAccount","FICR_MT600201CA.PolicyOrAccount"})
public class PolicyOrAccount_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private II id = new IIImpl();
    private CoveredPartyAsPatientBean beneficiaryCoveredPartyAsPatient;
    private CarrierRoleBean authorCarrierRole;
    private PolicyHolderPersonBean holderPolicyHolderPolicyHolderPerson;


    /**
     * <p>Business Name: PolicyID</p>
     * 
     * <p>Un-merged Business Name: PolicyID</p>
     * 
     * <p>Relationship: FICR_MT600201CA.PolicyOrAccount.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: PolicyID</p>
     * 
     * <p>Relationship: FICR_MT500201CA.PolicyOrAccount.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: PolicyID</p>
     * 
     * <p>Un-merged Business Name: PolicyID</p>
     * 
     * <p>Relationship: FICR_MT600201CA.PolicyOrAccount.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: PolicyID</p>
     * 
     * <p>Relationship: FICR_MT500201CA.PolicyOrAccount.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.PolicyBeneficiary.coveredPartyAsPatient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.PolicyBeneficiary.coveredPartyAsPatient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"beneficiary/coveredPartyAsPatient"})
    public CoveredPartyAsPatientBean getBeneficiaryCoveredPartyAsPatient() {
        return this.beneficiaryCoveredPartyAsPatient;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.PolicyBeneficiary.coveredPartyAsPatient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.PolicyBeneficiary.coveredPartyAsPatient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setBeneficiaryCoveredPartyAsPatient(CoveredPartyAsPatientBean beneficiaryCoveredPartyAsPatient) {
        this.beneficiaryCoveredPartyAsPatient = beneficiaryCoveredPartyAsPatient;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.PolicyUnderwriter.carrierRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.PolicyUnderwriter.carrierRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"author/carrierRole"})
    public CarrierRoleBean getAuthorCarrierRole() {
        return this.authorCarrierRole;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.PolicyUnderwriter.carrierRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.PolicyUnderwriter.carrierRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setAuthorCarrierRole(CarrierRoleBean authorCarrierRole) {
        this.authorCarrierRole = authorCarrierRole;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.PolicyHolder.policyHolderPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"holder/policyHolder/policyHolderPerson"})
    public PolicyHolderPersonBean getHolderPolicyHolderPolicyHolderPerson() {
        return this.holderPolicyHolderPolicyHolderPerson;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.PolicyHolder.policyHolderPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setHolderPolicyHolderPolicyHolderPerson(PolicyHolderPersonBean holderPolicyHolderPolicyHolderPerson) {
        this.holderPolicyHolderPolicyHolderPerson = holderPolicyHolderPolicyHolderPerson;
    }

}
