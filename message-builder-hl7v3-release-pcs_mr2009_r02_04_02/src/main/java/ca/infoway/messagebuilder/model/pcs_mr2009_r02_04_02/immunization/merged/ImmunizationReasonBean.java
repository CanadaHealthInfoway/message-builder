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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>POIZ_MT030060CA.ImmunizationReason: (no business name)</p>
 * 
 * <p><p>The reason why an immunization event occurred.</p></p>
 * 
 * <p><p>Needed for explicitly communicating the reason why a 
 * patient was administered as vaccine.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.ImmunizationReason","POIZ_MT030060CA.ImmunizationReason","POIZ_MT060150CA.ImmunizationReason"})
public class ImmunizationReasonBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.Choice {

    private static final long serialVersionUID = 20110831L;
    private ST immunizationReasonText = new STImpl();
    private CV immunizationReason = new CVImpl();


    /**
     * <p>ImmunizationReasonText</p>
     * 
     * <p>Immunization Reason Text</p>
     * 
     * <p><p>A textual or multimedia description (or reference to a 
     * description) of the reason.</p></p>
     * 
     * <p><p>Provides additional context and description relating 
     * to the reason for immunization. Not all implementations will 
     * support text. As a result, this attribute is optional.</p></p>
     * 
     * <p>Immunization Reason Text</p>
     */
    @Hl7XmlMapping({"text"})
    public String getImmunizationReasonText() {
        return this.immunizationReasonText.getValue();
    }
    public void setImmunizationReasonText(String immunizationReasonText) {
        this.immunizationReasonText.setValue(immunizationReasonText);
    }


    /**
     * <p>ImmunizationReason</p>
     * 
     * <p>Immunization Reason</p>
     * 
     * <p><p>A coded value denoting a reason for immunizing a 
     * patient.</p></p>
     * 
     * <p><p>Allows sorting and categorizing different kinds of 
     * immunization reasons. Ensures that reasons are gathered in a 
     * consistent analyzable manner. As a result, this attribute is 
     * mandatory.</p></p>
     * 
     * <p>Immunization Reason</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public Code getImmunizationReason() {
        return (Code) this.immunizationReason.getValue();
    }
    public void setImmunizationReason(Code immunizationReason) {
        this.immunizationReason.setValue(immunizationReason);
    }

}
