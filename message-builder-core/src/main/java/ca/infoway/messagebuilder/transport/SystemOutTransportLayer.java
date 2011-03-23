package ca.infoway.messagebuilder.transport;

/**
 * <p>A null implementation of a transport layer which doesn't send or receive a message.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * sharpen.ignore - transport - TBD!
 */
public class SystemOutTransportLayer implements TransportLayer {

	/**
	 * <p>Doesn't send a message. Provides an empty string for the response.
	 * 
	 * @param credentialsProvider a way to obtain credentials
	 * @param requestMessage the message to be sent across the transport layer
	 * @return the response message as a string
	 */
	public String sendRequestAndGetResponse(CredentialsProvider credentialsProvider, RequestMessage requestMessage) {
		return "";
	}

}
