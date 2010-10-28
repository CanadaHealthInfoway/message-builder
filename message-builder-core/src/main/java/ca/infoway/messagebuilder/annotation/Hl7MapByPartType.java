package ca.infoway.messagebuilder.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

/**
 * <p>This annotation is used to help determine which names map to which 
 * part types, when we're in a class that appears to have "overloaded" names.
 * 
 * <p>For example, we might have a single class, mapped to two different 
 * part types.  Each of those part types might have a distinct mapping for 
 * "subjectOf1", but which are not compatible.  In the past, the 
 * message builder tool has not been able to support that case.  Using this
 * new annotation -- and assuming that we know the required part type --  we 
 * should be able to look at the annotation to determine which mapping is the 
 * right one to consult.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Retention(RUNTIME)
public @interface Hl7MapByPartType {
	String name();
	String type();
}
