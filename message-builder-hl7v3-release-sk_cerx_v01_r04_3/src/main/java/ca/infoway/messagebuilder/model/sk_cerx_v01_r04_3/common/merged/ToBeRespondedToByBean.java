/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>ToBeRespondedToBy</p>
 * 
 * <p>MCCI_MT102001CA.RespondTo: to be responded to by</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
 * the interaction that should receive the response to this 
 * interaction. Used when different from the sender of the 
 * original interaction.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">In complex 
 * routing environments, the acknowledgements may need to be 
 * sent to a system other than the one which constructed the 
 * original message. This association is optional because not 
 * all environments will support responses to systems other 
 * than the original sender.</p></p>
 * 
 * <p>MCCI_MT000100CA.RespondTo: to be responded to by</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
 * the interaction that should receive the response to this 
 * interaction. Used when different from the sender of the 
 * original interaction.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">In complex 
 * routing environments, the acknowledgements may need to be 
 * sent to a system other than the one which constructed the 
 * original message. This association is optional because not 
 * all environments will support responses to systems other 
 * than the original sender.</p></p>
 * 
 * <p>MCCI_MT000200CA.RespondTo: to be responded to by</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
 * the interaction that should receive the response to this 
 * interaction. Used when different from the sender of the 
 * original interaction.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">In complex 
 * routing environments, the acknowledgements may need to be 
 * sent to a system other than the one which constructed the 
 * original message. This association is optional because not 
 * all environments will support responses to systems other 
 * than the original sender.</p></p>
 * 
 * <p>MCCI_MT000300CA.RespondTo: to be responded to by</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
 * the interaction that should receive the response to this 
 * interaction. Used when different from the sender of the 
 * original interaction.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">In complex 
 * routing environments, the acknowledgements may need to be 
 * sent to a system other than the one which constructed the 
 * original message. This association is optional because not 
 * all environments will support responses to systems other 
 * than the original sender.</p></p>
 */
@Hl7PartTypeMapping({"MCCI_MT000100CA.RespondTo","MCCI_MT000200CA.RespondTo","MCCI_MT000300CA.RespondTo","MCCI_MT102001CA.RespondTo"})
public class ToBeRespondedToByBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private TEL respondToNetworkAddress = new TELImpl();
    private II respondToApplicationIdentifier = new IIImpl();
    private II respondToOrganizationId = new IIImpl();
    private II respondToFacilityId = new IIImpl();


    /**
     * <p>RespondToNetworkAddress</p>
     * 
     * <p>KB:Respond to Network Address</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the address to send acknowledgments of this message to.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Needed when 
     * the address to respond to is different than that of the 
     * sender. This is optional because not all environments 
     * require network addresses.</p></p>
     */
    @Hl7XmlMapping({"telecom"})
    public TelecommunicationAddress getRespondToNetworkAddress() {
        return this.respondToNetworkAddress.getValue();
    }
    public void setRespondToNetworkAddress(TelecommunicationAddress respondToNetworkAddress) {
        this.respondToNetworkAddress.setValue(respondToNetworkAddress);
    }


    /**
     * <p>RespondToApplicationIdentifier</p>
     * 
     * <p>KA:Respond to Application Identifier</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The unique 
     * identifier of the applications to which responses should be 
     * sent. Only populated when different from the sending 
     * application id.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * unique identification and routing to the application to be 
     * responded to. This attribute is mandatory be cause it is the 
     * principal identifier of the application to respond to.</p></p>
     */
    @Hl7XmlMapping({"device/id"})
    public Identifier getRespondToApplicationIdentifier() {
        return this.respondToApplicationIdentifier.getValue();
    }
    public void setRespondToApplicationIdentifier(Identifier respondToApplicationIdentifier) {
        this.respondToApplicationIdentifier.setValue(respondToApplicationIdentifier);
    }


    /**
     * <p>RespondToOrganizationId</p>
     * 
     * <p>KC:Respond to Organization Id</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The unique 
     * identifier of the application who is to be responsible for 
     * responses to this message.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Needed for 
     * circumstances where the 'respond to' organization is 
     * different than the sending organization. This attribute is 
     * optional because not all environments require communicating 
     * this information.</p></p>
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
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the clinic or other facility to which responses to this 
     * interaction should be sent.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">May affect 
     * the routing of a message. This attribute is optional because 
     * not all environments require communicating this 
     * information.</p></p>
     */
    @Hl7XmlMapping({"device/asLocatedEntity/location/id"})
    public Identifier getRespondToFacilityId() {
        return this.respondToFacilityId.getValue();
    }
    public void setRespondToFacilityId(Identifier respondToFacilityId) {
        this.respondToFacilityId.setValue(respondToFacilityId);
    }

}
