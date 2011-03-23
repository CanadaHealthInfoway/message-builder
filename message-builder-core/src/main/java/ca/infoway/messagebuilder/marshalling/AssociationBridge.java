package ca.infoway.messagebuilder.marshalling;

import java.util.Collection;

interface AssociationBridge extends BaseRelationshipBridge {
	/**
	 * If the underlying value is a collection, return each collection that 
	 * contains one value for each element.  If the underlying value is 
	 * not a collection, return a collection with zero or one element, depending
	 * on whether or not the value is null. 
	 * @return
	 */
	public Collection<PartBridge> getAssociationValues();
	
}
