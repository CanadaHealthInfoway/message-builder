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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>PrivilegeCategorization</p>
 * 
 * <p>PRPM_MT306011CA.PrivilegeCategorization: Privilege 
 * Categorization</p>
 * 
 * <p><p>An act that is intended to result in new information 
 * about a subject. In this instance, regarding restrictions to 
 * practice for a specified healthcare provider.</p></p>
 * 
 * <p><p>Supports the business requirement to provide 
 * information about a healthcare provider where privileges 
 * have been restricted.</p></p>
 * 
 * <p>PRPM_MT309000CA.PrivilegeCategorization: Privilege 
 * Categorization</p>
 * 
 * <p><p>An act that is intended to result in new information 
 * about a subject. In this instance, regarding restrictions to 
 * practice for a specified healthcare provider.</p></p>
 * 
 * <p><p>Supports the business requirement to provide 
 * information about a healthcare provider where privileges 
 * have been restricted.</p></p>
 * 
 * <p>PRPM_MT303010CA.PrivilegeCategorization: Privilege 
 * Categorization</p>
 * 
 * <p><p>An act that is intended to result in new information 
 * about a subject. In this instance, regarding restrictions to 
 * practice for a specified healthcare provider.</p></p>
 * 
 * <p><p>Supports the business requirement to provide 
 * information about a healthcare provider where privileges 
 * have been restricted.</p></p>
 * 
 * <p>PRPM_MT301010CA.PrivilegeCategorization: Privilege 
 * Categorization</p>
 * 
 * <p><p>An act that is intended to result in new information 
 * about a subject. In this instance, regarding restrictions to 
 * practice for a specified healthcare provider.</p></p>
 * 
 * <p><p>Supports the business requirement to provide 
 * information about a healthcare provider where privileges 
 * have been restricted.</p></p>
 * 
 * <p><p>Default value for code is RESTRICTION</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT301010CA.PrivilegeCategorization","PRPM_MT303010CA.PrivilegeCategorization","PRPM_MT306011CA.PrivilegeCategorization","PRPM_MT309000CA.PrivilegeCategorization"})
public class PrivilegeCategorizationBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private CV code = new CVImpl();
    private CV value = new CVImpl();


    /**
     * <p>RestrictionsCategorizationType</p>
     * 
     * <p>Restrictions Categorization Type</p>
     * 
     * <p><p>The code identifying the specific privilege and/or 
     * restrictions on those privileges</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     * 
     * <p>Restrictions Categorization Type</p>
     * 
     * <p><p>The code identifying the specific privilege and/or 
     * restrictions on those privileges</p></p>
     * 
     * <p><p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     * 
     * <p>Restrictions Categorization Type</p>
     * 
     * <p><p>The code identifying the specific privilege and/or 
     * restrictions on those privileges</p></p>
     * 
     * <p><p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>RestrictionsCategorizationValue</p>
     * 
     * <p>Restrictions Categorization Value</p>
     * 
     * <p><p>The value identifying the specific privilege and/or 
     * restrictions on those privileges</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     * 
     * <p>Restrictions Categorization Value</p>
     * 
     * <p><p>The value identifying the specific privilege and/or 
     * restrictions on those privileges</p></p>
     * 
     * <p><p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     */
    @Hl7XmlMapping({"value"})
    public Code getValue() {
        return (Code) this.value.getValue();
    }
    public void setValue(Code value) {
        this.value.setValue(value);
    }

}
