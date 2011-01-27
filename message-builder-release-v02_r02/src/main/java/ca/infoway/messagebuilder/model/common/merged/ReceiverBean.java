/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"MCCI_MT002100CA.Receiver","MCCI_MT002200CA.Receiver","MCCI_MT002300CA.Receiver","MCCI_MT102001CA.Receiver"})
public class ReceiverBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private ST deviceName = new STImpl();
    private II receiverApplicationIdentifier = new IIImpl();
    private II receiverOrganizationIdentifier = new IIImpl();
    private TEL receiverNetworkAddress = new TELImpl();


    /**
     * <p>JE:Receiver Application Name</p>
     * 
     * <p><p>Name of receiver application.</p></p>
     * 
     * <p>JE:Receiver Application Name</p>
     * 
     * <p><p>Name of receiver application.</p></p>
     * 
     * <p><p>Optional name of receiver application</p></p>
     * 
     * <p>JE:Receiver Application Name</p>
     * 
     * <p><p>Optional name of receiver application.</p></p>
     * 
     * <p><p>Optional application name.</p></p>
     * 
     * <p>JE:Receiving Application Name</p>
     * 
     * <p><p>Name of the receiving application.</p></p>
     * 
     * <p><p>Optional name of the receiving application.</p></p>
     */
    @Hl7XmlMapping({"device/name"})
    public String getDeviceName() {
        return this.deviceName.getValue();
    }
    public void setDeviceName(String deviceName) {
        this.deviceName.setValue(deviceName);
    }


    /**
     * <p>ReceiverApplicationIdentifier</p>
     * 
     * <p>JA:Receiver Application Identifier</p>
     * 
     * <p><p>The unique identifier of the application to which the 
     * message is being sent.</p></p>
     * 
     * <p><p>soap:Header\wsa:To\@endpointID</p></p>
     * 
     * <p><p>Used for routing and for verification that &quot;yes, 
     * this message is intended for me.&quot; This is mandatory 
     * because it is the key identifier of the receiving 
     * application.</p></p>
     */
    @Hl7XmlMapping({"device/id"})
    public Identifier getReceiverApplicationIdentifier() {
        return this.receiverApplicationIdentifier.getValue();
    }
    public void setReceiverApplicationIdentifier(Identifier receiverApplicationIdentifier) {
        this.receiverApplicationIdentifier.setValue(receiverApplicationIdentifier);
    }


    /**
     * <p>ReceiverOrganizationIdentifier</p>
     * 
     * <p>JK:Receiver Organization Identifier</p>
     * 
     * <p><p>Name of receiver application.</p></p>
     * 
     * <p><p>Identifier is the only non-structure attribute in this 
     * class and is therefore mandatory. The agent association from 
     * the receiver device (application) to the agent role is 
     * optional.</p></p>
     * 
     * <p>JK:Receiver Organization Identifier</p>
     * 
     * <p><p>Organization intended to receive this message</p></p>
     * 
     * <p><p>Id is the only attribute in this class which is 
     * non-structural and is therefore mandatory. The agent 
     * association (from the receiver device) is optional.</p></p>
     * 
     * <p>JK:Receiver Organization Identifier</p>
     * 
     * <p><p>Receiver organization.</p></p>
     * 
     * <p><p>The identifier of the receiver organization. This is 
     * the only non-structural attribute in this class and is 
     * therefore mandatory. Receiver organization is optional (as 
     * the scoper association from the receiver application is 
     * optional).</p></p>
     * 
     * <p>JK:Receiver Organization Identifier</p>
     * 
     * <p><p>Unique identifier for the receiver organization.</p></p>
     * 
     * <p><p>The identifier is the only non-structural attribute in 
     * this class and is therefore mandatory. The association from 
     * receiver device to agent is optional.</p></p>
     */
    @Hl7XmlMapping({"device/agent/agentOrganization/id"})
    public Identifier getReceiverOrganizationIdentifier() {
        return this.receiverOrganizationIdentifier.getValue();
    }
    public void setReceiverOrganizationIdentifier(Identifier receiverOrganizationIdentifier) {
        this.receiverOrganizationIdentifier.setValue(receiverOrganizationIdentifier);
    }


    /**
     * <p>ReceiverNetworkAddress</p>
     * 
     * <p>JB:Receiver Network Address</p>
     * 
     * <p><p>The address to which this message is being sent.</p></p>
     * 
     * <p><p>soap:Header\wsa:To</p></p>
     * 
     * <p><p>Indicates where the message should be sent. This is 
     * optional because not all environments require network 
     * addresses. It is mandatory when communicating using 
     * SOAP.</p></p>
     */
    @Hl7XmlMapping({"telecom"})
    public TelecommunicationAddress getReceiverNetworkAddress() {
        return this.receiverNetworkAddress.getValue();
    }
    public void setReceiverNetworkAddress(TelecommunicationAddress receiverNetworkAddress) {
        this.receiverNetworkAddress.setValue(receiverNetworkAddress);
    }

}