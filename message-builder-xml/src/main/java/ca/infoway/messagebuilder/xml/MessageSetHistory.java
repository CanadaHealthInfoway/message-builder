/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy: gng $
 * Last modified: $LastChangedDate: 2012-06-20 11:22:14 -0500 (Wed, 20 June 2012) $
 * Revision:      $LastChangedRevision: 3230 $
 */

package ca.infoway.messagebuilder.xml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root
public class MessageSetHistory {
	@Attribute
	private HistoryType type;
	@Attribute
	private String value;
	@Attribute
	private Integer order;
	
	public static enum HistoryType {
		DELTA_SET,
		MESSAGE_SET
	}
	
	public MessageSetHistory() {}
	
	public MessageSetHistory(HistoryType type, String value, Integer order) {
		this.value = value;
		this.type = type;
		this.order = order;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public HistoryType getType() {
		return type;
	}
	public void setType(HistoryType type) {
		this.type = type;
	}

	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
}
