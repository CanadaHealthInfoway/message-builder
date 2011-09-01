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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActSubstanceAdminSubstitutionCode;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionReason;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT020070CA.SubstitutionMade","PORX_MT060090CA.SubstitutionMade","PORX_MT060160CA.SubstitutionMade","PORX_MT060340CA.SubstitutionMade"})
public class SubstitutionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110901L;
    private CV substitutionCode = new CVImpl();
    private CV reasonCode = new CVImpl();
    private AgentBean responsiblePartyAgent;


    /**
     * <p>SubstitutionCode</p>
     * 
     * <p>Substitution Code</p>
     */
    @Hl7XmlMapping({"code"})
    public ActSubstanceAdminSubstitutionCode getSubstitutionCode() {
        return (ActSubstanceAdminSubstitutionCode) this.substitutionCode.getValue();
    }
    public void setSubstitutionCode(ActSubstanceAdminSubstitutionCode substitutionCode) {
        this.substitutionCode.setValue(substitutionCode);
    }


    /**
     * <p>Product Selection Reason Code</p>
     * 
     * <p>Product Selection Reason Code</p>
     * 
     * <p><p><strong>If the Substitution Code is not "N", then this 
     * must be present or a MISSCOND error will be 
     * returned.</strong></p></p>
     * 
     * <p>Product Selection Code</p>
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
