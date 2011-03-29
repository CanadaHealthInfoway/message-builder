package ca.infoway.messagebuilder.transport.mohawk;

import java.io.IOException;

import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;

/**
 * <p>An interface for a transport layer to make use of a transport mechanism, such as HttpClient. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - transport - TBD!
 */
public interface Client {
	
	/**
	 * <p>Obtains the http state of the underlying client. 
	 * 
	 * @return the http state of the underlying client
	 */
	public HttpState getState();
	
	/**
	 * 
	 * <p>Obtains the current http parameters.
	 * 
	 * @return http parameters
	 */
	public HttpClientParams getParams();
	
	/**
	 * <p>Fires the given post method.
	 * 
	 * @param method the type of method to execute
	 * @return the http status code
	 * @throws IOException if there were any problems during the execution of the method 
	 */
	public int executeMethod(PostMethod method) throws IOException;
}
