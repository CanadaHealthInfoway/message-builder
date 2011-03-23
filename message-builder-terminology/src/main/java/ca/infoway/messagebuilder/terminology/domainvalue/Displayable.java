package ca.infoway.messagebuilder.terminology.domainvalue;

/**
 * <p>The Interface Displayable. Allows classes to provide display text for their contents.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public interface Displayable {

	/**
	 * <p>Gets the display text.
	 *
	 * @param language the language
	 * @return the display text
	 */
	public String getDisplayText(String language);
}
