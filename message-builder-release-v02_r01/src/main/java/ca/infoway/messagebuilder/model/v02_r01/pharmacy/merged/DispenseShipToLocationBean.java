/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT010110CA.ServiceDeliveryLocation","PORX_MT010120CA.ServiceDeliveryLocation","PORX_MT020060CA.ServiceDeliveryLocation","PORX_MT020070CA.ServiceDeliveryLocation","PORX_MT060010CA.ServiceDeliveryLocation","PORX_MT060040CA.ServiceDeliveryLocation","PORX_MT060040CA.ServiceDeliveryLocation2","PORX_MT060090CA.ServiceDeliveryLocation","PORX_MT060160CA.ServiceDeliveryLocation","PORX_MT060160CA.ServiceDeliveryLocation2","PORX_MT060340CA.ServiceDeliveryLocation","PORX_MT060340CA.ServiceDeliveryLocation2"})
public class DispenseShipToLocationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private AD addr = new ADImpl();


    /**
     * <p>I:Ship-To Address</p>
     * 
     * <p>Ship To Address</p>
     * 
     * <p>H:Prescription Ship to Address</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }

}
