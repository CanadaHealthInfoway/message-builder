package ca.infoway.messagebuilder.devtools;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;

public class ToBeRespondedToByValueHolder {
    private Identifier respondToApplicationIdentifier;
    private TelecommunicationAddress respondToNetworkAddress;
    
	public Identifier getRespondToApplicationIdentifier() {
		return this.respondToApplicationIdentifier;
	}
	public void setRespondToApplicationIdentifier(Identifier respondToApplicationIdentifier) {
		this.respondToApplicationIdentifier = respondToApplicationIdentifier;
	}
	
	public TelecommunicationAddress getRespondToNetworkAddress() {
		return this.respondToNetworkAddress;
	}
	public void setRespondToNetworkAddress(TelecommunicationAddress respondToNetworkAddress) {
		this.respondToNetworkAddress = respondToNetworkAddress;
	}
}
