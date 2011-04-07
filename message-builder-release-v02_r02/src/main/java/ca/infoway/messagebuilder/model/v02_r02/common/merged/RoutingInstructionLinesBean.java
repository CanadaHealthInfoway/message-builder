/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>RoutingInstructionLines</p>
 * 
 * <p>MCCI_MT102001CA.AttentionLine: Routing Instruction Lines</p>
 * 
 * <p><p>Provides information on how the message should be 
 * routed within the receiving application.</p></p>
 * 
 * <p><p>Allows direction of messages within complex 
 * applications. This association is optional because not all 
 * applications will require this level of routing.</p></p>
 * 
 * <p>MCCI_MT002300CA.AttentionLine: Routing Instruction Lines</p>
 * 
 * <p><p>Provides information on how the message should be 
 * routed within the receiving application.</p></p>
 * 
 * <p><p>Allows direction of messages within complex 
 * applications. This association is optional because not all 
 * applications will require this level of routing.</p></p>
 * 
 * <p>MCCI_MT002100CA.AttentionLine: Routing Instruction Lines</p>
 * 
 * <p><p>Provides information on how the message should be 
 * routed within the receiving application.</p></p>
 * 
 * <p><p>Allows direction of messages within complex 
 * applications. This association is optional because not all 
 * applications will require this level of routing.</p></p>
 */
@Hl7PartTypeMapping({"MCCI_MT002100CA.AttentionLine","MCCI_MT002300CA.AttentionLine","MCCI_MT102001CA.AttentionLine"})
public class RoutingInstructionLinesBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private ST routingType = new STImpl();
    private ST routingName = new STImpl();


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
     * 
     * <p><p>Indicates the specific value used to route the 
     * item.</p></p>
     * 
     * <p><p>Allows internal routing within an application.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public String getRoutingName() {
        return this.routingName.getValue();
    }
    public void setRoutingName(String routingName) {
        this.routingName.setValue(routingName);
    }

}
