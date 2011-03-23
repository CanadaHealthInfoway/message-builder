package ca.infoway.messagebuilder.transport;

/**
 * <p>A basic implementation of a CredentialsProvider. Holds credentials, and nothing more.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * sharpen.ignore - transport - TBD!
 */
public class TrivialCredentialsProvider implements CredentialsProvider {

	private final Credentials credentials;

	/**
	 * <p>Constructs a TrivialCredentialsProvider based on the provided Credentials.
	 * 
	 * @param credentials the credentials to provide
	 */
	public TrivialCredentialsProvider(Credentials credentials) {
		this.credentials = credentials;
	}

	/**
	 * <p>Obtain the credentials.
	 * 
	 * @return the current credentials
	 */
	public Credentials getCredentials() {
		return this.credentials;
	}
}
