/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.datatype.lang;

import static org.apache.commons.lang.StringUtils.trimToEmpty;

import static ca.infoway.messagebuilder.util.iterator.EmptyIterable.nullSafeIterable;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;

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
