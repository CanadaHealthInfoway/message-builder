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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.j5goodies;

import static org.apache.commons.lang.StringUtils.substringBefore;

import java.net.URL;
import java.util.List;

/**
 * <p>Find classes on the class path.
 * 
 * <p>One of the sad limitations of Java is that you can't, say, find all classes in a 
 * particular package.  Sometimes some forms of reflection would be easier if you didn't 
 * hafta have a master list of class names that you can consult.  (An example might be
 * the <code>hibernate.cfg.xml</code> file that lists all of your persistent entities).
 * 
 * <p>One strategy for getting around this limitation of Java is to manually scan 
 * an entire target directory or jar file, looking for all of the classes and then using
 * some rules ("predicates") to decide if it's a class that you want.
 * 
 * <p>Finding the jar or directory that contains your classes is a tricky exercise, but
 * this utility attempts to help with that.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public class ClassFinder {

	/**
	 * <p>Find all classes in the same jar as the contextual class.
	 * @param context - the class whose location helps us determine the path to the jar.
	 * @param predicate - a class that determines which classes should be included in the 
	 *                    result
	 * @return - the list of classes found.
	 */
	public List<Class<?>> findClasses(Class<?> context, ClassPredicate predicate) {
		String resourceName = toResourceName(context);
		String urlAsString = getClass().getResource(resourceName).toExternalForm();
		return getFinder(urlAsString, context).find(predicate);
	}	
	
	/**
	 * <p>Find all classes in the same jar as the given manifest.
	 * @param pathToManifest - the resource path to the manifest file
	 * @param predicate - a class that determines which classes should be included in the 
	 *                    result
	 * @return - the list of classes found.
	 */
	public List<Class<?>> findClasses(URL pathToManifest, ClassPredicate predicate) {
		String urlAsString = pathToManifest.toExternalForm();
		return getFinder(urlAsString, "/META-INF/MANIFEST.MF").find(predicate);
	}	
	
	private FinderStrategy getFinder(String root, Class<?> context) {
		if (isJar(root)) {
			return new JarFinderStrategy(extractRoot(root, context));
		} else {
			return new DirectoryFinderStrategy(extractRoot(root, context));
		}
	}
	
	private FinderStrategy getFinder(String root, String context) {
		if (isJar(root)) {
			return new JarFinderStrategy(extractRoot(root, context));
		} else {
			return new DirectoryFinderStrategy(extractRoot(root, context));
		}
	}

    private boolean isJar(String urlAsString) {
		return urlAsString.contains("!");
	}

	static String extractRoot(String path, Class<?> mainClass) {
		return extractRoot(path, mainClass.getName().replace('.', '/'));
    }

	static String extractRoot(String path, String resourceName) {
		if (path.contains("!")) {
            return substringBefore(path,"!");
        } else if (path.contains("/WEB-INF")) {
            return substringBefore(path, "/WEB-INF");
        } else {
			return substringBefore(path, resourceName);
        }
	}
	
    private String toResourceName(Class<?> mainClass) {
        return "/" + mainClass.getName().replace('.', '/') + ".class";
    }
}
