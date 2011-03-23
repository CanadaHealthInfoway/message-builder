package ca.infoway.messagebuilder.transport;

/**
 * 
 * <p>An exception for http problems encountered within the transport layers. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * sharpen.ignore - transport - TBD!
 */
public class HttpTransportLayerException extends TransportLayerException {

	private static final long serialVersionUID = 4806719016466005503L;
	
	/**
	 * <p>Constructs an http transport layer exception based on the http status code.
	 * 
	 * @param statusCode the statusCode of the http error
	 */
	public HttpTransportLayerException(int statusCode) {
		super("Invalid HTTP status code received from server " + statusCode);
	}

}
