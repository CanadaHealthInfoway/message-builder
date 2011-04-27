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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"MCCI_MT000100CA.AttentionLine","MCCI_MT000200CA.AttentionLine","MCCI_MT000300CA.AttentionLine","MCCI_MT102001CA.AttentionLine"})
public class RoutingInstructionLinesBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private ST routingType = new STImpl();
    private ST routingName = new STImpl();


    /**
     * <p>RoutingType</p>
     * 
     * <p>A:Routing Type</p>
     */
    @Hl7XmlMapping({"keyWordText"})
    public String getRoutingType() {
        return this.routingType.getValue();
    }
    public void setRoutingType(String routingType) {
        this.routingType.setValue(routingType);
    }


    /**
     * <p>RoutingName</p>
     * 
     * <p>B:Routing Name</p>
     */
    @Hl7XmlMapping({"value"})
    public String getRoutingName() {
        return this.routingName.getValue();
    }
    public void setRoutingName(String routingName) {
        this.routingName.setValue(routingName);
    }

}
