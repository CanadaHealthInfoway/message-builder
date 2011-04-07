/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Includes</p>
 * 
 * <p>PORX_MT060340CA.Component3: a:includes</p>
 * 
 * <p><p>Identifies the instructions for how the prescribed 
 * medication should be dispensed to the patient.</p></p>
 * 
 * <p><p>An essential part of most prescriptions is the 
 * authorization to dispense. Multiple repetitions are included 
 * to accommodate circumstances where multiple drug products 
 * may need to be dispensed to complete a therapy. E.g. 100 x 
 * 20mg tablets and 50 x 10mg tablets. The association is 
 * marked as Populated because the authorization to dispense is 
 * a critical portion of a prescription. However the 
 * association is allowed to be 'null' when the order is for a 
 * medication which requires no dispense authorization (e.g. 
 * over-the-counter medications), or when the patient already 
 * has sufficient supply of the medication on hand to complete 
 * the therapy.</p></p>
 * 
 * <p>PORX_MT060160CA.Component3: g:includes</p>
 * 
 * <p><p>Identifies the instructions for how the prescribed 
 * medication should be dispensed to the patient.</p></p>
 * 
 * <p><p>An essential part of most prescriptions is the 
 * authorization to dispense. Multiple repetitions are included 
 * to accommodate circumstances where multiple drug products 
 * may need to be dispensed to complete a therapy. E.g. 100 x 
 * 20mg tablets and 50 x 10mg tablets. The association is 
 * marked as Populated because the authorization to dispense is 
 * a critical portion of a prescription. However the 
 * association is allowed to be 'null' when the order is for a 
 * medication which requires no dispense authorization (e.g. 
 * over-the-counter medications), or when the patient already 
 * has sufficient supply of the medication on hand to complete 
 * the therapy.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060160CA.Component3","PORX_MT060340CA.Component3"})
public class Component3Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private ExtendedDispenseInstructionsBean supplyRequestItem;


    @Hl7XmlMapping({"supplyRequestItem"})
    public ExtendedDispenseInstructionsBean getSupplyRequestItem() {
        return this.supplyRequestItem;
    }
    public void setSupplyRequestItem(ExtendedDispenseInstructionsBean supplyRequestItem) {
        this.supplyRequestItem = supplyRequestItem;
    }

}
