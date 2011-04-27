/**
 * Copyright 2011 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

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
