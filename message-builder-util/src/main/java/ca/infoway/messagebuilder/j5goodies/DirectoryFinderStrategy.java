/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.io.FilenameUtils;

/**
 * @sharpen.ignore j5goodies - Translated manually 
 */ 
class DirectoryFinderStrategy extends DirectoryWalker implements FinderStrategy {

	private ClassPredicate predicate;
	private final String root;
	private File startDirectory;

	public DirectoryFinderStrategy(String root) {
		this.root = root;
	}

	public List<Class<?>> find(ClassPredicate predicate) {
		List<Class<?>> result = new ArrayList<Class<?>>();
		try {
			this.predicate = predicate;
			this.startDirectory = new File(new URI(root));
			walk(this.startDirectory, result);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected boolean handleDirectory(File directory, int depth,
			Collection results) throws IOException {
		if (".svn".equals(directory.getName())) {
			return false;
		} else {
			return super.handleDirectory(directory, depth, results);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void handleFile(File file, int depth, Collection results) throws IOException {
		if (isJavaClass(file)) {
			String className = ClassFileUtil.convertFileNameToClassName(this.startDirectory, file);
			if (isSelected(className)) {
				try {
					Class<?> c = Class.forName(className);
					if (this.predicate.isSelected(c)) {
						results.add(c);
					}
				} catch (NoClassDefFoundError e) {
					// skip it
				} catch (ClassNotFoundException e) {
					// skip it
				}
			}
		}
	}

	private boolean isSelected(String className) {
		return this.predicate.isSelected(getPackageName(className), getShortClassName(className));
	}

	private boolean isJavaClass(File file) {
		return "class".equals(FilenameUtils.getExtension(file.getName()));
	}
}

