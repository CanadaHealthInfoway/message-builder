package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.xml.TypeName;

/**
 * <p>A name coordinator has the responsiblity for finding the appropriate name for a
 * given TypeName
 * 
 * @author administrator
 */
public interface NameCoordinator {
	public String getName(TypeName name);
}
