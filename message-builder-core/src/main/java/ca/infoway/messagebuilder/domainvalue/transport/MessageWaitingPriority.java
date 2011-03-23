package ca.infoway.messagebuilder.domainvalue.transport;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * MessageWaitingPriority.
 * 
 * Indicates that the receiver has messages for the sender
 * 
 * From:
 * 
 * http://www.hl7.org/v3ballot/html/infrastructure/vocabulary/MessageWaitingPriority.htm
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 */
public class MessageWaitingPriority extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.MessageWaitingPriority {

	private static final long serialVersionUID = -9181499971666284366L;
	
	/**
	 * High priority messages are available.
	 */
	public static final MessageWaitingPriority HIGH = new MessageWaitingPriority("HIGH", "H");
	/**
	 * Low priority messages are available.
	 */
	public static final MessageWaitingPriority LOW = new MessageWaitingPriority("LOW", "L");
	/**
	 * Medium priority messages are available.
	 */
	public static final MessageWaitingPriority MEDIUM = new MessageWaitingPriority("MEDIUM", "M");
	
	private final String code;

	private MessageWaitingPriority(String name, String code) {
		super(name);
		this.code = code;
	}

	/**
	 * Returns the message waiting priority. 
	 * 
	 * @return the message waiting priority
	 */
	public String getMessageWaitingPriority() {
		return this.code;
	}

	/**
	 * Returns the message waiting priority code system.
	 * 
	 * @return the message waiting priority code system
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_MESSAGE_WAITING_PRIORITY.getRoot();
	}

	/**
	 * Returns the code value.
	 * 
	 * @return the code value
	 */
	public String getCodeValue() {
		return this.code;
	}
	
}
