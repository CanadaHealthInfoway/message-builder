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

package ca.infoway.messagebuilder.j5goodies;

/**
 * <p>An interface used when scanning jars for "interesting" classes.  We 
 * can decide that a class is interesting based on either the class name (which
 * doesn't require that the class be loaded) or attributes of the class itself (such
 * as annotations or things that can be determined by reflection).
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public interface ClassPredicate {
	/**
	 * <p>Determine if the class is interesting, based on package name and class name.
	 * @param packageName - the package name of the class.
	 * @param className - the name of the class.
	 * @return - true if the class is interesting; false otherwise.
	 */
	public boolean isSelected(String packageName, String className);
	/**
	 * <p>Determine if the class is interesting.
	 * @param c - the class.
	 * @return - true if the class is interesting; false otherwise.
	 */
	public boolean isSelected(Class<?> c);
}
