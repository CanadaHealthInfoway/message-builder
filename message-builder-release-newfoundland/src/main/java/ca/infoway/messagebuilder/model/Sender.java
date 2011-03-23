package ca.infoway.messagebuilder.model;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7BusinessName;
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

@Hl7PartTypeMapping({"MCCI_MT002100CA.Sender", "MCCI_MT002300CA.Sender", "MCCI_MT000100CA.Sender", "MCCI_MT102001CA.Sender", "MCCI_MT000300CA.Sender"})
public class Sender extends MessagePartBean implements Serializable {

	private static final long serialVersionUID = 6418261934692624819L;

	@Hl7BusinessName("sendingNetworkAddress")
	private TEL telecommunicationAddress = new TELImpl();
	@Hl7BusinessName("sendingApplicationIdentifier")
	private II deviceId = new IIImpl();
	@Hl7BusinessName("sendingApplicationName")
	private ST deviceName = new STImpl();
	@Hl7BusinessName("sendingApplicationSoftwareName")
	private ST softwareName = new STImpl();
	@Hl7BusinessName("sendingSoftwareVersionNumber")
	private ST manufacturerModelNumber = new STImpl();
	@Hl7BusinessName("sendingOrganizationIdentifier")
	private II sendingOrganizationIdentifier = new IIImpl();
	
	@Hl7XmlMapping("device/id")
	public Identifier getDeviceId() {
		return this.deviceId.getValue();
	}
	public void setDeviceId(Identifier deviceId) {
		this.deviceId.setValue(deviceId);
	}
	@Hl7XmlMapping("device/name")
	public String getDeviceName() {
		return this.deviceName.getValue();
	}
	public void setDeviceName(String deviceName) {
		this.deviceName.setValue(deviceName);
	}
	@Hl7XmlMapping("device/softwareName")
	public String getSoftwareName() {
		return this.softwareName.getValue();
	}
	public void setSoftwareName(String softwareName) {
		this.softwareName.setValue(softwareName);
	}
	@Hl7XmlMapping("device/manufacturerModelName")
	public String getManufacturerModelNumber() {
		return this.manufacturerModelNumber.getValue();
	}
	public void setManufacturerModelNumber(String manufacturerModelNumber) {
		this.manufacturerModelNumber.setValue(manufacturerModelNumber);
	}
	@Hl7XmlMapping("telecom")
	public TelecommunicationAddress getTelecommunicationAddress() {
		return this.telecommunicationAddress.getValue();
	}
	public void setTelecommunicationAddress(TelecommunicationAddress telecommunicationsAddress) {
		this.telecommunicationAddress.setValue(telecommunicationsAddress);
	}
	@Hl7XmlMapping("device/agent/agentOrganization/id")
	public Identifier getSendingOrganizationIdentifier() {
		return this.sendingOrganizationIdentifier.getValue();
	}
	public void setSendingOrganizationIdentifier(Identifier sendingOrganizationIdentifier) {
		this.sendingOrganizationIdentifier.setValue(sendingOrganizationIdentifier);
	}
}
