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

package ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DeviceRequestBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DeviceRequestBeanBuilder;

public class ActivateDevicePrescriptionRequestMessageBeanBuilder extends BaseBeanBuilder<ActivateDevicePrescriptionRequestMessageBean> {

	public ActivateDevicePrescriptionRequestMessageBeanBuilder() {
		super(new ActivateDevicePrescriptionRequestMessageBean());
	}

	public ActivateDevicePrescriptionRequestMessageBeanBuilder populate() {
		this.bean.getControlActEvent().setCode(HL7TriggerEventCode.ACTIVATE_DEVICE_PRESCRIPTION_REQUEST);
		MessageBeanBuilderSupport.populateStandardValuesV02(this.bean.getMessageAttributes());
		this.bean.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(this.bean.getControlActEvent());
		
		RecordBean<DeviceRequestBean> recordBean = new RecordBean<DeviceRequestBean>();
		recordBean.setRecord(new DeviceRequestBeanBuilder().populate().create());
		this.bean.getControlActEvent().setRecordBean(recordBean);
		
		return this;
	}
}
