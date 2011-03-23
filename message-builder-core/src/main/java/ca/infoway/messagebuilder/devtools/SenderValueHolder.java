package ca.infoway.messagebuilder.devtools;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;

public class SenderValueHolder {

    private TelecommunicationAddress sendingNetworkAddress;
    private Identifier sendingApplicationIdentifier;
    private String sendingApplicationName;
    private String sendingApplicationConfigurationInformation;
    private Interval<Date> sendingApplicationVersionDate;
    private String sendingSoftwareVersionNumber;
    private String sendingApplicationSoftwareName;
    private Identifier sendingOrganizationIdentifier;
    
	public TelecommunicationAddress getSendingNetworkAddress() {
		return this.sendingNetworkAddress;
	}
	public void setSendingNetworkAddress(TelecommunicationAddress sendingNetworkAddress) {
		this.sendingNetworkAddress = sendingNetworkAddress;
	}
	public Identifier getSendingApplicationIdentifier() {
		return this.sendingApplicationIdentifier;
	}
	public void setSendingApplicationIdentifier(Identifier sendingApplicationIdentifier) {
		this.sendingApplicationIdentifier = sendingApplicationIdentifier;
	}
	public String getSendingApplicationName() {
		return this.sendingApplicationName;
	}
	public void setSendingApplicationName(String sendingApplicationName) {
		this.sendingApplicationName = sendingApplicationName;
	}
	public String getSendingApplicationConfigurationInformation() {
		return this.sendingApplicationConfigurationInformation;
	}
	public void setSendingApplicationConfigurationInformation(
			String sendingApplicationConfigurationInformation) {
		this.sendingApplicationConfigurationInformation = sendingApplicationConfigurationInformation;
	}
	public Interval<Date> getSendingApplicationVersionDate() {
		return this.sendingApplicationVersionDate;
	}
	public void setSendingApplicationVersionDate(Interval<Date> sendingApplicationVersionDate) {
		this.sendingApplicationVersionDate = sendingApplicationVersionDate;
	}
	public String getSendingSoftwareVersionNumber() {
		return this.sendingSoftwareVersionNumber;
	}
	public void setSendingSoftwareVersionNumber(String sendingSoftwareVersionNumber) {
		this.sendingSoftwareVersionNumber = sendingSoftwareVersionNumber;
	}
	public String getSendingApplicationSoftwareName() {
		return this.sendingApplicationSoftwareName;
	}
	public void setSendingApplicationSoftwareName(String sendingApplicationSoftwareName) {
		this.sendingApplicationSoftwareName = sendingApplicationSoftwareName;
	}
	public Identifier getSendingOrganizationIdentifier() {
		return this.sendingOrganizationIdentifier;
	}
	public void setSendingOrganizationIdentifier(Identifier sendingOrganizationIdentifier) {
		this.sendingOrganizationIdentifier = sendingOrganizationIdentifier;
	}
	
	
}
