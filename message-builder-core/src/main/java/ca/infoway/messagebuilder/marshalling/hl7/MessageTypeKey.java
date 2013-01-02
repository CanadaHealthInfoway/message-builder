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

package ca.infoway.messagebuilder.marshalling.hl7;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.VersionNumber;

public class MessageTypeKey {
	
	private final String version;
	private final String messageId;

	public MessageTypeKey(VersionNumber version, String messageId) {
		this(version.getVersionLiteral(), messageId);
	}
	
	public MessageTypeKey(String version, String messageId) {
		this.version = version;
		this.messageId = messageId;
	}
	
	public String getVersion() {
		return this.version;
	}
	
	public String getMessageId() {
		return this.messageId;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.version).append(
				this.messageId).toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (getClass() != obj.getClass()) {
			return false;
		} else {
			MessageTypeKey that = (MessageTypeKey) obj;
			return new EqualsBuilder()
					.append(this.version, that.version)
					.append(this.messageId, that.messageId)
					.isEquals();
		}
	}
	@Override
	public String toString() {
		return "[MessageType=" + this.messageId + ",version=" + this.version + "]";
	}
	
}