package ca.infoway.messagebuilder.transport;

import org.w3c.dom.Document;

/**
 * <p>A message that can be sent across a transport layer.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * sharpen.ignore - transport - TBD!
 */
public interface RequestMessage {
	
	/**
	 * <p>Obtains the message as a string, converting the underlying structure if necessary (i.e. DOM -> string). 
	 * 
	 * @return the underlying message rendered as a string
	 * @throws TransportLayerException if a string representation of the message could not be constructed
	 */
	public String getMessageAsString() throws TransportLayerException;
	
	/**
	 * <p>Obtains the message's interaction id. 
	 * 
	 * @return the message's interaction id
	 * @throws TransportLayerException if the message's interaction id could not be determined
	 */
	public String getInteractionId() throws TransportLayerException;
	
	/**
	 * <p>Obtains the message as a DOM, converting the underlying structure if necessary (i.e. string -> DOM). 
	 * 
	 * @return the underlying message in a DOM structure
	 * @throws TransportLayerException if there were problems creating the DOM
	 */
	public Document getMessageAsDocument() throws TransportLayerException;

}
