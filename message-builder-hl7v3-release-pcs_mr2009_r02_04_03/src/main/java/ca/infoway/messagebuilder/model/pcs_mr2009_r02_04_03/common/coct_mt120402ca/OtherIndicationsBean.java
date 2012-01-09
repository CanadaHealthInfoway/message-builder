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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt120402ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActNonConditionIndicationCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Other indications</p>
 * 
 * <p><p>Must have at least one of code or text</p></p>
 * 
 * <p><p>Describes indications that are not diagnosis or 
 * symptom-related (e.g. contrast agents)</p></p>
 * 
 * <p><p>Allows separation of conditions from symptoms from 
 * other forms of indication.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT120402CA.OtherIndication"})
public class OtherIndicationsBean extends MessagePartBean implements Indications {

    private static final long serialVersionUID = 20120106L;
    private CV code = new CVImpl();
    private ST text = new STImpl();


    /**
     * <p>Other Indication</p>
     * 
     * <p><p>A code indicating some other action which is the 
     * reason for a therapy.</p></p>
     * 
     * <p><p>EPHS: vocab proposal needed for simple concepts of i) 
     * sign or symptom related to investigation disease ii) sign or 
     * symptom not related to investigation disease. EPHS: act.code 
     * value needed for encounter reason; reason for treatment; 
     * immunization interpretation reason</p></p>
     * 
     * <p><p>Allows for coded representation of a non-condition 
     * based indication such as administration of a contrast agent 
     * for a lab test.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActNonConditionIndicationCode getCode() {
        return (ActNonConditionIndicationCode) this.code.getValue();
    }
    public void setCode(ActNonConditionIndicationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Other indication ad-hoc description</p>
     * 
     * <p><p>A textual description of an indication not meant to be 
     * either diagnosis or symptom.</p></p>
     * 
     * <p><p>Provides ability to describe indication without 
     * labeling it a diagnosis or symptom. Attribute as free form 
     * text is the only information allowed.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }

}