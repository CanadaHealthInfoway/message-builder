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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActSubstanceAdminSubstitutionCode;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionReason;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Substitution</p>
 * 
 * <p>PORX_MT060160CA.SubstitutionMade: Substitution</p>
 * 
 * <p><p>An indication of what kind of substitution made, if 
 * any.</p></p>
 * 
 * <p><p>A_BillablePharmacyDispense</p></p>
 * 
 * <p><p>May explain why prescribed and dispensed medications 
 * differ.</p></p>
 * 
 * <p>PORX_MT060090CA.SubstitutionMade: Substitution</p>
 * 
 * <p><p>An indication of what kind of substitution made, if 
 * any.</p></p>
 * 
 * <p><p>A_BillablePharmacyDispense</p></p>
 * 
 * <p><p>May explain why prescribed and dispensed medications 
 * differ.</p></p>
 * 
 * <p>PORX_MT060340CA.SubstitutionMade: Substitution</p>
 * 
 * <p><p>An indication of what kind of substitution made, if 
 * any.</p></p>
 * 
 * <p><p>A_BillablePharmacyDispense</p></p>
 * 
 * <p><p>May explain why prescribed and dispensed medications 
 * differ.</p></p>
 * 
 * <p>PORX_MT020070CA.SubstitutionMade: Substitution</p>
 * 
 * <p><p>An indication of what kind of substitution was made, 
 * if any.</p></p>
 * 
 * <p><p>A_BillablePharmacyDispense</p></p>
 * 
 * <p><p>May explain why prescribed and dispensed medications 
 * may differ.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT020070CA.SubstitutionMade","PORX_MT060090CA.SubstitutionMade","PORX_MT060160CA.SubstitutionMade","PORX_MT060340CA.SubstitutionMade"})
public class SubstitutionBean extends MessagePartBean {

    private static final long serialVersionUID = 20120320L;
    private CV code = new CVImpl();
    private CV reasonCode = new CVImpl();
    private AgentBean responsiblePartyAgent;


    /**
     * <p>SubstitutionCode</p>
     * 
     * <p>Substitution Code</p>
     * 
     * <p><p>A code signifying whether a different drug was 
     * dispensed from what was prescribed.</p></p>
     * 
     * <p><p>DRU.050</p><p>Claim.408-D8</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DRU.050</p><p>Claim.408-D8</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DRU.050</p><p>Claim.408-D8</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Indicates that substitution was done (or not). This 
     * attribute is mandatory because it is essential to 
     * understanding the substitution.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActSubstanceAdminSubstitutionCode getCode() {
        return (ActSubstanceAdminSubstitutionCode) this.code.getValue();
    }
    public void setCode(ActSubstanceAdminSubstitutionCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Product Selection Code</p>
     * 
     * <p><p>Indicates the reason for the substitution of (or 
     * failure to substitute) the medication from what was 
     * prescribed.</p></p>
     * 
     * <p><p>DispensedItem.productSelectionCode</p><p>D62</p><p>ZDP.12</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.productSelectionCode</p><p>D62</p><p>ZDP.12</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.productSelectionCode</p><p>D62</p><p>ZDP.12</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.productSelectionCode</p><p>D62</p><p>ZDP.12</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Standardized reasons for substitution performed (or 
     * not performed). Useful in analysis of dispensing 
     * patterns.</p></p>
     * 
     * <p>Product Selection Reason Code</p>
     * 
     * <p><p>Indicates the reason for the substitution of (or lack 
     * of substitution) from what was prescribed.</p></p>
     * 
     * <p><p>DispensedItem.productSelectionCode</p><p>D62</p><p>ZDP.12</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.productSelectionCode</p><p>D62</p><p>ZDP.12</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.productSelectionCode</p><p>D62</p><p>ZDP.12</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.productSelectionCode</p><p>D62</p><p>ZDP.12</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Standardized reasons for substitution performed (or 
     * not performed). Useful in analysis of dispensing 
     * patterns.</p></p>
     * 
     * <p>Product Selection Reason Code</p>
     * 
     * <p><p>Indicates the reason for the substitution of (or 
     * failure to substitute) the medication from what was 
     * prescribed.</p></p>
     * 
     * <p><p>DispensedItem.productSelectionCode</p><p>D62</p><p>ZDP.12</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.productSelectionCode</p><p>D62</p><p>ZDP.12</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.productSelectionCode</p><p>D62</p><p>ZDP.12</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.productSelectionCode</p><p>D62</p><p>ZDP.12</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Standardized reasons for substitution performed (or 
     * not performed). Useful in analysis of dispensing 
     * patterns.</p></p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public SubstanceAdminSubstitutionReason getReasonCode() {
        return (SubstanceAdminSubstitutionReason) this.reasonCode.getValue();
    }
    public void setReasonCode(SubstanceAdminSubstitutionReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    @Hl7XmlMapping({"responsibleParty/agent"})
    public AgentBean getResponsiblePartyAgent() {
        return this.responsiblePartyAgent;
    }
    public void setResponsiblePartyAgent(AgentBean responsiblePartyAgent) {
        this.responsiblePartyAgent = responsiblePartyAgent;
    }

}
