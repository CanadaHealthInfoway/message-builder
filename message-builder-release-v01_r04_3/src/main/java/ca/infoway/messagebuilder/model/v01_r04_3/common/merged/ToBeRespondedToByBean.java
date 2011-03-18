/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"MCCI_MT000100CA.RespondTo","MCCI_MT000200CA.RespondTo","MCCI_MT000300CA.RespondTo","MCCI_MT102001CA.RespondTo"})
public class ToBeRespondedToByBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private II respondToOrganizationId = new IIImpl();
    private II respondToFacilityId = new IIImpl();
    private II respondToApplicationIdentifier = new IIImpl();
    private TEL respondToNetworkAddress = new TELImpl();


    /**
     * <p>RespondToOrganizationId</p>
     * 
     * <p>KC:Respond to Organization Id</p>
     */
    @Hl7XmlMapping({"device/asAgent/representedOrganization/id"})
    public Identifier getRespondToOrganizationId() {
        return this.respondToOrganizationId.getValue();
    }
    public void setRespondToOrganizationId(Identifier respondToOrganizationId) {
        this.respondToOrganizationId.setValue(respondToOrganizationId);
    }


    /**
     * <p>RespondToFacilityId</p>
     * 
     * <p>KD:Respond to Facility Id</p>
     */
    @Hl7XmlMapping({"device/asLocatedEntity/location/id"})
    public Identifier getRespondToFacilityId() {
        return this.respondToFacilityId.getValue();
    }
    public void setRespondToFacilityId(Identifier respondToFacilityId) {
        this.respondToFacilityId.setValue(respondToFacilityId);
    }


    /**
     * <p>RespondToApplicationIdentifier</p>
     * 
     * <p>KA:Respond to Application Identifier</p>
     */
    @Hl7XmlMapping({"device/id"})
    public Identifier getRespondToApplicationIdentifier() {
        return this.respondToApplicationIdentifier.getValue();
    }
    public void setRespondToApplicationIdentifier(Identifier respondToApplicationIdentifier) {
        this.respondToApplicationIdentifier.setValue(respondToApplicationIdentifier);
    }


    /**
     * <p>RespondToNetworkAddress</p>
     * 
     * <p>KB:Respond to Network Address</p>
     */
    @Hl7XmlMapping({"telecom"})
    public TelecommunicationAddress getRespondToNetworkAddress() {
        return this.respondToNetworkAddress.getValue();
    }
    public void setRespondToNetworkAddress(TelecommunicationAddress respondToNetworkAddress) {
        this.respondToNetworkAddress.setValue(respondToNetworkAddress);
    }

}
