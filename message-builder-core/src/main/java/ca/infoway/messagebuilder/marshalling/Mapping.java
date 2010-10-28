package ca.infoway.messagebuilder.marshalling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.NamedAndTyped;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.j5goodies.BeanProperty;
import ca.infoway.messagebuilder.util.iterator.EmptyIterable;

class Mapping implements NamedAndTyped {

	private final String mapping;
	private final Hl7MapByPartTypes exceptions;
	
	Mapping(String mapping, Hl7MapByPartTypes exceptions) {
		this.mapping = mapping;
		this.exceptions = exceptions;
	}

	public boolean isCompound() {
		return this.mapping.contains("/");
	}

	public static List<Mapping> from(Hl7XmlMapping mapping) {
		return mapping == null ? Collections.<Mapping>emptyList() : from(Arrays.asList(mapping.value()), null);
	}
	static List<Mapping> from(List<String> mappings, Hl7MapByPartTypes exceptions) {
		List<Mapping> result = new ArrayList<Mapping>();
		for (String mapping : EmptyIterable.<String>nullSafeIterable(mappings)) {
			result.add(new Mapping(mapping, exceptions));
		}
		return result;
	}
	public static List<Mapping> from(BeanProperty property) {
		Hl7XmlMapping mapping = property.getAnnotation(Hl7XmlMapping.class);
		Hl7MapByPartTypes exceptions = property.getAnnotation(Hl7MapByPartTypes.class);
		return from(mapping, exceptions);
	}

	private static List<Mapping> from(Hl7XmlMapping mapping, Hl7MapByPartTypes exceptions) {
		return mapping == null ? Collections.<Mapping>emptyList() : from(Arrays.asList(mapping.value()), exceptions);
	}

	@Override
	public String toString() {
		return this.mapping;
	}

	public String first() {
		return isCompound() ? StringUtils.substringBefore(this.mapping, "/") : this.mapping;
	}
	public Mapping rest() {
		return isCompound() ? new Mapping(StringUtils.substringAfter(this.mapping, "/"), this.exceptions) : null;
	}

	public Mapping firstPart() {
		return new Mapping(first(), this.exceptions);
	}

	public String getName() {
		return this.mapping;
	}

	public String getType() {
		String result = null;
		if (this.exceptions != null) {
			// FIXME: TM: Compound!  Handle it!  Amazingly!
			for (Hl7MapByPartType map : this.exceptions.value()) {
				if (StringUtils.equals(this.mapping, map.name())) {
					result = map.type();
					break;
				}
			}
		}
		return result;
	}
}
