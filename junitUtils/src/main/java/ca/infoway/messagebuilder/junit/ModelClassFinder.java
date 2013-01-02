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

package ca.infoway.messagebuilder.junit;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.lang.ClassUtils;

/**
 * 
 * @sharpen.ignore
 */
public class ModelClassFinder {
    public static final File srcDirectory = new File("./src/main/java");

    public static List<File> getAllModelFiles(Class<?>... modelClasses) {
    	List<File> files = new ArrayList<File>();
    	for (Class<?> c : modelClasses) {
    		String packageName = ClassUtils.getPackageName(c);
			files.addAll(getModelFilesInPackage(packageName));
		}
        return files;
    }

    public static List<File> getAllModelFiles(String... packageNames) {
    	List<File> files = new ArrayList<File>();
    	for (String packageName : packageNames) {
			files.addAll(getModelFilesInPackage(packageName));
		}
        return files;
    }

	private static List<File> getModelFilesInPackage(String packageName) {
		File packageDirectory = new File(srcDirectory, packageName.replace('.', File.separatorChar));
        return Arrays.asList(packageDirectory.listFiles((FilenameFilter) FileFilterUtils.suffixFileFilter(".java")));
	}
	
}
