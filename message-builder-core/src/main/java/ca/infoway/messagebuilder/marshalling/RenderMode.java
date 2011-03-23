package ca.infoway.messagebuilder.marshalling;

/**
 * <p>A render mode to indicate how the marshaller should handle 
 * incoming messages that don't satisfy the rules of rendering.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 */
public enum RenderMode {
	
	// if adding interfaces or behaviour to this enum, please consider using enum pattern for translation purposes

	/**
	 * <p>The permissive rendering mode.  Invalidly-populated input will produce warnings.
	 */
	PERMISSIVE,
	
	/**
	 * <p>The strict rendering mode.  Invalidly-populated input will produce an exception.
	 */
	STRICT;

}
