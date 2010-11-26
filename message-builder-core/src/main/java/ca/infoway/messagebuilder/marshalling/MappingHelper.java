package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.j5goodies.BeanProperty;

/**
 * @sharpen.ignore
 * 
 * The Hl7MapByPartTypes annotation only exists in Java
 * 
 */

final class MappingHelper {
	
	static final Hl7MapByPartType[] EMPTY = new Hl7MapByPartType[0];  

	static Hl7MapByPartType[] getAllHl7MapByPartType(BeanProperty property) {
		Hl7MapByPartTypes exceptions = property.getAnnotation(Hl7MapByPartTypes.class);
		return exceptions == null ? EMPTY : exceptions.value();
	}
	
}
