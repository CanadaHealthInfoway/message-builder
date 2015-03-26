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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActSupportingInformationCode;



@Hl7PartTypeMapping({"FICR_MT400001CA.SpecialAuthorizationCriteria","FICR_MT490103CA.SpecialAuthorizationCriteria"})
public class SpecialAuthorizationCriteriaBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private ST value = new STImpl();


    /**
     * <p>Business Name: GeneralSupportingInformationType</p>
     * 
     * <p>Un-merged Business Name: GeneralSupportingInformationType</p>
     * 
     * <p>Relationship: 
     * FICR_MT490103CA.SpecialAuthorizationCriteria.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: GeneralSupportingInformationType</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.SpecialAuthorizationCriteria.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ActSupportingInformationCode getCode() {
        return (ActSupportingInformationCode) this.code.getValue();
    }

    /**
     * <p>Business Name: GeneralSupportingInformationType</p>
     * 
     * <p>Un-merged Business Name: GeneralSupportingInformationType</p>
     * 
     * <p>Relationship: 
     * FICR_MT490103CA.SpecialAuthorizationCriteria.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: GeneralSupportingInformationType</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.SpecialAuthorizationCriteria.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ActSupportingInformationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: GeneralSupportingInformationText</p>
     * 
     * <p>Relationship: 
     * FICR_MT490103CA.SpecialAuthorizationCriteria.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationCriteriaText</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.SpecialAuthorizationCriteria.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Un-merged Business Name: GeneralSupportingInformationText</p>
     * 
     * <p>Relationship: 
     * FICR_MT490103CA.SpecialAuthorizationCriteria.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationCriteriaText</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.SpecialAuthorizationCriteria.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: GeneralSupportingInformationValue</p>
     * 
     * <p>Un-merged Business Name: 
     * GeneralSupportingInformationValue</p>
     * 
     * <p>Relationship: 
     * FICR_MT490103CA.SpecialAuthorizationCriteria.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: 
     * GeneralSupportingInformationValue</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.SpecialAuthorizationCriteria.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"value"})
    public String getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: GeneralSupportingInformationValue</p>
     * 
     * <p>Un-merged Business Name: 
     * GeneralSupportingInformationValue</p>
     * 
     * <p>Relationship: 
     * FICR_MT490103CA.SpecialAuthorizationCriteria.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: 
     * GeneralSupportingInformationValue</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.SpecialAuthorizationCriteria.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setValue(String value) {
        this.value.setValue(value);
    }

}
