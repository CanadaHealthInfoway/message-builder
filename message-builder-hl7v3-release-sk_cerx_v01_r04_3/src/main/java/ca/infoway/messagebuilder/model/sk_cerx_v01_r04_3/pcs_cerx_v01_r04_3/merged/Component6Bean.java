/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Includes</p>
 * 
 * <p>PORX_MT060060CA.Component6: f:includes</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifies 
 * the instructions for how the prescribed device should be 
 * dispensed to the patient.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifies 
 * the instructions for how the prescribed medication should be 
 * dispensed to the patient.</p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">An essential part 
 * of most prescriptions is the authorization to dispense. 
 * Multiple repetitions are included to accommodate 
 * circumstances where multiple drug products may need to be 
 * dispensed to complete a therapy. E.g. 100 x 20mg tablets and 
 * 50 x 10mg tablets. The association is marked as Populated 
 * because the authorization to dispense is a critical portion 
 * of a prescription. However the association is allowed to be 
 * 'null' when the order is for a device which requires no 
 * dispense authorization, or when the patient already has 
 * sufficient supply of the device on hand to complete the 
 * therapy.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifies 
 * the instructions for how the prescribed medication should be 
 * dispensed to the patient.</p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">An essential part 
 * of most prescriptions is the authorization to dispense. 
 * Multiple repetitions are included to accommodate 
 * circumstances where multiple drug products may need to be 
 * dispensed to complete a therapy. E.g. 100 x 20mg tablets and 
 * 50 x 10mg tablets. The association is marked as Populated 
 * because the authorization to dispense is a critical portion 
 * of a prescription. However the association is allowed to be 
 * 'null' when the order is for a device which requires no 
 * dispense authorization, or when the patient already has 
 * sufficient supply of the device on hand to complete the 
 * therapy.</p></p>
 * 
 * <p>PORX_MT010120CA.Component6: f:includes</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifies 
 * the instructions for how the prescribed medication should be 
 * dispensed to the patient.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">An essential 
 * part of most prescriptions is the authorization to dispense. 
 * Multiple repetitions are included to accommodate 
 * circumstances where multiple drug products may need to be 
 * dispensed to complete a therapy. E.g. 100 x 20mg tablets and 
 * 50 x 10mg tablets. The association is marked as Populated 
 * because the authorization to dispense is a critical portion 
 * of a prescription. However the association is allowed to be 
 * 'null' when the order is for a medication which requires no 
 * dispense authorization (e.g. over-the-counter medications), 
 * or when the patient already has sufficient supply of the 
 * medication on hand to complete the therapy.</p></p>
 * 
 * <p>PORX_MT010110CA.Component6: f:includes</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifies 
 * the instructions for how the prescribed device should be 
 * dispensed to the patient.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">An essential 
 * part of most prescriptions is the authorization to 
 * dispense.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT010110CA.Component6","PORX_MT010120CA.Component6","PORX_MT060060CA.Component6"})
public class Component6Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private DispenseInstructions_1Bean supplyRequest;


    @Hl7XmlMapping({"supplyRequest"})
    public DispenseInstructions_1Bean getSupplyRequest() {
        return this.supplyRequest;
    }
    public void setSupplyRequest(DispenseInstructions_1Bean supplyRequest) {
        this.supplyRequest = supplyRequest;
    }

}
