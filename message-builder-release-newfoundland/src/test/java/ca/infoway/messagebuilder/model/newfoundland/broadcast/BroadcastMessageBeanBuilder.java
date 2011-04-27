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

package ca.infoway.messagebuilder.model.newfoundland.broadcast;

import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.broadcast.BroadcastMessageBean;


public class BroadcastMessageBeanBuilder extends BaseBeanBuilder<BroadcastMessageBean> {
	
	public BroadcastMessageBeanBuilder() {
		super(new BroadcastMessageBean());
	}

	public BroadcastMessageBeanBuilder populate() {
		this.bean.setBroadcastSource("some broadcast source");
		this.bean.setBroadcastTopic(new BroadcastTopicBeanBuilder().populateAsNlMandatory().create());
		this.bean.setEffectiveTime(DateUtil.getDate(2015, 4, 22));
		this.bean.setText("Tires are being marked. Move your cars");
		this.bean.setTitle("Parking warning");
		return this;
	}

}
