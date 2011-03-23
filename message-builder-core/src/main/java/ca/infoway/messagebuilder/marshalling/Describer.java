package ca.infoway.messagebuilder.marshalling;

import org.apache.commons.lang.ClassUtils;

import ca.infoway.messagebuilder.j5goodies.BeanProperty;
import ca.infoway.messagebuilder.xml.Relationship;

class Describer {

	static String describe(MessagePartHolder messagePart, Relationship relationship) {
		return describe(messagePart.getName(), relationship);
	}

	static String describe(Class<?> tealClass, BeanProperty property) {
		return describe(tealClass, property.getName());
	}
	
	static String describe(Class<?> tealClass, String name) {
		return ClassUtils.getShortClassName(tealClass) + "." + name;
	}
	
	static String describe(String messagePartName, Relationship relationship) {
		return relationship.getName() + " of type " + messagePartName;
	}

}
