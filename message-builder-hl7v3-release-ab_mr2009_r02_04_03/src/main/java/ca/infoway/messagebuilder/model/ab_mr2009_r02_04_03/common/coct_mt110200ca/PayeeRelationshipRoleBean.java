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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.coct_mt110200ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.domainvalue.x_RoleClassPayeePolicyRelationship;



/**
 * <p>Business Name: Payee Relationship Role</p>
 * 
 * <p>Covered Party/Patient is the scoper of this role, but is 
 * not necessary in this CMET</p>
 * 
 * <p>Indicates whether payee is Person or Organisation</p>
 */
@Hl7PartTypeMapping({"COCT_MT110200CA.Role"})
public class PayeeRelationshipRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20150814L;
    private CS classCode = new CSImpl();


    /**
     * <p>Business Name: Account Payee Policy Relationship Role</p>
     * 
     * <p>Relationship: COCT_MT110200CA.Role.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Invoice Adjudication Results</p>
     */
    @Hl7XmlMapping({"classCode"})
    public x_RoleClassPayeePolicyRelationship getClassCode() {
        return (x_RoleClassPayeePolicyRelationship) this.classCode.getValue();
    }

    /**
     * <p>Business Name: Account Payee Policy Relationship Role</p>
     * 
     * <p>Relationship: COCT_MT110200CA.Role.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Invoice Adjudication Results</p>
     */
    public void setClassCode(x_RoleClassPayeePolicyRelationship classCode) {
        this.classCode.setValue(classCode);
    }

}
