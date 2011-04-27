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
package ca.infoway.messagebuilder.model.common.coct_mt270010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodDefEvnRqo;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Additional SIG Instruction 
 * 
 * <p>This is a modifier for a specific dosage line or for the 
 * entire SIG. Examples are: On empty stomach, At breakfast, 
 * before bedtime, etc. 
 * 
 * <p>Adds further constraint or flexibility to the primary 
 * administration instruction. 
 * 
 * <p>- moodCode must be DEFN for drug definitions (such as as 
 * monographs) - moodCode must be RQO for orders; - moodCode 
 * must be EVN for dispenses and recording of other medications 
 * { x.; } 
 */
@Hl7PartTypeMapping({"COCT_MT270010CA.SupplementalInstruction"})
public class AdditionalSIGInstructionBean extends MessagePartBean {

    private CS<x_ActMoodDefEvnRqo> dosageUsageContext = new CSImpl<x_ActMoodDefEvnRqo>();
    private ST additionalDosageInstruction = new STImpl();

    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodDefEvnRqo getDosageUsageContext() {
        return this.dosageUsageContext.getValue();
    }
    public void setDosageUsageContext(x_ActMoodDefEvnRqo dosageUsageContext) {
        this.dosageUsageContext.setValue(dosageUsageContext);
    }

    @Hl7XmlMapping({"text"})
    public java.lang.String getAdditionalDosageInstruction() {
        return this.additionalDosageInstruction.getValue();
    }
    public void setAdditionalDosageInstruction(java.lang.String additionalDosageInstruction) {
        this.additionalDosageInstruction.setValue(additionalDosageInstruction);
    }

}
