package ca.infoway.messagebuilder.transport;

/**
 * <p> A simple credentials implementation. Stores username and password.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * sharpen.ignore - transport - TBD!
 */
public class UsernamePasswordCredentials implements Credentials {

	private final String username;
	private final String password;

	/**
	 * <p>Constructs a usernamePassword credential with the given username and password.
	 * 
	 * @param username  the username/login id for the credentials  
	 * @param password  the plaintext password for the credentials
	 */
	public UsernamePasswordCredentials(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * <p>Obtains the username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * <p>Obtains the password.
	 * 
	 * @return the plaintext password
	 */
	public String getPassword() {
		return this.password;
	}
}
