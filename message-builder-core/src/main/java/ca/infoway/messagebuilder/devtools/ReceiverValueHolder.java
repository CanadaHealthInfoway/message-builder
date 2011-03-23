package ca.infoway.messagebuilder.devtools;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;

public class ReceiverValueHolder {

    private TelecommunicationAddress receiverNetworkAddress;
    private Identifier receiverApplicationIdentifier;
    private String receiverApplicationName;
    private Identifier receiverOrganizationIdentifier;
    
	public TelecommunicationAddress getReceiverNetworkAddress() {
		return this.receiverNetworkAddress;
	}
	public void setReceiverNetworkAddress(TelecommunicationAddress receiverNetworkAddress) {
		this.receiverNetworkAddress = receiverNetworkAddress;
	}
	public Identifier getReceiverApplicationIdentifier() {
		return receiverApplicationIdentifier;
	}
	public void setReceiverApplicationIdentifier(Identifier receiverApplicationIdentifier) {
		this.receiverApplicationIdentifier = receiverApplicationIdentifier;
	}
	// SPD: sets receiverApplicationIdentifier...accommodate different part name
	public Identifier getRespondToApplicationIdentifier() {
		return this.receiverApplicationIdentifier;
	}
	public void setRespondToApplicationIdentifier(Identifier respondToApplicationIdentifier) {
		this.receiverApplicationIdentifier = respondToApplicationIdentifier;
	}	
	public String getReceiverApplicationName() {
		return this.receiverApplicationName;
	}
	public void setReceiverApplicationName(String receiverApplicationName) {
		this.receiverApplicationName = receiverApplicationName;
	}
	public Identifier getReceiverOrganizationIdentifier() {
		return this.receiverOrganizationIdentifier;
	}
	public void setReceiverOrganizationIdentifier(Identifier receiverOrganizationIdentifier) {
		this.receiverOrganizationIdentifier = receiverOrganizationIdentifier;
	}
	
}
