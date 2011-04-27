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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.ProcessingID;
import ca.infoway.messagebuilder.domainvalue.ProcessingMode;
import ca.infoway.messagebuilder.domainvalue.ResponseMode;

public class ValueHolder {

	private Identifier messageIdentifier;
    private Date messageTimestamp;
    private String securityToken;
    private ResponseMode responseType;
    private List<Identifier> conformanceProfileIdentifiers = Collections.synchronizedList(new ArrayList<Identifier>());
    private ProcessingID processingCode;
    private ProcessingMode processingMode;
	private AcknowledgementCondition desiredAcknowledgmentType;
    private ReceiverValueHolder receiver = new ReceiverValueHolder();
    private SenderValueHolder sender = new SenderValueHolder();
	private ToBeRespondedToByValueHolder respondTo = new ToBeRespondedToByValueHolder();  
    private List<RoutingInstructionLinesValueHolder> attentionLine = new ArrayList<RoutingInstructionLinesValueHolder>();

	public Identifier getMessageIdentifier() {
        return this.messageIdentifier;
    }
    public void setMessageIdentifier(Identifier messageIdentifier) {
        this.messageIdentifier = messageIdentifier;
    }

    public Date getMessageTimestamp() {
        return this.messageTimestamp;
    }
    public void setMessageTimestamp(Date messageTimestamp) {
        this.messageTimestamp = messageTimestamp;
    }

    public String getSecurityToken() {
        return this.securityToken;
    }
    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public ResponseMode getResponseType() {
        return this.responseType;
    }
    public void setResponseType(ResponseMode responseType) {
        this.responseType = responseType;
    }

    public List<Identifier> getConformanceProfileIdentifiers() {
        return this.conformanceProfileIdentifiers;
    }

    public ProcessingID getProcessingCode() {
        return this.processingCode;
    }
    public void setProcessingCode(ProcessingID processingCode) {
        this.processingCode = processingCode;
    }

    public ProcessingMode getProcessingMode() {
		return this.processingMode;
	}
	public void setProcessingMode(ProcessingMode processingMode) {
		this.processingMode = processingMode;
	}

	public AcknowledgementCondition getDesiredAcknowledgmentType() {
        return this.desiredAcknowledgmentType;
    }
    public void setDesiredAcknowledgmentType(AcknowledgementCondition desiredAcknowledgmentType) {
        this.desiredAcknowledgmentType = desiredAcknowledgmentType;
    }

    public ReceiverValueHolder getReceiver() {
        return this.receiver;
    }
    public void setReceiver(ReceiverValueHolder receiver) {
        this.receiver = receiver;
    }

    public SenderValueHolder getSender() {
        return this.sender;
    }
    public void setSender(SenderValueHolder sender) {
        this.sender = sender;
    }
    
    public ToBeRespondedToByValueHolder getRespondTo() {
		return respondTo;
	}
	public void setRespondTo(ToBeRespondedToByValueHolder respondTo) {
		this.respondTo = respondTo;
	}
	
	// FIXME - TM - this currently does not work due to the nature of MessageBeanFactory handling collections
    public List<RoutingInstructionLinesValueHolder> getAttentionLine() {
		return attentionLine;
	}
	public void setAttentionLine(List<RoutingInstructionLinesValueHolder> attentionLine) {
		this.attentionLine = attentionLine;
	}
	
}
