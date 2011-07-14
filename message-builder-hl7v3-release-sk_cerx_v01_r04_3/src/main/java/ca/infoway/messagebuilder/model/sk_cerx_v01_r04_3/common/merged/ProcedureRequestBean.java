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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT010110CA.ProcedureRequest","PORX_MT020060CA.ProcedureRequest","PORX_MT060010CA.ProcedureRequest","PORX_MT060040CA.ProcedureRequest","PORX_MT060060CA.ProcedureRequest"})
public class ProcedureRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private ST usageInstructions = new STImpl();


    /**
     * <p>UsageInstructions</p>
     * 
     * <p>Usage Instructions</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * how the device should be used by the patient.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Instructions 
     * are a key part of the prescription.</p></p>
     * 
     * <p>Usage Instructions</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * how the patient is expected to use the device.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Communicates 
     * to other providers how the patient is expected to use the 
     * dispensed device</p></p>
     * 
     * <p>Usage Instructions</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * how the device is intended to be used.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Shows other 
     * providers the usage instructions provided to the 
     * patient.</p></p>
     * 
     * <p>Usage Instructions</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * how the prescribed device is intended to be used.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Usage 
     * instructions are a critical part of a prescription.</p></p>
     * 
     * <p>Usage Instructions</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * how the prescribed device is intended to be used.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Instructions 
     * for use are a key part of any prescription</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getUsageInstructions() {
        return this.usageInstructions.getValue();
    }
    public void setUsageInstructions(String usageInstructions) {
        this.usageInstructions.setValue(usageInstructions);
    }

}
