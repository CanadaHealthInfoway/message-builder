/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT060160CA.Component3","PORX_MT060340CA.Component3"})
public class Component3Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private ExtendedDispenseInstructionsBean supplyRequestItem;


    @Hl7XmlMapping({"supplyRequestItem"})
    public ExtendedDispenseInstructionsBean getSupplyRequestItem() {
        return this.supplyRequestItem;
    }
    public void setSupplyRequestItem(ExtendedDispenseInstructionsBean supplyRequestItem) {
        this.supplyRequestItem = supplyRequestItem;
    }

}