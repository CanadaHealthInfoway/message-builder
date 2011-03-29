/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT060160CA.CarrierRole","PORX_MT060340CA.CarrierRole"})
public class CarrierRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private ST payorName = new STImpl();
    private II payorIdentifier = new IIImpl();
    private ST underwritingOrganizationName = new STImpl();


    /**
     * <p>PayorName</p>
     * 
     * <p>Payor Name</p>
     */
    @Hl7XmlMapping({"underwritingCarrierOrganization/name"})
    public String getPayorName() {
        return this.payorName.getValue();
    }
    public void setPayorName(String payorName) {
        this.payorName.setValue(payorName);
    }


    /**
     * <p>PayorIdentifier</p>
     * 
     * <p>Payor Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPayorIdentifier() {
        return this.payorIdentifier.getValue();
    }
    public void setPayorIdentifier(Identifier payorIdentifier) {
        this.payorIdentifier.setValue(payorIdentifier);
    }


    /**
     * <p>PayorName</p>
     * 
     * <p>Payor Name</p>
     */
    @Hl7XmlMapping({"underwritingOrganization/name"})
    public String getUnderwritingOrganizationName() {
        return this.underwritingOrganizationName.getValue();
    }
    public void setUnderwritingOrganizationName(String underwritingOrganizationName) {
        this.underwritingOrganizationName.setValue(underwritingOrganizationName);
    }

}