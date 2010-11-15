package ca.infoway.messagebuilder.xml;

/**
 * <p>An interface describing types that have documentation.  MIFs often contain 
 * additional documentation that describe the purpose or meaning of types.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public interface Documentable {

	/**
	 * <p>Get the documentation.
	 * @return the documentation.
	 */
	public Documentation getDocumentation();
	/**
	 * <p>Set the documentation.
	 * @param documentation - the new documentation value
	 */
	public void setDocumentation(Documentation documentation);
	
}
