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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt510201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged.CoveredPartyAsPatientBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActInsurancePolicyType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.CarrierRoleBean;



/**
 * <p>Coverage must be specified for Root Adjudicated Invoice 
 * Element Group and may not be specified for any other 
 * Adjudicated Invoice Element Group.</p>
 * 
 * <p>Allows Payor to adj &amp; pay on different policy</p>
 */
@Hl7PartTypeMapping({"FICR_MT510201CA.Coverage"})
public class CoverageBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private INT sequenceNumber = new INTImpl();
    private II policyOrAccountId = new IIImpl();
    private CV policyOrAccountCode = new CVImpl();
    private CoveredPartyAsPatientBean policyOrAccountBeneficiaryCoveredPartyAsPatient;
    private CarrierRoleBean policyOrAccountAuthorCarrierRole;


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
     * <p>Business Name: Policy Identifier</p>
     * 
     * <p>Relationship: FICR_MT510201CA.PolicyOrAccount.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"policyOrAccount/id"})
    public Identifier getPolicyOrAccountId() {
        return this.policyOrAccountId.getValue();
    }

    /**
     * <p>Business Name: Policy Identifier</p>
     * 
     * <p>Relationship: FICR_MT510201CA.PolicyOrAccount.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPolicyOrAccountId(Identifier policyOrAccountId) {
        this.policyOrAccountId.setValue(policyOrAccountId);
    }


    /**
     * <p>Business Name: Policy type</p>
     * 
     * <p>Relationship: FICR_MT510201CA.PolicyOrAccount.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"policyOrAccount/code"})
    public ActInsurancePolicyType getPolicyOrAccountCode() {
        return (ActInsurancePolicyType) this.policyOrAccountCode.getValue();
    }

    /**
     * <p>Business Name: Policy type</p>
     * 
     * <p>Relationship: FICR_MT510201CA.PolicyOrAccount.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPolicyOrAccountCode(ActInsurancePolicyType policyOrAccountCode) {
        this.policyOrAccountCode.setValue(policyOrAccountCode);
    }


    /**
     * <p>Relationship: 
     * FICR_MT510201CA.Beneficiary.coveredPartyAsPatient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"policyOrAccount/beneficiary/coveredPartyAsPatient"})
    public CoveredPartyAsPatientBean getPolicyOrAccountBeneficiaryCoveredPartyAsPatient() {
        return this.policyOrAccountBeneficiaryCoveredPartyAsPatient;
    }

    /**
     * <p>Relationship: 
     * FICR_MT510201CA.Beneficiary.coveredPartyAsPatient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPolicyOrAccountBeneficiaryCoveredPartyAsPatient(CoveredPartyAsPatientBean policyOrAccountBeneficiaryCoveredPartyAsPatient) {
        this.policyOrAccountBeneficiaryCoveredPartyAsPatient = policyOrAccountBeneficiaryCoveredPartyAsPatient;
    }


    /**
     * <p>Relationship: FICR_MT510201CA.Author2.carrierRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"policyOrAccount/author/carrierRole"})
    public CarrierRoleBean getPolicyOrAccountAuthorCarrierRole() {
        return this.policyOrAccountAuthorCarrierRole;
    }

    /**
     * <p>Relationship: FICR_MT510201CA.Author2.carrierRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPolicyOrAccountAuthorCarrierRole(CarrierRoleBean policyOrAccountAuthorCarrierRole) {
        this.policyOrAccountAuthorCarrierRole = policyOrAccountAuthorCarrierRole;
    }

}
