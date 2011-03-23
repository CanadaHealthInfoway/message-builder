package ca.infoway.messagebuilder.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

/**
 * @sharpen.rename Hl7PartTypeMappingAttribute
 */
@Retention(RUNTIME)
public @interface Hl7PartTypeMapping {
	String[] value();

}
