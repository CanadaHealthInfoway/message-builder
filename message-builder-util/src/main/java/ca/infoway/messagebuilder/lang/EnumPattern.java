/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.lang;

import java.util.List;

/**
 * 
 * A class that implements an Enum Pattern. While Java 1.5 has enums, enums that implement
 * an interface and/or contain behaviour do not have a direct counterpart in .Net. In order
 * to keep the two codebases as consistent as possible our code makes use of this Enum
 * Pattern where applicable.
 * 
 * Code should not call Class.isEnum(), instead they should use EnumPattern.isEnum(Class).
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore platform enum
 */
public class EnumPattern extends Enum {

	private static final long serialVersionUID = -3291561094355852907L;

	protected EnumPattern(String name) {
		super(name);
	}

	/**
	 * <p>Gets the unique string identififying this particular enum.
	 *
	 * @return the unique string identififying this particular enum.
	 */
	public String name() {
		return getName();
	}

	/**
	 * <p>Obtains the enum value of a given string.
	 *
	 * @param <T> the generic type
	 * @param enumClass the enum class
	 * @param name the enum name
	 * @return the enum representing the name value
	 */
	public static <T> T valueOf(Class<T> enumClass, String name){
		Enum enum1 = EnumUtils.getEnum(enumClass, name);
		return enumClass.cast(enum1);
	}

	/**
	 * <p>Returns the enum values for a given enum class.
	 *
	 * @param <T> the generic type
	 * @param enumClass the enum class
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> values(Class<T> enumClass) {
		return EnumUtils.getEnumList(enumClass);
	}

	/**
	 * <p>Gets the enum constants for a given enum (java-based or enum pattern-based).
	 *
	 * @param enumClass the enum class
	 * @return the enum constants
	 */
	public static Object[] getEnumConstants(Class<?> enumClass){
		if (EnumPattern.class.isAssignableFrom(enumClass)) {
			return EnumPattern.values(enumClass).toArray();
		} else {
			return enumClass.getEnumConstants();
		}
	}

	/**
	 * <p>Checks if is an enum (java-based or enum pattern-based).
	 *
	 * @param enumClass the enum class
	 * @return true, if is enum
	 */
	public static boolean isEnum(Class<?> enumClass) {
		return enumClass.isEnum() || EnumPattern.class.isAssignableFrom(enumClass);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return getName();
	}
	
}
