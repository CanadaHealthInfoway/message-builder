/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt060340ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>f:includes</p>
 * 
 * <p>Identifies the instructions for how the prescribed 
 * medication should be dispensed to the patient.</p>
 * 
 * <p>An essential part of most prescriptions is the 
 * authorization to dispense. Multiple repetitions are included 
 * to accommodate circumstances where multiple drug products 
 * may need to be dispensed to complete a therapy. E.g. 100 x 
 * 20mg tablets and 50 x 10mg tablets. The association is 
 * marked as Populated because the authorization to dispense is 
 * a critical portion of a prescription. However the 
 * association is allowed to be '''null''' when the order is 
 * for a medication which requires no dispense authorization 
 * (e.g. over-the-counter medications), or when the patient 
 * already has sufficient supply of the medication on hand to 
 * complete the therapy.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060340CA.Component6"})
public class Component6Bean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private DispenseInstructionsBean supplyRequest;

    @Hl7XmlMapping({"supplyRequest"})
    public DispenseInstructionsBean getSupplyRequest() {
        return this.supplyRequest;
    }
    public void setSupplyRequest(DispenseInstructionsBean supplyRequest) {
        this.supplyRequest = supplyRequest;
    }

}
