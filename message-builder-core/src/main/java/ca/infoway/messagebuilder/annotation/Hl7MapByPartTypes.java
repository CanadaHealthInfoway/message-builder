package ca.infoway.messagebuilder.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

@Retention(RUNTIME)
public @interface Hl7MapByPartTypes {
	Hl7MapByPartType[] value();
}
