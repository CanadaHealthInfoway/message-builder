package ca.infoway.messagebuilder.transport;

/**
 * <p>A transport mechanism for sending requests (as requestMessages) and receiving responses (as strings).
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * sharpen.ignore - transport - TBD!
 */
public interface TransportLayer {
	
	/**
	 * <p>Sends a RequestMessage using the provided credentials and returns a response message as a string. 
	 * 
	 * @param credentialsProvider a way to obtain credentials
	 * @param requestMessage the message to be sent across the transport layer
	 * @return the response message as a string
	 * @throws TransportLayerException if any problems occurred during send or receive of the message
	 */
	public String sendRequestAndGetResponse(CredentialsProvider credentialsProvider, RequestMessage requestMessage) throws TransportLayerException;
	
}
