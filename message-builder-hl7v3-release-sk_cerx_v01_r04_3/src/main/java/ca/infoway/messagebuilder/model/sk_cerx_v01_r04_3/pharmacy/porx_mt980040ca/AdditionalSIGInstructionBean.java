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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.porx_mt980040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodDefEvnRqo;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Additional SIG Instruction</p>
 * 
 * <p><p>- moodCode must be DEFN for drug definitions (such as 
 * as monographs) - moodCode must be RQO for orders; - moodCode 
 * must be EVN for dispenses and recording of other medications 
 * { x.; }</p></p>
 * 
 * <p><p>This is a modifier for a specific dosage line or for 
 * the entire SIG. Examples are: On empty stomach, At 
 * breakfast, before bedtime, etc.</p></p>
 * 
 * <p><p>Adds further constraint or flexibility to the primary 
 * administration instruction.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT980040CA.SupplementalInstruction"})
public class AdditionalSIGInstructionBean extends MessagePartBean {

    private static final long serialVersionUID = 20120320L;
    private CS moodCode = new CSImpl();
    private ST text = new STImpl();


    /**
     * <p>Dosage Usage Context</p>
     * 
     * <p><p>Indicates the context of the 
     * administration.</p><p>moodCode = RQO, for administration 
     * instruction on orders</p><p>moodCode = EVN, for 
     * administration instruction on dispenses</p><p>moodCode = 
     * DEF, for administration instruction on medication definition 
     * documents/references (typically, monographs).</p></p>
     * 
     * <p><p>Indicates the context of the 
     * administration.</p><p>moodCode = RQO, for administration 
     * instruction on orders</p><p>moodCode = EVN, for 
     * administration instruction on dispenses</p><p>moodCode = 
     * DEF, for administration instruction on medication definition 
     * documents/references (typically, monographs).</p></p>
     * 
     * <p><p>Indicates the context of the 
     * administration.</p><p>moodCode = RQO, for administration 
     * instruction on orders</p><p>moodCode = EVN, for 
     * administration instruction on dispenses</p><p>moodCode = 
     * DEF, for administration instruction on medication definition 
     * documents/references (typically, monographs).</p></p>
     * 
     * <p><p>Indicates the context of the 
     * administration.</p><p>moodCode = RQO, for administration 
     * instruction on orders</p><p>moodCode = EVN, for 
     * administration instruction on dispenses</p><p>moodCode = 
     * DEF, for administration instruction on medication definition 
     * documents/references (typically, monographs).</p></p>
     * 
     * <p><p>Puts the class in context, and is therefore 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodDefEvnRqo getMoodCode() {
        return (x_ActMoodDefEvnRqo) this.moodCode.getValue();
    }
    public void setMoodCode(x_ActMoodDefEvnRqo moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>F:Additional Dosage Instruction</p>
     * 
     * <p><p>A free form textual description of extended 
     * instruction regarding the administration of the drug.</p></p>
     * 
     * <p><p>ZDP.13.8</p></p>
     * 
     * <p><p>Allows for expression of non-codable qualifiers such 
     * as: 'on an empty stomach', 'add water' etc; which do not 
     * affect calculations of frequencies or quantity.</p><p>This 
     * attribute is marked as 'mandatory' as it is the only 
     * information that can be specified here.</p></p>
     * 
     * <p><p>Allows for expression of non-codable qualifiers such 
     * as: 'on an empty stomach', 'add water' etc; which do not 
     * affect calculations of frequencies or quantity.</p><p>This 
     * attribute is marked as 'mandatory' as it is the only 
     * information that can be specified here.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }

}
