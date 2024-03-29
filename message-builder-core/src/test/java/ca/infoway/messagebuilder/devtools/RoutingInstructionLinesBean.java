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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.devtools;

import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



//@Hl7PartTypeMapping({"MCCI_MT002100CA.AttentionLine","MCCI_MT002300CA.AttentionLine","MCCI_MT102001CA.AttentionLine"})
public class RoutingInstructionLinesBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private ST keyWordText = new STImpl();
    private ST value = new STImpl();


    /**
     * <p>RoutingType</p>
     * 
     * <p>A:Routing Type</p>
     * 
     * <p><p>A particular type of guidance for routing the 
     * message.</p></p>
     * 
     * <p><p>Allows categorization of routing types or support for 
     * multiple route pieces. Mandatory to understand the routing 
     * information.</p></p>
     */
//    @Hl7XmlMapping({"keyWordText"})
    public String getKeyWordText() {
        return this.keyWordText.getValue();
    }
    public void setKeyWordText(String keyWordText) {
        this.keyWordText.setValue(keyWordText);
    }


    /**
     * <p>RoutingName</p>
     * 
     * <p>B:Routing Name</p>
     * 
     * <p><p>Indicates the specific value used to route the 
     * item.</p></p>
     * 
     * <p><p>Allows internal routing within an application.</p></p>
     */
//    @Hl7XmlMapping({"value"})
    public String getValue() {
        return this.value.getValue();
    }
    public void setValue(String value) {
        this.value.setValue(value);
    }

}
