package ca.infoway.messagebuilder.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

/**
 * @sharpen.rename Hl7XmlMappingAttribute 
 */
@Retention(RUNTIME)
public @interface Hl7XmlMapping {
	String[] value();
}
