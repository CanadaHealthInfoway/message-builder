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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActSubstanceAdminSubstitutionCode;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionReason;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT300000CA.Substitution"})
public class DispenseSubstitutionBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private CV code = new CVImpl();
    private CV reasonCode = new CVImpl();
    private SubstitutionRoleBean performerSubstitutionRole;


    /**
     * <p>Substitution Type</p>
     * 
     * <p>type of substitution</p>
     */
    @Hl7XmlMapping({"code"})
    public ActSubstanceAdminSubstitutionCode getCode() {
        return (ActSubstanceAdminSubstitutionCode) this.code.getValue();
    }

    /**
     * <p>Substitution Type</p>
     * 
     * <p>type of substitution</p>
     */
    public void setCode(ActSubstanceAdminSubstitutionCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Substitution Reason</p>
     * 
     * <p>Reason why the substitution occurred.</p>
     * 
     * <p>Reason for substituting or not substituting, e.g. because 
     * prescriber requested</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public SubstanceAdminSubstitutionReason getReasonCode() {
        return (SubstanceAdminSubstitutionReason) this.reasonCode.getValue();
    }

    /**
     * <p>Substitution Reason</p>
     * 
     * <p>Reason why the substitution occurred.</p>
     * 
     * <p>Reason for substituting or not substituting, e.g. because 
     * prescriber requested</p>
     */
    public void setReasonCode(SubstanceAdminSubstitutionReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    @Hl7XmlMapping({"performer/substitutionRole"})
    public SubstitutionRoleBean getPerformerSubstitutionRole() {
        return this.performerSubstitutionRole;
    }

    public void setPerformerSubstitutionRole(SubstitutionRoleBean performerSubstitutionRole) {
        this.performerSubstitutionRole = performerSubstitutionRole;
    }

}
