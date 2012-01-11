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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt110200ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Payee Relationship Role</p>
 * 
 * <p><p>Indicates whether payee is Person or Organisation</p></p>
 * 
 * <p><p>Covered Party/Patient is the scoper of this role, but 
 * is not necessary in this CMET</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT110200CA.Role"})
public class PayeeRelationshipRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private CS classCode = new CSImpl();


    /**
     * <p>Account Payee Policy Relationship Role</p>
     * 
     * <p><p>Invoice Adjudication Results</p></p>
     */
    @Hl7XmlMapping({"classCode"})
    public Code getClassCode() {
        return (Code) this.classCode.getValue();
    }
    public void setClassCode(Code classCode) {
        this.classCode.setValue(classCode);
    }

}
