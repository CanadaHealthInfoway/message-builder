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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.coct_mt680000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.domainvalue.ActInsurancePolicyCode;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.CarrierRoleBean;



/**
 * <p>Association is required, 1..1 and not mandatory, as EOB 
 * may have been generated from a non-HL7 EOB and the Provider 
 * s/w will not know the Policy Type to put in the target 
 * act.</p>
 */
@Hl7PartTypeMapping({"COCT_MT680000CA.AdjudicatedInvoiceCoverage"})
public class AdjudicatedInvoiceCoverageBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private INT sequenceNumber = new INTImpl();
    private CV policyOrAccountCode = new CVImpl();
    private CarrierRoleBean policyOrAccountAuthorCarrierRole;


    /**
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicatedInvoiceCoverage.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>COB priority as adjudicated primary, secondary, etc.</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicatedInvoiceCoverage.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>COB priority as adjudicated primary, secondary, etc.</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Business Name: policy/account code</p>
     * 
     * <p>Relationship: COCT_MT680000CA.PolicyOrAccount.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Code Set denoting policy type</p>
     */
    @Hl7XmlMapping({"policyOrAccount/code"})
    public ActInsurancePolicyCode getPolicyOrAccountCode() {
        return (ActInsurancePolicyCode) this.policyOrAccountCode.getValue();
    }

    /**
     * <p>Business Name: policy/account code</p>
     * 
     * <p>Relationship: COCT_MT680000CA.PolicyOrAccount.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Code Set denoting policy type</p>
     */
    public void setPolicyOrAccountCode(ActInsurancePolicyCode policyOrAccountCode) {
        this.policyOrAccountCode.setValue(policyOrAccountCode);
    }


    /**
     * <p>Relationship: 
     * COCT_MT680000CA.PolicyUnderwriter.carrierRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"policyOrAccount/author/carrierRole"})
    public CarrierRoleBean getPolicyOrAccountAuthorCarrierRole() {
        return this.policyOrAccountAuthorCarrierRole;
    }

    /**
     * <p>Relationship: 
     * COCT_MT680000CA.PolicyUnderwriter.carrierRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPolicyOrAccountAuthorCarrierRole(CarrierRoleBean policyOrAccountAuthorCarrierRole) {
        this.policyOrAccountAuthorCarrierRole = policyOrAccountAuthorCarrierRole;
    }

}
