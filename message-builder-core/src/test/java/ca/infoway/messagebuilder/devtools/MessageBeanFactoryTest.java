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

import junit.framework.Assert;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.lang.Identifier;

/**
 * @sharpen.ignore missing test
 */
public class MessageBeanFactoryTest {
	
	@Test
	public void shouldPopulateSubBeans() throws Exception {
		PatientDischargeCareSummariesQueryBean bean = new MessageBeanFactory(new DefaultValueHolder()).populate(new PatientDischargeCareSummariesQueryBean());
		Assert.assertNotNull(bean.getReceiver());
		Assert.assertEquals("security text", "SecurityToken", bean.getSecurityText());
		Assert.assertEquals("response mode", ca.infoway.messagebuilder.domainvalue.transport.ResponseMode.IMMEDIATE, bean.getResponseModeCode());
		Assert.assertEquals("profile id", new Identifier("1.1.1", "ext1"), bean.getProfileId().get(0));
		Assert.assertEquals("processing code", ca.infoway.messagebuilder.domainvalue.transport.ProcessingID.PRODUCTION, bean.getProcessingCode());
		Assert.assertEquals("processing mode code", ca.infoway.messagebuilder.domainvalue.transport.ProcessingMode.CURRENT_PROCESSING, bean.getProcessingModeCode());
		Assert.assertEquals("ack condition", ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition.ALWAYS, bean.getAcceptAckCode());
		Assert.assertEquals("sender name", "Sending Application Name", bean.getSender().getDeviceName());
		Assert.assertEquals("receiver name", "Receiver Application Name", bean.getReceiver().getDeviceName());
		Assert.assertEquals("attention lines", 2, bean.getAttentionLine().size());
		Assert.assertEquals("attention line 1a", "routing type", ((RoutingInstructionLinesBean) bean.getAttentionLine().get(0)).getKeyWordText());
		Assert.assertEquals("attention line 1b", "routing name", ((RoutingInstructionLinesBean) bean.getAttentionLine().get(0)).getValue());
		Assert.assertEquals("attention line 2a", "another routing type", ((RoutingInstructionLinesBean) bean.getAttentionLine().get(1)).getKeyWordText());
		Assert.assertEquals("attention line 2b", "another routing name", ((RoutingInstructionLinesBean) bean.getAttentionLine().get(1)).getValue());
		Assert.assertEquals("respondTo id", new Identifier("1.1.6", "ext6"), bean.getRespondTo().getDeviceId());
	}

}
