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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT300000CA.SubstanceAdministrationOrder"})
public class OriginalPrescriptionOrderBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private PresriberRoleBean authorPresriberRole;
    private DispenseSubstitutionBean component1Substitution;
    private OriginalPrescriptionBean component2SupplyOrder;


    @Hl7XmlMapping({"author/presriberRole"})
    public PresriberRoleBean getAuthorPresriberRole() {
        return this.authorPresriberRole;
    }
    public void setAuthorPresriberRole(PresriberRoleBean authorPresriberRole) {
        this.authorPresriberRole = authorPresriberRole;
    }


    @Hl7XmlMapping({"component1/substitution"})
    public DispenseSubstitutionBean getComponent1Substitution() {
        return this.component1Substitution;
    }
    public void setComponent1Substitution(DispenseSubstitutionBean component1Substitution) {
        this.component1Substitution = component1Substitution;
    }


    @Hl7XmlMapping({"component2/supplyOrder"})
    public OriginalPrescriptionBean getComponent2SupplyOrder() {
        return this.component2SupplyOrder;
    }
    public void setComponent2SupplyOrder(OriginalPrescriptionBean component2SupplyOrder) {
        this.component2SupplyOrder = component2SupplyOrder;
    }

}
