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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.mfmi_mt700711ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.RoleClass;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Null Author Role</p>
 * 
 * <p>This is a messaging artifact used by HL7 to allow the 
 * time, signiture and method to be captured when the author is 
 * not sent. This will happen in circumstances where the author 
 * information is sent as part of the authentication token.</p>
 */
@Hl7PartTypeMapping({"MFMI_MT700711CA.AuthorRole"})
public class NullAuthorRoleBean extends MessagePartBean implements ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged.AuthorPerson {

    private static final long serialVersionUID = 20121204L;
    private CS classCode = new CSImpl();


    /**
     * <p>Relationship: MFMI_MT700711CA.AuthorRole.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"classCode"})
    public RoleClass getClassCode() {
        return (RoleClass) this.classCode.getValue();
    }

    /**
     * <p>Relationship: MFMI_MT700711CA.AuthorRole.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setClassCode(RoleClass classCode) {
        this.classCode.setValue(classCode);
    }

}
