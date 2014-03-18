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
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.ProcessingID;
import ca.infoway.messagebuilder.domainvalue.ProcessingMode;
import ca.infoway.messagebuilder.domainvalue.ResponseMode;

public class ValueHolder {

	private Identifier id;
    private Date creationTime;
    private String securityText;
    private ResponseMode responseModeCode;
    private List<Identifier> profileId = Collections.synchronizedList(new ArrayList<Identifier>());
    private ProcessingID processingCode;
    private ProcessingMode processingModeCode;
	private AcknowledgementCondition acceptAckCode;
    private ReceiverValueHolder receiver = new ReceiverValueHolder();
    private SenderValueHolder sender = new SenderValueHolder();
	private ToBeRespondedToByValueHolder respondTo = new ToBeRespondedToByValueHolder();  
    private List<RoutingInstructionLinesValueHolder> attentionLine = new ArrayList<RoutingInstructionLinesValueHolder>();

	public Identifier getId() {
        return this.id;
    }
    public void setId(Identifier messageIdentifier) {
        this.id = messageIdentifier;
    }

    public Date getCreationTime() {
        return this.creationTime;
    }
    public void setCreationTime(Date messageTimestamp) {
        this.creationTime = messageTimestamp;
    }

    public String getSecurityText() {
        return this.securityText;
    }
    public void setSecurityText(String securityToken) {
        this.securityText = securityToken;
    }

    public ResponseMode getResponseModeCode() {
        return this.responseModeCode;
    }
    public void setResponseModeCode(ResponseMode responseType) {
        this.responseModeCode = responseType;
    }

    public List<Identifier> getProfileId() {
        return this.profileId;
    }

    public ProcessingID getProcessingCode() {
        return this.processingCode;
    }
    public void setProcessingCode(ProcessingID processingCode) {
        this.processingCode = processingCode;
    }

    public ProcessingMode getProcessingModeCode() {
		return this.processingModeCode;
	}
	public void setProcessingModeCode(ProcessingMode processingMode) {
		this.processingModeCode = processingMode;
	}

	public AcknowledgementCondition getAcceptAckCode() {
        return this.acceptAckCode;
    }
    public void setAcceptAckCode(AcknowledgementCondition desiredAcknowledgmentType) {
        this.acceptAckCode = desiredAcknowledgmentType;
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
	
	// FIXME - TM (see RM19207) - this currently does not work due to the nature of MessageBeanFactory handling collections
    public List<RoutingInstructionLinesValueHolder> getAttentionLine() {
		return attentionLine;
	}
	public void setAttentionLine(List<RoutingInstructionLinesValueHolder> attentionLine) {
		this.attentionLine = attentionLine;
	}
	
}
