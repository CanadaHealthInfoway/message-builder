/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Includes</p>
 * 
 * <p>PORX_MT060060CA.Component6: f:includes</p>
 * 
 * <p><p>Identifies the instructions for how the prescribed 
 * device should be dispensed to the patient.</p></p>
 * 
 * <p><p>An essential part of most prescriptions is the 
 * authorization to dispense.</p></p>
 * 
 * <p>PORX_MT060040CA.Component6: f:includes</p>
 * 
 * <p><p>Identifies the instructions for how the prescribed 
 * device should be dispensed to the patient.</p></p>
 * 
 * <p><p>An essential part of most prescriptions is the 
 * authorization to dispense.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060040CA.Component6","PORX_MT060060CA.Component6"})
public class Component6Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private DispenseInstructionsBean supplyRequest;


    @Hl7XmlMapping({"supplyRequest"})
    public DispenseInstructionsBean getSupplyRequest() {
        return this.supplyRequest;
    }
    public void setSupplyRequest(DispenseInstructionsBean supplyRequest) {
        this.supplyRequest = supplyRequest;
    }

}