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

package ca.infoway.messagebuilder.marshalling.newfoundland.cerx.v01r04_3;

import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.UPDATE_ADVERSE_REACTION_REQUEST;
import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.UPDATE_ADVERSE_REACTION_REQUEST_ACCEPTED;
import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.UPDATE_ADVERSE_REACTION_REQUEST_REFUSED;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.adversereaction.AdverseReactionBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.adversereaction.UpdateAdverseReactionAcceptedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.adversereaction.UpdateAdverseReactionMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.adversereaction.UpdateAdverseReactionRefusedMessageBean;

public class UpdateAdverseReactionTransformationTest extends BaseAdverseReactionTransformationTest {
	
	private static final String REQUEST_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/updateAdverseReactionRequest.xml";
	private static final String ACCEPTED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/updateAdverseReactionRequestAccepted.xml";
	private static final String REFUSED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/updateAdverseReactionRequestRefused.xml";
	
	@Override
	public String getAcceptedMessageFile() {
		return ACCEPTED_MESSAGE_FILE;
	}
	@Override
	public String getRefusedMessageFile() {
		return REFUSED_MESSAGE_FILE;
	}
	@Override
	public String getRequestMessageFile() {
		return REQUEST_MESSAGE_FILE;
	}
	@Override
	protected RecordResponseMessageBean<ActEventBean> createAcceptedBean() {
		return new UpdateAdverseReactionAcceptedMessageBean();
	}
	@Override
	protected RecordResponseMessageBean<ActEventBean> createRefusedBean() {
		UpdateAdverseReactionRefusedMessageBean refusedBean = new UpdateAdverseReactionRefusedMessageBean();
		refusedBean.getControlActEvent().setRecordBean(new RecordBean<ActEventBean>());
		refusedBean.getControlActEvent().getRecordBean().setRecord(new ActEventBeanBuilder().populate().create());
		return refusedBean;		
	}
	@Override
	protected RecordRequestMessageBean<AdverseReactionBean> createRequestBean() {
		return new UpdateAdverseReactionMessageBean();
	}
	@Override
	protected HL7TriggerEventCode getAcceptedHL7TriggerEventCode() {
		return UPDATE_ADVERSE_REACTION_REQUEST_ACCEPTED;
	}
	@Override
	protected HL7TriggerEventCode getRefusedHL7TriggerEventCode() {
		return UPDATE_ADVERSE_REACTION_REQUEST_REFUSED;	
	}
	@Override
	protected HL7TriggerEventCode getRequestHL7TriggerEventCode() {
		return UPDATE_ADVERSE_REACTION_REQUEST;
	}
}
