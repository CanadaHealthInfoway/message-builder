package ca.infoway.messagebuilder.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.rename Hl7ChoiceAttribute
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface Hl7Choice {
	public String[] value();
}
