package ca.infoway.messagebuilder.marshalling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.util.iterator.EmptyIterable;

class Mapping {

	private final String mapping;
	
	Mapping(String mapping) {
		this.mapping = mapping;
	}

	public boolean isCompound() {
		return this.mapping.contains("/");
	}

	public static List<Mapping> from(Hl7XmlMapping mapping) {
		return mapping == null ? Collections.<Mapping>emptyList() : from(Arrays.asList(mapping.value()));
	}
	public static List<Mapping> from(List<String> mappings) {
		List<Mapping> result = new ArrayList<Mapping>();
		for (String mapping : EmptyIterable.<String>nullSafeIterable(mappings)) {
			result.add(new Mapping(mapping));
		}
		return result;
	}

	@Override
	public String toString() {
		return this.mapping;
	}

	public String first() {
		return isCompound() ? StringUtils.substringBefore(this.mapping, "/") : this.mapping;
	}
	public Mapping rest() {
		return isCompound() ? new Mapping(StringUtils.substringAfter(this.mapping, "/")) : null;
	}
}
