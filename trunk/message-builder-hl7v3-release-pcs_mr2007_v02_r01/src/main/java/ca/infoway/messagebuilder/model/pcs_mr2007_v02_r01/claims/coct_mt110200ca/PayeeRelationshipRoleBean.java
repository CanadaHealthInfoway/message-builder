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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt110200ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.domainvalue.x_RoleClassPayeePolicyRelationship;



/**
 * <p>Payee Choice</p>
 * 
 * <p>Covered Party/Patient is the scoper of this role, but is 
 * not necessary in this CMET</p>
 */
@Hl7PartTypeMapping({"COCT_MT110200CA.PayeeRelationshipRole"})
public class PayeeRelationshipRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private CS classCode = new CSImpl();


    @Hl7XmlMapping({"classCode"})
    public x_RoleClassPayeePolicyRelationship getClassCode() {
        return (x_RoleClassPayeePolicyRelationship) this.classCode.getValue();
    }

    public void setClassCode(x_RoleClassPayeePolicyRelationship classCode) {
        this.classCode.setValue(classCode);
    }

}
