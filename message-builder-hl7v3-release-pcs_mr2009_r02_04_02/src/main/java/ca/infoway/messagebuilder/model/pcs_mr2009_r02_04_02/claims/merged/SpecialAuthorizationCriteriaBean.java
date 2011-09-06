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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT400001CA.SpecialAuthorizationCriteria","FICR_MT490103CA.SpecialAuthorizationCriteria"})
public class SpecialAuthorizationCriteriaBean extends MessagePartBean {

    private static final long serialVersionUID = 20110906L;
    private CV generalSupportingInformationType = new CVImpl();
    private ST text = new STImpl();
    private ST generalSupportingInformationValue = new STImpl();


    /**
     * <p>GeneralSupportingInformationType</p>
     * 
     * <p>General Supporting Information Type</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getGeneralSupportingInformationType() {
        return (Code) this.generalSupportingInformationType.getValue();
    }
    public void setGeneralSupportingInformationType(Code generalSupportingInformationType) {
        this.generalSupportingInformationType.setValue(generalSupportingInformationType);
    }


    /**
     * <p>General Supporting Information Text</p>
     * 
     * <p>Special Authorization Criteria Text</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>GeneralSupportingInformationValue</p>
     * 
     * <p>General Supporting Information Value</p>
     */
    @Hl7XmlMapping({"value"})
    public String getGeneralSupportingInformationValue() {
        return this.generalSupportingInformationValue.getValue();
    }
    public void setGeneralSupportingInformationValue(String generalSupportingInformationValue) {
        this.generalSupportingInformationValue.setValue(generalSupportingInformationValue);
    }

}
