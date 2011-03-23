package ca.infoway.messagebuilder.marshalling.hl7;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class MessageTypeKey {
	
	private final String version;
	private final String messageId;

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