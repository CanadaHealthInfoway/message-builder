package ca.infoway.messagebuilder.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

/**
 * Unlike csharp, Java does not support the usage of duplicate annotations on the same element.
 * This annotation is necesary for our Java implementation but not our csharp
 * implementation. 
 * 
 * @sharpen.ignore
 */

@Retention(RUNTIME)
public @interface Hl7MapByPartTypes {
	Hl7MapByPartType[] value();
}
