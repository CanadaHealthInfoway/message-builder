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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.porx_mt980040ca;

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
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is a 
 * modifier for a specific dosage line or for the entire SIG. 
 * Examples are: On empty stomach, At breakfast, before 
 * bedtime, etc.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Adds further 
 * constraint or flexibility to the primary administration 
 * instruction.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT980040CA.SupplementalInstruction"})
public class AdditionalSIGInstructionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private CS dosageUsageContext = new CSImpl();
    private ST additionalDosageInstruction = new STImpl();


    /**
     * <p>Dosage Usage Context</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the context of the administration.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = RQO, 
     * for administration instruction on orders</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = EVN, 
     * for administration instruction on dispenses</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = DEF, 
     * for administration instruction on medication definition 
     * documents/references (typically, monographs).</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the context of the administration.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = RQO, 
     * for administration instruction on orders</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = EVN, 
     * for administration instruction on dispenses</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = DEF, 
     * for administration instruction on medication definition 
     * documents/references (typically, monographs).</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the context of the administration.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = RQO, 
     * for administration instruction on orders</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = EVN, 
     * for administration instruction on dispenses</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = DEF, 
     * for administration instruction on medication definition 
     * documents/references (typically, monographs).</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the context of the administration.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = RQO, 
     * for administration instruction on orders</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = EVN, 
     * for administration instruction on dispenses</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">moodCode = DEF, 
     * for administration instruction on medication definition 
     * documents/references (typically, monographs).</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Puts the 
     * class in context, and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodDefEvnRqo getDosageUsageContext() {
        return (x_ActMoodDefEvnRqo) this.dosageUsageContext.getValue();
    }
    public void setDosageUsageContext(x_ActMoodDefEvnRqo dosageUsageContext) {
        this.dosageUsageContext.setValue(dosageUsageContext);
    }


    /**
     * <p>F:Additional Dosage Instruction</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A free form 
     * textual description of extended instruction regarding the 
     * administration of the drug.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.8</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows for 
     * expression of non-codable qualifiers such as: 'on an empty 
     * stomach', 'add water' etc; which do not affect calculations 
     * of frequencies or quantity.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">This attribute is 
     * marked as 'mandatory' as it is the only information that can 
     * be specified here.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows for 
     * expression of non-codable qualifiers such as: 'on an empty 
     * stomach', 'add water' etc; which do not affect calculations 
     * of frequencies or quantity.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">This attribute is 
     * marked as 'mandatory' as it is the only information that can 
     * be specified here.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getAdditionalDosageInstruction() {
        return this.additionalDosageInstruction.getValue();
    }
    public void setAdditionalDosageInstruction(String additionalDosageInstruction) {
        this.additionalDosageInstruction.setValue(additionalDosageInstruction);
    }

}
