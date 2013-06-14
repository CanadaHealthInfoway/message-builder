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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: RoutingInstructionLines</p>
 * 
 * <p>MCCI_MT102001CA.AttentionLine: Routing Instruction Lines</p>
 * 
 * <p>Allows direction of messages within complex applications. 
 * This association is optional because not all applications 
 * will require this level of routing.</p>
 * 
 * <p>Provides information on how the message should be routed 
 * within the receiving application.</p>
 * 
 * <p>MCCI_MT002300CA.AttentionLine: Routing Instruction Lines</p>
 * 
 * <p>Allows direction of messages within complex applications. 
 * This association is optional because not all applications 
 * will require this level of routing.</p>
 * 
 * <p>Provides information on how the message should be routed 
 * within the receiving application.</p>
 * 
 * <p>MCCI_MT002100CA.AttentionLine: Routing Instruction Lines</p>
 * 
 * <p>Allows direction of messages within complex applications. 
 * This association is optional because not all applications 
 * will require this level of routing.</p>
 * 
 * <p>Provides information on how the message should be routed 
 * within the receiving application.</p>
 */
@Hl7PartTypeMapping({"MCCI_MT002100CA.AttentionLine","MCCI_MT002300CA.AttentionLine","MCCI_MT102001CA.AttentionLine"})
public class RoutingInstructionLinesBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private ST keyWordText = new STImpl();
    private ST value = new STImpl();


    /**
     * <p>Business Name: RoutingType</p>
     * 
     * <p>Un-merged Business Name: RoutingType</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.AttentionLine.keyWordText</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorization of routing types or support for 
     * multiple route pieces. Mandatory to understand the routing 
     * information.</p>
     * 
     * <p>A particular type of guidance for routing the 
     * message.</p>
     * 
     * <p>Un-merged Business Name: RoutingType</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.AttentionLine.keyWordText</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorization of routing types or support for 
     * multiple route pieces. Mandatory to understand the routing 
     * information.</p>
     * 
     * <p>A particular type of guidance for routing the 
     * message.</p>
     * 
     * <p>Un-merged Business Name: RoutingType</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.AttentionLine.keyWordText</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorization of routing types or support for 
     * multiple route pieces. Mandatory to understand the routing 
     * information.</p>
     * 
     * <p>A particular type of guidance for routing the 
     * message.</p>
     */
    @Hl7XmlMapping({"keyWordText"})
    public String getKeyWordText() {
        return this.keyWordText.getValue();
    }

    /**
     * <p>Business Name: RoutingType</p>
     * 
     * <p>Un-merged Business Name: RoutingType</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.AttentionLine.keyWordText</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorization of routing types or support for 
     * multiple route pieces. Mandatory to understand the routing 
     * information.</p>
     * 
     * <p>A particular type of guidance for routing the 
     * message.</p>
     * 
     * <p>Un-merged Business Name: RoutingType</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.AttentionLine.keyWordText</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorization of routing types or support for 
     * multiple route pieces. Mandatory to understand the routing 
     * information.</p>
     * 
     * <p>A particular type of guidance for routing the 
     * message.</p>
     * 
     * <p>Un-merged Business Name: RoutingType</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.AttentionLine.keyWordText</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorization of routing types or support for 
     * multiple route pieces. Mandatory to understand the routing 
     * information.</p>
     * 
     * <p>A particular type of guidance for routing the 
     * message.</p>
     */
    public void setKeyWordText(String keyWordText) {
        this.keyWordText.setValue(keyWordText);
    }


    /**
     * <p>Business Name: RoutingName</p>
     * 
     * <p>Un-merged Business Name: RoutingName</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.AttentionLine.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows internal routing within an application.</p>
     * 
     * <p>Indicates the specific value used to route the item.</p>
     * 
     * <p>Un-merged Business Name: RoutingName</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.AttentionLine.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows internal routing within an application.</p>
     * 
     * <p>Indicates the specific value used to route the item.</p>
     * 
     * <p>Un-merged Business Name: RoutingName</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.AttentionLine.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows internal routing within an application.</p>
     * 
     * <p>Indicates the specific value used to route the item.</p>
     */
    @Hl7XmlMapping({"value"})
    public String getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: RoutingName</p>
     * 
     * <p>Un-merged Business Name: RoutingName</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.AttentionLine.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows internal routing within an application.</p>
     * 
     * <p>Indicates the specific value used to route the item.</p>
     * 
     * <p>Un-merged Business Name: RoutingName</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.AttentionLine.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows internal routing within an application.</p>
     * 
     * <p>Indicates the specific value used to route the item.</p>
     * 
     * <p>Un-merged Business Name: RoutingName</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.AttentionLine.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows internal routing within an application.</p>
     * 
     * <p>Indicates the specific value used to route the item.</p>
     */
    public void setValue(String value) {
        this.value.setValue(value);
    }

}
