package ca.infoway.messagebuilder.devtools;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.URLScheme;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.ProcessingID;
import ca.infoway.messagebuilder.domainvalue.ProcessingMode;
import ca.infoway.messagebuilder.domainvalue.ResponseMode;

public class DefaultValueHolder extends ValueHolder {

	@Override
	public Identifier getMessageIdentifier() {
		return new Identifier(UUID.randomUUID().toString(), null);
	}

	@Override
	public Date getMessageTimestamp() {
		return new Date();
	}
	
	@Override
	public String getSecurityToken() {
		return "SecurityToken";
	}
	
	@Override
	public ResponseMode getResponseType() {
		return ca.infoway.messagebuilder.domainvalue.transport.ResponseMode.IMMEDIATE;
	}
	
	@Override
	public List<Identifier> getConformanceProfileIdentifiers() {
		List<Identifier> conformanceProfileIdentifiers = super.getConformanceProfileIdentifiers();
		conformanceProfileIdentifiers.clear();
		conformanceProfileIdentifiers.add(new Identifier("1.1.1", "ext"));
		return conformanceProfileIdentifiers;
	}
	
	@Override
	public ProcessingID getProcessingCode() {
		return ca.infoway.messagebuilder.domainvalue.transport.ProcessingID.PRODUCTION;
	}

	@Override
	public ProcessingMode getProcessingMode() {
		return ca.infoway.messagebuilder.domainvalue.transport.ProcessingMode.CURRENT_PROCESSING;
	}
	
	@Override
	public AcknowledgementCondition getDesiredAcknowledgmentType() {
		return ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition.ALWAYS;
	}
	
	@Override
	public ReceiverValueHolder getReceiver() {
		return populateReceiver();
	}
	
	@Override
	public SenderValueHolder getSender() {
		return populateSender();
	}
	
	private ReceiverValueHolder populateReceiver() {
		ReceiverValueHolder receiver = new ReceiverValueHolder();
		receiver.setReceiverApplicationName("Receiver Application Name");
		receiver.setReceiverNetworkAddress(new TelecommunicationAddress(URLScheme.HTTP, "192.168.2.1"));
		receiver.setReceiverOrganizationIdentifier(new Identifier("1.1.1", "ext"));
		receiver.setReceiverApplicationIdentifier(new Identifier("1.1.1", "ext"));
		return receiver;
	}

	private SenderValueHolder populateSender() {
		SenderValueHolder sender = new SenderValueHolder();
		sender.setSendingNetworkAddress(new TelecommunicationAddress(URLScheme.HTTP, "192.168.2.1"));
		sender.setSendingApplicationIdentifier(new Identifier("1.1.1", "ext"));
		sender.setSendingSoftwareVersionNumber("1.0");
		sender.setSendingApplicationSoftwareName("MBT Pharmacy");
		sender.setSendingApplicationConfigurationInformation("Configuration information");
		sender.setSendingApplicationName("Sending Application name");
		sender.setSendingApplicationVersionDate(IntervalFactory.<Date>createLow(new Date()));
		sender.setSendingOrganizationIdentifier(new Identifier("1.1.1", "ext"));
		return sender;
	}
}
