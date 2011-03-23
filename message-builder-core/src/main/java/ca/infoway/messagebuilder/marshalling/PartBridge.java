package ca.infoway.messagebuilder.marshalling;

import java.util.List;

/**
 * <p>A part bridge maps between a Message Part and the Java class that represents it.
 * In the most simple case, one part maps to one Java class, but in some cases (such
 * as with inlining) the part really maps to a subset of properties on the class in
 * which it was inlined.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
interface PartBridge {
	public String getTypeName();
	public List<BaseRelationshipBridge> getRelationshipBridges();
	public boolean isEmpty();
	/**
	 * <p>Indicates whether or not the part has been "collapsed" or "inlined" into 
	 * another part type.  
	 * 
	 * @return true if the part maps to a number of bean properties in a message bean, 
	 * rather than a bean, itself.  Otherwise, it returns false.
	 */
	public boolean isCollapsed();
	public String getPropertyName();
}
