package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.xml.Relationship;

/**
 * <p>An interface that represents the bridge that associates a bean property with
 * a particular HL7 attribute or association. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
interface BaseRelationshipBridge {
	public boolean isAssociation();
	public Relationship getRelationship();
	public boolean isEmpty();
	public String getPropertyName();
}
