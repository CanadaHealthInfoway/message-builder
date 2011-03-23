package ca.infoway.messagebuilder.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * <p>A temporary annotation until we are fully auto-generating classes.
 * 
 * @sharpen.rename Hl7BusinessNameAttribute
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface Hl7BusinessName {
	public String value() default "";
}
