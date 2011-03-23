package ca.infoway.messagebuilder.xml;

/**
 * <p>A tool that can locate message parts.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public interface MessagePartResolver {
	/**
	 * <p>Find a message part by name.
	 * 
	 * @param type - the name of message type to retrieve.
	 * @return - the message part
	 */
	public MessagePart getMessagePart(String type);	
	/**
	 * <p>Find the root type of a package location.
	 * @param packageLocationName - the name of the package location.
	 * @return - the root type of the package location.
	 */
	public String getPackageLocationRootType(String packageLocationName);
}
