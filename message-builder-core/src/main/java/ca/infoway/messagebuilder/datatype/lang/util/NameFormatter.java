package ca.infoway.messagebuilder.datatype.lang.util;

import static ca.infoway.messagebuilder.util.iterator.EmptyIterable.nullSafeIterable;
import static org.apache.commons.lang.StringUtils.trimToEmpty;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PersonNamePartType;

/**
 * <p>An abstract formatter for PersonName. Contains an inner class implementation. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public abstract class NameFormatter {

	/**
	 * <p>A simple name formatter for formatting a PersonName.
	 * 
	 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
	 *
	 */
	static class SimpleNameFormatter extends NameFormatter {

		/**
		 * <p>Formats a PersonName into a string. Format of first name first, followed by all family names, all separated by a space. 
		 * 
		 * @param name the PersonName to format
		 * @return the formatted name
		 */
		@Override
		public String format(PersonName name) {
			StringBuilder builder = new StringBuilder();
			EntityNamePart first = getFirstGivenName(name);
			if (first != null) {
				append(builder, first);
			}
			for (EntityNamePart part : filterParts(name, PersonNamePartType.FAMILY)) {
				append(builder, part);
			}
			return builder.toString();
		}

		private void append(StringBuilder builder, EntityNamePart first) {
			if (builder.length() > 0) {
				builder.append(" ");
			}
			builder.append(trimToEmpty(first.getValue()));
		}
	}

	/**
	 * <p>Formats a PersonName into a string.
	 * 
	 * @param name the PersonName to format
	 * @return the formatted name
	 */
	public abstract String format(PersonName name);
	
	protected EntityNamePart getFirstGivenName(PersonName name) {
		return getFirstPart(name, PersonNamePartType.GIVEN);
	}

	private EntityNamePart getFirstPart(PersonName name, PersonNamePartType type) {
		List<EntityNamePart> parts = filterParts(name, type);
		return CollectionUtils.isEmpty(parts) ? null : parts.get(0);
	}
	
	protected List<EntityNamePart> filterParts(PersonName name, PersonNamePartType type) {
		List<EntityNamePart> result = new ArrayList<EntityNamePart>();
		for (EntityNamePart part : nullSafeIterable(name == null ? null : name.getParts())) {
			if (part.getType() == type) {
				result.add(part);
			}
		}
		return result;
	}
	
	/**
	 * <p>Standard (static) access to SimpleName Formatter.
	 *  
	 * @return a simple name formatter
	 */
	public static NameFormatter getSimpleNameFormatter() {
		return new SimpleNameFormatter();
	}
}
