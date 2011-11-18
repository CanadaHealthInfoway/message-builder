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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.si.comt_mt500001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Broadcast Message</p>
 * 
 * <p><p>Information being transmitted to proviers as a 'mass 
 * broadcast'</p></p>
 * 
 * <p><p>Allows conveying information such as stolen 
 * prescription pads, system availability information, etc.</p></p>
 */
@Hl7PartTypeMapping({"COMT_MT500001CA.InformEvent"})
@Hl7RootType
public class BroadcastMessageBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private ST text = new STImpl();


    /**
     * <p>Broadcast Message</p>
     * 
     * <p><p>Contains the text to be displayed to the user of the 
     * system.</p></p>
     * 
     * <p><p>Allows conveying of system messages and other types of 
     * alerts. E.g. Planned outages, stolen prescription pads, 
     * etc.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }

}
