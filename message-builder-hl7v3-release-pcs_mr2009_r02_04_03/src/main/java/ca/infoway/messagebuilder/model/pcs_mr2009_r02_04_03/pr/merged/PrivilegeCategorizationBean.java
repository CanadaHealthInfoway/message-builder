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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.RestrictionToPracticeCategorizationType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.RestrictionToPracticeCategorizationValue;



/**
 * <p>Business Name: PrivilegeCategorization</p>
 * 
 * <p>PRPM_MT303010CA.PrivilegeCategorization: Privilege 
 * Categorization</p>
 * 
 * <p>Supports the business requirement to provide information 
 * about a healthcare provider where privileges have been 
 * restricted.</p>
 * 
 * <p>An act that is intended to result in new information 
 * about a subject. In this instance, regarding restrictions to 
 * practice for a specified healthcare provider.</p>
 * 
 * <p>PRPM_MT309000CA.PrivilegeCategorization: Privilege 
 * Categorization</p>
 * 
 * <p>Supports the business requirement to provide information 
 * about a healthcare provider where privileges have been 
 * restricted.</p>
 * 
 * <p>An act that is intended to result in new information 
 * about a subject. In this instance, regarding restrictions to 
 * practice for a specified healthcare provider.</p>
 * 
 * <p>PRPM_MT301010CA.PrivilegeCategorization: Privilege 
 * Categorization</p>
 * 
 * <p>Supports the business requirement to provide information 
 * about a healthcare provider where privileges have been 
 * restricted.</p>
 * 
 * <p>Default value for code is RESTRICTION</p>
 * 
 * <p>An act that is intended to result in new information 
 * about a subject. In this instance, regarding restrictions to 
 * practice for a specified healthcare provider.</p>
 * 
 * <p>PRPM_MT306011CA.PrivilegeCategorization: Privilege 
 * Categorization</p>
 * 
 * <p>Supports the business requirement to provide information 
 * about a healthcare provider where privileges have been 
 * restricted.</p>
 * 
 * <p>An act that is intended to result in new information 
 * about a subject. In this instance, regarding restrictions to 
 * practice for a specified healthcare provider.</p>
 */
@Hl7PartTypeMapping({"PRPM_MT301010CA.PrivilegeCategorization","PRPM_MT303010CA.PrivilegeCategorization","PRPM_MT306011CA.PrivilegeCategorization","PRPM_MT309000CA.PrivilegeCategorization"})
public class PrivilegeCategorizationBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private CV code = new CVImpl();
    private CV value = new CVImpl();


    /**
     * <p>Business Name: RestrictionsCategorizationType</p>
     * 
     * <p>Un-merged Business Name: RestrictionsCategorizationType</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.PrivilegeCategorization.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>The code identifying the specific privilege and/or 
     * restrictions on those privileges</p>
     * 
     * <p>Un-merged Business Name: RestrictionsCategorizationType</p>
     * 
     * <p>Relationship: 
     * PRPM_MT309000CA.PrivilegeCategorization.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>The code identifying the specific privilege and/or 
     * restrictions on those privileges</p>
     * 
     * <p>Un-merged Business Name: RestrictionsCategorizationType</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.PrivilegeCategorization.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>The code identifying the specific privilege and/or 
     * restrictions on those privileges</p>
     * 
     * <p>Un-merged Business Name: RestrictionsCategorizationType</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.PrivilegeCategorization.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>The code identifying the specific privilege and/or 
     * restrictions on those privileges</p>
     */
    @Hl7XmlMapping({"code"})
    public RestrictionToPracticeCategorizationType getCode() {
        return (RestrictionToPracticeCategorizationType) this.code.getValue();
    }

    /**
     * <p>Business Name: RestrictionsCategorizationType</p>
     * 
     * <p>Un-merged Business Name: RestrictionsCategorizationType</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.PrivilegeCategorization.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>The code identifying the specific privilege and/or 
     * restrictions on those privileges</p>
     * 
     * <p>Un-merged Business Name: RestrictionsCategorizationType</p>
     * 
     * <p>Relationship: 
     * PRPM_MT309000CA.PrivilegeCategorization.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>The code identifying the specific privilege and/or 
     * restrictions on those privileges</p>
     * 
     * <p>Un-merged Business Name: RestrictionsCategorizationType</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.PrivilegeCategorization.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>The code identifying the specific privilege and/or 
     * restrictions on those privileges</p>
     * 
     * <p>Un-merged Business Name: RestrictionsCategorizationType</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.PrivilegeCategorization.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>The code identifying the specific privilege and/or 
     * restrictions on those privileges</p>
     */
    public void setCode(RestrictionToPracticeCategorizationType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: RestrictionsCategorizationValue</p>
     * 
     * <p>Un-merged Business Name: RestrictionsCategorizationValue</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.PrivilegeCategorization.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>The value identifying the specific privilege and/or 
     * restrictions on those privileges</p>
     * 
     * <p>Un-merged Business Name: RestrictionsCategorizationValue</p>
     * 
     * <p>Relationship: 
     * PRPM_MT309000CA.PrivilegeCategorization.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>The value identifying the specific privilege and/or 
     * restrictions on those privileges</p>
     * 
     * <p>Un-merged Business Name: RestrictionsCategorizationValue</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.PrivilegeCategorization.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>The value identifying the specific privilege and/or 
     * restrictions on those privileges</p>
     * 
     * <p>Un-merged Business Name: RestrictionsCategorizationValue</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.PrivilegeCategorization.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>The value identifying the specific privilege and/or 
     * restrictions on those privileges</p>
     */
    @Hl7XmlMapping({"value"})
    public RestrictionToPracticeCategorizationValue getValue() {
        return (RestrictionToPracticeCategorizationValue) this.value.getValue();
    }

    /**
     * <p>Business Name: RestrictionsCategorizationValue</p>
     * 
     * <p>Un-merged Business Name: RestrictionsCategorizationValue</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.PrivilegeCategorization.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>The value identifying the specific privilege and/or 
     * restrictions on those privileges</p>
     * 
     * <p>Un-merged Business Name: RestrictionsCategorizationValue</p>
     * 
     * <p>Relationship: 
     * PRPM_MT309000CA.PrivilegeCategorization.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>The value identifying the specific privilege and/or 
     * restrictions on those privileges</p>
     * 
     * <p>Un-merged Business Name: RestrictionsCategorizationValue</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.PrivilegeCategorization.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>The value identifying the specific privilege and/or 
     * restrictions on those privileges</p>
     * 
     * <p>Un-merged Business Name: RestrictionsCategorizationValue</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.PrivilegeCategorization.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>The value identifying the specific privilege and/or 
     * restrictions on those privileges</p>
     */
    public void setValue(RestrictionToPracticeCategorizationValue value) {
        this.value.setValue(value);
    }

}
