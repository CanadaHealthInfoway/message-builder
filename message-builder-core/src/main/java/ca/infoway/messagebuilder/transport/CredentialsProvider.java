package ca.infoway.messagebuilder.transport;

/**
 * <p>Allows implementors to provide credentials.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * sharpen.ignore - transport - TBD!
 */
public interface CredentialsProvider {
	
	/**
	 * <p>Obtain the credentials.
	 * 
	 * @return the current credentials
	 */
	public Credentials getCredentials();
	
}
