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

import static org.apache.commons.lang.ClassUtils.getPackageName;
import static org.apache.commons.lang.ClassUtils.getShortClassName;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @sharpen.ignore j5goodies - Translated manually
 */
class JarFinderStrategy implements FinderStrategy {

	private static String[] JAR_URL_PREFIXES = {"jar:", "zip:"};
	
	private String jarLocation;

	JarFinderStrategy(String root) {
		String trimmedRoot = StringUtils.trim(root);
		for (int i = 0; i < JAR_URL_PREFIXES.length; i++) {
			if (startsWith(trimmedRoot, JAR_URL_PREFIXES[i])) {
				this.jarLocation = StringUtils.substringAfter(trimmedRoot, JAR_URL_PREFIXES[i]);
			}
		}
		try {
			createUrl();
		} catch (MalformedURLException e) {
			this.jarLocation = "file:///" + this.jarLocation;
		}
	}

	private boolean startsWith(String str, String prefix) {
		return str != null && str.startsWith(prefix);
	}
	
	public List<Class<?>> find(ClassPredicate predicate) {
		List<Class<?>> list = new ArrayList<Class<?>>();
		try {
			JarInputStream input = new JarInputStream(createUrl().openStream());
			try {
				for (JarEntry entry = input.getNextJarEntry(); entry != null; entry = input.getNextJarEntry()) {
					process(entry, predicate, list);
				}
			} finally {
				IOUtils.closeQuietly(input);
			}
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return list;
	}

	protected URL createUrl() throws MalformedURLException {
		return new URL(this.jarLocation);
	}

	private void process(JarEntry entry, ClassPredicate predicate, List<Class<?>> list) {
		String name = entry.getName();
		if (isJavaClass(name)) {
			String className = sanitize(name);
			if (isSelected(className, predicate)) {
				try {
					Class<?> c = Class.forName(className);
					if (predicate.isSelected(c)) {
						list.add(c);
					}
				} catch (NoClassDefFoundError e) {
				} catch (ClassNotFoundException e) {
				}
			}
		}
	}
	private String sanitize(String name) {
		return FilenameUtils.removeExtension(name).replace('/', '.').replace('\\', '.');
	}

	private boolean isJavaClass(String name) {
		return "class".equals(FilenameUtils.getExtension(name));
	}

	private boolean isSelected(String className, ClassPredicate predicate) {
		return predicate.isSelected(getPackageName(className), getShortClassName(className));
	}
}

