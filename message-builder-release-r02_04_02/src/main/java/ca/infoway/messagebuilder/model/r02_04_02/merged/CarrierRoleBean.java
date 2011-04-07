/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT500201CA.CarrierRole","FICR_MT600201CA.CarrierRole","FICR_MT610201CA.CarrierRole","PORX_MT060160CA.CarrierRole","PORX_MT060340CA.CarrierRole"})
public class CarrierRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private II id = new IIImpl();
    private ST payorName = new STImpl();
    private ST underwritingOrganizationName = new STImpl();


    /**
     * <p>Payor Identifier</p>
     * 
     * <p><p>A unique identifier for the payor organization 
     * responsible for the coverage extension.</p></p>
     * 
     * <p><p>Gives context to the coverage extension identifier and 
     * therefore mandatory. Allows the dispensing service delivery 
     * location to know where to send a claim.</p></p>
     * 
     * <p>Carrier ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>PayorName</p>
     * 
     * <p>Payor Name</p>
     * 
     * <p><p>The name of the organization responsible for issuing 
     * the coverage extension.</p></p>
     * 
     * <p><p>Mandatory for display purposes.</p></p>
     */
    @Hl7XmlMapping({"underwritingCarrierOrganization/name"})
    public String getPayorName() {
        return this.payorName.getValue();
    }
    public void setPayorName(String payorName) {
        this.payorName.setValue(payorName);
    }


    /**
     * <p>PayorName</p>
     * 
     * <p>Payor Name</p>
     * 
     * <p><p>The name of the organization responsible for issuing 
     * the coverage extension.</p></p>
     * 
     * <p><p>Mandatory for display purposes.</p></p>
     */
    @Hl7XmlMapping({"underwritingOrganization/name"})
    public String getUnderwritingOrganizationName() {
        return this.underwritingOrganizationName.getValue();
    }
    public void setUnderwritingOrganizationName(String underwritingOrganizationName) {
        this.underwritingOrganizationName.setValue(underwritingOrganizationName);
    }

}
