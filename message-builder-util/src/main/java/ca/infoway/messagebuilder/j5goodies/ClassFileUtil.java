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

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

/**
 * <p>A utility to convert a file location (representing a Java source file) into a 
 * class name.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public class ClassFileUtil {

	/**
	 * <p>Convert the file name into its corresponding Java class name.
	 * @param root - the file that represents the source tree
	 * @param file - the file that represents the Java source file.
	 * @return - the name of the Java class
	 */
	public static String convertFileNameToClassName(String root, File file) {
		String rootName = root + File.separator;
		if (file.getAbsolutePath().startsWith(rootName)) {
			String fileName = StringUtils.substringAfter(file.getAbsolutePath(), rootName);
			return FilenameUtils.removeExtension(fileName).replace(File.separatorChar, '.');
		} else {
			throw new IllegalArgumentException(rootName 
					+ " doesn't look like the root of " + file.getAbsolutePath());
		}
	}
	
	public static String convertFileNameToClassName(File root, File file) {
		return convertFileNameToClassName(root.getAbsolutePath(), file);
	}
}
