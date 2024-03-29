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

import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.ADD_ALLERGY_INTOLERANCE_REQUEST;
import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.ADD_ALLERGY_INTOLERANCE_REQUEST_ACCEPTED;
import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.ADD_ALLERGY_INTOLERANCE_REQUEST_REFUSED;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.ResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.allergy.AddAllergyIntoleranceAcceptedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.allergy.AddAllergyIntoleranceMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.allergy.AddAllergyIntoleranceRefusedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.allergy.AllergyIntoleranceBean;

public class AddAllergyIntoleranceTransformationTest extends BaseAllergyIntoleranceTransformationTest {
	
	private static final String REQUEST_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/addAllergyIntoleranceRequest.xml";
	private static final String ACCEPTED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/addAllergyIntoleranceRequestAccepted.xml";
	private static final String REFUSED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/addAllergyIntoleranceRequestRefused.xml";
	
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
		return new AddAllergyIntoleranceAcceptedMessageBean();
	}
	@Override
	protected ResponseMessageBean createRefusedBean() {
		return new AddAllergyIntoleranceRefusedMessageBean();
	}
	@Override
	protected RecordRequestMessageBean<AllergyIntoleranceBean> createRequestBean() {
		return new AddAllergyIntoleranceMessageBean();
	}
	@Override
	protected HL7TriggerEventCode getAcceptedHL7TriggerEventCode() {
		return ADD_ALLERGY_INTOLERANCE_REQUEST_ACCEPTED;
	}
	@Override
	protected HL7TriggerEventCode getRefusedHL7TriggerEventCode() {
		return ADD_ALLERGY_INTOLERANCE_REQUEST_REFUSED;	
	}
	@Override
	protected HL7TriggerEventCode getRequestHL7TriggerEventCode() {
		return ADD_ALLERGY_INTOLERANCE_REQUEST;
	}
}
