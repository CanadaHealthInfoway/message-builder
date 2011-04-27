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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActSubstanceAdminSubstitutionCode;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionReason;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT300000CA.Substitution"})
public class DispenseSubstitutionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CV substitutionType = new CVImpl();
    private CV substitutionReason = new CVImpl();
    private SubstitutionRoleBean performerSubstitutionRole;


    /**
     * <p>Substitution Type</p>
     * 
     * <p><p>type of substitution</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActSubstanceAdminSubstitutionCode getSubstitutionType() {
        return (ActSubstanceAdminSubstitutionCode) this.substitutionType.getValue();
    }
    public void setSubstitutionType(ActSubstanceAdminSubstitutionCode substitutionType) {
        this.substitutionType.setValue(substitutionType);
    }


    /**
     * <p>Substitution Reason</p>
     * 
     * <p><p>Reason why the substitution occurred.</p></p>
     * 
     * <p><p>Reason for substituting or not substituting, e.g. 
     * because prescriber requested</p></p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public SubstanceAdminSubstitutionReason getSubstitutionReason() {
        return (SubstanceAdminSubstitutionReason) this.substitutionReason.getValue();
    }
    public void setSubstitutionReason(SubstanceAdminSubstitutionReason substitutionReason) {
        this.substitutionReason.setValue(substitutionReason);
    }


    @Hl7XmlMapping({"performer/substitutionRole"})
    public SubstitutionRoleBean getPerformerSubstitutionRole() {
        return this.performerSubstitutionRole;
    }
    public void setPerformerSubstitutionRole(SubstitutionRoleBean performerSubstitutionRole) {
        this.performerSubstitutionRole = performerSubstitutionRole;
    }

}
