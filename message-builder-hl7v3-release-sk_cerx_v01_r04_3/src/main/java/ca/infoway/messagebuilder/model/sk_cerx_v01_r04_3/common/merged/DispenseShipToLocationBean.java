/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>DispenseShipToLocation</p>
 * 
 * <p>PORX_MT060160CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The location 
 * where the dispensed product is expected to be delivered.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important as 
 * part of a claim for justifying shipping charges.</p></p>
 * 
 * <p>PORX_MT060040CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The location 
 * where the dispensed product is expected to be delivered.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important as 
 * part of a claim for justifying shipping charges.</p></p>
 * 
 * <p>PORX_MT060340CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The location 
 * where the dispensed product is expected to be delivered.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important as 
 * part of a claim for justifying shipping charges.</p></p>
 * 
 * <p>PORX_MT020070CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The location 
 * where the dispensed product is expected to be delivered.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important as 
 * part of a claim for justifying shipping charges.</p></p>
 * 
 * <p>PORX_MT020060CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The location 
 * where the dispensed product is expected to be delivered.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important as 
 * part of a claim for justifying shipping charges.</p></p>
 * 
 * <p>PORX_MT060090CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The location 
 * where the dispensed product is expected to be delivered.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important as 
 * part of a claim for justifying shipping charges.</p></p>
 * 
 * <p>PORX_MT060010CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The location 
 * where the dispensed product is expected to be delivered.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important as 
 * part of a claim for justifying shipping charges.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT010110CA.ServiceDeliveryLocation","PORX_MT010120CA.ServiceDeliveryLocation","PORX_MT020060CA.ServiceDeliveryLocation","PORX_MT020070CA.ServiceDeliveryLocation","PORX_MT060010CA.ServiceDeliveryLocation","PORX_MT060040CA.ServiceDeliveryLocation","PORX_MT060040CA.ServiceDeliveryLocation2","PORX_MT060090CA.ServiceDeliveryLocation","PORX_MT060160CA.ServiceDeliveryLocation","PORX_MT060160CA.ServiceDeliveryLocation2","PORX_MT060340CA.ServiceDeliveryLocation","PORX_MT060340CA.ServiceDeliveryLocation2"})
public class DispenseShipToLocationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private AD addr = new ADImpl();


    /**
     * <p>H:Prescription Ship to Address</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the location the dispensed medication should be shipped to, 
     * at the request of the patient or provider.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">In some 
     * cases drugs need to be delivered to the patient instead of 
     * being picked up. In other cases, drugs need to be shipped to 
     * the physician's office to replace stock used for the 
     * patient.</p></p>
     * 
     * <p>H:Prescription Ship to Address</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the location the dispensed device should be shipped to, at 
     * the request of the patient or provider.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">In some 
     * cases devices need to be delivered to the patient instead of 
     * being picked up. In other cases, devices need to be shipped 
     * to the physician's office to replace stock used for the 
     * patient.</p></p>
     * 
     * <p>I:Ship-To Address</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * where the dispensed product was sent.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important as 
     * part of a claim for justifying shipping charges.</p></p>
     * 
     * <p>Ship To Address</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * where the dispensed product was sent.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important as 
     * part of a claim for justifying shipping charges.</p></p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }

}
