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

package ca.infoway.messagebuilder.platform;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @sharpen.ignore platform
 */
public class SourceCodeLocationUtil {

	public static final String SOURCE_DIRECTORY = new File("./src/main/java").getAbsolutePath();
	
	public static List<File> getAllSourceFiles(String javaPackage) {
		File sourceFolder = new File(SOURCE_DIRECTORY + "/" + javaPackage.replace('.', File.separatorChar));
		return Arrays.asList(FileUtil.getFilesInDirectoryBySuffix(sourceFolder.getAbsolutePath(), ".java"));
	}
	
}
