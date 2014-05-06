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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.common.comt_mt500001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Broadcast Message</p>
 * 
 * <p>Allows conveying information such as stolen prescription 
 * pads, system availability information, etc.</p>
 * 
 * <p>Information being transmitted to proviers as a 'mass 
 * broadcast'</p>
 */
@Hl7PartTypeMapping({"COMT_MT500001CA.InformEvent"})
@Hl7RootType
public class BroadcastMessageBean extends MessagePartBean {

    private static final long serialVersionUID = 20140506L;
    private ST text = new STImpl();


    /**
     * <p>Business Name: Broadcast Message</p>
     * 
     * <p>Relationship: COMT_MT500001CA.InformEvent.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows conveying of system messages and other types of 
     * alerts. E.g. Planned outages, stolen prescription pads, 
     * etc.</p>
     * 
     * <p>Contains the text to be displayed to the user of the 
     * system.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: Broadcast Message</p>
     * 
     * <p>Relationship: COMT_MT500001CA.InformEvent.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows conveying of system messages and other types of 
     * alerts. E.g. Planned outages, stolen prescription pads, 
     * etc.</p>
     * 
     * <p>Contains the text to be displayed to the user of the 
     * system.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }

}
