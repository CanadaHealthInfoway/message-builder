/**
 * Copyright 2013 Canada Health Infoway, Inc.
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.ProcessingID;
import ca.infoway.messagebuilder.domainvalue.ProcessingMode;
import ca.infoway.messagebuilder.domainvalue.ResponseMode;
import ca.infoway.messagebuilder.domainvalue.basic.URLScheme;

public class DefaultValueHolder extends ValueHolder {

	@Override
	public Identifier getId() {
		return new Identifier(UUID.randomUUID().toString(), null);
	}

	@Override
	public Date getCreationTime() {
		return new Date();
	}
	
	@Override
	public String getSecurityText() {
		return "SecurityToken";
	}
	
	@Override
	public ResponseMode getResponseModeCode() {
		return ca.infoway.messagebuilder.domainvalue.transport.ResponseMode.IMMEDIATE;
	}
	
	@Override
	public List<Identifier> getProfileId() {
		List<Identifier> conformanceProfileIdentifiers = super.getProfileId();
		conformanceProfileIdentifiers.clear();
		conformanceProfileIdentifiers.add(new Identifier("1.1.1", "ext1"));
		return conformanceProfileIdentifiers;
	}
	
	@Override
	public ProcessingID getProcessingCode() {
		return ca.infoway.messagebuilder.domainvalue.transport.ProcessingID.PRODUCTION;
	}

	@Override
	public ProcessingMode getProcessingModeCode() {
		return ca.infoway.messagebuilder.domainvalue.transport.ProcessingMode.CURRENT_PROCESSING;
	}
	
	@Override
	public AcknowledgementCondition getAcceptAckCode() {
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
	
	@Override
	public ToBeRespondedToByValueHolder getRespondTo() {
		return populateRespondTo();
	}
	
	@Override
	public List<RoutingInstructionLinesValueHolder> getAttentionLine() {
		RoutingInstructionLinesValueHolder bean = new RoutingInstructionLinesValueHolder();
		bean.setKeyWordText("routing type");
		bean.setValue("routing name");
		
		RoutingInstructionLinesValueHolder bean2 = new RoutingInstructionLinesValueHolder();
		bean2.setKeyWordText("another routing type");
		bean2.setValue("another routing name");
		
		List<RoutingInstructionLinesValueHolder> result = new ArrayList<RoutingInstructionLinesValueHolder>();
		result.add(bean);
		result.add(bean2);
		return result;
	}

	private ReceiverValueHolder populateReceiver() {
		ReceiverValueHolder receiver = new ReceiverValueHolder();
		receiver.setDeviceName("Receiver Application Name");
		receiver.setTelecom(new TelecommunicationAddress(URLScheme.HTTP, "192.168.2.1"));
		receiver.setDeviceAgentAgentOrganizationId(new Identifier("1.1.2", "ext2"));
		receiver.setDeviceId(new Identifier("1.1.3", "ext3"));
		return receiver;
	}

	private SenderValueHolder populateSender() {
		SenderValueHolder sender = new SenderValueHolder();
		sender.setTelecom(new TelecommunicationAddress(URLScheme.HTTP, "192.168.2.2"));
		sender.setDeviceId(new Identifier("1.1.4", "ext4"));
		sender.setDeviceManufacturerModelName("1.0");
		sender.setDeviceSoftwareName("MBT Pharmacy");
		sender.setDeviceDesc("Configuration information");
		sender.setDeviceName("Sending Application Name");
		sender.setDeviceExistenceTime(IntervalFactory.<Date>createLow(new Date()));
		sender.setDeviceAgentAgentOrganizationId(new Identifier("1.1.5", "ext5"));
		return sender;
	}
	
	private ToBeRespondedToByValueHolder populateRespondTo() {
		ToBeRespondedToByValueHolder bean = new ToBeRespondedToByValueHolder();
		bean.setDeviceId(new Identifier("1.1.6", "ext6"));
		bean.setTelecom(new TelecommunicationAddress(URLScheme.HTTP, "192.168.2.3"));
		return bean;
	}

}
