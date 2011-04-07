/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.common.merged;

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
