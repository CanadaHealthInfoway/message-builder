package ca.infoway.messagebuilder.generator;

/**
 * <p>When we generate model classes from the message sets, we can use one of three
 * policies toward naming:
 * 
 * <ol>
 * <li>Standard names -- relationships and classes use the names as they appear in the 
 * MIF "name" attributes.  Thus, an attribute called "id" will be generated as a class
 * property called "id".
 * <li>Business names -- when business names exist, we will favour the business name.  
 * Otherwise, we'll fall back to the standard name.
 * <li>Mixed -- We will use a business name policy when we're dealing with class/type 
 * names, and use the standard names when we're dealing with relationships/properties.
 * </ol>
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public enum NamingPolicy {
	
	STANDARD_NAMES, BUSINESS_NAMES, MIXED_NAMES;

	public static NamingPolicy getDefaultPolicy() {
		return BUSINESS_NAMES;
	}
}
